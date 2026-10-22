package md5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f513280a = null;

    static {
        f513280a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        OwnerType r101 = (OwnerType) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        return new DocVersion(r101.getOwnerType());
    }
}
