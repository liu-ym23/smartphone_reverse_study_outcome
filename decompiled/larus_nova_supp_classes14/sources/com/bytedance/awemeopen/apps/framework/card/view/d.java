package com.bytedance.awemeopen.apps.framework.card.view;

import android.widget.RelativeLayout;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends RelativeLayout implements k {
    public static final /* synthetic */ int a = 0;

    public final void c(String r1) {
    }

    public final void d(String r1, long r2, int r4) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
    }

    public final void g(String r1, boolean r2, String r3) {
    }

    public final void h(String r1) {
    }

    public final void onPlayPrepare(String r1) {
    }

    public void setIsLoop(boolean r1) {
    }

    public void setPlayStatusListener(w44.a r1) {
    }

    public void setStartPlayPosition(long r1) {
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

    public final void onPlaying(String r1) {
        System.currentTimeMillis();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 == 0) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == true) goto L8;
        return;
    L8:
        throw null;
    }

    public void setIsMute(boolean r1) {
        throw null;
    }

    public final void l(String r1, l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }
}
