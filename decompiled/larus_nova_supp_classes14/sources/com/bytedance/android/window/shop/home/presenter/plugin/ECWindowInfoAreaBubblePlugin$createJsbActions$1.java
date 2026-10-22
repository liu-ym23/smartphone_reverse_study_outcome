package com.bytedance.android.window.shop.home.presenter.plugin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowInfoAreaBubblePlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowInfoAreaBubblePlugin$createJsbActions$1(ECWindowInfoAreaBubblePlugin r8) {
        super(1, r8, ECWindowInfoAreaBubblePlugin.class, "onCouponComponentClose", "onCouponComponentClose(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ECWindowInfoAreaBubblePlugin r0 = (ECWindowInfoAreaBubblePlugin) ((CallableReference) this).receiver;
        int r1 = ECWindowInfoAreaBubblePlugin.f;
        r0.getClass();
        String r5 = r4.optString("component_type");
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.hashCode() == (-1194267257)) goto L9;
        return;
    L9:
        if (r5.equals("fans_coupon_default") == false) goto L19;
        Function1<Boolean, Unit> r6 = r0.e;
        Integer r2 = r0.d.getShopParam().getFollowStatus();
        boolean r3 = true;
        if (r2 != null) goto L14;
    L17:
        r6.invoke(Boolean.valueOf(r3));
        r0.h();
        return;
    L14:
        if (r2.intValue() != 1) goto L17;
        r3 = false;
        goto L17
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
