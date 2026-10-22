package com.bytedance.android.livesdk.ktvimpl.multichorus;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Function0 r3 = this.a;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke();
        L5:
            r1.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Function0 r3 = this.a;
            if (r3 == null) goto L5;
            Unit r4 = (Unit) r3.invoke();
        L5:
            r1.dismiss();
        }
    }

    @JvmStatic
    public static final long c() {
        KtvContext.Companion.getClass();
        long r1 = 0;
        KtvMusic r3 = null;
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L13;
        KtvMusic.a r0 = KtvMusic.Companion;
        MusicPanel r4 = e();
        if (r4 == null) goto L7;
        r3 = r4.a;
    L7:
        i r5 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r5 == null) goto L12;
        Long r6 = r5.e();
        if (r6 == null) goto L12;
        r1 = r6.longValue();
    L12:
        r0.getClass();
        return KtvMusic.a.b(r3, r1);
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r2 == null) goto L16;
        KtvRoomLyricsStateMachineConfig.d r7 = r2.getCurState();
    L18:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L20;
        r7 = null;
    L20:
        KtvRoomLyricsStateMachineConfig.d.f r8 = (KtvRoomLyricsStateMachineConfig.d.f) r7;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r9 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r9 == null) goto L23;
        KtvRoomLyricsStateMachineConfig.d r10 = r9.getCurState();
    L25:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L27;
        r10 = null;
    L27:
        KtvRoomLyricsStateMachineConfig.d.C0041d r11 = (KtvRoomLyricsStateMachineConfig.d.C0041d) r10;
        if (r8 == null) goto L32;
        KtvRoomLyricsStateMachineConfig.c r12 = r8.d;
        if (r12 == null) goto L32;
    L35:
        Long r13 = Long.valueOf(r12.a);
    L37:
        if (r13 == null) goto L39;
        long r14 = r13.longValue();
    L41:
        if (r14 != 0) goto L45;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r15 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r15 == null) goto L56;
        r1 = r15.obtainCurMusicProgress();
    L56:
        KtvMusic.a r16 = KtvMusic.Companion;
        if (r8 == null) goto L64;
        MusicPanel r17 = r8.b;
        if (r17 == null) goto L64;
        KtvMusic r18 = r17.a;
        if (r18 == null) goto L64;
        r3 = r18;
    L68:
        r16.getClass();
        return KtvMusic.a.b(r3, r1);
    L64:
        if (r11 == null) goto L68;
        MusicPanel r19 = r11.b;
        if (r19 == null) goto L68;
        r3 = r19.a;
        goto L68
    L45:
        if (r8 == null) goto L49;
        KtvRoomLyricsStateMachineConfig.c r20 = r8.d;
        if (r20 == null) goto L49;
    L52:
        Long r21 = Long.valueOf(r20.a);
    L54:
        if (r21 == null) goto L56;
        r1 = r21.longValue();
    L49:
        if (r11 == null) goto L53;
        r20 = r11.c;
        if (r20 != null) goto L52;
    L53:
        r21 = null;
        goto L54
    L39:
        r14 = 0;
    L32:
        if (r11 == null) goto L36;
        r12 = r11.c;
        if (r12 != null) goto L35;
    L36:
        r13 = null;
        goto L37
    L23:
        r10 = null;
        goto L25
    L16:
        r7 = null;
        goto L18
    }

    @JvmStatic
    public static final long d() {
        ChorusContext.a r0 = ChorusContext.Companion;
        KtvMusic r2 = null;
        if (r0.c() == false) goto L12;
        KtvMusic.a r1 = KtvMusic.Companion;
        ChorusContext r3 = r0.getContext();
        if (r3 == null) goto L11;
        List<MusicPanel> r4 = r3.getChorusNotSelfSeeingMusicList();
        if (r4 == null) goto L11;
        MusicPanel r5 = (MusicPanel) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L11;
        r2 = r5.a;
    L11:
        r1.getClass();
        long r6 = KtvMusic.a.a(r2);
    L32:
        return r6 * 1000;
    L12:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L27;
        i r7 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r7 == null) goto L19;
        Long r8 = r7.f();
        if (r8 == null) goto L19;
        long r9 = r8.longValue();
    L21:
        if (r9 == 0) goto L27;
        i r10 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r10 == null) goto L33;
        Long r11 = r10.f();
        if (r11 != null) goto L35;
        return 0;
    L35:
        return r11.longValue();
    L33:
        return 0;
    L19:
        r9 = 0;
    L27:
        KtvMusic.a r12 = KtvMusic.Companion;
        MusicPanel r13 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r13 == null) goto L30;
        r2 = r13.a;
    L30:
        r12.getClass();
        r6 = KtvMusic.a.a(r2);
        goto L32
    }

    @JvmStatic
    public static final MusicPanel e() {
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == false) goto L9;
        ChorusContext r1 = r0.getContext();
        if (r1 == null) goto L21;
        List<MusicPanel> r2 = r1.getChorusNotSelfSeeingMusicList();
        if (r2 != null) goto L23;
        return null;
    L23:
        return (MusicPanel) CollectionsKt.firstOrNull(r2);
    L21:
        return null;
    L9:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L20;
        i r3 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r3 == null) goto L14;
        MusicPanel r4 = r3.f;
    L15:
        if (r4 == null) goto L20;
        i r5 = (i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r5 != null) goto L25;
        return null;
    L25:
        return r5.f;
    L14:
        r4 = null;
    L20:
        return com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
    }

    static {
    }

    @JvmStatic
    public static final boolean a(MusicPanel r4) {
        KtvContext.Companion.getClass();
        MusicPanel r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        Long r1 = null;
        if (r0 == null) goto L7;
        KtvMusic r2 = r0.a;
        if (r2 == null) goto L7;
        Long r3 = Long.valueOf(r2.getMId());
    L8:
        if (r3 == null) goto L21;
        if (r4 == null) goto L13;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L13;
        r1 = Long.valueOf(r5.getMId());
    L13:
        if (r1 == null) goto L21;
        MusicPanel r6 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r6 == null) goto L21;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L21;
        if (r7.getMId() != r4.a.getMId()) goto L21;
        return true;
    L21:
        return false;
    L7:
        r3 = null;
        goto L8
    }

    @JvmStatic
    public static final boolean b(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        OrderInfo r0 = r2.d();
        String r1 = null;
        if (r0 == null) goto L7;
        InteractiveSongUserInfo r3 = r0.getTopUser();
        if (r3 == null) goto L7;
        String r4 = r3.getIdString();
    L8:
        if (r4 == null) goto L30;
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L14;
        e r6 = r5.user();
        if (r6 == null) goto L14;
        String r7 = r6.n();
    L15:
        if (r7 == null) goto L30;
        OrderInfo r8 = r2.d();
        if (r8 == null) goto L21;
        InteractiveSongUserInfo r9 = r8.getTopUser();
        if (r9 == null) goto L21;
        String r10 = r9.getIdString();
    L22:
        IMiddlewareUserService r11 = k.f(IMiddlewareUserService.class);
        if (r11 == null) goto L28;
        e r12 = r11.user();
        if (r12 == null) goto L28;
        r1 = r12.n();
    L28:
        if (Intrinsics.areEqual(r10, r1) == false) goto L30;
        return true;
    L21:
        r10 = null;
    L14:
        r7 = null;
    L30:
        return false;
    L7:
        r4 = null;
        goto L8
    }

    public static void g(Context r4, boolean r5, int r6) {
        if ((r6 & 4) == 0) goto L5;
        r5 = false;
    L5:
        MultiChorusContext.a r7 = MultiChorusContext.Companion;
        if (r7.c() == true) goto L8;
        return;
    L8:
        if (MultiChorusContext.a.d() == true) goto L10;
    L12:
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == false) goto L15;
    L17:
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.y;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L60;
        f.d(r2, Boolean.TRUE);
        if (KtvContext.a.d() == false) goto L24;
        String r8 = s1.B(2131918431);
        String r9 = s1.B(2131918432);
    L29:
        Activity r3 = ContextUtil.contextToActivity(r4);
        if (r3 != null) goto L32;
        return;
    L32:
        if (r3.isFinishing() == true) goto L56;
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, "content");
        x0 r10 = null;
        if (r4 == null) goto L43;
        x0.d r11 = new x0.d();
        r11.b = r4;
        r11.a = 4;
        r11.c = r8;
        r11.d = r9;
        r11.k = false;
        r11.l = false;
        r11.m = Float.valueOf(16.0f);
        com.bytedance.android.livesdk.ktvimpl.multichorus.b r12 = new com.bytedance.android.livesdk.ktvimpl.multichorus.b(null);
        CharSequence r13 = r11.b.getText(2131917391);
        x0.c[] r14 = r11.g;
        x0.c r0 = r14[0];
        if (r0 != null) goto L39;
        r0 = new x0.c();
        r14[0] = r0;
    L39:
        r0.a = r13;
        r0.b = r12;
        x0.c[] r15 = r11.g;
        x0.c r16 = r15[0];
        if (r16 != null) goto L42;
        r16 = new x0.c();
        r15[0] = r16;
    L42:
        r16.c = true;
        r10 = new x0(r11.b, r11);
    L43:
        if (r10 != null) goto L45;
        return;
    L45:
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L51;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L51:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L48:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L56:
        return;
    L24:
        if (r7.b() == true) goto L28;
        if (r5 == true) goto L28;
        r8 = "";
        r9 = "";
    L28:
        r8 = s1.B(2131918416);
        r9 = s1.B(2131918430);
        goto L29
    L60:
        return;
    L15:
        if (r7.b() == true) goto L17;
        if (r5 == true) goto L17;
        return;
    L10:
        if (j.i() == false) goto L12;
    }

    @JvmStatic
    public static final x0 f(Context r2, String r3, String r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "content");
        if (r2 != null) goto L6;
        return null;
    L6:
        x0.b r0 = new x0.b(r2, 4);
        x0.d r7 = r0.a;
        r7.c = r3;
        r7.d = r4;
        r7.k = false;
        r7.l = false;
        r0.setCornerRadius(16.0f);
        r0.i(0, 2131915913, new a(r5));
        r0.k(0, true);
        r0.i(1, 2131915442, new b(r6));
        return r0.h();
    }
}
