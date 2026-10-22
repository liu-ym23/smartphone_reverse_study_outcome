package no8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519975a = 0;

    static {
    }

    public b() {
    }

    public static String a(com.larus.trace.tracespan.span.b r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r103 = new StringBuilder("traceId=");
        r103.append(r100.getTraceId());
        r103.append(", parentSpanId=");
        com.larus.trace.tracespan.span.b r104 = r100.getParent();
        if (r104 == null) goto L5;
        String r105 = r104.a();
    L6:
        r103.append(r105);
        r103.append(", spanId=");
        r103.append(r100.a());
        r103.append(", tag=");
        r103.append(r100.getTag());
        r103.append(", errorCode:");
        r103.append(r101);
        r103.append(", errorMsg:");
        r103.append(r102);
        return r103.toString();
    L5:
        r105 = null;
        goto L6
    }
}
