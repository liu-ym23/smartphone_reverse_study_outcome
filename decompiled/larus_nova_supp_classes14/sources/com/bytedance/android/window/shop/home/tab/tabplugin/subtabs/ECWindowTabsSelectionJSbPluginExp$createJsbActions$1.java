package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabsSelectionJSbPluginExp$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabsSelectionJSbPluginExp$createJsbActions$1(ECWindowTabsSelectionJSbPluginExp r8) {
        super(1, r8, ECWindowTabsSelectionJSbPluginExp.class, "onReceiveCouponAction", "onReceiveCouponAction(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ECWindowTabsSelectionJSbPluginExp r0 = (ECWindowTabsSelectionJSbPluginExp) ((CallableReference) this).receiver;
        int r1 = ECWindowTabsSelectionJSbPluginExp.g;
        r0.getClass();
        boolean r2 = r9.optBoolean("success");
        boolean r3 = r9.optBoolean("is_category_coupon");
        String r4 = r9.optString("category_id", null);
        TabNavigationParams.Companion.getClass();
        TabNavigationParams r10 = TabNavigationParams.a.a(r9);
        WindowNavigationParam.a r6 = WindowNavigationParam.Companion;
        WindowNavigationParam<String> r7 = r10.getCategoryId();
        r6.getClass();
        String r8 = "-1";
        String r11 = (String) WindowNavigationParam.a.a(r7, "-1");
        if (r11 == null) goto L6;
        r8 = r11;
    L6:
        CategoryRequestParamKey r5 = new CategoryRequestParamKey(r8, null, 2, null);
        r0.e.getShopParam().addAnchorParam(r5, r10);
        if (r2 == false) goto L14;
        if (r3 == true) goto L10;
        return;
    L10:
        if (((ArrayList) r0.b).isEmpty() == false) goto L12;
        List<Runnable> r12 = r0.c;
        ArrayList r13 = (ArrayList) r12;
        r13.add(new b(r0, r4));
        return;
    L12:
        r0.f.invoke(r4, r0.b);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
