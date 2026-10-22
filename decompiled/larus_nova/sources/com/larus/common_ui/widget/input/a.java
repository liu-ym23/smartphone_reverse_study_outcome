package com.larus.common_ui.widget.input;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f328681a = 0;

    static {
    }

    public static Object a(byte[] r100, int r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AudioUtils$getAudioWave$2(r100, 16, r101, null), r102);
    }
}
