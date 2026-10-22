package pk5;

import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.h;
import na8.p;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gk5.a f529665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f529666b;

    public g(p r100, f r101) {
        this.f529665a = r100;
        this.f529666b = r101;
    }

    @Override // com.ss.android.lark.location.service.h.a
    public final void a(POIInfo r100) {
        if (r100 != null) goto L10;
        gk5.a r101 = this.f529665a;
        BitableJSApiErrorCode r102 = BitableJSApiErrorCode.UNKNOWN;
        r101.onFailure(r102.getCode(), r102.getErrMsg());
        return;
    L10:
        nk5.b.e(this.f529665a, f.c(this.f529666b, r100));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        nk5.b.c(this.f529665a, th);
    }
}
