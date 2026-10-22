package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TopChallengeFunctionItem implements com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b {
    public ImageView a;
    public View b;
    public final CompositeDisposable c;
    public final boolean d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ TopChallengeFunctionItem a;

        public a(TopChallengeFunctionItem r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            View r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void b(int r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void i(long r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void j(int r1, int r2) {
    }

    public TopChallengeFunctionItem(boolean r1) {
        this.d = r1;
        this.c = new CompositeDisposable();
    }

    public final void c(View r4) {
        View r0 = null;
        if (r4 == null) goto L5;
        ImageView r1 = (ImageView) r4.findViewById(2131373368);
    L6:
        this.a = r1;
        if (r4 == null) goto L9;
        r0 = r4.findViewById(2131376875);
    L9:
        this.b = r0;
        ImageView r5 = this.a;
        boolean r2 = false;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
    L12:
        Long r6 = KtvLoggerHelper.a;
        if (this.d == false) goto L15;
        String r7 = "shortcut";
    L16:
        KtvLoggerHelper.b0(r7);
        ImageView r8 = this.a;
        if (r8 == null) goto L19;
        r8.setOnClickListener(x0.a(new TopChallengeFunctionItem$bind$1(this)));
    L19:
        KtvChallengeDataContext.a r9 = KtvChallengeDataContext.Companion;
        if (r9 == null) goto L24;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r3 = r9.a();
        if (r3 == null) goto L24;
        r3.addKtvChallengeStatusChangedListener(this);
    L24:
        View r10 = this.b;
        if (r10 != null) goto L27;
    L31:
        if (r9 == null) goto L37;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r11 = r9.a();
        if (r11 == null) goto L37;
        if (r11.isKtvChallengeOpen() != true) goto L37;
        r2 = true;
    L37:
        d(r2);
        if (r9 == null) goto L49;
        KtvChallengeDataContext r12 = r9.getContext();
        if (r12 == null) goto L50;
        m<Object> r13 = r12.getChallengeYellowStatus();
        if (r13 == null) goto L51;
        Observable r14 = r13.a();
        if (r14 == null) goto L52;
        Disposable r15 = r14.subscribe(new a(this));
        if (r15 == null) goto L53;
        RxUtilKt.c(r15, this.c);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L27:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.x.getValue()).booleanValue() == false) goto L29;
        int r16 = 0;
    L30:
        r10.setVisibility(r16);
        goto L31
    L29:
        r16 = 8;
        goto L30
    L15:
        r7 = "request_tab_ksong";
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L4;
        int r0 = 2131252023;
    L5:
        ImageView r1 = this.a;
        if (r1 == null) goto L8;
        r1.setImageResource(r0);
    L8:
        StringBuilder r2 = new StringBuilder();
        r2.append(s1.B(2131918228));
        if (r3 == false) goto L11;
        int r4 = 2131914862;
    L12:
        r2.append(s1.B(r4));
        String r5 = r2.toString();
        r3.a(this.a, r5);
        return;
    L11:
        r4 = 2131914861;
        goto L12
    L4:
        r0 = 2131252019;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void f(boolean r1, int r2) {
        d(r1);
    }
}
