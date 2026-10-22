package com.larus.bmhome.chat.list.cell.video;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 19;
    }

    public v() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new u(r101);
    }
}
