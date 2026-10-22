package com.bytedance.applet.debugger;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface x {

    public static final class a implements x {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Failure(reason=" + this.a + ", retryable=" + this.b + ')';
        }

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements x {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Success(conversationId=" + this.a + ", botId=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r3, "botId");
            this.a = r2;
            this.b = r3;
        }
    }
}
