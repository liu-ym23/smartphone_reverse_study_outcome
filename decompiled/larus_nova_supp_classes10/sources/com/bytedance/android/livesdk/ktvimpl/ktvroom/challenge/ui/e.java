package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b {
    public KtvComponentChallengeProgressView a;
    public View b;
    public TextView c;
    public View d;
    public Function0<Unit> e;
    public KtvComponentMidiView f;
    public KtvComponentMusicReportInfoManager g;

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public static boolean d() {
        KtvContext.Companion.getClass();
        MusicPanel r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r0 == null) goto L5;
        KtvMusic r1 = r0.a;
    L7:
        return ne2.a.f(r1);
    L5:
        r1 = null;
        goto L7
    }

    public final void e() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L11;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
        if (r2 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.getCurState();
        if (r3 == null) goto L11;
        MusicPanel r4 = r3.b();
    L12:
        if (r4 == null) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
        return;
    L17:
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L21;
        View r6 = this.d;
        if (r6 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r6);
        return;
    L26:
        return;
    L21:
        KtvComponentMusicReportInfoManager r7 = this.g;
        if (r7 == null) goto L28;
        r7.f(je2.f.a.a);
        return;
    L28:
        return;
    L14:
        r5 = false;
    L11:
        r4 = null;
        goto L12
    }

    public final void c() {
        if (ne2.a.b() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        ALogger.i("KtvChallengeViewWrapper", "checkMidiSwitch, scoreOpen: " + r0);
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L19;
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        if (r1 == null) goto L29;
        n<KtvComponentUIContext> r2 = r1.getKtvComponentUIContext();
        if (r2 == null) goto L30;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r2.getValue();
        if (r3 == null) goto L31;
        MutableLiveData<Boolean> r4 = r3.getScoreOpen();
        if (r4 == null) goto L32;
        r4.setValue(Boolean.valueOf(r0));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L19:
        KtvComponentContext r5 = KtvComponentContext.Companion.getContext();
        if (r5 == null) goto L34;
        n<KtvComponentUIContext> r6 = r5.getKtvComponentUIContext();
        if (r6 == null) goto L35;
        KtvComponentUIContext r7 = (KtvComponentUIContext) r6.getValue();
        if (r7 == null) goto L36;
        MutableLiveData<Boolean> r8 = r7.getSingerScoreOpen();
        if (r8 == null) goto L37;
        r8.setValue(Boolean.valueOf(r0));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L5:
        if (d() == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        KtvChallengeDataContext.a r0 = KtvChallengeDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r1 = r0.a();
        int r2 = 0;
        if (r1 == null) goto L9;
        boolean r3 = true;
        if (r1.isKtvChallengeOpen() != true) goto L9;
    L10:
        if (r3 == true) goto L12;
        return;
    L12:
        KtvRoomLyricsStateMachineConfig.d r4 = (KtvRoomLyricsStateMachineConfig.d) r5.c;
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L15;
    L47:
        ConstraintLayout r6 = this.a;
        if (r6 == null) goto L50;
        UtilityKotlinExtentionsKt.t(r6);
    L50:
        TextView r7 = this.c;
        if (r7 == null) goto L59;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    L59:
        return;
    L15:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L47;
        KtvComponentChallengeProgressView r8 = this.a;
        if (r8 == null) goto L25;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r9 = r0.a();
        if (r9 == null) goto L22;
        int r10 = r9.challengeTargetValue();
    L23:
        r8.setProgressBarRange(r10);
        goto L25
    L22:
        r10 = 0;
    L25:
        if ((r5.c instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L41;
        KtvComponentChallengeProgressView r11 = this.a;
        if (r11 == null) goto L29;
        r11.R5(0);
    L29:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L32;
        c();
        return;
    L32:
        TextView r12 = this.c;
        if (r12 == null) goto L35;
        UtilityKotlinExtentionsKt.t(r12);
    L35:
        View r13 = this.d;
        if (r13 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r13);
    L38:
        KtvComponentMusicReportInfoManager r14 = this.g;
        if (r14 == null) goto L55;
        r14.f(new je2.f.e(null, null));
        return;
    L55:
        return;
    L41:
        KtvComponentChallengeProgressView r15 = this.a;
        if (r15 == null) goto L57;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r16 = r0.a();
        if (r16 == null) goto L46;
        r2 = r16.currentScoreValue();
    L46:
        r15.R5(r2);
        return;
    L57:
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void b(int r8) {
        if (ne2.a.b() == false) goto L15;
        String r9 = "评分" + r8;
        KtvChallengeDataContext.a r0 = KtvChallengeDataContext.Companion;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r1 = r0.a();
        if (r1 == null) goto L11;
        me2.a r2 = r1.getChallengeConfig();
        if (r2 == null) goto L11;
        Long r3 = Long.valueOf(r2.c);
    L12:
        String r4 = r9 + '/' + String.valueOf(r3);
        SpannableString r5 = new SpannableString(r4);
        ForegroundColorSpan r6 = new ForegroundColorSpan(ColorProtector.parseColor("#E6FF3372"));
        ForegroundColorSpan r7 = new ForegroundColorSpan(ColorProtector.parseColor("#80FF3372"));
        r5.setSpan(r6, 0, r9.length(), 33);
        r5.setSpan(r7, r9.length(), r4.length(), 33);
        KtvComponentMidiView r10 = this.f;
        if (r10 == null) goto L19;
        r10.R5(r5, true);
        return;
    L19:
        return;
    L11:
        r3 = null;
        goto L12
    L15:
        KtvComponentChallengeProgressView r11 = this.a;
        if (r11 == null) goto L21;
        r11.R5(r8);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void i(long r4) {
        if (r4 > 10) goto L5;
        String r0 = "#FF3372";
    L6:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L15;
        TextView r1 = this.c;
        if (r1 == null) goto L11;
        r1.setTextColor(ColorProtector.parseColor(r0));
    L11:
        TextView r2 = this.c;
        if (r2 == null) goto L14;
        StringBuilder r3 = new StringBuilder();
        r3.append(r4);
        r3.append('s');
        r2.setText(r3.toString());
    L14:
        View r5 = this.b;
        StringBuilder r6 = new StringBuilder();
        r6.append(r4);
        r6.append(31186);
        r3.a(r5, r6.toString());
        return;
    L15:
        KtvComponentMusicReportInfoManager r7 = this.g;
        if (r7 == null) goto L20;
        r7.f(new je2.f.e(Long.valueOf(r4), r0));
        return;
    L20:
        return;
    L5:
        r0 = "#FFFFFF";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void f(boolean r3, int r4) {
        int r0 = 0;
        if (r3 == false) goto L15;
        KtvComponentChallengeProgressView r5 = this.a;
        if (r5 == null) goto L12;
        KtvChallengeDataContext.a r1 = KtvChallengeDataContext.Companion;
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r2 = r1.a();
        if (r2 == null) goto L11;
        r0 = r2.challengeTargetValue();
    L11:
        r5.setProgressBarRange(r0);
    L12:
        KtvComponentChallengeProgressView r6 = this.a;
        if (r6 == null) goto L37;
        r6.setChallengeTypeText(r4);
    L37:
        Function0<Unit> r7 = this.e;
        if (r7 == null) goto L41;
        Unit r8 = (Unit) r7.invoke();
        return;
    L41:
        return;
    L15:
        ConstraintLayout r9 = this.a;
        if (r9 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r9);
    L18:
        TextView r10 = this.c;
        if (r10 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r10);
    L21:
        e();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L33;
        KtvComponentContext r11 = KtvComponentContext.Companion.getContext();
        if (r11 == null) goto L33;
        n<KtvComponentUIContext> r12 = r11.getKtvComponentUIContext();
        if (r12 == null) goto L33;
        KtvComponentUIContext r13 = (KtvComponentUIContext) r12.getValue();
        if (r13 == null) goto L33;
        MutableLiveData<Boolean> r14 = r13.getScoreOpen();
        if (r14 == null) goto L33;
        r14.setValue(com.bytedance.android.livesdk.sharedpref.c.H.getValue());
    L33:
        if (ne2.a.b() == false) goto L37;
        SpannableString r15 = new SpannableString(BDLocationException.ERROR_TIMEOUT);
        KtvComponentMidiView r16 = this.f;
        if (r16 == null) goto L37;
        r16.R5(r15, false);
        goto L37
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvComponentChallengeProgressView] */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvComponentChallengeResultView] */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void j(int r17, int r18) {
        ALogger.i("KtvChallengeViewWrapper", "onChallengeResultChanged, resultType: " + r17);
        if (ne2.a.b() == true) goto L5;
        if (r17 != 5) goto L37;
        ConstraintLayout r3 = this.a;
        if (r3 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r3);
    L42:
        if (r17 != 2) goto L46;
        KtvComponentChallengeProgressView r4 = this.a;
        if (r4 == null) goto L46;
        r4.R5(r18);
    L46:
        ?? r5 = this.a;
        if (r5 == 0) goto L148;
        ?? r6 = r5.b;
        if (r6 == 0) goto L148;
        ProgressBar r8 = r5.a;
        if (r8 == null) goto L53;
        int r9 = r8.getMax();
    L54:
        int r7 = r5.getWidth();
        if (r17 == 1) goto L108;
        if (r17 == 2) goto L95;
        if (r17 == 3) goto L82;
        if (r17 != 4) goto L60;
        TextView r10 = r6.d;
        if (r10 == null) goto L78;
        r10.setVisibility(8);
    L78:
        View r11 = r6.f;
        if (r11 == null) goto L81;
        r11.setVisibility(0);
    L81:
        r6.post(new c(r6, r18, r9, r7));
        goto L148
    L60:
        if (r17 != 6) goto L148;
        TextView r12 = r6.d;
        if (r12 == null) goto L65;
        r12.setVisibility(0);
    L65:
        View r13 = r6.f;
        if (r13 == null) goto L68;
        r13.setVisibility(8);
    L68:
        TextView r14 = r6.d;
        if (r14 == null) goto L71;
        r14.setText(s1.B(2131918242));
    L71:
        TextView r15 = r6.d;
        if (r15 == null) goto L74;
        r15.setTextColor(ColorProtector.parseColor("#E6FF3372"));
    L74:
        r6.post(new d(r6, r18, r9, r7));
        goto L148
    L82:
        TextView r16 = r6.d;
        if (r16 == null) goto L85;
        r16.setVisibility(0);
    L85:
        View r19 = r6.f;
        if (r19 == null) goto L88;
        r19.setVisibility(8);
    L88:
        TextView r20 = r6.d;
        if (r20 == null) goto L91;
        r20.setText(s1.B(2131918236));
    L91:
        TextView r21 = r6.d;
        if (r21 == null) goto L94;
        r21.setTextColor(ColorProtector.parseColor("#5E6D8D"));
    L94:
        r6.post(new b(r6, r18, r9, r7));
        goto L148
    L95:
        TextView r2 = r6.d;
        if (r2 == null) goto L98;
        r2.setVisibility(0);
    L98:
        View r22 = r6.f;
        if (r22 == null) goto L101;
        r22.setVisibility(8);
    L101:
        TextView r23 = r6.d;
        if (r23 == null) goto L104;
        r23.setText(s1.B(2131918262));
    L104:
        TextView r24 = r6.d;
        if (r24 == null) goto L107;
        r24.setTextColor(ColorProtector.parseColor("#E6FF3372"));
    L107:
        r6.S5();
        goto L148
    L108:
        TextView r25 = r6.d;
        if (r25 == null) goto L111;
        r25.setVisibility(0);
    L111:
        View r26 = r6.f;
        if (r26 == null) goto L114;
        r26.setVisibility(8);
    L114:
        TextView r27 = r6.d;
        if (r27 == null) goto L117;
        r27.setText("演唱" + s1.B(2131918261));
    L117:
        TextView r28 = r6.d;
        if (r28 == null) goto L120;
        r28.setTextColor(ColorProtector.parseColor("#E6FF3372"));
    L120:
        ViewGroup.LayoutParams r29 = r6.getLayoutParams();
        if ((r29 instanceof ConstraintLayout.LayoutParams) == true) goto L123;
        r29 = null;
    L123:
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
        if (r30 == null) goto L126;
        r30.rightToRight = -1;
        r30.leftToLeft = 0;
    L126:
        r6.setLayoutParams(r30);
        r6.setTranslationX(0.0f);
        View r31 = r6.e;
        if (r31 == null) goto L129;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
    L131:
        if ((r32 instanceof ConstraintLayout.LayoutParams) == true) goto L133;
        r32 = null;
    L133:
        ViewGroup.LayoutParams r33 = (ConstraintLayout.LayoutParams) r32;
        if (r33 == null) goto L136;
        ((ConstraintLayout.LayoutParams) r33).rightToRight = -1;
        ((ConstraintLayout.LayoutParams) r33).leftToLeft = 0;
    L136:
        View r34 = r6.e;
        if (r34 == null) goto L139;
        r34.setLayoutParams(r33);
    L139:
        View r35 = r6.e;
        if (r35 == null) goto L142;
        r35.setBackgroundResource(2131252034);
    L142:
        TextView r36 = r6.d;
        if (r36 == null) goto L145;
        r36.setBackgroundResource(2131249303);
    L145:
        View r37 = r6.f;
        if (r37 == null) goto L148;
        r37.setBackgroundResource(2131249303);
        goto L148
    L129:
        r32 = null;
        goto L131
    L53:
        r9 = 0;
    L148:
        if (r17 != 1) goto L160;
        KtvComponentChallengeProgressView r38 = this.a;
        if (r38 == null) goto L160;
        KtvChallengeDataContext.a r39 = KtvChallengeDataContext.Companion;
        if (r39 == null) goto L158;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r40 = r39.a();
        if (r40 == null) goto L158;
        me2.a r41 = r40.getChallengeConfig();
        if (r41 == null) goto L158;
        int r42 = r41.f;
    L159:
        r38.setChallengeTypeText(r42);
    L158:
        r42 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
    L160:
        if (r17 == 1) goto L162;
        if (r17 == 2) goto L162;
    L163:
        if (r17 != 1) goto L174;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L167;
    L171:
        TextView r43 = this.c;
        if (r43 == null) goto L185;
        UtilityKotlinExtentionsKt.t(r43);
    L185:
        TextView r44 = this.c;
        if (r44 != null) goto L188;
    L189:
        r3.c(this.b, s1.B(2131918625), true);
    L190:
        if (r17 != 1) goto L204;
        boolean r1 = d();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L197;
        if (r1 == false) goto L197;
        View r45 = this.d;
        if (r45 == null) goto L211;
        UtilityKotlinExtentionsKt.t(r45);
    L211:
        Function0<Unit> r46 = this.e;
        if (r46 == null) goto L215;
        Unit r47 = (Unit) r46.invoke();
        return;
    L215:
        return;
    L197:
        View r48 = this.d;
        if (r48 == null) goto L200;
        UtilityKotlinExtentionsKt.w(r48);
    L200:
        if (r1 == false) goto L211;
        KtvComponentMusicReportInfoManager r49 = this.g;
        if (r49 == null) goto L211;
        r49.f(new je2.f.e(null, null));
        goto L211
    L204:
        if (r17 != 2) goto L207;
        e();
        goto L211
    L207:
        if (r17 != 5) goto L211;
        View r50 = this.d;
        if (r50 == null) goto L211;
        UtilityKotlinExtentionsKt.w(r50);
        goto L211
    L188:
        if (r44.getVisibility() == 0) goto L190;
    L167:
        if (d() == false) goto L171;
        TextView r51 = this.c;
        if (r51 == null) goto L185;
        UtilityKotlinExtentionsKt.w(r51);
        goto L185
    L174:
        if (r17 != 2) goto L181;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L185;
        TextView r52 = this.c;
        if (r52 == null) goto L185;
        UtilityKotlinExtentionsKt.t(r52);
        goto L185
    L181:
        if (r17 != 5) goto L185;
        TextView r53 = this.c;
        if (r53 == null) goto L185;
        UtilityKotlinExtentionsKt.t(r53);
    L162:
        c();
        goto L163
    L37:
        if (r17 == 1) goto L39;
        if (r17 != 2) goto L42;
    L39:
        ConstraintLayout r54 = this.a;
        if (r54 == null) goto L42;
        UtilityKotlinExtentionsKt.w(r54);
        goto L42
    L5:
        if (r17 == 1) goto L27;
        if (r17 == 2) goto L24;
        if (r17 == 3) goto L21;
        if (r17 != 4) goto L160;
        String r55 = "评分" + r18;
        KtvChallengeDataContext.a r56 = KtvChallengeDataContext.Companion;
        if (r56 == null) goto L17;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r57 = r56.a();
        if (r57 == null) goto L17;
        me2.a r58 = r57.getChallengeConfig();
        if (r58 == null) goto L17;
        Long r59 = Long.valueOf(r58.c);
    L18:
        String r60 = r55 + '/' + String.valueOf(r59);
        SpannableString r61 = new SpannableString(r60);
        ForegroundColorSpan r62 = new ForegroundColorSpan(ColorProtector.parseColor("#E6FF3372"));
        ForegroundColorSpan r63 = new ForegroundColorSpan(ColorProtector.parseColor("#80FF3372"));
        r61.setSpan(r62, 0, r55.length(), 33);
        r61.setSpan(r63, r55.length(), r60.length(), 33);
        KtvComponentMidiView r64 = this.f;
        if (r64 == null) goto L160;
        r64.R5(r61, true);
    L17:
        r59 = null;
        goto L18
    L21:
        String r65 = s1.B(2131918236);
        SpannableString r66 = new SpannableString(r65);
        r66.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#5E6D8D")), 0, r65.length(), 33);
        KtvComponentMidiView r67 = this.f;
        if (r67 == null) goto L160;
        r67.R5(r66, true);
        goto L160
    L24:
        String r68 = s1.B(2131918262);
        SpannableString r69 = new SpannableString(r68);
        r69.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#E6FF3372")), 0, r68.length(), 33);
        KtvComponentMidiView r70 = this.f;
        if (r70 == null) goto L160;
        r70.R5(r69, true);
        goto L160
    L27:
        String r71 = "演唱" + s1.B(2131918261);
        SpannableString r72 = new SpannableString(r71);
        r72.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#E6FF3372")), 0, r71.length(), 33);
        KtvComponentMidiView r73 = this.f;
        if (r73 == null) goto L30;
        r73.R5(r72, true);
    L30:
        ConstraintLayout r74 = this.a;
        if (r74 == null) goto L160;
        UtilityKotlinExtentionsKt.t(r74);
        goto L160
    }
}
