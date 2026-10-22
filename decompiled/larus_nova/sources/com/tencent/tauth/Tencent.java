package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.b.b;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Tencent f461889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f461890d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f461891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461892b;

    public static boolean isPermissionNotGranted() {
        if (f461890d == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(f.a().b()) == true) goto L8;
        return false;
    }

    public static void resetQQAppInfoCache() {
        k.a("com.tencent.mobileqq");
    }

    public static void resetTimAppInfoCache() {
        k.a(Constants.PACKAGE_TIM);
    }

    public String getAccessToken() {
        String r100 = this.f461891a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + r100);
        a("getAccessToken", new Object[0]);
        return r100;
    }

    public String getAppId() {
        String r100 = this.f461891a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + r100);
        a("getAppId", r100);
        return r100;
    }

    public long getExpiresIn() {
        long r100 = this.f461891a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + r100);
        a("getExpiresIn", Long.valueOf(r100));
        return r100;
    }

    public String getOpenId() {
        String r100 = this.f461891a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + r100);
        a("getOpenId", new Object[0]);
        return r100;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        a("getQQToken", new Object[0]);
        return this.f461891a.b();
    }

    public boolean isSessionValid() {
        boolean r100 = this.f461891a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + r100);
        a("isSessionValid", Boolean.valueOf(r100));
        return r100;
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        a("reportDAU", new Object[0]);
        this.f461891a.a();
    }

    public boolean isReady() {
        if (isSessionValid() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + r100);
        a("isReady", Boolean.valueOf(r100));
        return r100;
    L5:
        if (getOpenId() == null) goto L7;
        r100 = true;
        goto L8
    }

    public static void resetTargetAppInfoCache() {
        k.a();
    }

    private static String a(Object... r100) {
        if (r100 != null) goto L5;
    L17:
        return "";
    L5:
        if (r100.length == 0) goto L17;
        if ((r100.length % 2) == 0) goto L10;
        return "";
    L10:
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        if (r103 <= 0) goto L14;
        r101.append('|');
    L14:
        r101.append(r100[r103]);
        r101.append(':');
        r101.append(r100[r103 + 1]);
        r103 = r103 + 2;
        goto L11
    L16:
        return r101.toString();
    }

    public static synchronized String getAuthorities(String r100) {
        monitor-enter(Tencent.class);
        a("getAuthorities", new Object[]{"appid", r100});     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r100) == false) goto L9;
        SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");     // Catch: Throwable -> L20
        monitor-exit(Tencent.class);
        return null;
    L9:
        Tencent r101 = f461889c;     // Catch: Throwable -> L20
        if (r101 != null) goto L15;
        SLog.i("openSDK_LOG.Tencent", "sInstance == null");     // Catch: Throwable -> L20
        monitor-exit(Tencent.class);
        return null;
    L15:
        if (r100.equals(r101.getAppId()) == false) goto L17;
        String r102 = f461889c.f461892b;     // Catch: Throwable -> L20
    L18:
        monitor-exit(Tencent.class);
        return r102;
    L17:
        r102 = "";
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean isSupportPushToQZone(Context r100) {
        if (k.c(r100, "5.9.5") >= 0) goto L5;
        boolean r101 = false;
    L6:
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + r101);
        a("isSupportPushToQZone", Boolean.valueOf(r101));
        return r101;
    L5:
        r101 = true;
        goto L6
    }

    public static boolean isSupportShareToQQ(Context r100) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean r101 = true;
        if (m.c(r100) == false) goto L9;
        if (k.a(r100, Constants.PACKAGE_QQ_PAD) == null) goto L9;
        a("isSupportShareToQQ", Boolean.TRUE);
        return true;
    L9:
        if (k.c(r100, "4.1") < 0) goto L11;
    L13:
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + r101);
        a("isSupportShareToQQ", Boolean.valueOf(r101));
        return r101;
    L11:
        if (k.a(r100, Constants.PACKAGE_TIM) != null) goto L13;
        r101 = false;
        goto L13
    }

    public static Map<String, String> parseMiniParameters(Intent r100) {
        a("parseMiniParameters", new Object[0]);
        HashMap r101 = new HashMap();
        if (r100 != null) goto L34;
        SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
        return r101;
    L34:
        String r102 = r100.getStringExtra("appParameter");     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r102) == true) goto L13;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + r102);     // Catch: Exception -> L31
        JSONObject r103 = new JSONObject(r102);     // Catch: Exception -> L31
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L31
    L10:
        if (r104.hasNext() == false) goto L12;
        String r105 = r104.next();     // Catch: Exception -> L31
        r101.put(r105, JSONObjectProtectorUtils.getString(r103, r105));     // Catch: Exception -> L31
        goto L10
    L12:
        return r101;
    L13:
        Uri r106 = r100.getData();     // Catch: Exception -> L31
        if (r106 != null) goto L17;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");     // Catch: Exception -> L31
        return r101;
    L17:
        String r107 = r106.toString();     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r107) == false) goto L21;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");     // Catch: Exception -> L31
        return r101;
    L21:
        String r108 = r107.substring(r107.lastIndexOf(63) + 1);     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r108) == false) goto L25;
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");     // Catch: Exception -> L31
        return r101;
    L25:
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + r108);     // Catch: Exception -> L31
        String[] r109 = r108.split("&");     // Catch: Exception -> L31
        int r110 = r109.length;     // Catch: Exception -> L31
        int r111 = 0;
    L26:
        if (r111 >= r110) goto L33;
        String[] r112 = r109[r111].split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L31
        if (r112.length != 2) goto L30;
        r101.put(r112[0], r112[1]);     // Catch: Exception -> L31
    L30:
        r111 = r111 + 1;
    L33:
        return r101;
    L31:
        e = move-exception;
        SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        goto L33
    }

    public static void setCustomLogger(Tracer r100) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(r100);
    }

    public static void setIsPermissionGranted(boolean r100) {
        if (r100 == false) goto L8;
        f.a().a(g.a());
        String r101 = f.a().b();
        if (r101 != null) goto L6;
    L7:
        r101 = Build.MODEL;
    L9:
        setIsPermissionGranted(r100, r101);
        return;
    L6:
        if (r101.isEmpty() == false) goto L9;
    L8:
        r101 = "";
        goto L9
    }

    public void checkLogin(IUiListener r100) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        a("checkLogin", new Object[0]);
        this.f461891a.a(r100);
    }

    public void initSessionCache(JSONObject r100) {
        a("initSessionCache", new Object[0]);
        String r101 = JSONObjectProtectorUtils.getString(r100, "access_token");     // Catch: Exception -> L12
        String r102 = JSONObjectProtectorUtils.getString(r100, "expires_in");     // Catch: Exception -> L12
        String r103 = JSONObjectProtectorUtils.getString(r100, "openid");     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r101) == false) goto L6;
    L10:
        SLog.i("openSDK_LOG.Tencent", "initSessionCache()");     // Catch: Exception -> L12
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        if (TextUtils.isEmpty(r103) == true) goto L10;
        setAccessToken(r101, r102);     // Catch: Exception -> L12
        setOpenId(r103);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        SLog.i("QQToken", "initSessionCache " + e.toString());
    }

    public boolean isQQInstalled(Context r100) {
        boolean r101 = k.b(r100);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + r101);
        a("isQQInstalled", Boolean.valueOf(r101));
        return r101;
    }

    public boolean isSupportSSOLogin(Activity r100) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean r101 = true;
        if (m.c(r100) == false) goto L9;
        if (k.a(r100, Constants.PACKAGE_QQ_PAD) == null) goto L9;
        a("isSupportSSOLogin", Boolean.TRUE);
        return true;
    L9:
        if (k.c(r100, "4.1") < 0) goto L11;
    L13:
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + r101);
        a("isSupportSSOLogin", Boolean.valueOf(r101));
        return r101;
    L11:
        if (k.d(r100, "1.1") >= 0) goto L13;
        r101 = false;
        goto L13
    }

    public JSONObject loadSession(String r100) {
        JSONObject r101 = this.f461891a.b().loadSession(r100);
        StringBuilder r102 = new StringBuilder("loadSession() appid ");
        r102.append(r100);
        r102.append(", length=");
        if (r101 == null) goto L5;
        int r103 = r101.length();
    L6:
        r102.append(r103);
        SLog.i("openSDK_LOG.Tencent", r102.toString());
        a("loadSession", new Object[]{"appid", r100});
        return r101;
    L5:
        r103 = 0;
        goto L6
    }

    public void logout(Context r100) {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        a("logout", new Object[0]);
        this.f461891a.b().setAccessToken(null, "0");
        this.f461891a.b().setOpenId(null);
        this.f461891a.b().removeSession(this.f461891a.b().getAppId());
    }

    public void saveSession(JSONObject r100) {
        StringBuilder r101 = new StringBuilder("saveSession() length=");
        if (r100 == null) goto L5;
        int r102 = r100.length();
    L6:
        r101.append(r102);
        SLog.i("openSDK_LOG.Tencent", r101.toString());
        a("saveSession", new Object[0]);
        this.f461891a.b().saveSession(r100);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setOpenId(String r100) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        a("setOpenId", new Object[0]);
        this.f461891a.b(g.a(), r100);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    private Tencent(String r100, Context r101) {
        this.f461891a = c.a(r100, r101);
        b.a().a(r100, r101);
        f.a().a(r101);
    }

    private static boolean a(Context r100, String r101) {
        r100.getPackageManager().getActivityInfo(new ComponentName(r100.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        r100.getPackageManager().getActivityInfo(new ComponentName(r100.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);     // Catch: PackageManager.NameNotFoundException -> L7
        return true;
    L7:
        SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>");
        return false;
    L9:
        SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + r101 + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + r101 + "\" />\n</intent-filter>\n</activity>"));
        return false;
    }

    public static synchronized Tencent createInstance(String r100, Context r101) {
        monitor-enter(Tencent.class);
        g.a(r101.getApplicationContext());     // Catch: Throwable -> L22
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + r100);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r100) == false) goto L9;
        SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");     // Catch: Throwable -> L22
        monitor-exit(Tencent.class);
        return null;
    L9:
        Tencent r102 = f461889c;     // Catch: Throwable -> L22
        if (r102 != null) goto L13;
        f461889c = new Tencent(r100, r101);     // Catch: Throwable -> L22
    L16:
        if (a(r101, r100) == true) goto L19;
        monitor-exit(Tencent.class);
        return null;
    L19:
        a("createInstance", new Object[]{"appid", r100});     // Catch: Throwable -> L22
        com.tencent.open.a.f.a().a(i.a(r101, r100));     // Catch: Throwable -> L22
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");     // Catch: Throwable -> L22
        Tencent r103 = f461889c;     // Catch: Throwable -> L22
        monitor-exit(Tencent.class);
        return r103;
    L13:
        if (r100.equals(r102.getAppId()) == true) goto L16;
        f461889c.logout(r101);     // Catch: Throwable -> L22
        f461889c = new Tencent(r100, r101);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void handleResultData(Intent r100, IUiListener r101) {
        StringBuilder r102 = new StringBuilder("handleResultData() data = null ? ");
        boolean r103 = true;
        if (r100 != null) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r102.append(", listener = null ? ");
        if (r101 == null) goto L10;
        r103 = false;
    L10:
        r102.append(r103);
        SLog.i("openSDK_LOG.Tencent", r102.toString());
        a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(r100, r101);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static void setIsPermissionGranted(boolean r100, String r101) {
        if (r100 == false) goto L8;
        if (r101 != null) goto L6;
    L7:
        SLog.e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + r101 + "]");
        r100 = false;
        goto L8
    L6:
        if (r101.trim().isEmpty() == true) goto L7;
    L9:
        f461890d = r100;
        f.a().a(g.a(), r101);
        return;
    L8:
        r101 = null;
        goto L9
    }

    public void handleLoginData(Intent r100, IUiListener r101) {
        StringBuilder r102 = new StringBuilder("handleLoginData() data = null ? ");
        boolean r103 = true;
        if (r100 != null) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r102.append(", listener = null ? ");
        if (r101 == null) goto L10;
        r103 = false;
    L10:
        r102.append(r103);
        SLog.i("openSDK_LOG.Tencent", r102.toString());
        a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(r100, r101);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public boolean isQQInstalled(Context r100, String r101) {
        if (k.c(r100, r101) < 0) goto L5;
        boolean r102 = true;
    L6:
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled version[" + r101 + "] = " + r102);
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    public void setAccessToken(String r100, String r101) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + r101 + "");
        a("setAccessToken", new Object[0]);
        this.f461891a.a(r100, r101);
    }

    public void startAuthManagePage(Activity r100, IApiCallback r101) {
        SLog.i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f461891a, getQQToken()).gotoManagePage(r100, r101);
    }

    private static void a(String r100, Object... r101) {
        String r102 = a(r101);
        b.a().a(r100, r102);
    }

    private static void a(String r100, Object r101) {
        b.a().a(r100, r101);
    }

    public static synchronized Tencent createInstance(String r100, Context r101, String r102) {
        monitor-enter(Tencent.class);
        Tencent r103 = createInstance(r100, r101);     // Catch: Throwable -> L10
        SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + r100 + ", authorities=" + r102);     // Catch: Throwable -> L10
        a("createInstance_authority", new Object[]{"appid", r100, "authorities", r102});     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        r103.f461892b = r102;     // Catch: Throwable -> L10
    L8:
        monitor-exit(Tencent.class);
        return r103;
    L7:
        SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void callCommonChannelApi(Activity r100, Bundle r101, IUiListener r102) {
        c r103 = this.f461891a;
        SLog.i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + new CommonChannelApi(r103, r103.b()).launchQQ(r100, r101, r102));
    }

    public void joinQQGroup(Activity r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "joinQQGroup()");
        a("joinQQGroup", new Object[]{"organizationId", r101});
        new SocialOperation(getQQToken()).joinGroup(r100, r101, r102);
    }

    public int login(Fragment r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + r101);
        a("login_fragment_scope", new Object[]{"scope", r101});
        return this.f461891a.a(r100, r101, r102, "");
    }

    public int loginServerSide(Fragment r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + r101 + ",server_side");
        a("loginServerSide_fragment", new Object[]{"scope", r101});
        return this.f461891a.a(r100, r101 + ",server_side", r102, "");
    }

    public void publishToQzone(Activity r100, Bundle r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        a("publishToQzone", new Object[0]);
        new QzonePublish(r100, this.f461891a.b()).publishToQzone(r100, r101, r102);
    }

    public int reAuth(Activity r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + r101);
        a("reAuth", new Object[]{"scope", r101});
        return this.f461891a.b(r100, r101, r102);
    }

    public JSONObject request(String r100, Bundle r101, String r102) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        a("request", new Object[]{"graphPath", r100, "httpMethod", r102});
        return HttpUtils.request(this.f461891a.b(), g.a(), r100, r101, r102);
    }

    public void setAvatar(Activity r100, Bundle r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar", new Object[0]);
        String r103 = r101.getString("picture");
        int r104 = r101.getInt("exitAnim");
        new QQAvatar(this.f461891a.b()).setAvatar(r100, UriProtector.parse(r103), r102, r104);
    }

    public void setAvatarByQQ(Activity r100, Uri r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f461891a.b()).setAvatarByQQ(r100, r101, r102);
    }

    public void setDynamicAvatar(Activity r100, Uri r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f461891a.b()).setDynamicAvatar(r100, r101, r102);
    }

    public void setEmotions(Activity r100, ArrayList<Uri> r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        a("setEmotions", new Object[0]);
        new QQEmotion(this.f461891a.b()).setEmotions(r100, r101, r102);
    }

    public void shareToQQ(Activity r100, Bundle r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.f461892b) == false) goto L5;
        r102.onWarning(-19);
    L5:
        new QQShare(r100, this.f461891a.b()).shareToQQ(r100, r101, r102);
    }

    public void shareToQzone(Activity r100, Bundle r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        a("shareToQzone", new Object[0]);
        new QzoneShare(r100, this.f461891a.b()).shareToQzone(r100, r101, r102);
    }

    public int startIMAio(Activity r100, String r101, String r102) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        a("startIMAio", new Object[]{"uin", r101, "pkg_name", r102});
        return startIMConversation(r100, IM.CHAT_TYPE_AIO, r101, r102);
    }

    public int startIMAudio(Activity r100, String r101, String r102) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        a("startIMAudio", new Object[]{"uin", r101, "pkg_name", r102});
        return startIMConversation(r100, IM.CHAT_TYPE_AUDIO_CHAT, r101, r102);
    }

    public int startIMVideo(Activity r100, String r101, String r102) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        a("startIMVideo", new Object[]{"uin", r101, "pkg_name", r102});
        return startIMConversation(r100, IM.CHAT_TYPE_VIDEO_CHAT, r101, r102);
    }

    public void unBindQQGroup(Context r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "unBindQQGroup()");
        a("unBindQQGroup", new Object[]{"organizationId", r101});
        new SocialOperation(getQQToken()).unBindGroup(r100, r101, r102);
    }

    public int login(Activity r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + r101);
        a("login_scope", new Object[]{"scope", r101});
        return this.f461891a.a(r100, r101, r102);
    }

    public int loginServerSide(Activity r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + r101 + ",server_side");
        a("loginServerSide_activity", new Object[]{"scope", r101});
        return this.f461891a.a(r100, r101 + ",server_side", r102);
    }

    public int login(Activity r100, IUiListener r101, Map<String, Object> r102) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        a("login_param", new Object[0]);
        return this.f461891a.a(r100, r101, r102);
    }

    public static boolean onActivityResultData(int r100, int r101, Intent r102, IUiListener r103) {
        StringBuilder r104 = new StringBuilder("onActivityResultData() reqcode = ");
        r104.append(r100);
        r104.append(", resultcode = ");
        r104.append(r101);
        r104.append(", data = null ? ");
        if (r102 != null) goto L5;
        boolean r105 = true;
    L6:
        r104.append(r105);
        r104.append(", listener = null ? ");
        if (r103 != null) goto L9;
        boolean r106 = true;
    L10:
        r104.append(r106);
        SLog.i("openSDK_LOG.Tencent", r104.toString());
        a("onActivityResultData", new Object[]{"requestCode", Integer.valueOf(r100), "resultCode", Integer.valueOf(r101)});
        return UIListenerManager.getInstance().onActivityResult(r100, r101, r102, r103);
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public void bindQQGroup(Activity r100, String r101, String r102, IUiListener r103) {
        SLog.i("openSDK_LOG.Tencent", "bindQQGroup()");
        a("bindQQGroup", new Object[]{"organizationId", r101, "organizationName", r102});
        new SocialOperation(getQQToken()).bindQQGroup(r100, r101, r102, r103);
    }

    public int login(Fragment r100, String r110, IUiListener r111, boolean r112) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + r110);
        a("login_fragment_scope_qrcode", new Object[]{"scope", r110, "qrcode", Boolean.valueOf(r112)});
        return this.f461891a.a(r100, r110, r111, "", r112);
    }

    public void requestAsync(String r100, Bundle r101, String r110, IRequestListener r111) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        a("requestAsync", new Object[]{"graphPath", r100, "httpMethod", r110});
        HttpUtils.requestAsync(this.f461891a.b(), g.a(), r100, r101, r110, r111);
    }

    public int startIMConversation(Activity r100, String r101, String r102, String r103) {
        a("startIMConversation", new Object[]{"chatType", r101, "uin", r102, "pkg_name", r103});
        return new IM(getQQToken()).startIMConversation(r100, r101, r102, r103);
    }

    public int startMiniApp(Activity r110, String r111, String r112, String r113) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        a("startMiniApp", new Object[]{"miniAppId", r111, "miniAppPath", r112, "miniAppVersion", r113});
        return new MiniApp(getQQToken()).startMiniApp(r110, MiniApp.MINIAPP_TYPE_NORMAL, r111, "21", r112, r113);
    }

    public int login(Activity r100, String r101, IUiListener r102, boolean r103) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + r101);
        a("login_qrcode", new Object[]{"scope", r101, "qrcode", Boolean.valueOf(r103)});
        return this.f461891a.a(r100, r101, r102, r103);
    }

    public void setAvatar(Activity r100, Bundle r101, IUiListener r102, int r103, int r104) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar_anim", new Object[0]);
        r101.putInt("exitAnim", r104);
        r100.overridePendingTransition(r103, 0);
        setAvatar(r100, r101, r102);
    }

    public int loginWithOEM(Activity r110, String r111, IUiListener r112, boolean r113, String r114, String r115, String r116) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + r111);
        a("loginWithOEM", new Object[]{"scope", r111, "qrcode", Boolean.valueOf(r113), "registerChannel", r114, "installChannel", r115, "businessId", r116});
        return this.f461891a.a(r110, r111, r112, r113, r114, r115, r116);
    }
}
