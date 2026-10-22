package x21;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements x21.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562179a;

    /* JADX INFO: renamed from: x21.a$a, reason: collision with other inner class name */
    public static final class C8186a extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562180b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562180b;
        }

        public C8186a(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("AnchorJoinToLink");
            this.f562180b = r100;
        }
    }

    public static final class b extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562181b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562181b;
        }

        public b(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("AnchorLeaveToLink");
            this.f562181b = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.h f562182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c5 f562183c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.c(d());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.c(this.f562183c, null, 2);
        }

        public final x21.h d() {
            return this.f562182b;
        }

        public c(x21.h r100, c5 r101) {
            Intrinsics.checkNotNullParameter(r100, "pkInfo");
            Intrinsics.checkNotNullParameter(r101, "message");
            super("BattleOpen");
            this.f562182b = r100;
            this.f562183c = r101;
        }
    }

    public static final class d extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562184b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562184b;
        }

        public d(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PenalTimeUpToLink");
            this.f562184b = r100;
        }
    }

    public static final class e extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562185b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562185b;
        }

        public e(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PkStandardEndReqFailedToLink");
            this.f562185b = r100;
        }
    }

    public static final class f extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562186b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562186b;
        }

        public f(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PkStandardEndToLink");
            this.f562186b = r100;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.g f562187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f562188c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C8187b(d());
        }

        public final c3 d() {
            return this.f562188c;
        }

        public final x21.g e() {
            return this.f562187b;
        }

        public g(x21.g r100, c3 r101) {
            Intrinsics.checkNotNullParameter(r100, "penalInfo");
            Intrinsics.checkNotNullParameter(r101, "meta");
            super("PkStandardEndToPenal");
            this.f562187b = r100;
            this.f562188c = r101;
        }
    }

    public static final class h extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562189b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562189b;
        }

        public h(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PkTimeOutReqFailedToLink");
            this.f562189b = r100;
        }
    }

    public static final class i extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562190b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562190b;
        }

        public i(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("PkTimeOutToLink");
            this.f562190b = r100;
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.g f562191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f562192c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C8187b(d());
        }

        public final c3 d() {
            return this.f562192c;
        }

        public final x21.g e() {
            return this.f562191b;
        }

        public j(x21.g r100, c3 r101) {
            Intrinsics.checkNotNullParameter(r100, "penalInfo");
            Intrinsics.checkNotNullParameter(r101, "meta");
            super("PkTimeOutToPenal");
            this.f562191b = r100;
            this.f562192c = r101;
        }
    }

    public static final class k extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562193b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562193b;
        }

        public k(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("QueryFailedBackToLink");
            this.f562193b = r100;
        }
    }

    public static final class l extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562194b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562194b;
        }

        public l(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("QueryReturnLink");
            this.f562194b = r100;
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.g f562195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f562196c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C8187b(d());
        }

        public final c3 d() {
            return this.f562196c;
        }

        public final x21.g e() {
            return this.f562195b;
        }

        public m(x21.g r100, c3 r101) {
            Intrinsics.checkNotNullParameter(r100, "penalInfo");
            Intrinsics.checkNotNullParameter(r101, "meta");
            super("QueryReturnPenal");
            this.f562195b = r100;
            this.f562196c = r101;
        }
    }

    public static final class n extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.h f562197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f562198c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.c(d());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.c(null, this.f562198c, 1);
        }

        public final x21.h d() {
            return this.f562197b;
        }

        public n(x21.h r100, c3 r101) {
            Intrinsics.checkNotNullParameter(r100, "pkInfo");
            Intrinsics.checkNotNullParameter(r101, "meta");
            super("QueryReturnPk");
            this.f562197b = r100;
            this.f562198c = r101;
        }
    }

    public static final class o extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562199b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562199b;
        }

        public o(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("SecKillReqFailedToLink");
            this.f562199b = r100;
        }
    }

    public static final class p extends a implements x21.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.f f562200b;

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.a();
        }

        @Override // x21.e
        public final x21.d a() {
            return x21.i.a.a(this);
        }

        @Override // x21.i
        public final x21.f c() {
            return this.f562200b;
        }

        public p(x21.f r100) {
            Intrinsics.checkNotNullParameter(r100, "linkInfo");
            super("SecKillToLink");
            this.f562200b = r100;
        }
    }

    public static final class q extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x21.g f562201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f562202c;

        @Override // x21.e
        public final x21.d a() {
            return new x21.d.b(e());
        }

        @Override // x21.e
        public final x21.b b() {
            return new x21.b.C8187b(d());
        }

        public final c3 d() {
            return this.f562202c;
        }

        public final x21.g e() {
            return this.f562201b;
        }

        public q(x21.g r100, c3 r101) {
            Intrinsics.checkNotNullParameter(r100, "penalInfo");
            Intrinsics.checkNotNullParameter(r101, "meta");
            super("SecKillToPenal");
            this.f562201b = r100;
            this.f562202c = r101;
        }
    }

    public a(String r100) {
        this.f562179a = r100;
    }
}
