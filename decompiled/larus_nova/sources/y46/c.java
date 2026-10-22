package y46;

import android.graphics.Rect;
import com.bytedance.ies.ugc.aweme.fmp.core.diff.DiffType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiffType f566049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f566050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f566051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f566052e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f566048a, r101.f566048a) == true) goto L12;
        return false;
    L12:
        if (this.f566049b == r101.f566049b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566050c, r101.f566050c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566051d, r101.f566051d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566052e, r101.f566052e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f566048a.hashCode() * 31) + this.f566049b.hashCode()) * 31;
        Rect r101 = this.f566050c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Rect r105 = this.f566051d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        e r108 = this.f566052e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiffResultItem(viewIdentifyId=" + this.f566048a + ", diffType=" + this.f566049b + ", prePos=" + this.f566050c + ", currentPos=" + this.f566051d + ", viewInfo=" + this.f566052e + ')';
    }

    public c(String r100, DiffType r101, Rect r102, Rect r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, "viewIdentifyId");
        Intrinsics.checkNotNullParameter(r101, "diffType");
        this.f566048a = r100;
        this.f566049b = r101;
        this.f566050c = r102;
        this.f566051d = r103;
        this.f566052e = r104;
    }
}
