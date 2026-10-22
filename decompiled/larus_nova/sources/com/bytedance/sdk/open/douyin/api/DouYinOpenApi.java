package com.bytedance.sdk.open.douyin.api;

import android.content.Intent;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.model.OpenRecord;

/* JADX INFO: loaded from: classes22.dex */
public interface DouYinOpenApi {
    boolean authorize(Authorization.Request r100);

    boolean authorize(Authorization.Request r100, CommonConstants.InvokeStrategy r101);

    boolean authorizeInThirdApp(Authorization.Request r100);

    boolean authorizeWeb(Authorization.Request r100);

    String getSdkVersion();

    String getWapUrlIfAuthByWap(Authorization.Response r100);

    boolean handleIntent(Intent r100, IApiEventHandler r101);

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    boolean isAppSupportAuthorization(boolean r100);

    boolean isAppSupportMixShare();

    boolean isAppSupportShare();

    boolean isAppSupportShareCardToContact();

    boolean isAppSupportShareToContacts();

    boolean isAppSupportShareToImageAlbum();

    boolean isAppSupportShareToPublish();

    boolean isAppSupportVerification();

    boolean isShareSupportFileProvider();

    boolean isSupportApi(int r100, int r101);

    boolean isSupportApi(int r100, int r101, CommonConstants.InvokeStrategy r102);

    boolean isSupportCommonAbility(int r100);

    boolean isSupportOpenRecordPage();

    boolean isSupportShareLunaMusic();

    boolean isSupportSwitchAccount();

    boolean openCommon(CommonAbility.Request r100);

    boolean openCommon(CommonAbility.Request r100, CommonConstants.InvokeStrategy r101);

    boolean openRecordPage(OpenRecord.Request r100);

    boolean openRecordPage(OpenRecord.Request r100, CommonConstants.InvokeStrategy r101);

    boolean share(Share.Request r100);

    boolean share(Share.Request r100, CommonConstants.InvokeStrategy r101);

    boolean shareToContacts(ShareToContact.Request r100);

    boolean shareToContacts(ShareToContact.Request r100, CommonConstants.InvokeStrategy r101);
}
