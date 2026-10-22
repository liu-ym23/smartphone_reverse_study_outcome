package th8;

import android.util.Size;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f545975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f545976b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f545977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f545978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f545979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f545980d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f545977a == r101.f545977a) goto L12;
            return false;
        L12:
            if (this.f545978b == r101.f545978b) goto L15;
            return false;
        L15:
            if (this.f545979c == r101.f545979c) goto L18;
            return false;
        L18:
            if (this.f545980d == r101.f545980d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f545977a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((((r100 * 31) + this.f545978b) * 31) + this.f545979c) * 31) + this.f545980d;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "SizeConfig(isDeepThinkVlm=" + this.f545977a + ", padHorizontalWidth=" + this.f545978b + ", singleImageLongerSize=" + this.f545979c + ", multipleImageFixHeight=" + this.f545980d + ')';
        }

        public b(boolean r100, int r101, int r102, int r103) {
            this.f545977a = r100;
            this.f545978b = r101;
            this.f545979c = r102;
            this.f545980d = r103;
        }
    }

    static {
    }

    public f(b r100) {
        Intrinsics.checkNotNullParameter(r100, "sizeConfig");
        this.f545975a = r100;
        this.f545976b = LazyKt.lazy(new e());
    }

    public final Size a(int r100, FlowVLMContainerViewType r101, Integer r102, Integer r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "flowVLMContainerViewType");
        if (r102 == null) goto L5;
        int r106 = r102.intValue();
    L6:
        if (r103 == null) goto L8;
        int r107 = r103.intValue();
    L10:
        if (r101 != FlowVLMContainerViewType.NoContent) goto L14;
        return new Size(0, 0);
    L14:
        if (r101 != FlowVLMContainerViewType.SingleItem) goto L16;
        boolean r108 = true;
    L17:
        Integer r109 = Integer.valueOf(r106);
        Integer r110 = Integer.valueOf(r107);
        if (r109 == null) goto L20;
        int r111 = r109.intValue();
    L21:
        if (r110 == null) goto L23;
        int r112 = r110.intValue();
    L25:
        if (r105 == false) goto L33;
        if (r111 <= 0) goto L32;
        if (r112 <= 0) goto L32;
        if (r111 >= r112) goto L32;
        float r113 = 0.75f;
    L42:
        if (r108 == false) goto L60;
        b r114 = this.f545975a;
        if (r114.f545979c == 0) goto L46;
        int r115 = r100 - (c7.b(16) * 2);
        if (r113 <= 1.0f) goto L58;
        b r116 = this.f545975a;
        if (r116.f545977a == false) goto L55;
        int r117 = r116.f545979c;
        Size r118 = new Size((int) (r117 / 0.7407407f), r117 + 0);
    L68:
        return r118;
    L55:
        if (((Boolean) this.f545976b.getValue()).booleanValue() == false) goto L57;
        r115 = Math.min(this.f545975a.f545978b, r115);
    L57:
        r118 = new Size(r115, ((int) (r115 * 0.7407407f)) + 0);
        goto L68
    L58:
        int r119 = this.f545975a.f545979c;
        r118 = new Size((int) (r119 * 0.7407407f), r119 + 0);
        goto L68
    L46:
        if (r113 >= 1.0f) goto L48;
        float r120 = Math.min(r114.f545978b, r100) * 0.6666667f;
        return new Size((int) (r113 * r120), (int) r120);
    L48:
        float r121 = Math.min(r114.f545978b, r100) * 0.6666667f;
        return new Size((int) r121, (int) (r121 / r113));
    L60:
        b r122 = this.f545975a;
        int r123 = r122.f545980d;
        if (r123 > 0) goto L65;
        r123 = (int) (Math.min(r122.f545978b, r100) * 0.44444445f);
    L65:
        return new Size((int) (r123 * r113), r123);
    L32:
        r113 = 1.3333334f;
        goto L42
    L33:
        if (r111 <= 0) goto L41;
        if (r112 <= 0) goto L41;
        if (r108 == true) goto L40;
        if (r104 == false) goto L40;
        r113 = Math.max(0.6666667f, Math.min(1.5f, r111 / r112));
    L40:
        r113 = Math.max(0.5625f, Math.min(1.7777778f, r111 / r112));
    L41:
        r113 = 1.0f;
        goto L42
    L23:
        r112 = 0;
        goto L25
    L20:
        r111 = 0;
        goto L21
    L16:
        r108 = false;
        goto L17
    L8:
        r107 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }
}
