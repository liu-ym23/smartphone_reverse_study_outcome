package pk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f529676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResearchProcessBlock f529677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f529678c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f529676a == r101.f529676a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f529677b, r101.f529677b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f529678c, r101.f529678c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f529676a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        ResearchProcessBlock r102 = this.f529677b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((r101 + r103) * 31) + this.f529678c.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepResearchProgressCardVmData(isFinished=" + this.f529676a + ", researchProcessBlock=" + this.f529677b + ", message=" + this.f529678c + ')';
    }

    public e(boolean r100, ResearchProcessBlock r101, Message r102) {
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f529676a = r100;
        this.f529677b = r101;
        this.f529678c = r102;
    }
}
