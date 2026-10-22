package com.bytedance.lego.init.model;

import com.byted.cast.common.api.FirewallError;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum DelayTime extends Enum<DelayTime> implements Serializable {
    public static final DelayTime MINUTE_10 = null;
    public static final DelayTime MINUTE_15 = null;
    public static final DelayTime MINUTE_2 = null;
    public static final DelayTime MINUTE_5 = null;
    public static final DelayTime SECOND_15 = null;
    public static final DelayTime SECOND_3 = null;
    public static final DelayTime SECOND_30 = null;
    public static final DelayTime SECOND_5 = null;
    public static final DelayTime SECOND_60 = null;
    public static final DelayTime SECOND_8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DelayTime[] f254533a = null;
    private int value;

    static {
        DelayTime r100 = new DelayTime("SECOND_3", 0, 5000);
        SECOND_3 = r100;
        DelayTime r101 = new DelayTime("SECOND_5", 1, 5000);
        SECOND_5 = r101;
        DelayTime r102 = new DelayTime("SECOND_8", 2, 8000);
        SECOND_8 = r102;
        DelayTime r103 = new DelayTime("SECOND_15", 3, 15000);
        SECOND_15 = r103;
        DelayTime r104 = new DelayTime("SECOND_30", 4, 30000);
        SECOND_30 = r104;
        DelayTime r105 = new DelayTime("SECOND_60", 5, 60000);
        SECOND_60 = r105;
        DelayTime r110 = new DelayTime("MINUTE_2", 6, 120000);
        MINUTE_2 = r110;
        DelayTime r111 = new DelayTime("MINUTE_5", 7, 300000);
        MINUTE_5 = r111;
        DelayTime r112 = new DelayTime("MINUTE_10", 8, FirewallError.FIREWALL_OK);
        MINUTE_10 = r112;
        DelayTime r113 = new DelayTime("MINUTE_15", 9, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST);
        MINUTE_15 = r113;
        f254533a = new DelayTime[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static DelayTime[] values() {
        return (DelayTime[]) f254533a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static DelayTime from(int r100) {
        switch(r100) {
            case 3000: goto L24;
            case 5000: goto L22;
            case 8000: goto L20;
            case 15000: goto L18;
            case 30000: goto L16;
            case 60000: goto L14;
            case 120000: goto L12;
            case 300000: goto L10;
            case 600000: goto L8;
            case 900000: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MINUTE_15;
    L8:
        return MINUTE_10;
    L10:
        return MINUTE_5;
    L12:
        return MINUTE_2;
    L14:
        return SECOND_60;
    L16:
        return SECOND_30;
    L18:
        return SECOND_15;
    L20:
        return SECOND_8;
    L22:
        return SECOND_5;
    L24:
        return SECOND_3;
    }

    public static DelayTime valueOf(String r100) {
        return (DelayTime) a.a(DelayTime.class, r100);
    }

    public DelayTime(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
