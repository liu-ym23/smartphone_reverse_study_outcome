package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowFloatLynxPresenter$jsShowFollowToastEventSubscriber$1 implements j {
    public final /* synthetic */ ECWindowInnerFlowFloatLynxPresenter a;

    public ECWindowInnerFlowFloatLynxPresenter$jsShowFollowToastEventSubscriber$1(ECWindowInnerFlowFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void a(JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (((ArrayList) this.a.e).contains(r11.optString("tag")) == true) goto L25;
        final JSONObject r0 = z1.g(r11.optString("module"));
        ((ArrayList) this.a.e).add(r11.optString("tag"));
        final Context r5 = this.a.u().c();
        Fragment r1 = this.a.u().a;
        if ((r1 instanceof DialogFragment) == true) goto L7;
        r1 = null;
    L7:
        final DialogFragment r6 = (DialogFragment) r1;
        if (r0 == null) goto L10;
        String r2 = r0.optString("data");
    L11:
        final JSONObject r7 = z1.g(r2);
        if (r0 == null) goto L14;
        final String r8 = r0.optString("name");
    L15:
        WindowFloatLayout r12 = new ECWindowInnerFlowFloatLynxPresenter$jsShowFollowToastEventSubscriber$1$onReceiveJsEvent$1(this, r0, r5, r6, r7, r8);
        if (r0 == null) goto L18;
        String r3 = r0.optString("module_url");
    L19:
        Pair[] r4 = new Pair[2];
        if (r0 == null) goto L22;
        String r9 = r0.optString("data");
    L23:
        r4[0] = TuplesKt.to("data", r9);
        r4[1] = TuplesKt.to("metaInfo", ECWindowInnerFlowFloatLynxPresenter.E(this.a));
        r12.e(r3, MapsKt.mapOf(r4), null);
        return;
    L22:
        r9 = null;
        goto L23
    L18:
        r3 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L10:
        r2 = null;
        goto L11
    }
}
