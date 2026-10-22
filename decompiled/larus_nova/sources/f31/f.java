package f31;

import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f475330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f475331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f475332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f475333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o51.f f475334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.core.service.g f475335f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f475330a, r101.f475330a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475331b, r101.f475331b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f475332c, r101.f475332c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475333d, r101.f475333d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f475334e, r101.f475334e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f475335f, r101.f475335f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<k> r100 = this.f475330a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RectF r104 = this.f475331b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        RectF r107 = this.f475332c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Matrix r110 = this.f475333d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        o51.f r113 = this.f475334e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        com.bytedance.android.live.revlink.link.core.service.g r116 = this.f475335f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LayoutStatus(status=" + this.f475330a + ", visibleArea=" + this.f475331b + ", micVisibleArea=" + this.f475332c + ", gridMatrix=" + this.f475333d + ", uiLayoutIndex=" + this.f475334e + ", containerMargin=" + this.f475335f + ")";
    }

    public /* synthetic */ f(List r100, RectF r101, RectF r110, Matrix r111, o51.f r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public f(List<k> r100, RectF r101, RectF r102, Matrix r103, o51.f r104, com.bytedance.android.live.revlink.link.core.service.g r105) {
        Intrinsics.checkNotNullParameter(r101, "visibleArea");
        Intrinsics.checkNotNullParameter(r102, "micVisibleArea");
        Intrinsics.checkNotNullParameter(r103, "gridMatrix");
        Intrinsics.checkNotNullParameter(r104, "uiLayoutIndex");
        this.f475330a = r100;
        this.f475331b = r101;
        this.f475332c = r102;
        this.f475333d = r103;
        this.f475334e = r104;
        this.f475335f = r105;
    }
}
