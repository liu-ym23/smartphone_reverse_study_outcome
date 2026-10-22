package md5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public static final c<T, R> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r2) {
        OwnerType r3 = (OwnerType) r2;
        Intrinsics.checkNotNullParameter(r3, "t");
        return new DocVersion(r3.getOwnerType());
    }
}
