package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f193663a = 0;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f193664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f193665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f193666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f193667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g f193668e;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f193664a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Rect r100 = new Rect();
            if ((this.f193664a.getParent() instanceof i) == false) goto L5;
            this.f193664a.getHitRect(r100);
        L11:
            Rect r101 = new Rect(r100);
            int r102 = r100.top;
            int r103 = this.f193665b;
            r100.top = r102 - r103;
            int r104 = this.f193666c;
            if (r104 <= (r103 * 2)) goto L14;
            r100.bottom += r103 * 2;
        L15:
            this.f193667d.setSeekBarTouchDelegate(new f(this.f193668e));
            g r105 = this.f193668e;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            r105.f193661b = r100;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r105.f193660a.setHasTouchDelegate(true);
            return;
        L14:
            r100.bottom += r104;
            goto L15
        L5:
            Object r106 = this.f193664a.getParent();
            if ((r106 instanceof View) == false) goto L8;
            View r107 = (View) r106;
        L9:
            if (r107 == null) goto L11;
            r107.getHitRect(r100);
            goto L11
        L8:
            r107 = null;
            goto L9
        }

        public a(CustomizedUISeekBar r100, int r101, int r102, i r103, g r104) {
            this.f193664a = r100;
            this.f193665b = r101;
            this.f193666c = r102;
            this.f193667d = r103;
            this.f193668e = r104;
        }
    }

    static {
    }

    public static boolean a(g r100, int r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        ViewParent r101 = null;
        if (r111 != null) goto L5;
    L13:
        Resources r102 = Resources.getSystem();
        int r112 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    L14:
        int r103 = r112;
        CustomizedUISeekBar r104 = r100.f193660a;
        ViewParent r113 = r104.getParent();
        View r105 = r104.getRootView();
    L15:
        if (r113 == null) goto L22;
        if (Intrinsics.areEqual(r113, r105) == true) goto L22;
        if ((r113 instanceof i) == false) goto L21;
        r101 = r113;
    L21:
        r113 = r113.getParent();
    L22:
        i r106 = (i) r101;
        if (r106 != null) goto L25;
        return false;
    L25:
        r104.getViewTreeObserver().addOnGlobalLayoutListener(new a(r104, r103, r110, r106, r100));
        return true;
    L5:
        if (r111.intValue() < 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L11;
        r111 = null;
    L11:
        if (r111 == null) goto L13;
        r112 = r111.intValue();
        goto L14
    L7:
        r107 = false;
        goto L8
    }
}
