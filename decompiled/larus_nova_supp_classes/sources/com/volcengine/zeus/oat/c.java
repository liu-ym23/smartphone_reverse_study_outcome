package com.volcengine.zeus.oat;

import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqc.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static void c() {
        int r5 = Build.VERSION.SDK_INT;
        if (r5 >= 33) goto L6;
        return;
    L6:
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L8;
        return;
    L8:
        t r6 = t.c();
        boolean r9 = true;
        int r10 = 0;
        if (r6.f("ZEUS_ROM_UPGRADE_DEX2OAT") == true) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L42;
        long r11 = System.currentTimeMillis();
        c r12 = new c(0, 0, new ArrayList(0));
        dqc.c.k();     // Catch: Throwable -> L24
        PolarisFileWrapper r13 = new PolarisFileWrapper(dqc.c.a.getPath());     // Catch: Throwable -> L24
        if (r5 >= 26) goto L20;
        r9 = false;
    L20:
        r12 = b(r13, r9, System.currentTimeMillis());     // Catch: Throwable -> L24
        StringBuilder r7 = new StringBuilder("Dex2OatArtifactsCleaner tryCleanOnRomUpgrade success scanned=");
        r7.append(r12.a);
        r7.append(" renamed=");
        r7.append(r12.b);
        r7.append(" deleteTargets=");
        List r1 = r12.c;
        if (r1 == null) goto L30;
    L29:
        r10 = r1.size();
    L30:
        r7.append(r10);
        r7.append(" costMs=");
        r7.append(System.currentTimeMillis() - r11);
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, r7.toString());
        List r0 = r12.c;
        if (r0 == null) goto L42;
        if (r0.isEmpty() == true) goto L42;
        e.b(new a(new ArrayList(r12.c)));
    L24:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "Dex2OatArtifactsCleaner tryCleanOnRomUpgrade failed", th);     // Catch: Throwable -> L35
        r7 = new StringBuilder("Dex2OatArtifactsCleaner tryCleanOnRomUpgrade success scanned=");
        r7.append(r12.a);
        r7.append(" renamed=");
        r7.append(r12.b);
        r7.append(" deleteTargets=");
        r1 = r12.c;
        if (r1 != null) goto L29;
    L35:
        th = move-exception;
        StringBuilder r14 = new StringBuilder("Dex2OatArtifactsCleaner tryCleanOnRomUpgrade success scanned=");
        r14.append(r12.a);
        r14.append(" renamed=");
        r14.append(r12.b);
        r14.append(" deleteTargets=");
        List r2 = r12.c;
        if (r2 == null) goto L40;
        r10 = r2.size();
    L40:
        r14.append(r10);
        r14.append(" costMs=");
        r14.append(System.currentTimeMillis() - r11);
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, r14.toString());
        throw th;
    L42:
        r6.n("ZEUS_ROM_UPGRADE_DEX2OAT");
        return;
    L11:
        if (r6.i("ZEUS_ROM_UPGRADE_DEX2OAT") == false) goto L13;
        r8 = true;
        goto L14
    }

    public static PolarisFileWrapper a(PolarisFileWrapper r4, long r5, int r7) {
        if (r4.exists() == false) goto L18;
        File r0 = r4.getParentFile();
        if (r0 != null) goto L8;
        return null;
    L8:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r0, "." + r4.getName() + "_deleted_" + r5 + "_" + r7);
    L16:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "Dex2OatArtifactsCleaner renameAsTombstone failed, dir=" + r4, th);
        goto L18
    L10:
        if (r6.exists() == false) goto L12;
        return null;
    L12:
        if (r4.renameTo(r6) == true) goto L15;
        return null;
    L15:
        return r6;
    L18:
        return null;
    }

    public static c b(PolarisFileWrapper r17, boolean r18, long r19) {
        if (r17.isDirectory() == false) goto L5;
        ArrayList r2 = new ArrayList();
        File[] r4 = r17.listFiles();
        if (r4 == null) goto L9;
        int r5 = r4.length;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L11:
        if (r6 >= r5) goto L60;
        File r9 = r4[r6];
        if (r9 == null) goto L58;
        if (r9.isDirectory() == false) goto L58;
        File[] r10 = r9.listFiles();
        if (r10 == null) goto L58;
        int r11 = r10.length;
        int r12 = 0;
    L21:
        if (r12 >= r11) goto L58;
        File r13 = r10[r12];
        if (r13 != null) goto L25;
    L56:
        File[] r110 = r4;
        int r16 = r5;
    L57:
        r12 = r12 + 1;
        r4 = r110;
        r5 = r16;
        goto L21
    L25:
        if (r13.isDirectory() == false) goto L56;
        String r14 = r13.getName();
        if (r14 == null) goto L56;
        if (r14.length() == 0) goto L56;
        if (r14.startsWith("version-") == false) goto L34;
    L36:
        r7 = r7 + 1;
        if (r18 == false) goto L50;
        PolarisFileWrapper r15 = new PolarisFileWrapper(new PolarisFileWrapper(r13, "apk"), "oat");
        r110 = r4;
        r16 = r5;
        PolarisFileWrapper r111 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(r13, "apk"), "temp"), "oat");
        if (r15.exists() == false) goto L45;
        int r3 = r8 + 1;
        PolarisFileWrapper r20 = a(r15, r19, r3);
        if (r20 == null) goto L43;
        r2.add(r20);
        r8 = r3;
        goto L45
    L43:
        r2.add(r15);
    L45:
        if (r111.exists() == false) goto L57;
        int r21 = r8 + 1;
        PolarisFileWrapper r22 = a(r111, r19, r21);
        if (r22 == null) goto L49;
        r2.add(r22);
        r8 = r21;
        goto L57
    L49:
        r2.add(r111);
        goto L57
    L50:
        r110 = r4;
        r16 = r5;
        PolarisFileWrapper r23 = new PolarisFileWrapper(r13, "dalvik-cache");
        if (r23.exists() == false) goto L57;
        int r24 = r8 + 1;
        PolarisFileWrapper r25 = a(r23, r19, r24);
        if (r25 == null) goto L55;
        r2.add(r25);
        r8 = r24;
        goto L57
    L55:
        r2.add(r23);
        goto L57
    L34:
        if (r14.startsWith("preversion-") == true) goto L36;
    L58:
        r6 = r6 + 1;
        r4 = r4;
        r5 = r5;
        goto L11
    L60:
        return new c(r7, r8, r2);
    L9:
        return new c(0, 0, r2);
    L5:
        return new c(0, 0, new ArrayList(0));
    }
}
