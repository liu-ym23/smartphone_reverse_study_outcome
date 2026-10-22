package com.larus.disk.impl.handler;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FrescoCustomCacheHandler$cleanCache$1 extends FunctionReferenceImpl implements Function0<Long> {
    public FrescoCustomCacheHandler$cleanCache$1(Object r100) {
        super(0, r100, FrescoCustomCacheHandler.class, "getManualCleanableSize", "getManualCleanableSize()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(((FrescoCustomCacheHandler) this.receiver).d());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
