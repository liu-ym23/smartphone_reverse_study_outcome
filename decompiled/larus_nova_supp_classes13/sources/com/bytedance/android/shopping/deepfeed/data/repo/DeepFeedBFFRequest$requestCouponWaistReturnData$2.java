package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.u;
import he3.y0;
import he3.z;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"tryDispatch", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedBFFRequest$requestCouponWaistReturnData$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef $feedResp;
    final /* synthetic */ DeepFeedBFFRequest$requestCouponWaistReturnData$1 $finish$1;
    final /* synthetic */ Ref.ObjectRef $packResp;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ DeepFeedBFFRequest this$0;

    public DeepFeedBFFRequest$requestCouponWaistReturnData$2(DeepFeedBFFRequest r1, Ref.ObjectRef r2, Ref.ObjectRef r3, DeepFeedBFFRequest$requestCouponWaistReturnData$1 r4, String r5) {
        this.this$0 = r1;
        this.$packResp = r2;
        this.$feedResp = r3;
        this.$finish$1 = r4;
        this.$sessionId = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m788invoke() {
        y0 r0 = (y0) this.$packResp.element;
        if (r0 != null) goto L5;
        return;
    L5:
        InFeedProductResponse r1 = (InFeedProductResponse) this.$feedResp.element;
        if (r1 != null) goto L8;
        return;
    L8:
        DeepFeedBFFRequest r2 = this.this$0;
        int r3 = DeepFeedBFFRequest.L;
        r2.getClass();
        u r4 = r0.a();
        if (r4 == null) goto L12;
        z r5 = r4.c();
        if (r5 == null) goto L12;
    L13:
        r2.G = r5;
        DeepFeedBFFRequest.K(r0);
        List r6 = AbsDeepFeedRequest.j(r0);
        Map<String, ? extends Object> r7 = null;
        if (r6 == null) goto L23;
        InFeedProductV2 r8 = (InFeedProductV2) CollectionsKt.firstOrNull(r6);
        if (r8 == null) goto L23;
        DeepFeedBFFRequest.M((InFeedProductV2) CollectionsKt.firstOrNull(r2.K), r8);
        u r9 = r0.a();
        if (r9 == null) goto L21;
        Map<String, ? extends Object> r10 = r9.b();
    L22:
        r2.Q(r10, CollectionsKt.listOf(r8));
        r2.U(r0);
    L24:
        if (r8 != null) goto L27;
        this.$finish$1.invoke(null);
        return;
    L27:
        DeepFeedBFFRequest$requestCouponWaistReturnData$1 r11 = this.$finish$1;
        String r12 = this.$sessionId;
        DeepFeedBFFRequest r13 = this.this$0;
        r13.getClass();
        DeepFeedBFFRequest.P(r1);
        List<InFeedProductV2> r14 = AbsDeepFeedRequest.i(r1);
        if (r14 != null) goto L30;
        r14 = CollectionsKt.emptyList();
    L30:
        u r15 = r1.getBffData();
        if (r15 == null) goto L33;
        r7 = r15.b();
    L33:
        r13.Q(r7, r14);
        r11.invoke(new i(r12, r8, CollectionsKt.take(r14, 4)));
        return;
    L21:
        r10 = null;
    L23:
        r8 = null;
    L12:
        r5 = r2.G;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m788invoke();
        return Unit.INSTANCE;
    }
}
