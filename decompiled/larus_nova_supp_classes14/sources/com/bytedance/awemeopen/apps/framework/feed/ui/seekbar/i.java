package com.bytedance.awemeopen.apps.framework.feed.ui.seekbar;

import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements k {
    public final /* synthetic */ SingleVideoSeekBarHelper a;

    public final void c(String r1) {
    }

    public final void d(String r1, long r2, int r4) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void h(String r1) {
    }

    public final void onPlaying(String r1) {
    }

    public i(SingleVideoSeekBarHelper r1) {
        this.a = r1;
    }

    public final void onPlayPrepare(String r4) {
        SingleVideoSeekBarHelper r5 = this.a;
        if (r5.g() == true) goto L7;
        r5.k();
        r5.M = "start_delay_loading_play_prepare";
        r5.L = true;
        r5.N.postDelayed(r5.O, 1500);
        return;
    }

    public final void l(String r1, l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }

    public final void g(String r1, boolean r2, String r3) {
        this.a.k();
        this.a.j();
        SingleVideoSeekBarHelper r4 = this.a;
        e r5 = r4.K;
        if (r5 == null) goto L7;
        boolean r6 = true;
        if (r5.b != true) goto L7;
    L8:
        if (r6 == false) goto L11;
        r4.m("render_first_frame");
        return;
    L11:
        return;
    L7:
        r6 = false;
        goto L8
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
        if (r2 == false) goto L4;
        this.a.l("buffer_start");
        return;
    L4:
        this.a.m("buffer_end");
    }
}
