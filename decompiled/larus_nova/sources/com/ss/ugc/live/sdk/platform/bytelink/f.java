package com.ss.ugc.live.sdk.platform.bytelink;

import com.bytedance.common.utility.collection.WeakContainer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import vlc.n;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakContainer<com.ss.ugc.live.sdk.platform.bytelink.dispatch.c>> f458526a;

    @Override // vlc.f
    public final boolean c() {
        return false;
    }

    @Override // vlc.f
    public final void p(n r100) {
    }

    @Override // vlc.f
    public final boolean w(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        return false;
    }

    public f() {
        new ConcurrentHashMap();
        this.f458526a = new ConcurrentHashMap();
        new b();
    }

    @Override // com.ss.ugc.live.sdk.platform.bytelink.d
    public final void d(String r100, com.ss.ugc.live.sdk.platform.bytelink.dispatch.c r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "listener");
        WeakContainer<com.ss.ugc.live.sdk.platform.bytelink.dispatch.c> r102 = this.f458526a.get(r100);
        if (r102 != null) goto L5;
        r102 = new WeakContainer();
        this.f458526a.put(r100, r102);
    L5:
        r102.add(r101);
    }

    @Override // com.ss.ugc.live.sdk.platform.bytelink.d
    public final void m(String r100, com.ss.ugc.live.sdk.platform.bytelink.dispatch.c r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "listener");
        WeakContainer<com.ss.ugc.live.sdk.platform.bytelink.dispatch.c> r102 = this.f458526a.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isEmpty() == true) goto L9;
        r102.remove(r101);
        return;
    }
}
