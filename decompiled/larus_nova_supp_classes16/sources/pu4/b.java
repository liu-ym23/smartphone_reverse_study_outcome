package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePublicPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        BitableSharePublicPermission r3 = (BitableSharePublicPermission) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3;
    }
}
