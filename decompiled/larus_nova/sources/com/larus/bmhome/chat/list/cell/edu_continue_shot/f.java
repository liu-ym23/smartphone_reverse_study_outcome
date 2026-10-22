package com.larus.bmhome.chat.list.cell.edu_continue_shot;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements g {
    @Override // xc8.g
    public final int c() {
        return 40;
    }

    public f() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() == 800) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101.getBizContentType(), "edu_continue_shot") == false) goto L7;
        return true;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new e(r101);
    }
}
