package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import android.os.Build;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bytedance.bmf_mods_api.BmfException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class SRPostProcessor extends BasePostprocessor {
    public static String TAG = "SRPostProcessor";
    private String failureReason;
    private CacheKey mCacheKey;
    private boolean mEnableAllSr;
    private int mScaleType;
    private ISuperResolution mSuperResolution;
    private boolean mUseOpenGl;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "SRPostProcessor";
    }

    public String getScaleType(int r100) {
        if (r100 != 1) goto L5;
        return "1.5";
    L5:
        if (r100 != 2) goto L7;
        return "2";
    L7:
        if (r100 != 4) goto L9;
        return "1.1";
    L9:
        if (r100 != 8) goto L11;
        return "1.2";
    L11:
        if (r100 != 16) goto L13;
        return "1.3";
    L13:
        if (r100 == 32) goto L15;
        return "1";
    L15:
        return "1.4";
    }

    public void destroy() {
        this.mSuperResolution.destroy();
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey != null) goto L6;
        this.mCacheKey = new SimpleCacheKey(String.format(null, "s%d%b", new Object[]{Integer.valueOf(this.mScaleType), Boolean.valueOf(this.mEnableAllSr)}));
    L6:
        return this.mCacheKey;
    }

    private int getScaleType(String r100) {
        r100.getClass();
        switch(r100.hashCode()) {
            case 50: goto L30;
            case 48564: goto L26;
            case 48565: goto L22;
            case 48566: goto L18;
            case 48567: goto L14;
            case 48568: goto L10;
            case 49524: goto L6;
            default: goto L4;
        };
    L4:
        byte r101 = -1;
    L33:
        switch(r101) {
            case 0: goto L39;
            case 1: goto L41;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L39;
            default: goto L34;
        };
    L34:
        return -1;
    L35:
        return 1;
    L36:
        return 32;
    L37:
        return 16;
    L38:
        return 8;
    L39:
        return 2;
    L41:
        return 4;
    L6:
        if (r100.equals(EventConstant.Value.AUTH_VERSION_2) == false) goto L4;
        r101 = 6;
        goto L33
    L10:
        if (r100.equals("1.5") == false) goto L4;
        r101 = 5;
        goto L33
    L14:
        if (r100.equals("1.4") == false) goto L4;
        r101 = 4;
        goto L33
    L18:
        if (r100.equals("1.3") == false) goto L4;
        r101 = 3;
        goto L33
    L22:
        if (r100.equals("1.2") == false) goto L4;
        r101 = 2;
        goto L33
    L26:
        if (r100.equals("1.1") == false) goto L4;
        r101 = 1;
        goto L33
    L30:
        if (r100.equals("2") == false) goto L4;
        r101 = 0;
        goto L33
    }

    private boolean isProcessableBitmapConfig(Bitmap r100) {
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L9;
        if (r100.getConfig() != Bitmap.Config.ARGB_8888) goto L20;
        return true;
    L20:
        return false;
    L9:
        if ((BMFSR.getBitmapOptimizeLevel() & 1) <= 0) goto L17;
        if (Build.VERSION.SDK_INT > 29) goto L13;
        return false;
    L13:
        if (r100.getConfig() != Bitmap.Config.HARDWARE) goto L22;
        return true;
    L22:
        return false;
    L17:
        if (r100.getConfig() != Bitmap.Config.ARGB_8888) goto L23;
        return true;
    L23:
        return false;
    }

    public SRPostProcessor(int r100, boolean r101) {
        this.failureReason = "";
        this.mUseOpenGl = true;
        this.mEnableAllSr = r101;
        this.mScaleType = r100;
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L5;
        this.mSuperResolution = new BmfJniSr();
        return;
    L5:
        boolean r102 = this.mUseOpenGl;
        if (r102 == false) goto L8;
        int r103 = 7;
    L9:
        if (r102 == false) goto L11;
        int r104 = 3;
    L12:
        this.mSuperResolution = new BMFSR(r103, r104, 32768);
        return;
    L11:
        r104 = 2;
        goto L12
    L8:
        r103 = 8;
        goto L9
    }

    public void updateScaleTypeAndEnableAllSr(int r100, boolean r101) {
        this.mEnableAllSr = r101;
        this.mScaleType = r100;
    }

    public SRPostProcessor(boolean r100, int r101, boolean r102) {
        this.failureReason = "";
        this.mUseOpenGl = r100;
        this.mEnableAllSr = r102;
        this.mScaleType = r101;
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L5;
        this.mSuperResolution = new BmfJniSr();
        return;
    L5:
        boolean r103 = this.mUseOpenGl;
        if (r103 == false) goto L8;
        int r104 = 7;
    L9:
        if (r103 == false) goto L11;
        int r105 = 3;
    L12:
        this.mSuperResolution = new BMFSR(r104, r105, 32768);
        return;
    L11:
        r105 = 2;
        goto L12
    L8:
        r104 = 8;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public CloseableReference<Bitmap> process(Bitmap r210, PlatformBitmapFactory r211, Map<String, String> r212) {
        Bitmap r100 = r210;
        if (r212 != null) goto L5;
    L10:
        long r110 = System.currentTimeMillis();
        r212.put("sr_type", this.mSuperResolution.getSRType());
        String r101 = "sr_err";
        String r102 = "1";
        String r111 = "";
        if (isProcessableBitmapConfig(r210) == true) goto L14;
        this.failureReason = "The Bitmap config is not support sr, config is:" + r210.getConfig();
        char r112 = JSONLexer.EOI;
    L100:
        CloseableReference<Bitmap> r113 = null;
        String r103 = r111;
        ?? r114 = r112;
    L101:
        StringBuilder r104 = new StringBuilder();
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L104;
        int r105 = SRMonitorUtil.getMaxWidth();
    L105:
        r104.append(r105);
        r104.append(r103);
        r212.put("sr_max_width", r104.toString());
        StringBuilder r106 = new StringBuilder();
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L108;
        int r107 = SRMonitorUtil.getMaxHeight();
    L109:
        r106.append(r107);
        r106.append(r103);
        r212.put("sr_max_height", r106.toString());
        r212.put("scale_type", this.mScaleType + r103);
        r212.put("enable_all", this.mEnableAllSr + r103);
        if (r113 == null) goto L137;
    L130:
        return r113;
    L137:
    L126:
        th = th;
        String r108 = r102;
    L128:
        String r109 = r101;
    L129:
        r212.put("sr_status", r108);
        r212.put(r109, th.getMessage());
        goto L130
    L112:
        if (Build.VERSION.SDK_INT >= r114) goto L114;
    L116:
        r113 = r211.createBitmap(r100);     // Catch: Throwable -> L126
        r108 = r102;
        r212.put("sr_status", r108);     // Catch: Throwable -> L124
        r109 = r101;
        r212.put(r109, this.failureReason);     // Catch: Throwable -> L122
    L122:
        th = th;
    L124:
        th = th;
        goto L128
    L114:
        if (r100.getConfig() != Bitmap.Config.HARDWARE) goto L116;
        r100 = r100.copy(Bitmap.Config.ARGB_8888, false);     // Catch: Throwable -> L126
        goto L116
    L108:
        r107 = BMFSR.getMaxHeight();
        goto L109
    L104:
        r105 = BMFSR.getMaxWidth();
        goto L105
    L14:
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L16;
        int r115 = SRMonitorUtil.getMaxWidth();
        int r116 = SRMonitorUtil.getMaxHeight();
        int r117 = SRMonitorUtil.getConcurrencyLimit();
        String r118 = SRMonitorUtil.getCacheDir();
        String r119 = BmfJniSr.initBMFSR(r115, r116, r117, r118);
        ?? r120 = r118;
    L18:
        if ("success".equals(r119) == true) goto L148;
        r112 = JSONLexer.EOI;
        this.failureReason = "failed reason is:" + r119;
        goto L100
    L148:
        int r121 = 7;
        if (this.mEnableAllSr == false) goto L71;
        String r122 = r212.get("sr_stretch");     // Catch: Exception -> L87 BmfException -> L90
        r120 = 0;
        r120 = 0;
        float r213 = CastFloatProtector.parseFloat(r122);     // Catch: Exception -> L25
    L26:
        int r123 = getScaleType(r122);     // Catch: Exception -> L87 BmfException -> L90
        if (FrescoCacheMonitorUtil.isOptAutoSr() == true) goto L29;
    L51:
        r120 = 26;
        r120 = 26;
        r120 = 26;
        if (r123 > 0) goto L54;
        r102 = "1";
        r101 = "sr_err";
        this.failureReason = "The scale is abnormal, scale = " + r123;     // Catch: Exception -> L83 BmfException -> L85
        CloseableReference<Bitmap> r124 = null;
    L82:
        r113 = r124;
        ?? r125 = r120;
    L94:
        if (r113 == null) goto L98;
        r212.put("sr_status", "0");
        StringBuilder r126 = new StringBuilder();
        r126.append(System.currentTimeMillis() - r110);
        String r127 = r111;
        r126.append(r127);
        r212.put("sr_duration", r126.toString());
        r212.put("sr_width", r113.get().getWidth() + r127);
        r212.put("sr_height", r113.get().getHeight() + r127);
        r103 = r127;
        r114 = r125;
        if (this.mEnableAllSr == true) goto L101;
        r212.put("sr_stretch", getScaleType(this.mScaleType));
        r103 = r127;
        r114 = r125;
        goto L101
    L98:
        r103 = r111;
        r114 = r125;
        goto L101
    L54:
        if (FrescoCacheMonitorUtil.isUseJniSr() == true) goto L56;
        r102 = "1";
        r101 = "sr_err";
        if (BMFSR.getBmfSRStageType() != 0) goto L65;
        ISuperResolution r128 = this.mSuperResolution;     // Catch: Exception -> L83 BmfException -> L85
        boolean r129 = this.mUseOpenGl;     // Catch: Exception -> L83 BmfException -> L85
        if (r129 == true) goto L64;
        r121 = 8;
    L64:
        r124 = r128.processMultiScaleBitmap(r129, r210, r211, r121, r123);     // Catch: Exception -> L83 BmfException -> L85
        goto L82
    L65:
        r124 = this.mSuperResolution.processMultiScaleBitmap(BMFSR.getBitmapOptimizeLevel(), r100, r211, r123);     // Catch: Exception -> L83 BmfException -> L85
        goto L82
    L56:
        r101 = "sr_err";
        r102 = "1";
        r120 = 26;
        r124 = this.mSuperResolution.processMultiScaleBitmap(this.mUseOpenGl, r210, r211, 7, r123);     // Catch: Exception -> L83 BmfException -> L85
        goto L82
    L29:
        if (r213 <= 0.0f) goto L51;
    L32:
        if (r213 >= FrescoCacheMonitorUtil.getStretchAboveForSR()) goto L51;
        r120 = 26;
        r120 = 26;
        if (Build.VERSION.SDK_INT >= 26) goto L37;
    L40:
        Bitmap r130 = r100;
    L142:
        r212.put("sr_status", "1");     // Catch: Exception -> L43 BmfException -> L45
        r212.put("sr_err", "倍率小于设置的允许超分倍率" + FrescoCacheMonitorUtil.getStretchAboveForSR());     // Catch: Exception -> L43 BmfException -> L45
        return r211.createBitmap(r130);
    L45:
        e = e;
        r100 = r130;
    L69:
        r102 = "1";
        r101 = "sr_err";
    L92:
        this.failureReason = "errCode is " + e.getCode() + ", " + e.getMessage();
        ?? r131 = r120;
    L93:
        r113 = null;
        r125 = r131;
    L43:
        e = e;
        r100 = r130;
    L67:
        r102 = "1";
        r101 = "sr_err";
    L89:
        this.failureReason = e.getMessage();
        r131 = r120;
        goto L93
    L37:
        if (r210.getConfig() != Bitmap.Config.HARDWARE) goto L40;
        r130 = r100.copy(Bitmap.Config.ARGB_8888, false);     // Catch: Exception -> L66 BmfException -> L68
        goto L142
    L49:
        e = e;
    L91:
        r102 = "1";
        r101 = "sr_err";
        r120 = 26;
    L47:
        e = e;
    L88:
        r102 = "1";
        r101 = "sr_err";
        r120 = 26;
    L68:
        e = e;
    L66:
        e = e;
    L25:
        r213 = 0.0f;
        goto L26
    L71:
        r102 = "1";
        r101 = "sr_err";
        r120 = 26;
        r120 = 26;
        r120 = 26;
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L75;
        r124 = this.mSuperResolution.processMultiScaleBitmap(this.mUseOpenGl, r210, r211, 7, this.mScaleType);     // Catch: Exception -> L83 BmfException -> L85
        goto L82
    L75:
        if (BMFSR.getBmfSRStageType() != 0) goto L81;
        ISuperResolution r132 = this.mSuperResolution;     // Catch: Exception -> L83 BmfException -> L85
        boolean r133 = this.mUseOpenGl;     // Catch: Exception -> L83 BmfException -> L85
        if (r133 == true) goto L80;
        r121 = 8;
    L80:
        r124 = r132.processMultiScaleBitmap(r133, r210, r211, r121, this.mScaleType);     // Catch: Exception -> L83 BmfException -> L85
        goto L82
    L81:
        r124 = this.mSuperResolution.processMultiScaleBitmap(BMFSR.getBitmapOptimizeLevel(), r100, r211, this.mScaleType);     // Catch: Exception -> L83 BmfException -> L85
    L85:
        e = e;
    L83:
        e = e;
    L90:
        e = e;
    L87:
        e = e;
        goto L88
    L16:
        r119 = BMFSR.init(BMFSR.getBmfSRStageType());
        r120 = r111;
        goto L18
    L5:
        if ("0".equalsIgnoreCase(r212.get("sr_status")) == false) goto L10;
        return r211.createBitmap(r100);
    L8:
        return null;
    }

    public SRPostProcessor(int r100, int r101, int r102, boolean r110) {
        this.failureReason = "";
        this.mUseOpenGl = true;
        this.mEnableAllSr = r110;
        this.mScaleType = r100;
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L5;
        this.mSuperResolution = new BmfJniSr();
        return;
    L5:
        boolean r111 = this.mUseOpenGl;
        if (r111 == false) goto L8;
        int r103 = 7;
    L9:
        if (r111 == false) goto L11;
        int r104 = 3;
    L12:
        this.mSuperResolution = new BMFSR(r103, r104, 32768, r101, r102);
        return;
    L11:
        r104 = 2;
        goto L12
    L8:
        r103 = 8;
        goto L9
    }

    public SRPostProcessor(int r100, int r101, int r102, int r110, boolean r111) {
        this.failureReason = "";
        this.mUseOpenGl = true;
        this.mEnableAllSr = r111;
        this.mScaleType = r101;
        if (FrescoCacheMonitorUtil.isUseJniSr() == false) goto L6;
        this.mSuperResolution = new BmfJniSr();
        return;
    L6:
        if (this.mUseOpenGl == false) goto L8;
        int r103 = 3;
    L9:
        this.mSuperResolution = new BMFSR(r100, r103, 32768, r102, r110);
        return;
    L8:
        r103 = 2;
        goto L9
    }
}
