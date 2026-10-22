package kz2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6634a f506727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f506728b = null;

    /* JADX INFO: renamed from: kz2.a$a, reason: collision with other inner class name */
    public static final class C6634a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f506729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f506730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f506731c;

        public C6634a(int r100) {
            List<String> r101 = CollectionsKt.emptyList();
            List<String> r102 = CollectionsKt.emptyList();
            Intrinsics.checkNotNullParameter(r101, "commonEventTypeAllowList");
            Intrinsics.checkNotNullParameter(r102, "customEventTypeAllowList");
            this.f506729a = false;
            this.f506730b = r101;
            this.f506731c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f506732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f506733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f506734c;

        public b() {
            this.f506732a = true;
            this.f506733b = false;
            this.f506734c = false;
        }
    }

    static {
        f506727a = new C6634a(0);
        f506728b = new b();
    }
}
