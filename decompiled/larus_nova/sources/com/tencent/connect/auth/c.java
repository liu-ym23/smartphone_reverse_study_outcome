package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AuthAgent f461489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private QQToken f461490b;

    public void a() {
        this.f461489a.a(null);
    }

    public boolean c() {
        if (this.f461490b.isSessionValid() == false) goto L5;
        String r100 = "true";
    L6:
        SLog.i("openSDK_LOG.QQAuth", "isSessionValid(), result = ".concat(r100));
        return this.f461490b.isSessionValid();
    L5:
        r100 = "false";
        goto L6
    }

    public QQToken b() {
        return this.f461490b;
    }

    public void a(IUiListener r100) {
        this.f461489a.b(r100);
    }

    private c(String r100, Context r101) {
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f461490b = new QQToken(r100);
        this.f461489a = new AuthAgent(this.f461490b);
        com.tencent.connect.a.a.c(r101, this.f461490b);
        a(r101, Constants.SDK_VERSION);
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public void a(String r100, String r101) {
        SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + r101 + "");
        this.f461490b.setAccessToken(r100, r101);
    }

    public void b(Context r100, String r101) {
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f461490b.setOpenId(r101);
        com.tencent.connect.a.a.d(r100, this.f461490b);
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public static c a(String r100, Context r101) {
        g.a(r101.getApplicationContext());
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        c r102 = new c(r100, r101);
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return r102;
    }

    public static void a(Context r100, String r101) {
        SharedPreferences.Editor r102 = r100.getSharedPreferences("BuglySdkInfos", 0).edit();
        r102.putString("bcb3903995", r101);
        r102.apply();
    }

    public int a(Activity r110, IUiListener r111, Map<String, Object> r112) {
        SLog.i("openSDK_LOG.QQAuth", "login--params");
        boolean r100 = m.a(r112, Constants.KEY_QRCODE, false);
        return a(r110, null, m.a(r112, Constants.KEY_SCOPE, "all"), r111, "", r100, r112);
    }

    public int b(Activity r110, String r111, IUiListener r112) {
        SLog.i("openSDK_LOG.QQAuth", "reAuth()");
        return this.f461489a.a(r110, r111, r112, true, null, false);
    }

    public int a(Activity r100, String r101, IUiListener r102) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(r100, r101, r102, "");
    }

    public int a(Fragment r100, String r101, IUiListener r102, String r110) {
        FragmentActivity r103 = r100.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + r103);
        return a(r103, r100, r101, r102, r110);
    }

    public int a(Activity r100, String r110, IUiListener r111, String r112) {
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + r100);
        return a(r100, null, r110, r111, r112);
    }

    public int a(Activity r110, String r111, IUiListener r112, boolean r113) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(r110, null, r111, r112, "", r113);
    }

    public int a(Fragment r100, String r101, IUiListener r110, String r111, boolean r112) {
        FragmentActivity r102 = r100.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + r102);
        return a(r102, r100, r101, r110, r111, r112);
    }

    private int a(Activity r100, Fragment r101, String r110, IUiListener r111, String r112) {
        return a(r100, r101, r110, r111, r112, false);
    }

    private int a(Activity r100, Fragment r110, String r111, IUiListener r112, String r113, boolean r114) {
        return a(r100, r110, r111, r112, r113, r114, null);
    }

    private int a(Activity r110, Fragment r111, String r112, IUiListener r113, String r114, boolean r115, Map<String, Object> r116) {
        String r100 = k.a(r110);     // Catch: Throwable -> L9
        if (r100 == null) goto L11;
        String r117 = com.tencent.open.utils.b.a(new PolarisFileWrapper(r100));     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r117) == true) goto L11;
        SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + r117);     // Catch: Throwable -> L9
        return a(r110, r112, r113, r115, r117, r117, "");
    L11:
        SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f461489a.doLogin(r110, r112, r113, false, r111, r115, r116);
    L9:
        th = move-exception;
        SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        goto L11
    }

    public int a(Activity r100, String r101, IUiListener r110, boolean r111, String r112, String r113, String r114) {
        SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (r112.equals("") == false) goto L6;
        r112 = "null";
    L6:
        if (r113.equals("") == false) goto L9;
        r113 = "null";
    L9:
        if (r114.equals("") == false) goto L11;
        r114 = "null";
    L11:
        BaseApi.installChannel = r113;
        BaseApi.registerChannel = r112;
        BaseApi.businessId = r114;
        return this.f461489a.a(r100, r101, r110, false, null, r111);
    }
}
