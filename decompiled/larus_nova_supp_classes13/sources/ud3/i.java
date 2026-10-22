package ud3;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.jedi.model.fetcher.SimpleFetcher;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends SimpleFetcher<h, CommerceBaseResponse> {
    public i() {
    }

    public final Observable g(Object r4) {
        h r5 = (h) r4;
        Intrinsics.checkNotNullParameter(r5, "request");
        AnchorV3Api.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "request");
        AnchorV3Api r0 = AnchorV3Api.a.a;
        if (r0 == null) goto L7;
        Observable<CommerceBaseResponse> r6 = r0.reportTrackParams(r5.a, r5.b, r5.c);
        if (r6 == null) goto L7;
        return r6;
    L7:
        return Observable.error(new Throwable());
    }
}
