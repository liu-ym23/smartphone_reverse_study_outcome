package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class w {

    public static final class a extends w {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends w {
        public final int a;
        public final Bitmap b;
        public final boolean c;
        public final String d;
        public final int e;
        public final int f;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L18;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r0 = this.a * 31;
            Bitmap r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.c;
            ?? r6 = r5;
            if (r5 == false) goto L9;
            r6 = 1;
        L9:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L13;
            r2 = r8.hashCode();
        L13:
            return ((((r7 + r2) * 31) + this.e) * 31) + this.f;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "SuccessBitmap(index=" + this.a + ", bitmap=" + this.b + ", isHead=" + this.c + ", uri=" + this.d + ", imageWidth=" + this.e + ", imageHeight=" + this.f + ")";
        }

        public b(int r2, Bitmap r3, boolean r4, String r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r3, "bitmap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public w() {
    }
}
