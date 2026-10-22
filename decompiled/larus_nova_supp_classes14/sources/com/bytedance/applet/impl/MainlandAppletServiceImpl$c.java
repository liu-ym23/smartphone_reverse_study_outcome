package com.bytedance.applet.impl;

import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.platform.api.m4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MainlandAppletServiceImpl$c implements m4 {
    public MainlandAppletServiceImpl$c() {
    }

    public final void b1() {
    }

    public final void S1() {
        AudioStreamPlayerDelegate.b.a(null, "enter_minor");
        MusicPlayManagerDelegate r0 = MusicPlayManagerDelegate.b;
        a88.e r2 = r0.a();
        if (r2 == null) goto L6;
        String r3 = r2.a;
        if (r3 == null) goto L6;
    L7:
        r0.c(r3);
        e19.t r1 = e19.t.j;
        e19.t r4 = e19.t.a.a();
        if (r4 == null) goto L11;
        e19.i.a.a(r4, null, 3);
        return;
    L11:
        return;
    L6:
        r3 = "";
        goto L7
    }
}
