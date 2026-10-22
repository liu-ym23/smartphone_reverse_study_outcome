package com.ss.texturerender.effect;

import com.ss.texturerender.SharpenBaseWrapper;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class AdaptiveSharpenWrapper extends SharpenBaseWrapper {
    private static final String VIDEO_SHARPEN_CLASS_NAME = "com.ss.lens.algorithm.AdaptiveSharpen";
    private Method mGetOutputMethod;
    private Method mInitMethod;
    private Method mProcessMethod;
    private Method mProcessOESMethod;
    private Method mReleaseMethod;
    private Object mSharpenObject;
    private int mTexType;

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int GetAdaptiveSharpenOutput() {
        Object r100 = this.mSharpenObject;
        if (r100 == null) goto L12;
        Method r101 = this.mGetOutputMethod;
        if (r101 == null) goto L13;
        Object r102 = _invokeMethod(r101, r100, new Object[0]);
        if (r102 != null) goto L11;
        return -1;
    L11:
        return ((Integer) r102).intValue();
    L13:
        return -1;
    L12:
        return -1;
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public void ReleaseAdaptiveSharpen() {
        Object r100 = this.mSharpenObject;
        if (r100 == null) goto L7;
        Method r101 = this.mReleaseMethod;
        if (r101 == null) goto L7;
        _invokeMethod(r101, r100, new Object[0]);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "ReleaseAdaptiveSharpen");
    L7:
        this.mSharpenObject = null;
    }

    public AdaptiveSharpenWrapper(int r110) {
        this.mSharpenObject = null;
        this.mInitMethod = null;
        this.mProcessMethod = null;
        this.mProcessOESMethod = null;
        this.mGetOutputMethod = null;
        this.mReleaseMethod = null;
        this.mTexType = r110;
        TextureRenderLog.i(r110, this.LOG_TAG, "new AdaptiveSharpenWrapper");
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_SHARPEN_CLASS_NAME);     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        Class<?> r101 = Boolean.TYPE;     // Catch: Exception -> L7
        Class<?> r102 = Integer.TYPE;     // Catch: Exception -> L7
        this.mInitMethod = r100.getDeclaredMethod("InitAdaptiveSharpen", new Class[]{r101, r102, r102, r102});     // Catch: Exception -> L7
        Class<?> r111 = Float.TYPE;     // Catch: Exception -> L7
        this.mProcessMethod = r100.getDeclaredMethod("AdaptiveSharpenProcess", new Class[]{r102, r102, r102, r101, r102, r111, r111, r111, r102});     // Catch: Exception -> L7
        this.mProcessOESMethod = r100.getDeclaredMethod("AdaptiveSharpenOesProcess", new Class[]{r102, r102, r102, float[].class, r101, r102, r111, r111, r111, r102});     // Catch: Exception -> L7
        this.mGetOutputMethod = r100.getDeclaredMethod("GetAdaptiveSharpenOutput", new Class[0]);     // Catch: Exception -> L7
        this.mReleaseMethod = r100.getDeclaredMethod("ReleaseAdaptiveSharpen", new Class[0]);     // Catch: Exception -> L7
        this.mSharpenObject = r100.newInstance();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "AdaptiveSharpen get fail:" + e.toString());
        this.mSharpenObject = null;
        this.mInitMethod = null;
        this.mProcessMethod = null;
        this.mGetOutputMethod = null;
        this.mReleaseMethod = null;
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

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public boolean InitAdaptiveSharpen(boolean r100, int r101, int r102, int r103) {
        Object r104 = this.mSharpenObject;
        if (r104 == null) goto L12;
        Method r105 = this.mInitMethod;
        if (r105 == null) goto L13;
        Object r106 = _invokeMethod(r105, r104, new Object[]{Boolean.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)});
        if (r106 != null) goto L11;
        return false;
    L11:
        return ((Boolean) r106).booleanValue();
    L13:
        return false;
    L12:
        return false;
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenProcess(int r100, int r101, int r102, boolean r103, int r110, float r111, float r112, float r113, int r114) {
        Object r104 = this.mSharpenObject;
        if (r104 == null) goto L12;
        Method r105 = this.mProcessMethod;
        if (r105 == null) goto L13;
        Object r106 = _invokeMethod(r105, r104, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Boolean.valueOf(r103), Integer.valueOf(r110), Float.valueOf(r111), Float.valueOf(r112), Float.valueOf(r113), Integer.valueOf(r114)});
        if (r106 != null) goto L11;
        return -1;
    L11:
        return ((Integer) r106).intValue();
    L13:
        return -1;
    L12:
        return -1;
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, boolean r110, int r111, float r112, float r113, float r114, int r115) {
        Object r104 = this.mSharpenObject;
        if (r104 == null) goto L12;
        Method r105 = this.mProcessOESMethod;
        if (r105 == null) goto L13;
        Object r106 = _invokeMethod(r105, r104, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), r103, Boolean.valueOf(r110), Integer.valueOf(r111), Float.valueOf(r112), Float.valueOf(r113), Float.valueOf(r114), Integer.valueOf(r115)});
        if (r106 != null) goto L11;
        return -1;
    L11:
        return ((Integer) r106).intValue();
    L13:
        return -1;
    L12:
        return -1;
    }
}
