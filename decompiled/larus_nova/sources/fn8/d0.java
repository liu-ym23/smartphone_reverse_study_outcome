package fn8;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class d0 {

    public static final class a extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f477958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RichMediaOverlayAlignment f477959b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f477958a, r101.f477958a) == true) goto L12;
            return false;
        L12:
            if (this.f477959b == r101.f477959b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f477958a.hashCode() * 31) + this.f477959b.hashCode();
        }

        public final String toString() {
            return "Image(iconUrl=" + this.f477958a + ", alignment=" + this.f477959b + ')';
        }

        @Override // fn8.d0
        public final RichMediaOverlayAlignment a() {
            return this.f477959b;
        }

        public a(String r100, RichMediaOverlayAlignment r101) {
            Intrinsics.checkNotNullParameter(r100, "iconUrl");
            Intrinsics.checkNotNullParameter(r101, "alignment");
            this.f477958a = r100;
            this.f477959b = r101;
        }
    }

    public static final class b extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f477960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RichMediaOverlayAlignment f477961b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f477960a, r101.f477960a) == true) goto L12;
            return false;
        L12:
            if (this.f477961b == r101.f477961b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f477960a.hashCode() * 31) + this.f477961b.hashCode();
        }

        public final String toString() {
            return "Link(openUrl=" + this.f477960a + ", alignment=" + this.f477961b + ')';
        }

        @Override // fn8.d0
        public final RichMediaOverlayAlignment a() {
            return this.f477961b;
        }

        public b(String r100, RichMediaOverlayAlignment r101) {
            Intrinsics.checkNotNullParameter(r100, RuleConditionBean.OPEN_URL_KEY);
            Intrinsics.checkNotNullParameter(r101, "alignment");
            this.f477960a = r100;
            this.f477961b = r101;
        }
    }

    public d0() {
    }

    public abstract RichMediaOverlayAlignment a();
}
