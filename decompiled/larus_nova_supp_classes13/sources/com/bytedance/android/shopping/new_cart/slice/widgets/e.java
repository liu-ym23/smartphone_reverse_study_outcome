package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends SlcRoundFrameLayout {
    public Map<Integer, View> c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final List<TextView> h;
    public l1 i;
    public int j;
    public long k;
    public long l;
    public long m;
    public String n;
    public Map<String, ? extends Object> o;
    public boolean p;
    public int q;
    public final SlcTemplateContext r;

    public static final class a implements l1.a {
        public final /* synthetic */ e a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ int g;

        public final void onFinish() {
            this.a.c(this.b, 0, this.d, this.e, this.f);
            if (this.g != 2) goto L7;
            BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this.a);
            if (r0 == null) goto L11;
            SlcCommonAction r2 = new SlcCommonAction("cartRefresh", MapsKt.emptyMap());
            SlcRoundFrameLayout r3 = this.a;
            r0.getTemplateContext().d(r2, r3, r0.l(), null, null);
            return;
        L11:
            return;
        L7:
            BaseSlcViewManager r1 = SlcViewExtensionsKt.g(this.a);
            if (r1 == null) goto L13;
            SlcCommonAction r4 = new SlcCommonAction("cartCountDownHide", MapsKt.mapOf(TuplesKt.to("count_down_hide", Boolean.TRUE)));
            SlcRoundFrameLayout r5 = this.a;
            r1.getTemplateContext().d(r4, r5, r1.l(), null, null);
            return;
        }

        public final void onStart() {
            this.a.c(this.b, this.c, this.d, this.e, this.f);
        }

        public final void onTick(long r9) {
            this.a.c(this.b, r9, this.d, this.e, this.f);
        }

        public a(e r1, int r2, long r3, long r5, String r7, Map r8, int r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
            this.f = r8;
            this.g = r9;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        if (this.p == true) goto L6;
        setVisibility(8);
        return;
    L6:
        d(this.j, this.k, this.l, this.m, this.n, this.o, this.q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        l1 r0 = this.i;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.r;
    }

    public final List<TextView> getTextViewList() {
        return this.h;
    }

    public final l1 getTimer() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(int r3) {
        if (this.c != null) goto L5;
        this.c = new LinkedHashMap();
    L5:
        View r0 = this.c.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.c.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    public final void setTimer(l1 r1) {
        this.i = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r5, SlcTemplateContext r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "slcTemplateContext");
        ViewGroup.LayoutParams r0 = null;
        super(r5, null, 0);
        this.r = r6;
        this.c = new LinkedHashMap();
        this.d = 86400000;
        this.e = 3600000;
        this.f = 60000;
        this.g = 1000;
        ArrayList r7 = new ArrayList();
        this.h = r7;
        setVisibility(8);
        LayoutInflater.from(r5).inflate(2131560395, this, true);
        View r8 = qc3.a.c(this, 0);
        if (r8 == null) goto L5;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L7:
        if ((r9 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r0 = r9;
    L10:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L13;
        r1.gravity = 17;
    L13:
        r7.add(b(2131368564));
        r7.add(b(2131368561));
        r7.add(b(2131374570));
        r7.add(b(2131374566));
        r7.add(b(2131380164));
        r7.add(b(2131380163));
        r7.add(b(2131385700));
        r7.add(b(2131385691));
        this.j = 14;
        this.n = "";
        return;
    L5:
        r9 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(int r20, long r21, long r23, String r25, Map<String, ? extends Object> r26) {
        Intrinsics.checkNotNullParameter(r25, "fontColor");
        if (r21 >= 0) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        Iterator r9 = ((ArrayList) this.h).iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        TextView r10 = (TextView) r9.next();
        r10.setTextColor(ColorProtector.parseColor(r25));
        if (CartSettingUtils.b() == false) goto L12;
        Number r12 = Float.valueOf(r20 * RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a()));
    L13:
        r10.setTextSize(0, SlcDimensExtensionsKt.e(r12, this.r.m()));
        goto L8
    L12:
        r12 = Integer.valueOf(r20);
        goto L13
    L14:
        TextView r11 = (TextView) b(2131368561);
        Object r13 = null;
        if (r26 == null) goto L17;
        Object r14 = r26.get("day_suffix");
    L19:
        if ((r14 instanceof String) == true) goto L21;
        r14 = null;
    L21:
        String r15 = (String) r14;
        if (r15 != null) goto L25;
        r15 = "天";
    L25:
        r11.setText(r15);
        TextView r16 = (TextView) b(2131374566);
        if (r26 == null) goto L28;
        Object r17 = r26.get("hours_suffix");
    L30:
        if ((r17 instanceof String) == true) goto L32;
        r17 = null;
    L32:
        String r18 = (String) r17;
        String r19 = ":";
        if (r18 != null) goto L36;
        r18 = ":";
    L36:
        r16.setText(r18);
        TextView r110 = (TextView) b(2131380163);
        if (r26 == null) goto L39;
        Object r111 = r26.get("minutes_suffix");
    L41:
        if ((r111 instanceof String) == true) goto L43;
        r111 = null;
    L43:
        String r112 = (String) r111;
        if (r112 == null) goto L46;
        r19 = r112;
    L46:
        r110.setText(r19);
        TextView r113 = (TextView) b(2131385691);
        if (r26 == null) goto L49;
        Object r3 = r26.get("seconds_suffix");
    L51:
        if ((r3 instanceof String) == false) goto L54;
        r13 = r3;
    L54:
        String r114 = (String) r13;
        if (r114 != null) goto L58;
        r114 = "";
    L58:
        r113.setText(r114);
        if (r23 == 1) goto L64;
        long r115 = this.d;
        if ((r21 / r115) == 0) goto L64;
        ((TextView) b(2131368564)).setText(String.valueOf((int) Math.ceil((r21 * 1.0d) / r115)));
        b(2131368564).setVisibility(0);
        b(2131368561).setVisibility(0);
        b(2131374570).setVisibility(8);
        b(2131374566).setVisibility(8);
        b(2131380163).setVisibility(8);
        b(2131380164).setVisibility(8);
        b(2131385691).setVisibility(8);
        b(2131385700).setVisibility(8);
        return;
    L64:
        long r6 = this.e;
        long r116 = r21 / r6;
        long r117 = this.f;
        long r1 = (r21 % r117) / this.g;
        b(2131368561).setVisibility(8);
        b(2131368564).setVisibility(8);
        TextView r4 = (TextView) b(2131374570);
        r4.setText(StringsKt.padStart(String.valueOf(r116), 2, '0'));
        r4.setVisibility(0);
        TextView r5 = (TextView) b(2131380164);
        r5.setText(StringsKt.padStart(String.valueOf((r21 % r6) / r117), 2, '0'));
        r5.setVisibility(0);
        TextView r7 = (TextView) b(2131385700);
        r7.setText(StringsKt.padStart(String.valueOf(r1), 2, '0'));
        r7.setVisibility(0);
        b(2131374570).setVisibility(0);
        b(2131374566).setVisibility(0);
        b(2131380163).setVisibility(0);
        b(2131380164).setVisibility(0);
        b(2131385691).setVisibility(0);
        b(2131385700).setVisibility(0);
        return;
    L49:
        r3 = null;
        goto L51
    L39:
        r111 = null;
        goto L41
    L28:
        r17 = null;
        goto L30
    L17:
        r14 = null;
        goto L19
    }

    public final void d(int r18, long r19, long r21, long r23, String r25, Map<String, ? extends Object> r26, int r27) {
        Intrinsics.checkNotNullParameter(r25, "fontColor");
        this.j = r18;
        this.k = r19;
        this.l = r21;
        this.m = r23;
        this.n = r25;
        this.o = r26;
        this.p = true;
        this.q = r27;
        l1 r11 = this.i;
        if (r11 == null) goto L5;
        r11.a();
    L5:
        this.i = null;
        long r12 = Math.max(0, (r19 * ((long) 1000)) - (System.currentTimeMillis() - r21));
        l1 r13 = new l1(r12, TimeUnit.SECONDS.toMillis(1), new a(this, r18, r12, r23, r25, r26, r27));
        r13.d();
        Unit r0 = Unit.INSTANCE;
        this.i = r13;
    }
}
