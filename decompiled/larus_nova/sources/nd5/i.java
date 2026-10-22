package nd5;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T, R> f518787a = null;

    static {
        f518787a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        IFolderPublicPermission r101 = (IFolderPublicPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        return new h(r101);
    }
}
