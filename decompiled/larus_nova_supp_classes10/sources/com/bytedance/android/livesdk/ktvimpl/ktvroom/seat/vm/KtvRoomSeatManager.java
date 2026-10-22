package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionViewManager;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomSeatManager {
    public static final /* synthetic */ int t = 0;
    public final boolean a;
    public SeatAnimEngineWrapper b;
    public ThemedCompetitionViewManager c;
    public final SeatAnimationView d;
    public KtvRoomSeatListAdapter e;
    public KtvRoomSeatListAdapter f;
    public hg0.d g;
    public hg0.d h;
    public MuteStateChecker i;
    public int j;
    public CompositeDisposable k;
    public List<tf0.e> l;
    public final Lazy m;
    public final Lazy n;
    public VoiceLiveTheme o;
    public final ViewGroup p;
    public final Context q;
    public final fd2.h r;
    public final com.bytedance.android.live.pushstream.d s;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.KtvRoomSeatManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<i, Unit> {
        public AnonymousClass1(KtvRoomSeatManager r8) {
            super(1, r8, KtvRoomSeatManager.class, "onSubSceneChange", "onSubSceneChange(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneEvent;)V", 0);
        }

        public final void invoke(i r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            KtvRoomSeatManager r0 = (KtvRoomSeatManager) ((CallableReference) this).receiver;
            int r1 = KtvRoomSeatManager.t;
            r0.c(r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        KtvRoomSeatListAdapter r0 = this.f;
        if (r0 == null) goto L5;
        int r1 = r0.getItemCount();
    L6:
        KtvRoomSeatListAdapter r2 = this.f;
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.z2(r4));
    L10:
        if (r3 != null) goto L12;
    L15:
        KtvRoomSeatListAdapter r5 = this.e;
        if (r5 == null) goto L22;
        int r6 = r5.z2(r4);
        if (r6 >= 0) goto L21;
        return -1;
    L21:
        return (r6 + r1) + 1;
    L22:
        return -1;
    L12:
        if (r3.intValue() < 0) goto L15;
        return r3.intValue() + 1;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public final void b(boolean r10) {
        if (r10 == false) goto L59;
        this.k = new CompositeDisposable();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r11 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r11 == null) goto L7;
        MuteStateChecker r12 = r11.muteChecker();
    L8:
        this.i = r12;
        u r13 = m.d();
        if (r13 == null) goto L19;
        j r14 = r13.s();
        if (r14 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r15 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r14.getValue();
        if (r15 == null) goto L19;
        BehaviorSubject r16 = r15.a();
        if (r16 == null) goto L19;
        final KtvRoomSeatManager$onRoomStateChange$1 r1 = new KtvRoomSeatManager$onRoomStateChange$1(this);
        Disposable r17 = r16.subscribe(new b(r1));
        if (r17 == null) goto L19;
        RxUtilKt.c(r17, this.k);
    L19:
        u r18 = m.d();
        if (r18 == null) goto L27;
        j r19 = r18.s();
        if (r19 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r110 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r19.getValue();
        if (r110 == null) goto L27;
        i r111 = r110.t();
        if (r111 == null) goto L27;
    L28:
        c(r111);
        if (this.a == false) goto L31;
    L46:
        k.n(IInteractService.class).addBusinessDegradeStrategy((com.bytedance.android.livesdk.a) this.m.getValue());
        k.n(IInteractService.class).addBusinessDegradeStrategy((com.bytedance.android.livesdk.a) this.n.getValue());
        com.bytedance.android.livesdk.a r112 = (com.bytedance.android.livesdk.a) this.m.getValue();
        if (r112 == null) goto L50;
        r112.e = 9;
    L50:
        if (this.j != 9) goto L55;
        ThemedCompetitionViewManager r113 = new ThemedCompetitionViewManager(this.p, null);
        this.c = r113;
        pj0.b r0 = ThemedCompetitionContext.Companion.c();
        if (r0 == null) goto L61;
        r0.ee(r113);
        return;
    L61:
        return;
    L55:
        if (this.c == null) goto L63;
        pj0.b r114 = ThemedCompetitionContext.Companion.c();
        if (r114 == null) goto L64;
        r114.ee(null);
        return;
    L64:
        return;
    L63:
        return;
    L31:
        if (((Boolean) vm2.d.W5.getValue(null, vm2.d.a[358(0x166, float:5.02E-43)])).booleanValue() == false) goto L46;
        o r115 = m.i();
        if (r115 == null) goto L46;
        com.bytedance.live.datacontext.m r116 = r115.getRoom();
        if (r116 == null) goto L46;
        IRoom r117 = (IRoom) r116.getValue();
        if (r117 == null) goto L46;
        String r118 = r117.getOwnerUserIdString();
        if (r118 == null) goto L46;
        SeatAnimEngineWrapper r2 = this.b;
        if (r2 == null) goto L43;
        SeatAnimManager r3 = r2.a;
    L44:
        if (r3 == null) goto L46;
        r3.e(r118, this.d);
        goto L46
    L43:
        r3 = null;
    L27:
        r111 = new i(5, je0.d.o(), null, true, false, null, 36);
        goto L28
    L7:
        r12 = null;
        goto L8
    L59:
        this.i = null;
    }

    public final void c(i r2) {
        int r3 = r2.a;
        if (r3 != this.j) goto L5;
        return;
    L5:
        this.j = r3;
        SeatAnimEngineWrapper r4 = this.b;
        if (r4 == null) goto L8;
        EmojiSoundManager r5 = r4.b;
    L9:
        if (r5 == null) goto L12;
        r5.f();
        return;
    L12:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void d(Map<String, Integer> r29, KtvRoomSeatListAdapter r30) {
        if (r30 == null) goto L6;
        List r1 = r30.c;
        if (r1 == null) goto L6;
    L7:
        int r2 = r1.size();
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L196;
        MultiLinkGuestViewBinder.a r5 = (tf0.e) ListProtector.get(r1, r4);
        if ((r5 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L12;
    L11:
        List r25 = r1;
        int r26 = r2;
        int r8 = r4;
    L191:
        r4 = r8 + 1;
        r1 = r25;
        r2 = r26;
        goto L8
    L12:
        if (r5 == null) goto L195;
        LinkPlayerInfo r6 = r5.k.a;
        if (r6 == null) goto L193;
        LinkPlayerInfo r7 = r6;
        Integer r9 = (Integer) ((HashMap) r29).get(r7.getInteractId());
        if (TextUtils.isEmpty(r7.getInteractId()) == true) goto L11;
        if (TextUtils.equals(r7.getInteractId(), BDLocationException.ERROR_TIMEOUT) == true) goto L11;
        if (r9 == null) goto L11;
        if (r9.intValue() == r7.talkState) goto L11;
        int r10 = r9.intValue();
        r7.talkState = r10;
        if (r10 > 0) goto L25;
    L183:
        r25 = r1;
        r26 = r2;
        r8 = r4;
    L182:
        LinkPlayerInfo r27 = r7;
    L185:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L191;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L191;
        kk0.g r3 = r0.getLinkMicSeatCallback();
        if (r3 == null) goto L191;
        LinkPlayerInfo r11 = r27;
        r3.mo(r11.talkState, r11.getUser());
        goto L191
    L25:
        if (r7.silenceStatus == 0) goto L183;
        MuteStateChecker r12 = this.i;
        if (r12 == null) goto L183;
        String r13 = r7.getInteractId();
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r14 = IVoiceChatAdminService.a.a();
        if (r14 != null) goto L31;
    L32:
        l.n2.getClass();
        l r15 = l.a.a();
        if (r15 != null) goto L35;
    L37:
        boolean r16 = false;
    L38:
        CopyOnWriteArrayList r17 = r12.g.c;
        if (r17 == null) goto L41;
        Integer r18 = Integer.valueOf(r17.size());
    L43:
        if (r18.intValue() <= 1) goto L55;
        if (r16 == false) goto L55;
        if (Intrinsics.areEqual(r13, tc0.c.h().f) == true) goto L49;
        r8 = r4;
        if (r12.c != 0) goto L66;
        r12.c = System.currentTimeMillis() - ((long) LocationInfoConst.HALF_MINUTES);
    L73:
        boolean r19 = false;
    L74:
        if (r19 != true) goto L181;
        MuteStateChecker r20 = this.i;
        if (r20 == null) goto L181;
        IBaseUser r21 = r7.getUser();
        String r22 = "";
        if (r21 == null) goto L81;
        String r23 = r21.getIdString();
        if (r23 == null) goto L81;
    L82:
        String r24 = r7.getInteractId();
        if (r24 != null) goto L85;
        r24 = "";
    L85:
        int r110 = r7.silenceStatus;
        String r111 = r7.devicePlatform;
        Intrinsics.checkNotNullParameter(r23, "userId");
        Intrinsics.checkNotNullParameter(r24, "linkId");
        if (Intrinsics.areEqual(je0.d.g().toString(), r23) == true) goto L181;
        long r112 = System.currentTimeMillis();
        y r113 = r20.g;
        y.a r114 = r113.s;
        if (r114 == null) goto L91;
        long r115 = r114.a;
    L92:
        long r116 = r112 - r115;
        r25 = r1;
        if (r20.e == false) goto L97;
        int r28 = r2;
        long r117 = 0;
        if (r113.t == 0) goto L99;
    L103:
        r26 = r28;
        if (Intrinsics.areEqual(r24, tc0.c.h().f) == false) goto L175;
        if (r110 == 0) goto L175;
        VoiceChatMuteManager r31 = r20.h;
        if (r31 == null) goto L182;
        if (r31.q() == false) goto L112;
        r27 = r7;
        long r210 = r116;
    L120:
        boolean r32 = false;
    L122:
        if (r32 != true) goto L185;
        if (r20.a == false) goto L126;
    L132:
        com.bytedance.android.live.pushstream.d r33 = r20.c();
        if (r33 == null) goto L139;
        d0 r34 = r33.getLiveCore();
        if (r34 == null) goto L139;
        if (r34.t0() == true) goto L139;
    L138:
        boolean r35 = true;
    L140:
        if (r35 == false) goto L174;
        String r36 = je0.d.g();
        int r37 = x.a;
        Intrinsics.checkNotNullParameter(r23, "userId");
        Intrinsics.checkNotNullParameter(r24, "linkId");
        Intrinsics.checkNotNullParameter(r36, "singerId");
        LinkedHashMap r38 = new LinkedHashMap();
        r38.put("abnormal_user_id", r23);
        r38.put("list_status", Integer.valueOf(r110));
        r38.put("link_id", r24);
        r38.put("msg_elapse_time", Long.valueOf(r210));
        r38.put("singer_id", r36);
        x.t0("self_silence_but_unmute", r38);
        VoiceChatMuteManager r39 = r20.h;
        if (r39 == null) goto L174;
        if (r39.l == true) goto L146;
    L173:
        ALogger.e("voice_chat", "interceptResetMute " + r39.q() + ' ' + r39.g + ' ' + r39.i() + ' ' + je0.d.G());
        goto L174
    L146:
        if (r39.q() == true) goto L173;
        if (r39.g == true) goto L173;
        if (r39.i() == false) goto L173;
        if (je0.d.G() == true) goto L173;
        long r40 = System.currentTimeMillis();
        y.a r41 = r39.r.s;
        if (r41 == null) goto L157;
        long r118 = r41.a;
    L158:
        long r42 = r40 - r118;
        long r119 = r40 - r39.h;
        long r211 = r40 - r39.i;
        long r212 = r40 - r39.j;
        if (r39.p() == false) goto L164;
        if (r39.k.enableVersionResetMute == false) goto L164;
        r39.t.G4(true, "listSilence but unmute version");
        DataCenter r43 = r39.s;
        Boolean r44 = Boolean.TRUE;
        r43.put("data_self_is_silenced", r44);
        r39.f.postValue(r44);
        x.b0(true, r110, r42, r119, r211, r212, true);
    L164:
        if (VoiceChatMuteManager.r(r42) == true) goto L166;
    L172:
        x.b0(false, r110, r42, r119, r211, r212, false);
        goto L174
    L166:
        if (VoiceChatMuteManager.r(r119) == false) goto L172;
        if (VoiceChatMuteManager.r(r211) == false) goto L172;
        if (VoiceChatMuteManager.r(r212) == false) goto L172;
        r39.t.G4(true, "listSilence but unmute");
        x.b0(true, r110, r42, r119, r211, r212, false);
        goto L174
    L157:
        r118 = r117;
    L174:
        r20.d = System.currentTimeMillis();
    L139:
        r35 = false;
        goto L140
    L126:
        if (r20.b == false) goto L132;
        com.bytedance.android.live.pushstream.d r45 = r20.c();
        if (r45 == null) goto L139;
        if (r45.t0() == true) goto L139;
    L112:
        if (r31.p() == false) goto L114;
        r27 = r7;
        r210 = r116;
    L119:
        r32 = true;
        goto L122
    L114:
        long r213 = System.currentTimeMillis();
        r27 = r7;
        long r46 = r213 - r31.h;
        r210 = r116;
        long r214 = r213 - r31.i;
        if (VoiceChatMuteManager.r(r46) == false) goto L120;
        if (VoiceChatMuteManager.r(r214) == true) goto L119;
    L175:
        r27 = r7;
        r20.c = System.currentTimeMillis();
        int r47 = x.a;
        if (r111 == null) goto L179;
        r22 = r111;
    L179:
        Intrinsics.checkNotNullParameter(r23, "userId");
        Intrinsics.checkNotNullParameter(r24, "linkId");
        Intrinsics.checkNotNullParameter(r22, "os");
        LinkedHashMap r48 = new LinkedHashMap();
        r48.put("abnormal_user_id", r23);
        r48.put("list_status", Integer.valueOf(r110));
        r48.put("link_id", r24);
        r48.put("os", r22);
        x.t0("others_mute_state_error", r48);
    L99:
        if (r116 >= 5000) goto L101;
    L180:
        r26 = r28;
        r27 = r7;
        ALogger.e("ttlive_link", "checkStateFromRtcTalkState " + r23 + ' ' + r24 + ' ' + r110 + " but gap too short " + r116 + " ms");
        goto L185
    L101:
        if (r116 <= 86400000) goto L103;
    L97:
        r28 = r2;
        r117 = 0;
        goto L99
    L91:
        r115 = 0;
    L81:
        r23 = "";
    L181:
        r25 = r1;
        r26 = r2;
        goto L182
    L66:
        long r49 = System.currentTimeMillis();
        long r120 = r12.c;
        long r50 = r49 - r120;
        if (r120 <= 0) goto L73;
        if (r50 <= LocationInfoConst.HALF_MINUTES) goto L73;
        if (r50 >= 86400000) goto L73;
    L72:
        r19 = true;
        goto L74
    L49:
        if (r12.e == false) goto L51;
        int r51 = 8000;
    L53:
        if (r12.d != 0) goto L56;
        r12.d = System.currentTimeMillis() - ((long) r51);
        goto L55
    L56:
        long r121 = System.currentTimeMillis();
        r8 = r4;
        long r52 = r12.d;
        long r122 = r121 - r52;
        if (r52 <= 0) goto L73;
        if (r122 <= r51) goto L73;
        if (r122 >= 86400000) goto L73;
    L51:
        r51 = 20000;
    L55:
        r8 = r4;
        goto L73
    L41:
        r18 = null;
        goto L43
    L35:
        if (r15.isEngineOn() != true) goto L37;
    L36:
        r16 = true;
        goto L38
    L31:
        if (r14.isEngineOn() == true) goto L36;
    L193:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo");
    L195:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L196:
        return;
    L6:
        r1 = new ArrayList();
        goto L7
    }

    public KtvRoomSeatManager(ViewGroup r2, Context r3, KtvRoomViewManager.c r4, com.bytedance.android.live.pushstream.d r5) {
        Intrinsics.checkNotNullParameter(r2, "ktvLayout");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenterProvider");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.s = r5;
        DataCenter r6 = r4.a();
        if (r6 == null) goto L5;
        boolean r7 = a0.d(r6, false);
    L6:
        this.a = r7;
        this.k = new CompositeDisposable();
        this.m = LazyKt.lazy(KtvRoomSeatManager$emojiSoundDegradeStrategy$2.INSTANCE);
        this.n = LazyKt.lazy(KtvRoomSeatManager$emojiAnimationDegradeStrategy$2.INSTANCE);
        Lazy r8 = KtvCommonSettingHelper.a;
        EmojiSoundManager r0 = null;
        this.d = new SeatAnimationView(r3, null, 6, 0);
        SeatAnimEngineWrapper r9 = this.b;
        if (r9 == null) goto L9;
        r0 = r9.b;
    L9:
        if (r0 == null) goto L12;
        r0.f();
        return;
    L12:
        return;
    L5:
        r7 = false;
        goto L6
    }
}
