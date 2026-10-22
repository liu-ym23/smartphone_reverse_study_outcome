package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.LLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxError extends a0 {
    public static final int JAVA_ERROR = -3;
    public static final int JS_ERROR = -2;
    public static final String LEVEL_ERROR = "error";
    public static final String LEVEL_WARN = "warn";
    static final String LYNX_ERROR_KEY_CONTEXT = "context";
    public static final String LYNX_ERROR_KEY_IMAGE_CATEGORIZED_CODE = "image_categorized_code";
    static final String LYNX_ERROR_KEY_PREFIX_CONTEXT = "lynx_context_";
    public static final String LYNX_ERROR_KEY_RESOURCE_TYPE = "type";
    public static final String LYNX_ERROR_KEY_RESOURCE_URL = "src";
    public static final String LYNX_ERROR_SUGGESTION_REF_OFFICIAL_SITE = "Please refer to the solution in Doc 'LynxError FAQ' on the official website.";
    public static final String LYNX_THROWABLE = "throwable";
    public static final int NATIVE_ERROR = -1;
    private static final String TAG = "LynxError";
    private JSONObject errorObj;
    private String mCallStack;
    private String mCardVersion;
    private List<LynxSubErrorCode$Consumer> mConsumers;
    private Map<String, Object> mCustomInfo;
    private int mErrorType;
    private String mFixSuggestion;
    private boolean mIsLogBoxOnly;
    private boolean mIsNewErrorCode;
    private String mJsonStringCache;
    private String mLevel;
    private String mRootCause;
    private int mSubCode;
    private String mSummaryMessage;
    private String mTemplateUrl;
    private JSONObject mUserDefineInfo;
    private String msg;

    private String generateJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put("error_code", getErrorCode());     // Catch: JSONException -> L10
        r100.put("sub_code", this.mSubCode);     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "url", this.mTemplateUrl);     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "error", this.mSummaryMessage);     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "card_version", this.mCardVersion);     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "sdk", LynxEnv.inst().getLynxVersion());     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "level", this.mLevel);     // Catch: JSONException -> L10
        r100.put("consumers", new JSONArray(this.mConsumers));     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "fix_suggestion", this.mFixSuggestion);     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "error_stack", this.mCallStack);     // Catch: JSONException -> L10
        putStringToJsonObject(r100, "root_cause", this.mRootCause);     // Catch: JSONException -> L10
        putMapValueToJsonObject(r100, this.mCustomInfo);     // Catch: JSONException -> L10
        JSONObject r101 = this.mUserDefineInfo;     // Catch: JSONException -> L10
        if (r101 != null) goto L6;
    L8:
        String r102 = r100.toString();     // Catch: JSONException -> L10
    L12:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L6:
        if (r101.length() <= 0) goto L8;
        r100.put("user_define_info", this.mUserDefineInfo);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        LLog.e(TAG, e.getMessage());
        r102 = null;
        goto L12
    }

    public Map<String, String> getContextInfo() {
        HashMap r100 = new HashMap();
        Map<String, Object> r101 = this.mCustomInfo;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, Object> r103 = r102.next();
        String r104 = r103.getKey();
        if (r104.startsWith(LYNX_ERROR_KEY_PREFIX_CONTEXT) == true) goto L10;
        if (r104.equals("src") == false) goto L7;
        r100.put(r104, r103.getValue().toString());
        goto L7
    L10:
        r100.put(r104.substring(13), r103.getValue().toString());
        goto L7
    L14:
        return r100;
    }

    public int getErrorCode() {
        if (this.mIsNewErrorCode == false) goto L7;
        return this.mSubCode / 100;
    L7:
        return this.mSubCode;
    }

    public String getFixSuggestion() {
        String r100 = this.mFixSuggestion;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getMsg() {
        if (TextUtils.isEmpty(this.mJsonStringCache) == true) goto L7;
        return this.mJsonStringCache;
    L7:
        if (TextUtils.isEmpty(this.mSummaryMessage) == true) goto L9;
        this.mJsonStringCache = generateJsonString();
    L15:
        String r100 = this.mJsonStringCache;
        if (r100 != null) goto L19;
        return "";
    L19:
        return r100;
    L9:
        JSONObject r101 = this.errorObj;
        if (r101 == null) goto L12;
        this.mJsonStringCache = r101.toString();
        goto L15
    L12:
        String r102 = this.msg;
        if (r102 == null) goto L15;
        this.mJsonStringCache = r102;
        goto L15
    }

    public String getRootCause() {
        String r100 = this.mRootCause;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getSummaryMessage() {
        String r100 = this.mSummaryMessage;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public boolean isFatal() {
        if (this.mLevel != LynxSubErrorCode$Level.FATAL.value) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.msg) == true) goto L5;
        return true;
    L5:
        if (this.errorObj == null) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(this.mSummaryMessage) == false) goto L14;
        return false;
    L14:
        return true;
    }

    public String toString() {
        return "{\"code\": " + getErrorCode() + ",\"msg\":" + getMsg() + com.alipay.sdk.m.u.i.f25855d;
    }

    public boolean isJSError() {
        int r100 = getErrorCode();
        if (r100 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 300) goto L7;
        return true;
    }

    public boolean isLepusError() {
        int r100 = getErrorCode();
        if (r100 >= 1100) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 1200) goto L7;
        return true;
    }

    public JSONObject getErrorObj() {
        return this.errorObj;
    }

    public String getLevel() {
        return this.mLevel;
    }

    public int getSubCode() {
        return this.mSubCode;
    }

    public int getType() {
        return this.mErrorType;
    }

    public boolean isLogBoxOnly() {
        return this.mIsLogBoxOnly;
    }

    public boolean containsCustomField(String r100) {
        if (this.mCustomInfo != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        return this.mCustomInfo.containsKey(r100);
    }

    public void setCallStack(String r100) {
        this.mJsonStringCache = null;
        this.mCallStack = r100;
    }

    public void setCardVersion(String r100) {
        this.mJsonStringCache = null;
        this.mCardVersion = r100;
    }

    public void setCustomInfo(Map<String, Object> r100) {
        this.mJsonStringCache = null;
        this.mCustomInfo = r100;
    }

    public void setLogBoxOnly(boolean r100) {
        this.mIsLogBoxOnly = r100;
    }

    public void setRootCause(String r100) {
        this.mJsonStringCache = null;
        this.mRootCause = r100;
    }

    public void setTemplateUrl(String r100) {
        this.mJsonStringCache = null;
        this.mTemplateUrl = r100;
    }

    public void setUserDefineInfo(JSONObject r100) {
        this.mJsonStringCache = null;
        this.mUserDefineInfo = r100;
    }

    public LynxError(String r100, int r101) {
        this.mIsLogBoxOnly = false;
        this.mIsNewErrorCode = false;
        this.mSubCode = r101;
        this.msg = r100;
    }

    public static void putMapValueToJsonObject(JSONObject r100, Map<String, Object> r101) throws JSONException {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isEmpty() == true) goto L25;
        if (r100 == null) goto L27;
        JSONObject r102 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, Object> r104 = r103.next();
        if (r104.getKey().startsWith(LYNX_ERROR_KEY_PREFIX_CONTEXT) == true) goto L12;
        r100.put(r104.getKey(), r104.getValue());
        goto L9
    L12:
        r102.put(r104.getKey(), r104.getValue());
        goto L9
    L15:
        if (r102.length() <= 0) goto L26;
        r100.put("context", r102);
        return;
    L26:
        return;
    L27:
        return;
    }

    public void addCustomInfo(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        this.mJsonStringCache = null;
        if (this.mCustomInfo != null) goto L10;
        this.mCustomInfo = new HashMap();
    L10:
        this.mCustomInfo.put(r100, r101);
        return;
    }

    public LynxError(int r100, String r101) {
        this(r100, r101, "", LynxSubErrorCode$Level.ERROR.value);
    }

    public static void putStringToJsonObject(JSONObject r100, String r101, String r102) throws JSONException {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r100.put(r101, r102);
        return;
    }

    public LynxError(int r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, -3);
    }

    public LynxError(int r100, String r101, String r110, String r111, int r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public LynxError(int r100, String r110, String r111, String r112, int r113, Map<String, Object> r114) {
        this(r100, r110, r111, r112, r113, r114, false);
    }

    private static LynxError createLynxError(int r100, String r110, String r111, String r112, JavaOnlyMap r113, boolean r114) {
        return new LynxError(r100, r110, r111, r112, -1, r113, r114);
    }

    public LynxError(int r100, String r101, String r102, String r103, int r104, Map<String, Object> r105, boolean r106) {
        this.mIsNewErrorCode = false;
        this.msg = "";
        this.mSubCode = r100;
        this.mSummaryMessage = r101;
        this.mErrorType = r104;
        this.mCustomInfo = r105;
        this.mIsLogBoxOnly = r106;
        if (r100 != 0) goto L5;
    L127:
        x0 r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
    L128:
        if (r107 == null) goto L137;
        LynxSubErrorCode$Level r108 = r107.f384108a;
        if (r108 == LynxSubErrorCode$Level.UNDECIDED) goto L132;
        r103 = r108.value;
    L132:
        this.mLevel = r103;
        if (r107.f384109b.isEmpty() == true) goto L136;
        r102 = r107.f384109b;
    L136:
        this.mFixSuggestion = r102;
        this.mConsumers = r107.f384110c;
        this.mIsNewErrorCode = true;
        return;
    L137:
        this.mLevel = r103;
        this.mFixSuggestion = r102;
        this.mConsumers = Collections.emptyList();
        return;
    L5:
        if (r100 != 30301) goto L7;
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the url of the external resource is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L7:
        if (r100 == 30302) goto L125;
        if (r100 == 0) goto L127;
        switch(r100) {
            case 0: goto L127;
            case 10299: goto L124;
            case 10501: goto L123;
            case 10701: goto L122;
            case 20201: goto L121;
            case 20301: goto L120;
            case 20401: goto L119;
            case 30196: goto L118;
            case 30400: goto L117;
            case 39800: goto L116;
            case 39900: goto L115;
            case 40199: goto L114;
            case 50201: goto L113;
            case 60100: goto L112;
            case 60201: goto L111;
            case 60301: goto L110;
            case 60401: goto L109;
            case 90801: goto L108;
            case 99800: goto L107;
            case 99900: goto L106;
            case 109900: goto L105;
            case 110100: goto L104;
            case 130300: goto L103;
            case 140201: goto L102;
            case 140401: goto L101;
            case 190100: goto L100;
            case 190200: goto L99;
            case 190300: goto L98;
            case 200101: goto L97;
            case 220101: goto L96;
            case 220301: goto L95;
            case 229800: goto L94;
            case 990100: goto L93;
            case 990200: goto L92;
            default: goto L12;
        };
    L92:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L93:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L94:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L95:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This may be due to platform-specific limitations or system restrictions. If blur-radius is not supported on this platform, consider using CSS filter: blur() as an alternative.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L96:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L97:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L98:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Make sure you have imported worklet file correctly.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L99:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Calling requestAnimationFrame failed. This is usually caused by an error in the callback function. Please ensure that the callback function executes without errors.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L100:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L101:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "The used app bundle and injected data to hydrate the SSR page should be the same as ones used to render on the server side", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L102:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L103:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please use values following the property definitions. You can get the definitions at the official website.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L104:
        r107 = new x0(LynxSubErrorCode$Level.UNDECIDED, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L105:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This error is caught by the Lynx Engine. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.LYNX}));
        goto L128
    L106:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This error indicates an unhandled runtime exception within the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L107:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This error is explicitly defined by the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L108:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Check if the server's response body is correct; Check if client unexpectedly consumes http response body using network request interceptor; You can use request's url and log id to track down the problem.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L109:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This is an internal error of Lynx, which usually occurs when multiple threads access ShadowNode at the same time.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L110:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This is an internal error of Lynx. LynxUI has not been created or the creation failed while updating.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L111:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Infinite loop of layout happens. It usually happens when the front-end decides the content size based on the viewport size, while the client is deciding the viewport size based on the content size.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L112:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Lynx internal error. Please check whether the creating of corresponding ShadowNode failed", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L113:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L114:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L115:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L116:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L117:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L118:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please investigate the corresponding image download workflow for potential issues.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L119:
        r107 = new x0(LynxSubErrorCode$Level.WARN, "Please throttle related calls.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L120:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please see error info.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L121:
        r107 = new x0(LynxSubErrorCode$Level.WARN, "Please throttle related calls.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L122:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please check if the app bundle has been signed correctly", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L123:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please `loadTemplate` before `reloadTemplate`", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L124:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L12:
        switch(r100) {
            case 90101: goto L91;
            case 90102: goto L90;
            case 90103: goto L89;
            case 90104: goto L88;
            case 90105: goto L87;
            case 90106: goto L86;
            case 90107: goto L85;
            case 90108: goto L84;
            default: goto L13;
        };
    L13:
        switch(r100) {
            case 120201: goto L83;
            case 120202: goto L82;
            default: goto L14;
        };
    L14:
        switch(r100) {
            case 130100: goto L81;
            case 130101: goto L80;
            case 130102: goto L79;
            default: goto L15;
        };
    L15:
        switch(r100) {
            case 130201: goto L78;
            case 130202: goto L77;
            case 130203: goto L76;
            default: goto L16;
        };
    L16:
        switch(r100) {
            case 140100: goto L75;
            case 140101: goto L74;
            case 140102: goto L73;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 160101: goto L72;
            case 160102: goto L71;
            case 160103: goto L70;
            case 160104: goto L69;
            default: goto L19;
        };
    L69:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the error message of the bundle", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L70:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the lazy bundle file is broken or it is compatible with the host page", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L71:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the lazy bundle file is empty", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L72:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the url of the lazy bundle is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L19:
        switch(r100) {
            case 220201: goto L68;
            case 220202: goto L67;
            case 220203: goto L66;
            case 220204: goto L65;
            case 220205: goto L64;
            case 220206: goto L63;
            case 220207: goto L62;
            case 220208: goto L61;
            case 220209: goto L60;
            default: goto L20;
        };
    L20:
        switch(r100) {
            case 10201: goto L34;
            case 10202: goto L33;
            case 10203: goto L32;
            case 10204: goto L31;
            case 10205: goto L30;
            default: goto L22;
        };
    L30:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please check the error message of the bundle.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L31:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please check that 1. the provided bundle is an app bundle, 2. the engine version of the bundle is compatible with that of Lynx engine, 3. the bundle file is not broken.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L32:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please check if the app bundle is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L33:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please call the initialization method of LynxEnv before loadTemplate.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L34:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Should not call `loadTemplate` while the rendering pipeline of app bundle has not finished", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L22:
        switch(r100) {
            case 20100: goto L39;
            case 20101: goto L38;
            case 20102: goto L37;
            case 20103: goto L36;
            case 20104: goto L35;
            default: goto L23;
        };
    L23:
        switch(r100) {
            case 30101: goto L42;
            case 30102: goto L41;
            case 30103: goto L40;
            default: goto L24;
        };
    L24:
        switch(r100) {
            case 30199: goto L49;
            case 30200: goto L48;
            case 30201: goto L47;
            case 30202: goto L46;
            case 30203: goto L45;
            case 30204: goto L44;
            case 30205: goto L43;
            default: goto L25;
        };
    L25:
        switch(r100) {
            case 32101: goto L53;
            case 32102: goto L52;
            case 32103: goto L51;
            case 32104: goto L50;
            default: goto L26;
        };
    L26:
        switch(r100) {
            case 40101: goto L55;
            case 40102: goto L54;
            default: goto L27;
        };
    L27:
        switch(r100) {
            case 50101: goto L57;
            case 50102: goto L56;
            default: goto L28;
        };
    L28:
        switch(r100) {
            case 111101: goto L59;
            case 111102: goto L58;
            default: goto L29;
        };
    L29:
        r107 = null;
        goto L128
    L58:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L59:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L56:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L57:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L54:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Target string data should be enabled to be parsed into a table.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L55:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Should not call `getDerivedStateFromProps`, `getDerivedStateFromError`, `shouldComponentUpdate` as data processor.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L50:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the network status or increase the timeout value.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L51:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please refer to the official documentation to implement the ILynxResourceService and integrate it into your app.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L52:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please refer to the official documentation to integrate LynxImageService into your app.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L53:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please refer to the parameter descriptions of this API in documentation and check the parameters used in the call.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L43:
        r107 = new x0(LynxSubErrorCode$Level.UNDECIDED, "If the font is displayed correctly, there is no need to deal with it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L44:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please use a font file in ttf or otf format.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L45:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the base64 resource is available.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L46:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether font resource is available.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L47:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the font-face format.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L48:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L49:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "An unidentified exception occurred that cannot be attributed to a specific cause. Please investigate further based on the available details.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L40:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "In most cases, the issue arises from a canceled image request or an unavailable network connection.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L41:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Possibly due to an unsupported image format or a corrupted file. Please verify the integrity of the image file.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L42:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please resize the image to appropriate dimensions or enable downsampling.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L35:
        r107 = new x0(LynxSubErrorCode$Level.WARN, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L36:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the error message and fix binding API call.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L37:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L38:
        r107 = new x0(LynxSubErrorCode$Level.FATAL, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L39:
        r107 = new x0(LynxSubErrorCode$Level.UNDECIDED, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L60:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "For parameter usage, please check documentation of list component.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L61:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the legality of the item-key.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L62:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please set the attribute enable-async-list of <list /> to true.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L63:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "The internal state of the engine has become inconsistent.  Please file an issue to Lynx for help resolving this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L64:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "For parameter usage, please check documentation of list component.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L65:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please do not change the value of `vertical-orientation` dynamically.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L66:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L67:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L68:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the legality of the item-key.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L73:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Check the syntax of the script which is attached with SSR data.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L74:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please limit the client version to the ones that support the SSR data sent from the server side.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L75:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check if the data used to render the page is the same data generated from the SSR server runtime. Or check if SSR is correctly implemented.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L76:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Remove property name from inheritance list.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L77:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L78:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L79:
        r107 = new x0(LynxSubErrorCode$Level.UNDECIDED, "Please check your value for the property follow the detailed message.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L80:
        r107 = new x0(LynxSubErrorCode$Level.UNDECIDED, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L81:
        r107 = new x0(LynxSubErrorCode$Level.UNDECIDED, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L82:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L83:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L84:
        r107 = new x0(LynxSubErrorCode$Level.WARN, "Please migrate deprecated api as soon as possible.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L85:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L86:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L87:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L88:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please verify that the parameter types in the method call exactly match the native module implementation. Ensure type compatibility across all parameters and validate the parameter order corresponds to the native method signature. You can check the native module documentation for expected data types.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L89:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please ensure that the number of parameters passed to the native method exactly matches the declared parameters in the native module implementation.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L90:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please verify proper method registration using platform-specific annotations on Android or static method declarations on iOS (For details, refer to the native module documentation). Additionally, ensure that the invoked method name exactly matches the registered name in the native module implementation.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L91:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please verify that the invoked native module name matches the registered name and confirm module registration status.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L125:
        r107 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the local external resource is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    }
}
