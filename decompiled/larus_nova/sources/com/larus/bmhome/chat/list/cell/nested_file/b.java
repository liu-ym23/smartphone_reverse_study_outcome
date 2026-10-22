package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 25;
    }

    public b() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return lr8.c.a(r101);
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new a(r101);
    }
}
