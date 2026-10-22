package com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class SingleSongPlaylist implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f249871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f249872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f249873c;

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final List<f> b() {
        return (List) this.f249872b.getValue();
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final String getId() {
        f r100 = this.f249871a;
        if (r100 == null) goto L6;
        String r101 = r100.getId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final int getCurrentIndex() {
        return this.f249873c;
    }

    public SingleSongPlaylist(f r100) {
        this.f249871a = r100;
        this.f249872b = LazyKt.lazy(new SingleSongPlaylist$mOriginList$2(this));
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final void a(int r100) {
        this.f249873c = r100;
    }
}
