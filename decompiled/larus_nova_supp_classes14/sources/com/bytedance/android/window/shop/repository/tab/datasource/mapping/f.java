package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int c = 0;
    public final Class<?> a;
    public final Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> b;

    public static final class a {
        public static f a(Class r2, Function1 r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "transformer");
            return new f(r2, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 1));
        }
    }

    static {
    }

    public f() {
        throw null;
    }

    public f(Class r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
