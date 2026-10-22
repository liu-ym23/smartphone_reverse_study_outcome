package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.home.entity.FansClubInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final Integer b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ShopFollowState(followState=" + this.a + ", fansLevel=" + this.b + ")";
        }

        public a(String r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static a b(com.bytedance.android.shopping.store.home.entity.d r5) {
        Integer r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        Integer r1 = r5.c;
        boolean r2 = false;
        if (r1 == null) goto L11;
        boolean r3 = true;
        if (r1.intValue() != 1) goto L11;
    L12:
        FansClubInfo r4 = r5.h;
        if (r4 == null) goto L15;
        boolean r6 = r4.getOpenFansClub();
    L16:
        FansClubInfo r7 = r5.h;
        if (r7 == null) goto L19;
        r2 = r7.getJoinStatus();
    L19:
        FansClubInfo r8 = r5.h;
        if (r8 == null) goto L22;
        r0 = r8.getFansClubLevel();
    L22:
        if (r6 == false) goto L27;
        if (r3 == false) goto L27;
        if (r2 == false) goto L26;
        String r9 = "fans_level";
    L31:
        return new a(r9, r0);
    L26:
        r9 = "join_fans";
    L27:
        if (r3 == false) goto L29;
        r9 = "follow";
        goto L31
    L29:
        r9 = "unfollow";
        goto L31
    L15:
        r6 = false;
    L11:
        r3 = false;
        goto L12
    }

    public static void a(Map r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "sliceItemStates");
        if (r3 != null) goto L5;
        return;
    L5:
        String r0 = r3.a;
        if (r0 == null) goto L8;
        r2.put("shop_follow_state", r0);
    L8:
        Integer r4 = r3.b;
        if (r4 == null) goto L12;
        r2.put("shop_fans_level", Integer.valueOf(r4.intValue()));
        return;
    }
}
