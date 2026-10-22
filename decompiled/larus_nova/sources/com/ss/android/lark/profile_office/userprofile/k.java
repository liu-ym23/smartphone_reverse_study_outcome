package com.ss.android.lark.profile_office.userprofile;

import androidx.autofill.HintConstants;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.ss.android.lark.contact.export.ContactSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface k {

    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f438943a = null;

        static {
            f438943a = new a();
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
            return -1603386757;
        }

        public final String toString() {
            return "AcceptFriend";
        }
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f438944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f438945b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f438944a, r101.f438944a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438945b, r101.f438945b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f438944a.hashCode() * 31) + this.f438945b.hashCode();
        }

        public final String toString() {
            return "ApplyFriend(message=" + this.f438944a + ", alias=" + this.f438945b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "alias");
            this.f438944a = r100;
            this.f438945b = r101;
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f438946a = null;

        static {
            f438946a = new c();
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
            return 1515035738;
        }

        public final String toString() {
            return "AvatarClick";
        }
    }

    public static final class d implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438947a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f438947a == ((d) r100).f438947a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438947a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "BlockUser(isBlock=" + this.f438947a + ')';
        }

        public d(boolean r100) {
            this.f438947a = r100;
        }
    }

    public static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GetDoubaoProfileResponse.CTAInfo f438948a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f438948a, ((e) r100).f438948a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f438948a.hashCode();
        }

        public final String toString() {
            return "CtaClick(cta=" + this.f438948a + ')';
        }

        public e(GetDoubaoProfileResponse.CTAInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "cta");
            this.f438948a = r100;
        }
    }

    public static final class f implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f438949a = null;

        static {
            f438949a = new f();
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
            return -35074850;
        }

        public final String toString() {
            return "DeleteFriend";
        }
    }

    public static final class g implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f438950a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f438950a, ((g) r100).f438950a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f438950a.hashCode();
        }

        public final String toString() {
            return "DescriptionPhoneClick(phoneNumber=" + this.f438950a + ')';
        }

        public g(String r100) {
            Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            this.f438950a = r100;
        }
    }

    public static final class h implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f438951a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f438951a, ((h) r100).f438951a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f438951a.hashCode();
        }

        public final String toString() {
            return "DescriptionUrlClick(url=" + this.f438951a + ')';
        }

        public h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f438951a = r100;
        }
    }

    public static final class i implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f438952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f438953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ContactSource f438954c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f438952a, r101.f438952a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438953b, r101.f438953b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f438954c, r101.f438954c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f438952a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f438953b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            ContactSource r107 = this.f438954c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(userId=" + this.f438952a + ", token=" + this.f438953b + ", source=" + this.f438954c + ')';
        }

        public i(String r100, String r101, ContactSource r102) {
            this.f438952a = r100;
            this.f438953b = r101;
            this.f438954c = r102;
        }
    }

    public static final class j implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f438955a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f438955a, ((j) r100).f438955a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f438955a.hashCode();
        }

        public final String toString() {
            return "LeaderClick(leaderUserId=" + this.f438955a + ')';
        }

        public j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "leaderUserId");
            this.f438955a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.k$k, reason: collision with other inner class name */
    public static final class C5263k implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5263k f438956a = null;

        static {
            f438956a = new C5263k();
        }

        public C5263k() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5263k) == true) goto L9;
            return false;
        L9:
            C5263k r101 = (C5263k) r100;
            return true;
        }

        public final int hashCode() {
            return 2052328629;
        }

        public final String toString() {
            return "NavigateToDoubaoHomepage";
        }
    }

    public static final class l implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f438957a = null;

        static {
            f438957a = new l();
        }

        public l() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            l r101 = (l) r100;
            return true;
        }

        public final int hashCode() {
            return -125054171;
        }

        public final String toString() {
            return "QrCodeClick";
        }
    }

    public static final class m implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f438958a = null;

        static {
            f438958a = new m();
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
            return -2012943858;
        }

        public final String toString() {
            return "Reload";
        }
    }

    public static final class n implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f438959a = null;

        static {
            f438959a = new n();
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
            return -2012824151;
        }

        public final String toString() {
            return "Report";
        }
    }

    public static final class o implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f438960a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f438960a, ((o) r100).f438960a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f438960a.hashCode();
        }

        public final String toString() {
            return "SaveAlias(alias=" + this.f438960a + ')';
        }

        public o(String r100) {
            Intrinsics.checkNotNullParameter(r100, "alias");
            this.f438960a = r100;
        }
    }

    public static final class p implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438961a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L9;
            return false;
        L9:
            if (this.f438961a == ((p) r100).f438961a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438961a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetApplyFriendDialogVisible(visible=" + this.f438961a + ')';
        }

        public p(boolean r100) {
            this.f438961a = r100;
        }
    }

    public static final class q implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438962a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L9;
            return false;
        L9:
            if (this.f438962a == ((q) r100).f438962a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438962a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetBlockedDialogVisible(visible=" + this.f438962a + ')';
        }

        public q(boolean r100) {
            this.f438962a = r100;
        }
    }

    public static final class r implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438963a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L9;
            return false;
        L9:
            if (this.f438963a == ((r) r100).f438963a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438963a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetDeleteFriendDialogVisible(visible=" + this.f438963a + ')';
        }

        public r(boolean r100) {
            this.f438963a = r100;
        }
    }

    public static final class s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438964a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof s) == true) goto L9;
            return false;
        L9:
            if (this.f438964a == ((s) r100).f438964a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438964a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetDepartmentExpanded(expanded=" + this.f438964a + ')';
        }

        public s() {
            this.f438964a = true;
        }
    }

    public static final class t implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438965a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L9;
            return false;
        L9:
            if (this.f438965a == ((t) r100).f438965a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438965a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetEditAliasDialogVisible(visible=" + this.f438965a + ')';
        }

        public t(boolean r100) {
            this.f438965a = r100;
        }
    }

    public static final class u implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f438966a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L9;
            return false;
        L9:
            if (this.f438966a == ((u) r100).f438966a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f438966a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetReportPopupVisible(visible=" + this.f438966a + ')';
        }

        public u(boolean r100) {
            this.f438966a = r100;
        }
    }

    public static final class v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f438967a = null;

        static {
            f438967a = new v();
        }

        public v() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L9;
            return false;
        L9:
            v r101 = (v) r100;
            return true;
        }

        public final int hashCode() {
            return 371623295;
        }

        public final String toString() {
            return "ShareProfile";
        }
    }
}
