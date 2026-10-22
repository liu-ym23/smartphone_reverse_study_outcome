package com.bytedance.android.ui.ec.widget.tools;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/tools/DrawableHelper;", "", "()V", "createTintBlackColorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "color", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawableHelper {
    public static final DrawableHelper INSTANCE = null;

    private DrawableHelper() {
    }

    static {
        INSTANCE = new DrawableHelper();
    }

    public final ColorMatrixColorFilter createTintBlackColorFilter(int r6) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r6), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r6), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r6), 0.0f, 0.0f, 0.0f, (Color.alpha(r6) * 1.0f) / 255, 0.0f});
    }
}
