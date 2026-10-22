package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ b a;

    public j(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        IPlayer.State r4 = (IPlayer.State) r3;
        Intrinsics.checkNotNullParameter(r4, "state");
        tt5.a.h("TtsMediaViewModel", "ttsStateObserver, state: " + r4);
        b.a(this.a);
    }
}
