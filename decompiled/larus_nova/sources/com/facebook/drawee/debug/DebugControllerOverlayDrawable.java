package com.facebook.drawee.debug;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    private static final int DEFAULT_LIMIT_BITMAP_CONTRAST = 2;
    private static final long DEFAULT_LIMIT_FILE_SIZE = 20971520;
    private static final long DEFAULT_LIMIT_RAM_SIZE = 0;
    private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    private static final int MAX_LINE_WIDTH_EM = 8;
    private static final int MAX_NUMBER_OF_LINES = 9;
    private static final int MAX_TEXT_SIZE_PX = 40;
    private static final int MIN_TEXT_SIZE_PX = 10;
    private static final String NO_CONTROLLER_ID = "none";
    private static final int OUTLINE_COLOR = -26624;
    private static final int OUTLINE_STROKE_WIDTH_PX = 2;
    static final int OVERLAY_COLOR_IMAGE_ALMOST_OK = 1728026624;
    static final int OVERLAY_COLOR_IMAGE_NOT_OK = 1727284022;
    static final int OVERLAY_COLOR_IMAGE_OK = 1716301648;
    private static final int TEXT_BACKGROUND_COLOR = 268435456;
    private static final int TEXT_COLOR = -1;
    private static final int TEXT_LINE_SPACING_PX = 8;
    private static final int TEXT_PADDING_PX = 10;
    private static boolean isShowAnim;
    private static boolean isShowBigImage;
    private static boolean isShowFormat;
    private static boolean isShowID;
    private static boolean isShowIDS;
    private static boolean isShowImageSize;
    private static boolean isShowImageWH;
    private static boolean isShowOrigin;
    private static boolean isShowScale;
    private static boolean isShowTimeCost;
    private static boolean isShowViewWH;
    private static float mPaintSizeRatio;
    private static int sLimitBitmapContrast;
    private static long sLimitFileSize;
    private static long sLimitRamSize;
    private String mBigReason;
    private String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFileSize;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;
    private String mImageFormat;
    private String mImageId;
    private int mImageSizeBytes;
    private boolean mIsBigImage;
    private int mLineIncrementPx;
    private int mLoopCount;
    private final Matrix mMatrix;
    private String mOrigin;
    private final Paint mPaint;
    private final Rect mRect;
    private final RectF mRectF;
    private int mSampleSize;
    private ScalingUtils.ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mTextGravity;
    private int mWidthPx;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1;
        this.mOrigin = null;
        this.mSampleSize = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
    }

    static {
        long r100 = getScreenPixelMemory();
        DEFAULT_LIMIT_RAM_SIZE = r100;
        sLimitBitmapContrast = 2;
        sLimitFileSize = DEFAULT_LIMIT_FILE_SIZE;
        sLimitRamSize = r100;
        isShowOrigin = true;
        isShowTimeCost = true;
        isShowScale = true;
        isShowImageSize = true;
        isShowFormat = true;
        isShowImageWH = true;
        isShowViewWH = true;
        isShowID = true;
        isShowIDS = true;
        isShowAnim = true;
        isShowBigImage = false;
        mPaintSizeRatio = 1.0f;
    }

    public DebugControllerOverlayDrawable() {
        this.mSampleSize = -1;
        this.mTextGravity = 80;
        this.mPaint = new Paint(1);
        this.mMatrix = new Matrix();
        this.mRect = new Rect();
        this.mRectF = new RectF();
        reset();
    }

    private static long getScreenPixelMemory() {
        DisplayMetrics r100 = INVOKEVIRTUAL_com_facebook_drawee_debug_DebugControllerOverlayDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem());
        return (r100.heightPixels * r100.widthPixels) * 4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_facebook_drawee_debug_DebugControllerOverlayDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static void setPaintSizeRatio(float r100) {
        mPaintSizeRatio = r100;
    }

    public static void showBigOverlayInfo(boolean r100) {
        isShowBigImage = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Rect r101 = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(OUTLINE_COLOR);
        r100.drawRect(r101.left, r101.top, r101.right, r101.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        r100.drawRect(r101.left, r101.top, r101.right, r101.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        String r102 = this.mImageId;
        if (r102 == null) goto L8;
        if (isShowIDS == false) goto L11;
        addDebugText(r100, "IDs: %s, %s", new Object[]{this.mControllerId, r102});
    L11:
        if (isShowViewWH == false) goto L14;
        addDebugText(r100, "D: %dx%d", new Object[]{Integer.valueOf(r101.width()), Integer.valueOf(r101.height())});
    L14:
        if (isShowImageWH == false) goto L17;
        addDebugText(r100, "I: %dx%d %d", new Object[]{Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx), Integer.valueOf(this.mSampleSize)});
    L17:
        if (isShowImageSize == false) goto L19;
        addDebugText(r100, "I: %d KiB", new Object[]{Integer.valueOf(this.mImageSizeBytes / 1024)});
    L19:
        String r103 = this.mImageFormat;
        if (r103 != null) goto L22;
    L24:
        int r104 = this.mFrameCount;
        if (r104 > 0) goto L27;
    L29:
        ScalingUtils.ScaleType r105 = this.mScaleType;
        if (r105 != null) goto L32;
    L34:
        long r106 = this.mFinalImageTimeMs;
        if (r106 >= 0) goto L37;
    L39:
        String r107 = this.mOrigin;
        if (r107 == null) goto L45;
        if (isShowOrigin == false) goto L45;
        addDebugText(r100, "origin: %s", new Object[]{r107});
    L45:
        if (isShowBigImage == false) goto L66;
        this.mBigReason = "";
        if (this.mFileSize <= sLimitFileSize) goto L50;
        this.mIsBigImage = true;
        this.mBigReason = "File,";
    L50:
        if (this.mImageSizeBytes <= sLimitRamSize) goto L53;
        this.mIsBigImage = true;
        this.mBigReason += "Ram,";
    L53:
        if (this.mWidthPx <= (r101.width() * sLimitBitmapContrast)) goto L55;
    L56:
        this.mIsBigImage = true;
        this.mBigReason += "WH";
    L57:
        boolean r108 = this.mIsBigImage;
        if (r108 == true) goto L60;
        this.mBigReason = "Not Big";
    L60:
        String r109 = this.mBigReason;
        if (r108 == false) goto L63;
        int r110 = -65536;
    L64:
        addDebugTextWithColor(r100, "isBigImg", r109, r110);
        return;
    L63:
        r110 = FakePickerAvatarCreator.GREEN;
        goto L64
    L55:
        if (this.mHeightPx <= (r101.height() * sLimitBitmapContrast)) goto L57;
    L66:
        return;
    L37:
        if (isShowTimeCost == false) goto L39;
        addDebugText(r100, "t: %d ms", new Object[]{Long.valueOf(r106)});
        goto L39
    L32:
        if (isShowScale == false) goto L34;
        addDebugText(r100, "scale: %s", new Object[]{r105});
        goto L34
    L27:
        if (isShowAnim == false) goto L29;
        addDebugText(r100, "anim: f %d, l %d", new Object[]{Integer.valueOf(r104), Integer.valueOf(this.mLoopCount)});
        goto L29
    L22:
        if (isShowFormat == false) goto L24;
        addDebugText(r100, "i format: %s", new Object[]{r103});
        goto L24
    L8:
        if (isShowID == false) goto L11;
        addDebugText(r100, "ID: %s", new Object[]{this.mControllerId});
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        prepareDebugTextParameters(r100, 9, 8);
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long r100) {
        this.mFinalImageTimeMs = r100;
        invalidateSelf();
    }

    public void setControllerId(@Nullable String r100) {
        if (r100 != null) goto L5;
        r100 = "none";
    L5:
        this.mControllerId = r100;
        invalidateSelf();
    }

    public void setFileSize(long r100) {
        this.mFileSize = r100;
    }

    public void setFinalImageTimeMs(long r100) {
        this.mFinalImageTimeMs = r100;
    }

    public void setImageFormat(@Nullable String r100) {
        this.mImageFormat = r100;
    }

    public void setImageId(@Nullable String r100) {
        this.mImageId = r100;
        invalidateSelf();
    }

    public void setImageSize(int r100) {
        this.mImageSizeBytes = r100;
    }

    public void setOrigin(String r100) {
        this.mOrigin = r100;
        invalidateSelf();
    }

    public void setSampleSize(int r100) {
        this.mSampleSize = r100;
        invalidateSelf();
    }

    public void setScaleType(ScalingUtils.ScaleType r100) {
        this.mScaleType = r100;
    }

    public void setTextGravity(int r100) {
        this.mTextGravity = r100;
        invalidateSelf();
    }

    public void setAnimationInfo(int r100, int r101) {
        this.mFrameCount = r100;
        this.mLoopCount = r101;
        invalidateSelf();
    }

    public void setDimensions(int r100, int r101) {
        this.mWidthPx = r100;
        this.mHeightPx = r101;
        invalidateSelf();
    }

    private void addDebugText(Canvas r100, String r101, @Nullable Object... r102) {
        if (r102 != null) goto L4;
        r100.drawText(r101, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
    L5:
        this.mCurrentTextYPx += this.mLineIncrementPx;
        return;
    L4:
        r100.drawText(String.format(r101, r102), this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        goto L5
    }

    private void prepareDebugTextParameters(Rect r100, int r101, int r102) {
        int r103 = Math.min(40, Math.max(10, Math.min(r100.width() / r102, r100.height() / r101)));
        this.mPaint.setTextSize(r103 * mPaintSizeRatio);
        int r104 = (int) ((r103 + 8) * mPaintSizeRatio);
        this.mLineIncrementPx = r104;
        int r105 = this.mTextGravity;
        if (r105 != 80) goto L5;
        this.mLineIncrementPx = r104 * (-1);
    L5:
        this.mStartTextXPx = r100.left + 10;
        if (r105 != 80) goto L8;
        int r106 = r100.bottom - 10;
    L9:
        this.mStartTextYPx = r106;
        int r107 = Math.abs(r100.bottom - r100.top);
        int r108 = Math.abs(r100.right - r100.left);
        if (r108 <= 500) goto L12;
        this.mStartTextXPx += r108 / 10;
    L12:
        if (r107 > 500) goto L14;
        return;
    L14:
        if (this.mTextGravity != 80) goto L16;
        this.mStartTextYPx -= r107 / 10;
        return;
    L16:
        this.mStartTextYPx += r107 / 10;
        return;
    L8:
        r106 = (r100.top + 10) + 10;
        goto L9
    }

    public static void setLimit(int r100, long r101, long r102) {
        sLimitBitmapContrast = r100;
        sLimitFileSize = r101;
        sLimitRamSize = r102;
    }

    public int determineOverlayColor(int r110, int r111, @Nullable ScalingUtils.ScaleType r112) {
        int r100 = getBounds().width();
        int r101 = getBounds().height();
        if (r100 <= 0) goto L22;
        if (r101 <= 0) goto L22;
        if (r110 <= 0) goto L22;
        if (r111 <= 0) goto L22;
        if (r112 == null) goto L10;
        Rect r102 = this.mRect;
        r102.top = 0;
        r102.left = 0;
        r102.right = r100;
        r102.bottom = r101;
        this.mMatrix.reset();
        r112.getTransform(this.mMatrix, this.mRect, r110, r111, 0.0f, 0.0f);
        RectF r113 = this.mRectF;
        r113.top = 0.0f;
        r113.left = 0.0f;
        r113.right = r110;
        r113.bottom = r111;
        this.mMatrix.mapRect(r113);
        int r114 = (int) this.mRectF.width();
        int r103 = (int) this.mRectF.height();
        r100 = Math.min(r100, r114);
        r101 = Math.min(r101, r103);
    L10:
        float r115 = r100;
        float r104 = r115 * 0.1f;
        float r116 = r115 * 0.5f;
        float r105 = r101;
        float r106 = 0.1f * r105;
        float r107 = r105 * 0.5f;
        int r117 = Math.abs(r110 - r100);
        int r118 = Math.abs(r111 - r101);
        float r119 = r117;
        if (r119 >= r104) goto L17;
        if (r118 >= r106) goto L17;
        return OVERLAY_COLOR_IMAGE_OK;
    L17:
        if (r119 >= r116) goto L22;
        if (r118 >= r107) goto L22;
        return OVERLAY_COLOR_IMAGE_ALMOST_OK;
    L22:
        return OVERLAY_COLOR_IMAGE_NOT_OK;
    }

    private void addDebugTextWithColor(Canvas r110, String r111, String r112, int r113) {
        String r114 = r111 + ": ";
        float r100 = this.mPaint.measureText(r114);
        float r101 = this.mPaint.measureText(r112);
        this.mPaint.setColor(268435456);
        int r102 = this.mCurrentTextXPx;
        int r103 = this.mCurrentTextYPx;
        r110.drawRect(r102 - 4, r103 + 8, ((r102 + r100) + r101) + 4.0f, (r103 + this.mLineIncrementPx) + 8, this.mPaint);
        this.mPaint.setColor(-1);
        r110.drawText(r114, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        this.mPaint.setColor(r113);
        r110.drawText(r112, this.mCurrentTextXPx + r100, this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    public static void showOverlayInfo(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r109, boolean r110) {
        isShowOrigin = r100;
        isShowTimeCost = r101;
        isShowScale = r102;
        isShowImageSize = r103;
        isShowFormat = r104;
        isShowImageWH = r105;
        isShowViewWH = r106;
        isShowID = r107;
        isShowIDS = r108;
        isShowAnim = r109;
        isShowBigImage = r110;
    }
}
