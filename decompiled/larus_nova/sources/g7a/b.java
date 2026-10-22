package g7a;

import android.view.View;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParentHelper;
import com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView;
import com.lynx.tasm.behavior.ui.scroll.NestedScrollView;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f480337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f480338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f480339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f480340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f480341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f480342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollingParentHelper f480343g;

    public final void a() {
        int r100 = this.f480340d.getScrollX();
        int r101 = this.f480340d.getScrollY();
        boolean r102 = this.f480337a;
        if (r102 == true) goto L12;
        View r103 = this.f480340d;
        if ((r103 instanceof NestedHorizontalScrollView) == false) goto L12;
        NestedHorizontalScrollView r104 = (NestedHorizontalScrollView) r103;
        if (this.f480338b == false) goto L10;
        r104.b(this.f480342f, r101);
        this.f480338b = false;
        return;
    L10:
        if (this.f480339c == false) goto L23;
        r104.b(this.f480342f, r101);
        this.f480339c = false;
        return;
    L23:
        return;
    L12:
        if (r102 == false) goto L25;
        View r105 = this.f480340d;
        if ((r105 instanceof NestedScrollView) == false) goto L26;
        NestedScrollView r106 = (NestedScrollView) r105;
        if (this.f480338b == false) goto L19;
        r106.a(r100, this.f480342f);
        this.f480338b = false;
        return;
    L19:
        if (this.f480339c == false) goto L28;
        r106.a(r100, this.f480342f);
        this.f480339c = false;
        return;
    L28:
        return;
    L26:
        return;
    }

    public final boolean b() {
        boolean r100 = this.f480337a;
        if (r100 == true) goto L11;
        View r101 = this.f480340d;
        if ((r101 instanceof NestedHorizontalScrollView) == false) goto L11;
        OverScroller r102 = ((NestedHorizontalScrollView) r101).getHScroller();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r102.isFinished() == true) goto L21;
        return true;
    L21:
        return false;
    L11:
        if (r100 == false) goto L22;
        View r103 = this.f480340d;
        if ((r103 instanceof NestedScrollView) == false) goto L23;
        OverScroller r104 = ((NestedScrollView) r103).getVScroller();
        if (r104 != null) goto L17;
        return false;
    L17:
        if (r104.isFinished() == true) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    public final void e(int r100) {
        int r101 = this.f480340d.getScrollX();
        int r102 = this.f480340d.getScrollY();
        if (1 != r100) goto L5;
        return;
    L5:
        boolean r103 = this.f480337a;
        if (r103 == true) goto L13;
        View r104 = this.f480340d;
        if ((r104 instanceof NestedHorizontalScrollView) == false) goto L13;
        NestedHorizontalScrollView r105 = (NestedHorizontalScrollView) r104;
        int r106 = this.f480342f;
        if (r101 == r106) goto L12;
        r105.b(r106, r102);
    L12:
        r105.stopNestedScroll(r100);
        return;
    L13:
        if (r103 == false) goto L22;
        View r107 = this.f480340d;
        if ((r107 instanceof NestedScrollView) == false) goto L23;
        NestedScrollView r108 = (NestedScrollView) r107;
        int r109 = this.f480342f;
        if (r102 == r109) goto L19;
        r108.a(r101, r109);
    L19:
        r108.stopNestedScroll(r100);
        return;
    L23:
        return;
    }

    public b(View r100, boolean r101, NestedScrollingParentHelper r102) {
        this.f480340d = r100;
        this.f480337a = r101;
        this.f480343g = r102;
    }

    public final void c(View r100, int r101, int r110, int[] r111, int r112) {
        if (1 != r112) goto L5;
        return;
    L5:
        int r113 = this.f480340d.getScrollX();
        int r102 = this.f480340d.getScrollY();
        boolean r103 = this.f480337a;
        if (r103 == true) goto L40;
        View r104 = this.f480340d;
        if ((r104 instanceof NestedHorizontalScrollView) == false) goto L40;
        NestedHorizontalScrollView r105 = (NestedHorizontalScrollView) r104;
        int r114 = this.f480341e;
        int r106 = this.f480342f;
        if (r100.canScrollHorizontally(-1) == true) goto L17;
        if (r101 >= 0) goto L17;
        if ((r113 + r101) >= 0) goto L15;
        r105.scrollTo(0, r102);
    L16:
        r111[0] = r101;
    L25:
        if (r100.canScrollHorizontally(1) == true) goto L32;
        if (r101 <= 0) goto L32;
        if ((r113 + r101) <= r114) goto L30;
        r105.scrollTo(r114, r102);
    L31:
        r111[0] = r101;
        return;
    L30:
        r105.requestDisallowInterceptTouchEvent(true);
        r105.scrollBy(r101, 0);
    L32:
        if (r106 >= r113) goto L76;
        if (r113 > r114) goto L77;
        if (r101 >= 0) goto L78;
        r105.requestDisallowInterceptTouchEvent(true);
        if ((r113 + r101) >= r106) goto L38;
        r105.scrollBy(r106 - r113, 0);
    L39:
        r111[0] = r101;
        return;
    L38:
        r105.scrollBy(r101, 0);
        goto L39
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L15:
        r105.requestDisallowInterceptTouchEvent(true);
        r105.scrollBy(r101, 0);
    L17:
        if (r113 >= r106) goto L25;
        if (r101 <= 0) goto L25;
        r105.requestDisallowInterceptTouchEvent(true);
        if ((r113 + r101) <= r106) goto L22;
        r105.scrollBy(r106 - r113, 0);
    L23:
        r111[0] = r101;
        goto L25
    L22:
        r105.scrollBy(r101, 0);
    L40:
        if (r103 == false) goto L80;
        View r107 = this.f480340d;
        if ((r107 instanceof NestedScrollView) == false) goto L81;
        NestedScrollView r108 = (NestedScrollView) r107;
        int r109 = this.f480341e;
        int r115 = this.f480342f;
        if (r100.canScrollVertically(-1) == true) goto L51;
        if (r110 >= 0) goto L51;
        if ((r102 + r110) >= 0) goto L49;
        r108.scrollTo(r113, 0);
    L50:
        r111[1] = r110;
    L59:
        if (r100.canScrollVertically(1) == true) goto L66;
        if (r110 <= 0) goto L66;
        if ((r102 + r110) <= r109) goto L64;
        r108.scrollTo(r113, r109);
    L65:
        r111[1] = r110;
        return;
    L64:
        r108.requestDisallowInterceptTouchEvent(true);
        r108.scrollBy(0, r110);
    L66:
        if (r115 >= r102) goto L83;
        if (r102 > r109) goto L84;
        if (r110 >= 0) goto L85;
        r108.requestDisallowInterceptTouchEvent(true);
        if ((r102 + r110) >= r115) goto L72;
        r108.scrollBy(0, r115 - r102);
    L73:
        r111[1] = r110;
        return;
    L72:
        r108.scrollBy(0, r110);
        goto L73
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L49:
        r108.requestDisallowInterceptTouchEvent(true);
        r108.scrollBy(0, r110);
    L51:
        if (r102 >= r115) goto L59;
        if (r110 <= 0) goto L59;
        r108.requestDisallowInterceptTouchEvent(true);
        if ((r102 + r110) <= r115) goto L56;
        r108.scrollBy(0, r115 - r102);
    L57:
        r111[1] = r110;
        goto L59
    L56:
        r108.scrollBy(0, r110);
        goto L57
    L81:
        return;
    }

    public final void d(int r100, int r101, int r102, int r110, int r111) {
        if (r111 != 0) goto L4;
        return;
    L4:
        int r112 = this.f480340d.getScrollX();
        int r103 = this.f480340d.getScrollY();
        boolean r104 = this.f480337a;
        if (r104 == true) goto L31;
        View r105 = this.f480340d;
        if ((r105 instanceof NestedHorizontalScrollView) == false) goto L31;
        NestedHorizontalScrollView r106 = (NestedHorizontalScrollView) r105;
        OverScroller r107 = r106.getHScroller();
        if (r107 != null) goto L11;
        return;
    L11:
        int r113 = this.f480341e;
        int r108 = this.f480342f;
        boolean r109 = this.f480338b;
        if (r109 == true) goto L16;
        if (r100 >= 0) goto L16;
        if (r102 >= 0) goto L16;
        r106.b(0, r103);
        this.f480338b = true;
    L21:
        boolean r114 = this.f480339c;
        if (r114 == true) goto L26;
        if (r100 <= 0) goto L26;
        if (r102 <= 0) goto L26;
        r106.b(r113, r103);
        this.f480339c = true;
        return;
    L26:
        if (r114 == false) goto L59;
        if (r112 == r113) goto L29;
        return;
    L29:
        if (r107.isFinished() == false) goto L61;
        r106.b(r108, r103);
        this.f480339c = false;
        return;
    L61:
        return;
    L59:
        return;
    L16:
        if (r109 == false) goto L21;
        if (r112 != 0) goto L21;
        if (r107.isFinished() == false) goto L21;
        r106.b(r108, r103);
        this.f480338b = false;
    L31:
        if (r104 == false) goto L63;
        View r115 = this.f480340d;
        if ((r115 instanceof NestedScrollView) == false) goto L64;
        NestedScrollView r116 = (NestedScrollView) r115;
        OverScroller r117 = r116.getVScroller();
        if (r117 != null) goto L37;
        return;
    L37:
        int r118 = this.f480341e;
        int r119 = this.f480342f;
        boolean r120 = this.f480338b;
        if (r120 == true) goto L42;
        if (r101 >= 0) goto L42;
        if (r110 >= 0) goto L42;
        r116.a(r112, 0);
        this.f480338b = true;
    L47:
        boolean r121 = this.f480339c;
        if (r121 == true) goto L52;
        if (r101 <= 0) goto L52;
        if (r110 <= 0) goto L52;
        r116.a(r112, r118);
        this.f480339c = true;
        return;
    L52:
        if (r121 == false) goto L66;
        if (r103 == r118) goto L55;
        return;
    L55:
        if (r117.isFinished() == false) goto L68;
        r116.a(r112, r119);
        this.f480339c = false;
        return;
    L68:
        return;
    L66:
        return;
    L42:
        if (r120 == false) goto L47;
        if (r103 != 0) goto L47;
        if (r117.isFinished() == false) goto L47;
        r116.a(r112, r119);
        this.f480338b = false;
        goto L47
    L64:
        return;
    }
}
