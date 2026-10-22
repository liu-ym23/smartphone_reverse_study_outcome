package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239729a;

    public j(b r100) {
        this.f239729a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        IPlayer.State r101 = (IPlayer.State) r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        tt5.a.h("TtsMediaViewModel", "ttsStateObserver, state: " + r101);
        b.a(this.f239729a);
    }
}
