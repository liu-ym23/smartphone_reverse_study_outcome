package com.bytedance.live.zdanmaku.pipelines;

import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.live.zdanmaku.data.b;
import com.bytedance.live.zdanmaku.data.d;
import java.util.Iterator;
import java.util.Map;
import lf6.c;
import vk6.e;

/* JADX INFO: loaded from: classes19.dex */
public final class DanmakuProcessPipeline extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DanmakuController<?> f255860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, b<?>> f255861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f255862d;

    @Override // lf6.c
    public final void a() {
        this.f255860b.f255819i = new DanmakuProcessPipeline$onPrepare$entityCreator$1(this);
    }

    @Override // lf6.c
    public final void b(RenderRequest r100, float r101) {
        this.f255860b.d();
        DanmakuController<?> r102 = this.f255860b;
        if (r102.a() == false) goto L5;
        r102.f255812b.post(new com.bytedance.live.zdanmaku.b(r102));
    L6:
        Iterator r103 = this.f255860b.f255814d.iterator();
    L7:
        e.a r104 = (e.a) r103;
        if (r104.hasNext() == false) goto L10;
        RenderEntity r105 = ((Danmaku) r104.next()).b();
        r100.f254842a.add(r105);
        goto L7
    L10:
        return;
    L5:
        r102.b(r102.f255814d, r101, r102.f255816f);
        goto L6
    }

    public DanmakuProcessPipeline(DanmakuController<?> r100, Map<Class<?>, b<?>> r101, d r102) {
        this.f255860b = r100;
        this.f255861c = r101;
        this.f255862d = r102;
    }
}
