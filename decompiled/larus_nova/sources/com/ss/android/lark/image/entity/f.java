package com.ss.android.lark.image.entity;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f426352b;

    @Override // com.ss.android.lark.image.entity.b
    public final String b() {
        return PlayerResolution.SDKKEY.ORIGIN;
    }

    @Override // com.ss.android.lark.image.entity.b
    public final String a() {
        return this.f426352b;
    }

    public f(String r100) {
        super(r100);
        this.f426352b = r100;
    }
}
