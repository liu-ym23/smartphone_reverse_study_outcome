package com.bytedance.android.shopping.new_cart.router;

import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter;
import com.bytedance.android.shopping.new_cart.repo.CartRepository;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.new_cart.router.NewCartStarter$getCartCacheResponse$2", f = "NewCartStarter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NewCartStarter$getCartCacheResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newSourceType;
    int label;
    final /* synthetic */ NewCartStarter this$0;

    public NewCartStarter$getCartCacheResponse$2(NewCartStarter r1, String r2, Continuation r3) {
        this.this$0 = r1;
        this.$newSourceType = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new NewCartStarter$getCartCacheResponse$2(this.this$0, this.$newSourceType, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        Lazy r4 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", new AnonymousClass1(this));
        NewCartStarter r5 = this.this$0;
        e r0 = NewCartStarter.t;
        if (r5.b() == false) goto L7;
        int r6 = ECCartMonitorReporter.d;
        ECCartMonitorReporter r7 = ECCartMonitorReporter.a.a();
        String r1 = this.this$0.k;
        r7.getClass();
        ECCartMonitorReporter.d(r1, "request_end");
        ECCartMonitorReporter r8 = ECCartMonitorReporter.a.a();
        String r2 = this.this$0.k;
        r8.getClass();
        ECCartMonitorReporter.d(r2, "render_start");
    L7:
        e r9 = CartRepository.parseResponse(this.$newSourceType);
        if (r9 == null) goto L14;
        this.this$0.c(r9);
        Map<String, Map<String, Long>> r10 = yf3.b.a;
        yf3.b.a(this.this$0.s, "GetCartCacheResponseEnd");
        bg3.a r11 = com.bytedance.android.shopping.new_cart.utils.a.a;
        String r12 = this.$newSourceType;
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        com.bytedance.android.shopping.new_cart.utils.a.a("success", r12, CartRepository.INSTANCE.getCacheSourceType());
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
