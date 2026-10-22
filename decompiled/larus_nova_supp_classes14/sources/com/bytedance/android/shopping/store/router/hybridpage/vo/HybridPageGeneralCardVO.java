package com.bytedance.android.shopping.store.router.hybridpage.vo;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.shopping.store.hybridproduct.extension.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageGeneralCardVO extends o {
    public static final a i = null;
    public final Lazy h;

    public static final class a {
        public a() {
        }

        public static HybridPageGeneralCardVO a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "data");
            HybridPageGeneralCardVO r5 = new HybridPageGeneralCardVO();
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
            int r2 = t0.a;     // Catch: Throwable -> L11
            Object r6 = t0.a.a.fromJson(r4, Map.class);     // Catch: Throwable -> L11
            if ((r6 instanceof Map) == true) goto L6;
            r6 = null;
        L6:
            Map r7 = (Map) r6;     // Catch: Throwable -> L11
            if (r7 != null) goto L9;
            r7 = MapsKt.emptyMap();     // Catch: Throwable -> L11
        L9:
            Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L11
        L14:
            if (Result.isFailure-impl(r8) == true) goto L17;
            r0 = r8;
        L17:
            Map<String, ? extends Object> r9 = (Map) r0;
            if (r9 != null) goto L20;
            r9 = MapsKt.emptyMap();
        L20:
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r5.a = r9;
            return r5;
        L11:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        }
    }

    public final int modelType() {
        return 100;
    }

    static {
        i = new a();
    }

    public HybridPageGeneralCardVO() {
        this.h = LazyKt.lazy(new HybridPageGeneralCardVO$sliceRenderDataMap$2(this));
    }
}
