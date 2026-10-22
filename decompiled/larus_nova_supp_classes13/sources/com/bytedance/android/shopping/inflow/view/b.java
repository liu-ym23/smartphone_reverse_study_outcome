package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ InFlowRankLayout g;
    public final /* synthetic */ AnchorV3Param h;
    public final /* synthetic */ String i;

    public final void a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        InFlowRankLayout r10 = this.g;
        int r0 = p0.a;
        String r1 = r10.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r10.a = p0.d(r1, SimilarProductParam.ENTER_FROM, "product_flow_page");
        AnchorV3Param r11 = this.h;
        String r2 = null;
        if (r11 == null) goto L8;
        String r12 = r11.getEntranceInfo();
    L32:
        JSONObject r3 = new JSONObject(r12);     // Catch: Exception -> L17
        InFlowRankLayout r13 = this.g;
        String r4 = r13.a;
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        r13.a = p0.d(r4, "previous_page", r3.optString("carrier_source", ""));
        InFlowRankLayout r14 = this.g;
        String r5 = r14.a;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        r14.a = p0.d(r5, "search_params", r3.optString("search_params", ""));
    L18:
        String r6 = this.i;
        if (r6 == null) goto L21;
        String r15 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, r6, PageFinder.via(this.g), null, 4, null);
    L22:
        p r7 = p.a;
        Context r8 = this.g.getContext();
        String r16 = this.g.a;
        if (r16 == null) goto L28;
        if (r15 != null) goto L27;
        r2 = r16;
        goto L28
    L27:
        Uri.Builder r17 = UriProtector.parse(r16).buildUpon();
        r17.appendQueryParameter("source_btm_token", r15);
        r2 = r17.toString();
    L28:
        r7.openSchema(r8, r2);
        Function0<Unit> r18 = this.g.d;
        if (r18 == null) goto L34;
        Unit r19 = (Unit) r18.invoke();
        return;
    L34:
        return;
    L21:
        r15 = null;
        goto L22
    L8:
        r12 = null;
        goto L32
    }

    public b(InFlowRankLayout r1, AnchorV3Param r2, String r3) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        super(null, null, 3);
    }
}
