package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomChallengeViewWrapper implements com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b {
    public View a;
    public KtvRoomChallengeProgressView b;
    public View c;
    public Function1<? super Boolean, Unit> d;
    public final Context e;
    public final KtvRoomViewModel f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a
    public final void onDestroy() {
        this.d = null;
        KtvChallengeDataContext.a r0 = KtvChallengeDataContext.Companion;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r1 = r0.a();
        if (r1 == null) goto L9;
        r1.removeKtvChallengeStatusChangedListener(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a
    public final boolean d() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isKtvChallengeOpen() != true) goto L7;
        return true;
    }

    public final String l() {
        KtvRoomViewModel r0 = this.f;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = KtvRoomViewModel.getCurSingerName$default(r0, null, 1, null);
    L7:
        if (r2 == null) goto L9;
        int r3 = r2.length();
    L11:
        if (r3 <= 5) goto L18;
        StringBuilder r4 = new StringBuilder();
        if (r2 == null) goto L16;
        r1 = r2.substring(0, 5);
    L16:
        r4.append(r1);
        r4.append("...");
        return r4.toString();
    L18:
        return r2;
    L9:
        r3 = 0;
        goto L11
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void b(int r2) {
        KtvRoomChallengeProgressView r0 = this.b;
        if (r0 == null) goto L6;
        r0.S5(r2);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a
    public final void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r10.c;
        int r2 = 8;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L7;
    L82:
        ConstraintLayout r11 = this.b;
        if (r11 == null) goto L88;
        r11.setVisibility(8);
        return;
    L88:
        return;
    L7:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L82;
        MusicPanel r1 = r0.b();
        me2.a r3 = null;
        if (r1 == null) goto L12;
        KtvMusic r4 = r1.a;
    L13:
        ConstraintLayout r5 = this.b;
        int r6 = 0;
        if (r5 != null) goto L16;
    L21:
        KtvRoomChallengeProgressView r7 = this.b;
        if (r7 == null) goto L30;
        KtvChallengeDataContext.a r8 = KtvChallengeDataContext.Companion;
        if (r8 == null) goto L28;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r9 = r8.a();
        if (r9 == null) goto L28;
        int r12 = r9.challengeTargetValue();
    L29:
        r7.setProgressBarRange(r12);
    L28:
        r12 = 0;
    L30:
        KtvRoomChallengeProgressView r13 = this.b;
        if (r13 == null) goto L43;
        KtvChallengeDataContext.a r14 = KtvChallengeDataContext.Companion;
        if (r14 == null) goto L37;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r15 = r14.a();
        if (r15 == null) goto L37;
        me2.a r16 = r15.getChallengeConfig();
    L38:
        if (r16 == null) goto L40;
        int r17 = r16.f;
    L41:
        r13.setChallengeTypeText(r17);
        goto L43
    L40:
        r17 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
    L37:
        r16 = null;
    L43:
        if ((r10.c instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L67;
        KtvRoomChallengeProgressView r18 = this.b;
        if (r18 == null) goto L47;
        r18.S5(0);
    L47:
        KtvMusic.Companion.getClass();
        long r19 = KtvMusic.a.a(r4);
        KtvRoomChallengeProgressView r110 = this.b;
        if (r110 == null) goto L75;
        Long r20 = Long.valueOf(r19);
        KtvChallengeDataContext.a r21 = KtvChallengeDataContext.Companion;
        if (r21 == null) goto L54;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r22 = r21.a();
        if (r22 == null) goto L54;
        r3 = r22.getChallengeConfig();
    L54:
        long r23 = 90;
        if (r3 == null) goto L57;
        long r24 = r3.d;
    L59:
        if (r24 <= 0) goto L62;
        r23 = r24;
    L62:
        if (r20 != null) goto L64;
    L66:
        r110.R5(r23);
        goto L75
    L64:
        if (r20.longValue() >= r23) goto L66;
        r23 = r20.longValue();
        goto L66
    L57:
        r24 = 90;
    L75:
        KtvRoomChallengeProgressView r111 = this.b;
        if (r111 == null) goto L86;
        if (r4 == null) goto L80;
        String r25 = r4.getTitle();
        if (r25 == null) goto L80;
    L81:
        String r26 = k(r25);
        j.l.getClass();
        r111.T5(r26, j.d(r4));
        return;
    L80:
        r25 = "";
        goto L81
    L86:
        return;
    L67:
        KtvRoomChallengeProgressView r112 = this.b;
        if (r112 == null) goto L75;
        KtvChallengeDataContext.a r27 = KtvChallengeDataContext.Companion;
        if (r27 == null) goto L74;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r28 = r27.a();
        if (r28 == null) goto L74;
        r6 = r28.currentScoreValue();
    L74:
        r112.S5(r6);
        goto L75
    L16:
        if (d() == true) goto L18;
    L20:
        r5.setVisibility(r2);
        goto L21
    L18:
        if (ne2.a.f(r4) == false) goto L20;
        r2 = 0;
        goto L20
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a
    public final void h(UserAttr r2) {
        if (r2 != null) goto L4;
    L9:
        View r3 = this.a;
        if (r3 == null) goto L12;
        r3.setVisibility(8);
    L12:
        View r4 = this.c;
        if (r4 != null) goto L15;
    L19:
        m(d());
        return;
    L15:
        if (r4.getVisibility() != 0) goto L19;
        View r5 = this.c;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
        goto L19
    L4:
        if (r2.isAdmin() != true) goto L9;
        View r6 = this.a;
        if (r6 == null) goto L8;
        r6.setVisibility(0);
    L8:
        Long r7 = KtvLoggerHelper.a;
        KtvLoggerHelper.b0("challenge_icon");
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void i(long r2) {
        KtvRoomChallengeProgressView r0 = this.b;
        if (r0 == null) goto L6;
        r0.R5(r2);
        return;
    }

    public final String k(String r4) {
        if (TextUtils.isEmpty(l()) == false) goto L5;
        return r4;
    L5:
        return s1.C(2131918260, new Object[]{l(), r4});
    }

    public final void m(boolean r3) {
        if (r3 == false) goto L4;
        int r0 = 2131252023;
    L5:
        View r1 = this.a;
        if (r1 == null) goto L8;
        r1.setBackgroundResource(r0);
    L8:
        View r2 = this.a;
        if (r3 == false) goto L11;
        String r4 = "演唱挑战开";
    L12:
        r3.a(r2, r4);
        return;
    L11:
        r4 = "演唱挑战关";
        goto L12
    L4:
        r0 = 2131252019;
        goto L5
    }

    public KtvRoomChallengeViewWrapper(Context r2, KtvRoomViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.e = r2;
        this.f = r3;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a
    public final void e(View r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        View r0 = null;
        if (r4 == null) goto L5;
        KtvRoomChallengeProgressView r1 = (KtvRoomChallengeProgressView) r4.findViewById(2131376879);
    L6:
        if (r4 == null) goto L8;
        View r2 = r4.findViewById(2131376877);
    L9:
        if (r4 == null) goto L11;
        r0 = r4.findViewById(2131376875);
    L11:
        g(r1, r2, r0, r5);
        return;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void f(boolean r2, int r3) {
        m(r2);
        if (r2 == false) goto L16;
        KtvRoomChallengeProgressView r4 = this.b;
        if (r4 == null) goto L13;
        KtvChallengeDataContext.a r0 = KtvChallengeDataContext.Companion;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r1 = r0.a();
        if (r1 == null) goto L11;
        int r5 = r1.challengeTargetValue();
    L12:
        r4.setProgressBarRange(r5);
    L11:
        r5 = 0;
    L13:
        KtvRoomChallengeProgressView r6 = this.b;
        if (r6 == null) goto L30;
        r6.setChallengeTypeText(r3);
        return;
    L30:
        return;
    L16:
        ConstraintLayout r7 = this.b;
        if (r7 == null) goto L19;
        r7.setVisibility(8);
    L19:
        Function1<? super Boolean, Unit> r8 = this.d;
        if (r8 == null) goto L22;
        Unit r9 = (Unit) r8.invoke(Boolean.FALSE);
    L22:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L32;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r10 = KtvRoomContext.a.a();
        if (r10 == null) goto L33;
        m<Boolean> r11 = r10.isMidiOpened();
        if (r11 == null) goto L34;
        r11.setValue(com.bytedance.android.livesdk.sharedpref.c.M.getValue());
        return;
    L34:
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void j(int r8, int r9) {
        ALogger.i("KtvRoomChallengeViewWrapper", "onChallengeResultChanged, resultType: " + r8 + ", currentProgress: " + r9);
        boolean r0 = true;
        if (r8 == 2) goto L5;
        if (r8 == 1) goto L5;
    L9:
        KtvContext.Companion.getClass();
        KtvContext r10 = KtvContext.a.g();
        KtvMusic r2 = null;
        if (r10 == null) goto L20;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r11 = r10.getKtvCoreViewModel();
        if (r11 == null) goto L20;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r12 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r11.getValue();
        if (r12 == null) goto L20;
        KtvRoomLyricsStateMachineConfig.d r13 = r12.getCurState();
        if (r13 == null) goto L20;
        MusicPanel r14 = r13.b();
        if (r14 == null) goto L20;
        KtvMusic r15 = r14.a;
    L21:
        j.l.getClass();
        boolean r3 = j.d(r15);
        if (r15 == null) goto L26;
        KtvRoomChallengeProgressView r4 = this.b;
        if (r4 == null) goto L26;
        r4.T5(k(r15.getTitle()), r3);
    L26:
        KtvRoomChallengeProgressView r16 = this.b;
        if (r16 != null) goto L29;
    L86:
        if (r8 == 1) goto L88;
        if (r8 == 2) goto L88;
        return;
    L88:
        MusicPanel r17 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r17 == null) goto L91;
        r2 = r17.a;
    L91:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r18 = KtvRoomContext.a.a();
        if (r18 == null) goto L104;
        m<Boolean> r19 = r18.isMidiOpened();
        if (r19 != null) goto L96;
        return;
    L96:
        if (ne2.a.b() == true) goto L98;
    L100:
        r0 = false;
    L101:
        r19.setValue(Boolean.valueOf(r0));
        return;
    L98:
        if (ne2.a.f(r2) == false) goto L100;
    L104:
        return;
    L29:
        if (r8 == 1) goto L69;
        if (r8 != 2) goto L32;
        TextView r6 = r16.g;
        if (r6 == null) goto L54;
        r6.setVisibility(0);
    L54:
        View r7 = r16.h;
        if (r7 == null) goto L57;
        r7.setVisibility(8);
    L57:
        TextView r20 = r16.e;
        if (r20 == null) goto L60;
        r20.setVisibility(8);
    L60:
        TextView r5 = r16.g;
        if (r5 == null) goto L64;
        r5.setText(s1.B(2131918262));
    L64:
        if (r16.i == false) goto L86;
        if (r3 == false) goto L86;
        TextView r21 = r16.f;
        if (r21 == null) goto L86;
        r21.setVisibility(0);
        goto L86
    L32:
        if (r8 != 3) goto L34;
        TextView r22 = r16.g;
        if (r22 == null) goto L45;
        r22.setVisibility(0);
    L45:
        View r23 = r16.h;
        if (r23 == null) goto L48;
        r23.setVisibility(8);
    L48:
        TextView r24 = r16.g;
        if (r24 == null) goto L86;
        r24.setText(s1.B(2131918236));
        goto L86
    L34:
        if (r8 != 4) goto L86;
        TextView r25 = r16.g;
        if (r25 == null) goto L39;
        r25.setVisibility(8);
    L39:
        View r26 = r16.h;
        if (r26 == null) goto L86;
        r26.setVisibility(0);
        goto L86
    L69:
        TextView r27 = r16.g;
        if (r27 == null) goto L72;
        r27.setVisibility(0);
    L72:
        View r28 = r16.h;
        if (r28 == null) goto L75;
        r28.setVisibility(8);
    L75:
        TextView r29 = r16.e;
        if (r29 == null) goto L78;
        r29.setVisibility(0);
    L78:
        TextView r30 = r16.g;
        if (r30 == null) goto L82;
        r30.setText(s1.B(2131918261));
    L82:
        if (r16.i == false) goto L86;
        TextView r31 = r16.f;
        if (r31 == null) goto L86;
        r31.setVisibility(8);
    L20:
        r15 = null;
    L5:
        if (r9 <= 0) goto L9;
        KtvRoomChallengeProgressView r32 = this.b;
        if (r32 == null) goto L9;
        r32.S5(r9);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a
    public final void g(KtvRoomChallengeProgressView r3, View r4, View r5, Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        KtvChallengeDataContext.a r0 = KtvChallengeDataContext.Companion;
        if (r0 == null) goto L5;
        final com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r1 = r0.a();
    L6:
        this.b = r3;
        if (r1 == null) goto L9;
        r1.addKtvChallengeStatusChangedListener(this);
    L9:
        this.a = r4;
        if (r4 == null) goto L12;
        r4.setOnClickListener(x0.a(new KtvRoomChallengeViewWrapper$initChallengeView$1(this, r1)));
    L12:
        int r7 = 8;
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L15;
    L20:
        View r8 = this.a;
        boolean r2 = false;
        if (r8 == null) goto L23;
        r8.setVisibility(0);
    L23:
        Long r9 = KtvLoggerHelper.a;
        KtvLoggerHelper.b0("challenge_icon");
        this.c = r5;
        if (r5 != null) goto L26;
    L29:
        if (r1 != null) goto L31;
    L33:
        m(r2);
    L34:
        this.d = r6;
        return;
    L31:
        if (r1.isKtvChallengeOpen() != true) goto L33;
        r2 = true;
        goto L33
    L26:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.x.getValue()).booleanValue() == false) goto L28;
        r7 = 0;
    L28:
        r5.setVisibility(r7);
        goto L29
    L15:
        if (KtvUtilsKt.d() == true) goto L20;
        View r10 = this.a;
        if (r10 == null) goto L34;
        r10.setVisibility(8);
        goto L34
    L5:
        r1 = null;
        goto L6
    }
}
