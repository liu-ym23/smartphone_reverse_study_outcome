package com.bytedance.android.shopping.store.hybridproduct.extension;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static final /* synthetic */ int c = 0;
    public final Class<?> a;
    public final Function2<Object, String, d> b;

    public static final class a {
        public static p a(Class r2, Function2 r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "transformer");
            return new p(r2, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 2));
        }
    }

    static {
    }

    public p() {
        throw null;
    }

    public p(Class r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }
}
