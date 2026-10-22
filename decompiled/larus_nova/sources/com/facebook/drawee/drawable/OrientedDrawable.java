package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class OrientedDrawable extends ForwardingDrawable {
    private int mExifOrientation;
    private int mRotationAngle;
    final Matrix mRotationMatrix;
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int r100 = this.mExifOrientation;
        if (r100 == 5) goto L12;
        if (r100 == 7) goto L12;
        if ((this.mRotationAngle % 180) != 0) goto L12;
        return super.getIntrinsicHeight();
    L12:
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int r100 = this.mExifOrientation;
        if (r100 == 5) goto L12;
        if (r100 == 7) goto L12;
        if ((this.mRotationAngle % 180) != 0) goto L12;
        return super.getIntrinsicWidth();
    L12:
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (this.mRotationAngle > 0) goto L10;
        int r101 = this.mExifOrientation;
        if (r101 != 0) goto L7;
    L8:
        super.draw(r100);
        return;
    L7:
        if (r101 == 1) goto L8;
    L10:
        int r102 = r100.save();
        r100.concat(this.mRotationMatrix);
        super.draw(r100);
        r100.restoreToCount(r102);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix r100) {
        getParentTransform(r100);
        if (this.mRotationMatrix.isIdentity() == true) goto L6;
        r100.preConcat(this.mRotationMatrix);
        return;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Drawable r101 = getCurrent();
        int r102 = this.mRotationAngle;
        if (r102 > 0) goto L10;
        int r103 = this.mExifOrientation;
        if (r103 != 0) goto L7;
    L9:
        r101.setBounds(r100);
        return;
    L7:
        if (r103 == 1) goto L9;
    L10:
        int r104 = this.mExifOrientation;
        if (r104 != 2) goto L13;
        this.mRotationMatrix.setScale(-1.0f, 1.0f);
    L23:
        this.mTempMatrix.reset();
        this.mRotationMatrix.invert(this.mTempMatrix);
        this.mTempRectF.set(r100);
        this.mTempMatrix.mapRect(this.mTempRectF);
        RectF r105 = this.mTempRectF;
        r101.setBounds((int) r105.left, (int) r105.top, (int) r105.right, (int) r105.bottom);
        return;
    L13:
        if (r104 != 7) goto L15;
        this.mRotationMatrix.setRotate(270.0f, r100.centerX(), r100.centerY());
        this.mRotationMatrix.postScale(-1.0f, 1.0f);
        goto L23
    L15:
        if (r104 != 4) goto L17;
        this.mRotationMatrix.setScale(1.0f, -1.0f);
        goto L23
    L17:
        if (r104 == 5) goto L19;
        this.mRotationMatrix.setRotate(r102, r100.centerX(), r100.centerY());
        goto L23
    L19:
        this.mRotationMatrix.setRotate(270.0f, r100.centerX(), r100.centerY());
        this.mRotationMatrix.postScale(1.0f, -1.0f);
        goto L23
    }

    public OrientedDrawable(Drawable r100, int r101) {
        this(r100, r101, 0);
    }

    public OrientedDrawable(Drawable r100, int r101, int r102) {
        super(r100);
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        boolean r103 = true;
        if ((r101 % 90) != 0) goto L5;
        boolean r104 = true;
    L6:
        Preconditions.checkArgument(r104);
        if (r102 >= 0) goto L9;
    L11:
        r103 = false;
    L12:
        Preconditions.checkArgument(r103);
        this.mRotationMatrix = new Matrix();
        this.mRotationAngle = r101;
        this.mExifOrientation = r102;
        return;
    L9:
        if (r102 > 8) goto L11;
    L5:
        r104 = false;
        goto L6
    }
}
