package com.bytedance.rts.kmp.foundation;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@RTSHiddenFromObjC
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267611a = 0;

    public static final class a {
        public static Object a(Map r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            return r100.get(r101);
        }

        public final Map<String, Object> update(Map<String, Object> r100, Map<String, Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "data");
            r100.putAll(r101);
            return r100;
        }

        public static void b(Map r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            if (r102 != null) goto L6;
            r100.remove(r101);
            return;
        L6:
            r100.put(r101, r102);
        }
    }

    static {
    }
}
