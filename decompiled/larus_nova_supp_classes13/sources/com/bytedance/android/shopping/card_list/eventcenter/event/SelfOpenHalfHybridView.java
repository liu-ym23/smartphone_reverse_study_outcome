package com.bytedance.android.shopping.card_list.eventcenter.event;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.view.BtmViewUtils;
import com.bytedance.android.shopping.card_list.components.CardListPopupLayerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
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
    public static final /* synthetic */ int i = 0;
    public final AtomicBoolean a;
    public final Lazy b;
    public final String c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final CardListObjectContainer h;

    public static final class a {
    }

    static {
    }

    public SelfOpenHalfHybridView(CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        this.h = r3;
        this.a = new AtomicBoolean(false);
        this.b = LazyKt.lazy(new SelfOpenHalfHybridView$popupLayerComponent$2(this));
        CardPassThroughData r4 = r3.e.a;
        if (r4 == null) goto L5;
        String r5 = r4.getMonitorId();
    L6:
        this.c = r5;
        this.d = LazyKt.lazy(new SelfOpenHalfHybridView$errorMonitor$2(this));
        this.e = LazyKt.lazy(new SelfOpenHalfHybridView$footerComponent$2(this));
        this.f = LazyKt.lazy(new SelfOpenHalfHybridView$splitMode$2(this));
        this.g = LazyKt.lazy(new SelfOpenHalfHybridView$screenWidth$2(this));
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r18, Function1 r19) {
        Intrinsics.checkNotNullParameter(r18, "input");
        Intrinsics.checkNotNullParameter(r19, "chainNextCallback");
        Map r3 = r18.q();
        if (r3 == null) goto L5;
        Object r6 = r3.get("schema");
    L7:
        if ((r6 instanceof String) == true) goto L9;
        r6 = null;
    L9:
        String r7 = (String) r6;
        if (TextUtils.isEmpty(r7) == false) goto L13;
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r19.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is null", null, null, 57));
        return;
    L13:
        int r8 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.a;
        if (r7 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == false) goto L22;
        Map r10 = MapsKt.emptyMap();
    L30:
        if (r3 == null) goto L32;
        Object r11 = r3.get("popup_code");
    L34:
        if ((r11 instanceof String) == true) goto L36;
        r11 = null;
    L36:
        String r12 = (String) r11;
        if (r3 == null) goto L39;
        Object r4 = r3.get("should_below_footer");
    L41:
        if ((r4 instanceof Boolean) == true) goto L43;
        r4 = null;
    L43:
        Boolean r5 = (Boolean) r4;
        if (r5 == null) goto L46;
        boolean r13 = r5.booleanValue();
    L47:
        String r14 = (String) r10.get("height_percent");
        if (r14 == null) goto L52;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L52;
        int r16 = r15.intValue();
    L53:
        int r17 = ((AndroidYaTaInstance) this.h.e.c.invoke()).s.e();
        int r110 = (int) (((double) (r16 * r17)) * 0.01d);
        com.bytedance.android.shopping.card_list.components.i r111 = (com.bytedance.android.shopping.card_list.components.i) this.e.getValue();
        if (r111 == null) goto L56;
        int r112 = r111.g();
    L57:
        int r113 = r110 - r112;
        CardPassThroughData r114 = this.h.e.a;
        if (r114 == null) goto L62;
        HashMap<String, String> r115 = r114.getSchemaParams();
        if (r115 == null) goto L62;
        String r116 = r115.get("bottom_offset");
    L63:
        int r117 = r113 - com.bytedance.android.shopping.extensions.k.r(r116, 0);
        if (this.a.compareAndSet(false, true) == false) goto L112;
        CardListPopupLayerComponent r118 = (CardListPopupLayerComponent) this.b.getValue();
        if (r118 == null) goto L106;
        String r20 = (String) r10.get("register_btm");
        FrameLayout r119 = r118.f;
        if ((r119 instanceof View) == true) goto L70;
        r119 = null;
    L70:
        if (r119 == null) goto L73;
        if (r20 == null) goto L73;
        String r120 = BtmViewUtils.a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.k(r119, r20, null);
    L73:
        if (r13 == true) goto L91;
        FrameLayout r21 = r118.f;
        if (r21 == null) goto L77;
        ViewParent r22 = r21.getParent();
    L79:
        if ((r22 instanceof ViewGroup) == true) goto L81;
        r22 = null;
    L81:
        ViewGroup r23 = (ViewGroup) r22;
        if (r23 == null) goto L84;
        Integer r121 = Integer.valueOf(r23.indexOfChild(r118.f));
    L85:
        if (r121 == null) goto L89;
        int r24 = r121.intValue();
        if (r121.intValue() == (-1)) goto L89;
        r23.removeViewAt(r24);
    L89:
        if (r23 == null) goto L91;
        r23.addView(r118.f);
        goto L91
    L84:
        r121 = null;
        goto L85
    L77:
        r22 = null;
    L91:
        FrameLayout r25 = r118.f;
        if (r25 == null) goto L103;
        r25.setVisibility(0);
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if ((r26 instanceof ViewGroup.MarginLayoutParams) == true) goto L96;
        r26 = null;
    L96:
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r26;
        if (r27 == null) goto L103;
        com.bytedance.android.shopping.card_list.components.i r28 = (com.bytedance.android.shopping.card_list.components.i) r118.e.getValue();
        if (r28 == null) goto L101;
        int r29 = r28.g();
    L102:
        r27.bottomMargin = r29;
        goto L103
    L101:
        r29 = com.bytedance.android.shopping.extensions.b.b(64);
    L103:
        if (r119 == null) goto L106;
        if (r20 == null) goto L106;
        String r30 = BtmViewUtils.a;
        BtmViewUtils.c(r119);
    L106:
        Boolean r31 = Boolean.TRUE;
        Boolean r32 = Boolean.FALSE;
        il3.a r33 = new il3.a(r12, r12, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("schema", String.valueOf(r7)), TuplesKt.to("is_hybrid", r31), TuplesKt.to("type", "popup"), TuplesKt.to("action_type", "bottom"), TuplesKt.to("enable_pull_up", r32), TuplesKt.to("height", Integer.valueOf(r117)), TuplesKt.to("mask_color", 1711276032), TuplesKt.to("has_mask", r31), TuplesKt.to("allow_close_by_touch_mask", r31), TuplesKt.to("hide_able", r31), TuplesKt.to("disable_drag_down", r31), TuplesKt.to("render_safe_area", r32), TuplesKt.to("split_mode", Boolean.valueOf(((Boolean) this.f.getValue()).booleanValue())), TuplesKt.to("ec_split_screen_width", Integer.valueOf(((Number) this.g.getValue()).intValue())), TuplesKt.to("ec_split_screen_height", Integer.valueOf(r17))}));
        CardListPopupLayerComponent r34 = (CardListPopupLayerComponent) this.b.getValue();
        if (r34 == null) goto L111;
        PopupLayer r35 = r34.g();
        if (r35 == null) goto L111;
        r35.g(r33, new SelfOpenHalfHybridView$onExecuteAsync$1(this, r18));
    L111:
        int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r19.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L112:
        CardListPopupLayerComponent r36 = (CardListPopupLayerComponent) this.b.getValue();
        if (r36 == null) goto L117;
        PopupLayer r37 = r36.g();
        if (r37 == null) goto L117;
        r37.h(r12);
    L117:
        CardListPopupLayerComponent r38 = (CardListPopupLayerComponent) this.b.getValue();
        if (r38 == null) goto L120;
        r38.h();
    L120:
        int r39 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r19.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L62:
        r116 = null;
        goto L63
    L56:
        r112 = 0;
    L52:
        r16 = 73;
        goto L53
    L46:
        r13 = false;
        goto L47
    L39:
        r4 = null;
        goto L41
    L32:
        r11 = null;
        goto L34
    L22:
        Intrinsics.checkNotNullParameter(r7, "$this$toUri");
        Uri r40 = UriProtector.parse(r7);
        Set r122 = UriProtector.getQueryParameterNames(r40);
        LinkedHashMap r123 = new LinkedHashMap();
        Iterator r124 = r122.iterator();
    L24:
        if (r124.hasNext() == false) goto L29;
        String r125 = (String) r124.next();
        String r126 = UriProtector.getQueryParameter(r40, r125);
        if (r126 != null) goto L28;
        r126 = "";
    L28:
        r123.put(r125, r126);
        goto L24
    L29:
        r10 = MapsKt.toMap(r123);
        goto L30
    L16:
        if (r7.length() == 0) goto L19;
        r9 = false;
        goto L20
    L5:
        r6 = null;
        goto L7
    }
}
