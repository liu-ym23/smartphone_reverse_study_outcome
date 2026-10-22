package com.bytedance.android.shopping.deepfeed.data.repo;

import android.net.Uri;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.y0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedBFFRequest$onInterceptorResponse$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Object $resp;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ DeepFeedBFFRequest this$0;

    public DeepFeedBFFRequest$onInterceptorResponse$1(DeepFeedBFFRequest r1, Uri r2, Object r3) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$resp = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m787invoke() {
        DeepFeedBFFRequest r0 = this.this$0;
        Uri r1 = this.$uri;
        Object r2 = this.$resp;
        int r3 = DeepFeedBFFRequest.L;
        r0.getClass();
        String r4 = r1.getPath();
        if (r4 == null) goto L47;
        int r5 = r4.hashCode();
        if (r5 == (-910618324)) goto L26;
        if (r5 == 748761884) goto L11;
        return;
    L11:
        if (r4.equals("/aweme/v2/commerce/bff/deep/feed") == false) goto L44;
        AbsDeepFeedRequest.PendingRequestType r6 = AbsDeepFeedRequest.PendingRequestType.FEED;
        if (r0.r(r6, r1) == true) goto L16;
        return;
    L16:
        if ((r2 instanceof InFeedProductResponse) == true) goto L18;
        r2 = null;
    L18:
        InFeedProductResponse r7 = (InFeedProductResponse) r2;
        if (r7 != null) goto L22;
        return;
    L22:
        if (r0.H(r6, r1) == false) goto L51;
        n r8 = r0.I;
        r0.I = null;
        r0.x(r7, r8);
        return;
    L51:
        return;
    L44:
        return;
    L26:
        if (r4.equals("/aweme/v2/commerce/bff/deep/feed/pack") == false) goto L46;
        AbsDeepFeedRequest.PendingRequestType r9 = AbsDeepFeedRequest.PendingRequestType.PACK;
        if (r0.r(r9, r1) == true) goto L31;
        return;
    L31:
        if ((r2 instanceof y0) == true) goto L33;
        r2 = null;
    L33:
        y0 r10 = (y0) r2;
        if (r10 != null) goto L37;
        return;
    L37:
        if (r0.H(r9, r1) == false) goto L54;
        Function2<? super Boolean, ? super InFeedProductV2, Unit> r11 = r0.H;
        if (r11 == null) goto L55;
        r0.H = null;
        r0.R(r10, r11);
        return;
    L55:
        return;
    L54:
        return;
    L46:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m787invoke();
        return Unit.INSTANCE;
    }
}
