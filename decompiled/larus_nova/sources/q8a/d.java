package q8a;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.lynx.xelement.scroll.coordinator.childitem.ScrollCoordinatorNestedScrollView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollCoordinatorNestedScrollView f532048a;

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f532048a.f384310f == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        ScrollCoordinatorNestedScrollView r101 = this.f532048a;
        if (r101.f384310f == false) goto L12;
        r101.e(r100);
        if (r100.getAction() != 0) goto L8;
        ScrollCoordinatorNestedScrollView r102 = this.f532048a;
        r102.f(r102.f384321q);
    L8:
        if (r100.getAction() != 1) goto L11;
        ScrollCoordinatorNestedScrollView r103 = this.f532048a;
        r103.f384318n = r103.getScrollY();
        r103.f384319o = r103.f384307c.getScrollX();
        r103.postDelayed(r103.f384317m, r103.f384320p);
    L11:
        return super.onTouchEvent(r100);
    L12:
        return false;
    }

    public d(ScrollCoordinatorNestedScrollView r100, Context r101) {
        this.f532048a = r100;
        super(r101);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        ScrollCoordinatorNestedScrollView r104 = this.f532048a;
        if (r100 != r104.f384309e) goto L6;
        return;
    L6:
        if (r104.f384313i == true) goto L8;
    L13:
        r104.f(r104.f384321q);
        Iterator<ScrollCoordinatorNestedScrollView.a> r105 = r104.f384315k.iterator();
    L15:
        if (r105.hasNext() == false) goto L18;
        r105.next().onScrollChanged();
    L18:
        if (this.f532048a.f384309e == getScrollX()) goto L23;
        ScrollCoordinatorNestedScrollView r106 = this.f532048a;
        r106.f384309e = getScrollX();
        return;
    L23:
        return;
    L8:
        if (r104.f384314j == true) goto L13;
        r104.f384314j = true;
        r104.f(1);
        Iterator<ScrollCoordinatorNestedScrollView.a> r107 = r104.f384315k.iterator();
    L11:
        if (r107.hasNext() == false) goto L18;
        r107.next().a();
        goto L11
    }
}
