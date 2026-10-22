package r68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f536357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f536358b;

    static {
        f536357a = new b();
    }

    public b() {
    }

    @Override // r68.a
    public final void b() {
        a r100 = f536358b;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // r68.a
    public final void a(String r100) {
        a r101 = f536358b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // r68.a
    public final void d(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "pcm");
        a r101 = f536358b;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // r68.a
    public final boolean c(long r100, boolean r101) {
        a r102 = f536358b;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.c(r100, r101) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
