package com.bytedance.awemeopen.apps.framework.feed.ui.seekbar;

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SeekBarState;
import com.bytedance.awemeopen.apps.framework.utils.j0;
import com.bytedance.awemeopen.infra.base.player.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements d.a {
    public final /* synthetic */ SingleVideoSeekBarHelper a;

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
    public final void a() {
        SingleVideoSeekBarHelper r0 = this.a;
        r0.A = true;
        int r1 = r0.r;
        r0.q.removeMessages(r1);
        SingleVideoSeekBarHelper.b r2 = r0.F;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        SeekBarState.Action r3 = SeekBarState.Action.DRAG;
        r0.h.d(r3);
        int r4 = r0.s;
        r0.q.removeMessages(r4);
        LinearLayout r5 = r0.i;
        r5.setAlpha(0.0f);
        r5.setTranslationX(0.0f);
        x54.b.d(r5);
        r5.animate().alpha(1.0f).setDuration(400).setInterpolator((com.bytedance.awemeopen.apps.framework.base.view.seekbar.h) r0.E.getValue());
        r5.animate().start();
        LinearLayout r6 = r0.j;
        if (r6 == null) goto L9;
        x54.b.a(r6);
    L9:
        if (r0.B == false) goto L14;
        m r7 = r0.z;
        if (r7 == null) goto L15;
        com.bytedance.awemeopen.infra.base.player.g r8 = r0.x;
        Intrinsics.checkNotNull(r7);
        r8.f(r7);
        return;
    L15:
        return;
    }

    public h(SingleVideoSeekBarHelper r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
    public final void onProgressChanged(int r8) {
        SingleVideoSeekBarHelper r0 = this.a;
        float r9 = r8;
        r0.h.setProgress(r9 / 100.0f);
        int r1 = j0.a;
        String r10 = j0.a.b((int) ((r9 / 10000.0f) * r0.y));
        r0.k.setText(r10);
        TextView r2 = r0.l;
        if (r2 == null) goto L7;
        r2.setText(r10);
    L7:
        if (r0.B == true) goto L9;
        return;
    L9:
        if (r0.A == false) goto L15;
        long r3 = System.currentTimeMillis();
        if ((r3 - r0.v) <= r0.w) goto L16;
        r0.v = r3;
        r0.q.sendEmptyMessage(r0.t);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
    public final void b(SeekBar r4, boolean r5) {
        SingleVideoSeekBarHelper r6 = this.a;
        r6.A = false;
        SingleVideoSeekBarHelper.b r7 = r6.F;
        if (r7 == null) goto L5;
        r7.b();
    L5:
        SeekBarState.Action r8 = SeekBarState.Action.RELEASE;
        r6.h.d(r8);
        float r9 = r6.f();
        r6.x.seekTo((long) r9);
        r6.q.sendEmptyMessageDelayed(r6.s, r6.u);
        r6.q.sendEmptyMessageDelayed(r6.r, 3000);
        x54.b.a(r6.i);
        LinearLayout r10 = r6.j;
        if (r10 == null) goto L8;
        x54.b.d(r10);
    L8:
        x54.b.a(r6.g);
        if (r6.b.a() == false) goto L12;
        r6.b.playPlayer();
        return;
    }
}
