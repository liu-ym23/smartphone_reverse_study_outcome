package com.bytedance.ee.bear.drive.view.preview.video.audio;

import android.media.AudioManager;
import com.bytedance.ee.bear.drive.view.preview.video.player.n;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b implements AudioManager.OnAudioFocusChangeListener {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int r3) {
        tt5.a.h("PlayerPauseWhenAudioFocusLoss", "onAudioFocusChange, focusChange: " + r3);
        if (r3 != (-3)) goto L5;
        TTVideoEngine r4 = ((n) this).a.e.a;
        if (r4 == null) goto L30;
        r4.pause();
        return;
    L30:
        return;
    L5:
        if (r3 != (-2)) goto L7;
        TTVideoEngine r5 = ((n) this).a.e.a;
        if (r5 == null) goto L28;
        r5.pause();
        return;
    L28:
        return;
    L7:
        if (r3 != (-1)) goto L9;
        TTVideoEngine r6 = ((n) this).a.e.a;
        if (r6 == null) goto L26;
        r6.pause();
        return;
    L26:
        return;
    L9:
        if (r3 != 1) goto L31;
        TTVideoEngine r7 = ((n) this).a.e.a;
        if (r7 == null) goto L24;
        r7.play();
        return;
    L24:
        return;
    }
}
