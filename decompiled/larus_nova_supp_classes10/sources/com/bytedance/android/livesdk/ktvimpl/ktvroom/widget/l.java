package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeProgressView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvOpusSingerInfoView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends LinearLayout {
    public static final /* synthetic */ int x = 0;
    public final KtvOpusSingerInfoView a;
    public final KtvRoomChallengeProgressView b;
    public final CompositeDisposable c;
    public final boolean d;
    public final View e;
    public ArrayList<? extends View> f;
    public final View g;
    public final View h;
    public final View i;
    public final View j;
    public final View k;
    public final ArrayList<View> l;
    public final ArrayList<View> m;
    public final ArrayList<View> n;
    public final ArrayList<View> o;
    public final ArrayList<KtvRoomChallengeProgressView> p;
    public final ArrayList<View> q;
    public final ArrayList<View> r;
    public final ArrayList<View> s;
    public final KtvContext t;
    public final KtvRoomViewModel u;
    public final LifecycleOwner v;
    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a w;

    public static boolean c() {
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L5;
        return true;
    L5:
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L18;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.isAdmin() == false) goto L21;
        UserAttr r2 = r1.q();
        if (r2 == null) goto L22;
        List r3 = r2.getAdminPrivileges();
        if (r3 == null) goto L23;
        LiveRoomPermission.D.getClass();
        if (r3.contains(Integer.valueOf(LiveRoomPermission.l.a)) != true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L18:
        return false;
    }

    public final KtvContext getKtvContext() {
        return this.t;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.v;
    }

    public final void b(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r10.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L7;
    L75:
        setVisibility(8);
    L76:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r1 = this.w;
        if (r1 == null) goto L80;
        r1.c(r10);
        return;
    L80:
        return;
    L7:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L75;
        this.k.setSelected(r0 instanceof KtvRoomLyricsStateMachineConfig.d.f);
        boolean r2 = false;
        setVisibility(0);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r3 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        MusicPanel r4 = r0.b();
        KtvMusic r5 = null;
        if (r4 == null) goto L12;
        KtvMusic r6 = r4.a;
    L13:
        r3.getClass();
        boolean r7 = com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r6);
        KtvOpusSingerInfoView r8 = this.a;
        r8.getClass();
        KtvRoomLyricsStateMachineConfig.d r9 = (KtvRoomLyricsStateMachineConfig.d) r10.c;
        KtvRoomLyricsStateMachineConfig.d r11 = (KtvRoomLyricsStateMachineConfig.d) r10.a;
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L35;
        r8.T5(0);
        if ((r11 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L31;
        OrderInfo r12 = ((KtvRoomLyricsStateMachineConfig.d.e) r11).b.a.getOrderInfo();
        if (r12 == null) goto L22;
        InteractiveSongUserInfo r13 = r12.getTopUser();
        if (r13 == null) goto L22;
        String r14 = r13.getIdString();
    L23:
        OrderInfo r15 = ((KtvRoomLyricsStateMachineConfig.d.e) r9).b.a.getOrderInfo();
        if (r15 == null) goto L28;
        InteractiveSongUserInfo r16 = r15.getTopUser();
        if (r16 == null) goto L28;
        String r17 = r16.getIdString();
    L30:
        if ((!Intrinsics.areEqual(r14, r17)) == true) goto L31;
    L61:
        if (this.t.isCurrentUserIsSinger() != true) goto L63;
        boolean r18 = true;
    L64:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r19 = this.w;
        if (r19 != null) goto L67;
    L74:
        a(r18, r2, r7);
        d(r2);
        goto L76
    L67:
        if (r19.d() != true) goto L74;
        MusicPanel r20 = r0.b();
        if (r20 == null) goto L72;
        r5 = r20.a;
    L72:
        if (ne2.a.f(r5) == false) goto L74;
        r2 = true;
        goto L74
    L63:
        r18 = false;
    L28:
        r17 = null;
    L22:
        r14 = null;
    L31:
        String r21 = ((KtvRoomLyricsStateMachineConfig.d.e) r9).b.g();
        if (r21 == null) goto L61;
        r8.U5(r21);
        goto L61
    L35:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L56;
        if ((r11 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L52;
        OrderInfo r22 = ((KtvRoomLyricsStateMachineConfig.d.f) r11).b.a.getOrderInfo();
        if (r22 == null) goto L43;
        InteractiveSongUserInfo r23 = r22.getTopUser();
        if (r23 == null) goto L43;
        String r24 = r23.getIdString();
    L44:
        OrderInfo r25 = ((KtvRoomLyricsStateMachineConfig.d.f) r9).b.a.getOrderInfo();
        if (r25 == null) goto L49;
        InteractiveSongUserInfo r26 = r25.getTopUser();
        if (r26 == null) goto L49;
        String r27 = r26.getIdString();
    L51:
        if ((!Intrinsics.areEqual(r24, r27)) == false) goto L61;
    L49:
        r27 = null;
    L43:
        r24 = null;
    L52:
        String r28 = ((KtvRoomLyricsStateMachineConfig.d.f) r9).b.g();
        if (r28 == null) goto L61;
        r8.U5(r28);
        goto L61
    L56:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L58;
    L59:
        r8.T5(0);
        goto L61
    L58:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L61;
    L12:
        r6 = null;
        goto L13
    }

    public final void d(boolean r5) {
        KtvContext.Companion.getClass();
        boolean r0 = KtvContext.a.g().isCurrentUserIsSinger();
        if (r5 == false) goto L5;
        this.a.setSingingInfoVisibility(false);
    L6:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        a(r0, r5, true ^ com.bytedance.android.livesdk.ktvimpl.base.util.j.a());
        return;
    L5:
        this.a.setSingingInfoVisibility(true);
        goto L6
    }

    public final void a(boolean r1, boolean r2, boolean r3) {
        if (r2 == false) goto L16;
        if (this.d == true) goto L12;
        if (r3 == true) goto L7;
    L9:
        if (r1 == false) goto L11;
        ArrayList r4 = this.q;
    L28:
        if ((!Intrinsics.areEqual(this.f, r4)) == false) goto L33;
        this.f = r4;
        removeAllViews();
        addView(this.a);
        Iterator r5 = r4.iterator();
    L31:
        if (r5.hasNext() == false) goto L35;
        addView((View) r5.next());
        goto L31
    L35:
        return;
    L33:
        return;
    L11:
        r4 = this.p;
        goto L28
    L7:
        if (c() == false) goto L9;
    L12:
        if (r1 == false) goto L14;
        r4 = this.r;
        goto L28
    L14:
        r4 = this.s;
        goto L28
    L16:
        if (this.d == true) goto L24;
        if (r3 == true) goto L19;
    L21:
        if (r1 == false) goto L23;
        r4 = this.n;
        goto L28
    L23:
        r4 = this.o;
        goto L28
    L19:
        if (c() == false) goto L21;
    L24:
        if (r1 == false) goto L26;
        r4 = this.l;
        goto L28
    L26:
        r4 = this.m;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvOpusSingerInfoView] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeProgressView] */
    public l(Context r17, KtvContext r18, KtvRoomInteractViewModel r19, LifecycleOwner r20, KtvRoomChallengeViewWrapper r21) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "ktvContext");
        Intrinsics.checkNotNullParameter(r20, "lifecycleOwner");
        super(r17);
        this.t = r18;
        this.u = r19;
        this.v = r20;
        this.w = r21;
        ?? r5 = new KtvOpusSingerInfoView(r17);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, com.bytedance.android.live.core.utils.s1.f(30.0f));
        r6.gravity = 16;
        Unit r8 = Unit.INSTANCE;
        r5.setLayoutParams(r6);
        r5.setKtvContext(r18);
        this.a = r5;
        ?? r7 = new KtvRoomChallengeProgressView(r17, null, 6, 0);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(200.0f), com.bytedance.android.live.core.utils.s1.f(26.0f));
        r9.gravity = 16;
        r7.setLayoutParams(r9);
        TextView r10 = r7.f;
        if (r10 == null) goto L5;
        r10.setVisibility(8);
    L5:
        r7.i = true;
        this.b = r7;
        CompositeDisposable r11 = new CompositeDisposable();
        this.c = r11;
        sb0.b r2 = (sb0.b) r18.getDataEntity().getValue();
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        this.d = r3;
        int r4 = com.bytedance.android.live.core.utils.s1.f(20.0f);
        int r12 = com.bytedance.android.live.core.utils.s1.f(5.0f);
        View r13 = new View(r17);
        r13.setBackgroundColor(-1);
        r13.setAlpha(0.5f);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(0.3f), com.bytedance.android.live.core.utils.s1.f(15.0f));
        r14.leftMargin = com.bytedance.android.live.core.utils.s1.f(5.0f);
        r14.rightMargin = com.bytedance.android.live.core.utils.s1.f(5.0f);
        r13.setLayoutParams(r14);
        this.e = r13;
        c r15 = new c(this);
        Intrinsics.checkNotNullParameter(r15, "clickListener");
        View r16 = new View(getContext());
        r16.setBackgroundResource(2131252116);
        r16.setOnClickListener(r15);
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(r4, r4);
        r22.gravity = 16;
        r22.leftMargin = r12;
        r22.rightMargin = r12;
        r22.topMargin = r12;
        r22.bottomMargin = r12;
        r16.setLayoutParams(r22);
        r3.a(r16, com.bytedance.android.live.core.utils.s1.B(2131919500));
        this.g = r16;
        d r23 = new d(this, r17);
        Intrinsics.checkNotNullParameter(r23, "clickListener");
        View r110 = new View(getContext());
        r110.setBackgroundResource(2131252018);
        r110.setOnClickListener(r23);
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(r4, r4);
        r24.gravity = 16;
        r24.leftMargin = r12;
        r24.rightMargin = r12;
        r24.topMargin = r12;
        r24.bottomMargin = r12;
        r110.setLayoutParams(r24);
        this.h = r110;
        j r25 = new j(this);
        Intrinsics.checkNotNullParameter(r25, "clickListener");
        View r26 = new View(getContext());
        r26.setBackgroundResource(2131252048);
        r26.setOnClickListener(r25);
        LinearLayout.LayoutParams r27 = new LinearLayout.LayoutParams(r4, r4);
        r27.gravity = 16;
        r27.leftMargin = r12;
        r27.rightMargin = r12;
        r27.topMargin = r12;
        r27.bottomMargin = r12;
        r26.setLayoutParams(r27);
        this.i = r26;
        e r28 = new e(this);
        Intrinsics.checkNotNullParameter(r28, "clickListener");
        View r111 = new View(getContext());
        r111.setBackgroundResource(2131252115);
        r111.setOnClickListener(r28);
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(r4, r4);
        r29.gravity = 16;
        r29.leftMargin = r12;
        r29.rightMargin = r12;
        r29.topMargin = r12;
        r29.bottomMargin = r12;
        r111.setLayoutParams(r29);
        r3.a(r111, com.bytedance.android.live.core.utils.s1.B(2131918603));
        this.j = r111;
        k r30 = new k(this);
        Intrinsics.checkNotNullParameter(r30, "clickListener");
        View r31 = new View(getContext());
        r31.setBackgroundResource(2131252125);
        r31.setOnClickListener(r30);
        LinearLayout.LayoutParams r32 = new LinearLayout.LayoutParams(r4, r4);
        r32.gravity = 16;
        r32.leftMargin = r12;
        r32.rightMargin = r12;
        r32.topMargin = r12;
        r32.bottomMargin = r12;
        r31.setLayoutParams(r32);
        r3.a(r31, com.bytedance.android.live.core.utils.s1.B(2131918119));
        this.k = r31;
        TextView r33 = new TextView(r17);
        r33.setTextSize(1, 14.0f);
        r33.setTextColor(-1);
        r33.setTypeface(Typeface.DEFAULT_BOLD);
        r33.setText(2131918187);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 16;
        r1.leftMargin = r12;
        r1.rightMargin = r12;
        r1.topMargin = r12;
        r1.bottomMargin = r12;
        r33.setLayoutParams(r1);
        r33.setOnClickListener(new a(this));
        this.l = CollectionsKt.arrayListOf(new View[]{r13, r33, r16, r110});
        this.m = CollectionsKt.arrayListOf(new View[]{r13, r31, r111, r110});
        this.n = CollectionsKt.arrayListOf(new View[]{r13, r26, r111, r33, r16});
        this.o = new ArrayList();
        this.p = CollectionsKt.arrayListOf(new KtvRoomChallengeProgressView[]{r7});
        this.q = CollectionsKt.arrayListOf(new View[]{r7, r16});
        this.r = CollectionsKt.arrayListOf(new View[]{r7, r16, r110});
        this.s = CollectionsKt.arrayListOf(new View[]{r7, r111, r110});
        r5.R5(r20, r19, r11);
        setBackgroundResource(2131249307);
        ViewGroup.MarginLayoutParams r34 = new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.live.core.utils.s1.f(30.0f));
        setGravity(16);
        r34.bottomMargin = com.bytedance.android.live.core.utils.s1.f(0.5f);
        setPadding(0, 0, com.bytedance.android.live.core.utils.s1.f(15.0f), 0);
        setLayoutParams(r34);
        setOrientation(0);
        if (r19 == null) goto L16;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r35 = r19.getStateChangeEvent();
        if (r35 == null) goto L16;
        r35.observe(r20, new b(this));
    L16:
        if (r19 == null) goto L20;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r36 = r19.getStateChangeEvent();
        if (r36 == null) goto L20;
        StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r37 = (StateMachine.c.b) r36.getValue();
    L21:
        b(r37);
        Lazy r38 = KtvCommonSettingHelper.a;
        return;
    L20:
        r37 = null;
        goto L21
    L8:
        if (r2.isAnchor() != true) goto L10;
        r3 = true;
        goto L11
    }
}
