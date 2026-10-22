package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends SlcRoundFrameLayout {
    public Map<Integer, View> c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final List<TextView> h;
    public l1 i;
    public final Lazy j;
    public final Lazy k;
    public int l;
    public long m;
    public long n;
    public long o;
    public String p;
    public Map<String, ? extends Object> q;
    public boolean r;
    public int s;
    public final SlcTemplateContext t;
    public final boolean u;

    public static final class a implements l1.a {
        public final /* synthetic */ f a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ int g;

        public final void onFinish() {
            this.a.d(this.b, 0, this.d, this.e, this.f);
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
            this.a.d(this.b, this.c, this.d, this.e, this.f);
        }

        public final void onTick(long r9) {
            this.a.d(this.b, r9, this.d, this.e, this.f);
        }

        public a(f r1, int r2, long r3, long r5, String r7, Map r8, int r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
            this.f = r8;
            this.g = r9;
        }
    }

    private final CardListObjectContainer getObjectContainer() {
        return (CardListObjectContainer) this.k.getValue();
    }

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.j.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        if (this.r == true) goto L6;
        setVisibility(8);
        return;
    L6:
        e(this.l, this.m, this.n, this.o, this.p, this.q, this.s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        l1 r0 = this.i;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final boolean getEnableLargeTextMode() {
        return this.u;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.t;
    }

    public final l1 getTimer() {
        return this.i;
    }

    public static final /* synthetic */ CardListSliceCustomWidgetAdapterComponent c(f r0) {
        return r0.getProvider();
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

    public final void setTimer(l1 r1) {
        this.i = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r3, SlcTemplateContext r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.t = r4;
        this.u = r5;
        this.c = new LinkedHashMap();
        this.d = 86400000;
        this.e = 3600000;
        this.f = 60000;
        this.g = 1000;
        ArrayList r6 = new ArrayList();
        this.h = r6;
        this.j = LazyKt.lazy(new CountDownView$provider$2(this));
        this.k = LazyKt.lazy(new CountDownView$objectContainer$2(this));
        setVisibility(8);
        LayoutInflater.from(r3).inflate(2131560390, this, true);
        r6.add(b(2131368564));
        r6.add(b(2131368561));
        r6.add(b(2131374570));
        r6.add(b(2131374566));
        r6.add(b(2131380164));
        r6.add(b(2131380163));
        r6.add(b(2131385700));
        r6.add(b(2131385691));
        this.l = 14;
        this.p = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r20, long r21, long r23, String r25, Map<String, ? extends Object> r26) {
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
        if (this.u != true) goto L12;
        Number r12 = Float.valueOf(r20 * RangesKt.coerceAtMost(1.15f, LargeFontModeUtil.a()));
    L13:
        r10.setTextSize(0, SlcDimensExtensionsKt.e(r12, this.t.m()));
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

    public final void e(int r18, long r19, long r21, long r23, String r25, Map<String, ? extends Object> r26, int r27) {
        Intrinsics.checkNotNullParameter(r25, "fontColor");
        this.l = r18;
        this.m = r19;
        this.n = r21;
        this.o = r23;
        this.p = r25;
        this.q = r26;
        this.r = true;
        this.s = r27;
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
