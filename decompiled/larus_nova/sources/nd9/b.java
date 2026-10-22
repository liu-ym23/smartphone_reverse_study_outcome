package nd9;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f518809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f518810b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f518809a, r101.f518809a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f518810b, r101.f518810b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f518809a.hashCode() * 31;
            ByteBuffer r101 = this.f518810b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Frame(data=" + this.f518809a + ", extra=" + this.f518810b + ')';
        }

        public a(ByteBuffer r100, ByteBuffer r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f518809a = r100;
            this.f518810b = r101;
        }
    }

    a a(a r100);

    ByteBuffer b(ByteBuffer r100);
}
