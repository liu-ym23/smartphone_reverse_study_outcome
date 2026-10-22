package com.bytedance.awemeopen.apps.framework.feed.ui.seekbar;

import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleVideoSeekBarHelper f196786a;

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
    public final void h(String r100) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlaying(String r100) {
    }

    public i(SingleVideoSeekBarHelper r100) {
        this.f196786a = r100;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlayPrepare(String r100) {
        SingleVideoSeekBarHelper r101 = this.f196786a;
        if (r101.g() == true) goto L7;
        r101.k();
        r101.M = "start_delay_loading_play_prepare";
        r101.L = true;
        r101.N.postDelayed(r101.O, 1500);
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void l(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void g(String r100, boolean r101, String r102) {
        this.f196786a.k();
        this.f196786a.j();
        SingleVideoSeekBarHelper r103 = this.f196786a;
        e r104 = r103.K;
        if (r104 == null) goto L7;
        boolean r105 = true;
        if (r104.f196781b != true) goto L7;
    L8:
        if (r105 == false) goto L11;
        r103.m("render_first_frame");
        return;
    L11:
        return;
    L7:
        r105 = false;
        goto L8
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void f(String r100, boolean r101, int r102, int r103) {
        if (r101 == false) goto L4;
        this.f196786a.l("buffer_start");
        return;
    L4:
        this.f196786a.m("buffer_end");
    }
}
