package com.lightning.edu.ei.edgealgorithm;

import android.os.Build;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class Result {
    public float[] blurConf;
    public long blurCost;
    public float blurScore;
    public float blurThreshold;
    public float[][] boundingBoxes;
    public boolean checkOrbFeat;
    public long darkCheckCost;
    public int darkLabel;
    public float[] darkLabelConf;
    public long detectionCost;
    public String detectionMsg;
    public int detectionStatus;
    public String deviceInfo;
    public long featureCheckCost;
    public int inHeight;
    public int inOrientation;
    public int inWidth;
    public long initCost;
    public float[] midboundingBox;
    public String msg;
    public int orientation;
    public float[] orientationConf;
    public long orientationCost;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    public String f379900os;
    public boolean pass;
    public long preProcessCost;
    public long predictCost;
    public long sceneCost;
    public int sceneLabel;
    public float[] sceneLabelConf;
    public long sceneOrientationCost;
    public String stateMachineInfo;
    public int stateMachinePrePC;
    public int status;
    public String threeClassMsg;
    public int threeClassStatus;
    public String version;

    public static String readableDark(int r100) {
        if (r100 != 0) goto L6;
        return "过暗";
    L6:
        if (r100 != 1) goto L9;
        return "正常";
    L9:
        return "未知亮度";
    }

    public static String readableOrientation(int r100) {
        if (r100 != 0) goto L6;
        return "0度";
    L6:
        if (r100 != 1) goto L10;
        return "左转90度";
    L10:
        if (r100 != 2) goto L14;
        return "旋转180度";
    L14:
        if (r100 != 3) goto L17;
        return "右转90度";
    L17:
        return "未知角度";
    }

    public static String readableScene(int r100) {
        if (r100 != 0) goto L6;
        return "题目场景";
    L6:
        if (r100 != 1) goto L9;
        return "非题目场景";
    L9:
        return "未知场景";
    }

    public void getOsDeviceInfo() {
        this.f379900os = "Android " + Build.VERSION.RELEASE;
        this.deviceInfo = Build.BRAND + "_" + Build.HARDWARE + "_" + Build.CPU_ABI;
    }

    public Status getStatus() {
        switch(this.status) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L29;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            default: goto L5;
        };
    L5:
        return Status.STATUS_SUCCESS;
    L7:
        return Status.STATUS_DETECTION_INFERENCE_IS_NULL;
    L9:
        return Status.STATUS_DETECTION_INFERENCE_FAILED;
    L11:
        return Status.STATUS_NEED_REFUSE;
    L13:
        return Status.STATUS_NEED_RETAKE;
    L15:
        return Status.STATUS_CHECK_DARK_FAILED;
    L17:
        return Status.STATUS_CHECK_SCENE_FAILED;
    L19:
        return Status.STATUS_CHECK_BLUR_FAILED;
    L21:
        return Status.STATUS_BITMAP_LOCK_PIXELS;
    L23:
        return Status.STATUS_BITMAP_NOT_RGBA8888;
    L25:
        return Status.STATUS_BITMAP_GET_INFO;
    L27:
        return Status.STATUS_BITMAP_IS_RECYCLED;
    L29:
        return Status.STATUS_INFERENCE_IS_NULL_C;
    L31:
        return Status.STATUS_IMAGE_SMALL;
    L33:
        return Status.STATUS_INFERENCE_IS_NULL;
    L35:
        return Status.STATUS_SUCCESS;
    }

    public String toJSON() {
        getOsDeviceInfo();
        JSONObject r100 = new JSONObject();
        r100.put("pass", this.pass);     // Catch: JSONException -> L27
        r100.put("blurScore", this.blurScore);     // Catch: JSONException -> L27
        r100.put("blurThreshold", this.blurThreshold);     // Catch: JSONException -> L27
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L27
        float[] r102 = this.blurConf;     // Catch: JSONException -> L27
        int r103 = r102.length;     // Catch: JSONException -> L27
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L6;
        r101.put(r102[r104]);     // Catch: JSONException -> L27
        r104 = r104 + 1;     // Catch: JSONException -> L27
        goto L4
    L6:
        r100.put("blurConf", r101);     // Catch: JSONException -> L27
        r100.put("sceneLabel", this.sceneLabel);     // Catch: JSONException -> L27
        JSONArray r105 = new JSONArray();     // Catch: JSONException -> L27
        float[] r106 = this.sceneLabelConf;     // Catch: JSONException -> L27
        int r107 = r106.length;     // Catch: JSONException -> L27
        int r108 = 0;
    L7:
        if (r108 >= r107) goto L9;
        r105.put(r106[r108]);     // Catch: JSONException -> L27
        r108 = r108 + 1;     // Catch: JSONException -> L27
        goto L7
    L9:
        r100.put("sceneLabelConf", r105);     // Catch: JSONException -> L27
        r100.put("darkLabel", this.darkLabel);     // Catch: JSONException -> L27
        JSONArray r109 = new JSONArray();     // Catch: JSONException -> L27
        float[] r110 = this.darkLabelConf;     // Catch: JSONException -> L27
        int r111 = r110.length;     // Catch: JSONException -> L27
        int r112 = 0;
    L10:
        if (r112 >= r111) goto L12;
        r109.put(r110[r112]);     // Catch: JSONException -> L27
        r112 = r112 + 1;     // Catch: JSONException -> L27
        goto L10
    L12:
        r100.put("darkLabelConf", r109);     // Catch: JSONException -> L27
        r100.put("inOrientation", this.inOrientation);     // Catch: JSONException -> L27
        r100.put("inWidth", this.inWidth);     // Catch: JSONException -> L27
        r100.put("inHeight", this.inHeight);     // Catch: JSONException -> L27
        r100.put("orientation", this.orientation);     // Catch: JSONException -> L27
        JSONArray r113 = new JSONArray();     // Catch: JSONException -> L27
        float[] r114 = this.orientationConf;     // Catch: JSONException -> L27
        int r115 = r114.length;     // Catch: JSONException -> L27
        int r116 = 0;
    L13:
        if (r116 >= r115) goto L15;
        r113.put(r114[r116]);     // Catch: JSONException -> L27
        r116 = r116 + 1;     // Catch: JSONException -> L27
        goto L13
    L15:
        r100.put("orientationConf", r113);     // Catch: JSONException -> L27
        r100.put("initCost", this.initCost + "ms");     // Catch: JSONException -> L27
        r100.put("preProcessCost", this.preProcessCost + "ms");     // Catch: JSONException -> L27
        r100.put("darkCheckCost", this.darkCheckCost + "ms");     // Catch: JSONException -> L27
        r100.put("blurCost", this.blurCost + "ms");     // Catch: JSONException -> L27
        r100.put("featureCheckCost", this.featureCheckCost + "ms");     // Catch: JSONException -> L27
        r100.put("sceneCost", this.sceneCost + "ms");     // Catch: JSONException -> L27
        r100.put("orientationCost", this.orientationCost + "ms");     // Catch: JSONException -> L27
        r100.put("predictCost", this.predictCost + "ms");     // Catch: JSONException -> L27
        r100.put("version", this.version);     // Catch: JSONException -> L27
        r100.put("status", this.status);     // Catch: JSONException -> L27
        r100.put("threeClassStatus", this.threeClassStatus);     // Catch: JSONException -> L27
        r100.put("stateMachineInfo", this.stateMachineInfo);     // Catch: JSONException -> L27
        r100.put("stateMachinePrePC", this.stateMachinePrePC);     // Catch: JSONException -> L27
        r100.put("msg", this.msg);     // Catch: JSONException -> L27
        r100.put("threeClassMsg", this.threeClassMsg);     // Catch: JSONException -> L27
        r100.put("os", this.f379900os);     // Catch: JSONException -> L27
        r100.put("deviceInfo", this.deviceInfo);     // Catch: JSONException -> L27
        JSONArray r117 = new JSONArray();     // Catch: JSONException -> L27
        float[] r118 = this.midboundingBox;     // Catch: JSONException -> L27
        int r119 = r118.length;     // Catch: JSONException -> L27
        int r120 = 0;
    L16:
        if (r120 >= r119) goto L18;
        r117.put(r118[r120]);     // Catch: JSONException -> L27
        r120 = r120 + 1;     // Catch: JSONException -> L27
        goto L16
    L18:
        JSONArray r121 = new JSONArray();     // Catch: JSONException -> L27
        r100.put("midboundingBox", r117);     // Catch: JSONException -> L27
        int r122 = 0;
    L20:
        if (r122 >= this.boundingBoxes.length) goto L25;
        JSONArray r123 = new JSONArray();     // Catch: JSONException -> L27
        float[] r124 = this.boundingBoxes[r122];     // Catch: JSONException -> L27
        int r125 = r124.length;     // Catch: JSONException -> L27
        int r126 = 0;
    L22:
        if (r126 >= r125) goto L24;
        r123.put(r124[r126]);     // Catch: JSONException -> L27
        r126 = r126 + 1;     // Catch: JSONException -> L27
        goto L22
    L24:
        r121.put(r123);     // Catch: JSONException -> L27
        r122 = r122 + 1;     // Catch: JSONException -> L27
        goto L20
    L25:
        r100.put("boundingBoxes", r121);     // Catch: JSONException -> L27
        r100.put("detectionCost", this.detectionCost + "ms");     // Catch: JSONException -> L27
        r100.put("detectionStatus", this.detectionStatus);     // Catch: JSONException -> L27
        r100.put("detectionMsg", this.detectionMsg);     // Catch: JSONException -> L27
        return r100.toString();
    L27:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public Result() {
        this.pass = true;
        this.status = 0;
        this.threeClassStatus = 0;
        this.blurScore = -1.0f;
        this.orientation = -1;
        this.sceneLabel = -1;
        this.darkLabel = -1;
        this.blurConf = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.orientationConf = new float[]{-1.0f, -1.0f, -1.0f, -1.0f};
        this.sceneLabelConf = new float[]{-1.0f, -1.0f};
        this.darkLabelConf = new float[]{-1.0f, -1.0f};
        this.msg = "Success";
        this.threeClassMsg = "Success";
        this.stateMachineInfo = "";
        this.stateMachinePrePC = -1;
        this.version = "";
        this.initCost = 0;
        this.preProcessCost = 0;
        this.blurCost = 0;
        this.sceneCost = 0;
        this.orientationCost = 0;
        this.sceneOrientationCost = 0;
        this.predictCost = 0;
        this.darkCheckCost = 0;
        this.featureCheckCost = 0;
        this.blurThreshold = 0.0f;
        this.inOrientation = 0;
        this.inWidth = 0;
        this.inHeight = 0;
        this.checkOrbFeat = true;
        this.detectionStatus = 0;
        this.detectionMsg = "Success";
        this.boundingBoxes = new float[][]{new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f}};
        this.midboundingBox = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.detectionCost = 0;
    }

    public String toString() {
        getOsDeviceInfo();
        return " 是否通过=" + this.pass + ",\n 模糊打分=" + this.blurScore + " [模糊阈值: " + this.blurThreshold + "],\n 模糊置信度=" + Arrays.toString(this.blurConf) + ",\n 输入Exif方向=" + this.inOrientation + ", 输入尺寸=w:" + this.inWidth + ", h:" + this.inHeight + ",\n 旋转角度=" + readableOrientation(this.orientation) + " 置信度: " + Arrays.toString(this.orientationConf) + ",\n 场景分类=" + readableScene(this.sceneLabel) + " 置信度: " + Arrays.toString(this.sceneLabelConf) + ",\n 过暗判断=" + readableDark(this.darkLabel) + " 置信度: " + Arrays.toString(this.darkLabelConf) + ",\n 模型初始化耗时=" + this.initCost + "ms,\n 预处理耗时=" + this.preProcessCost + "ms,\n 过暗判断耗时=" + this.darkCheckCost + "ms,\n 模糊检测耗时=" + this.blurCost + "ms,\n ORB特征耗时=" + this.featureCheckCost + "ms,\n 场景判断耗时=" + this.sceneCost + "ms,\n 方向检测耗时=" + this.orientationCost + "ms,\n 算法总耗时=" + this.predictCost + "ms,\n ORB判断=" + this.checkOrbFeat + ",\n 状态=" + readableStatus(this.status) + ",\n 调试信息='" + this.msg + "',\n Refuse状态=" + readableStatus(this.threeClassStatus) + ",\n Refuse信息='" + this.threeClassMsg + "',\n 预测前状态机计数='" + this.stateMachinePrePC + "',\n 状态机='" + this.stateMachineInfo + "',\n 切题输入图像宽度=" + this.inWidth + ", 高度=" + this.inHeight + ",\n 切题最近中心检测结果=" + Arrays.toString(this.midboundingBox) + ",\n 切题算法总耗时=" + this.detectionCost + "ms,\n 切题状态=" + readableDetectionStatus(this.detectionStatus) + ",\n 切题调试信息='" + this.detectionMsg + "',\n 版本=" + this.version + ",\n 系统&设备=" + this.f379900os + "_" + this.deviceInfo;
    }

    public static String readableDetectionStatus(int r100) {
        if (r100 != (-1)) goto L6;
        return "被拒识";
    L6:
        if (r100 != 0) goto L10;
        return "成功";
    L10:
        return "失败(" + r100 + ")";
    }

    public static String readableStatus(int r100) {
        if (r100 != 0) goto L6;
        return "成功";
    L6:
        return "失败(" + r100 + ")";
    }
}
