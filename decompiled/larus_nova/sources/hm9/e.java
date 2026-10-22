package hm9;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements f09.a.b {
    public e() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        s r100 = j.f485966h;
        r100.f485994x = true;
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "onAppBackground, mode=" + r100.f485995y);
        j.f485959a.b();
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        s r100 = j.f485966h;
        r100.f485994x = false;
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "onAppForeground, mode=" + r100.f485995y);
        r100.d(false);
        j.f485959a.b();
    }
}
