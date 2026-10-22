package com.ss.texturerender.effect;

import com.ss.texturerender.SharpenBaseWrapper;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import kc4.b;

/* JADX INFO: loaded from: classes40.dex */
public class BMFAdaptiveSharpenDirectInvokeWrapper extends SharpenBaseWrapper {
    private static final String VIDEO_SHARPEN_CLASS_NAME = "com.bytedance.bmf_mods_lite.Sharpen";
    private int bmflogCount;
    private b mSharpenObject;
    private int mTexType;

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int GetAdaptiveSharpenOutput() {
        b r100 = this.mSharpenObject;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.GetResult();
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public void ReleaseAdaptiveSharpen() {
        b r100 = this.mSharpenObject;
        if (r100 == null) goto L5;
        r100.Free();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "ReleaseAdaptiveSharpen");
    L5:
        this.mSharpenObject = null;
    }

    public BMFAdaptiveSharpenDirectInvokeWrapper(int r100) {
        this.mSharpenObject = null;
        this.bmflogCount = 0;
        this.mTexType = r100;
        TextureRenderLog.i(r100, this.LOG_TAG, "new BMFAdaptiveSharpenWrapper");
        Class<?> r101 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_SHARPEN_CLASS_NAME);     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        this.mSharpenObject = (b) r101.newInstance();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "AdaptiveSharpen get fail:" + e.toString());
        this.mSharpenObject = null;
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenProcess(int r100, int r101, int r102) {
        b r103 = this.mSharpenObject;
        if (r103 != null) goto L6;
        return -1;
    L6:
        int r104 = r103.c();
        int r105 = this.bmflogCount;
        if (r105 < 100) goto L10;
        if (r104 != 0) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sharpen sucess");
        this.bmflogCount = 0;
    L11:
        return r104;
    L10:
        this.bmflogCount = r105 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenDirectDraw(int r100, int r101, int r102, int[] r103) {
        b r104 = this.mSharpenObject;
        if (r104 != null) goto L6;
        return -1;
    L6:
        int r105 = r104.f();
        int r106 = this.bmflogCount;
        if (r106 < 100) goto L10;
        if (r105 != 0) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "Sharpen DirectDraw successful");
        this.bmflogCount = 0;
    L11:
        return r105;
    L10:
        this.bmflogCount = r106 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106) {
        b r107 = this.mSharpenObject;
        if (r107 != null) goto L6;
        return -1;
    L6:
        int r108 = r107.d();
        int r109 = this.bmflogCount;
        if (r109 < 100) goto L10;
        if (r108 != 0) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sharpen oes sucess");
        this.bmflogCount = 0;
    L11:
        return r108;
    L10:
        this.bmflogCount = r109 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesDirectDraw(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, int[] r107) {
        b r108 = this.mSharpenObject;
        if (r108 != null) goto L6;
        return -1;
    L6:
        int r109 = r108.e();
        int r110 = this.bmflogCount;
        if (r110 < 100) goto L10;
        if (r109 != 0) goto L10;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "Sharpen Oes DirectDraw successful");
        this.bmflogCount = 0;
    L11:
        return r109;
    L10:
        this.bmflogCount = r110 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenProcess(int r100, int r101, int r102, float r103, float r104, float r105, boolean r106, float r107, float r108) {
        b r109 = this.mSharpenObject;
        if (r109 != null) goto L6;
        return -1;
    L6:
        int r110 = r109.k();
        int r111 = this.bmflogCount;
        if (r111 < 100) goto L10;
        if (r110 != 0) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sharpen dy adjust param sucess");
        this.bmflogCount = 0;
    L11:
        return r110;
    L10:
        this.bmflogCount = r111 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenDirectDraw(int r100, int r101, int r102, float r103, float r104, float r105, boolean r106, float r107, float r108, int[] r110) {
        b r109 = this.mSharpenObject;
        if (r109 != null) goto L6;
        return -1;
    L6:
        int r111 = r109.j();
        int r112 = this.bmflogCount;
        if (r112 < 100) goto L10;
        if (r111 != 0) goto L10;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "Sharpen DirectDraw successful");
        this.bmflogCount = 0;
    L11:
        return r111;
    L10:
        this.bmflogCount = r112 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int InitAdaptiveSharpen(int r100, int r101, int r102, int r103, String r104, float r105, float r106, float r107, boolean r108, float r110, float r111) {
        b r109 = this.mSharpenObject;
        if (r109 == null) goto L5;
        Integer r112 = Integer.valueOf(r109.a());
    L6:
        if (r112 != null) goto L8;
    L10:
        if (r112 != null) goto L13;
        return -1;
    L13:
        return r112.intValue();
    L8:
        if (r112.intValue() != 0) goto L10;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "bmfSharpTexture init success");
        goto L10
    L5:
        r112 = null;
        goto L6
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, float r107, float r108, float r110, boolean r111, float r112, float r113) {
        b r109 = this.mSharpenObject;
        if (r109 != null) goto L6;
        return -1;
    L6:
        int r114 = r109.i();
        int r115 = this.bmflogCount;
        if (r115 < 100) goto L10;
        if (r114 != 0) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sharpen  dy adjust param oes sucess");
        this.bmflogCount = 0;
    L11:
        return r114;
    L10:
        this.bmflogCount = r115 + 1;
        goto L11
    }

    @Override // com.ss.texturerender.SharpenBaseWrapper
    public int AdaptiveSharpenOesDirectDraw(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, float r107, float r108, float r110, boolean r111, float r112, float r113, int[] r114) {
        b r109 = this.mSharpenObject;
        if (r109 != null) goto L6;
        return -1;
    L6:
        int r115 = r109.h();
        int r116 = this.bmflogCount;
        if (r116 < 100) goto L10;
        if (r115 != 0) goto L10;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "Sharpen Oes DirectDraw successful");
        this.bmflogCount = 0;
    L11:
        return r115;
    L10:
        this.bmflogCount = r116 + 1;
        goto L11
    }
}
