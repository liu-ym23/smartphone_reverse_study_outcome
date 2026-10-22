package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.SubInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f461557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected QQToken f461558c;

    public class TempRequestListener implements IRequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseApi f461559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IUiListener f461560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f461561c;

        public static /* synthetic */ IUiListener a(TempRequestListener r100) {
            return r100.f461560b;
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100;
            r101.what = 0;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -9;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -2;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -4;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -3;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -10;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -8;
            this.f461561c.sendMessage(r101);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception r100) {
            Message r101 = this.f461561c.obtainMessage();
            r101.obj = r100.getMessage();
            r101.what = -6;
            this.f461561c.sendMessage(r101);
        }

        public TempRequestListener(final BaseApi r100, IUiListener r101) {
            this.f461559a = r100;
            this.f461560b = r101;
            final Looper r102 = g.a().getMainLooper();
            this.f461561c = new AnonymousClass1(this, r102, r100);
        }
    }

    public void releaseResource() {
    }

    public Bundle a() {
        Bundle r100 = new Bundle();
        r100.putString(SubInfo.KEY_FORMAT, "json");
        r100.putString("status_os", Build.VERSION.RELEASE);
        r100.putString("status_machine", f.a().c(g.a()));
        r100.putString("status_version", Build.VERSION.SDK);
        r100.putString("sdkv", Constants.SDK_VERSION);
        r100.putString("sdkp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        QQToken r101 = this.f461558c;
        if (r101 != null) goto L5;
    L7:
        SharedPreferences r102 = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM == false) goto L10;
        r100.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
    L11:
        return r100;
    L10:
        r100.putString(Constants.PARAM_PLATFORM_ID, r102.getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        goto L11
    L5:
        if (r101.isSessionValid() == false) goto L7;
        r100.putString("access_token", this.f461558c.getAccessToken());
        r100.putString("oauth_consumer_key", this.f461558c.getAppId());
        r100.putString("openid", this.f461558c.getOpenId());
        goto L7
    }

    public Bundle b() {
        Bundle r100 = new Bundle();
        r100.putString("appid", this.f461558c.getAppId());
        if (this.f461558c.isSessionValid() == false) goto L5;
        r100.putString(Constants.PARAM_KEY_STR, this.f461558c.getAccessToken());
        r100.putString(Constants.PARAM_KEY_TYPE, "0x80");
    L5:
        String r101 = this.f461558c.getOpenId();
        if (r101 == null) goto L8;
        r100.putString("hopenid", r101);
    L8:
        r100.putString("platform", "androidqz");
        SharedPreferences r102 = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM == false) goto L11;
        r100.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
    L12:
        r100.putString("sdkv", Constants.SDK_VERSION);
        r100.putString("sdkp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        return r100;
    L11:
        r100.putString(Constants.PARAM_PLATFORM_ID, r102.getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        r100.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        goto L12
    }

    public Intent c() {
        Intent r100 = new Intent();
        if (m.c(g.a()) == false) goto L7;
        r100.setClassName(Constants.PACKAGE_QQ_PAD, "com.tencent.open.agent.AgentActivity");
        if (k.c(g.a(), r100) == false) goto L7;
        return r100;
    L7:
        r100.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
        if (k.c(g.a(), r100) == false) goto L10;
        return r100;
    L10:
        r100.setClassName(Constants.PACKAGE_TIM, "com.tencent.open.agent.AgentActivity");
        if (k.c(g.a(), r100) == false) goto L13;
        return r100;
    L13:
        return null;
    }

    public BaseApi(QQToken r100) {
        this(null, r100);
    }

    public static void INVOKEVIRTUAL_com_tencent_connect_common_BaseApi_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(TDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public String a(String r100) {
        Bundle r101 = a();
        StringBuilder r102 = new StringBuilder("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r101.putString("need_version", r100);
    L5:
        r102.append(HttpUtils.encodeUrl(r101));
        return r102.toString();
    }

    public Intent b(String r100) {
        Intent r101 = new Intent();
        if (m.c(g.a()) == false) goto L7;
        r101.setClassName(Constants.PACKAGE_QQ_PAD, r100);
        if (k.a(g.a(), r101) == false) goto L7;
        return r101;
    L7:
        r101.setClassName("com.tencent.mobileqq", r100);
        if (k.a(g.a(), r101) == false) goto L10;
        return r101;
    L10:
        r101.setClassName(Constants.PACKAGE_TIM, r100);
        if (k.a(g.a(), r101) == false) goto L13;
        return r101;
    L13:
        return null;
    }

    public Intent c(String r100) {
        Intent r101 = new Intent();
        Intent r102 = b(r100);
        if (r102 != null) goto L6;
    L9:
        return null;
    L6:
        if (r102.getComponent() == null) goto L9;
        r101.setClassName(r102.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return r101;
    }

    public boolean a(Intent r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return k.b(g.a(), r100);
    }

    public BaseApi(c r100, QQToken r101) {
        this.f461557b = r100;
        this.f461558c = r101;
    }

    public void a(StringBuilder r100, Activity r101) {
        if (r100.indexOf("?") >= 0) goto L5;
        r100.append("?");
    L6:
        r100.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append("app");
        String r102 = this.f461558c.getAppId();
        String r103 = this.f461558c.getOpenId();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        a(r100, "app_id", r102);
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        a(r100, Constants.JumpUrlConstants.URL_KEY_OPENID, m.k(r103));
    L12:
        String r104 = m.a(r101);
        if (TextUtils.isEmpty(r104) == false) goto L15;
    L18:
        a(r100, "sdk_version", m.k(Constants.SDK_VERSION));
        return;
    L15:
        if (r104.length() <= 20) goto L17;
        r104 = r104.substring(0, 20) + "...";
    L17:
        a(r100, "app_name", m.k(r104));
        goto L18
    L5:
        r100.append("&");
        goto L6
    }

    private Intent a(Activity r100, Intent r101, Map<String, Object> r102) {
        Intent r103 = new Intent(r100.getApplicationContext(), AssistActivity.class);
        r103.putExtra("is_login", true);
        r103.putExtra(AssistActivity.EXTRA_INTENT, r101);
        if (r102 != null) goto L12;
        return r103;
    L12:
    L9:
        e = move-exception;
        SLog.e("openSDK_LOG.BaseApi", "Exception", e);
    L11:
        return r103;
    L6:
        if (r102.containsKey(Constants.KEY_RESTORE_LANDSCAPE) == false) goto L11;
        Boolean r104 = (Boolean) r102.get(Constants.KEY_RESTORE_LANDSCAPE);     // Catch: Exception -> L9
        r103.putExtra(Constants.KEY_RESTORE_LANDSCAPE, r104.booleanValue());     // Catch: Exception -> L9
        goto L11
    }

    public void a(Activity r100, Bundle r101, IUiListener r102) {
        SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        INVOKEVIRTUAL_com_tencent_connect_common_BaseApi_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new TDialog(r100, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(r101), null, this.f461558c));
    }

    public void a(StringBuilder r100, String r101, String r102) {
        r100.append("&");
        r100.append(r101);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(m.f(r102));
    }

    public void a(Activity r100, Intent r101, int r102) {
        a(r100, r101, r102, null);
    }

    public void a(Activity r100, int r101, Intent r102, boolean r103) {
        Intent r104 = new Intent(r100.getApplicationContext(), AssistActivity.class);
        if (r103 == false) goto L5;
        r104.putExtra("is_qq_mobile_share", true);
    L5:
        r104.putExtra(AssistActivity.EXTRA_INTENT, r102);
        r100.startActivityForResult(r104, r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.BaseApi", "startAssistActivity exception", e);
    }

    public void a(Fragment r100, Intent r101, int r102, Map<String, Object> r103) {
        r101.putExtra(Constants.KEY_REQUEST_CODE, r102);
        r100.startActivityForResult(a(r100.getActivity(), r101, r103), r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e);
    }

    public void a(Activity r100, Intent r101, int r102, Map<String, Object> r103) {
        r101.putExtra(Constants.KEY_REQUEST_CODE, r102);
        r100.startActivityForResult(a(r100, r101, r103), r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e);
    }
}
