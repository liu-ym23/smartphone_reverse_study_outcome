package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 0;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;
    private Drawable overlayDrawable;
    private CircularRevealWidget.RevealInfo revealInfo;
    private final Paint revealPaint;
    private final Path revealPath;
    private final Paint scrimPaint;
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas r100);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    static {
        STRATEGY = 2;
    }

    private void invalidateRevealInfo() {
        if (STRATEGY != 1) goto L7;
        this.revealPath.rewind();
        CircularRevealWidget.RevealInfo r100 = this.revealInfo;
        if (r100 == null) goto L7;
        this.revealPath.addCircle(r100.centerX, r100.centerY, r100.radius, Path.Direction.CW);
    L7:
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget.RevealInfo r100 = this.revealInfo;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (STRATEGY != 0) goto L17;
        if (r101 == false) goto L13;
        return false;
    L13:
        if (this.hasCircularRevealCache == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return !r101;
    L5:
        if (r100.isInvalid() == true) goto L8;
        r101 = false;
        goto L10
    }

    private boolean shouldDrawOverlayDrawable() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L9:
        return false;
    L5:
        if (this.overlayDrawable == null) goto L9;
        if (this.revealInfo == null) goto L9;
        return true;
    }

    private boolean shouldDrawScrim() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.scrimPaint.getColor()) == 0) goto L7;
        return true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY != 0) goto L15;
        this.buildingCircularRevealCache = true;
        this.hasCircularRevealCache = false;
        this.view.buildDrawingCache();
        Bitmap r100 = this.view.getDrawingCache();
        if (r100 == null) goto L7;
    L11:
        if (r100 == null) goto L13;
        Paint r101 = this.revealPaint;
        Shader.TileMode r102 = Shader.TileMode.CLAMP;
        r101.setShader(new BitmapShader(r100, r102, r102));
    L13:
        this.buildingCircularRevealCache = false;
        this.hasCircularRevealCache = true;
        return;
    L7:
        if (this.view.getWidth() == 0) goto L11;
        if (this.view.getHeight() == 0) goto L11;
        r100 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r100);
        this.view.draw(r103);
        goto L11
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY != 0) goto L6;
        this.hasCircularRevealCache = false;
        this.view.destroyDrawingCache();
        this.revealPaint.setShader(null);
        this.view.invalidate();
        return;
    }

    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo r100 = this.revealInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        CircularRevealWidget.RevealInfo r101 = new CircularRevealWidget.RevealInfo(r100);
        if (r101.isInvalid() == false) goto L9;
        r101.radius = getDistanceToFurthestCorner(r101);
    L9:
        return r101;
    }

    public boolean isOpaque() {
        if (this.delegate.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldDrawCircularReveal() == true) goto L7;
        return true;
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(Delegate r100) {
        this.delegate = r100;
        View r101 = (View) r100;
        this.view = r101;
        r101.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint r102 = new Paint(1);
        this.scrimPaint = r102;
        r102.setColor(0);
    }

    private void drawDebugMode(Canvas r100) {
        this.delegate.actualDraw(r100);
        if (shouldDrawScrim() == false) goto L6;
        CircularRevealWidget.RevealInfo r101 = this.revealInfo;
        r100.drawCircle(r101.centerX, r101.centerY, r101.radius, this.scrimPaint);
    L6:
        if (shouldDrawCircularReveal() == false) goto L8;
        drawDebugCircle(r100, -16777216, 10.0f);
        drawDebugCircle(r100, -65536, 5.0f);
    L8:
        drawOverlayDrawable(r100);
    }

    private void drawOverlayDrawable(Canvas r100) {
        if (shouldDrawOverlayDrawable() == false) goto L6;
        Rect r101 = this.overlayDrawable.getBounds();
        float r102 = this.revealInfo.centerX - (r101.width() / 2.0f);
        float r103 = this.revealInfo.centerY - (r101.height() / 2.0f);
        r100.translate(r102, r103);
        this.overlayDrawable.draw(r100);
        r100.translate(-r102, -r103);
        return;
    }

    private float getDistanceToFurthestCorner(CircularRevealWidget.RevealInfo r100) {
        return MathUtils.distanceToFurthestCorner(r100.centerX, r100.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    public void draw(Canvas r100) {
        if (shouldDrawCircularReveal() == false) goto L22;
        int r101 = STRATEGY;
        if (r101 != 0) goto L7;
        CircularRevealWidget.RevealInfo r102 = this.revealInfo;
        r100.drawCircle(r102.centerX, r102.centerY, r102.radius, this.revealPaint);
        if (shouldDrawScrim() == false) goto L25;
        CircularRevealWidget.RevealInfo r103 = this.revealInfo;
        r100.drawCircle(r103.centerX, r103.centerY, r103.radius, this.scrimPaint);
    L25:
        drawOverlayDrawable(r100);
        return;
    L7:
        if (r101 != 1) goto L9;
        int r104 = r100.save();
        r100.clipPath(this.revealPath);
        this.delegate.actualDraw(r100);
        if (shouldDrawScrim() == false) goto L18;
        r100.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
    L18:
        r100.restoreToCount(r104);
        goto L25
    L9:
        if (r101 != 2) goto L14;
        this.delegate.actualDraw(r100);
        if (shouldDrawScrim() == false) goto L25;
        r100.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    L14:
        throw new IllegalStateException("Unsupported strategy " + r101);
    L22:
        this.delegate.actualDraw(r100);
        if (shouldDrawScrim() == false) goto L25;
        r100.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    }

    public void setCircularRevealOverlayDrawable(Drawable r100) {
        this.overlayDrawable = r100;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(int r100) {
        this.scrimPaint.setColor(r100);
        this.view.invalidate();
    }

    public void setRevealInfo(CircularRevealWidget.RevealInfo r100) {
        if (r100 != null) goto L4;
        this.revealInfo = null;
    L11:
        invalidateRevealInfo();
        return;
    L4:
        CircularRevealWidget.RevealInfo r101 = this.revealInfo;
        if (r101 != null) goto L7;
        this.revealInfo = new CircularRevealWidget.RevealInfo(r100);
    L9:
        if (MathUtils.geq(r100.radius, getDistanceToFurthestCorner(r100), 1.0E-4f) == false) goto L11;
        this.revealInfo.radius = Float.MAX_VALUE;
        goto L11
    L7:
        r101.set(r100);
        goto L9
    }

    private void drawDebugCircle(Canvas r100, int r101, float r102) {
        this.debugPaint.setColor(r101);
        this.debugPaint.setStrokeWidth(r102);
        CircularRevealWidget.RevealInfo r103 = this.revealInfo;
        r100.drawCircle(r103.centerX, r103.centerY, r103.radius - (r102 / 2.0f), this.debugPaint);
    }
}
