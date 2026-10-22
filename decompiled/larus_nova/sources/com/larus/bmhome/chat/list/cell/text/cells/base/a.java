package com.larus.bmhome.chat.list.cell.text.cells.base;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f306018e;

    public c i() {
        return this.f306018e;
    }

    public a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.f306018e = new c(null, 0, 0, 63);
    }

    @Override // xc8.b
    public boolean c(wq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(getMessage().getLocalMessageId(), r100.getMessage().getLocalMessageId()) == true) goto L7;
        return false;
    L7:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (i().f306021a != r101.i().f306021a) goto L14;
        if (i().f306022b != r101.i().f306022b) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L20;
        return true;
    L20:
        return false;
    L14:
        r102 = false;
        goto L15
    }
}
