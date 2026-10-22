package com.larus.extension.summary_card.impl.cell;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f343004e;

    @Override // xc8.b
    public final int d() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f343004e, ((z) r100).f343004e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f343004e.hashCode();
    }

    public final String toString() {
        return "SummaryCardCellState(msg=" + this.f343004e + ')';
    }

    public z(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super(r100);
        this.f343004e = r100;
    }
}
