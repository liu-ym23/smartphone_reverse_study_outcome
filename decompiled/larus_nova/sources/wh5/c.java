package wh5;

import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f559671a = null;

    static {
        f559671a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        EditionUserPermission r101 = (EditionUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
