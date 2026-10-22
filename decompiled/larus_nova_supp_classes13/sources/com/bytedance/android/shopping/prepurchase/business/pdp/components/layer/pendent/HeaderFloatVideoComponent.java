package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import vg3.c0;
import vg3.d0;
import vg3.r;
import vg3.t;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeaderFloatVideoComponent extends b0 {
    public static final /* synthetic */ int q = 0;
    public boolean i;
    public v j;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.o k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final a o;
    public int[] p;

    public static final class a implements fj.b {
        public a() {
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.l.class, w.class, t.class, d0.class, vg3.b0.class, c0.class, r.class});
    }

    public final t d2() {
        return (t) N1(t.class);
    }

    public final c0 e2() {
        return (c0) N1(c0.class);
    }

    public HeaderFloatVideoComponent() {
        this.i = true;
        this.o = new a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        Z1(d0.class, new HeaderFloatVideoComponent$onAttach$1(this, null));
        Z1(vg3.l.class, new HeaderFloatVideoComponent$onAttach$2(this, null));
        Z1(vg3.b0.class, new HeaderFloatVideoComponent$onAttach$3(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        int r0 = ECSdk.a;
        fj.c r1 = (fj.c) ECSdk.a(fj.c.class);
        if (r1 == null) goto L5;
        r1.a(this.o);
    L5:
        vg3.b0 r2 = (vg3.b0) N1(vg3.b0.class);
        if (r2 == null) goto L9;
        r2.S0(null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1] */
    public static void c2(final HeaderFloatVideoComponent r9) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r0 = r9.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L75;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r3 = r9.k;
        if (r3 == null) goto L33;
        int r4 = com.bytedance.android.shopping.anchorv4.video.float.e.a;
        if (r4 != 1) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L22;
    L23:
        if (r4 != 1) goto L25;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == false) goto L33;
        if (r3.c() == true) goto L33;
    L32:
        r1 = true;
        goto L33
    L25:
        if (r4 == 2) goto L28;
        r6 = false;
        goto L29
    L22:
        if (r3.c() == true) goto L32;
    L16:
        if (r4 == 3) goto L19;
        r5 = false;
    L33:
        if (r1 == false) goto L76;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r7 = r9.k;
        x73.c r8 = null;
        if (r7 == null) goto L37;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r10 = r7.getVideoModel();
    L38:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r11 = r9.k;
        if (r11 == null) goto L41;
        x73.c r12 = r11.getSharePlayer();
    L42:
        if (r10 == null) goto L77;
        if (r12 == null) goto L78;
        vg3.b0 r13 = (vg3.b0) r9.N1(vg3.b0.class);
        if (r13 == 0) goto L52;
        ?? r14 = new HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1(r9);
        LinkedHashMap r15 = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r16 = r9.k;
        if (r16 == null) goto L51;
        Map<String, Object> r17 = r16.d();
        if (r17 == null) goto L51;
        r15.putAll(r17);
    L51:
        Unit r18 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.l r19 = r13.m0(r10, r12, r14, null, r15);
    L53:
        if (r19 == null) goto L55;
        vg3.b0 r20 = (vg3.b0) r9.N1(vg3.b0.class);
        if (r20 == null) goto L64;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.i.a r21 = r20.g1(r19);
    L65:
        r9.j = r21;
        if (r21 == null) goto L68;
        return;
    L68:
        if ((r12 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) == false) goto L71;
        r8 = r12;
    L71:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c r22 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) r8;
        if (r22 == null) goto L82;
        r22.k(true);
        return;
    L82:
        return;
    L64:
        r21 = null;
        goto L65
    L55:
        if ((r12 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) == false) goto L58;
        r8 = r12;
    L58:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c r23 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.c) r8;
        if (r23 == null) goto L79;
        r23.k(true);
        return;
    L79:
        return;
    L52:
        r19 = null;
        goto L53
    L78:
        return;
    L77:
        return;
    L41:
        r12 = null;
        goto L42
    L37:
        r10 = null;
        goto L38
    L76:
        return;
    L75:
        return;
    L5:
        if (r0.isPlaying() != true) goto L8;
        r2 = true;
        goto L9
    }

    public static final void b2(HeaderFloatVideoComponent r8, boolean r9) {
        r8.getClass();
        w r0 = (w) r8.N1(w.class);
        if (r0 == null) goto L18;
        ProductDetailEventService.b r1 = r0.m();
        if (r1 == null) goto L19;
        LinkedHashMap r2 = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.o r10 = r8.k;
        if (r10 == null) goto L11;
        Map<String, Object> r11 = r10.d();
        if (r11 == null) goto L11;
        r2.putAll(r11);
    L11:
        if (r9 == false) goto L13;
        String r12 = FreqActions.ACTION_CLOSE;
    L14:
        r2.put("click_type", r12);
        Unit r13 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r3 = r1.d(r2);
        if (r3 == null) goto L20;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r3, "main_video_window_click", false, null, null, 14);
        return;
    L20:
        return;
    L13:
        r12 = "blank";
        goto L14
    L19:
        return;
    }
}
