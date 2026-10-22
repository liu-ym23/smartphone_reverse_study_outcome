package com.larus.voice_setting.voice;

import android.media.AudioManager;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes32.dex */
public final class n2 {
    static {
    }

    public static int a() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r100 instanceof AudioManager) == false) goto L5;
        AudioManager r101 = (AudioManager) r100;
    L7:
        if (r101 == null) goto L9;
        int r102 = r101.getStreamVolume(3);
    L10:
        if (r101 == null) goto L12;
        int r103 = r101.getStreamMaxVolume(3);
    L14:
        return (int) ((r102 / r103) * 100);
    L12:
        r103 = 15;
        goto L14
    L9:
        r102 = 0;
        goto L10
    L5:
        r101 = null;
        goto L7
    }
}
