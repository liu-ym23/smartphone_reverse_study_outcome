package com.volcengine.zeus.oat;

import android.os.Build;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqc.i;
import mqc.t;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: loaded from: classes41.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f462722a;

        /* JADX INFO: renamed from: com.volcengine.zeus.oat.c$a$a, reason: collision with other inner class name */
        public class C5553a implements b {
            public C5553a() {
            }

            @Override // com.volcengine.zeus.oat.c.b
            public void delete(File r100) {
                i.e(r100);
            }
        }

        public final void a() {
            ArrayList r100 = this.f462722a;
            C5553a r101 = new C5553a();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isEmpty() == true) goto L28;
            Iterator r102 = r100.iterator();
        L8:
            if (r102.hasNext() == false) goto L29;
            File r103 = (File) r102.next();
            if (r103 == null) goto L8;
        L16:
            th = move-exception;
            ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "Dex2OatArtifactsCleaner deleteTargets failed, target=" + r103, th);
            goto L8
        L13:
            if (r103.exists() == false) goto L8;
            r101.delete(r103);     // Catch: Throwable -> L16
            goto L8
        L29:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ArrayList r100) {
            this.f462722a = r100;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface b {
        void delete(File r100);
    }

    /* JADX INFO: renamed from: com.volcengine.zeus.oat.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static final class C5554c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f462723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f462724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<File> f462725c;

        public C5554c(int r100, int r101, List<File> r102) {
            this.f462723a = r100;
            this.f462724b = r101;
            this.f462725c = r102;
        }
    }

    public static void c() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 33) goto L6;
        return;
    L6:
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L8;
        return;
    L8:
        t r101 = t.c();
        boolean r102 = true;
        int r110 = 0;
        if (r101.f("ZEUS_ROM_UPGRADE_DEX2OAT") == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L42;
        long r111 = System.currentTimeMillis();
        C5554c r104 = new C5554c(0, 0, new ArrayList(0));
        dqc.c.k();     // Catch: Throwable -> L24
        PolarisFileWrapper r112 = new PolarisFileWrapper(dqc.c.f469730a.getPath());     // Catch: Throwable -> L24
        if (r100 >= 26) goto L20;
        r102 = false;
    L20:
        r104 = b(r112, r102, System.currentTimeMillis());     // Catch: Throwable -> L24
        StringBuilder r105 = new StringBuilder("Dex2OatArtifactsCleaner tryCleanOnRomUpgrade success scanned=");
        r105.append(r104.f462723a);
        r105.append(" renamed=");
        r105.append(r104.f462724b);
        r105.append(" deleteTargets=");
        List<File> r106 = r104.f462725c;
        if (r106 == null) goto L30;
    L29:
        r110 = r106.size();
    L30:
        r105.append(r110);
        r105.append(" costMs=");
        r105.append(System.currentTimeMillis() - r111);
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, r105.toString());
        List<File> r107 = r104.f462725c;
        if (r107 == null) goto L42;
        if (r107.isEmpty() == true) goto L42;
        dqc.e.b(new a(new ArrayList(r104.f462725c)));
    L24:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "Dex2OatArtifactsCleaner tryCleanOnRomUpgrade failed", th);     // Catch: Throwable -> L35
        r105 = new StringBuilder("Dex2OatArtifactsCleaner tryCleanOnRomUpgrade success scanned=");
        r105.append(r104.f462723a);
        r105.append(" renamed=");
        r105.append(r104.f462724b);
        r105.append(" deleteTargets=");
        r106 = r104.f462725c;
        if (r106 != null) goto L29;
    L35:
        th = move-exception;
        StringBuilder r108 = new StringBuilder("Dex2OatArtifactsCleaner tryCleanOnRomUpgrade success scanned=");
        r108.append(r104.f462723a);
        r108.append(" renamed=");
        r108.append(r104.f462724b);
        r108.append(" deleteTargets=");
        List<File> r109 = r104.f462725c;
        if (r109 == null) goto L40;
        r110 = r109.size();
    L40:
        r108.append(r110);
        r108.append(" costMs=");
        r108.append(System.currentTimeMillis() - r111);
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, r108.toString());
        throw th;
    L42:
        r101.n("ZEUS_ROM_UPGRADE_DEX2OAT");
        return;
    L11:
        if (r101.i("ZEUS_ROM_UPGRADE_DEX2OAT") == false) goto L13;
        r103 = true;
        goto L14
    }

    public static PolarisFileWrapper a(PolarisFileWrapper r100, long r101, int r102) {
        if (r100.exists() == false) goto L18;
        File r103 = r100.getParentFile();
        if (r103 != null) goto L8;
        return null;
    L8:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, "." + r100.getName() + "_deleted_" + r101 + "_" + r102);
    L16:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "Dex2OatArtifactsCleaner renameAsTombstone failed, dir=" + r100, th);
        goto L18
    L10:
        if (r104.exists() == false) goto L12;
        return null;
    L12:
        if (r100.renameTo(r104) == true) goto L15;
        return null;
    L15:
        return r104;
    L18:
        return null;
    }

    public static C5554c b(PolarisFileWrapper r110, boolean r111, long r112) {
        if (r110.isDirectory() == false) goto L5;
        ArrayList r100 = new ArrayList();
        File[] r101 = r110.listFiles();
        if (r101 == null) goto L9;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L11:
        if (r103 >= r102) goto L60;
        File r106 = r101[r103];
        if (r106 == null) goto L58;
        if (r106.isDirectory() == false) goto L58;
        File[] r107 = r106.listFiles();
        if (r107 == null) goto L58;
        int r113 = r107.length;
        int r114 = 0;
    L21:
        if (r114 >= r113) goto L58;
        File r115 = r107[r114];
        if (r115 != null) goto L25;
    L56:
        File[] r116 = r101;
        int r117 = r102;
    L57:
        r114 = r114 + 1;
        r101 = r116;
        r102 = r117;
        goto L21
    L25:
        if (r115.isDirectory() == false) goto L56;
        String r118 = r115.getName();
        if (r118 == null) goto L56;
        if (r118.length() == 0) goto L56;
        if (r118.startsWith(PluginDirHelper.VERSION_PREFIX) == false) goto L34;
    L36:
        r104 = r104 + 1;
        if (r111 == false) goto L50;
        PolarisFileWrapper r119 = new PolarisFileWrapper(new PolarisFileWrapper(r115, "apk"), "oat");
        r116 = r101;
        r117 = r102;
        PolarisFileWrapper r120 = new PolarisFileWrapper(new PolarisFileWrapper(new PolarisFileWrapper(r115, "apk"), "temp"), "oat");
        if (r119.exists() == false) goto L45;
        int r108 = r105 + 1;
        PolarisFileWrapper r109 = a(r119, r112, r108);
        if (r109 == null) goto L43;
        r100.add(r109);
        r105 = r108;
        goto L45
    L43:
        r100.add(r119);
    L45:
        if (r120.exists() == false) goto L57;
        int r121 = r105 + 1;
        PolarisFileWrapper r122 = a(r120, r112, r121);
        if (r122 == null) goto L49;
        r100.add(r122);
        r105 = r121;
        goto L57
    L49:
        r100.add(r120);
        goto L57
    L50:
        r116 = r101;
        r117 = r102;
        PolarisFileWrapper r123 = new PolarisFileWrapper(r115, "dalvik-cache");
        if (r123.exists() == false) goto L57;
        int r124 = r105 + 1;
        PolarisFileWrapper r125 = a(r123, r112, r124);
        if (r125 == null) goto L55;
        r100.add(r125);
        r105 = r124;
        goto L57
    L55:
        r100.add(r123);
        goto L57
    L34:
        if (r118.startsWith("preversion-") == true) goto L36;
    L58:
        r103 = r103 + 1;
        r101 = r101;
        r102 = r102;
        goto L11
    L60:
        return new C5554c(r104, r105, r100);
    L9:
        return new C5554c(0, 0, r100);
    L5:
        return new C5554c(0, 0, new ArrayList(0));
    }
}
