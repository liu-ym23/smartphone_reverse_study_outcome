package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T, R> implements Function {
    public static final i<T, R> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        IFolderPublicPermission r3 = (IFolderPublicPermission) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        return new h(r3);
    }
}
