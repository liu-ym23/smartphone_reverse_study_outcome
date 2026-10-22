package com.bytedance.ee.bear.office.common.upload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class g0 {

    public static final class a extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f235370a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f235370a, ((a) r100).f235370a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235370a.hashCode();
        }

        public final String toString() {
            return "Folder(folderToken=" + this.f235370a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "folderToken");
            this.f235370a = r100;
        }
    }

    public static final class b extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f235371a = null;

        static {
            f235371a = new b();
        }

        public b() {
        }
    }

    public g0() {
    }
}
