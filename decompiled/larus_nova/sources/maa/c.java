package maa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f512724a = null;

        static {
            f512724a = new a();
        }

        public a() {
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f512725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f512726b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f512725a, r101.f512725a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f512726b, r101.f512726b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f512725a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f512726b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrResultEnd(asrTaskID=" + this.f512725a + ", text=" + this.f512726b + ')';
        }

        public b(String r100, String r101) {
            this.f512725a = r100;
            this.f512726b = r101;
        }
    }

    /* JADX INFO: renamed from: maa.c$c, reason: collision with other inner class name */
    public static final class C6790c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f512727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f512728b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6790c) == true) goto L8;
            return false;
        L8:
            C6790c r101 = (C6790c) r100;
            if (Intrinsics.areEqual(this.f512727a, r101.f512727a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f512728b, r101.f512728b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f512727a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f512728b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrUpdate(asrTaskID=" + this.f512727a + ", text=" + this.f512728b + ')';
        }

        public C6790c(String r100, String r101) {
            this.f512727a = r100;
            this.f512728b = r101;
        }
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f512729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f512730b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f512729a, r101.f512729a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f512730b, r101.f512730b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f512729a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f512730b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "QueryBegin(asrTaskID=" + this.f512729a + ", text=" + this.f512730b + ')';
        }

        public d(String r100) {
            this.f512729a = r100;
            this.f512730b = "";
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f512731a = null;

        static {
            f512731a = new e();
        }

        public e() {
        }
    }

    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f512732a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f512732a == ((f) r100).f512732a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f512732a;
        }

        public final String toString() {
            return "TalkStateChanged(state=" + this.f512732a + ')';
        }

        public f(int r100) {
            this.f512732a = r100;
        }
    }
}
