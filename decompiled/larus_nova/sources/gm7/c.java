package gm7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481693a = 0;

    static {
    }

    public static void a(tk7.a r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L4
        r102.put("status", r101);     // Catch: Throwable -> L4
        c("luckydog_countdown_complete_jump", r102, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckyTimerTaskEvent", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("luckyDogCountdownPendantShowSuccessEvent", th.getLocalizedMessage()), th);
    }

    public static void b(tk7.a r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L4
        r102.put("reason", r101);     // Catch: Throwable -> L4
        c("luckydog_countdown_pendant_show_failed", r102, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckyTimerTaskEvent", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("luckyDogCountdownPendantShowFailedEvent", th.getLocalizedMessage()), th);
    }

    public static void c(String r100, JSONObject r101, tk7.a r102) {
        if (r101 != null) goto L6;
        r101 = new JSONObject();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckyTimerTaskEvent", com.bytedance.ug.sdk.luckydog.api.task.taskmanager.d.a("reportEvent", th.getLocalizedMessage()), th);
        return;
    L6:
        String r103 = "";
        if (r102 == null) goto L11;
        String r104 = r102.f546539a;     // Catch: Throwable -> L25
        if (r104 == null) goto L11;
    L12:
        r101.put("global_task_id", r104);     // Catch: Throwable -> L25
        if (r102 == null) goto L17;
        String r105 = r102.f546541c;     // Catch: Throwable -> L25
        if (r105 == null) goto L17;
    L18:
        r101.put("task_id", r105);     // Catch: Throwable -> L25
        if (r102 == null) goto L23;
        String r106 = r102.f546544f;     // Catch: Throwable -> L25
        if (r106 == null) goto L23;
        r103 = r106;
    L23:
        r101.put("activity_id", r103);     // Catch: Throwable -> L25
        com.bytedance.ug.sdk.luckydog.api.log.b.a(r100, r101);     // Catch: Throwable -> L25
        return;
    L17:
        r105 = "";
    L11:
        r104 = "";
        goto L12
    }
}
