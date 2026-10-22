package com.bytedance.ug.sdk.luckydog.task.tasktimer.executor;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements gm7.b.InterfaceC6037b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalTimerTaskExecutor f272266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f272267b;

    @Override // gm7.b.InterfaceC6037b
    public final void onSuccess() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "retryReportProgress success");
        this.f272266a.f272225b.getAndAdd(1);
        this.f272266a.f272233j.remove(Integer.valueOf(this.f272267b));
    }

    public e(NormalTimerTaskExecutor r100, int r101) {
        this.f272266a = r100;
        this.f272267b = r101;
    }

    @Override // gm7.b.InterfaceC6037b
    public final void onFail(int r100, String r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NormalTimerTaskExecutor", "retryReportProgress fail");
    }
}
