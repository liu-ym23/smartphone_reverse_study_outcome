package xh5;

import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV1;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T, R> implements Function {
    public static final e<T, R> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2) {
        FolderPublicPermissionV1 r3 = (FolderPublicPermissionV1) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3;
    }
}
