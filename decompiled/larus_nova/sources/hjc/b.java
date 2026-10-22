package hjc;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.ss.android.widget.slider.UndergroundView;
import ijc.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VelocityTracker f485495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap f485496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f485497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f485498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f485499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f485500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f485501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f485502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public UndergroundView f485503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f485504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<d> f485505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f485506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InterfaceC6157b f485507m;

    public interface a {
    }

    /* JADX INFO: renamed from: hjc.b$b, reason: collision with other inner class name */
    public interface InterfaceC6157b {
        int a(Context r100, float r101, float r102);
    }

    public Activity getActivity() {
        return null;
    }

    public View getTargetView() {
        return this.f485501g;
    }

    public UndergroundView getUndergroundView() {
        return this.f485503i;
    }

    public b(Context r100) {
        super(r100);
        this.f485496b = new ArrayMap();
        this.f485502h = 15;
        this.f485504j = -1;
        this.f485505k = new HashSet();
        this.f485506l = false;
        this.f485507m = new e();
        this.f485495a = VelocityTracker.obtain();
        ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f485503i = new UndergroundView(r100);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.f485503i, 0, r101);
    }

    public final int b(MotionEvent r100) {
        int r101 = this.f485504j;
        if (r101 != (-1)) goto L8;
        float r102 = r100.getRawX() - this.f485498d;
        float r103 = r100.getRawY() - this.f485499e;
        InterfaceC6157b r104 = this.f485507m;
        if (r104 != null) goto L7;
        return r101;
    L7:
        return r104.a(getContext(), r102, r103);
    L8:
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 1) goto L5;
    L6:
        this.f485497c = false;
    L8:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101 != 3) goto L8;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        f r101 = this.f485500f;
        if (r101 == null) goto L8;
        if (r101.f485513f == true) goto L8;
        return true;
    L8:
        if (r100.getActionMasked() != 0) goto L11;
        this.f485500f = null;
        this.f485504j = -1;
        this.f485506l = false;
    L11:
        if (this.f485496b.isEmpty() == true) goto L13;
        int r102 = r100.getActionMasked();
        if (isEnabled() == true) goto L17;
    L42:
        return false;
    L17:
        if (this.f485497c == true) goto L42;
        if (r102 != 5) goto L24;
        this.f485497c = true;
        return false;
    L24:
        if (this.f485495a != null) goto L26;
        this.f485495a = VelocityTracker.obtain();
    L26:
        this.f485495a.addMovement(r100);
        if (r102 != 0) goto L29;
        this.f485498d = r100.getRawX();
        this.f485499e = r100.getRawY();
    L38:
        if (super.onInterceptTouchEvent(r100) == true) goto L43;
        return false;
    L43:
        return true;
    L29:
        if (r102 != 2) goto L38;
        if (this.f485506l == true) goto L38;
        int r103 = b(r100);
        f(r100, r103);
        if (r103 == (-1)) goto L38;
        this.f485506l = true;
        goto L38
    L13:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f485504j == (-1)) goto L5;
    L9:
        f r100 = this.f485500f;
        if (r100 != null) goto L12;
    L67:
        return true;
    L12:
        if (r100.f485513f == false) goto L67;
        if (this.f485495a != null) goto L17;
        this.f485495a = VelocityTracker.obtain();
    L17:
        int r101 = (int) (r110.getRawX() - this.f485498d);
        int r102 = (int) (r110.getRawY() - this.f485499e);
        int r103 = r110.getActionMasked();
        if (r103 == 1) goto L30;
        if (r103 != 2) goto L21;
        this.f485495a.addMovement(r110);
        f r111 = this.f485500f;
        f.c r104 = r111.f485510c;
        if (r104 == null) goto L67;
        View r105 = this.f485501g;
        g r106 = (g) r104;
        if ((r111.f485508a & 12) == 0) goto L28;
        r105.setTranslationY(ijc.a.c(r106.f490165a, r101, r102));
    L29:
        r111.a((ijc.a.a(r106.f490165a, r105) * 1.0f) / ijc.a.b(r111.f485508a, null), 2);
        goto L67
    L28:
        r105.setTranslationX(ijc.a.c(r106.f490165a, r101, r102));
        goto L29
    L21:
        if (r103 != 3) goto L67;
    L30:
        this.f485495a.computeCurrentVelocity(1000);
        int r112 = (int) this.f485495a.getXVelocity();
        int r107 = (int) this.f485495a.getYVelocity();
        f r108 = this.f485500f;
        f.d r109 = r108.f485511d;
        if (r109 == null) goto L67;
        a r113 = r109.f485514a;
        if (r113 == null) goto L67;
        View r114 = this.f485501g;
        ijc.f r115 = (ijc.f) r113;
        ijc.a.C6277a r116 = r115.f490164a.f490157a;
        int r117 = r108.f485508a;
        float r118 = r114.getTranslationX();
        int r119 = ijc.a.b(r108.f485508a, null);
        r115.f490164a.getClass();
        r116.getClass();
        boolean r120 = false;
        if ((Math.abs(r118) * 4.0f) <= Math.abs(r119)) goto L37;
        boolean r121 = true;
    L39:
        if (r112 <= 0) goto L42;
        if (r112 >= 500) goto L42;
        boolean r122 = true;
    L44:
        if (r112 >= 0) goto L47;
        if (r112 <= (-500)) goto L47;
        boolean r123 = true;
    L48:
        if (r112 <= 500) goto L50;
        boolean r124 = true;
    L51:
        if (r112 >= (-500)) goto L53;
        boolean r125 = true;
    L55:
        if ((r117 & 5) == 0) goto L60;
        if (r122 == false) goto L58;
        if (r121 == false) goto L58;
    L63:
        r120 = true;
    L64:
        if (r120 == false) goto L66;
        r109.f485515b.a(this.f485500f, this.f485501g, r112, r107);
        goto L67
    L66:
        r109.f485516c.a(this.f485500f, this.f485501g, r112, r107);
    L58:
        if (r124 == false) goto L64;
    L60:
        if (r123 == false) goto L62;
        if (r121 == true) goto L63;
    L62:
        if (r125 == false) goto L64;
    L53:
        r125 = false;
        goto L55
    L50:
        r124 = false;
    L47:
        r123 = false;
    L42:
        r122 = false;
        goto L44
    L37:
        r121 = false;
        goto L39
    L5:
        if (r110.getActionMasked() != 2) goto L9;
        int r126 = b(r110);
        f(r110, r126);
        if (r126 == (-1)) goto L9;
        this.f485506l = true;
        goto L9
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        UndergroundView r101 = this.f485503i;
        if (r101 == null) goto L6;
        r101.f456074b = r100;
        r101.invalidate();
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        UndergroundView r101 = this.f485503i;
        if (r101 == null) goto L6;
        r101.f456074b = r100;
        r101.invalidate();
        return;
    }

    public static boolean c(View r100, MotionEvent r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getVisibility() != 0) goto L9;
        Rect r102 = new Rect();
        r100.getGlobalVisibleRect(r102);
        return r102.contains((int) r101.getX(), (int) r101.getY());
    L9:
        return false;
    }

    public static boolean e(int r100, View r101) {
        if (r100 != 1) goto L6;
        return ViewCompat.canScrollHorizontally(r101, -1);
    L6:
        if (r100 != 2) goto L9;
        return ViewCompat.canScrollHorizontally(r101, 1);
    L9:
        if (r100 != 4) goto L12;
        return ViewCompat.canScrollVertically(r101, -1);
    L12:
        if (r100 == 8) goto L19;
        return false;
    L19:
        return ViewCompat.canScrollVertically(r101, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean f(MotionEvent r100, int r101) {
        if (this.f485504j == (-1)) goto L5;
    L58:
        return false;
    L5:
        if ((this.f485502h & r101) <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L58;
        Iterator r103 = ((HashSet) this.f485505k).iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        ((d) r103.next()).getClass();
        if (c(null, r100) == false) goto L11;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L58;
        Iterator r105 = ((HashSet) this.f485505k).iterator();
    L19:
        if (r105.hasNext() == false) goto L22;
        ((d) r105.next()).getClass();
        goto L19
    L22:
        if (d(null, r100, r101) == true) goto L58;
        f r106 = (f) this.f485496b.get(Integer.valueOf(r101));
        if (r106 == null) goto L58;
        if (r106.f485513f == false) goto L58;
        Pair<Boolean, View> r107 = g(r106, null, r100, r106.f485509b);
        if (r107.first.booleanValue() == false) goto L58;
        this.f485500f = r106;
        this.f485501g = r107.second;
        LinkedList<Activity> r108 = hjc.a.f485494a;
        int r109 = r108.size() - 1;
        boolean r110 = false;
    L31:
        if (r109 < 0) goto L42;
        if (r110 == false) goto L39;
        Activity r111 = r108.get(r109);
        if (r111 == null) goto L41;
        if (r111.isFinishing() == true) goto L41;
    L43:
        if (r111 != null) goto L45;
        this.f485502h &= ~r101;
        goto L58
    L45:
        View r112 = r111.findViewById(R.id.content);
        if (r112 != null) goto L49;
        this.f485502h &= ~r101;
        goto L58
    L49:
        if ((r111 instanceof c) == false) goto L52;
        ((c) r111).a();
    L52:
        if (a(r111, null, r112) == false) goto L55;
        this.f485502h &= ~r101;
        goto L58
    L55:
        if (this.f485503i == null) goto L58;
        throw null;
    L41:
        r109 = r109 - 1;
        goto L31
    L39:
        if (r108.get(r109) != null) goto L41;
        r110 = true;
        goto L41
    L42:
        r111 = null;
        goto L43
    L15:
        r104 = false;
        goto L16
    L7:
        r102 = false;
        goto L8
    }

    public final boolean a(Activity r100, Activity r101, View r102) {
        if (r102 != null) goto L5;
    L23:
        return false;
    L5:
        if (r102.getVisibility() != 0) goto L23;
        if ((r102 instanceof SurfaceView) == true) goto L12;
        if ((r102 instanceof TextureView) == true) goto L12;
    L15:
        if ((r102 instanceof ViewGroup) == false) goto L23;
        ViewGroup r103 = (ViewGroup) r102;
        int r104 = 0;
    L18:
        if (r104 >= r103.getChildCount()) goto L23;
        if (a(r100, r101, r103.getChildAt(r104)) == true) goto L21;
        r104 = r104 + 1;
        goto L18
    L21:
        return true;
    L12:
        if (r102.getVisibility() != 0) goto L15;
        return true;
    }

    public final boolean d(View r100, MotionEvent r101, int r102) {
        Iterator r103 = ((HashSet) this.f485505k).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        ((d) r103.next()).getClass();
        if (r100 != null) goto L4;
        return false;
    L8:
        if (r100 != null) goto L11;
        return false;
    L11:
        if (c(r100, r101) == false) goto L16;
        if (e(r102, r100) == false) goto L16;
    L21:
        return true;
    L16:
        if ((r100 instanceof ViewGroup) == false) goto L23;
        ViewGroup r104 = (ViewGroup) r100;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L31;
        if (d(r104.getChildAt(r106), r101, r102) == true) goto L21;
        r106 = r106 + 1;
        goto L18
    L31:
        return false;
    L23:
        return false;
    }

    public final Pair<Boolean, View> g(f r100, View r101, MotionEvent r102, f.e r103) {
        if (r101 == null) goto L4;
        r103.a(r100);
        if (c(r101, r102) == false) goto L12;
        if (e(r100.f485508a, r101) == true) goto L12;
        this.f485501g = r101;
        return Pair.create(Boolean.TRUE, r101);
    L12:
        if ((r101 instanceof ViewGroup) == false) goto L20;
        ViewGroup r104 = (ViewGroup) r101;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L20;
        Pair<Boolean, View> r107 = g(r100, r104.getChildAt(r106), r102, r103);
        if (r107.first.booleanValue() == true) goto L17;
        r106 = r106 + 1;
        goto L14
    L17:
        return r107;
    L20:
        return Pair.create(Boolean.FALSE, r101);
    L4:
        return Pair.create(Boolean.FALSE, null);
    }
}
