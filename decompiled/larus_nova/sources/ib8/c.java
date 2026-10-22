package ib8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f489017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DeepThinkFoldStatus f489018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DeepThinkFoldStatus f489019d;

    public c() {
        DeepThinkFoldStatus r100 = null;
        boolean r101 = false;
        this(r101, r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f489016a == r101.f489016a) goto L12;
        return false;
    L12:
        if (this.f489017b == r101.f489017b) goto L15;
        return false;
    L15:
        if (this.f489018c == r101.f489018c) goto L18;
        return false;
    L18:
        if (this.f489019d == r101.f489019d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f489016a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f489017b == true) goto L11;
        r100 = 1237;
    L11:
        return ((((r102 + r100) * 31) + this.f489018c.hashCode()) * 31) + this.f489019d.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FoldAnimationData(needRefreshLayout=" + this.f489016a + ", needAnimation=" + this.f489017b + ", originFoldStatus=" + this.f489018c + ", targetFoldStatus=" + this.f489019d + ')';
    }

    public c(boolean r100, boolean r101, DeepThinkFoldStatus r102, DeepThinkFoldStatus r103) {
        Intrinsics.checkNotNullParameter(r102, "originFoldStatus");
        Intrinsics.checkNotNullParameter(r103, "targetFoldStatus");
        this.f489016a = r100;
        this.f489017b = r101;
        this.f489018c = r102;
        this.f489019d = r103;
    }

    public /* synthetic */ c(boolean r100, DeepThinkFoldStatus r101, DeepThinkFoldStatus r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r101 = DeepThinkFoldStatus.CompleteExpand;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = DeepThinkFoldStatus.CompleteExpand;
    L11:
        this(r100, false, r101, r102);
    }
}
