package vv1;

import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f557381a = null;

    static {
        f557381a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        FeedDataKey r102 = (FeedDataKey) r100;
        List r103 = (List) r101;
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
