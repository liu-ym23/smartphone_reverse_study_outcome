package xb3;

import com.bytedance.android.ec.model.response.r0;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.anchorv3.comment.api.PromotionCommentApi;
import com.bytedance.jedi.model.fetcher.AbstractFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends AbstractFetcher<zb3.b, r0, zb3.b, r0> {
    public a() {
    }

    public final Object d(Object r2) {
        zb3.b r3 = (zb3.b) r2;
        Intrinsics.checkNotNullParameter(r3, "req");
        return r3;
    }

    public final Observable g(Object r6) {
        zb3.b r7 = (zb3.b) r6;
        Intrinsics.checkNotNullParameter(r7, "req");
        PromotionCommentApi r0 = (PromotionCommentApi) n.a.create("https://aweme.snssdk.com", PromotionCommentApi.class);
        if (r0 == null) goto L9;
        Observable r8 = r0.syncCommentAction(r7.a, r7.b);
        if (r8 == null) goto L9;
        Observable r9 = r8.subscribeOn(Schedulers.io());
        if (r9 == null) goto L9;
        return r9;
    L9:
        return Observable.error(new Exception("PromotionCommentApi.INSTANCE is null"));
    }

    public final Object e(Object r2, Object r3) {
        r0 r4 = (r0) r3;
        Intrinsics.checkNotNullParameter((zb3.b) r2, "req");
        Intrinsics.checkNotNullParameter(r4, "resp");
        return r4;
    }
}
