package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopMarqueeTextView> {
    public boolean H3;
    public String I3;
    public String J3;
    public int K3;
    public int L3;

    public static final class a {
    }

    static {
    }

    public g(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.I3 = "play";
        this.J3 = "#161823";
        this.K3 = 14;
        this.L3 = 400;
    }

    /* JADX WARN: Type inference failed for: r11v20, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
    public final void H0(Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "props");
        if (((ECShopMarqueeTextView) k1()) != null) goto L5;
        return;
    L5:
        dm.a.a("ShopScrollTextViewManager").a("onUpdateProp, props: " + r11);
        boolean r2 = false;
        if (this.H3 == false) goto L41;
        Object r12 = r11.get("play_state");
        if (r12 == null) goto L13;
        String r13 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r12);
        if (r13 == null) goto L13;
        this.I3 = r13;
    L13:
        if (Intrinsics.areEqual(this.I3, "play") == false) goto L20;
        ECShopMarqueeTextView r14 = (ECShopMarqueeTextView) k1();
        if (r14 != null) goto L17;
        return;
    L17:
        if (r14.q == false) goto L218;
        r14.z("resumePauseScroll isPause: true");
        r14.c = true;
        r14.f = 0;
        r14.q = false;
        r14.E();
        return;
    L218:
        return;
    L20:
        if (Intrinsics.areEqual(this.I3, "pause") == false) goto L35;
        ?? r15 = (ECShopMarqueeTextView) k1();
        if (r15 != 0) goto L24;
        return;
    L24:
        if (r15.b != null) goto L27;
        return;
    L27:
        if (r15.q == true) goto L226;
        r15.q = true;
        r15.removeCallbacks(r15.v);
        r15.y();
        Scroller r0 = r15.b;
        if (r0 == null) goto L32;
        r0.forceFinished(true);
    L32:
        Scroller r4 = r15.b;
        if (r4 == null) goto L221;
        r4.startScroll(0, 0, 0, 0, 0);
        return;
    L221:
        return;
    L226:
        return;
    L35:
        ECShopMarqueeTextView r16 = (ECShopMarqueeTextView) k1();
        if (r16 != null) goto L38;
        return;
    L38:
        if (r16.q == false) goto L224;
        r16.z("resumePauseScroll isPause: true");
        r16.c = true;
        r16.f = 0;
        r16.q = false;
        r16.E();
        return;
    L224:
        return;
    L41:
        Iterator<Map.Entry<String, ? extends Object>> r17 = r11.entrySet().iterator();
        boolean r1 = true;
    L43:
        if (r17.hasNext() == false) goto L111;
        Map.Entry<String, ? extends Object> r6 = r17.next();
        String r7 = r6.getKey();
        Object r8 = r6.getValue();
        switch(r7.hashCode()) {
            case -2025069948: goto L106;
            case -396084139: goto L98;
            case 3556653: goto L90;
            case 630712325: goto L82;
            case 1053247136: goto L74;
            case 1071725009: goto L66;
            case 1349322996: goto L58;
            case 1925938118: goto L52;
            case 2014051279: goto L48;
            default: goto L43;
        };
    L48:
        if (r7.equals("scroll_enabled") == false) goto L43;
        if (r8 == null) goto L43;
        r1 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r8);
        goto L43
    L52:
        if (r7.equals("play_state") == false) goto L43;
        if (r8 == null) goto L43;
        String r9 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r8);
        if (r9 == null) goto L43;
        this.I3 = r9;
        goto L43
    L58:
        if (r7.equals("scroll_start_delay") == false) goto L43;
        if (r8 == null) goto L43;
        Integer r10 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r10 == null) goto L43;
        int r18 = r10.intValue();
        ECShopMarqueeTextView r19 = (ECShopMarqueeTextView) k1();
        if (r19 == null) goto L43;
        r19.setScrollStartDelay(r18 * ECDraweeView.SQUARE);
        goto L43
    L66:
        if (r7.equals("scroll_max_loop") == false) goto L43;
        if (r8 == null) goto L43;
        Integer r20 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r20 == null) goto L43;
        int r21 = r20.intValue();
        ECShopMarqueeTextView r22 = (ECShopMarqueeTextView) k1();
        if (r22 == null) goto L43;
        r22.setMaxLoopCount(r21);
        goto L43
    L74:
        if (r7.equals("scroll_end_pause") == false) goto L43;
        if (r8 == null) goto L43;
        Integer r23 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r23 == null) goto L43;
        int r24 = r23.intValue();
        ECShopMarqueeTextView r25 = (ECShopMarqueeTextView) k1();
        if (r25 == null) goto L43;
        r25.setScrollFirstDelay(r24 * ECDraweeView.SQUARE);
        goto L43
    L82:
        if (r7.equals("scroll_time_interval") == false) goto L43;
        if (r8 == null) goto L43;
        Integer r26 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r26 == null) goto L43;
        int r27 = r26.intValue();
        ECShopMarqueeTextView r28 = (ECShopMarqueeTextView) k1();
        if (r28 == null) goto L43;
        r28.setScrollTimeInterval(r27 * ECDraweeView.SQUARE);
        goto L43
    L90:
        if (r7.equals("text") == false) goto L43;
        if (r8 == null) goto L43;
        CharSequence r29 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r8);
        if (r29 == null) goto L43;
        AppCompatTextView r30 = (ECShopMarqueeTextView) k1();
        if (r30 == null) goto L43;
        r30.setText(r29);
        goto L43
    L98:
        if (r7.equals("scroll_speed") == false) goto L43;
        if (r8 == null) goto L43;
        Integer r31 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r31 == null) goto L43;
        int r32 = r31.intValue();
        ECShopMarqueeTextView r33 = (ECShopMarqueeTextView) k1();
        if (r33 == null) goto L43;
        r33.setMScrollVelocity((r32 * 3) / 10);
        goto L43
    L106:
        if (r7.equals("scroll_auto_start") == false) goto L43;
        if (r8 == null) goto L43;
        boolean r34 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r8);
        ECShopMarqueeTextView r35 = (ECShopMarqueeTextView) k1();
        if (r35 == null) goto L43;
        r35.setCanScrollable(r34);
        goto L43
    L111:
        dm.a.b r110 = dm.a.a("ShopScrollTextViewManager");
        StringBuilder r3 = new StringBuilder("text: ");
        ECShopMarqueeTextView r5 = (ECShopMarqueeTextView) k1();
        if (r5 == null) goto L114;
        CharSequence r36 = r5.getText();
    L115:
        r3.append(r36);
        r3.append(", canScroll ");
        r3.append(r1);
        r3.append(", hasStartScroll: ");
        r3.append(this.H3);
        r110.a(r3.toString());
        if (r1 == false) goto L227;
        ECShopMarqueeTextView r111 = (ECShopMarqueeTextView) k1();
        if (r111 == null) goto L228;
        CharSequence r112 = r111.getText();
        if (r112 != null) goto L122;
        return;
    L122:
        if (r112.length() <= 0) goto L124;
        r2 = true;
    L124:
        if (r2 == true) goto L126;
        return;
    L126:
        if (Intrinsics.areEqual(this.I3, "play") == false) goto L231;
        ECShopMarqueeTextView r113 = (ECShopMarqueeTextView) k1();
        if (r113 == null) goto L130;
        r113.E();
    L130:
        this.H3 = true;
        return;
    L231:
        return;
    L228:
        return;
    L227:
        return;
    L114:
        r36 = null;
        goto L115
    }

    public final void I0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "styles");
        dm.a.a("ShopScrollTextViewManager").a("onUpdateStyle, styles: " + r4);
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L38;
        Map.Entry<String, ? extends Object> r0 = r5.next();
        String r1 = r0.getKey();
        Object r2 = r0.getValue();
        switch(r1.hashCode()) {
            case -1539906063: goto L30;
            case -507058317: goto L21;
            case 94842723: goto L18;
            case 2024311912: goto L9;
            default: goto L4;
        };
    L9:
        if (r1.equals("font_weight") == false) goto L4;
        Integer r3 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r2);
        if (r3 == null) goto L4;
        if (r3.intValue() == this.L3) goto L4;
        this.L3 = r3.intValue();
        AppCompatTextView r6 = (ECShopMarqueeTextView) k1();
        if (r6 == null) goto L4;
        com.bytedance.android.shopping.extensions.f.e(r6, Integer.valueOf(RangesKt.coerceAtLeast(this.L3, 400)));
        goto L4
    L18:
        if (r1.equals("color") == false) goto L4;
    L22:
        String r7 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r2);
        if (r7 == null) goto L4;
        if ((!Intrinsics.areEqual(r7, this.J3)) == false) goto L4;
        this.J3 = r7;
        AppCompatTextView r8 = (ECShopMarqueeTextView) k1();
        if (r8 == null) goto L4;
        int r9 = s.a;
        r8.setTextColor(s.a(this.J3, 0));
        goto L4
    L21:
        if (r1.equals("font_color") == false) goto L4;
    L30:
        if (r1.equals("font_size") == false) goto L4;
        Integer r10 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r2);
        if (r10 == null) goto L4;
        if (r10.intValue() == this.K3) goto L4;
        this.K3 = r10.intValue();
        ECShopMarqueeTextView r11 = (ECShopMarqueeTextView) k1();
        if (r11 == null) goto L4;
        r11.setTextSize(2, this.K3);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new ECShopMarqueeTextView(r5, null, 6, 0);
        r0.setSingleLine(true);
        r0.setCanScrollable(false);
        r0.setNeedAdaptWidth(true);
        int r6 = s.a;
        r0.setTextColor(s.a(this.J3, 0));
        r0.setTextSize(2, this.K3);
        com.bytedance.android.shopping.extensions.f.e(r0, Integer.valueOf(RangesKt.coerceAtLeast(this.L3, 400)));
        return r0;
    }
}
