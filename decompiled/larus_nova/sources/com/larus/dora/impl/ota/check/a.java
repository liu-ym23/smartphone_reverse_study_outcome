package com.larus.dora.impl.ota.check;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements d {
    public a() {
    }

    @Override // com.larus.dora.impl.ota.check.d
    public final Object a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Continuation<? super Result<e49.a>> r108) {
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new Exception("local OTAUpdateResponse is null")));
    }
}
