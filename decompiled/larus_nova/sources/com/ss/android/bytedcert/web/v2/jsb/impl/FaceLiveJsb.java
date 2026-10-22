package com.ss.android.bytedcert.web.v2.jsb.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.bytedcert.callback.IWebEventCallback;
import com.ss.android.bytedcert.callback.IWebEventCallbackV2;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlowParams;
import com.ss.android.bytedcert.flow.face.FaceDetectFlowParams;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.web.v2.jsb.AbsJsBridge;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import rsa.e;

/* JADX INFO: loaded from: classes34.dex */
public class FaceLiveJsb extends AbsJsBridge {
    private static final long serialVersionUID = -2709731900209065362L;
    private boolean isCloseFromWeb;
    private final BytedCertFlow mFlow;
    private CertResult mResult;
    private JSONObject perCacheResultData;
    private final Pair<Integer, String> result;

    public class a implements IWebEventCallbackV2.IWebEventCompleteCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407914b;

        public a(String r100, IBridgeContext r101) {
            this.f407913a = r100;
            this.f407914b = r101;
        }

        @Override // com.ss.android.bytedcert.callback.IWebEventCallbackV2.IWebEventCompleteCallback
        public final void onEventComplete(boolean r100, JSONObject r101) {
            JSONObject r102 = new JSONObject();
            if (r100 == false) goto L6;
            int r103 = 0;
        L15:
            r102.put("status_code", r103);     // Catch: JSONException -> L9
            r102.put("data", r101);     // Catch: JSONException -> L9
        L11:
            CertLog.d(BytedCertFlow.TAG, "receive webEvent complete:" + this.f407913a + ";resp:" + r102);
            IBridgeContext r104 = this.f407914b;
            if (r104 == null) goto L17;
            r104.onSuccess(r102);
            return;
        L17:
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L11
        L6:
            r103 = 1;
            goto L15
        }
    }

    public FaceLiveJsb(BytedCertFlow r100) {
        this.result = ErrorConstant.Client.ERROR_USER_CANCEL;
        this.mFlow = r100;
    }

    public static /* synthetic */ BytedCertFlow access$200(FaceLiveJsb r100) {
        return r100.mFlow;
    }

    public static /* synthetic */ CertResult access$400(FaceLiveJsb r100) {
        return r100.mResult;
    }

    @Override // com.ss.android.bytedcert.web.v2.jsb.AbsJsBridge, com.ss.android.cert.manager.web.jsb.IJsBridge
    public void onDestroy(Activity r100) {
        if (this.isCloseFromWeb == false) goto L6;
        return;
    L6:
        if (this.perCacheResultData != null) goto L11;
        JSONObject r101 = new JSONObject();
        this.perCacheResultData = r101;
        r101.put("error_code", this.result.first);     // Catch: Exception -> L10
        this.perCacheResultData.put("error_msg", this.result.second);     // Catch: Exception -> L10
    L11:
        this.mFlow.onH5Close(this.perCacheResultData);
        if (this.mResult != null) goto L14;
        CertResult r102 = new CertResult();
        this.mResult = r102;
        r102.setCode(((Integer) this.result.first).intValue());
        this.mResult.setMessage((String) this.result.second);
    L14:
        this.mFlow.onCertResult(this.mResult);
    }

    public static /* synthetic */ boolean access$102(FaceLiveJsb r100, boolean r101) {
        r100.isCloseFromWeb = r101;
        return r101;
    }

    public static /* synthetic */ CertResult access$402(FaceLiveJsb r100, CertResult r101) {
        r100.mResult = r101;
        return r101;
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void invoke(final IBridgeContext r110, Object... r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        byte r100 = 0;
        String r101 = (String) r111[0];
        r101.getClass();
        switch(r101.hashCode()) {
            case -1847956096: goto L48;
            case -1665661478: goto L44;
            case -1496467384: goto L40;
            case -450217910: goto L36;
            case 22737236: goto L32;
            case 260378023: goto L28;
            case 404513145: goto L24;
            case 1203888423: goto L20;
            case 1416370607: goto L16;
            case 1762224313: goto L12;
            case 2019561108: goto L8;
            default: goto L49;
        };
    L49:
        r100 = -1;
    L51:
        switch(r100) {
            case 0: goto L88;
            case 1: goto L87;
            case 2: goto L81;
            case 3: goto L80;
            case 4: goto L79;
            case 5: goto L76;
            case 6: goto L75;
            case 7: goto L74;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L53;
            default: goto L111;
        };
    L53:
        JSONObject r102 = (JSONObject) r111[1];
        String r103 = (String) r111[2];
        String r112 = (String) r111[3];
        Activity r104 = r110.getActivity();
        if (r104 != null) goto L56;
        transparentMsgToJs(r110, new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN));
        return;
    L56:
        this.mFlow.startVideoRecord(r104, e.a(r102), r103, r112, new d(r110));
        return;
    L57:
        BytedCertManager.getInstance().executeInMainThread(new b(this, (JSONObject) r111[1], r110, null));
        return;
    L58:
        String r105 = (String) r111[1];
        String r106 = (String) r111[2];
        String r107 = (String) r111[3];
        String r108 = (String) r111[4];
        JSONObject r113 = (JSONObject) r111[5];
        HashMap r109 = new HashMap();
        r109.put("scene", r105);
        r109.put("cert_app_id", r106);
        r109.put(BytedCertConstant.CertKey.FLOW, r107);
        if (TextUtils.isEmpty(r108) == true) goto L61;
        r109.put("ticket", r108);
    L61:
        if (r113 == null) goto L71;
        Iterator<String> r114 = r113.keys();
    L64:
        if (r114.hasNext() == false) goto L71;
        String r115 = r114.next();
        String r116 = r113.optString(r115);
        if (TextUtils.isEmpty(r115) == true) goto L64;
        if (TextUtils.isEmpty(r116) == true) goto L64;
        r109.put("h5-params-" + r115, r116);
    L71:
        if (r109.containsKey("use_new_api") == true) goto L73;
        r109.put("use_new_api", "true");
    L73:
        BytedCertManager.getInstance().startBytedCert(new BytedCertFlowParams.Builder(r110.getActivity()).setCertInfo(r109).setWebEventCallback(this.mFlow.getWebEventCallback()).setH5CallBack(new c(this, r110)).build());
        return;
    L74:
        final String r117 = (String) r111[1];
        final String r118 = (String) r111[2];
        final JSONObject r119 = (JSONObject) r111[3];
        BytedCertManager.getInstance().executeInMainThread(new AnonymousClass6(this, r117, r118, r119, r110));
        return;
    L75:
        BytedCertManager.getInstance().executeInMainThread(new b(this, (JSONObject) r111[1], r110, (String) r111[2]));
        return;
    L76:
        JSONObject r120 = new JSONObject();
        r120.put("type", r111[1]);     // Catch: JSONException -> L90
        r120.put("title", r111[2]);     // Catch: JSONException -> L90
        r120.put("url", r111[3]);     // Catch: JSONException -> L90
        r120.put("hide_nav_bar", ((Integer) r111[4]).intValue());     // Catch: JSONException -> L90
    L78:
        a(r110, r110.getActivity(), SendEventContainerMethodParamModel.EventKinds.openPage, r120);
        return;
    L79:
        a(r110, r110.getActivity(), (String) r111[1], (JSONObject) r111[2]);
        return;
    L80:
        b(r110, ((Integer) r111[1]).intValue(), ((Integer) r111[2]).intValue(), ((Integer) r111[3]).intValue());
        return;
    L81:
        String r121 = (String) r111[1];
        String r122 = (String) r111[2];
        boolean r123 = ((Boolean) r111[3]).booleanValue();
        JSONObject r124 = (JSONObject) r111[4];
        JSONObject r125 = (JSONObject) r111[5];
        JSONObject r126 = (JSONObject) r111[6];
        JSONObject r127 = (JSONObject) r111[7];
        boolean r128 = ((Boolean) r111[8]).booleanValue();
        String r129 = (String) r111[9];
        if (r124 == null) goto L84;
        this.perCacheResultData = r124.optJSONObject("data");
    L84:
        if (r125 == null) goto L86;
        b(null, r125.optInt("cert_status"), r125.optInt("manual_status"), r125.optInt("age_range"));
    L86:
        osa.b r130 = this.mFlow.getCertInfo();
        r130.f526588v = r127;
        r130.B = r123;
        r130.f526571e = r121;
        r130.f526572f = r122;
        this.mFlow.doFaceLive(new FaceDetectFlowParams.Builder(r110.getActivity()).setCertInfo(e.a(r126)).setShowLoading(r128).setLanguage(r129).setFaceLiveCallback(new AnonymousClass1(this, r110)).build());
        return;
    L87:
        this.mFlow.switchLanguage(r110.getActivity(), (String) r111[1]);
        r110.onSuccess(null);
        return;
    L88:
        a(r110, r110.getActivity(), "login", null);
        return;
    L111:
        return;
    L8:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_OPEN_VIDEO_RECORD) == false) goto L49;
        r100 = 10;
        goto L51
    L12:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_CLOSE_PAGE) == false) goto L49;
        r100 = 9;
        goto L51
    L16:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_LAUNCH_FLOW) == false) goto L49;
        r100 = 8;
        goto L51
    L20:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_OPEN_VIDEO_CERT) == false) goto L49;
        r100 = 7;
        goto L51
    L24:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_OPEN_AND_CLOSE) == false) goto L49;
        r100 = 6;
        goto L51
    L28:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_OPEN_PAGE) == false) goto L49;
        r100 = 5;
        goto L51
    L32:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_WEB_EVENT) == false) goto L49;
        r100 = 4;
        goto L51
    L36:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_SET_CERT_STATUS) == false) goto L49;
        r100 = 3;
        goto L51
    L40:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_OPEN_FACE_LIVE) == false) goto L49;
        r100 = 2;
        goto L51
    L44:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_SWITCH_LANGUAGE) == false) goto L49;
        r100 = 1;
        goto L51
    L48:
        if (r101.equals(BytedCertConstant.JsbKey.METHOD_OPEN_LOGIN_PAGE) == true) goto L51;
        goto L49
    }

    public static /* synthetic */ void access$700(FaceLiveJsb r100, IBridgeContext r101, CertResponse r102) {
        r100.transparentMsgToJs(r101, r102);
    }

    public static /* synthetic */ void access$800(FaceLiveJsb r100, IBridgeContext r101, CertResponse r102) {
        r100.transparentMsgToJs(r101, r102);
    }

    public static /* synthetic */ void access$000(FaceLiveJsb r100, IBridgeContext r101, CertResponse r102, JSONObject r103) {
        r100.transparentMsgToJs(r101, r102, r103);
    }

    public static void access$300(FaceLiveJsb r100, int r101, String r102, JSONObject r103) {
        r100.getClass();
        if (r103 == null) goto L18;
        JSONObject r104 = new JSONObject(r103.toString());     // Catch: Exception -> L13
        r104.put("error_msg", r102);     // Catch: Exception -> L13
        if (r104.has("name") == false) goto L9;
        r104.remove("name");     // Catch: Exception -> L13
    L9:
        if (r104.has("idNumber") == false) goto L11;
        r104.remove("idNumber");     // Catch: Exception -> L13
    L11:
        r104.put("error_code", r101);     // Catch: Exception -> L13
        r100.mFlow.onEvent(EventConstant.Event.BYTED_CERT_CERTIFICATION_JSB_RESULT, r104);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void access$600(FaceLiveJsb r100, IBridgeContext r101, JSONObject r102, String r103) {
        r100.getClass();
        BytedCertManager.getInstance().executeInMainThread(new b(r100, r102, r101, r103));
    }

    public final void a(IBridgeContext r100, Activity r101, String r102, JSONObject r103) {
        IWebEventCallback r104 = this.mFlow.getWebEventCallback();
        if (r104 != null) goto L5;
        return;
    L5:
        if ((r104 instanceof IWebEventCallbackV2) == false) goto L7;
        CertLog.d(BytedCertFlow.TAG, "receive webEvent v2:" + r102 + ";data:" + r103);
        ((IWebEventCallbackV2) r104).onWebEventV2(r101, r102, r103, new a(r102, r100));
        return;
    L7:
        CertLog.d(BytedCertFlow.TAG, "receive webEvent:" + r102 + ";data:" + r103);
        r104.onWebEvent(r102, r103);
    }

    public final void b(IBridgeContext r100, int r101, int r102, int r103) {
        if (this.mResult != null) goto L5;
        this.mResult = new CertResult();
    L5:
        this.mResult.setCertStatus(r101);
        this.mResult.setManualStatus(r102);
        this.mResult.setAgeRange(r103);
        if (r100 == null) goto L9;
        r100.onSuccess(null);
        return;
    }

    public static /* synthetic */ void access$500(FaceLiveJsb r100, IBridgeContext r101, Activity r102, String r103, JSONObject r104) {
        r100.a(r101, r102, r103, r104);
    }
}
