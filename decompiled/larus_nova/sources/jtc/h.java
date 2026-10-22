package jtc;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class h {
    public static i a(io.opentelemetry.context.b r100) {
        if (r100 != null) goto L5;
        io.opentelemetry.api.internal.a.a();
        return g.f500397b;
    L5:
        io.opentelemetry.context.f r101 = l.f500399a;
        i r102 = (i) r100.get();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return g.f500397b;
    }
}
