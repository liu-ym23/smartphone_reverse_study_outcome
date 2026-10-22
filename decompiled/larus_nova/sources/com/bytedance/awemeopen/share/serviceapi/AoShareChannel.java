package com.bytedance.awemeopen.share.serviceapi;

import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/share/serviceapi/AoShareChannel;", "", "Wechat", "WechatTimeline", Constants.SOURCE_QQ, "QQZone", "Weibo", "FeiShu", "Copy", "Cancel", "ao_share_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum AoShareChannel extends Enum<AoShareChannel> {
    public static final AoShareChannel Cancel = null;
    public static final AoShareChannel Copy = null;
    public static final AoShareChannel FeiShu = null;
    public static final AoShareChannel QQ = null;
    public static final AoShareChannel QQZone = null;
    public static final AoShareChannel Wechat = null;
    public static final AoShareChannel WechatTimeline = null;
    public static final AoShareChannel Weibo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AoShareChannel[] f199008a = null;

    public static AoShareChannel valueOf(String r100) {
        return (AoShareChannel) a.a(AoShareChannel.class, r100);
    }

    public static AoShareChannel[] values() {
        return (AoShareChannel[]) f199008a.clone();
    }

    static {
        AoShareChannel r100 = new AoShareChannel("Wechat", 0);
        Wechat = r100;
        AoShareChannel r101 = new AoShareChannel("WechatTimeline", 1);
        WechatTimeline = r101;
        AoShareChannel r102 = new AoShareChannel(Constants.SOURCE_QQ, 2);
        QQ = r102;
        AoShareChannel r103 = new AoShareChannel("QQZone", 3);
        QQZone = r103;
        AoShareChannel r104 = new AoShareChannel("Weibo", 4);
        Weibo = r104;
        AoShareChannel r105 = new AoShareChannel("FeiShu", 5);
        FeiShu = r105;
        AoShareChannel r110 = new AoShareChannel("Copy", 6);
        Copy = r110;
        AoShareChannel r111 = new AoShareChannel("Cancel", 7);
        Cancel = r111;
        f199008a = new AoShareChannel[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public AoShareChannel(String r100, int r101) {
        super(r100, r101);
    }
}
