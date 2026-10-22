package s86;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.bytedance.ies.xelement.viewpager.childitem.AndroidNestedScrollView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidNestedScrollView f540967a;

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f540967a.f250506f == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        AndroidNestedScrollView r101 = this.f540967a;
        if (r101.f250506f == false) goto L12;
        r101.e(r100);
        if (r100.getAction() != 0) goto L8;
        AndroidNestedScrollView r102 = this.f540967a;
        r102.f(r102.f250517q);
    L8:
        if (r100.getAction() != 1) goto L11;
        AndroidNestedScrollView r103 = this.f540967a;
        r103.f250514n = r103.getScrollY();
        r103.f250515o = r103.f250503c.getScrollX();
        r103.postDelayed(r103.f250513m, r103.f250516p);
    L11:
        return super.onTouchEvent(r100);
    L12:
        return false;
    }

    public b(AndroidNestedScrollView r100, Context r101) {
        this.f540967a = r100;
        super(r101);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        AndroidNestedScrollView r104 = this.f540967a;
        if (r100 != r104.f250505e) goto L6;
        return;
    L6:
        if (r104.f250509i == true) goto L8;
    L13:
        r104.f(r104.f250517q);
        Iterator<AndroidNestedScrollView.a> r105 = r104.f250511k.iterator();
    L15:
        if (r105.hasNext() == false) goto L18;
        r105.next().onScrollChanged();
    L18:
        if (this.f540967a.f250505e == getScrollX()) goto L23;
        AndroidNestedScrollView r106 = this.f540967a;
        r106.f250505e = getScrollX();
        return;
    L23:
        return;
    L8:
        if (r104.f250510j == true) goto L13;
        r104.f250510j = true;
        r104.f(1);
        Iterator<AndroidNestedScrollView.a> r107 = r104.f250511k.iterator();
    L11:
        if (r107.hasNext() == false) goto L18;
        r107.next().a();
        goto L11
    }
}
