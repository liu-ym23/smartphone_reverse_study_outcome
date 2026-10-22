package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f485970a;

    public m(y r100) {
        this.f485970a = r100;
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r100, s r101) {
        if (r101 == null) goto L6;
        boolean r102 = true;
        if (r101.f485973c != true) goto L6;
    L8:
        if (r102 == true) goto L10;
        if (r101 == null) goto L19;
        s.b(r101, "BackgroundNetworkInterceptor#SeniorUserHandler", "[SeniorUserHandler]Need continue process , onlyBlockSenior :" + r101.f485973c + ' ');
    L19:
        x r103 = this.f485970a;
        if (r103 != null) goto L26;
    L22:
        return null;
    L26:
        return r103.a(r100, r101);
    L10:
        if (r101.f485972b == false) goto L14;
        s.b(r101, "BackgroundNetworkInterceptor#SeniorUserHandler", "[SeniorUserHandler]Need continue process , onlyBlockSenior :" + r101.f485973c + " current os is senior ");
        x r104 = this.f485970a;
        if (r104 == null) goto L22;
        return r104.a(r100, r101);
    L14:
        s.b(r101, "BackgroundNetworkInterceptor#SeniorUserHandler", "[SeniorUserHandler]No need Block , onlyBlockSenior :" + r101.f485973c + " current os is not senior ");
        r101.c();
        if (r100 == null) goto L22;
        return r100.proceed(r100.request());
    L6:
        r102 = false;
        goto L8
    }
}
