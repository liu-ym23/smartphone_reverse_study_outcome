package pk5;

import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.h;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements h.a {
    public final /* synthetic */ gk5.a a;
    public final /* synthetic */ f b;

    public g(p r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(POIInfo r3) {
        if (r3 != null) goto L10;
        gk5.a r4 = this.a;
        BitableJSApiErrorCode r0 = BitableJSApiErrorCode.UNKNOWN;
        r4.onFailure(r0.getCode(), r0.getErrMsg());
        return;
    L10:
        nk5.b.e(this.a, f.c(this.b, r3));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        nk5.b.c(this.a, th);
    }
}
