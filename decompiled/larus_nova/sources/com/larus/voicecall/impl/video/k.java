package com.larus.voicecall.impl.video;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class k implements Function1 {
    public /* synthetic */ k() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        if (((VideoPreviewState) r100) != VideoPreviewState.close) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }
}
