package com.bytedance.framwork.core.monitor;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum MonitorNetUtil$NetworkType extends Enum<MonitorNetUtil$NetworkType> {
    public static final MonitorNetUtil$NetworkType MOBILE = null;
    public static final MonitorNetUtil$NetworkType MOBILE_2G = null;
    public static final MonitorNetUtil$NetworkType MOBILE_3G = null;
    public static final MonitorNetUtil$NetworkType MOBILE_4G = null;
    public static final MonitorNetUtil$NetworkType NONE = null;
    public static final MonitorNetUtil$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorNetUtil$NetworkType[] f244853a = null;
    final int nativeInt;

    static {
        MonitorNetUtil$NetworkType r100 = new MonitorNetUtil$NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        MonitorNetUtil$NetworkType r101 = new MonitorNetUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r101;
        MonitorNetUtil$NetworkType r102 = new MonitorNetUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r102;
        MonitorNetUtil$NetworkType r103 = new MonitorNetUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r103;
        MonitorNetUtil$NetworkType r104 = new MonitorNetUtil$NetworkType("WIFI", 4, 4);
        WIFI = r104;
        MonitorNetUtil$NetworkType r105 = new MonitorNetUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r105;
        f244853a = new MonitorNetUtil$NetworkType[]{r100, r101, r102, r103, r104, r105};
    }

    public static MonitorNetUtil$NetworkType[] values() {
        return (MonitorNetUtil$NetworkType[]) f244853a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static MonitorNetUtil$NetworkType valueOf(String r100) {
        return (MonitorNetUtil$NetworkType) a.a(MonitorNetUtil$NetworkType.class, r100);
    }

    public MonitorNetUtil$NetworkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.nativeInt = r102;
    }
}
