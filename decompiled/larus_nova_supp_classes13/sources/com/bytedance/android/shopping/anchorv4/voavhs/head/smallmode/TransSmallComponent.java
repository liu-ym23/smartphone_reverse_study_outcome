package com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECHorizontalScrollView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadViewPager;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.d;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.e;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.r;
import com.bytedance.android.shopping.anchorv4.voavhs.head.j;
import com.bytedance.android.shopping.anchorv4.voavhs.head.t;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4FindSameView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import f83.l;
import f83.p;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TransSmallComponent implements com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a {
    public static final /* synthetic */ int r = 0;
    public boolean a;
    public final ECHorizontalScrollView b;
    public ECAnchorHeaderFrameLayout c;
    public final AnchorV4SmallTransition d;
    public HeadViewHolderBuilder e;
    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> f;
    public c g;
    public final ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public int n;
    public final Context o;
    public final AnchorV4HeadViewPager p;
    public final d q;

    public static final class Companion {
        public static int a(final Context r2) {
            Intrinsics.checkNotNullParameter(r2, "ctx");
            return (((Number) LazyKt.lazy(new TransSmallComponent$Companion$getFrameWidth$smallWidth$2(r2)).getValue()).intValue() * 2) + ((int) UIUtils.dip2Px(r2, 6.0f));
        }
    }

    public static final class a implements View.OnScrollChangeListener {
        public final /* synthetic */ TransSmallComponent a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;

        public a(TransSmallComponent r1, List r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View r9, int r10, int r11, int r12, int r13) {
            int r14 = -1;
            if (j.a() == false) goto L32;
            TransSmallComponent r15 = this.a;
            List<FrameLayout> r2 = this.b;
            List r3 = this.c;
            float r4 = r15.d.j;
            if (r4 != 0.0f) goto L7;
        L9:
            Iterator r5 = r3.iterator();
            int r6 = 0;
        L11:
            if (r5.hasNext() == false) goto L19;
            if ((r10 - r15.j()) > ((Number) r5.next()).intValue()) goto L15;
            boolean r7 = true;
        L16:
            if (r7 == true) goto L20;
            r6 = r6 + 1;
        L20:
            Iterator r8 = r3.iterator();
            int r16 = 0;
        L22:
            if (r8.hasNext() == false) goto L30;
            if ((r15.j() + r10) > ((Number) r8.next()).intValue()) goto L26;
            boolean r17 = true;
        L27:
            if (r17 == true) goto L31;
            r16 = r16 + 1;
        L31:
            r15.k(r2, Integer.valueOf(r6));
            r15.k(r2, Integer.valueOf(r16));
            goto L32
        L26:
            r17 = false;
            goto L27
        L30:
            r16 = -1;
            goto L31
        L15:
            r7 = false;
            goto L16
        L19:
            r6 = -1;
            goto L20
        L7:
            if (r4 == (-1.0f)) goto L9;
        L32:
            Iterator r18 = this.c.iterator();
            int r19 = 0;
        L34:
            if (r18.hasNext() == false) goto L42;
            if (((this.a.j() / 2) + r10) > ((Number) r18.next()).intValue()) goto L38;
            boolean r20 = true;
        L39:
            if (r20 == true) goto L40;
            r19 = r19 + 1;
            goto L34
        L40:
            r14 = r19;
            goto L42
        L38:
            r20 = false;
        L42:
            Integer r21 = Integer.valueOf(r14);
            r21.intValue();
            float r110 = this.a.d.j;
            if (r110 != 0.0f) goto L45;
        L48:
            boolean r111 = true;
        L50:
            if (r111 == true) goto L53;
            r21 = null;
        L53:
            if (r21 == null) goto L86;
            int r22 = RangesKt.coerceAtLeast(0, r21.intValue() - 1);
            int r112 = this.a.h.size();
            if (r22 < 0) goto L89;
            if (r112 <= r22) goto L87;
            TransSmallComponent r113 = this.a;
            if (r113.n == r22) goto L68;
            c r114 = r113.g;
            if (r114 == null) goto L68;
            HeadViewHolderBuilder r115 = r114.c;
            if (r115 == null) goto L68;
            Iterator r116 = ((ArrayList) r115.a.j).iterator();
        L66:
            if (r116.hasNext() == false) goto L68;
            ((com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b) r116.next()).b();
        L68:
            TransSmallComponent r117 = this.a;
            r117.n = r22;
            p r118 = r117.p.getTabLogicInterceptor();
            if (r118 == null) goto L75;
            Function0<l> r119 = r118.d;
            if (r119 == null) goto L75;
            l r120 = (l) r119.invoke();
            if (r120 == null) goto L75;
            r120.b(null, r22, null, false);
        L75:
            e.a.a(this.a.p, Integer.valueOf(r22), null, null, 6);
            p r121 = this.a.p.getTabLogicInterceptor();
            if (r121 == null) goto L88;
            r121.e(Integer.valueOf(r22));
            return;
        L88:
            return;
        L87:
            return;
        L89:
            return;
        L86:
            return;
        L45:
            if (r110 == (-1.0f)) goto L48;
            r111 = false;
            goto L50
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TransSmallComponent a;

        public b(TransSmallComponent r1) {
            this.a = r1;
        }

        public final void a() {
            AnchorV4SmallTransition r0 = this.a.d;
            Iterator<T> r1 = r0.a().iterator();
            int r2 = 0;
            int r3 = 0;
        L4:
            if (r1.hasNext() == false) goto L6;
            View r4 = (View) r1.next();
            ((ArrayList) r0.a).add(new com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a(r4.getX(), r4.getY(), r4.getWidth(), r4.getHeight()));
            List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> r5 = r0.b;
            ArrayList r6 = (ArrayList) r5;
            r6.add(new com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a(r0.b() * r3, 0.0f, r0.b(), r0.b()));
            r3 = r3 + 1;
            goto L4
        L6:
            ECAnchorHeaderFrameLayout r7 = r0.k.f();
            if (r7 == null) goto L9;
            int r8 = r7.getWidth();
        L10:
            r0.e = r8;
            r0.h = r0.a().size() * r0.b();
            ECAnchorHeaderFrameLayout r9 = r0.k.f();
            if (r9 == null) goto L13;
            r2 = r9.getHeight();
        L13:
            r0.f = r2;
            r0.g = r0.b();
            return;
        L9:
            r8 = 0;
            goto L10
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

    static {
    }

    public final int i() {
        return ((Number) this.k.getValue()).intValue();
    }

    public final int j() {
        return ((Number) this.i.getValue()).intValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final int a() {
        return this.p.getCurrentItem();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final void b() {
        ECHorizontalScrollView r0 = this.b;
        if (r0.d != null) goto L8;
        Field r1 = HorizontalScrollView.class.getDeclaredField("mScroller");
        r1.setAccessible(true);
        Object r2 = r1.get(r0);
        if ((r2 instanceof OverScroller) == true) goto L7;
        r2 = null;
    L7:
        r0.d = (OverScroller) r2;
    L8:
        OverScroller r3 = r0.d;
        if (r3 == null) goto L12;
        r3.forceFinished(true);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final void g() {
        this.p.requestLayout();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final List<View> getContainers() {
        ArrayList r0 = new ArrayList();
        ECAnchorHeaderFrameLayout r1 = this.c;
        if (r1 == null) goto L7;
        List r2 = com.bytedance.commerce.base.view.b.a(r1);
        if (r2 == null) goto L7;
    L8:
        r0.addAll(r2);
        return r0;
    L7:
        r2 = CollectionsKt.emptyList();
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final int c() {
        return i();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final boolean e() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final ECAnchorHeaderFrameLayout f() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final ECHorizontalScrollView h() {
        return this.b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a
    public final void d(AnchorV4SmallTransition.a r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.p.post(r2);
    }

    public final void l(View r5) {
        Iterator r6 = com.bytedance.commerce.base.view.b.a(r5).iterator();
    L3:
        List r1 = null;
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((((View) r0) instanceof AnchorV4FindSameView) == false) goto L3;
    L9:
        View r2 = (View) r0;
        if (r2 == null) goto L26;
        List r7 = com.bytedance.commerce.base.view.b.a(r2);
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.size() <= 3) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        r1 = r7;
    L19:
        if (r1 == null) goto L32;
        List r8 = r1.subList(0, 4);
        if (r8 == null) goto L33;
        Iterator r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L34;
        View r4 = (View) r9.next();
        int r10 = (i() - com.bytedance.android.shopping.extensions.b.b(8)) / 2;
        r4.getLayoutParams().width = r10;
        r4.getLayoutParams().height = r10;
        goto L24
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r3 = false;
        goto L17
    L26:
        return;
    L8:
        r0 = null;
        goto L9
    }

    public final void k(List<FrameLayout> r5, Integer r6) {
        if (r6 == null) goto L16;
        r6.intValue();
        FrameLayout r0 = (FrameLayout) CollectionsKt.getOrNull(r5, r6.intValue());
        if (r0 != null) goto L6;
        return;
    L6:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r1 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) CollectionsKt.getOrNull(this.h, r6.intValue());
        if (r1 == null) goto L17;
        View r2 = r1.b();
        if (r2 == null) goto L18;
        l(r2);
        r0.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        if (r6.intValue() >= 0) goto L13;
        return;
    L13:
        if (r6.intValue() >= r5.size()) goto L20;
        ListProtector.set(r5, r6.intValue(), null);
        return;
    L20:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void m(List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r24, l53.b r25) {
        Intrinsics.checkNotNullParameter(r24, "headNodeGroupList");
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r1 = r24;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        com.bytedance.android.shopping.anchorv4.voavhs.head.b r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.b) r2.next();
        String r7 = r3.a;
        String r8 = r3.b;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> r4 = r3.c;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r9.add(com.bytedance.android.shopping.anchorv4.voavhs.head.c.a((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r6.next(), null, null, 0, null, null, null, null, false, null, null, -2097153, 7));
        goto L7
    L9:
        r5.add(new com.bytedance.android.shopping.anchorv4.voavhs.head.b(r7, r8, r9, r3.d, r3.e));
        goto L4
    L10:
        this.f = r5;
        HeadViewHolderBuilder r10 = new HeadViewHolderBuilder(this.o, null, r5, r25, this.q, true);
        this.e = r10;
        if (r10.c() <= 0) goto L16;
        this.g = new c(r10);
        Function2<Integer, Float, Unit> r11 = new TransSmallComponent$refreshHeadViewData$2(this);
        Intrinsics.checkNotNullParameter(r11, "listener");
        r r12 = r10.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "listener");
        r12.i = r11;
        AnchorV4HeadViewPager r13 = this.p;
        Function1<HeadViewHolderBuilder, Unit> r14 = new TransSmallComponent$refreshHeadViewData$3(this);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "callback");
        HeadViewHolderBuilder r15 = r13.g;
        if (r15 == null) goto L15;
        r14.invoke(r15);
        goto L16
    L15:
        r13.o = r14;
    L16:
        ECAnchorHeaderFrameLayout r16 = this.c;
        if (r16 == null) goto L20;
        r16.removeAllViews();
    L20:
        if (this.c != null) goto L52;
        ArrayList r17 = new ArrayList();
        final ArrayList r18 = new ArrayList();
        ECAnchorHeaderFrameLayout r19 = new ECAnchorHeaderFrameLayout(this.o, null, 6, 0);
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r20 = this.h;
        HeadViewHolderBuilder r21 = this.e;
        if (r21 == null) goto L24;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r22 = r21.b();
    L25:
        r20.addAll(r22);
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r23 = this.h.iterator();
        int r26 = 0;
    L27:
        if (r23.hasNext() == false) goto L46;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r27 = r23.next();
        int r28 = r26 + 1;
        if (r26 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r29 = r27;
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(i(), i());
        r110.topMargin = ((Number) this.l.getValue()).intValue();
        r110.bottomMargin = ((Number) this.l.getValue()).intValue();
        r110.leftMargin = ((Number) this.l.getValue()).intValue() + ((i() + ((Number) this.m.getValue()).intValue()) * r26);
        if (this.h.size() != 1) goto L34;
        r110.leftMargin = (UIUtils.getScreenWidth(r19.getContext()) - i()) / 2;
    L35:
        r17.add(Integer.valueOf(r110.leftMargin));
        if (j.a() == false) goto L44;
        RoundedFrameLayout r111 = new RoundedFrameLayout(this.o);
        if (r26 >= 2) goto L40;
        View r30 = r29.b();
        l(r30);
        Unit r112 = Unit.INSTANCE;
        r111.addView(r30);
    L40:
        r111.setRadius(com.bytedance.android.shopping.extensions.b.b(8));
        r19.addView(r111, r110);
        if (r26 >= 2) goto L43;
        r111 = null;
    L43:
        r18.add(r111);
    L45:
        r26 = r28;
        goto L27
    L44:
        View r31 = r29.b();
        l(r31);
        Unit r32 = Unit.INSTANCE;
        r19.addView(r31, r110);
        goto L45
    L34:
        r110.rightMargin = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(16.0f));
        goto L35
    L46:
        Unit r33 = Unit.INSTANCE;
        this.c = r19;
        this.b.addView(r19, new ViewGroup.LayoutParams(-1, -2));
        r17.add(Integer.MAX_VALUE);
        if (j.a() == false) goto L50;
        this.p.addOnPageChangeListener(new TransSmallComponent$refreshHeadViewData$5(this, r18));
    L50:
        if (Build.VERSION.SDK_INT < 23) goto L52;
        this.b.setOnScrollChangeListener(new a(this, r18, r17));
        goto L52
    L24:
        r22 = CollectionsKt.emptyList();
    L52:
        p r34 = this.p.getTabLogicInterceptor();
        if (r34 == null) goto L64;
        r34.a(this.f);
        Function0<l> r35 = r34.d;
        if (r35 == null) goto L59;
        l r36 = (l) r35.invoke();
        if (r36 == null) goto L59;
        r36.b(null, 0, null, false);
    L59:
        Function0<l> r37 = r34.d;
        if (r37 == null) goto L64;
        l r38 = (l) r37.invoke();
        if (r38 == null) goto L64;
        r38.h(false);
    L64:
        this.b.postDelayed(new b(this), 200);
    }

    public TransSmallComponent(Context r2, AnchorV4HeadViewPager r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        Intrinsics.checkNotNullParameter(r4, "headViewAction");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        ECHorizontalScrollView r5 = View.inflate(r2, 2131560512, null);
        if (r5 == null) goto L7;
        this.b = r5;
        this.d = new AnchorV4SmallTransition(this);
        this.f = CollectionsKt.emptyList();
        this.h = new ArrayList();
        this.i = LazyKt.lazy(new TransSmallComponent$screenWidth$2(this));
        this.j = LazyKt.lazy(new TransSmallComponent$smallWidth$2(this));
        this.k = LazyKt.lazy(new TransSmallComponent$mBigWidth$2(this));
        this.l = LazyKt.lazy(new TransSmallComponent$mBigMargin$2(this));
        this.m = LazyKt.lazy(new TransSmallComponent$mSmallMargin$2(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.detail.widget.ECHorizontalScrollView");
    }
}
