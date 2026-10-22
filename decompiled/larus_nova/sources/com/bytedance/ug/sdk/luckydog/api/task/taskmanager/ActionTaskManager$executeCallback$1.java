package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ActionTaskManager$executeCallback$1 implements gk7.e {
    public ActionTaskManager$executeCallback$1() {
    }

    @Override // gk7.e
    public final synchronized void a(tk7.a r100) {
        monitor-enter(this);
        String r101 = r100.f546540b;     // Catch: Throwable -> L21
        String r102 = r100.f546539a;     // Catch: Throwable -> L21
        ActionTaskManager r103 = ActionTaskManager.f271681l;     // Catch: Throwable -> L21
        if (ActionTaskManager.l(r103, new Object[]{r101, r102}) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(ActionTaskManager.f271671b, "taskType = " + r101 + ", globalTaskId = " + r102 + " 的任务触发【完成】回调");     // Catch: Throwable -> L21
        r103.o(r102);     // Catch: Throwable -> L21
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.e.a("task_manager_task_create_time_is_null", new JSONObject(), null);     // Catch: Throwable -> L21
        com.bytedance.ug.sdk.luckydog.api.log.d.c(ActionTaskManager.f271671b, d.a("onComplete", th.getLocalizedMessage()), th);     // Catch: Throwable -> L21
    L18:
        ActionTaskManager r105 = ActionTaskManager.f271681l;     // Catch: Throwable -> L21
        r105.getClass();     // Catch: Throwable -> L21
        ActionTaskManager.C("luckydog_task_manager_complete", r100, r104);     // Catch: Throwable -> L21
        r105.B(r102);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L10:
        if (r100.f546548j == null) goto L18;
        long r106 = r103.z();     // Catch: Throwable -> L16
        Long r107 = r100.f546548j;     // Catch: Throwable -> L16
        if (r107 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L14:
        r104.put("task_duration", (r106 - r107.longValue()) / ((long) 1000));     // Catch: Throwable -> L16
    L21:
        th = move-exception;
        throw th;
    }

    @Override // gk7.e
    public final synchronized void c(tk7.a r100, String r101) {
        monitor-enter(this);
        String r102 = r100.f546540b;     // Catch: Throwable -> L19
        String r103 = r100.f546539a;     // Catch: Throwable -> L19
        if (ActionTaskManager.l(ActionTaskManager.f271681l, new Object[]{r102, r103}) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(ActionTaskManager.f271671b, "taskType = " + r102 + ", globalTaskId = " + r103 + " 的任务触发【失败】回调");     // Catch: Throwable -> L19
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L19
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        Object r106 = Result.m9449constructorimpl(r104.put("reason", r101));     // Catch: Throwable -> L11
    L13:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L19
        if (r107 == null) goto L16;
        com.bytedance.ug.sdk.luckydog.api.log.d.c(ActionTaskManager.f271671b, d.a("onFailure", r107.getLocalizedMessage()), r107);     // Catch: Throwable -> L19
    L16:
        ActionTaskManager r108 = ActionTaskManager.f271681l;     // Catch: Throwable -> L19
        r108.getClass();     // Catch: Throwable -> L19
        ActionTaskManager.C("luckydog_task_manager_failure", r100, r104);     // Catch: Throwable -> L19
        r108.o(r103);     // Catch: Throwable -> L19
        r108.B(r103);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // gk7.e
    public final synchronized void b(final tk7.a r100, boolean r101, final String r102, boolean r110) {
        monitor-enter(this);
        String r103 = r100.f546540b;     // Catch: Throwable -> L11
        final String r104 = r100.f546539a;     // Catch: Throwable -> L11
        if (ActionTaskManager.l(ActionTaskManager.f271681l, new Object[]{r103, r104}) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(ActionTaskManager.f271671b, "taskType = " + r103 + ", globalTaskId = " + r104 + " 的任务触发【开启结果】回调, 开启成功 = " + r101 + ", 失败原因 = " + r102 + ", 是否清存储: " + r110);     // Catch: Throwable -> L11
        d.c(r101, new ActionTaskManager$executeCallback$1$onOpenResult$1(r100));     // Catch: Throwable -> L11
        d.b(r101, new ActionTaskManager$executeCallback$1$onOpenResult$2(r104, r102, r100));     // Catch: Throwable -> L11
        d.c(r110, new ActionTaskManager$executeCallback$1$onOpenResult$3(r104));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
