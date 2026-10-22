package v85;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends v85.a {

    public static final class a extends v85.a.C7974a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f553712s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f553713t;

        public a() {
            this.f553712s = 1;
        }

        @Override // v85.a.C7974a
        public final int a() {
            return this.f553712s;
        }

        @Override // v85.a.C7974a
        public final boolean b() {
            return this.f553713t;
        }
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super(r100);
    }
}
