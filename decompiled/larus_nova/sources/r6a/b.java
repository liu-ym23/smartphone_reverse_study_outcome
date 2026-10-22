package r6a;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Interpolator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f536385b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f536386c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f536387d = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f536388a;

    static {
        Resources r100 = Resources.getSystem();
        f536385b = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        float r101 = 1.0f / g(1.0f);
        f536386c = r101;
        f536387d = 1.0f - (r101 * g(1.0f));
    }

    public b(int r100) {
        this.f536388a = r100;
    }

    public static int c(float r100) {
        return (int) ((r100 * f536385b) + 0.5f);
    }

    public static boolean d(View r100) {
        if ((r100 instanceof AbsListView) == false) goto L5;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == false) goto L17;
    L20:
        return true;
    L17:
        if ((r100 instanceof ViewPager) == true) goto L20;
        if ((r100 instanceof NestedScrollingParent) == true) goto L20;
        return false;
    L5:
        if ((r100 instanceof ScrollView) == true) goto L14;
        if ((r100 instanceof ScrollingView) == true) goto L14;
        if ((r100 instanceof WebView) == true) goto L14;
        if ((r100 instanceof NestedScrollingChild) == true) goto L14;
        r101 = false;
        goto L15
    }

    public static int f(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L5;
        r101 = new ViewGroup.LayoutParams(-1, -2);
    L5:
        int r102 = ViewGroup.getChildMeasureSpec(0, 0, r101.width);
        int r103 = r101.height;
        if (r103 <= 0) goto L8;
        int r104 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L9:
        r100.measure(r102, r104);
        return r100.getMeasuredHeight();
    L8:
        r104 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L9
    }

    public static float g(float r100) {
        float r101 = r100 * 8.0f;
        if (r101 >= 1.0f) goto L6;
        return r101 - (1.0f - ((float) Math.exp(-r101)));
    L6:
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - r101))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (this.f536388a != 1) goto L6;
        float r101 = 1.0f - r100;
        return 1.0f - (r101 * r101);
    L6:
        float r102 = f536386c * g(r100);
        if (r102 > 0.0f) goto L9;
        return r102;
    L9:
        return r102 + f536387d;
    }

    public static boolean b(View r100, PointF r101) {
        if (r100.canScrollVertically(-1) == false) goto L8;
        if (r100.getVisibility() != 0) goto L8;
        return false;
    L8:
        if ((r100 instanceof ViewGroup) == false) goto L22;
        if (r101 == null) goto L27;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        PointF r104 = new PointF();
    L11:
        if (r103 <= 0) goto L28;
        r103 = r103 - 1;
        View r105 = r102.getChildAt(r103);
        if (e(r102, r105, r101.x, r101.y, r104) == false) goto L11;
        if ("fixed".equals(r105.getTag()) == false) goto L17;
    L21:
        return false;
    L17:
        if ("fixed-bottom".equals(r105.getTag()) == true) goto L21;
        r101.offset(r104.x, r104.y);
        boolean r106 = b(r105, r101);
        r101.offset(-r104.x, -r104.y);
        return r106;
    L28:
        return true;
    L27:
        return true;
    L22:
        return true;
    }

    public static boolean a(View r100, PointF r101, boolean r110) {
        if (r100.canScrollVertically(1) == false) goto L8;
        if (r100.getVisibility() != 0) goto L8;
        return false;
    L8:
        if ((r100 instanceof ViewGroup) == false) goto L36;
        if (r101 == null) goto L36;
        if ((r100 instanceof AbsListView) == false) goto L13;
    L22:
        boolean r102 = true;
    L23:
        if (r102 == true) goto L36;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        PointF r105 = new PointF();
    L25:
        if (r104 <= 0) goto L36;
        r104 = r104 - 1;
        View r106 = r103.getChildAt(r104);
        if (e(r103, r106, r101.x, r101.y, r105) == false) goto L25;
        if ("fixed".equals(r106.getTag()) == false) goto L31;
    L35:
        return false;
    L31:
        if ("fixed-top".equals(r106.getTag()) == true) goto L35;
        r101.offset(r105.x, r105.y);
        boolean r107 = a(r106, r101, r110);
        r101.offset(-r105.x, -r105.y);
        return r107;
    L13:
        if ((r100 instanceof ScrollView) == true) goto L22;
        if ((r100 instanceof ScrollingView) == true) goto L22;
        if ((r100 instanceof WebView) == true) goto L22;
        if ((r100 instanceof NestedScrollingChild) == true) goto L22;
        r102 = false;
    L36:
        if (r110 == false) goto L38;
        return true;
    L38:
        if (r100.canScrollVertically(-1) == true) goto L46;
        return false;
    L46:
        return true;
    }

    public static boolean e(View r100, View r101, float r102, float r103, PointF r110) {
        if (r101.getVisibility() == 0) goto L5;
        return false;
    L5:
        float[] r104 = {r102, r103};
        r104[0] = (r100.getScrollX() - r101.getLeft()) + r102;
        float r105 = r104[1] + (r100.getScrollY() - r101.getTop());
        r104[1] = r105;
        float r106 = r104[0];
        if (r106 >= 0.0f) goto L8;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L17;
        r110.set(r104[0] - r102, r104[1] - r103);
    L17:
        return r107;
    L8:
        if (r105 < 0.0f) goto L14;
        if (r106 >= r101.getWidth()) goto L14;
        if (r104[1] >= r101.getHeight()) goto L14;
        r107 = true;
        goto L15
    }
}
