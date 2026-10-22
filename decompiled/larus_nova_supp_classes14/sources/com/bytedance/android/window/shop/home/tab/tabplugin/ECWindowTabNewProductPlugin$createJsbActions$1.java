package com.bytedance.android.window.shop.home.tab.tabplugin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabNewProductPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabNewProductPlugin$createJsbActions$1(ECWindowTabNewProductPlugin r8) {
        super(1, r8, ECWindowTabNewProductPlugin.class, "onReceiveCouponEvent", "onReceiveCouponEvent(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ECWindowTabNewProductPlugin r0 = (ECWindowTabNewProductPlugin) ((CallableReference) this).receiver;
        int r1 = ECWindowTabNewProductPlugin.e;
        r0.getClass();
        boolean r2 = r6.optBoolean("success", false);
        boolean r3 = r6.optBoolean("is_category_coupon", false);
        if (r6.optInt("tab_select", com.bytedance.android.window.shop.c.c.getType()) != r0.c.getType()) goto L11;
        if (r2 == false) goto L9;
        if (r3 == false) goto L10;
        r0.h(r6);
        return;
    L10:
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
