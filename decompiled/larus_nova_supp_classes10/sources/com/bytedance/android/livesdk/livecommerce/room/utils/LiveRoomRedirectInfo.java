package com.bytedance.android.livesdk.livecommerce.room.utils;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveRoomRedirectInfo {
    public static final Lazy e = null;
    public static final a f = null;
    public final String a;
    public final Map<String, String> b;
    public final LiveRoomRedirectPriority c;
    public final long d;

    public static final class a {
        public a() {
        }

        public static Map a(String r4) {
            ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
            if (r0.getECOM_LIVE_ROUTE_NEW() == true) goto L18;
            if (r4 == null) goto L33;
            int r1 = r4.hashCode();
            if (r1 == 939723428) goto L15;
            if (r1 == 1265592045) goto L12;
            return null;
        L12:
            if (r4.equals("ecom_live_route_rule_heat") == true) goto L31;
            return null;
        L31:
            return r0.getECOM_LIVE_ROUTE_RULE_HEAT();
        L15:
            if (r4.equals("ecom_live_route_rule_normal") == true) goto L17;
            return null;
        L17:
            return r0.getECOM_LIVE_ROUTE_RULE_NORMAL();
        L33:
            return null;
        L18:
            if (r4 != null) goto L20;
        L29:
            return null;
        L20:
            if (r4.length() <= 0) goto L22;
            boolean r2 = true;
        L23:
            if (r2 == false) goto L29;
            Lazy r3 = LiveRoomRedirectInfo.e;
            if (((ConcurrentHashMap) r3.getValue()).contains(r4) == true) goto L28;
            ((ConcurrentHashMap) r3.getValue()).put(r4, EComABUtils.getLiveSettingValue(r4, new LinkedHashMap()));
        L28:
            return (Map) ((ConcurrentHashMap) r3.getValue()).get(r4);
        L22:
            r2 = false;
            goto L23
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof LiveRoomRedirectInfo) == false) goto L14;
        LiveRoomRedirectInfo r6 = (LiveRoomRedirectInfo) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        LiveRoomRedirectPriority r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        long r9 = this.d;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRoomRedirectInfo(routeRule=" + this.a + ", route=" + this.b + ", priority=" + this.c + ", logicalClock=" + this.d + ")";
    }

    static {
        f = new a();
        e = LazyKt.lazy(LiveRoomRedirectInfo$Companion$routeRuleMap$2.INSTANCE);
    }

    public LiveRoomRedirectInfo(String r2, Map<String, String> r3, LiveRoomRedirectPriority r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "route");
        Intrinsics.checkNotNullParameter(r4, "priority");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
