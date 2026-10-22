package com.larus.asr.session;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InputTextAsrSession2V2$createComponents$3 extends FunctionReferenceImpl implements Function0<String> {
    public InputTextAsrSession2V2$createComponents$3(Object r100) {
        super(0, r100, p.class, "getAsrBizScene", "getAsrBizScene()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return ((p) this.receiver).nb();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
