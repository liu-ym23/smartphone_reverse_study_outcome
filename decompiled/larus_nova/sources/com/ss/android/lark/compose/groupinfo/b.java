package com.ss.android.lark.compose.groupinfo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f417707a = null;

        static {
            f417707a = new a();
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
            return 2116751936;
        }

        public final String toString() {
            return "Finish";
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.b$b, reason: collision with other inner class name */
    public static final class C4911b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4911b f417708a = null;

        static {
            f417708a = new C4911b();
        }

        public C4911b() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4911b) == true) goto L9;
            return false;
        L9:
            C4911b r101 = (C4911b) r100;
            return true;
        }

        public final int hashCode() {
            return -1686718457;
        }

        public final String toString() {
            return "PickAvatar";
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f417709a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f417709a, ((c) r100).f417709a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f417709a.hashCode();
        }

        public final String toString() {
            return "ShowError(error=" + this.f417709a + ')';
        }

        public c(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f417709a = r100;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GroupInfoToast f417710a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f417710a == ((d) r100).f417710a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f417710a.hashCode();
        }

        public final String toString() {
            return "ShowToast(toast=" + this.f417710a + ')';
        }

        public d(GroupInfoToast r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            this.f417710a = r100;
        }
    }
}
