package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer r1) {
        this.mContainer = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        ActionBarContainer r0 = this.mContainer;
        if (r0.mIsSplit == false) goto L7;
        Drawable r1 = r0.mSplitBackground;
        if (r1 == null) goto L16;
        r1.draw(r3);
        return;
    L16:
        return;
    L7:
        Drawable r2 = r0.mBackground;
        if (r2 == null) goto L10;
        r2.draw(r3);
    L10:
        ActionBarContainer r4 = this.mContainer;
        Drawable r5 = r4.mStackedBackground;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r4.mIsStacked == false) goto L19;
        r5.draw(r3);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r3) {
        ActionBarContainer r0 = this.mContainer;
        if (r0.mIsSplit == false) goto L7;
        Drawable r1 = r0.mSplitBackground;
        if (r1 == null) goto L11;
        r1.getOutline(r3);
        return;
    L11:
        return;
    L7:
        Drawable r2 = r0.mBackground;
        if (r2 == null) goto L13;
        r2.getOutline(r3);
        return;
    }
}
