package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.model.response.f0;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements q {
    public final Set<String> a;
    public final s b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    static {
    }

    public final Map<String, Object> b() {
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r0 = this.b.Sf().f(this.b.getCurrentPosition());
        LinkedHashMap r1 = new LinkedHashMap();
        if (r0 == null) goto L10;
        u1 r2 = r0.b();
        if (r2 == null) goto L10;
        f0 r3 = r2.a();
        if (r3 == null) goto L10;
        Map r4 = r3.b();
        if (r4 == null) goto L10;
    L11:
        r1.putAll(r4);
        if (r0 == null) goto L14;
        String r5 = r0.j();
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r1.put("video_id", r5);
        return r1;
    L14:
        r5 = null;
    L10:
        r4 = MapsKt.emptyMap();
        goto L11
    }

    public a(s r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        this.b = r2;
        this.a = new LinkedHashSet();
    }

    public final void c(boolean r11) {
        Pair[] r0 = new Pair[1];
        if (r11 == false) goto L5;
        String r12 = "open";
    L6:
        r0[0] = TuplesKt.to("click_type", r12);
        Map r2 = MapsKt.mutableMapOf(r0);
        AnchorV4HeadV2VO r13 = this.b.K10();
        if (r13 == null) goto L14;
        List<HeaderContentModel> r14 = r13.getCells();
        if (r14 == null) goto L14;
        HeaderContentModel r15 = (HeaderContentModel) CollectionsKt.getOrNull(r14, this.b.getCurrentPosition());
        if (r15 == null) goto L14;
        Map<String, String> r16 = r15.getTrack();
        if (r16 == null) goto L14;
    L15:
        r2.putAll(r16);
        r2.putAll(b());
        Unit r17 = Unit.INSTANCE;
        q.a.a(this, "pd_sound_icon_click", r2, false, null, null, null, null, null, 508);
        return;
    L14:
        r16 = MapsKt.emptyMap();
        goto L15
    L5:
        r12 = FreqActions.ACTION_CLOSE;
        goto L6
    }

    public final void d(boolean r11) {
        Pair[] r0 = new Pair[1];
        if (r11 == false) goto L5;
        String r12 = "open";
    L6:
        r0[0] = TuplesKt.to("icon_status", r12);
        Map r2 = MapsKt.mutableMapOf(r0);
        AnchorV4HeadV2VO r13 = this.b.K10();
        if (r13 == null) goto L14;
        List<HeaderContentModel> r14 = r13.getCells();
        if (r14 == null) goto L14;
        HeaderContentModel r15 = (HeaderContentModel) CollectionsKt.getOrNull(r14, this.b.getCurrentPosition());
        if (r15 == null) goto L14;
        Map<String, String> r16 = r15.getTrack();
        if (r16 == null) goto L14;
    L15:
        r2.putAll(r16);
        r2.putAll(b());
        Unit r17 = Unit.INSTANCE;
        q.a.a(this, "pd_sound_icon_show", r2, false, null, null, null, null, null, 508);
        return;
    L14:
        r16 = MapsKt.emptyMap();
        goto L15
    L5:
        r12 = FreqActions.ACTION_CLOSE;
        goto L6
    }

    public final void e(boolean r11) {
        Pair[] r0 = new Pair[1];
        if (r11 == false) goto L5;
        String r12 = "play";
    L6:
        r0[0] = TuplesKt.to("click_type", r12);
        Map r2 = MapsKt.mutableMapOf(r0);
        AnchorV4HeadV2VO r13 = this.b.K10();
        if (r13 == null) goto L14;
        List<HeaderContentModel> r14 = r13.getCells();
        if (r14 == null) goto L14;
        HeaderContentModel r15 = (HeaderContentModel) CollectionsKt.getOrNull(r14, this.b.getCurrentPosition());
        if (r15 == null) goto L14;
        Map<String, String> r16 = r15.getTrack();
        if (r16 == null) goto L14;
    L15:
        r2.putAll(r16);
        r2.putAll(b());
        Unit r17 = Unit.INSTANCE;
        q.a.a(this, "pd_video_pause_click", r2, false, null, null, null, null, null, 508);
        return;
    L14:
        r16 = MapsKt.emptyMap();
        goto L15
    L5:
        r12 = "pause";
        goto L6
    }

    public final void f(boolean r11) {
        Pair[] r0 = new Pair[1];
        if (r11 == false) goto L5;
        String r12 = "play";
    L6:
        r0[0] = TuplesKt.to("icon_status", r12);
        Map r2 = MapsKt.mutableMapOf(r0);
        AnchorV4HeadV2VO r13 = this.b.K10();
        if (r13 == null) goto L14;
        List<HeaderContentModel> r14 = r13.getCells();
        if (r14 == null) goto L14;
        HeaderContentModel r15 = (HeaderContentModel) CollectionsKt.getOrNull(r14, this.b.getCurrentPosition());
        if (r15 == null) goto L14;
        Map<String, String> r16 = r15.getTrack();
        if (r16 == null) goto L14;
    L15:
        r2.putAll(r16);
        r2.putAll(b());
        Unit r17 = Unit.INSTANCE;
        q.a.a(this, "pd_video_pause_show", r2, false, null, null, null, null, null, 508);
        return;
    L14:
        r16 = MapsKt.emptyMap();
        goto L15
    L5:
        r12 = "pause";
        goto L6
    }

    public final void h(Map<String, ? extends Object> r11) {
        q.a.a(this, "pd_images_tab_show", r11, false, null, null, null, null, null, 508);
    }

    public final void i(RecyclerView r11) {
        Intrinsics.checkNotNullParameter("a1.b8094.c0645.d057069", "btmId");
        q.a.a(this, "show_product_main_picture", null, false, null, r11, "a1.b8094.c0645.d057069", null, null, 406);
    }

    public final void j(String r11) {
        if (r11 == null) goto L4;
    L7:
        Map<String, Object> r2 = b();
        r2.put("from_entrance", r11);
        q.a.a(this, "pd_video_show", r2, false, r11 + "_" + ((LinkedHashMap) r2).get("video_id"), this.b.getRecyclerView(), "a1.b8094.c0645.d057069", null, null, 388);
        return;
    L4:
        if (this.b.a() == false) goto L6;
        r11 = "big_picture";
        goto L7
    L6:
        r11 = "main_picture";
        goto L7
    }

    public final void g(String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r12, "actionType");
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action_type", r12)});
        if (r13 == null) goto L5;
        r3.putAll(r13);
    L5:
        Unit r14 = Unit.INSTANCE;
        q.a.a(this, "pd_images_tab_click", r3, false, null, this.b.getRecyclerView(), "a1.b8094.c0645.d663013", null, null, 412);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.q
    public final void a(String r18, Map<String, ? extends Object> r19, boolean r20, boolean r21, String r22, View r23, String r24, Integer r25, Integer r26) {
        if (r18 != null) goto L5;
        return;
    L5:
        boolean r13 = true;
        if (r25 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        String r15 = null;
        if (r3 == false) goto L43;
        if (r23 == null) goto L78;
        if (r24 != null) goto L16;
        String r4 = "";
    L17:
        if (r24 == null) goto L19;
        r15 = r24 + r22;
    L19:
        c r5 = new c(this, r19, r20);
        if (r4.length() != 0) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == false) goto L25;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L25:
        com.bytedance.android.bst.api.d r2 = new com.bytedance.android.bst.api.d(r23);
        r2.a = r4;
        r2.b = r18;
        r2.c = r15;
        r2.d = "shopping";
        r2.e = -1;
        r2.f = r5;
        if (r25 != null) goto L29;
    L31:
        boolean r6 = false;
    L32:
        if (r6 == false) goto L34;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r2);
        return;
    L34:
        if (r25 != null) goto L37;
    L39:
        r13 = false;
    L40:
        if (r13 == false) goto L80;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r2);
        return;
    L80:
        return;
    L37:
        if (r25.intValue() != 2) goto L39;
    L29:
        if (r25.intValue() != 1) goto L31;
        r6 = true;
        goto L32
    L22:
        r1 = false;
        goto L23
    L16:
        r4 = r24;
        goto L17
    L78:
        return;
    L43:
        LinkedHashMap r7 = new LinkedHashMap();
        AnchorV4HeadV2VO r8 = this.b.K10();
        if (r8 == null) goto L48;
        Map<String, String> r9 = r8.getTrackMeta();
        if (r9 == null) goto L48;
        r7.putAll(r9);
    L48:
        if (r19 == null) goto L51;
        r7.putAll(r19);
    L51:
        if (com.bytedance.android.shopping.extensions.k.c(r24) == false) goto L53;
        r7.put("btm", r24);
    L53:
        if (r19 == null) goto L55;
        Object r10 = r19.get("from_entrance");
    L57:
        if (Intrinsics.areEqual(r10, "big_picture") == false) goto L59;
        r7.put("enter_source", "pdp_head");
    L59:
        this.b.rR().g0(r18, r7, r24, r23, r20, r21, r22);
        if (r26 != null) goto L63;
    L65:
        if (r26 != null) goto L68;
    L71:
        String r11 = null;
    L72:
        if (r11 == null) goto L81;
        if (r22 == null) goto L75;
        String r12 = StringsKt.replace$default(r22, r18, r11, false, 4, null);
    L76:
        this.b.rR().g0(r11, r7, r24, r23, r20, r21, r12);
        return;
    L75:
        r12 = null;
        goto L76
    L81:
        return;
    L68:
        if (r26.intValue() != 2) goto L71;
        String r14 = "pdp_module_click";
    L70:
        r11 = r14;
        goto L72
    L63:
        if (r26.intValue() != 1) goto L65;
        r14 = "pdp_module_show";
        goto L70
    L55:
        r10 = null;
        goto L57
    L8:
        if (r25.intValue() <= 0) goto L10;
        r3 = true;
        goto L11
    }
}
