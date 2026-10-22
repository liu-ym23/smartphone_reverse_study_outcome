package com.google.android.material.internal;

import android.R;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes23.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private int collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity;
    private float collapsedTextSize;
    private Typeface collapsedTypeface;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFraction;
    private int expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private CharSequence text;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private float textureAscent;
    private float textureDescent;
    private Paint texturePaint;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        USE_SCALING_TEXTURE = false;
        DEBUG_DRAW_PAINT = null;
    }

    private void calculateBaseOffsets() {
        float r100 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize);
        CharSequence r101 = this.textToDraw;
        float r102 = 0.0f;
        if (r101 == null) goto L5;
        float r103 = this.textPaint.measureText(r101, 0, r101.length());
    L6:
        int r104 = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int r105 = r104 & 112;
        if (r105 == 48) goto L11;
        if (r105 == 80) goto L10;
        this.collapsedDrawY = this.collapsedBounds.centerY() + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent());
    L12:
        int r106 = r104 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r106 == 1) goto L17;
        if (r106 == 5) goto L16;
        this.collapsedDrawX = this.collapsedBounds.left;
    L18:
        calculateUsingTextSize(this.expandedTextSize);
        CharSequence r107 = this.textToDraw;
        if (r107 == null) goto L21;
        r102 = this.textPaint.measureText(r107, 0, r107.length());
    L21:
        int r108 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int r109 = r108 & 112;
        if (r109 == 48) goto L26;
        if (r109 == 80) goto L25;
        this.expandedDrawY = this.expandedBounds.centerY() + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent());
    L27:
        int r110 = r108 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r110 == 1) goto L32;
        if (r110 == 5) goto L31;
        this.expandedDrawX = this.expandedBounds.left;
    L33:
        clearTexture();
        setInterpolatedTextSize(r100);
        return;
    L31:
        this.expandedDrawX = this.expandedBounds.right - r102;
        goto L33
    L32:
        this.expandedDrawX = this.expandedBounds.centerX() - (r102 / 2.0f);
        goto L33
    L25:
        this.expandedDrawY = this.expandedBounds.bottom;
        goto L27
    L26:
        this.expandedDrawY = this.expandedBounds.top - this.textPaint.ascent();
        goto L27
    L16:
        this.collapsedDrawX = this.collapsedBounds.right - r103;
        goto L18
    L17:
        this.collapsedDrawX = this.collapsedBounds.centerX() - (r103 / 2.0f);
        goto L18
    L10:
        this.collapsedDrawY = this.collapsedBounds.bottom;
        goto L12
    L11:
        this.collapsedDrawY = this.collapsedBounds.top - this.textPaint.ascent();
        goto L12
    L5:
        r103 = 0.0f;
        goto L6
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private void clearTexture() {
        Bitmap r100 = this.expandedTitleTexture;
        if (r100 == null) goto L6;
        r100.recycle();
        this.expandedTitleTexture = null;
        return;
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null) goto L5;
        return;
    L5:
        if (this.expandedBounds.isEmpty() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.textToDraw) == true) goto L21;
        calculateOffsets(0.0f);
        this.textureAscent = this.textPaint.ascent();
        this.textureDescent = this.textPaint.descent();
        TextPaint r100 = this.textPaint;
        CharSequence r101 = this.textToDraw;
        int r102 = Math.round(r100.measureText(r101, 0, r101.length()));
        int r103 = Math.round(this.textureDescent - this.textureAscent);
        if (r102 <= 0) goto L19;
        if (r103 <= 0) goto L22;
        this.expandedTitleTexture = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(this.expandedTitleTexture);
        CharSequence r105 = this.textToDraw;
        r104.drawText(r105, 0, r105.length(), 0.0f, r103 - this.textPaint.descent(), this.textPaint);
        if (this.texturePaint != null) goto L20;
        this.texturePaint = new Paint(3);
        return;
    L20:
        return;
    L22:
        return;
    L19:
        return;
    }

    private int getCurrentExpandedTextColor() {
        int[] r100 = this.state;
        if (r100 == null) goto L7;
        return this.expandedTextColor.getColorForState(r100, 0);
    L7:
        return this.expandedTextColor.getDefaultColor();
    }

    public float calculateCollapsedTextWidth() {
        if (this.text != null) goto L6;
        return 0.0f;
    L6:
        getTextPaintCollapsed(this.tmpPaint);
        TextPaint r100 = this.tmpPaint;
        CharSequence r101 = this.text;
        return r100.measureText(r101, 0, r101.length());
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public Typeface getCollapsedTypeface() {
        Typeface r100 = this.collapsedTypeface;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return Typeface.DEFAULT;
    }

    public int getCurrentCollapsedTextColor() {
        int[] r100 = this.state;
        if (r100 == null) goto L7;
        return this.collapsedTextColor.getColorForState(r100, 0);
    L7:
        return this.collapsedTextColor.getDefaultColor();
    }

    public Typeface getExpandedTypeface() {
        Typeface r100 = this.expandedTypeface;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return Typeface.DEFAULT;
    }

    public final boolean isStateful() {
        ColorStateList r100 = this.collapsedTextColor;
        if (r100 != null) goto L5;
    L6:
        ColorStateList r101 = this.expandedTextColor;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r100.isStateful() == true) goto L10;
        goto L6
    }

    public void onBoundsChanged() {
        if (this.collapsedBounds.width() > 0) goto L5;
    L11:
        boolean r100 = false;
    L12:
        this.drawTitle = r100;
        return;
    L5:
        if (this.collapsedBounds.height() <= 0) goto L11;
        if (this.expandedBounds.width() <= 0) goto L11;
        if (this.expandedBounds.height() <= 0) goto L11;
        r100 = true;
        goto L12
    }

    public void recalculate() {
        if (this.view.getHeight() > 0) goto L5;
        return;
    L5:
        if (this.view.getWidth() <= 0) goto L9;
        calculateBaseOffsets();
        calculateCurrentOffsets();
        return;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public CharSequence getText() {
        return this.text;
    }

    public CollapsingTextHelper(View r100) {
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.view = r100;
        TextPaint r101 = new TextPaint(129);
        this.textPaint = r101;
        this.tmpPaint = new TextPaint(r101);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
    }

    private boolean calculateIsRtl(CharSequence r100) {
        boolean r101 = true;
        if (ViewCompat.getLayoutDirection(this.view) == 1) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L8;
        TextDirectionHeuristicCompat r102 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    L10:
        return r102.isRtl(r100, 0, r100.length());
    L8:
        r102 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        goto L10
    }

    private void calculateOffsets(float r100) {
        interpolateBounds(r100);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, r100, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, r100, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, r100, this.textSizeInterpolator));
        if (this.collapsedTextColor == this.expandedTextColor) goto L5;
        this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), r100));
    L6:
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, r100, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, r100, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, r100, null), blendColors(this.expandedShadowColor, this.collapsedShadowColor, r100));
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L5:
        this.textPaint.setColor(getCurrentCollapsedTextColor());
        goto L6
    }

    private void calculateUsingTextSize(float r100) {
        if (this.text != null) goto L5;
        return;
    L5:
        float r101 = this.collapsedBounds.width();
        float r102 = this.expandedBounds.width();
        boolean r103 = true;
        if (isClose(r100, this.collapsedTextSize) == false) goto L11;
        float r104 = this.collapsedTextSize;
        this.scale = 1.0f;
        Typeface r105 = this.currentTypeface;
        Typeface r106 = this.collapsedTypeface;
        if (r105 == r106) goto L10;
        this.currentTypeface = r106;
        boolean r107 = true;
    L25:
        if (r101 <= 0.0f) goto L36;
        if (this.currentTextSize == r104) goto L29;
    L33:
        r107 = true;
    L34:
        this.currentTextSize = r104;
        this.boundsChanged = false;
        goto L36
    L29:
        if (this.boundsChanged == true) goto L33;
        if (r107 == true) goto L33;
        r107 = false;
    L36:
        if (this.textToDraw == null) goto L38;
        if (r107 == true) goto L38;
        return;
    L38:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        TextPaint r108 = this.textPaint;
        if (this.scale != 1.0f) goto L42;
        r103 = false;
    L42:
        r108.setLinearText(r103);
        CharSequence r109 = TextUtils.ellipsize(this.text, this.textPaint, r101, TextUtils.TruncateAt.END);
        if (TextUtils.equals(r109, this.textToDraw) == true) goto L47;
        this.textToDraw = r109;
        this.isRtl = calculateIsRtl(r109);
        return;
    L47:
        return;
    L10:
        r107 = false;
        goto L25
    L11:
        float r110 = this.expandedTextSize;
        Typeface r111 = this.currentTypeface;
        Typeface r112 = this.expandedTypeface;
        if (r111 == r112) goto L14;
        this.currentTypeface = r112;
        boolean r113 = true;
    L16:
        if (isClose(r100, r110) == false) goto L18;
        this.scale = 1.0f;
    L19:
        float r114 = this.collapsedTextSize / this.expandedTextSize;
        if ((r102 * r114) <= r101) goto L22;
        r101 = Math.min(r101 / r114, r102);
    L23:
        r104 = r110;
        r107 = r113;
        goto L25
    L22:
        r101 = r102;
        goto L23
    L18:
        this.scale = r100 / this.expandedTextSize;
        goto L19
    L14:
        r113 = false;
        goto L16
    }

    private void getTextPaintCollapsed(TextPaint r100) {
        r100.setTextSize(this.collapsedTextSize);
        r100.setTypeface(this.collapsedTypeface);
    }

    private void interpolateBounds(float r100) {
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, r100, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, r100, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, r100, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, r100, this.positionInterpolator);
    }

    private Typeface readFontFamilyTypeface(int r100) {
        TypedArray r101 = this.view.getContext().obtainStyledAttributes(r100, new int[]{R.attr.fontFamily});
        String r102 = r101.getString(0);     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        Typeface r103 = Typeface.create(r102, 0);     // Catch: Throwable -> L10
        r101.recycle();
        return r103;
    L8:
        r101.recycle();
        return null;
    L10:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    private void setInterpolatedTextSize(float r100) {
        calculateUsingTextSize(r100);
        if (USE_SCALING_TEXTURE == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.useTexture = r101;
        if (r101 == false) goto L11;
        ensureExpandedTexture();
    L11:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L5:
        if (this.scale == 1.0f) goto L7;
        r101 = true;
        goto L8
    }

    public void draw(Canvas r110) {
        int r100 = r110.save();
        if (this.textToDraw != null) goto L5;
    L23:
        r110.restoreToCount(r100);
        return;
    L5:
        if (this.drawTitle == false) goto L23;
        float r101 = this.currentDrawX;
        float r102 = this.currentDrawY;
        if (this.useTexture == true) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        float r104 = this.textureAscent * this.scale;
    L15:
        if (r103 == false) goto L17;
        r102 = r102 + r104;
    L17:
        float r105 = r102;
        float r106 = this.scale;
        if (r106 == 1.0f) goto L20;
        r110.scale(r106, r106, r101, r105);
    L20:
        if (r103 == false) goto L22;
        r110.drawBitmap(this.expandedTitleTexture, r101, r105, this.texturePaint);
        goto L23
    L22:
        CharSequence r107 = this.textToDraw;
        r110.drawText(r107, 0, r107.length(), r101, r105, this.textPaint);
        goto L23
    L14:
        r104 = this.textPaint.ascent() * this.scale;
        this.textPaint.descent();
        goto L15
    L9:
        if (this.expandedTitleTexture == null) goto L11;
        r103 = true;
        goto L12
    }

    public void getCollapsedTextActualBounds(RectF r100) {
        boolean r101 = calculateIsRtl(this.text);
        Rect r102 = this.collapsedBounds;
        if (r101 == true) goto L5;
        float r103 = r102.left;
    L6:
        r100.left = r103;
        Rect r104 = this.collapsedBounds;
        r100.top = r104.top;
        if (r101 == true) goto L9;
        float r105 = r103 + calculateCollapsedTextWidth();
    L10:
        r100.right = r105;
        r100.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
        return;
    L9:
        r105 = r104.right;
        goto L10
    L5:
        r103 = r102.right - calculateCollapsedTextWidth();
        goto L6
    }

    public void setCollapsedTextAppearance(int r100) {
        TintTypedArray r101 = TintTypedArray.obtainStyledAttributes(this.view.getContext(), r100, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        if (r101.hasValue(3) == false) goto L6;
        this.collapsedTextColor = r101.getColorStateList(3);
    L6:
        if (r101.hasValue(0) == false) goto L8;
        this.collapsedTextSize = r101.getDimensionPixelSize(0, (int) this.collapsedTextSize);
    L8:
        this.collapsedShadowColor = r101.getInt(6, 0);
        this.collapsedShadowDx = r101.getFloat(7, 0.0f);
        this.collapsedShadowDy = r101.getFloat(8, 0.0f);
        this.collapsedShadowRadius = r101.getFloat(9, 0.0f);
        r101.recycle();
        this.collapsedTypeface = readFontFamilyTypeface(r100);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList r100) {
        if (this.collapsedTextColor == r100) goto L6;
        this.collapsedTextColor = r100;
        recalculate();
        return;
    }

    public void setCollapsedTextGravity(int r100) {
        if (this.collapsedTextGravity == r100) goto L6;
        this.collapsedTextGravity = r100;
        recalculate();
        return;
    }

    public void setCollapsedTextSize(float r100) {
        if (this.collapsedTextSize == r100) goto L6;
        this.collapsedTextSize = r100;
        recalculate();
        return;
    }

    public void setCollapsedTypeface(Typeface r100) {
        if (this.collapsedTypeface == r100) goto L6;
        this.collapsedTypeface = r100;
        recalculate();
        return;
    }

    public void setExpandedTextAppearance(int r100) {
        TintTypedArray r101 = TintTypedArray.obtainStyledAttributes(this.view.getContext(), r100, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        if (r101.hasValue(3) == false) goto L6;
        this.expandedTextColor = r101.getColorStateList(3);
    L6:
        if (r101.hasValue(0) == false) goto L8;
        this.expandedTextSize = r101.getDimensionPixelSize(0, (int) this.expandedTextSize);
    L8:
        this.expandedShadowColor = r101.getInt(6, 0);
        this.expandedShadowDx = r101.getFloat(7, 0.0f);
        this.expandedShadowDy = r101.getFloat(8, 0.0f);
        this.expandedShadowRadius = r101.getFloat(9, 0.0f);
        r101.recycle();
        this.expandedTypeface = readFontFamilyTypeface(r100);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList r100) {
        if (this.expandedTextColor == r100) goto L6;
        this.expandedTextColor = r100;
        recalculate();
        return;
    }

    public void setExpandedTextGravity(int r100) {
        if (this.expandedTextGravity == r100) goto L6;
        this.expandedTextGravity = r100;
        recalculate();
        return;
    }

    public void setExpandedTextSize(float r100) {
        if (this.expandedTextSize == r100) goto L6;
        this.expandedTextSize = r100;
        recalculate();
        return;
    }

    public void setExpandedTypeface(Typeface r100) {
        if (this.expandedTypeface == r100) goto L6;
        this.expandedTypeface = r100;
        recalculate();
        return;
    }

    public void setExpansionFraction(float r100) {
        float r101 = MathUtils.clamp(r100, 0.0f, 1.0f);
        if (r101 == this.expandedFraction) goto L6;
        this.expandedFraction = r101;
        calculateCurrentOffsets();
        return;
    }

    public void setPositionInterpolator(TimeInterpolator r100) {
        this.positionInterpolator = r100;
        recalculate();
    }

    public final boolean setState(int[] r100) {
        this.state = r100;
        if (isStateful() == false) goto L6;
        recalculate();
        return true;
    L6:
        return false;
    }

    public void setText(CharSequence r100) {
        if (r100 != null) goto L4;
    L5:
        this.text = r100;
        this.textToDraw = null;
        clearTexture();
        recalculate();
        return;
    L4:
        if (r100.equals(this.text) == false) goto L5;
    }

    public void setTextSizeInterpolator(TimeInterpolator r100) {
        this.textSizeInterpolator = r100;
        recalculate();
    }

    public void setTypefaces(Typeface r100) {
        this.expandedTypeface = r100;
        this.collapsedTypeface = r100;
        recalculate();
    }

    private static boolean isClose(float r100, float r101) {
        if (Math.abs(r100 - r101) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    private static int blendColors(int r100, int r101, float r102) {
        float r103 = 1.0f - r102;
        return Color.argb((int) ((Color.alpha(r100) * r103) + (Color.alpha(r101) * r102)), (int) ((Color.red(r100) * r103) + (Color.red(r101) * r102)), (int) ((Color.green(r100) * r103) + (Color.green(r101) * r102)), (int) ((Color.blue(r100) * r103) + (Color.blue(r101) * r102)));
    }

    private static float lerp(float r100, float r101, float r102, TimeInterpolator r103) {
        if (r103 == null) goto L5;
        r102 = r103.getInterpolation(r102);
    L5:
        return AnimationUtils.lerp(r100, r101, r102);
    }

    public void setCollapsedBounds(int r100, int r101, int r102, int r103) {
        if (rectEquals(this.collapsedBounds, r100, r101, r102, r103) == true) goto L6;
        this.collapsedBounds.set(r100, r101, r102, r103);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    public void setExpandedBounds(int r100, int r101, int r102, int r103) {
        if (rectEquals(this.expandedBounds, r100, r101, r102, r103) == true) goto L6;
        this.expandedBounds.set(r100, r101, r102, r103);
        this.boundsChanged = true;
        onBoundsChanged();
        return;
    }

    private static boolean rectEquals(Rect r100, int r101, int r102, int r103, int r104) {
        if (r100.left == r101) goto L5;
    L11:
        return false;
    L5:
        if (r100.top != r102) goto L11;
        if (r100.right != r103) goto L11;
        if (r100.bottom != r104) goto L11;
        return true;
    }
}
