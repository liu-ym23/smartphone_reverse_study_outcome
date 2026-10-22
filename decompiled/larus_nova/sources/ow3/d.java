package ow3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f527049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f527050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f527051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f527052d;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f527053d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f527054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f527055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f527056c;

        /* JADX INFO: renamed from: ow3.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes14.dex */
        public static final class C7122a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f527054a, r101.f527054a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f527055b, r101.f527055b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f527056c, r101.f527056c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f527054a.hashCode() * 31) + this.f527055b.hashCode()) * 31) + this.f527056c.hashCode();
        }

        public final String toString() {
            return "PageInfo(pid=" + this.f527054a + ", pName=" + this.f527055b + ", sdkPageId=" + this.f527056c + ')';
        }

        public a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "pid");
            Intrinsics.checkNotNullParameter(r101, "pName");
            Intrinsics.checkNotNullParameter(r102, "sdkPageId");
            this.f527054a = r100;
            this.f527055b = r101;
            this.f527056c = r102;
        }
    }

    public d() {
        this.f527050b = "__coldstart";
        this.f527051c = "";
        this.f527052d = "__coldstart";
    }
}
