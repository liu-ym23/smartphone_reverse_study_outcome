package com.larus.bmhome.chat.list.cell.test;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 47;
    }

    public z() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() == 800) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101.getBizContentType(), "crowd_test_tab") == false) goto L7;
        return true;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        int r102 = y.f305993e;
        return y.a.a(r101);
    }
}
