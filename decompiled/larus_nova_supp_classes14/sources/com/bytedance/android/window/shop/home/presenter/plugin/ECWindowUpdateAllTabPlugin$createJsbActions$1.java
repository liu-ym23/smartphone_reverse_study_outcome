package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.window.shop.home.tab.tabplugin.a;
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
public final /* synthetic */ class ECWindowUpdateAllTabPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowUpdateAllTabPlugin$createJsbActions$1(ECWindowUpdateAllTabPlugin r8) {
        super(1, r8, ECWindowUpdateAllTabPlugin.class, "onReceiveRefresh", "onReceiveRefresh(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ECWindowUpdateAllTabPlugin r0 = (ECWindowUpdateAllTabPlugin) ((CallableReference) this).receiver;
        int r1 = ECWindowUpdateAllTabPlugin.c;
        r0.getClass();
        String r4 = r3.optString("sec_author_id");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(r4, (String) r0.b.invoke())) == true) goto L10;
        s0.a(new a(r4, null, null, null));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
