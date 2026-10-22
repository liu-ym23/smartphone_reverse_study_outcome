package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.LinkedHashMap;
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
import org.json.JSONObject;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/shopping/prepurchase/business/pdp/services/PdpCommonBridgeService$lynxCardSendLog$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.PdpCommonBridgeService$lynxCardSendLog$1$1", f = "PdpCommonBridgeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpCommonBridgeService$lynxCardSendLog$$inlined$runCatching$lambda$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $duplicateKey;
    final /* synthetic */ JSONObject $eventParams;
    final /* synthetic */ JSONObject $params$inlined;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ d this$0;

    public PdpCommonBridgeService$lynxCardSendLog$$inlined$runCatching$lambda$1(JSONObject r1, String r2, Continuation r3, d r4, JSONObject r5) {
        this.$eventParams = r1;
        this.$duplicateKey = r2;
        this.this$0 = r4;
        this.$params$inlined = r5;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r7, w r8, Continuation<? super Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "$this$create");
        Intrinsics.checkNotNullParameter(r8, "it");
        Intrinsics.checkNotNullParameter(r9, "continuation");
        PdpCommonBridgeService$lynxCardSendLog$$inlined$runCatching$lambda$1 r10 = new PdpCommonBridgeService$lynxCardSendLog$$inlined$runCatching$lambda$1(this.$eventParams, this.$duplicateKey, r9, this.this$0, this.$params$inlined);
        r10.L$0 = r8;
        return r10;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r9);
        ProductDetailEventService.b r10 = ((w) this.L$0).m();
        LinkedHashMap r0 = new LinkedHashMap();
        JSONObject r1 = this.$eventParams;
        if (r1 == null) goto L7;
        r0.putAll(z1.j(r1));
    L7:
        Object r2 = this.this$0.O1().getContainerAbility().k7();
        JSONObject r3 = this.$params$inlined;
        String r4 = r3.optString("btm_id");
        boolean r5 = r3.optBoolean("is_click");
        r0.put("btm_id", BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r4, Boolean.valueOf(r5)).withBtmPage(r2).build()));
        Unit r6 = Unit.INSTANCE;
        m r7 = r10.d(r0);
        String r8 = this.$params$inlined.optString("eventName");
        if (this.$duplicateKey.length() != 0) goto L10;
        boolean r11 = true;
    L11:
        m.a.a(r7, r8, r11, this.$duplicateKey, null, 8);
        return Unit.INSTANCE;
    L10:
        r11 = false;
        goto L11
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
