package com.bytedance.android.shopping.mall.homepage.card.video;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import com.bytedance.android.shopping.mall.homepage.jsb.q;
import com.bytedance.android.shopping.mall.homepage.tools.LastActionRecorderKt;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NativeVideoCard$productClickListener$1 implements View.OnClickListener {
    public final /* synthetic */ NativeVideoCard a;
    public final /* synthetic */ View b;

    public NativeVideoCard$productClickListener$1(NativeVideoCard r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        int r11 = q.a;
        NativeVideoCard r12 = this.a;
        String r0 = r12.r;
        VideoCardData r13 = r12.O;
        if (r13 == null) goto L7;
        VideoCardData.Video r14 = r13.getVideo();
        if (r14 == null) goto L7;
        String r15 = r14.getId();
    L8:
        ECHybridListItemVO r2 = ((BaseViewHolder) this.a).c;
        if (r2 == null) goto L11;
        String r3 = r2.d;
    L12:
        q.a(r0, r15, r3);
        LastActionRecorderKt.b(this.a, false, null);
        String r16 = "c9582.d3197_i" + (ToolsKt.g(this.a) + 1);
        g.e(this.a, r16);
        ToolsKt.g(this.a);
        Map<String, Object> r4 = c0.a;
        ECHybridListItemVO r5 = ((BaseViewHolder) this.a).c;
        if (r5 == null) goto L18;
        ECNAMallCardExtra r6 = r5.c();
        if (r6 == null) goto L18;
        Map r7 = r6.getSchemaMap();
        if (r7 == null) goto L18;
    L19:
        String r8 = c0.a(r7, true, ToolsKt.g(this.a), new NativeVideoCard$productClickListener$1$schema$1(this));
        JsonObject r9 = new JsonObject();
        Object r17 = ToolsKt.k(this.a).get(SimilarProductParam.ENTER_FROM);
        if ((r17 instanceof String) == true) goto L22;
        r17 = null;
    L22:
        String r18 = (String) r17;
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        r9.addProperty(SimilarProductParam.ENTER_FROM, r18);
        r9.toString();
        com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostECSchemaMonitorService();
        if (BtmSDK.INSTANCE.useV2Api() == false) goto L28;
        int r19 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
        r8 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r8, MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r16), TuplesKt.to("bcm", MapsKt.mapOf(TuplesKt.to("type", "video")))}), PageFinder.via(this.b), this.b.getContext(), false);
    L29:
        NativeVideoCard r110 = this.a;
        IHybridVideoBoxView r20 = r110.Q;
        if (r20 != null) goto L32;
    L34:
        k.b.d(this.b.getContext(), r8, null);
        return;
    L32:
        if (r110.h1 == false) goto L34;
        r110.X = true;
        MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r8)});
        int r111 = IHybridVideoBoxView.a;
        r20.b();
        return;
    L28:
        ToolsKt.z(this.a, this.b, r16, new JSONObject().put("type", "video"));
    L18:
        r7 = MapsKt.emptyMap();
        goto L19
    L11:
        r3 = null;
    L7:
        r15 = null;
        goto L8
    }
}
