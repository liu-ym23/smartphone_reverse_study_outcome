package mo8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.trace.tracespan.span.b f514616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.trace.tracespan.span.b f514617b;

    /* JADX INFO: renamed from: mo8.a$a, reason: collision with other inner class name */
    public static final class C6838a {
    }

    static {
    }

    public abstract List<String> a();

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public a(com.larus.trace.tracespan.span.b r100) {
        Intrinsics.checkNotNullParameter(r100, "parentSpan");
        this.f514616a = r100;
    }
}
