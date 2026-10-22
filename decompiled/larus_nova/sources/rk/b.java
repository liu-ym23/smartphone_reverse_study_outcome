package rk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f538241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f538242d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("location", this.f538239a);
        appendParam("business", this.f538240b);
        appendParam("in_schema", this.f538241c);
        appendParam("out_schema", this.f538242d);
    }

    public b(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r101, "business");
        super("schema_report");
        this.f538239a = r100;
        this.f538240b = r101;
        this.f538241c = r102;
        this.f538242d = r103;
    }
}
