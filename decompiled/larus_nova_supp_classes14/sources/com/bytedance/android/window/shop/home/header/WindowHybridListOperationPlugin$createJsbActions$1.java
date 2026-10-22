package com.bytedance.android.window.shop.home.header;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.window.shop.home.tab.presenter.a0;
import com.bytedance.android.window.shop.home.tab.presenter.b0;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowHybridListOperationPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public WindowHybridListOperationPlugin$createJsbActions$1(WindowHybridListOperationPlugin r8) {
        super(1, r8, WindowHybridListOperationPlugin.class, "handleHeaderStateTransform", "handleHeaderStateTransform(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        WindowHybridListOperationPlugin r0 = (WindowHybridListOperationPlugin) ((CallableReference) this).receiver;
        if (r0.b.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) >= 0) goto L6;
        return;
    L6:
        if (ECWindowJsbPlugin.g(r6, r0.c.getShopParam().getSecAuthorId()) == false) goto L34;
        WindowHybridListOperationPlugin.b r2 = new WindowHybridListOperationPlugin.b(r6.optString("mode"), r0.c.getShopParam().getSecAuthorId());
        RecyclerView r7 = r0.d.b;
        JSONObject r1 = k.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("sec_author_id", r0.c.getShopParam().getSecAuthorId()), TuplesKt.to("mode", r2.a)}));
        Intrinsics.checkNotNullParameter(r7, "$this$sendListLynxEventByJSON");
        Intrinsics.checkNotNullParameter("ecom.window.card_state_transform", "eventName");
        Intrinsics.checkNotNullParameter(r1, "params");
        RecyclerView r3 = r7;
    L9:
        RecyclerView r4 = null;
        if ((r3 instanceof RecyclerView) == true) goto L19;
        if (r3 == null) goto L19;
        RecyclerView r5 = r3.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L16;
        r4 = r5;
    L16:
        r3 = (ViewGroup) r4;
        if ((r3 instanceof RecyclerView) == false) goto L9;
        r4 = r3;
    L19:
        if (r4 != null) goto L22;
    L27:
        s0.a(r2);
        return;
    L22:
        if ((r4 instanceof ECHybridRecyclerView) == false) goto L25;
        r7.post(new a0(r4, r1));
        goto L27
    L25:
        if ((r4 instanceof ECShopRecyclerView) == false) goto L27;
        r7.post(new b0(r4, r1));
        goto L27
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
