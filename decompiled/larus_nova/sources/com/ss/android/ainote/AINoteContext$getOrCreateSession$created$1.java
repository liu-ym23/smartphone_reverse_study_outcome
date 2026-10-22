package com.ss.android.ainote;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AINoteContext$getOrCreateSession$created$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public AINoteContext$getOrCreateSession$created$1(Object r100) {
        super(0, r100, AINoteContext.class, "isBizSessionActive", "isBizSessionActive()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        if (((AINoteContext) this.receiver).f406501t <= 0) goto L5;
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L5:
        r100 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
