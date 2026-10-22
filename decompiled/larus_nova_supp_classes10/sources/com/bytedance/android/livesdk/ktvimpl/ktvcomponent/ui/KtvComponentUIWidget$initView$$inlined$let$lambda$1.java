package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvComponentUIWidget$initView$$inlined$let$lambda$1 implements jg4.i {
    public final /* synthetic */ KtvComponentUIWidget a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget$initView$$inlined$let$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h {
        public final /* synthetic */ KtvComponentUIWidget$initView$$inlined$let$lambda$1 o;

        public final void d(final jg4.j r8) {
            Intrinsics.checkNotNullParameter(r8, "request");
            UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass2(this, r8), 7);
        }

        public final void h(final jg4.j r7, int r8, String r9) {
            Intrinsics.checkNotNullParameter(r9, "errorMsg");
            if (r8 != 100) goto L6;
            UtilityKotlinExtentionsKt.s(0, false, false, new C00191(this, r7), 7);
            return;
        }

        public AnonymousClass1(KtvComponentUIWidget$initView$$inlined$let$lambda$1 r8, long r9, String r11, String r12, String r13, LyricsDisplayConfig r14) {
            this.o = r8;
            super(r9, r11, r12, r13, r14);
        }
    }

    public KtvComponentUIWidget$initView$$inlined$let$lambda$1(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final jg4.j a(String r11, String r12, String r13, LyricsDisplayConfig r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "savePath");
        Intrinsics.checkNotNullParameter(r13, "fileName");
        Intrinsics.checkNotNullParameter(r14, "config");
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.a.m;
        if (r0 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L9;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L9;
        long r3 = r2.c();
    L10:
        long r4 = r3;
        this.a.getClass();
        List<com.bytedance.component.lyric.model.b> r5 = null;
        if (KtvComponentUIWidget.Iq() == false) goto L24;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r6 = this.a.m;
        if (r6 == null) goto L15;
        KtvRoomLyricsStateMachineConfig.d r7 = r6.getCurState();
    L17:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L19;
        r7 = null;
    L19:
        KtvRoomLyricsStateMachineConfig.d.f r8 = (KtvRoomLyricsStateMachineConfig.d.f) r7;
        if (r8 == null) goto L24;
        KtvRoomLyricsStateMachineConfig.c r9 = r8.d;
        if (r9 == null) goto L24;
        r5 = r9.c;
        goto L24
    L15:
        r7 = null;
    L24:
        kg4.a.b("initRequest:" + r4);
        AnonymousClass1 r10 = new AnonymousClass1(this, r4, r11, r12, r13, r14);
        List<com.bytedance.component.lyric.model.b> r15 = r5;
        if (r15 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == true) goto L33;
        ((jg4.j) r10).c = r5;
    L33:
        return r10;
    L27:
        if (r15.isEmpty() == true) goto L30;
        r16 = false;
    L9:
        r3 = 0;
        goto L10
    }
}
