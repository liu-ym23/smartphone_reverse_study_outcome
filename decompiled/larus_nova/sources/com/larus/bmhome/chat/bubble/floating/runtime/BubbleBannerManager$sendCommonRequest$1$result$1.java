package com.larus.bmhome.chat.bubble.floating.runtime;

import com.larus.bmhome.chat.bubble.floating.network.BubbleBannerApi;
import com.larus.bmhome.chat.bubble.floating.network.ExperienceCommonBizData;
import com.larus.bmhome.chat.bubble.floating.network.ExperienceCommonBizRequest;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1$result$1", f = "BubbleBannerManager.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
public final class BubbleBannerManager$sendCommonRequest$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends ExperienceCommonBizData>>, Object> {
    final /* synthetic */ Map<String, String> $actionData;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "Lcom/larus/bmhome/chat/bubble/floating/network/BubbleBannerApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1$result$1$1", f = "BubbleBannerManager.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<BubbleBannerApi, Continuation<? super BizResponse<ExperienceCommonBizData>>, Object> {
        final /* synthetic */ Map<String, String> $actionData;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Map<String, String> r100, Continuation<? super AnonymousClass1> r101) {
            this.$actionData = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$actionData, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(BubbleBannerApi r100, Continuation<? super BizResponse<ExperienceCommonBizData>> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(BubbleBannerApi r100, Continuation<? super BizResponse<ExperienceCommonBizData>> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L23:
            return r110;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            BubbleBannerApi r111 = (BubbleBannerApi) this.L$0;
            Map<String, String> r102 = this.$actionData;
            if (r102 == null) goto L11;
            String r103 = r102.get("biz_req_id");
        L12:
            Map<String, String> r104 = this.$actionData;
            if (r104 == null) goto L19;
            String r105 = r104.get("params");
            if (r105 == null) goto L19;
            if ((!StringsKt.isBlank(r105)) == false) goto L19;
            String r106 = r105;
        L20:
            ExperienceCommonBizRequest r107 = new ExperienceCommonBizRequest(r103, 0, r106, 2, null);
            this.label = 1;
            r110 = r111.sendCommonRequest(r107, this);
            if (r110 != r100) goto L23;
            return r100;
        L19:
            r106 = null;
            goto L20
        L11:
            r103 = null;
            goto L12
        }
    }

    public BubbleBannerManager$sendCommonRequest$1$result$1(Map<String, String> r100, Continuation<? super BubbleBannerManager$sendCommonRequest$1$result$1> r101) {
        this.$actionData = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BubbleBannerManager$sendCommonRequest$1$result$1(this.$actionData, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super dm9.a<? extends ExperienceCommonBizData>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super dm9.a<ExperienceCommonBizData>> r101) {
        return ((BubbleBannerManager$sendCommonRequest$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        BubbleBannerApi.a r103 = BubbleBannerApi.f297526a;
        AnonymousClass1 r104 = new AnonymousClass1(this.$actionData, null);
        this.label = 1;
        r103.getClass();
        r100 = BubbleBannerApi.a.a(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
