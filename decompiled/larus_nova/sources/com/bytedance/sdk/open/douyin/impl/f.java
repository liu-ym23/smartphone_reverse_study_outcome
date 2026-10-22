package com.bytedance.sdk.open.douyin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.AuthImpl;
import com.bytedance.sdk.open.aweme.authorize.handler.SendAuthDataHandler;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.aweme.share.ShareDataHandler;
import com.bytedance.sdk.open.aweme.share.ShareImpl;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
import com.bytedance.sdk.open.douyin.ui.DouYinWebAuthorizeActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class f implements DouYinOpenApi {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f269658h = "RapidOpenApiImpl";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f269659i = "douyinapi.DouYinEntryActivity";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f269660j = "wap_authorize_url";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f269661k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f269662l = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, IDataHandler> f269663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f269664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ShareImpl f269665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AuthImpl f269666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.sdk.open.douyin.d f269667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f269668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference<Activity> f269669g;

    public f(Activity r100, String r101) {
        this.f269663a = new HashMap(2);
        this.f269669g = new WeakReference(r100);
        Context r102 = r100.getApplicationContext();
        g r103 = new g(r101);
        this.f269664b = r103;
        this.f269665c = new ShareImpl(r102, r103);
        this.f269666d = new AuthImpl(r101);
        this.f269667e = new com.bytedance.sdk.open.douyin.d(r101);
        this.f269668f = new e(r100, r103);
        this.f269663a.put(1, new SendAuthDataHandler());
        this.f269663a.put(2, new ShareDataHandler());
    }

    private boolean a(Authorization.Request r100) {
        return this.f269666d.authorizeWeb(this.f269669g.get(), DouYinWebAuthorizeActivity.class, r100);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request r110) {
        if (isAppSupportAuthorization() == false) goto L7;
        return this.f269666d.authorizeNative(this.f269669g.get(), r110, this.f269668f.getPackageName(), this.f269668f.getRemoteAuthEntryActivity(), f269659i, com.bytedance.sdk.open.douyin.b.f269628e, "5.21.1-rc.0");
    L7:
        return authorizeWeb(r110);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorize(Authorization.Request r100, CommonConstants.InvokeStrategy r101) {
        return authorize(r100);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorizeInThirdApp(Authorization.Request r100) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean authorizeWeb(Authorization.Request r100) {
        return a(r100);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public String getSdkVersion() {
        return "5.21.1-rc.0";
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public String getWapUrlIfAuthByWap(Authorization.Response r100) {
        if (r100 == null) goto L9;
        Bundle r101 = r100.extras;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.containsKey("wap_authorize_url") == true) goto L8;
        return null;
    L8:
        return r100.extras.getString("wap_authorize_url", "");
    L9:
        return null;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean handleIntent(Intent r100, IApiEventHandler r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L8;
        r101.onErrorIntent(r100);
        return false;
    L8:
        Bundle r102 = r100.getExtras();
        if (r102 != null) goto L12;
        r101.onErrorIntent(r100);
        return false;
    L12:
        int r103 = r102.getInt(ParamKeyConstants.BaseParams.TYPE);
        if (r103 != 0) goto L16;
        r103 = r102.getInt(ParamKeyConstants.ShareParams.TYPE);
    L16:
        switch(r103) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L20;
            default: goto L17;
        };
    L17:
        LogUtils.w(f269658h, new Object[]{"handleIntent: unknown type " + r103});
        return this.f269663a.get(1).handle(r103, r102, r101);
    L20:
        return new com.bytedance.sdk.open.tt.c().handle(r103, r102, r101);
    L22:
        return new com.bytedance.sdk.open.tt.d().handle(r103, r102, r101);
    L24:
        return this.f269663a.get(2).handle(r103, r102, r101);
    L26:
        return this.f269663a.get(1).handle(r103, r102, r101);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppInstalled() {
        return AppUtil.isAppInstalled(this.f269669g.get(), this.f269668f.getPackageName());
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization() {
        return this.f269668f.isAppSupportAuthorization();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportAuthorization(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (isAppSupportAuthorization() == false) goto L6;
        return true;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportMixShare() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShare() {
        return this.f269668f.isAppSupportShare();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareCardToContact() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToContacts() {
        return this.f269668f.isSupportShareToContact();
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToImageAlbum() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportShareToPublish() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isAppSupportVerification() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isShareSupportFileProvider() {
        return true;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportApi(int r100, int r101) {
        return isSupportApi(r100, r101, CommonConstants.InvokeStrategy.AUTO);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportApi(int r100, int r101, CommonConstants.InvokeStrategy r102) {
        return this.f269668f.isSupportApi(r100, r101);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportCommonAbility(int r100) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportOpenRecordPage() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportShareLunaMusic() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean isSupportSwitchAccount() {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openCommon(CommonAbility.Request r100) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openCommon(CommonAbility.Request r100, CommonConstants.InvokeStrategy r101) {
        return openCommon(r100);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request r100) {
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean openRecordPage(OpenRecord.Request r100, CommonConstants.InvokeStrategy r101) {
        return openRecordPage(r100);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        int r100 = r110.requireApi;
        if (r100 != 10003) goto L8;
        boolean r101 = this.f269668f.isAppSupportShare();
    L9:
        if (r101 == true) goto L11;
        return false;
    L11:
        return this.f269665c.share(this.f269669g.get(), f269659i, this.f269664b.getPackageName(), this.f269664b.getComponentClassName(), r110, "", com.bytedance.sdk.open.douyin.b.f269628e, "5.21.1-rc.0");
    L8:
        r101 = this.f269668f.isSupportApi(2, r100);
        goto L9
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean share(Share.Request r100, CommonConstants.InvokeStrategy r101) {
        return share(r100);
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request r100) {
        if (this.f269668f.isSupportShareToContact() == false) goto L7;
        this.f269667e.a(this.f269669g.get(), f269659i, this.f269668f.getPackageName(), "openshare.ShareToContactsActivity", r100);
        return false;
    L7:
        return false;
    }

    @Override // com.bytedance.sdk.open.douyin.api.DouYinOpenApi
    public boolean shareToContacts(ShareToContact.Request r100, CommonConstants.InvokeStrategy r101) {
        return shareToContacts(r100);
    }
}
