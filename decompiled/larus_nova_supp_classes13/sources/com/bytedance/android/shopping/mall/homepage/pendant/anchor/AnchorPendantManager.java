package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.api.e;
import com.bytedance.android.ec.hybrid.card.api.f;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.ec.hybrid.tools.d;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment$pageStateHelper$1;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorPendantManager implements ik.b {
    public static final /* synthetic */ int l = 0;
    public final Lazy a;
    public final Lazy b;
    public final of3.b c;
    public final Set<AnchorPendant> d;
    public final ConstraintLayout e;
    public int f;
    public final ViewGroup g;
    public final FrameLayout h;
    public final f i;
    public final ik.a j;
    public final com.bytedance.android.shopping.api.mall.b k;

    public static final class a {
    }

    public static final class b extends rj.a {
        public b() {
            super("anchor_pendant", 1);
        }

        public final void onTimingSetup(Map<String, ? extends Object> r10) {
            super.onTimingSetup(r10);
            e r11 = ((rj.a) this).b;
            if ((r11 instanceof ECLynxCard) == true) goto L5;
            r11 = null;
        L5:
            ECLynxCard r0 = (ECLynxCard) r11;
            if (r0 == null) goto L9;
            ECLynxCard.m(r0, true, "app", "", true, false, false, 0, 240);
            return;
        }
    }

    static {
    }

    public final void d(boolean r1) {
    }

    public final void i() {
        if (this.d.isEmpty() == false) goto L11;
        ViewParent r0 = this.e.getParent();
        if ((r0 instanceof FrameLayout) == true) goto L7;
        r0 = null;
    L7:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L12;
        r1.removeView(this.e);
        return;
    L12:
        return;
    }

    public final void a(boolean r3) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        e((AnchorPendant) r0.next());
        goto L4
    L6:
        this.d.clear();
        if (r3 == false) goto L11;
        i();
        return;
    }

    public final void e(AnchorPendant r13) {
        e r0 = r13.r.b.b;
        if ((r0 instanceof ECLynxCard) == true) goto L5;
        r0 = null;
    L5:
        ECLynxCard r3 = (ECLynxCard) r0;
        if (r3 == null) goto L8;
        ECLynxCard.m(r3, false, "app", "", false, false, false, 0, 248);
    L8:
        ViewTreeObserver r1 = r13.o.getViewTreeObserver();
        if (r1 == null) goto L12;
        r1.removeOnScrollChangedListener(r13.f);
    L12:
        if (MallSettings.a() == false) goto L14;
        r13.o.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) r13.g.getValue());
    L14:
        r13.n.removeView(r13.p);
        r13.n.removeView(r13.b);
        View r2 = r13.c;
        if ((r2 instanceof RecyclerView) == true) goto L17;
        r2 = null;
    L17:
        RecyclerView r4 = (RecyclerView) r2;
        if (r4 == null) goto L20;
        r4.removeOnScrollListener(r13);
    L20:
        com.bytedance.android.shopping.api.mall.b r5 = r13.s;
        if (r5 == null) goto L23;
        Intrinsics.checkNotNullParameter(r13, "listener");
        ((ArrayList) r5.a).remove(r13);
    L23:
        r13.c = null;
        r13.j = true;
        if (r13.r.f == false) goto L26;
    L28:
        of3.b r6 = this.c;
        com.bytedance.android.shopping.mall.homepage.pendant.anchor.b r14 = r13.r;
        String r7 = r14.a;
        of3.a r15 = r14.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "schema");
        Intrinsics.checkNotNullParameter(r15, "card");
        LinkedList<of3.a> r8 = (LinkedList) ((LinkedHashMap) r6.a).get(r7);
        if (r8 != null) goto L31;
        r8 = new LinkedList();
    L31:
        r8.offer(r15);
        r6.a.put(r7, r8);
        return;
    L26:
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L28;
        r13.r.b.b.release();
    }

    public final AnchorPendant f(String r4) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((AnchorPendant) r1).h, r4) == false) goto L4;
    L10:
        return (AnchorPendant) r1;
    L8:
        r1 = null;
        goto L10
    }

    public final AnchorPendant g(View r4) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((AnchorPendant) r1).r.c, r4) == false) goto L4;
    L10:
        return (AnchorPendant) r1;
    L8:
        r1 = null;
        goto L10
    }

    public final boolean b(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "containerID");
        AnchorPendant r5 = f(r3);
        if (r5 == null) goto L5;
        e(r5);
        this.d.remove(r5);
    L5:
        if (r4 == false) goto L7;
        i();
    L7:
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.c.b, "dismiss pendent :" + r5);
        if (r5 == null) goto L10;
        return true;
    L10:
        return false;
    }

    public final void c(int r6, int r7) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        AnchorPendant r1 = (AnchorPendant) r0.next();
        View r2 = r1.r.c;
        LynxView r4 = null;
        if ((r2 instanceof LynxView) == true) goto L8;
        r2 = null;
    L8:
        LynxView r3 = (LynxView) r2;
        if (r3 == null) goto L11;
        r3.updateScreenMetrics(r6, r7);
    L11:
        r1.o.post(new com.bytedance.android.shopping.mall.homepage.pendant.anchor.a(r1));
        LynxView r5 = r1.r.b.b;
        if ((r5 instanceof LynxView) == false) goto L15;
        r4 = r5;
    L15:
        LynxView r8 = r4;
        if (r8 == null) goto L4;
        r8.requestLayout();
        goto L4
    }

    public AnchorPendantManager(ViewGroup r2, FrameLayout r3, f r4, ik.a r5, ECMallFragment$pageStateHelper$1 r6) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "pendantContainer");
        Intrinsics.checkNotNullParameter(r4, "lynxCardLoader");
        Intrinsics.checkNotNullParameter(r5, "appStateManager");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r5.a.add(this);
        this.a = LazyKt.lazy(AnchorPendantManager$outOfScreenEnable$2.INSTANCE);
        this.b = LazyKt.lazy(AnchorPendantManager$avoidRecycleEnable$2.INSTANCE);
        this.c = new of3.b();
        this.d = new LinkedHashSet();
        this.e = new ConstraintLayout(r3.getContext());
    }

    public final Pair<String, String> h(View r21, c r22, String r23, String r24, boolean r25, boolean r26, int r27, Pair<Integer, Integer> r28, boolean r29, boolean r30, Integer r31) {
        Intrinsics.checkNotNullParameter(r21, "anchor");
        Intrinsics.checkNotNullParameter(r22, "layout");
        Intrinsics.checkNotNullParameter(r23, "schema");
        Intrinsics.checkNotNullParameter(r24, "data");
        if (this.e.getParent() != null) goto L5;
        this.h.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    L5:
        int[] r9 = new int[2];
        r21.getLocationInWindow(r9);
        boolean r10 = false;
        if (r9[0] == 0) goto L8;
    L12:
        int r11 = this.f;
        int[] r13 = new int[2];
        this.h.getLocationInWindow(r13);
        if ((r9[1] + r11) < r13[1]) goto L15;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L19;
    L22:
        if (r27 == 1) goto L24;
    L27:
        if (r27 != 2) goto L30;
        a(false);
    L30:
        if (r27 != 3) goto L126;
        if (r28 == null) goto L126;
        if (r22.e.length != 4) goto L126;
        Set<AnchorPendant> r2 = this.d;
        ArrayList r14 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L36:
        if (r3.hasNext() == false) goto L45;
        Object r15 = r3.next();
        if (((AnchorPendant) r15).r.d != r26) goto L40;
        boolean r16 = true;
    L41:
        if (r16 == false) goto L36;
        r14.add(r15);
        goto L36
    L40:
        r16 = false;
        goto L41
    L45:
        if ((!r14.isEmpty()) == true) goto L48;
        r14 = null;
    L48:
        if (r14 == null) goto L126;
        int[] r4 = new int[2];
        r21.getLocationInWindow(r4);
        int[] r17 = new int[2];
        FrameLayout r18 = this.h;
        r18.getLocationInWindow(r17);
        int r19 = r4[0];
        int r5 = r4[1];
        Rect r20 = new Rect(r19, r5, r21.getMeasuredWidth() + r19, r21.getMeasuredHeight() + r5);
        int r6 = r17[0];
        int r110 = r17[1];
        Rect r7 = new Rect(r6, r110, r18.getMeasuredWidth() + r6, r18.getMeasuredHeight() + r110);
        Rect r8 = new Rect(r20.left, r20.top, r7.right, r7.bottom);
        int r32 = ((Number) r28.getFirst()).intValue();
        int r111 = ((Number) r28.getSecond()).intValue();
        if (Intrinsics.areEqual(r22.c, "left") == false) goto L52;
    L55:
        boolean r112 = true;
    L57:
        if (r112 == false) goto L75;
        if (Intrinsics.areEqual(r22.c, "right") == false) goto L61;
        int r113 = r20.right;
        r8.left = r113;
        int r114 = r113 + d.b(r22.e[0]);
        r8.left = r114;
        r8.right = r114 + r32;
    L62:
        String r33 = r22.d;
        int r115 = r33.hashCode();
        if (r115 == 100571) goto L71;
        if (r115 == 109757538) goto L68;
    L73:
        int r34 = r20.top;
        r8.top = r34;
        int r35 = r34 + RangesKt.coerceAtLeast((r20.height() - r111) / 2, 0);
        r8.top = r35;
        r8.bottom = r35 + r111;
    L91:
        if (r8.left < r8.right) goto L93;
    L95:
        boolean r36 = false;
    L96:
        if (r36 == true) goto L99;
        r8 = null;
    L99:
        if (r8 != null) goto L101;
    L100:
        r10 = false;
        goto L126
    L101:
        Iterator r37 = r14.iterator();
    L103:
        if (r37.hasNext() == false) goto L100;
        AnchorPendant r38 = (AnchorPendant) r37.next();
        int[] r116 = new int[2];
        r38.p.getLocationInWindow(r116);
        int r117 = RangesKt.coerceAtLeast(r116[0], 0);
        int r118 = RangesKt.coerceAtLeast(r116[1], 0);
        Rect r119 = new Rect(r117, r118, r38.p.getMeasuredWidth() + r117, r38.p.getMeasuredHeight() + r118);
        if (r8.contains(r119.left, r119.top) == false) goto L107;
    L122:
        boolean r120 = true;
    L123:
        if (r120 == false) goto L103;
        b(r38.h, false);
        goto L103
    L107:
        if (r8.contains(r119.right, r119.top) == true) goto L122;
        if (r8.contains(r119.right, r119.bottom) == true) goto L122;
        if (r8.contains(r119.left, r119.bottom) == true) goto L122;
        if (r119.contains(r8.left, r8.top) == true) goto L122;
        if (r119.contains(r8.right, r8.top) == true) goto L122;
        if (r119.contains(r8.right, r8.bottom) == true) goto L122;
        if (r119.contains(r8.left, r8.bottom) == true) goto L122;
        r120 = false;
        goto L123
    L93:
        if (r8.top >= r8.bottom) goto L95;
        r36 = true;
        goto L96
    L68:
        if (r33.equals("start") == false) goto L73;
        int r39 = r20.top;
        r8.top = r39;
        int r40 = r39 + d.b(r22.e[1]);
        r8.top = r40;
        r8.bottom = r40 + r111;
        goto L91
    L71:
        if (r33.equals("end") == false) goto L73;
        int r41 = r20.bottom;
        r8.bottom = r41;
        int r42 = r41 - d.b(r22.e[3]);
        r8.bottom = r42;
        r8.top = r42 - r111;
        goto L91
    L61:
        int r121 = r20.left;
        r8.right = r121;
        int r122 = r121 - d.b(r22.e[2]);
        r8.right = r122;
        r8.left = r122 - r32;
        goto L62
    L75:
        if (Intrinsics.areEqual(r22.c, "bottom") == false) goto L77;
        int r123 = r20.bottom;
        r8.top = r123;
        int r124 = r123 + d.b(r22.e[1]);
        r8.top = r124;
        r8.bottom = r124 + r111;
    L78:
        String r125 = r22.d;
        int r126 = r125.hashCode();
        if (r126 == 100571) goto L87;
        if (r126 == 109757538) goto L84;
    L89:
        int r43 = r20.left;
        r8.left = r43;
        int r44 = r43 + RangesKt.coerceAtLeast((r20.width() - r32) / 2, 0);
        r8.left = r44;
        r8.right = r44 + r32;
        goto L91
    L84:
        if (r125.equals("start") == false) goto L89;
        int r45 = r20.left;
        r8.left = r45;
        int r46 = r45 + d.b(r22.e[0]);
        r8.left = r46;
        r8.right = r46 + r32;
        goto L91
    L87:
        if (r125.equals("end") == false) goto L89;
        int r47 = r20.right;
        r8.right = r47;
        int r48 = r47 - d.b(r22.e[2]);
        r8.right = r48;
        r8.left = r48 - r32;
        goto L91
    L77:
        int r127 = r20.top;
        r8.bottom = r127;
        int r128 = r127 - d.b(r22.e[3]);
        r8.bottom = r128;
        r8.top = r128 - r111;
        goto L78
    L52:
        if (Intrinsics.areEqual(r22.c, "right") == true) goto L55;
        r112 = false;
    L126:
        of3.b r49 = this.c;
        r49.getClass();
        Intrinsics.checkNotNullParameter(r23, "schema");
        LinkedList r50 = (LinkedList) ((LinkedHashMap) r49.a).get(r23);
        if (r50 != null) goto L129;
    L130:
        r10 = true;
    L131:
        if (r10 == true) goto L133;
        of3.a r129 = (of3.a) r50.pop();
    L134:
        if (r129 == null) goto L136;
        e r51 = r129.b;
        int r52 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r51.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r24), true);
    L137:
        of3.a r53 = r129;
        if (r25 == false) goto L140;
        int r54 = com.bytedance.android.ec.hybrid.list.a.a;
        com.bytedance.android.ec.hybrid.list.a.b(r53.a);
    L141:
        AnchorPendant r130 = new AnchorPendant(this.g, this.h, this.e, r21, r53.a, r22, new com.bytedance.android.shopping.mall.homepage.pendant.anchor.b(r23, r53, r53.b.b(), r26, r29, r30, r31), this.k, new AnchorPendantManager$show$anchorPendant$1(this));
        this.d.add(r130);
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.c.b, "show pendent :" + r130);
        return TuplesKt.to(r130.j(), "SHOW_SUCCESS");
    L140:
        int r55 = com.bytedance.android.ec.hybrid.list.a.a;
        com.bytedance.android.ec.hybrid.list.a.a(r53.a);
        goto L141
    L136:
        FrameLayout r56 = new FrameLayout(this.e.getContext());
        r129 = new of3.a(r56, this.i.IW(r56, r23, r24, null, new ViewGroup.LayoutParams(-1, -1), new b(), null));
        goto L137
    L133:
        r129 = null;
        goto L134
    L129:
        if (r50.isEmpty() == false) goto L131;
    L24:
        if ((!this.d.isEmpty()) == false) goto L27;
        return TuplesKt.to(null, "PENDANT_SET_IS_NOT_EMPTY");
    L19:
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L22;
        return TuplesKt.to(null, "ANCHOR_OUT_OF_SCREEN");
    L15:
        r12 = false;
        goto L17
    L8:
        if (r9[1] != 0) goto L12;
        if (r21.getX() <= 0.0f) goto L12;
        goto L12
    }
}
