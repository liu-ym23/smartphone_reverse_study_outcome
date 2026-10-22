package mj5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f514252a = null;

    static {
        f514252a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((SimpleRequestResult) r100, "it");
        return Boolean.TRUE;
    }
}
