package or1;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f524924a = null;

    static {
        f524924a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        FollowPair r101 = (FollowPair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
