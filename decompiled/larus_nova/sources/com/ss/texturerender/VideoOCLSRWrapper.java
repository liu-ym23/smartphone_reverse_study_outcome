package com.ss.texturerender;

import android.os.Bundle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class VideoOCLSRWrapper extends VideoOCLSRBaseWrapper {
    private static final int HEIGHT_DEFAULT = 720;
    private static final String VIDEO_OCLSR_CLASS_NAME = "com.ss.lens.algorithm.VideoOCLSR";
    private static final int WIDTH_DEFAULT = 1440;
    private Method mGetOutputMethod;
    private Method mInitMethod;
    private Method mInitMethodMax;
    private Method mInitMethodMaxMalisync;
    private Method mInitWithLicenseMethod;
    private Method mProcessMethod;
    private Method mProcessOesMethod;
    private Method mReleaseMethod;
    private Object mSRObject;
    private int mTexType;

    private void _initObjAndMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_CLASS_NAME);     // Catch: Exception -> L9
        if (r100 == null) goto L13;
        Class<?> r110 = Integer.TYPE;     // Catch: Exception -> L7
        Class<?> r111 = Boolean.TYPE;     // Catch: Exception -> L7
        this.mInitMethod = r100.getDeclaredMethod("InitVideoOclSr", new Class[]{String.class, r110, r111});     // Catch: Exception -> L7
        this.mInitMethodMax = r100.getDeclaredMethod("InitVideoOclSr", new Class[]{String.class, r110, r111, r110, r110});     // Catch: Exception -> L7
        this.mProcessOesMethod = r100.getDeclaredMethod("VideoOclSrOesProcess", new Class[]{r110, r110, r110, float[].class, r111});     // Catch: Exception -> L7
        this.mProcessMethod = r100.getDeclaredMethod("VideoOclSrProcess", new Class[]{r110, r110, r110, r111});     // Catch: Exception -> L7
        this.mGetOutputMethod = r100.getDeclaredMethod("GetVideoOclSrOutput", new Class[0]);     // Catch: Exception -> L7
        this.mReleaseMethod = r100.getDeclaredMethod("ReleaseVideoOclSr", new Class[0]);     // Catch: Exception -> L7
        this.mSRObject = r100.newInstance();     // Catch: Exception -> L7
    L7:
        e = e;
    L11:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "VideoOCLSR get fail:" + e.toString());
        this.mSRObject = null;
        this.mInitMethod = null;
        this.mInitMethodMax = null;
        this.mProcessOesMethod = null;
        this.mProcessMethod = null;
        this.mGetOutputMethod = null;
        this.mReleaseMethod = null;
    L13:
        if (r100 != null) goto L30;
    L18:
        if (r100 == null) goto L32;
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L21
        Class<?> r102 = Boolean.TYPE;     // Catch: Exception -> L21
        this.mInitWithLicenseMethod = r100.getDeclaredMethod("InitVideoOclSrWithLicense", new Class[]{String.class, r101, r102, r102, String.class, r101, r101});     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getmethod error:" + e.toString() + ", maybe no license");
        return;
    L32:
        return;
    L30:
        Class<?> r112 = Integer.TYPE;     // Catch: Exception -> L16
        Class<?> r113 = Boolean.TYPE;     // Catch: Exception -> L16
        this.mInitMethodMaxMalisync = r100.getDeclaredMethod("InitVideoOclSr", new Class[]{String.class, r112, r113, r113, r112, r112});     // Catch: Exception -> L16
    L16:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getmethod error:" + e.toString() + ",old lens version maybe");
    L9:
        e = e;
        r100 = null;
        goto L11
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int GetVideoOclSrOutput() {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        Object r100 = _invokeMethod(this.mGetOutputMethod, this.mSRObject, new Object[0]);
        if (r100 != null) goto L11;
        return -1;
    L11:
        return ((Integer) r100).intValue();
    L5:
        if (this.mGetOutputMethod != null) goto L7;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public void ReleaseVideoOclSr() {
        Object r100 = this.mSRObject;
        if (r100 == null) goto L7;
        Method r101 = this.mReleaseMethod;
        if (r101 == null) goto L7;
        _invokeMethod(r101, r100, new Object[0]);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "ReleaseVideoOclSr");
    L7:
        this.mSRObject = null;
    }

    public VideoOCLSRWrapper(int r100) {
        this.mSRObject = null;
        this.mInitMethod = null;
        this.mInitMethodMax = null;
        this.mInitMethodMaxMalisync = null;
        this.mInitWithLicenseMethod = null;
        this.mProcessOesMethod = null;
        this.mProcessMethod = null;
        this.mGetOutputMethod = null;
        this.mReleaseMethod = null;
        this.mTexType = r100;
        TextureRenderLog.i(r100, this.LOG_TAG, "new VideoOCLSRWrapper");
        _initObjAndMethod();
    }

    private Object _invokeMethod(Method r100, Object r101, Object... r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        return r100.invoke(r101, r102);
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, e.toString());
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r100, int r101, boolean r102, int r103, int r104) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        Object r105 = _invokeMethod(this.mInitMethodMax, this.mSRObject, new Object[]{r100, Integer.valueOf(r101), Boolean.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r104)});
        if (r105 != null) goto L10;
        return false;
    L10:
        if (((Boolean) r105).booleanValue() == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (this.mInitMethodMax != null) goto L7;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean glSrInit(String r100, int r101, boolean r102, int r110, int r111) {
        return InitVideoOclSr(r100, r101, r102, r111, r110);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r100, int r101, boolean r102, String r103, int r104, int r105, int r110, String r111, String r112) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        Object r106 = this.mSRObject;
        if (r106 != null) goto L10;
    L15:
        Object r107 = null;
    L16:
        if (r107 != null) goto L18;
    L20:
        return false;
    L18:
        if (((Boolean) r107).booleanValue() == false) goto L20;
        return true;
    L10:
        if (this.mInitWithLicenseMethod == null) goto L12;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitWithLicenseMethod " + r103);
        r107 = _invokeMethod(this.mInitWithLicenseMethod, this.mSRObject, new Object[]{r100, Integer.valueOf(r101), Boolean.valueOf(r102), Boolean.TRUE, r103, 720, 1440});
        goto L16
    L12:
        Method r108 = this.mInitMethod;
        if (r108 == null) goto L15;
        r107 = _invokeMethod(r108, r106, new Object[]{r100, Integer.valueOf(r101), Boolean.valueOf(r102)});
        goto L16
    L5:
        if (this.mInitWithLicenseMethod != null) goto L7;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoAsyncOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r105, String r106, int r107, int r108, int r110, String r111, String r112, Bundle r113) {
        return InitVideoOclSr(r100, r101, r102, r104, r105);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r110, int r111, boolean r112, boolean r113, int r114, int r115, String r210, int r211, int r212, int r213, String r214, String r215, Bundle r216) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        Object r100 = this.mSRObject;
        if (r100 != null) goto L10;
    L21:
        Object r101 = null;
    L22:
        if (r101 != null) goto L24;
    L26:
        return false;
    L24:
        if (((Boolean) r101).booleanValue() == false) goto L26;
        return true;
    L10:
        if (this.mInitWithLicenseMethod == null) goto L12;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitWithLicenseMethod " + r210);
        r101 = _invokeMethod(this.mInitWithLicenseMethod, this.mSRObject, new Object[]{r110, Integer.valueOf(r111), Boolean.valueOf(r112), Boolean.valueOf(r113), r210, Integer.valueOf(r114), Integer.valueOf(r115)});
        goto L22
    L12:
        Method r102 = this.mInitMethodMaxMalisync;
        if (r102 == null) goto L16;
        r101 = _invokeMethod(r102, r100, new Object[]{r110, Integer.valueOf(r111), Boolean.valueOf(r112), Boolean.valueOf(r113), Integer.valueOf(r114), Integer.valueOf(r115)});
        goto L22
    L16:
        if (this.mInitMethodMax == null) goto L19;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitMethodMaxMalisync null, use mInitMethodMax");
        r101 = _invokeMethod(this.mInitMethodMax, this.mSRObject, new Object[]{r110, Integer.valueOf(r111), Boolean.valueOf(r112), Integer.valueOf(r114), Integer.valueOf(r115)});
        goto L22
    L19:
        if (this.mInitMethod == null) goto L21;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitMethodMaxMalisync/mInitMethodMax null,use mInitMethod");
        r101 = _invokeMethod(this.mInitMethod, this.mSRObject, new Object[]{r110, Integer.valueOf(r111), Boolean.valueOf(r112)});
        goto L22
    L5:
        if (this.mInitWithLicenseMethod != null) goto L7;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int r100, int r101, int r102, boolean r103, int r104, int r105, int r106, int r107, int r108, long r110, int r111, int r112, Bundle r113) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        Object r109 = _invokeMethod(this.mProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Boolean.valueOf(r103)});
        if (r109 == null) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "lensTextureProcess sucess");
    L10:
        if (r109 != null) goto L13;
        return -1;
    L13:
        return ((Integer) r109).intValue();
    L5:
        if (this.mProcessMethod != null) goto L7;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r100, int r101, int r102, float[] r103, boolean r104, int r105, int r106, int r107, int r108, int r110, long r111, int r112, int r113, Bundle r114) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        Object r109 = _invokeMethod(this.mProcessOesMethod, this.mSRObject, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), r103, Boolean.valueOf(r104)});
        if (r109 == null) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "lensTextureProcess sucess");
    L10:
        if (r109 != null) goto L13;
        return -1;
    L13:
        return ((Integer) r109).intValue();
    L5:
        if (this.mProcessOesMethod != null) goto L7;
        goto L6
    }
}
