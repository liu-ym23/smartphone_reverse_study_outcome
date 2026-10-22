package com.obric.assistant.audio;

import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements o78.b {
    public n() {
    }

    @Override // o78.b
    public final void b(String r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // o78.b
    public final void d(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "uniId");
    }

    @Override // o78.b
    public final void c(String r100, Map r101) {
        o78.b.a.a(r100);
    }

    @Override // o78.b
    public final void a(String r100, GlobalAudioStateEnum r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "playbackState");
        FLogger.f375446a.i("ObricAudioConnectionStatusMonitor", "onPlaybackStateChanged " + r101);
        if (r101 != GlobalAudioStateEnum.STOPPED) goto L8;
        Lazy r103 = ObricAudioConnectionStatusMonitor.f385617a;
        if (ObricAudioConnectionStatusMonitor.a() == false) goto L9;
        ObricAudioConnectionStatusMonitor.c("onStopAudioPlay");
        return;
    L9:
        return;
    }
}
