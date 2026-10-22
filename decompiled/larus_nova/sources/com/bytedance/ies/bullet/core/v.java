package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class v implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f246569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u26.b f246570b;

    @Override // com.bytedance.ies.bullet.core.q
    public final void lX() {
        this.f246569a.lX();
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void onClose() {
        this.f246569a.onClose();
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void onOpen() {
        this.f246569a.onOpen();
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void rS() {
        this.f246569a.rS();
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final u26.b getLynxClient() {
        return this.f246570b;
    }

    public v(q r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f246569a = r100;
        this.f246570b = r100.getLynxClient();
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void HP(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246569a.HP(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void Ox(Uri r100, h16.e r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246569a.Ox(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void TH(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f246569a.TH(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void gQ(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246569a.gQ(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void go(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246569a.go(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f246569a.onLoadFail(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void LG(Uri r100, com.bytedance.ies.bullet.service.base.o r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246569a.LG(r100, r101, r102);
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void bK(Uri r100, com.bytedance.ies.bullet.service.base.o r101, t36.j r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
        this.f246569a.bK(r100, r101, r102);
    }
}
