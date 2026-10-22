package vv1;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f557380a = null;

    static {
        f557380a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        FeedDataKey r101 = (FeedDataKey) r100;
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return Integer.valueOf(r101.hashCode());
    }
}
