package com.bytedance.android.shopping.new_cart.eventcenter.event;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.view.BtmViewUtils;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfOpenHalfHybridView extends com.bytedance.kmp.ec.yata.event.common.a {
    public static final /* synthetic */ int h = 0;
    public final AtomicBoolean a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final CartObjectContainer g;

    public static final class a {
    }

    static {
    }

    public SelfOpenHalfHybridView(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.g = r2;
        this.a = new AtomicBoolean(false);
        this.b = LazyKt.lazy(new SelfOpenHalfHybridView$cartPopupLayerComponent$2(this));
        this.c = LazyKt.lazy(new SelfOpenHalfHybridView$cartViewModel$2(this));
        this.d = LazyKt.lazy(new SelfOpenHalfHybridView$footerComponent$2(this));
        this.e = LazyKt.lazy(new SelfOpenHalfHybridView$splitMode$2(this));
        this.f = LazyKt.lazy(new SelfOpenHalfHybridView$screenWidth$2(this));
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r20, Function1 r21) {
        Intrinsics.checkNotNullParameter(r20, "input");
        Intrinsics.checkNotNullParameter(r21, "chainNextCallback");
        Map r3 = r20.q();
        if (r3 == null) goto L5;
        Object r6 = r3.get("schema");
    L7:
        if ((r6 instanceof String) == true) goto L9;
        r6 = null;
    L9:
        String r7 = (String) r6;
        if (TextUtils.isEmpty(r7) == false) goto L13;
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r21.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is null", null, null, 57));
        bg3.a r2 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g((CartViewModel) this.c.getValue(), "OpenHybridPopupView", "schema is null", MapsKt.emptyMap());
        return;
    L13:
        bg3.a r8 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c((CartViewModel) this.c.getValue(), "OpenHybridPopupView", new p(this), null);
        int r9 = com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.c.a;
        if (r7 != null) goto L16;
    L19:
        boolean r10 = true;
    L20:
        String r11 = "";
        if (r10 == false) goto L23;
        Map r12 = MapsKt.emptyMap();
    L31:
        if (r3 == null) goto L33;
        Object r13 = r3.get("popup_code");
    L35:
        if ((r13 instanceof String) == true) goto L37;
        r13 = null;
    L37:
        String r14 = (String) r13;
        if (r3 == null) goto L40;
        Object r15 = r3.get("should_below_footer");
    L42:
        if ((r15 instanceof Boolean) == true) goto L44;
        r15 = null;
    L44:
        Boolean r16 = (Boolean) r15;
        if (r16 == null) goto L47;
        boolean r17 = r16.booleanValue();
    L48:
        String r18 = (String) r12.get("height_percent");
        if (r18 == null) goto L53;
        Integer r19 = StringsKt.toIntOrNull(r18);
        if (r19 == null) goto L53;
        int r110 = r19.intValue();
    L54:
        int r111 = ((AndroidYaTaInstance) this.g.e.d.invoke()).s.e();
        int r4 = (int) (((double) (r110 * r111)) * 0.01d);
        com.bytedance.android.shopping.new_cart.components.f r5 = (com.bytedance.android.shopping.new_cart.components.f) this.d.getValue();
        if (r5 == null) goto L57;
        int r22 = r5.n();
    L58:
        int r23 = r4 - r22;
        CartParams r24 = this.g.e.c;
        if (r24 == null) goto L63;
        HashMap<String, String> r25 = r24.getSchemaParams();
        if (r25 == null) goto L63;
        String r26 = r25.get("bottom_offset");
    L64:
        int r27 = r23 - com.bytedance.android.shopping.extensions.k.r(r26, 0);
        if (r3 == null) goto L67;
        Object r28 = r3.get("btm");
    L69:
        if ((r28 instanceof String) == true) goto L71;
        r28 = null;
    L71:
        String r29 = (String) r28;
        if (r29 == null) goto L75;
        r11 = r29;
    L75:
        PageFinder r30 = this.g.e.j;
        if (r30 == null) goto L79;
        BtmSDK.INSTANCE.createJumpSourceBtmToken(r11, r30, null);
    L79:
        if (this.a.compareAndSet(false, true) == false) goto L142;
        com.bytedance.android.shopping.new_cart.components.l r31 = (com.bytedance.android.shopping.new_cart.components.l) this.b.getValue();
        if (r31 == null) goto L136;
        String r32 = (String) r12.get("register_btm");
        FrameLayout r112 = r31.d;
        if ((r112 instanceof View) == true) goto L85;
        r112 = null;
    L85:
        if (r112 == null) goto L94;
        if (r32 != null) goto L88;
    L91:
        boolean r113 = true;
    L92:
        if (r113 == true) goto L94;
        String r114 = BtmViewUtils.a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.k(r112, r32, null);
        goto L94
    L88:
        if (r32.length() == 0) goto L91;
        r113 = false;
    L94:
        if (r17 == true) goto L112;
        FrameLayout r115 = r31.d;
        if (r115 == null) goto L98;
        ViewParent r116 = r115.getParent();
    L100:
        if ((r116 instanceof ViewGroup) == true) goto L102;
        r116 = null;
    L102:
        ViewGroup r117 = (ViewGroup) r116;
        if (r117 == null) goto L105;
        Integer r118 = Integer.valueOf(r117.indexOfChild(r31.d));
    L106:
        if (r118 == null) goto L110;
        int r119 = r118.intValue();
        if (r118.intValue() == (-1)) goto L110;
        r117.removeViewAt(r119);
    L110:
        if (r117 == null) goto L112;
        r117.addView(r31.d);
        goto L112
    L105:
        r118 = null;
        goto L106
    L98:
        r116 = null;
    L112:
        FrameLayout r120 = r31.d;
        if (r120 == null) goto L124;
        r120.setVisibility(0);
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if ((r121 instanceof ViewGroup.MarginLayoutParams) == true) goto L117;
        r121 = null;
    L117:
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        if (r122 == null) goto L124;
        com.bytedance.android.shopping.new_cart.components.f r123 = (com.bytedance.android.shopping.new_cart.components.f) r31.c.getValue();
        if (r123 == null) goto L122;
        int r124 = r123.n();
    L123:
        r122.bottomMargin = r124;
        goto L124
    L122:
        r124 = com.bytedance.android.shopping.extensions.b.b(64);
    L124:
        FrameLayout r125 = r31.d;
        if ((r125 instanceof View) == true) goto L127;
        r125 = null;
    L127:
        if (r125 == null) goto L136;
        if (r32 != null) goto L130;
    L133:
        boolean r33 = true;
    L134:
        if (r33 == true) goto L136;
        String r34 = BtmViewUtils.a;
        BtmViewUtils.c(r125);
        goto L136
    L130:
        if (r32.length() == 0) goto L133;
        r33 = false;
    L136:
        Boolean r35 = Boolean.TRUE;
        Boolean r36 = Boolean.FALSE;
        il3.a r37 = new il3.a(r14, r14, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("schema", String.valueOf(r7)), TuplesKt.to("is_hybrid", r35), TuplesKt.to("type", "popup"), TuplesKt.to("action_type", "bottom"), TuplesKt.to("enable_pull_up", r36), TuplesKt.to("height", Integer.valueOf(r27)), TuplesKt.to("mask_color", 1711276032), TuplesKt.to("has_mask", r35), TuplesKt.to("allow_close_by_touch_mask", r35), TuplesKt.to("hide_able", r35), TuplesKt.to("disable_drag_down", r35), TuplesKt.to("render_safe_area", r36), TuplesKt.to("split_mode", Boolean.valueOf(((Boolean) this.e.getValue()).booleanValue())), TuplesKt.to("ec_split_screen_width", Integer.valueOf(((Number) this.f.getValue()).intValue())), TuplesKt.to("ec_split_screen_height", Integer.valueOf(r111))}));
        com.bytedance.android.shopping.new_cart.components.l r38 = (com.bytedance.android.shopping.new_cart.components.l) this.b.getValue();
        if (r38 == null) goto L141;
        PopupLayer r39 = r38.n();
        if (r39 == null) goto L141;
        r39.g(r37, new SelfOpenHalfHybridView$onExecuteAsync$2(this, r20));
    L141:
        int r40 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r21.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L142:
        com.bytedance.android.shopping.new_cart.components.l r41 = (com.bytedance.android.shopping.new_cart.components.l) this.b.getValue();
        if (r41 == null) goto L147;
        PopupLayer r42 = r41.n();
        if (r42 == null) goto L147;
        r42.h(r14);
    L147:
        com.bytedance.android.shopping.new_cart.components.l r43 = (com.bytedance.android.shopping.new_cart.components.l) this.b.getValue();
        if (r43 == null) goto L150;
        r43.o();
    L150:
        int r44 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r21.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L67:
        r28 = null;
    L63:
        r26 = null;
        goto L64
    L57:
        r22 = 0;
    L53:
        r110 = 73;
        goto L54
    L47:
        r17 = false;
        goto L48
    L40:
        r15 = null;
        goto L42
    L33:
        r13 = null;
        goto L35
    L23:
        Intrinsics.checkNotNullParameter(r7, "$this$toUri");
        Uri r45 = UriProtector.parse(r7);
        Set r126 = UriProtector.getQueryParameterNames(r45);
        LinkedHashMap r127 = new LinkedHashMap();
        Iterator r128 = r126.iterator();
    L25:
        if (r128.hasNext() == false) goto L30;
        String r129 = (String) r128.next();
        String r130 = UriProtector.getQueryParameter(r45, r129);
        if (r130 != null) goto L29;
        r130 = "";
    L29:
        r127.put(r129, r130);
        goto L25
    L30:
        r12 = MapsKt.toMap(r127);
        goto L31
    L16:
        if (r7.length() == 0) goto L19;
        r10 = false;
        goto L20
    L5:
        r6 = null;
        goto L7
    }
}
