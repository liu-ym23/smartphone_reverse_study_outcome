package com.bytedance.awemeopen.bizmodels.share;

import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/share/ShareChannel;", "", "Wechat", "WechatTimeline", Constants.SOURCE_QQ, "QQZone", "Weibo", "FeiShu", "Copy", "Cancel", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum ShareChannel extends Enum<ShareChannel> {
    public static final ShareChannel Cancel = null;
    public static final ShareChannel Copy = null;
    public static final ShareChannel FeiShu = null;
    public static final ShareChannel QQ = null;
    public static final ShareChannel QQZone = null;
    public static final ShareChannel Wechat = null;
    public static final ShareChannel WechatTimeline = null;
    public static final ShareChannel Weibo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareChannel[] f198212a = null;

    public static ShareChannel valueOf(String r100) {
        return (ShareChannel) a.a(ShareChannel.class, r100);
    }

    public static ShareChannel[] values() {
        return (ShareChannel[]) f198212a.clone();
    }

    static {
        ShareChannel r100 = new ShareChannel("Wechat", 0);
        Wechat = r100;
        ShareChannel r101 = new ShareChannel("WechatTimeline", 1);
        WechatTimeline = r101;
        ShareChannel r102 = new ShareChannel(Constants.SOURCE_QQ, 2);
        QQ = r102;
        ShareChannel r103 = new ShareChannel("QQZone", 3);
        QQZone = r103;
        ShareChannel r104 = new ShareChannel("Weibo", 4);
        Weibo = r104;
        ShareChannel r105 = new ShareChannel("FeiShu", 5);
        FeiShu = r105;
        ShareChannel r110 = new ShareChannel("Copy", 6);
        Copy = r110;
        ShareChannel r111 = new ShareChannel("Cancel", 7);
        Cancel = r111;
        f198212a = new ShareChannel[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public ShareChannel(String r100, int r101) {
        super(r100, r101);
    }
}
