package hm9;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements pda.a {
    public h() {
    }

    @Override // pda.a
    public final void a() {
        s r100 = j.f485966h;
        r100.f485994x = true;
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "onMainProcessBackground, mode=" + r100.f485995y);
        j.f485959a.b();
    }

    @Override // pda.a
    public final void b() {
        s r100 = j.f485966h;
        r100.f485994x = false;
        FLogger.f375446a.i("BackgroundNetworkInterceptor", "onMainProcessForeground, mode=" + r100.f485995y);
        r100.d(false);
        j.f485959a.b();
    }
}
