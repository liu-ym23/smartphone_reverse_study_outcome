package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent$EventDependencyImpl$track$2", f = "HeaderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HeaderComponent$EventDependencyImpl$track$2 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
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

    public HeaderComponent$EventDependencyImpl$track$2(Map r1, String r2, String r3, boolean r4, String r5, PageFinder r6, View r7, boolean r8, Continuation r9) {
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
        HeaderComponent$EventDependencyImpl$track$2 r14 = new HeaderComponent$EventDependencyImpl$track$2(this.$params, this.$btmId, this.$eventName, this.$allowDuplicate, this.$identifier, this.$pageFinder, this.$view, this.$logLuban, r13);
        r14.L$0 = r12;
        return r14;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r6);
        w r7 = (w) this.L$0;
        ProductDetailEventService.b r0 = r7.m();
        LinkedHashMap r1 = new LinkedHashMap();
        Map<? extends String, ? extends Object> r2 = this.$params;
        if (r2 == null) goto L8;
        r1.putAll(r2);
    L8:
        if (k.c(this.$btmId) == false) goto L10;
        r1.put("btm", this.$btmId);
    L10:
        Unit r3 = Unit.INSTANCE;
        m r4 = r0.d(r1);
        String r5 = this.$eventName;
        boolean r8 = this.$allowDuplicate;
        String r9 = this.$identifier;
        PageFinder r10 = this.$pageFinder;
        if (r10 != null) goto L13;
        r10 = PageFinder.via(this.$view);
    L13:
        boolean r11 = r4.a(r5, r8, r9, r10);
        if (this.$logLuban == false) goto L19;
        if (r11 != true) goto L19;
        w.a.a(r7, this.$eventName, null, 6);
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
