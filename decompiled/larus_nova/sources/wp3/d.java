package wp3;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f560575d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowV2ProductItemVO f560576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f560577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560578c;

    public static final class a {
        public static d a(up3.f r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.f() != null) goto L9;
            return null;
        L9:
            if (r100.a() != null) goto L11;
            return null;
        L11:
            WindowV2ProductItemVO r101 = WindowV2ProductItemVO.a.c(WindowV2ProductItemVO.P, r100.f());
            String r102 = r100.a().a();
            String r103 = "";
            if (r102 != null) goto L14;
            r102 = "";
        L14:
            String r104 = r100.a().b();
            if (r104 == null) goto L19;
            r103 = r104;
        L19:
            return new d(r101, new b(r102, r103), r100.i());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f560579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f560580b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f560579a, r101.f560579a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f560580b, r101.f560580b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f560579a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f560580b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ECBuyButtonVO(des=" + this.f560579a + ", url=" + this.f560580b + ")";
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "des");
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f560579a = r100;
            this.f560580b = r101;
        }
    }

    static {
    }

    public d(WindowV2ProductItemVO r100, b r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "product");
        Intrinsics.checkNotNullParameter(r101, "buyButton");
        this.f560576a = r100;
        this.f560577b = r101;
        this.f560578c = r102;
    }
}
