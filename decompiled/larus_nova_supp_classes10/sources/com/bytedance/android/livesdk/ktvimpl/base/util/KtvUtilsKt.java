package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.PermissionType;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdk.message.model.ej;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvUtilsKt {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            View r0 = this.a;
            Resources r2 = s1.getResources();
            r0.setBackground(new BitmapDrawable(r2, (Bitmap) r4));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Function0 c;

        public c(Ref.BooleanRef r1, Function0 r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            if (this.a.element == true) goto L6;
            this.c.invoke();
            return;
        }
    }

    public static final boolean d() {
        return jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
    }

    public static final boolean f() {
        int r0 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (r0 != 4) goto L5;
    L16:
        return true;
    L5:
        if (r0 == 5) goto L16;
        if (r0 == 8) goto L16;
        if (r0 == 9) goto L16;
        if (r0 == 12) goto L16;
        if (r0 == 16) goto L16;
        return false;
    }

    public static final boolean e() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r0 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = r1.t();
        if (r2 == null) goto L21;
        if (r2.a != 9) goto L21;
        u r3 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r3 == null) goto L21;
        com.bytedance.live.datacontext.j r4 = r3.s();
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L21;
        if (r6.b != 61) goto L21;
        return true;
    L21:
        return false;
    }

    public static final boolean g() {
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j r1 = r0.s();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L13;
        if (r3.a != 9) goto L13;
        return true;
    L13:
        return false;
    }

    public static final String c(MusicPanel r2) {
        if (r2 == null) goto L6;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L6;
        long r0 = r3.getMId();
    L8:
        return String.valueOf(r0);
    L6:
        r0 = 0;
        goto L8
    }

    public static final boolean h(MusicPanel r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r2) == true) goto L8;
        return false;
    L8:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r2) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean a(MusicPanel r3, boolean r4) {
        if (r4 == false) goto L8;
        if (r3 != null) goto L6;
    L12:
        boolean r5 = false;
    L13:
        if (r3 != null) goto L15;
    L59:
        return r5;
    L15:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.E(r3) != true) goto L59;
        if (jc0.a.c() == false) goto L26;
        Integer r6 = (Integer) com.bytedance.android.livesdk.sharedpref.c.h.getValue();
        if (r6 != null) goto L22;
        return false;
    L22:
        if (r6.intValue() != 1) goto L60;
        if (r5 == false) goto L61;
        return true;
    L61:
        return false;
    L60:
        return false;
    L26:
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == true) goto L29;
        KtvComponentContext r7 = KtvComponentContext.Companion.getContext();
        if (r7 == null) goto L53;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r8 = r7.getKtvComponentUIContext();
        if (r8 == null) goto L53;
        KtvComponentUIContext r9 = (KtvComponentUIContext) r8.getValue();
        if (r9 == null) goto L53;
        MutableLiveData<Boolean> r10 = r9.getOriginOpen();
        if (r10 == null) goto L53;
        Boolean r11 = (Boolean) r10.getValue();
    L55:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L67;
        if (r5 == false) goto L68;
    L57:
        return true;
    L68:
        return false;
    L67:
        return false;
    L53:
        r11 = null;
        goto L55
    L29:
        if (jc0.a.a() == false) goto L37;
        Integer r12 = (Integer) com.bytedance.android.livesdk.sharedpref.c.g.getValue();
        if (r12 != null) goto L34;
        return false;
    L34:
        if (r12.intValue() != 1) goto L63;
        if (r5 == true) goto L57;
        return false;
    L63:
        return false;
    L37:
        Integer r13 = (Integer) com.bytedance.android.livesdk.sharedpref.c.f.getValue();
        if (r13 != null) goto L41;
        return false;
    L41:
        if (r13.intValue() != 1) goto L65;
        if (r5 == true) goto L57;
        return false;
    L65:
        return false;
    L6:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.G(r3) != true) goto L12;
    L11:
        r5 = true;
        goto L13
    L8:
        if (r3 == null) goto L12;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.F(r3) != true) goto L12;
        goto L11
    }

    public static /* synthetic */ boolean b(boolean r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        KtvContext.Companion.getClass();
        MusicPanel r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
    L7:
        if ((r2 & 2) == 0) goto L10;
        r1 = false;
    L10:
        return a(r0, r1);
    L5:
        r0 = null;
        goto L7
    }

    public static final void i(View r1, py.k r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        ((ObservableSubscribeProxy) a1.k(r2).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r1))).subscribe(new a(r1), b.a);
        return;
    L8:
        return;
    }

    public static final void l(boolean r3, boolean r4) {
        ALogger.i("KtvUtils", "updateKtvAllStateValue " + r3 + " ;; " + r4 + ' ');
        if (r3 == false) goto L5;
        KtvContext.Companion.getClass();
        KtvContext.a.n(1);
        KtvContext.a.a(8);
    L6:
        if (r4 == false) goto L8;
        KtvContext.Companion.getClass();
        KtvContext.a.n(1);
        KtvContext.a.n(8);
        KtvContext.a.a(32);
        return;
    L8:
        KtvContext.Companion.getClass();
        KtvContext.a.n(32);
        return;
    L5:
        KtvContext.Companion.getClass();
        KtvContext.a.n(8);
        goto L6
    }

    public static void j(Context r6, String r7, Function0 r8, Function0 r9) {
        String r0 = s1.B(2131915442);
        String r1 = s1.B(2131915913);
        Intrinsics.checkNotNullParameter(r7, "content");
        Intrinsics.checkNotNullParameter(r0, "cancelText");
        Intrinsics.checkNotNullParameter(r1, "confirmText");
        Intrinsics.checkNotNullParameter("", "clickType");
        Intrinsics.checkNotNullParameter(r9, "confirmFunc");
        if (r6 != null) goto L5;
        com.bytedance.android.live.ktv.common.util.g.b("openDialog error,context is null");
        return;
    L5:
        Activity r10 = ContextUtil.contextToActivity(r6);
        if (r10 != null) goto L8;
    L17:
        com.bytedance.android.live.ktv.common.util.g.b("openDialog error,activity is null or isFinishing");
        return;
    L8:
        if (r10.isFinishing() == true) goto L17;
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.element = false;
        x0.d r4 = new x0.d();
        r4.b = r10;
        r4.a = 4;
        r4.k = true;
        r4.l = true;
        r4.d = r7;
        l r11 = new l(r2, r9);
        x0.c[] r12 = r4.g;
        x0.c r5 = r12[0];
        if (r5 != null) goto L13;
        r5 = new x0.c();
        r12[0] = r5;
    L13:
        r5.a = r1;
        r5.b = r11;
        r4.i = new m(r2, r8);
        n r13 = new n(r2, r8);
        x0.c[] r14 = r4.g;
        x0.c r15 = r14[1];
        if (r15 != null) goto L16;
        r15 = new x0.c();
        r14[1] = r15;
    L16:
        r15.a = r0;
        r15.b = r13;
        x0.b.g(new x0(r4.b, r4));
    }

    public static final void k(final RTChorusOperateType r24, final Integer r25, final ej r26, final Function0<Unit> r27, final Function0<Unit> r28) {
        Intrinsics.checkNotNullParameter(r24, "operateType");
        Intrinsics.checkNotNullParameter(r27, "cancelCallback");
        Intrinsics.checkNotNullParameter(r28, "confirmCallback");
        IMiddlewareHostApp r0 = jc1.k.f(IMiddlewareHostApp.class);
        if (r0 == null) goto L208;
        Activity r11 = r0.getTopActivity();
        if (r11 == null) goto L209;
        View r12 = LayoutInflater.from(r11).inflate(2131566531, null);
        if (r12 == null) goto L9;
        TextView r1 = (TextView) r12.findViewById(2131388772);
    L10:
        if (r12 == null) goto L12;
        TextView r2 = (TextView) r12.findViewById(2131367794);
    L13:
        if (r12 == null) goto L15;
        LinearLayout r13 = (LinearLayout) r12.findViewById(2131367647);
    L16:
        if (r12 == null) goto L18;
        TextView r3 = (TextView) r12.findViewById(2131387212);
    L19:
        if (r12 == null) goto L21;
        HSImageView r4 = (HSImageView) r12.findViewById(2131373724);
    L22:
        if (r12 == null) goto L24;
        TextView r5 = (TextView) r12.findViewById(2131373774);
    L25:
        if (r12 == null) goto L27;
        TextView r6 = (TextView) r12.findViewById(2131371627);
    L28:
        if (r12 == null) goto L30;
        TextView r14 = (TextView) r12.findViewById(2131365123);
    L31:
        long r18 = 0;
        String r21 = "";
        if (r24 != RTChorusOperateType.JOIN_CHORUS) goto L113;
        int r7 = PermissionType.FansClub.getValue();
        if (r25 != null) goto L37;
    L53:
        int r8 = PermissionType.Subscribe.getValue();
        if (r25 != null) goto L57;
    L73:
        int r9 = PermissionType.SendAssignGift.getValue();
        if (r25 != null) goto L77;
    L193:
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = null;
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = false;
        if (r13 == null) goto L196;
        int r16 = 0;
        r13.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new KtvUtilsKt$openRTChorusDialog$$inlined$let$lambda$1(r10, r15, r24, r25, r26, r28, r27)));
    L197:
        if (r14 == null) goto L199;
        r14.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new KtvUtilsKt$openRTChorusDialog$$inlined$let$lambda$2(r10, r15, r24, r25, r26, r28, r27)));
    L199:
        x0.d r17 = new x0.d();
        r17.b = r11;
        r17.a = r16;
        r17.e = r12;
        x0 r19 = new x0(r17.b, r17);
        r15.element = r19;
        r19.setOnDismissListener(new c(r10, r28, r27));
        Dialog r20 = (Dialog) r15.element;
        if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L206;
        DialogLancet.handleBlockedDialogShow(r20);
        return;
    L206:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L205
    L203:
        DialogLancet.beforeDialogShow(r20);
        r20.show();
        DialogLancet.afterDialogShow(r20);
        return;
    L196:
        r16 = 0;
        goto L197
    L77:
        if (r25.intValue() != r9) goto L193;
        if (r1 == null) goto L80;
        r1.setText(s1.B(2131918591));
    L80:
        if (r2 == null) goto L93;
        Object[] r22 = new Object[3];
        if (r26 == null) goto L85;
        String r23 = r26.c();
        if (r23 == null) goto L85;
    L86:
        r22[0] = r23;
        if (r26 == null) goto L91;
        Long r29 = r26.a();
        if (r29 == null) goto L91;
        long r110 = r29.longValue();
    L92:
        r22[1] = Long.valueOf(r110);
        r22[2] = r3.c();
        r2.setText(s1.C(2131918583, r22));
    L91:
        r110 = 0;
    L85:
        r23 = "";
    L93:
        if (r3 == null) goto L95;
        r3.setText(s1.B(2131918589));
    L95:
        if (r26 == null) goto L100;
        String r30 = r26.d();
        if (r30 == null) goto L100;
        r21 = r30;
    L100:
        a1.o(r4, ImageModel.genBy(r21), ImageView.ScaleType.FIT_XY);
        if (r5 == null) goto L108;
        Object[] r31 = new Object[2];
        if (r26 == null) goto L107;
        Long r32 = r26.a();
        if (r32 == null) goto L107;
        r18 = r32.longValue();
    L107:
        r31[0] = Long.valueOf(r18);
        r31[1] = r3.c();
        r5.setText(s1.C(2131918587, r31));
    L108:
        if (r6 == null) goto L110;
        r6.setText(s1.B(2131918585));
    L110:
        if (r14 == null) goto L193;
        r14.setText(s1.B(2131915442));
        goto L193
    L57:
        if (r25.intValue() != r8) goto L73;
        if (r1 == null) goto L60;
        UtilityKotlinExtentionsKt.t(r1);
    L60:
        UIUtils.updateLayoutMargin(r12, -3, s1.f(4.0f), -3, -3);
        if (r2 == null) goto L63;
        r2.setText(s1.B(2131918470));
    L63:
        if (r3 == null) goto L65;
        r3.setText(s1.B(2131918472));
    L65:
        if (r4 == null) goto L67;
        UtilityKotlinExtentionsKt.t(r4);
    L67:
        if (r5 == null) goto L69;
        UtilityKotlinExtentionsKt.t(r5);
    L69:
        if (r6 == null) goto L71;
        UtilityKotlinExtentionsKt.t(r6);
    L71:
        if (r14 == null) goto L193;
        r14.setText(s1.B(2131915442));
        goto L193
    L37:
        if (r25.intValue() != r7) goto L53;
        if (r1 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r1);
    L40:
        UIUtils.updateLayoutMargin(r12, -3, s1.f(4.0f), -3, -3);
        if (r2 == null) goto L43;
        r2.setText(s1.B(2131918467));
    L43:
        if (r3 == null) goto L45;
        r3.setText(s1.B(2131918469));
    L45:
        if (r4 == null) goto L47;
        UtilityKotlinExtentionsKt.t(r4);
    L47:
        if (r5 == null) goto L49;
        UtilityKotlinExtentionsKt.t(r5);
    L49:
        if (r6 == null) goto L51;
        UtilityKotlinExtentionsKt.t(r6);
    L51:
        if (r14 == null) goto L193;
        r14.setText(s1.B(2131915442));
        goto L193
    L113:
        if (r24 != RTChorusOperateType.ORDER_SONG) goto L193;
        int r33 = PermissionType.FansClub.getValue();
        if (r25 != null) goto L118;
    L134:
        int r34 = PermissionType.Subscribe.getValue();
        if (r25 != null) goto L138;
    L154:
        int r35 = PermissionType.SendAssignGift.getValue();
        if (r25 == null) goto L193;
        if (r25.intValue() != r35) goto L193;
        if (r1 == null) goto L161;
        r1.setText(s1.B(2131918592));
    L161:
        if (r2 == null) goto L174;
        Object[] r36 = new Object[3];
        if (r26 == null) goto L166;
        String r37 = r26.c();
        if (r37 == null) goto L166;
    L167:
        r36[0] = r37;
        if (r26 == null) goto L172;
        Long r38 = r26.a();
        if (r38 == null) goto L172;
        long r111 = r38.longValue();
    L173:
        r36[1] = Long.valueOf(r111);
        r36[2] = r3.c();
        r2.setText(s1.C(2131918584, r36));
    L172:
        r111 = 0;
    L166:
        r37 = "";
    L174:
        if (r3 == null) goto L176;
        r3.setText(s1.B(2131918590));
    L176:
        if (r26 == null) goto L181;
        String r39 = r26.d();
        if (r39 == null) goto L181;
        r21 = r39;
    L181:
        a1.o(r4, ImageModel.genBy(r21), ImageView.ScaleType.FIT_XY);
        if (r5 == null) goto L189;
        Object[] r40 = new Object[2];
        if (r26 == null) goto L188;
        Long r41 = r26.a();
        if (r41 == null) goto L188;
        r18 = r41.longValue();
    L188:
        r40[0] = Long.valueOf(r18);
        r40[1] = r3.c();
        r5.setText(s1.C(2131918588, r40));
    L189:
        if (r6 == null) goto L191;
        r6.setText(s1.B(2131918586));
    L191:
        if (r14 == null) goto L193;
        r14.setText(s1.B(2131915442));
        goto L193
    L138:
        if (r25.intValue() != r34) goto L154;
        if (r1 == null) goto L141;
        UtilityKotlinExtentionsKt.t(r1);
    L141:
        UIUtils.updateLayoutMargin(r12, -3, s1.f(4.0f), -3, -3);
        if (r2 == null) goto L144;
        r2.setText(s1.B(2131918471));
    L144:
        if (r3 == null) goto L146;
        r3.setText(s1.B(2131918472));
    L146:
        if (r4 == null) goto L148;
        UtilityKotlinExtentionsKt.t(r4);
    L148:
        if (r5 == null) goto L150;
        UtilityKotlinExtentionsKt.t(r5);
    L150:
        if (r6 == null) goto L152;
        UtilityKotlinExtentionsKt.t(r6);
    L152:
        if (r14 == null) goto L193;
        r14.setText(s1.B(2131915442));
        goto L193
    L118:
        if (r25.intValue() != r33) goto L134;
        if (r1 == null) goto L121;
        UtilityKotlinExtentionsKt.t(r1);
    L121:
        UIUtils.updateLayoutMargin(r12, -3, s1.f(4.0f), -3, -3);
        if (r2 == null) goto L124;
        r2.setText(s1.B(2131918468));
    L124:
        if (r3 == null) goto L126;
        r3.setText(s1.B(2131918469));
    L126:
        if (r4 == null) goto L128;
        UtilityKotlinExtentionsKt.t(r4);
    L128:
        if (r5 == null) goto L130;
        UtilityKotlinExtentionsKt.t(r5);
    L130:
        if (r6 == null) goto L132;
        UtilityKotlinExtentionsKt.t(r6);
    L132:
        if (r14 == null) goto L193;
        r14.setText(s1.B(2131915442));
        goto L193
    L30:
        r14 = null;
        goto L31
    L27:
        r6 = null;
        goto L28
    L24:
        r5 = null;
        goto L25
    L21:
        r4 = null;
        goto L22
    L18:
        r3 = null;
        goto L19
    L15:
        r13 = null;
        goto L16
    L12:
        r2 = null;
        goto L13
    L9:
        r1 = null;
        goto L10
    L209:
        return;
    }
}
