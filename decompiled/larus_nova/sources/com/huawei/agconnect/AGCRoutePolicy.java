package com.huawei.agconnect;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class AGCRoutePolicy {
    public static final AGCRoutePolicy CHINA = null;
    public static final AGCRoutePolicy GERMANY = null;
    public static final AGCRoutePolicy RUSSIA = null;
    public static final AGCRoutePolicy SINGAPORE = null;
    public static final AGCRoutePolicy UNKNOWN = null;
    private final int route;

    static {
        UNKNOWN = new AGCRoutePolicy(0);
        CHINA = new AGCRoutePolicy(1);
        GERMANY = new AGCRoutePolicy(2);
        RUSSIA = new AGCRoutePolicy(3);
        SINGAPORE = new AGCRoutePolicy(4);
    }

    private AGCRoutePolicy(int r100) {
        this.route = r100;
    }

    private int hash(Object... r100) {
        return Arrays.hashCode(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (AGCRoutePolicy.class != r100.getClass()) goto L15;
        if (this.route == ((AGCRoutePolicy) r100).route) goto L16;
        return false;
    L16:
        return true;
    }

    public String getRouteName() {
        int r100 = this.route;
        if (r100 != 1) goto L5;
        return "CN";
    L5:
        if (r100 != 2) goto L7;
        return "DE";
    L7:
        if (r100 != 3) goto L9;
        return "RU";
    L9:
        if (r100 == 4) goto L12;
        return "UNKNOWN";
    L12:
        return "SG";
    }

    public int hashCode() {
        return hash(new Object[]{Integer.valueOf(this.route)});
    }
}
