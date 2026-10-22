package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvMvMidiWidget$initStageViewModel$7 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public KtvMvMidiWidget$initStageViewModel$7(KtvMvMidiWidget r8) {
        super(1, r8, KtvMvMidiWidget.class, "updateLyricProgress", "updateLyricProgress(Ljava/lang/Long;)V", 0);
    }

    public final void invoke(Long r11) {
        KtvMvMidiWidget r0 = (KtvMvMidiWidget) ((CallableReference) this).receiver;
        boolean r1 = r0.g.isCurrentUserIsSinger();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r2 = r0.g.getKtvCoreViewModel();
        KtvMidiStageViewModel r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r2.getValue();
        if (r4 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
        if (r5 == null) goto L9;
        MusicPanel r6 = r5.b();
    L10:
        if (r6 == null) goto L40;
        if (r1 == false) goto L28;
        AbsKtvMidiView r7 = r0.c;
        if (r7 != null) goto L15;
    L21:
        if (r11 == null) goto L28;
        long r8 = r11.longValue();
        KtvMusic r12 = r6.a;
        KtvMusic.Companion.getClass();
        long r9 = KtvMusic.a.a(r12);
        if (r9 <= 0) goto L28;
        AbsKtvMidiView r10 = r0.c;
        if (r10 == null) goto L28;
        r10.U5(r9 * 1000, KtvMusic.a.b(r12, r8));
        goto L28
    L15:
        if (r7.getVisibility() != 0) goto L21;
        KtvMidiStageViewModel r13 = r0.b;
        if ((r13 instanceof KtvMidiStageViewModel) == true) goto L19;
        r13 = null;
    L19:
        if (r13 == null) goto L21;
        r13.tryStartGetScoreInfoTimer(r11);
    L28:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L41;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.b r14 = r0.i;
        if (r14 != null) goto L32;
        return;
    L32:
        if (r14.isFinishDrawLastLine() != true) goto L43;
        KtvMidiStageViewModel r15 = r0.b;
        if ((r15 instanceof KtvMidiStageViewModel) == false) goto L37;
        r3 = r15;
    L37:
        if (r3 == null) goto L44;
        r3.reportScore(r6, "updateLyricProgress");
        return;
    L44:
        return;
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Long) r1);
        return Unit.INSTANCE;
    }
}
