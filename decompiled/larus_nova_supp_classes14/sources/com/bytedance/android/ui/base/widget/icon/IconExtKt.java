package com.bytedance.android.ui.base.widget.icon;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"setDrawableSize", "", "drawable", "Landroid/graphics/drawable/Drawable;", "size", "", "coloredDrawable", "color", "ui-base-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class IconExtKt {
    public static final Drawable coloredDrawable(Drawable r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$coloredDrawable");
        Drawable r4 = r2.mutate();
        r4.setColorFilter(new PorterDuffColorFilter(r3, PorterDuff.Mode.SRC_IN));
        return r4;
    }

    public static final void setDrawableSize(Drawable r1, int r2) {
        if (r1 == null) goto L5;
        r1.setBounds(0, 0, r2, r2);
        return;
    }
}
