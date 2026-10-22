package com.ss.android.ugc.tools.accessibility;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.ugc.tools.CukaieManifest;
import com.ss.android.ugc.tools.utils.g;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class TouchDelegateChildren extends TouchDelegate {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f454803j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f454804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f454805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f454806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f454807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f454808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f454809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f454810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f454811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f454812i;

    public final Rect a() {
        return (Rect) this.f454805b.getValue();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f454811h.isShown() == true) goto L6;
        return false;
    L6:
        if (this.f454811h.isEnabled() == true) goto L8;
        return false;
    L8:
        ViewGroup r100 = this.f454810g;
        View r101 = this.f454811h;
        Rect r102 = a();
        ThreadLocal<Matrix> r103 = c.f454818a;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "descendant");
        Intrinsics.checkNotNullParameter(r102, Argument.OUT);
        r102.set(0, 0, r101.getWidth(), r101.getHeight());
        ThreadLocal<Matrix> r104 = c.f454818a;
        Matrix r105 = r104.get();
        if (r105 != null) goto L11;
        r105 = new Matrix();
        r104.set(r105);
    L12:
        c.a(r100, r101, r105);
        ThreadLocal<RectF> r106 = c.f454819b;
        RectF r107 = r106.get();
        if (r107 != null) goto L15;
        r107 = new RectF();
        r106.set(r107);
    L15:
        r107.set(r102);
        r105.mapRect(r107);
        r102.set((int) (r107.left + 0.5f), (int) (r107.top + 0.5f), (int) (r107.right + 0.5f), (int) (r107.bottom + 0.5f));
        Rect r108 = a();
        int r109 = this.f454808e;
        int r111 = this.f454809f;
        int r112 = r108.right;
        int r113 = r108.left;
        int r114 = r112 - r113;
        int r115 = r108.bottom;
        int r116 = r108.top;
        int r117 = r115 - r116;
        if (r114 >= r109) goto L18;
        int r118 = r109 - r114;
    L19:
        if (r117 >= r111) goto L21;
        int r119 = r111 - r117;
    L23:
        if (r118 != 0) goto L26;
        if (r119 != 0) goto L26;
    L30:
        ((Rect) this.f454806c.getValue()).set(a());
        ((Rect) this.f454806c.getValue()).inset(-((Number) this.f454807d.getValue()).intValue(), -((Number) this.f454807d.getValue()).intValue());
        int r120 = (int) r110.getX();
        int r121 = (int) r110.getY();
        int r122 = r110.getAction();
        boolean r123 = true;
        if (r122 == 0) goto L44;
        if (r122 == 1) goto L38;
        if (r122 == 2) goto L38;
        if (r122 != 3) goto L48;
        boolean r124 = this.f454804a;
        this.f454804a = false;
    L47:
        boolean r125 = r124;
    L49:
        if (r125 == false) goto L56;
        View r126 = this.f454811h;
        if (r123 == false) goto L53;
        float r127 = 2;
        r110.setLocation(r126.getWidth() / r127, r126.getHeight() / r127);
    L55:
        return r126.dispatchTouchEvent(r110);
    L53:
        float r128 = -(((Number) this.f454807d.getValue()).intValue() * 2);
        r110.setLocation(r128, r128);
        goto L55
    L56:
        return false;
    L48:
        r125 = false;
    L38:
        r125 = this.f454804a;
        if (r125 == true) goto L41;
    L43:
        r124 = r125;
        goto L47
    L41:
        if (((Rect) this.f454806c.getValue()).contains(r120, r121) == true) goto L43;
        r123 = false;
        goto L49
    L44:
        Rect r129 = a();
        g r130 = CukaieManifest.c();
        Objects.toString(a());
        r110.toString();
        r130.d();
        if (r129.contains(r120, r121) == false) goto L48;
        this.f454804a = true;
        r124 = true;
    L26:
        Rect r131 = this.f454812i;
        if (r131 != null) goto L29;
        int r132 = r118 / 2;
        r108.left = r113 - r132;
        int r133 = r119 / 2;
        r108.top = r116 - r133;
        r108.right = r112 + r132;
        r108.bottom = r115 + r133;
        goto L30
    L29:
        r108.left = r113 - r131.left;
        r108.top = r116 - r131.top;
        r108.right = r112 + r131.right;
        r108.bottom = r115 + r131.bottom;
        goto L30
    L21:
        r119 = 0;
        goto L23
    L18:
        r118 = 0;
        goto L19
    L11:
        r105.reset();
        goto L12
    }

    public TouchDelegateChildren(int r100, int r101, ViewGroup r102, View r103, Rect r104) {
        Intrinsics.checkNotNullParameter(r102, "mParent");
        Intrinsics.checkNotNullParameter(r103, "mDelegateView");
        super(new Rect(), r103);
        this.f454808e = r100;
        this.f454809f = r101;
        this.f454810g = r102;
        this.f454811h = r103;
        this.f454812i = r104;
        this.f454805b = LazyKt.lazy(TouchDelegateChildren$mBounds$2.INSTANCE);
        this.f454806c = LazyKt.lazy(new TouchDelegateChildren$mSlopBounds$2(this));
        this.f454807d = LazyKt.lazy(new TouchDelegateChildren$mSlop$2(this));
    }
}
