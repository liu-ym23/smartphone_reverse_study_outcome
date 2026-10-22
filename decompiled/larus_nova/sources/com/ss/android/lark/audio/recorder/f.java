package com.ss.android.lark.audio.recorder;

import com.ss.android.lark.log.Log;
import java.util.concurrent.Semaphore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {
    public static final void a(Semaphore r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.acquire();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("LarkAudioRecorder", "[safeAcquire]occur exception:" + e + " hashCode:" + r100.hashCode());
    }
}
