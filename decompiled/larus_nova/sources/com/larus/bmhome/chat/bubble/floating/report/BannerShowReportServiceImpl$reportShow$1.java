package com.larus.bmhome.chat.bubble.floating.report;

import com.larus.bmhome.chat.bubble.floating.network.BubbleBannerApi;
import com.larus.bmhome.chat.bubble.floating.network.BubbleBannerShowReportRequest;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.report.BannerShowReportServiceImpl$reportShow$1", f = "BannerShowReportServiceImpl.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class BannerShowReportServiceImpl$reportShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bannerSource;
    final /* synthetic */ a $input;
    final /* synthetic */ String $serverRequired;
    int label;

    public BannerShowReportServiceImpl$reportShow$1(String r100, a r101, String r102, Continuation<? super BannerShowReportServiceImpl$reportShow$1> r103) {
        this.$bannerSource = r100;
        this.$input = r101;
        this.$serverRequired = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BannerShowReportServiceImpl$reportShow$1(this.$bannerSource, this.$input, this.$serverRequired, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BannerShowReportServiceImpl$reportShow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L14:
        dm9.a r111 = (dm9.a) r110;
        if ((r111 instanceof dm9.a.b) == true) goto L22;
        if ((r111 instanceof dm9.a.C5690a) == false) goto L20;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("push banner show report failed, bannerSource=");
        r103.append(this.$bannerSource);
        r103.append(", showTime=");
        r103.append(this.$input.f297535b);
        r103.append(", code=");
        dm9.a.C5690a r112 = (dm9.a.C5690a) r111;
        r103.append(r112.f469228a);
        r103.append(", msg=");
        r103.append(r112.f469229b);
        r102.e("BannerShowReportServiceImpl", r103.toString(), r112.f469230c);
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        String r104 = this.$bannerSource;
        long r105 = this.$input.f297535b;
        String r106 = this.$serverRequired;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        BubbleBannerShowReportRequest r113 = new BubbleBannerShowReportRequest(r104, r105, null, MapsKt.mapOf(TuplesKt.to("server_required", r106)), 4, null);
        BubbleBannerApi.a r107 = BubbleBannerApi.f297526a;
        BannerShowReportServiceImpl$reportShow$1$result$1 r108 = new BannerShowReportServiceImpl$reportShow$1$result$1(r113, null);
        this.label = 1;
        r107.getClass();
        r110 = BubbleBannerApi.a.a(r108, this);
        if (r110 != r100) goto L14;
        return r100;
    }
}
