package com.larus.voice_setting.voice.utils;

import android.content.Context;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static final Object a(Context r100, File r101, Continuation r102) {
        Object r103 = BuildersKt.withContext(Dispatchers.getIO(), new CommonExtKt$copyAssetsToStorage$2(r101, r100, "audio_metrics_v1.4.model", null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }
}
