package com.bytedance.ee.bear.drive.core.thumbnail;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class g {

    public static final class a extends g {
        public final File a;

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
            return "Hit(file=" + this.a + ')';
        }

        public a(File r2) {
            Intrinsics.checkNotNullParameter(r2, "file");
            this.a = r2;
        }
    }

    public static final class b extends g {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public g() {
    }
}
