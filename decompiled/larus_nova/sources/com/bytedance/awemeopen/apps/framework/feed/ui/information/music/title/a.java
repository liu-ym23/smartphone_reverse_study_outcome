package com.bytedance.awemeopen.apps.framework.feed.ui.information.music.title;

import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f196202a;

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void c(String r100) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void d(String r100, long r101, int r102) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void e(String r100, int r101, String r102) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void f(String r100, boolean r101, int r102, int r103) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void g(String r100, boolean r101, String r102) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlayPrepare(String r100) {
    }

    public a(b r100) {
        this.f196202a = r100;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void h(String r100) {
        if (Intrinsics.areEqual(this.f196202a.f196205i, r100) == false) goto L6;
        this.f196202a.h().f196212b.b(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlaying(String r100) {
        if (Intrinsics.areEqual(this.f196202a.f196205i, r100) == false) goto L6;
        this.f196202a.h().f196212b.b(Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void l(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
    }
}
