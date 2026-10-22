package pu4;

import com.bytedance.ee.bear.bitable.share.permission.BitableShareUserPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f530725a = null;

    static {
        f530725a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BitableShareUserPermission r101 = (BitableShareUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
