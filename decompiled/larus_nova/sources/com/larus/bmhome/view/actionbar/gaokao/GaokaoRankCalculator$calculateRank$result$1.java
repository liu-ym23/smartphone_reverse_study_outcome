package com.larus.bmhome.view.actionbar.gaokao;

import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoApi;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceZhiyuanResponse;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoZhiyuanRequest;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceZhiyuanResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator$calculateRank$result$1", f = "GaokaoRankCalculator.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class GaokaoRankCalculator$calculateRank$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends GaokaoProvinceZhiyuanResponse>>, Object> {
    final /* synthetic */ String $province;
    final /* synthetic */ String $score;
    final /* synthetic */ String $subject;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator$calculateRank$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceZhiyuanResponse;", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator$calculateRank$result$1$1", f = "GaokaoRankCalculator.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<GaokaoApi, Continuation<? super BizResponse<GaokaoProvinceZhiyuanResponse>>, Object> {
        final /* synthetic */ String $province;
        final /* synthetic */ String $score;
        final /* synthetic */ String $subject;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r100, String r101, String r102, Continuation<? super AnonymousClass1> r103) {
            this.$score = r100;
            this.$province = r101;
            this.$subject = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$score, this.$province, this.$subject, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(GaokaoApi r100, Continuation<? super BizResponse<GaokaoProvinceZhiyuanResponse>> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(GaokaoApi r100, Continuation<? super BizResponse<GaokaoProvinceZhiyuanResponse>> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            GaokaoApi r103 = (GaokaoApi) this.L$0;
            GaokaoZhiyuanRequest r104 = new GaokaoZhiyuanRequest(this.$score, this.$province, this.$subject);
            this.label = 1;
            r100 = r103.getGaokaoZhiyuan(r104, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    public GaokaoRankCalculator$calculateRank$result$1(String r100, String r101, String r102, Continuation<? super GaokaoRankCalculator$calculateRank$result$1> r103) {
        this.$score = r100;
        this.$province = r101;
        this.$subject = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GaokaoRankCalculator$calculateRank$result$1(this.$score, this.$province, this.$subject, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super dm9.a<? extends GaokaoProvinceZhiyuanResponse>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super dm9.a<GaokaoProvinceZhiyuanResponse>> r101) {
        return ((GaokaoRankCalculator$calculateRank$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        GaokaoApi.a r103 = GaokaoApi.f316791a;
        AnonymousClass1 r104 = new AnonymousClass1(this.$score, this.$province, this.$subject, null);
        this.label = 1;
        r103.getClass();
        r100 = GaokaoApi.a.a(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
