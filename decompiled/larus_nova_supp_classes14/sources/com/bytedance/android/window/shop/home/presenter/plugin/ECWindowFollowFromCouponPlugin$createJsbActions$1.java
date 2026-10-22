package com.bytedance.android.window.shop.home.presenter.plugin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowFollowFromCouponPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowFollowFromCouponPlugin$createJsbActions$1(ECWindowFollowFromCouponPlugin r8) {
        super(1, r8, ECWindowFollowFromCouponPlugin.class, "onFollowStatusChanged", "onFollowStatusChanged(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ECWindowFollowFromCouponPlugin r0 = (ECWindowFollowFromCouponPlugin) ((CallableReference) this).receiver;
        int r1 = ECWindowFollowFromCouponPlugin.d;
        r0.getClass();
        int r2 = r4.optInt("follow_status", -1);
        if (r2 == (-1)) goto L15;
        String r5 = r4.optString("sec_author_id");
        if (StringsKt.isBlank(r5) == false) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(r5, (String) r0.b.invoke())) == true) goto L16;
        if (r2 != 1) goto L17;
        r0.c.invoke();
        return;
    L17:
        return;
    L16:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
