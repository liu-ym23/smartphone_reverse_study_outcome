package com.bytedance.android.shopping.deepfeed.data;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final View a;
        public final C0051b b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            C0051b r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "FragmentPreInflateConsumeResult(view=" + this.a + ", info=" + this.b + ")";
        }

        public a(C0051b r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            this.a = null;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.data.b$b, reason: collision with other inner class name */
    public static final class C0051b {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final long d;
        public final long e;
        public final long f;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof C0051b) == false) goto L18;
            C0051b r7 = (C0051b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (this.e == r7.e) goto L16;
            return false;
        L16:
            if (this.f == r7.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            if (r7 == true) goto L12;
            r1 = r7;
        L12:
            int r8 = (r6 + r1) * 31;
            long r9 = this.d;
            int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
            long r11 = this.e;
            int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
            long r13 = this.f;
            return r12 + ((int) (r13 ^ (r13 >>> 32)));
        }

        public final String toString() {
            return "FragmentPreInflateInfo(enabled=" + this.a + ", hasCacheEntry=" + this.b + ", hit=" + this.c + ", requestTime=" + this.d + ", inflateEndTime=" + this.e + ", consumeTime=" + this.f + ")";
        }

        public C0051b(long r2, long r4, long r6) {
            this.a = false;
            this.b = false;
            this.c = false;
            this.d = r2;
            this.e = r4;
            this.f = r6;
        }
    }

    static {
    }
}
