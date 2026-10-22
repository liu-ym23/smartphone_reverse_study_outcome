package l5;

import android.os.Handler;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.monitor.bridge.TraceType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class w implements j4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f507419b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a0> f507420c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f507421d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f507422e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0 f507423f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e0 f507424g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f0 f507425h = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f507426a = null;

        static {
            int[] r100 = new int[TraceType.values().length];
            r100[TraceType.FE_CALL_FE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[TraceType.FE_CALL_NATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[TraceType.NATIVE_EVENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[TraceType.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f507426a = r100;
        }
    }

    public w() {
    }

    static {
        f507419b = new w();
        f507420c = new LinkedHashMap();
        f507421d = LazyKt.lazy(new l5.a());
        f507422e = new c0();
        f507423f = new d0();
        f507424g = new e0();
        f507425h = new f0();
    }

    public static void m(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        ((Handler) f507421d.getValue()).post(new u(r100));
    }

    @Override // j4.a
    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        m(new p(r100));
    }

    @Override // j4.a
    public final void c(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r101 = System.currentTimeMillis();
        m(new m(r100, r101));
    }

    @Override // j4.a
    public final void d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r101 = System.currentTimeMillis();
        m(new r(r100, r101));
    }

    @Override // j4.a
    public final void h(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r101 = System.currentTimeMillis();
        m(new o(r100, r101));
    }

    @Override // j4.a
    public final void j(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r101 = System.currentTimeMillis();
        m(new n(r100, r101));
    }

    @Override // j4.a
    public final void markError(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        m(new l(r100));
    }

    @Override // j4.a
    public final void b(final String r100, final ProtocolMessage r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "callbackMsg");
        final long r102 = System.currentTimeMillis();
        m(new k(r101, r100, r102));
    }

    @Override // j4.a
    public final void e(final String r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        m(new j(r101, r100));
    }

    @Override // j4.a
    public final void i(final String r100, final m4.c r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r102 = System.currentTimeMillis();
        m(new s(r100, r102, r101));
    }

    @Override // j4.a
    public final void k(final String r100, final ContainerType r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "containerType");
        final long r102 = System.currentTimeMillis();
        m(new f(r101, r100, r102));
    }

    @Override // j4.a
    public final void l(final String r100, final m4.c r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r102 = System.currentTimeMillis();
        m(new g(r100, r102, r101));
    }

    @Override // j4.a
    public final void f(final String r100, final d3.a0 r101, final String r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        final long r102 = System.currentTimeMillis();
        m(new t(r100, r101, r102, r110));
    }

    @Override // j4.a
    public final void g(final String r100, final long r110, final d3.a0 r111, final String r112, final m4.c r113) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r112, "callName");
        m(new q(r110, r111, r112, r100, r113));
    }
}
