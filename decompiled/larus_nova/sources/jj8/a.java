package jj8;

import com.larus.im.bean.message.block.InteractionAskBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractionAskBlock f499343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f499344b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f499343a, r101.f499343a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499344b, r101.f499344b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        InteractionAskBlock r100 = this.f499343a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f499344b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionAskCotTipVMData(interactionAskBlock=" + this.f499343a + ", backgroundRes=" + this.f499344b + ')';
    }

    public a(InteractionAskBlock r100, Integer r101) {
        this.f499343a = r100;
        this.f499344b = r101;
    }
}
