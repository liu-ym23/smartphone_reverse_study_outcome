package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv3.guessulike.model.GuessULikeResponseDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionProductDetailResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FirstScreenResponseWatcher implements com.bytedance.android.shopping.anchorv4.data.i {
    public boolean a;
    public boolean b;
    public final String c;
    public final Lifecycle d;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j e;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.repository.FirstScreenResponseWatcher$onGetPack$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.repository.FirstScreenResponseWatcher$onGetPack$1", f = "FirstScreenResponseWatcher.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PackResponseDTO $packDTO;
        int label;
        final /* synthetic */ FirstScreenResponseWatcher this$0;

        public AnonymousClass1(FirstScreenResponseWatcher r1, PackResponseDTO r2, Continuation r3) {
            this.this$0 = r1;
            this.$packDTO = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass1(this.this$0, this.$packDTO, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            y r5 = (y) r4;
            List r2 = null;
            if (this.this$0.b == false) goto L16;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r6 = r5.V();
            if (r6 == null) goto L16;
            float r3 = com.bytedance.android.shopping.anchorv4.perf.monitor.c.j;
            r6.f(null);
        L16:
            FirstScreenResponseWatcher r7 = this.this$0;
            r7.b = false;
            if (r7.a == false) goto L40;
            if (this.$packDTO.getFromCache() == true) goto L40;
            PackParsedDTO r8 = this.$packDTO.getParsedDTO();
            if (r8 == null) goto L23;
            AnchorV4HeadV2VO r9 = r8.getHeaderV2();
        L24:
            if (r9 != null) goto L37;
            PackParsedDTO r10 = this.$packDTO.getParsedDTO();
            if (r10 == null) goto L28;
            r2 = r10.getComponents();
        L28:
            List r11 = r2;
            if (r11 != null) goto L31;
        L34:
            boolean r12 = true;
        L35:
            if (r12 == false) goto L37;
            boolean r13 = true;
        L38:
            int r14 = com.bytedance.android.shopping.base.event.c.a;
            com.bytedance.android.shopping.base.event.c.b(true, this.this$0.c, r13);
            this.this$0.a = false;
            goto L40
        L31:
            if (r11.isEmpty() == true) goto L34;
            r12 = false;
        L37:
            r13 = false;
            goto L38
        L23:
            r9 = null;
        L40:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.bytedance.android.shopping.prepurchase.arch.container.component.j r15 = this.this$0.e;
            this.label = 1;
            r4 = r15.e(y.class, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public final void onGetGULError() {
    }

    public final void onGetPackClientError() {
    }

    public final void onGetDetail(PromotionProductDetailResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "detailDTO");
        Intrinsics.checkNotNullParameter(r2, "detailDTO");
    }

    public final void onGetExtraChunkPack(PackResponseDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "packDTO");
        Intrinsics.checkNotNullParameter(r2, "packDTO");
    }

    public final void onGetFindSameGoods(com.bytedance.android.shopping.anchorv4.dto.business.d r2) {
        Intrinsics.checkNotNullParameter(r2, "sameGoodsDTOI");
        Intrinsics.checkNotNullParameter(r2, "sameGoodsDTOI");
    }

    public final void onGetGUL(GuessULikeResponseDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "gulDTO");
        Intrinsics.checkNotNullParameter(r2, "gulDTO");
    }

    public final void onGetSearchWords(SearchSuggestWordResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "searchDTO");
        Intrinsics.checkNotNullParameter(r2, "searchDTO");
    }

    public final void onGetShopRecommends(PromotionRecommendResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "shopRecDTO");
        Intrinsics.checkNotNullParameter(r2, "shopRecDTO");
    }

    public final void onGetPack(PackResponseDTO r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "packDTO");
        BuildersKt.launch$default(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.f.a(this.d), null, null, new AnonymousClass1(this, r7, null), 3, null);
    }

    public FirstScreenResponseWatcher(String r2, LifecycleRegistry r3, com.bytedance.android.shopping.prepurchase.arch.container.component.j r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        Intrinsics.checkNotNullParameter(r4, "serviceRegistry");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = true;
        this.b = true;
    }
}
