package k5;

import com.bytedance.ai.monitor.AppletMonitorableEvent;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f501792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f501793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f501794c;

    public /* synthetic */ f(String r100, j r101, long r102) {
        this.f501792a = r100;
        this.f501793b = r101;
        this.f501794c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f501792a;
        j r101 = this.f501793b;
        long r102 = this.f501794c;
        AppletMonitorableEvent r103 = new AppletMonitorableEvent(r100, AppletMonitorableEvent.EventOrigin.Native);
        r101.a(r103);
        r103.f37143d = true;
        r103.f37144e = r102;
        com.bytedance.ai.monitor.b.c(r103);
    }
}
