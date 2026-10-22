package com.tencent.connect.common;

import android.content.Intent;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class UIListenerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UIListenerManager f461564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, ApiTask> f461565b;

    public class ApiTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UIListenerManager f461566a;
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(UIListenerManager r100, int r101, IUiListener r102) {
            this.f461566a = r100;
            this.mRequestCode = r101;
            this.mListener = r102;
        }
    }

    public static UIListenerManager getInstance() {
        if (f461564a != null) goto L6;
        f461564a = new UIListenerManager();
    L6:
        return f461564a;
    }

    private UIListenerManager() {
        Map<String, ApiTask> r100 = Collections.synchronizedMap(new HashMap());
        this.f461565b = r100;
        if (r100 != null) goto L6;
        this.f461565b = Collections.synchronizedMap(new HashMap());
        return;
    }

    public IUiListener getListnerWithAction(String r100) {
        if (r100 != null) goto L6;
        SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
        return null;
    L6:
        Map<String, ApiTask> r101 = this.f461565b;
        monitor-enter(r101);
        ApiTask r102 = this.f461565b.get(r100);     // Catch: Throwable -> L14
        this.f461565b.remove(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.mListener;
    L14:
        th = move-exception;
        throw th;
    }

    public IUiListener getListnerWithRequestCode(int r100) {
        String r101 = k.a(r100);
        if (r101 != null) goto L7;
        SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + r100);
        return null;
    L7:
        return getListnerWithAction(r101);
    }

    private IUiListener a(int r100, IUiListener r101) {
        if (r100 != 11101) goto L6;
        SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
    L11:
        return r101;
    L6:
        if (r100 != 11105) goto L9;
        SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        goto L11
    L9:
        if (r100 != 11106) goto L11;
        SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        goto L11
    }

    public void handleDataToListener(Intent r100, IUiListener r101) {
        SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (r100 != null) goto L6;
        r101.onCancel();
        return;
    L6:
        String r102 = r100.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(r102) == false) goto L19;
        int r103 = r100.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (r103 != 0) goto L17;
        String r104 = r100.getStringExtra(Constants.KEY_RESPONSE);
        if (r104 != null) goto L39;
        SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
        r101.onComplete(new JSONObject());
        return;
    L39:
        r101.onComplete(m.d(r104));     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        r101.onError(new UiError(-4, Constants.MSG_JSON_ERROR, r104));
        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
        return;
    L17:
        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + r103 + "");
        r101.onError(new UiError(r103, r100.getStringExtra(Constants.KEY_ERROR_MSG), r100.getStringExtra(Constants.KEY_ERROR_DETAIL)));
        return;
    L19:
        if ("action_share".equals(r102) == false) goto L44;
        String r105 = r100.getStringExtra("result");
        String r106 = r100.getStringExtra("response");
        if ("cancel".equals(r105) == false) goto L24;
        r101.onCancel();
        return;
    L24:
        if ("error".equals(r105) == false) goto L27;
        r101.onError(new UiError(-6, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, r106 + ""));
        return;
    L27:
        if (BitableAnalytic.SelectSceneClickType.COMPLETE.equals(r105) == false) goto L47;
    L34:
        e = move-exception;
        e.printStackTrace();
        r101.onError(new UiError(-4, "json error", r106 + ""));
        return;
    L29:
        if (r106 != null) goto L31;
        String r107 = "{\"ret\": 0}";
    L32:
        r101.onComplete(new JSONObject(r107));     // Catch: JSONException -> L34
        return;
    L31:
        r107 = r106;
        goto L32
    L47:
        return;
    }

    public Object setListenerWithRequestcode(int r100, IUiListener r101) {
        String r102 = k.a(r100);
        if (r102 != null) goto L6;
        SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + r100);
        return null;
    L6:
        Map<String, ApiTask> r103 = this.f461565b;
        monitor-enter(r103);
        ApiTask r104 = this.f461565b.put(r102, new ApiTask(this, r100, r101));     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.mListener;
    L14:
        th = move-exception;
        throw th;
    }

    public Object setListnerWithAction(String r100, IUiListener r101) {
        int r102 = k.b(r100);
        if (r102 != (-1)) goto L6;
        SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + r100);
        return null;
    L6:
        Map<String, ApiTask> r103 = this.f461565b;
        monitor-enter(r103);
        ApiTask r104 = this.f461565b.put(r100, new ApiTask(this, r102, r101));     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.mListener;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean onActivityResult(int r110, int r111, Intent r112, IUiListener r210) {
        SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + r110 + " res=" + r111);
        IUiListener r100 = getListnerWithRequestCode(r110);
        if (r100 != null) goto L10;
        if (r210 == null) goto L6;
        r100 = a(r110, r210);
        goto L10
    L6:
        SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
        return false;
    L10:
        if (r111 == (-1)) goto L12;
        r100.onCancel();
        return true;
    L12:
        if (r112 != null) goto L15;
        r100.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
        return true;
    L15:
        String r101 = r112.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(r101) == false) goto L28;
        int r102 = r112.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (r102 != 0) goto L26;
        String r103 = r112.getStringExtra(Constants.KEY_RESPONSE);
        if (r103 != null) goto L77;
        SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
        r100.onComplete(new JSONObject());
        return true;
    L77:
        r100.onComplete(m.d(r103));     // Catch: JSONException -> L23
        return true;
    L23:
        e = move-exception;
        r100.onError(new UiError(-4, Constants.MSG_JSON_ERROR, r103));
        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
        return true;
    L26:
        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + r102 + "");
        r100.onError(new UiError(r102, r112.getStringExtra(Constants.KEY_ERROR_MSG), r112.getStringExtra(Constants.KEY_ERROR_DETAIL)));
        return true;
    L28:
        if ("action_share".equals(r101) == false) goto L30;
    L58:
        String r104 = r112.getStringExtra("result");
        String r105 = r112.getStringExtra("response");
        if ("cancel".equals(r104) == false) goto L62;
        r100.onCancel();
        return true;
    L62:
        if ("error".equals(r104) == false) goto L65;
        r100.onError(new UiError(-6, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, r105 + ""));
        return true;
    L65:
        if (BitableAnalytic.SelectSceneClickType.COMPLETE.equals(r104) == false) goto L96;
    L72:
        e = move-exception;
        SLog.e("openSDK_LOG.UIListenerManager", "JSONException", e);
        r100.onError(new UiError(-4, "json error", r105 + ""));
        return true;
    L67:
        if (r105 != null) goto L69;
        String r106 = "{\"ret\": 0}";
    L70:
        r100.onComplete(new JSONObject(r106));     // Catch: JSONException -> L72
        return true;
    L69:
        r106 = r105;
        goto L70
    L96:
        return true;
    L30:
        if ("action_request_avatar".equals(r101) == true) goto L58;
        if ("action_request_dynamic_avatar".equals(r101) == true) goto L58;
        if ("action_request_set_emotion".equals(r101) == true) goto L58;
        if ("guildOpen".equals(r101) == true) goto L58;
        if ("action_common_channel".equals(r101) == false) goto L49;
        int r107 = r112.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (r107 != 0) goto L48;
        String r108 = r112.getStringExtra("response");
        if (r108 != null) goto L81;
        r100.onComplete(new JSONObject());
        return true;
    L81:
        String r109 = r112.getStringExtra("message");     // Catch: JSONException -> L46
        JSONObject r113 = m.d(r108);     // Catch: JSONException -> L46
        r113.put("message", r109);     // Catch: JSONException -> L46
        r100.onComplete(r113);     // Catch: JSONException -> L46
        return true;
    L46:
        r100.onError(new UiError(-4, Constants.MSG_JSON_ERROR, r108));
        return true;
    L48:
        r100.onError(new UiError(r107, r112.getStringExtra(Constants.KEY_ERROR_MSG), r112.getStringExtra(Constants.KEY_ERROR_DETAIL)));
        return true;
    L49:
        int r114 = r112.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (r114 != 0) goto L57;
        String r115 = r112.getStringExtra(Constants.KEY_RESPONSE);
        if (r115 != null) goto L79;
        r100.onComplete(new JSONObject());
        return true;
    L79:
        r100.onComplete(m.d(r115));     // Catch: JSONException -> L55
        return true;
    L55:
        r100.onError(new UiError(-4, Constants.MSG_JSON_ERROR, r115));
        return true;
    L57:
        r100.onError(new UiError(r114, r112.getStringExtra(Constants.KEY_ERROR_MSG), r112.getStringExtra(Constants.KEY_ERROR_DETAIL)));
        return true;
    }
}
