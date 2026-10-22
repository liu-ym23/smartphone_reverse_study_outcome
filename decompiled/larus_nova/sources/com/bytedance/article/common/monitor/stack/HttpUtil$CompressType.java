package com.bytedance.article.common.monitor.stack;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes14.dex */
public final enum HttpUtil$CompressType extends Enum<HttpUtil$CompressType> {
    public static final HttpUtil$CompressType DEFLATER = null;
    public static final HttpUtil$CompressType GZIP = null;
    public static final HttpUtil$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpUtil$CompressType[] f192849a = null;
    final int nativeInt;

    static {
        HttpUtil$CompressType r100 = new HttpUtil$CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        HttpUtil$CompressType r101 = new HttpUtil$CompressType("GZIP", 1, 1);
        GZIP = r101;
        HttpUtil$CompressType r102 = new HttpUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r102;
        f192849a = new HttpUtil$CompressType[]{r100, r101, r102};
    }

    public static HttpUtil$CompressType[] values() {
        return (HttpUtil$CompressType[]) f192849a.clone();
    }

    public static HttpUtil$CompressType valueOf(String r100) {
        return (HttpUtil$CompressType) r27.a.a(HttpUtil$CompressType.class, r100);
    }

    public HttpUtil$CompressType(String r100, int r101, int r102) {
        super(r100, r101);
        this.nativeInt = r102;
    }
}
