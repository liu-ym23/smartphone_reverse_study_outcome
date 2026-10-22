package kc8;

import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> f502523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f502524b;

    public l0() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f502523a, r101.f502523a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502524b, r101.f502524b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> r100 = this.f502523a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f502524b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickReplyBlockConfig(customClickListener=" + this.f502523a + ", itemBackgroundRes=" + this.f502524b + ')';
    }

    public /* synthetic */ l0(cb8.z r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l0(Function6<? super String, ? super QuickReplyBlock, ? super String, ? super QuickReplyItem, ? super Integer, ? super Integer, Boolean> r100, Integer r101) {
        this.f502523a = r100;
        this.f502524b = r101;
    }
}
