package com.larus.bmhome.chat.model;

import com.larus.im.callback.IMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o1 extends com.larus.im.service.b {

    public static final class a {
    }

    static {
    }

    public o1() {
    }

    @Override // com.larus.im.service.c
    public final void a(IMError r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        FLogger.f375446a.e("StopLoadingCmdProcessor", r100.getTips(), r100.getException());
    }
}
