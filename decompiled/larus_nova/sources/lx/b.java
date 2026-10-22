package lx;

import android.content.Context;
import com.bytedance.android.latch.LatchProcessOptions;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements kx.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f511104a = null;

    public static final class a implements Function3<Context, String, LatchProcessOptions, kx.b.a> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public final kx.b.a invoke(Context r100, String r101, LatchProcessOptions r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "pageUrl");
            Intrinsics.checkNotNullParameter(r102, "processOptions");
            return new b();
        }
    }

    static {
        f511104a = new a();
    }

    public b() {
    }

    @Override // kx.b.a
    public final void release() {
    }

    @Override // kx.b.a
    public final void a(String r100, JavaOnlyMap r101, kx.b.a.InterfaceC6625a r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r102.onFail("Not yet implemented");
    }
}
