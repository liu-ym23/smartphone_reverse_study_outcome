package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.queue;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.e;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import l76.d;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<g> f249964a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f249964a.clear();
    }

    public b() {
        this.f249964a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.e
    public final void e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f249964a.remove(r100);
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g
    public final h k(h r100) {
        Iterator<T> r101 = this.f249964a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r100 = ((g) r101.next()).k(r100);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L10:
        return r100;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g
    public final PlayMode o(PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        Iterator<T> r101 = this.f249964a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r100 = ((g) r101.next()).o(r100);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L10:
        return r100;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.e
    public final void p(g r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        if (this.f249964a.contains(r100) == true) goto L6;
        this.f249964a.add(r100);
        return;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.g
    public final f j(f r100, n76.b r101) {
        Iterator<T> r102 = this.f249964a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        r100 = ((g) r102.next()).j(r100, r101);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L10:
        return r100;
    }
}
