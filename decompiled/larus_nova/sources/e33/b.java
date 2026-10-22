package e33;

import com.bytedance.android.scope.DependencyResolutionError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final a a(com.bytedance.android.scope.e r100, KClass r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        ArrayList r102 = new ArrayList();
        r100.a(r101, r102);
        return new a(r102);
    }

    @JvmStatic
    public static final Object b(com.bytedance.android.scope.e r100, KClass r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        return r100.b(r101);
    }

    @JvmStatic
    public static final Object c(com.bytedance.android.scope.e r100, KClass r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        Object r102 = r100.b(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        DependencyResolutionError.Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, "objType");
        throw new DependencyResolutionError("Failed to find an instance of '" + r101 + '\'', null, 2, null);
    }
}
