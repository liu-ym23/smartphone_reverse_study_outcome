package com.ss.android.bytedcert.web.v1;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.js.JsBridgeManager;
import com.bytedance.sdk.bridge.js.auth.JSBridgeAuthenticator;
import com.bytedance.sdk.bridge.js.spec.JsbridgeEventHelper;
import com.bytedance.sdk.bridge.method.AbsAppBridgeModule;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.callback.H5CallBack;
import com.ss.android.bytedcert.callback.IWebEventCallback;
import com.ss.android.bytedcert.callback.IWebEventCallbackV2;
import com.ss.android.bytedcert.callback.NfcEventCallback;
import com.ss.android.bytedcert.callback.NfcStatusCallback;
import com.ss.android.bytedcert.callback.PhotoCallback;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.dialog.DialogHelper;
import com.ss.android.bytedcert.dialog.LoadingDialog;
import com.ss.android.bytedcert.dialog.PickPhotoDialog;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlowParams;
import com.ss.android.bytedcert.flow.face.FaceDetectFlowParams;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.net.fetch.BaseRequest;
import com.ss.android.bytedcert.net.fetch.BaseResponse;
import com.ss.android.bytedcert.net.fetch.CallBack;
import com.ss.android.bytedcert.net.fetch.FetchJSBRequest;
import com.ss.android.bytedcert.net.fetch.FetchJSBRequestService;
import com.ss.android.bytedcert.net.fetch.FetchJSBResponse;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.permission.PermissionHelper;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.SystemInfoTools;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.net.BCNetworkUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class JSModule extends AbsAppBridgeModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f407812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ysa.a> f407813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBridgeContext f407814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f407815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f407816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f407817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f407818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LoadingDialog f407819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f407820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BytedCertFlow f407821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CertResult f407822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f407823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FetchJSBRequestService f407824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, JsEventSubscriber> f407825n;

    public class a implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407832b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            JSModule r101 = this.f407832b;
            IBridgeContext r102 = this.f407831a;
            r101.getClass();
            JSModule.d(r102, r100, null);
        }

        public a(JSModule r100, IBridgeContext r101) {
            this.f407832b = r100;
            this.f407831a = r101;
        }
    }

    public class b implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407834b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            JSModule r101 = this.f407834b;
            IBridgeContext r102 = this.f407833a;
            r101.getClass();
            JSModule.d(r102, r100, null);
        }

        public b(JSModule r100, IBridgeContext r101) {
            this.f407834b = r100;
            this.f407833a = r101;
        }
    }

    public class c implements IWebEventCallbackV2.IWebEventCompleteCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407836b;

        public c(String r100, IBridgeContext r101) {
            this.f407835a = r100;
            this.f407836b = r101;
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
            CertLog.d("JSModule", "receive webEvent complete:" + this.f407835a + ";resp:" + r102);
            IBridgeContext r104 = this.f407836b;
            if (r104 == null) goto L17;
            r104.callback(BridgeResult.Companion.createSuccessResult(r102));
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

    public class d implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407838b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            JSModule r101 = this.f407838b;
            IBridgeContext r102 = this.f407837a;
            r101.getClass();
            JSModule.d(r102, r100, null);
        }

        public d(JSModule r100, IBridgeContext r101) {
            this.f407838b = r100;
            this.f407837a = r101;
        }
    }

    public class e implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407840b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            JSModule r101 = this.f407840b;
            IBridgeContext r102 = this.f407839a;
            r101.getClass();
            JSModule.d(r102, r100, null);
        }

        public e(JSModule r100, IBridgeContext r101) {
            this.f407840b = r100;
            this.f407839a = r101;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f407843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f407844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f407845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407846f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSModule f407847g;

        public final void a() {
            JSModule r100 = this.f407847g;
            int r101 = this.f407841a;
            String r102 = this.f407842b;
            String r103 = this.f407843c;
            String r104 = this.f407844d;
            String r105 = this.f407845e;
            IBridgeContext r106 = this.f407846f;
            r100.getClass();
            if (r101 != 2) goto L5;
            DialogHelper.showJsbIdEmpDialog(r100.getContext());
            return;
        L5:
            if (r101 != 0) goto L7;
        L8:
            if (r101 != 0) goto L10;
            String r107 = "";
        L11:
            Activity r108 = r100.getContext();
            com.ss.android.bytedcert.web.v1.b r109 = new com.ss.android.bytedcert.web.v1.b(r100, r106);
            com.ss.android.bytedcert.web.v1.c r110 = new com.ss.android.bytedcert.web.v1.c(r100, r106);
            DialogHelper.showAlertDialog(r108, r102, r107, r104, r105, r109, r110);
            return;
        L10:
            r107 = r103;
            goto L11
        L7:
            if (r101 == 1) goto L8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(JSModule r100, int r101, int r102, String r103, String r104, String r105, String r106, IBridgeContext r107) {
            this.f407847g = r100;
            this.f407841a = r101;
            this.f407842b = r103;
            this.f407843c = r104;
            this.f407844d = r105;
            this.f407845e = r106;
            this.f407846f = r107;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSModule f407848a;

        @Override // java.lang.Runnable
        public final void run() {
            IWebEventCallback r100 = this.f407848a.f407821j.getWebEventCallback();     // Catch: Throwable -> L10
            if (r100 != null) goto L5;
            return;
        L5:
            if ((r100 instanceof IWebEventCallbackV2) == false) goto L7;
            ((IWebEventCallbackV2) r100).onWebEventV2(this.f407848a.getContext(), "login", null, null);     // Catch: Throwable -> L10
        L8:
            CertLog.d("#h5callback", "onOpenLoginPage");     // Catch: Throwable -> L10
            return;
        L7:
            r100.onWebEvent("login", null);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public g(JSModule r100) {
            this.f407848a = r100;
        }
    }

    public class h extends WebViewClient {
        public h() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            if (r101 == null) goto L10;
            if (JsBridgeManager.INSTANCE.canHandleUrl(r101) == false) goto L10;
            if (r100 == null) goto L11;
            JsBridgeManager.INSTANCE.delegateMessage(r100, r101);
            return true;
        L11:
            return true;
        L10:
            return super.shouldOverrideUrlLoading(r100, r101);
        }
    }

    public class i implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407850b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            JSModule r101 = this.f407850b;
            IBridgeContext r102 = this.f407849a;
            r101.getClass();
            JSModule.d(r102, r100, null);
        }

        public i(JSModule r100, IBridgeContext r101) {
            this.f407850b = r100;
            this.f407849a = r101;
        }
    }

    public class j extends BCThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FetchJSBRequest f407851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSModule f407853c;

        public class a implements CallBack<FetchJSBRequest, FetchJSBResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f407854a;

            public a(j r100) {
                this.f407854a = r100;
            }

            @Override // com.ss.android.bytedcert.net.fetch.CallBack
            public final void onError(BaseRequest r100, BaseResponse r101) {
                FetchJSBRequest r102 = (FetchJSBRequest) r100;
                FetchJSBResponse r103 = (FetchJSBResponse) r101;
                j r104 = this.f407854a;     // Catch: Exception -> L5
                JSModule r105 = r104.f407853c;     // Catch: Exception -> L5
                IBridgeContext r106 = r104.f407852b;     // Catch: Exception -> L5
                CertResponse r107 = r103.getMResponse();     // Catch: Exception -> L5
                r105.getClass();     // Catch: Exception -> L5
                JSModule.d(r106, r107, null);     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                CertLog.w("JSModule", "onFailure", e);
            }

            @Override // com.ss.android.bytedcert.net.fetch.CallBack
            public final void onSuccess(BaseRequest r100, BaseResponse r101, boolean r102) {
                FetchJSBRequest r103 = (FetchJSBRequest) r100;
                FetchJSBResponse r104 = (FetchJSBResponse) r101;
                j r105 = this.f407854a;     // Catch: Exception -> L5
                JSModule r106 = r105.f407853c;     // Catch: Exception -> L5
                IBridgeContext r107 = r105.f407852b;     // Catch: Exception -> L5
                CertResponse r108 = r104.getMResponse();     // Catch: Exception -> L5
                r106.getClass();     // Catch: Exception -> L5
                JSModule.d(r107, r108, null);     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                CertLog.w("JSModule", "onResponse", e);
            }
        }

        @Override // com.ss.android.cert.manager.utils.thread.BCThread, java.lang.Runnable
        public final void run() {
            this.f407853c.f407824m.directRequest(this.f407851a, new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(JSModule r100, FetchJSBRequest r101, IBridgeContext r102) {
            this.f407853c = r100;
            this.f407851a = r101;
            this.f407852b = r102;
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSModule f407855a;

        @Override // java.lang.Runnable
        public final void run() {
            Activity r100 = this.f407855a.getContext();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ((SDKWebActivity) r100).f407886g = true;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public k(JSModule r100) {
            this.f407855a = r100;
        }
    }

    public class l implements SDKCallBack.VideoRecordCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407856a;

        public l(IBridgeContext r100) {
            this.f407856a = r100;
        }

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.VideoRecordCallback
        public final void onFinish(BDResponse r100, String r101, String r102) {
            JSONObject r103 = r100.jsonBody;     // Catch: Exception -> L7
            if (r103 != null) goto L5;
            r103 = new JSONObject();     // Catch: Exception -> L7
        L5:
            r103.put("status_code", r100.errorCode);     // Catch: Exception -> L7
            r103.put("description", r100.errorMsg);     // Catch: Exception -> L7
            r103.put("preview_image", r102);     // Catch: Exception -> L7
            this.f407856a.callback(BridgeResult.Companion.createSuccessResult(r103));     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public class m implements H5CallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407858b;

        @Override // com.ss.android.bytedcert.callback.H5CallBack
        public final void onH5Close(JSONObject r100) {
            if (r100.has("step") == false) goto L13;
            int r101 = r100.optInt("step");
            if (r101 == 1) goto L13;
            if (r101 < 0) goto L13;
            if (r101 < 2) goto L16;
            r101 = r101 - 1;
        L16:
            r100.put("step", r101);     // Catch: JSONException -> L15
        L12:
            this.f407858b.closePage(null, r100);
        L13:
            boolean r102 = TextUtils.equals(r100.optString("error_msg", ""), BytedCertConstant.CertValue.CERTIFICATE_SUCCESS);
            JSModule r103 = this.f407858b;
            IBridgeContext r104 = this.f407857a;
            CertResponse r105 = new CertResponse(r102, r100);
            r103.getClass();
            JSModule.d(r104, r105, null);
        }

        public m(JSModule r100, IBridgeContext r101) {
            this.f407858b = r100;
            this.f407857a = r101;
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407860b;

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(this.f407859a.getActivity(), this.f407860b, 0).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public n(IBridgeContext r100, String r101) {
            this.f407859a = r100;
            this.f407860b = r101;
        }
    }

    public class o implements NfcStatusCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zsa.a f407861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407862b;

        public o(zsa.a r100, IBridgeContext r101) {
            this.f407861a = r100;
            this.f407862b = r101;
        }

        @Override // com.ss.android.bytedcert.callback.NfcStatusCallback
        public final void nfcStatusCheck(Pair<Integer, String> r100, String r101) {
            zsa.a r102 = this.f407861a;
            IBridgeContext r103 = this.f407862b;
            r102.getClass();
            zsa.a.b(r103, r100, r101);
        }
    }

    public class p implements NfcEventCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSModule f407863a;

        public p(JSModule r100) {
            this.f407863a = r100;
        }

        @Override // com.ss.android.bytedcert.callback.NfcEventCallback
        public final void nfcEnd(JSONObject r100) {
            JSModule r101 = this.f407863a;
            if (r101.f407812a == null) goto L5;
            JsbridgeEventHelper.INSTANCE.sendEvent(BytedCertConstant.JsbKey.EVENT_NFC_END, r100, r101.f407812a);
        L5:
            this.f407863a.f407821j.setTimestamp(BytedCertConstant.KeyTimestamp.TIMESTAMP_NFC_END, EventConstant.Key.FULL_FLOW_TIMESTAMP);
        }

        @Override // com.ss.android.bytedcert.callback.NfcEventCallback
        public final void nfcStart(JSONObject r100) {
            JSModule r101 = this.f407863a;
            if (r101.f407812a == null) goto L5;
            JsbridgeEventHelper.INSTANCE.sendEvent(BytedCertConstant.JsbKey.EVENT_NFC_READ, r100, r101.f407812a);
        L5:
            this.f407863a.f407821j.setTimestamp(BytedCertConstant.KeyTimestamp.TIMESTAMP_NFC_CONNECTED, EventConstant.Key.FULL_FLOW_TIMESTAMP);
        }
    }

    public class q implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407865b;

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            if (r100.getParams() == null) goto L5;
            JSONObject r101 = new JSONObject(r100.getParams().toMap());
        L6:
            JsbridgeEventHelper.INSTANCE.sendEvent(this.f407864a, r101, this.f407865b.f407812a);
            return;
        L5:
            r101 = null;
            goto L6
        }

        public q(JSModule r100, String r101) {
            this.f407865b = r100;
            this.f407864a = r101;
        }
    }

    public class r implements PermissionHelper.PermissionRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSModule f407866a;

        public r(JSModule r100) {
            this.f407866a = r100;
        }

        @Override // com.ss.android.cert.manager.permission.PermissionHelper.PermissionRequestCallback
        public final void onRequest(boolean r100, boolean r101, HashMap<String, PermissionEntity> r102, String r103) {
            if (r101 == true) goto L4;
            this.f407866a.c(ErrorConstant.Client.ERROR_PERMISSION_ERROR);
        L4:
            JSONObject r104 = new JSONObject();
            if (r101 == false) goto L8;
            String r105 = EventConstant.Value.HAS_PERMISSION;
        L13:
            r104.put(EventConstant.Key.CAMERA_PERMIT, r105);     // Catch: JSONException -> L12
        L10:
            this.f407866a.f407821j.onEvent(EventConstant.Event.ID_CARD_PHOTO_UPLOAD_CAMERA_PERMIT, r104);
            return;
        L8:
            r105 = "no_permission";
            goto L13
        }
    }

    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f407867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BytedCertSdkAbsActivity.c f407869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PermissionHelper.PermissionRequestCallback f407870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSModule f407871e;

        public class a implements PermissionHelper.OnPermissionEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f407872a;

            public a(s r100) {
                this.f407872a = r100;
            }

            @Override // com.ss.android.cert.manager.permission.PermissionHelper.OnPermissionEventListener
            public final void onPermissionEvent(String r100, JSONObject r101) {
                this.f407872a.f407871e.f407821j.onEvent(r100, r101);
            }
        }

        public final void a() {
            BytedCertManager.getInstance().mImgType = "take_photo";
            JSONObject r100 = new JSONObject();
            r100.put("button", "take_photo");     // Catch: Exception -> L6
        L4:
            this.f407871e.f407821j.onEvent(EventConstant.Event.ID_CARD_PHOTO_UPLOAD_ALERT_CLICK, r100);
            BytedCertSdkAbsActivity.y1(this.f407867a, 1, this.f407868b, this.f407869c, new a(this), this.f407870d);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public s(JSModule r100, Activity r101, String r102, qsa.n r103, r r104) {
            this.f407871e = r100;
            this.f407867a = r101;
            this.f407868b = r102;
            this.f407869c = r103;
            this.f407870d = r104;
        }
    }

    public class t implements PhotoCallback.ResultCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSModule f407873a;

        public t(JSModule r100) {
            this.f407873a = r100;
        }

        @Override // com.ss.android.bytedcert.callback.PhotoCallback.ResultCallBack
        public final void onResult(String[] r100, int r101, String r102) {
            if (r101 != 0) goto L4;
            JSModule r103 = this.f407873a;
            String r104 = r100[0];
            qsa.p.c(r103.f407816e, r104);
            r103.c(null);
            return;
        L4:
            this.f407873a.c(ErrorConstant.Client.ERROR_PICK_PHOTO_ERROR);
        }
    }

    public class u implements PickPhotoDialog.OnTakePhotoClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f407874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BytedCertSdkAbsActivity.c f407876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PermissionHelper.PermissionRequestCallback f407877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSModule f407878e;

        public class a implements PermissionHelper.OnPermissionEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u f407879a;

            public a(u r100) {
                this.f407879a = r100;
            }

            @Override // com.ss.android.cert.manager.permission.PermissionHelper.OnPermissionEventListener
            public final void onPermissionEvent(String r100, JSONObject r101) {
                this.f407879a.f407878e.f407821j.onEvent(r100, r101);
            }
        }

        @Override // com.ss.android.bytedcert.dialog.PickPhotoDialog.OnTakePhotoClickListener
        public final void onTakePhotoClick() {
            BytedCertSdkAbsActivity.y1(this.f407874a, 1, this.f407875b, this.f407876c, new a(this), this.f407877d);
        }

        public u(JSModule r100, Activity r101, String r102, qsa.n r103, r r104) {
            this.f407878e = r100;
            this.f407874a = r101;
            this.f407875b = r102;
            this.f407876c = r103;
            this.f407877d = r104;
        }
    }

    public class v implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSModule f407880a;

        public v(JSModule r100) {
            this.f407880a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f407880a.c(ErrorConstant.Client.ERROR_USER_CANCEL);
        }
    }

    public class w implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSModule f407882b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            JSModule r101 = this.f407882b;
            IBridgeContext r102 = this.f407881a;
            r101.getClass();
            JSModule.d(r102, r100, null);
        }

        public w(JSModule r100, IBridgeContext r101) {
            this.f407882b = r100;
            this.f407881a = r101;
        }
    }

    @Override // com.bytedance.sdk.bridge.method.AbsAppBridgeModule
    public final void alert(IBridgeContext r100, String r101, String r102, String r103, String r104, JSONObject r105) {
    }

    @Override // com.bytedance.sdk.bridge.method.AbsAppBridgeModule
    public final BridgeResult checkLoginSatusSync(IBridgeContext r100) {
        return null;
    }

    @Override // com.bytedance.sdk.bridge.method.AbsAppBridgeModule
    public final void login(IBridgeContext r100) {
    }

    @Override // com.bytedance.sdk.bridge.method.AbsAppBridgeModule
    public final void toast(IBridgeContext r100, String r101, String r102, JSONObject r103) {
    }

    public Activity getContext() {
        WeakReference<Activity> r100 = this.f407815d;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.get() != null) goto L7;
        return null;
    L7:
        return this.f407815d.get();
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_STOP_NFC)
    public void stopNFC() {
        ysa.a r100 = (ysa.a) ((HashMap) this.f407813b).get(BytedCertConstant.JsbKey.METHOD_STOP_NFC);
        if (r100 == null) goto L6;
        r100.a(getContext(), null, new Object[]{BytedCertConstant.JsbKey.METHOD_STOP_NFC});
        return;
    }

    public final void c(Pair<Integer, String> r100) {
        CertLog.d("JSModule", "returnImgToOcrJS: error=" + r100);
        if (r100 != null) goto L7;
        b(null, qsa.p.b(this.f407816e, this.f407817f, this.f407818g));     // Catch: Exception -> L5
    L11:
        return;
    L7:
        b(r100, "");     // Catch: Exception -> L5
    L5:
        e = move-exception;
        b(ErrorConstant.Client.ERROR_UNKNOWN, "");
        EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_CAN_I_USE_NFC)
    public void caniuseNFC(@BridgeContext IBridgeContext r100) {
        zsa.a r101 = (zsa.a) ((HashMap) this.f407813b).get(BytedCertConstant.JsbKey.METHOD_CAN_I_USE_NFC);
        if (r101 == null) goto L6;
        r101.a(getContext(), r100, new Object[]{BytedCertConstant.JsbKey.METHOD_CAN_I_USE_NFC, new o(r101, r100)});
        return;
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_DO_OCR)
    public void doOCR(@BridgeContext IBridgeContext r100) {
        this.f407821j.getMonitorManager().a("OCR识别");
        psa.a r101 = this.f407821j.getRequestUtils();
        Activity r102 = getContext();
        b r103 = new b(this, r100);
        boolean r104 = this.f407821j.getCertInfo().f526576j;
        Map<String, String> r105 = this.f407821j.appendCommonRequestParams(null);
        r101.getClass();
        new psa.h(r101, r105, r102, r104, r103).start();
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_HIDE_LOADING)
    public void hideLoading(@BridgeContext IBridgeContext r100) {
        rsa.b.b(this.f407819h);
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_LOGIN_PAGE)
    public void openLoginPage(@BridgeContext IBridgeContext r100) {
        BytedCertManager.getInstance().executeInMainThread(new g(this));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SET_PAGE_LOADED)
    public void setPageLoaded(@BridgeContext IBridgeContext r100) {
        if (BytedCertManager.getInstance().getCertConfig().isEnableWebBack() == false) goto L9;
        Activity r101 = getContext();
        if (r101 != null) goto L7;
        return;
    L7:
        r101.runOnUiThread(new k(this));
        return;
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_ADD_EVENT_LISTENER)
    public void addEventListener(@BridgeContext IBridgeContext r100, @BridgeParam("name") String r101) {
        q r102 = new q(this, r101);
        EventCenter.registerJsEventSubscriber(r101, r102);
        ((HashMap) this.f407825n).put(r101, r102);
        r100.callback(BridgeResult.Companion.createSuccessResult());
    }

    public final void b(Pair<Integer, String> r100, String r101) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L5;
        int r104 = ((Integer) r100.first).intValue();
        String r105 = (String) r100.second;
    L18:
        r102.put("status_code", r104);     // Catch: Exception -> L15
        r102.put("description", r105);     // Catch: Exception -> L15
        Activity r106 = getContext();     // Catch: Exception -> L15
        if (r106 == null) goto L9;
        r103.put("camera_valid", SystemInfoTools.isCameraValid(r106));     // Catch: Exception -> L15
    L9:
        if (r104 != 0) goto L11;
        r103.put("image_b64", r101);     // Catch: Exception -> L15
        r103.put("stay_inner_time", String.valueOf(BytedCertManager.getInstance().mImgTimeDelta));     // Catch: Exception -> L15
        r103.put("upload_type", BytedCertManager.getInstance().mImgType);     // Catch: Exception -> L15
    L11:
        r102.put("data", r103);     // Catch: Exception -> L15
        IBridgeContext r107 = this.f407814c;     // Catch: Exception -> L15
        if (r107 == null) goto L20;
        r107.callback(BridgeResult.Companion.createSuccessResult(r102));     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
        return;
    L5:
        r104 = 0;
        r105 = "";
        goto L18
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_CLOSE_PAGE)
    public void closePage(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r101) {
        BytedCertManager.getInstance().executeInMainThread(new com.ss.android.bytedcert.web.v1.a(this, r101, r100, null));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_CN_NET_AUTH)
    public void openCNNetAuth(@BridgeContext IBridgeContext r100, @BridgeParam("type") int r101) {
        ysa.a r102 = (ysa.a) ((HashMap) this.f407813b).get(BytedCertConstant.JsbKey.METHOD_OPEN_CN_NET_AUTH);
        if (r102 == null) goto L6;
        r102.a(getContext(), r100, new Object[]{Integer.valueOf(r101)});
        return;
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_REMOVE_EVENT_LISTENER)
    public void removeEventListener(@BridgeContext IBridgeContext r100, @BridgeParam("name") String r101) {
        JsEventSubscriber r102 = (JsEventSubscriber) ((HashMap) this.f407825n).remove(r101);
        if (r102 == null) goto L5;
        EventCenter.unregisterJsEventSubscriber(r101, r102);
    L5:
        r100.callback(BridgeResult.Companion.createSuccessResult());
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SHOW_LOADING)
    public void showLoading(@BridgeContext IBridgeContext r100, @BridgeParam("message") String r101) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f407819h != null) goto L5;
        this.f407819h = LoadingDialog.create(getContext(), r101);     // Catch: Exception -> L7
    L5:
        rsa.b.c(this.f407819h);     // Catch: Exception -> L7
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_START_NFC)
    public void startNFC(@BridgeContext IBridgeContext r100, @BridgeParam("type") String r101) {
        ysa.a r102 = (ysa.a) ((HashMap) this.f407813b).get(BytedCertConstant.JsbKey.METHOD_START_NFC);
        if (r102 == null) goto L6;
        r102.a(getContext(), r100, new Object[]{BytedCertConstant.JsbKey.METHOD_START_NFC, r101, new p(this)});
        return;
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SWITCH_LANGUAGE)
    public void switchLanguage(@BridgeContext IBridgeContext r100, @BridgeParam("language") String r101) {
        this.f407821j.switchLanguage(getContext(), r101);
        r100.callback(BridgeResult.Companion.createSuccessResult());
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_TOAST)
    public void toast(@BridgeContext IBridgeContext r100, @BridgeParam("message") String r101) {
        BytedCertManager.getInstance().executeInMainThread(new n(r100, r101));
        r100.callback(BridgeResult.Companion.createSuccessResult());
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_TRACK_FLOW_ABILITY)
    public void trackFlowAbility(@BridgeContext IBridgeContext r100, @BridgeParam("name") String r101) {
        this.f407821j.getMonitorManager().a(r101);
    }

    public JSModule(Activity r100, WebView r101, BytedCertFlow r102) {
        HashMap r103 = new HashMap();
        this.f407813b = r103;
        this.f407814c = null;
        this.f407815d = null;
        this.f407819h = null;
        this.f407820i = false;
        this.f407825n = new HashMap();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f407812a = r101;
        if (r100 == null) goto L8;
        this.f407815d = new WeakReference(r100);
    L8:
        this.f407821j = r102;
        this.f407824m = new FetchJSBRequestService(new BCNetworkUtils(r102));
        JsBridgeManager.INSTANCE.delegateJavaScriptInterface(this.f407812a);
        JSBridgeAuthenticator r104 = JSBridgeAuthenticator.inst();
        if (xsa.a.f565046b == null) goto L11;
    L20:
        r104.add(xsa.a.f565046b);
        this.f407812a.setWebViewClient(new h());
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(this, this.f407812a);
        r103.put(BytedCertConstant.JsbKey.METHOD_TAKE_OCR_PHOTO, new zsa.b());
        zsa.a r105 = new zsa.a();
        r103.put(BytedCertConstant.JsbKey.METHOD_START_NFC, r105);
        r103.put(BytedCertConstant.JsbKey.METHOD_STOP_NFC, r105);
        r103.put(BytedCertConstant.JsbKey.METHOD_CAN_I_USE_NFC, r105);
        r103.put(BytedCertConstant.JsbKey.METHOD_OPEN_CN_NET_AUTH, new zsa.c());
        return;
    L11:
        monitor-enter(xsa.a.class);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (xsa.a.f565046b != null) goto L15;
        xsa.a.f565046b = new xsa.a();     // Catch: Throwable -> L17
    L15:
        monitor-exit(xsa.a.class);     // Catch: Throwable -> L17
        goto L20
    }

    public static void a(JSModule r100, IBridgeContext r101, int r102) {
        r100.getClass();
        if (r101 == null) goto L12;
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, r102);     // Catch: Exception -> L7
        r103.put("status_code", 0);     // Catch: Exception -> L7
        r103.put("data", r104);     // Catch: Exception -> L7
        r101.callback(BridgeResult.Companion.createSuccessResult(r103));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void d(IBridgeContext r100, CertResponse r101, JSONObject r102) {
        if (r100 == null) goto L15;
        if (r102 == null) goto L13;
    L7:
        if (r102 != null) goto L9;
        r102 = new JSONObject();     // Catch: Exception -> L5
    L9:
        r102.put("status_code", r101.errorCode);     // Catch: Exception -> L5
        r102.put("description", r101.errorMsg);     // Catch: Exception -> L5
        r102.put("detail_error_code", r101.detailErrorCode);     // Catch: Exception -> L5
        r102.put("detail_error_message", r101.detailErrorMsg);     // Catch: Exception -> L5
        r100.callback(BridgeResult.Companion.createSuccessResult(r102));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r102 = r101.jsonBody;     // Catch: Exception -> L5
        goto L7
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_AND_CLOSE)
    public void openAndClose(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r101, @BridgeParam("url") String r102) {
        BytedCertManager.getInstance().executeInMainThread(new com.ss.android.bytedcert.web.v1.a(this, r101, r100, r102));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_WEB_EVENT)
    public void receiveWebEvent(@BridgeContext IBridgeContext r100, @BridgeParam("event") String r101, @BridgeParam("data") JSONObject r102) {
        IWebEventCallback r103 = this.f407821j.getWebEventCallback();
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103 instanceof IWebEventCallbackV2) == false) goto L7;
        CertLog.d("JSModule", "receive webEvent v2:" + r101 + ";data:" + r102);
        ((IWebEventCallbackV2) r103).onWebEventV2(getContext(), r101, r102, new c(r101, r100));
        return;
    L7:
        CertLog.d("JSModule", "receive webEvent:" + r101 + ";data:" + r102);
        r103.onWebEvent(r101, r102);
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SEND_LOG)
    public void sendAppLog(@BridgeContext IBridgeContext r100, @BridgeParam("params") String r101, @BridgeParam("eventName") String r102) {
        this.f407821j.onEvent(r102, new JSONObject(r101));     // Catch: Exception -> L4
        r100.callback(BridgeResult.Companion.createSuccessResult());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SEND_EVENT)
    public void sendEvent(@BridgeContext IBridgeContext r100, @BridgeParam("name") String r101, @BridgeParam("data") JSONObject r102) {
        EventCenter.enqueueEvent(new Event(r101, System.currentTimeMillis(), new ReadableMapImpl(r102)));
        r100.callback(BridgeResult.Companion.createSuccessResult());
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_TAKE_OCR_PHOTO)
    public void takeOCRPhoto(@BridgeContext IBridgeContext r100, @BridgeParam("type") String r101, @BridgeParam(defaultString = "landscape", value = "orientation") String r102) {
        ysa.a r103 = (ysa.a) ((HashMap) this.f407813b).get(BytedCertConstant.JsbKey.METHOD_TAKE_OCR_PHOTO);
        if (r103 == null) goto L6;
        r103.a(getContext(), r100, new Object[]{r101, this.f407821j.getFlowId(), r102});
        return;
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_UPLOAD_EVENT)
    public void uploadEvent(@BridgeContext IBridgeContext r100, @BridgeParam("event") String r101, @BridgeParam("message") String r102) {
        JSONObject r103 = new JSONObject(r102);     // Catch: Exception -> L4
    L5:
        this.f407821j.onEvent(r101, r103);
        JSONObject r104 = new JSONObject();
        r104.put("status_code", 0);     // Catch: Exception -> L8
        r100.callback(BridgeResult.Companion.createSuccessResult(r104));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        r103 = null;
        goto L5
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_UPLOAD_PHOTO)
    public void uploadPhoto(@BridgeContext IBridgeContext r100, @BridgeParam("type") String r110, @BridgeParam(defaultInt = 85, value = "compress_ratio_net_android") int r111) {
        this.f407821j.getRequestUtils().b(getContext(), new w(this, r100), r110, r111, false, this.f407821j.appendCommonRequestParams(null));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_PRE_MANUAL_CHECK)
    public void PreManualCheck(@BridgeContext IBridgeContext r110, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_CODE) String r111, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_NAME) String r112, @BridgeParam("identity_type") String r113) {
        psa.a r100 = this.f407821j.getRequestUtils();
        Activity r101 = getContext();
        e r102 = new e(this, r110);
        Map<String, String> r103 = this.f407821j.appendCommonRequestParams(null);
        r100.getClass();
        new psa.i(r100, r103, r101, r111, r112, r113, r102).start();
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_DO_REQUEST)
    public void doRequest(@BridgeContext IBridgeContext r100, @BridgeParam(com.alipay.sdk.m.p.e.f25671s) String r101, @BridgeParam("path") String r102, @BridgeParam("data") JSONObject r103) {
        this.f407821j.getRequestUtils().c(new i(this, r100), r101, r102, this.f407821j.appendCommonRequestParams(FetchJSBRequestService.getParams(r103.toString())));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_VIDEO_CERT)
    public void faceVideoLive(@BridgeContext final IBridgeContext r100, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_CODE) final String r110, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_NAME) final String r111, @BridgeParam("event_params") final JSONObject r112) {
        BytedCertManager.getInstance().executeInMainThread(new AnonymousClass8(this, r110, r111, r112, r100));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_VIDEO_RECORD)
    public void openVideoRecord(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r101, @BridgeParam("view") String r102, @BridgeParam("language") String r110) {
        Activity r103 = r100.getActivity();
        if (r103 != null) goto L6;
        d(r100, new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN), null);
        return;
    L6:
        this.f407821j.startVideoRecord(r103, rsa.e.a(r101), r102, r110, new l(r100));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SET_CERT_STATUS)
    public void setCertStatus(@BridgeContext IBridgeContext r100, @BridgeParam("cert_status") int r101, @BridgeParam("manual_status") int r102, @BridgeParam("age_range") int r103) {
        if (this.f407822k != null) goto L5;
        this.f407822k = new CertResult();
    L5:
        this.f407822k.setCertStatus(r101);
        this.f407822k.setManualStatus(r102);
        this.f407822k.setAgeRange(r103);
        if (r100 == null) goto L9;
        r100.callback(BridgeResult.Companion.createSuccessResult());
        return;
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_PAGE)
    public void openPage(@BridgeContext IBridgeContext r100, @BridgeParam("type") String r101, @BridgeParam("title") String r102, @BridgeParam("url") String r103, @BridgeParam("hide_nav_bar") int r104) {
        JSONObject r105 = new JSONObject();
        r105.put("url", r103);     // Catch: JSONException -> L6
        r105.put("type", r101);     // Catch: JSONException -> L6
        r105.put("title", r102);     // Catch: JSONException -> L6
        r105.put("hide_nav_bar", r104);     // Catch: JSONException -> L6
    L4:
        receiveWebEvent(r100, SendEventContainerMethodParamModel.EventKinds.openPage, r105);
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_UPLOAD)
    public void upload(@BridgeContext IBridgeContext r110, @BridgeParam("type") String r111, @BridgeParam("url") String r112, @BridgeParam("file_name") String r113, @BridgeParam("params") String r114) {
        psa.a r100 = this.f407821j.getRequestUtils();
        Activity r101 = getContext();
        a r102 = new a(this, r110);
        Map<String, String> r103 = this.f407821j.appendCommonRequestParams(FetchJSBRequestService.getParams(r114));
        r100.getClass();
        new psa.g(r100, r103, r111, r101, r113, r112, r102).start();
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_LAUNCH_FLOW)
    public void launchFlow(@BridgeContext IBridgeContext r100, @BridgeParam("scene") String r101, @BridgeParam("aid") String r102, @BridgeParam(BytedCertConstant.CertKey.FLOW) String r103, @BridgeParam("ticket") String r104, @BridgeParam("h5_query_params") JSONObject r105) {
        HashMap r106 = new HashMap();
        r106.put("scene", r101);
        r106.put("cert_app_id", r102);
        r106.put(BytedCertConstant.CertKey.FLOW, r103);
        if (TextUtils.isEmpty(r104) == true) goto L5;
        r106.put("ticket", r104);
    L5:
        if (r105 == null) goto L15;
        Iterator<String> r107 = r105.keys();
    L8:
        if (r107.hasNext() == false) goto L15;
        String r108 = r107.next();
        String r109 = r105.optString(r108);
        if (TextUtils.isEmpty(r108) == true) goto L8;
        if (TextUtils.isEmpty(r109) == true) goto L8;
        r106.put("h5-params-" + r108, r109);
    L15:
        if (r106.containsKey("use_new_api") == true) goto L17;
        r106.put("use_new_api", "true");
    L17:
        BytedCertManager.getInstance().startBytedCert(new BytedCertFlowParams.Builder(getContext()).setCertInfo(r106).setWebEventCallback(this.f407821j.getWebEventCallback()).setH5CallBack(new m(this, r100)).build());
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_MANUALLY_VERIFY)
    public void manuallyVerify(@BridgeContext IBridgeContext r110, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_CODE) String r111, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_NAME) String r112, @BridgeParam("identity_type") String r113, @BridgeParam("type") String r114, @BridgeParam(defaultInt = 85, value = "compress_ratio_net_android") int r115) {
        if (r115 > 0) goto L5;
        int r100 = 85;
    L6:
        psa.a r101 = this.f407821j.getRequestUtils();
        Activity r116 = getContext();
        d r117 = new d(this, r110);
        boolean r118 = this.f407821j.getCertInfo().f526576j;
        Map<String, String> r102 = this.f407821j.appendCommonRequestParams(null);
        r101.getClass();
        new psa.b(r101, r102, r111, r112, r113, r114, r100, r116, r118, r117).start();
        return;
    L5:
        r100 = r115;
        goto L6
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_SHOW_DIALOG)
    public void dialogShow(@BridgeContext IBridgeContext r110, @BridgeParam("type") int r111, @BridgeParam("scene_id") int r112, @BridgeParam("title") String r113, @BridgeParam("message") String r114, @BridgeParam("key_1") String r115, @BridgeParam("key_2") String r116) {
        BytedCertManager.getInstance().executeInMainThread(new f(this, r111, r112, r113, r114, r115, r116, r110));
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_OPEN_FACE_LIVE)
    public void faceLive(@BridgeContext final IBridgeContext r100, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_CODE) String r101, @BridgeParam(BytedCertConstant.CertKey.IDENTITY_NAME) String r102, @BridgeParam("should_close_after_success") boolean r103, @BridgeParam("close_page_params") JSONObject r104, @BridgeParam("set_cert_status_params") JSONObject r105, @BridgeParam("data") JSONObject r106, @BridgeParam("event_params") JSONObject r110, @BridgeParam("show_loading") boolean r111, @BridgeParam("language") String r112) {
        this.f407823l = r104.optJSONObject("data");
        if (r105 == null) goto L5;
        setCertStatus(null, r105.optInt("cert_status"), r105.optInt("manual_status"), r105.optInt("age_range"));
    L5:
        osa.b r107 = this.f407821j.getCertInfo();
        r107.f526588v = r110;
        r107.B = r103;
        r107.f526571e = r101;
        r107.f526572f = r102;
        this.f407821j.doFaceLive(new FaceDetectFlowParams.Builder(getContext()).setCertInfo(rsa.e.a(r106)).setShowLoading(r111).setLanguage(r112).setFaceLiveCallback(new AnonymousClass7(this, r100)).build());
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_BYTED_CERT_FETCH)
    public void fetch(@BridgeContext IBridgeContext r110, @BridgeParam(required = true, value = "url") String r111, @BridgeParam(defaultString = MonitorConstants.CONNECT_TYPE_GET, value = com.alipay.sdk.m.p.e.f25671s) String r112, @BridgeParam(defaultString = "form", value = "requestType") String r113, @BridgeParam("header") String r114, @BridgeParam("params") String r115, @BridgeParam("data") String r116, @BridgeParam(defaultLong = -1, value = "timeout") long r117, @BridgeParam("ignorePrefetch") boolean r210, @BridgeParam(defaultBoolean = true, value = "append_cert_params") boolean r211) {
        if (TextUtils.isEmpty(r111) == false) goto L18;
    L12:
        String r100 = r111;
    L13:
        FetchJSBRequest r101 = new FetchJSBRequest(r100, r112, r113, r114, r115, r116, Long.valueOf(r117));
        if (r211 == false) goto L16;
        r101.setCommonRequestParams(this.f407821j.appendCommonRequestParams(null));
    L16:
        r101.setRequestUseUrl(true);
        new j(this, r101, r110).start();
        return;
    L18:
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        if (new URI(r111).getHost() != null) goto L8;
        String r102 = UrlConstant.getBaseUrl() + r111;     // Catch: URISyntaxException -> L10
    L9:
        r100 = r102;
        goto L13
    L8:
        r102 = r111;
        goto L9
    }

    @BridgeMethod(BytedCertConstant.JsbKey.METHOD_TAKE_PHOTO)
    public void takePhoto(@BridgeContext IBridgeContext r100, @BridgeParam("max_side") int r101, @BridgeParam("type") String r102, @BridgeParam("is_only_camera") boolean r103, @BridgeParam(defaultInt = 85, value = "compress_ratio_web_android") int r104, @BridgeParam("orientation") String r105, @BridgeParam("title") String r106, @BridgeParam(SocialConstants.PARAM_APP_DESC) String r110, @BridgeParam("default_camera_position") String r111, @BridgeParam("show_album_entry") boolean r112, @BridgeParam("show_camera_switcher") boolean r113, @BridgeParam("hide_mask") boolean r114, @BridgeParam("language") String r115) {
        if (r101 != 0) goto L4;
        r101 = 400;
    L4:
        if (r104 > 0) goto L6;
        r104 = 85;
    L6:
        this.f407814c = r100;
        this.f407816e = r102;
        this.f407817f = r101;
        this.f407818g = r104;
        Activity r107 = getContext();
        if (r107 != null) goto L10;
        c(ErrorConstant.Client.ERROR_UNKNOWN);
        return;
    L10:
        r r108 = new r(this);
        if (TextUtils.isEmpty(r115) == false) goto L13;
        r115 = this.f407821j.getLanguage();
    L13:
        qsa.o r109 = new qsa.o(this.f407816e);
        r109.f534714b = this.f407821j.getFlowId();
        r109.f534715c = r105;
        r109.f534716d = r106;
        r109.f534717e = r110;
        r109.f534718f = r111;
        r109.f534719g = r112;
        r109.f534720h = r113;
        r109.f534721i = r114;
        r109.f534722j = r115;
        qsa.n r116 = new qsa.n(r109);
        if (r103 == false) goto L16;
        BytedCertManager.getInstance().executeInMainThread(new s(this, r107, r115, r116, r108));
        return;
    L16:
        String r117 = r115;
        new PickPhotoDialog(r107).show(getContext(), this.f407816e, this.f407821j.getFlowId(), r117, new t(this), new u(this, r107, r115, r116, r108), new v(this));
    }
}
