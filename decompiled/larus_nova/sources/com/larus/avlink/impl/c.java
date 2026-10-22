package com.larus.avlink.impl;

import android.media.AudioManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f293103a = 0;

    static {
    }

    public static void a() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("audio");     // Catch: Exception -> L17
        if ((r100 instanceof AudioManager) == false) goto L6;
        AudioManager r101 = (AudioManager) r100;     // Catch: Exception -> L17
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        int r102 = r101.getStreamVolume(3);     // Catch: Exception -> L17
        if (Build.VERSION.SDK_INT < 28) goto L12;
        int r103 = r101.getStreamMinVolume(3);     // Catch: Exception -> L17
    L13:
        int r104 = (int) ((((double) (r101.getStreamMaxVolume(3) - r103)) * 0.125d) + ((double) r103));     // Catch: Exception -> L17
        FLogger.f375446a.i("DoraAVLinkPlatform", "adjustSystemVoice systemVolume:" + r102 + " expectVoice:" + r104);     // Catch: Exception -> L17
        if (r102 >= r104) goto L22;
        r101.setStreamVolume(3, r104, 1);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L12:
        r103 = 0;
        goto L13
    L6:
        r101 = null;
    L17:
        e = move-exception;
        FLogger.f375446a.e("DoraAVLinkPlatform", "adjustSystemVoice failed", e);
    }
}
