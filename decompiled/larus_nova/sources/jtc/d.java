package jtc;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f500390a = 0;

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public k f500391a;

        public a() {
        }

        @Override // jtc.j
        public final i a() {
            if (this.f500391a != null) goto L12;
            io.opentelemetry.context.c r100 = io.opentelemetry.context.g.f492702b;
            io.opentelemetry.context.b r101 = r100.current();
            if (r101 != null) goto L8;
            r101 = r100.root();
        L8:
            io.opentelemetry.context.f r102 = l.f500399a;
            i r103 = (i) r101.get();
            if (r103 != null) goto L11;
            r103 = g.f500397b;
        L11:
            this.f500391a = r103.b();
        L12:
            k r104 = this.f500391a;
            if (r104 != null) goto L16;
            io.opentelemetry.api.internal.a.a();
            return g.f500397b;
        L16:
            if (((io.opentelemetry.api.internal.b) r104).f492669g == true) goto L19;
            return g.f500397b;
        L19:
            return new g(r104);
        }

        @Override // jtc.j
        public final j b(wx9.a r100) {
            if (r100 != null) goto L4;
            io.opentelemetry.api.internal.a.a();
        L5:
            return this;
        L4:
            this.f500391a = h.a(r100).b();
            goto L5
        }
    }

    public d() {
    }

    static {
    }

    @Override // jtc.o
    public final j a(String r100) {
        return new a();
    }
}
