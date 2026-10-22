package com.bytedance.ee.bear.office.common.upload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class g0 {

    public static final class a extends g0 {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Folder(folderToken=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "folderToken");
            this.a = r2;
        }
    }

    public static final class b extends g0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public g0() {
    }
}
