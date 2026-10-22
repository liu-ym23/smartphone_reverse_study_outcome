package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.component.lyric.LyricComponentImplManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvComponentUIWidget$initViewModel$6$2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public KtvComponentUIWidget$initViewModel$6$2(KtvComponentUIWidget r8) {
        super(1, r8, KtvComponentUIWidget.class, "handleLyricsProgress", "handleLyricsProgress(J)V", 0);
    }

    public final void invoke(long r3) {
        KtvComponentUIWidget r4 = (KtvComponentUIWidget) ((CallableReference) this).receiver;
        LyricComponentImplManager r5 = r4.S;
        if (r5 == null) goto L7;
        jg4.j r6 = r5.a;
        if (r6 == null) goto L7;
        Boolean r7 = Boolean.valueOf(r6.a());
    L12:
        if (r7 == null) goto L14;
        boolean r8 = r7.booleanValue();
    L16:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L32;
        if (r8 == false) goto L32;
        if (r4.J == true) goto L34;
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r9 = KtvContext.a.g().getKtvCoreViewModel();
        if (r9 == null) goto L31;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r10 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r9.getValue();
        if (r10 == null) goto L31;
        KtvRoomLyricsStateMachineConfig.d r11 = r10.getCurState();
        if (r11 == null) goto L31;
        MusicPanel r12 = r11.b();
        if (r12 == null) goto L31;
        KtvComponentMidiViewModel r0 = r4.N;
        if (r0 == null) goto L31;
        r0.reportScore(r12, "KSong handleLyricsProgress (non-singer listner)");
    L31:
        r4.J = true;
        return;
    L34:
        return;
    L32:
        r4.J = false;
        return;
    L14:
        r8 = false;
    L7:
        KtvSingAndListenerLyricViewV2 r13 = r4.T.b;
        if (r13 == null) goto L10;
        r7 = Boolean.valueOf(r13.isFinishDrawLastLine());
        goto L12
    L10:
        r7 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3) {
        invoke(((Number) r3).longValue());
        return Unit.INSTANCE;
    }
}
