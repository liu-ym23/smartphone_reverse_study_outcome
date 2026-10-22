package com.larus.audio.utils;

import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes24.dex */
public final class j0 {
    static {
    }

    public static boolean a() {
        IObricRealtimeCallExtService r100 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.isAssistantListening();
    L6:
        int r102 = c68.b.f22600a;
        c68.b.a("AudioUtils", "O_CALL isListening: " + r101);
        Lazy r103 = MediaResourceManager.f358950a;
        if (MediaResourceManager.i(MediaScene.O_CALL) == false) goto L11;
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L5:
        r101 = false;
        goto L6
    }
}
