package lc3;

import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ICommentComponent> f508410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ICommentComponent> f508411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f508412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FetchFrom f508413d;

    public b() {
        List r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f508410a, r101.f508410a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f508411b, r101.f508411b) == true) goto L10;
        return false;
    L10:
        if (this.f508412c == r101.f508412c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508413d, r101.f508413d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        List<ICommentComponent> r100 = this.f508410a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ICommentComponent> r104 = this.f508411b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f508412c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        FetchFrom r110 = this.f508413d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentModel(listComponents=" + this.f508410a + ", multiPicComponents=" + this.f508411b + ", needScrollToFirst=" + this.f508412c + ", fetchFrom=" + this.f508413d + ")";
    }

    public /* synthetic */ b(List r100, List r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r102 & 8) == 0) goto L11;
        FetchFrom r103 = FetchFrom.OTHER;
    L12:
        this(r100, r101, false, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public b(List<ICommentComponent> r100, List<ICommentComponent> r101, boolean r102, FetchFrom r103) {
        Intrinsics.checkNotNullParameter(r100, "listComponents");
        Intrinsics.checkNotNullParameter(r101, "multiPicComponents");
        Intrinsics.checkNotNullParameter(r103, "fetchFrom");
        this.f508410a = r100;
        this.f508411b = r101;
        this.f508412c = r102;
        this.f508413d = r103;
    }
}
