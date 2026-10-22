package com.bytedance.ug.sdk.share.api.entity;

import android.graphics.Bitmap;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import in7.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kn7.d;
import mn7.b;
import mn7.c;
import mn7.e;
import mn7.f;
import oo7.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class ShareContent implements Serializable {
    private r.a logContext;
    private String mAudioUrl;
    private String mCopyUrl;
    private mn7.a mDownloadProgressDialog;
    private h mEventCallBack;
    private String mExtra;
    private kn7.a mExtraParams;
    private String mFileName;
    private String mFileUrl;
    private String mFrom;
    private ShareChannelType mFromChannel;
    private String mHiddenImageUrl;
    private Bitmap mImage;
    private ArrayList<Bitmap> mImageBitmapList;
    private b mImageTokenDialog;
    private d mImageTokenShareInfo;
    private String mImageUrl;
    private JSONObject mLogEventParams;
    private String mPanelId;
    private String mQrcodeImageUrl;
    private String mResourceId;
    private ShareChannelType mShareChanelType;
    private ShareContentType mShareContentType;
    private c mShareProgressView;
    private ShareStrategy mShareStrategy;
    private List<ShareStrategy> mShareStrategyList;
    private String mShareToken;
    private mn7.d mShareTokenDialog;
    private in7.b mShareTokenGenerator;
    private ShareContentType mSystemShareType;
    private String mTargetUrl;
    private String mText;
    private String mTitle;
    private d mTokenShareInfo;
    private co7.d mVideoDialogCallback;
    private e mVideoGuideDialog;
    private String mVideoName;
    private f mVideoShareDialog;
    private String mVideoUrl;

    public static /* synthetic */ class a {
    }

    public b getImageTokenDialog() {
        return null;
    }

    public c getShareProgressView() {
        return null;
    }

    public mn7.d getShareTokenDialog() {
        return null;
    }

    public co7.d getVideoDialogCallback() {
        return null;
    }

    public e getVideoGuideDialog() {
        return null;
    }

    public f getVideoShareDialog() {
        return null;
    }

    public void setVideoDialogCallback(co7.d r100) {
    }

    public ShareContent clone() {
        d r100 = this.mTokenShareInfo;
        a r101 = null;
        if (r100 == null) goto L5;
        d r102 = new d();
        r102.f504260a = r100.f504260a;
    L6:
        d r103 = this.mImageTokenShareInfo;
        if (r103 == null) goto L9;
        d r104 = new d();
        r104.f504260a = r103.f504260a;
    L11:
        if (this.mExtraParams == null) goto L13;
        kn7.a r105 = new kn7.a();
        kn7.a r106 = this.mExtraParams;
        r105.f504247a = r106.f504247a;
        r105.f504248b = r106.f504248b;
        r105.f504249c = r106.f504249c;
        r105.f504250d = r106.f504250d;
        r105.f504251e = r106.f504251e;
        r105.f504253g = r106.f504253g;
        r105.f504254h = r106.f504254h;
        r105.f504252f = r106.f504252f;
    L14:
        ShareContent r107 = new ShareContent(r101);
        ShareContentType r108 = this.mShareContentType;
        if (r108 == null) goto L17;
        access$102(r107, r108);
    L17:
        ShareContentType r109 = this.mSystemShareType;
        if (r109 == null) goto L20;
        access$202(r107, r109);
    L20:
        access$1202(r107, this.mShareChanelType);
        access$802(r107, this.mShareStrategy);
        access$902(r107, this.mShareStrategyList);
        access$502(r107, this.mTitle);
        access$702(r107, this.mText);
        access$602(r107, this.mTargetUrl);
        access$2002(r107, this.mCopyUrl);
        access$402(r107, this.mImage);
        access$1302(r107, this.mImageBitmapList);
        access$1402(r107, this.mImageUrl);
        access$1902(r107, this.mHiddenImageUrl);
        access$1802(r107, this.mQrcodeImageUrl);
        access$1502(r107, this.mVideoUrl);
        access$1602(r107, this.mVideoName);
        access$1702(r107, this.mAudioUrl);
        access$2202(r107, this.mFileName);
        access$2102(r107, this.mFileUrl);
        access$2502(r107, null);
        access$2602(r107, null);
        access$2702(r107, null);
        access$2802(r107, null);
        access$2902(r107, this.mDownloadProgressDialog);
        access$3002(r107, null);
        access$3102(r107, null);
        access$302(r107, this.mEventCallBack);
        access$1002(r107, r102);
        access$1102(r107, r104);
        access$2302(r107, r105);
        access$2402(r107, this.mLogEventParams);
        access$3202(r107, this.mFrom);
        access$3302(r107, this.mFromChannel);
        access$3402(r107, this.mPanelId);
        access$3502(r107, this.mResourceId);
        access$3602(r107, this.mExtra);
        access$3702(r107, this.mShareTokenGenerator);
        access$3802(r107, this.mShareToken);
        if (access$3700(r107) != null) goto L23;
        access$3702(r107, new in7.b.a());
    L23:
        r107.logContext = this.logContext;
        return r107;
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    private ShareContent() {
        this.mShareStrategy = ShareStrategy.NORMAL;
        this.mShareContentType = ShareContentType.ALL;
        this.mSystemShareType = ShareContentType.TEXT;
        this.logContext = new r.a();
    }

    public String getAudioUrl() {
        return this.mAudioUrl;
    }

    public String getCopyUrl() {
        return this.mCopyUrl;
    }

    public mn7.a getDownloadProgressDialog() {
        return this.mDownloadProgressDialog;
    }

    public h getEventCallBack() {
        return this.mEventCallBack;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public kn7.a getExtraParams() {
        return this.mExtraParams;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFileUrl() {
        return this.mFileUrl;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public ShareChannelType getFromChannel() {
        return this.mFromChannel;
    }

    public String getHiddenImageUrl() {
        return this.mHiddenImageUrl;
    }

    public Bitmap getImage() {
        return this.mImage;
    }

    public ArrayList<Bitmap> getImageBitmapList() {
        return this.mImageBitmapList;
    }

    public d getImageTokenShareInfo() {
        return this.mImageTokenShareInfo;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public r.a getLogContext() {
        return this.logContext;
    }

    public JSONObject getLogEventParams() {
        return this.mLogEventParams;
    }

    public String getPanelId() {
        return this.mPanelId;
    }

    public String getQrcodeImageUrl() {
        return this.mQrcodeImageUrl;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public ShareChannelType getShareChanelType() {
        return this.mShareChanelType;
    }

    public ShareContentType getShareContentType() {
        return this.mShareContentType;
    }

    public ShareStrategy getShareStrategy() {
        return this.mShareStrategy;
    }

    public List<ShareStrategy> getShareStrategyList() {
        return this.mShareStrategyList;
    }

    public String getShareToken() {
        return this.mShareToken;
    }

    public in7.b getShareTokenGenerator() {
        return this.mShareTokenGenerator;
    }

    public ShareContentType getSystemShareType() {
        return this.mSystemShareType;
    }

    public String getTargetUrl() {
        return this.mTargetUrl;
    }

    public String getText() {
        return this.mText;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public d getTokenShareInfo() {
        return this.mTokenShareInfo;
    }

    public String getVideoName() {
        return this.mVideoName;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8525clone() throws CloneNotSupportedException {
        return clone();
    }

    public /* synthetic */ ShareContent(a r100) {
        this();
    }

    public static /* synthetic */ in7.b access$3700(ShareContent r100) {
        return r100.mShareTokenGenerator;
    }

    public void setAudioUrl(String r100) {
        this.mAudioUrl = r100;
    }

    public void setCopyUrl(String r100) {
        this.mCopyUrl = r100;
    }

    public void setEventCallBack(h r100) {
        this.mEventCallBack = r100;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public void setExtraParams(kn7.a r100) {
        this.mExtraParams = r100;
    }

    public void setFileName(String r100) {
        this.mFileName = r100;
    }

    public void setFileUrl(String r100) {
        this.mFileUrl = r100;
    }

    public void setFrom(String r100) {
        this.mFrom = r100;
    }

    public void setFromChannel(ShareChannelType r100) {
        this.mFromChannel = r100;
    }

    public void setHiddenImageUrl(String r100) {
        this.mHiddenImageUrl = r100;
    }

    public void setImage(Bitmap r100) {
        this.mImage = r100;
    }

    public void setImageBitmapList(ArrayList<Bitmap> r100) {
        this.mImageBitmapList = r100;
    }

    public void setImageTokenShareInfo(d r100) {
        this.mImageTokenShareInfo = r100;
    }

    public void setImageUrl(String r100) {
        this.mImageUrl = r100;
    }

    public void setPanelId(String r100) {
        this.mPanelId = r100;
    }

    public void setQrcodeImageUrl(String r100) {
        this.mQrcodeImageUrl = r100;
    }

    public void setResourceId(String r100) {
        this.mResourceId = r100;
    }

    public void setShareChannelType(ShareChannelType r100) {
        this.mShareChanelType = r100;
    }

    public void setShareContentType(ShareContentType r100) {
        this.mShareContentType = r100;
    }

    public void setShareStrategy(ShareStrategy r100) {
        this.mShareStrategy = r100;
    }

    public void setShareStrategyList(List<ShareStrategy> r100) {
        this.mShareStrategyList = r100;
    }

    public void setShareToken(String r100) {
        this.mShareToken = r100;
    }

    public void setSystemShareType(ShareContentType r100) {
        this.mSystemShareType = r100;
    }

    public void setTargetUrl(String r100) {
        this.mTargetUrl = r100;
    }

    public void setText(String r100) {
        this.mText = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }

    public void setTokenShareInfo(d r100) {
        this.mTokenShareInfo = r100;
    }

    public void setVideoName(String r100) {
        this.mVideoName = r100;
    }

    public void setVideoUrl(String r100) {
        this.mVideoUrl = r100;
    }

    public static /* synthetic */ d access$1002(ShareContent r100, d r101) {
        r100.mTokenShareInfo = r101;
        return r101;
    }

    public static /* synthetic */ ShareContentType access$102(ShareContent r100, ShareContentType r101) {
        r100.mShareContentType = r101;
        return r101;
    }

    public static /* synthetic */ d access$1102(ShareContent r100, d r101) {
        r100.mImageTokenShareInfo = r101;
        return r101;
    }

    public static /* synthetic */ ShareChannelType access$1202(ShareContent r100, ShareChannelType r101) {
        r100.mShareChanelType = r101;
        return r101;
    }

    public static /* synthetic */ ArrayList access$1302(ShareContent r100, ArrayList r101) {
        r100.mImageBitmapList = r101;
        return r101;
    }

    public static /* synthetic */ String access$1402(ShareContent r100, String r101) {
        r100.mImageUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$1502(ShareContent r100, String r101) {
        r100.mVideoUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$1602(ShareContent r100, String r101) {
        r100.mVideoName = r101;
        return r101;
    }

    public static /* synthetic */ String access$1702(ShareContent r100, String r101) {
        r100.mAudioUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$1802(ShareContent r100, String r101) {
        r100.mQrcodeImageUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$1902(ShareContent r100, String r101) {
        r100.mHiddenImageUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$2002(ShareContent r100, String r101) {
        r100.mCopyUrl = r101;
        return r101;
    }

    public static /* synthetic */ ShareContentType access$202(ShareContent r100, ShareContentType r101) {
        r100.mSystemShareType = r101;
        return r101;
    }

    public static /* synthetic */ String access$2102(ShareContent r100, String r101) {
        r100.mFileUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$2202(ShareContent r100, String r101) {
        r100.mFileName = r101;
        return r101;
    }

    public static /* synthetic */ kn7.a access$2302(ShareContent r100, kn7.a r101) {
        r100.mExtraParams = r101;
        return r101;
    }

    public static /* synthetic */ JSONObject access$2402(ShareContent r100, JSONObject r101) {
        r100.mLogEventParams = r101;
        return r101;
    }

    public static /* synthetic */ mn7.d access$2502(ShareContent r100, mn7.d r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ b access$2602(ShareContent r100, b r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ e access$2702(ShareContent r100, e r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ f access$2802(ShareContent r100, f r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ mn7.a access$2902(ShareContent r100, mn7.a r101) {
        r100.mDownloadProgressDialog = r101;
        return r101;
    }

    public static /* synthetic */ c access$3002(ShareContent r100, c r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ h access$302(ShareContent r100, h r101) {
        r100.mEventCallBack = r101;
        return r101;
    }

    public static /* synthetic */ co7.d access$3102(ShareContent r100, co7.d r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ String access$3202(ShareContent r100, String r101) {
        r100.mFrom = r101;
        return r101;
    }

    public static /* synthetic */ ShareChannelType access$3302(ShareContent r100, ShareChannelType r101) {
        r100.mFromChannel = r101;
        return r101;
    }

    public static /* synthetic */ String access$3402(ShareContent r100, String r101) {
        r100.mPanelId = r101;
        return r101;
    }

    public static /* synthetic */ String access$3502(ShareContent r100, String r101) {
        r100.mResourceId = r101;
        return r101;
    }

    public static /* synthetic */ String access$3602(ShareContent r100, String r101) {
        r100.mExtra = r101;
        return r101;
    }

    public static /* synthetic */ in7.b access$3702(ShareContent r100, in7.b r101) {
        r100.mShareTokenGenerator = r101;
        return r101;
    }

    public static /* synthetic */ String access$3802(ShareContent r100, String r101) {
        r100.mShareToken = r101;
        return r101;
    }

    public static /* synthetic */ Bitmap access$402(ShareContent r100, Bitmap r101) {
        r100.mImage = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(ShareContent r100, String r101) {
        r100.mTitle = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(ShareContent r100, String r101) {
        r100.mTargetUrl = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(ShareContent r100, String r101) {
        r100.mText = r101;
        return r101;
    }

    public static /* synthetic */ ShareStrategy access$802(ShareContent r100, ShareStrategy r101) {
        r100.mShareStrategy = r101;
        return r101;
    }

    public static /* synthetic */ List access$902(ShareContent r100, List r101) {
        r100.mShareStrategyList = r101;
        return r101;
    }
}
