package com.ss.android.lark.audio.recorder;

import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.ss.android.lark.audio.opus.OggopusFG;
import com.ss.android.lark.log.Log;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409133a = 0;

    static {
    }

    public static byte[] a(String r100) {
        byte[] r101 = new byte[64];
        Random.Default.nextBytes(r101);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L18;
        return r101;
    L18:
    L15:
        th = move-exception;
        Log.e("IMAudioRecordCompat", "getWaveform failed: " + th);
        return r101;
    L12:
        if (((Boolean) OggopusFG.f408995a.getValue()).booleanValue() == false) goto L20;
        return Oggopus_rustKt.getOpusWaveform(r100, 64);
    L20:
        return r101;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
