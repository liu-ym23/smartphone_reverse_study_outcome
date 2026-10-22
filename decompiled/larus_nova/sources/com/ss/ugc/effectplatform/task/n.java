package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.StickerUploadAuthKeyResponse;

/* JADX INFO: loaded from: classes36.dex */
public final class n extends BaseNetworkTask<StickerUploadAuthKeyResponse, StickerUploadAuthKeyResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457852n;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        com.ss.ugc.effectplatform.util.g.b(this.f457852n, 6);
        throw null;
    }

    public n(EffectConfig r100, String r101) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r101, r100.P);
        this.f457852n = r100;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (StickerUploadAuthKeyResponse) r100.f469201a.convertJsonToObj(r101, StickerUploadAuthKeyResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void k(String r100, String r101, ExceptionResult r102) {
        r102.setTrackParams(r100, this.f457852n.E, r101);
        super.k(r100, r101, r102);
    }
}
