package k9;

import com.bytedance.ies.web.jsbridge2.u;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements e {

    public static final class a implements d {
        public a() {
        }

        @Override // k9.d
        public final void a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "monitorId");
            Intrinsics.checkNotNullParameter(r101, "key");
        }

        @Override // k9.d
        public final void b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "monitorId");
            Intrinsics.checkNotNullParameter("scene", "field");
        }

        @Override // k9.d
        public final void c(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "monitorId");
            Intrinsics.checkNotNullParameter(r101, "field");
        }

        @Override // k9.d
        public final void d(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "monitorId");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
        }
    }

    public b() {
    }

    @Override // k9.e
    public final d V0() {
        return new a();
    }

    @Override // k9.e
    public final List<b7.a> T() {
        return CollectionsKt.emptyList();
    }

    @Override // k9.e
    public final List<u> Z0() {
        return CollectionsKt.emptyList();
    }

    @Override // k9.e
    public final j9.b H0() {
        return j9.b.C6405b.f497758a;
    }
}
