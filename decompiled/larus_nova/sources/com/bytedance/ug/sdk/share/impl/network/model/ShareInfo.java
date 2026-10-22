package com.bytedance.ug.sdk.share.impl.network.model;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kn7.d;

/* JADX INFO: loaded from: classes22.dex */
public class ShareInfo implements Serializable {

    @SerializedName("channel")
    private String mChannel;

    @SerializedName("share_data")
    private ShareDetail mShareDetail;

    @SerializedName(e.f25671s)
    private String mStrategy;

    public ShareInfo() {
    }

    public String getChannel() {
        return this.mChannel;
    }

    public ShareDetail getShareDetail() {
        return this.mShareDetail;
    }

    public String getStrategy() {
        return this.mStrategy;
    }

    public void setChannel(String r100) {
        this.mChannel = r100;
    }

    public void setShareDetail(ShareDetail r100) {
        this.mShareDetail = r100;
    }

    public void setStrategy(String r100) {
        this.mStrategy = r100;
    }

    public static ShareContent applyToShareModel(ShareInfo r100, ShareContent r101) {
        String r102 = r100.getStrategy();
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r101.setShareStrategy(ShareStrategy.getStrategyByType(r102));
    L5:
        ShareDetail r103 = r100.getShareDetail();
        if (r103 == null) goto L47;
        String r104 = r103.getTitle();
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r101.setTitle(r104);
    L10:
        String r105 = r103.getDescription();
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r101.setText(r105);
    L13:
        String r106 = r103.getImageUrl();
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r101.setImageUrl(r106);
    L16:
        String r107 = r103.getQrCodeImageUrl();
        if (TextUtils.isEmpty(r107) == true) goto L19;
        r101.setQrcodeImageUrl(r107);
    L19:
        String r108 = r103.getHiddenImageUrl();
        if (TextUtils.isEmpty(r108) == true) goto L22;
        r101.setHiddenImageUrl(r108);
    L22:
        String r109 = r103.getShareUrl();
        if (TextUtils.isEmpty(r109) == false) goto L49;
    L32:
        String r110 = r103.getVideoUrl();
        if (TextUtils.isEmpty(r110) == true) goto L35;
        r101.setVideoUrl(r110);
    L35:
        String r111 = r103.getAudioUrl();
        if (TextUtils.isEmpty(r111) == true) goto L38;
        r101.setAudioUrl(r111);
    L38:
        String r112 = r103.getExtra();
        if (TextUtils.isEmpty(r112) == true) goto L41;
        r101.setExtra(r112);
    L41:
        TokenInfo r113 = r103.getTokenInfo();
        if (r113 == null) goto L44;
        d r114 = new d();
        r113.getTitle();
        r114.f504260a = r113.getDescription();
        r113.getTips();
        r101.setTokenShareInfo(r114);
    L44:
        TokenInfo r115 = r103.getImageTokenInfo();
        if (r115 == null) goto L47;
        d r116 = new d();
        r115.getTitle();
        r116.f504260a = r115.getDescription();
        r115.getTips();
        r101.setImageTokenShareInfo(r116);
        goto L47
    L49:
        Uri r117 = UriProtector.parse(r109);     // Catch: Exception -> L31
        if (r101.getShareChanelType() != ShareChannelType.COPY_LINK) goto L27;
    L29:
        r101.setTargetUrl(r109);     // Catch: Exception -> L31
    L48:
        goto L32
    L27:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r117, "share_token")) == false) goto L29;
        r101.setTargetUrl(r117.buildUpon().appendQueryParameter("share_token", r101.getShareToken()).build().toString());     // Catch: Exception -> L31
    L31:
        r101.setTargetUrl(r109);
    L47:
        return r101;
    }

    public static ShareContent applyTokenToShareModel(ShareInfo r100, ShareContent r101) {
        ShareDetail r102 = r100.getShareDetail();
        if (r102 == null) goto L10;
        TokenInfo r103 = r102.getTokenInfo();
        if (r103 == null) goto L7;
        d r104 = new d();
        r103.getTitle();
        r104.f504260a = r103.getDescription();
        r103.getTips();
        r101.setTokenShareInfo(r104);
    L7:
        TokenInfo r105 = r102.getImageTokenInfo();
        if (r105 == null) goto L10;
        d r106 = new d();
        r105.getTitle();
        r106.f504260a = r105.getDescription();
        r105.getTips();
        r101.setImageTokenShareInfo(r106);
    L10:
        return r101;
    }
}
