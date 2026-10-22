package hc3;

import android.view.View;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.FilterCardViewHolder;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements fc3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f484520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f484522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FilterCardViewHolder.a f484523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f484524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f484525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f484526g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (this.f484520a == r101.f484520a) goto L8;
        return false;
    L8:
        if (this.f484521b == r101.f484521b) goto L10;
        return false;
    L10:
        if (this.f484522c == r101.f484522c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484523d, r101.f484523d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f484524e, r101.f484524e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f484525f, r101.f484525f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484526g, r101.f484526g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f484520a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f484521b) * 31) + this.f484522c) * 31;
        FilterCardViewHolder.a r102 = this.f484523d;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Function0<Unit> r106 = this.f484524e;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        Function1<? super Integer, Unit> r109 = this.f484525f;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        View r112 = this.f484526g;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "FilterExpandParams(animTime=" + this.f484520a + ", foldHeight=" + this.f484521b + ", expandHeight=" + this.f484522c + ", foldStatus=" + this.f484523d + ", animEndListener=" + this.f484524e + ", tabHeightListener=" + this.f484525f + ", animView=" + this.f484526g + ")";
    }

    public b(long r100, int r101, int r102, FilterCardViewHolder.a r103, Function0 r104, Function1 r105, CommentSliceView r106) {
        Intrinsics.checkNotNullParameter(r103, "foldStatus");
        Intrinsics.checkNotNullParameter(r104, "animEndListener");
        this.f484520a = r100;
        this.f484521b = r101;
        this.f484522c = r102;
        this.f484523d = r103;
        this.f484524e = r104;
        this.f484525f = r105;
        this.f484526g = r106;
    }
}
