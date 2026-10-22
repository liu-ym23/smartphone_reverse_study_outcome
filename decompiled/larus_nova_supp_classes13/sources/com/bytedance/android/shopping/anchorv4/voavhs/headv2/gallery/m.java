package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.HashMap;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j {
    public final Set<String> a;
    public l b;
    public Long c;
    public boolean d;
    public final Set<String> e;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n f;
    public final GalleryFromType g;

    public static final class a {
    }

    static {
    }

    public final Map<String, Object> b(int r7) {
        l r0 = this.b;
        Map r1 = null;
        if (r0 == null) goto L7;
        List<com.bytedance.android.ec.model.k> r2 = r0.b;
        if (r2 == null) goto L7;
        com.bytedance.android.ec.model.k r3 = (com.bytedance.android.ec.model.k) CollectionsKt.getOrNull(r2, r7);
    L9:
        if ((r3 instanceof g0) == true) goto L11;
        r3 = null;
    L11:
        g0 r4 = (g0) r3;
        if (r4 == null) goto L16;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r5 = r4.o;
        if (r5 == null) goto L16;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r6 = r5.getPlayInfo();
    L17:
        l r8 = this.b;
        if (r8 == null) goto L31;
        List<c0> r9 = r8.c;
        if (r9 == null) goto L31;
        Iterator<T> r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L27;
        Object r11 = r10.next();
        if (f0.b(r7, (c0) r11) == false) goto L23;
    L28:
        c0 r12 = (c0) r11;
        if (r12 == null) goto L31;
        Integer r13 = Integer.valueOf((r7 - r12.a) + 1);
    L32:
        Pair[] r14 = new Pair[3];
        r14[0] = TuplesKt.to("from_entrance", "big_picture");
        if (r6 == null) goto L35;
        String r15 = r6.j();
    L36:
        if (r15 != null) goto L38;
        r15 = "";
    L38:
        r14[1] = TuplesKt.to("video_id", r15);
        r14[2] = TuplesKt.to("video_position", r13);
        HashMap r16 = MapsKt.hashMapOf(r14);
        if (this.g != GalleryFromType.MoreVideo) goto L46;
        if (r6 == null) goto L52;
        u1 r17 = r6.b();
        if (r17 == null) goto L52;
        com.bytedance.android.ec.model.response.k0 r18 = r17.c();
        if (r18 == null) goto L52;
        r1 = r18.a();
    L52:
        if (r1 == null) goto L54;
        r16.putAll(r1);
    L54:
        return r16;
    L46:
        if (r6 == null) goto L52;
        u1 r19 = r6.b();
        if (r19 == null) goto L52;
        com.bytedance.android.ec.model.response.f0 r20 = r19.a();
        if (r20 == null) goto L52;
        r1 = r20.b();
        goto L52
    L35:
        r15 = null;
        goto L36
    L27:
        r11 = null;
    L31:
        r13 = null;
    L16:
        r6 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final void e(String r7) {
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        d(this, "pdp_module_click", MapsKt.mapOf(TuplesKt.to("tab_name", r7)), null, "a1.b34986.c442582.d324529", 28);
    }

    public final void f(String r7) {
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        d(this, "pdp_module_show", MapsKt.mapOf(TuplesKt.to("tab_name", r7)), null, "a1.b34986.c442582.d324529", 28);
    }

    public final void g(boolean r7) {
        d(this, "pdp_module_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_show", Integer.valueOf(r7 ? 1 : 0))}), null, "a1.b34986.c503191.d90177", 28);
    }

    public m(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r1, GalleryFromType r2) {
        this.f = r1;
        this.g = r2;
        this.a = new LinkedHashSet();
        this.e = new LinkedHashSet();
    }

    public final void h(int r7, boolean r8) {
        Map<String, Object> r2 = b(r7);
        if (r8 == false) goto L5;
        String r9 = FreqActions.ACTION_CLOSE;
    L6:
        r2.put("click_type", r9);
        Unit r10 = Unit.INSTANCE;
        d(this, "pd_sound_icon_click", r2, null, null, 60);
        return;
    L5:
        r9 = "open";
        goto L6
    }

    public final void i(int r7, boolean r8) {
        Map<String, Object> r2 = b(r7);
        if (r8 == false) goto L5;
        String r9 = "auto";
    L6:
        r2.put("entrance_method", r9);
        Object r10 = r2.get("video_id");
        if (r10 == null) goto L9;
        String r11 = r10.toString();
    L10:
        int r12 = !CollectionsKt.contains(this.a, r11) ? 1 : 0;
        if (r11 == null) goto L13;
        this.a.add(r11);
    L13:
        r2.put("is_first", Integer.valueOf(r12));
        Unit r13 = Unit.INSTANCE;
        d(this, "pd_video_play", r2, null, null, 60);
        return;
    L9:
        r11 = null;
        goto L10
    L5:
        r9 = "click_button";
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j
    public final void a(int r7, String r8, String r9) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r2 = this.f;
        if (r2 == null) goto L7;
        CommonMeta r3 = r2.a();
        if (r3 == null) goto L7;
        String r4 = r3.getProductId();
    L8:
        r0[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r4);
        r0[2] = TuplesKt.to("tab_type", "pic_recommend");
        r0[3] = TuplesKt.to("pic_type", Integer.valueOf(r7));
        HashMap r5 = MapsKt.hashMapOf(r0);
        if (r9 == null) goto L11;
        r5.put("view_style", r9);
    L11:
        if (r8 == null) goto L13;
        r5.put("media_type", r8);
    L13:
        Unit r10 = Unit.INSTANCE;
        d(this, "find_similar_tab_show", r5, String.valueOf(r8), "a1.b8094.c86220.d94403", 4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void c(int r7, String r8, String r9) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r2 = this.f;
        if (r2 == null) goto L7;
        CommonMeta r3 = r2.a();
        if (r3 == null) goto L7;
        String r4 = r3.getProductId();
    L8:
        r0[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r4);
        r0[2] = TuplesKt.to("tab_type", "pic_recommend");
        r0[3] = TuplesKt.to("pic_type", Integer.valueOf(r7));
        HashMap r5 = MapsKt.hashMapOf(r0);
        if (r9 == null) goto L11;
        r5.put("view_style", r9);
    L11:
        r5.put("media_type", r8);
        Unit r10 = Unit.INSTANCE;
        d(this, "find_similar_tab_click", r5, null, "a1.b8094.c86220.d94403", 28);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void j(int r10, long r11, boolean r13) {
        if (r11 <= 0) goto L10;
        Map<String, Object> r5 = b(r10);
        r5.put("duration", Long.valueOf(r11));
        if (r13 == false) goto L7;
        String r12 = "1";
    L8:
        r5.put("is_play_over", r12);
        Unit r14 = Unit.INSTANCE;
        d(this, "pd_video_play_time", r5, null, null, 60);
        return;
    L7:
        r12 = "0";
        goto L8
    }

    public static void d(m r12, String r13, Map r14, String r15, String r16, int r17) {
        PageFinder r2 = null;
        if ((r17 & 2) == 0) goto L5;
        Map r1 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r17 & 16) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r17 & 32) == 0) goto L17;
        String r10 = null;
    L18:
        r12.getClass();
        cl.d.a.getClass();
        cl.d r4 = cl.d.a.b();
        if (r4 == null) goto L21;
        r4.f();
    L21:
        if (r8 == null) goto L26;
        String r5 = r13.concat(r8);
        if (r5 == null) goto L26;
    L27:
        if (r3 == false) goto L29;
    L32:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r1 == null) goto L36;
        r6.putAll(r1);
    L36:
        if (r12.g != GalleryFromType.MoreVideo) goto L38;
        String r7 = "pdp_more_video";
    L39:
        r6.put("enter_source", r7);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r9 = r12.f;
        if (r9 == null) goto L46;
        l r0 = r12.b;
        if (r0 == null) goto L44;
        r2 = r0.k;
    L44:
        r9.b(r13, r6, false, true, r8, null, r10, r2);
        return;
    L46:
        return;
    L38:
        r7 = "pdp_head";
        goto L39
    L29:
        if (r12.e.contains(r5) == true) goto L47;
        r12.e.add(r5);
        goto L32
    L47:
        return;
    L26:
        r5 = r13;
        goto L27
    L17:
        r10 = r16;
        goto L18
    L13:
        r8 = r15;
        goto L15
    L9:
        r3 = false;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
