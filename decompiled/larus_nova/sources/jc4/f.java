package jc4;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
public final class f extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f498106n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498107o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f498108p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f498109q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f498110r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f498111s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f498112t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f498113u;

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "verify_identity";
    }

    @Override // jc4.a
    public final String g() {
        return "identity_two_elements_face";
    }

    @Override // jc4.a
    public int getType() {
        return 14;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        StringsKt.clear(r100);
        com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
        r100.append(com.bytedance.bdturing.setting.e.c("verify_identity", "report_url"));
    }

    public f(long r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r110) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.CertKey.FLOW);
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r104, "detail");
        Intrinsics.checkNotNullParameter(r105, "ticket");
        Intrinsics.checkNotNullParameter(r110, "subType");
        this.f498106n = r100;
        this.f498107o = r101;
        this.f498108p = r102;
        this.f498109q = r103;
        this.f498110r = r104;
        this.f498111s = r105;
        this.f498112t = r106;
        this.f498113u = r110;
    }
}
