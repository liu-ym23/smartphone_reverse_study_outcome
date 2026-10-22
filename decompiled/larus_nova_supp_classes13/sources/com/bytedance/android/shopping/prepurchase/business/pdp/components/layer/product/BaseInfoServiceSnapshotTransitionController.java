package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BaseInfoServiceSnapshotTransitionController {
    public boolean a;
    public f b;
    public c c;
    public c d;
    public a e;
    public e f;
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.a g;
    public int h;
    public boolean i;
    public String j;
    public boolean k;
    public int l;
    public d m;
    public final Handler n;
    public final int[] o;
    public final int[] p;
    public final RecyclerView q;
    public final ProductDetailInfoAdapter r;
    public final vg3.v s;
    public final Function0<Window> t;

    public static final class a {
        public final BitmapDrawable a;
        public final ColorDrawable b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            BitmapDrawable r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            ColorDrawable r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ActiveOverlay(snapshotDrawable=" + this.a + ", whiteDrawable=" + this.b + ")";
        }

        public a(BitmapDrawable r2, ColorDrawable r3) {
            Intrinsics.checkNotNullParameter(r2, "snapshotDrawable");
            Intrinsics.checkNotNullParameter(r3, "whiteDrawable");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final com.bytedance.android.ecom.arch.slice.g a;
        public final com.bytedance.android.ecom.arch.slice.slices.a b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.ecom.arch.slice.g r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.ecom.arch.slice.slices.a r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AttachedSlice(slice=" + this.a + ", holder=" + this.b + ")";
        }

        public b(com.bytedance.android.ecom.arch.slice.g r2, com.bytedance.android.ecom.arch.slice.slices.a r3) {
            Intrinsics.checkNotNullParameter(r2, "slice");
            Intrinsics.checkNotNullParameter(r3, "holder");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final RecyclerView a;
        public final Rect b;
        public final boolean c;
        public final Bitmap d;
        public final Integer e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L16;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public final int hashCode() {
            RecyclerView r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Rect r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            ?? r8 = r7;
            if (r7 == false) goto L13;
            r8 = 1;
        L13:
            int r9 = (r6 + r8) * 31;
            Bitmap r10 = this.d;
            if (r10 == null) goto L16;
            int r11 = r10.hashCode();
        L17:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.e;
            if (r13 == null) goto L21;
            r1 = r13.hashCode();
        L21:
            return r12 + r1;
        L16:
            r11 = 0;
            goto L17
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CachedSnapshot(host=" + this.a + ", bounds=" + this.b + ", isExpanded=" + this.c + ", bitmap=" + this.d + ", topFromHeaderBottom=" + this.e + ")";
        }

        public c(RecyclerView r2, Rect r3, boolean r4, Bitmap r5, Integer r6) {
            Intrinsics.checkNotNullParameter(r2, "host");
            Intrinsics.checkNotNullParameter(r3, "bounds");
            Intrinsics.checkNotNullParameter(r5, "bitmap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final boolean c;
        public final Rect d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L14;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            boolean r1 = this.c;
            ?? r2 = r1;
            if (r1 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = (r0 + r2) * 31;
            Rect r4 = this.d;
            if (r4 == null) goto L8;
            int r5 = r4.hashCode();
        L10:
            return r3 + r5;
        L8:
            r5 = 0;
            goto L10
        }

        public final String toString() {
            return "PendingCapture(requestId=" + this.a + ", generation=" + this.b + ", isExpanded=" + this.c + ", bounds=" + this.d + ")";
        }

        public d(int r2, int r3, boolean r4, Rect r5) {
            Intrinsics.checkNotNullParameter(r5, "bounds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class e {
        public final ViewTreeObserver.OnPreDrawListener a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((e) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ViewTreeObserver.OnPreDrawListener r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "PendingPreDraw(listener=" + this.a + ")";
        }

        public e(h r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.a = r2;
        }
    }

    public static final class f {
        public final boolean a;
        public final Rect b;
        public final View c;
        public final Integer d;
        public float e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L16;
            f r4 = (f) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Float.compare(this.e, r4.e) == 0) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            Rect r3 = this.b;
            int r4 = 0;
            if (r3 == null) goto L8;
            int r5 = r3.hashCode();
        L9:
            int r6 = (r2 + r5) * 31;
            View r7 = this.c;
            if (r7 == null) goto L12;
            int r8 = r7.hashCode();
        L13:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 == null) goto L17;
            r4 = r10.hashCode();
        L17:
            return ((r9 + r4) * 31) + Float.floatToIntBits(this.e);
        L12:
            r8 = 0;
            goto L13
        L8:
            r5 = 0;
            goto L9
        }

        public final String toString() {
            return "Transition(targetExpanded=" + this.a + ", snapshotBounds=" + this.b + ", headerView=" + this.c + ", snapshotTopFromHeaderBottom=" + this.d + ", progress=" + this.e + ")";
        }

        public f(boolean r2, Rect r3, View r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r3, "snapshotBounds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = 0.0f;
        }
    }

    public static final class g {
        public final com.bytedance.android.ecom.arch.slice.p a;
        public final com.bytedance.android.ecom.arch.slice.slices.a b;
        public final View c;
        public final Rect d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof g) == false) goto L14;
            g r4 = (g) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.ecom.arch.slice.p r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.ecom.arch.slice.slices.a r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            View r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Rect r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TransitionTarget(baseInfoGroup=" + this.a + ", serviceHolder=" + this.b + ", headerView=" + this.c + ", bounds=" + this.d + ")";
        }

        public g(com.bytedance.android.ecom.arch.slice.p r2, com.bytedance.android.ecom.arch.slice.slices.a r3, View r4, Rect r5) {
            Intrinsics.checkNotNullParameter(r2, "baseInfoGroup");
            Intrinsics.checkNotNullParameter(r5, "bounds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class h implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ BaseInfoServiceSnapshotTransitionController a;
        public final /* synthetic */ Function0 b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a.q.getViewTreeObserver().isAlive() == false) goto L5;
            this.a.q.getViewTreeObserver().removeOnPreDrawListener(this);
        L5:
            this.a.f = null;
            this.b.invoke();
            return true;
        }

        public h(BaseInfoServiceSnapshotTransitionController r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final g e() {
        if (ViewCompat.isAttachedToWindow(this.q) == true) goto L5;
    L141:
        g("recycler_not_ready");
        return null;
    L5:
        if (this.q.getWidth() <= 0) goto L141;
        if (this.q.getHeight() <= 0) goto L141;
        final String r2 = "BaseInfoGroupV2";
        b r0 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r2));
        if (r0 != null) goto L12;
        final String r3 = "BaseInfoGroup";
        r0 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r3));
    L12:
        if (r0 != null) goto L14;
        r0 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedBaseInfoGroup$1(this));
    L14:
        if (r0 != null) goto L17;
        g("base_info_not_attached");
        return null;
    L17:
        com.bytedance.android.ecom.arch.slice.g r4 = r0.a;
        if ((r4 instanceof com.bytedance.android.ecom.arch.slice.p) == true) goto L20;
        r4 = null;
    L20:
        com.bytedance.android.ecom.arch.slice.p r5 = (com.bytedance.android.ecom.arch.slice.p) r4;
        if (r5 != null) goto L24;
        g("base_info_not_group");
        return null;
    L24:
        RecyclerView r1 = r0.b.s0();
        final String r6 = "service";
        b r7 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r6));
        if (r7 == null) goto L27;
        com.bytedance.android.ecom.arch.slice.g r8 = r7.a;
    L29:
        if ((r8 instanceof com.bytedance.android.ecom.arch.slice.p) == true) goto L31;
        r8 = null;
    L31:
        com.bytedance.android.ecom.arch.slice.p r9 = (com.bytedance.android.ecom.arch.slice.p) r8;
        if (r9 != null) goto L47;
        List<com.bytedance.android.ecom.arch.slice.g> r10 = this.r.E2();
        ArrayList r11 = new ArrayList();
        Iterator r12 = ((ArrayList) r10).iterator();
    L35:
        if (r12.hasNext() == false) goto L39;
        Object r13 = r12.next();
        if ((r13 instanceof com.bytedance.android.ecom.arch.slice.p) == false) goto L35;
        r11.add(r13);
        goto L35
    L39:
        Iterator r14 = r11.iterator();
    L41:
        if (r14.hasNext() == false) goto L45;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.p) r15).getSliceId(), "service") == false) goto L41;
    L46:
        r9 = (com.bytedance.android.ecom.arch.slice.p) r15;
        goto L47
    L45:
        r15 = null;
    L47:
        if (r9 != null) goto L50;
        g("service_group_missing");
        return null;
    L50:
        if (r7 == null) goto L52;
        com.bytedance.android.ecom.arch.slice.slices.a r16 = r7.b;
    L53:
        if (r16 == null) goto L59;
        View r17 = r16.s0();
        if (r17 == null) goto L59;
        if (f(r17) == false) goto L59;
    L61:
        if (f(r1) == true) goto L65;
        g("base_info_view_detached");
        return null;
    L65:
        if ((r1 instanceof RecyclerView) == true) goto L67;
        RecyclerView r18 = null;
    L68:
        RecyclerView r19 = r18;
        if (r19 == null) goto L91;
        int r20 = r19.getChildCount();
        int r21 = 0;
    L72:
        if (r21 >= r20) goto L91;
        View r22 = r19.getChildAt(r21);
        int r110 = com.bytedance.android.ecom.arch.slice.adapter.e.e;
        Intrinsics.checkNotNullParameter(r22, FreqActions.ACTION_VIEW);
        Object r111 = r22.getTag(2131386876);
        if ((r111 instanceof com.bytedance.android.ecom.arch.slice.adapter.b) == true) goto L76;
        r111 = null;
    L76:
        com.bytedance.android.ecom.arch.slice.adapter.b r112 = (com.bytedance.android.ecom.arch.slice.adapter.b) r111;
        if ((r112 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L79;
        r112 = null;
    L79:
        com.bytedance.android.ecom.arch.slice.g r113 = (com.bytedance.android.ecom.arch.slice.g) r112;
        if (r113 == null) goto L87;
        if (Intrinsics.areEqual(r113.getSliceId(), "title_v2") == true) goto L89;
        if (Intrinsics.areEqual(r113.getViewType(), "pfz_title") == false) goto L87;
    L89:
        if (f(r22) == false) goto L91;
    L92:
        if (r22 != null) goto L95;
        g("title_not_attached");
        return null;
    L95:
        final String r23 = "BaseInfoOffset";
        b r24 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r23));
        if (r24 == null) goto L104;
        com.bytedance.android.ecom.arch.slice.slices.a r25 = r24.b;
        if (r25 == null) goto L104;
        View r26 = r25.s0();
        if (r26 == null) goto L104;
        if (f(r26) == false) goto L104;
    L105:
        List r27 = CollectionsKt.distinct(CollectionsKt.plus(CollectionsKt.listOf(r1), CollectionsKt.listOfNotNull(new View[]{r17, r26})));
        if (r22.getVisibility() != 8) goto L108;
    L123:
        Rect r28 = null;
    L124:
        if (r28 != null) goto L127;
        g("target_bounds_empty");
        return null;
    L127:
        int r29 = this.q.getChildCount();
        int r30 = 0;
    L128:
        if (r30 >= r29) goto L138;
        View r31 = this.q.getChildAt(r30);
        int r32 = this.q.getChildAdapterPosition(r31);
        if (r32 == (-1)) goto L137;
        if ((DiffableAdapter.DefaultImpls.getItem$default(this.r, r32, false, 2, null) instanceof AnchorV4HeadV2VO) == false) goto L137;
        if (f(r31) == false) goto L138;
    L139:
        this.j = null;
        return new g(r5, r16, r31, r28);
    L137:
        r30 = r30 + 1;
    L138:
        r31 = null;
        goto L139
    L108:
        if (r22.getHeight() <= 0) goto L123;
        this.q.getLocationInWindow(this.o);
        r22.getLocationInWindow(this.p);
        int r33 = (this.p[1] - this.o[1]) + r22.getHeight();
        Iterator r34 = r27.iterator();
        int r35 = Integer.MIN_VALUE;
    L112:
        if (r34.hasNext() == false) goto L119;
        View r114 = (View) r34.next();
        if (r114.getVisibility() == 8) goto L112;
        if (r114.getHeight() <= 0) goto L112;
        r114.getLocationInWindow(this.p);
        r35 = Math.max(r35, (this.p[1] - this.o[1]) + r114.getHeight());
        goto L112
    L119:
        int r36 = RangesKt.coerceAtLeast(r33, 0);
        int r37 = RangesKt.coerceAtMost(r35, this.q.getHeight());
        if (r37 <= r36) goto L123;
        r28 = new Rect(0, r36, this.q.getWidth(), r37);
    L104:
        r26 = null;
    L87:
        r21 = r21 + 1;
    L91:
        r22 = null;
        goto L92
    L67:
        r18 = r1;
    L59:
        r17 = null;
        goto L61
    L52:
        r16 = null;
        goto L53
    L27:
        r8 = null;
        goto L29
    }

    public final void j() {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.a r0 = this.g;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.q.getViewTreeObserver().isAlive() == false) goto L8;
        this.q.getViewTreeObserver().removeOnPreDrawListener(r0);
    L8:
        this.g = null;
    }

    public final void k() {
        e r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.q.getViewTreeObserver().isAlive() == false) goto L8;
        this.q.getViewTreeObserver().removeOnPreDrawListener(r0.a);
    L8:
        this.f = null;
    }

    public final void c() {
        j();
        a r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        this.q.getOverlay().remove(r0.a);
        this.q.getOverlay().remove(r0.b);
        r0.a.setCallback(null);
        r0.b.setCallback(null);
        this.e = null;
    }

    public final b d(Function1<? super String, Boolean> r9) {
        int r0 = this.q.getChildCount();
        int r2 = 0;
    L3:
        com.bytedance.android.ecom.arch.slice.slices.a r3 = null;
        if (r2 >= r0) goto L29;
        View r4 = this.q.getChildAt(r2);
        int r5 = this.q.getChildAdapterPosition(r4);
        if (r5 == (-1)) goto L26;
        Object r6 = DiffableAdapter.DefaultImpls.getItem$default(this.r, r5, false, 2, null);
        if ((r6 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L11;
        r6 = null;
    L11:
        com.bytedance.android.ecom.arch.slice.g r7 = (com.bytedance.android.ecom.arch.slice.g) r6;
        if (r7 == null) goto L26;
        String r8 = r7.getSliceId();
        if (r8 == null) goto L26;
        if (((Boolean) r9.invoke(r8)).booleanValue() == false) goto L26;
        com.bytedance.android.ecom.arch.slice.slices.a r10 = this.q.getChildViewHolder(r4);
        if ((r10 instanceof com.bytedance.android.ecom.arch.slice.slices.a) == false) goto L24;
        r3 = r10;
    L24:
        com.bytedance.android.ecom.arch.slice.slices.a r11 = r3;
        if (r11 == null) goto L26;
        return new b(r7, r11);
    L26:
        r2 = r2 + 1;
        goto L3
    L29:
        return null;
    }

    public final boolean f(View r3) {
        if (ViewCompat.isAttachedToWindow(r3) == true) goto L5;
        return false;
    L5:
        ViewParent r4 = r3.getParent();
    L6:
        if (r4 == null) goto L12;
        if (r4 == this.q) goto L9;
        r4 = r4.getParent();
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public final void g(String r4) {
        if (Intrinsics.areEqual(this.j, r4) == false) goto L5;
        return;
    L5:
        this.j = r4;
        dm.a.a("PdpSnapshotTransition").b("skip reason=" + r4 + " childCount=" + this.q.getChildCount(), null);
    }

    public final void h(final boolean r5) {
        if (this.i == false) goto L5;
        return;
    L5:
        f r0 = this.b;
        this.a = r5;
        this.k = false;
        this.h++;
        k();
        j();
        if (r0 != null) goto L10;
        n(e(), r5);
        i(r5);
        return;
    L10:
        if (r5 == r0.a) goto L14;
        a r1 = this.e;
        if (r1 == null) goto L14;
        r1.a.setAlpha(255);
        r1.b.setAlpha(0);
    L14:
        n(e(), r5);
        this.b = null;
        final int r2 = this.h;
        l(new BaseInfoServiceSnapshotTransitionController$onSettled$2(this, r2, r5));
    }

    public final void i(final boolean r3) {
        if (this.i == false) goto L5;
        return;
    L5:
        if (this.b != null) goto L20;
        this.a = r3;
        if (r3 == false) goto L10;
        c r0 = this.d;
    L11:
        if (r0 == null) goto L13;
        RecyclerView r1 = r0.a;
    L15:
        if (r1 != this.q) goto L17;
        return;
    L17:
        l(new BaseInfoServiceSnapshotTransitionController$prepareStableSnapshot$1(this, r3));
        return;
    L13:
        r1 = null;
        goto L15
    L10:
        r0 = this.c;
        goto L11
    }

    public final void l(Function0<Unit> r2) {
        k();
        if (ViewCompat.isAttachedToWindow(this.q) == true) goto L6;
        r2.invoke();
        return;
    L6:
        h r0 = new h(this, r2);
        this.f = new e(r0);
        this.q.getViewTreeObserver().addOnPreDrawListener(r0);
        this.q.invalidate();
    }

    public final void m(f r12) {
        a r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r1 = r12.d;
        if (r1 == null) goto L17;
        int r2 = r1.intValue();
        View r3 = r12.c;
        Integer r4 = null;
        if (r3 != null) goto L10;
    L15:
        if (r4 == null) goto L17;
        int r5 = r4.intValue();
    L18:
        boolean r6 = r12.a;
        if (r6 == false) goto L21;
        float r7 = 0.0f;
    L22:
        if (r6 == false) goto L24;
        float r8 = 0.42f;
    L25:
        if (r6 == false) goto L27;
        float r9 = 0.1f;
    L28:
        if (r6 == false) goto L30;
        float r10 = 0.58f;
    L31:
        float r11 = RangesKt.coerceIn((r12.e - r7) / (r8 - r7), 0.0f, 1.0f);
        float r13 = RangesKt.coerceIn((r12.e - r9) / (r10 - r9), 0.0f, 1.0f);
        r0.a.setAlpha(RangesKt.coerceIn(MathKt.roundToInt((1.0f - ((r11 * r11) * (3.0f - (r11 * 2.0f)))) * 255.0f), 0, 255));
        r0.b.setAlpha(RangesKt.coerceIn(MathKt.roundToInt((1.0f - ((r13 * r13) * (3.0f - (r13 * 2.0f)))) * 255.0f), 0, 255));
        BitmapDrawable r14 = r0.a;
        Rect r15 = r12.b;
        r14.setBounds(r15.left, r5, r15.right, r15.height() + r5);
        r0.b.setBounds(r0.a.getBounds());
        return;
    L30:
        r10 = 0.92f;
        goto L31
    L27:
        r9 = 0.32f;
        goto L28
    L24:
        r8 = 0.6f;
        goto L25
    L21:
        r7 = 0.05f;
        goto L22
    L10:
        if (f(r3) == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        this.q.getLocationInWindow(this.o);
        r3.getLocationInWindow(this.p);
        r4 = Integer.valueOf(((this.p[1] - this.o[1]) + r3.getHeight()) + r2);
    L17:
        r5 = r12.b.top;
        goto L18
    }

    public final void n(g r5, boolean r6) {
        this.r.F2(r6);
        boolean r0 = this.s.Y0(r6);
        dm.a.b r1 = dm.a.a("PdpSnapshotTransition");
        StringBuilder r2 = new StringBuilder("update target expanded=");
        r2.append(r6);
        r2.append(" dispatched=");
        r2.append(r0);
        r2.append(" baseInfo=");
        if (r5 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.p r3 = r5.a;
        if (r3 == null) goto L7;
        String r4 = r3.getSliceId();
    L8:
        r2.append(r4);
        r2.append(" serviceAttached=");
        if (r5 == null) goto L11;
        com.bytedance.android.ecom.arch.slice.slices.a r7 = r5.b;
    L12:
        if (r7 == null) goto L14;
        boolean r8 = true;
    L15:
        r2.append(r8);
        r1.b(r2.toString(), null);
        return;
    L14:
        r8 = false;
        goto L15
    L11:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static final void a(final BaseInfoServiceSnapshotTransitionController r12, g r13, final boolean r14) {
        if (r12.b == null) goto L5;
        return;
    L5:
        if (r12.e != null) goto L65;
        if (r14 == false) goto L9;
        c r0 = r12.d;
    L11:
        if (r0 == null) goto L13;
        RecyclerView r1 = r0.a;
    L15:
        if (r1 == r12.q) goto L66;
        Rect r5 = new Rect(r13.d);
        View r2 = r13.c;
        if (r2 == null) goto L20;
        r12.q.getLocationInWindow(r12.o);
        r2.getLocationInWindow(r12.p);
        Integer r9 = Integer.valueOf(r13.d.top - ((r12.p[1] - r12.o[1]) + r2.getHeight()));
    L21:
        final int r15 = r12.h;
        d r3 = r12.m;
        if (r3 != null) goto L24;
    L30:
        final int r4 = r12.l + 1;
        r12.l = r4;
        r12.m = new d(r4, r15, r14, r5);
        Function1<c, Unit> r10 = new BaseInfoServiceSnapshotTransitionController$captureStableSnapshot$1(r12, r4, r15, r14);
        if (ViewCompat.isAttachedToWindow(r12.q) == true) goto L33;
    L53:
        r12.g("capture_invalid_bounds:" + r5);
        r10.invoke(null);
        return;
    L33:
        if (r5.width() <= 0) goto L53;
        if (r5.height() <= 0) goto L53;
        if (Build.VERSION.SDK_INT < 26) goto L52;
        Window r16 = (Window) r12.t.invoke();
        if (r16 != null) goto L42;
        r12.g("capture_window_missing");
        r10.invoke(null);
        return;
    L42:
        r12.q.getLocationInWindow(r12.o);
        int[] r6 = r12.o;
        int r7 = r6[0];
        int r8 = r5.left + r7;
        int r11 = r6[1];
        Rect r17 = new Rect(r8, r5.top + r11, r7 + r5.right, r11 + r5.bottom);
        Bitmap r18 = Bitmap.createBitmap(r5.width(), r5.height(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L48 IllegalArgumentException -> L50
        PixelCopy.request(r16, r17, r18, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.b(r12, r5, r14, r10, r18, r9), r12.n);     // Catch: IllegalArgumentException -> L46
        return;
    L46:
        e = move-exception;
        r12.g("capture_pixel_copy_illegal_argument:" + e.getMessage());
        r10.invoke(null);
        return;
    L50:
        e = move-exception;
        r12.g("capture_illegal_argument:" + e.getMessage());
        r10.invoke(null);
        return;
    L48:
        e = move-exception;
        r12.g("capture_oom:" + e.getMessage());
        r10.invoke(null);
        return;
    L52:
        r10.invoke(r12.b(r5, r14, r9));
        return;
    L24:
        if (r3.b != r15) goto L30;
        if (r3.c != r14) goto L30;
        if (Intrinsics.areEqual(r3.d, r5) == false) goto L30;
        return;
    L20:
        r9 = null;
        goto L21
    L66:
        return;
    L13:
        r1 = null;
        goto L15
    L9:
        r0 = r12.c;
        goto L11
    }

    public final c b(Rect r12, boolean r13, Integer r14) {
        if (ViewCompat.isAttachedToWindow(this.q) == true) goto L5;
    L16:
        g("capture_invalid_bounds:" + r12);
        return null;
    L5:
        if (r12.width() <= 0) goto L16;
        if (r12.height() <= 0) goto L16;
        Bitmap r9 = Bitmap.createBitmap(r12.width(), r12.height(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        Canvas r1 = new Canvas(r9);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        r1.translate(-r12.left, -r12.top);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        this.q.draw(r1);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        this.j = null;     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        dm.a.a("PdpSnapshotTransition").b("capture success mode=canvas bounds=" + r12 + " expanded=" + r13, null);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
    L20:
        return new c(this.q, new Rect(r12), r13, r9, r14);
    L13:
        e = move-exception;
        g("capture_illegal_argument:" + e.getMessage());
        return null;
    L11:
        e = move-exception;
        g("capture_oom:" + e.getMessage());
        return null;
    }

    public BaseInfoServiceSnapshotTransitionController(BasePdpRecyclerView r2, ProductDetailInfoAdapter r3, vg3.v r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "dynamicFeatureAbility");
        Intrinsics.checkNotNullParameter(r5, "containerWindowProvider");
        this.q = r2;
        this.r = r3;
        this.s = r4;
        this.t = r5;
        this.n = new Handler(Looper.getMainLooper());
        this.o = new int[2];
        this.p = new int[2];
    }
}
