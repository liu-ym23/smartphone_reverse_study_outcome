package com.bytedance.article.common.monitor.stack;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes14.dex */
public final enum HttpUtil$NetworkType extends Enum<HttpUtil$NetworkType> {
    public static final HttpUtil$NetworkType MOBILE = null;
    public static final HttpUtil$NetworkType MOBILE_2G = null;
    public static final HttpUtil$NetworkType MOBILE_3G = null;
    public static final HttpUtil$NetworkType MOBILE_4G = null;
    public static final HttpUtil$NetworkType NONE = null;
    public static final HttpUtil$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpUtil$NetworkType[] f192850a = null;
    final int nativeInt;

    static {
        HttpUtil$NetworkType r100 = new HttpUtil$NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        HttpUtil$NetworkType r101 = new HttpUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r101;
        HttpUtil$NetworkType r102 = new HttpUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r102;
        HttpUtil$NetworkType r103 = new HttpUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r103;
        HttpUtil$NetworkType r104 = new HttpUtil$NetworkType("WIFI", 4, 4);
        WIFI = r104;
        HttpUtil$NetworkType r105 = new HttpUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r105;
        f192850a = new HttpUtil$NetworkType[]{r100, r101, r102, r103, r104, r105};
    }

    public static HttpUtil$NetworkType[] values() {
        return (HttpUtil$NetworkType[]) f192850a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static HttpUtil$NetworkType valueOf(String r100) {
        return (HttpUtil$NetworkType) r27.a.a(HttpUtil$NetworkType.class, r100);
    }

    public HttpUtil$NetworkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.nativeInt = r102;
    }
}
