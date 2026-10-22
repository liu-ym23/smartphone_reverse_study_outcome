package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvEchoChecker {
    public static boolean a;
    public static boolean b;

    public static final class a implements DialogInterface.OnDismissListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            boolean r2 = KtvEchoChecker.a;
            KtvEchoChecker.a = false;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            boolean r2 = KtvEchoChecker.a;
            KtvEchoChecker.a = false;
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            boolean r2 = KtvEchoChecker.a;
            KtvEchoChecker.a = false;
        }
    }

    static {
    }

    public static void a(com.bytedance.android.livesdk.ktvimpl.base.view.a r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    /* JADX WARN: Type inference failed for: r6v12, types: [android.app.Dialog, com.bytedance.android.livesdk.ktvimpl.base.view.a] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.app.Dialog, com.bytedance.android.livesdk.ktvimpl.base.view.a] */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.app.Dialog, com.bytedance.android.livesdk.ktvimpl.base.view.a] */
    public static void b(Context r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (a == false) goto L6;
        return;
    L6:
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L12;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L12;
        if (r1.isMergeVSRoom() != true) goto L12;
    L22:
        com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r2 == null) goto L29;
        com.bytedance.live.datacontext.m r3 = r2.R2();
        if (r3 == null) goto L29;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L29;
        boolean r5 = r4.booleanValue();
    L30:
        Object r7 = r6.getSystemService("usb");
        if ((r7 instanceof UsbManager) == true) goto L33;
        r7 = null;
    L33:
        UsbManager r8 = (UsbManager) r7;
        if (r8 == null) goto L40;
        HashMap<String, UsbDevice> r9 = r8.getDeviceList();
        if (r9 == null) goto L40;
        if (r9.isEmpty() == true) goto L40;
        boolean r10 = true;
    L41:
        if (r5 == true) goto L44;
        if (r10 == true) goto L44;
        return;
    L44:
        b = false;
        if (((Boolean) vm2.h.M0.getValue(null, vm2.h.a[89])).booleanValue() == false) goto L81;
        a = true;
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L64;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L64;
        if (r12.isMergeVSRoom() != true) goto L64;
        ConcertStageDataContext r13 = ConcertStageDataContext.Companion.getContext();
        if (r13 == null) goto L74;
        com.bytedance.live.datacontext.j<gd2.f> r14 = r13.getService();
        if (r14 == null) goto L75;
        gd2.f r15 = (gd2.f) r14.getValue();
        if (r15 == null) goto L76;
        final gd2.d r16 = r15.getConcertEarMonitor();
        if (r16 == null) goto L77;
        com.bytedance.android.livesdk.ktvimpl.base.view.a.C0013a r17 = new com.bytedance.android.livesdk.ktvimpl.base.view.a.C0013a(r6);
        r17.b(2131918361, new KtvEchoChecker$check$1$1(r16));
        r17.b(2131918362, new KtvEchoChecker$check$1$2(r16));
        r17.a(KtvEchoChecker$check$1$3.INSTANCE);
        ?? r18 = new com.bytedance.android.livesdk.ktvimpl.base.view.a(r17.b, r17.a);
        r18.setOnDismissListener(b.a);
        a(r18);
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L64:
        if (jc0.a.c() == false) goto L72;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r19 = VideoChorusDataContext.Companion.a();
        if (r19 == null) goto L78;
        final KtvEarMonitor r20 = r19.g();
        if (r20 == null) goto L79;
        com.bytedance.android.livesdk.ktvimpl.base.view.a.C0013a r21 = new com.bytedance.android.livesdk.ktvimpl.base.view.a.C0013a(r6);
        r21.b(2131918361, new KtvEchoChecker$check$1$5(r20));
        r21.b(2131918362, new KtvEchoChecker$check$1$6(r20));
        r21.a(KtvEchoChecker$check$1$7.INSTANCE);
        ?? r22 = new com.bytedance.android.livesdk.ktvimpl.base.view.a(r21.b, r21.a);
        r22.setOnDismissListener(c.a);
        a(r22);
        return;
    L79:
        return;
    L78:
        return;
    L72:
        final com.bytedance.android.live.ktv.common.tuningpanel.ability.a r23 = KSongTuningPanelHelperKt.d();
        com.bytedance.android.livesdk.ktvimpl.base.view.a.C0013a r24 = new com.bytedance.android.livesdk.ktvimpl.base.view.a.C0013a(r6);
        r24.b(2131918361, new KtvEchoChecker$check$1$9(r23));
        r24.b(2131918362, new KtvEchoChecker$check$1$10(r23));
        r24.a(KtvEchoChecker$check$1$11.INSTANCE);
        ?? r25 = new com.bytedance.android.livesdk.ktvimpl.base.view.a(r24.b, r24.a);
        r25.setOnDismissListener(a.a);
        a(r25);
        return;
    L81:
        return;
    L40:
        r10 = false;
    L29:
        r5 = false;
    L12:
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(8) == true) goto L22;
        if (KtvContext.a.c(32) == true) goto L22;
        if (KtvContext.a.c(1) == true) goto L22;
        if (jc0.a.c() == true) goto L22;
        b = true;
    }
}
