package com.bytedance.android.window.shop.home.tabcard;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowHybridTabCardGroup$WindowNotifyShakePlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public WindowHybridTabCardGroup$WindowNotifyShakePlugin$createJsbActions$1(WindowHybridTabCardGroup.WindowNotifyShakePlugin r8) {
        super(1, r8, WindowHybridTabCardGroup.WindowNotifyShakePlugin.class, "onForwardEvent", "onForwardEvent(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        WindowHybridTabCardGroup.WindowNotifyShakePlugin r0 = (WindowHybridTabCardGroup.WindowNotifyShakePlugin) ((CallableReference) this).receiver;
        if (ECWindowJsbPlugin.g(r5, r0.b.i.getShopParam().getSecAuthorId()) == false) goto L19;
        String r1 = a2.d(r5.optString("forward_event"));
        if (r1 == null) goto L20;
        r5.optInt("receiver_type");
        Map r6 = z1.k(r5.optJSONObject("forward_param"));
        BaseViewHolder r2 = ((ECHybridListEngine) r0.b.e.getValue()).e("coupon_list_card", "52011_0");
        if ((r2 instanceof WindowHybridTabCardGroup.WindowLynxHolder) == true) goto L11;
        r2 = null;
    L11:
        WindowHybridTabCardGroup.WindowLynxHolder r3 = (WindowHybridTabCardGroup.WindowLynxHolder) r2;
        if (r3 == null) goto L17;
        JSONObject r7 = KtSafeMethodExtensionKt.safeToJson(r6);
        Intrinsics.checkNotNullParameter(r1, "eventName");
        ECLynxCard r4 = ((ECLynxCardHolder) r3).t;
        if (r4 == null) goto L18;
        r4.o(r1, r7);
        return;
    L18:
        return;
    L17:
        return;
    L20:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
