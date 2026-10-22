package za8;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.a1;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f571095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f571096b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.bmhome.auth.e0 f571097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.bmhome.auth.j0 f571098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.bmhome.auth.b f571099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final FeatureConfig f571100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FeatureConfig f571101e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f571097a, r101.f571097a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f571098b, r101.f571098b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f571099c, r101.f571099c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f571100d, r101.f571100d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f571101e, r101.f571101e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            com.larus.bmhome.auth.e0 r100 = this.f571097a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            com.larus.bmhome.auth.j0 r104 = this.f571098b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            com.larus.bmhome.auth.b r107 = this.f571099c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            FeatureConfig r110 = this.f571100d;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return ((r109 + r101) * 31) + this.f571101e.hashCode();
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "FeatureConfigCache(basic=" + this.f571097a + ", im=" + this.f571098b + ", audio=" + this.f571099c + ", aggregate=" + this.f571100d + ", config=" + this.f571101e + ')';
        }

        public a(com.larus.bmhome.auth.e0 r100, com.larus.bmhome.auth.j0 r101, com.larus.bmhome.auth.b r102, FeatureConfig r103, FeatureConfig r104) {
            Intrinsics.checkNotNullParameter(r104, "config");
            this.f571097a = r100;
            this.f571098b = r101;
            this.f571099c = r102;
            this.f571100d = r103;
            this.f571101e = r104;
        }
    }

    static {
        f571096b = LazyKt.lazy(new za8.a());
    }

    public static FeatureConfig a() {
        AuthModelDelegate r100 = AuthModelDelegate.f297134b;
        com.larus.bmhome.chat.api.e0 r101 = r100.e().getValue();
        FeatureDetail r102 = null;
        if (r101 == null) goto L7;
        LaunchInfo r103 = r101.f297186a;
        if (r103 == null) goto L7;
        FeatureConfig r104 = r103.y0();
    L8:
        com.larus.bmhome.auth.e0 r105 = r100.D();
        com.larus.bmhome.auth.j0 r106 = r100.C();
        com.larus.bmhome.auth.b r107 = r100.o();
        a r108 = f571095a;
        if (r108 != null) goto L11;
    L20:
        FeatureConfig r109 = a1.a(r105, r106, r107, r104);
        if (r106 == null) goto L23;
        FeatureDetail r110 = r106.d();
    L24:
        if (r110 == null) goto L26;
        r102 = r106.d();
    L28:
        r109.H0(r102);
        f571095a = new a(r105, r106, r107, r104, r109);
        return r109;
    L26:
        if (r107 == null) goto L28;
        r102 = r107.c();
        goto L28
    L23:
        r110 = null;
        goto L24
    L11:
        if (r108.f571097a != r105) goto L20;
        if (r108.f571098b != r106) goto L20;
        if (r108.f571099c != r107) goto L20;
        if (r108.f571100d != r104) goto L20;
        return r108.f571101e;
    L7:
        r104 = null;
        goto L8
    }
}
