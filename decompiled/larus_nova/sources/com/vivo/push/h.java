package com.vivo.push;

import com.ss.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes41.dex */
final class h implements com.vivo.push.restructure.request.a.a.c.a<g> {
    public h() {
    }

    private static g b(String r100) {
        return new g(new com.vivo.push.restructure.request.a.a.a(r100));
    L4:
        e = move-exception;
        com.vivo.push.util.t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
        return null;
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String r100) {
        return b(r100);
    }
}
