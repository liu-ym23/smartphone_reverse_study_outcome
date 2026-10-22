package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentExtras;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentLogParams;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.comment.view.AnchorV3CommentActivity;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.commentv3.audio.i;
import com.bytedance.android.shopping.commentv3.audio.j;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.d;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vg3.e;
import vg3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class VirtualCommentComponent extends m implements g, i {
    public String m;
    public String n;
    public final d<Boolean> o;
    public final Lazy p;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{e.class, vg3.a.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        Map<String, WeakReference<i>> r0 = j.a;
        j.a(this.n, this);
        this.n = null;
        super.U1();
    }

    @Override // vg3.g
    public final boolean W0() {
        FragmentActivity r0 = (FragmentActivity) this.p.getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.o.a(), Boolean.TRUE) == false) goto L9;
        int r1 = com.bytedance.android.shopping.anchorv3.commentv2.a.a;
        com.bytedance.android.shopping.anchorv3.commentv2.a.a(O1().getContainerAbility().g7(), r0);
        Map<String, WeakReference<i>> r2 = j.a;
        j.a(this.n, this);
        this.n = null;
        this.o.g(Boolean.FALSE);
        return true;
    L9:
        return false;
    }

    public VirtualCommentComponent() {
        this.m = "";
        this.o = new d();
        this.p = LazyKt.lazy(new VirtualCommentComponent$ctx$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        if (O1().getContainerAbility().g7().findFragmentByTag("PRODUCT_COMMENT") == null) goto L5;
        boolean r0 = true;
    L6:
        this.o.g(Boolean.valueOf(r0));
        AbsComponent.Y1(this, g.class, this, false, 12);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.i
    public final com.bytedance.android.shopping.anchorv4.video.a p1(Function0 r3) {
        Intrinsics.checkNotNullParameter(r3, "stopAudio");
        vg3.a r0 = (vg3.a) N1(vg3.a.class);
        if (r0 == null) goto L12;
        AnchorV4PlayerStateManager r1 = r0.e();
        if (r1 == null) goto L14;
        com.bytedance.android.shopping.anchorv4.video.a r2 = new com.bytedance.android.shopping.anchorv4.video.a(r1, r3);
        if (r2.j == true) goto L11;
        r2.j = true;
        r2.k.c(r2);
    L11:
        return r2;
    L14:
        return null;
    L12:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        FrameLayout r4 = new FrameLayout(r2.getContext());
        r4.setId(2131362765);
        return r4;
    }

    @Override // vg3.g
    public final void Z(StatTagItem r41, int r42, Integer r43, Map<String, ? extends Object> r44) {
        Intrinsics.checkNotNullParameter(r41, "tagItem");
        String r4 = com.bytedance.android.shopping.monitor.d.c("ec_anchor_v3_comment_duration");
        this.m = r4;
        com.bytedance.android.shopping.monitor.d r5 = com.bytedance.android.shopping.monitor.d.f(r4);
        if (r42 == 0) goto L7;
        if (r42 == 1) goto L6;
        String r6 = "show";
    L8:
        r5.i("type", r6);
        if (g2().getNativeParams().getFullMode() == false) goto L12;
        String r7 = "full_screen";
    L15:
        com.bytedance.android.shopping.monitor.d r8 = com.bytedance.android.shopping.monitor.d.f(this.m);
        r8.i("scene", r7);
        r8.i("data_type", String.valueOf(k.g(r43, 0)));
        boolean r12 = g2().getNativeParams().getFullMode();
        if (r12 == true) goto L18;
        com.bytedance.android.shopping.monitor.d r9 = com.bytedance.android.shopping.monitor.d.f(this.m);
        int r10 = com.bytedance.android.shopping.anchorv4.experiment.a.a;
        r9.i("tech_version", "anchor_v4");
    L18:
        com.bytedance.android.shopping.monitor.d.f(this.m).a("duration");
        CommonMeta r11 = O1().d().getData().a().a();
        if (r11 == null) goto L22;
        r11.setCommentMonitorName(this.m);
    L22:
        if (r44 == null) goto L28;
        String r16 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r44, "top_comment_ids", "");
        if (r16 == null) goto L28;
        List r13 = StringsKt.split$default(r16, new String[]{","}, false, 0, 6, null);
        if (r13 == null) goto L28;
        List r17 = CollectionsKt.toMutableList(r13);
    L29:
        if (r44 == null) goto L31;
        String r18 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r44, "top_comment_types", null);
    L32:
        if (r44 == null) goto L34;
        String r19 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r44, "page_title", null);
    L35:
        if (r44 == null) goto L37;
        String r14 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r44, "comment_module", null);
    L38:
        if (r42 != 0) goto L47;
        Map r15 = O1().e().r().a.u0;
        if (r15 == null) goto L42;
        Object r20 = r15.get("comment_preload_data");
    L44:
        if ((r20 instanceof String) == true) goto L46;
        r20 = null;
    L46:
        String r24 = (String) r20;
    L48:
        if (r11 != null) goto L50;
    L52:
        if (r11 != null) goto L54;
    L57:
        String r110 = null;
    L58:
        if (r11 == null) goto L60;
        String r21 = r11.getSearchId();
    L61:
        if (r11 == null) goto L63;
        String r22 = r11.getProductId();
    L64:
        if (r11 != null) goto L66;
    L68:
        boolean r23 = false;
    L69:
        if (r11 == null) goto L71;
        String r111 = r11.getShopId();
    L72:
        String r25 = g2().getNativeParams().getUserId();
        if (r11 == null) goto L75;
        String r26 = r11.getAuthorId();
    L76:
        if (r11 == null) goto L78;
        String r27 = r11.getCommentAuthorId();
    L80:
        if (r11 == null) goto L82;
        ECAdLogExtra r28 = r11.getAdLogExtra();
    L83:
        if (r11 == null) goto L85;
        String r29 = r11.getV3EventsAdditions();
    L86:
        if (r11 == null) goto L88;
        String r210 = r11.getEntranceInfo();
    L89:
        ECAnchorV3ExtraData r30 = g2().getNativeParams().getAnchorV3ExtraData();
        if (r30 == null) goto L92;
        r30.setPromotionLogId(O1().d().getData().d());
        Unit r112 = Unit.INSTANCE;
        ECAnchorV3ExtraData r31 = r30;
    L93:
        if (r11 == null) goto L95;
        String r32 = r11.getSourcePage();
    L96:
        if (r11 == null) goto L98;
        String r33 = r11.getLabelName();
    L99:
        CommentLogParams r113 = new CommentLogParams("product_detail", r28, r29, r210, r31, r32, r33);
        if (r11 == null) goto L102;
        String r114 = r11.getCommentMonitorName();
    L103:
        CommentExtras r34 = new CommentExtras(r114, r7);
        Map<String, Object> r211 = O1().a().u1();
        int r212 = k.g(r43, 0);
        if (r11 == null) goto L107;
        Long r35 = r11.getDiscountMinPrice();
        if (r35 == null) goto L107;
    L109:
        Long r36 = r35;
    L111:
        String r38 = r14;
        CommentParams r37 = new CommentParams(r23, r22, r27, r25, r26, r111, r21, r110, r113, r34, r211, r17, r18, r19, false, 0, r212, null, r44, r24, r36, null, null, null, g2().getSessionId(), 14860288, null);
        r37.setEnterClickTagItem(r41);
        if (r12 == true) goto L115;
        r37.setBtmId(BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c68372.d00451", Boolean.FALSE).withBtmPage(r37).build()));
    L115:
        if ((!Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.FALSE)) == true) goto L117;
    L127:
        int r1 = AnchorV3CommentActivity.l;
        AnchorV3CommentActivity.a.a((FragmentActivity) this.p.getValue(), r37);
    L128:
        String r2 = o53.b.a;
        if (r43 == null) goto L131;
        int r115 = r43.intValue();
    L132:
        o53.b.b(r42, r115, r38);
        this.o.g(Boolean.TRUE);
        return;
    L131:
        r115 = 0;
        goto L132
    L117:
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.a == true) goto L127;
        String r3 = r37.getPdpSessionId();
        if (r3 == null) goto L122;
        this.n = r3;
        Map<String, WeakReference<i>> r39 = j.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(this, "provider");
        j.a.put(r3, new WeakReference(this));
    L122:
        int r40 = com.bytedance.android.shopping.anchorv3.commentv2.a.a;
        e r45 = (e) N1(e.class);
        if (r45 == null) goto L125;
        int r116 = r45.d1();
    L126:
        r37.setMarginBottom(r116);
        Unit r46 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv3.commentv2.a.b(2131362765, r37, O1().getContainerAbility().g7(), r12, (FragmentActivity) this.p.getValue());
        goto L128
    L125:
        r116 = 0;
    L107:
        if (r11 == null) goto L110;
        r35 = r11.getProductMinPrice();
        goto L109
    L110:
        r36 = null;
        goto L111
    L102:
        r114 = null;
        goto L103
    L98:
        r33 = null;
        goto L99
    L95:
        r32 = null;
        goto L96
    L92:
        r31 = null;
        goto L93
    L88:
        r210 = null;
        goto L89
    L85:
        r29 = null;
        goto L86
    L82:
        r28 = null;
        goto L83
    L78:
        r27 = null;
        goto L80
    L75:
        r26 = null;
        goto L76
    L71:
        r111 = null;
        goto L72
    L66:
        if (r11.isLuban() != true) goto L68;
        r23 = true;
        goto L69
    L63:
        r22 = null;
        goto L64
    L60:
        r21 = null;
        goto L61
    L54:
        if (r11.getSupermarketType() != 2) goto L57;
        String r47 = "supermarket_retail";
    L56:
        r110 = r47;
        goto L58
    L50:
        if (r11.getSupermarketType() != 1) goto L52;
        r47 = "supermarket_pop";
        goto L56
    L42:
        r20 = null;
        goto L44
    L47:
        r24 = null;
        goto L48
    L37:
        r14 = null;
        goto L38
    L34:
        r19 = null;
        goto L35
    L31:
        r18 = null;
    L28:
        r17 = null;
        goto L29
    L12:
        if (g2().getNativeParams().getFromLive() != true) goto L14;
        r7 = "half_screen_live";
        goto L15
    L14:
        r7 = "half_screen_feed";
        goto L15
    L6:
        r6 = "shop";
        goto L8
    L7:
        r6 = "goods";
        goto L8
    }
}
