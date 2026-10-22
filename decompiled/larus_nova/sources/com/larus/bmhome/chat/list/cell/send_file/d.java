package com.larus.bmhome.chat.list.cell.send_file;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f305872e;

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.f305872e) ? 1 : 0;
    }

    public d(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "sendFileMessage");
        super(r100);
        this.f305872e = r100;
    }
}
