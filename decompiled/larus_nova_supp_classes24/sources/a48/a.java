package a48;

import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {
    public final String a;

    /* JADX INFO: renamed from: a48.a$a, reason: collision with other inner class name */
    public static final class C0002a extends a {
        public final String b;
        public final z38.a c;

        public final int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "TokenInvalid(token=" + this.b + ", message=" + this.c + ')';
        }

        @Override // a48.a
        public final String a() {
            return this.b;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0002a) == true) goto L8;
            return false;
        L8:
            C0002a r6 = (C0002a) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public C0002a(String r2, z38.a r3) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "message");
            super(r2);
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends a {
        public final String b;
        public final MfaMessage c;
        public final boolean d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            boolean r1 = this.d;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return r0 + r2;
        }

        public final String toString() {
            return "TokenReceive(token=" + this.b + ", message=" + this.c + ", isDeeplink=" + this.d + ')';
        }

        @Override // a48.a
        public final String a() {
            return this.b;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L17;
            return false;
        L17:
            return true;
        }

        public b(String r2, MfaMessage r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "message");
            super(r2);
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public String a() {
        return this.a;
    }

    public a(String r1) {
        this.a = r1;
    }
}
