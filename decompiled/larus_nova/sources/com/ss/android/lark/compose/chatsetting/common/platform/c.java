package com.ss.android.lark.compose.chatsetting.common.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f417366a = null;

        static {
            f417366a = new a();
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
            return -1030014494;
        }

        public final String toString() {
            return "BlockedByOther";
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f417367a = null;

        static {
            f417367a = new b();
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
            return 2136181082;
        }

        public final String toString() {
            return "BlockedOthers";
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.common.platform.c$c, reason: collision with other inner class name */
    public static final class C4891c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4891c f417368a = null;

        static {
            f417368a = new C4891c();
        }

        public C4891c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4891c) == true) goto L9;
            return false;
        L9:
            C4891c r101 = (C4891c) r100;
            return true;
        }

        public final int hashCode() {
            return 19740967;
        }

        public final String toString() {
            return "ClearHistorySuccess";
        }
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f417369a = null;

        static {
            f417369a = new d();
        }

        public d() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            d r101 = (d) r100;
            return true;
        }

        public final int hashCode() {
            return -1068275787;
        }

        public final String toString() {
            return "GeneralError";
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f417370a = null;

        static {
            f417370a = new e();
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
            return -1175779915;
        }

        public final String toString() {
            return "GroupCannotBeShared";
        }
    }

    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f417371a = null;

        static {
            f417371a = new f();
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
            return -138536617;
        }

        public final String toString() {
            return "GroupInfoEditNotAllowed";
        }
    }

    public static final class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f417372a = null;

        static {
            f417372a = new g();
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
            return 155647794;
        }

        public final String toString() {
            return "MovedToMuted";
        }
    }

    public static final class h implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f417373a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f417373a, ((h) r100).f417373a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f417373a.hashCode();
        }

        public final String toString() {
            return "NeedAddContact(chatterName=" + this.f417373a + ')';
        }

        public h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "chatterName");
            this.f417373a = r100;
        }
    }

    public static final class i implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f417374a = null;

        static {
            f417374a = new i();
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
            return 126862060;
        }

        public final String toString() {
            return "NeedAddContactFallback";
        }
    }

    public static final class j implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f417375a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f417375a, ((j) r100).f417375a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f417375a.hashCode();
        }

        public final String toString() {
            return "Text(value=" + this.f417375a + ')';
        }

        public j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f417375a = r100;
        }
    }

    public static final class k implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f417376a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f417376a, ((k) r100).f417376a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f417376a.hashCode();
        }

        public final String toString() {
            return "UdText(value=" + this.f417376a + ')';
        }

        public k(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f417376a = r100;
        }
    }
}
