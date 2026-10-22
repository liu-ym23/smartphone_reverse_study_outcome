package com.ss.android.ttvecamera;

import android.graphics.Rect;
import android.hardware.Camera;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes38.dex */
public class TEFocusSettings {
    private ITECameraArea.ITECameraFocusArea mCameraFocusArea;
    private ITECameraArea.ITECameraMeteringArea mCameraMeteringArea;
    private CoordinatesMode mCoordinatesMode;
    private final float mDisplayDensity;
    private ITEFocusCallback mFocusCallback;
    private boolean mFromUser;
    private final int mHeight;
    private boolean mIsLock;
    private boolean mNeedFocus;
    private boolean mNeedMetering;
    private long mStartTimeMS;
    private final int mWidth;
    private final int mX;
    private final int mY;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.TEFocusSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum CoordinatesMode extends Enum<CoordinatesMode> {
        private static final /* synthetic */ CoordinatesMode[] $VALUES = null;
        public static final CoordinatesMode ORIGINAL_FRAME = null;
        public static final CoordinatesMode VIEW = null;

        private static /* synthetic */ CoordinatesMode[] $values() {
            return new CoordinatesMode[]{VIEW, ORIGINAL_FRAME};
        }

        static {
            VIEW = new CoordinatesMode("VIEW", 0);
            ORIGINAL_FRAME = new CoordinatesMode("ORIGINAL_FRAME", 1);
            $VALUES = $values();
        }

        public static CoordinatesMode[] values() {
            return (CoordinatesMode[]) $VALUES.clone();
        }

        public static CoordinatesMode valueOf(String r100) {
            return (CoordinatesMode) r27.a.a(CoordinatesMode.class, r100);
        }

        private CoordinatesMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface ITEFocusCallback {
        void onFocus(int r100, int r101, String r102);
    }

    public static class TEFocusNullCallback implements ITEFocusCallback {
        private TEFocusNullCallback() {
        }

        public /* synthetic */ TEFocusNullCallback(AnonymousClass1 r100) {
            this();
        }

        @Override // com.ss.android.ttvecamera.TEFocusSettings.ITEFocusCallback
        public void onFocus(int r100, int r101, String r102) {
            if (r100 <= 0) goto L5;
            TELogUtils.d("TEFocusNullCallback", "Focus done, cost: " + r100 + "ms");
        L6:
            TELogUtils.printStackTrace();
            return;
        L5:
            TELogUtils.i("TEFocusNullCallback", "Focus failed, error code: " + r100 + ", msg: " + r102);
            goto L6
        }
    }

    public String toString() {
        return "TEFocusSettings{width =" + this.mWidth + ", height =" + this.mHeight + ", x =" + this.mX + ", y =" + this.mY + ", need focus =" + this.mNeedFocus + ", need meter =" + this.mNeedMetering + ", lock =" + this.mIsLock + ", from user=" + this.mFromUser + ", CoordinatesMode" + this.mCoordinatesMode + '}';
    }

    public int getFocusConsumingMS() {
        return (int) (System.currentTimeMillis() - this.mStartTimeMS);
    }

    public void markStartTimeMS() {
        this.mStartTimeMS = System.currentTimeMillis();
    }

    public ITECameraArea.ITECameraFocusArea getCameraFocusArea() {
        return this.mCameraFocusArea;
    }

    public ITECameraArea.ITECameraMeteringArea getCameraMeteringArea() {
        return this.mCameraMeteringArea;
    }

    public CoordinatesMode getCoordinatesMode() {
        return this.mCoordinatesMode;
    }

    public float getDisplayDensity() {
        return this.mDisplayDensity;
    }

    public ITEFocusCallback getFocusCallback() {
        return this.mFocusCallback;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public boolean isFromUser() {
        return this.mFromUser;
    }

    public boolean isLock() {
        return this.mIsLock;
    }

    public boolean isNeedFocus() {
        return this.mNeedFocus;
    }

    public boolean isNeedMetering() {
        return this.mNeedMetering;
    }

    public void setCameraFocusArea(ITECameraArea.ITECameraFocusArea r100) {
        this.mCameraFocusArea = r100;
    }

    public void setCameraMeteringArea(ITECameraArea.ITECameraMeteringArea r100) {
        this.mCameraMeteringArea = r100;
    }

    public void setCoordinatesMode(CoordinatesMode r100) {
        this.mCoordinatesMode = r100;
    }

    public void setFocusCallback(ITEFocusCallback r100) {
        if (r100 == null) goto L4;
        this.mFocusCallback = r100;
        return;
    L4:
        this.mFocusCallback = new TEFocusNullCallback(null);
    }

    public void setFromUser(boolean r100) {
        this.mFromUser = r100;
    }

    public void setLock(boolean r100) {
        this.mIsLock = r100;
    }

    public void setNeedFocus(boolean r100) {
        this.mNeedFocus = r100;
    }

    public void setNeedMetering(boolean r100) {
        this.mNeedMetering = r100;
    }

    public Rect calculateFocusArea(int r100, boolean r101) {
        ITECameraArea.ITECameraFocusArea r102 = this.mCameraFocusArea;
        if (r102 != null) goto L5;
        return null;
    L5:
        return ((Camera.Area) ListProtector.get(r102.calculateArea(this.mWidth, this.mHeight, this.mX, this.mY, r100, r101), 0)).rect;
    }

    public Rect calculateMeteringArea(int r100, boolean r101) {
        ITECameraArea.ITECameraMeteringArea r102 = this.mCameraMeteringArea;
        if (r102 != null) goto L5;
        return null;
    L5:
        return ((Camera.Area) ListProtector.get(r102.calculateArea(this.mWidth, this.mHeight, this.mX, this.mY, r100, r101), 0)).rect;
    }

    public TEFocusSettings(int r100, int r101, int r102, int r103, float r104) {
        this.mNeedFocus = true;
        this.mNeedMetering = true;
        this.mIsLock = false;
        this.mFromUser = true;
        this.mCoordinatesMode = CoordinatesMode.VIEW;
        this.mCameraFocusArea = null;
        this.mCameraMeteringArea = null;
        this.mFocusCallback = new TEFocusNullCallback(null);
        this.mWidth = r100;
        this.mHeight = r101;
        this.mX = r102;
        this.mY = r103;
        this.mDisplayDensity = r104;
    }

    public TEFocusSettings(int r100, int r101, int r102, int r103, float r104, ITEFocusCallback r105) {
        this.mNeedFocus = true;
        this.mNeedMetering = true;
        this.mIsLock = false;
        this.mFromUser = true;
        this.mCoordinatesMode = CoordinatesMode.VIEW;
        this.mCameraFocusArea = null;
        this.mCameraMeteringArea = null;
        this.mFocusCallback = new TEFocusNullCallback(null);
        this.mWidth = r100;
        this.mHeight = r101;
        this.mX = r102;
        this.mY = r103;
        this.mDisplayDensity = r104;
        if (r105 == null) goto L6;
        this.mFocusCallback = r105;
        return;
    }
}
