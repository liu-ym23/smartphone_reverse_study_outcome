package com.ss.texturerender.effect;

import com.ss.texturerender.SharpenBaseWrapper;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class BMFAdaptiveSharpenWrapper extends SharpenBaseWrapper {
    private static final String VIDEO_SHARPEN_CLASS_NAME = "com.bytedance.bmf_mods.Sharp";
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

    public BMFAdaptiveSharpenWrapper(int r110) {
        this.mSharpenObject = null;
        this.mInitMethod = null;
        this.mProcessMethod = null;
        this.mProcessOESMethod = null;
        this.mGetOutputMethod = null;
        this.mReleaseMethod = null;
        this.mTexType = r110;
        TextureRenderLog.i(r110, this.LOG_TAG, "new BMFAdaptiveSharpenWrapper");
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_SHARPEN_CLASS_NAME);     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L7
        Class<?> r111 = Float.TYPE;     // Catch: Exception -> L7
        this.mInitMethod = r100.getDeclaredMethod("Init", new Class[]{r101, r101, r101, r101, String.class, r111, r111, r111, Boolean.TYPE, r111, r111});     // Catch: Exception -> L7
        this.mProcessMethod = r100.getDeclaredMethod("ProcessTexture", new Class[]{r101, r101, r101});     // Catch: Exception -> L7
        this.mProcessOESMethod = r100.getDeclaredMethod("ProcessOesTexture", new Class[]{r101, r101, r101, float[].class, float[].class, float[].class});     // Catch: Exception -> L7
        this.mGetOutputMethod = r100.getDeclaredMethod("GetResult", new Class[0]);     // Catch: Exception -> L7
        this.mReleaseMethod = r100.getDeclaredMethod("Free", new Class[0]);     // Catch: Exception -> L7
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
    public int AdaptiveSharpenProcess(int r100, int r101, int r102) {
        Object r103 = this.mSharpenObject;
        if (r103 == null) goto L12;
        Method r104 = this.mProcessMethod;
        if (r104 == null) goto L13;
        Object r105 = _invokeMethod(r104, r103, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102)});
        if (r105 != null) goto L11;
        return -1;
    L11:
        return ((Integer) r105).intValue();
    L13:
        return -1;
    L12:
        return -1;
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r110, boolean r111) {
        Object r112 = this.mSharpenObject;
        if (r112 == null) goto L12;
        Method r105 = this.mProcessOESMethod;
        if (r105 == null) goto L13;
        Object r106 = _invokeMethod(r105, r112, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), r103, r104, r110});
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
    public int InitAdaptiveSharpen(int r100, int r101, int r102, int r103, String r104, float r110, float r111, float r112, boolean r113, float r114, float r115) {
        Object r105 = _invokeMethod(this.mInitMethod, this.mSharpenObject, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103), r104, Float.valueOf(r110), Float.valueOf(r111), Float.valueOf(r112), Boolean.valueOf(r113), Float.valueOf(r114), Float.valueOf(r115)});
        if (r105 != null) goto L6;
        return -1;
    L6:
        return ((Integer) r105).intValue();
    }
}
