package com.bytedance.android.livesdk.ktvimpl.feed;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.l;
import com.bytedance.android.live.liveinteract.feed.d0;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.ui.q;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.KTVRoomFeedModel;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u00016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J(\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0018\u0010&\u001a\u00020\f2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016R\u001d\u0010,\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/feed/RealTimeChorusFeedContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/feed/IKtvRoomFeedView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/b;", "Lcom/bytedance/android/live/ktv/common/util/l;", "Ltb0/a;", "Lcom/bytedance/android/livesdk/ktvimpl/feed/a;", "", "getFeedViewName", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "", "setLivePlayerView", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkPlayerInfo;", "getOnlineList", "Landroid/view/ViewGroup;", "getKtvVideoContainer", "", "getKtvSeiModelObject", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKtvEnterRoomExtraParam", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "Landroid/content/Context;", "getFeedContext", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getFeedRoom", "getFeedGuestList", "guestList", "setFeedGuestList", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "j", "Lkotlin/Lazy;", "getWidgetManager", "()Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "widgetManager", "com/bytedance/android/livesdk/ktvimpl/feed/RealTimeChorusFeedContainer$backgroundViewStatistics$2$a", "n", "getBackgroundViewStatistics", "()Lcom/bytedance/android/livesdk/ktvimpl/feed/RealTimeChorusFeedContainer$backgroundViewStatistics$2$a;", "backgroundViewStatistics", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusFeedContainer extends FrameLayout implements IKtvRoomFeedView, LifecycleOwnerCompat, com.bytedance.android.livesdk.ktvimpl.base.sei.b, l, tb0.a, com.bytedance.android.livesdk.ktvimpl.feed.a {
    public MessageHub a;
    public IMultiScenePreviewStatistics b;
    public boolean c;
    public boolean d;
    public boolean e;
    public IRoom f;
    public List<? extends LinkPlayerInfo> g;
    public final CompositeDisposable h;
    public final LifecycleRegistry i;
    public final Lazy j;
    public Integer k;
    public Integer l;
    public final RealTimeChorusMainViewWidget m;
    public final Lazy n;
    public final m o;
    public oe2.a p;
    public final HSImageView q;
    public final FrameLayout r;
    public d0 s;
    public final int t;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.ui.a {
        public final /* synthetic */ RealTimeChorusFeedContainer a;

        public b(RealTimeChorusFeedContainer r1) {
            this.a = r1;
        }

        public final void Ek(IVoiceLiveTheme r2) {
            Intrinsics.checkNotNullParameter(r2, "theme");
            Intrinsics.checkNotNullParameter(r2, "theme");
        }

        public final void W9(boolean r3, IVoiceLiveTheme r4) {
            Intrinsics.checkNotNullParameter(r4, "theme");
            if (r3 == false) goto L8;
            Function2<? super Boolean, ? super Long, Unit> r5 = RealTimeChorusFeedContainer.a(this.a).a;
            if (r5 == null) goto L9;
            Unit r6 = (Unit) r5.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
            return;
        L9:
            return;
        }
    }

    static {
    }

    private final RealTimeChorusFeedContainer$backgroundViewStatistics$2.a getBackgroundViewStatistics() {
        return (RealTimeChorusFeedContainer$backgroundViewStatistics$2.a) this.n.getValue();
    }

    private final RecyclableWidgetManager getWidgetManager() {
        return (RecyclableWidgetManager) this.j.getValue();
    }

    public String getFeedViewName() {
        return "RealTimeChorusFeedView";
    }

    public HashMap<String, Object> getKtvEnterRoomExtraParam() {
        this.e = true;
        HashMap<String, Object> r0 = new HashMap();
        r0.put("ktvContext", getKtvContext());
        r0.put("ktv_chorus_scene_widget", this.m);
        Integer r1 = this.k;
        if (r1 == null) goto L5;
        r0.put("ktv_chorus_feed_subScene", Integer.valueOf(r1.intValue()));
    L5:
        return r0;
    }

    public Object getKtvSeiModelObject() {
        return null;
    }

    public ViewGroup getKtvVideoContainer() {
        return null;
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final void onBizDestory() {
    }

    public final void onBizEnterRoom() {
    }

    public final void onBizHide() {
    }

    public final void onBizShow() {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public final void onKtvVideoStateChange(ld0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "videoSei");
    }

    public final void onOnlineListChanged() {
    }

    public final void onViewHolderSelected() {
        this.d = true;
        this.m.onBizShow();
        if (KtvSettingHelper.w() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.e(this);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.a(this, "RealTimeChorusFeedContainer onViewHolderSelected");
        return;
    }

    public final void onViewHolderUnSelected() {
        this.d = false;
        this.m.onBizHide();
        if (KtvSettingHelper.w() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.f(this);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "RealTimeChorusFeedContainer onViewHolderUnSelected");
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

    private final KtvContext getKtvContext() {
        return this.m.X;
    }

    public final void e() {
        if (this.r == null) goto L19;
        getKtvContext().getStatisticHelper().b(this.m);
        RecyclableWidgetManager r0 = getWidgetManager();
        if (r0 == null) goto L7;
        r0.load(this.r, this.m, false);
    L7:
        RealTimeChorusMainViewWidget r1 = this.m;
        View r2 = null;
        if (r1 == null) goto L10;
        View r3 = ((Widget) r1).contentView;
    L12:
        if ((r3 instanceof com.bytedance.android.live.ktv.common.util.c) == false) goto L15;
        r2 = r3;
    L15:
        com.bytedance.android.live.ktv.common.util.c r4 = (com.bytedance.android.live.ktv.common.util.c) r2;
        if (r4 == null) goto L20;
        getKtvContext().getStatisticHelper().b(r4);
        return;
    L20:
        return;
    L10:
        r3 = null;
        goto L12
    }

    public List<LinkPlayerInfo> getOnlineList() {
        List<? extends LinkPlayerInfo> r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        ALogger.i("RealTimeChorusFeedContainer", "feed view onAttachedToWindow");
        super.onAttachedToWindow();
        this.i.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ALogger.i("RealTimeChorusFeedContainer", "feed view onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public final void onViewHolderResume() {
        RealTimeChorusMainViewWidget r0 = this.m;
        if (r0 == null) goto L5;
        r0.Yq("onViewHolderResume");
    L5:
        RealTimeChorusMainViewWidget r1 = this.m;
        if (r1 == null) goto L11;
        KtvPreviewSongsWidget r2 = r1.A;
        if (r2 == null) goto L11;
        r2.g.onViewHolderResume();
    L11:
        if (KtvSettingHelper.w() == true) goto L13;
        return;
    L13:
        if (this.d == false) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.a(this, "RealTimeChorusFeedContainer onViewHolderResume");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.d(this);
        return;
    }

    public final void reset() {
        o r0 = IRoomContextService.a.a(k.n(IRoomContextService.class), null, 0, 3);
        if (r0 == null) goto L7;
        n r1 = r0.getInteractionDataPrepared();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
    L9:
        if (r2 == null) goto L11;
        boolean r3 = true;
    L13:
        if (((Boolean) KtvSettingHelper.i.getValue()).booleanValue() == false) goto L18;
        if (r3 == false) goto L18;
        w.a("RealTimeChorusFeedContainer", "is enter room so return");
        return;
    L18:
        if (this.c == false) goto L20;
        return;
    L20:
        this.c = true;
        this.i.setCurrentState(Lifecycle.State.DESTROYED);
        this.m.onBizDestory();
        this.o.e();
        this.h.dispose();
        getKtvContext().getStatisticHelper().a = null;
        Disposable r4 = getKtvContext().getDataContextDisposable();
        if (r4 != null) goto L23;
    L25:
        this.a = null;
        if (KtvSettingHelper.r().booleanValue() == false) goto L29;
        removeAllViews();
        return;
    L29:
        return;
    L23:
        if (r4.isDisposed() == true) goto L25;
        r4.dispose();
        goto L25
    L11:
        r3 = false;
    L7:
        r2 = null;
        goto L9
    }

    public final void b() {
        getKtvContext().getStatisticHelper().b(getBackgroundViewStatistics());
        this.s = new d0(false, this.q, null, null, new b(this), 56);
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r0 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        d0 r1 = this.s;
        Intrinsics.checkNotNull(r1);
        q.a.c(r0, r1);
        q r2 = r0.a();
        IRoom r3 = this.f;
        if (r3 == null) goto L5;
        IVoiceLiveTheme r4 = r3.getVoiceLiveTheme();
    L6:
        r2.c(r4);
        IRoom r5 = this.f;
        if (r5 == null) goto L12;
        IVoiceLiveTheme r6 = r5.getVoiceLiveTheme();
        if (r6 == null) goto L13;
        this.m.getClass();
        Intrinsics.checkNotNullParameter(r6, "theme");
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IKtvRoomFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
    }

    public Object getCurrentSeiParseResultData() {
        return IKtvRoomFeedView.DefaultImpls.getCurrentSeiParseResultData(this);
    }

    public String getCurrentSingUserIdString() {
        return IKtvRoomFeedView.DefaultImpls.getCurrentSingUserIdString(this);
    }

    public Context getFeedContext() {
        return getContext();
    }

    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        return IKtvRoomFeedView.DefaultImpls.getFeedViewRoomInfoStore(this);
    }

    public IKtvInteractFeedView getIKtvInteractFeedView() {
        return IKtvRoomFeedView.DefaultImpls.getIKtvInteractFeedView(this);
    }

    public IMultiFeedView getIMultiFeedView() {
        return IKtvRoomFeedView.DefaultImpls.getIMultiFeedView(this);
    }

    public IPkFeedView getIPkFeedView() {
        return IKtvRoomFeedView.DefaultImpls.getIPkFeedView(this);
    }

    public List<String> getImCacheTags() {
        return IKtvRoomFeedView.DefaultImpls.getImCacheTags(this);
    }

    public IKtvComponentFeedView getKtvComponentFeedView() {
        return IKtvRoomFeedView.DefaultImpls.getKtvComponentFeedView(this);
    }

    public View getViewCompat() {
        return IKtvRoomFeedView.DefaultImpls.getViewCompat(this);
    }

    public final Observable<IPkExposeData> observeFeedViewExposeData() {
        return IKtvRoomFeedView.DefaultImpls.observeFeedViewExposeData(this);
    }

    public final void onBizLeaveRoom() {
        e();
        if (KtvSettingHelper.w() == false) goto L5;
        this.e = false;
        this.m.onBizShow();
    L5:
        RealTimeChorusMainViewWidget r0 = this.m;
        getWidgetManager();
        r0.getClass();
        oe2.a r1 = this.p;
        if (r1 == null) goto L11;
        sb0.d r2 = this.m.k0.d();
        MusicPanel r3 = r2.a();
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L10;
        r4.add(r3);
    L10:
        oe2.a.b r5 = r1.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "list");
        r5.a = r4;
        oe2.a.b r6 = r1.d;
        r6.b = r2.a();
        oe2.a.b r7 = r1.d;
        r7.c = r2.c();
        sb0.c r8 = this.m.k0.c();
        r1.e.a(r8.getOnlineUserList());
        this.m.jr(r1);
    L11:
        getKtvContext().getStatisticHelper().a = this;
        CollectionsKt.arrayListOf(new String[]{"mv"});
        RealTimeChorusMainViewWidget r9 = this.m;
        if (r9 == null) goto L15;
        r9.kr(this.a, "RealTimeChorusFeedContainer onBizLeaveRoom");
        return;
    }

    public final void onViewHolderPause() {
        if (KtvSettingHelper.w() == true) goto L5;
    L7:
        RealTimeChorusMainViewWidget r0 = this.m;
        if (r0 == null) goto L13;
        KtvPreviewSongsWidget r1 = r0.A;
        if (r1 == null) goto L14;
        r1.g.onViewHolderPause();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (this.e == true) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "RealTimeChorusFeedContainer onViewHolderPause");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.c(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.a
    public List<LinkPlayerInfo> getFeedGuestList() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.a
    public IRoom getFeedRoom() {
        return this.f;
    }

    public Lifecycle getLifecycleCompat() {
        return this.i;
    }

    public final void onViewHolderUnBind() {
        IKtvRoomFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public final void resetKtvSeiModelObject() {
        IKtvRoomFeedView.DefaultImpls.resetKtvSeiModelObject(this);
    }

    public static final /* synthetic */ RealTimeChorusFeedContainer$backgroundViewStatistics$2.a a(RealTimeChorusFeedContainer r0) {
        return r0.getBackgroundViewStatistics();
    }

    public final void bind(KTVRoomFeedModel r10) {
        Intrinsics.checkNotNullParameter(r10, "feedModelKTV");
        if (KtvSettingHelper.w() == false) goto L6;
        b();
    L6:
        if (this.p != null) goto L8;
        this.p = new oe2.a(r10, this);
    L8:
        oe2.a r11 = this.p;
        if (r11 == null) goto L11;
        this.m.jr(r11);
    L11:
        e();
        RealTimeChorusMainViewWidget r12 = this.m;
        if (r12 == null) goto L14;
        r12.kr(this.a, "RealTimeChorusFeedContainer bind");
    L14:
        this.m.Wq(new i(9, 61, null, false, false, null, 60), true);
        getKtvContext().updateCurrentUserIsSinger(false);
        if (KtvSettingHelper.w() == true) goto L18;
        b();
        return;
    }

    public final void monitorLayouts(String r1) {
        IKtvRoomFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r1) {
        IKtvRoomFeedView.DefaultImpls.onOnlineListChanged(this, r1);
    }

    public final void onSeiUpdated(SeiAppData r3) {
        if (r3 == null) goto L32;
        int r0 = r3.getSubScene();
        Integer r1 = this.k;
        if (r1 != null) goto L7;
    L13:
        this.k = Integer.valueOf(r3.getSubScene());
        this.l = Integer.valueOf(r3.getUiLayout());
        Integer r4 = this.k;
        if (r4 != null) goto L17;
        return;
    L17:
        if (r4.intValue() != 9) goto L34;
        Integer r5 = this.l;
        if (r5 != null) goto L22;
        return;
    L22:
        if (r5.intValue() == 61) goto L24;
        return;
    L24:
        if ((!LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.t)) == false) goto L36;
        Object r6 = getParent();
        if ((r6 instanceof View) == true) goto L28;
        r6 = null;
    L28:
        View r7 = (View) r6;
        if (r7 == null) goto L37;
        r7.post(new g(this, null, r7, null));
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L7:
        if (r0 != r1.intValue()) goto L13;
        int r2 = r3.getUiLayout();
        Integer r8 = this.l;
        if (r8 == null) goto L13;
        if (r2 != r8.intValue()) goto L13;
        return;
    }

    public final void onSeiUpdatedRaw(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.o.d(this, r2);
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IKtvRoomFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IKtvRoomFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public void setDataMergeCenter(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        IKtvRoomFeedView.DefaultImpls.setDataMergeCenter(this, r2);
    }

    public void setDataMergeCenterV2(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        IKtvRoomFeedView.DefaultImpls.setDataMergeCenterV2(this, r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.a
    public void setFeedGuestList(List<? extends LinkPlayerInfo> r1) {
        this.g = r1;
    }

    public void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IKtvRoomFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IKtvRoomFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateMessageHub(MessageHub r3) {
        Intrinsics.checkNotNullParameter(r3, "hub");
        this.a = r3;
        RealTimeChorusMainViewWidget r0 = this.m;
        if (r0 == null) goto L6;
        r0.kr(r3, "RealTimeChorusFeedContainer updateMessageHub");
        return;
    }

    public final void updateMvControllerSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvRoomFeedView.DefaultImpls.updateMvControllerSei(this, r2);
    }

    public final void updateRadioSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvRoomFeedView.DefaultImpls.updateRadioSei(this, r2);
    }

    public final void updateRadioTextSei(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvRoomFeedView.DefaultImpls.updateRadioTextSei(this, r2);
    }

    public final void updateRoom(IRoom r9) {
        Intrinsics.checkNotNullParameter(r9, "room");
        this.f = r9;
        KTVRoomFeedModel r0 = new KTVRoomFeedModel();
        r0.room = r9;
        IRoom r1 = this.f;
        int r2 = 0;
        if (r1 == null) goto L84;
        IVoiceLiveTheme r3 = r1.getVoiceLiveTheme();
        if (r3 == null) goto L84;
        IRoom r4 = this.f;
        List<Long> r5 = null;
        if (r4 == null) goto L9;
        Map r6 = r4.getLinkMap();
    L10:
        r0.linkerMap = r6;
        py.k r7 = r3.getSingleStaticBackground();
        String r8 = "";
        if (r7 == null) goto L21;
        List r10 = r7.getUrls();
        if (r10 == null) goto L21;
        if (CollectionsKt.getLastIndex(r10) < 0) goto L17;
        Object r11 = ListProtector.get(r10, 0);
    L19:
        if (((String) r11) == null) goto L21;
        String r12 = "";
    L22:
        r0.singleStaticBackground = r12;
        py.k r13 = r3.getAnimatedBackground();
        if (r13 == null) goto L33;
        List r14 = r13.getUrls();
        if (r14 == null) goto L33;
        if (CollectionsKt.getLastIndex(r14) < 0) goto L29;
        Object r15 = ListProtector.get(r14, 0);
    L31:
        if (((String) r15) == null) goto L33;
        String r16 = "";
    L34:
        r0.animatedBackground = r16;
        py.k r17 = r3.getEffectAvatarTalk();
        if (r17 == null) goto L45;
        List r18 = r17.getUrls();
        if (r18 == null) goto L45;
        if (CollectionsKt.getLastIndex(r18) < 0) goto L41;
        Object r19 = ListProtector.get(r18, 0);
    L43:
        if (((String) r19) == null) goto L45;
        String r20 = "";
    L46:
        r0.effectAvatarTalk = r20;
        if (r3.isRealTimeChorusTheme() == false) goto L49;
        int r21 = 100;
    L50:
        r0.bgType = r21;
        r0.emptyEndColor = r3.getEmptyEndColor();
        r0.emptyStartColor = r3.getEmptyStartColor();
        r0.id = r3.getId();
        r0.publicScreenColorValue = r0.publicScreenColorValue;
        py.k r22 = r3.getImageColdBg();
        if (r22 == null) goto L61;
        List r23 = r22.getUrls();
        if (r23 == null) goto L61;
        if (CollectionsKt.getLastIndex(r23) < 0) goto L57;
        Object r24 = ListProtector.get(r23, 0);
    L59:
        if (((String) r24) == null) goto L61;
        String r25 = "";
    L62:
        r0.imageColdBg = r25;
        py.k r26 = r3.getThumbnailBackground();
        if (r26 == null) goto L73;
        List r27 = r26.getUrls();
        if (r27 == null) goto L73;
        if (CollectionsKt.getLastIndex(r27) < 0) goto L69;
        Object r28 = ListProtector.get(r27, 0);
    L71:
        if (((String) r28) == null) goto L73;
    L74:
        r0.imageThumbnail = r8;
        r0.publicScreenColorValue = r3.getPublicScreenColorValue();
        r0.imageType = r3.getImageType();
        r0.imageUri = r3.getImageUri();
        r0.timeLimit = r3.getTimeLimit();
        r0.statusColorValue = r3.getStatusColorValue();
        IRoom r29 = this.f;
        if (r29 == null) goto L79;
        z5 r30 = r29.getLinkerDetail();
        if (r30 == null) goto L79;
        r5 = r30.getPlayModes();
    L79:
        r0.playModes = r5;
        IRoom r31 = this.f;
        if (r31 == null) goto L82;
        long r32 = r31.getId();
    L83:
        r0.roomId = r32;
        goto L84
    L82:
        r32 = 0;
        goto L83
    L69:
        r28 = "";
    L73:
        r8 = null;
        goto L74
    L57:
        r24 = "";
    L61:
        r25 = null;
        goto L62
    L49:
        r21 = r3.getBgType();
        goto L50
    L41:
        r19 = "";
    L45:
        r20 = null;
        goto L46
    L29:
        r15 = "";
    L33:
        r16 = null;
        goto L34
    L17:
        r11 = "";
    L21:
        r12 = null;
        goto L22
    L9:
        r6 = null;
    L84:
        Map r33 = r9.getAnchorABMap();
        if (r33 == null) goto L89;
        String r34 = (String) r33.get("ktv_midi_sense_enhance");
        if (r34 == null) goto L89;
        r2 = CastIntegerProtector.parseInt(r34);
    L89:
        r0.enhanceMidiMode = r2;
        r0.ownerUserIdString = r9.getOwnerUserIdString();
        r0.roomId = r9.getRoomId();
        bind(r0);
    }

    public final void updateRoomBeforeSelect(IRoom r1) {
        IKtvRoomFeedView.DefaultImpls.updateRoomBeforeSelect(this, r1);
    }

    public final void updateSpeechRecognitionSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvRoomFeedView.DefaultImpls.updateSpeechRecognitionSei(this, r2);
    }

    public final void updateSpeechRhythmSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvRoomFeedView.DefaultImpls.updateSpeechRhythmSei(this, r2);
    }

    public final void updateSubtitleSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvRoomFeedView.DefaultImpls.updateSubtitleSei(this, r2);
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IKtvRoomFeedView.DefaultImpls.updateTalkState(this, r2);
    }

    public final void onSeiUpdated(JSONObject r1) {
        IKtvRoomFeedView.DefaultImpls.onSeiUpdated(this, r1);
    }

    public final void updateTalkState(Map<String, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        IKtvRoomFeedView.DefaultImpls.updateTalkState(this, r2);
    }

    public RealTimeChorusFeedContainer(int r10, final Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, null, 0);
        this.t = r10;
        this.h = new CompositeDisposable();
        LifecycleRegistry r0 = new LifecycleRegistry(this);
        this.i = r0;
        this.j = LazyKt.lazy(new RealTimeChorusFeedContainer$widgetManager$2(this, r11));
        getWidgetManager();
        RealTimeChorusMainViewWidget r2 = new RealTimeChorusMainViewWidget(r10, null, null, null, null);
        r2.setRecyclable();
        Unit r3 = Unit.INSTANCE;
        this.m = r2;
        this.n = LazyKt.lazy(RealTimeChorusFeedContainer$backgroundViewStatistics$2.INSTANCE);
        this.o = (m) getKtvContext().getSeiProcessor().getValue();
        ALogger.i("RealTimeChorusFeedContainer", "RealTimeChorusFeedContainer showFrom == " + r10);
        View.inflate(r11, 2131567822, this);
        this.q = findViewById(2131383778);
        this.r = (FrameLayout) findViewById(2131383777);
        setImportantForAccessibility(4);
        getKtvContext().getStatisticHelper().a = this;
        setClipChildren(false);
        setClipToPadding(false);
        r0.setCurrentState(Lifecycle.State.CREATED);
        getKtvContext().getBizLcMager().a(this);
        if (((Boolean) KtvSettingHelper.y.getValue()).booleanValue() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "RealTimeChorusFeedContainer init");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.c(this);
        return;
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        this.b = r1;
    }

    public final long c(boolean r3, long r4) {
        if (r3 == false) goto L5;
        return -1;
    L5:
        if (r4 == 0) goto L9;
        if (r4 > System.currentTimeMillis()) goto L9;
        return r4;
    L9:
        return System.currentTimeMillis();
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IKtvRoomFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        ALogger.i("RealTimeChorusFeedContainer", "onWrdsDataUpdate,RealTimeChorusFeedView, syncKey: " + r2);
    }

    public final void refreshSeiCanvasAndSeiVersion(JSONObject r1, Integer r2) {
        IKtvRoomFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(this, r1, r2);
    }

    public final void updateEnterFrom(String r1, String r2) {
        IKtvRoomFeedView.DefaultImpls.updateEnterFrom(this, r1, r2);
    }

    public final void updateSeiVerAndUiLayout(int r1, int r2) {
        IKtvRoomFeedView.DefaultImpls.updateSeiVerAndUiLayout(this, r1, r2);
    }

    public final void ue(String r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "name");
        IMultiScenePreviewStatistics r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        switch(r3.hashCode()) {
            case -1753661428: goto L29;
            case -1332194002: goto L26;
            case -1059173961: goto L23;
            case -629268598: goto L20;
            case -410956671: goto L17;
            case 3497: goto L14;
            case 3351329: goto L11;
            case 103457887: goto L8;
            default: goto L47;
        };
    L47:
        return;
    L8:
        if (r3.equals("lyric") == false) goto L33;
        r0.recordSubElementShow("lyric_load", c(r4, r5));
        return;
    L33:
        return;
    L11:
        if (r3.equals("midi") == false) goto L35;
        r0.recordSubElementShow("midi_load", c(r4, r5));
        return;
    L35:
        return;
    L14:
        if (r3.equals("mv") == false) goto L37;
        r0.recordSubElementShow("mv_load", c(r4, r5));
        return;
    L37:
        return;
    L17:
        if (r3.equals("container") == false) goto L39;
    L21:
        r0.recordSubElementShow("container_load", c(r4, r5));
        return;
    L39:
        return;
    L20:
        if (r3.equals("main_widget") == true) goto L21;
        return;
    L23:
        if (r3.equals("empty_seat") == false) goto L42;
        r0.recordSubElementShow("empty_seat_load", c(r4, r5));
        return;
    L42:
        return;
    L26:
        if (r3.equals(TraceCons.METRIC_BACKGROUND) == false) goto L44;
        r0.recordSubElementShow("background_Load", c(r4, r5));
        return;
    L44:
        return;
    L29:
        if (r3.equals("guest_seat") == false) goto L46;
        r0.recordSubElementShow("guest_seat_load", c(r4, r5));
        return;
    }
}
