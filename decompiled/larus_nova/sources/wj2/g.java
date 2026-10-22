package wj2;

import kotlin.jvm.internal.Intrinsics;
import sl.k;

/* JADX INFO: loaded from: classes10.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f559973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f559974b;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "productId");
            this.f559973a = r100;
            this.f559974b = r101;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f559975a;

        public b(k r100) {
            this.f559975a = r100;
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f559976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f559977b;

        public c(boolean r100) {
            this.f559976a = true;
            this.f559977b = r100;
        }
    }

    public g() {
    }
}
