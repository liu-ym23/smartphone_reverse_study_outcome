package com.bytedance.awemeopen.apps.framework.card.view;

import android.widget.RelativeLayout;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends RelativeLayout implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f193908a = 0;

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
    public final void h(String r100) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlayPrepare(String r100) {
    }

    public void setIsLoop(boolean r100) {
    }

    public void setPlayStatusListener(w44.a r100) {
    }

    public void setStartPlayPosition(long r100) {
    }

    public long getCurrentPosition() {
        throw null;
    }

    public long getDuration() {
        throw null;
    }

    public long getWatchDuration() {
        throw null;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlaying(String r100) {
        System.currentTimeMillis();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 == 0) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == true) goto L8;
        return;
    L8:
        throw null;
    }

    public void setIsMute(boolean r100) {
        throw null;
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void l(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
        Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
    }
}
