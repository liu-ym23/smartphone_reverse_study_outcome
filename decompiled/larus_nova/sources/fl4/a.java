package fl4;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes15.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C5923a f477732a = null;

    /* JADX INFO: renamed from: fl4.a$a, reason: collision with other inner class name */
    public static final class C5923a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C5923a f477733a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static b f477734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile gl4.a f477735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final jl4.a f477736d = null;

        public C5923a() {
        }

        static {
            f477733a = new C5923a();
            f477736d = new jl4.a();
        }

        public static Object a(KClass r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            b r101 = f477734b;
            if (r101 == null) goto L7;
            return r101.a(r100);
        L7:
            throw new IllegalArgumentException("DoraKMPAdapter not initialized. Call init(registry) at startup.".toString());
        }
    }

    static {
        f477732a = C5923a.f477733a;
    }
}
