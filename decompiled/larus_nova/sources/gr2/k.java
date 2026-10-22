package gr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements hr2.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f482318b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aj6.b f482319a;

    public static final class a {
        public static k a(hr2.h r100) {
            if (r100 == null) goto L6;
            return new k(new aj6.b(null, null, null));
        L6:
            return new k(new aj6.b());
        }
    }

    static {
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482319a;
    }

    public k(aj6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482319a = r100;
    }
}
