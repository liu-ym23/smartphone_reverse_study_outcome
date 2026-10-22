package com.lark.kmp.storage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f282697a;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f282697a, ((a) r100).f282697a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f282697a.hashCode();
        }

        public final String toString() {
            return "GlobalSpace(spaceName=" + this.f282697a + ')';
        }

        public a(int r100) {
            Intrinsics.checkNotNullParameter("lark", "spaceName");
            SpaceScope r101 = SpaceScope.Global;
            super("lark");
            this.f282697a = "lark";
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f282698a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f282698a, ((b) r100).f282698a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f282698a.hashCode();
        }

        public final String toString() {
            return "UserSpace(spaceName=" + this.f282698a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spaceName");
            SpaceScope r101 = SpaceScope.Global;
            super(r100);
            this.f282698a = r100;
        }
    }

    public f(String r100) {
    }
}
