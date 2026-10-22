package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/topcontrol/KtvComponentControlTopBarWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentControlTopBarWidget extends HolderRoomWidget {
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.c d;
    public final TopPauseStartFunctionItem e;
    public final l f;
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.f g;
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.d h;
    public final i i;
    public final TopChallengeFunctionItem j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public View n;
    public final CompositeDisposable o;
    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c p;
    public final boolean q;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public a(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            KtvComponentControlTopBarWidget r0 = this.a;
            int r4 = ((com.bytedance.android.livesdk.chatroom.viewmodel.j) r3).a;
            r0.getClass();
            if (r4 != 5) goto L5;
        L12:
            boolean r5 = true;
        L13:
            r0.yq(r5);
            return;
        L5:
            if (r4 == 8) goto L12;
            if (r4 == 12) goto L12;
            if (r4 == 16) goto L12;
            r5 = false;
            goto L13
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public b(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            UserAttr r4 = (UserAttr) r3;
            KtvComponentControlTopBarWidget r0 = this.a;
            if (r4 == null) goto L7;
            r0.getClass();
            boolean r1 = true;
            if (r4.isAdmin() != true) goto L7;
        L8:
            r0.yq(r1);
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public c(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.wq(((Boolean) r2).booleanValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public d(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            UserAttr r3 = (UserAttr) r2;
            KtvComponentControlTopBarWidget r4 = this.a;
            KtvContext.Companion.getClass();
            r4.wq(KtvContext.a.g().isCurrentUserIsSinger());
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public e(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            List r3 = (List) r2;
            KtvComponentControlTopBarWidget r4 = this.a;
            KtvContext.Companion.getClass();
            r4.wq(KtvContext.a.g().isCurrentUserIsSinger());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public f(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) sh6.c.b((sh6.b) r3);
            boolean r0 = false;
            if (r4 == null) goto L5;
            int r5 = r4.size();
        L7:
            if (ChorusContext.Companion.c() == false) goto L15;
            com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.c r1 = this.a.d;
            if (r5 <= 0) goto L13;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L13;
            r0 = true;
        L13:
            r1.a(r0);
            return;
        L15:
            return;
        L5:
            r5 = 0;
            goto L7
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ KtvComponentControlTopBarWidget a;

        public g(KtvComponentControlTopBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r3;
            if (r4.d == true) goto L17;
            KtvComponentControlTopBarWidget r0 = this.a;
            int r5 = r4.a;
            r0.getClass();
            if (r5 != 5) goto L7;
        L14:
            boolean r6 = true;
        L15:
            r0.yq(r6);
            return;
        L7:
            if (r5 == 8) goto L14;
            if (r5 == 12) goto L14;
            if (r5 == 16) goto L14;
            r6 = false;
            goto L15
        }
    }

    public final int getLayoutId() {
        if (this.q == false) goto L6;
        return 2131566488;
    L6:
        return 2131566479;
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        this.k = (ImageView) findViewById(2131373382);
        this.m = (ImageView) findViewById(2131373381);
        this.n = findViewById(2131373384);
        final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.c r1 = this.d;
        ImageView r2 = (ImageView) findViewById(2131373364);
        r1.a = r2;
        if (r2 == null) goto L5;
        UtilityKotlinExtentionsKt.f(r2);
    L5:
        ImageView r3 = r1.a;
        if (r3 == null) goto L8;
        r3.setOnClickListener(x0.a(new TopAdjustFunctionItem$bind$1(r1)));
    L8:
        KtvContext.Companion.getClass();
        RxUtilKt.c(KtvContext.a.g().getHasBgm().a().subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.b(r1)), r1.b);
        TopPauseStartFunctionItem r4 = this.e;
        r4.a = this.k;
        r4.a();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r5 = r4.c;
        if (r5 == null) goto L12;
        r5.observeState(r4.b, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.g(r4), false);
    L12:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L16;
        if (KtvUtilsKt.d() == true) goto L16;
    L18:
        xq();
    L19:
        ViewGroup.LayoutParams r6 = null;
        if (this.q == false) goto L45;
        ConstraintLayout r7 = findViewById(2131385174);
        if (MidiContext.Companion.d() == false) goto L29;
        r7.setVisibility(0);
        ImageView r8 = this.l;
        if (r8 == null) goto L26;
        r8.setVisibility(0);
    L26:
        ImageView r9 = this.k;
        if (r9 == null) goto L48;
        r9.setVisibility(8);
    L48:
        final l r10 = this.f;
        ImageView r11 = (ImageView) findViewById(2131373390);
        r10.a = r11;
        if (r11 == null) goto L51;
        UtilityKotlinExtentionsKt.f(r11);
    L51:
        if (r11 == null) goto L53;
        r11.setOnClickListener(x0.a(new TopTurnNextFunctionItem$bind$1(r10)));
    L53:
        r10.a();
        KtvComponentOrderedSongDataContext r12 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r12 == null) goto L56;
        com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r12, r10.b, new j(r10), 2);
    L56:
        ChorusContext.a r13 = ChorusContext.Companion;
        ChorusContext r14 = r13.getContext();
        if (r14 == null) goto L65;
        n<List<MusicPanel>> r15 = r14.getChorusSelectedSongList();
        if (r15 == null) goto L65;
        Observable r16 = r15.a();
        if (r16 == null) goto L65;
        ObservableSubscribeProxy r17 = (ObservableSubscribeProxy) r16.as(AutoDispose.bind(r10.b));
        if (r17 == null) goto L65;
        r17.subscribe(new k(r10));
    L65:
        final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.f r18 = this.g;
        ImageView r19 = (ImageView) findViewById(2131373381);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "iconView");
        r18.a = r19;
        if (r19 == null) goto L68;
        UtilityKotlinExtentionsKt.f(r19);
    L68:
        ImageView r20 = r18.a;
        if (r20 == null) goto L72;
        r20.setOnClickListener(x0.a(new TopOriginFunctionItem$bind$1(r18)));
    L72:
        if (this.q == false) goto L74;
    L129:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.d r0 = this.h;
        TextView r21 = (TextView) findViewById(2131373370);
        r0.getClass();
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L133;
        if (r21 == null) goto L141;
        r21.setVisibility(8);
    L141:
        wq(KtvContext.a.g().isCurrentUserIsSinger());
        Disposable r22 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new c(this), 3, null);
        if (r22 == null) goto L144;
        RxUtilKt.c(r22, this.o);
    L144:
        IMiddlewareUserService r23 = jc1.k.f(IMiddlewareUserService.class);
        if (r23 == null) goto L153;
        com.bytedance.android.livesdk.user.e r24 = r23.user();
        if (r24 == null) goto L153;
        Observable r25 = r24.u();
        if (r25 == null) goto L153;
        Disposable r26 = r25.subscribe(new d(this));
        if (r26 == null) goto L153;
        RxUtilKt.c(r26, this.o);
    L153:
        MultiChorusContext.Companion.h(this, new e(this));
        ChorusContext r27 = r13.getContext();
        if (r27 == null) goto L163;
        n<List<MusicPanel>> r28 = r27.getChorusSelectedSongList();
        if (r28 == null) goto L163;
        Observable r29 = r28.a();
        if (r29 == null) goto L163;
        Disposable r30 = r29.subscribe(new f(this));
        if (r30 == null) goto L163;
        RxUtilKt.c(r30, this.o);
    L163:
        if (this.q == true) goto L165;
        return;
    L165:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L167;
    L168:
        o r31 = m.j(this);
        if (r31 == null) goto L187;
        com.bytedance.live.datacontext.m r32 = r31.getRoom();
        if (r32 == null) goto L187;
        IRoom r33 = (IRoom) r32.getValue();
        if (r33 == null) goto L187;
        if (r33.isLiveTypeAudio() != true) goto L187;
        u r34 = m.e(this);
        if (r34 == null) goto L199;
        com.bytedance.live.datacontext.j r35 = r34.s();
        if (r35 == null) goto L199;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r36 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r35.getValue();
        if (r36 == null) goto L199;
        BehaviorSubject r37 = r36.a();
        if (r37 == null) goto L199;
        Disposable r38 = r37.subscribe(new g(this));
        if (r38 == null) goto L199;
        this.o.add(r38);
    L199:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L201;
        return;
    L201:
        if (ne2.a.c() == false) goto L214;
        IMiddlewareUserService r39 = jc1.k.f(IMiddlewareUserService.class);
        if (r39 == null) goto L215;
        com.bytedance.android.livesdk.user.e r40 = r39.user();
        if (r40 == null) goto L216;
        Observable r41 = r40.u();
        if (r41 == null) goto L217;
        Disposable r42 = r41.subscribe(new b(this));
        if (r42 == null) goto L218;
        RxUtilKt.c(r42, this.o);
        return;
    L218:
        return;
    L217:
        return;
    L216:
        return;
    L215:
        return;
    L214:
        return;
    L187:
        u r43 = m.e(this);
        if (r43 == null) goto L199;
        com.bytedance.live.datacontext.j r44 = r43.getVideoTalkRoomSubScene();
        if (r44 == null) goto L199;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r45 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r44.getValue();
        if (r45 == null) goto L199;
        BehaviorSubject r46 = r45.a();
        if (r46 == null) goto L199;
        Disposable r47 = r46.subscribe(new a(this));
        if (r47 == null) goto L199;
        this.o.add(r47);
        goto L199
    L167:
        if (KtvUtilsKt.d() == false) goto L199;
    L133:
        if (r21 == null) goto L135;
        r21.setVisibility(0);
    L135:
        if (r21 == null) goto L137;
        UtilityKotlinExtentionsKt.f(r21);
    L137:
        if (r21 == null) goto L139;
        r21.setTag(Boolean.TRUE);
    L139:
        if (r21 == null) goto L141;
        r21.setOnClickListener(x0.a(TopExistFunctionItem$bind$1.INSTANCE));
        goto L141
    L74:
        if (MidiContext.Companion.d() == false) goto L106;
        ImageView r48 = this.l;
        if (r48 == null) goto L79;
        r48.setVisibility(0);
    L79:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L123;
        ImageView r49 = this.l;
        if (r49 == null) goto L83;
        ViewGroup.LayoutParams r50 = r49.getLayoutParams();
    L85:
        if ((r50 instanceof ConstraintLayout.LayoutParams) == true) goto L87;
        r50 = null;
    L87:
        ViewGroup.LayoutParams r51 = (ConstraintLayout.LayoutParams) r50;
        ImageView r52 = this.l;
        if (r52 == null) goto L93;
        if (r51 == null) goto L91;
        ((ConstraintLayout.LayoutParams) r51).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r51).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r51).endToStart = -1;
        ((ConstraintLayout.LayoutParams) r51).rightToLeft = -1;
        Unit r53 = Unit.INSTANCE;
    L92:
        r52.setLayoutParams(r51);
        goto L93
    L91:
        r51 = null;
    L93:
        View r54 = this.n;
        if (r54 == null) goto L96;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();
    L98:
        if ((r55 instanceof ConstraintLayout.LayoutParams) == true) goto L100;
        r55 = null;
    L100:
        ViewGroup.LayoutParams r56 = (ConstraintLayout.LayoutParams) r55;
        View r57 = this.n;
        if (r57 == null) goto L123;
        if (r56 == null) goto L104;
        ((ConstraintLayout.LayoutParams) r56).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r56).rightToLeft = -1;
        Unit r58 = Unit.INSTANCE;
        r6 = r56;
    L104:
        r57.setLayoutParams(r6);
        goto L123
    L96:
        r55 = null;
        goto L98
    L83:
        r50 = null;
    L123:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L129;
        if (ke2.a.e() == false) goto L129;
        View r59 = this.n;
        if (r59 == null) goto L129;
        UtilityKotlinExtentionsKt.t(r59);
        goto L129
    L106:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L119;
        ImageView r60 = (ImageView) findViewById(2131373381);
        if (r60 == null) goto L110;
        ViewGroup.LayoutParams r61 = r60.getLayoutParams();
    L112:
        if ((r61 instanceof ConstraintLayout.LayoutParams) == true) goto L114;
        r61 = null;
    L114:
        ViewGroup.LayoutParams r62 = (ConstraintLayout.LayoutParams) r61;
        if (r60 == null) goto L119;
        if (r62 == null) goto L118;
        ((ConstraintLayout.LayoutParams) r62).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r62).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r62).endToStart = -1;
        ((ConstraintLayout.LayoutParams) r62).rightToLeft = -1;
        Unit r63 = Unit.INSTANCE;
        r6 = r62;
    L118:
        r60.setLayoutParams(r6);
        goto L119
    L110:
        r61 = null;
    L119:
        ImageView r64 = this.l;
        if (r64 == null) goto L123;
        r64.setVisibility(4);
        goto L123
    L29:
        r7.setVisibility(8);
        ImageView r65 = this.l;
        if (r65 == null) goto L32;
        r65.setVisibility(8);
    L32:
        ImageView r66 = this.k;
        if (r66 == null) goto L35;
        r66.setVisibility(0);
    L35:
        ImageView r67 = this.m;
        if (r67 == null) goto L38;
        ViewGroup.LayoutParams r68 = r67.getLayoutParams();
    L39:
        if (r68 == null) goto L44;
        LinearLayout.LayoutParams r69 = (LinearLayout.LayoutParams) r68;
        r69.rightMargin = 0;
        ImageView r70 = this.m;
        if (r70 == null) goto L48;
        r70.setLayoutParams(r69);
        goto L48
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L38:
        r68 = null;
        goto L39
    L45:
        ImageView r71 = this.k;
        if (r71 == null) goto L48;
        r71.setVisibility(0);
    L16:
        if (ne2.a.c() == false) goto L18;
        this.j.c(((Widget) this).contentView);
        goto L19
    }

    public final void onDestroy() {
        super.onDestroy();
        this.e.getClass();
        this.i.getClass();
        this.h.getClass();
        this.f.getClass();
        this.g.b.dispose();
        TopChallengeFunctionItem r0 = this.j;
        r0.getClass();
        KtvChallengeDataContext.a r1 = KtvChallengeDataContext.Companion;
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r2 = r1.a();
        if (r2 == null) goto L7;
        r2.removeKtvChallengeStatusChangedListener(r0);
    L7:
        r0.c.clear();
        this.o.dispose();
    }

    public final void xq() {
        ImageView r0 = (ImageView) findViewById(2131373383);
        this.l = r0;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        final i r1 = this.i;
        ImageView r2 = this.l;
        r1.a = r2;
        if (r2 == null) goto L8;
        UtilityKotlinExtentionsKt.f(r2);
    L8:
        ImageView r3 = r1.a;
        if (r3 == null) goto L11;
        r3.setOnClickListener(x0.a(new TopScoreFunctionItem$bind$1(r1)));
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = r1.d;
        if (r4 == null) goto L15;
        r4.observeState(r1.c, new h(r1), false);
        return;
    }

    public KtvComponentControlTopBarWidget(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r10) {
        Intrinsics.checkNotNullParameter("shortcut", "requestPage");
        this.p = r10;
        this.q = true;
        this.d = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.c("shortcut");
        this.e = new TopPauseStartFunctionItem(this, r10, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.a(2131252114, 2131252109), "shortcut");
        this.f = new l(this, "shortcut");
        this.g = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.f(this, r10, false, true, "shortcut");
        this.h = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.d();
        this.i = new i(this, r10, "shortcut");
        this.j = new TopChallengeFunctionItem(true);
        this.o = new CompositeDisposable();
    }

    public final void wq(boolean r7) {
        boolean r1 = false;
        if (this.q == false) goto L5;
    L16:
        this.d.a(r7);
        this.h.getClass();
        if (MidiContext.Companion.d() == false) goto L19;
        this.i.b(r7);
    L20:
        this.f.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.f r0 = this.g;
        if (r7 == false) goto L69;
        r0.getClass();
        KtvComponentContext r8 = KtvComponentContext.Companion.getContext();
        if (r8 == null) goto L31;
        n<KtvComponentUIContext> r9 = r8.getKtvComponentUIContext();
        if (r9 == null) goto L31;
        KtvComponentUIContext r10 = (KtvComponentUIContext) r9.getValue();
        if (r10 == null) goto L31;
        MutableLiveData<Boolean> r11 = r10.getOriginOpen();
        if (r11 == null) goto L31;
        r11.observe(r0.d, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.e(r0));
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r12 = r0.e;
        Integer r4 = null;
        if (r12 == null) goto L36;
        KtvRoomLyricsStateMachineConfig.d r13 = r12.getCurState();
        if (r13 == null) goto L36;
        MusicPanel r14 = r13.b();
    L37:
        if (r14 != null) goto L39;
    L55:
        ImageView r5 = r0.a;
        if (r5 == null) goto L58;
        r5.setAlpha(0.5f);
    L58:
        ImageView r3 = r0.a;
        if (r3 == null) goto L61;
        r3.setTag(Boolean.FALSE);
    L61:
        if (r14 != null) goto L63;
    L65:
        if (r14 != null) goto L67;
    L76:
        ImageView r15 = r0.a;
        if (r15 != null) goto L79;
        return;
    L79:
        if (r0.c != true) goto L87;
        if (r0.g == false) goto L84;
        r15.setBackgroundResource(2131252108);
        return;
    L84:
        if (r0.f == false) goto L95;
        FrescoLoader r2 = FrescoLoader.with(r15.getContext());
        int r6 = com.bytedance.android.live.ktv.common.util.h.a;
        r2.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ktv_component_top_bar_origin_open_ic_new.png").into(r15);
        return;
    L95:
        return;
    L87:
        if (r0.g == false) goto L90;
        r15.setBackgroundResource(2131252107);
        return;
    L90:
        if (r0.f == false) goto L98;
        FrescoLoader r16 = FrescoLoader.with(r15.getContext());
        int r17 = com.bytedance.android.live.ktv.common.util.h.a;
        r16.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ktv_component_top_bar_origin_close_ic_new.png").into(r15);
        return;
    L98:
        return;
    L67:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.o(r14) != true) goto L76;
        r0.c = false;
        goto L76
    L63:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.p(r14) != true) goto L65;
        r0.c = true;
        goto L76
    L39:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r14) != true) goto L55;
        ImageView r18 = r0.a;
        if (r18 == null) goto L43;
        r18.setAlpha(1.0f);
    L43:
        ImageView r19 = r0.a;
        if (r19 == null) goto L46;
        r19.setTag(Boolean.TRUE);
    L46:
        KtvContext.Companion.getClass();
        oe2.b r20 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r20 == null) goto L49;
        r4 = Integer.valueOf(r20.d());
    L49:
        if (r4 != null) goto L52;
    L54:
        r0.a(r1);
        goto L76
    L52:
        if (r4.intValue() != 1) goto L54;
        r1 = true;
    L36:
        r14 = null;
        goto L37
    L69:
        ImageView r21 = r0.a;
        if (r21 == null) goto L72;
        r21.setAlpha(0.5f);
    L72:
        ImageView r22 = r0.a;
        if (r22 == null) goto L75;
        r22.setTag(Boolean.FALSE);
    L75:
        r0.c = false;
        goto L76
    L19:
        this.e.getClass();
        goto L20
    L5:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L7;
    L13:
        ViewGroup r23 = ((Widget) this).containerView;
        if (r23 == null) goto L16;
        r23.setVisibility(0);
        goto L16
    L7:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.j() == true) goto L13;
        if (r7 == true) goto L13;
        ViewGroup r24 = ((Widget) this).containerView;
        if (r24 == null) goto L16;
        r24.setVisibility(8);
        goto L16
    }

    public final void yq(boolean r2) {
        if (r2 == false) goto L6;
        this.j.c(((Widget) this).contentView);
        ImageView r3 = this.l;
        if (r3 == null) goto L11;
        r3.setVisibility(8);
        return;
    L11:
        return;
    L6:
        ImageView r4 = this.j.a;
        if (r4 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r4);
    L9:
        xq();
    }
}
