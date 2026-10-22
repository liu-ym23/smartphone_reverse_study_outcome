package com.bytedance.android.window.shop.home.presenter.plugin;

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
public final /* synthetic */ class ECWindowMuteCtrlPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowMuteCtrlPlugin$createJsbActions$1(ECWindowMuteCtrlPlugin r8) {
        super(1, r8, ECWindowMuteCtrlPlugin.class, "onReceiveActionMute", "onReceiveActionMute(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ECWindowMuteCtrlPlugin r0 = (ECWindowMuteCtrlPlugin) ((CallableReference) this).receiver;
        if (ECWindowJsbPlugin.g(r4, r0.b.getShopParam().getSecAuthorId()) == true) goto L6;
        return;
    L6:
        if (r4.optBoolean("mute_window", false) == false) goto L8;
        r0.b.getLiveManager().h(false);
        r0.b.getLiveManager().g(true);
        return;
    L8:
        r0.b.getLiveManager().j(false);
        r0.b.getLiveManager().a();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
