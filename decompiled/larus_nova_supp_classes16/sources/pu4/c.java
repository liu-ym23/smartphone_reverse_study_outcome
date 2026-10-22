package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableShareUserPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T, R> implements Function {
    public static final c<T, R> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r2) {
        BitableShareUserPermission r3 = (BitableShareUserPermission) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3;
    }
}
