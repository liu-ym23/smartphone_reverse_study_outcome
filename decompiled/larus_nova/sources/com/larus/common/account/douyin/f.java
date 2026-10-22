package com.larus.common.account.douyin;

import android.app.Activity;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.account.douyin.network.DouyinAuthNetHelper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import n38.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f326061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q f326062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f326063c;

    public static final class a implements DouyinAuthNetHelper.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Authorization.Response f326064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f326065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f326066c;

        @Override // com.larus.common.account.douyin.network.DouyinAuthNetHelper.c
        public final void onResult(boolean r110) {
            FLogger.f375446a.i("DouyinAuthHelper", "onResult:" + r110 + ", errorCode:" + this.f326064a.errorCode + ", errorMsg:" + this.f326064a.errorMsg + ", permissions:" + this.f326064a.grantedPermissions);
            q r100 = this.f326065b;
            if (r100 == null) goto L6;
            Integer r101 = Integer.valueOf(this.f326064a.errorCode);
            Authorization.Response r102 = this.f326064a;
            r100.a(r110, r101, r102.errorMsg, r102.authCode, this.f326066c, r102.grantedPermissions);
            return;
        }

        public a(Authorization.Response r100, q r101, String r102) {
            this.f326064a = r100;
            this.f326065b = r101;
            this.f326066c = r102;
        }
    }

    static {
        f326061a = -1;
    }

    public static void a(Authorization.Response r100) {
        Intrinsics.checkNotNullParameter(r100, "resp");
        if (r100.state != null) goto L15;
        f326063c = true;
        EnsureManager.ensureNotReachHere(new Exception("state_is_null"), "DouyinAuthHelper");
        return;
    L15:
        JSONObject r101 = new JSONObject(r100.state);     // Catch: JSONException -> L12
        if (f326061a == r101.optLong("latest_auth_start_time")) goto L10;
        return;
    L10:
        FLogger.f375446a.i("DouyinAuthHelper", "authExchangeToken triggered, hasNullStateBefore: " + f326063c);
        f326063c = false;
        String r102 = r101.optString("original_state");
        r100.state = r102;
        q r103 = f326062b;
        f326062b = null;
        f326061a = -1;
        DouyinAuthNetHelper r104 = DouyinAuthNetHelper.f326087a;
        DouyinAuthNetHelper.a(r100, new a(r100, r103, r102));
        return;
    L12:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthHelper", "wrapped state format error", e);
    }

    public static boolean b(String r100, String r110, String r111, q r112) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "state");
        long r101 = System.currentTimeMillis();
        boolean r102 = false;
        if (f326061a <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
    L13:
        f326061a = r101;
        f326062b = r112;
        DouYinOpenConfig r113 = com.bytedance.sdk.open.douyin.a.getConfig();
        if (r113 == null) goto L16;
        String r114 = r113.clientKey;
    L18:
        if (Intrinsics.areEqual(r114, r100) == true) goto L20;
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig(r100));
    L20:
        JSONObject r104 = new JSONObject();
        r104.put("original_state", r111);
        r104.put("latest_auth_start_time", r101);
        HashSet r115 = new HashSet();
        r115.add(r110);
        Request r105 = new Request.Builder().setScopes(r115).setState(r104.toString()).setCallerLocalEntry("com.larus.nova.douyinapi.DouYinEntryActivity").build();
        Activity r116 = AppHost.f326268a.a().getCurrentActivity();
        if (r116 == null) goto L29;
        IDouYin2Service r117 = (IDouYin2Service) AuthorizeFramework.getService(IDouYin2Service.class);
        if (r117 != null) goto L25;
    L27:
        if (r102 == true) goto L29;
        f326061a = -1;
        f326062b = null;
        goto L29
    L25:
        if (r117.authorize(r116, r105, null) != true) goto L27;
        r102 = true;
    L29:
        return r102;
    L16:
        r114 = null;
        goto L18
    L8:
        if ((r101 - f326061a) >= 1000) goto L13;
        FLogger.f375446a.i("DouyinAuthHelper", "onResult:false, errorCode:null, errorMsg:another_auth_task_is_just_in_progress, permissions:" + r110);
        if (r112 == null) goto L12;
        q.a.a(r112);
    L12:
        return false;
    L5:
        r103 = false;
        goto L6
    }
}
