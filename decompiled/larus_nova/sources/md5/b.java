package md5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f513279a = null;

    static {
        f513279a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        tt5.a.e("OwnerTypeFetcher", "fetchDocOwnerType()...", r101, false);
        return new DocVersion(0);
    }
}
