package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class m implements Function1 {
    public /* synthetic */ m() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Log.e("DraftService", "addDraft: error occurred: error is " + ((ErrorResult) r100).getDisplayMsg());
        return null;
    }
}
