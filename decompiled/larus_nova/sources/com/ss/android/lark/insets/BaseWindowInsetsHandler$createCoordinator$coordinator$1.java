package com.ss.android.lark.insets;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"com/ss/android/lark/insets/BaseWindowInsetsHandler$createCoordinator$coordinator$1", "Lcom/ss/android/lark/insets/FitSystemCoordinator;", "decorDrawable", "Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "getDecorDrawable", "()Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "checkDecorEdge", "", "getCheckDecorEdge", "()Z", "setCheckDecorEdge", "(Z)V", "requestLayout", "", "invalidate", "isDarkMode", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", BaseSwitches.V, "Landroid/view/View;", "insets", "getScreenBounds", "Landroid/graphics/Rect;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "updateDecorDrawableEdgeVisibility", "consumeWindowInsets", "nonNullInsets", "insets_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseWindowInsetsHandler$createCoordinator$coordinator$1 implements FitSystemCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f427709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f427710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f427711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f427712d;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseWindowInsetsHandler$createCoordinator$coordinator$1 f427713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f427714b;

        public a(BaseWindowInsetsHandler$createCoordinator$coordinator$1 r100, View r101) {
            this.f427713a = r100;
            this.f427714b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r110, int r111, int r112, int r113, int r114, int r115) {
            boolean r116 = false;
            this.f427713a.f427709a.setBounds(0, 0, this.f427714b.getWidth(), this.f427714b.getHeight());
            BaseWindowInsetsHandler$createCoordinator$coordinator$1 r103 = this.f427713a;
            if (r103.f427710b == false) goto L41;
            int[] r104 = r103.f427712d.f427744l;
            ArraysKt.fill$default(r104, 0, 0, 0, 6, null);
            r103.f427711c.getLocationOnScreen(r104);
            int r105 = r104[0];
            int r106 = r104[1];
            int r117 = r103.f427711c.getWidth() + r105;
            int r118 = r103.f427711c.getHeight() + r106;
            Context r119 = r103.f427711c.getContext();
            r103.f427712d.f427745m.setEmpty();
            Object r120 = r119.getSystemService(LiveEndPageData.TAG_WINDOW);
            Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager r121 = (WindowManager) r120;
            if (Build.VERSION.SDK_INT < 30) goto L8;
            WindowMetrics r122 = r121.getCurrentWindowMetrics();
            r103.f427712d.f427745m.set(r122.getBounds());
            Rect r123 = r103.f427712d.f427745m;
        L9:
            g r124 = r103.f427709a;
            if (r106 > r123.top) goto L12;
            boolean r107 = true;
        L14:
            if (r107 == r124.f427759j) goto L17;
            r124.f427759j = r107;
            r124.invalidateSelf();
        L17:
            g r108 = r103.f427709a;
            if (r118 < (r123.bottom - 1)) goto L20;
            boolean r125 = true;
        L22:
            if (r125 == r108.f427760k) goto L25;
            r108.f427760k = r125;
            r108.invalidateSelf();
        L25:
            g r109 = r103.f427709a;
            if (r105 > r123.left) goto L28;
            boolean r126 = true;
        L30:
            if (r126 == r109.f427761l) goto L33;
            r109.f427761l = r126;
            r109.invalidateSelf();
        L33:
            g r127 = r103.f427709a;
            if (r117 < r123.right) goto L37;
            r116 = true;
        L37:
            if (r116 == r127.f427762m) goto L42;
            r127.f427762m = r116;
            r127.invalidateSelf();
            return;
        L42:
            return;
        L28:
            r126 = false;
            goto L30
        L20:
            r125 = false;
            goto L22
        L12:
            r107 = false;
            goto L14
        L8:
            DisplayMetrics r128 = new DisplayMetrics();
            r121.getDefaultDisplay().getRealMetrics(r128);
            r103.f427712d.f427745m.set(0, 0, r128.widthPixels, r128.heightPixels);
            r123 = r103.f427712d.f427745m;
            goto L9
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseWindowInsetsHandler$createCoordinator$coordinator$1 f427715a;

        public b(BaseWindowInsetsHandler$createCoordinator$coordinator$1 r100) {
            this.f427715a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            this.f427715a.f427709a.setBounds(0, 0, r100.getWidth(), r100.getHeight());
        }
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final void invalidate() {
        this.f427711c.invalidate();
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final boolean isDarkMode() {
        if ((this.f427711c.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final void requestLayout() {
        this.f427711c.requestLayout();
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final g a() {
        return this.f427709a;
    }

    public BaseWindowInsetsHandler$createCoordinator$coordinator$1(View r100, c r101) {
        this.f427711c = r100;
        this.f427712d = r101;
        g r102 = new g();
        this.f427709a = r102;
        if (r100.isLaidOut() == true) goto L5;
    L7:
        r100.addOnLayoutChangeListener(new b(this));
    L8:
        r100.getOverlay().add(r102);
        r100.addOnLayoutChangeListener(new a(this, r100));
        return;
    L5:
        if (r100.isLayoutRequested() == true) goto L7;
        r102.setBounds(0, 0, r100.getWidth(), r100.getHeight());
        goto L8
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "insets");
        if (Build.VERSION.SDK_INT >= 30) goto L22;
        WindowInsets r102 = r101.toWindowInsets();
        if (r102 == null) goto L18;
        c r103 = this.f427712d;
        int r104 = c.f427732n;
        r103.getClass();
        boolean r105 = true;
        if (r102.getSystemWindowInsetTop() == 0) goto L9;
    L15:
        boolean r106 = false;
    L16:
        if (r106 != true) goto L18;
    L19:
        if (r105 == false) goto L22;
        return r101;
    L9:
        if (r102.getSystemWindowInsetBottom() != 0) goto L15;
        if (r102.getSystemWindowInsetLeft() != 0) goto L15;
        if (r102.getSystemWindowInsetRight() != 0) goto L15;
        r106 = true;
    L18:
        r105 = false;
    L22:
        if (this.f427712d.f427739g == false) goto L24;
        int r107 = WindowInsetsCompat.Type.ime() | 0;
    L26:
        if (this.f427712d.f427742j == false) goto L29;
        r107 = r107 | WindowInsetsCompat.Type.displayCutout();
    L29:
        if (this.f427712d.f427741i == false) goto L32;
        r107 = (r107 | WindowInsetsCompat.Type.statusBars()) | WindowInsetsCompat.Type.captionBar();
    L32:
        if (this.f427712d.f427740h == false) goto L34;
        r107 = r107 | WindowInsetsCompat.Type.navigationBars();
    L34:
        Insets r108 = r101.getInsets(r107);
        Insets r109 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
        int r110 = r108.top + this.f427712d.f427743k;
        int r111 = WindowInsetsUtils.f427723a;
        View r112 = this.f427711c;
        int r113 = r108.bottom;
        r112.setPadding(r108.left, r110, r108.right, r113);
        this.f427709a.a(r109);
        c r114 = this.f427712d;
        int r115 = r114.f427737e;
        g r116 = this.f427709a;
        r116.f427755f = r115;
        int r117 = r114.f427738f;
        r116.f427756g = r117;
        r116.f427757h = r117;
        r116.f427758i = r117;
        int r118 = Math.max(r108.left, 0);
        int r119 = Math.max(r108.right, 0);
        WindowInsetsCompat r120 = r101.inset(r118, Math.max(r108.top, 0), r119, Math.max(r108.bottom, 0));
        OnApplyWindowInsetsListener r121 = this.f427712d.f427734b;
        if (r121 == null) goto L38;
        r120 = r121.onApplyWindowInsets(this.f427711c, r120);
    L38:
        return r120;
    L24:
        r107 = 0;
        goto L26
    }
}
