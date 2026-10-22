package li5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.setting.manager.BatchUserPermissionResult;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        BatchUserPermissionResult r3 = (BatchUserPermissionResult) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (HashMap) ((Result) r3).data;
    }
}
