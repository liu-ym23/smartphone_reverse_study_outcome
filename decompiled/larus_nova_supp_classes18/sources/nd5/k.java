package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T, R> implements Function {
    public static final k<T, R> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r2) {
        IDocPublicPermission r3 = (IDocPublicPermission) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        return new j(r3);
    }
}
