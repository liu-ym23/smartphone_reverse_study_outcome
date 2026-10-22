package com.bytedance.awemeopen.bizmodels.feed.poi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198190a = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.bizmodels.feed.poi.b$b, reason: collision with other inner class name */
    public static final class C2847b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f198191b;

        public C2847b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C2847b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f198191b, ((C2847b) r100).f198191b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // com.bytedance.awemeopen.bizmodels.feed.poi.b
        public final int hashCode() {
            return this.f198191b.hashCode();
        }

        public final String toString() {
            return "Gray(color=" + this.f198191b + ')';
        }

        public C2847b(int r100) {
            Intrinsics.checkNotNullParameter("#C4C4C4", "color");
            super(1);
            this.f198191b = "#C4C4C4";
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f198192b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f198192b == ((c) r100).f198192b) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // com.bytedance.awemeopen.bizmodels.feed.poi.b
        public final int hashCode() {
            return this.f198192b;
        }

        public final String toString() {
            return "Mix(color=" + this.f198192b + ')';
        }

        public c(int r100) {
            super(3);
            this.f198192b = 0;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f198193b;

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f198193b == ((d) r100).f198193b) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // com.bytedance.awemeopen.bizmodels.feed.poi.b
        public final int hashCode() {
            return this.f198193b;
        }

        public final String toString() {
            return "Normal(color=" + this.f198193b + ')';
        }

        public d(int r100) {
            super(0);
            this.f198193b = 0;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f198194b;

        public e() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f198194b == ((e) r100).f198194b) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // com.bytedance.awemeopen.bizmodels.feed.poi.b
        public final int hashCode() {
            return this.f198194b;
        }

        public final String toString() {
            return "Pic(color=" + this.f198194b + ')';
        }

        public e(int r100) {
            super(2);
            this.f198194b = 0;
        }
    }

    static {
    }

    public abstract int hashCode();

    public b(int r100) {
    }
}
