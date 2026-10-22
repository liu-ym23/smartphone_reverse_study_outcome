package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;

/* JADX INFO: loaded from: classes23.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable {
    private int alpha;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private final Matrix[] edgeTransforms;
    private float interpolation;
    private final Matrix matrix;
    private final Paint paint;
    private Paint.Style paintStyle;
    private final Path path;
    private final PointF pointF;
    private float scale;
    private final float[] scratch;
    private final float[] scratch2;
    private final Region scratchRegion;
    private int shadowColor;
    private int shadowElevation;
    private boolean shadowEnabled;
    private int shadowRadius;
    private final ShapePath shapePath;
    private ShapePathModel shapedViewModel;
    private float strokeWidth;
    private PorterDuffColorFilter tintFilter;
    private ColorStateList tintList;
    private PorterDuff.Mode tintMode;
    private final Region transparentRegion;
    private boolean useTintColorForShadow;

    public MaterialShapeDrawable() {
        this(null);
    }

    private static int modulateAlpha(int r100, int r101) {
        return (r100 * (r101 + (r101 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void updateTintFilter() {
        ColorStateList r100 = this.tintList;
        if (r100 != null) goto L5;
    L11:
        this.tintFilter = null;
        return;
    L5:
        if (this.tintMode == null) goto L11;
        int r101 = r100.getColorForState(getState(), 0);
        this.tintFilter = new PorterDuffColorFilter(r101, this.tintMode);
        if (this.useTintColorForShadow == false) goto L13;
        this.shadowColor = r101;
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r100 = getBounds();
        this.transparentRegion.set(r100);
        getPath(r100.width(), r100.height(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getInterpolation() {
        return this.interpolation;
    }

    public Paint.Style getPaintStyle() {
        return this.paintStyle;
    }

    public float getScale() {
        return this.scale;
    }

    public int getShadowElevation() {
        return this.shadowElevation;
    }

    public int getShadowRadius() {
        return this.shadowRadius;
    }

    public ShapePathModel getShapedViewModel() {
        return this.shapedViewModel;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getTintList() {
        return this.tintList;
    }

    public boolean isShadowEnabled() {
        return this.shadowEnabled;
    }

    public MaterialShapeDrawable(ShapePathModel r100) {
        this.paint = new Paint();
        this.cornerTransforms = new Matrix[4];
        this.edgeTransforms = new Matrix[4];
        this.cornerPaths = new ShapePath[4];
        this.matrix = new Matrix();
        this.path = new Path();
        this.pointF = new PointF();
        this.shapePath = new ShapePath();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        this.scratch = new float[2];
        this.scratch2 = new float[2];
        this.shapedViewModel = null;
        int r101 = 0;
        this.shadowEnabled = false;
        this.useTintColorForShadow = false;
        this.interpolation = 1.0f;
        this.shadowColor = -16777216;
        this.shadowElevation = 5;
        this.shadowRadius = 10;
        this.alpha = 255;
        this.scale = 1.0f;
        this.strokeWidth = 0.0f;
        this.paintStyle = Paint.Style.FILL_AND_STROKE;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.tintList = null;
        this.shapedViewModel = r100;
    L3:
        if (r101 >= 4) goto L5;
        this.cornerTransforms[r101] = new Matrix();
        this.edgeTransforms[r101] = new Matrix();
        this.cornerPaths[r101] = new ShapePath();
        r101 = r101 + 1;
        goto L3
    }

    private CornerTreatment getCornerTreatmentForIndex(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return this.shapedViewModel.getTopLeftCorner();
    L11:
        return this.shapedViewModel.getBottomLeftCorner();
    L13:
        return this.shapedViewModel.getBottomRightCorner();
    L15:
        return this.shapedViewModel.getTopRightCorner();
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return this.shapedViewModel.getTopEdge();
    L11:
        return this.shapedViewModel.getLeftEdge();
    L13:
        return this.shapedViewModel.getBottomEdge();
    L15:
        return this.shapedViewModel.getRightEdge();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        this.paint.setColorFilter(this.tintFilter);
        int r100 = this.paint.getAlpha();
        this.paint.setAlpha(modulateAlpha(r100, this.alpha));
        this.paint.setStrokeWidth(this.strokeWidth);
        this.paint.setStyle(this.paintStyle);
        int r101 = this.shadowElevation;
        if (r101 <= 0) goto L8;
        if (this.shadowEnabled == false) goto L8;
        this.paint.setShadowLayer(this.shadowRadius, 0.0f, r101, this.shadowColor);
    L8:
        if (this.shapedViewModel == null) goto L10;
        getPath(r110.getWidth(), r110.getHeight(), this.path);
        r110.drawPath(this.path, this.paint);
    L11:
        this.paint.setAlpha(r100);
        return;
    L10:
        r110.drawRect(0.0f, 0.0f, r110.getWidth(), r110.getHeight(), this.paint);
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.alpha = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.paint.setColorFilter(r100);
        invalidateSelf();
    }

    public void setInterpolation(float r100) {
        this.interpolation = r100;
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style r100) {
        this.paintStyle = r100;
        invalidateSelf();
    }

    public void setScale(float r100) {
        this.scale = r100;
        invalidateSelf();
    }

    public void setShadowColor(int r100) {
        this.shadowColor = r100;
        this.useTintColorForShadow = false;
        invalidateSelf();
    }

    public void setShadowElevation(int r100) {
        this.shadowElevation = r100;
        invalidateSelf();
    }

    public void setShadowEnabled(boolean r100) {
        this.shadowEnabled = r100;
        invalidateSelf();
    }

    public void setShadowRadius(int r100) {
        this.shadowRadius = r100;
        invalidateSelf();
    }

    public void setShapedViewModel(ShapePathModel r100) {
        this.shapedViewModel = r100;
        invalidateSelf();
    }

    public void setStrokeWidth(float r100) {
        this.strokeWidth = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r100) {
        setTintList(ColorStateList.valueOf(r100));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        this.tintList = r100;
        updateTintFilter();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        this.tintMode = r100;
        updateTintFilter();
        invalidateSelf();
    }

    public void setUseTintColorForShadow(boolean r100) {
        this.useTintColorForShadow = r100;
        invalidateSelf();
    }

    private void appendCornerPath(int r100, Path r101) {
        float[] r102 = this.scratch;
        ShapePath r103 = this.cornerPaths[r100];
        r102[0] = r103.startX;
        r102[1] = r103.startY;
        this.cornerTransforms[r100].mapPoints(r102);
        if (r100 != 0) goto L5;
        float[] r104 = this.scratch;
        r101.moveTo(r104[0], r104[1]);
    L6:
        this.cornerPaths[r100].applyToPath(this.cornerTransforms[r100], r101);
        return;
    L5:
        float[] r105 = this.scratch;
        r101.lineTo(r105[0], r105[1]);
        goto L6
    }

    private void appendEdgePath(int r100, Path r101) {
        int r102 = (r100 + 1) % 4;
        float[] r103 = this.scratch;
        ShapePath r104 = this.cornerPaths[r100];
        r103[0] = r104.endX;
        r103[1] = r104.endY;
        this.cornerTransforms[r100].mapPoints(r103);
        float[] r105 = this.scratch2;
        ShapePath r106 = this.cornerPaths[r102];
        r105[0] = r106.startX;
        r105[1] = r106.startY;
        this.cornerTransforms[r102].mapPoints(r105);
        float[] r107 = this.scratch;
        float r108 = r107[0];
        float[] r109 = this.scratch2;
        float r110 = (float) Math.hypot(r108 - r109[0], r107[1] - r109[1]);
        this.shapePath.reset(0.0f, 0.0f);
        getEdgeTreatmentForIndex(r100).getEdgePath(r110, this.interpolation, this.shapePath);
        this.shapePath.applyToPath(this.edgeTransforms[r100], r101);
    }

    public boolean isPointInTransparentRegion(int r100, int r101) {
        return getTransparentRegion().contains(r100, r101);
    }

    private float angleOfCorner(int r100, int r101, int r102) {
        getCoordinatesOfCorner(((r100 - 1) + 4) % 4, r101, r102, this.pointF);
        PointF r103 = this.pointF;
        float r104 = r103.x;
        float r105 = r103.y;
        getCoordinatesOfCorner((r100 + 1) % 4, r101, r102, r103);
        PointF r106 = this.pointF;
        float r107 = r106.x;
        float r108 = r106.y;
        getCoordinatesOfCorner(r100, r101, r102, r106);
        PointF r109 = this.pointF;
        float r110 = r109.x;
        float r111 = r109.y;
        float r112 = r108 - r111;
        float r113 = ((float) Math.atan2(r105 - r111, r104 - r110)) - ((float) Math.atan2(r112, r107 - r110));
        if (r113 < 0.0f) goto L5;
        return r113;
    L5:
        return (float) (((double) r113) + 6.283185307179586d);
    }

    private float angleOfEdge(int r100, int r101, int r102) {
        int r103 = (r100 + 1) % 4;
        getCoordinatesOfCorner(r100, r101, r102, this.pointF);
        PointF r104 = this.pointF;
        float r105 = r104.x;
        float r106 = r104.y;
        getCoordinatesOfCorner(r103, r101, r102, r104);
        PointF r107 = this.pointF;
        return (float) Math.atan2(r107.y - r106, r107.x - r105);
    }

    private void getPath(int r100, int r101, Path r102) {
        getPathForSize(r100, r101, r102);
        if (this.scale != 1.0f) goto L5;
        return;
    L5:
        this.matrix.reset();
        Matrix r103 = this.matrix;
        float r104 = this.scale;
        r103.setScale(r104, r104, r100 / 2, r101 / 2);
        r102.transform(this.matrix);
    }

    private void setCornerPathAndTransform(int r100, int r101, int r102) {
        getCoordinatesOfCorner(r100, r101, r102, this.pointF);
        getCornerTreatmentForIndex(r100).getCornerPath(angleOfCorner(r100, r101, r102), this.interpolation, this.cornerPaths[r100]);
        float r103 = angleOfEdge(((r100 - 1) + 4) % 4, r101, r102) + 1.5707964f;
        this.cornerTransforms[r100].reset();
        Matrix r104 = this.cornerTransforms[r100];
        PointF r105 = this.pointF;
        r104.setTranslate(r105.x, r105.y);
        this.cornerTransforms[r100].preRotate((float) Math.toDegrees(r103));
    }

    private void setEdgeTransform(int r100, int r101, int r102) {
        float[] r103 = this.scratch;
        ShapePath r104 = this.cornerPaths[r100];
        r103[0] = r104.endX;
        r103[1] = r104.endY;
        this.cornerTransforms[r100].mapPoints(r103);
        float r105 = angleOfEdge(r100, r101, r102);
        this.edgeTransforms[r100].reset();
        Matrix r106 = this.edgeTransforms[r100];
        float[] r107 = this.scratch;
        r106.setTranslate(r107[0], r107[1]);
        this.edgeTransforms[r100].preRotate((float) Math.toDegrees(r105));
    }

    public void getPathForSize(int r100, int r101, Path r102) {
        r102.rewind();
        if (this.shapedViewModel != null) goto L5;
        return;
    L5:
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= 4) goto L9;
        setCornerPathAndTransform(r104, r100, r101);
        setEdgeTransform(r104, r100, r101);
        r104 = r104 + 1;
    L9:
        if (r103 >= 4) goto L11;
        appendCornerPath(r103, r102);
        appendEdgePath(r103, r102);
        r103 = r103 + 1;
        goto L9
    L11:
        r102.close();
    }

    private void getCoordinatesOfCorner(int r100, int r101, int r102, PointF r103) {
        if (r100 != 1) goto L5;
        r103.set(r101, 0.0f);
        return;
    L5:
        if (r100 != 2) goto L7;
        r103.set(r101, r102);
        return;
    L7:
        if (r100 == 3) goto L9;
        r103.set(0.0f, 0.0f);
        return;
    L9:
        r103.set(0.0f, r102);
    }
}
