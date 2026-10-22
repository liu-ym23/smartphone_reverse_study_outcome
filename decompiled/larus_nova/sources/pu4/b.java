package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePublicPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f530724a = null;

    static {
        f530724a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BitableSharePublicPermission r101 = (BitableSharePublicPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
