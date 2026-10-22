package sr9;

import com.larus.platform.spi.IAIChatService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f543234b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f543235a;

    public static final class a implements d {
        public a() {
        }

        @Override // sr9.d
        public final String a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return "";
        }

        @Override // sr9.d
        public final Pair<Integer, Integer> b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return null;
        }

        @Override // sr9.d
        public final String c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return "";
        }

        @Override // sr9.d
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter("upload", "contentSource");
        }

        @Override // sr9.d
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter("album", "previousPage");
        }

        @Override // sr9.d
        public final String f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return "";
        }

        @Override // sr9.d
        public final boolean g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return false;
        }

        @Override // sr9.d
        public final String h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return "";
        }
    }

    static {
        f543234b = new b();
    }

    @Override // sr9.d
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f543235a.a(r100);
    }

    @Override // sr9.d
    public final Pair<Integer, Integer> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f543235a.b(r100);
    }

    @Override // sr9.d
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f543235a.c(r100);
    }

    @Override // sr9.d
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("upload", "contentSource");
        this.f543235a.d(r100, "upload");
    }

    @Override // sr9.d
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("album", "previousPage");
        this.f543235a.e(r100, "album");
    }

    @Override // sr9.d
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f543235a.f(r100);
    }

    @Override // sr9.d
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f543235a.g(r100);
    }

    @Override // sr9.d
    public final String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f543235a.h(r100);
    }

    public b() {
        IAIChatService r100 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r100 == null) goto L6;
        d r101 = r100.v7();
        if (r101 == null) goto L6;
    L7:
        this.f543235a = r101;
        return;
    L6:
        r101 = new a();
        goto L7
    }
}
