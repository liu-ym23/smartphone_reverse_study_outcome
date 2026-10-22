package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public class SocialApiIml extends BaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f461640a;

    public class a extends DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SocialApiIml f461641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IUiListener f461642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f461643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f461644d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bundle f461645e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Activity f461646f;

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f461642b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object r110) {
            String r111 = JSONObjectProtectorUtils.getString((JSONObject) r110, SocialConstants.PARAM_ENCRY_EOKEN);     // Catch: JSONException -> L5
        L7:
            this.f461645e.putString("encrytoken", r111);
            SocialApiIml r100 = this.f461641a;
            SocialApiIml.a(r100, SocialApiIml.a(r100), this.f461643c, this.f461645e, this.f461644d, this.f461642b);
            if (TextUtils.isEmpty(r111) == false) goto L13;
            SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
            this.f461641a.writeEncryToken(this.f461646f);
            return;
        L13:
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e);
            r111 = null;
            goto L7
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError r100) {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + r100.errorMessage);
            this.f461642b.onError(r100);
        }

        public a(SocialApiIml r100, Activity r101, IUiListener r102, String r103, String r104, Bundle r105) {
            this.f461641a = r100;
            this.f461642b = r102;
            this.f461643c = r103;
            this.f461644d = r104;
            this.f461645e = r105;
            this.f461646f = r101;
        }
    }

    public SocialApiIml(QQToken r100) {
        super(r100);
    }

    public static void INVOKEVIRTUAL_com_tencent_open_SocialApiIml_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(TDialog r100) {
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

    public static /* synthetic */ Activity a(SocialApiIml r100) {
        return r100.f461640a;
    }

    @Override // com.tencent.connect.common.BaseApi
    public Intent b(String r100) {
        Intent r101 = new Intent();
        r101.setClassName(Constants.PACKAGE_QQ_PAD, r100);
        if (m.c(g.a()) == true) goto L5;
    L7:
        Intent r102 = new Intent();
        r102.setClassName("com.tencent.mobileqq", r100);
        if (k.a(g.a(), r102) == true) goto L10;
    L12:
        Intent r103 = new Intent();
        r103.setClassName(Constants.PACKAGE_QZONE, r100);
        if (k.a(g.a(), r103) == true) goto L15;
    L21:
        return null;
    L15:
        if (k.a(k.a(g.a(), Constants.PACKAGE_QZONE), "4.2") < 0) goto L21;
        if (k.a(g.a(), r103.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE) == false) goto L20;
        return r103;
    L20:
        return null;
    L10:
        if (k.c(g.a(), "4.7") < 0) goto L12;
        return r102;
    L5:
        if (k.a(g.a(), r101) == false) goto L7;
        return r101;
    }

    public void writeEncryToken(Context r100) {
        String r101 = this.f461558c.getAccessToken();
        String r102 = this.f461558c.getAppId();
        String r103 = this.f461558c.getOpenId();
        if (r101 != null) goto L5;
    L13:
        String r104 = null;
    L14:
        com.tencent.open.c.b r105 = new com.tencent.open.c.b(r100);
        WebSettings r106 = r105.getSettings();
        r106.setDomStorageEnabled(true);
        r106.setDatabaseEnabled(true);
        com.tencent.open.web.a.a(r105);
        String r107 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f461558c.getOpenId() + "_" + this.f461558c.getAppId() + "\"]=\"" + r104 + "\";</script></head><body></body></html>";
        String r108 = j.a().a(r100, "https://imgcache.qq.com");
        r105.loadDataWithBaseURL(r108, r107, "text/html", XML.CHARSET_UTF8, r108);
        return;
    L5:
        if (r101.length() <= 0) goto L13;
        if (r102 == null) goto L13;
        if (r102.length() <= 0) goto L13;
        if (r103 == null) goto L13;
        if (r103.length() <= 0) goto L13;
        r104 = m.g("tencent&sdk&qazxc***14969%%" + r101 + r102 + r103 + "qzone3.4");
        goto L14
    }

    public static void INVOKEVIRTUAL_com_tencent_open_SocialApiIml_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(d r100) {
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

    public SocialApiIml(com.tencent.connect.auth.c r100, QQToken r101) {
        super(r100, r101);
    }

    public void ask(Activity r100, Bundle r101, IUiListener r102) {
        a(r100, SocialConstants.ACTION_ASK, r101, r102);
    }

    public void gift(Activity r100, Bundle r101, IUiListener r102) {
        a(r100, SocialConstants.ACTION_GIFT, r101, r102);
    }

    public void invite(Activity r110, Bundle r111, IUiListener r112) {
        this.f461640a = r110;
        Intent r100 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (r100 != null) goto L5;
        SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
        r100 = c(SocialConstants.ACTIVITY_INVITE);
    L5:
        Intent r101 = r100;
        r111.putAll(b());
        a(r110, r101, SocialConstants.ACTION_INVITE, r111, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), r112, false);
    }

    public void story(Activity r110, Bundle r111, IUiListener r112) {
        this.f461640a = r110;
        Intent r100 = c(SocialConstants.ACTIVITY_STORY);
        r111.putAll(b());
        a(r110, r100, SocialConstants.ACTION_STORY, r111, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), r112, false);
    }

    private void a(Activity r110, String r111, Bundle r112, IUiListener r113) {
        this.f461640a = r110;
        Intent r100 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (r100 != null) goto L5;
        SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
        r100 = c(SocialConstants.ACTIVITY_ASK_GIFT);
    L5:
        Intent r101 = r100;
        r112.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(r111) == false) goto L9;
        r112.putString("type", "request");
    L11:
        a(r110, r101, r111, r112, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/request/sdk_request.html?"), r113, false);
        return;
    L9:
        if (SocialConstants.ACTION_GIFT.equals(r111) == false) goto L11;
        r112.putString("type", SocialConstants.TYPE_FREEGIFT);
        goto L11
    }

    private void a(Activity r110, String r111, Bundle r112, String r113, IUiListener r114) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + r111);
        Intent r100 = c();
        IUiListener r101 = new a(this, r110, r114, r111, r113, r112);
        Intent r115 = b("com.tencent.open.agent.EncryTokenActivity");
        if (r115 == null) goto L14;
        if (r100 == null) goto L14;
        if (r100.getComponent() == null) goto L14;
        if (r115.getComponent() == null) goto L14;
        if (r100.getComponent().getPackageName().equals(r115.getComponent().getPackageName()) == false) goto L14;
        r115.putExtra("oauth_consumer_key", this.f461558c.getAppId());
        r115.putExtra("openid", this.f461558c.getOpenId());
        r115.putExtra("access_token", this.f461558c.getAccessToken());
        r115.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
        if (a(r115) == false) goto L23;
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, r101);
        a(r110, r115, Constants.REQUEST_SOCIAL_H5);
        return;
    L23:
        return;
    L14:
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String r116 = m.g("tencent&sdk&qazxc***14969%%" + this.f461558c.getAccessToken() + this.f461558c.getAppId() + this.f461558c.getOpenId() + "qzone3.4");
        JSONObject r117 = new JSONObject();
        r117.put(SocialConstants.PARAM_ENCRY_EOKEN, r116);     // Catch: JSONException -> L17
    L19:
        r101.onComplete(r117);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private void a(Context r110, String r111, Bundle r112, String r113, IUiListener r114) {
        SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(r110);
        r112.putString("oauth_consumer_key", this.f461558c.getAppId());
        if (this.f461558c.isSessionValid() == false) goto L5;
        r112.putString("access_token", this.f461558c.getAccessToken());
    L5:
        String r115 = this.f461558c.getOpenId();
        if (r115 == null) goto L20;
        r112.putString("openid", r115);
    L20:
        r112.putString(Constants.PARAM_PLATFORM_ID, g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));     // Catch: Exception -> L10
    L12:
        String r100 = r113 + HttpUtils.encodeUrl(r112);
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (SocialConstants.ACTION_CHALLENGE.equals(r111) == false) goto L15;
    L18:
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
        INVOKEVIRTUAL_com_tencent_open_SocialApiIml_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new d(this.f461640a, r111, r100, r114, this.f461558c));
        return;
    L15:
        if (SocialConstants.ACTION_BRAG.equals(r111) == true) goto L18;
        INVOKEVIRTUAL_com_tencent_open_SocialApiIml_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new TDialog(this.f461640a, r111, r100, r114, this.f461558c));
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        r112.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        goto L12
    }

    private void a(Activity r100, Intent r101, String r102, Bundle r103, IUiListener r104) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + r102);
        r101.putExtra(Constants.KEY_ACTION, r102);
        r101.putExtra(Constants.KEY_PARAMS, r103);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, r104);
        a(r100, r101, Constants.REQUEST_SOCIAL_API);
    }

    public static /* synthetic */ void a(SocialApiIml r100, Context r101, String r102, Bundle r103, String r104, IUiListener r105) {
        r100.a(r101, r102, r103, r104, r105);
    }

    private void a(Activity r100, Intent r101, String r102, Bundle r110, String r111, IUiListener r112, boolean r113) {
        StringBuilder r103 = new StringBuilder("-->handleIntent action = ");
        r103.append(r102);
        r103.append(", activityIntent = null ? ");
        boolean r104 = true;
        if (r101 != null) goto L5;
        boolean r105 = true;
    L6:
        r103.append(r105);
        SLog.i("openSDK_LOG.SocialApiIml", r103.toString());
        if (r101 == null) goto L9;
        a(r100, r101, r102, r110, r112);
        return;
    L9:
        i r106 = i.a(g.a(), this.f461558c.getAppId());
        if (r113 == false) goto L12;
    L15:
        if (r104 == false) goto L17;
        a(r100, r102, r110, r111, r112);
        return;
    L17:
        a(r100, r110, r112);
        return;
    L12:
        if (r106.b("C_LoginH5") == true) goto L15;
        r104 = false;
        goto L15
    L5:
        r105 = false;
        goto L6
    }
}
