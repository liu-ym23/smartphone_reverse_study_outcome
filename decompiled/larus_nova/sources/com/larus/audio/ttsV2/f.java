package com.larus.audio.ttsV2;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f289921a = null;

    static {
        f289921a = new f();
    }

    public f() {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L22;
        FLogger.f375446a.i("TtsBackgroundPlayLocalStore", "[contains] userId is empty");
        return false;
    L22:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(((Keva) m78.c.f512358b.getValue()).contains("key_tts_play_background_".concat(r100))));     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        FLogger.f375446a.e("TtsBackgroundPlayLocalStore", "[contains] check failed, userId=".concat(r100), r104);
    L17:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L21;
        r103 = r105;
    L21:
        return ((Boolean) r103).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        r101 = false;
        goto L7
    }

    public static boolean b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L22;
        FLogger.f375446a.i("TtsBackgroundPlayLocalStore", "[isEnabled] userId is empty, use defaultValue=" + r101);
        return r101;
    L22:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(((Keva) m78.c.f512358b.getValue()).getBoolean("key_tts_play_background_".concat(r100), r101)));     // Catch: Throwable -> L12
    L14:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        FLogger.f375446a.e("TtsBackgroundPlayLocalStore", "[isEnabled] load failed, userId=".concat(r100), r105);
    L17:
        Boolean r106 = Boolean.valueOf(r101);
        if (Result.m9455isFailureimpl(r104) == false) goto L21;
        r104 = r106;
    L21:
        return ((Boolean) r104).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        r102 = false;
        goto L7
    }

    public static boolean c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L22;
        FLogger.f375446a.i("TtsBackgroundPlayLocalStore", "[setEnabled] userId is empty, skip");
        return false;
    L22:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        ((Keva) m78.c.f512358b.getValue()).storeBoolean("key_tts_play_background_".concat(r101), r100);     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        FLogger.f375446a.e("TtsBackgroundPlayLocalStore", "[setEnabled] save failed, userId=" + r101 + ", enabled=" + r100, r105);
    L17:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L21;
        r104 = r106;
    L21:
        return ((Boolean) r104).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        r102 = false;
        goto L7
    }
}
