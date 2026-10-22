package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1$initView$5$logSearchWordShow$1", f = "TopNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopNavigationComponentV1$initView$5$logSearchWordShow$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.w, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommonMeta $commonMeta;
    final /* synthetic */ com.bytedance.android.shopping.anchorv3.i $searchInfo;
    final /* synthetic */ com.bytedance.android.shopping.anchorv3.widget.f $searchParams;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopNavigationComponentV1$initView$5 this$0;

    public TopNavigationComponentV1$initView$5$logSearchWordShow$1(TopNavigationComponentV1$initView$5 r1, com.bytedance.android.shopping.anchorv3.i r2, com.bytedance.android.shopping.anchorv3.widget.f r3, CommonMeta r4, Continuation r5) {
        this.this$0 = r1;
        this.$searchInfo = r2;
        this.$searchParams = r3;
        this.$commonMeta = r4;
        super(3, r5);
    }

    public final Continuation<Unit> create(CoroutineScope r7, vg3.w r8, Continuation<? super Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "$this$create");
        Intrinsics.checkNotNullParameter(r8, "it");
        Intrinsics.checkNotNullParameter(r9, "continuation");
        TopNavigationComponentV1$initView$5$logSearchWordShow$1 r10 = new TopNavigationComponentV1$initView$5$logSearchWordShow$1(this.this$0, this.$searchInfo, this.$searchParams, this.$commonMeta, r9);
        r10.L$0 = r8;
        return r10;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r8);
        ProductDetailEventService.b r9 = ((vg3.w) this.L$0).m();
        String r3 = null;
        if ((!Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.this$0.a.O1())).b.d.a(), Boxing.boxBoolean(false))) == true) goto L8;
        r9 = null;
    L8:
        if (r9 == null) goto L20;
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to("words_source", "search_bar_outer");
        r0[1] = TuplesKt.to("words_content", this.$searchInfo.a);
        r0[2] = TuplesKt.to("impr_id", this.$searchInfo.c);
        r0[3] = TuplesKt.to(SimilarProductParam.ENTER_FROM, this.$searchParams.e);
        r0[4] = TuplesKt.to("enter_from_second", this.$searchParams.h);
        r0[5] = TuplesKt.to("group_id", this.$searchInfo.b);
        CommonMeta r1 = this.$commonMeta;
        if (r1 == null) goto L12;
        String r2 = r1.getProductId();
    L13:
        r0[6] = TuplesKt.to("from_gid", r2);
        CommonMeta r4 = this.$commonMeta;
        if (r4 == null) goto L16;
        r3 = r4.getProductId();
    L16:
        r0[7] = TuplesKt.to("enter_group_id", r3);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r5 = r9.d(MapsKt.mapOf(r0));
        if (r5 == null) goto L20;
        Boxing.boxBoolean(com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r5, "trending_words_show", false, null, null, 12));
        goto L20
    L12:
        r2 = null;
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
