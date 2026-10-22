package lk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f509595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f509596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f509597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ResearchBlock f509598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f509599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f509600f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f509595a, r101.f509595a) == true) goto L12;
        return false;
    L12:
        if (this.f509596b == r101.f509596b) goto L15;
        return false;
    L15:
        if (this.f509597c == r101.f509597c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509598d, r101.f509598d) == true) goto L21;
        return false;
    L21:
        if (this.f509599e == r101.f509599e) goto L24;
        return false;
    L24:
        if (this.f509600f == r101.f509600f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f509595a.hashCode() * 31;
        int r101 = 1231;
        if (this.f509596b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f509597c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        ResearchBlock r106 = this.f509598d;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r105 + r107) * 31) + this.f509599e) * 31;
        if (this.f509600f == true) goto L19;
        r101 = 1237;
    L19:
        return r108 + r101;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepResearchCardVMData(message=" + this.f509595a + ", isFirstBlockModel=" + this.f509596b + ", isLastBlockModel=" + this.f509597c + ", researchBlock=" + this.f509598d + ", maxContentWidth=" + this.f509599e + ", enableTableHeader=" + this.f509600f + ')';
    }

    public a(Message r100, boolean r101, boolean r102, ResearchBlock r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f509595a = r100;
        this.f509596b = r101;
        this.f509597c = r102;
        this.f509598d = r103;
        this.f509599e = r104;
        this.f509600f = r105;
    }
}
