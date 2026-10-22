package vr5;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.bytedance.ee.lark.component.core.settings.NativeComponentSdkConfig;
import com.bytedance.ee.lark.component.core.view.NativeViewLayout2;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officewebview.webview_api.bridge.Status;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements qxb.a<String, pxb.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pxb.a f556918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final as5.b f556919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public as5.c f556920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f556921d;

    @Override // qxb.a
    public final void shouldRunInUIThread() {
    }

    public c(pxb.a r100, String r101, as5.b r102) {
        this.f556918a = r100;
        this.f556921d = r101;
        this.f556919b = r102;
    }

    @Override // qxb.a
    public final void a(Object r110, qxb.c r111, pxb.a r112) {
        String r113 = (String) r110;
        OPTrace r100 = gyb.a.a().subTrace(this.f556921d);
        OPMonitorCode r101 = new OPMonitorCode("client.open_platform.api.common", 10002, OPMonitorLevel.NORMAL, "native_receive_invoke");
        String r102 = "";
        if (r113 != null) goto L39;
        String r103 = "";
    L11:
        OPMonitor r104 = new OPMonitor(r101);
        r104.addCategoryValue("api_name", this.f556921d);
        if (r113 != null) goto L14;
        int r105 = 0;
    L15:
        r104.addCategoryValue("param.length", Integer.valueOf(r105));
        r104.addCategoryValue("is_native_component", 1);
        r104.addCategoryValue("native_component_type", r102);
        if (TextUtils.isEmpty(r103) == true) goto L18;
        r104.addCategoryValue("native_component_method", r103);
    L18:
        r104.flush(r100);
        if (TextUtils.isEmpty(r113) == false) goto L21;
        b(b.f556912g, null, r111, Status.FAILURE, new JSONObject(), r100);
        Log.i("NativeComponentBridge", "data is empty");
        return;
    L21:
        as5.c r106 = tr5.b.a.f547309a.f547307a;
        this.f556920c = r106;
        if (r106 != null) goto L38;
        Log.e("NativeComponentBridge", "registerHandler, componentTypeProvider is null, handlerName = " + this.f556921d);
        return;
    L38:
        JSONObject r107 = new JSONObject(r113);     // Catch: JSONException -> L34
        String r114 = r107.optString("type");     // Catch: JSONException -> L34
        if (this.f556920c.b(r112, r114) != null) goto L32;
        as5.c r108 = this.f556920c;     // Catch: JSONException -> L34
        if (((ConcurrentHashMap) r108.f16133a).containsKey(r114) == false) goto L29;
        Class r109 = (Class) ((ConcurrentHashMap) r108.f16133a).get(r114);     // Catch: JSONException -> L34
    L30:
        if (r109 != null) goto L32;
        Log.e("NativeComponentBridge", "NativeComponentHandler handle, component: " + r114 + " not registered");     // Catch: JSONException -> L34
        b(b.f556910e, r107, r111, Status.FAILURE, r107, r100);     // Catch: JSONException -> L34
        return;
    L29:
        Log.e("NativeComponentTypeProviderImpl", "getNativeComponentClass, find viewType without class, viewType = " + r114);     // Catch: JSONException -> L34
        r109 = null;
    L32:
        c(r107, r111, r112, r100);     // Catch: JSONException -> L34
        return;
    L34:
        e = move-exception;
        Log.i("NativeComponentBridge", "NativeComponentHandler error, handler = " + this.f556921d + " e: " + e);
        b(b.f556912g, null, r111, Status.FAILURE, new JSONObject(), r100);
        return;
    L14:
        r105 = r113.length();
        goto L15
    L39:
        JSONObject r115 = new JSONObject(r113);     // Catch: JSONException -> L7
        String r116 = r115.optString("type");     // Catch: JSONException -> L7
        r102 = r115.optString(e.f25671s);     // Catch: JSONException -> L37
    L9:
        r103 = r102;
        r102 = r116;
    L8:
        Log.e("NativeComponentBridge", "monitorReceiveInvoke, json parse error");
    L7:
        r116 = "";
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(JSONObject r110, qxb.c r111, pxb.a r112, OPTrace r113) {
        String r100 = this.f556921d;
        r100.getClass();
        switch(r100.hashCode()) {
            case -2095915653: goto L18;
            case -345754730: goto L14;
            case 480322221: goto L10;
            case 1970446463: goto L6;
            default: goto L21;
        };
    L21:
        byte r101 = -1;
    L22:
        txb.a r102 = null;
        cs5.a r103 = 0;
        r103 = 0;
        r103 = 0;
        r103 = 0;
        r103 = 0;
        if (r101 != 0) goto L25;
        String r104 = r110.optString("id");
        Log.i("NativeComponentBridge", "deleteNativeComponent, id = " + r104);
        as5.b r105 = this.f556919b;
        r105.getClass();
        Log.d("NativeComponentManager", "remove nativeBaseComponent, viewId = " + r104);
        tr5.a r106 = r105.f16130b.get(r104);
        if (r106 == null) goto L97;
        Iterator<as5.a> r107 = r105.f16129a.iterator();
    L92:
        if (r107.hasNext() == false) goto L95;
        r107.next().a(r106);
        goto L92
    L95:
        if ((r106.getContainer() instanceof cs5.a) == false) goto L97;
        ((cs5.a) r106.getContainer()).b();
    L97:
        r105.f16130b.remove(r104);
        pxb.a r108 = r105.f16131c;
        Log.i("NativeComponentManager", "unRegisterPlatformView, viewId = " + r104);
        if (r108 != null) goto L101;
        Log.e("NativeComponentManager", "unRegisterPlatformView err, webView is null");
    L109:
        b(b.f556909d, r110, r111, Status.SUCCESS, new JSONObject(), r113);
        return;
    L101:
        if (TextUtils.isEmpty(r104) == false) goto L103;
        Log.e("NativeComponentManager", "unRegisterPlatformView err, viewId is empty");
        goto L109
    L103:
        txb.b r109 = r108.getServiceManager();
        if (r109 == null) goto L106;
        r102 = (txb.a) r109.getService(txb.a.class);
    L106:
        if (r102 == null) goto L108;
        r102.h(r104);
        goto L109
    L108:
        Log.e("NativeComponentManager", "unRegisterPlatformView err, renderInWebViewService is null");
        goto L109
    L25:
        if (r101 != 1) goto L27;
        String r114 = r110.optString("id");
        String r115 = r110.optString(e.f25671s);
        Log.d("NativeComponentBridge", "nativeComponentDispatchAction, id = " + r114 + " method = " + r115);
        JSONObject r116 = r110.optJSONObject("data");
        if (r116 != null) goto L72;
        Log.e("NativeComponentBridge", "nativeComponentDispatchAction error with empty data");
        b(b.f556912g, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L72:
        tr5.a r117 = this.f556919b.f16130b.get(r114);
        if (r117 != null) goto L76;
        Log.e("NativeComponentBridge", "updateNativeComponent, nativeBaseComponent not exist");
        b(b.f556914i, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L76:
        if ("reRender".equals(r115) == false) goto L87;
        tr5.a r118 = this.f556919b.f16130b.get(r114);
        if (r118 != null) goto L80;
        Log.e("NativeComponentBridge", "reRender, nativeBaseComponent not exist");
        b(b.f556914i, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L80:
        ViewGroup r119 = r118.getContainer();
        if (r119 != null) goto L84;
        Log.e("NativeComponentBridge", "reRender, nativeBaseComponent not exist");
        b(b.f556911f, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L84:
        if (r119.getParent() == null) goto L86;
        Log.e("NativeComponentBridge", "reRender, nativeLayout has already added");
        b(b.f556909d, new JSONObject(), r111, Status.SUCCESS, new JSONObject(), r113);
        return;
    L86:
        Log.d("NativeComponentBridge", "reRender, id = " + r114);
        as5.b r120 = this.f556919b;
        ViewGroup r121 = r118.getContainer();
        r120.getClass();
        as5.b.b(r112, r114, r121);
        b(b.f556909d, new JSONObject(), r111, Status.SUCCESS, new JSONObject(), r113);
        return;
    L87:
        r117.performAction(r115, JSON.parseObject(r116.toString()));
        b(b.f556909d, r110, r111, Status.SUCCESS, new JSONObject(), r113);
        return;
    L27:
        if (r101 == 2) goto L37;
        if (r101 == 3) goto L30;
        Log.e("NativeComponentBridge", "no handler handle api = " + this.f556921d);
        return;
    L30:
        String r122 = r110.optString("id");
        String r123 = r110.optString("type");
        JSONObject r124 = r110.optJSONObject("data");
        if (r124 != null) goto L33;
        Log.e("NativeComponentBridge", "updateNativeComponent error with empty data");
        b(b.f556912g, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L33:
        tr5.a r125 = this.f556919b.f16130b.get(r122);
        if (r125 != null) goto L36;
        Log.e("NativeComponentBridge", "updateNativeComponent, nativeBaseComponent not exist");
        b(b.f556914i, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L36:
        Log.i("NativeComponentBridge", "updateNativeComponent, id = " + r122 + " type = " + r123);
        r125.updateData(JSON.parseObject(r124.toString()));
        this.f556919b.update(r125);
        b(b.f556909d, r110, r111, Status.SUCCESS, new JSONObject(), r113);
        return;
    L37:
        String r126 = r110.optString("id");
        String r127 = r110.optString("type");
        Log.i("NativeComponentBridge", "insertNativeComponent, id = " + r126 + " type = " + r127);
        JSONObject r128 = r110.optJSONObject("data");
        if (r128 != null) goto L111;
        Log.e("NativeComponentBridge", "insertNativeComponent error with empty data");
        b(b.f556912g, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L111:
    L67:
        e = move-exception;
        Log.e("NativeComponentBridge", "insertNativeComponent exception = " + e);
        b(b.f556912g, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L41:
        if (this.f556919b.f16130b.get(r126) == null) goto L43;
        Log.e("NativeComponentBridge", "insertNativeComponent already inserted");     // Catch: JSONException -> L67
        b(b.f556913h, null, r111, Status.FAILURE, new JSONObject(), r113);     // Catch: JSONException -> L67
        return;
    L43:
        AbstractNativeComponent r129 = this.f556920c.a(this.f556919b.f16132d, r126, r127);     // Catch: JSONException -> L67
        if (r129 != null) goto L47;
        Log.e("NativeComponentBridge", "insertNativeComponent, nativeBaseComponent not exist");     // Catch: JSONException -> L67
        b(b.f556914i, null, r111, Status.FAILURE, new JSONObject(), r113);     // Catch: JSONException -> L67
        return;
    L47:
        if (this.f556919b.f16132d.getContext() != null) goto L50;
        Log.e("NativeComponentBridge", "insertNativeComponent, context is null");     // Catch: JSONException -> L67
        b(b.f556911f, null, r111, Status.FAILURE, new JSONObject(), r113);     // Catch: JSONException -> L67
        return;
    L50:
        if (NativeComponentSdkConfig.isPlatformViewPluginReuse() == true) goto L52;
    L60:
        if (r103 != 0) goto L65;
        Log.i("NativeComponentBridge", "insertNativeComponent create new nativeViewLayout, refactor=" + NativeComponentSdkConfig.isNativeViewLayoutRefactor());     // Catch: JSONException -> L67
        if (NativeComponentSdkConfig.isNativeViewLayoutRefactor() == false) goto L64;
        r103 = new NativeViewLayout2(this.f556919b.f16132d.getContext());     // Catch: JSONException -> L67
        goto L65
    L64:
        r103 = new cs5.b(this.f556919b.f16132d.getContext());     // Catch: JSONException -> L67
    L65:
        r103.setNativeComponentProvider(this.f556919b);     // Catch: JSONException -> L67
        r103.a(r126);     // Catch: JSONException -> L67
        r129.bindContainer((ViewGroup) r103);     // Catch: JSONException -> L67
        r129.bindData(new yr5.a(r126, r127, JSON.parseObject(r128.toString())));     // Catch: JSONException -> L67
        this.f556919b.a(r129);     // Catch: JSONException -> L67
        JSONObject r130 = new JSONObject();     // Catch: JSONException -> L67
        r130.put("id", r126);     // Catch: JSONException -> L67
        b(b.f556909d, r110, r111, Status.SUCCESS, r130, r113);     // Catch: JSONException -> L67
        return;
    L52:
        if (this.f556918a.getServiceManager() == null) goto L60;
        rxb.b r131 = ((txb.a) this.f556918a.getServiceManager().getService(txb.a.class)).c(r126);     // Catch: JSONException -> L67
        if (r131 == null) goto L60;
        if (r131.a() == null) goto L60;
        if ((r131.a().b(r126) instanceof cs5.a) == false) goto L60;
        Log.i("NativeComponentBridge", "insertNativeComponent, find plugin, reuse");     // Catch: JSONException -> L67
        r103 = (cs5.a) r131.a().b(r126);     // Catch: JSONException -> L67
        goto L60
    L6:
        if (r100.equals("updateNativeComponentAttribute") == false) goto L21;
        r101 = 3;
        goto L22
    L10:
        if (r100.equals("insertNativeComponent") == false) goto L21;
        r101 = 2;
        goto L22
    L14:
        if (r100.equals("nativeComponentDispatchAction") == false) goto L21;
        r101 = 1;
        goto L22
    L18:
        if (r100.equals("deleteNativeComponent") == false) goto L21;
        r101 = 0;
        goto L22
    }

    public final void b(b r110, JSONObject r111, qxb.c r112, Status r113, JSONObject r114, OPTrace r210) {
        Log.i("NativeComponentBridge", "callbackResult, handleName = " + this.f556921d + " status = " + r113);
        OPMonitorCode r100 = new OPMonitorCode("client.open_platform.api.common", 10003, OPMonitorLevel.NORMAL, "native_callback_invoke");
        if (r111 == null) goto L5;
        String r101 = r111.optString("id");
        String r102 = r111.optString("type");
        String r103 = r111.optString(e.f25671s);
        String r115 = r101;
        String r116 = r102;
    L6:
        OPMonitor r104 = new OPMonitor(r100);
        r104.addCategoryValue("errMsg", r110.f556917c);
        r104.addCategoryValue(LKBaseResponseModel.INNER_MSG_KEY, r110.f556917c);
        r104.addCategoryValue("errCode", Integer.valueOf(r110.f556915a));
        r104.addCategoryValue(LKBaseResponseModel.INNER_CODE_KEY, Integer.valueOf(r110.f556916b));
        r104.addCategoryValue("is_native_component", 1);
        r104.addCategoryValue("native_component_type", r116);
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r104.addCategoryValue("native_component_method", r103);
    L10:
        if (r113 != Status.SUCCESS) goto L12;
        r104.setResultTypeSuccess();
    L13:
        r104.flush(r210);
        OPTrace.Companion.getClass();
        r210.finish(new OPMonitor(OPTrace.BATCH_EVENT_NAME, OPTrace.access$getBATCH_MONITOR_CODE$cp()));
        zr5.b r105 = this.f556919b.f16132d.f551381c;
        if (r105 == null) goto L19;
        Iterator r117 = ((ArrayList) r105.f573431a).iterator();
    L17:
        if (r117.hasNext() == false) goto L19;
        ((zr5.a) r117.next()).a(this.f556921d, r115, r110, r116, r113, r210);
    L19:
        r112.a(r113, r114);
        return;
    L12:
        r104.setResultTypeFail();
        goto L13
    L5:
        r103 = "";
        r115 = r103;
        r116 = r115;
        goto L6
    }
}
