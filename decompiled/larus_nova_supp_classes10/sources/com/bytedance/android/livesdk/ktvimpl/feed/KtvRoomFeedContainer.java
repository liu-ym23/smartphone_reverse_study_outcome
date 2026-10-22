package com.bytedance.android.livesdk.ktvimpl.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.l;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvLinkApis;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsWidget;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.d5;
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
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001aJ\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J(\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001cH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u0018\u0010+\u001a\u00020\f2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016R$\u00102\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00109\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001d\u0010?\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0017\u0010M\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\"\u0010U\u001a\u00020N8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010\\\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0011\u0010`\u001a\u00020]8F¢\u0006\u0006\u001a\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/feed/KtvRoomFeedContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/feed/IKtvRoomFeedView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/b;", "Lcom/bytedance/android/live/ktv/common/util/l;", "Ltb0/a;", "Lcom/bytedance/android/livesdk/ktvimpl/feed/a;", "", "getFeedViewName", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "", "setLivePlayerView", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "dataMergeCenter", "setDataMergeCenter", "setDataMergeCenterV2", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkPlayerInfo;", "getOnlineList", "Landroid/view/ViewGroup;", "getKtvVideoContainer", "getKtvSeiModelObject", "getCurrentSingUserIdString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKtvEnterRoomExtraParam", "getCurrentSeiParseResultData", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "Landroid/content/Context;", "getFeedContext", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getFeedRoom", "getFeedGuestList", "guestList", "setFeedGuestList", "j", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setMRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "mRoom", "k", "Ljava/util/List;", "getMGuestList", "()Ljava/util/List;", "setMGuestList", "(Ljava/util/List;)V", "mGuestList", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "q", "Lkotlin/Lazy;", "getWidgetManager", "()Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "widgetManager", "", "r", "Ljava/lang/Integer;", "getCurSubScene", "()Ljava/lang/Integer;", "setCurSubScene", "(Ljava/lang/Integer;)V", "curSubScene", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/m;", "u", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/m;", "getSeiProcessor", "()Lcom/bytedance/android/livesdk/ktvimpl/base/sei/m;", "seiProcessor", "", "w", "Z", "getSmallWindow", "()Z", "setSmallWindow", "(Z)V", "smallWindow", "x", "I", "getShowFrom", "()I", "setShowFrom", "(I)V", "showFrom", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomFeedContainer extends FrameLayout implements IKtvRoomFeedView, LifecycleOwnerCompat, com.bytedance.android.livesdk.ktvimpl.base.sei.b, l, tb0.a, com.bytedance.android.livesdk.ktvimpl.feed.a {
    public MessageHub a;
    public ue0.c b;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d c;
    public boolean d;
    public IMultiScenePreviewStatistics e;
    public IRenderView f;
    public boolean g;
    public boolean h;
    public boolean i;
    public IRoom j;
    public List<? extends LinkPlayerInfo> k;
    public final CompositeDisposable l;
    public final e m;
    public final LifecycleRegistry n;
    public boolean o;
    public final ConcurrentHashMap<String, Object> p;
    public final Lazy q;
    public Integer r;
    public LivePlayerView s;
    public final KtvRoomContainerWidget t;
    public final m u;
    public oe2.a v;
    public boolean w;
    public int x;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvRoomFeedContainer a;

        public b(KtvRoomFeedContainer r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            Intrinsics.checkNotNullParameter(r8, "response");
            KtvRoomFeedContainer r0 = this.a;
            r0.g = false;
            w0 r9 = (w0) ((ExtraResponse) r8).data;
            if (r9 == null) goto L10;
            List r10 = r9.getMPlayerInfo();
            if (r10 == null) goto L10;
            List r11 = r10;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator<T> r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L11;
            r2.add(je0.d.d0((k) r12.next(), false));
        L11:
            r0.setMGuestList(KotlinTypeUtilsKt.castElementType(r2));
            IMultiScenePreviewStatistics r1 = this.a.e;
            if (r1 == null) goto L16;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r1, "list_v2_time", 0, 2, null);
            return;
        L16:
            return;
        L10:
            r2 = null;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvRoomFeedContainer a;

        public c(KtvRoomFeedContainer r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.g = false;
        }
    }

    static {
    }

    public KtvRoomFeedContainer(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, false, r9, 44);
    }

    private final RecyclableWidgetManager getWidgetManager() {
        return (RecyclableWidgetManager) this.q.getValue();
    }

    public String getCurrentSingUserIdString() {
        return "";
    }

    public String getFeedViewName() {
        return "KtvRoomFeedView";
    }

    public HashMap<String, Object> getKtvEnterRoomExtraParam() {
        this.d = true;
        HashMap<String, Object> r0 = new HashMap();
        r0.put("ktvContext", getKtvContext());
        r0.put("ktv_scene_widget", this.t);
        Integer r1 = this.r;
        if (r1 == null) goto L5;
        r0.put("ktv_feed_subScene", Integer.valueOf(r1.intValue()));
    L5:
        return r0;
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

    public final void onViewHolderSelected() {
        this.o = false;
        this.i = true;
        this.m.getClass();
        this.t.onBizShow();
        if (KtvSettingHelper.z() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.e(this);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.a(this, "KtvRoomFeedContainer onViewHolderSelected");
        return;
    }

    public final void onViewHolderUnSelected() {
        this.i = false;
        this.o = false;
        this.m.getClass();
        this.t.onBizHide();
        if (KtvSettingHelper.z() == false) goto L6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.f(this);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "KtvFeedContainer onViewHolderUnSelected");
        return;
    }

    public void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r1) {
    }

    public final void c() {
        qe2.c r0 = this.t.z;
        if (r0 == null) goto L10;
        r0.h = true;
        r0.e = this.j;
        int r1 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.x) == false) goto L7;
        r0.f = this.c;
    L8:
        r0.g();
        r0.f();
        return;
    L7:
        r0.g = this.b;
        r0.f = null;
        goto L8
    }

    public Object getCurrentSeiParseResultData() {
        this.m.getClass();
        return null;
    }

    public final KtvContext getKtvContext() {
        return this.t.p;
    }

    public Object getKtvSeiModelObject() {
        this.m.getClass();
        return null;
    }

    public List<LinkPlayerInfo> getOnlineList() {
        List<? extends LinkPlayerInfo> r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        ALogger.i("coreVm排查", "预览流onAttachedToWindow");
        p.g.getClass();
        p.f = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ALogger.i("coreVm排查", "预览流onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    public final void onOnlineListChanged() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        IRoom r0 = this.j;
        if (r0 == null) goto L13;
        Disposable r1 = ((KtvLinkApis) com.bytedance.android.live.network.c.b().e(KtvLinkApis.class)).getLinkListV2(r0.getId(), d5.c(r0.getOwnerUserIdString()), r0.getOwnerUserIdString(), r0.isOfficialChannelRoom()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        if (r1 == null) goto L10;
        Boolean r2 = Boolean.valueOf(this.l.add(r1));
    L11:
        r2.booleanValue();
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void reset() {
        o r0 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
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
        ALogger.i(bb0.b.b(), "KtvRoomFeedContainer ;; is enter room so return, invoke class :KtvRoomFeedContainer");
        return;
    L18:
        if (this.h == true) goto L20;
    L22:
        this.h = true;
        this.b = null;
        this.c = null;
        this.t.onBizDestory();
        this.m.getClass();
        this.u.e();
        this.l.dispose();
        getKtvContext().getStatisticHelper().a = null;
        Disposable r4 = getKtvContext().getDataContextDisposable();
        if (r4 != null) goto L25;
    L27:
        this.a = null;
        if (KtvSettingHelper.r().booleanValue() == false) goto L31;
        removeAllViews();
        return;
    L31:
        return;
    L25:
        if (r4.isDisposed() == true) goto L27;
        r4.dispose();
        goto L27
    L20:
        if (((Boolean) h.h1.getValue(null, h.a[110(0x6e, float:1.54E-43)])).booleanValue() == false) goto L22;
        return;
    L11:
        r3 = false;
    L7:
        r2 = null;
        goto L9
    }

    public final void resetKtvSeiModelObject() {
        this.m.getClass();
    }

    public final void setRenderViewBitmapToMockView() {
        Bitmap r2 = null;
        if (this.o == false) goto L54;
        Context r0 = getContext();
        TextureView r3 = this.f;
        LivePlayerView r4 = this.s;
        if (r4 != null) goto L13;
        if (r3 == null) goto L8;
        ViewParent r5 = r3.getParent();
    L10:
        if ((r5 instanceof LivePlayerView) == true) goto L12;
        r5 = null;
    L12:
        r4 = (LivePlayerView) r5;
        goto L13
    L8:
        r5 = null;
    L13:
        if (r4 == null) goto L17;
        Bitmap r6 = r4.getPreSceneRenderBitmap();
        if (r6 == null) goto L17;
    L24:
        if (r6 != null) goto L26;
    L30:
        if (r3 == null) goto L32;
        View r7 = r3.getSelfView();
    L34:
        if ((r7 instanceof TextureRenderView) == true) goto L36;
        r7 = null;
    L36:
        TextureRenderView r8 = (TextureRenderView) r7;
        if (r8 != null) goto L39;
    L50:
        qe2.a r1 = this.t.e;
        if (r1 == null) goto L53;
        r1.g(r6);
    L53:
        ALogger.i("alog_ktv_smooth_enter_room", "setRenderViewBitmapToMockView ;; renderViewBitmap == " + r6);
        return;
    L39:
        if (r8.isAvailable() == false) goto L50;
        if (r8.getWidth() <= 0) goto L50;
        if (r8.getHeight() <= 0) goto L50;
        if (r0 == null) goto L46;
        Resources r9 = r0.getResources();
        Bitmap r10 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()), r8.getWidth(), r8.getHeight(), Bitmap.Config.RGB_565);
    L47:
        if (r10 == null) goto L49;
        r2 = r8.getBitmap(r10);
    L49:
        r6 = r2;
        goto L50
    L46:
        r10 = Bitmap.createBitmap(r8.getWidth(), r8.getHeight(), Bitmap.Config.RGB_565);
        goto L47
    L32:
        r7 = null;
        goto L34
    L26:
        if (r6.getWidth() <= 0) goto L30;
        if (r6.getHeight() <= 0) goto L30;
    L17:
        if ((r3 instanceof TextureView) == true) goto L19;
        TextureView r11 = null;
    L20:
        TextureView r12 = r11;
        if (r12 == null) goto L23;
        r6 = r12.getBitmap();
        goto L24
    L23:
        r6 = null;
        goto L24
    L19:
        r11 = r3;
        goto L20
    L54:
        qe2.a r13 = this.t.e;
        if (r13 == null) goto L57;
        r13.g(null);
    L57:
        ALogger.i("alog_ktv_smooth_enter_room", "setRenderViewBitmapToMockView ;; not open video");
    }

    public final void b() {
        getKtvContext().getStatisticHelper().b(this.t);
        RecyclableWidgetManager r0 = getWidgetManager();
        if (r0 == null) goto L5;
        r0.load(this, this.t, false);
    L5:
        KtvRoomContainerWidget r1 = this.t;
        View r2 = null;
        if (r1 == null) goto L8;
        View r3 = ((Widget) r1).contentView;
    L10:
        if ((r3 instanceof com.bytedance.android.live.ktv.common.util.c) == false) goto L13;
        r2 = r3;
    L13:
        com.bytedance.android.live.ktv.common.util.c r4 = (com.bytedance.android.live.ktv.common.util.c) r2;
        if (r4 == null) goto L17;
        getKtvContext().getStatisticHelper().b(r4);
        return;
    L17:
        return;
    L8:
        r3 = null;
        goto L10
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return IKtvRoomFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(this);
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
        c();
        b();
        if (KtvSettingHelper.w() == false) goto L5;
        this.d = false;
        this.t.onBizShow();
    L5:
        KtvRoomContainerWidget r0 = this.t;
        r0.B = getWidgetManager();
        oe2.a r1 = this.v;
        if (r1 == null) goto L12;
        sb0.d r2 = this.t.q.d();
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
        sb0.c r8 = this.t.q.c();
        r1.e.a(r8.getOnlineUserList());
        this.t.Rq(r1);
    L12:
        if (KtvSettingHelper.w() == true) goto L16;
        KtvRoomContainerWidget r9 = this.t;
        Function0<? extends IRenderView> r10 = new AnonymousClass2(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "provider");
        qe2.a r11 = r9.e;
        if (r11 == null) goto L16;
        r11.c(r10);
    L16:
        getKtvContext().getStatisticHelper().a = this;
    }

    public final void onViewHolderPause() {
        IKtvRoomFeedView.DefaultImpls.onViewHolderPause(this);
        if (KtvSettingHelper.z() == true) goto L5;
    L10:
        KtvPreviewSongsWidget r0 = this.t.O;
        if (r0 == null) goto L14;
        r0.g.onViewHolderPause();
        return;
    L14:
        return;
    L5:
        if (KtvSettingHelper.w() == true) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "KtvRoomFeedContainer onViewHolderPause");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.c(this);
        goto L10
    L7:
        if (this.d == true) goto L10;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "KtvRoomFeedContainer onViewHolderPause");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.c(this);
        goto L10
    }

    public final void onViewHolderResume() {
        IKtvRoomFeedView.DefaultImpls.onViewHolderResume(this);
        if (KtvSettingHelper.z() == true) goto L5;
    L9:
        this.t.Mq("onViewHolderResume");
        KtvPreviewSongsWidget r0 = this.t.O;
        if (r0 == null) goto L13;
        r0.g.onViewHolderResume();
        return;
    L13:
        return;
    L5:
        if (((Boolean) KtvSettingHelper.I0.getValue()).booleanValue() == false) goto L9;
        if (this.i == false) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.a(this, "KtvRoomFeedContainer onViewHolderResume");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.d(this);
        goto L9
    }

    public final Integer getCurSubScene() {
        return this.r;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.a
    public List<LinkPlayerInfo> getFeedGuestList() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.a
    public IRoom getFeedRoom() {
        return this.j;
    }

    public Lifecycle getLifecycleCompat() {
        return this.n;
    }

    public final List<LinkPlayerInfo> getMGuestList() {
        return this.k;
    }

    public final IRoom getMRoom() {
        return this.j;
    }

    public final m getSeiProcessor() {
        return this.u;
    }

    public final int getShowFrom() {
        return this.x;
    }

    public final boolean getSmallWindow() {
        return this.w;
    }

    public final void onViewHolderUnBind() {
        IKtvRoomFeedView.DefaultImpls.onViewHolderUnBind(this);
    }

    public final void bind(KTVRoomFeedModel r10) {
        Intrinsics.checkNotNullParameter(r10, "feedModelKTV");
        this.m.getClass();
        if (this.v != null) goto L5;
        this.v = new oe2.a(r10, this);
    L5:
        oe2.a r11 = this.v;
        if (r11 == null) goto L8;
        this.t.Rq(r11);
    L8:
        b();
        KtvRoomContainerWidget r12 = this.t;
        MessageHub r0 = this.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter("KtvRoomFeedContainer bind", "source");
        ALogger.i("KtvRoomContainerWidget", "updateMessageHub ;; source == ".concat("KtvRoomFeedContainer bind"));
        r12.I = r0;
        this.t.Lq(new i(9, 0, null, false, false, null, 60), true);
        getKtvContext().updateCurrentUserIsSinger(false);
        IRoom r13 = this.j;
        if (r13 == null) goto L15;
        IVoiceLiveTheme r14 = r13.getVoiceLiveTheme();
        if (r14 == null) goto L15;
        KtvRoomContainerWidget r1 = this.t;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "theme");
        qe2.a r2 = r1.e;
        if (r2 == null) goto L15;
        r2.n(r14);
    L15:
        Iterator<Map.Entry<String, Object>> r15 = this.p.entrySet().iterator();
    L17:
        if (r15.hasNext() == false) goto L21;
        Map.Entry<String, Object> r3 = r15.next();
        String r4 = r3.getKey();
        Object r5 = r3.getValue();
        KtvRoomContainerWidget r6 = this.t;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        qe2.a r7 = r6.e;
        if (r7 == null) goto L17;
        r7.k(r4, r5);
        goto L17
    L21:
        this.p.clear();
    }

    public final void monitorLayouts(String r1) {
        IKtvRoomFeedView.DefaultImpls.monitorLayouts(this, r1);
    }

    public final void onKtvVideoStateChange(ld0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "videoSei");
        if (this.f != null) goto L5;
        return;
    L5:
        String r0 = r5.linkId;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        ALogger.i("KtvRoomFeedContainer", "The guest singing is over, and there is no one singing on the seat. It needs to be reset to the idle state.");
    L19:
        this.o = r5.b();
        r5.toString();
        this.m.getClass();
        this.m.getClass();
        ALogger.e("ttlive_link_ktv", "updateVideoController:" + this.o);
        if (this.o == false) goto L27;
        KtvRoomContainerWidget r6 = this.t;
        Function0<? extends IRenderView> r2 = new KtvRoomFeedContainer$updateVideoController$1(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r2, "provider");
        qe2.a r7 = r6.e;
        if (r7 == null) goto L24;
        r7.c(r2);
    L24:
        qe2.a r8 = this.t.e;
        if (r8 == null) goto L31;
        r8.o(true);
        return;
    L31:
        return;
    L27:
        qe2.a r9 = this.t.e;
        if (r9 == null) goto L33;
        r9.o(false);
        return;
    L33:
        return;
    L15:
        if (this.o != r5.b()) goto L19;
        if (KtvSettingHelper.w() == true) goto L19;
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r2) {
        if (r2 == null) goto L6;
        this.k = r2;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo>");
    }

    public final void onSeiUpdated(SeiAppData r3) {
        if (r3 == null) goto L22;
        int r0 = r3.getSubScene();
        Integer r1 = this.r;
        if (r1 != null) goto L7;
    L8:
        Integer r4 = Integer.valueOf(r3.getSubScene());
        this.r = r4;
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.intValue() == 9) goto L14;
        return;
    L14:
        if ((!LinkFeedTypeConstant.Companion.isDouyinFullScreen(this.x)) == false) goto L25;
        Object r5 = getParent();
        if ((r5 instanceof View) == true) goto L18;
        r5 = null;
    L18:
        View r6 = (View) r5;
        if (r6 == null) goto L26;
        r6.post(new d(r6, this, null, null));
        return;
    L26:
        return;
    L25:
        return;
    L7:
        if (r0 != r1.intValue()) goto L8;
        return;
    }

    public final void onSeiUpdatedRaw(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.u.d(this, r2);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
    }

    public final void putImCacheContent(Map<String, ? extends ImCacheUnit> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IKtvRoomFeedView.DefaultImpls.putImCacheContent(this, r2);
    }

    public final void sendMessage(List<? extends tlc.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        IKtvRoomFeedView.DefaultImpls.sendMessage(this, r2);
    }

    public final void setCurSubScene(Integer r1) {
        this.r = r1;
    }

    public void setDataMergeCenter(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        if ((r2 instanceof ue0.c) == true) goto L5;
        r2 = null;
    L5:
        this.b = (ue0.c) r2;
    }

    public void setDataMergeCenterV2(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "dataMergeCenter");
        if ((r2 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.d) == true) goto L5;
        r2 = null;
    L5:
        this.c = (com.bytedance.android.live.liveinteract.plantform.datamerge.d) r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.feed.a
    public void setFeedGuestList(List<? extends LinkPlayerInfo> r1) {
        this.k = r1;
    }

    public void setInteractPlayView(IInteractPlayView r2) {
        Intrinsics.checkNotNullParameter(r2, "interactPlayView");
        IKtvRoomFeedView.DefaultImpls.setInteractPlayView(this, r2);
    }

    public void setLivePlayerView(final IRenderView r4) {
        this.f = r4;
        ViewParent r0 = null;
        if (r4 == null) goto L5;
        ViewParent r1 = r4.getParent();
    L7:
        if ((r1 instanceof LivePlayerView) == false) goto L10;
        r0 = r1;
    L10:
        LivePlayerView r2 = (LivePlayerView) r0;
        if (r2 == null) goto L13;
        this.s = r2;
    L13:
        KtvRoomContainerWidget r3 = this.t;
        Function0<? extends IRenderView> r5 = new C02362(r4);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "provider");
        qe2.a r6 = r3.e;
        if (r6 == null) goto L17;
        r6.c(r5);
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setMGuestList(List<? extends LinkPlayerInfo> r1) {
        this.k = r1;
    }

    public final void setMRoom(IRoom r1) {
        this.j = r1;
    }

    public final void setShowFrom(int r1) {
        this.x = r1;
    }

    public final void setSmallWindow(boolean r1) {
        this.w = r1;
    }

    public final void updateActionCaller(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        IKtvRoomFeedView.DefaultImpls.updateActionCaller(this, r2);
    }

    public final void updateMessageHub(MessageHub r4) {
        Intrinsics.checkNotNullParameter(r4, "hub");
        this.a = r4;
        KtvRoomContainerWidget r0 = this.t;
        r0.getClass();
        Intrinsics.checkNotNullParameter("KtvRoomFeedContainer updateMessageHub", "source");
        ALogger.i("KtvRoomContainerWidget", "updateMessageHub ;; source == ".concat("KtvRoomFeedContainer updateMessageHub"));
        r0.I = r4;
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

    public final void updateRoom(IRoom r10) {
        Intrinsics.checkNotNullParameter(r10, "room");
        this.j = r10;
        KTVRoomFeedModel r0 = new KTVRoomFeedModel();
        r0.room = r10;
        IRoom r1 = this.j;
        int r2 = 0;
        if (r1 == null) goto L153;
        IVoiceLiveTheme r3 = r1.getVoiceLiveTheme();
        if (r3 == null) goto L153;
        IRoom r4 = this.j;
        List<Long> r5 = null;
        if (r4 == null) goto L9;
        Map r6 = r4.getLinkMap();
    L10:
        r0.linkerMap = r6;
        boolean r7 = true;
        String r8 = "";
        if (r3.getSingleStaticBackground() == null) goto L36;
        py.k r9 = r3.getSingleStaticBackground();
        if (r9 == null) goto L15;
        List r11 = r9.getUrls();
    L16:
        if (r11 == null) goto L36;
        py.k r12 = r3.getSingleStaticBackground();
        if (r12 == null) goto L20;
        List r13 = r12.getUrls();
    L21:
        List r14 = r13;
        if (r14 != null) goto L24;
    L27:
        boolean r15 = true;
    L28:
        if (r15 == true) goto L36;
        py.k r16 = r3.getSingleStaticBackground();
        if (r16 == null) goto L35;
        List r17 = r16.getUrls();
        if (r17 == null) goto L35;
        String r18 = (String) ListProtector.get(r17, 0);
    L37:
        r0.singleStaticBackground = r18;
        if (r3.getAnimatedBackground() == null) goto L63;
        py.k r19 = r3.getAnimatedBackground();
        if (r19 == null) goto L42;
        List r20 = r19.getUrls();
    L43:
        if (r20 == null) goto L63;
        py.k r21 = r3.getAnimatedBackground();
        if (r21 == null) goto L47;
        List r22 = r21.getUrls();
    L48:
        List r23 = r22;
        if (r23 != null) goto L51;
    L54:
        boolean r24 = true;
    L55:
        if (r24 == true) goto L63;
        py.k r25 = r3.getAnimatedBackground();
        if (r25 == null) goto L62;
        List r26 = r25.getUrls();
        if (r26 == null) goto L62;
        String r27 = (String) ListProtector.get(r26, 0);
    L64:
        r0.animatedBackground = r27;
        if (r3.getEffectAvatarTalk() == null) goto L90;
        py.k r28 = r3.getEffectAvatarTalk();
        if (r28 == null) goto L69;
        List r29 = r28.getUrls();
    L70:
        if (r29 == null) goto L90;
        py.k r30 = r3.getEffectAvatarTalk();
        if (r30 == null) goto L74;
        List r31 = r30.getUrls();
    L75:
        List r32 = r31;
        if (r32 != null) goto L78;
    L81:
        boolean r33 = true;
    L82:
        if (r33 == true) goto L90;
        py.k r34 = r3.getEffectAvatarTalk();
        if (r34 == null) goto L89;
        List r35 = r34.getUrls();
        if (r35 == null) goto L89;
        String r36 = (String) ListProtector.get(r35, 0);
    L91:
        r0.effectAvatarTalk = r36;
        r0.bgType = r3.getBgType();
        r0.emptyEndColor = r3.getEmptyEndColor();
        r0.emptyStartColor = r3.getEmptyStartColor();
        r0.id = r3.getId();
        r0.publicScreenColorValue = r0.publicScreenColorValue;
        if (r3.getImageColdBg() == null) goto L117;
        py.k r37 = r3.getImageColdBg();
        if (r37 == null) goto L96;
        List r38 = r37.getUrls();
    L97:
        if (r38 == null) goto L117;
        py.k r39 = r3.getImageColdBg();
        if (r39 == null) goto L101;
        List r40 = r39.getUrls();
    L102:
        List r41 = r40;
        if (r41 != null) goto L105;
    L108:
        boolean r42 = true;
    L109:
        if (r42 == true) goto L117;
        py.k r43 = r3.getImageColdBg();
        if (r43 == null) goto L116;
        List r44 = r43.getUrls();
        if (r44 == null) goto L116;
        String r45 = (String) ListProtector.get(r44, 0);
    L118:
        r0.imageColdBg = r45;
        if (r3.getThumbnailBackground() == null) goto L143;
        py.k r46 = r3.getThumbnailBackground();
        if (r46 == null) goto L123;
        List r47 = r46.getUrls();
    L124:
        if (r47 == null) goto L143;
        py.k r48 = r3.getThumbnailBackground();
        if (r48 == null) goto L128;
        List r49 = r48.getUrls();
    L129:
        List r50 = r49;
        if (r50 != null) goto L132;
    L135:
        if (r7 == true) goto L143;
        py.k r51 = r3.getThumbnailBackground();
        if (r51 == null) goto L142;
        List r52 = r51.getUrls();
        if (r52 == null) goto L142;
        r8 = (String) ListProtector.get(r52, 0);
    L142:
        r8 = null;
        goto L143
    L132:
        if (r50.isEmpty() == true) goto L135;
        r7 = false;
        goto L135
    L128:
        r49 = null;
        goto L129
    L123:
        r47 = null;
    L143:
        r0.imageThumbnail = r8;
        r0.publicScreenColorValue = r3.getPublicScreenColorValue();
        r0.imageType = r3.getImageType();
        r0.imageUri = r3.getImageUri();
        r0.timeLimit = r3.getTimeLimit();
        r0.statusColorValue = r3.getStatusColorValue();
        IRoom r53 = this.j;
        if (r53 == null) goto L148;
        z5 r54 = r53.getLinkerDetail();
        if (r54 == null) goto L148;
        r5 = r54.getPlayModes();
    L148:
        r0.playModes = r5;
        IRoom r55 = this.j;
        if (r55 == null) goto L151;
        long r56 = r55.getId();
    L152:
        r0.roomId = r56;
        goto L153
    L151:
        r56 = 0;
    L116:
        r45 = null;
        goto L118
    L105:
        if (r41.isEmpty() == true) goto L108;
        r42 = false;
        goto L109
    L101:
        r40 = null;
        goto L102
    L96:
        r38 = null;
    L117:
        r45 = "";
    L89:
        r36 = null;
        goto L91
    L78:
        if (r32.isEmpty() == true) goto L81;
        r33 = false;
        goto L82
    L74:
        r31 = null;
        goto L75
    L69:
        r29 = null;
    L90:
        r36 = "";
    L62:
        r27 = null;
        goto L64
    L51:
        if (r23.isEmpty() == true) goto L54;
        r24 = false;
        goto L55
    L47:
        r22 = null;
        goto L48
    L42:
        r20 = null;
    L63:
        r27 = "";
    L35:
        r18 = null;
        goto L37
    L24:
        if (r14.isEmpty() == true) goto L27;
        r15 = false;
        goto L28
    L20:
        r13 = null;
        goto L21
    L15:
        r11 = null;
    L36:
        r18 = "";
        goto L37
    L9:
        r6 = null;
    L153:
        Map r57 = r10.getAnchorABMap();
        if (r57 == null) goto L158;
        String r58 = (String) r57.get("ktv_midi_sense_enhance");
        if (r58 == null) goto L158;
        r2 = CastIntegerProtector.parseInt(r58);
    L158:
        r0.enhanceMidiMode = r2;
        r0.ownerUserIdString = r10.getOwnerUserIdString();
        r0.roomId = r10.getRoomId();
        bind(r0);
        c();
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

    public final long a(boolean r3, long r4) {
        if (r3 == false) goto L5;
        return -1;
    L5:
        if (r4 == 0) goto L9;
        if (r4 > System.currentTimeMillis()) goto L9;
        return r4;
    L9:
        return System.currentTimeMillis();
    }

    public final void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r1, long r2) {
        this.e = r1;
    }

    public final void onScreenSizeChange(int r1, int r2) {
        IKtvRoomFeedView.DefaultImpls.onScreenSizeChange(this, r1, r2);
    }

    public final void onWrdsDataUpdate(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        ALogger.i("KtvRoomFeedContainer", "onWrdsDataUpdate,KtvRoomFeedView, syncKey: " + r4);
        if (this.v != null) goto L6;
        if (r5 == null) goto L6;
        this.p.put(r4, r5);
        return;
    L6:
        KtvRoomContainerWidget r1 = this.t;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        qe2.a r0 = r1.e;
        if (r0 == null) goto L9;
        r0.k(r4, r5);
    L9:
        this.p.clear();
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

    public final void ue(String r6, boolean r7, long r8) {
        Intrinsics.checkNotNullParameter(r6, "name");
        IMultiScenePreviewStatistics r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        switch(r6.hashCode()) {
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
        if (r6.equals("lyric") == false) goto L33;
        r0.recordSubElementShow("lyric_load", a(r7, r8));
        return;
    L33:
        return;
    L11:
        if (r6.equals("midi") == false) goto L35;
        r0.recordSubElementShow("midi_load", a(r7, r8));
        return;
    L35:
        return;
    L14:
        if (r6.equals("mv") == false) goto L37;
        r0.recordSubElementShow("mv_load", a(r7, r8));
        r0.recordSubElementShow("background_Load", a(r7, r8));
        return;
    L37:
        return;
    L17:
        if (r6.equals("container") == false) goto L39;
    L21:
        r0.recordSubElementShow("container_load", a(r7, r8));
        return;
    L39:
        return;
    L20:
        if (r6.equals("main_widget") == true) goto L21;
        return;
    L23:
        if (r6.equals("empty_seat") == false) goto L42;
        r0.recordSubElementShow("empty_seat_load", a(r7, r8));
        return;
    L42:
        return;
    L26:
        if (r6.equals(TraceCons.METRIC_BACKGROUND) == false) goto L44;
        r0.recordSubElementShow("background_Load", a(r7, r8));
        return;
    L44:
        return;
    L29:
        if (r6.equals("guest_seat") == false) goto L46;
        r0.recordSubElementShow("guest_seat_load", a(r7, r8));
        return;
    }

    public KtvRoomFeedContainer(final Context r11, AttributeSet r12, boolean r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 8) == 0) goto L8;
        r13 = false;
    L8:
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, 0);
        this.w = r13;
        this.x = r14;
        this.l = new CompositeDisposable();
        this.m = new e();
        LifecycleRegistry r16 = new LifecycleRegistry(this);
        this.n = r16;
        this.p = new ConcurrentHashMap();
        this.q = LazyKt.lazy(new KtvRoomFeedContainer$widgetManager$2(this, r11));
        KtvRoomContainerWidget r17 = new KtvRoomContainerWidget(null, getWidgetManager(), null, null, null, null, null, null);
        r17.setRecyclable();
        Unit r18 = Unit.INSTANCE;
        this.t = r17;
        m r19 = (m) getKtvContext().getSeiProcessor().getValue();
        r19.getClass();
        this.u = r19;
        View.inflate(r11, 2131567732, this);
        setImportantForAccessibility(4);
        getKtvContext().getStatisticHelper().a = this;
        setClipChildren(false);
        setClipToPadding(false);
        r16.markState(Lifecycle.State.CREATED);
        getKtvContext().getBizLcMager().a(this);
        if (((Boolean) KtvSettingHelper.y.getValue()).booleanValue() == false) goto L12;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.b(this, "KtvRoomFeedContainer init");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.a.c(this);
        return;
    }
}
