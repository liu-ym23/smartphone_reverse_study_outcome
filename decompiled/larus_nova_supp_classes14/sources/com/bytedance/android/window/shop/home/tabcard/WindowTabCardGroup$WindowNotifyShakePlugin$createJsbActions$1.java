package com.bytedance.android.window.shop.home.tabcard;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.product.presenter.lynxCard.ECLynxCardPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowTabCardGroup$WindowNotifyShakePlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public WindowTabCardGroup$WindowNotifyShakePlugin$createJsbActions$1(WindowTabCardGroup.WindowNotifyShakePlugin r8) {
        super(1, r8, WindowTabCardGroup.WindowNotifyShakePlugin.class, "onForwardEvent", "onForwardEvent(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        WindowTabCardGroup.WindowNotifyShakePlugin r0 = (WindowTabCardGroup.WindowNotifyShakePlugin) ((CallableReference) this).receiver;
        if (ECWindowJsbPlugin.g(r6, r0.b.g.getShopParam().getSecAuthorId()) == false) goto L20;
        String r1 = a2.d(r6.optString("forward_event"));
        if (r1 == null) goto L30;
        int r2 = r6.optInt("receiver_type");
        JSONObject r7 = r6.optJSONObject("forward_param");
        Iterator<T> r3 = r0.b.c.entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L31;
        WindowLynxHolder r4 = (WindowLynxHolder) ((Pair) ((Map.Entry) r3.next()).getValue()).getSecond();
        v r5 = r4.x;
        if (r5 == null) goto L10;
        if (r5.i != r2) goto L10;
        ECLynxCard r8 = ((ECLynxCardPresenter) r4.y.getValue()).G();
        if (r8 == null) goto L10;
        r8.o(r1, r7);
        goto L10
    L31:
        return;
    L30:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
