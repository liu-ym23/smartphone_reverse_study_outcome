package x50;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.crash.Npth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f562499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f562500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Boolean f562501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Boolean f562502d;

    static {
        f562499a = new AtomicBoolean();
    }

    public static void c() {
        Boolean r100 = f562500b;
        if (r100 != null) goto L5;
    L7:
        f562500b = Boolean.FALSE;
        HashMap r101 = new HashMap();
        r101.put("is_live_streaming", "0");
        Npth.addTags(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r100.booleanValue() == true) goto L7;
    }

    public static void b(boolean r100) {
        Boolean r101 = f562502d;
        if (r101 != null) goto L5;
    L7:
        f562502d = Boolean.valueOf(r100);
        HashMap r102 = new HashMap();
        if (r100 == false) goto L10;
        String r103 = "1";
    L11:
        r102.put("is_live_page", r103);
        Npth.addTags(r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        r103 = "0";
        goto L11
    L5:
        if (r101.booleanValue() != r100) goto L7;
    }

    public static void d(boolean r100) {
        Boolean r101 = f562501c;
        if (r101 != null) goto L5;
    L7:
        f562501c = Boolean.valueOf(r100);
        HashMap r102 = new HashMap();
        if (r100 == false) goto L10;
        String r103 = "1";
    L11:
        r102.put("is_live_watching", r103);
        Npth.addTags(r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        r103 = "0";
        goto L11
    L5:
        if (r101.booleanValue() != r100) goto L7;
    }

    public static void a(long r100, List r101, Map r102) {
        JSONObject r103 = new JSONObject();
        r103.put("duration", r100);     // Catch: Exception -> L21
        r103.put("task_exe_thread", "WorkThread");     // Catch: Exception -> L21
        Iterator r104 = ((ArrayList) r101).iterator();     // Catch: Exception -> L21
        String r105 = "";
    L6:
        if (r104.hasNext() == false) goto L14;
        String r106 = (String) r104.next();     // Catch: Exception -> L21
        if (r106 == null) goto L6;
        StringBuilder r107 = new StringBuilder();     // Catch: Exception -> L21
        r107.append(r105);     // Catch: Exception -> L21
        if (r105.length() != 0) goto L12;
        String r108 = "";
    L13:
        r107.append(r108);     // Catch: Exception -> L21
        r107.append(r106);     // Catch: Exception -> L21
        r105 = r107.toString();     // Catch: Exception -> L21
        goto L6
    L12:
        r108 = ", ";
        goto L13
    L14:
        r103.put("exe_tasks", r105);     // Catch: Exception -> L21
        HashMap r109 = (HashMap) r102;     // Catch: Exception -> L21
        Set r110 = r109.keySet();     // Catch: Exception -> L21
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L21
        Iterator r112 = r110.iterator();     // Catch: Exception -> L21
    L16:
        if (r112.hasNext() == false) goto L18;
        String r113 = (String) r112.next();     // Catch: Exception -> L21
        r111.put(r113, r109.get(r113));     // Catch: Exception -> L21
        goto L16
    L18:
        r103.put("task_duration", r111);     // Catch: Exception -> L21
        r103.put("exception_task", "");     // Catch: Exception -> L21
        r103.put("exception_msg", "");     // Catch: Exception -> L21
        r103.put("duration", r100);     // Catch: Exception -> L21
        r103.toString();     // Catch: Exception -> L21
    L19:
        LiveSlardarMonitor.monitorDuration("ttlive_sdk_launch", r100, r103);
    }
}
