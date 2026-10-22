package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.FontShadow;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.FontStyle;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderNAPendantConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderNAPendantItemConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderNAPendantStyleConfigModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantNative;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.Padding;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ShadowOffset;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.m;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.TabHighLightView;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CenterShowTabIndicatorLayout extends FrameLayout implements o<HeaderPendantNative>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c {
    public static final /* synthetic */ int o = 0;
    public int a;
    public List<m> b;
    public TabHighLightView c;
    public m d;
    public HeaderPendantNative e;
    public boolean f;
    public boolean g;
    public final Paint h;
    public final RectF i;
    public final EdgeGradientFrameLayout j;
    public final d k;
    public final FrameLayout l;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a m;
    public final s n;

    public static final class a implements View.OnTouchListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    public static final class b {
        public b() {
        }

        public static final void a(TextView r6, FontShadow r7) {
            int r0 = CenterShowTabIndicatorLayout.o;
            if (r7 != null) goto L5;
            r6.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            return;
        L5:
            Double r2 = r7.getShadowBlur();
            if (r2 == null) goto L8;
            float r3 = com.bytedance.android.shopping.extensions.b.b(r2);
        L9:
            ShadowOffset r4 = r7.getShadowOffset();
            if (r4 == null) goto L14;
            Double r5 = r4.getX();
            if (r5 == null) goto L14;
            float r8 = com.bytedance.android.shopping.extensions.b.b(r5);
        L15:
            ShadowOffset r9 = r7.getShadowOffset();
            if (r9 == null) goto L20;
            Double r10 = r9.getY();
            if (r10 == null) goto L20;
            float r11 = com.bytedance.android.shopping.extensions.b.b(r10);
        L21:
            Integer r12 = r7.getShadowColorInt();
            if (r12 == null) goto L24;
            int r13 = r12.intValue();
        L26:
            if (r3 == 0.0f) goto L28;
        L33:
            r6.setShadowLayer(r3, r8, r11, r13);
            return;
        L28:
            if (r8 != 0.0f) goto L33;
            if (r11 != 0.0f) goto L33;
            if (r13 != 0) goto L33;
            r6.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            return;
        L24:
            r13 = 0;
        L20:
            r11 = 0.0f;
        L14:
            r8 = 0.0f;
            goto L15
        L8:
            r3 = 0.0f;
            goto L9
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TabHighLightView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;

        public static final class a implements View.OnLayoutChangeListener {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener(this);
                this.a.a.animate().translationX(this.a.c.getX()).setDuration(250).start();
            }
        }

        public c(TabHighLightView r1, boolean r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            this.a.animate().cancel();
            if (this.b == true) goto L5;
            this.a.setTranslationX(this.c.getX());
            return;
        L5:
            if (this.c.isLayoutRequested() == false) goto L7;
            this.c.addOnLayoutChangeListener(new a(this));
            return;
        L7:
            this.a.animate().translationX(this.c.getX()).setDuration(250).start();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends HorizontalScrollView {
        public final /* synthetic */ CenterShowTabIndicatorLayout a;

        public d(CenterShowTabIndicatorLayout r1, Context r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.view.View
        public final void onScrollChanged(int r1, int r2, int r3, int r4) {
            super.onScrollChanged(r1, r2, r3, r4);
            CenterShowTabIndicatorLayout.j(this.a);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ m a;
        public final /* synthetic */ int b;
        public final /* synthetic */ CenterShowTabIndicatorLayout c;

        public e(m r1, int r2, CenterShowTabIndicatorLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            this.c.n(this.b, true);
            CenterShowTabIndicatorLayout r6 = this.c;
            m r0 = this.a;
            r6.d = r0;
            if (r6.n.h00() == false) goto L5;
            r6.n.eh().n(r0.e(), null);
            return;
        L5:
            int r1 = r0.e();
            int r3 = r0.e() + r0.g();
        L6:
            if (r1 >= r3) goto L15;
            if (r6.n.aN(r1) == false) goto L9;
            r1 = r1 + 1;
            goto L6
        L9:
            r6.n.eh().n(r1, null);
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a a;
        public final /* synthetic */ CenterShowTabIndicatorLayout b;
        public final /* synthetic */ m c;
        public final /* synthetic */ Ref.IntRef d;

        public f(com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r1, CenterShowTabIndicatorLayout r2, m r3, Ref.IntRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.a.getChildCount();     // Catch: Throwable -> L7
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.a.getChildAt(r2).requestLayout();     // Catch: Throwable -> L7
            r2 = r2 + 1;     // Catch: Throwable -> L7
            goto L3
        L5:
            this.a.invalidate();     // Catch: Throwable -> L7
            this.b.k(this.d.element, this.c, false, true);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CenterShowTabIndicatorLayout a;
        public final /* synthetic */ m b;

        public static final class a implements View.OnLayoutChangeListener {
            public final /* synthetic */ g a;

            public a(g r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener(this);
                if (((this.a.a.m.getWidth() + this.a.a.k.getPaddingLeft()) + this.a.a.k.getPaddingRight()) <= CenterShowTabIndicatorLayout.i(this.a.a)) goto L7;
                g r10 = this.a;
                CenterShowTabIndicatorLayout r11 = r10.a;
                r11.g = true;
                View r12 = r11.m.findViewWithTag(r10.b);
                if (r12 == null) goto L8;
                CenterShowTabIndicatorLayout r13 = this.a.a;
                int r14 = CenterShowTabIndicatorLayout.i(r13);
                r13.k.smoothScrollTo(r12.getLeft() - ((r14 / 2) - (r12.getWidth() / 2)), 0);
            L8:
                CenterShowTabIndicatorLayout.j(this.a.a);
                return;
            L7:
                this.a.a.g = false;
                goto L8
            }
        }

        public g(CenterShowTabIndicatorLayout r1, m r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            CenterShowTabIndicatorLayout r0 = this.a;
            r0.m.requestLayout();
            View r1 = r0.m;
        L3:
            ViewParent r2 = null;
            if (r1 == null) goto L6;
            ViewParent r3 = r1.getParent();
        L7:
            if (r3 == null) goto L19;
            ViewParent r4 = r1.getParent();
            if ((r4 instanceof View) == false) goto L12;
            r2 = r4;
        L12:
            r1 = (View) r2;
            if (r1 == null) goto L18;
            if (r1.isLayoutRequested() == true) goto L18;
            r1.requestLayout();
        L18:
            if (Intrinsics.areEqual(r1, r0) == false) goto L3;
        L19:
            this.a.m.addOnLayoutChangeListener(new a(this));
            return;
        L6:
            r3 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h extends q {
        public final /* synthetic */ Function0 e;

        public final void c() {
            this.e.invoke();
        }

        public h(Function0 r1) {
            this.e = r1;
            super(3);
        }
    }

    static {
        new b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void c(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void d(boolean r1, int r2) {
    }

    private final void update() {
        HeaderPendantNative r0 = this.e;
        if (r0 == null) goto L27;
        HeaderNAPendantStyleConfigModel r1 = r0.getStyleConfig();
        if (r1 == null) goto L27;
        HeaderNAPendantConfig r2 = r1.getContainer();
        if (r2 == null) goto L27;
        Padding r3 = r2.getPadding();
        if (r3 == null) goto L27;
        d r4 = this.k;
        Long r5 = r3.getLeft();
        if (r5 == null) goto L13;
        int r6 = com.bytedance.android.shopping.extensions.b.a(r5);
    L14:
        Long r7 = r3.getTop();
        if (r7 == null) goto L17;
        int r8 = com.bytedance.android.shopping.extensions.b.a(r7);
    L18:
        Long r9 = r3.getRight();
        if (r9 == null) goto L21;
        int r10 = com.bytedance.android.shopping.extensions.b.a(r9);
    L22:
        Long r11 = r3.getBottom();
        if (r11 == null) goto L25;
        int r12 = com.bytedance.android.shopping.extensions.b.a(r11);
    L26:
        r4.setPadding(r6, r8, r10, r12);
        this.k.setClipToPadding(false);
        goto L27
    L25:
        r12 = 0;
        goto L26
    L21:
        r10 = 0;
        goto L22
    L17:
        r8 = 0;
        goto L18
    L13:
        r6 = 0;
    L27:
        List<m> r13 = this.b;
        if (r13 == null) goto L41;
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
    L31:
        if (r14.hasNext() == false) goto L41;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        m r18 = (m) r16;
        if (this.a < r18.e()) goto L40;
        if (this.a >= (r18.e() + r18.g())) goto L40;
        int r19 = r15;
    L42:
        List<m> r20 = this.b;
        if (r20 == null) goto L45;
        m r110 = (m) CollectionsKt.getOrNull(r20, r19);
    L47:
        if (r110 != null) goto L51;
        setVisibility(8);
        return;
    L51:
        if (getVisibility() != 8) goto L53;
        boolean r111 = true;
    L54:
        setVisibility(0);
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        String r21 = r110.b(this.a);
        r112.element = r21;
        if (r21 != null) goto L57;
    L60:
        boolean r22 = true;
    L62:
        if (r22 == true) goto L64;
    L90:
        Ref.IntRef r23 = new Ref.IntRef();
        r23.element = -1;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r24 = this.m;
        List<m> r25 = this.b;
        if (r25 != null) goto L93;
    L94:
        r24.removeAllViewsInLayout();
        List<m> r26 = this.b;
        if (r26 == null) goto L110;
        Iterator<T> r27 = r26.iterator();
        int r28 = 0;
    L98:
        if (r27.hasNext() == false) goto L110;
        Object r29 = r27.next();
        int r30 = r28 + 1;
        if (r28 >= 0) goto L102;
        CollectionsKt.throwIndexOverflow();
    L102:
        m r31 = (m) r29;
        Context r113 = r24.getContext();
        String r114 = r31.d();
        if (r114 != null) goto L105;
        String r115 = "";
    L106:
        Intrinsics.checkNotNullParameter(r113, "context");
        Intrinsics.checkNotNullParameter(r115, "textValue");
        TextView r32 = new TextView(r113);
        ViewGroup.LayoutParams r116 = r32.getLayoutParams();
        if (r116 != null) goto L109;
        r116 = new ViewGroup.LayoutParams(-2, -2);
    L109:
        r116.width = -2;
        r116.height = -1;
        Unit r117 = Unit.INSTANCE;
        r32.setLayoutParams(r116);
        r32.setSingleLine(true);
        r32.setTextSize(11.0f);
        r32.setTypeface(Typeface.DEFAULT_BOLD);
        r32.setGravity(17);
        r32.setText(r115);
        r32.setTag(r31);
        r32.setOnClickListener(new e(r31, r28, this));
        r24.addView(r32);
        r28 = r30;
        goto L98
    L105:
        r115 = r114;
    L110:
        int r33 = r24.getChildCount();
        int r118 = 0;
    L112:
        if (r118 >= r33) goto L139;
        View r34 = r24.getChildAt(r118);
        if (r34 == null) goto L138;
        TextView r35 = (TextView) r34;
        if ((!Intrinsics.areEqual(r35.getTag(), r110)) == false) goto L131;
        Object r36 = r35.getTag();
        if ((r36 instanceof m) == true) goto L120;
        r36 = null;
    L120:
        m r37 = (m) r36;
        if (r37 == null) goto L123;
        String r38 = r37.d();
    L124:
        if (r38 != null) goto L126;
        r38 = "";
    L126:
        r35.setText(r38);
        List<m> r39 = this.b;
        if (r39 == null) goto L129;
        int r119 = r39.size();
    L130:
        Ref.IntRef r40 = r23;
        p(r35, false, r118, r19, r119);
    L136:
        r118 = r118 + 1;
        r23 = r40;
        r24 = r24;
        goto L112
    L129:
        r119 = 0;
        goto L130
    L123:
        r38 = null;
        goto L124
    L131:
        r40 = r23;
        r40.element = r118;
        r35.setText((String) r112.element);
        List<m> r41 = this.b;
        if (r41 == null) goto L134;
        int r42 = r41.size();
    L135:
        p(r35, true, r118, r19, r42);
        goto L136
    L134:
        r42 = 0;
        goto L135
    L138:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L139:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r120 = r24;
        Ref.IntRef r43 = r23;
        if (this.c != null) goto L162;
        FrameLayout r44 = this.l;
        TabHighLightView r45 = new TabHighLightView(r120.getContext());
        HeaderPendantNative r46 = this.e;
        if (r46 == null) goto L146;
        HeaderNAPendantStyleConfigModel r47 = r46.getStyleConfig();
        if (r47 == null) goto L146;
        HeaderNAPendantConfig r48 = r47.getSlider();
    L147:
        if (r48 != null) goto L149;
        r45.setBackgroundResource(2131231271);
        int r49 = 0;
    L161:
        this.c = r45;
        Unit r50 = Unit.INSTANCE;
        r44.addView(r45, r49, new FrameLayout.LayoutParams(r49, r49));
    L163:
        TabHighLightView r51 = this.c;
        if (r51 == null) goto L167;
        r51.setVisibility(r49);
    L167:
        if (r120.getHasMeasuredButNotLayout() == false) goto L169;
        r120.post(new f(r120, this, r110, r43));
    L169:
        List<m> r52 = this.b;
        if (r52 != null) goto L172;
    L181:
        post(new g(this, r110));
        k(r43.element, r110, !r111, false);
        if ((!Intrinsics.areEqual(r110, this.d)) == true) goto L184;
    L186:
        this.d = r110;
        if (this.f == true) goto L192;
        this.f = true;
        Function0<Unit> r53 = new CenterShowTabIndicatorLayout$update$action$1(this);
        if (PdpPerfOpt.c() == false) goto L191;
        this.n.rR().Z(new h(r53), false);
        goto L192
    L191:
        r53.invoke();
    L192:
        b();
        return;
    L184:
        if (this.d == null) goto L186;
        n(r19, false);
        goto L186
    L172:
        if (r52.size() != 1) goto L181;
        View r54 = this.m.getChildAt(0);
        if (r54 == null) goto L180;
        TextView r55 = (TextView) r54;
        r55.setTextColor(-1);
        r55.setPadding(com.bytedance.android.shopping.extensions.b.b(10), 0, com.bytedance.android.shopping.extensions.b.b(10), 0);
        TabHighLightView r56 = this.c;
        if (r56 == null) goto L181;
        r56.setVisibility(8);
        goto L181
    L180:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L149:
        Integer r57 = r48.getBgColorInt();
        Double r58 = r48.getBorderRadius();
        if (r58 == null) goto L152;
        Float r59 = Float.valueOf(com.bytedance.android.ec.core.utils.q.a(r58));
    L153:
        Double r60 = r48.getHeight();
        if (r60 == null) goto L156;
        Float r121 = Float.valueOf(com.bytedance.android.ec.core.utils.q.a(r60));
    L157:
        r45.b = r57;
        r45.c = r59;
        r45.d = r121;
        r49 = 0;
        if (r57 == null) goto L160;
        r45.setBackgroundColor(0);
    L160:
        r45.invalidate();
        goto L161
    L156:
        r121 = null;
        goto L157
    L152:
        r59 = null;
    L146:
        r48 = null;
        goto L147
    L162:
        r49 = 0;
        goto L163
    L93:
        if (r25.size() == r24.getChildCount()) goto L110;
    L64:
        if (this.n.h00() == false) goto L66;
    L77:
        int r61 = 0;
        int r62 = 0;
    L78:
        int r63 = ((this.a - r110.e()) - r61) + 1;
        int r64 = r110.g() - r62;
        StringBuilder r65 = new StringBuilder();
        r65.append(r63);
        r65.append('/');
        r65.append(r64);
        String r66 = r65.toString();
        List<m> r67 = this.b;
        if (r67 == null) goto L84;
        if (r67.size() != 1) goto L84;
    L89:
        r112.element = r66;
    L84:
        if (r110.g() <= 1) goto L86;
        r66 = r110.d() + r66;
        goto L89
    L86:
        r66 = r110.d();
        if (r66 != null) goto L89;
        r66 = "";
        goto L89
    L66:
        if ((!Intrinsics.areEqual(r110.a, Boolean.FALSE)) == false) goto L77;
        int r68 = r110.e();
        int r69 = r110.e() + r110.g();
        boolean r70 = false;
        r61 = 0;
        r62 = 0;
    L68:
        if (r68 >= r69) goto L76;
        if (this.n.aN(r68) == false) goto L75;
        r62 = r62 + 1;
        if (r68 >= this.a) goto L74;
        r61 = r61 + 1;
    L74:
        r70 = true;
    L75:
        r68 = r68 + 1;
        goto L68
    L76:
        r110.a = Boolean.valueOf(r70);
        goto L78
    L57:
        if (r21.length() == 0) goto L60;
        r22 = false;
        goto L62
    L53:
        r111 = false;
        goto L54
    L45:
        r110 = null;
    L40:
        r15 = r17;
    L41:
        r19 = -1;
        goto L42
    }

    private final int getMinSaveWidth() {
        return RangesKt.coerceAtMost((k1.m(getContext()) - com.bytedance.android.shopping.extensions.b.b(84)) - com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(178));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void b() {
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L7;
    L11:
        int r0 = 0;
    L12:
        setVisibility(r0);
        return;
    L7:
        if (this.n.s() == true) goto L11;
        if (this.n.isExpanded() == true) goto L11;
        r0 = 4;
        goto L12
    }

    public static final /* synthetic */ int i(CenterShowTabIndicatorLayout r0) {
        return r0.getMinSaveWidth();
    }

    public static final void j(CenterShowTabIndicatorLayout r5) {
        List<m> r0 = r5.b;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.size());
    L6:
        if (r1 == null) goto L29;
        List<m> r2 = r5.b;
        if (r2 != null) goto L10;
    L11:
        List<m> r3 = r5.b;
        if (r3 == null) goto L17;
        if (r3.size() != 1) goto L17;
        return;
    L17:
        if (r5.g == true) goto L19;
        r5.j.b(0, 0, 0, 0);
        return;
    L19:
        if (r5.k.canScrollHorizontally(-1) == false) goto L21;
        int r4 = com.bytedance.android.shopping.extensions.b.b(36);
    L23:
        if (r5.k.canScrollHorizontally(1) == false) goto L25;
        int r6 = com.bytedance.android.shopping.extensions.b.b(36);
    L26:
        r5.j.b(r4, 0, r6, 0);
        return;
    L25:
        r6 = 0;
        goto L26
    L21:
        r4 = 0;
        goto L23
    L10:
        if (r2.size() != 0) goto L11;
        return;
    L29:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void a(boolean r2) {
        if (getVisibility() != 0) goto L8;
        if (r2 == false) goto L6;
        ViewExtensionsKt.c(this, false, 3);
        return;
    L6:
        ViewExtensionsKt.i(this);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void g(HeaderPendantNative r2) {
        boolean r0 = !Intrinsics.areEqual(r2, this.e);
        this.e = r2;
        if (r2 == null) goto L5;
        List<m> r3 = r2.getHeaderTabs();
    L6:
        this.b = r3;
        if (r0 == false) goto L10;
        update();
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final Map<String, Object> m(int r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        List<m> r1 = this.b;
        if (r1 == null) goto L9;
        m r2 = (m) CollectionsKt.getOrNull(r1, r3);
        if (r2 == null) goto L9;
        Map<String, Object> r4 = r2.h();
        if (r4 == null) goto L9;
        r0.putAll(r4);
        r0.put("tab_rank", Integer.valueOf(r3 + 1));
    L9:
        return r0;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        HeaderPendantNative r0 = this.e;
        if (r0 == null) goto L11;
        HeaderNAPendantStyleConfigModel r1 = r0.getStyleConfig();
        if (r1 == null) goto L11;
        HeaderNAPendantConfig r2 = r1.getContainer();
        if (r2 == null) goto L11;
        Double r3 = r2.getBorderRadius();
        if (r3 == null) goto L11;
        float r4 = com.bytedance.android.ec.core.utils.q.a(r3);
    L12:
        float r5 = com.bytedance.android.ec.core.utils.q.a(Double.valueOf(0.5d));
        HeaderPendantNative r6 = this.e;
        if (r6 == null) goto L15;
        HeaderNAPendantStyleConfigModel r8 = r6.getStyleConfig();
    L17:
        if (r8 == null) goto L29;
        HeaderPendantNative r9 = this.e;
        if (r9 == null) goto L27;
        HeaderNAPendantStyleConfigModel r10 = r9.getStyleConfig();
        if (r10 == null) goto L27;
        HeaderNAPendantConfig r11 = r10.getContainer();
        if (r11 == null) goto L27;
        Double r12 = r11.getBorderWidth();
        if (r12 == null) goto L27;
        float r13 = (float) r12.doubleValue();
    L28:
        r5 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(r13));
    L27:
        r13 = 0.0f;
    L29:
        this.i.set(0.0f, 0.0f, getWidth(), getHeight());
        this.i.inset(r5, r5);
        this.h.setStyle(Paint.Style.FILL);
        Paint r14 = this.h;
        HeaderPendantNative r15 = this.e;
        if (r15 == null) goto L38;
        HeaderNAPendantStyleConfigModel r16 = r15.getStyleConfig();
        if (r16 == null) goto L38;
        HeaderNAPendantConfig r17 = r16.getContainer();
        if (r17 == null) goto L38;
        Integer r18 = r17.getBgColorInt();
        if (r18 == null) goto L38;
        int r19 = r18.intValue();
    L39:
        r14.setColor(r19);
        r7.drawRoundRect(this.i, r4, r4, this.h);
        if (r5 <= 0) goto L52;
        float r20 = (-r5) / 2;
        this.i.inset(r20, r20);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeWidth(r5);
        Paint r21 = this.h;
        HeaderPendantNative r22 = this.e;
        if (r22 == null) goto L50;
        HeaderNAPendantStyleConfigModel r23 = r22.getStyleConfig();
        if (r23 == null) goto L50;
        HeaderNAPendantConfig r24 = r23.getContainer();
        if (r24 == null) goto L50;
        Integer r25 = r24.getBorderColorInt();
        if (r25 == null) goto L50;
        int r26 = r25.intValue();
    L51:
        r21.setColor(r26);
        r7.drawRoundRect(this.i, r4, r4, this.h);
    L50:
        r26 = 536870911;
    L52:
        super.onDraw(r7);
        return;
    L38:
        r19 = (int) 2148931619L;
        goto L39
    L15:
        r8 = null;
    L11:
        r4 = getHeight() / 2.0f;
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void onPageSelected(int r1) {
        this.a = r1;
        update();
    }

    public CenterShowTabIndicatorLayout(Context r7, s r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "headAbility");
        super(r7);
        this.n = r8;
        this.a = r8.getCurrentPosition();
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        r9.setStrokeCap(Paint.Cap.ROUND);
        Unit r0 = Unit.INSTANCE;
        this.h = r9;
        this.i = new RectF();
        EdgeGradientFrameLayout r10 = new EdgeGradientFrameLayout(r7, null, 6, 0);
        this.j = r10;
        d r1 = new d(this, r7);
        this.k = r1;
        FrameLayout r2 = new FrameLayout(r7);
        this.l = r2;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r3 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a(r7);
        this.m = r3;
        r2.addView(r3, new FrameLayout.LayoutParams(-2, -1));
        r1.addView(r2, new FrameLayout.LayoutParams(-2, -1));
        r1.setHorizontalScrollBarEnabled(false);
        r10.addView(r1, new FrameLayout.LayoutParams(-2, -1));
        addView(r10, new FrameLayout.LayoutParams(-2, -1));
        setWillNotDraw(false);
        r1.setOnTouchListener(a.a);
    }

    public final void n(int r2, boolean r3) {
        List<m> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((m) CollectionsKt.getOrNull(r0, r2)) == null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r1 = this.n.w7();
        if (r3 == false) goto L9;
        TabClickType r4 = TabClickType.TYPE_CLICK;
    L10:
        r1.g(r4.getType(), m(r2));
        return;
    L9:
        r4 = TabClickType.TYPE_DRAW;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMinSaveWidth();
        if (getMeasuredWidth() <= r6) goto L6;
        this.j.measure(View.MeasureSpec.makeMeasureSpec(r6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.j.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(r6, getMeasuredHeight());
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(HeaderPendantNative r1, int r2, Integer r3) {
    }

    public final void k(int r3, m r4, boolean r5, boolean r6) {
        TabHighLightView r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        View r7 = this.m.getChildAt(r3);
        if (r7 == null) goto L21;
        if (r6 == true) goto L12;
        if (Intrinsics.areEqual(r0.getTag(), r4) == false) goto L12;
        return;
    L12:
        if (r0.getTag() == null) goto L15;
        if (r5 == false) goto L15;
        boolean r8 = true;
    L16:
        r0.setTag(r4);
        View r9 = r0.a;
        if (r9 == null) goto L19;
        r9.removeOnLayoutChangeListener(r0.f);
    L19:
        r7.addOnLayoutChangeListener(r0.f);
        r0.a = r7;
        r0.a(r7, false);
        r0.post(new c(r0, r8, r7));
        return;
    L15:
        r8 = false;
        goto L16
    }

    public final void p(TextView r8, boolean r9, int r10, int r11, int r12) {
        HeaderPendantNative r0 = this.e;
        FontShadow r1 = null;
        if (r0 == null) goto L7;
        HeaderNAPendantStyleConfigModel r2 = r0.getStyleConfig();
        if (r2 == null) goto L7;
        HeaderNAPendantItemConfig r3 = r2.getItem();
    L8:
        if (r3 == null) goto L12;
        Double r4 = r3.getInnerSpace();
        if (r4 == null) goto L12;
        Integer r5 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(r4));
    L13:
        if (r5 == null) goto L15;
        int r6 = r5.intValue();
    L17:
        if (r9 == false) goto L47;
        if (r3 == null) goto L24;
        FontStyle r13 = r3.getSelected();
        if (r13 == null) goto L24;
        Integer r14 = r13.getTextColorInt();
        if (r14 == null) goto L24;
        int r15 = r14.intValue();
    L25:
        if (r3 == null) goto L32;
        FontStyle r16 = r3.getSelected();
        if (r16 == null) goto L32;
        if (r16.isBoldStyle() == true) goto L32;
        Typeface r17 = Typeface.DEFAULT;
    L33:
        if (r3 == null) goto L37;
        FontStyle r18 = r3.getSelected();
        if (r18 == null) goto L37;
        Long r19 = r18.getFontSize();
    L38:
        r8.setTextColor(r15);
        r8.setPadding(r6, 0, r6, 0);
        r8.setTypeface(r17);
        if (r19 == null) goto L41;
        r8.setTextSize(r19.longValue());
    L41:
        if (r3 == null) goto L45;
        FontStyle r20 = r3.getSelected();
        if (r20 == null) goto L45;
        r1 = r20.getFontShadow();
    L45:
        b.a(r8, r1);
        return;
    L37:
        r19 = null;
    L32:
        r17 = Typeface.DEFAULT_BOLD;
    L24:
        r15 = ContextCompat.getColor(r8.getContext(), 2131101196);
        goto L25
    L47:
        if (r3 == null) goto L53;
        FontStyle r7 = r3.getUnselected();
        if (r7 == null) goto L53;
        Integer r21 = r7.getTextColorInt();
        if (r21 == null) goto L53;
        int r22 = r21.intValue();
    L54:
        if (r3 == null) goto L61;
        FontStyle r23 = r3.getUnselected();
        if (r23 == null) goto L61;
        if (r23.isBoldStyle() == true) goto L61;
        Typeface r24 = Typeface.DEFAULT;
    L62:
        if (r3 == null) goto L66;
        FontStyle r25 = r3.getUnselected();
        if (r25 == null) goto L66;
        Long r26 = r25.getFontSize();
    L67:
        r8.setTextColor(r22);
        if ((r10 + 1) != r11) goto L70;
    L73:
        int r27 = r6;
    L74:
        r8.setPadding(r6, 0, r27, 0);
        r8.setTypeface(r24);
        if (r26 == null) goto L77;
        r8.setTextSize(r26.longValue());
    L77:
        if (r3 == null) goto L81;
        FontStyle r28 = r3.getUnselected();
        if (r28 == null) goto L81;
        r1 = r28.getFontShadow();
    L81:
        b.a(r8, r1);
        return;
    L70:
        if (r10 == (r12 - 1)) goto L73;
        r27 = 0;
    L66:
        r26 = null;
    L61:
        r24 = Typeface.DEFAULT_BOLD;
    L53:
        r22 = -1;
        goto L54
    L15:
        r6 = com.bytedance.android.shopping.extensions.b.b(8);
    L12:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }
}
