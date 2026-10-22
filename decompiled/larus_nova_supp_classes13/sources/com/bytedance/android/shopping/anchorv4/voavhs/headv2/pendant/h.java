package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.anchorv4.components.TopGuideGaussComponent;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.d0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends FrameLayout implements o<List<? extends HeaderPendantModel>>, p {
    public final Map<String, f> a;
    public final Map<String, e> b;
    public final List<b<?>> c;
    public a d;
    public final s e;

    public static final class a extends q {
        public final /* synthetic */ h e;
        public final /* synthetic */ List f;

        public final void c() {
            this.e.b(this.f);
        }

        public a(h r1, List r2) {
            this.e = r1;
            this.f = r2;
            super(3);
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(float r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(int r1, ImageInfo r2, boolean r3, int r4) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(int r1, Boolean r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(String r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(int r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).e();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).onDestroy();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).o();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(boolean r2) {
        Iterator r3 = ((ArrayList) this.c).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).o();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(boolean r3) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).a(r3);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.h] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final void b(List<HeaderPendantModel> r22) {
        List r0 = r22;
        a r2 = this.d;
        if (r2 == null) goto L5;
        ((q) r2).b = true;
    L5:
        this.d = null;
        if (this.e.rR().n() == false) goto L8;
    L34:
        removeAllViews();
        ((ArrayList) this.c).clear();
        if (r0 == null) goto L164;
        Iterator r3 = r0.iterator();
    L38:
        if (r3.hasNext() == false) goto L193;
        HeaderPendantModel r1 = (HeaderPendantModel) r3.next();
        if (r1.getNative() != null) goto L41;
        if (r1.getSlice() != null) goto L60;
        if (r1.getLynx() == null) goto L38;
        e r4 = (e) ((LinkedHashMap) this.b).get(r1.getId());
        if (r4 != null) goto L103;
        r4 = new e(getContext(), this.e, r1);
        if (r1.getId() == null) goto L103;
        this.b.put(r1.getId(), r4);
    L103:
        ((ArrayList) this.c).add(r4);
        if (r1.getConfig() == null) goto L106;
        r1.getLynx().setConfig(r1.getConfig());
    L106:
        HeaderPendantLynx r5 = r1.getLynx();
        r4.a = r5;
        if (r5 == null) goto L156;
        String r6 = r5.getLynxUrl();
        if (r6 == null) goto L156;
        HeaderPendantLynx r7 = r4.a;
        if (r7 == null) goto L116;
        JsonObject r8 = r7.getLynxData();
        if (r8 == null) goto L116;
        JSONObject r9 = k.b(r8);
        r9.put("identifier", AnchorV4DataManager.d);
    L165:
        Uri.Builder r10 = UriProtector.parse(r6).buildUpon();     // Catch: Exception -> L140
        String r11 = AnchorV4DataManager.d;     // Catch: Exception -> L140
        if (r11 == null) goto L120;
        r10.appendQueryParameter("identifier", r11);     // Catch: Exception -> L140
    L120:
        Lazy r12 = TopGuideGaussComponent.e;     // Catch: Exception -> L140
        String r13 = "1";
        if (TopGuideGaussComponent.a.a() == false) goto L124;
        String r14 = "1";
    L125:
        r10.appendQueryParameter("gauss", r14);     // Catch: Exception -> L140
        if (r4.f.p3() == false) goto L128;
        String r15 = "0";
    L129:
        r10.appendQueryParameter("video_state", r15);     // Catch: Exception -> L140
        if (r4.f.vn() == true) goto L133;
        r13 = "0";
    L133:
        r10.appendQueryParameter("now_index_video_status", r13);     // Catch: Exception -> L140
        r10.appendQueryParameter("page_index", String.valueOf(r4.f.getCurrentPosition()));     // Catch: Exception -> L140
        HeaderPendantLynx r16 = r4.a;     // Catch: Exception -> L140
        if (r16 != null) goto L136;
    L138:
        String r17 = r10.build().toString();     // Catch: Exception -> L140
    L142:
        String r18 = r17;
        l r19 = r4.b;
        if (r19 != null) goto L145;
        LifecycleOwner r110 = r4.f.rR().getLifecycleOwner();
        if (r110 == null) goto L153;
        Lifecycle r111 = r110.getLifecycle();
    L154:
        Context r20 = r4.e;
        JSONObject r21 = new JSONObject();
        r21.put("module_param", r9);
        Unit r23 = Unit.INSTANCE;
        l r24 = ECLiveHybridUtil.b(r20, r18, com.bytedance.android.shopping.hybrid.a.b(r21), null, r4, null, r111, false, r110, null, true, 1448);
        r4.b = r24;
        w.a.e(w.b, r24, r4.e, Boolean.valueOf(r4.f.rR().d()), 8);
    L155:
        r4.i();
        r4.d = false;
        goto L156
    L153:
        r111 = null;
        goto L154
    L145:
        if (com.bytedance.android.shopping.extensions.k.c(r18) == true) goto L147;
    L149:
        JSONObject r25 = new JSONObject();
        r25.put("module_param", r9);
        Unit r26 = Unit.INSTANCE;
        r19.renderTemplate(r18, com.bytedance.android.shopping.hybrid.a.b(r25));
        goto L155
    L147:
        if (r4.d == true) goto L149;
        JSONObject r27 = new JSONObject();
        r27.put("module_param", r9);
        Unit r28 = Unit.INSTANCE;
        r19.updateData(com.bytedance.android.shopping.hybrid.a.b(r27));
        goto L155
    L136:
        if (r16.getLynxData() == null) goto L138;
        String r29 = UUID.randomUUID().toString();     // Catch: Exception -> L140
        r10.appendQueryParameter("mega_object_id", r29);     // Catch: Exception -> L140
        HashMap r30 = j.a;     // Catch: Exception -> L140
        j.h(r29, r9);     // Catch: Exception -> L140
        goto L138
    L128:
        r15 = "1";
        goto L129
    L124:
        r14 = "0";
    L140:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r17 = "";
    L116:
        r9 = null;
    L156:
        d r31 = r4.c;
        r31.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (r31.getChildCount() != 0) goto L163;
        l r32 = r4.b;
        if (r32 == null) goto L163;
        View r33 = r32.getHybridView();
        if (r33 == null) goto L163;
        r31.addView(r33, -1, -1);
    L163:
        wg.a.a(r31);
        addView(r31);
        goto L38
    L60:
        i r34 = new i(getContext(), this.e, r1);
        ((ArrayList) this.c).add(r34);
        HeaderSliceModel r35 = r1.getSlice();
        r34.a = r35;
        StringBuilder r36 = new StringBuilder("head-pendant-");
        if (r35 == null) goto L63;
        String r37 = r35.getSliceId();
    L64:
        r36.append(r37);
        String r38 = r36.toString();
        if (r35 == null) goto L67;
        com.bytedance.android.ecom.arch.slice.g r39 = r35.getGeckoSlice();
    L68:
        if (r39 == null) goto L74;
        c0 r40 = r34.d.yd().b(r38, r35.getGeckoSlice());
        if (r40 == null) goto L82;
        r34.c = r40.a;
        if (r40.b == false) goto L82;
        r34.b();
    L82:
        SlcTemplateViewHelper r41 = r34.c;
        if (r41 == null) goto L87;
        SlcTemplateView r42 = r41.b;
        if (r42 == null) goto L87;
    L91:
        if (r42 == null) goto L93;
        r42.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    L94:
        if (r42 == null) goto L38;
        wg.a.a(r42);
        addView(r42);
        goto L38
    L93:
        r42 = null;
    L87:
        r r43 = r34.b;
        if (r43 == null) goto L90;
        r42 = r43.c;
        goto L91
    L90:
        r42 = null;
        goto L91
    L74:
        d0 r44 = r34.d.yd();
        if (r35 == null) goto L77;
        SlcElement r45 = r35.getSliceTemplate();
    L78:
        r r46 = r44.c(r38, r45);
        if (r46 == null) goto L81;
        r34.b = r46;
        r34.b();
        goto L82
    L81:
        r34.b = null;
        goto L82
    L77:
        r45 = null;
        goto L78
    L67:
        r39 = null;
        goto L68
    L63:
        r37 = null;
        goto L64
    L41:
        f r47 = (f) ((LinkedHashMap) this.a).get(r1.getId());
        if (r47 != null) goto L52;
        int r48 = f.b;
        Context r49 = getContext();
        s r50 = this.e;
        Intrinsics.checkNotNullParameter(r49, "context");
        Intrinsics.checkNotNullParameter(r50, "headAbility");
        Intrinsics.checkNotNullParameter(r1, "pendantModel");
        if (Intrinsics.areEqual(r1.getId(), "tab") == false) goto L46;
        r47 = new g(r49, r50, r1);
    L47:
        if (r47 != null) goto L49;
        r47 = null;
        goto L52
    L49:
        if (r1.getId() == null) goto L52;
        this.a.put(r1.getId(), r47);
        goto L52
    L46:
        r47 = null;
    L52:
        if (r47 == null) goto L38;
        ((ArrayList) this.c).add(r47);
        r47.g(r1.getNative());
        Object r51 = ((g) r47).c;
        if (r51 == null) goto L57;
        View r52 = (View) r51;
        wg.a.a(r52);
        addView(r52);
        goto L38
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L193:
        return;
    L164:
        return;
    L8:
        if (PdpPerfOpt.a().c() == false) goto L20;
        if (r0 == null) goto L19;
        ?? r53 = new ArrayList();
        Iterator r54 = r0.iterator();
    L12:
        if (r54.hasNext() == false) goto L21;
        Object r55 = r54.next();
        if (((HeaderPendantModel) r55).getSlice() != null) goto L16;
        boolean r56 = true;
    L17:
        if (r56 == false) goto L12;
        r53.add(r55);
        goto L12
    L16:
        r56 = false;
    L21:
        Lazy r57 = PdpPerfOpt.a;
        if (r53 == 0) goto L32;
        ArrayList r58 = new ArrayList();
        Iterator r59 = ((Iterable) r53).iterator();
    L25:
        if (r59.hasNext() == false) goto L33;
        Object r60 = r59.next();
        if (((HeaderPendantModel) r60).getLynx() != null) goto L29;
        boolean r61 = true;
    L30:
        if (r61 == false) goto L25;
        r58.add(r60);
        goto L25
    L29:
        r61 = false;
    L33:
        PdpPerfOpt.a().c();
        a r62 = new a(this, r0);
        this.e.rR().Z(r62, true);
        Unit r63 = Unit.INSTANCE;
        this.d = r62;
        r0 = r58;
        goto L34
    L32:
        r58 = null;
        goto L33
    L19:
        r53 = 0;
        goto L21
    L20:
        r53 = r0;
        goto L21
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(boolean r3) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).c(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(boolean r3) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).f(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(boolean r3) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).h(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(int r3) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).onPageSelected(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(AnchorV4HeadV2VO r2) {
        Intrinsics.checkNotNullParameter(r2, "headVo");
        Intrinsics.checkNotNullParameter(r2, "headVo");
    }

    public h(Context r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        super(r2);
        this.e = r3;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        r3.eh().x(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(boolean r3, int r4) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).d(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(List<? extends HeaderPendantModel> r1, int r2, Integer r3) {
    }
}
