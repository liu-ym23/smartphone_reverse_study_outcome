package pa;

import kotlin.jvm.internal.Intrinsics;
import t36.d;
import t36.f;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y36.a f528334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y36.a f528335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y36.a f528336c;

    public a() {
    }

    @Override // t36.f
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        y36.a r101 = new y36.a(r100, "enable_prefetch", Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f528334a = r101;
        Boolean r102 = Boolean.TRUE;
        y36.a r103 = new y36.a(r100, "enable_model_pre_create", r102);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f528335b = r103;
        y36.a r104 = new y36.a(r100, "enable_engine_preload", r102);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f528336c = r104;
    }
}
