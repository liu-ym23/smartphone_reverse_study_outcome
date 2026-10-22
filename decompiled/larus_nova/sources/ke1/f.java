package ke1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f503013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f503014d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f503015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f503016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f503017c;

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.f503017c = r100;
            this.f503015a = new LinkedHashMap();
        }

        public final void a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f503015a.put(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f503014d, ((f) r100).f503014d) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f503014d;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "TraceNode(builder=" + this.f503014d + ")";
    }

    public f(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f503014d = r100;
        this.f503011a = r100.f503016b;
        this.f503012b = r100.f503017c;
        this.f503013c = r100.f503015a;
    }
}
