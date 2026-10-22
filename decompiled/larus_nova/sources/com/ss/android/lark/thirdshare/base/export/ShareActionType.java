package com.ss.android.lark.thirdshare.base.export;

import android.content.Context;
import android.text.TextUtils;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes38.dex */
public class ShareActionType implements Serializable {
    public static final ShareActionType COPY = null;
    public static final String PACKAGE_NAME_QQ = "com.tencent.mobileqq";
    public static final String PACKAGE_NAME_WB = "com.sina.weibo";
    public static final String PACKAGE_NAME_WX = "com.tencent.mm";
    public static final ShareActionType QQ = null;
    public static final ShareActionType SAVE = null;
    public static final ShareActionType SYS = null;
    public static final ShareActionType UNKNOWN = null;
    public static final ShareActionType WB = null;
    public static final ShareActionType WX = null;
    public static final ShareActionType WX_TIMELINE = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, ShareActionType> f441192b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f441193c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ShareItemInfo f441194a;
    private boolean isThirdApp;
    private String typeName;
    private int value;

    public static abstract class ShareItemClickListener implements Serializable {
        private ShareActionType type;

        public abstract void onClick(Context r100, ShareEntity r101);

        public ShareItemClickListener(ShareActionType r100) {
            this.type = r100;
        }

        public void onClickReal(Context r100, ShareEntity r101) {
            r101.setCurActionType(this.type);
            onClick(r100, r101);
        }
    }

    public static class ShareItemInfo implements Serializable {
        static final ShareItemInfo COPY_ITEM_INFO = null;
        static final ShareItemInfo QQ_ITEM_INFO = null;
        static final ShareItemInfo SAVE_ITEM_INFO = null;
        static final ShareItemInfo SYS_ITEM_INFO = null;
        static final ShareItemInfo WB_ITEM_INFO = null;
        static final ShareItemInfo WX_ITEM_INFO = null;
        static final ShareItemInfo WX_TIMELINE_ITEM_INFO = null;
        public int mIconId;
        public ShareItemClickListener mListener;
        public int mNameResId;
        public boolean shouldApplyTint;

        static {
            WX_ITEM_INFO = new ShareItemInfo(R.drawable.ts_icon_wx, R.string.Lark_UserGrowth_TitleWechat);
            WB_ITEM_INFO = new ShareItemInfo(R.drawable.ts_icon_wb, R.string.Lark_UserGrowth_TitleWeibo);
            QQ_ITEM_INFO = new ShareItemInfo(R.drawable.ts_icon_qq, R.string.Lark_UserGrowth_TitleQQ);
            COPY_ITEM_INFO = new ShareItemInfo(R.drawable.ud_icon_link_copy_outlined, R.string.Lark_UserGrowth_InvitePeopleContactsShareToCopy, true);
            SYS_ITEM_INFO = new ShareItemInfo(R.drawable.ud_icon_more_outlined, R.string.Lark_UserGrowth_InvitePeopleContactsShareToMore, true);
            WX_TIMELINE_ITEM_INFO = new ShareItemInfo(R.drawable.ts_icon_wx_timeline, R.string.Lark_Invitation_SharePYQ);
            SAVE_ITEM_INFO = new ShareItemInfo(R.drawable.ud_icon_download_outlined, R.string.Lark_Legacy_QrCodeSave, true);
        }

        public String getName() {
            return UIHelper.getString(this.mNameResId);
        }

        public ShareItemInfo setListener(final ShareActionType r100) {
            setListener(new AnonymousClass1(this, r100));
            return this;
        }

        public ShareItemInfo setListener(ShareItemClickListener r100) {
            this.mListener = r100;
            return this;
        }

        public ShareItemInfo(int r100, int r101) {
            this.mIconId = r100;
            this.mNameResId = r101;
        }

        public ShareItemInfo(int r100, int r101, boolean r102) {
            this.mIconId = r100;
            this.mNameResId = r101;
            this.shouldApplyTint = r102;
        }
    }

    static {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        f441192b = r100;
        f441193c = new AtomicInteger(-1);
        ShareActionType r101 = new ShareActionType("unknown", false);
        r100.put("unknown", r101);
        UNKNOWN = r101;
        ShareActionType r102 = new ShareActionType("wechat_session", true);
        r100.put("wechat_session", r102);
        WX = r102;
        ShareActionType r103 = new ShareActionType("weibo", true);
        r100.put("weibo", r103);
        WB = r103;
        ShareActionType r104 = new ShareActionType("qq", true);
        r100.put("qq", r104);
        QQ = r104;
        ShareActionType r105 = new ShareActionType(ShareChannel.COPY_TEXT, false);
        r100.put(ShareChannel.COPY_TEXT, r105);
        COPY = r105;
        ShareActionType r106 = new ShareActionType("system_share", false);
        r100.put("system_share", r106);
        SYS = r106;
        ShareActionType r107 = new ShareActionType("wechat_timeline", true);
        r100.put("wechat_timeline", r107);
        WX_TIMELINE = r107;
        ShareActionType r108 = new ShareActionType(ShareChannel.SAVE_IMAGE, false);
        r100.put(ShareChannel.SAVE_IMAGE, r108);
        SAVE = r108;
        r102.a(ShareItemInfo.WX_ITEM_INFO);
        r103.a(ShareItemInfo.WB_ITEM_INFO);
        r104.a(ShareItemInfo.QQ_ITEM_INFO);
        r105.a(ShareItemInfo.COPY_ITEM_INFO);
        r106.a(ShareItemInfo.SYS_ITEM_INFO);
        r107.a(ShareItemInfo.WX_TIMELINE_ITEM_INFO);
        r108.a(ShareItemInfo.SAVE_ITEM_INFO);
    }

    public ShareActionType copy() {
        String r100 = this.typeName;
        ShareActionType r101 = new ShareActionType(r100, this.isThirdApp);
        ((ConcurrentHashMap) f441192b).put(r100, r101);
        return r101;
    }

    public String getPkgName() {
        if (WX.equals(this) == false) goto L5;
        return "com.tencent.mm";
    L5:
        if (WX_TIMELINE.equals(this) == false) goto L8;
        return "com.tencent.mm";
    L8:
        if (WB.equals(this) == false) goto L12;
        return "com.sina.weibo";
    L12:
        if (QQ.equals(this) == false) goto L15;
        return "com.tencent.mobileqq";
    L15:
        Log.e("ThirdShare", this + "is not third app share type.");
        return "";
    }

    public boolean isBaseActionType() {
        if (this != WX) goto L5;
    L18:
        return true;
    L5:
        if (this == WB) goto L18;
        if (this == QQ) goto L18;
        if (this == COPY) goto L18;
        if (this == SYS) goto L18;
        if (this == WX_TIMELINE) goto L18;
        if (this == SAVE) goto L18;
        return false;
    }

    public String toString() {
        return name();
    }

    public ShareItemInfo getShareItemInfo() {
        return this.f441194a;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isThirdAppShareType() {
        return this.isThirdApp;
    }

    public String name() {
        return this.typeName;
    }

    public static ShareActionType value2ShareActionType(int r100) {
        Iterator r101 = ((ConcurrentHashMap) f441192b).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (((ShareActionType) r102.getValue()).getValue() != r100) goto L4;
        return (ShareActionType) r102.getValue();
    L10:
        return UNKNOWN;
    }

    public final void a(ShareItemInfo r100) {
        this.f441194a = r100.setListener(this);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ShareActionType) == true) goto L5;
        return false;
    L5:
        return TextUtils.equals(this.typeName, ((ShareActionType) r100).typeName);
    }

    public void setThirdApp(boolean r100) {
        this.isThirdApp = r100;
    }

    public ShareActionType(String r100, boolean r101) {
        this.value = f441193c.getAndIncrement();
        this.typeName = r100;
        this.isThirdApp = r101;
    }

    public static ShareActionType getShareActionType(String r100, boolean r101) {
        Map<String, ShareActionType> r102 = f441192b;
        ShareActionType r103 = (ShareActionType) ((ConcurrentHashMap) r102).get(r100);
        if (r103 == null) goto L5;
        return r103;
    L5:
        if (r101 == false) goto L9;
        Log.i("ThirdShare", r100 + " will be added!!!");
        ShareActionType r104 = new ShareActionType(r100, false);
        ((ConcurrentHashMap) r102).put(r100, r104);
        return r104;
    L9:
        return UNKNOWN;
    }

    public void setShareItemInfo(ShareItemInfo r100, ShareItemClickListener r101) {
        this.f441194a = r100.setListener(r101);
    }
}
