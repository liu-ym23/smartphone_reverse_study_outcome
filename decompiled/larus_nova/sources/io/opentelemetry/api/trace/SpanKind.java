package io.opentelemetry.api.trace;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum SpanKind extends Enum<SpanKind> {
    public static final SpanKind CLIENT = null;
    public static final SpanKind CONSUMER = null;
    public static final SpanKind INTERNAL = null;
    public static final SpanKind PRODUCER = null;
    public static final SpanKind SERVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpanKind[] f492682a = null;

    static {
        SpanKind r100 = new SpanKind("INTERNAL", 0);
        INTERNAL = r100;
        SpanKind r101 = new SpanKind(HTTP.SERVER, 1);
        SERVER = r101;
        SpanKind r102 = new SpanKind("CLIENT", 2);
        CLIENT = r102;
        SpanKind r103 = new SpanKind("PRODUCER", 3);
        PRODUCER = r103;
        SpanKind r104 = new SpanKind("CONSUMER", 4);
        CONSUMER = r104;
        f492682a = new SpanKind[]{r100, r101, r102, r103, r104};
    }

    public static SpanKind[] values() {
        return (SpanKind[]) f492682a.clone();
    }

    public static SpanKind valueOf(String r100) {
        return (SpanKind) a.a(SpanKind.class, r100);
    }

    public SpanKind(String r100, int r101) {
        super(r100, r101);
    }
}
