package pq4;

import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareMeta;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T, R> f530281a = null;

    static {
        f530281a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ShareMeta r101 = (ShareMeta) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
