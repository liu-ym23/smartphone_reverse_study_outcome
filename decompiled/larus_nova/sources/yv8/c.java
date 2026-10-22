package yv8;

import android.app.Application;
import android.content.Intent;
import android.os.Process;
import com.larus.common.apphost.AppHost;
import com.larus.network.m;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569311a = 0;

    static {
    }

    public static String a() {
        Application r100 = AppHost.f326268a.getApplication();
        Intent r101 = r100.getPackageManager().getLaunchIntentForPackage(r100.getPackageName());
        if (r101 != null) goto L6;
        return "SetTestEnv failed for null launchIntent";
    L6:
        r101.addFlags(67108864);
        r100.startActivity(r101);
        Process.killProcess(Process.myPid());
        System.exit(0);
        return "";
    }

    @JvmStatic
    public static final String b() {
        Lazy r100 = m.f360210a;
        m.c("", "");
        Thread.sleep(10);     // Catch: InterruptedException -> L12
        String r101 = a();
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return r101;
    L10:
        return "SetTestEnv success with online environment.";
    L7:
        r102 = false;
    L12:
        e = move-exception;
        return "SetTestEnv failed for exception occurred with message " + e.getMessage();
    }
}
