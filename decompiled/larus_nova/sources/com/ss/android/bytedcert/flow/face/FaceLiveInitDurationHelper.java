package com.ss.android.bytedcert.flow.face;

import android.text.TextUtils;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class FaceLiveInitDurationHelper {
    private final Map<String, Long> mDurationMap;
    private final FaceDetectFlow mFlow;
    private final Map<String, Long> mStartTimeMap;

    public interface Module {
        public static final String CAMERA_SET_UP = "face_camera_setup";
        public static final String CHECK_CAMERA_FEATURE = "check_camera_feature";
        public static final String CHECK_MULTI_WINDOW = "check_multi_window";
        public static final String CHECK_PERMISSION = "check_permission";
        public static final String INIT_UI = "init_ui";
        public static final String LOAD_SMASH = "face_smash_load";
        public static final String SMASH_SET_UP = "face_smash_setup";
    }

    public FaceLiveInitDurationHelper(FaceDetectFlow r100) {
        this.mStartTimeMap = new HashMap();
        this.mDurationMap = new HashMap();
        this.mFlow = r100;
    }

    public void onStart(String r100) {
        if (BytedCertSdkManager.getInstance().isReportQualityInfo() == true) goto L5;
        return;
    L5:
        this.mStartTimeMap.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public void onEnd(String r100, boolean r101) {
        onFinish(r100, r101, !r101);
    }

    public void onFinish(String r110, boolean r111, boolean r112) {
        if (BytedCertSdkManager.getInstance().isReportQualityInfo() == true) goto L5;
        return;
    L5:
        Long r100 = this.mStartTimeMap.get(r110);
        long r101 = 0;
        if (r100 != null) goto L8;
    L10:
        if (r112 == false) goto L41;
        Iterator<String> r113 = this.mDurationMap.keySet().iterator();
        String r102 = "";
        long r103 = 0;
    L13:
        if (r113.hasNext() == false) goto L22;
        String r104 = r113.next();
        Long r105 = this.mDurationMap.get(r104);
        if (r105 == null) goto L13;
        r101 = r101 + r105.longValue();
        if (TextUtils.equals(r104, Module.CHECK_PERMISSION) == true) goto L13;
        if (r105.longValue() <= r103) goto L13;
        r103 = r105.longValue();
        r102 = r104;
        goto L13
    L22:
        JSONObject r114 = new JSONObject();
        if (r111 == false) goto L25;
        r114.put("result", "success");     // Catch: Exception -> L29
    L26:
        r114.put("max_duration", r103);     // Catch: Exception -> L29
        r114.put("max_duration_module", r102);     // Catch: Exception -> L29
        r114.put("duration", r101);     // Catch: Exception -> L29
        goto L27
    L25:
        r114.put("result", "fail");     // Catch: Exception -> L29
        r114.put("module_fail", r110);     // Catch: Exception -> L29
    L27:
        this.mFlow.onEvent(EventConstant.Event.EVENT_FACE_MODULE_LOAD_RESULT, r114);
        CertLog.d("FaceDetectFlow", "module:" + r110 + "; result:" + r111 + ";max_duration:" + r103 + ";max_duration_module:" + r102 + ";duration:" + r101);
        return;
    L41:
        return;
    L8:
        if (r100.longValue() <= 0) goto L10;
        long r106 = System.currentTimeMillis() - r100.longValue();
        this.mDurationMap.put(r110, Long.valueOf(r106));
        CertLog.d("FaceDetectFlow", r110 + " duration: " + r106);
        goto L10
    }
}
