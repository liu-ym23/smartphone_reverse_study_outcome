package com.ss.android.bytedcert.flow.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.nfc.NfcManager;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.bytedcert.config.ICnNetIdService;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.cvlibrary.FaceLiveness;
import com.ss.android.bytedcert.dialog.LoadingDialog;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.manager.AutoTestManager;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.BytedCertSdkInitParam;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import com.ss.android.cert.manager.ablity.IExceptionCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.net.BCNetworkUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import osa.b;
import psa.a;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbsCertFlow implements ICertFlow, BCNetworkUtils.NetworkEventProcessor {
    private static volatile boolean startup;
    protected final b mCertInfo;
    protected String mFlowId;
    protected String mLanguage;
    private final a mRequestUtils;
    private Resources mResources;
    protected ThemeConfig themeConfig;

    @Override // com.ss.android.bytedcert.flow.base.ICertFlow
    public ThemeConfig getThemeConfig() {
        ThemeConfig r100 = this.themeConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return BytedCertManager.getInstance().getThemeConfig();
    }

    public AbsCertFlow() {
        this.mCertInfo = new b();
        this.mRequestUtils = new a(this);
    }

    public boolean isSupportCnNetAuth() {
        BytedCertSdkInitParam.CnNetAuthParams r100 = BytedCertSdkManager.getInstance().getCnNetAuthParams();
        ICnNetIdService r101 = BytedCertManager.getInstance().getCnNetIdService();
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public b getCertInfo() {
        return this.mCertInfo;
    }

    public String getFlowId() {
        return this.mFlowId;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public a getRequestUtils() {
        return this.mRequestUtils;
    }

    public boolean isBytedCertFlow() {
        return this instanceof BytedCertFlow;
    }

    public static /* synthetic */ boolean access$002(boolean r100) {
        startup = r100;
        return r100;
    }

    private void initError(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Context r101 = r100.getApplicationContext();
        ErrorConstant.Client.ERROR_NETWORK_ERROR = new Pair(-1000, getMultiLanguageString(r101, R.string.byted_error_network_error));
        ErrorConstant.Client.ERROR_UNKNOWN = new Pair(-1001, getMultiLanguageString(r101, R.string.byted_error_unknown));
        ErrorConstant.Client.ERROR_FACE_LIVE_INTERRUPT = new Pair(-1002, getMultiLanguageString(r101, R.string.byted_error_network_error));
        ErrorConstant.Client.ERROR_FACE_LIVE_FAIL = new Pair(-1003, getMultiLanguageString(r101, R.string.byted_error_face_live_fail));
        ErrorConstant.Client.ERROR_ALGORITHM_INIT_FAIL = new Pair(-1004, getMultiLanguageString(r101, R.string.byted_error_network_error));
        ErrorConstant.Client.ERROR_ALGORITHM_PARAMS_FAIL = new Pair(-1005, getMultiLanguageString(r101, R.string.byted_error_network_error));
        ErrorConstant.Client.ERROR_FACE_LIVE_RETURN = new Pair(-1006, getMultiLanguageString(r101, R.string.byted_error_user_cancel));
        ErrorConstant.Client.ERROR_USER_CANCEL = new Pair(-1007, getMultiLanguageString(r101, R.string.byted_error_user_cancel));
        ErrorConstant.Client.ERROR_VIDEO_RECORD_NO_FACE = new Pair(-1009, getMultiLanguageString(r101, R.string.byted_detect_no_face));
        ErrorConstant.Client.ERROR_PERMISSION_ERROR = new Pair(-3000, getMultiLanguageString(r101, R.string.byted_error_permission_error));
        ErrorConstant.Client.ERROR_JSON_PARSING = new Pair(-3001, getMultiLanguageString(r101, R.string.byted_error_network_error));
        ErrorConstant.Client.ERROR_MULTI_WINDOW = new Pair(-3002, getMultiLanguageString(r101, R.string.byted_error_multi_window));
        ErrorConstant.Client.ERROR_CAMERA_UN_SUPPORT = new Pair(-3003, getMultiLanguageString(r101, R.string.byted_error_permission_error));
        ErrorConstant.Client.ERROR_SET_TASK_FAIL = new Pair(-3004, getMultiLanguageString(r101, R.string.byted_error_network_error));
        ErrorConstant.Client.ERROR_PICK_PHOTO_ERROR = new Pair(-3006, getMultiLanguageString(r101, R.string.byted_error_pick_photo_error));
        ErrorConstant.Client.ERROR_TAKE_PHOTO_ERROR = new Pair(-3007, getMultiLanguageString(r101, R.string.byted_error_take_photo_error));
        ErrorConstant.Client.ERROR_CERT_IS_START = new Pair(-4003, getMultiLanguageString(r101, R.string.byted_error_cert_is_start));
    }

    public Map<String, String> appendCommonRequestParams(Map<String, String> r100) {
        if (r100 != null) goto L5;
        r100 = new HashMap();
    L5:
        if (TextUtils.isEmpty(this.mCertInfo.f526567a) == true) goto L8;
        r100.put("scene", this.mCertInfo.f526567a);
    L8:
        if (TextUtils.isEmpty(this.mCertInfo.f526568b) == true) goto L11;
        r100.put("ticket", this.mCertInfo.f526568b);
    L11:
        if (TextUtils.isEmpty(this.mCertInfo.f526569c) == true) goto L14;
        r100.put("mode", this.mCertInfo.f526569c);
    L14:
        if (TextUtils.isEmpty(this.mCertInfo.f526573g) == true) goto L17;
        r100.put("cert_app_id", this.mCertInfo.f526573g);
    L17:
        if (TextUtils.isEmpty(this.mCertInfo.f526570d) == true) goto L19;
        r100.put(BytedCertConstant.CertKey.FLOW, this.mCertInfo.f526570d);
    L19:
        Map<String, String> r101 = this.mCertInfo.f526578l;
        if (r101 == null) goto L23;
        r100.putAll(r101);
    L23:
        if (TextUtils.isEmpty(this.mLanguage) == true) goto L26;
        r100.put("byted_cert_language", this.mLanguage);
    L26:
        if (BytedCertSdkManager.getInstance().withFaceDetect() == false) goto L30;
        r100.put(BytedCertConstant.CertKey.ALGO_ACTION_VERSION, "3.0");
        if (hsa.a.isLoadSuccess() == false) goto L30;
        r100.put("smash_live_model_name", FaceLiveness.native_FL_GetModelName());
        r100.put("smash_sdk_version", FaceLiveness.native_FL_GetSdkVersion());
    L30:
        return r100;
    }

    public JSONObject appendEventParams(JSONObject r100) {
        return appendEventParams(r100, false);
    }

    public <P extends CertParams<?>> ICertLoadingDialog createCertLoadingDialog(P r100) {
        if (r100.isShowLoading() == false) goto L19;
        ICertDialogDepend r101 = r100.getCertDialogDepend();
        if (r101 != null) goto L18;
        r101 = BytedCertSdkManager.getInstance().getCertDialogDepend();
    L18:
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L8:
        if ((r100.getContext() instanceof Activity) == false) goto L20;
        String r102 = getMultiLanguageString(r100.getContext().getApplicationContext(), R.string.byted_loading_text);     // Catch: Exception -> L15
        if (r101 == null) goto L13;
        ICertLoadingDialog r103 = r101.showLoading(r100.getContext(), r102);     // Catch: Exception -> L15
    L21:
        return r103;
    L13:
        r103 = LoadingDialog.create((Activity) r100.getContext(), r102);     // Catch: Exception -> L15
        goto L21
    L20:
        return null;
    L19:
        return null;
    }

    public JSONObject getTimestampMap(String r100) {
        b r101 = this.mCertInfo;
        r101.getClass();
        int r102 = r100.hashCode();     // Catch: Exception -> L21
        if (r102 == (-312865764)) goto L12;
        if (r102 == 649330421) goto L9;
    L14:
        byte r103 = -1;
    L15:
        if (r103 == 0) goto L27;
        if (r103 == 1) goto L26;
    L24:
        return new JSONObject();
    L26:
        return new JSONObject(r101.f526586t);
    L27:
        return new JSONObject(r101.f526585s);
    L9:
        if (r100.equals(EventConstant.Key.FULL_FLOW_TIMESTAMP) == false) goto L14;
        r103 = 0;
        goto L15
    L12:
        if (r100.equals(EventConstant.Key.FACE_DETECT_TIMESTAMP) == false) goto L14;
        r103 = 1;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public BDResponse initCheck(Context r100) {
        EventLogUtils.module = "";
        EventLogUtils.lastModule = "";
        BytedCertManager.getInstance().reportSecScene(getCertInfo().f526573g);
        initError(r100);
        if (CertManager.getInstance().getMonitor() != null) goto L7;
        return new BDResponse(ErrorConstant.Client.ERROR_CERT_MONITOR_CONFIG);
    L7:
        if (CertManager.getInstance().getNetWork() != null) goto L11;
        return new BDResponse(ErrorConstant.Client.ERROR_SDK_INERT_NET_FAILED);
    L11:
        if (BytedCertSdkManager.getInstance().withFaceDetect() == true) goto L13;
        return null;
    L13:
        if (hsa.a.isLoadSuccess() == true) goto L25;
        JSONObject r101 = new JSONObject();
        r101.put(EventConstant.Key.EXCEPTION_STACK_TRACE, hsa.a.getFailedReason());     // Catch: JSONException -> L17
        r101.put("exception_msg", "smash so load failed");     // Catch: JSONException -> L17
        r101.put("error_code", ErrorConstant.Client.ERROR_LOAD_LIB);     // Catch: JSONException -> L17
    L19:
        onEvent(EventConstant.Event.SDK_EXCEPTION, r101);
        return new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_INIT_FAIL);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return null;
    }

    public boolean isSupportedNFC(Context r100) {
        if (r100 == null) goto L8;
        NfcManager r101 = (NfcManager) r100.getSystemService("nfc");
        if (r101 == null) goto L8;
        if (r101.getDefaultAdapter() == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void parseJSONToCertInfo(BDResponse r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.success == false) goto L21;
        JSONObject r101 = r100.jsonData;
        if (r101 == null) goto L22;
        String r102 = r101.optString(BytedCertConstant.WebInfo.ENTRY_PAGE_ADDRESS);
        String r103 = r101.optString("ticket");
        b r104 = this.mCertInfo;
        r104.f526581o = r101.optInt("video_record_policy");
        b r105 = this.mCertInfo;
        r105.f526576j = r101.optBoolean(BytedCertConstant.CertKey.USE_SYSTEM_V2);
        b r106 = this.mCertInfo;
        r106.f526583q = r101.optString("backend_auth_version");
        b r107 = this.mCertInfo;
        r107.f526582p = r101.optBoolean(BytedCertConstant.CertKey.SHOW_PROTECT_FACE_LOGO);
        if (r101.has(BytedCertConstant.CertKey.VERIFY_CHANNEL) == false) goto L11;
        b r108 = this.mCertInfo;
        r108.f526580n = r101.optString(BytedCertConstant.CertKey.VERIFY_CHANNEL);
    L11:
        if (r101.has(BytedCertConstant.CertKey.FLOW) == false) goto L14;
        b r109 = this.mCertInfo;
        r109.f526570d = r101.optString(BytedCertConstant.CertKey.FLOW);
    L17:
        if (TextUtils.isEmpty(r103) == true) goto L23;
        this.mCertInfo.f526568b = r103;
        return;
    L23:
        return;
    L14:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        Uri r110 = UriProtector.parse(r102);
        b r111 = this.mCertInfo;
        r111.f526570d = UriProtector.getQueryParameter(r110, BytedCertConstant.CertKey.FLOW);
        goto L17
    L22:
        return;
    }

    public void setStartTimestamp(String r100) {
        b r101 = this.mCertInfo;
        r101.getClass();
        r100.getClass();
        if (r100.equals(EventConstant.Key.FACE_DETECT_TIMESTAMP) == false) goto L5;
        Map<String, String> r102 = r101.f526586t;
        HashMap r103 = (HashMap) r102;
        r103.put(BytedCertConstant.KeyTimestamp.FACE_DETECT_OPEN, String.valueOf(System.currentTimeMillis()));
        return;
    L5:
        if (r100.equals(EventConstant.Key.FULL_FLOW_TIMESTAMP) == false) goto L11;
        Map<String, String> r104 = r101.f526585s;
        HashMap r105 = (HashMap) r104;
        r105.put(BytedCertConstant.KeyTimestamp.FLOW_START, String.valueOf(System.currentTimeMillis()));
        return;
    }

    public <P extends CertParams<?>> boolean start(P r110) {
        if (r110 != null) goto L6;
        return false;
    L6:
        if (startup == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(this.mFlowId) == false) goto L15;
        String r100 = UUID.randomUUID().toString();
    L12:
        if (BytedCertManager.getInstance().getFlowMap().containsKey(r100) == false) goto L14;
        r100 = UUID.randomUUID().toString();
        goto L12
    L14:
        BytedCertManager.getInstance().getFlowMap().put(r100, this);
        this.mFlowId = r100;
    L15:
        startup = true;
        BytedCertManager.getInstance().getHandler().postDelayed(new AnonymousClass1(this), 500);
        b r101 = this.mCertInfo;
        Map<String, String> r102 = r110.getCertInfo();
        r101.getClass();
        if (r102 == null) goto L269;
        Iterator<String> r103 = r102.keySet().iterator();
    L19:
        if (r103.hasNext() == false) goto L269;
        String r104 = r103.next();
        String r105 = r102.get(r104);
        r104.getClass();
        switch(r104.hashCode()) {
            case -1875568701: goto L148;
            case -1868653684: goto L144;
            case -1750590409: goto L140;
            case -1592415216: goto L136;
            case -1423007668: goto L132;
            case -1411074055: goto L128;
            case -1380325337: goto L124;
            case -1307473424: goto L120;
            case -1281392976: goto L116;
            case -1104629723: goto L112;
            case -1085033299: goto L108;
            case -873960692: goto L104;
            case -841106227: goto L100;
            case -685906904: goto L96;
            case -377954509: goto L92;
            case -168253766: goto L88;
            case 96572: goto L84;
            case 3146030: goto L80;
            case 3357091: goto L76;
            case 3701952: goto L72;
            case 96965648: goto L68;
            case 109254796: goto L64;
            case 132199606: goto L60;
            case 159702686: goto L56;
            case 562019534: goto L52;
            case 562334060: goto L48;
            case 606905102: goto L44;
            case 1125349443: goto L40;
            case 1416352755: goto L36;
            case 1531001460: goto L32;
            case 1601187122: goto L28;
            case 1852198397: goto L24;
            default: goto L151;
        };
    L151:
        byte r106 = -1;
    L153:
        switch(r106) {
            case 0: goto L256;
            case 1: goto L251;
            case 2: goto L244;
            case 3: goto L242;
            case 4: goto L241;
            case 5: goto L239;
            case 6: goto L237;
            case 7: goto L233;
            case 8: goto L232;
            case 9: goto L225;
            case 10: goto L220;
            case 11: goto L219;
            case 12: goto L212;
            case 13: goto L210;
            case 14: goto L203;
            case 15: goto L201;
            case 16: goto L239;
            case 17: goto L200;
            case 18: goto L199;
            case 19: goto L195;
            case 20: goto L195;
            case 21: goto L194;
            case 22: goto L193;
            case 23: goto L192;
            case 24: goto L191;
            case 25: goto L190;
            case 26: goto L177;
            case 27: goto L170;
            case 28: goto L165;
            case 29: goto L164;
            case 30: goto L163;
            case 31: goto L159;
            default: goto L155;
        };
    L159:
        if (r105 == null) goto L19;
        if (TextUtils.isDigitsOnly(r105) == false) goto L19;
        r101.f526575i = CastIntegerProtector.parseInt(r105);
        goto L19
    L163:
        r101.L = r105;
        goto L19
    L164:
        r101.f526573g = r105;
        goto L19
    L165:
        if (r105 == null) goto L19;
        if (TextUtils.isDigitsOnly(r105) == false) goto L19;
        r101.I = CastIntegerProtector.parseInt(r105);
        goto L19
    L170:
        if (TextUtils.equals("true", r105) == false) goto L172;
    L175:
        boolean r107 = true;
    L176:
        r101.f526577k = r107;
        goto L19
    L172:
        if (TextUtils.equals("1", r105) == true) goto L175;
        r107 = false;
        goto L176
    L177:
        String[] r108 = TextUtils.split(r105, ",");
        if (r108 == null) goto L19;
        if (r108.length <= 0) goto L19;
        r101.E = new ArrayList();
        int r109 = r108.length;
        int r111 = 0;
    L182:
        if (r111 >= r109) goto L19;
        String r112 = r108[r111];
        if (TextUtils.isEmpty(r112) == true) goto L189;
        if (TextUtils.isDigitsOnly(r112) == false) goto L189;
        List<Integer> r113 = r101.E;
        ArrayList r114 = (ArrayList) r113;
        r114.add(Integer.valueOf(CastIntegerProtector.parseInt(r112)));
    L189:
        r111 = r111 + 1;
        goto L182
    L190:
        r101.f526572f = r105;
        goto L19
    L191:
        r101.f526571e = r105;
        goto L19
    L192:
        r101.f526591y = r105;
        goto L19
    L193:
        r101.f526574h = r105;
        goto L19
    L194:
        r101.f526567a = r105;
        goto L19
    L195:
        if (r105 == null) goto L19;
        r101.f526588v = new JSONObject(r105);     // Catch: JSONException -> L198
        goto L19
    L199:
        r101.f526569c = r105;
        goto L19
    L200:
        r101.f526570d = r105;
        goto L19
    L201:
        r101.D = r105;
        goto L19
    L203:
        if (TextUtils.equals("true", r105) == false) goto L205;
    L208:
        boolean r115 = true;
    L209:
        r101.f526584r = r115;
        goto L19
    L205:
        if (TextUtils.equals("1", r105) == true) goto L208;
        r115 = false;
        goto L209
    L210:
        r101.N = r105;
        goto L19
    L212:
        if (TextUtils.equals("true", r105) == false) goto L214;
    L217:
        boolean r116 = true;
    L218:
        r101.f526589w = r116;
        goto L19
    L214:
        if (TextUtils.equals("1", r105) == true) goto L217;
        r116 = false;
        goto L218
    L219:
        r101.f526568b = r105;
        goto L19
    L220:
        if (r105 == null) goto L19;
        if (TextUtils.isDigitsOnly(r105) == false) goto L19;
        r101.K = CastDoubleProtector.parseDouble(r105);
        goto L19
    L225:
        if (TextUtils.equals("true", r105) == false) goto L227;
    L230:
        boolean r117 = true;
    L231:
        r101.F = r117;
        goto L19
    L227:
        if (TextUtils.equals("1", r105) == true) goto L230;
        r117 = false;
        goto L231
    L232:
        r101.C = r105;
        goto L19
    L233:
        if (r105 == null) goto L19;
        if (TextUtils.isDigitsOnly(r105) == false) goto L19;
        r101.f526566J = CastDoubleProtector.parseDouble(r105);
        goto L19
    L237:
        r101.f526590x = r105;
        goto L19
    L239:
        if (r101.f526573g != null) goto L19;
        r101.f526573g = r105;
        goto L19
    L241:
        r101.A = r105;
        goto L19
    L242:
        r101.f526592z = r105;
        goto L19
    L244:
        if (TextUtils.equals("true", r105) == false) goto L246;
    L249:
        boolean r118 = true;
    L250:
        r101.G = r118;
        goto L19
    L246:
        if (TextUtils.equals("1", r105) == true) goto L249;
        r118 = false;
        goto L250
    L251:
        if (r105 == null) goto L19;
        if (TextUtils.isDigitsOnly(r105) == false) goto L19;
        r101.M = CastIntegerProtector.parseInt(r105);
        goto L19
    L256:
        if (TextUtils.equals("true", r105) == false) goto L258;
    L261:
        boolean r119 = true;
    L262:
        r101.H = r119;
        goto L19
    L258:
        if (TextUtils.equals("1", r105) == true) goto L261;
        r119 = false;
        goto L262
    L155:
        if (r104.startsWith("h5-params-") == true) goto L157;
        if (r101.f526578l != null) goto L267;
        r101.f526578l = new HashMap();
    L267:
        ((HashMap) r101.f526578l).put(r104, r105);
        goto L19
    L157:
        if (r101.f526579m != null) goto L263;
        r101.f526579m = new HashMap();
    L263:
        Map<String, String> r120 = r101.f526579m;
        HashMap r121 = (HashMap) r120;
        r121.put(r104.replace("h5-params-", ""), r105);
        goto L19
    L24:
        if (r104.equals("action_num") == false) goto L151;
        r106 = 31;
        goto L153
    L28:
        if (r104.equals("face_view_type") == false) goto L151;
        r106 = 30;
        goto L153
    L32:
        if (r104.equals("cert_app_id") == false) goto L151;
        r106 = 29;
        goto L153
    L36:
        if (r104.equals("face_page_view_height") == false) goto L151;
        r106 = 28;
        goto L153
    L40:
        if (r104.equals("use_new_api") == false) goto L151;
        r106 = 27;
        goto L153
    L44:
        if (r104.equals("face_init_pass_code") == false) goto L151;
        r106 = 26;
        goto L153
    L48:
        if (r104.equals(BytedCertConstant.CertKey.IDENTITY_NAME) == false) goto L151;
        r106 = 25;
        goto L153
    L52:
        if (r104.equals(BytedCertConstant.CertKey.IDENTITY_CODE) == false) goto L151;
        r106 = 24;
        goto L153
    L56:
        if (r104.equals("retain_title") == false) goto L151;
        r106 = 23;
        goto L153
    L60:
        if (r104.equals(BytedCertConstant.CertKey.LIVE_TYPE) == false) goto L151;
        r106 = 22;
        goto L153
    L64:
        if (r104.equals("scene") == false) goto L151;
        r106 = 21;
        goto L153
    L68:
        if (r104.equals("extra") == false) goto L151;
        r106 = 20;
        goto L153
    L72:
        if (r104.equals("eventParams") == false) goto L151;
        r106 = 19;
        goto L153
    L76:
        if (r104.equals("mode") == false) goto L151;
        r106 = 18;
        goto L153
    L80:
        if (r104.equals(BytedCertConstant.CertKey.FLOW) == false) goto L151;
        r106 = 17;
        goto L153
    L84:
        if (r104.equals("aid") == false) goto L151;
        r106 = 16;
        goto L153
    L88:
        if (r104.equals("background_image_url") == false) goto L151;
        r106 = 15;
        goto L153
    L92:
        if (r104.equals(BytedCertConstant.CertKey.SHOW_AUTH_ERROR) == false) goto L151;
        r106 = 14;
        goto L153
    L96:
        if (r104.equals("enter_method") == false) goto L151;
        r106 = HTTP.CR;
        goto L153
    L100:
        if (r104.equals("without_animation") == false) goto L151;
        r106 = 12;
        goto L153
    L104:
        if (r104.equals("ticket") == false) goto L151;
        r106 = 11;
        goto L153
    L108:
        if (r104.equals("face_cycle_radius") == false) goto L151;
        r106 = 10;
        goto L153
    L112:
        if (r104.equals("face_prompt_audio_enable") == false) goto L151;
        r106 = 9;
        goto L153
    L116:
        if (r104.equals("title_icon_url") == false) goto L151;
        r106 = 8;
        goto L153
    L120:
        if (r104.equals("face_cycle_translation_y") == false) goto L151;
        r106 = 7;
        goto L153
    L124:
        if (r104.equals("retain_text") == false) goto L151;
        r106 = 6;
        goto L153
    L128:
        if (r104.equals("app_id") == false) goto L151;
        r106 = 5;
        goto L153
    L132:
        if (r104.equals("retain_negative_btn") == false) goto L151;
        r106 = 4;
        goto L153
    L136:
        if (r104.equals("retain_positive_btn") == false) goto L151;
        r106 = 3;
        goto L153
    L140:
        if (r104.equals("face_prompt_animation_enable") == false) goto L151;
        r106 = 2;
        goto L153
    L144:
        if (r104.equals("face_dialog_timeout") == false) goto L151;
        r106 = 1;
        goto L153
    L148:
        if (r104.equals("face_full_progress_bar_opt") == false) goto L151;
        r106 = 0;
    L269:
        if (r110.getThemeConfig() == null) goto L272;
        this.themeConfig = r110.getThemeConfig();
    L272:
        if (TextUtils.isEmpty(r110.getLanguage()) == true) goto L274;
        this.mLanguage = r110.getLanguage();
    L274:
        initError(r110.getContext());
        return true;
    }

    public static HashMap<String, String> getPermissionLocalStrings(Context r100, String r101) {
        HashMap<String, String> r102 = new HashMap();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L8:
        r102.put("byted_permission_desc_title", "%s权限使用说明: ");
        r102.put("byted_permission_deny", "未授权“%s”权限，无法正常使用");
        r102.put("byted_permission_cancel", "取消");
        r102.put("byted_permission_goto_settings", "去设置");
    L9:
        BytedCertSdkInitParam.PermissionParam r103 = BytedCertSdkManager.getInstance().getPermissionParam();
        if (r103 != null) goto L12;
    L20:
        return r102;
    L12:
        if (r103.isShowMask() == false) goto L20;
        Map<String, Map<String, String>> r104 = BytedCertSdkManager.getInstance().getPermissionParam().getLocalizationUsageMap();
        if (r104 == null) goto L20;
        if (r104.containsKey(r101) == false) goto L20;
        if (r104.get(r101) == null) goto L20;
        r102.put("byted_permission_usage_android.permission-group.CAMERA", r104.get(r101).get(PermissionEntity.Group.PERMISSION_GROUP_CAMERA));
        r102.put("byted_permission_usage_android.permission-group.MICROPHONE", r104.get(r101).get(PermissionEntity.Group.PERMISSION_GROUP_MICROPHONE));
        goto L20
    L5:
        if (TextUtils.equals("zh", r101) == true) goto L8;
        r102.put("byted_permission_desc_title", "%s permission usage instructions:");
        r102.put("byted_permission_deny", "\"%s\" has not been authorized, the function cannot be used normally. ");
        r102.put("byted_permission_cancel", "Cancel");
        r102.put("byted_permission_goto_settings", "Setting");
        goto L9
    }

    public JSONObject appendEventParams(JSONObject r100, boolean r101) {
        if (r100 != null) goto L5;
        r100 = new JSONObject();
    L5:
        if (r101 == false) goto L66;
    L9:
        r100.put("mode", this.mCertInfo.f526569c);     // Catch: Exception -> L65
        if (TextUtils.isEmpty(this.mCertInfo.f526573g) == true) goto L14;
        r100.put("cert_app_id", this.mCertInfo.f526573g);     // Catch: Exception -> L65
    L14:
        if (TextUtils.isEmpty(this.mCertInfo.f526574h) == false) goto L16;
        r100.put(EventConstant.Key.VERIFY_DETECTION_TYPE, BytedCertConstant.LiveType.LIVE_TYPE_ACTION);     // Catch: Exception -> L65
    L18:
        if (TextUtils.isEmpty(this.mCertInfo.f526580n) == true) goto L22;
        r100.put(EventConstant.Key.VERIFY_SOURCE, this.mCertInfo.f526580n);     // Catch: Exception -> L65
    L22:
        if (TextUtils.isEmpty(this.mCertInfo.f526583q) == true) goto L24;
        r100.put(EventConstant.Key.AUTH_VERSION, this.mCertInfo.f526583q);     // Catch: Exception -> L65
    L29:
        JSONObject r102 = this.mCertInfo.f526588v;     // Catch: Exception -> L65
        if (r102 == null) goto L33;
        r100.put("extra", r102);     // Catch: Exception -> L65
    L33:
        if (TextUtils.isEmpty(this.mCertInfo.N) == true) goto L35;
        r100.put("enter_method", this.mCertInfo.N);     // Catch: Exception -> L65
    L35:
        HashMap r103 = (HashMap) this.mCertInfo.f526587u;     // Catch: Exception -> L65
        if (r103.isEmpty() == true) goto L45;
        Iterator r104 = r103.entrySet().iterator();     // Catch: Exception -> L65
    L39:
        if (r104.hasNext() == false) goto L45;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L65
        String r106 = (String) r105.getKey();     // Catch: Exception -> L65
        String r107 = (String) r105.getValue();     // Catch: Exception -> L65
        if (TextUtils.isEmpty(r106) == true) goto L39;
        if (TextUtils.isEmpty(r107) == true) goto L39;
        r100.put(r106, r107);     // Catch: Exception -> L65
    L45:
        Map<String, String> r108 = this.mCertInfo.f526578l;     // Catch: Exception -> L65
        if (r108 == null) goto L57;
        if (((HashMap) r108).containsKey("youth_cert_scene") == false) goto L57;
        String r109 = (String) ((HashMap) this.mCertInfo.f526578l).get("youth_cert_scene");     // Catch: Exception -> L65
        if (r109 != null) goto L53;
    L55:
        r100.put(EventConstant.Key.AGE_LARGER_14, 0);     // Catch: Exception -> L65
        goto L57
    L53:
        if (TextUtils.isDigitsOnly(r109) == false) goto L55;
        r100.put(EventConstant.Key.AGE_LARGER_14, CastIntegerProtector.parseInt(r109));     // Catch: Exception -> L65
    L57:
        if (BytedCertSdkManager.getInstance().withFaceDetect() == false) goto L62;
        if (hsa.a.isLoadSuccess() == false) goto L62;
        r100.put("smash_live_model_name", FaceLiveness.native_FL_GetModelName());     // Catch: Exception -> L65
        r100.put("smash_sdk_version", FaceLiveness.native_FL_GetSdkVersion());     // Catch: Exception -> L65
    L62:
        if (isBytedCertFlow() == false) goto L64;
        r100.put("jsb_version", 101);     // Catch: Exception -> L65
    L64:
        return r100;
    L24:
        if (this.mCertInfo.f526576j == false) goto L26;
        String r110 = "3.0";
    L27:
        r100.put(EventConstant.Key.AUTH_VERSION, r110);     // Catch: Exception -> L65
        goto L29
    L26:
        r110 = EventConstant.Value.AUTH_VERSION_2;
        goto L27
    L16:
        r100.put(EventConstant.Key.VERIFY_DETECTION_TYPE, this.mCertInfo.f526574h);     // Catch: Exception -> L65
        goto L18
    L66:
        r100.put("scene", this.mCertInfo.f526567a);     // Catch: Exception -> L65
        r100.put("ticket", this.mCertInfo.f526568b);     // Catch: Exception -> L65
        if (TextUtils.isEmpty(this.mCertInfo.f526570d) == true) goto L9;
        r100.put(BytedCertConstant.CertKey.FLOW, this.mCertInfo.f526570d);     // Catch: Exception -> L65
        goto L9
    }

    public String getMultiLanguageString(Context r100, int r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(this.mLanguage) == true) goto L17;
        if (TextUtils.equals("zh", this.mLanguage) == true) goto L17;
        if (this.mResources != null) goto L18;
        Configuration r102 = new Configuration(r100.getResources().getConfiguration());
        r102.setLocale(new Locale(this.mLanguage));
        Context r103 = r100.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r103);
        this.mResources = r103.getResources();
    L18:
        return this.mResources.getString(r101);
    L15:
        return r100.getString(r101);
    L17:
        return r100.getString(r101);
    }

    @Override // com.ss.android.bytedcert.flow.base.ICertFlow, com.ss.android.cert.manager.utils.net.BCNetworkUtils.NetworkEventProcessor
    public void onEvent(String r100, JSONObject r101) {
        onEvent(r100, r101, false);
    }

    @Override // com.ss.android.cert.manager.utils.net.BCNetworkUtils.NetworkEventProcessor
    public void onExceptionEvent(Throwable r100, int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        if (r100 == null) goto L5;
        r102.put(EventConstant.Key.EXCEPTION_STACK_TRACE, CertLog.getStackTraceString(r100));     // Catch: Exception -> L9
        r102.put("exception_msg", r100.getMessage());     // Catch: Exception -> L9
    L5:
        r102.put("error_code", r101);     // Catch: Exception -> L9
        onEvent(EventConstant.Event.SDK_EXCEPTION, r102);     // Catch: Exception -> L9
        IExceptionCallback r103 = CertManager.getInstance().getExceptionCallback();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        r103.onException(r100, r101);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.bytedcert.flow.base.ICertFlow
    public void setTimestamp(String r100, String r101) {
        b r102 = this.mCertInfo;
        r102.getClass();
        int r103 = r101.hashCode();     // Catch: NumberFormatException -> L29
        if (r103 == (-312865764)) goto L12;
        if (r103 == 649330421) goto L9;
    L14:
        byte r104 = -1;
    L15:
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L19;
        return;
    L19:
        if (((HashMap) r102.f526586t).containsKey(BytedCertConstant.KeyTimestamp.FACE_DETECT_OPEN) == false) goto L34;
        String r105 = (String) ((HashMap) r102.f526586t).get(BytedCertConstant.KeyTimestamp.FACE_DETECT_OPEN);     // Catch: NumberFormatException -> L29
        if (TextUtils.isEmpty(r105) == true) goto L35;
        Map<String, String> r106 = r102.f526586t;     // Catch: NumberFormatException -> L29
        HashMap r107 = (HashMap) r106;     // Catch: NumberFormatException -> L29
        r107.put(r100, String.valueOf(System.currentTimeMillis() - CastLongProtector.parseLong(r105)));     // Catch: NumberFormatException -> L29
        return;
    L35:
        return;
    L34:
        return;
    L24:
        if (((HashMap) r102.f526585s).containsKey(BytedCertConstant.KeyTimestamp.FLOW_START) == false) goto L37;
        String r108 = (String) ((HashMap) r102.f526585s).get(BytedCertConstant.KeyTimestamp.FLOW_START);     // Catch: NumberFormatException -> L29
        if (TextUtils.isEmpty(r108) == true) goto L38;
        Map<String, String> r109 = r102.f526585s;     // Catch: NumberFormatException -> L29
        HashMap r110 = (HashMap) r109;     // Catch: NumberFormatException -> L29
        r110.put(r100, String.valueOf(System.currentTimeMillis() - CastLongProtector.parseLong(r108)));     // Catch: NumberFormatException -> L29
        return;
    L38:
        return;
    L37:
        return;
    L9:
        if (r101.equals(EventConstant.Key.FULL_FLOW_TIMESTAMP) == false) goto L14;
        r104 = 0;
        goto L15
    L12:
        if (r101.equals(EventConstant.Key.FACE_DETECT_TIMESTAMP) == false) goto L14;
        r104 = 1;
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    public void switchLanguage(Context r100, String r101) {
        if (r100 == null) goto L8;
        this.mLanguage = r101;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        this.mResources = null;
        return;
    L6:
        Configuration r102 = new Configuration(r100.getResources().getConfiguration());
        r102.setLocale(new Locale(r101));
        Context r103 = r100.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r103);
        this.mResources = r103.getResources();
        initError(r100);
        return;
    }

    public void onAuthVerifyEndEvent(BDResponse r100, boolean r101, String r102) {
        setTimestamp(BytedCertConstant.KeyTimestamp.FLOW_END, EventConstant.Key.FULL_FLOW_TIMESTAMP);
        JSONObject r103 = new JSONObject();
        if (r100.success == false) goto L6;
        String r104 = "success";
    L7:
        r103.put("result", r104);     // Catch: Exception -> L21
        r103.put("error_code", String.valueOf(r100.errorCode));     // Catch: Exception -> L21
        if (r100.success == false) goto L10;
    L14:
        r103.put(EventConstant.Key.ALL_MODULE, r102);     // Catch: Exception -> L21
        if (r101 == false) goto L17;
        String r105 = "1";
    L18:
        r103.put(EventConstant.Key.IS_FINISH, r105);     // Catch: Exception -> L21
        r103.put(EventConstant.Key.FULL_FLOW_TIMESTAMP, getTimestampMap(EventConstant.Key.FULL_FLOW_TIMESTAMP).toString());     // Catch: Exception -> L21
        goto L19
    L17:
        r105 = "0";
        goto L18
    L10:
        if (TextUtils.isEmpty(r100.detailErrorMsg) == true) goto L12;
        String r106 = r100.detailErrorMsg;     // Catch: Exception -> L21
    L13:
        r103.put("fail_reason", r106);     // Catch: Exception -> L21
        goto L14
    L12:
        r106 = "";
        goto L13
    L6:
        r104 = "fail";
    L19:
        onEvent(EventConstant.Event.AUTH_VERIFY_END, r103);
    }

    public void onEvent(String r100, JSONObject r101, boolean r102) {
        JSONObject r103 = appendEventParams(r101, r102);
        if (AutoTestManager.getInstance().isAutoTest() == false) goto L7;
        r103.put("auto_test_event", r100);     // Catch: Exception -> L11
        AutoTestManager.outputLog(r103.toString());     // Catch: Exception -> L11
    L7:
        if (TextUtils.isEmpty(this.mLanguage) == true) goto L9;
        r103.put("byted_cert_language", this.mLanguage);     // Catch: Exception -> L11
    L9:
        EventLogUtils.onEvent(r100, r103);
    }

    public void showErrDialog(final Context r100, final String r101, final Runnable r102) {
        if ((r100 instanceof Activity) == true) goto L6;
        BytedCertManager.getInstance().executeInMainThread(r102);
        return;
    L6:
        BytedCertManager.getInstance().executeInMainThread(new AnonymousClass2(this, r102, r100, r101));
    }

    @Override // com.ss.android.cert.manager.utils.net.BCNetworkUtils.NetworkEventProcessor
    public void performanceEvent(String r100, CertResponse r101, Integer r102, JSONObject r103, String r104) {
        EventLogUtils.performanceEvent(r100, r101, r102, appendEventParams(r103), r104);
    }
}
