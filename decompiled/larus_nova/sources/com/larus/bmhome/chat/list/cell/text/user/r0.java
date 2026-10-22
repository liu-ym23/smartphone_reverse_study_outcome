package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r0 extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f306526e;

    @Override // xc8.b
    public final int d() {
        return 1;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f306526e, ((r0) r100).f306526e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f306526e.hashCode();
    }

    public final String toString() {
        return "UserTextCellState(textMessage=" + this.f306526e + ')';
    }

    public r0(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "textMessage");
        super(r100);
        this.f306526e = r100;
    }
}
