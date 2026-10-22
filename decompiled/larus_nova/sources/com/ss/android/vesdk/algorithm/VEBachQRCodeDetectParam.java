package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachQRCodeDetectParam extends VEBachAlgorithmParam {
    public float bottom;
    public int detectFrameRate;
    public boolean enableZoomBehavior;
    private boolean isZoomByUser;
    public float left;
    public float maxFactorToFrameHeight;
    public float maxZoomFactor;
    public float needZoomFactorToFrameHeight;
    public int noQrCodeTimeOut;
    public float percent;
    public float right;
    public float threshold;
    public float top;
    private float zoom;

    public static final class Builder {
        private final VEBachQRCodeDetectParam mBachQRCodeDetectParam;

        public VEBachQRCodeDetectParam build() {
            VEBachQRCodeDetectParam.access$200(this.mBachQRCodeDetectParam);
            return this.mBachQRCodeDetectParam;
        }

        public Builder() {
            this.mBachQRCodeDetectParam = new VEBachQRCodeDetectParam();
        }

        public Builder(VEBachQRCodeDetectParam r100) {
            this.mBachQRCodeDetectParam = r100;
        }

        public Builder setBottom(float r100) {
            this.mBachQRCodeDetectParam.bottom = r100;
            return this;
        }

        public Builder setDetectFrameRate(int r100) {
            this.mBachQRCodeDetectParam.detectFrameRate = r100;
            return this;
        }

        public Builder setEnableZoomBehavior(boolean r100) {
            this.mBachQRCodeDetectParam.enableZoomBehavior = r100;
            return this;
        }

        public Builder setLeft(float r100) {
            this.mBachQRCodeDetectParam.left = r100;
            return this;
        }

        public Builder setMaxFactorToFrameHeight(float r100) {
            this.mBachQRCodeDetectParam.maxFactorToFrameHeight = r100;
            return this;
        }

        public Builder setNeedZoomFactorToFrameHeight(float r100) {
            this.mBachQRCodeDetectParam.needZoomFactorToFrameHeight = r100;
            return this;
        }

        public Builder setNotQRCodeTimeOut(int r100) {
            this.mBachQRCodeDetectParam.noQrCodeTimeOut = r100;
            return this;
        }

        public Builder setPercent(float r100) {
            this.mBachQRCodeDetectParam.percent = r100;
            return this;
        }

        public Builder setRight(float r100) {
            this.mBachQRCodeDetectParam.right = r100;
            return this;
        }

        public Builder setThreshold(float r100) {
            this.mBachQRCodeDetectParam.threshold = r100;
            return this;
        }

        public Builder setTop(float r100) {
            this.mBachQRCodeDetectParam.top = r100;
            return this;
        }

        public Builder setZoom(float r100) {
            VEBachQRCodeDetectParam.access$002(this.mBachQRCodeDetectParam, r100);
            return this;
        }

        public Builder setZoomByUser(boolean r100) {
            VEBachQRCodeDetectParam.access$102(this.mBachQRCodeDetectParam, r100);
            return this;
        }
    }

    public VEBachQRCodeDetectParam() {
        this.detectFrameRate = 10;
        this.threshold = 0.15f;
        this.noQrCodeTimeOut = 3000;
        this.needZoomFactorToFrameHeight = 0.2f;
        this.maxFactorToFrameHeight = 0.33f;
        this.enableZoomBehavior = true;
        this.top = 0.239f;
        this.bottom = 0.617f;
        this.left = 0.164f;
        this.right = 0.836f;
        this.percent = 0.5f;
        this.maxZoomFactor = 3.0f;
        this.zoom = Float.MIN_VALUE;
        this.isZoomByUser = false;
        setAlgorithmName("qrCodeDetect");
        setAlgorithmType(13);
    }

    private void buildConfig() {
        this.algorithmConfig = "{\n    \"version\": \"1.0\",\n    \"mode\": 2,\n    \"nodes\": [\n        {\n            \"name\": \"input_0\",\n            \"type\": \"blit\"\n        },\n        {\n            \"name\": \"ImageTransform\",\n            \"type\": \"nh_image_transform\",\n            \"config\":   {\n                \"keyMaps\":  {\n                    \"intParam\": {\n                        \"data_convert_rtype\":    3,\n                        \"cvt_color_code\":    1,\n                        \"side_mode\": 3,\n                        \"side_model_len\": 192,\n                        \"max_stride\": 32\n                    },\n                    \"floatParam\":   {\n                        \"data_convert_alpha\": 1,\n                        \"data_convert_beta\":    -128\n                    },\n                    \"stringParam\":  {\n                        \"transforms\":    \"side_mode_resize:cvt_color:data_convert\"\n                    }\n                }\n            }\n        },\n        {\n            \"name\": \"ToTensor\",\n            \"type\": \"nh_convert_to_tensor\",\n            \"config\":   {\n                \"keyMaps\":  {\n                    \"intParam\": {\n                    },\n                    \"floatParam\":   {\n                    },\n                    \"stringParam\":  {\n                    }\n                }\n            }\n        },\n        {\n            \"name\": \"Inference\",\n            \"type\": \"nh_inference\",\n            \"config\":   {\n                \"keyMaps\":  {\n                    \"intParam\": {\n                        \"num_thread\":    1,\n                        \"forward_type\":    0\n                    },\n                    \"floatParam\":   {\n                    },\n                    \"stringParam\":  {\n                        \"model_name\": \"tt_qrcode_det_nhapi_nas50\",\n                        \"output_names\": \"bbox_head.fcos_reg_all.0:bbox_head.fcos_reg_all.1:bbox_head.fcos_reg_all.2:bbox_head.fcos_cls_all.0:bbox_head.fcos_cls_all.1:bbox_head.fcos_cls_all.2:bbox_head.fcos_centerness_all.0:bbox_head.fcos_centerness_all.1:bbox_head.fcos_centerness_all.2\"\n                    }\n                }\n            }\n        },\n        {\n            \"name\": \"NHObjectDetectionPostProcess\",\n            \"type\": \"nh_object_detection_post_process\",\n            \"config\": {\n                \"keymaps\": {\n                    \"stringParam\": {\n                        \"m_anchorBaseSizes\": \"8,16,32\",\n                        \"m_baseSize\": \"8,16,32\",\n                        \"m_minSizes\": \"4,8,16\",\n                        \"m_strides\": \"8,16,32\",\n                        \"m_means\": \"0,0,0,0\",\n                        \"m_stds\": \"1,1,1,1\",\n                        \"m_scaleVec\": \"1:1:1\",\n                        \"m_ratioVec\": \"1:1:1\",\n                        \"m_bboxPredLayerNames\": \"bbox_head.fcos_reg_all.0,bbox_head.fcos_reg_all.1,bbox_head.fcos_reg_all.2\",\n                        \"m_clsScoreLayerNames\": \"bbox_head.fcos_cls_all.0,bbox_head.fcos_cls_all.1,bbox_head.fcos_cls_all.2\",\n                        \"m_centernessLayerNames\": \"bbox_head.fcos_centerness_all.0,bbox_head.fcos_centerness_all.1,bbox_head.fcos_centerness_all.2\"\n                    },\n                    \"intParam\": {\n                    \"m_nmsPreTopn\": 1000,\n                    \"m_nmsPostTopn\": 200,\n                    \"m_bits\": 16,\n                    \"m_detModelType\": 2,\n                    \"m_useCenterness\": 1\n                    },\n                    \"floatParam\": {\n                    \"m_nmsThresh\": 0.1,\n                    \"m_probThresh\": 0.1\n                    }\n                }\n            }\n        }\n    ],\n    \"links\": [\n        {\n            \"fromNode\": \"input_0\",\n            \"fromIndex\": 0,\n            \"toNode\": \"ImageTransform\",\n            \"toIndex\": 0\n        },\n        {\n            \"fromNode\": \"ImageTransform\",\n            \"fromIndex\": 0,\n            \"toNode\": \"ToTensor\",\n            \"toIndex\": 0\n        },\n        {\n            \"fromNode\": \"ToTensor\",\n            \"fromIndex\": 0,\n            \"toNode\": \"Inference\",\n            \"toIndex\": 0\n        },\n        {\n            \"fromNode\": \"Inference\",\n            \"fromIndex\": 0,\n            \"toNode\": \"NHObjectDetectionPostProcess\",\n            \"toIndex\": 0\n        },\n        {\n            \"fromNode\": \"input_0\",\n            \"fromIndex\": 0,\n            \"toNode\": \"NHObjectDetectionPostProcess\",\n            \"toIndex\": 1\n        },\n        {\n            \"fromNode\": \"ImageTransform\",\n            \"fromIndex\": 0,\n            \"toNode\": \"NHObjectDetectionPostProcess\",\n            \"toIndex\": 2\n        }\n    ]\n}";
    }

    @Override // com.ss.android.vesdk.algorithm.VEBachAlgorithmParam, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("detectFrameRate", this.detectFrameRate);
        r100.setFloat("threshold", this.threshold);
        r100.setInt("notQRCodeTimeOut", this.noQrCodeTimeOut);
        r100.setFloat("needZoomFactorToFrameHeight", this.needZoomFactorToFrameHeight);
        r100.setFloat("maxFactorToFrameHeight", this.maxFactorToFrameHeight);
        r100.setBool("enableZoomBehavior", this.enableZoomBehavior);
        r100.setFloat("top", this.top);
        r100.setFloat("bottom", this.bottom);
        r100.setFloat("left", this.left);
        r100.setFloat("right", this.right);
        r100.setFloat("percent", this.percent);
        r100.setFloat("maxZoomFactor", this.maxZoomFactor);
        r100.setFloat("Zoom", this.zoom);
        r100.setBool("isZoomByUser", this.isZoomByUser);
        return r100;
    }

    public float getZoom() {
        return this.zoom;
    }

    public boolean isZoomByUser() {
        return this.isZoomByUser;
    }

    public static /* synthetic */ void access$200(VEBachQRCodeDetectParam r100) {
        r100.buildConfig();
    }

    public static /* synthetic */ float access$002(VEBachQRCodeDetectParam r100, float r101) {
        r100.zoom = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(VEBachQRCodeDetectParam r100, boolean r101) {
        r100.isZoomByUser = r101;
        return r101;
    }
}
