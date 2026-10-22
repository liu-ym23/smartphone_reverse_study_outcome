package com.larus.bmhome.chat.list.cell.spacer;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 51;
    }

    public l() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceData");
        return false;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new xc8.b(r101);
    }
}
