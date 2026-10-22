package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvOpusMidiWidget$initStageViewModel$7 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public KtvOpusMidiWidget$initStageViewModel$7(KtvOpusMidiWidget r8) {
        super(1, r8, KtvOpusMidiWidget.class, "updateLyricProgress", "updateLyricProgress(Ljava/lang/Long;)V", 0);
    }

    public final void invoke(Long r6) {
        KtvOpusMidiWidget r0 = (KtvOpusMidiWidget) ((CallableReference) this).receiver;
        boolean r1 = r0.l.isCurrentUserIsSinger();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r2 = r0.l.getKtvCoreViewModel();
        KtvMidiStageViewModel r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r2.getValue();
        if (r4 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
        if (r5 == null) goto L9;
        MusicPanel r7 = r5.b();
    L10:
        if (r7 == null) goto L39;
        if (r1 == false) goto L24;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r8 = r0.c;
        if (r8 == null) goto L24;
        View r9 = r8.asView();
        if (r9 == null) goto L24;
        if (r9.getVisibility() != 0) goto L24;
        KtvMidiStageViewModel r10 = r0.b;
        if ((r10 instanceof KtvMidiStageViewModel) == true) goto L21;
        r10 = null;
    L21:
        if (r10 == null) goto L24;
        r10.tryStartGetScoreInfoTimer(r6);
    L24:
        if (KtvSettingHelper.z() == false) goto L26;
        boolean r11 = r0.i;
    L27:
        if (r11 == false) goto L40;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.b r12 = r0.n;
        if (r12 != null) goto L31;
        return;
    L31:
        if (r12.isFinishDrawLastLine() != true) goto L42;
        KtvMidiStageViewModel r13 = r0.b;
        if ((r13 instanceof KtvMidiStageViewModel) == false) goto L36;
        r3 = r13;
    L36:
        if (r3 == null) goto L43;
        r3.reportScore(r7, "updateLyricProgress");
        return;
    L43:
        return;
    L42:
        return;
    L40:
        return;
    L26:
        r11 = com.bytedance.android.live.ktv.common.util.j.i();
        goto L27
    L39:
        return;
    L9:
        r7 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Long) r1);
        return Unit.INSTANCE;
    }
}
