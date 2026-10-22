package com.larus.audio.flow.client.cache;

import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<TtsEventEnum> f289741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<TtsState> f289742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableSharedFlow<byte[]> f289743c = null;

    static {
        BufferOverflow r100 = BufferOverflow.DROP_OLDEST;
        f289741a = SharedFlowKt.MutableSharedFlow(1, 1, r100);
        f289742b = SharedFlowKt.MutableSharedFlow(1, 1, r100);
        f289743c = SharedFlowKt.MutableSharedFlow(0, 2, BufferOverflow.SUSPEND);
    }
}
