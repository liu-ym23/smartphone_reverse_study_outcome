package ma;

import kotlin.jvm.internal.Intrinsics;
import t36.d;
import t36.f;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y36.a f512667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f512668b;

    public a() {
    }

    @Override // t36.f
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        y36.a r101 = new y36.a(r100, "enable_blank_detect", Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f512667a = r101;
        p r102 = new p(r100, "bdhm_bid", "");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f512668b = r102;
    }
}
