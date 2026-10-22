package com.bytedance.rts.kmp.foundation;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@RTSHiddenFromObjC
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Object a(Map r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "json");
            Intrinsics.checkNotNullParameter(r2, "key");
            return r1.get(r2);
        }

        public final Map<String, Object> update(Map<String, Object> r3, Map<String, Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "json");
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r3, "json");
            Intrinsics.checkNotNullParameter(r4, "data");
            r3.putAll(r4);
            return r3;
        }

        public static void b(Map r1, String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r1, "json");
            Intrinsics.checkNotNullParameter(r2, "key");
            if (r3 != null) goto L6;
            r1.remove(r2);
            return;
        L6:
            r1.put(r2, r3);
        }
    }

    static {
    }
}
