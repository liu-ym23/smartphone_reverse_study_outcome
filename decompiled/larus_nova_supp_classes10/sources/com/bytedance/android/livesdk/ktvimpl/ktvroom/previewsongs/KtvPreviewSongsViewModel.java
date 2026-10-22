package com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.model.api.y;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.rd;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002deB\u001f\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010`\u001a\u000205¢\u0006\u0004\ba\u0010bJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fJ\u0012\u0010$\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&J\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010-R\u0014\u00106\u001a\u0002058\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00107R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020!0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00107R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010-R!\u0010G\u001a\b\u0012\u0004\u0012\u00020B0A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR!\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010KR!\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010D\u001a\u0004\bN\u0010KR\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010-R\u0016\u0010Q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010-R\u0016\u0010R\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u00107R\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010`\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u00107¨\u0006f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/previewsongs/KtvPreviewSongsViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Ltb0/a;", "", "updatePreviewCardViewIfNeed", "", "show", "onPreviewCardStateChange", "prepareToRotateSongs", "changeSonsMenu", "doClear", "cancelTimerDispose", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "obtainSingState", "onInit", "onBizEnterRoom", "onBizLeaveRoom", "onViewHolderPause", "onViewHolderResume", "onBizHide", "onBizShow", "onBizDestory", "Ltlc/d;", "message", "onMessage", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "accept", "onSeiResult", "Lio/reactivex/Observable;", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getPreviewSongs", "curState", "isMusicStopped", "open", "", "logTrace", "setShowPreviewCard", "isShowPreviewCard", BaseCoreViewModel.CORE_TAG_STATE, "updateOrderSongListGetedState", "isPageShow", "Z", "isViewHolderResume", "isEnterRoom", "Lio/reactivex/disposables/CompositeDisposable;", "globalCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "roomCompositeDisposable", "isPreviewCardActive", "", "previewCardShowPeriodSec", "J", "Lio/reactivex/disposables/Disposable;", "timer", "Lio/reactivex/disposables/Disposable;", "lastReceivedStartMessage", "Ljava/util/LinkedList;", "guideSongsList", "Ljava/util/LinkedList;", "curOffset", "isAnchor", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/previewsongs/KtvPreviewSongsViewModel$b;", "refreshView$delegate", "Lcom/bytedance/live/datacontext/p;", "getRefreshView", "()Lcom/bytedance/live/datacontext/k;", "refreshView", "Lcom/bytedance/live/datacontext/m;", "showPreviewCard$delegate", "getShowPreviewCard", "()Lcom/bytedance/live/datacontext/m;", "showPreviewCard", "needDelayToShow$delegate", "getNeedDelayToShow", "needDelayToShow", "isOrderSongListGeted", "isShowFromOrderSongList", "showFromOrderSongListTime", "Lio/reactivex/functions/Action;", "dropExpired", "Lio/reactivex/functions/Action;", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "", "songCountInEachPage", "I", "getSongCountInEachPage", "()I", "setSongCountInEachPage", "(I)V", "roomId", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;IJ)V", "Companion", "a", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvPreviewSongsViewModel extends DataContext implements vlc.l, com.bytedance.android.livesdk.ktvimpl.base.sei.c, tb0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private static final long CARD_SHOW_PERIOD_SECOND_5 = 5;
    public static final int CHORUS_SONG_COUNT_IN_EACH_PAGE = 6;
    public static final a Companion = null;
    public static final int DEFAULT_SONG_COUNT_IN_EACH_PAGE = 4;
    private static final long FETCH_COUNT_ONCE = 15;
    public static final int MV_SONG_COUNT_IN_EACH_PAGE = 5;
    public static final String TAG = "KtvPreviewSongsViewModel";
    private long curOffset;
    private final Action dropExpired;
    private final CompositeDisposable globalCompositeDisposable;
    private final LinkedList<MusicPanel> guideSongsList;
    private boolean isAnchor;
    private boolean isEnterRoom;
    private boolean isOrderSongListGeted;
    private boolean isPageShow;
    private boolean isPreviewCardActive;
    private boolean isShowFromOrderSongList;
    private boolean isViewHolderResume;
    private final KtvContext ktvContext;
    private long lastReceivedStartMessage;
    private final p needDelayToShow$delegate;
    private final long previewCardShowPeriodSec;
    private final p refreshView$delegate;
    private final CompositeDisposable roomCompositeDisposable;
    private final long roomId;
    private long showFromOrderSongListTime;
    private final p showPreviewCard$delegate;
    private int songCountInEachPage;
    private Disposable timer;

    public static final class a {
        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final List<MusicPanel> a;

            public a(List<MusicPanel> r2) {
                Intrinsics.checkNotNullParameter(r2, "songList");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel$b$b, reason: collision with other inner class name */
        public static final class C0027b extends b {
            public static final C0027b a = null;

            static {
                a = new C0027b();
            }

            public C0027b() {
            }
        }

        public static final class c extends b {
        }

        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsViewModel a;

        public c(KtvPreviewSongsViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            if ((!r5.isEmpty()) == true) goto L5;
            return;
        L5:
            if (((Boolean) this.a.getNeedDelayToShow().getValue()).booleanValue() == true) goto L7;
            this.a.setShowPreviewCard(true, "newRound");
        L7:
            List r6 = r5;
            Iterator<T> r0 = r6.iterator();
        L9:
            if (r0.hasNext() == false) goto L13;
            MusicPanel r1 = (MusicPanel) r0.next();
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = KtvModeOrderSongDataContext.Companion.a();
            if (r2 == null) goto L9;
            r2.updateMusicPanelState(r1);
            goto L9
        L13:
            this.a.getRefreshView().post(new b.a(CollectionsKt.take(r6, this.a.getSongCountInEachPage())));
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (v.a() == false) goto L6;
            r3.printStackTrace();
            return;
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ KtvPreviewSongsViewModel a;

        public e(KtvPreviewSongsViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            int r0 = this.a.getSongCountInEachPage();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            if ((!KtvPreviewSongsViewModel.access$getGuideSongsList$p(this.a).isEmpty()) == false) goto L7;
            KtvPreviewSongsViewModel.access$getGuideSongsList$p(this.a).removeFirst();
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r2) {
            LinkedList r3 = (LinkedList) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return CollectionsKt.toList(r3);
        }
    }

    public static final class g<T, R> implements Function {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r12) {
            Response r13 = (Response) r12;
            Intrinsics.checkNotNullParameter(r13, "response");
            List r14 = ((y) ((BaseResponse) r13).data).a();
            if (r14 == null) goto L9;
            List r15 = r14;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator<T> r16 = r15.iterator();
        L6:
            if (r16.hasNext() == false) goto L11;
            r0.add(new MusicPanel((KtvMusic) r16.next(), 0, "冷启推荐", false, MusicPanel.MusicPanelSource.KTV, null, null, 1073741782));
            goto L6
        L11:
            return r0;
        L9:
            return new ArrayList();
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsViewModel a;
        public final /* synthetic */ long b;

        public h(KtvPreviewSongsViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            List r7 = (List) r6;
            ALogger.i(KtvPreviewSongsViewModel.TAG, "getPreviewSongs API cost=" + (System.currentTimeMillis() - this.b));
            if (r7.isEmpty() == false) goto L5;
            KtvPreviewSongsViewModel.access$setCurOffset$p(this.a, 0);
            KtvPreviewSongsViewModel.access$getGuideSongsList$p(this.a).clear();
            return;
        L5:
            KtvPreviewSongsViewModel r0 = this.a;
            KtvPreviewSongsViewModel.access$setCurOffset$p(r0, KtvPreviewSongsViewModel.access$getCurOffset$p(r0) + 15);
            KtvPreviewSongsViewModel.access$getGuideSongsList$p(this.a).addAll(r7);
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsViewModel a;

        public j(KtvPreviewSongsViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            KtvPreviewSongsViewModel.access$updatePreviewCardViewIfNeed(this.a);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsViewModel a;

        public k(KtvPreviewSongsViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            com.bytedance.android.livesdk.ktvimpl.base.util.j r5 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
            KtvContext r0 = KtvPreviewSongsViewModel.access$getKtvContext$p(this.a);
            r5.getClass();
            if (com.bytedance.android.livesdk.ktvimpl.base.util.j.j(r0) == false) goto L5;
            this.a.setShowPreviewCard(true, "not self seeing count is 0");
            return;
        L5:
            this.a.getRefreshView().post(b.C0027b.a);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsViewModel a;

        public l(KtvPreviewSongsViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L5;
            this.a.setShowPreviewCard(false, "feedbackPanel show");
            return;
        L5:
            this.a.setShowPreviewCard(true, "feedbackPanel hide");
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsViewModel a;

        public m(KtvPreviewSongsViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            KtvPreviewSongsViewModel.access$changeSonsMenu(this.a);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvPreviewSongsViewModel.class, "refreshView", "getRefreshView()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvPreviewSongsViewModel.class, "showPreviewCard", "getShowPreviewCard()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvPreviewSongsViewModel.class, "needDelayToShow", "getNeedDelayToShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    private final void updatePreviewCardViewIfNeed() {
        updateOrderSongListGetedState(true);
        ALogger.i(TAG, "updatePreviewCardViewIfNeed ;; curState == " + obtainSingState());
        if (isMusicStopped$default(this, null, 1, null) == false) goto L6;
        setShowPreviewCard(true, "KtvRoomEnterGetOrderSongSuccess");
        return;
    }

    public final com.bytedance.live.datacontext.m<Boolean> getNeedDelayToShow() {
        return (com.bytedance.live.datacontext.m) this.needDelayToShow$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.k<b> getRefreshView() {
        return (com.bytedance.live.datacontext.k) this.refreshView$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getShowPreviewCard() {
        return (com.bytedance.live.datacontext.m) this.showPreviewCard$delegate.a(this, $$delegatedProperties[1]);
    }

    public void onBizEnterRoom() {
        this.isEnterRoom = true;
        o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L5;
        Boolean r2 = r0.isAnchor();
    L6:
        boolean r3 = Intrinsics.areEqual(r2, Boolean.TRUE);
        this.isAnchor = r3;
        if (r3 == true) goto L9;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.ktvContext.getSeiProcessor().getValue()).c(this, 6.0f);
    L9:
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L15;
        vlc.d r4 = (vlc.d) r1.getValue();
        if (r4 == null) goto L15;
        r4.addMessageListener(MessageType.KTV_PLAY_MODE_START_MESSAGE.getIntType(), this);
    L15:
        KtvModeOrderedSongDataContext r5 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r5 == null) goto L20;
        Disposable r6 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r5, null, new k(this), 3);
        if (r6 == null) goto L20;
        RxUtilKt.c(r6, this.roomCompositeDisposable);
    L20:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r7 = KtvRoomContext.a.a();
        if (r7 != null) goto L23;
        return;
    L23:
        if (r7.isKtvRoomEnterGetOrderSongSuccess() == false) goto L25;
        updatePreviewCardViewIfNeed();
    L25:
        RxUtilKt.c(r7.observeKtvRoomEnterGetOrderSongSuccess(new j(this)), this.roomCompositeDisposable);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void onBizHide() {
        this.isPageShow = false;
    }

    public void onBizLeaveRoom() {
        this.isEnterRoom = false;
        if (this.isAnchor == true) goto L5;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.ktvContext.getSeiProcessor().getValue()).g(this);
    L5:
        o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L12;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L12;
        r2.removeMessageListener(this);
    L12:
        this.roomCompositeDisposable.clear();
    }

    public void onBizShow() {
        this.isPageShow = true;
    }

    public final void onViewHolderPause() {
        this.isViewHolderResume = false;
    }

    public final void onViewHolderResume() {
        this.isViewHolderResume = true;
    }

    private final void cancelTimerDispose() {
        Disposable r0 = this.timer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    private final void changeSonsMenu() {
        StringBuilder r0 = new StringBuilder("changeSonsMenu  ");
        com.bytedance.android.livesdk.a.h.getClass();
        r0.append(com.bytedance.android.livesdk.a.a.a("ktv_cold_start_play"));
        ALogger.i(TAG, r0.toString());
        boolean r1 = false;
        if (this.isPageShow == true) goto L5;
    L6:
        KtvRoomContext.Companion.getClass();
        if (KtvRoomContext.a.a() != null) goto L9;
        boolean r2 = true;
    L11:
        if (this.isEnterRoom == true) goto L16;
        KtvRoomContext.Companion.getClass();
        if (KtvRoomContext.a.a() == null) goto L16;
        r1 = true;
    L16:
        if (((Boolean) getShowPreviewCard().getValue()).booleanValue() == false) goto L22;
        if (r2 == true) goto L23;
        if (r1 == true) goto L24;
        RxUtilKt.c(getPreviewSongs().subscribe(new c(this), d.a), this.globalCompositeDisposable);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r2 = false;
        goto L11
    L5:
        if (this.isViewHolderResume == true) goto L9;
        goto L6
    }

    private final void doClear() {
        if (this.isAnchor == true) goto L5;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.ktvContext.getSeiProcessor().getValue()).g(this);
    L5:
        o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L12;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L12;
        r2.removeMessageListener(this);
    L12:
        cancelTimerDispose();
        this.roomCompositeDisposable.clear();
        this.globalCompositeDisposable.clear();
    }

    private final KtvRoomLyricsStateMachineConfig.d obtainSingState() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) this.ktvContext.getKtvCoreViewModel().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurState();
    }

    private final void prepareToRotateSongs() {
        ALogger.i(TAG, "prepareToRotateSongs");
        cancelTimerDispose();
        Disposable r0 = du2.a.b(1, this.previewCardShowPeriodSec, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this));
        this.timer = r0;
        if (r0 == null) goto L6;
        this.globalCompositeDisposable.add(r0);
        return;
    }

    public final Observable<List<MusicPanel>> getPreviewSongs() {
        if ((!this.guideSongsList.isEmpty()) == false) goto L9;
        if (this.guideSongsList.size() < this.songCountInEachPage) goto L9;
        return Observable.just(this.guideSongsList).doOnComplete(this.dropExpired).map(f.a);
    L9:
        return ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getPreviewSongs(this.roomId, this.curOffset, 15).compose(RxUtil.rxSchedulerHelper()).map(g.a).doOnNext(new h(this, System.currentTimeMillis())).doOnComplete(this.dropExpired).doOnError(i.a);
    }

    public final boolean isShowPreviewCard() {
        return ((Boolean) getShowPreviewCard().getValue()).booleanValue();
    }

    public final void onInit() {
        RxUtilKt.c(getNeedDelayToShow().a().subscribe(new l(this)), this.globalCompositeDisposable);
        KtvRoomContext.Companion.getClass();
        if (KtvRoomContext.a.a() != null) goto L6;
        updatePreviewCardViewIfNeed();
        return;
    }

    public final int getSongCountInEachPage() {
        return this.songCountInEachPage;
    }

    public void onBizDestory() {
        doClear();
    }

    public static final /* synthetic */ void access$changeSonsMenu(KtvPreviewSongsViewModel r0) {
        r0.changeSonsMenu();
    }

    public static final /* synthetic */ long access$getCurOffset$p(KtvPreviewSongsViewModel r2) {
        return r2.curOffset;
    }

    public static final /* synthetic */ LinkedList access$getGuideSongsList$p(KtvPreviewSongsViewModel r0) {
        return r0.guideSongsList;
    }

    public static final /* synthetic */ KtvContext access$getKtvContext$p(KtvPreviewSongsViewModel r0) {
        return r0.ktvContext;
    }

    public static final /* synthetic */ void access$updatePreviewCardViewIfNeed(KtvPreviewSongsViewModel r0) {
        r0.updatePreviewCardViewIfNeed();
    }

    private final void onPreviewCardStateChange(boolean r2) {
        com.bytedance.android.livesdk.a.h.getClass();
        if (com.bytedance.android.livesdk.a.a.a("ktv_cold_start_show") == false) goto L5;
        this.isPreviewCardActive = false;
    L6:
        ALogger.i(TAG, "onPreviewCardStateChange isPreviewCardActive " + this.isPreviewCardActive);
        if (this.isPreviewCardActive == false) goto L9;
        prepareToRotateSongs();
        return;
    L9:
        cancelTimerDispose();
        changeSonsMenu();
        return;
    L5:
        this.isPreviewCardActive = r2;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (this.isAnchor == false) goto L5;
    L7:
        return false;
    L5:
        if ((r2.b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L7;
        return true;
    }

    public final boolean isMusicStopped(KtvRoomLyricsStateMachineConfig.d r3) {
        if (KtvSettingHelper.w() == true) goto L5;
    L7:
        if (r3 != null) goto L9;
    L12:
        return true;
    L9:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L12;
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L12;
        return false;
    L5:
        if (this.ktvContext.getKtvCoreViewModel().getValue() != null) goto L7;
        return false;
    }

    public void onMessage(tlc.d r4) {
        if ((r4 instanceof rd) == true) goto L5;
        return;
    L5:
        if (((rd) r4).isForColdStartRecommend() == false) goto L18;
        KtvContext r0 = this.ktvContext;
        if (r0 == null) goto L13;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
        if (r2 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.getCurState();
    L15:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L17;
        setShowPreviewCard(true, "onMessage");
        goto L18
    L17:
        this.lastReceivedStartMessage = System.currentTimeMillis();
    L13:
        r3 = null;
    L18:
        pd2.d.n.E(LinkMonitorData.MsgKtvPlaymodeStartMessage, r4, new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(w r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        boolean r0 = isShowPreviewCard();
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r1 = r7.b;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = null;
        if ((r1 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r2 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r1;
        if (r2 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r8 = r7.b;
        if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L15;
        r3 = r8;
    L15:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3;
        if (r5 != null) goto L18;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == false) goto L26;
        return;
    L26:
        if (r0 == true) goto L33;
        if (r4 == false) goto L33;
        if ((obtainSingState() instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L33;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r6 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvContext r10 = this.ktvContext;
        r6.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.j(r10) == false) goto L33;
        setShowPreviewCard(true, "onSeiResult");
        return;
    L33:
        if (r0 == false) goto L38;
        if (r4 == true) goto L39;
        setShowPreviewCard(false, "onSeiResult");
        return;
    L39:
        return;
    L38:
        return;
    L18:
        if (r5.C() != 2) goto L22;
        if ((obtainSingState() instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L22;
        r9 = true;
        goto L23
    L8:
        if (r2.C() != 0) goto L10;
        r4 = true;
        goto L11
    }

    public final void setSongCountInEachPage(int r1) {
        this.songCountInEachPage = r1;
    }

    public final void updateOrderSongListGetedState(boolean r1) {
        this.isOrderSongListGeted = r1;
    }

    public static final /* synthetic */ void access$setCurOffset$p(KtvPreviewSongsViewModel r0, long r1) {
        r0.curOffset = r1;
    }

    public final void setShowPreviewCard(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "logTrace");
        ALogger.d(TAG, "setShowPreviewCard: " + r4 + " logTrace: " + r5);
        if (r4 == false) goto L27;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.I0.getValue()).booleanValue() == true) goto L9;
        ALogger.d(TAG, "setShowPreviewCard but live_ktv_enable_cold_start_song_list is not allow");
        return;
    L9:
        if (isMusicStopped$default(this, null, 1, null) == true) goto L13;
        ALogger.d(TAG, "setShowPreviewCard but currentState is not Idle or Closed ;; curState == " + obtainSingState());
        return;
    L13:
        if (((Boolean) getNeedDelayToShow().getValue()).booleanValue() == false) goto L16;
        ALogger.d(TAG, "setShowPreviewCard but needDelayToShow is true");
        return;
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r0 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvContext r2 = this.ktvContext;
        r0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.j(r2) == true) goto L21;
        ALogger.d(TAG, "setShowPreviewCard but notSelfSeeingCount > 0");
        return;
    L21:
        if (this.isAnchor == true) goto L27;
        if (this.isOrderSongListGeted == true) goto L27;
        ALogger.d(TAG, "setShowPreviewCard but isOrderSongListGeted is false");
        return;
    L27:
        if (r4 == ((Boolean) getShowPreviewCard().getValue()).booleanValue()) goto L38;
        getShowPreviewCard().setValue(Boolean.valueOf(r4));
        onPreviewCardStateChange(r4);
        ALogger.d(TAG, "open=" + r4 + ", logTrace=" + r5);
        if (r4 == false) goto L34;
        this.isShowFromOrderSongList = Intrinsics.areEqual("getOrderSongList", r5);
        if (Intrinsics.areEqual("getOrderSongList", r5) == false) goto L39;
        this.showFromOrderSongListTime = System.currentTimeMillis();
        return;
    L39:
        return;
    L34:
        if (this.isShowFromOrderSongList == false) goto L36;
        System.currentTimeMillis();
    L36:
        this.isShowFromOrderSongList = false;
        return;
    }

    public KtvPreviewSongsViewModel(KtvContext r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        this.ktvContext = r2;
        this.songCountInEachPage = r3;
        this.roomId = r4;
        this.isPageShow = true;
        this.isViewHolderResume = true;
        this.isEnterRoom = true;
        this.globalCompositeDisposable = new CompositeDisposable();
        this.roomCompositeDisposable = new CompositeDisposable();
        this.previewCardShowPeriodSec = 5;
        this.guideSongsList = new LinkedList();
        this.refreshView$delegate = com.bytedance.live.datacontext.e.b(this);
        Boolean r5 = Boolean.FALSE;
        this.showPreviewCard$delegate = q.d(this, r5);
        this.needDelayToShow$delegate = q.d(this, r5);
        this.showFromOrderSongListTime = -1;
        this.dropExpired = new e(this);
    }

    public static /* synthetic */ boolean isMusicStopped$default(KtvPreviewSongsViewModel r0, KtvRoomLyricsStateMachineConfig.d r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.obtainSingState();
    L6:
        return r0.isMusicStopped(r1);
    }
}
