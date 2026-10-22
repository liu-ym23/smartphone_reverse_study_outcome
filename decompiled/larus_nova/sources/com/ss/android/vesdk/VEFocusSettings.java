package com.ss.android.vesdk;

import com.ss.android.ttvecamera.TEFocusSettings;

/* JADX INFO: loaded from: classes40.dex */
public class VEFocusSettings {
    private com.ss.android.vesdk.camera.a mCameraFaceFocusPoint;
    private com.ss.android.vesdk.camera.b mCameraFocusArea;
    private com.ss.android.vesdk.camera.c mCameraMeteringArea;
    private TEFocusSettings.CoordinatesMode mCoordinatesMode;
    private float mDisplayDensity;
    private IVEFocusCallback mFocusCallback;
    private boolean mFromUser;
    private int mHeight;
    private boolean mIsLock;
    private boolean mNeedFocus;
    private boolean mNeedMetering;
    private int mWidth;
    private int mX;
    private int mY;

    public interface IVEFocusCallback {
        void onFocus(int r100, int r101, String r102);
    }

    public com.ss.android.vesdk.camera.a getCameraFaceFocusPoint() {
        return null;
    }

    public com.ss.android.vesdk.camera.b getCameraFocusArea() {
        return null;
    }

    public com.ss.android.vesdk.camera.c getCameraMeteringArea() {
        return null;
    }

    public String toString() {
        return "[" + this.mX + ", " + this.mY + "]";
    }

    public TEFocusSettings.CoordinatesMode getCoordinatesMode() {
        return this.mCoordinatesMode;
    }

    public float getDisplayDensity() {
        return this.mDisplayDensity;
    }

    public IVEFocusCallback getFocusCallback() {
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

    public void setCoordinatesMode(TEFocusSettings.CoordinatesMode r100) {
        this.mCoordinatesMode = r100;
    }

    public void setDisplayDensity(float r100) {
        this.mDisplayDensity = r100;
    }

    public void setFromUser(boolean r100) {
        this.mFromUser = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
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

    public void setWidth(int r100) {
        this.mWidth = r100;
    }

    public void setX(int r100) {
        this.mX = r100;
    }

    public void setY(int r100) {
        this.mY = r100;
    }

    public static /* synthetic */ boolean access$002(VEFocusSettings r100, boolean r101) {
        r100.mNeedFocus = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(VEFocusSettings r100, boolean r101) {
        r100.mNeedMetering = r101;
        return r101;
    }

    public static /* synthetic */ com.ss.android.vesdk.camera.b access$202(VEFocusSettings r100, com.ss.android.vesdk.camera.b r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ com.ss.android.vesdk.camera.c access$302(VEFocusSettings r100, com.ss.android.vesdk.camera.c r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ com.ss.android.vesdk.camera.a access$402(VEFocusSettings r100, com.ss.android.vesdk.camera.a r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ IVEFocusCallback access$502(VEFocusSettings r100, IVEFocusCallback r101) {
        r100.mFocusCallback = r101;
        return r101;
    }

    public static /* synthetic */ TEFocusSettings.CoordinatesMode access$602(VEFocusSettings r100, TEFocusSettings.CoordinatesMode r101) {
        r100.mCoordinatesMode = r101;
        return r101;
    }

    public VEFocusSettings(int r100, int r101, int r102, int r103, float r104) {
        this.mNeedFocus = true;
        this.mNeedMetering = true;
        this.mIsLock = false;
        this.mFromUser = true;
        this.mCoordinatesMode = TEFocusSettings.CoordinatesMode.VIEW;
        this.mWidth = r102;
        this.mHeight = r103;
        this.mX = r100;
        this.mY = r101;
        this.mDisplayDensity = r104;
    }

    public VEFocusSettings(int r100, int r101, int r102, int r103, float r104, IVEFocusCallback r105) {
        this.mNeedFocus = true;
        this.mNeedMetering = true;
        this.mIsLock = false;
        this.mFromUser = true;
        this.mCoordinatesMode = TEFocusSettings.CoordinatesMode.VIEW;
        this.mWidth = r102;
        this.mHeight = r103;
        this.mX = r100;
        this.mY = r101;
        this.mDisplayDensity = r104;
        this.mFocusCallback = r105;
    }
}
