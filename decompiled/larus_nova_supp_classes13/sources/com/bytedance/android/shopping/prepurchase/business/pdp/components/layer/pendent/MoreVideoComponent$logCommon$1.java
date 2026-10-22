package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.MoreVideoComponent$logCommon$1", f = "MoreVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MoreVideoComponent$logCommon$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowDuplicate;
    final /* synthetic */ String $btmId;
    final /* synthetic */ String $eventName;
    final /* synthetic */ String $identifier;
    final /* synthetic */ boolean $logLuban;
    final /* synthetic */ PageFinder $pageFinder;
    final /* synthetic */ Map $params;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public MoreVideoComponent$logCommon$1(Map r1, String r2, String r3, boolean r4, String r5, PageFinder r6, View r7, boolean r8, Continuation r9) {
        this.$params = r1;
        this.$btmId = r2;
        this.$eventName = r3;
        this.$allowDuplicate = r4;
        this.$identifier = r5;
        this.$pageFinder = r6;
        this.$view = r7;
        this.$logLuban = r8;
        super(3, r9);
    }

    public final Continuation<Unit> create(CoroutineScope r11, w r12, Continuation<? super Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "$this$create");
        Intrinsics.checkNotNullParameter(r12, "it");
        Intrinsics.checkNotNullParameter(r13, "continuation");
        MoreVideoComponent$logCommon$1 r14 = new MoreVideoComponent$logCommon$1(this.$params, this.$btmId, this.$eventName, this.$allowDuplicate, this.$identifier, this.$pageFinder, this.$view, this.$logLuban, r13);
        r14.L$0 = r12;
        return r14;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r7);
        w r8 = (w) this.L$0;
        ProductDetailEventService.b r0 = r8.m();
        if (r0 == null) goto L18;
        LinkedHashMap r2 = new LinkedHashMap();
        Map<? extends String, ? extends Object> r3 = this.$params;
        if (r3 == null) goto L10;
        r2.putAll(r3);
    L10:
        if (com.bytedance.android.shopping.extensions.k.c(this.$btmId) == false) goto L12;
        r2.put("btm", this.$btmId);
    L12:
        Unit r4 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r1 = r0.d(r2);
        if (r1 == null) goto L18;
        String r5 = this.$eventName;
        boolean r6 = this.$allowDuplicate;
        String r9 = this.$identifier;
        PageFinder r10 = this.$pageFinder;
        if (r10 != null) goto L17;
        r10 = PageFinder.via(this.$view);
    L17:
        Boolean r11 = Boxing.boxBoolean(r1.a(r5, r6, r9, r10));
    L19:
        boolean r12 = r11.booleanValue();
        if (this.$logLuban == false) goto L25;
        if (r12 != true) goto L25;
        w.a.a(r8, this.$eventName, null, 6);
    L25:
        return Unit.INSTANCE;
    L18:
        r11 = null;
        goto L19
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
