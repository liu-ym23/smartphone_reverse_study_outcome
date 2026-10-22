package com.larus.im.service;

import com.larus.im.internal.protocol.bean.IMCMD;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends c {
    public void c(ouc.d0 r100) {
    }

    public a() {
        super(IMCMD.IMCMD_COMMON.value);
    }

    @Override // com.larus.im.service.c
    public final Object b(ouc.d0 r100, Continuation<? super Unit> r101) {
        com.larus.im.internal.delegate.a.f348188b.i("CmdProcessor", "biz cmd processor");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r100.toString());     // Catch: Throwable -> L5
    L7:
        Object r104 = null;
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L11;
        r103 = null;
    L11:
        String r105 = (String) r103;
        if (r105 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L32;
        com.larus.im.internal.delegate.a.f348188b.e("CmdProcessor", "biz cmd processor json str is null or blank");
        c(null);
        return Unit.INSTANCE;
    L32:
        Object r107 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L22
    L24:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L27;
        r104 = r107;
    L28:
        c((ouc.d0) r104);
        return Unit.INSTANCE;
    L27:
        com.larus.im.internal.delegate.a.f348188b.e("CmdProcessor", "biz cmd processor json str parse error " + r108.getMessage());
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L14:
        if (StringsKt.isBlank(r105) == true) goto L17;
        r106 = false;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
