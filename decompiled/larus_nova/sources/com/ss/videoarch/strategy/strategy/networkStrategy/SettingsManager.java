package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.text.TextUtils;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.CharacterConfig;
import com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.LSStrategySDKSettings;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class SettingsManager {
    static final String TAG = "VeLSSettingsManager";
    private Map<String, List<StrategyConfigUpdateCallBack>> mCallBackMap;

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LSToggles {
        public int mBasePostRequestInterval;
        public String mClientInfos;
        public String mCommonConfigJSON;
        public String mDomainInfos;
        public boolean mEnableSelectNode;
        public String mFeatureConfigJSON;
        public String mNodeInfos;
        public String mProjectSettings;
        public String mRequestId;
        public String mSettings;
        public String mStrategyConfigJSON;
        public String mUidFeatureJSON;

        public LSToggles() {
            this.mBasePostRequestInterval = 300;
            this.mEnableSelectNode = false;
            this.mDomainInfos = "";
            this.mRequestId = "";
            this.mNodeInfos = null;
            this.mSettings = "";
            this.mClientInfos = "";
            this.mProjectSettings = "";
            this.mStrategyConfigJSON = "";
            this.mFeatureConfigJSON = "";
            this.mCommonConfigJSON = "";
            this.mUidFeatureJSON = "";
        }
    }

    public class ResponseData {
        public int responseCost;
        public String responseJsonStr;
        public int statusCode;
        final /* synthetic */ SettingsManager this$0;

        public ResponseData(SettingsManager r100) {
            this.this$0 = r100;
            this.responseJsonStr = "";
        }
    }

    public static class SettingsManagerInstance {
        private static final SettingsManager mInstance = null;

        private SettingsManagerInstance() {
        }

        static {
            mInstance = new SettingsManager(null);
        }

        public static /* synthetic */ SettingsManager access$100() {
            return mInstance;
        }
    }

    public interface StrategyConfigUpdateCallBack {
        void onConfigUpdated(String r100);
    }

    private native boolean nativeGetCharacterConfig(String r100, String r101, CharacterConfig r102);

    private native boolean nativeGetLSSettings(String r100, LSToggles r101);

    private native String nativeGetStrategyConfigByName(String r100, String r101);

    private native LSStrategySDKSettings nativeGetStrategySDKSettings(String r100, LSStrategySDKSettings r101);

    private native void nativeLoadDB();

    private native void nativeRegisterStrategyConfigUpdate(String r100);

    private native void nativeSendRequest(String r100, ResponseData r101);

    private native void nativeSetSDKParams(String r100);

    private SettingsManager() {
        this.mCallBackMap = new HashMap();
    }

    public static SettingsManager getInstance() {
        return SettingsManagerInstance.access$100();
    }

    public void loadDB() {
        if (LSSettings.inst().mEnableDataWarehouse == 1) goto L5;
        return;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L9;
        nativeLoadDB();
        return;
    }

    public /* synthetic */ SettingsManager(AnonymousClass1 r100) {
        this();
    }

    public void SetSDKParams(String r100) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L6;
        return;
    L6:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableSetSDKParams == 1) goto L8;
        return;
    L8:
        nativeSetSDKParams(r100);
    }

    public void UpdateSettingsFromNative(JSONObject r100) {
        if (r100 == null) goto L5;
        LSSettings.inst().updateSettingsFromNative(r100);
        return;
    }

    public ResponseData sendRequest(String r100) {
        ResponseData r101 = new ResponseData(this);
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return r101;
    L5:
        nativeSendRequest(r100, r101);
        r101.responseJsonStr.length();
        return r101;
    }

    public boolean getFeatureConfig(String r100, FeatureConfigInfo r101) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return false;
    L5:
        String r102 = r101.mFeatureTypeName;
        CharacterConfig r103 = new CharacterConfig();
        if (nativeGetCharacterConfig(r100, r101.mFeatureTypeName, r103) == true) goto L24;
    L23:
        return false;
    L24:
    L21:
        e = move-exception;
        e.toString();
        goto L23
    L8:
        if (r103.mFeaturesList.isEmpty() == false) goto L10;
        JSONArray r104 = r101.mFeaturesList;     // Catch: JSONException -> L21
    L11:
        r101.mFeaturesList = r104;     // Catch: JSONException -> L21
        if (r103.mRTFeaturesList.isEmpty() == true) goto L15;
        JSONArray r105 = new JSONArray(r103.mRTFeaturesList);     // Catch: JSONException -> L21
        r101.mRTFeaturesList = r105;     // Catch: JSONException -> L21
        r101.mRTFeaturesStr = r105.toString();     // Catch: JSONException -> L21
    L15:
        if (TextUtils.isEmpty(r103.mFeaturesCollectRules) == false) goto L17;
        JSONObject r106 = r101.mFeaturesCollectRules;     // Catch: JSONException -> L21
    L18:
        r101.mFeaturesCollectRules = r106;     // Catch: JSONException -> L21
        return true;
    L17:
        r106 = new JSONObject(r103.mFeaturesCollectRules);     // Catch: JSONException -> L21
        goto L18
    L10:
        r104 = new JSONArray(r103.mFeaturesList);     // Catch: JSONException -> L21
        goto L11
    }

    public String getStrategyConfigByName(String r100, String r101) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return "";
    L7:
        return nativeGetStrategyConfigByName(r100, r101);
    }

    public LSStrategySDKSettings getStrategySDKSettings(String r100, LSStrategySDKSettings r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        return r101;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L9;
        return nativeGetStrategySDKSettings(r100, r101);
    }

    public boolean initLSSettings(String r100, LSSettings r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L51:
        return false;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L51;
        LSToggles r102 = new LSToggles();
        if (nativeGetLSSettings(r100, r102) == false) goto L51;
        r101.mBasePostRequestInterval = r102.mBasePostRequestInterval;
        r101.mEnableSelectNode = r102.mEnableSelectNode;
        r101.mRequestId = r102.mRequestId;
    L49:
        e = move-exception;
        e.toString();
        goto L51
    L11:
        if (TextUtils.isEmpty(r102.mDomainInfos) == false) goto L13;
        JSONArray r103 = r101.mDomianInfos;     // Catch: JSONException -> L49
    L14:
        r101.mDomianInfos = r103;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mNodeInfos) == false) goto L17;
        JSONObject r104 = r101.mNodeInfos;     // Catch: JSONException -> L49
    L18:
        r101.mNodeInfos = r104;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mSettings) == false) goto L21;
        JSONObject r105 = r101.mSettings;     // Catch: JSONException -> L49
    L22:
        r101.mSettings = r105;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mClientInfos) == false) goto L25;
        JSONObject r106 = r101.mClientInfos;     // Catch: JSONException -> L49
    L26:
        r101.mClientInfos = r106;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mProjectSettings) == false) goto L29;
        JSONObject r107 = r101.mProjectSettings;     // Catch: JSONException -> L49
    L30:
        r101.mProjectSettings = r107;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mStrategyConfigJSON) == false) goto L33;
        JSONObject r108 = r101.mStrategyConfigJSON;     // Catch: JSONException -> L49
    L34:
        r101.mStrategyConfigJSON = r108;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mFeatureConfigJSON) == false) goto L37;
        JSONObject r109 = r101.mFeatureConfigJSON;     // Catch: JSONException -> L49
    L38:
        r101.mFeatureConfigJSON = r109;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mCommonConfigJSON) == false) goto L41;
        JSONObject r110 = r101.mCommonConfigJSON;     // Catch: JSONException -> L49
    L42:
        r101.mCommonConfigJSON = r110;     // Catch: JSONException -> L49
        if (TextUtils.isEmpty(r102.mUidFeatureJSON) == false) goto L45;
        JSONObject r111 = r101.mUidFeatureJSON;     // Catch: JSONException -> L49
    L46:
        r101.mUidFeatureJSON = r111;     // Catch: JSONException -> L49
        return true;
    L45:
        r111 = new JSONObject(r102.mUidFeatureJSON);     // Catch: JSONException -> L49
        goto L46
    L41:
        r110 = new JSONObject(r102.mCommonConfigJSON);     // Catch: JSONException -> L49
        goto L42
    L37:
        r109 = new JSONObject(r102.mFeatureConfigJSON);     // Catch: JSONException -> L49
        goto L38
    L33:
        r108 = new JSONObject(r102.mStrategyConfigJSON);     // Catch: JSONException -> L49
        goto L34
    L29:
        r107 = new JSONObject(r102.mProjectSettings);     // Catch: JSONException -> L49
        goto L30
    L25:
        r106 = new JSONObject(r102.mClientInfos);     // Catch: JSONException -> L49
        goto L26
    L21:
        r105 = new JSONObject(r102.mSettings);     // Catch: JSONException -> L49
        goto L22
    L17:
        r104 = new JSONObject(r102.mNodeInfos);     // Catch: JSONException -> L49
        goto L18
    L13:
        r103 = new JSONArray(r102.mDomainInfos);     // Catch: JSONException -> L49
        goto L14
    }

    public void onConfigUpdate(String r100, String r101) {
        if (this.mCallBackMap.containsKey(r100) == false) goto L13;
        List<StrategyConfigUpdateCallBack> r102 = this.mCallBackMap.get(r100);
        if (r102 != null) goto L7;
        return;
    L7:
        Iterator<StrategyConfigUpdateCallBack> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L19;
        StrategyConfigUpdateCallBack r104 = r103.next();
        if (r104 == null) goto L9;
        r104.onConfigUpdated(r101);
        goto L9
    L19:
        return;
    }

    public void registerStrategyConfigUpdate(String r100, StrategyConfigUpdateCallBack r101) {
        if (this.mCallBackMap.containsKey(r100) == false) goto L5;
        List<StrategyConfigUpdateCallBack> r102 = this.mCallBackMap.get(r100);
        Objects.requireNonNull(r102);
        r102.add(r101);
    L7:
        if (VeLSUtils.isLoadSoSuccess() == true) goto L9;
        return;
    L9:
        nativeRegisterStrategyConfigUpdate(r100);
        return;
    L5:
        ArrayList r103 = new ArrayList();
        r103.add(r101);
        this.mCallBackMap.put(r100, r103);
        goto L7
    }
}
