package xh5;

import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV1;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T, R> f563880a = null;

    static {
        f563880a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        FolderPublicPermissionV1 r101 = (FolderPublicPermissionV1) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
