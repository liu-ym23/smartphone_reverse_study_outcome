package com.larus.home.impl.main.side_bar.layout.drawer_impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes29.dex */
public class FullDraggableContainer extends FrameLayout implements com.larus.home.impl.main.side_bar.layout.drawer_impl.a.InterfaceC4320a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.layout.drawer_impl.a f344740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DrawerLayout f344741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f344742c;

    public interface a {
    }

    @Override // com.larus.home.impl.main.side_bar.layout.drawer_impl.a.InterfaceC4320a
    public View getDrawerMainContainer() {
        return this;
    }

    public List<DrawerLayout.DrawerListener> getDrawerListeners() {
        Field r100 = DrawerLayout.class.getDeclaredField("mListeners");     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
        return (List) r100.get(this.f344741b);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.larus.home.impl.main.side_bar.layout.drawer_impl.a.InterfaceC4320a
    public int getDistanceThreshold() {
        return getWidth() / 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r100 = getParent();
        if ((r100 instanceof DrawerLayout) == false) goto L7;
        this.f344741b = (DrawerLayout) r100;
        return;
    L7:
        throw new IllegalStateException("This " + this + " must be added to a DrawerLayout");
    }

    public FullDraggableContainer(Context r100) {
        this(r100, null);
    }

    public final View a(int r100) {
        int r101 = GravityCompat.getAbsoluteGravity(r100, ViewCompat.getLayoutDirection(this.f344741b)) & 7;
        int r102 = this.f344741b.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = this.f344741b.getChildAt(r103);
        if ((GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams) r104.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this.f344741b)) & 7) == r101) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        com.larus.home.impl.main.side_bar.layout.drawer_impl.a r101 = this.f344740a;
        r101.getClass();
        int r102 = r100.getActionMasked();
        float r103 = r100.getX();
        float r104 = r100.getY();
        if (r102 != 0) goto L23;
        r101.f344744b = r103;
        r101.f344746d = r103;
        r101.f344745c = r104;
        r101.f344754l = r100.getEventTime();
        boolean r105 = true;
        if (((FullDraggableContainer) r101.f344743a).f344741b.isDrawerOpen(3) == false) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L20;
        com.larus.home.impl.main.side_bar.layout.drawer_impl.a.InterfaceC4320a r107 = r101.f344743a;
        a r108 = ((FullDraggableContainer) r107).f344742c;
        if (r108 != null) goto L15;
        boolean r109 = true;
    L16:
        if (r109 == false) goto L20;
        if (com.larus.home.impl.main.side_bar.layout.drawer_impl.a.c(r107.getDrawerMainContainer(), (int) r103, (int) r104) == false) goto L20;
    L21:
        r101.f344755m = r105;
        r101.f344756n = false;
        r101.f344757o = false;
        return false;
    L15:
        r109 = ((wb9.a) r108).f559028a.f344728e;
    L20:
        r105 = false;
        goto L21
    L7:
        if (((FullDraggableContainer) r101.f344743a).f344741b.isDrawerOpen(5) == true) goto L10;
        r106 = false;
        goto L11
    L23:
        if (r102 == 2) goto L25;
        return false;
    L25:
        if (r101.f344757o == false) goto L28;
        return false;
    L28:
        if (r101.b(r100, r103, r104) == false) goto L31;
        return false;
    L31:
        if (com.larus.home.impl.main.side_bar.layout.drawer_impl.a.a(r101.f344743a.getDrawerMainContainer(), false, (int) (r103 - r101.f344746d), (int) r103, (int) r104) == true) goto L39;
        r101.f344746d = r103;
        return r101.d(r103 - r101.f344744b, r104 - r101.f344745c, r101.f344747e);
    L39:
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        com.larus.home.impl.main.side_bar.layout.drawer_impl.a r100 = this.f344740a;
        r100.getClass();
        float r101 = r110.getX();
        float r102 = r110.getY();
        int r103 = r110.getActionMasked();
        int r104 = 3;
        if (r100.f344757o == false) goto L7;
        if (r103 == 1) goto L7;
        if (r103 == 3) goto L7;
        return false;
    L7:
        if (r103 == 1) goto L70;
        if (r103 == 2) goto L13;
        if (r103 == 3) goto L70;
    L90:
        return true;
    L13:
        if (r100.b(r110, r101, r102) == true) goto L99;
        float r105 = r101 - r100.f344744b;
        if (((FullDraggableContainer) r100.f344743a).f344741b.isDrawerOpen(3) == false) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L24;
        return false;
    L24:
        if (r100.e(r105) == true) goto L27;
        return false;
    L27:
        if (r100.d(r105, r102 - r100.f344745c, r100.f344748f) == true) goto L31;
        if (r100.f344752j == true) goto L31;
    L61:
        if (r100.f344752j == false) goto L97;
        ViewParent r111 = r100.f344743a.getDrawerMainContainer().getParent();
        if (r111 == null) goto L97;
        r111.requestDisallowInterceptTouchEvent(true);
    L97:
        return r100.f344752j;
    L31:
        if (r100.f344758p != null) goto L33;
        r100.f344758p = VelocityTracker.obtain();
    L33:
        r100.f344758p.addMovement(r110);
        boolean r112 = r100.f344752j;
        r100.f344752j = true;
        float r107 = Math.abs(r105);
        if (r107 <= r100.f344743a.getDistanceThreshold()) goto L36;
        boolean r108 = true;
    L37:
        r100.f344753k = r108;
        int r109 = r100.f344751i;
        if (r109 == 0) goto L40;
        if (r109 == 3) goto L46;
    L47:
        if (r109 == 5) goto L49;
    L51:
        com.larus.home.impl.main.side_bar.layout.drawer_impl.a.InterfaceC4320a r113 = r100.f344743a;
        int r114 = r100.f344751i;
        float r115 = r107 - r100.f344748f;
        FullDraggableContainer r116 = (FullDraggableContainer) r113;
        View r117 = r116.a(r114);
        Objects.requireNonNull(r117);
        float r118 = MathUtils.clamp(r115 / r117.getWidth(), 0.0f, 1.0f);
        Method r119 = DrawerLayout.class.getDeclaredMethod("moveDrawerToOffset", new Class[]{View.class, Float.TYPE});     // Catch: Exception -> L66
        r119.setAccessible(true);     // Catch: Exception -> L66
        r119.invoke(r116.f344741b, new Object[]{r117, Float.valueOf(r118)});     // Catch: Exception -> L66
        r117.setVisibility(0);     // Catch: Exception -> L66
        r116.f344741b.invalidate();
        if (r112 == true) goto L61;
        List<DrawerLayout.DrawerListener> r120 = ((FullDraggableContainer) r100.f344743a).getDrawerListeners();
        if (r120 == null) goto L61;
        int r121 = r120.size() - 1;
    L58:
        if (r121 < 0) goto L61;
        ((DrawerLayout.DrawerListener) ListProtector.get(r120, r121)).onDrawerStateChanged(1);
        r121 = r121 - 1;
    L66:
        e = move-exception;
        throw new RuntimeException(e);
    L49:
        if (r105 <= 0.0f) goto L51;
    L50:
        r100.f344744b = r101;
        return false;
    L46:
        if (r105 < 0.0f) goto L50;
    L40:
        if (r105 > 0.0f) goto L43;
        r104 = 5;
    L43:
        r100.f344751i = r104;
        goto L51
    L36:
        r108 = false;
        goto L37
    L18:
        if (((FullDraggableContainer) r100.f344743a).f344741b.isDrawerOpen(5) == true) goto L21;
        r106 = false;
        goto L22
    L99:
        return false;
    L70:
        if (r100.f344752j == false) goto L87;
        VelocityTracker r122 = r100.f344758p;
        if (r122 == null) goto L84;
        r122.computeCurrentVelocity(1000);
        float r123 = r100.f344758p.getXVelocity();
        if (r100.f344751i != 3) goto L76;
        boolean r124 = true;
    L77:
        int r125 = r100.f344749g;
        if (r123 <= r125) goto L81;
        r100.f344753k = r124;
        goto L84
    L81:
        if (r123 >= (-r125)) goto L84;
        r100.f344753k = !r124;
        goto L84
    L76:
        r124 = false;
    L84:
        if (r100.f344753k == false) goto L86;
        ((FullDraggableContainer) r100.f344743a).f344741b.openDrawer(r100.f344751i, true);
        goto L87
    L86:
        ((FullDraggableContainer) r100.f344743a).f344741b.closeDrawer(r100.f344751i, true);
    L87:
        r100.f344753k = false;
        r100.f344752j = false;
        r100.f344751i = 0;
        r100.f344755m = false;
        r100.f344756n = false;
        r100.f344757o = false;
        VelocityTracker r126 = r100.f344758p;
        if (r126 == null) goto L90;
        r126.recycle();
        r100.f344758p = null;
        goto L90
    }

    public void setCallback(a r100) {
        this.f344742c = r100;
    }

    public FullDraggableContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FullDraggableContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f344740a = new com.larus.home.impl.main.side_bar.layout.drawer_impl.a(r100, this);
    }
}
