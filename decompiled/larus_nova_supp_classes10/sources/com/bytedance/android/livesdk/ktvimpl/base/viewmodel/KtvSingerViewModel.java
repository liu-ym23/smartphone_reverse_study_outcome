package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.c0;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.base.sei.t;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomSingerController;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.v;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicActionType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdk.message.model.td;
import com.bytedance.android.livesdk.message.model.yh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mb0.f;
import org.json.JSONObject;
import vlc.l;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\\\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001f\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010k\u001a\u00020j¢\u0006\u0004\bu\u0010vJ\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0018H\u0016J\n\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0016J\b\u0010-\u001a\u00020\u000bH\u0016J\b\u0010.\u001a\u00020\u000bH\u0014J\u0012\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u00102\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u00104\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u000203H\u0016J@\u0010=\u001a\u00020\u000b2\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u001d2\b\b\u0002\u0010<\u001a\u00020\u0018J\b\u0010>\u001a\u00020\u000bH\u0016J\u0010\u0010A\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010B\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?H\u0016R$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR*\u0010R\u001a\u0016\u0012\u0004\u0012\u00020P\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060Q\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010WR\u001a\u0010a\u001a\u00020`8\u0016X\u0096\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0017\u0010f\u001a\u00020e8\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0017\u0010k\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0016\u0010r\u001a\u0004\u0018\u00010o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006w"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/KtvSingerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/d;", "", "isKtvMode", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "getOrderedSongDataContext", "isSinger", "", "handleCurrentUserSingerRoleChange", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "songList", "handleSongListChange", "Lcom/bytedance/android/livesdk/message/model/l8;", "message", "onKtvMessage", "Lcom/bytedance/android/livesdk/message/model/yh;", "content", "isMessageContentValid", "firstSelectedMusicOrNull", "", "action", "", "musicId", "updateSingerState", "", "source", "initLiveStreamWrapper", "Ltlc/d;", "onMessage", "cutMusic", "origin", "toggleOrigin", "paused", "togglePause", "line", "updateCurrentLyricsLine", "Lcom/bytedance/android/livesdk/ktvimpl/base/i;", "lazyInitKtvCoreController", "onPageStop", "onPageResume", "onPageCreate", "onCleared", "musicPanel", "isNeedMusicDownload", "challengeReportStr", "cutFromChallenge", "Lcom/bytedance/android/livesdk/message/model/td;", "updateSingHot", "", "tone", "standardTone", "score", "index", "hitType", "anchorId", "comboCount", "sendMidiSei", "clearData", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "onSeiResult", "accept", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomSingerController;", "singerController", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomSingerController;", "getSingerController", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomSingerController;", "setSingerController", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomSingerController;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "prepareMusicPanel", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "Lkotlin/Pair;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "pendingPauseObserver", "Lkotlin/Pair;", "lastMusicId", "Ljava/lang/Long;", "isPageResumed", "Z", "lastIsSinger", "Ljava/lang/Boolean;", "currentUserId", "Ljava/lang/String;", "com/bytedance/android/livesdk/ktvimpl/base/viewmodel/KtvSingerViewModel$c", "mCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/KtvSingerViewModel$c;", "enableFilterMysEI", "Loe2/b;", "ktvRoomProvider", "Loe2/b;", "getKtvRoomProvider", "()Loe2/b;", "Lsb0/b;", "dataEntityProxy", "Lsb0/b;", "getDataEntityProxy", "()Lsb0/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "coreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "getCoreViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "Lcom/bytedance/android/live/liveinteract/plantform/utils/d0;", "getLiveStreamInfoSenderManager", "()Lcom/bytedance/android/live/liveinteract/plantform/utils/d0;", "liveStreamInfoSenderManager", "isAnchor", "()Z", "<init>", "(Loe2/b;Lsb0/b;Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSingerViewModel extends ViewModel implements l, com.bytedance.android.livesdk.ktvimpl.base.sei.b, com.bytedance.android.livesdk.ktvimpl.base.sei.c, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d {
    private final CompositeDisposable compositeDisposable;
    private final BaseCoreViewModel coreViewModel;
    private final String currentUserId;
    private final sb0.b dataEntityProxy;
    private final boolean enableFilterMysEI;
    private boolean isPageResumed;
    private final oe2.b ktvRoomProvider;
    private Boolean lastIsSinger;
    private Long lastMusicId;
    private final c mCoreListener;
    private Pair<? extends LifecycleOwner, ? extends Observer<Boolean>> pendingPauseObserver;
    private MusicPanel prepareMusicPanel;
    private KtvRoomSingerController singerController;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvSingerViewModel a;

        public a(KtvSingerViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvSingerViewModel r0 = this.a;
            KtvSingerViewModel.access$handleSongListChange(r0, (List) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvSingerViewModel a;

        public b(KtvSingerViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvSingerViewModel.access$handleCurrentUserSingerRoleChange(this.a, ((Boolean) r2).booleanValue());
        }
    }

    public static final class c extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvSingerViewModel a;

        public c(KtvSingerViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "transition");
            KtvRoomSingerController r0 = this.a.getSingerController();
            if (r0 == null) goto L6;
            r0.c(r2);
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void b(KtvRoomLyricsStateMachineConfig.b r2) {
            Intrinsics.checkNotNullParameter(r2, "sideEffect");
            KtvRoomSingerController r0 = this.a.getSingerController();
            if (r0 == null) goto L6;
            r0.t(r2);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public d(long r1, long r3, int r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiUpdateSingerState, System.currentTimeMillis() - this.a, ((ExtraResponse) r8).logId);
            int r0 = f.a;
            f.s(this.b, ((ExtraResponse) r8).logId, this.c);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public e(long r1, long r3, int r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiUpdateSingerState, System.currentTimeMillis() - this.a, r8);
            int r0 = f.a;
            f.r(this.b, r8, this.c);
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void onPageCreate() {
        this.isPageResumed = true;
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L8;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = r0.q();
        if (r1 == null) goto L9;
        r1.onPageCreate();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void onPageResume() {
        this.isPageResumed = true;
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L8;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = r0.q();
        if (r1 == null) goto L9;
        r1.onPageResume();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void onPageStop() {
        this.isPageResumed = false;
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L8;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = r0.q();
        if (r1 == null) goto L9;
        r1.onPageStop();
        return;
    L9:
        return;
    }

    private final MusicPanel firstSelectedMusicOrNull() {
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == false) goto L17;
        ChorusContext r1 = r0.getContext();
        Object r2 = null;
        if (r1 == null) goto L22;
        n<List<MusicPanel>> r3 = r1.getChorusSelectedSongList();
        if (r3 == null) goto L23;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L24;
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        if ((!((MusicPanel) r6).e) == false) goto L12;
        r2 = r6;
    L25:
        return (MusicPanel) r2;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L17:
        KtvContext.Companion.getClass();
        return com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
    }

    private final d0 getLiveStreamInfoSenderManager() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L7;
        n<d0> r1 = r0.getStreamInfoSender();
        if (r1 == null) goto L7;
        return (d0) r1.getValue();
    L7:
        return null;
    }

    private final boolean isAnchor() {
        return this.dataEntityProxy.b().isAnchor();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void cutMusic() {
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L6;
        KtvRoomSingerController.n(r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public i lazyInitKtvCoreController() {
        KtvRoomSingerController r0 = this.singerController;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p();
    }

    public void onCleared() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i<m> r1 = r0.getSeiProcessor();
        if (r1 == null) goto L9;
        m r2 = (m) r1.getValue();
        if (r2 == null) goto L9;
        r2.g(this);
    L9:
        BaseCoreViewModel r3 = this.coreViewModel;
        if (r3 == null) goto L12;
        r3.unregisterKtvCoreListener(this.mCoreListener);
    L12:
        KtvRoomSingerController r4 = this.singerController;
        if (r4 == null) goto L15;
        r4.i();
    L15:
        this.singerController = null;
        this.prepareMusicPanel = null;
        this.compositeDisposable.dispose();
        DataCenter r5 = this.dataEntityProxy.getDataCenter();
        if (r5 == null) goto L21;
        vlc.d r6 = (vlc.d) r5.get("data_message_manager", null);
        if (r6 == null) goto L22;
        r6.removeMessageListener(this);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void clearData() {
        onCleared();
    }

    public final BaseCoreViewModel getCoreViewModel() {
        return this.coreViewModel;
    }

    public final sb0.b getDataEntityProxy() {
        return this.dataEntityProxy;
    }

    public oe2.b getKtvRoomProvider() {
        return this.ktvRoomProvider;
    }

    public final KtvRoomSingerController getSingerController() {
        return this.singerController;
    }

    private final OrderedSongDataContext getOrderedSongDataContext(boolean r1) {
        if (r1 == false) goto L5;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L5:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    private final void handleCurrentUserSingerRoleChange(boolean r19) {
        if (KtvSettingHelper.w() == true) goto L5;
    L8:
        this.lastIsSinger = Boolean.valueOf(r19);
        String r4 = bb0.b.b();
        ALogger.i(r4, ("currentUserIsSinger:" + r19) + ", invoke class :KtvSingerViewModel");
        KtvRoomSingerController r2 = this.singerController;
        if (r2 == null) goto L11;
        r2.i();
    L11:
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        String r5 = null;
        if (this.enableFilterMysEI == false) goto L15;
        if (r19 == false) goto L15;
        ((m) r3.getSeiProcessor().getValue()).a = this.currentUserId;
    L16:
        if (r19 == false) goto L84;
        sb0.b r6 = this.dataEntityProxy;
        CompositeDisposable r7 = this.compositeDisposable;
        oe2.b r9 = getKtvRoomProvider();
        oe2.b r8 = getKtvRoomProvider();
        if (r8 == null) goto L20;
        com.bytedance.android.live.pushstream.d r10 = r8.h(isAnchor());
    L21:
        this.singerController = new KtvRoomSingerController(r6, r7, r10, r9, new AnonymousClass1(this));
        BaseCoreViewModel r1 = this.coreViewModel;
        boolean r11 = false;
        if (r1 == null) goto L24;
        r1.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_EFFECT}), this.mCoreListener, false);
    L24:
        KtvRoomSingerController r12 = this.singerController;
        if (r12 == null) goto L60;
        ChorusContext.a r13 = ChorusContext.Companion;
        if (r13.c() == false) goto L40;
        ChorusContext r14 = r13.getContext();
        if (r14 == null) goto L60;
        List<MusicPanel> r15 = r14.getChorusNotSelfSeeingMusicList();
        if (r15 == null) goto L60;
        MusicPanel r16 = (MusicPanel) CollectionsKt.getOrNull(r15, 0);
        if (r16 == null) goto L60;
        String r17 = "init singer controller,TuningNext," + r16.a.getMTitle();
        ALogger.i(bb0.b.b(), r17 + ", invoke class :" + KtvRoomSingerController.class.getSimpleName());
        if ((!KtvUtilsKt.m(r16)) == false) goto L37;
        KtvMusicManager.e(KtvMusicManager.m, r16, new v(r12), false, null, false, 28);
        goto L60
    L37:
        BaseCoreViewModel r18 = r12.o();
        if (r18 == null) goto L60;
        r18.sendEvent(new KtvRoomLyricsStateMachineConfig.a.i(r16), "KtvRoomSingerController");
        goto L60
    L40:
        ALogger.i("logKtvMainPath", "KtvRoomSingerController tryTuningNext, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        MusicPanel r20 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        int r21 = f.a;
        if (r20 == null) goto L43;
        Long r22 = Long.valueOf(r20.c());
    L44:
        if (r20 == null) goto L46;
        r5 = r20.e();
    L46:
        JSONObject r110 = new JSONObject();
        if (r22 == null) goto L49;
        r22.longValue();
        r110.put("songId", r22.longValue());
    L49:
        if (r5 != null) goto L51;
    L52:
        r11 = true;
    L53:
        if (r11 == true) goto L55;
        r110.put("musicName", r5);
    L55:
        int r23 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "transitionNext", 0, null, r110, 88);
        if (r20 == null) goto L60;
        String r24 = "init singer controller,TuningNext," + r20.a.getMTitle();
        ALogger.i(bb0.b.b(), r24 + ", invoke class :" + KtvRoomSingerController.class.getSimpleName());
        BaseCoreViewModel r25 = r12.o();
        if (r25 == null) goto L60;
        r25.sendEvent(new KtvRoomLyricsStateMachineConfig.a.i(r20), "KtvRoomSingerController");
        goto L60
    L51:
        if (r5.length() != 0) goto L53;
    L43:
        r22 = null;
    L60:
        Pair<? extends LifecycleOwner, ? extends Observer<Boolean>> r26 = this.pendingPauseObserver;
        if (r26 == null) goto L67;
        KtvRoomSingerController r27 = this.singerController;
        if (r27 == null) goto L67;
        MutableLiveData<Boolean> r28 = r27.g;
        if (r28 == null) goto L67;
        r28.observe((LifecycleOwner) r26.getFirst(), (androidx.lifecycle.Observer) r26.getSecond());
    L67:
        initLiveStreamWrapper("handleCurrentUserSingerRoleChange");
        com.bytedance.live.datacontext.i<m> r29 = r3.getSeiProcessor();
        if (r29 == null) goto L73;
        m r30 = (m) r29.getValue();
        if (r30 == null) goto L73;
        r30.c(this, 5.0f);
    L73:
        if (this.isPageResumed == false) goto L79;
        KtvRoomSingerController r31 = this.singerController;
        if (r31 == null) goto L79;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r32 = r31.q();
        if (r32 == null) goto L79;
        r32.onPageResume();
    L79:
        KtvRoomSingerController r33 = this.singerController;
        if (r33 == null) goto L92;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r34 = r33.q();
        if (r34 == null) goto L93;
        r34.c();
        return;
    L93:
        return;
    L92:
        return;
    L20:
        r10 = null;
        goto L21
    L84:
        ((m) r3.getSeiProcessor().getValue()).g(this);
        BaseCoreViewModel r35 = this.coreViewModel;
        if (r35 == null) goto L87;
        r35.unregisterKtvCoreListener(this.mCoreListener);
    L87:
        KtvRoomSingerController r36 = this.singerController;
        if (r36 == null) goto L90;
        r36.i();
    L90:
        this.singerController = null;
        this.prepareMusicPanel = null;
        return;
    L15:
        ((m) r3.getSeiProcessor().getValue()).a = null;
        goto L16
    L5:
        if (Intrinsics.areEqual(this.lastIsSinger, Boolean.valueOf(r19)) == false) goto L8;
        String r37 = bb0.b.b();
        ALogger.i(r37, ("handleCurrentUserSingerRoleChange ;; is same state ;; isSinger == " + r19) + ", invoke class :KtvSingerViewModel");
    }

    private final void handleSongListChange(List<MusicPanel> r6) {
        if (r6 == null) goto L26;
        MusicPanel r7 = (MusicPanel) CollectionsKt.getOrNull(r6, 0);
        if (r7 == null) goto L27;
        KtvMusic r0 = r7.a;
        Long r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getOrderUserIdString();
    L10:
        if (Intrinsics.areEqual(r2, this.currentUserId) == false) goto L28;
        KtvMusic r3 = r7.a;
        if (r3 == null) goto L14;
        r1 = Long.valueOf(r3.getMId());
    L14:
        long r4 = r1.longValue();
        Long r5 = this.lastMusicId;
        if (r5 != null) goto L18;
    L19:
        this.lastMusicId = Long.valueOf(r4);
        if (((Boolean) KtvSettingHelper.s1.getValue()).booleanValue() == true) goto L22;
    L24:
        pd2.d.M(pd2.d.n, r7, "song_arrive");
        return;
    L22:
        if (this.singerController == null) goto L24;
        KtvContext.Companion.getClass();
        KtvContext.a.g().updateCurrentUserIsSinger(true);
        goto L24
    L18:
        if (r4 != r5.longValue()) goto L19;
        return;
    L28:
        return;
    L8:
        r2 = null;
        goto L10
    L27:
        return;
    }

    private final boolean isMessageContentValid(yh r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        MusicPanel r1 = firstSelectedMusicOrNull();
        if (r1 != null) goto L8;
        return false;
    L8:
        IBaseUser r2 = k.n(IMiddlewareUserService.class).user().b();
        String r3 = r2.getIdString();
        OrderInfo r4 = r1.a.getOrderInfo();
        Boolean r5 = null;
        if (r4 == null) goto L13;
        InteractiveSongUserInfo r6 = r4.getTopUser();
        if (r6 == null) goto L13;
        String r8 = r6.getIdString();
    L15:
        if ((!Intrinsics.areEqual(r3, r8)) == false) goto L20;
        if (ChorusContext.Companion.c() == true) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(r2.getIdString(), r7.d())) == false) goto L25;
        if (ChorusContext.Companion.c() == true) goto L25;
        return false;
    L25:
        if (((Boolean) KtvSettingHelper.r1.getValue()).booleanValue() == false) goto L27;
    L31:
        ChorusContext.a r9 = ChorusContext.Companion;
        if (r9.c() == true) goto L34;
    L36:
        int r10 = r7.a();
        if (r10 != MusicActionType.NONE.ordinal()) goto L40;
        return false;
    L40:
        if (r10 != MusicActionType.PAUSE.ordinal()) goto L50;
        KtvRoomSingerController r11 = this.singerController;
        if (r11 == null) goto L47;
        MutableLiveData<Boolean> r12 = r11.g;
        if (r12 == null) goto L47;
        r5 = (Boolean) r12.getValue();
    L47:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L59;
        return false;
    L59:
        return true;
    L50:
        if (r10 != MusicActionType.RESUME.ordinal()) goto L59;
        KtvRoomSingerController r13 = this.singerController;
        if (r13 == null) goto L57;
        MutableLiveData<Boolean> r14 = r13.g;
        if (r14 == null) goto L57;
        r5 = (Boolean) r14.getValue();
    L57:
        if ((!Intrinsics.areEqual(r5, Boolean.TRUE)) == false) goto L59;
        return false;
    L34:
        if (r9.d() == true) goto L36;
        return false;
    L27:
        if (Intrinsics.areEqual(r2.getIdString(), r7.c()) == false) goto L31;
        if (ChorusContext.Companion.c() == true) goto L31;
        return false;
    L13:
        r8 = null;
        goto L15
    }

    private final void onKtvMessage(l8 r3) {
        if (r3.getMessageType() == 5) goto L6;
        return;
    L6:
        if (isMessageContentValid(r3.getPausePlaySongContent()) == false) goto L11;
        KtvRoomSingerController r4 = this.singerController;
        if (r4 == null) goto L12;
        r4.u();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public boolean accept(w r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r5 = r4.b;
        String r1 = null;
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r5 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r6 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r5;
        if (r6 == null) goto L23;
        String r7 = r6.b();
        o r2 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L15;
        IRoom r8 = (IRoom) r3.getValue();
        if (r8 == null) goto L15;
        r1 = r8.getOwnerUserIdString();
    L15:
        if (Intrinsics.areEqual(r7, r1) == true) goto L24;
        ChorusContext.a r9 = ChorusContext.Companion;
        if (r9.c() == false) goto L22;
        if (r9.d() == true) goto L22;
        return true;
    L22:
        return false;
    L24:
        return true;
    L23:
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void cutFromChallenge(String r2) {
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L8;
        if (r2 != null) goto L6;
        r2 = "sing_challenge";
    L6:
        r0.m = r2;
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void initLiveStreamWrapper(String r6) {
        StringBuilder r0 = new StringBuilder("initLiveStreamWrapper source:");
        r0.append(r6);
        r0.append(", liveStreamWrapper is null:");
        KtvRoomSingerController r7 = this.singerController;
        c0 r1 = null;
        if (r7 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r8 = r7.a;
    L6:
        boolean r2 = false;
        if (r8 != null) goto L9;
        boolean r9 = true;
    L10:
        r0.append(r9);
        r0.append(", ktvRoomProvider.LiveStream is null:");
        oe2.b r10 = getKtvRoomProvider();
        if (r10 == null) goto L13;
        com.bytedance.android.live.pushstream.d r11 = r10.h(isAnchor());
    L14:
        if (r11 != null) goto L16;
        r2 = true;
    L16:
        r0.append(r2);
        String r12 = r0.toString();
        ALogger.i(bb0.b.b(), "KtvSingerViewModel :" + r12 + ", invoke class :KtvSingerViewModel");
        KtvRoomSingerController r13 = this.singerController;
        if (r13 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r14 = r13.a;
    L20:
        if (r14 != null) goto L22;
    L24:
        oe2.b r15 = getKtvRoomProvider();
        if (r15 == null) goto L40;
        com.bytedance.android.live.pushstream.d r16 = r15.h(isAnchor());
        if (r16 == null) goto L41;
        KtvRoomSingerController r3 = this.singerController;
        if (r3 == null) goto L42;
        d0 r4 = getLiveStreamInfoSenderManager();
        if (r4 != null) goto L33;
    L38:
        r3.a = new com.bytedance.android.livesdk.ktvimpl.base.sei.f(r16, r1);
        return;
    L33:
        if (isAnchor() == false) goto L38;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L37;
        AtomicInteger r5 = c0.c;
        r1 = c0.a.b(r4);
        goto L38
    L37:
        AtomicInteger r17 = c0.c;
        r1 = c0.a.a(r4);
        goto L38
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L22:
        if (((Boolean) KtvSettingHelper.w1.getValue()).booleanValue() == false) goto L24;
        return;
    L19:
        r14 = null;
        goto L20
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = false;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public boolean isNeedMusicDownload(MusicPanel r3) {
        if (this.singerController == null) goto L11;
        int r0 = KtvRoomSingerController.H;
        if (r3 != null) goto L7;
        boolean r4 = false;
    L8:
        if (r4 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = !KtvUtilsKt.m(r3);
        goto L8
    L11:
        return false;
    }

    public void onMessage(tlc.d r2) {
        if ((r2 instanceof l8) == false) goto L6;
        onKtvMessage((l8) r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(w r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r4 = r3.b;
        if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r4;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.d() != 1) goto L14;
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L15;
        r0.f(r5);
        return;
    L15:
        return;
    }

    public final void setSingerController(KtvRoomSingerController r1) {
        this.singerController = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void toggleOrigin(boolean r4) {
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L20;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = r0.q();
        boolean r2 = false;
        if (r1 == null) goto L7;
        r1.q(r4, false);
    L7:
        MutableLiveData<Boolean> r5 = r0.f;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3 = r0.q();
        if (r3 == null) goto L10;
        Boolean r6 = Boolean.valueOf(r3.R());
    L11:
        r5.setValue(r6);
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r7 = KtvRoomContext.a.a();
        if (r7 == null) goto L21;
        com.bytedance.live.datacontext.k<Boolean> r8 = r7.getOriginSwitch();
        if (r8 == null) goto L22;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r9 = r0.q();
        if (r9 == null) goto L18;
        r2 = r9.R();
    L18:
        r8.post(Boolean.valueOf(r2));
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r6 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void togglePause(boolean r5) {
        String r1 = bb0.b.b();
        ALogger.i(r1, ("togglePause:" + r5) + ", invoke class :KtvSingerViewModel");
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r2 = r0.getCurState();
    L7:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L9;
        return;
    L9:
        MusicPanel r3 = firstSelectedMusicOrNull();
        if (r3 == null) goto L18;
        Lazy r4 = KtvMusicControlManager.d;
        KtvMusicControlManager r6 = KtvMusicControlManager.a.a();
        com.bytedance.android.livesdk.ktvimpl.base.controlnode.d r7 = new com.bytedance.android.livesdk.ktvimpl.base.controlnode.d(r3, r5, ModeType.KTV_MODE);
        KtvRoomSingerController r8 = this.singerController;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "node");
        if (r8 == null) goto L14;
        r6.g(r7, r8);
    L14:
        r6.b.b(r7);
        Function1 r9 = r6.c;
        if (r9 == null) goto L19;
        Unit r10 = (Unit) r9.invoke(r7);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d
    public void updateCurrentLyricsLine(int r2) {
        KtvRoomSingerController r0 = this.singerController;
        if (r0 == null) goto L6;
        r0.e = r2;
        return;
    }

    public void updateSingHot(td r14) {
        Intrinsics.checkNotNullParameter(r14, "message");
        KtvRoomSingerController r1 = this.singerController;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r14, "message");
        long r2 = r14.songId;
        long r4 = r14.hot;
        int r0 = r14.hotLevel;
        String r6 = r14.getUserIdString();
        int r7 = r14.hotStatus;
        long r8 = r14.level2_thresHold;
        long r10 = r14.level3_thresHold;
        List<ILinkPlayerInfoBridge> r15 = t.a;
        Intrinsics.checkNotNullParameter(r6, "userId");
        JSONObject r16 = new JSONObject().put("song_id", r2).put("hot", r4).put("hot_level", r0).put("user_id", t.h(r6)).put("hot_status", r7).put("level2_threshold", r8).put("level3_threshold", r10);
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r3 = r1.a;
        if (r3 == null) goto L9;
        r3.a("ktv_hot_sei", r16);
        return;
    L9:
        return;
    }

    public static final /* synthetic */ void access$handleCurrentUserSingerRoleChange(KtvSingerViewModel r0, boolean r1) {
        r0.handleCurrentUserSingerRoleChange(r1);
    }

    public static final /* synthetic */ void access$handleSongListChange(KtvSingerViewModel r0, List r1) {
        r0.handleSongListChange(r1);
    }

    private final void updateSingerState(int r18, long r19) {
        long r7 = System.currentTimeMillis();
        long r12 = this.dataEntityProxy.b().getRoomId();
        this.compositeDisposable.add(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).updateSingerState(r12, r12, r19, r18).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r7, r19, r18), new e(r7, r19, r18)));
    }

    public KtvSingerViewModel(oe2.b r8, sb0.b r9, BaseCoreViewModel r10) {
        Intrinsics.checkNotNullParameter(r8, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r9, "dataEntityProxy");
        Intrinsics.checkNotNullParameter(r10, "coreViewModel");
        this.ktvRoomProvider = r8;
        this.dataEntityProxy = r9;
        this.coreViewModel = r10;
        CompositeDisposable r11 = new CompositeDisposable();
        this.compositeDisposable = r11;
        IMiddlewareUserService r12 = k.f(IMiddlewareUserService.class);
        if (r12 == null) goto L9;
        com.bytedance.android.livesdk.user.e r13 = r12.user();
        if (r13 == null) goto L9;
        String r14 = r13.n();
        if (r14 == null) goto L9;
    L10:
        this.currentUserId = r14;
        this.mCoreListener = new c(this);
        this.enableFilterMysEI = ((Boolean) h.Y3.getValue(null, h.a[257(0x101, float:3.6E-43)])).booleanValue();
        OrderedSongDataContext r15 = getOrderedSongDataContext$default(this, false, 1, null);
        if (r15 == null) goto L15;
        Disposable r16 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b.a.a(r15, false, new a(this), 3);
        if (r16 == null) goto L15;
        RxUtilKt.c(r16, r11);
    L15:
        KtvContext.Companion.getClass();
        handleCurrentUserSingerRoleChange(KtvContext.a.g().isCurrentUserIsSinger());
        Disposable r17 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new b(this), 3, null);
        if (r17 == null) goto L18;
        RxUtilKt.c(r17, r11);
    L18:
        DataCenter r18 = r9.getDataCenter();
        if (r18 == null) goto L24;
        vlc.d r19 = (vlc.d) r18.get("data_message_manager", null);
        if (r19 == null) goto L25;
        r19.addMessageListener(MessageType.KTV_MESSAGE.getIntType(), this);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r14 = null;
        goto L10
    }

    public static final /* synthetic */ void access$updateSingerState(KtvSingerViewModel r0, int r1, long r2) {
        r0.updateSingerState(r1, r2);
    }

    public static /* synthetic */ OrderedSongDataContext getOrderedSongDataContext$default(KtvSingerViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        KtvContext.Companion.getClass();
        r1 = KtvContext.a.g().isKtvMode();
    L6:
        return r0.getOrderedSongDataContext(r1);
    }

    public final void sendMidiSei(float r12, float r13, float r14, int r15, int r16, String r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "anchorId");
        KtvRoomSingerController r10 = this.singerController;
        if (r10 == null) goto L8;
        Intrinsics.checkNotNullParameter(r17, "anchorId");
        JSONObject r0 = t.a(r12, r13, r14, r15, r16, r17, r18, null, 0);
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r1 = r10.a;
        if (r1 == null) goto L9;
        r1.a("ktv_midi_sei", r0);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void sendMidiSei$default(KtvSingerViewModel r9, float r10, float r11, float r12, int r13, int r14, String r15, int r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        int r8 = 0;
    L6:
        r9.sendMidiSei(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }
}
