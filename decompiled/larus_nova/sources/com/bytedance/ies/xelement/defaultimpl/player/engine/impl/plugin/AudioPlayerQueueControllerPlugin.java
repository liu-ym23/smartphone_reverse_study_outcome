package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.plugin;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.e;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import m76.b;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class AudioPlayerQueueControllerPlugin extends p76.a implements b, g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f249950c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n76.a<f, k> f249951b;

    public static final class a {
    }

    static {
    }

    @Override // p76.c
    public final void onDetach() {
        this.f249951b = null;
        p76.b r100 = this.f528030a;
        if (r100 == null) goto L8;
        e r101 = r100.f528033c;
        if (r101 == null) goto L9;
        r101.e(this);
        return;
    L9:
        return;
    }

    @Override // p76.a, o76.c
    public final void onCompletion() {
        p76.b r100 = this.f528030a;
        f r101 = null;
        if (r100 == null) goto L7;
        com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b r102 = r100.f528036f;
        if (r102 == null) goto L7;
        PlayMode r103 = r102.getPlayMode();
    L8:
        boolean r104 = false;
        if (r103 != PlayMode.SINGLE_LOOP) goto L24;
        p76.b r105 = this.f528030a;
        if (r105 == null) goto L17;
        com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b r106 = r105.f528036f;
        if (r106 == null) goto L17;
        if (r106.o() != true) goto L17;
        r104 = true;
    L17:
        if (r104 == false) goto L34;
        p76.b r107 = this.f528030a;
        if (r107 == null) goto L23;
        com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b r108 = r107.f528036f;
        if (r108 == null) goto L23;
        r101 = r108.getCurrent();
    L23:
        w(r101, new n76.b("FROM_AUTO_SINGLE_LOOP"));
        return;
    L34:
        return;
    L24:
        p76.b r109 = this.f528030a;
        if (r109 == null) goto L31;
        com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b r110 = r109.f528036f;
        if (r110 == null) goto L31;
        if (r110.n() != true) goto L31;
        r104 = true;
    L31:
        if (r104 == false) goto L36;
        v(new n76.b("FROM_AUTO_PLAY_NEXT"));
        return;
    L36:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public AudioPlayerQueueControllerPlugin() {
        this.f249951b = new m76.a();
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g
    public final h k(h r100) {
        p76.b r101 = this.f528030a;
        if (r101 == null) goto L7;
        o76.b r102 = r101.f528035e;
        if (r102 == null) goto L7;
        r102.g(new n76.b("STOP_FROM_PLAYLIST_CHANGED"));
    L7:
        return r100;
    }

    @Override // p76.a, com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void m(f r100) {
        n76.a<f, k> r101 = this.f249951b;
        if (r101 == null) goto L6;
        r101.a(r100, new AudioPlayerQueueControllerPlugin$onCurrentDataSourceChanged$1(this));
        return;
    }

    @Override // p76.a, p76.c
    public final void n(p76.b r100) {
        Intrinsics.checkNotNullParameter(r100, "attachInfo");
        super.n(r100);
        p76.b r101 = this.f528030a;
        if (r101 == null) goto L8;
        e r102 = r101.f528033c;
        if (r102 == null) goto L9;
        r102.p(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g
    public final PlayMode o(PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        return r100;
    }

    public final void v(n76.b r100) {
        p76.b r101 = this.f528030a;
        if (r101 == null) goto L7;
        com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b r102 = r101.f528036f;
        if (r102 == null) goto L7;
        f r103 = r102.getNext();
    L8:
        w(r103, r100);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g
    public final f j(f r100, n76.b r101) {
        p76.b r102 = this.f528030a;
        if (r102 == null) goto L9;
        o76.b r103 = r102.f528035e;
        if (r103 == null) goto L9;
        if (r101 != null) goto L8;
        r101 = new n76.b("STOP_FROM_DATA_SOURCE_CHANGED");
    L8:
        r103.g(r101);
    L9:
        return r100;
    }

    public final void w(f r100, n76.b r101) {
        p76.b r102 = this.f528030a;
        if (r102 == null) goto L7;
        com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.b r103 = r102.f528036f;
        if (r103 == null) goto L7;
        r103.i(r100, r101);
    L7:
        p76.b r104 = this.f528030a;
        if (r104 == null) goto L13;
        o76.b r105 = r104.f528035e;
        if (r105 == null) goto L14;
        r105.d(r101);
        return;
    L14:
        return;
    }
}
