package x21;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562207a;

    public static final class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f562208b;

        public a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("LINK");
            this.f562208b = r100;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f562209b;

        public b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "penalInfo");
            super("PENAL");
            this.f562209b = r100;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h f562210b;

        public c(h r100) {
            Intrinsics.checkNotNullParameter(r100, "pkInfo");
            super("PK");
            this.f562210b = r100;
        }
    }

    /* JADX INFO: renamed from: x21.d$d, reason: collision with other inner class name */
    public static final class C8188d extends d {
        public C8188d() {
            super("UNKNOWN");
        }
    }

    public d(String r100) {
        this.f562207a = r100;
    }
}
