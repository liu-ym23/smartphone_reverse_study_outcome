package com.bytedance.dux.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.drawable.doubleballV2.DoubleV2Scene;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.larus.nova.R;
import em4.g;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes15.dex */
public class DoubleColorBallAnimationView extends FrameLayout implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f204981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f204982g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String[] f204983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f204984i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f204985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f204986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f204987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f204988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f204989e;

    static {
        f204982g = new AtomicInteger(0);
        f204983h = null;
        f204984i = new AtomicInteger(0);
    }

    public static boolean c() {
        AtomicInteger r100 = f204982g;
        if (r100.get() >= 2) goto L6;
        a(r100, new b());
    L6:
        return f204981f;
    }

    public static String[] getSupportSceneList() {
        AtomicInteger r100 = f204984i;
        if (r100.get() >= 2) goto L8;
        if (f204983h != null) goto L8;
        a(r100, new a());
    L8:
        return f204983h;
    }

    @Override // com.bytedance.dux.drawable.f
    public final void b() {
        f r100 = this.f204986b;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.bytedance.dux.drawable.f
    public final void f() {
        f r100 = this.f204986b;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.bytedance.dux.drawable.f
    public final boolean isAnimating() {
        f r100 = this.f204986b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isAnimating() == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r100 = true;
        boolean r101 = false;
        if ((this.f204986b instanceof DoubleColorBallAnimationViewNewV2) == false) goto L24;
        if (getParent() != null) goto L7;
    L11:
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L24;
        if (this.f204987c.equals("dux_internal") == true) goto L24;
        if (this.f204988d == true) goto L18;
        r102.width = g.c(32);
        r102.height = g.c(32);
    L22:
        setLayoutParams(r102);
        goto L24
    L18:
        if (this.f204989e == false) goto L20;
        r102.width = com.bytedance.dux.largefont.a.b(32);
        r102.height = com.bytedance.dux.largefont.a.b(32);
        goto L22
    L20:
        r102.width = g.f(32);
        r102.height = g.f(32);
        goto L22
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L11;
        if (((ViewGroup) getParent()).getChildCount() != 1) goto L11;
        ((ViewGroup) getParent()).setClipChildren(false);
    L24:
        if (c() == false) goto L30;
        f r103 = this.f204986b;
        if (r103 == null) goto L30;
        if ((r103 instanceof DoubleColorBallAnimationViewNewV2) == false) goto L30;
    L31:
        if (r100 == false) goto L33;
        return;
    L33:
        Lazy<Boolean> r104 = DuxConfig.f204900d;
        if (r104 == null) goto L36;
        r101 = r104.getValue().booleanValue();
    L36:
        if (r101 == false) goto L39;
        return;
    L39:
        if (this.f204985a == true) goto L41;
        return;
    L41:
        if (isShown() == false) goto L45;
        f();
        return;
    L45:
        return;
    L30:
        r100 = false;
        goto L31
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
    }

    private void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f204988d = DuxLargeFontHelper.a(DuxComponent.PROGRESS_INDICATOR, r100);
    }

    public static void setSupportSceneList(String[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length == 0) goto L9;
        f204983h = r100;
        return;
    }

    public static void setUseNewAnimation(Boolean r100) {
        f204982g.compareAndSet(0, 2);
        f204981f = r100.booleanValue();
    }

    public void setCycleBias(int r100) {
        if (c() == true) goto L8;
        f r101 = this.f204986b;
        if ((r101 instanceof DoubleColorBallAnimationViewOld) == false) goto L9;
        ((DoubleColorBallAnimationViewOld) r101).setCycleBias(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.dux.drawable.f
    public void setProgress(float r100) {
        f r101 = this.f204986b;
        if (r101 == null) goto L6;
        r101.setProgress(r100);
        return;
    }

    @Override // com.bytedance.dux.drawable.f
    public void setProgressBarInfo(int r100) {
        f r101 = this.f204986b;
        if (r101 == null) goto L6;
        r101.setProgressBarInfo(r100);
        return;
    }

    public void setStartAnimationAfterAttach(boolean r100) {
        this.f204985a = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        f();
        return;
    L5:
        b();
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void a(AtomicInteger r100, Runnable r101) {
    L3:
        if (r100.get() >= 2) goto L14;
        if (r100.compareAndSet(0, 1) == true) goto L6;
        if (r100.get() <= 1) goto L3;
        return;
    L6:
        r101.run();
        r100.compareAndSet(1, 2);
        return;
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r110) {
        this(r100, r101, r110, DoubleV2Scene.defaultscene.name(), c());
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102, String r103, boolean r104) {
        super(r100, r101, r102);
        this.f204985a = !c();
        this.f204986b = null;
        this.f204987c = null;
        setAdaptLargeFontInternal(null);
        boolean r105 = false;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.dux_doublecolorball_scene, R.attr.limitLargeFontScale});     // Catch: Exception -> L20
        if (r104 == false) goto L13;
    L17:
        th = move-exception;
        r106.recycle();     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L21:
        r106.recycle();     // Catch: Exception -> L20
        goto L22
    L6:
        if (r103.equals(DoubleV2Scene.defaultscene.name()) == false) goto L13;
        String r107 = r106.getString(1);     // Catch: Throwable -> L17 RuntimeException -> L49
        if (r107 == null) goto L13;
        if (r107.isEmpty() == true) goto L13;
        r103 = r107;
    L13:
        if (r106.hasValue(0) == false) goto L15;
        setAdaptLargeFontInternal(Boolean.valueOf(r106.getBoolean(0, false)));     // Catch: Throwable -> L17 RuntimeException -> L49
    L15:
        this.f204989e = r106.getBoolean(2, false);     // Catch: Throwable -> L17 RuntimeException -> L49
    L22:
        this.f204987c = r103;
        if (getSupportSceneList() != null) goto L25;
    L34:
        boolean r108 = true;
    L36:
        if (r104 == false) goto L39;
        if (r108 == false) goto L39;
        this.f204986b = new DoubleColorBallAnimationViewNewV2(r100, r103);
    L40:
        addView((View) this.f204986b);
        if (c() == false) goto L47;
        f r109 = this.f204986b;
        if (r109 == null) goto L47;
        if ((r109 instanceof DoubleColorBallAnimationViewNewV2) == false) goto L47;
        r105 = true;
    L47:
        this.f204985a = !r105;
        return;
    L39:
        this.f204986b = new DoubleColorBallAnimationViewOld(r100);
        goto L40
    L25:
        if (getSupportSceneList().length == 0) goto L34;
        String[] r110 = getSupportSceneList();
        int r111 = r110.length;
        int r112 = 0;
    L28:
        if (r112 >= r111) goto L33;
        if (r110[r112].equals(r103) == true) goto L34;
        r112 = r112 + 1;
        goto L28
    L33:
        r108 = false;
        goto L36
    }
}
