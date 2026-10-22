package li5;

import com.bytedance.ee.bear.middleground.permission.setting.manager.BatchUserPermissionResult;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f509358a = null;

    static {
        f509358a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BatchUserPermissionResult r101 = (BatchUserPermissionResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (HashMap) r101.data;
    }
}
