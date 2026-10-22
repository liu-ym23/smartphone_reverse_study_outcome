package com.bytedance.android.livesdk.ktvimpl.ksong.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.midi.KtvComponentProgressView;
import com.bytedance.android.live.ktv.common.midi.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.x41;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAudienceLyricsDisplayView;
import com.bytedance.android.livesdk.ktvimpl.feed.KtvComponentFeedViewModel;
import com.bytedance.android.livesdk.ktvimpl.feed.KtvComponentMidiFeedViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.i0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentEmptyView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.KTVRoomFeedModel;
import com.bytedance.android.livesdkapi.model.NullableOrderInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001VB'\b\u0007\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020K¢\u0006\u0004\bT\u0010UJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J(\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020!H\u0016R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u001d\u00101\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u00105R\u001d\u0010;\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010%\u001a\u0004\b9\u0010:R\u001d\u0010@\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010%\u001a\u0004\b>\u0010?R\u001d\u0010E\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010%\u001a\u0004\bC\u0010DR\u001d\u0010J\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010%\u001a\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ksong/base/view/KtvComponentFeedView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/ktvimpl/feed/KtvComponentFeedViewModel$a;", "", "rate", "", "setPositionByRate", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/model/NullableOrderInfo;", "getOrderInfoObservable", "Landroid/view/ViewGroup;", "getKtvVideoContainer", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "setLivePlayerView", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "getKtvSeiModelObject", "", "getCurrentSingUserIdString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKtvEnterRoomExtraParam", "getFeedViewName", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "", "getKtvComponentLyricsViewShowStatus", "Lcom/bytedance/android/livesdk/ktvimpl/feed/KtvComponentMidiFeedViewModel;", "g", "Lkotlin/Lazy;", "getMidiViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/feed/KtvComponentMidiFeedViewModel;", "midiViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/midi/KtvComponentMidiView;", "m", "getMidiView", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/midi/KtvComponentMidiView;", "midiView", "o", "getMultipleAnchorKtvContainer", "()Landroid/view/ViewGroup;", "multipleAnchorKtvContainer", "Landroid/widget/ImageView;", "p", "getSingingTextView", "()Landroid/widget/ImageView;", "singingTextView", "Lcom/bytedance/android/live/core/widget/HSImageView;", "q", "getMultipleKtvAnimationView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "multipleKtvAnimationView", "Lcom/bytedance/android/live/ktv/common/midi/KtvComponentProgressView;", "r", "getKtvMultipleKtvProgressView", "()Lcom/bytedance/android/live/ktv/common/midi/KtvComponentProgressView;", "ktvMultipleKtvProgressView", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "s", "getKtvLyricsView", "()Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "ktvLyricsView", "Landroid/view/View;", "t", "getLyricsEmptyView", "()Landroid/view/View;", "lyricsEmptyView", "", "getActiveAreaHeight", "()I", "activeAreaHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentFeedView extends ConstraintLayout implements IKtvComponentFeedView, LifecycleOwnerCompat, KtvComponentFeedViewModel.a {
    public static final /* synthetic */ int y = 0;
    public boolean a;
    public boolean b;
    public boolean c;
    public final KtvComponentMusicReportInfoManager d;
    public final KtvComponentFeedViewModel e;
    public final LifecycleRegistry f;
    public final Lazy g;
    public IRoom h;
    public Disposable i;
    public final int j;
    public final int k;
    public boolean l;
    public final Lazy m;
    public final b n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public ViewGroup u;
    public ViewGroup.LayoutParams v;
    public final BehaviorSubject<NullableOrderInfo> w;
    public KtvMusic x;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.ktv.common.midi.f {
        public int a;
        public final /* synthetic */ KtvComponentFeedView b;

        public final int e() {
            int r0 = this.a;
            if (r0 != (-1)) goto L18;
            int r1 = vm2.d.W();
            int r2 = 0;
            if (r1 != 0) goto L7;
            IRoom r3 = this.b.h;
            if (r3 == null) goto L16;
            Map r4 = r3.getAnchorABMap();
            if (r4 == null) goto L16;
            String r5 = (String) r4.get("ktv_component_new_midi");
            if (r5 == null) goto L16;
            r2 = CastIntegerProtector.parseInt(r5);
        L16:
            this.a = r2;
            return r2;
        L7:
            if (r1 == 4) goto L16;
            r2 = vm2.d.W();
            goto L16
        L18:
            return r0;
        }

        public final boolean a() {
            if (e() != 1) goto L5;
            return true;
        L5:
            if (e() == 3) goto L10;
            return false;
        L10:
            return true;
        }

        public final boolean b() {
            if (e() != 1) goto L5;
            return true;
        L5:
            if (e() == 2) goto L10;
            return false;
        L10:
            return true;
        }

        public final boolean c() {
            if (e() != 1) goto L5;
            return true;
        L5:
            if (e() == 3) goto L10;
            return false;
        L10:
            return true;
        }

        public final boolean d() {
            if (e() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public b(KtvComponentFeedView r1) {
            this.b = r1;
            this.a = -1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public c(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.R5(r0, (List) r2);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public d(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.S5(r0, (k) r2);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public e(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.U5(r0, (com.bytedance.android.livesdk.ktvimpl.base.sei.h) r2);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public f(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.T5(r0, (StateMachine.c.b) r2);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public g(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.R5(r0, (List) r2);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public h(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.S5(r0, (k) r2);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ KtvComponentFeedView a;

        public i(KtvComponentFeedView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KtvComponentFeedView r0 = this.a;
            KtvComponentFeedView.U5(r0, (com.bytedance.android.livesdk.ktvimpl.base.sei.h) r2);
        }
    }

    static {
    }

    public KtvComponentFeedView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentFeedView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final KtvAudienceLyricsDisplayView getKtvLyricsView() {
        return (KtvAudienceLyricsDisplayView) this.s.getValue();
    }

    private final KtvComponentProgressView getKtvMultipleKtvProgressView() {
        return (KtvComponentProgressView) this.r.getValue();
    }

    private final View getLyricsEmptyView() {
        return (View) this.t.getValue();
    }

    private final KtvComponentMidiView getMidiView() {
        return (KtvComponentMidiView) this.m.getValue();
    }

    private final KtvComponentMidiFeedViewModel getMidiViewModel() {
        return (KtvComponentMidiFeedViewModel) this.g.getValue();
    }

    private final ViewGroup getMultipleAnchorKtvContainer() {
        return (ViewGroup) this.o.getValue();
    }

    private final HSImageView getMultipleKtvAnimationView() {
        return (HSImageView) this.q.getValue();
    }

    private final ImageView getSingingTextView() {
        return (ImageView) this.p.getValue();
    }

    public String getFeedViewName() {
        return "KtvComponentFeedView";
    }

    public HashMap<String, Object> getKtvEnterRoomExtraParam() {
        return null;
    }

    public ViewGroup getKtvVideoContainer() {
        return null;
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.KtvComponentFeedViewModel.a
    public final void i3(com.bytedance.android.livesdk.ktvimpl.base.sei.g r2) {
        Intrinsics.checkNotNullParameter(r2, "midiSeiModel");
    }

    public final void onKtvVideoStateChange(ld0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "videoSei");
    }

    public final void onOnlineListChanged() {
    }

    public final void onSeiUpdated(SeiAppData r1) {
    }

    public final void onSeiUpdated(JSONObject r1) {
    }

    public final void onViewHolderSelected() {
    }

    public final void onViewHolderUnSelected() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.feed.KtvComponentFeedViewModel.a
    public final void s1() {
        setVisibility(0);
        ViewGroup r1 = getMultipleAnchorKtvContainer();
        if (r1 == null) goto L5;
        r1.setVisibility(0);
    L5:
        ImageView r0 = getSingingTextView();
        if (r0 == null) goto L8;
        r0.setImageResource(2131252047);
    L8:
        KtvAudienceLyricsDisplayView r2 = getKtvLyricsView();
        if (r2 == null) goto L14;
        ub0.b r3 = r2.getConfig();
        if (r3 == null) goto L14;
        if (r3.o != 4) goto L14;
        return;
    L14:
        KtvAudienceLyricsDisplayView r4 = getKtvLyricsView();
        if (r4 == null) goto L19;
        r4.c(KtvComponentFeedView$onKtvModeChanged$1.INSTANCE);
        return;
    }

    public void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
    }

    public void setLivePlayerView(IRenderView r1) {
    }

    public final void setRenderViewBitmapToMockView() {
    }

    public final void updateEnterFrom(String r1, String r2) {
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    private final int getActiveAreaHeight() {
        return this.k - this.j;
    }

    public final void b6() {
        Integer r0 = this.e.h;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L17;
        HSImageView r2 = getMultipleKtvAnimationView();
        if (r2 == null) goto L13;
        r2.setVisibility(8);
    L13:
        HSImageView r3 = getMultipleKtvAnimationView();
        if (r3 == null) goto L18;
        r3.setController(null);
        return;
    L18:
        return;
    L17:
        return;
    L6:
        if (r0.intValue() != 0) goto L8;
        r1 = true;
        goto L9
    }

    public final void c6() {
        if ((this.d.g.getValue() instanceof je2.f.C0147f) == false) goto L7;
        ALogger.i("KtvComponentFeedView", "showLyricView ;; isShowingPrepareSongInfo");
        return;
    L7:
        if (this.l == true) goto L10;
        ALogger.i("KtvComponentFeedView", "invoke showLyricView ;; but showLyricsAndMidi=" + this.l);
        return;
    L10:
        KtvAudienceLyricsDisplayView r0 = getKtvLyricsView();
        if (r0 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r0);
        return;
    }

    public String getCurrentSingUserIdString() {
        MusicPanel r0 = ((KtvRoomLyricsStateMachineConfig.d) this.e.b.b()).b();
        if (r0 == null) goto L6;
        String r1 = r0.g();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public Object getKtvSeiModelObject() {
        return this.e.a;
    }

    public final void resetKtvSeiModelObject() {
        this.e.a = null;
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IKtvComponentFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
    }

    public Object getCurrentSeiParseResultData() {
        return IKtvComponentFeedView.DefaultImpls.getCurrentSeiParseResultData(this);
    }

    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        return IKtvComponentFeedView.DefaultImpls.getFeedViewRoomInfoStore(this);
    }

    public IKtvInteractFeedView getIKtvInteractFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getIKtvInteractFeedView(this);
    }

    public IMultiFeedView getIMultiFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getIMultiFeedView(this);
    }

    public IPkFeedView getIPkFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getIPkFeedView(this);
    }

    public List<String> getImCacheTags() {
        return IKtvComponentFeedView.DefaultImpls.getImCacheTags(this);
    }

    public IKtvComponentFeedView getKtvComponentFeedView() {
        return IKtvComponentFeedView.DefaultImpls.getKtvComponentFeedView(this);
    }

    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return IKtvComponentFeedView.DefaultImpls.getOnlineList(this);
    }

    public View getViewCompat() {
        return IKtvComponentFeedView.DefaultImpls.getViewCompat(this);
    }

    public final void i6() {
        HSImageView r0 = getMultipleKtvAnimationView();
        if (r0 == null) goto L5;
        DraweeController r1 = r0.getController();
    L6:
        if (r1 != null) goto L14;
        HSImageView r2 = getMultipleKtvAnimationView();
        if (r2 == null) goto L10;
        r2.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse((String) vm2.h.m1.getValue(null, vm2.h.a[115(0x73, float:1.61E-43)]))).setAutoPlayAnimations(true).build());
    L10:
        HSImageView r3 = getMultipleKtvAnimationView();
        if (r3 == null) goto L15;
        r3.setVisibility(0);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IKtvComponentFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        je2.e r0 = this.d.f;
        r0.a = (KtvComponentEmptyView) findViewById(2131377038);
        r0.b = (KtvComponentEmptyView) findViewById(2131377074);
        i0 r1 = new i0();
        ConstraintLayout r2 = (ConstraintLayout) findViewById(2131380104);
        if (r2 == null) goto L5;
        r1.b(r2);
    L5:
        Unit r3 = Unit.INSTANCE;
        r0.e = r1;
        KtvComponentMusicReportInfoManager r4 = this.d;
        r4.g.observeForever(r4.h);
        KtvAudienceLyricsDisplayView r5 = getKtvLyricsView();
        if (r5 == null) goto L8;
        r5.a(new AnonymousClass2(this));
    L8:
        KtvComponentMidiFeedViewModel r6 = getMidiViewModel();
        if (r6 == null) goto L15;
        KtvComponentFeedViewModel r7 = r6.p;
        if (r7 == null) goto L15;
        m r8 = r7.f;
        if (r8 == null) goto L15;
        r8.c(r6, 5.0f);
    L15:
        KtvComponentMidiFeedViewModel r9 = getMidiViewModel();
        if (r9 == null) goto L20;
        MutableLiveData<List<cb0.c>> r10 = r9.e;
        if (r10 == null) goto L20;
        r10.observe(this, new c(this));
    L20:
        KtvComponentMidiFeedViewModel r11 = getMidiViewModel();
        if (r11 == null) goto L25;
        MutableLiveData<k> r12 = r11.i;
        if (r12 == null) goto L25;
        r12.observe(this, new d(this));
    L25:
        KtvComponentMidiFeedViewModel r13 = getMidiViewModel();
        if (r13 == null) goto L30;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.h> r14 = r13.h;
        if (r14 == null) goto L30;
        r14.observe(this, new e(this));
    L30:
        KtvComponentMidiView r15 = getMidiView();
        if (r15 == null) goto L33;
        KtvComponentMidiFeedViewModel r16 = getMidiViewModel();
        Intrinsics.checkNotNull(r16);
        r15.Gk(r16, null);
    L33:
        this.f.markState(Lifecycle.State.STARTED);
        this.e.d.observe(this, new f(this));
        StateMachine.c.b r17 = (StateMachine.c.b) this.e.d.getValue();
        if (r17 == null) goto L37;
        this.e.d.setValue(r17);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        if (this.f.getCurrentState().ordinal() <= Lifecycle.State.INITIALIZED.ordinal()) goto L5;
        this.f.markState(Lifecycle.State.DESTROYED);
    L5:
        this.d.a();
        Disposable r0 = this.i;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        KtvComponentMidiFeedViewModel r1 = getMidiViewModel();
        if (r1 == null) goto L22;
        ScheduledFuture<?> r2 = r1.d;
        if (r2 == null) goto L13;
        r2.cancel(true);
        r1.d = null;
    L13:
        r1.c = 0;
        r1.m = 0;
        Disposable r3 = r1.k;
        if (r3 == null) goto L16;
        r3.dispose();
    L16:
        KtvComponentFeedViewModel r4 = r1.p;
        if (r4 == null) goto L21;
        m r5 = r4.f;
        if (r5 == null) goto L21;
        r5.g(r1);
    L21:
        r1.a = false;
    L22:
        KtvComponentMidiView r6 = getMidiView();
        if (r6 == null) goto L26;
        r6.onDetach();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reset() {
        KtvAudienceLyricsDisplayView r0 = getKtvLyricsView();
        if (r0 == null) goto L5;
        r0.h();
    L5:
        View r1 = getLyricsEmptyView();
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        KtvComponentFeedViewModel r2 = this.e;
        m r3 = r2.f;
        if (r3 == null) goto L11;
        r3.g(r2);
    L11:
        r2.c.j(KtvRoomLyricsStateMachineConfig.a.h.c);
        KtvComponentMidiFeedViewModel r4 = getMidiViewModel();
        ScheduledFuture<?> r5 = r4.d;
        if (r5 == null) goto L14;
        r5.cancel(true);
        r4.d = null;
    L14:
        r4.c = 0;
        r4.j.clear();
        Disposable r6 = r4.k;
        if (r6 == null) goto L17;
        r6.dispose();
    L17:
        KtvComponentFeedViewModel r7 = r4.p;
        if (r7 == null) goto L22;
        m r8 = r7.f;
        if (r8 == null) goto L22;
        r8.g(r4);
    L22:
        r4.a = false;
        KtvComponentProgressView r9 = getKtvMultipleKtvProgressView();
        if (r9 == null) goto L26;
        r9.setProgress(100.0f);
    L26:
        if (getParent() == null) goto L31;
        UtilityKotlinExtentionsKt.t(this);
        ViewGroup r10 = this.u;
        if (r10 == null) goto L32;
        r10.removeView(this);
        return;
    L32:
        return;
    }

    public boolean getKtvComponentLyricsViewShowStatus() {
        return this.l;
    }

    public Lifecycle getLifecycleCompat() {
        return this.f;
    }

    public Observable<NullableOrderInfo> getOrderInfoObservable() {
        return this.w;
    }

    public final void onViewHolderPause() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderPause(this);
    }

    public final void onViewHolderResume() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderResume(this);
    }

    public final void onViewHolderUnBind() {
        IKtvComponentFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setPositionByRate(float r3) {
        if (r3 >= 0) goto L6;
        r3 = 0.0f;
    L8:
        setY(this.j + (r3 * getActiveAreaHeight()));
        return;
    L6:
        if (r3 <= 1) goto L8;
        r3 = 1.0f;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5(int r3) {
        Integer r0 = this.e.i;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (getVisibility() == r3) goto L15;
        setVisibility(r3);
        return;
    L15:
        return;
    L6:
        if (r0.intValue() != 3) goto L8;
        r1 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bind(KTVRoomFeedModel r2) {
        Intrinsics.checkNotNullParameter(r2, "feedModelKTV");
        setVisibility(8);
        KtvComponentProgressView r3 = getKtvMultipleKtvProgressView();
        if (r3 == null) goto L6;
        r3.setProgress(100.0f);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.feed.KtvComponentFeedViewModel.a
    public final void k3(com.bytedance.android.livesdk.ktvimpl.base.sei.k r10) {
        Intrinsics.checkNotNullParameter(r10, "seiModelCompat");
        IRoom r0 = this.h;
        if (r0 == null) goto L5;
        r0.getOwnerUserIdString();
    L5:
        r10.getClass();
        int r1 = r10.d();
        int r2 = 0;
        if (r1 != 1) goto L23;
        if (getParent() != null) goto L12;
        ViewGroup r3 = this.u;
        if (r3 == null) goto L12;
        r3.addView(this, this.v);
    L12:
        float r4 = r10.c();
        double r5 = r4;
        if (r5 >= 0.0d) goto L15;
    L17:
        setPositionByRate(0.0f);
    L18:
        setVisibility(0);
        Disposable r6 = this.i;
        if (r6 == null) goto L21;
        r6.dispose();
    L21:
        this.i = RxUtilKt.h(Observable.timer(7000, TimeUnit.MILLISECONDS)).subscribe(new com.bytedance.android.livesdk.ktvimpl.ksong.base.view.a(this));
        ALogger.d("KtvComponentFeedView", "onKtvSeiCompatResult.ReceiveStartSEI.ShowKtvComponent." + this);
        goto L23
    L15:
        if (r5 > 1.0d) goto L17;
        setPositionByRate(r4);
    L23:
        if (r1 != 2) goto L26;
        setVisibility(8);
    L42:
        if (r10.o() == false) goto L47;
        KtvAudienceLyricsDisplayView r7 = getKtvLyricsView();
        if (r7 == null) goto L47;
        r7.m = r10.n();
    L47:
        if (this.n.e() <= 0) goto L49;
        boolean r8 = true;
    L50:
        if (r8 == false) goto L85;
        Integer r9 = r10.q();
        if (r9 != null) goto L55;
        return;
    L55:
        if (r9.intValue() != 1) goto L86;
        com.bytedance.android.live.ktv.common.util.c r11 = getMidiView();
        if (r11 != null) goto L59;
    L70:
        com.bytedance.android.live.ktv.common.util.c r12 = getMidiView();
        if (r12 == null) goto L89;
        Integer r13 = r10.s();
        if (r13 != null) goto L76;
    L82:
        r2 = 8;
    L83:
        r12.setVisibility(r2);
        return;
    L76:
        if (r13.intValue() != 1) goto L82;
        if ((((KtvRoomLyricsStateMachineConfig.d) this.e.b.b()) instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L82;
        if (this.l == false) goto L82;
    L89:
        return;
    L59:
        if (r11.getVisibility() != 0) goto L70;
        com.bytedance.android.live.ktv.common.util.c r14 = getMidiView();
        if (r14 == null) goto L87;
        Integer r15 = r10.s();
        if (r15 != null) goto L66;
    L68:
        r2 = 8;
    L69:
        r14.setVisibility(r2);
        return;
    L66:
        if (r15.intValue() != 1) goto L68;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L49:
        r8 = false;
        goto L50
    L26:
        if (r1 != 6) goto L29;
        b6();
        goto L42
    L29:
        if (r1 != 7) goto L42;
        if (r10.i() == false) goto L39;
        KtvAudienceLyricsDisplayView r16 = getKtvLyricsView();
        if (r16 == null) goto L35;
        r16.h();
    L35:
        KtvAudienceLyricsDisplayView r17 = getKtvLyricsView();
        if (r17 == null) goto L38;
        r17.a(new KtvComponentFeedView$onKtvSeiCompatResult$1(this));
    L38:
        int r18 = 8;
    L40:
        setVisibility(r18);
        goto L42
    L39:
        r18 = 0;
        goto L40
    }

    public final void monitorLayouts(String r1) {
        IKtvComponentFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r1) {
        IKtvComponentFeedView.DefaultImpls.onOnlineListChanged(this, r1);
    }

    public final void onSeiUpdatedRaw(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        KtvComponentFeedViewModel r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "sei");
        m r1 = r0.f;
        if (r1 == null) goto L8;
        r1.d(r0, r3);
        return;
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IKtvComponentFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IKtvComponentFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public void setDataMergeCenter(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        IKtvComponentFeedView.DefaultImpls.setDataMergeCenter(this, r2);
    }

    public void setDataMergeCenterV2(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        IKtvComponentFeedView.DefaultImpls.setDataMergeCenterV2(this, r2);
    }

    public void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IKtvComponentFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IKtvComponentFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateKsongLayout(Function1<? super ViewGroup.LayoutParams, ? extends ViewGroup.LayoutParams> r2) {
        Intrinsics.checkNotNullParameter(r2, "updateTask");
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
        r0 = this.v;
    L5:
        ViewGroup.LayoutParams r3 = (ViewGroup.LayoutParams) r2.invoke(r0);
        this.v = r3;
        setLayoutParams(r3);
    }

    public final void updateKtvComponentLyricsViewShowStatus(boolean r3) {
        if (vm2.c.b().getDismissKtvComponentLyricsAndMidiOnStageSubtitle() == true) goto L5;
        return;
    L5:
        ALogger.i("KtvComponentFeedView", "updateKtvComponentLyricsViewShowStatus, show=" + r3);
        this.l = r3;
        if (r3 == false) goto L8;
        c6();
        return;
    L8:
        KtvAudienceLyricsDisplayView r4 = getKtvLyricsView();
        if (r4 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r4);
    L11:
        com.bytedance.android.live.ktv.common.util.c r5 = getMidiView();
        if (r5 == null) goto L16;
        r5.setVisibility(8);
        return;
    }

    public final void updateMessageHub(MessageHub r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        IKtvComponentFeedView.DefaultImpls.updateMessageHub(this, r2);
    }

    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateMvControllerSei(this, r2);
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public final void updateRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.h = r2;
        this.e.j = r2;
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        IKtvComponentFeedView.DefaultImpls.updateRoomBeforeSelect(this, r1);
    }

    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateSpeechRecognitionSei(this, r2);
    }

    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateSpeechRhythmSei(this, r2);
    }

    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView.DefaultImpls.updateSubtitleSei(this, r2);
    }

    public final void updateTalkState(Map<String, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IKtvComponentFeedView.DefaultImpls.updateTalkState(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateKsongLayout(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutParam");
        this.v = r2;
        setLayoutParams(r2);
    }

    public static final void R5(KtvComponentFeedView r4, List r5) {
        r4.getClass();
        List r6 = r5;
        int r0 = 0;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L27;
        KtvComponentMidiFeedViewModel r8 = r4.getMidiViewModel();
        if (r8 == null) goto L20;
        List r9 = (List) r8.e.getValue();
        int r1 = 100;
        if (r9 == null) goto L19;
        Iterator r10 = r9.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        cb0.c r2 = (cb0.c) r10.next();
        r1 = Math.min(r1, r2.b);
        r0 = Math.max(r0, r2.b);
    L19:
        Pair<Integer, Integer> r11 = TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r0));
    L21:
        KtvComponentMidiView r12 = r4.getMidiView();
        if (r12 == null) goto L26;
        r12.xc(r11);
        return;
    L26:
        return;
    L20:
        r11 = null;
        goto L21
    L27:
        return;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r7 = false;
        goto L9
    }

    public static final void S5(KtvComponentFeedView r2, k r3) {
        com.bytedance.android.live.ktv.common.util.c r0 = r2.getMidiView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L12;
        if (r3 == null) goto L13;
        KtvComponentMidiView r4 = r2.getMidiView();
        if (r4 == null) goto L14;
        r4.F9(r3, null, false);
        return;
    L14:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void T5(final KtvComponentFeedView r17, StateMachine.c.b r18) {
        r17.getClass();
        if (r18 == null) goto L204;
        Object r2 = r18.c;
        KtvRoomLyricsStateMachineConfig.d r3 = (KtvRoomLyricsStateMachineConfig.d) r2;
        String r8 = null;
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L39;
        KtvRoomLyricsStateMachineConfig.d r1 = (KtvRoomLyricsStateMachineConfig.d) r18.a;
        if (r2 == null) goto L37;
        KtvRoomLyricsStateMachineConfig.d.b r4 = (KtvRoomLyricsStateMachineConfig.d.b) r2;
        boolean r5 = Z5(r1, (KtvRoomLyricsStateMachineConfig.d) r2);
        Integer r6 = r17.e.g;
        if (r6 != null) goto L12;
    L14:
        if (r5 == false) goto L24;
        ALogger.i(bb0.b.b(), "KtvComponentFeedView :onIdle, invoke class :KtvComponentFeedView");
        r17.c = false;
        r17.b = false;
        r17.a = false;
        r17.d.f(je2.f.a.a);
        KtvAudienceLyricsDisplayView r7 = r17.getKtvLyricsView();
        if (r7 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r7);
    L18:
        KtvAudienceLyricsDisplayView r9 = r17.getKtvLyricsView();
        if (r9 == null) goto L21;
        r9.h();
    L21:
        r17.b6();
        r17.Y5(8);
        KtvComponentProgressView r10 = r17.getKtvMultipleKtvProgressView();
        if (r10 == null) goto L24;
        r10.setProgress(100.0f);
    L24:
        KtvAudienceLyricsDisplayView r11 = r17.getKtvLyricsView();
        if (r11 == null) goto L27;
        r11.a(new KtvComponentFeedView$onIdle$1(r17));
    L27:
        com.bytedance.android.live.ktv.common.util.c r12 = r17.getMidiView();
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        KtvComponentMidiFeedViewModel r13 = r17.getMidiViewModel();
        if (r13.l == false) goto L33;
        com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "tryHideFeedback");
        r13.g.setValue(Boolean.TRUE);
        r13.l = false;
    L33:
        ViewGroup r0 = r17.getMultipleAnchorKtvContainer();
        if (r0 == null) goto L210;
        r0.setVisibility(0);
        return;
    L210:
        return;
    L12:
        if (r6.intValue() != 3) goto L14;
        r17.w.onNext(new NullableOrderInfo(null));
        goto L14
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Idle");
    L39:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L81;
        KtvRoomLyricsStateMachineConfig.d r14 = (KtvRoomLyricsStateMachineConfig.d) r18.a;
        if (r2 == null) goto L79;
        KtvRoomLyricsStateMachineConfig.d.e r15 = (KtvRoomLyricsStateMachineConfig.d.e) r2;
        Z5(r14, (KtvRoomLyricsStateMachineConfig.d) r2);
        Intrinsics.checkNotNullParameter(r14, "from");
        Intrinsics.checkNotNullParameter(r15, "to");
        if ((r14 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L45;
    L47:
        String r16 = "onPreparing:" + r15.b;
        ALogger.i(bb0.b.b(), "KtvComponentFeedView :" + r16 + ", invoke class :KtvComponentFeedView");
        r17.c = false;
        r17.b = false;
        r17.a = false;
        r17.d.f(je2.f.a.a);
        Integer r19 = r17.e.g;
        if (r19 != null) goto L51;
    L53:
        r17.c6();
        View r20 = r17.getLyricsEmptyView();
        if (r20 == null) goto L56;
        r20.setVisibility(8);
    L56:
        final KtvMusic r21 = r15.b.a;
        if (r17.b == true) goto L66;
        if (r21 == null) goto L61;
        r8 = r21.getMTitle();
    L61:
        if (r2.a(r8) == false) goto L66;
        r17.b = true;
        KtvAudienceLyricsDisplayView r22 = r17.getKtvLyricsView();
        if (r22 == null) goto L65;
        UtilityKotlinExtentionsKt.t(r22);
    L65:
        r17.d.d(r21, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, new KtvComponentFeedView$showPrepareInfoWhenPrepareState$1(r17, r21));
    L66:
        KtvAudienceLyricsDisplayView r23 = r17.getKtvLyricsView();
        if (r23 == null) goto L69;
        r23.a(new KtvComponentFeedView$onPreparing$1(r17));
    L69:
        r17.Y5(0);
        r17.i6();
        KtvComponentProgressView r24 = r17.getKtvMultipleKtvProgressView();
        if (r24 == null) goto L72;
        r24.b();
    L72:
        com.bytedance.android.live.ktv.common.util.c r25 = r17.getMidiView();
        if (r25 == null) goto L75;
        r25.setVisibility(8);
    L75:
        KtvComponentMidiFeedViewModel r26 = r17.getMidiViewModel();
        if (r26.l == false) goto L212;
        com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "tryHideFeedback");
        r26.g.setValue(Boolean.TRUE);
        r26.l = false;
        return;
    L212:
        return;
    L51:
        if (r19.intValue() != 3) goto L53;
        r17.w.onNext(new NullableOrderInfo(r15.b.a.getOrderInfo()));
        goto L53
    L45:
        if (((KtvRoomLyricsStateMachineConfig.d.e) r14).b.a.getMId() != r15.b.a.getMId()) goto L47;
        return;
    L79:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Preparing");
    L81:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L99;
        KtvRoomLyricsStateMachineConfig.d r27 = (KtvRoomLyricsStateMachineConfig.d) r18.a;
        if (r2 == null) goto L97;
        KtvRoomLyricsStateMachineConfig.d.C0041d r28 = (KtvRoomLyricsStateMachineConfig.d.C0041d) r2;
        Z5(r27, (KtvRoomLyricsStateMachineConfig.d) r2);
        Intrinsics.checkNotNullParameter(r27, "from");
        Intrinsics.checkNotNullParameter(r28, "to");
        Integer r29 = r17.e.g;
        if (r29 != null) goto L88;
    L90:
        KtvAudienceLyricsDisplayView r30 = r17.getKtvLyricsView();
        if (r30 == null) goto L93;
        r30.i(4);
    L93:
        r17.b6();
        KtvComponentProgressView r31 = r17.getKtvMultipleKtvProgressView();
        if (r31 == null) goto L214;
        r31.a();
        return;
    L214:
        return;
    L88:
        if (r29.intValue() != 3) goto L90;
        r17.w.onNext(new NullableOrderInfo(r28.b.a.getOrderInfo()));
        goto L90
    L97:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Paused");
    L99:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L187;
        KtvRoomLyricsStateMachineConfig.d r32 = (KtvRoomLyricsStateMachineConfig.d) r18.a;
        if (r2 == null) goto L185;
        KtvRoomLyricsStateMachineConfig.d.f r33 = (KtvRoomLyricsStateMachineConfig.d.f) r2;
        boolean r34 = Z5(r32, (KtvRoomLyricsStateMachineConfig.d) r2);
        Intrinsics.checkNotNullParameter(r32, "from");
        Intrinsics.checkNotNullParameter(r33, "to");
        if (r34 == true) goto L105;
    L138:
        Integer r35 = r17.e.g;
        if (r35 == null) goto L145;
        if (r35.intValue() != 3) goto L145;
        r17.w.onNext(new NullableOrderInfo(r33.b.a.getOrderInfo()));
    L145:
        if (r33.c != null) goto L147;
    L176:
        r17.Y5(0);
        KtvMusic r36 = r17.x;
        if (r36 != null) goto L179;
    L181:
        KtvAudienceLyricsDisplayView r37 = r17.getKtvLyricsView();
        if (r37 == null) goto L216;
        r37.a(new KtvComponentFeedView$onSinging$1(r17));
        return;
    L216:
        return;
    L179:
        if (r36.isSameKtvMusic(r33.b.a) == true) goto L181;
        r17.reset();
        r17.x = r33.b.a;
        goto L181
    L147:
        if (r17.getKtvLyricsView() == null) goto L176;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r38 = r33.c;
        KtvAudienceLyricsDisplayView r39 = r17.getKtvLyricsView();
        if (r39 == null) goto L176;
        r39.i(r38.d());
        List<v> r40 = r38.l();
        if (r40 == null) goto L176;
        Iterator<v> r41 = r40.iterator();
    L154:
        if (r41.hasNext() == false) goto L176;
        v r42 = r41.next();
        String r110 = "";
        if (r38.n() != 2) goto L167;
        new lg4.b();
        TreeMap r43 = new TreeMap();
        String r44 = r42.a();
        if (r44 == null) goto L161;
        r110 = r44;
    L161:
        lg4.b.c(r43, r110);
        Iterator r45 = r43.keySet().iterator();
        if (r45 != null) goto L164;
    L173:
        com.bytedance.component.lyric.model.b r46 = null;
    L174:
        if (r46 == null) goto L154;
        r39.f(r42.b(), r46, (long) ((r38.y() + r38.m()) * 1000.0f));
        goto L154
    L164:
        if (r45.hasNext() != true) goto L173;
        r46 = (com.bytedance.component.lyric.model.b) r43.get(r45.next());
        goto L174
    L167:
        if (r38.n() != 3) goto L173;
        lg4.a r47 = new lg4.a();
        String r48 = r42.a();
        if (r48 == null) goto L172;
        r110 = r48;
    L172:
        r46 = r47.b(r110);
        goto L174
    L105:
        if ((r32 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L118;
        KtvAudienceLyricsDisplayView r49 = r17.getKtvLyricsView();
        if (r49 == null) goto L109;
        r49.i(5);
    L109:
        Integer r50 = r17.e.h;
        if (r50 != null) goto L113;
    L115:
        boolean r51 = false;
    L116:
        if (r51 == false) goto L118;
        r17.i6();
        goto L118
    L113:
        if (r50.intValue() != 0) goto L115;
        r51 = true;
    L118:
        r17.i6();
        StringBuilder r52 = new StringBuilder("onSinging:");
        MusicPanel r53 = r33.b;
        if (r53 == null) goto L123;
        KtvMusic r54 = r53.a;
        if (r54 == null) goto L123;
        String r55 = r54.getMTitle();
    L124:
        r52.append(r55);
        String r56 = r52.toString();
        ALogger.i(bb0.b.b(), "KtvComponentFeedView :" + r56 + ", invoke class :KtvComponentFeedView");
        r17.c6();
        if (r33.c != null) goto L127;
    L133:
        KtvMusic.a r57 = KtvMusic.Companion;
        KtvMusic r58 = r33.b.a;
        r57.getClass();
        if (KtvMusic.a.a(r58) <= 0) goto L138;
        KtvComponentProgressView r59 = r17.getKtvMultipleKtvProgressView();
        if (r59 == null) goto L138;
        r59.c(KtvMusic.a.a(r33.b.a) * 1000, KtvMusic.a.b(r33.b.a, r33.d.a));
        goto L138
    L127:
        if (((x41) vm2.h.V0.getValue(null, vm2.h.a[98])).a() > 0) goto L133;
        if (r33.c.J() == false) goto L133;
        j r60 = j.l;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r61 = r33.c;
        r60.getClass();
        boolean r62 = j.c(r61);
        if (r17.c == true) goto L133;
        r17.c = true;
        r17.d.b(r62);
    L123:
        r55 = null;
        goto L124
    L185:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L187:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L218;
        KtvRoomLyricsStateMachineConfig.d r63 = (KtvRoomLyricsStateMachineConfig.d) r18.a;
        if (r2 == null) goto L203;
        Z5(r63, (KtvRoomLyricsStateMachineConfig.d) r2);
        Intrinsics.checkNotNullParameter(r63, "from");
        Intrinsics.checkNotNullParameter((KtvRoomLyricsStateMachineConfig.d.a) r2, "to");
        Integer r64 = r17.e.g;
        if (r64 != null) goto L194;
    L196:
        r17.c = false;
        r17.b = false;
        r17.a = false;
        r17.d.f(je2.f.a.a);
        KtvAudienceLyricsDisplayView r65 = r17.getKtvLyricsView();
        if (r65 == null) goto L199;
        r65.h();
    L199:
        r17.setVisibility(8);
        KtvComponentProgressView r66 = r17.getKtvMultipleKtvProgressView();
        if (r66 == null) goto L219;
        r66.setProgress(100.0f);
        return;
    L219:
        return;
    L194:
        if (r64.intValue() != 3) goto L196;
        r17.w.onNext(new NullableOrderInfo(null));
        goto L196
    L203:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Closed");
    L218:
        return;
    }

    public static final void U5(KtvComponentFeedView r4, com.bytedance.android.livesdk.ktvimpl.base.sei.h r5) {
        if (r5 != null) goto L4;
        r4.getClass();
        return;
    L4:
        if (r4.a == false) goto L6;
        return;
    L6:
        if (r5.d() == true) goto L8;
        return;
    L8:
        if (r4.n.e() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L31;
        r4.a = true;
        r4.d.c(r5);
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n().toString(), r5.k()) == false) goto L15;
        String r1 = "oneself";
    L16:
        Long r2 = KtvLoggerHelper.a;
        int r3 = (int) r5.g();
        String r6 = r5.k();
        if (r5.l() == false) goto L19;
        String r7 = "mark";
    L20:
        KtvLoggerHelper.g0(r3, r6, r1, r7);
        KtvComponentMidiFeedViewModel r8 = r4.getMidiViewModel();
        if (r8 == null) goto L32;
        Disposable r9 = r8.k;
        if (r9 != null) goto L25;
    L26:
        com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "startFeedBackShowTimer");
        r8.k = Observable.timer(vm2.d.Y(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.ktvimpl.feed.c(r8));
        return;
    L25:
        if (r9.isDisposed() == true) goto L26;
        return;
    L32:
        return;
    L19:
        r7 = null;
        goto L20
    L15:
        r1 = "others";
        goto L16
    L31:
        return;
    L10:
        r0 = false;
        goto L11
    }

    public static final void V5(KtvComponentFeedView r5, Long r6) {
        com.bytedance.android.live.ktv.common.util.c r0 = r5.getMidiView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L24;
        if (r6 == null) goto L22;
        long r1 = r6.longValue();
        KtvComponentMidiFeedViewModel r2 = r5.getMidiViewModel();
        if (r2 == null) goto L17;
        MutableLiveData<k> r3 = r2.i;
        if (r3 == null) goto L17;
        k r4 = (k) r3.getValue();
        if (r4 == null) goto L17;
        KtvComponentMidiView r7 = r5.getMidiView();
        if (r7 == null) goto L17;
        r7.F9(r4, r6, false);
    L17:
        KtvComponentMidiView r8 = r5.getMidiView();
        if (r8 == null) goto L23;
        r8.R2(r1);
        return;
    L23:
        return;
    L22:
        return;
    }

    public static boolean Z5(KtvRoomLyricsStateMachineConfig.d r2, KtvRoomLyricsStateMachineConfig.d r3) {
        if (Intrinsics.areEqual(r2.getClass(), r3.getClass()) == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getClass().getClassLoader(), r3.getClass().getClassLoader()) == false) goto L8;
        return false;
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        IKtvComponentFeedView.DefaultImpls.bindMultiScenePreviewReportData(this, r1, r2);
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IKtvComponentFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        IKtvComponentFeedView.DefaultImpls.onWrdsDataUpdate(this, r2, r3);
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r1, Integer r2) {
        IKtvComponentFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAttachParent(ViewGroup r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r3, "layoutParam");
        this.u = r2;
        this.v = r3;
        je2.e r4 = this.d.f;
        r4.a = (KtvComponentEmptyView) findViewById(2131377038);
        r4.b = (KtvComponentEmptyView) findViewById(2131377074);
        i0 r5 = new i0();
        ConstraintLayout r0 = (ConstraintLayout) findViewById(2131380104);
        if (r0 == null) goto L5;
        r5.b(r0);
    L5:
        Unit r1 = Unit.INSTANCE;
        r4.e = r5;
        r4.f = (TextView) findViewById(2131379325);
        KtvComponentMusicReportInfoManager r6 = this.d;
        r6.g.observeForever(r6.h);
        KtvComponentMidiFeedViewModel r7 = getMidiViewModel();
        if (r7 == null) goto L12;
        KtvComponentFeedViewModel r8 = r7.p;
        if (r8 == null) goto L12;
        m r9 = r8.f;
        if (r9 == null) goto L12;
        r9.c(r7, 5.0f);
    L12:
        KtvComponentMidiFeedViewModel r10 = getMidiViewModel();
        if (r10 == null) goto L17;
        MutableLiveData<List<cb0.c>> r11 = r10.e;
        if (r11 == null) goto L17;
        r11.observe(this, new g(this));
    L17:
        KtvComponentMidiFeedViewModel r12 = getMidiViewModel();
        if (r12 == null) goto L22;
        MutableLiveData<k> r13 = r12.i;
        if (r13 == null) goto L22;
        r13.observe(this, new h(this));
    L22:
        KtvComponentMidiFeedViewModel r14 = getMidiViewModel();
        if (r14 == null) goto L27;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.h> r15 = r14.h;
        if (r15 == null) goto L27;
        r15.observe(this, new i(this));
    L27:
        KtvComponentMidiView r16 = getMidiView();
        if (r16 == null) goto L31;
        KtvComponentMidiFeedViewModel r17 = getMidiViewModel();
        Intrinsics.checkNotNull(r17);
        r16.Gk(r17, null);
        return;
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IKtvComponentFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvComponentFeedView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(r2, 2131566480, this);
        this.d = new KtvComponentMusicReportInfoManager();
        this.e = new KtvComponentFeedViewModel(this);
        this.f = new LifecycleRegistry(this);
        this.g = LazyKt.lazy(new KtvComponentFeedView$midiViewModel$2(this));
        this.j = s1.j(2131168828);
        this.k = ((s1.w() - s1.A()) - s1.j(2131169164)) - s1.j(2131168852);
        this.l = true;
        this.m = LazyKt.lazy(new KtvComponentFeedView$midiView$2(this));
        this.n = new b(this);
        this.o = LazyKt.lazy(new KtvComponentFeedView$multipleAnchorKtvContainer$2(this));
        this.p = LazyKt.lazy(new KtvComponentFeedView$singingTextView$2(this));
        this.q = LazyKt.lazy(new KtvComponentFeedView$multipleKtvAnimationView$2(this));
        this.r = LazyKt.lazy(new KtvComponentFeedView$ktvMultipleKtvProgressView$2(this));
        this.s = LazyKt.lazy(new KtvComponentFeedView$ktvLyricsView$2(this));
        this.t = LazyKt.lazy(new KtvComponentFeedView$lyricsEmptyView$2(this));
        this.w = BehaviorSubject.create();
    }

    public /* synthetic */ KtvComponentFeedView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
