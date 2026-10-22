package ew3;

import com.larus.bmhome.chat.api.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final String a;
    public final r0 b;
    public final Function1<String, Boolean> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "PermissionApplyCardVMData(permissionData=" + this.a + ", msgData=" + this.b + ", isLastMessage=" + this.c + ')';
    }

    public a(String r2, r0 r3, dw3.b r4) {
        Intrinsics.checkNotNullParameter(r3, "msgData");
        Intrinsics.checkNotNullParameter(r4, "isLastMessage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
