package com.bytedance.navigation.kmp.handler.tracker;

import com.byted.cast.common.auth.AuthConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f265921a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f265922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f265923b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f265922a == r101.f265922a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f265923b, r101.f265923b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f265922a * 31;
            Integer r101 = this.f265923b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TraceRouteType(routePlanType=" + this.f265922a + ", ridingType=" + this.f265923b + ")";
        }

        public a(int r100, Integer r101) {
            this.f265922a = r100;
            this.f265923b = r101;
        }
    }

    static {
    }

    public static Map a(c37.g r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = r100.f22332g;
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L6;
        a r102 = new a(1, 1);
    L11:
        Pair[] r103 = new Pair[2];
        r103[0] = TuplesKt.to("route_plan_type", Integer.valueOf(r102.f265922a));
        String r104 = r100.f22337l;
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        r103[1] = TuplesKt.to(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID, r104);
        Map r105 = MapsKt.mutableMapOf(r103);
        Integer r106 = r102.f265923b;
        if (r106 == null) goto L17;
        r105.put("riding_type", Integer.valueOf(r106.intValue()));
    L17:
        Integer r107 = r100.f22339n;
        if (r107 == null) goto L20;
        r105.put("poi_type", Integer.valueOf(r107.intValue()));
    L20:
        return r105;
    L6:
        if (r101 == 3) goto L8;
        r102 = new a(0, null);
        goto L11
    L8:
        r102 = new a(2, null);
        goto L11
    L10:
        r102 = new a(1, 0);
        goto L11
    }
}
