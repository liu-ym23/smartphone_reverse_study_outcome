package com.bytedance.ee.bear.drive.view.preview.video.audio;

import android.media.AudioManager;
import com.bytedance.ee.bear.drive.view.preview.video.player.n;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b implements AudioManager.OnAudioFocusChangeListener {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int r100) {
        tt5.a.h("PlayerPauseWhenAudioFocusLoss", "onAudioFocusChange, focusChange: " + r100);
        if (r100 != (-3)) goto L5;
        TTVideoEngine r101 = ((n) this).f225585a.f225569e.f225555a;
        if (r101 == null) goto L30;
        r101.pause();
        return;
    L30:
        return;
    L5:
        if (r100 != (-2)) goto L7;
        TTVideoEngine r102 = ((n) this).f225585a.f225569e.f225555a;
        if (r102 == null) goto L28;
        r102.pause();
        return;
    L28:
        return;
    L7:
        if (r100 != (-1)) goto L9;
        TTVideoEngine r103 = ((n) this).f225585a.f225569e.f225555a;
        if (r103 == null) goto L26;
        r103.pause();
        return;
    L26:
        return;
    L9:
        if (r100 != 1) goto L31;
        TTVideoEngine r104 = ((n) this).f225585a.f225569e.f225555a;
        if (r104 == null) goto L24;
        r104.play();
        return;
    L24:
        return;
    }
}
