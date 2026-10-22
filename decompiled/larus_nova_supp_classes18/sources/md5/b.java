package md5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        tt5.a.e("OwnerTypeFetcher", "fetchDocOwnerType()...", r5, false);
        return new DocVersion(0);
    }
}
