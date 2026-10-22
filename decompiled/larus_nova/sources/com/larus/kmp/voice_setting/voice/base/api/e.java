package com.larus.kmp.voice_setting.voice.base.api;

import com.larus.kmp.voice_setting.voice.bridge.n;
import com.larus.kmp.voice_setting.voice.bridge.r;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final boolean a() {
        r r100 = n.a(true);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L19;
        r r102 = n.a(false);
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r102.f351893b != true) goto L14;
        r103 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r100.f351893b != true) goto L7;
        r101 = true;
        goto L8
    }
}
