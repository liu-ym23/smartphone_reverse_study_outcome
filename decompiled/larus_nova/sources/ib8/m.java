package ib8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<DeepThinkFoldStatus, String> f489075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<DeepThinkFoldStatus, String> f489076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<DeepThinkFoldStatus, List<String>> f489078d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f489075a, r101.f489075a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489076b, r101.f489076b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489077c, r101.f489077c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489078d, r101.f489078d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f489075a.hashCode() * 31) + this.f489076b.hashCode()) * 31) + this.f489077c.hashCode()) * 31) + this.f489078d.hashCode();
    }

    public final String toString() {
        return "FoldContainerHeaderInfo(headIcon=" + this.f489075a + ", headTitle=" + this.f489076b + ", headTitleShowCount=" + this.f489077c + ", headTitleList=" + this.f489078d + ')';
    }

    public /* synthetic */ m(Function1 r100, Function1 r101, String r102) {
        this(r100, r101, r102, l.f489072a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function1<? super DeepThinkFoldStatus, String> r100, Function1<? super DeepThinkFoldStatus, String> r101, String r102, Function1<? super DeepThinkFoldStatus, ? extends List<String>> r103) {
        Intrinsics.checkNotNullParameter(r100, "headIcon");
        Intrinsics.checkNotNullParameter(r101, "headTitle");
        Intrinsics.checkNotNullParameter(r102, "headTitleShowCount");
        Intrinsics.checkNotNullParameter(r103, "headTitleList");
        this.f489075a = r100;
        this.f489076b = r101;
        this.f489077c = r102;
        this.f489078d = r103;
    }
}
