package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u2 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u2) == false) goto L12;
        ((u2) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return ((((int) 0) + 0) * 31) + 0;
    }

    public final String toString() {
        return "SendGiftErrorEvent(throwable=null, runnable=null, allowCharge=0, giftId=0, toUser=null)";
    }
}
