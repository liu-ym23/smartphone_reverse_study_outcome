package com.larus.disk.impl.handler;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class VoicePreLoadCacheHandler$2 extends FunctionReferenceImpl implements Function0<Long> {
    public static final VoicePreLoadCacheHandler$2 INSTANCE = null;

    static {
        INSTANCE = new VoicePreLoadCacheHandler$2();
    }

    public VoicePreLoadCacheHandler$2() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
