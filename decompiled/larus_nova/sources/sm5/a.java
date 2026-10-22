package sm5;

import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f542574a = null;

    static {
        f542574a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        VFSPath r101 = (VFSPath) r100;
        Intrinsics.checkNotNullParameter(r101, "path");
        return r101.toFile().getAbsoluteFile();
    }
}
