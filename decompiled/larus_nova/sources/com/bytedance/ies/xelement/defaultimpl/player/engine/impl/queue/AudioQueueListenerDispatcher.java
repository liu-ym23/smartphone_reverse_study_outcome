package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.queue;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.d;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.plugin.PluginManager;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class AudioQueueListenerDispatcher implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f249957a;

    public final q76.a<c> b() {
        return (q76.a) this.f249957a.getValue();
    }

    public AudioQueueListenerDispatcher() {
        this.f249957a = LazyKt.lazy(AudioQueueListenerDispatcher$mListeners$2.INSTANCE);
    }

    public final void d() {
        b().f531971a.clear();
    }

    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        q76.a<c> r101 = b();
        if (r101.f531971a.contains(r100) == true) goto L6;
        r101.f531971a.add(r100);
        return;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void c(final PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        b().a(new AudioQueueListenerDispatcher$onPlayModeChanged$1(r100));
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void m(final f r100) {
        b().a(new AudioQueueListenerDispatcher$onCurrentDataSourceChanged$1(r100));
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.d
    public final void q(PluginManager r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b().f531971a.remove(r100);
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void r(final h r100) {
        b().a(new AudioQueueListenerDispatcher$onPlaylistChanged$1(r100));
    }
}
