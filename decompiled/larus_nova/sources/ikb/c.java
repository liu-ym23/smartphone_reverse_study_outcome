package ikb;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f490289b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f490290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f490291b;

        public final Context getContext() {
            return this.f490290a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f490290a = r100;
        }
    }

    public final Context getContext() {
        return this.f490288a;
    }

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f490288a = r100.getContext();
        h r101 = r100.f490291b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("proxyFactory");
        r101 = null;
    L6:
        this.f490289b = r101;
    }
}
