package tp8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f547061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Block f547062b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f547061a, r101.f547061a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547062b, r101.f547062b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f547061a.hashCode() * 31) + this.f547062b.hashCode();
    }

    public final String toString() {
        return "ResolvedInputAreaQuickReplyBlock(message=" + this.f547061a + ", block=" + this.f547062b + ')';
    }

    public i(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f547061a = r100;
        this.f547062b = r101;
    }
}
