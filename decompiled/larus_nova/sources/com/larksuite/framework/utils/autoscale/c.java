package com.larksuite.framework.utils.autoscale;

import android.app.UiModeManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends Resources {
    @Override // android.content.res.Resources
    public final Configuration getConfiguration() {
        Configuration r100 = super.getConfiguration();
        int r101 = a.f285947a;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "configuration");
        return r100;
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        DisplayMetrics r100 = WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics());
        int r101 = a.f285947a;
        Intrinsics.checkNotNull(r100);
        a.a(r100);
        return r100;
    }

    public c(Resources r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        AssetManager r101 = r100.getAssets();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        String[] r103 = CarUtils.f444655a;
        Configuration r104 = r100.getConfiguration();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (CarUtils.b() == true) goto L5;
    L20:
        super(r101, r102, r104);
        int r105 = a.f285947a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(super.getConfiguration(), "configuration");
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        int r106 = r104.uiMode;
        boolean r107 = true;
        if (((UiModeManager) com.larksuite.framework.utils.b.f285948a.getSystemService(UiModeManager.class)).getNightMode() != 2) goto L9;
        boolean r108 = true;
    L10:
        int r109 = 32;
        if ((r106 & 48) == 32) goto L15;
        if (r106 == 0) goto L15;
        r107 = false;
    L15:
        if (r108 == r107) goto L20;
        if (r108 == true) goto L19;
        r109 = 16;
    L19:
        r104.uiMode = r109;
        Log.i("CarUtils", "fixUIMode, before: " + r106 + ", after: " + r104.uiMode);
        goto L20
    L9:
        r108 = false;
        goto L10
    }

    @Override // android.content.res.Resources
    public final float getDimension(int r100) {
        int r101 = a.f285947a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        return super.getDimension(r100);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int r100) {
        int r101 = a.f285947a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        return super.getDimensionPixelOffset(r100);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int r100) {
        int r101 = a.f285947a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        return super.getDimensionPixelSize(r100);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration r100, DisplayMetrics r101) {
        super.updateConfiguration(r100, r101);
        int r102 = a.f285947a;
        a.a(WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(super.getConfiguration(), "configuration");
    }
}
