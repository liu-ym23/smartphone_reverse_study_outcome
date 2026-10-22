package i8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f488725a;

    public abstract void a();

    public abstract void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r100);

    public abstract void d(String r100, String r101);

    public a(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        this.f488725a = r100;
    }

    public final void c(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f488725a.c(r100);
    }
}
