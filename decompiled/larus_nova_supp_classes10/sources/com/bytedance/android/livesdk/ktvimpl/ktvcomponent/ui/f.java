package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public final /* synthetic */ KtvComponentUIWidget a;

    public f(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void a() {
        KtvComponentUIWidget r0 = this.a;
        TokenCert r1 = KtvComponentUIWidget.y1;
        r0.tr();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = this.a.m;
        jg4.j r3 = null;
        if (r2 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r4 = r2.getCurState();
    L7:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L14;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r5 = this.a.m;
        if (r5 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r6 = r5.getCurState();
    L13:
        if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L14;
        return;
    L11:
        r6 = null;
    L14:
        ChorusContext.a r7 = ChorusContext.Companion;
        if (r7.c() == false) goto L24;
        ChorusContext r8 = r7.getContext();
        if (r8 == null) goto L23;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r9 = r8.getChorusSelectedSongList();
        if (r9 == null) goto L23;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L23;
        MusicPanel r11 = (MusicPanel) CollectionsKt.firstOrNull(r10);
    L25:
        if (r11 == null) goto L41;
        long r12 = r11.c();
        LyricComponentImplManager r13 = this.a.S;
        if (r13 == null) goto L29;
        jg4.j r14 = r13.a;
    L31:
        if ((r14 instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h) == false) goto L34;
        r3 = r14;
    L34:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h r15 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h) r3;
        if (r15 != null) goto L37;
    L38:
        this.a.Jq(r11);
        return;
    L37:
        if (r15.n != r12) goto L38;
        return;
    L29:
        r14 = null;
        goto L31
    L41:
        return;
    L23:
        r11 = null;
        goto L25
    L24:
        r11 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.a.R);
        goto L25
    L5:
        r4 = null;
        goto L7
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
