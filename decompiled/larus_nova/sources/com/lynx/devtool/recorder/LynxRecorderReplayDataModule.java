package com.lynx.devtool.recorder;

import android.content.Context;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.PiperData;
import com.lynx.tasm.base.LLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxRecorderReplayDataModule extends LynxModule {
    private static final String TAG = "LynxRecorderReplayDataModule";
    private JSONObject mCallbackData;
    private JSONArray mFunctionCall;
    private JSONArray mJsbIgnoredInfo;
    private JSONObject mJsbSettings;
    private JSONObject mSharedData;

    private String getJsbIgnoredInfo() {
        JSONArray r100 = this.mJsbIgnoredInfo;
        if (r100 != null) goto L5;
        LLog.e("TestBench", "getJsbIgnoredInfo  error: download File failed");
        return "[]";
    L5:
        return r100.toString();
    }

    private String getJsbSettings() {
        JSONObject r100 = this.mJsbSettings;
        if (r100 != null) goto L5;
        LLog.e("TestBench", "getJsbSettings  error: download File failed");
        return SliceInitService.DEFAULT_SWITCH;
    L5:
        return r100.toString();
    }

    private String getRecordData() {
        String r100 = "Record Time";
        String r101 = "Params";
        String r102 = "RecordMillisecond";
        JSONObject r103 = new JSONObject();
        int r104 = 0;
    L46:
        if (r104 >= this.mFunctionCall.length()) goto L39;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(this.mFunctionCall, r104);     // Catch: JSONException -> L40
        String r110 = JSONObjectProtectorUtils.getString(r105, "Module Name");     // Catch: JSONException -> L40
        if (r103.has(r110) == true) goto L8;
        r103.put(r110, new JSONArray());     // Catch: JSONException -> L40
    L8:
        JSONObject r111 = new JSONObject();     // Catch: JSONException -> L40
        Object r112 = JSONObjectProtectorUtils.getString(r105, "Method Name");     // Catch: JSONException -> L40
        long r113 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r105, r100)) * 1000;     // Catch: JSONException -> L40
        if (r105.has(r102) == false) goto L11;
        r113 = JSONObjectProtectorUtils.getLong(r105, r102);     // Catch: JSONException -> L40
    L11:
        JSONObject r106 = JSONObjectProtectorUtils.getJSONObject(r105, r101);     // Catch: JSONException -> L40
        JSONArray r114 = JSONObjectProtectorUtils.getJSONArray(r106, "callback");     // Catch: JSONException -> L15
    L16:
        StringBuffer r107 = new StringBuffer();     // Catch: JSONException -> L40
        JSONObject r210 = r103;
        JSONArray r108 = new JSONArray();     // Catch: JSONException -> L40
        if (r114 == null) goto L32;
        int r115 = 0;
    L20:
        if (r115 >= r114.length()) goto L31;
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(this.mCallbackData, JSONArrayProtectorUtils.getString(r114, r115));     // Catch: JSONException -> L23
    L24:
        if (r109 == null) goto L30;
        long r211 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r109, r100)) * 1000;     // Catch: JSONException -> L40
        if (r105.has(r102) == false) goto L28;
        r211 = JSONObjectProtectorUtils.getLong(r109, r102);     // Catch: JSONException -> L40
    L28:
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L40
        r116.put("Value", JSONObjectProtectorUtils.getJSONObject(r109, r101));     // Catch: JSONException -> L40
        r116.put("Delay", r211 - r113);     // Catch: JSONException -> L40
        r108.put(r115, r116);     // Catch: JSONException -> L40
    L30:
        r107.append(JSONArrayProtectorUtils.getString(r114, r115));     // Catch: JSONException -> L40
        r107.append("_");     // Catch: JSONException -> L40
        r115 = r115 + 1;     // Catch: JSONException -> L40
        LynxRecorderReplayDataModule this = this;
        r101 = r101;
        r100 = r100;
        r102 = r102;
    L23:
        r109 = null;
        goto L24
    L31:
        String r212 = r100;
        String r117 = r101;
        String r213 = r102;
    L34:
        if (r105.has("SyncAttributes") == false) goto L36;
        r111.put("SyncAttributes", JSONObjectProtectorUtils.getJSONObject(r105, "SyncAttributes"));     // Catch: JSONException -> L40
    L36:
        r111.put("Method Name", r112);     // Catch: JSONException -> L40
        r111.put(r117, r106);     // Catch: JSONException -> L40
        r111.put("Callback", r108);     // Catch: JSONException -> L40
        r111.put("Label", r107.toString());     // Catch: JSONException -> L40
        JSONObjectProtectorUtils.getJSONArray(r210, r110).put(r111);     // Catch: JSONException -> L40
        r104 = r104 + 1;
        r103 = r210;
        r101 = r117;
        r100 = r212;
        r102 = r213;
        goto L46
    L32:
        r212 = r100;
        r117 = r101;
        r213 = r102;
    L15:
        r114 = null;
        goto L16
    L39:
        return r103.toString();
    L40:
        LLog.e("TestBench", "Record file format error!");
        return SliceInitService.DEFAULT_SWITCH;
    }

    public LynxRecorderReplayDataModule(Context r100) {
        super(r100);
    }

    @LynxMethod
    public void getData(Callback r100) {
        JSONObject r101 = new JSONObject();
        r101.put("RecordData", getRecordData());     // Catch: JSONException -> L5
        r101.put("JsbIgnoredInfo", getJsbIgnoredInfo());     // Catch: JSONException -> L5
        r101.put("JsbSettings", getJsbSettings());     // Catch: JSONException -> L5
    L6:
        r100.invoke(new Object[]{r101.toString()});
        return;
    L5:
        LLog.e("TestBench", "Record file format error!");
        r100.invoke(new Object[]{SliceInitService.DEFAULT_SWITCH});
        goto L6
    }

    @LynxMethod
    public PiperData getSharedData(String r100) {
        HashMap r101 = new HashMap();
        JSONObject r102 = this.mSharedData;     // Catch: JSONException -> L7
        if (r102 == null) goto L8;
        Object r103 = r102.get(r100);     // Catch: JSONException -> L7
    L9:
        r101.put("value", r103);
        return new PiperData(r101, false);
    L8:
        r103 = null;
    L7:
        LLog.e("LynxRecorder", "SharedData with key: " + r100 + " not found!");
        goto L8
    }

    public LynxRecorderReplayDataModule(Context r100, Object r101) {
        super(r100);
        LynxRecorderReplayDataProvider r102 = (LynxRecorderReplayDataProvider) r101;
        this.mFunctionCall = r102.getFunctionCall();
        this.mCallbackData = r102.getCallbackData();
        this.mJsbIgnoredInfo = r102.getJsbIgnoredInfo();
        this.mJsbSettings = r102.getJsbSettings();
        this.mSharedData = r102.getSharedData();
    }
}
