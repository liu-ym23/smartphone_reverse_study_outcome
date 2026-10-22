package ei4;

import android.view.View;
import com.bytedance.creativex.mediaimport.preview.internal.main.h;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import java.util.List;
import ki4.a0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DATA f472780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DATA> f472781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaterialSelectedState f472783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f472784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<DATA, View> f472785f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f472780a, r101.f472780a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472781b, r101.f472781b) == true) goto L15;
        return false;
    L15:
        if (this.f472782c == r101.f472782c) goto L18;
        return false;
    L18:
        if (this.f472783d == r101.f472783d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f472784e, r101.f472784e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f472785f, r101.f472785f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        DATA r100 = this.f472780a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.f472781b.hashCode()) * 31) + this.f472782c) * 31) + this.f472783d.hashCode()) * 31;
        a0 r104 = this.f472784e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<DATA, View> r107 = this.f472785f;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewEntranceParam(data=" + this.f472780a + ", list=" + this.f472781b + ", selectionIndex=" + this.f472782c + ", state=" + this.f472783d + ", enterFrom=" + this.f472784e + ", transViewProvider=" + this.f472785f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Object r100, List r101, int r102, MaterialSelectedState r103, a0 r104, h r105) {
        Intrinsics.checkNotNullParameter(r101, "list");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f472780a = r100;
        this.f472781b = r101;
        this.f472782c = r102;
        this.f472783d = r103;
        this.f472784e = r104;
        this.f472785f = r105;
    }
}
