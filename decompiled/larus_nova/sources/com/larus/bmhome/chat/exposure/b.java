package com.larus.bmhome.chat.exposure;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExposureConfig f302987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f302988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f302989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f302990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f302991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<View> f302992f;

    /* JADX INFO: loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f302993a = null;

        static {
            int[] r100 = new int[ExposureConfig.ExposureMode.values().length];
            r100[ExposureConfig.ExposureMode.AREA_RATIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ExposureConfig.ExposureMode.TOP_EDGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f302993a = r100;
        }
    }

    public b(ExposureConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f302987a = r100;
        this.f302988b = new Rect();
        this.f302989c = new Rect();
        this.f302990d = new Rect();
        this.f302991e = new int[2];
    }

    public final void a(View r100) {
        WeakReference<View> r101 = this.f302992f;
        if (r101 == null) goto L5;
        View r102 = r101.get();
    L7:
        if (r102 != null) goto L9;
    L11:
        Resources r103 = r100.getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).heightPixels;
        Resources r105 = r100.getResources();
        int r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).widthPixels;
        float r107 = r104;
        ExposureConfig r108 = this.f302987a;
        this.f302989c.set(0, (int) (r108.f302949a * r107), r106, (int) (r107 * r108.f302950b));
        return;
    L9:
        if (r102.isAttachedToWindow() == false) goto L11;
        r102.getLocationOnScreen(this.f302991e);
        int[] r109 = this.f302991e;
        int r110 = r109[0];
        int r111 = r109[1];
        int r112 = r102.getWidth() + r110;
        r102.getHeight();
        float r113 = r102.getHeight();
        ExposureConfig r114 = this.f302987a;
        this.f302989c.set(r110, ((int) (r114.f302949a * r113)) + r111, r112, r111 + ((int) (r113 * r114.f302950b)));
        return;
    L5:
        r102 = null;
        goto L7
    }
}
