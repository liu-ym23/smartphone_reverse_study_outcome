package com.bytedance.lark.sdk.refactor;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class RustCommunicator$barrier$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    public RustCommunicator$barrier$1(Object r100) {
        super(1, r100, o.class, "isBarrierWhiteList", "isBarrierWhiteList(I)Z", 0);
    }

    public final Boolean invoke(int r100) {
        return Boolean.valueOf(((o) this.receiver).e(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
