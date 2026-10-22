package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final Context a;
    public final AnchorV4VM b;
    public final AnchorV4KolEvaluationMeta c;
    public final AnchorV4KolEvaluationDisplay d;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final void a(int r11) {
        AnchorV4KolEvaluationMeta r0 = this.c;
        if (r0 == null) goto L9;
        AnchorV4KolEvaluationBusinessMeta r1 = r0.getBusinessMeta();
        if (r1 == null) goto L9;
        List<String> r2 = r1.getKolAwemeIdList();
        if (r2 == null) goto L9;
        String r3 = (String) CollectionsKt.getOrNull(r2, r11);
    L10:
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        AnchorV4KolEvaluationMeta r5 = this.c;
        if (r5 == null) goto L20;
        AnchorV4KolEvaluationBusinessMeta r6 = r5.getBusinessMeta();
        if (r6 == null) goto L20;
        List<String> r7 = r6.getKolAuthorIdList();
        if (r7 == null) goto L20;
        String r8 = (String) CollectionsKt.getOrNull(r7, r11);
    L21:
        if (r8 == null) goto L24;
        r4 = r8;
    L24:
        AnchorV4KolEvaluationMeta r9 = this.c;
        if (r9 == null) goto L46;
        AnchorV4KolEvaluationBusinessMeta r10 = r9.getBusinessMeta();
        if (r10 == null) goto L47;
        String r12 = r10.getKolVideoPlaySchema();
        if (r12 == null) goto L49;
        Uri r13 = UriProtector.parse(r12);
        if (StringsKt.contains$default(r12, "#click_video_id", false, 2, null) == false) goto L37;
        String r14 = StringsKt.replace$default(r12, "#click_video_id", r3, false, 4, null);
        JSONObject r15 = k.w(UriProtector.getQueryParameter(r13, "tracker"));
        if (r15 != null) goto L36;
        r15 = new JSONObject();
    L36:
        r15.put("kol_video_id", r3);
        r15.put("kol_author_id", r4);
        r15.put("kol_video_rank", r11 + 1);
        int r16 = p0.a;
        p0.d(r14, "tracker", r15.toString());
        r12 = p0.d(r14, SimilarProductParam.ENTER_FROM, "kol_product_video");
    L37:
        p.a.openSchema(this.a, r12);
        LinkedHashMap r17 = new LinkedHashMap();
        AnchorV4KolEvaluationTrackMeta r18 = this.c.getTrackMeta();
        if (r18 == null) goto L42;
        String r19 = r18.getContentSource();
        if (r19 == null) goto L42;
        String r20 = (String) r17.put("content_source", r19);
    L42:
        r17.put("video_id", r3);
        r17.put("location", "module");
        int r21 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r22 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r22 == null) goto L48;
        r22.c = r17;
        AnchorV4TrackerImpl.b(r22, "goods_video_click", false, null, false, null, 30);
        return;
    L48:
        return;
    L49:
        return;
    L47:
        return;
    L46:
        return;
    L20:
        r8 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r8, Action r9, Object r10) {
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r9, "action");
        String r11 = r9.getId();
        if (r11 == null) goto L78;
        int r0 = r11.hashCode();
        int r2 = 0;
        if (r0 == (-961288383)) goto L19;
        if (r0 == (-266569678)) goto L11;
        return;
    L11:
        if (r11.equals("kol_review_video_list") == false) goto L74;
        String r12 = r9.getMeta();
        if (r12 == null) goto L17;
        JSONObject r13 = k.w(r12);
        if (r13 == null) goto L17;
        r2 = r13.optInt("index");
    L17:
        a(r2);
        return;
    L74:
        return;
    L19:
        if (r11.equals("kol_review_video_full_view") == false) goto L76;
        AnchorV4KolEvaluationDisplay r14 = this.d;
        if (r14 == null) goto L25;
        List<KolReviewElement> r15 = r14.getKolReviewList();
        if (r15 == null) goto L25;
        int r16 = r15.size();
    L27:
        if (r16 <= 1) goto L60;
        AnchorV4KolEvaluationMeta r17 = this.c;
        Integer r1 = null;
        if (r17 == null) goto L33;
        AnchorV4KolEvaluationBusinessMeta r18 = r17.getBusinessMeta();
        if (r18 == null) goto L33;
        String r19 = r18.getKolVideoListSchema();
    L34:
        if (r19 == null) goto L60;
        AnchorV4KolEvaluationMeta r20 = this.c;
        if (r20 == null) goto L43;
        AnchorV4KolEvaluationBusinessMeta r21 = r20.getBusinessMeta();
        if (r21 == null) goto L43;
        String r22 = r21.getKolVideoListSchema();
        if (r22 == null) goto L43;
        JSONObject r23 = k.w(UriProtector.getQueryParameter(UriProtector.parse(r22), "tracker"));
        if (r23 == null) goto L43;
    L44:
        AnchorV4KolEvaluationMeta r3 = this.c;
        if (r3 == null) goto L49;
        AnchorV4KolEvaluationTrackMeta r4 = r3.getTrackMeta();
        if (r4 == null) goto L49;
        r1 = Integer.valueOf(r4.getKolAllVideoCnt());
    L49:
        r23.put("kol_all_video_cnt", k.f(r1));
        Iterator r5 = this.b.getEventParams().entrySet().iterator();
    L51:
        if (r5.hasNext() == false) goto L53;
        Map.Entry r6 = (Map.Entry) r5.next();
        r23.put((String) r6.getKey(), r6.getValue());
        goto L51
    L53:
        AnchorV4KolEvaluationMeta r7 = this.c;
        if (r7 == null) goto L62;
        AnchorV4KolEvaluationBusinessMeta r24 = r7.getBusinessMeta();
        if (r24 == null) goto L62;
        String r25 = r24.getKolVideoListSchema();
        if (r25 == null) goto L62;
        p r26 = p.a;
        Context r27 = this.a;
        int r28 = p0.a;
        r26.openSchema(r27, p0.d(r25, "tracker", r23.toString()));
    L62:
        String r29 = new BtmItemBuilder("a1.b8094.c28779.d502730", Boolean.TRUE).withView(r8).createBtmId();
        LinkedHashMap r30 = new LinkedHashMap();
        AnchorV4KolEvaluationMeta r110 = this.c;
        if (r110 == null) goto L69;
        AnchorV4KolEvaluationTrackMeta r111 = r110.getTrackMeta();
        if (r111 == null) goto L69;
        String r112 = r111.getContentSource();
        if (r112 == null) goto L69;
        r30.put("content_source", r112);
        r30.put("btm_id", r29);
    L69:
        int r31 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r32 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r32 == null) goto L77;
        r32.c = r30;
        AnchorV4TrackerImpl.b(r32, "goods_video_entrance_click", false, null, false, null, 30);
        return;
    L77:
        return;
    L43:
        r23 = new JSONObject();
    L33:
        r19 = null;
    L60:
        if (r16 <= 0) goto L62;
        a(0);
    L25:
        r16 = 0;
        goto L27
    L76:
        return;
    }

    public a(Context r2, AnchorV4VM r3, AnchorV4KolEvaluationMeta r4, AnchorV4KolEvaluationDisplay r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
