package com.vivo.push.d;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class j implements com.vivo.push.restructure.request.a.a.b.a<i> {
    public j() {
    }

    private static i b(com.vivo.push.restructure.request.a.a.a r100) {
        return new i(r100);
    L4:
        e = move-exception;
        t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
        return null;
    }

    @Override // com.vivo.push.restructure.request.a.a.b.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.b a(com.vivo.push.restructure.request.a.a.a r100) {
        return b(r100);
    }
}
