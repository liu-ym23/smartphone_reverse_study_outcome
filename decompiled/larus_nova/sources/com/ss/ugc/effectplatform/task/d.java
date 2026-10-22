package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.net.CustomizedStickerCreateResponse;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends BaseNetworkTask<CustomizedStickerCreateResponse, CustomizedStickerCreateResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457757n;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        com.ss.ugc.effectplatform.util.g.b(this.f457757n, 6);
        throw null;
    }

    public d(EffectConfig r100, String r101) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r101, r100.P);
        this.f457757n = r100;
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (CustomizedStickerCreateResponse) r100.f469201a.convertJsonToObj(r101, CustomizedStickerCreateResponse.class);
    }
}
