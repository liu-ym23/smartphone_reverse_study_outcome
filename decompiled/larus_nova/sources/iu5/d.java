package iu5;

import android.os.Process;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static void c(Exception r100) {
        a("ReportCrashUtils_DbCrash", r100);
    }

    public static void a(String r100, Throwable r101) {
        tt5.a.f("ReportCrashUtils_" + r100, r101, true);
    }

    public static void b(String r100, Throwable r101) {
        tt5.a.f("ReportCrashUtils_".concat(r100), r101, true);
        if ((r101 instanceof NoClassDefFoundError) == false) goto L6;
        tt5.a.d(r100, "kill self");
        Process.killProcess(Process.myPid());
        return;
    }
}
