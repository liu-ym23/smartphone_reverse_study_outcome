package com.facebook.drawee.generic;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    private static boolean sEnableVisibleOpt;

    @Nullable
    Drawable mControllerOverlay;

    @Nullable
    private VisibilityCallback mVisibilityCallback;

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    public Drawable getControllerOverlay() {
        return this.mControllerOverlay;
    }

    public RootDrawable(Drawable r100) {
        super(r100);
        this.mControllerOverlay = null;
    }

    public static void enableVisibleOpt(boolean r100) {
        sEnableVisibleOpt = r100;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (sEnableVisibleOpt == false) goto L5;
    L7:
        VisibilityCallback r101 = this.mVisibilityCallback;
        if (r101 == null) goto L10;
        r101.onDraw();
    L10:
        super.draw(r100);
        Drawable r102 = this.mControllerOverlay;
        if (r102 == null) goto L14;
        r102.setBounds(getBounds());
        this.mControllerOverlay.draw(r100);
        return;
    L14:
        return;
    L5:
        if (isVisible() == true) goto L7;
    }

    public void setControllerOverlay(@Nullable Drawable r100) {
        this.mControllerOverlay = r100;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void setVisibilityCallback(@Nullable VisibilityCallback r100) {
        this.mVisibilityCallback = r100;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        VisibilityCallback r102 = this.mVisibilityCallback;
        if (r102 == null) goto L6;
        r102.onVisibilityChange(r100);
    L6:
        return super.setVisible(r100, r101);
    }
}
