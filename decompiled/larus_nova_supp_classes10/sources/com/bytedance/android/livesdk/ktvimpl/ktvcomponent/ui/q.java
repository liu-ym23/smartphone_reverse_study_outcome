package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.midi.KtvMidiView;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.component.lyric.LyricComponentImplManager;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ r a;

    public q(r r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        fd2.a.b r12 = (fd2.a) r11;
        KtvComponentUIWidget r0 = this.a.a;
        TokenCert r1 = KtvComponentUIWidget.y1;
        r0.getClass();
        Boolean r2 = null;
        if ((r12 instanceof fd2.a.d) == false) goto L6;
        r0.Pq(null);
        return;
    L6:
        if ((r12 instanceof fd2.a.b) == false) goto L94;
        Long r13 = Long.valueOf(r12.a);
        if (r13 == null) goto L66;
        long r4 = r13.longValue();
        if ((r0.C % ((long) r0.D)) == 0) goto L12;
    L65:
        r0.C++;
        goto L66
    L12:
        if (MidiContext.Companion.d() == true) goto L14;
    L40:
        KtvMidiView r14 = r0.T.k;
        if (r14 == null) goto L65;
        if (r14.getVisibility() != 0) goto L59;
        KtvComponentMidiViewModel r6 = r0.N;
        if (r6 == null) goto L49;
        MutableLiveData<List<cb0.c>> r7 = r6.getMidiData();
        if (r7 == null) goto L49;
        List r8 = (List) r7.getValue();
    L50:
        List r9 = r8;
        if (r9 != null) goto L53;
    L56:
        boolean r10 = true;
    L57:
        if (r10 == true) goto L59;
        boolean r15 = true;
    L60:
        if (r15 == true) goto L63;
        r14 = null;
    L63:
        if (r14 == null) goto L65;
        r14.b(r4);
        goto L65
    L53:
        if (r9.isEmpty() == true) goto L56;
        r10 = false;
    L49:
        r8 = null;
    L59:
        r15 = false;
        goto L60
    L14:
        if (r0.r == true) goto L40;
        ConstraintLayout r16 = r0.T.l;
        if (r16 == null) goto L65;
        if (r16.getVisibility() != 0) goto L34;
        KtvComponentMidiViewModel r17 = r0.N;
        if (r17 == null) goto L24;
        MutableLiveData<List<cb0.c>> r18 = r17.getMidiData();
        if (r18 == null) goto L24;
        List r19 = (List) r18.getValue();
    L25:
        List r20 = r19;
        if (r20 != null) goto L28;
    L31:
        boolean r21 = true;
    L32:
        if (r21 == true) goto L34;
        boolean r22 = true;
    L35:
        if (r22 == true) goto L38;
        r16 = null;
    L38:
        if (r16 == null) goto L65;
        r16.R2(r4);
        goto L65
    L28:
        if (r20.isEmpty() == true) goto L31;
        r21 = false;
    L24:
        r19 = null;
    L34:
        r22 = false;
    L66:
        LyricComponentImplManager r110 = r0.S;
        if (r110 == null) goto L71;
        jg4.j r111 = r110.a;
        if (r111 == null) goto L71;
        r2 = Boolean.valueOf(r111.a());
    L74:
        boolean r112 = Intrinsics.areEqual(r2, Boolean.TRUE);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L91;
        if (r112 == false) goto L91;
        if (r0.J == true) goto L95;
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r113 = KtvContext.a.g().getKtvCoreViewModel();
        if (r113 == null) goto L90;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r114 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r113.getValue();
        if (r114 == null) goto L90;
        KtvRoomLyricsStateMachineConfig.d r115 = r114.getCurState();
        if (r115 == null) goto L90;
        MusicPanel r116 = r115.b();
        if (r116 == null) goto L90;
        KtvComponentMidiViewModel r3 = r0.N;
        if (r3 == null) goto L90;
        r3.reportScore(r116, "KSong handleProgress (singer listner)");
    L90:
        r0.J = true;
        return;
    L95:
        return;
    L91:
        r0.J = false;
        return;
    L71:
        KtvSingAndListenerLyricViewV2 r117 = r0.T.b;
        if (r117 == null) goto L74;
        r2 = Boolean.valueOf(r117.isFinishDrawLastLine());
        goto L74
    }
}
