package com.bytedance.fresco.sharp;

import android.graphics.Bitmap;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class SharpPostProcessor extends BasePostprocessor {
    public static String TAG = "SharpPostProcessor";
    private String failureReason;
    private boolean mAdaptive;
    private int mAlgorithm;
    private CacheKey mCacheKey;
    private float mG0;
    private float mLcWtThr;
    private float mOvrt;
    private ISharpResolution mSharpResolution;
    private int mSharpTemplate;
    private float mThr;
    private float mWt;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "SharpPostProcessor";
    }

    public void destroy() {
        this.mSharpResolution.destroy(this.mAlgorithm);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey != null) goto L6;
        this.mCacheKey = new SimpleCacheKey(String.format(null, "s%d%d", new Object[]{Integer.valueOf(this.mAlgorithm), Integer.valueOf(this.mSharpTemplate)}));
    L6:
        return this.mCacheKey;
    }

    public SharpPostProcessor(int r100) {
        this.failureReason = "";
        this.mSharpTemplate = r100;
        if (r100 >= 5) goto L5;
        int r101 = 3;
    L6:
        this.mAlgorithm = r101;
        createSharpTempParams(r100);
        this.mSharpResolution = new BMFSharp(this.mAlgorithm);
        return;
    L5:
        r101 = 4;
        goto L6
    }

    private boolean isArgb8888Type(Bitmap r100) {
        if (r100.getConfig() != Bitmap.Config.ARGB_8888) goto L5;
        return true;
    L5:
        return false;
    }

    public void createSharpTempParams(int r100) {
        this.mThr = 3.0f;
        this.mAdaptive = true;
        this.mG0 = 1200.0f;
        this.mLcWtThr = 1.0f;
        switch(r100) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            case 8: goto L9;
            default: goto L4;
        };
    L4:
        FLog.d(TAG, "Illegal parameter type, use default value");
        this.mWt = 4.0f;
        this.mOvrt = 0.3f;
        return;
    L5:
        this.mWt = 3.0f;
        this.mOvrt = 0.1f;
        return;
    L6:
        this.mWt = 4.0f;
        this.mOvrt = 0.2f;
        return;
    L7:
        this.mWt = 5.0f;
        this.mOvrt = 0.3f;
        return;
    L8:
        this.mWt = 1.0f;
        this.mOvrt = 0.1f;
        return;
    L9:
        this.mWt = 2.0f;
        this.mOvrt = 0.1f;
        return;
    L10:
        this.mWt = 3.0f;
        this.mOvrt = 0.2f;
        return;
    L11:
        this.mWt = 4.0f;
        this.mOvrt = 0.3f;
    }

    public void updateSharpTemplate(int r100) {
        this.mSharpTemplate = r100;
        if (r100 >= 5) goto L5;
        int r101 = 3;
    L6:
        this.mAlgorithm = r101;
        createSharpTempParams(r100);
        return;
    L5:
        r101 = 4;
        goto L6
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public CloseableReference<Bitmap> process(Bitmap r210, PlatformBitmapFactory r211, Map<String, String> r212) {
        long r100 = System.currentTimeMillis();
        int r101 = this.mSharpTemplate;
        if (r101 != 10) goto L10;
        if (this.mAlgorithm != 3) goto L7;
        String r102 = "0";
    L8:
        r212.put("sharp_type", r102);
    L15:
        if (isArgb8888Type(r210) == true) goto L18;
        this.failureReason = "The Bitmap config is not ARGB_8888";
    L33:
        CloseableReference<Bitmap> r103 = null;
    L34:
        r212.put("sharp_wt", this.mWt + "");
        r212.put("sharp_thr", this.mThr + "");
        r212.put("sharp_ovrt", this.mOvrt + "");
        r212.put("sharp_adaptive", this.mAdaptive + "");
        r212.put("sharp_g0", this.mG0 + "");
        r212.put("sharp_lc_wt_thr", this.mLcWtThr + "");
        if (r103 != null) goto L40;
        CloseableReference<Bitmap> r104 = r211.createBitmap(r210);
        r212.put("sharp_status", "1");
        r212.put("sharp_error", this.failureReason);
        return r104;
    L40:
        return r103;
    L18:
        if (BMFSharp.isOnlyUserInit() == false) goto L20;
        String r105 = BMFSharp.isInited(this.mAlgorithm);
    L22:
        if ("success".equals(r105) == true) goto L38;
        this.failureReason = "failed reason is:" + r105;
        goto L33
    L38:
        r103 = this.mSharpResolution.process(r210, r211, this.mAlgorithm, this.mWt, this.mThr, this.mOvrt, this.mAdaptive, this.mG0, this.mLcWtThr);     // Catch: Exception -> L25 BmfException -> L27
    L30:
        if (r103 == null) goto L34;
        r212.put("sharp_status", "0");
        r212.put("sharp_duration", (System.currentTimeMillis() - r100) + "");
        goto L34
    L27:
        e = move-exception;
        this.failureReason = "errCode is " + e.getCode() + ", " + e.getMessage();
    L29:
        r103 = null;
    L25:
        e = move-exception;
        this.failureReason = e.getMessage();
        goto L29
    L20:
        r105 = BMFSharp.init(this.mAlgorithm);
        goto L22
    L7:
        r102 = "1";
        goto L8
    L10:
        if (r101 >= 5) goto L12;
        String r106 = "0";
    L13:
        r212.put("sharp_type", r106);
        goto L15
    L12:
        r106 = "1";
        goto L13
    }

    public SharpPostProcessor(int r100, float r101, float r102, float r103, boolean r104, float r105, float r106) {
        this.failureReason = "";
        this.mSharpTemplate = 10;
        this.mAlgorithm = r100;
        this.mWt = r101;
        this.mThr = r102;
        this.mOvrt = r103;
        this.mAdaptive = r104;
        this.mG0 = r105;
        this.mLcWtThr = r106;
        this.mSharpResolution = new BMFSharp(r100);
    }

    public void updateSharpParams(int r100, float r101, float r102, float r103, boolean r104, float r105, float r106) {
        this.mSharpTemplate = 10;
        this.mAlgorithm = r100;
        this.mWt = r101;
        this.mThr = r102;
        this.mOvrt = r103;
        this.mAdaptive = r104;
        this.mG0 = r105;
        this.mLcWtThr = r106;
        this.mSharpResolution = new BMFSharp(r100);
    }
}
