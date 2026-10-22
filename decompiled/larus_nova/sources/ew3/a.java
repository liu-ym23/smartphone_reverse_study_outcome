package ew3;

import com.larus.bmhome.chat.api.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f474531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Boolean> f474532c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f474530a, r101.f474530a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474531b, r101.f474531b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474532c, r101.f474532c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474530a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f474531b.hashCode()) * 31) + this.f474532c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PermissionApplyCardVMData(permissionData=" + this.f474530a + ", msgData=" + this.f474531b + ", isLastMessage=" + this.f474532c + ')';
    }

    public a(String r100, r0 r101, dw3.b r102) {
        Intrinsics.checkNotNullParameter(r101, "msgData");
        Intrinsics.checkNotNullParameter(r102, "isLastMessage");
        this.f474530a = r100;
        this.f474531b = r101;
        this.f474532c = r102;
    }
}
