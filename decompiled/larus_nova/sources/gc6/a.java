package gc6;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.d;
import com.bytedance.android.live.network.response.e;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f480854a = null;

    static {
        f480854a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        e r101 = (e) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new d.b(r101.data, new Extra());
    }
}
