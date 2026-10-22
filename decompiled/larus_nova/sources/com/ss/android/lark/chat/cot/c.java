package com.ss.android.lark.chat.cot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f414793a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f414793a, ((a) r100).f414793a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f414793a.hashCode();
        }

        public final String toString() {
            return "BuiltIn(name=" + this.f414793a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f414793a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f414794a = null;

        static {
            f414794a = new b();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.c$c, reason: collision with other inner class name */
    public static final class C4849c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f414795a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4849c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f414795a, ((C4849c) r100).f414795a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f414795a.hashCode();
        }

        public final String toString() {
            return "ImageKey(key=" + this.f414795a + ')';
        }

        public C4849c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f414795a = r100;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f414796a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f414796a, ((d) r100).f414796a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f414796a.hashCode();
        }

        public final String toString() {
            return "ImageUrl(url=" + this.f414796a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f414796a = r100;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f414797a = null;

        static {
            f414797a = new e();
        }

        public e() {
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f414798a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f414798a, ((f) r100).f414798a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f414798a.hashCode();
        }

        public final String toString() {
            return "UdToken(token=" + this.f414798a + ')';
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.f414798a = r100;
        }
    }

    public c() {
    }
}
