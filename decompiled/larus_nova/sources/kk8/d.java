package kk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f503821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f503822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f503823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ResearchBlock f503824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f503825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f503826f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f503821a, r101.f503821a) == true) goto L12;
        return false;
    L12:
        if (this.f503822b == r101.f503822b) goto L15;
        return false;
    L15:
        if (this.f503823c == r101.f503823c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503824d, r101.f503824d) == true) goto L21;
        return false;
    L21:
        if (this.f503825e == r101.f503825e) goto L24;
        return false;
    L24:
        if (this.f503826f == r101.f503826f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f503821a.hashCode() * 31;
        int r101 = 1231;
        if (this.f503822b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f503823c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        ResearchBlock r106 = this.f503824d;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r105 + r107) * 31) + this.f503825e) * 31;
        if (this.f503826f == true) goto L19;
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
        return "DeepResearchCardViewInput(message=" + this.f503821a + ", isFirstBlockModel=" + this.f503822b + ", isLastBlockModel=" + this.f503823c + ", researchBlock=" + this.f503824d + ", maxContentWidth=" + this.f503825e + ", enableTableHeader=" + this.f503826f + ')';
    }

    public d(Message r100, boolean r101, boolean r102, ResearchBlock r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f503821a = r100;
        this.f503822b = r101;
        this.f503823c = r102;
        this.f503824d = r103;
        this.f503825e = r104;
        this.f503826f = r105;
    }
}
