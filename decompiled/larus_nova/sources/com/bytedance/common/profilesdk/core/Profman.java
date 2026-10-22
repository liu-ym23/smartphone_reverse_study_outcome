package com.bytedance.common.profilesdk.core;

import android.os.Build;
import android.os.SystemClock;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.common.profilesdk.util.SoUtils;
import com.bytedance.common.profilesdk.util.VersionUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class Profman {
    static File sBinary = null;
    static boolean sPreloadSo = true;
    List<String> options;
    File redirectOutput;

    public static class Builder {
        List<String> options;
        File redirectOutput;

        public Profman build() {
            Profman r100 = new Profman();
            r100.options = this.options;
            r100.redirectOutput = this.redirectOutput;
            return r100;
        }

        public Builder() {
            this.options = new ArrayList();
        }

        public Builder addOption(String r100) {
            this.options.add(r100);
            return this;
        }
    }

    public Profman() {
    }

    public static boolean isValid() {
        return false;
    }

    public static String messageReturnCode(int r100) {
        if (r100 != 0) goto L4;
        return "Profiles merged successfully.";
    L4:
        if (r100 != 1) goto L6;
        return "There is not enough new information added by the current profiles, skip.";
    L6:
        if (r100 != 2) goto L8;
        return "Bad profiles in merging, do clean-up.";
    L8:
        if (r100 != 3) goto L10;
    L12:
        return "IO error while reading profiles";
    L10:
        if (r100 == 4) goto L12;
        return "Unknown error code";
    }

    public int loadso() {
        Logger.d("profman loadso");
        StringBuilder r100 = new StringBuilder();
        Iterator<String> r101 = this.options.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.append(r101.next());
        r100.append(" ");
        goto L4
    L6:
        r100.trimToSize();
        int r102 = -1;
        long r103 = SystemClock.uptimeMillis();     // Catch: Exception -> L31
        ProcessBuilder r104 = new ProcessBuilder(new String[]{"/system/bin/app_process32"});     // Catch: Exception -> L31
        r104.environment().put("LD_PRELOAD", sBinary.getAbsolutePath());     // Catch: Exception -> L31
        if (VersionUtils.isQ() == false) goto L12;
        r104.environment().put("LD_LIBRARY_PATH", "/apex/com.android.runtime/lib");     // Catch: Exception -> L31
    L12:
        if (VersionUtils.isR() == false) goto L14;
        r104.environment().put("LD_LIBRARY_PATH", "/apex/com.android.art/lib");     // Catch: Exception -> L31
    L14:
        File r105 = this.redirectOutput;     // Catch: Exception -> L31
        if (r105 != null) goto L17;
    L19:
        Process r106 = r104.start();     // Catch: Exception -> L31
        BufferedWriter r107 = new BufferedWriter(new OutputStreamWriter(r106.getOutputStream()));     // Catch: Exception -> L31
        r107.write(r100.toString());     // Catch: Throwable -> L23
        r107.newLine();     // Catch: Throwable -> L23
        r107.flush();     // Catch: Throwable -> L23
        r107.close();     // Catch: Exception -> L31
        r102 = r106.waitFor();     // Catch: Exception -> L31
        Logger.d("profking took " + (SystemClock.uptimeMillis() - r103) + "ms, ret=" + r102 + ", options=" + r100.toString());     // Catch: Exception -> L31
    L33:
        if (r102 != 0) goto L35;
    L37:
        return r102;
    L35:
        if (r102 == 1) goto L37;
        EnsureManager.ensureNotReachHere("profking return " + r102 + ". " + messageReturnCode(r102));
        goto L37
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r107.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Exception -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31
        goto L30
    L17:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        r104.redirectOutput(r105);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        Logger.d(e.toString());
        goto L33
    }

    public static File install() {
        if (VersionUtils.isPQR() == true) goto L5;
        return null;
    L5:
        if (sPreloadSo == false) goto L12;
        File r100 = SoUtils.getAppSo("cvt");
        if (r100.exists() == false) goto L9;
        return r100;
    L9:
        SoUtils.checkAndUnpackSo("cvt", "2");
        return new PolarisFileWrapper(SoUtils.getUnpackedSoPath("cvt"));
    L12:
        return SoUtils.getAppSo("cvt");
    }

    public int run() {
        if (isValid() == true) goto L7;
        return -100;
    L7:
        if (sBinary != null) goto L9;
        sBinary = install();
        Logger.d("install profman, path=" + sBinary);
    L9:
        File r100 = sBinary;
        int r101 = -1;
        if (r100 != null) goto L12;
    L51:
        EnsureManager.ensureNotReachHere("profman not exists");
        return -1;
    L12:
        if (r100.exists() == false) goto L51;
        if (VersionUtils.isPQR() == true) goto L17;
    L20:
        ArrayList r102 = new ArrayList();
        r102.add(sBinary.getAbsolutePath());
        r102.addAll(this.options);
        monitor-enter(Profman.class);
        long r103 = SystemClock.uptimeMillis();     // Catch: Throwable -> L39 Exception -> L41
        ProcessBuilder r104 = new ProcessBuilder(r102);     // Catch: Throwable -> L39 Exception -> L41
        if (VersionUtils.isQ() == false) goto L26;
        r104.environment().put("LD_LIBRARY_PATH", "/apex/com.android.runtime/lib");     // Catch: Throwable -> L39 Exception -> L41
    L26:
        if (VersionUtils.isR() == false) goto L28;
        r104.environment().put("LD_LIBRARY_PATH", "/apex/com.android.art/lib");     // Catch: Throwable -> L39 Exception -> L41
    L28:
        File r105 = this.redirectOutput;     // Catch: Throwable -> L39 Exception -> L41
        if (r105 != null) goto L31;
    L33:
        r101 = r104.start().waitFor();     // Catch: Throwable -> L39 Exception -> L41
        long r106 = SystemClock.uptimeMillis() - r103;     // Catch: Throwable -> L39 Exception -> L41
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L39 Exception -> L41
        Iterator r108 = r102.iterator();     // Catch: Throwable -> L39 Exception -> L41
    L35:
        if (r108.hasNext() == false) goto L37;
        r107.append((String) r108.next());     // Catch: Throwable -> L39 Exception -> L41
        r107.append(" ");     // Catch: Throwable -> L39 Exception -> L41
        goto L35
    L37:
        Logger.d("profman took " + r106 + "ms, ret=" + r101 + ", cmd=" + r107.toString());     // Catch: Throwable -> L39 Exception -> L41
    L43:
        if (r101 != 0) goto L45;
    L47:
        monitor-exit(Profman.class);     // Catch: Throwable -> L39
        return r101;
    L45:
        if (r101 == 1) goto L47;
        EnsureManager.ensureNotReachHere("Profman return " + r101 + ". " + messageReturnCode(r101));     // Catch: Throwable -> L39
        goto L47
    L31:
        if (Build.VERSION.SDK_INT < 26) goto L33;
        r104.redirectOutput(r105);     // Catch: Throwable -> L39 Exception -> L41
    L39:
        th = move-exception;
        throw th;
    L41:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L39
        Logger.d(e.toString());     // Catch: Throwable -> L39
        goto L43
    L17:
        if (sPreloadSo == false) goto L20;
        return loadso();
    }
}
