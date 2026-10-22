package hc3;

import android.view.View;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.FilterCardViewHolder;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements fc3.b {
    public final long a;
    public final int b;
    public final int c;
    public final FilterCardViewHolder.a d;
    public final Function0<Unit> e;
    public final Function1<? super Integer, Unit> f;
    public final View g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L20;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31;
        FilterCardViewHolder.a r2 = this.d;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        Function0<Unit> r6 = this.e;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        Function1<? super Integer, Unit> r9 = this.f;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        View r12 = this.g;
        if (r12 == null) goto L18;
        r3 = r12.hashCode();
    L18:
        return r11 + r3;
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "FilterExpandParams(animTime=" + this.a + ", foldHeight=" + this.b + ", expandHeight=" + this.c + ", foldStatus=" + this.d + ", animEndListener=" + this.e + ", tabHeightListener=" + this.f + ", animView=" + this.g + ")";
    }

    public b(long r2, int r4, int r5, FilterCardViewHolder.a r6, Function0 r7, Function1 r8, CommentSliceView r9) {
        Intrinsics.checkNotNullParameter(r6, "foldStatus");
        Intrinsics.checkNotNullParameter(r7, "animEndListener");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
