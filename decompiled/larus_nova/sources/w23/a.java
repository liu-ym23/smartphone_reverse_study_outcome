package w23;

import com.bytedance.android.scope.e;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import e33.f;
import e33.l;
import e33.n;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements f, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f557992a = null;

    public a() {
    }

    static {
        f557992a = new a();
    }

    @Override // e33.f
    public final Collection getScopes() {
        return CollectionsKt.emptyList();
    }

    @Override // e33.f
    public final Collection b(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "scopeCls");
        throw new IllegalArgumentException(r100.toString());
    }

    @Override // e33.n
    public final o a(l r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceDesc");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.getClass();
        throw new IllegalArgumentException(r100.toString());
    }
}
