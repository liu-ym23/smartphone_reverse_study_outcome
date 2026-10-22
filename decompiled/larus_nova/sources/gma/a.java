package gma;

import android.view.View;
import com.obric.oui.picker.reels.views.WheelView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface a {

    /* JADX INFO: renamed from: gma.a$a, reason: collision with other inner class name */
    public interface InterfaceC6040a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f481776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f481777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f481778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f481779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f481780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f481781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f481782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f481783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final c f481784i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f481776a == r101.f481776a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f481777b, r101.f481777b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f481778c, r101.f481778c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.f481779d), Float.valueOf(r101.f481779d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f481780e, r101.f481780e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f481781f, r101.f481781f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f481782g, r101.f481782g) == true) goto L30;
            return false;
        L30:
            if (this.f481783h == r101.f481783h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f481784i, r101.f481784i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f481776a * 31) + this.f481777b.hashCode()) * 31;
            CharSequence r101 = this.f481778c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + Float.floatToIntBits(this.f481779d)) * 31;
            Integer r105 = this.f481780e;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Integer r108 = this.f481781f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Integer r111 = this.f481782g;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (((r110 + r112) * 31) + this.f481783h) * 31;
            c r114 = this.f481784i;
            if (r114 == null) goto L23;
            r102 = r114.hashCode();
        L23:
            return r113 + r102;
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Reel(id=" + this.f481776a + ", entries=" + this.f481777b + ", tag=" + this.f481778c + ", widthWeight=" + this.f481779d + ", width=" + this.f481780e + ", minWidth=" + this.f481781f + ", tagGap=" + this.f481782g + ", selectedIndex=" + this.f481783h + ", reelChangedListener=" + this.f481784i + ')';
        }

        public /* synthetic */ b(int r110, List r111, CharSequence r112, float r113, int r114, c r115, int r210) {
            if ((r210 & 4) == 0) goto L5;
            CharSequence r100 = null;
        L7:
            if ((r210 & 8) == 0) goto L9;
            float r101 = 1.0f;
        L11:
            if ((r210 & 128) == 0) goto L13;
            int r116 = 0;
        L15:
            if ((r210 & 256) == 0) goto L17;
            c r117 = null;
        L18:
            this(r110, r111, r100, r101, null, null, null, r116, r117);
            return;
        L17:
            r117 = r115;
            goto L18
        L13:
            r116 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }

        public b(int r100, List<String> r101, CharSequence r102, float r103, Integer r104, Integer r105, Integer r106, int r107, c r110) {
            Intrinsics.checkNotNullParameter(r101, "entries");
            this.f481776a = r100;
            this.f481777b = r101;
            this.f481778c = r102;
            this.f481779d = r103;
            this.f481780e = r104;
            this.f481781f = r105;
            this.f481782g = r106;
            this.f481783h = r107;
            this.f481784i = r110;
        }
    }

    public interface c {
        void a(int r100, int r101);
    }

    WheelView L0(int r100);

    View asView();
}
