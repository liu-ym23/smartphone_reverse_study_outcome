package gm7;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements b.InterfaceC6037b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.InterfaceC6037b f481734a;

    @Override // gm7.b.InterfaceC6037b
    public final void onSuccess() {
        b.InterfaceC6037b r100 = this.f481734a;
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    public g(b.InterfaceC6037b r100) {
        this.f481734a = r100;
    }

    @Override // gm7.b.InterfaceC6037b
    public final void onFail(int r100, String r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "reportTimerTask onFail errCode = " + r100);
        b.InterfaceC6037b r102 = this.f481734a;
        if (r102 == null) goto L6;
        r102.onFail(r100, r101);
        return;
    }
}
