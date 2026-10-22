package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabsSelectionJSbPluginExp$createJsbActions$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabsSelectionJSbPluginExp$createJsbActions$2(ECWindowTabsSelectionJSbPluginExp r8) {
        super(1, r8, ECWindowTabsSelectionJSbPluginExp.class, "doTabAnchor", "doTabAnchor(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ECWindowTabsSelectionJSbPluginExp r0 = (ECWindowTabsSelectionJSbPluginExp) ((CallableReference) this).receiver;
        int r1 = ECWindowTabsSelectionJSbPluginExp.g;
        r0.getClass();
        if ((!Intrinsics.areEqual(r4.optString("sec_author_id"), r0.e.getShopParam().getSecAuthorId())) == true) goto L7;
        r0.f.invoke(r4.optString("category_id"), r0.b);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
