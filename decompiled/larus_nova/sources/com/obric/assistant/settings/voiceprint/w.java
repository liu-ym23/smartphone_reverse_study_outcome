package com.obric.assistant.settings.voiceprint;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f392483a = null;

    static {
        f392483a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }
}
