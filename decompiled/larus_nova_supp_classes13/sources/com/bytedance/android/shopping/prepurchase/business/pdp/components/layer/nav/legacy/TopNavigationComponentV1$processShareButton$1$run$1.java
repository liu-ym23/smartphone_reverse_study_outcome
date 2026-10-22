package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.api.anchorv3.ECShareFission;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1$processShareButton$1$run$1", f = "TopNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopNavigationComponentV1$processShareButton$1$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopNavigationComponentV1$processShareButton$1 this$0;

    public TopNavigationComponentV1$processShareButton$1$run$1(TopNavigationComponentV1$processShareButton$1 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        TopNavigationComponentV1$processShareButton$1$run$1 r0 = new TopNavigationComponentV1$processShareButton$1$run$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L29
        Object r0 = Result.constructor-impl(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis())));     // Catch: Throwable -> L8
    L10:
        Boolean r2 = null;
        if (Result.isFailure-impl(r0) == false) goto L13;
        r0 = null;
    L13:
        String r1 = (String) r0;     // Catch: Throwable -> L29
        if (r1 == null) goto L16;
        com.bytedance.android.ec.sdk.helper.q r3 = com.bytedance.android.ec.sdk.helper.q.a;     // Catch: Throwable -> L29
        if ((!Intrinsics.areEqual(r3.getString("share_button_bubble_date", r1), r1)) == false) goto L21;
        r3.d(ECShareFission.SHARE_BUTTON_BUBBLE_TIMES, 0);     // Catch: Throwable -> L29
    L21:
        ShareMeta r4 = this.this$0.d;     // Catch: Throwable -> L29
        if (r4 == null) goto L25;
        r2 = r4.getDisplayShareTouchPoint();     // Catch: Throwable -> L29
    L25:
        if (Intrinsics.areEqual(r2, Boxing.boxBoolean(true)) == false) goto L27;
        r3.d(ECShareFission.SHARE_BUTTON_BUBBLE_TIMES, r3.getInt(ECShareFission.SHARE_BUTTON_BUBBLE_TIMES, 0) + 1);     // Catch: Throwable -> L29
    L27:
        r3.putString("share_button_bubble_date", r1);     // Catch: Throwable -> L29
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L35;
        ECExceptionMonitor.e(r12);
    L35:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L29
        r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
