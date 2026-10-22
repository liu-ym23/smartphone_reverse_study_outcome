package com.bytedance.framwork.core.monitor;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum MonitorNetUtil$CompressType extends Enum<MonitorNetUtil$CompressType> {
    public static final MonitorNetUtil$CompressType DEFLATER = null;
    public static final MonitorNetUtil$CompressType GZIP = null;
    public static final MonitorNetUtil$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorNetUtil$CompressType[] f244852a = null;
    final int nativeInt;

    static {
        MonitorNetUtil$CompressType r100 = new MonitorNetUtil$CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        MonitorNetUtil$CompressType r101 = new MonitorNetUtil$CompressType("GZIP", 1, 1);
        GZIP = r101;
        MonitorNetUtil$CompressType r102 = new MonitorNetUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r102;
        f244852a = new MonitorNetUtil$CompressType[]{r100, r101, r102};
    }

    public static MonitorNetUtil$CompressType[] values() {
        return (MonitorNetUtil$CompressType[]) f244852a.clone();
    }

    public static MonitorNetUtil$CompressType valueOf(String r100) {
        return (MonitorNetUtil$CompressType) a.a(MonitorNetUtil$CompressType.class, r100);
    }

    public MonitorNetUtil$CompressType(String r100, int r101, int r102) {
        super(r100, r101);
        this.nativeInt = r102;
    }
}
