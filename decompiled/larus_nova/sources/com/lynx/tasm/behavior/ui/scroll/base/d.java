package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.view.Choreographer;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f7a.a f382978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f382979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f382980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f382982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LynxBaseScrollViewNested f382983f;

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }

        public a() {
        }
    }

    public class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f382984a;

        public b(d r100) {
            this.f382984a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            d r101 = this.f382984a;
            int r102 = r101.f382981d;
            LynxBaseScrollViewNested r103 = r101.f382983f;
            if (r102 < 0) goto L13;
            if (r103.f382969c == false) goto L10;
            if (r103.getScrollOffsetVertically() >= r103.getScrollRangeVertically()[1]) goto L19;
        L20:
            boolean r104 = true;
        L21:
            if (r104 == false) goto L29;
            d r105 = this.f382984a;
            int r106 = r105.f382981d;
            LynxBaseScrollViewNested r107 = r105.f382983f;
            if (r107.f382969c == false) goto L25;
            int r108 = r107.getScrollY() + r106;
            int[] r109 = r107.getScrollRangeVertically();
            r107.h(Math.min(Math.max(r108, r109[0]), r109[1]));
        L27:
            if (this.f382984a.f382982e == null) goto L31;
            Choreographer.getInstance().postFrameCallback(this.f382984a.f382982e);
            return;
        L31:
            return;
        L25:
            int r110 = r107.getScrollX() + r106;
            int[] r111 = r107.getScrollRangeHorizontally();
            r107.g(Math.min(Math.max(r110, r111[0]), r111[1]));
            goto L27
        L29:
            this.f382984a.h();
            return;
        L19:
            r104 = false;
            goto L21
        L10:
            if (r103.getScrollOffsetHorizontally() < r103.getScrollRangeHorizontally()[1]) goto L20;
        L13:
            if (r103.f382969c == false) goto L18;
            if (r103.getScrollOffsetVertically() > r103.getScrollRangeVertically()[0]) goto L20;
        L18:
            if (r103.getScrollOffsetHorizontally() > r103.getScrollRangeHorizontally()[0]) goto L20;
            goto L19
        }
    }

    public interface c {
        void a(boolean r100);
    }

    public final void d() {
        if (this.f382978a.b() == false) goto L11;
        LynxBaseScrollViewNested r100 = this.f382983f;
        boolean r101 = r100.f382969c;
        int r102 = 0;
        if (r101 == false) goto L7;
        int r103 = 0;
    L8:
        if (r101 == false) goto L10;
        f7a.a.C5866a r104 = this.f382978a.f475780c;
        r102 = r104.f475786b - r104.f475787c;
    L10:
        r100.k(r103, r102, this.f382980c, null);
        f();
        return;
    L7:
        f7a.a.C5866a r105 = this.f382978a.f475779b;
        r103 = r105.f475786b - r105.f475787c;
        goto L8
    L11:
        g(true);
    }

    public final void f() {
        this.f382983f.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.f382983f.getView(), this);
    }

    public final void h() {
        if (this.f382982e == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.f382982e);
        this.f382982e = null;
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(Context r100) {
        this.f382980c = 1;
        this.f382981d = 0;
        this.f382982e = null;
        this.f382978a = new f7a.a(r100, new a());
    }

    public final void g(boolean r100) {
        this.f382983f.getView().removeCallbacks(this);
        this.f382978a.a();
        c r101 = this.f382979b;
        if (r101 == null) goto L6;
        this.f382979b = null;
        r101.a(r100);
        return;
    }

    public static int[] c(LynxBaseScrollViewNestedInternal r100, boolean r101, boolean r102) {
        int[] r103 = r100.b(r102);
        if (r102 == false) goto L5;
        int r104 = r100.getScrollOffsetVertically();
    L6:
        LynxBaseScrollViewNestedInternal r105 = r100.r5();
        if (r101 == false) goto L9;
        int r106 = r100.getForwardNestedScrollMode();
    L11:
        if (r106 == 1) goto L20;
        if (r106 != 2) goto L14;
        if (r105 == null) goto L23;
        int[] r107 = c(r105, r101, r102);
        r103[0] = r103[0] + r107[0];
        r103[1] = r103[1] + r107[1];
    L23:
        return new int[]{r103[0] - r104, r103[1] - r104};
    L14:
        if (r106 != 3) goto L23;
        if (r105 == null) goto L23;
        int[] r108 = c(r105, r101, r102);
        r103[0] = Math.max(r103[0], r108[0]);
        r103[1] = Math.max(r103[1], r108[1]);
        goto L23
    L20:
        if (r105 == null) goto L23;
        int[] r109 = c(r105, r101, r102);
        r103[0] = r103[0] + r109[0];
        r103[1] = r103[1] + r109[1];
        goto L23
    L9:
        r106 = r100.getBackwardNestedScrollMode();
        goto L11
    L5:
        r104 = r100.getScrollOffsetHorizontally();
        goto L6
    }

    public final void a(int r100, int r101, c r110) {
        g(false);
        f7a.a r102 = this.f382978a;
        int r103 = this.f382983f.getScrollX();
        int r104 = this.f382983f.getScrollY();
        int r105 = r100 - this.f382983f.getScrollX();
        int r106 = r101 - this.f382983f.getScrollY();
        r102.f475778a = 0;
        f7a.a.C5866a r107 = r102.f475779b;
        r107.f475796l = false;
        r107.f475785a = r103;
        r107.f475787c = r103;
        r107.f475786b = r103;
        r107.f475788d = r103 + r105;
        r107.f475792h = AnimationUtils.currentAnimationTimeMillis();
        r107.f475793i = 250;
        r107.f475791g = 0.0f;
        r107.f475789e = 0;
        f7a.a.C5866a r108 = r102.f475780c;
        r108.f475796l = false;
        r108.f475785a = r104;
        r108.f475787c = r104;
        r108.f475786b = r104;
        r108.f475788d = r104 + r106;
        r108.f475792h = AnimationUtils.currentAnimationTimeMillis();
        r108.f475793i = 250;
        r108.f475791g = 0.0f;
        r108.f475789e = 0;
        this.f382979b = r110;
        this.f382980c = 1;
        f();
    }

    public final void e(int r110, int r111, c r112) {
        g(false);
        LynxBaseScrollViewNested r100 = this.f382983f;
        if (r100.f382969c == false) goto L5;
        int r101 = 2;
    L6:
        r100.startNestedScroll(r101, 1);
        int[] r102 = this.f382983f.getScrollOffset();
        this.f382983f.getScrollRange();
        LynxBaseScrollViewNested r103 = this.f382983f;
        boolean r104 = r103.f382969c;
        this.f382979b = r112;
        int r105 = r102[0];
        int r106 = r102[1];
        if (r104 == false) goto L10;
        if (r111 > 0) goto L11;
    L12:
        boolean r107 = false;
    L13:
        int[] r108 = c(r103, r107, r104);
        if (this.f382983f.hasNestedScrollingParent(1) == false) goto L37;
        LynxBaseScrollViewNestedInternal r109 = this.f382983f.r5();
        if (r104 == false) goto L18;
        int r113 = r111;
    L19:
        if (r113 == 0) goto L37;
        if ((r109 instanceof LynxBaseScrollViewNestedInternal) == false) goto L37;
        boolean r114 = ((LynxBaseScrollView) r109).f382969c;
        if (r114 == false) goto L26;
        if (r111 > 0) goto L27;
    L28:
        boolean r115 = false;
    L29:
        int[] r116 = c(r109, r115, r114);
        if (r113 <= 0) goto L32;
        int r117 = this.f382983f.getForwardNestedScrollMode();
    L34:
        if (r117 != 3) goto L37;
        r108[0] = Math.min(r108[0], r116[0]);
        r108[1] = Math.max(r108[1], r116[1]);
        goto L37
    L32:
        r117 = this.f382983f.getBackwardNestedScrollMode();
    L27:
        r115 = true;
        goto L29
    L26:
        if (r110 <= 0) goto L28;
    L18:
        r113 = r110;
    L37:
        if (r104 == false) goto L39;
        int r118 = r108[0];
        int r119 = r102[1];
        int r120 = r118 + r119;
        int r121 = r108[1] + r119;
        int r122 = r105;
    L40:
        this.f382978a.c(this.f382983f.getScrollX(), this.f382983f.getScrollY(), r110, r111, r105, r122, r120, r121, Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.f382980c = 2147483632;
        f();
        return;
    L39:
        int r123 = r108[0];
        int r124 = r102[0];
        r105 = r123 + r124;
        r120 = r106;
        r121 = r120;
        r122 = r108[1] + r124;
    L11:
        r107 = true;
        goto L13
    L10:
        if (r110 <= 0) goto L12;
    L5:
        r101 = 1;
        goto L6
    }

    public final boolean i(LynxBaseScrollViewNestedInternal r100, boolean r101, c r102) {
        if (r100.d() == false) goto L18;
        if (r101 == false) goto L6;
        int r103 = r100.getScrollOffsetVertically();
    L7:
        if (r101 == false) goto L9;
        int[] r104 = r100.getScrollRangeVertically();
    L11:
        if (r100.a(r103, r104) == false) goto L15;
        b(r100, -10000, r101, r102);
        return true;
    L15:
        if (r100.c(r103, r104) == false) goto L22;
        b(r100, 10000, r101, r102);
        return true;
    L22:
        return false;
    L9:
        r104 = r100.getScrollRangeHorizontally();
        goto L11
    L6:
        r103 = r100.getScrollOffsetHorizontally();
        goto L7
    L18:
        LynxBaseScrollViewNestedInternal r105 = r100.r5();
        if (r105 != null) goto L21;
        return false;
    L21:
        return i(r105, r101, r102);
    }

    public final void b(h7a.b r210, int r310, boolean r311, c r312) {
        g(false);
        if (this.f382983f.f382969c == false) goto L5;
        int r100 = 2;
    L6:
        r210.startNestedScroll(r100, 1);
        if (r311 == false) goto L9;
        int r101 = r210.getScrollOffsetVertically();
    L10:
        if (r311 == false) goto L12;
        int[] r102 = r210.getScrollRangeVertically();
    L13:
        this.f382979b = r312;
        if (r310 < 0) goto L23;
        f7a.a r103 = this.f382978a;
        int r104 = r210.getScrollX();
        int r105 = r210.getScrollY();
        if (r311 == false) goto L18;
        int r106 = 0;
    L19:
        if (r311 == false) goto L21;
        int r110 = r310;
    L22:
        r103.c(r104, r105, r106, r110, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, (-r101) - r102[0], 0);
    L31:
        this.f382980c = 2147483634;
        f();
        return;
    L21:
        r110 = 0;
        goto L22
    L18:
        r106 = r310;
        goto L19
    L23:
        f7a.a r107 = this.f382978a;
        int r111 = r210.getScrollX();
        int r112 = r210.getScrollY();
        if (r311 == false) goto L26;
        int r211 = 0;
    L27:
        if (r311 == false) goto L29;
        int r212 = r310;
    L30:
        r107.c(r111, r112, r211, r212, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, r101 - r102[1]);
        goto L31
    L29:
        r212 = 0;
        goto L30
    L26:
        r211 = r310;
        goto L27
    L12:
        r102 = r210.getScrollRangeHorizontally();
        goto L13
    L9:
        r101 = r210.getScrollOffsetHorizontally();
        goto L10
    L5:
        r100 = 1;
        goto L6
    }
}
