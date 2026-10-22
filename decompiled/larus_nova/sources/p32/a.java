package p32;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f527558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f527560c;

    public final c p() {
        c r100 = this.f527558a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("highlightContainer");
    L5:
        return r100;
    }

    @Override // p32.d
    public String getId() {
        return this.f527559b;
    }

    @Override // p32.d
    public final int getPriority() {
        return this.f527560c;
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f527559b = r100;
        this.f527560c = r101;
    }
}
