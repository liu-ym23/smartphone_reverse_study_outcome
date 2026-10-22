package com.obric.oui.drawble;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/drawble/RotatingDrawable;", "Landroidx/appcompat/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class RotatingDrawable extends DrawableWrapper implements Animatable {
    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        new LinearInterpolator();
        throw null;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        throw null;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r100.save();
        r100.rotate(0.0f, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r100);
        r100.restore();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        if (r100.width() >= r100.height()) goto L5;
        r100.width();
        getWrappedDrawable().getIntrinsicWidth();
        return;
    L5:
        r100.height();
        getWrappedDrawable().getIntrinsicHeight();
    }
}
