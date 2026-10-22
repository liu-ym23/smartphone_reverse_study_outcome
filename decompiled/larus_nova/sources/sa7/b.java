package sa7;

import ara.t;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends ua7.a<ua7.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ua7.a f541181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f541182b;

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        ua7.f r101 = (ua7.f) r100;
        this.f541181a.onResponse(r101);
        com.bytedance.sdk.account.impl.j r102 = com.bytedance.sdk.account.impl.j.m(this.f541182b.f541192a);
        if (r102.isLogin() == true) goto L6;
        r102.a(false);
        ta7.b r103 = new ta7.b(3);
        HashMap r104 = new HashMap();
        r103.f545199e = r104;
        r104.put("logout_type", r101.f549267s);
        r102.e(r103);
        return;
    }

    public b(f r100, t r101) {
        this.f541182b = r100;
        this.f541181a = r101;
    }
}
