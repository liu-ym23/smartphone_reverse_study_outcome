package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
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
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent$HeaderDependencyV2$track$2", f = "HeaderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HeaderComponent$HeaderDependencyV2$track$2 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowDuplicate;
    final /* synthetic */ String $btmId;
    final /* synthetic */ String $eventName;
    final /* synthetic */ String $identifier;
    final /* synthetic */ boolean $logLuban;
    final /* synthetic */ Map $params;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public HeaderComponent$HeaderDependencyV2$track$2(Map r1, View r2, String r3, String r4, boolean r5, String r6, boolean r7, Continuation r8) {
        this.$params = r1;
        this.$view = r2;
        this.$btmId = r3;
        this.$eventName = r4;
        this.$allowDuplicate = r5;
        this.$identifier = r6;
        this.$logLuban = r7;
        super(3, r8);
    }

    public final Continuation<Unit> create(CoroutineScope r10, w r11, Continuation<? super Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$create");
        Intrinsics.checkNotNullParameter(r11, "it");
        Intrinsics.checkNotNullParameter(r12, "continuation");
        HeaderComponent$HeaderDependencyV2$track$2 r13 = new HeaderComponent$HeaderDependencyV2$track$2(this.$params, this.$view, this.$btmId, this.$eventName, this.$allowDuplicate, this.$identifier, this.$logLuban, r12);
        r13.L$0 = r11;
        return r13;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r7);
        w r8 = (w) this.L$0;
        m r0 = r8.m().d(this.$params);
        View r1 = this.$view;
        String r2 = this.$btmId;
        if (r2 != null) goto L7;
        r2 = "a1.b8094.c0.d0";
    L7:
        boolean r3 = r0.c(r1, r2, null).a(this.$eventName, this.$allowDuplicate, this.$identifier, PageFinder.via(this.$view));
        if (this.$logLuban == false) goto L13;
        if (r3 != true) goto L13;
        w.a.a(r8, this.$eventName, null, 6);
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
