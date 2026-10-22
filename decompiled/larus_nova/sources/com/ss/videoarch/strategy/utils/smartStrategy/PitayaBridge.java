package com.ss.videoarch.strategy.utils.smartStrategy;

import android.text.TextUtils;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.ss.videoarch.strategy.NativeObject;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class PitayaBridge extends NativeObject {
    static final String TAG = "PitayaBridge";

    public static /* synthetic */ void a(JSONObject[] r100, boolean r101, PTYError r102, PTYTaskData r103, PTYPackageInfo r104) {
        lambda$RunTask$0(r100, r101, r102, r103, r104);
    }

    private native void nativeSetObject();

    public PitayaBridge() {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableNativeStrategyCenter == 1) goto L5;
        return;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L9;
        nativeSetObject();
        return;
    }

    public String RunTask(String r100, String r101) {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUsePTY == 1) goto L5;
        return "";
    L5:
        final JSONObject[] r102 = {null};
        PTYTaskResultCallback r103 = new a(r102);
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r104 = new JSONObject(r101);     // Catch: JSONException -> L15
    L10:
        if (PitayaWrapper.inst().runPtyPacket(r100, r104, r103) == false) goto L17;
        JSONObject r105 = r102[0];     // Catch: JSONException -> L15
        if (r105 == null) goto L17;
        Objects.toString(r105);     // Catch: JSONException -> L15
        return r102[0].toString();
    L17:
        return "";
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static /* synthetic */ void lambda$RunTask$0(JSONObject[] r100, boolean r101, PTYError r102, PTYTaskData r103, PTYPackageInfo r104) {
        if (r103 == null) goto L4;
        r100[0] = r103.getParams();
        Objects.toString(r102);
        Objects.toString(r100[0]);
        return;
    L4:
        Objects.toString(r102);
    }
}
