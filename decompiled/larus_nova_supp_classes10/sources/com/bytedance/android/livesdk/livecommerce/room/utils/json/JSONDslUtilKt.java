package com.bytedance.android.livesdk.livecommerce.room.utils.json;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class JSONDslUtilKt {
    public static final JSONObject a(a... r5) {
        Intrinsics.checkNotNullParameter(r5, "envPair");
        JSONObject r0 = new JSONObject();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        a r3 = r5[r2];
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "obj");
        r3.a.invoke(r0);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final a b(final String r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$objto");
        return new a(new JSONDslUtilKt$objto$1(r2, r3));
    }

    public static final a c(final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$objto");
        Intrinsics.checkNotNullParameter(r3, "value");
        return new a(new JSONDslUtilKt$objto$3(r2, r3));
    }

    public static final a d(final String r2, final JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$objto");
        Intrinsics.checkNotNullParameter(r3, "value");
        return new a(new JSONDslUtilKt$objto$6(r2, r3));
    }

    public static final a e(final String r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$objto");
        return new a(new JSONDslUtilKt$objto$5(r2, r3));
    }
}
