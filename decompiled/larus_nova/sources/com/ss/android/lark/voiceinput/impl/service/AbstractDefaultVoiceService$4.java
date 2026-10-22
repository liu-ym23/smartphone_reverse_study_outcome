package com.ss.android.lark.voiceinput.impl.service;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AbstractDefaultVoiceService$4 extends FunctionReferenceImpl implements Function0<Long> {
    public static final AbstractDefaultVoiceService$4 INSTANCE = null;

    static {
        INSTANCE = new AbstractDefaultVoiceService$4();
    }

    public AbstractDefaultVoiceService$4() {
        super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
