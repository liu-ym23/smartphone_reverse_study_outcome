package com.ss.android.vesdk.algorithm;

import android.graphics.Bitmap;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.ugc.aweme.discover.model.BackgroundConfig;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachQRCodeParam extends VEBachAlgorithmParam {
    public static final int CODE_TYPE_AZTEC_SCAN = 513;
    public static final int CODE_TYPE_CODABAR = 515;
    public static final int CODE_TYPE_CODE128_CODE = 128;
    public static final int CODE_TYPE_CODE39_CODE = 64;
    public static final int CODE_TYPE_CODE93_CODE = 1024;
    public static final int CODE_TYPE_DATA_MATRIX = 256;
    public static final int CODE_TYPE_EAN_13_CODE = 32;
    public static final int CODE_TYPE_EAN_8_CODE = 16;
    public static final int CODE_TYPE_ITF14 = 514;
    public static final int CODE_TYPE_ITF_CODE = 2048;
    public static final int CODE_TYPE_PDF_417 = 512;
    public static final int CODE_TYPE_QRCODE = 1;
    public static final int CODE_TYPE_UPC_A_CODE = 4;
    public static final int CODE_TYPE_UPC_E_CODE = 8;
    public static final int CODE_TYPE_VORTEX_CODE = 2;
    private static final String TAG = "VEBachQRCodeParam";
    public String algorithmConfigJson;
    public String algorithmName;
    public boolean algorithmNameEnable;
    public boolean autoZoomIn;
    public boolean enhanceCamera;
    public String guidePicAlgorithm;
    public int mCodeType;
    public boolean mIsMultiCode;
    private VE_SCAN_CODE_BEHAVIOR mScanBehavior;
    public int mScanMode;
    public String modelName;
    public String modelPath;
    public int optimization;
    public boolean runSyncMode;
    public int scanFps;

    /* JADX INFO: renamed from: com.ss.android.vesdk.algorithm.VEBachQRCodeParam$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final VEBachQRCodeParam mBachQRCodeParam;

        public VEBachQRCodeParam build() {
            VEBachQRCodeParam.access$200(this.mBachQRCodeParam);
            return this.mBachQRCodeParam;
        }

        public Builder() {
            this.mBachQRCodeParam = new VEBachQRCodeParam(null);
        }

        public Builder(VEBachQRCodeParam r100) {
            this.mBachQRCodeParam = r100;
        }

        public Builder enableAutoZoomIn(boolean r100) {
            this.mBachQRCodeParam.autoZoomIn = r100;
            return this;
        }

        public Builder enhanceCamera(boolean r100) {
            this.mBachQRCodeParam.enhanceCamera = r100;
            return this;
        }

        public Builder setAlgorithmConfig(String r100) {
            this.mBachQRCodeParam.algorithmConfig = r100;
            return this;
        }

        public Builder setAlgorithmConfigJson(String r100) {
            this.mBachQRCodeParam.algorithmConfigJson = r100;
            return this;
        }

        public Builder setBitmap(Bitmap r100) {
            this.mBachQRCodeParam.bitmap = r100;
            return this;
        }

        public Builder setCodeType(int r100) {
            this.mBachQRCodeParam.mCodeType = r100;
            VELogUtil.d(VEBachQRCodeParam.TAG, "setCodeType:" + r100);
            return this;
        }

        public Builder setEnableScanAsync(boolean r100) {
            this.mBachQRCodeParam.setEnableScanAsync(r100);
            return this;
        }

        public Builder setGuidePicAlgorithm(String r100) {
            this.mBachQRCodeParam.guidePicAlgorithm = r100;
            return this;
        }

        public Builder setModelName(String r100) {
            this.mBachQRCodeParam.modelName = r100;
            return this;
        }

        public Builder setModelPath(String r100) {
            this.mBachQRCodeParam.modelPath = r100;
            return this;
        }

        public Builder setMultoCode(boolean r100) {
            this.mBachQRCodeParam.mIsMultiCode = r100;
            return this;
        }

        public Builder setOptimization(int r100) {
            this.mBachQRCodeParam.optimization = r100;
            return this;
        }

        public Builder setPicturePath(String r100) {
            this.mBachQRCodeParam.picturePath = r100;
            return this;
        }

        public Builder setReqHeight(int r100) {
            this.mBachQRCodeParam.reqHeight = r100;
            return this;
        }

        public Builder setReqWidth(int r100) {
            this.mBachQRCodeParam.reqWidth = r100;
            return this;
        }

        public Builder setRunSyncMode(boolean r100) {
            this.mBachQRCodeParam.runSyncMode = r100;
            return this;
        }

        public Builder setScanBehavior(VE_SCAN_CODE_BEHAVIOR r100) {
            VEBachQRCodeParam.access$102(this.mBachQRCodeParam, r100);
            return this;
        }

        public Builder setScanFps(int r100) {
            this.mBachQRCodeParam.scanFps = r100;
            return this;
        }

        public Builder setScanMode(VE_SCAN_MODE r100) {
            VEBachQRCodeParam r101 = this.mBachQRCodeParam;
            r101.mScanMode = r100.ordinal();
            return this;
        }

        public Builder setAlgorithmNameEnable(String r100, boolean r101) {
            VEBachQRCodeParam r102 = this.mBachQRCodeParam;
            r102.algorithmName = r100;
            r102.algorithmNameEnable = r101;
            return this;
        }

        public Builder setScanSize(int r100, int r101) {
            this.mBachQRCodeParam.setScanSize(r100, r101);
            return this;
        }
    }

    public static final enum VE_SCAN_CODE_BEHAVIOR extends Enum<VE_SCAN_CODE_BEHAVIOR> {
        private static final /* synthetic */ VE_SCAN_CODE_BEHAVIOR[] $VALUES = null;
        public static final VE_SCAN_CODE_BEHAVIOR ETEScanCodeContinue = null;
        public static final VE_SCAN_CODE_BEHAVIOR ETEScanCodeOnce = null;

        private static /* synthetic */ VE_SCAN_CODE_BEHAVIOR[] $values() {
            return new VE_SCAN_CODE_BEHAVIOR[]{ETEScanCodeOnce, ETEScanCodeContinue};
        }

        static {
            ETEScanCodeOnce = new VE_SCAN_CODE_BEHAVIOR("ETEScanCodeOnce", 0);
            ETEScanCodeContinue = new VE_SCAN_CODE_BEHAVIOR("ETEScanCodeContinue", 1);
            $VALUES = $values();
        }

        public static VE_SCAN_CODE_BEHAVIOR[] values() {
            return (VE_SCAN_CODE_BEHAVIOR[]) $VALUES.clone();
        }

        public static VE_SCAN_CODE_BEHAVIOR valueOf(String r100) {
            return (VE_SCAN_CODE_BEHAVIOR) a.a(VE_SCAN_CODE_BEHAVIOR.class, r100);
        }

        private VE_SCAN_CODE_BEHAVIOR(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VE_SCAN_MODE extends Enum<VE_SCAN_MODE> {
        private static final /* synthetic */ VE_SCAN_MODE[] $VALUES = null;
        public static final VE_SCAN_MODE CAMERA = null;
        public static final VE_SCAN_MODE PICTURE = null;

        private static /* synthetic */ VE_SCAN_MODE[] $values() {
            return new VE_SCAN_MODE[]{CAMERA, PICTURE};
        }

        static {
            CAMERA = new VE_SCAN_MODE("CAMERA", 0);
            PICTURE = new VE_SCAN_MODE(BackgroundConfig.BackgroundType.TYPE_PICTURE, 1);
            $VALUES = $values();
        }

        public static VE_SCAN_MODE[] values() {
            return (VE_SCAN_MODE[]) $VALUES.clone();
        }

        public static VE_SCAN_MODE valueOf(String r100) {
            return (VE_SCAN_MODE) a.a(VE_SCAN_MODE.class, r100);
        }

        private VE_SCAN_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    private void buildConfig() {
        if (this.modelName == null) goto L5;
        String r100 = "                        \"model_name\":\"" + this.modelName + "\"";
    L6:
        this.algorithmConfig = "{   \"version\": \"1.0\",   \"mode\":    2,   \"name\":    \"AlgorithmGraph_ecRgUcf7dhb9dzco8d9bfb5dccWd\",   \"size\":    {      \"width\":   0,      \"height\":  0   },   \"nodes\":   [{         \"name\":    \"blit_0\",         \"type\":    \"blit\",         \"config\":  {            \"keyMaps\": {               \"intParam\":    {               },               \"floatParam\":  {               },               \"stringParam\": {               },               \"pathParam\":   {               }            }         }      }, {         \"name\":    \"enigma\",         \"type\":    \"enigma\",         \"config\":  {            \"keyMaps\": {               \"intParam\":    {                  \"enigma_scan_mode\": " + this.mScanMode + ",                  \"enigma_run_mode\": " + (this.runSyncMode ? 1 : 0) + ",                  \"enigma_enhance_camera\": " + (this.enhanceCamera ? 1 : 0) + ",                  \"enigma_auto_zoom_in\": " + (this.autoZoomIn ? 1 : 0) + ",                  \"enigma_decode_multiple\": " + (this.mIsMultiCode ? 1 : 0) + ",                  \"enigma_code_type\": " + this.mCodeType + ",                  \"enigma_enable_rf\": 1,                  \"enigma_call_type\": 0               },               \"floatParam\":  {               },               \"stringParam\": {" + r100 + "               }            }         }      }],   \"links\":   [{      \"fromNode\":    \"blit_0\",      \"fromIndex\":   0,      \"toNode\":  \"enigma\",      \"toIndex\": 0   }]}";
        StringBuilder r101 = new StringBuilder("config json:\n");
        r101.append(this.algorithmConfig);
        VELogUtil.d(TAG, r101.toString());
        return;
    L5:
        r100 = "";
        goto L6
    }

    private VEBachQRCodeParam() {
        this.mScanMode = VE_SCAN_MODE.CAMERA.ordinal();
        this.mCodeType = 3;
        this.runSyncMode = false;
        this.scanFps = 3;
        this.enhanceCamera = true;
        this.mScanBehavior = VE_SCAN_CODE_BEHAVIOR.ETEScanCodeOnce;
        this.autoZoomIn = true;
        this.mIsMultiCode = false;
        this.algorithmConfigJson = "";
        this.guidePicAlgorithm = "";
        this.algorithmName = "";
        this.algorithmNameEnable = true;
        this.modelName = null;
        this.modelPath = null;
        this.optimization = -1;
        setAlgorithmName("enigma");
        buildConfig();
        setAlgorithmType(11);
    }

    @Override // com.ss.android.vesdk.algorithm.VEBachAlgorithmParam, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("FrameNum", this.scanFps);
        r100.setLong("CodeType", getCodeType());
        r100.setInt("scanBehavior", getScanBehavior().ordinal());
        r100.setString("algorithmConfigJson", this.algorithmConfigJson);
        r100.setString("guidePicAlgorithm", this.guidePicAlgorithm);
        r100.setString("algorithmName", this.algorithmName);
        r100.setBool("algorithmNameEnable", this.algorithmNameEnable);
        return r100;
    }

    public int getCodeType() {
        if (VEConfigCenter.getInstance().getValue("ve_enable_hms_qr_scan", false).booleanValue() == false) goto L7;
        return 2;
    L7:
        return this.mCodeType;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBachAlgorithmParam
    public String getAlgorithmConfig() {
        return this.algorithmConfig;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBachAlgorithmParam
    public String getPicturePath() {
        return this.picturePath;
    }

    public VE_SCAN_CODE_BEHAVIOR getScanBehavior() {
        return this.mScanBehavior;
    }

    public /* synthetic */ VEBachQRCodeParam(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ void access$200(VEBachQRCodeParam r100) {
        r100.buildConfig();
    }

    public static /* synthetic */ VE_SCAN_CODE_BEHAVIOR access$102(VEBachQRCodeParam r100, VE_SCAN_CODE_BEHAVIOR r101) {
        r100.mScanBehavior = r101;
        return r101;
    }
}
