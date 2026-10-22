package com.larus.bmhome.chat.list.cell.send_file;

import com.larus.im.bean.message.Message;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements g {
    @Override // xc8.g
    public final int c() {
        return 18;
    }

    public e() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() != 7) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new d(r101);
    }
}
