package f70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f475744c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f475746b;

    public static final class a extends b {
        public a() {
            super("default", 0);
        }
    }

    static {
        f475744c = new a();
    }

    public final String toString() {
        return this.f475745a;
    }

    public b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "description");
        this.f475745a = r100;
        this.f475746b = r101;
    }
}
