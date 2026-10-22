package sm5;

import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r2) {
        VFSPath r3 = (VFSPath) r2;
        Intrinsics.checkNotNullParameter(r3, "path");
        return r3.toFile().getAbsoluteFile();
    }
}
