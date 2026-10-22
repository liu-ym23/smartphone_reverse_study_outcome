package com.ss.ttvideoengine.model;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class MediaBitrateFitterInfo {
    public static final String KEY_FITTER_DURATION = "duration";
    public static final String KEY_FITTER_FUNC_PARAMS = "func_params";
    public static final String KEY_FITTER_FUNC_TYPE = "func_method";
    public static final String KEY_FITTER_HEADER_SIZE = "header_size";
    private static final String TAG = "FitterInfo";
    private int mDuration;
    private float[] mFunctionParams;
    private int mFunctionType;
    private int mHeaderSize;

    public MediaBitrateFitterInfo() {
        this.mFunctionParams = null;
        this.mFunctionType = 0;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public float[] getFunctionParams() {
        return this.mFunctionParams;
    }

    public int getFunctionType() {
        return this.mFunctionType;
    }

    public int getHeaderSize() {
        return this.mHeaderSize;
    }

    private int calculateSize(float r110) {
        float[] r100 = getFunctionParams();
        getHeaderSize();
        if (r100.length <= 50) goto L6;
        TTVideoEngineLog.e(TAG, "bitrateFitterParams num: " + r100.length);
        return 0;
    L6:
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L15;
        double r103 = 1.0d;
        int r104 = 0;
    L11:
        if (r104 >= ((r100.length - r102) - 1)) goto L13;
        r103 = r103 * ((double) r110);
        r104 = r104 + 1;
        goto L11
    L13:
        r101 = r101 + (r103 * ((double) r100[r102]));
        r102 = r102 + 1;
        goto L8
    L15:
        return (int) (((r101 * ((double) r110)) * 1024.0d) / 8.0d);
    }

    private int calculateSizeByFun2(float r110) {
        float[] r100 = getFunctionParams();
        if (r100.length == 3) goto L5;
        return 0;
    L5:
        double r101 = r100[0];
        double r102 = r110;
        return (int) (((((r101 / Math.pow(r102, r100[2])) + r100[1]) * r102) * 1024.0d) / 8.0d);
    }

    public int calculateSizeBySecond(float r100) {
        if (this.mFunctionParams != null) goto L7;
        TTVideoEngineLog.e(TAG, "fitter params empty");
        return 0;
    L7:
        if (r100 <= getDuration()) goto L9;
    L20:
        TTVideoEngineLog.e(TAG, String.format("preload second:%f, fitter duration:%d", new Object[]{Float.valueOf(r100), Integer.valueOf(getDuration())}));
        return 0;
    L9:
        if (r100 <= 0.0f) goto L20;
        int r101 = this.mFunctionType;
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L19;
        return calculateSizeByFun2(r100);
    L19:
        return calculateSize(r100);
    L14:
        return calculateSize(r100);
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L19;
        return;
    L19:
    L16:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    L6:
        if (r100.has(KEY_FITTER_FUNC_PARAMS) == false) goto L14;
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, KEY_FITTER_FUNC_PARAMS);     // Catch: Exception -> L16
        if (r101.length() > 0) goto L10;
        return;
    L10:
        this.mFunctionParams = new float[r101.length()];     // Catch: Exception -> L16
        int r102 = 0;
    L12:
        if (r102 >= r101.length()) goto L14;
        this.mFunctionParams[r102] = (float) r101.optDouble(r102);     // Catch: Exception -> L16
        r102 = r102 + 1;     // Catch: Exception -> L16
    L14:
        this.mHeaderSize = r100.optInt(KEY_FITTER_HEADER_SIZE);     // Catch: Exception -> L16
        this.mDuration = r100.optInt("duration");     // Catch: Exception -> L16
        this.mFunctionType = r100.optInt(KEY_FITTER_FUNC_TYPE);     // Catch: Exception -> L16
    }
}
