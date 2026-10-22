package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f438968a = null;

    public static final class a implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f438969b = null;

        static {
            f438969b = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 1364110770;
        }

        public final String toString() {
            return "Alias";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            return !r100.u();
        }
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f438970b = null;

        static {
            f438970b = new b();
        }

        public b() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 1365040111;
        }

        public final String toString() {
            return "Block";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == true) goto L5;
        L13:
            return false;
        L5:
            if (r100.u() == true) goto L13;
            if (r100.t() == true) goto L13;
            if (r100.s() == true) goto L13;
            if (r100.p() == true) goto L13;
            return true;
        }
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f438971b = null;

        static {
            f438971b = new c();
        }

        public c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -510128695;
        }

        public final String toString() {
            return "City";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438890d == true) goto L5;
            return false;
        L5:
            if (r100.o() == true) goto L7;
            return false;
        L7:
            if (r100.c().length() <= 0) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == false) goto L15;
            return true;
        L15:
            return false;
        L9:
            r101 = false;
            goto L10
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d f438972a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set<l> f438973b = null;

        public d() {
        }

        static {
            f438972a = new d();
            f438973b = SetsKt.setOf(new l[]{j.f438979b, o.f438984b, i.f438978b, m.f438982b, e.f438974b, g.f438976b, C5264l.f438981b, c.f438971b, h.f438977b, a.f438969b, n.f438983b, b.f438970b, f.f438975b, k.f438980b});
        }
    }

    public static final class e implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f438974b = null;

        static {
            f438974b = new e();
        }

        public e() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return 260639218;
        }

        public final String toString() {
            return "Cta";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == true) goto L5;
        L7:
            return false;
        L5:
            if ((!r100.e().isEmpty()) == false) goto L7;
            return true;
        }
    }

    public static final class f implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f438975b = null;

        static {
            f438975b = new f();
        }

        public f() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            f r101 = (f) r100;
            return true;
        }

        public final int hashCode() {
            return -1741060473;
        }

        public final String toString() {
            return "DeleteFriend";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == true) goto L5;
            return false;
        L5:
            if (r100.u() == false) goto L7;
            return false;
        L7:
            if (r100.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == true) goto L12;
            return false;
        L12:
            if (r100.t() == false) goto L14;
            return false;
        L14:
            if (r100.s() == false) goto L16;
            return false;
        L16:
            if (r100.p() == true) goto L24;
            return true;
        L24:
            return false;
        L9:
            r101 = false;
            goto L10
        }
    }

    public static final class g implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f438976b = null;

        static {
            f438976b = new g();
        }

        public g() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            g r101 = (g) r100;
            return true;
        }

        public final int hashCode() {
            return 1620736304;
        }

        public final String toString() {
            return "Department";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438890d == true) goto L5;
        L9:
            return false;
        L5:
            if (r100.o() == false) goto L9;
            if ((!r100.f438894h.isEmpty()) == false) goto L9;
            return true;
        }
    }

    public static final class h implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f438977b = null;

        static {
            f438977b = new h();
        }

        public h() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            h r101 = (h) r100;
            return true;
        }

        public final int hashCode() {
            return 683532146;
        }

        public final String toString() {
            return "DoubaoHomepage";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438890d == false) goto L5;
        L7:
            return false;
        L5:
            if (r100.r() == false) goto L7;
            return true;
        }
    }

    public static final class i implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i f438978b = null;

        static {
            f438978b = new i();
        }

        public i() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            i r101 = (i) r100;
            return true;
        }

        public final int hashCode() {
            return -1408566323;
        }

        public final String toString() {
            return "DoubaoNumber";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            return r100.r();
        }
    }

    public static final class j implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f438979b = null;

        static {
            f438979b = new j();
        }

        public j() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            j r101 = (j) r100;
            return true;
        }

        public final int hashCode() {
            return -1411086284;
        }

        public final String toString() {
            return "FriendApplication";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == true) goto L5;
        L7:
            return false;
        L5:
            if (r100.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE) goto L7;
            return true;
        }
    }

    public static final class k implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k f438980b = null;

        static {
            f438980b = new k();
        }

        public k() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            k r101 = (k) r100;
            return true;
        }

        public final int hashCode() {
            return -983196744;
        }

        public final String toString() {
            return "Friendship";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == true) goto L5;
        L17:
            return false;
        L5:
            if (r100.u() == true) goto L17;
            if (r100.s() == true) goto L17;
            if (r100.p() == true) goto L17;
            if (r100.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_FORWARD) goto L13;
        L16:
            return true;
        L13:
            if (r100.d() == GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE) goto L16;
            if (r100.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_NONE) goto L17;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.l$l, reason: collision with other inner class name */
    public static final class C5264l implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5264l f438981b = null;

        static {
            f438981b = new C5264l();
        }

        public C5264l() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5264l) == true) goto L9;
            return false;
        L9:
            C5264l r101 = (C5264l) r100;
            return true;
        }

        public final int hashCode() {
            return -354018841;
        }

        public final String toString() {
            return "Leader";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438890d == true) goto L5;
            return false;
        L5:
            if (r100.o() == true) goto L7;
            return false;
        L7:
            if (r100.i().length() <= 0) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == true) goto L12;
            return false;
        L12:
            if (r100.h().length() <= 0) goto L14;
            boolean r102 = true;
        L15:
            if (r102 == false) goto L21;
            return true;
        L21:
            return false;
        L14:
            r102 = false;
            goto L15
        L9:
            r101 = false;
            goto L10
        }
    }

    public static final class m implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final m f438982b = null;

        static {
            f438982b = new m();
        }

        public m() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            m r101 = (m) r100;
            return true;
        }

        public final int hashCode() {
            return -199750516;
        }

        public final String toString() {
            return "QrCode";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == false) goto L9;
            i.f438978b.getClass();
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.r() == false) goto L9;
            if (r100.u() == false) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class n implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final n f438983b = null;

        static {
            f438983b = new n();
        }

        public n() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            n r101 = (n) r100;
            return true;
        }

        public final int hashCode() {
            return 1380607809;
        }

        public final String toString() {
            return "Share";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.f438889c == true) goto L5;
            return false;
        L5:
            if (r100.u() == false) goto L7;
        L11:
            return true;
        L7:
            if (r100.d() != GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == true) goto L11;
            return false;
        L9:
            r101 = false;
            goto L10
        }
    }

    public static final class o implements l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final o f438984b = null;

        static {
            f438984b = new o();
        }

        public o() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L9;
            return false;
        L9:
            o r101 = (o) r100;
            return true;
        }

        public final int hashCode() {
            return -829713834;
        }

        public final String toString() {
            return "TenantInfo";
        }

        @Override // com.ss.android.lark.profile_office.userprofile.l
        public final boolean a(OfficeProfileState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (r100.j().length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
        L19:
            return true;
        L8:
            if (r100.s() == false) goto L10;
        L17:
            boolean r102 = true;
        L18:
            if (r102 == true) goto L19;
            return false;
        L10:
            if (r100.p() == true) goto L17;
            if (r100.f438899m == true) goto L17;
            if (r100.n() == true) goto L17;
            r102 = false;
            goto L18
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
        f438968a = d.f438972a;
    }

    boolean a(OfficeProfileState r100);
}
