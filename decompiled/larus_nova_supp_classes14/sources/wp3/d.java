package wp3;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends c {
    public static final /* synthetic */ int d = 0;
    public final WindowV2ProductItemVO a;
    public final b b;
    public final String c;

    public static final class a {
        public static d a(up3.f r6) {
            if (r6 != null) goto L6;
            return null;
        L6:
            if (r6.f() != null) goto L9;
            return null;
        L9:
            if (r6.a() != null) goto L11;
            return null;
        L11:
            WindowV2ProductItemVO r1 = WindowV2ProductItemVO.a.c(WindowV2ProductItemVO.P, r6.f());
            String r3 = r6.a().a();
            String r4 = "";
            if (r3 != null) goto L14;
            r3 = "";
        L14:
            String r5 = r6.a().b();
            if (r5 == null) goto L19;
            r4 = r5;
        L19:
            return new d(r1, new b(r3, r4), r6.i());
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
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
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ECBuyButtonVO(des=" + this.a + ", url=" + this.b + ")";
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "des");
            Intrinsics.checkNotNullParameter(r3, "url");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public d(WindowV2ProductItemVO r2, b r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "product");
        Intrinsics.checkNotNullParameter(r3, "buyButton");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
