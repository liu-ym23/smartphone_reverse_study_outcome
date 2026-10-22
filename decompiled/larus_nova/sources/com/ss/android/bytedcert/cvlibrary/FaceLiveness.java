package com.ss.android.bytedcert.cvlibrary;

import com.ss.android.bytedcert.face.w;
import com.ss.android.cert.manager.utils.CertLog;
import hsa.a;
import hsa.b;
import java.nio.Buffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class FaceLiveness extends a {
    public static final String ALGO_ACTION_VERSION = "3.0";
    private b mOnNativeEventListener;

    public static native String native_FL_GetModelName();

    public static native String native_FL_GetSdkVersion();

    public native int native_FL_CacheMotionExtremeFrame(long r100, int r101);

    public native int native_FL_ClearMotionExtremeFrame(long r100);

    public native long native_FL_CreateHandler();

    public native int native_FL_GetBestFrame(long r100, byte[] r101, int[] r102, byte[] r103, int[] r104);

    public native String native_FL_GetFaceVerifySdkData(long r100, byte[] r101, int r102, int r103, byte[] r104, int r105, int r106);

    public native byte[] native_FL_GetHeadYawCaptureImage(long r100, int r101);

    public native int native_FL_GetInfoDetectResult(long r100, int[] r101);

    public native String native_FL_GetLogData(long r100);

    public native String native_FL_GetQualityLog(long r100);

    public native String native_FL_GetSdkData(long r100, int r101, String r102, boolean r103, String r104, boolean r105, int r106, int[] r107, String r110, String r111, boolean r112, boolean r113, boolean r114, String r115, boolean r116);

    public native String native_FL_GetStageLogInfo(long r100, int r101);

    public native String native_FL_GetStillSdkData(long r100, byte[] r101, int r102, int r103);

    public native int native_FL_ReleaseHandle(long r100, boolean r101, String r102);

    public native int native_FL_ReleaseHeadYawCaptureImage(long r100, int r101);

    public native int native_FL_ResetHandle(long r100, boolean r101, String r102);

    public native int native_FL_SetConfigBuffer(long r100, int r101, Buffer r102);

    public native int native_FL_SetConfigFloat(long r100, int r101, float r102);

    public native int native_FL_SetConfigInt(long r100, int r101, int r102);

    public native int native_FL_SetHeadYawCaptureConfig(long r100, boolean r101, float r102, float r103);

    public native int native_FL_SetModule(long r100, String r101);

    public native int native_FL_SetParamFromBytes(long r100, int r101, int r102, int r103, int r104, int r105, int r106);

    public native int native_FL_doFaceQuality(long r100, byte[] r101, int r102, int r103, int r104, int r105, int r106, int[] r107);

    public native int native_FL_doPredict(long r100, byte[] r101, int r102, int r103, int r104, int r105, int r106, int r107, int[] r110, int[] r111, float[] r112, byte[] r113);

    public native int native_FL_show(long r100, byte[] r101, byte[] r102, int r103, int r104, int r105, int[] r106, int r107);

    public FaceLiveness() {
    }

    public void setOnNativeEventListener(b r100) {
        this.mOnNativeEventListener = r100;
    }

    public void onNativeEvent(String r100, int r101, String r102) {
        b r103 = this.mOnNativeEventListener;
        if (r103 == null) goto L11;
        CertLog.e("FaceDetectFlow", w.P + " receive native event:" + r100 + ";code:" + r101 + ";msg:" + r102);
        w r104 = ((w.b) r103).f407540a;
        r104.getClass();
        JSONObject r105 = new JSONObject();
        r105.put("event", r100);     // Catch: Exception -> L8
        r105.put("code", r101);     // Catch: Exception -> L8
        r105.put("message", r102);     // Catch: Exception -> L8
    L6:
        r104.f407536x.onEvent("face_detection_native_event", r105);
        return;
    }
}
