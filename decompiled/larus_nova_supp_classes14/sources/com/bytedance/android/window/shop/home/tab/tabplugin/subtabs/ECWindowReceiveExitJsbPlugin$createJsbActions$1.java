package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowReceiveExitJsbPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowReceiveExitJsbPlugin$createJsbActions$1(ECWindowReceiveExitJsbPlugin r8) {
        super(1, r8, ECWindowReceiveExitJsbPlugin.class, "onReceiveCloseEvent", "onReceiveCloseEvent(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ECWindowReceiveExitJsbPlugin r0 = (ECWindowReceiveExitJsbPlugin) ((CallableReference) this).receiver;
        if (ECWindowJsbPlugin.g(r3, r0.b) == false) goto L7;
        r0.c.finish();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
