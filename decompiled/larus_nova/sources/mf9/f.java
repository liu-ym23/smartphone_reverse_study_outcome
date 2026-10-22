package mf9;

import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f513665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Block> f513666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f513667d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f513664a, r101.f513664a) == true) goto L12;
        return false;
    L12:
        if (this.f513665b == r101.f513665b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513666c, r101.f513666c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f513667d, r101.f513667d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f513664a.hashCode() * 31) + this.f513665b) * 31) + this.f513666c.hashCode()) * 31) + this.f513667d.hashCode();
    }

    public final String toString() {
        return "SsePullDeepResearchRequest# resourceId = " + this.f513664a + ", seqNo = " + this.f513665b;
    }

    public f(String r100, int r101, List<Block> r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        Intrinsics.checkNotNullParameter(r102, "originBlocks");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f513664a = r100;
        this.f513665b = r101;
        this.f513666c = r102;
        this.f513667d = r103;
    }
}
