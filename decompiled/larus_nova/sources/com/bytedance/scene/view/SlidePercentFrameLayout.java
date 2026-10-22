package com.bytedance.scene.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.bytedance.scene.navigation.NavigationScene;
import com.bytedance.scene.navigation.d;
import com.bytedance.scene.navigation.j;
import com.bytedance.scene.ui.template.SwipeBackGroupScene;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import la7.b;
import la7.c;
import qa7.f;

/* JADX INFO: loaded from: classes19.dex */
public class SlidePercentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f268863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f268864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f268865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f268866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f268867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f268868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f268869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f268870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f268871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f268872j;

    public interface a {
    }

    public final void a() {
        if (this.f268870h == false) goto L21;
        SwipeBackGroupScene.c r100 = (SwipeBackGroupScene.c) this.f268864b;
        NavigationScene r101 = d.a(r100.f268847e);
        if (r101 == null) goto L20;
        j r102 = r100.f268846d;
        f.a();
        r101.f268754s.h(r102);
        la7.d r103 = r100.f268843a;
        if (r103.f508213c == false) goto L20;
        r103.f508213c = false;
        float r104 = r103.f508214d;
        float r105 = 0.0f;
        r103.f508214d = 0.0f;
        if (r104 <= 0.5f) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        r105 = 1.0f;
    L15:
        ArrayList r107 = new ArrayList();
        Iterator r108 = ((ArrayList) r103.f508212b).iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        ma7.a r109 = (ma7.a) r108.next();
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r109, ma7.a.f512710c, new float[]{r109.f512712b, r105});
        r110.setDuration(150);
        r107.add(r110);
        goto L17
    L19:
        AnimatorSet r111 = new AnimatorSet();
        r111.playTogether(r107);
        r111.addListener(new b(r103, r106));
        r111.setInterpolator(new LinearOutSlowInInterpolator());
        r111.start();
        r103.f508212b = null;
        r103.f508220j.setOnCancelListener(new c(r111));
        goto L20
    L12:
        r106 = false;
    L20:
        this.f268870h = false;
    L21:
        this.f268871i = -1;
        this.f268872j = false;
    }

    public final void b() {
        ViewConfiguration r100 = ViewConfiguration.get(getContext());
        Resources r101 = getContext().getResources();
        this.f268865c = (int) ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 50.0f) + 0.5f);
        this.f268869g = r100.getScaledTouchSlop();
    }

    public SlidePercentFrameLayout(Context r100) {
        super(r100);
        this.f268863a = true;
        this.f268870h = false;
        this.f268871i = -1;
        this.f268872j = false;
        b();
    }

    public final void c(MotionEvent r100) {
        if (this.f268870h == false) goto L5;
        return;
    L5:
        this.f268870h = true;
        SwipeBackGroupScene.c r101 = (SwipeBackGroupScene.c) this.f268864b;
        if (d.b(r101.f268847e).r0(r101.f268843a) == false) goto L8;
        Resources r102 = r101.f268847e.getResources();
        float r103 = TypedValue.applyDimension(1, 8.0f, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        ViewCompat.setElevation(r101.f268844b, r103);
        r101.f268845c.setVisibility(0);
        d.b(r101.f268847e).l0(r101.f268847e, r101.f268846d);
    L8:
        this.f268866d = r100.getRawX();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f268864b == null) goto L46;
        if (this.f268863a == false) goto L46;
        int r101 = r100.getAction();
        if (r101 != 2) goto L13;
        if (this.f268870h == false) goto L13;
        return true;
    L13:
        if (super.onInterceptTouchEvent(r100) == false) goto L15;
        return true;
    L15:
        int r102 = r101 & 255;
        if (r102 == 0) goto L38;
        if (r102 == 1) goto L37;
        if (r102 == 2) goto L23;
        if (r102 == 3) goto L37;
    L44:
        return this.f268870h;
    L23:
        if (this.f268867e <= this.f268865c) goto L25;
    L36:
        return false;
    L25:
        if (this.f268872j == true) goto L36;
        int r103 = this.f268871i;
        if (r103 == (-1)) goto L44;
        int r104 = r100.findPointerIndex(r103);
        if (r104 == (-1)) goto L44;
        int r105 = (int) r100.getX(r104);
        if (Math.abs(r105 - this.f268868f) <= this.f268869g) goto L44;
        this.f268868f = r105;
        getParent().requestDisallowInterceptTouchEvent(true);
        c(r100);
    L37:
        a();
        goto L44
    L38:
        SwipeBackGroupScene.c r106 = (SwipeBackGroupScene.c) this.f268864b;
        if (d.b(r106.f268847e).o0(r106.f268843a) == true) goto L42;
        this.f268872j = true;
        return false;
    L42:
        int r107 = (int) r100.getX();
        this.f268868f = r107;
        this.f268867e = r107;
        this.f268871i = r100.getPointerId(0);
    L46:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f268864b == null) goto L35;
        if (this.f268872j == true) goto L35;
        if (this.f268863a == false) goto L35;
        int r101 = r100.getActionMasked();
        if (r101 != 1) goto L12;
    L32:
        a();
    L33:
        return true;
    L12:
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L32;
    L17:
        if (this.f268870h == true) goto L30;
        if (this.f268867e >= this.f268865c) goto L30;
        int r102 = this.f268871i;
        if (r102 == (-1)) goto L33;
        int r103 = r100.findPointerIndex(r102);
        if (r103 == (-1)) goto L33;
        int r104 = (int) r100.getX(r103);
        if (Math.abs(r104 - this.f268868f) <= this.f268869g) goto L30;
        this.f268868f = r104;
        getParent().requestDisallowInterceptTouchEvent(true);
        c(r100);
    L30:
        if (this.f268870h == false) goto L33;
        a r105 = this.f268864b;
        ((SwipeBackGroupScene.c) r105).f268843a.b(Math.max(0.0f, r100.getRawX() - this.f268866d) / (getWidth() - this.f268866d));
    L35:
        return super.onTouchEvent(r100);
    }

    public void setCallback(a r100) {
        this.f268864b = r100;
    }

    public void setEdgeSize(int r100) {
        this.f268865c = r100;
    }

    public void setSwipeEnabled(boolean r100) {
        if (this.f268863a != r100) goto L5;
        return;
    L5:
        this.f268863a = r100;
        if (r100 == false) goto L8;
        return;
    L8:
        if (this.f268870h == false) goto L12;
        a();
        return;
    }

    public SlidePercentFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f268863a = true;
        this.f268870h = false;
        this.f268871i = -1;
        this.f268872j = false;
        b();
    }

    public SlidePercentFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f268863a = true;
        this.f268870h = false;
        this.f268871i = -1;
        this.f268872j = false;
        b();
    }
}
