package com.bytedance.android.livesdk.ktvimpl.chorus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.model.ChorusInfo;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.chorus.api.ChorusApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdk.message.model.CloseChorusContent;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicActionType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OpenChorusContent;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.de;
import com.bytedance.android.livesdk.message.model.s2;
import com.bytedance.android.livesdk.message.model.v2;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import fd2.x;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001d\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\u0005H\u0014R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/chorus/ChorusViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "", "removeSong", "panel", "tryPause", "Ltlc/d;", "message", "onMessage", "initChorusSongList", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/liveinteract/model/ChorusInfo;", "chorusInfo", "Landroidx/lifecycle/MutableLiveData;", "getChorusInfo", "()Landroidx/lifecycle/MutableLiveData;", "setChorusInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "", "openStatus", "getOpenStatus", "setOpenStatus", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "com/bytedance/android/livesdk/ktvimpl/chorus/ChorusViewModel$b", "handler", "Lcom/bytedance/android/livesdk/ktvimpl/chorus/ChorusViewModel$b;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusViewModel extends ViewModel implements l {
    public static final a Companion = null;
    public static final int MSG_INIT_CHORUS_SONG_LIST = 1;
    public static final String TAG = "ChorusViewModel";
    private MutableLiveData<ChorusInfo> chorusInfo;
    private final CompositeDisposable compositeDisposable;
    private final DataCenter dataCenter;
    private b handler;
    private MutableLiveData<Boolean> openStatus;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends Handler {
        public final /* synthetic */ ChorusViewModel a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super.handleMessage(r2);
            if (r2.what != 1) goto L7;
            this.a.initChorusSongList();
            return;
        }

        public b(ChorusViewModel r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            List<de.b> r4 = ((com.bytedance.android.livesdk.ktvimpl.chorus.api.a) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r3)).data).a();
            if (r4 == null) goto L10;
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a(ChorusViewModel.TAG, "initChorusSongList count :" + r4.size());
            ChorusContext r0 = ChorusContext.Companion.getContext();
            if (r0 == null) goto L11;
            n<List<MusicPanel>> r1 = r0.getChorusSelectedSongList();
            if (r1 == null) goto L12;
            r1.setValue(i.a(r4));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a(ChorusViewModel.TAG, "initChorusSongList failed " + ((Throwable) r3).getMessage());
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a(ChorusViewModel.TAG, "tryPause success");
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r6 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
            if (r6 == null) goto L6;
            r6.sendEvent(new KtvRoomLyricsStateMachineConfig.a.b(0), ChorusViewModel.TAG);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.ktvimpl.chorus.a.a(ChorusViewModel.TAG, "tryPause failed " + ((Throwable) r3).getMessage());
        }
    }

    static {
        Companion = new a();
    }

    public final void initChorusSongList() {
        o r0 = m.i();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L12;
        long r3 = r2.getRoomId();
        RxUtilKt.c(((ChorusApi) com.bytedance.android.live.network.c.b().e(ChorusApi.class)).getChorusOrderedSongList(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(c.a, d.a), this.compositeDisposable);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onCleared() {
        super.onCleared();
        o r0 = m.i();
        if (r0 == null) goto L9;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(this);
    L9:
        this.compositeDisposable.dispose();
        this.handler.removeMessages(1);
    }

    public final MutableLiveData<ChorusInfo> getChorusInfo() {
        return this.chorusInfo;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final MutableLiveData<Boolean> getOpenStatus() {
        return this.openStatus;
    }

    public ChorusViewModel(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.dataCenter = r2;
        this.chorusInfo = new MutableLiveData();
        this.openStatus = new MutableLiveData();
        this.compositeDisposable = new CompositeDisposable();
        this.handler = new b(this, Looper.getMainLooper());
        o r3 = m.i();
        if (r3 == null) goto L10;
        j r4 = r3.getMessageManager();
        if (r4 == null) goto L11;
        vlc.d r5 = (vlc.d) r4.getValue();
        if (r5 == null) goto L12;
        r5.addMessageListener(MessageType.CHORUS_MESSAGE.getIntType(), this);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void removeSong(final MusicPanel r18) {
        o r1 = m.i();
        if (r1 == null) goto L22;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L22;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L22;
        long r4 = System.currentTimeMillis();
        int r5 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g r6 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
        long r7 = r3.getId();
        long r8 = r3.getId();
        long r9 = r18.a.getMId();
        OrderInfo r10 = r18.a.getOrderInfo();
        if (r10 == null) goto L15;
        InteractiveSongUserInfo r11 = r10.getTopUser();
        if (r11 == null) goto L15;
        String r12 = r11.getIdString();
        if (r12 == null) goto L15;
    L16:
        Disposable r0 = r6.e(r4, r7, r8, r9, r12, true, r18.a.getSongType(), KtvUtilsKt.i(r18), new AnonymousClass1(r18), new AnonymousClass2(r18));
        if (r0 == null) goto L20;
        RxUtilKt.c(r0, this.compositeDisposable);
        return;
    L20:
        return;
    L15:
        r12 = "";
    }

    private final void tryPause(MusicPanel r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        o r0 = m.i();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L13;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L14;
        long r5 = r2.getRoomId();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).pausePlayMusic(r12.a.getMId(), MusicActionType.PAUSE.ordinal(), r5, r12.a.getSongType(), d5.c(r12.a.getOrderUserIdString()), r12.a.getOrderUserIdString()).compose(RxUtil.rxSchedulerHelper()).subscribe(e.a, f.a), this.compositeDisposable);
        return;
    L14:
        return;
    L13:
        return;
    }

    public void onMessage(tlc.d r20) {
        if ((r20 instanceof s2) == false) goto L136;
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).receiveChorusMessage((f0) r20);
        s2 r1 = (s2) r20;
        int r3 = r1.getMsgType();
        MusicPanel r8 = null;
        if (r3 != 1) goto L7;
        OpenChorusContent r4 = r1.getOpenChorusContent();
        if (r4 == null) goto L134;
        this.chorusInfo.setValue(r4.getChorusInfo());
        com.bytedance.android.livesdk.ktvimpl.chorus.b r5 = com.bytedance.android.livesdk.ktvimpl.chorus.c.a;
        com.bytedance.android.livesdk.ktvimpl.chorus.c.a.b = r4.getChorusInfo();
        String r6 = k.n(IMiddlewareUserService.class).user().n().toString();
        u r9 = m.d();
        if (r9 == null) goto L76;
        j r10 = r9.J();
        if (r10 == null) goto L76;
        LivePlayModeLogContext r11 = (LivePlayModeLogContext) r10.getValue();
        if (r11 == null) goto L76;
        r11.addPlayMode(23);
    L76:
        if (a0.d(this.dataCenter, false) == false) goto L132;
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r7 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r7 == null) goto L80;
        KtvRoomLyricsStateMachineConfig.d r12 = r7.getCurState();
    L81:
        KtvComponentContext.a r13 = KtvComponentContext.Companion;
        KtvComponentContext r14 = r13.getContext();
        if (r14 == null) goto L86;
        n<Integer> r15 = r14.getKtvComponentStatus();
        if (r15 == null) goto L86;
        Integer r16 = (Integer) r15.getValue();
    L87:
        if (r16 != null) goto L90;
    L91:
        if (r14 == null) goto L111;
        n<x> r17 = r14.getKtvComponentCmd();
        if (r17 == null) goto L111;
        r17.setValue(new x(1, Boolean.FALSE, "pk_chorus", null, Boolean.TRUE, null, 3, null, 168));
    L111:
        KtvComponentContext r18 = r13.getContext();
        if (r18 == null) goto L121;
        n<KtvComponentUIContext> r19 = r18.getKtvComponentUIContext();
        if (r19 == null) goto L121;
        KtvComponentUIContext r21 = (KtvComponentUIContext) r19.getValue();
        if (r21 == null) goto L121;
        MutableLiveData<Boolean> r22 = r21.getScoreOpen();
        if (r22 == null) goto L121;
        r8 = (Boolean) r22.getValue();
    L121:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L133;
        KtvComponentContext r23 = r13.getContext();
        if (r23 == null) goto L131;
        n<KtvComponentUIContext> r24 = r23.getKtvComponentUIContext();
        if (r24 == null) goto L131;
        KtvComponentUIContext r25 = (KtvComponentUIContext) r24.getValue();
        if (r25 == null) goto L131;
        MutableLiveData<Boolean> r26 = r25.getScoreOpen();
        if (r26 == null) goto L131;
        r26.setValue(Boolean.FALSE);
    L131:
        com.bytedance.android.livesdk.sharedpref.e r27 = com.bytedance.android.livesdk.sharedpref.c.H;
        Boolean r28 = Boolean.FALSE;
        r27.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r27, r28);
    L133:
        this.handler.sendMessageDelayed(this.handler.obtainMessage(1), 400);
        goto L134
    L90:
        if (r16.intValue() != 1) goto L91;
        if ((r12 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L98;
    L99:
        ChorusInfo r29 = r4.getChorusInfo();
        if (r29 == null) goto L102;
        String r30 = r29.getLeadSingerIdString();
    L104:
        if (Intrinsics.areEqual(r30, r6) == false) goto L106;
        tryPause(r12.b());
        goto L111
    L106:
        n<com.bytedance.android.livesdk.ktvimpl.base.i> r31 = KtvContext.a.g().getKtvCoreController();
        if (r31 == null) goto L111;
        com.bytedance.android.livesdk.ktvimpl.base.i r32 = (com.bytedance.android.livesdk.ktvimpl.base.i) r31.getValue();
        if (r32 == null) goto L111;
        r32.u();
        goto L111
    L102:
        r30 = null;
        goto L104
    L98:
        if ((r12 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L111;
    L86:
        r16 = null;
        goto L87
    L80:
        r12 = null;
        goto L81
    L132:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.d();
    L134:
        this.openStatus.setValue(Boolean.TRUE);
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a(TAG, "onMessage  open chorus");
        return;
    L7:
        if (r3 == 2) goto L21;
        if (r3 != 3) goto L145;
        v2 r33 = r1.getChorusOrderedSongListChangeContent();
        if (r33 == null) goto L137;
        List r34 = r33.a();
        if (r34 == null) goto L15;
        List<MusicPanel> r35 = i.a(r34);
    L16:
        ChorusContext r36 = ChorusContext.Companion.getContext();
        if (r36 == null) goto L138;
        n<List<MusicPanel>> r37 = r36.getChorusSelectedSongList();
        if (r37 == null) goto L139;
        r37.setValue(r35);
        return;
    L139:
        return;
    L138:
        return;
    L15:
        r35 = CollectionsKt.emptyList();
        goto L16
    L137:
        return;
    L145:
        return;
    L21:
        CloseChorusContent r38 = r1.getCloseChorusContent();
        if (r38 == null) goto L57;
        this.chorusInfo.setValue(r38.getChorusInfo());
        String r39 = k.n(IMiddlewareUserService.class).user().n().toString();
        KtvContext.Companion.getClass();
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r40 = KtvContext.a.g().getKtvCoreViewModel();
        if (r40 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r41 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r40.getValue();
    L27:
        ChorusInfo r42 = r38.getChorusInfo();
        if (r42 == null) goto L30;
        String r43 = r42.getLeadSingerIdString();
    L32:
        if ((true ^ Intrinsics.areEqual(r43, r39)) == false) goto L43;
        if (a0.d(this.dataCenter, false) == false) goto L43;
        n<com.bytedance.android.livesdk.ktvimpl.base.i> r44 = KtvContext.a.g().getKtvCoreController();
        if (r44 == null) goto L40;
        com.bytedance.android.livesdk.ktvimpl.base.i r45 = (com.bytedance.android.livesdk.ktvimpl.base.i) r44.getValue();
        if (r45 == null) goto L40;
        r45.u();
    L40:
        if (r41 == null) goto L43;
        r41.sendEvent(KtvRoomLyricsStateMachineConfig.a.h.c, TAG);
    L43:
        if (a0.d(this.dataCenter, false) == false) goto L55;
        ChorusContext r46 = ChorusContext.Companion.getContext();
        if (r46 == null) goto L51;
        n<List<MusicPanel>> r47 = r46.getChorusSelectedSongList();
        if (r47 == null) goto L51;
        List r48 = (List) r47.getValue();
        if (r48 == null) goto L51;
        r8 = (MusicPanel) CollectionsKt.getOrNull(r48, 0);
    L51:
        if (r8 == null) goto L55;
        if (Intrinsics.areEqual(r8.g(), r39) == false) goto L55;
        removeSong(r8);
    L55:
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a(TAG, "onMessage  close chorus reason " + r38.getCloseReason());
        goto L57
    L30:
        r43 = null;
        goto L32
    L26:
        r41 = null;
    L57:
        if (a0.d(this.dataCenter, false) == true) goto L59;
        com.bytedance.android.livesdk.ktvimpl.chorus.c.e();
    L59:
        this.openStatus.setValue(Boolean.FALSE);
        u r49 = m.d();
        if (r49 == null) goto L141;
        j r50 = r49.J();
        if (r50 == null) goto L142;
        LivePlayModeLogContext r51 = (LivePlayModeLogContext) r50.getValue();
        if (r51 == null) goto L143;
        r51.removePlayMode(23);
        return;
    L143:
        return;
    L142:
        return;
    L141:
        return;
    }

    public final void setChorusInfo(MutableLiveData<ChorusInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chorusInfo = r2;
    }

    public final void setOpenStatus(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.openStatus = r2;
    }
}
