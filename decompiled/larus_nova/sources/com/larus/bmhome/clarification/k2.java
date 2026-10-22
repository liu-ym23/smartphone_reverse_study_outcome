package com.larus.bmhome.clarification;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f310553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Block f310554b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k2) == true) goto L8;
        return false;
    L8:
        k2 r101 = (k2) r100;
        if (Intrinsics.areEqual(this.f310553a, r101.f310553a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310554b, r101.f310554b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f310553a.hashCode() * 31) + this.f310554b.hashCode();
    }

    public final String toString() {
        return "ResolvedClarificationBlock(message=" + this.f310553a + ", block=" + this.f310554b + ')';
    }

    public k2(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f310553a = r100;
        this.f310554b = r101;
    }
}
