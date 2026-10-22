package com.ss.android.lark.audio.voiceinput.utils;

import com.ss.android.lark.audio.voiceinput.service.IAudioService;

/* JADX INFO: loaded from: classes34.dex */
public final class VoiceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409442a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.audio.voiceinput.utils.VoiceUtils$abortUploadAudio$1] */
    public static void a(IAudioService r100, final String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        if (r100 == 0) goto L13;
        r100.xa(r101, new VoiceUtils$abortUploadAudio$1(r101));
        return;
    L13:
        return;
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }
}
