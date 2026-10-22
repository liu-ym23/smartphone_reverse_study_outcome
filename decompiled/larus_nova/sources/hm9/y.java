package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.network.util.ScreenStateManager;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f485999a;

    public y(x r100) {
        this.f485999a = r100;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (r101 == null) goto L5;
        ScreenStateManager.ScreenState r102 = r101.f485971a;
    L7:
        if (r102 == ScreenStateManager.ScreenState.SCREEN_ON) goto L9;
    L13:
        if (r101 == null) goto L15;
        s.b(r101, "BackgroundNetworkInterceptor#ScreenOnHandler", "[ScreenOnHandler]Need continue process , appScreenState :" + r101.f485971a);
    L15:
        x r103 = this.f485999a;
        if (r103 != null) goto L18;
        return null;
    L18:
        return r103.a(r100, r101);
    L9:
        if (r101.f485995y == 2) goto L13;
        s.b(r101, "BackgroundNetworkInterceptor#ScreenOnHandler", "[ScreenOnHandler]NO need continue process current is screen on , appScreenState :" + r101.f485971a);
        r101.c();
        if (r100 != null) goto L20;
        return null;
    L20:
        return r100.proceed(r100.request());
    L5:
        r102 = null;
        goto L7
    }
}
