package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T, R> f518789a = null;

    static {
        f518789a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        IDocPublicPermission r101 = (IDocPublicPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        return new j(r101);
    }
}
