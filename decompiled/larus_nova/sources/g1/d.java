package g1;

import android.app.ActivityManager;
import android.os.Looper;
import com.apm.lite.k.u;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f479562a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f479563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ActivityManager.ProcessErrorStateInfo f479564c;

    public static JSONObject b() {
        StackTraceElement[] r100 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L4
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
        r101.put("thread_number", 1);     // Catch: Throwable -> L4
        r101.put("mainStackFromTrace", u.d(r100));     // Catch: Throwable -> L4
        return r101;
    L4:
        com.apm.lite.c.a();
        return null;
    }

    public static boolean c(ActivityManager.ProcessErrorStateInfo r100, ActivityManager.ProcessErrorStateInfo r101) {
        if (String.valueOf(r100.condition).equals(String.valueOf(r101.condition)) == true) goto L5;
    L17:
        return false;
    L5:
        if (String.valueOf(r100.processName).equals(String.valueOf(r101.processName)) == false) goto L17;
        if (String.valueOf(r100.pid).equals(String.valueOf(r101.pid)) == false) goto L17;
        if (String.valueOf(r100.uid).equals(String.valueOf(r101.uid)) == false) goto L17;
        if (String.valueOf(r100.tag).equals(String.valueOf(r101.tag)) == false) goto L17;
        if (String.valueOf(r100.shortMsg).equals(String.valueOf(r101.shortMsg)) == false) goto L17;
        if (String.valueOf(r100.longMsg).equals(String.valueOf(r101.longMsg)) == false) goto L17;
        return true;
    }

    public static String a(ActivityManager.ProcessErrorStateInfo r100) {
        if (com.apm.lite.e.f29918j == true) goto L6;
        return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
    L6:
        StringBuilder r101 = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
        r101.append("condition: " + r100.condition + "\n");
        r101.append("processName: " + r100.processName + "\n");
        r101.append("pid: " + r100.pid + "\n");
        r101.append("uid: " + r100.uid + "\n");
        r101.append("tag: " + r100.tag + "\n");
        r101.append("shortMsg : " + r100.shortMsg + "\n");
        r101.append("longMsg : " + r100.longMsg + "\n");
        r101.append("-----------------------end----------------------------");
        return r101.toString();
    }
}
