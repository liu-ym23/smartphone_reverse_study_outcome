package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Runnable {
    public final /* synthetic */ TtsViewModel.e a;

    public i(TtsViewModel.e r1) {
        this.a = r1;
    }

    public final void a() {
        TtsViewModel.e r1 = this.a;
        TtsViewModel r2 = r1.d;
        IPlayer r3 = r2.z;
        if (r3 != null) goto L6;
        tt5.a.d("TtsViewModel", r2.d + " ProgressTimer-checkProgress, player is null.");
        return;
    L6:
        if (r3.getPlaybackState() == 4) goto L8;
        tt5.a.d("TtsViewModel", r1.d.d + " ProgressTimer-checkProgress, player not playing, state: " + r3.getPlaybackState());
        return;
    L8:
        long r6 = 0;
        long r4 = RangesKt.coerceAtLeast(r3.getCurrentPosition(), 0);
        TtsViewModel r8 = r1.d;
        if (r4 == r1.c) goto L11;
    L12:
        r1.c = r4;
        TtsM3U8Bean r9 = r8.u.c;
        if (r9 == null) goto L15;
        long r10 = r9.segmentFirstOffsetMs;
    L16:
        long r5 = r4 + r10;
        Long r11 = (Long) r8.o.getValue();
        if (r11 == null) goto L19;
        r6 = r11.longValue();
    L19:
        long r7 = RangesKt.coerceIn(r5, 0, r6);
        so5.a r12 = r8.x.d;
        if (r12 == null) goto L22;
        r12.j = r5;
    L22:
        r8.l.setValue(Long.valueOf(r7));
        r8.m.setValue(r8.u.a(r7));
    L23:
        IPlayer r13 = r1.d.z;
        if (r13 != null) goto L26;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == false) goto L31;
        com.bytedance.ee.util.ui.j.d(r1.b, 500);
        return;
    L31:
        StringBuilder r15 = new StringBuilder();
        r15.append(r1.d.d);
        r15.append(" ProgressTimer-startTimer, player not playing, state: ");
        IPlayer r16 = r1.d.z;
        if (r16 == null) goto L34;
        Integer r17 = Integer.valueOf(r16.getPlaybackState());
    L35:
        r15.append(r17);
        tt5.a.d("TtsViewModel", r15.toString());
        return;
    L34:
        r17 = null;
        goto L35
    L26:
        if (r13.getPlaybackState() != 4) goto L28;
        r14 = true;
        goto L29
    L15:
        r10 = 0;
        goto L16
    L11:
        if (r1.a == true) goto L23;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
