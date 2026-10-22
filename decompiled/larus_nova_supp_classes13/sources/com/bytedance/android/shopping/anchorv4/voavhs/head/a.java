package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.AnchorV4KolEvaluationBusinessMeta;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final Context a;
    public final AnchorV4VM b;
    public final AnchorV4HeadMeta c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r8, Object r9) {
        LinkedTreeMap<String, Object> r10 = null;
        if (r8 == null) goto L5;
        String r11 = r8.getId();
    L6:
        if (r11 == null) goto L45;
        int r0 = r11.hashCode();
        if (r0 == (-336084919)) goto L29;
        if (r0 == 1583504725) goto L21;
        if (r0 == 1734847841) goto L16;
        return;
    L16:
        if (r11.equals("kol_review_more_video") == false) goto L37;
        int r12 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r1 == null) goto L38;
        r1.c = MapsKt.mapOf(TuplesKt.to("type", "pioneer_test"));
        AnchorV4TrackerImpl.b(r1, "pd_images_tab_more_show", false, null, false, null, 28);
        return;
    L38:
        return;
    L37:
        return;
    L21:
        if (r11.equals("action_live") == false) goto L40;
        int r13 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r2 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r2 == null) goto L41;
        AnchorV4HeadMeta r14 = this.c;
        if (r14 == null) goto L27;
        r10 = r14.getTrackMeta();
    L27:
        r2.c = r10;
        AnchorV4TrackerImpl.b(r2, "livesdk_live_show", false, null, false, null, 28);
        return;
    L41:
        return;
    L40:
        return;
    L29:
        if (r11.equals("action_play_back") == false) goto L43;
        int r15 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r3 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r3 == null) goto L44;
        AnchorV4HeadMeta r16 = this.c;
        if (r16 == null) goto L35;
        r10 = r16.getTrackMeta();
    L35:
        r3.c = r10;
        AnchorV4TrackerImpl.b(r3, "explain_replay_entrance_show", false, null, false, null, 28);
        return;
    L44:
        return;
    L43:
        return;
    L45:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public a(Context r2, AnchorV4VM r3, AnchorV4HeadMeta r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r13, Action r14, Object r15) {
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r14, "action");
        String r16 = r14.getId();
        if (r16 == null) goto L171;
        Object r5 = null;
        switch(r16.hashCode()) {
            case -336084919: goto L125;
            case -266569678: goto L68;
            case 1583504725: goto L43;
            case 1734847841: goto L9;
            default: goto L172;
        };
    L172:
        return;
    L9:
        if (r16.equals("kol_review_more_video") == false) goto L149;
        AnchorV4HeadMeta r17 = this.c;
        if (r17 == null) goto L20;
        HeadBusinessMeta r18 = r17.getBusinessMeta();
        if (r18 == null) goto L20;
        AnchorV4KolEvaluationBusinessMeta r19 = r18.getKolMeta();
        if (r19 == null) goto L20;
        String r110 = r19.getKolVideoListSchema();
        if (r110 == null) goto L20;
        JSONObject r111 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(UriProtector.parse(r110), "tracker"));
        if (r111 == null) goto L20;
    L21:
        AnchorV4HeadMeta r112 = this.c;
        if (r112 == null) goto L26;
        LinkedTreeMap<String, Object> r113 = r112.getTrackMeta();
        if (r113 == null) goto L26;
        r5 = r113.get("kol_video_cnt");
    L26:
        r111.put("kol_all_video_cnt", r5);
        Iterator r114 = this.b.getEventParams().entrySet().iterator();
    L28:
        if (r114.hasNext() == false) goto L30;
        Map.Entry r115 = (Map.Entry) r114.next();
        r111.put((String) r115.getKey(), r115.getValue());
        goto L28
    L30:
        AnchorV4HeadMeta r116 = this.c;
        if (r116 == null) goto L39;
        HeadBusinessMeta r117 = r116.getBusinessMeta();
        if (r117 == null) goto L39;
        AnchorV4KolEvaluationBusinessMeta r118 = r117.getKolMeta();
        if (r118 == null) goto L39;
        String r119 = r118.getKolVideoListSchema();
        if (r119 == null) goto L39;
        com.bytedance.android.ec.sdk.helper.p r120 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r0 = this.a;
        int r1 = p0.a;
        r120.openSchema(r0, p0.d(r119, "tracker", r111.toString()));
    L39:
        int r121 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r2 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r2 == null) goto L150;
        r2.c = MapsKt.mapOf(TuplesKt.to("type", "pioneer_test"));
        AnchorV4TrackerImpl.b(r2, "pd_images_tab_more_click", false, null, false, null, 30);
        return;
    L150:
        return;
    L20:
        r111 = new JSONObject();
        goto L21
    L149:
        return;
    L43:
        if (r16.equals("action_live") == false) goto L152;
        AnchorV4HeadMeta r122 = this.c;
        if (r122 == null) goto L153;
        HeadBusinessMeta r123 = r122.getBusinessMeta();
        if (r123 == null) goto L154;
        Link r124 = r123.getLiveLink();
        if (r124 == null) goto L155;
        String r125 = r124.getLinkUrl();
        if (r125 == null) goto L156;
        Context r126 = r13.getContext();
        if ((r126 instanceof Activity) == true) goto L55;
        r126 = null;
    L55:
        Activity r127 = (Activity) r126;
        if (r127 == null) goto L58;
        com.bytedance.android.ec.sdk.helper.p.a.d(com.bytedance.android.ec.core.btm.c.c(r125, r13, "a1.b8094.c5958.d61744", new Pair[0]), r127);
    L58:
        BtmItemBuilder r128 = new BtmItemBuilder("a1.b8094.c5958.d61744", null, 2, null).withPageFinder(PageFinder.via(r13)).setTargetPagesBtm(new String[]{"a1128.b3295"});
        LinkedHashMap r129 = new LinkedHashMap();
        LinkedTreeMap<String, Object> r130 = this.c.getTrackMeta();
        if (r130 == null) goto L61;
        r129.putAll(r130);
    L61:
        r129.put("btm_id", r128.obtainEventBtmParams());
        int r131 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r3 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r3 == null) goto L64;
        r3.c = r129;
        AnchorV4TrackerImpl.b(r3, "livesdk_rec_live_play", false, null, false, null, 30);
    L64:
        AnchorV4TrackerImpl r4 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r4 == null) goto L157;
        r4.c = r129;
        AnchorV4TrackerImpl.b(r4, "livesdk_live_pd_play", false, null, false, null, 30);
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L152:
        return;
    L68:
        if (r16.equals("kol_review_video_list") == false) goto L159;
        String r132 = r14.getMeta();
        if (r132 == null) goto L74;
        JSONObject r133 = com.bytedance.android.shopping.extensions.k.w(r132);
        if (r133 == null) goto L74;
        int r134 = r133.optInt("index");
    L75:
        AnchorV4HeadMeta r135 = this.c;
        if (r135 == null) goto L84;
        HeadBusinessMeta r136 = r135.getBusinessMeta();
        if (r136 == null) goto L84;
        AnchorV4KolEvaluationBusinessMeta r137 = r136.getKolMeta();
        if (r137 == null) goto L84;
        List<String> r138 = r137.getKolAwemeIdList();
        if (r138 == null) goto L84;
        String r139 = (String) CollectionsKt.getOrNull(r138, r134);
    L85:
        String r140 = "";
        if (r139 != null) goto L88;
        r139 = "";
    L88:
        AnchorV4HeadMeta r6 = this.c;
        if (r6 == null) goto L97;
        HeadBusinessMeta r7 = r6.getBusinessMeta();
        if (r7 == null) goto L97;
        AnchorV4KolEvaluationBusinessMeta r8 = r7.getKolMeta();
        if (r8 == null) goto L97;
        List<String> r9 = r8.getKolAuthorIdList();
        if (r9 == null) goto L97;
        String r10 = (String) CollectionsKt.getOrNull(r9, r134);
    L98:
        if (r10 == null) goto L101;
        r140 = r10;
    L101:
        AnchorV4HeadMeta r11 = this.c;
        if (r11 == null) goto L160;
        HeadBusinessMeta r12 = r11.getBusinessMeta();
        if (r12 == null) goto L161;
        AnchorV4KolEvaluationBusinessMeta r20 = r12.getKolMeta();
        if (r20 == null) goto L162;
        String r21 = r20.getKolVideoPlaySchema();
        if (r21 == null) goto L173;
        Uri r22 = UriProtector.parse(r21);
        if (StringsKt.contains$default(r21, "#click_video_id", false, 2, null) == false) goto L116;
        String r23 = StringsKt.replace$default(r21, "#click_video_id", r139, false, 4, null);
        JSONObject r24 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(r22, "tracker"));
        if (r24 != null) goto L115;
        r24 = new JSONObject();
    L115:
        r24.put("kol_video_id", r139);
        r24.put("kol_author_id", r140);
        r24.put("kol_video_rank", r134 + 1);
        int r141 = p0.a;
        p0.d(r23, "tracker", r24.toString());
        r21 = p0.d(r23, SimilarProductParam.ENTER_FROM, "kol_product_video");
    L116:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a, r21);
        LinkedHashMap r142 = new LinkedHashMap();
        LinkedTreeMap<String, Object> r143 = this.c.getTrackMeta();
        if (r143 == null) goto L121;
        Object r144 = r143.get("content_source");
        if (r144 == null) goto L121;
        String r145 = (String) r142.put("content_source", r144.toString());
    L121:
        r142.put("video_id", r139);
        r142.put("location", "tab");
        int r146 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r25 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r25 == null) goto L163;
        r25.c = r142;
        AnchorV4TrackerImpl.b(r25, "goods_video_click", false, null, false, null, 30);
        return;
    L163:
        return;
    L173:
        return;
    L162:
        return;
    L161:
        return;
    L160:
        return;
    L97:
        r10 = null;
    L84:
        r139 = null;
    L74:
        r134 = 0;
        goto L75
    L159:
        return;
    L125:
        if (r16.equals("action_play_back") == false) goto L165;
        AnchorV4HeadMeta r147 = this.c;
        if (r147 == null) goto L166;
        HeadBusinessMeta r148 = r147.getBusinessMeta();
        if (r148 == null) goto L167;
        Link r149 = r148.getReplayLink();
        if (r149 == null) goto L168;
        String r150 = r149.getLinkUrl();
        if (r150 == null) goto L169;
        Context r151 = r13.getContext();
        if ((r151 instanceof Activity) == false) goto L138;
        r5 = r151;
    L138:
        Activity r26 = (Activity) r5;
        if (r26 == null) goto L141;
        com.bytedance.android.ec.sdk.helper.p.a.d(com.bytedance.android.ec.core.btm.c.c(r150, r13, "a1.b8094.c5958.d6302", new Pair[0]), r26);
    L141:
        String r152 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c5958.d6302", Boolean.FALSE).withView(r13).build());
        int r153 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r27 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r27 == null) goto L170;
        LinkedHashMap r154 = new LinkedHashMap();
        LinkedTreeMap<String, Object> r155 = this.c.getTrackMeta();
        if (r155 == null) goto L146;
        r154.putAll(r155);
    L146:
        r154.put("btm_id", r152);
        Unit r156 = Unit.INSTANCE;
        r27.c = r154;
        AnchorV4TrackerImpl.b(r27, "explain_replay_entrance_click", false, null, false, null, 30);
        return;
    L170:
        return;
    L169:
        return;
    L168:
        return;
    L167:
        return;
    L166:
        return;
    L165:
        return;
    }
}
