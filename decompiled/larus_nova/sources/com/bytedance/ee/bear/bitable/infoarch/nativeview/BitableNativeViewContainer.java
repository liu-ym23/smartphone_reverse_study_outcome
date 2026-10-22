package com.bytedance.ee.bear.bitable.infoarch.nativeview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.ViewHolder;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.calendar.CalendarViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.CardViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GallerySetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldHeaderData;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import zs4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010A\u001a\u00020BJ\u001c\u0010C\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0D2\u0006\u0010E\u001a\u00020(H\u0016J\b\u0010F\u001a\u000204H\u0016J-\u0010G\u001a\u00020B2\u001e\u0010H\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020K0J0I\"\b\u0012\u0004\u0012\u00020K0JH\u0002¢\u0006\u0002\u0010LJ\n\u0010M\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010N\u001a\u00020B2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010O\u001a\u00020PH\u0016J\u000e\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020B2\u0006\u0010U\u001a\u00020-J\u000e\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020XJ\u0016\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]J\u0016\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020^2\u0006\u0010\\\u001a\u00020]JB\u0010Y\u001a\u00020B2\b\u0010\u0003\u001a\u0004\u0018\u00010_2\u0006\u0010Z\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\u001e\b\u0002\u0010c\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010(0e\u0018\u00010dJ\b\u0010f\u001a\u00020BH\u0002J\u0016\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020g2\u0006\u0010\\\u001a\u00020]J&\u0010h\u001a\u00020-2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010k\u001a\u00020XH\u0002J\u0010\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020nH\u0002J6\u0010o\u001a\u00020B2\b\u0010\u0003\u001a\u0004\u0018\u00010_2\u0006\u0010Z\u001a\u00020p2\u0006\u0010\\\u001a\u00020]2\b\u0010q\u001a\u0004\u0018\u00010b2\b\b\u0002\u0010r\u001a\u00020-H\u0007J\u000e\u0010s\u001a\u00020B2\u0006\u0010t\u001a\u00020uJ\u0006\u0010v\u001a\u00020BJ\u000e\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020-J\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JJ\u0006\u0010z\u001a\u00020\u0016J\u001c\u0010{\u001a\u00020B2\u0006\u0010|\u001a\u00020}2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020(0/j\b\u0012\u0004\u0012\u00020(`0X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u0004\u0018\u000106X\u0096\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010<\u001a\u0004\u0018\u00010(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006~"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/BitableNativeViewContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/ViewContainerContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cardViewFromXml", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardViewContainer;", "getCardViewFromXml", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardViewContainer;", "setCardViewFromXml", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardViewContainer;)V", "galleryViewFromXml", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryViewContainer;", "getGalleryViewFromXml", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryViewContainer;", "setGalleryViewFromXml", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryViewContainer;)V", "gridViewFromXml", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer;", "getGridViewFromXml", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer;", "setGridViewFromXml", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer;)V", "calendarViewFromXml", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarViewContainer;", "getCalendarViewFromXml", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarViewContainer;", "setCalendarViewFromXml", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarViewContainer;)V", "emptyViewFromXml", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;", "getEmptyViewFromXml", "()Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;", "setEmptyViewFromXml", "(Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyView;)V", "documentTraceId", "", "viewDataProvider", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/BitableViewDataProvider;", "isUpdateSceneNotReady", "Lkotlin/Function0;", "", "firstRenderSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "emptyTTV", "Ljava/util/concurrent/atomic/AtomicBoolean;", "viewContainerType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/MobileViewContainerType;", "firstRebuildTime", "", "getFirstRebuildTime", "()Ljava/lang/Long;", "setFirstRebuildTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "objToken", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "enableBottomSpace", "", "isFirstRender", "Lkotlin/Pair;", "viewType", "getMobileViewContainerType", "bindContainerContext", "containers", "", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/list/BaseListViewContainer;", "", "([Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/list/BaseListViewContainer;)V", "getDocumentTraceId", "setDocumentTraceId", "getViewDataProvider", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/IViewDataProvider;", "onSceneChanged", "scene", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/SceneModel;", "setBackgroundAllowed", "allow", "onKeyboardChanged", "height", "", "setData", "data", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardViewData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryViewData;", "Landroid/app/Activity;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarViewData;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "interceptors", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "showOnLoadFail", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewData;", "tryShowEmpty", "emptyData", "Lcom/bytedance/ee/bear/bitable/uikit/empty/EmptyData;", "marginTop", "checkFirstSetData", "view", "Landroid/view/View;", "setNativeViewData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "handlerFun", "setViewVisible", "setVisibleNativeView", "subViewType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/SubViewType;", LiveCommonConstants.REASON_ON_DEDTROY, "onScreenOrientationChanged", "landscape", "getCurrentVisibleView", "getGridView", "init", "viewHolder", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ViewHolder;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableNativeViewContainer extends FrameLayout implements c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f213229n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CardViewContainer f213230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GalleryViewContainer f213231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GridViewContainer f213232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CalendarViewContainer f213233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EmptyView f213234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f213235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BitableViewDataProvider f213236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Boolean> f213237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashSet<String> f213238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f213239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MobileViewContainerType f213240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f213241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f213242m;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213243a = null;

        static {
            int[] r100 = new int[SubViewType.values().length];
            r100[SubViewType.NativeGrid.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SubViewType.NativeCard.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SubViewType.NativeGallery.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SubViewType.LynxCalendar.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f213243a = r100;
        }
    }

    public final CalendarViewContainer getCalendarViewFromXml() {
        KeyEvent.Callback r100 = this.f213233d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.calendar_view);
        this.f213233d = (CalendarViewContainer) r100;
    L6:
        return (CalendarViewContainer) r100;
    }

    public final CardViewContainer getCardViewFromXml() {
        KeyEvent.Callback r100 = this.f213230a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.card_view);
        this.f213230a = (CardViewContainer) r100;
    L6:
        return (CardViewContainer) r100;
    }

    public final EmptyView getEmptyViewFromXml() {
        KeyEvent.Callback r100 = this.f213234e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.empty_view);
        this.f213234e = (EmptyView) r100;
    L6:
        return (EmptyView) r100;
    }

    public final GalleryViewContainer getGalleryViewFromXml() {
        KeyEvent.Callback r100 = this.f213231b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.gallery_view);
        this.f213231b = (GalleryViewContainer) r100;
    L6:
        return (GalleryViewContainer) r100;
    }

    public final GridViewContainer getGridViewFromXml() {
        KeyEvent.Callback r100 = this.f213232c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.grid_view);
        this.f213232c = (GridViewContainer) r100;
    L6:
        return (GridViewContainer) r100;
    }

    public final void l() {
        EmptyData r100 = new EmptyData();
        r100.setText(getContext().getString(R.string.CreationMobile_Common_Placeholder_FailedToLoad));
        Icon r101 = new Icon();
        r101.setImgRes(Integer.valueOf(R.drawable.ccm_empty_negative_load_failed));
        r100.setIcon(r101);
        m(r100, null, 0);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewContainer$e] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewContainer$e] */
    public final void e() {
        if (getGridViewFromXml().getVisibility() != 0) goto L9;
        GridViewContainer r100 = getGridViewFromXml();
        r100.getRecyclerView().getRowScrollManager().c(r100.getRecyclerView().getMeasuredWidth(), r100.getViewContext().h().d(), -1);
        GridFieldHeaderData r101 = r100.getViewContext().h().J();
        if (r101 == null) goto L7;
        r100.f213541o.f210816b.g(r101, r100.getViewContext().e());
    L7:
        r100.notifyDataSetChanged();
        return;
    }

    public final BaseListViewContainer<Object> getCurrentVisibleView() {
        if (getGridViewFromXml().getVisibility() != 0) goto L6;
        GridViewContainer r100 = getGridViewFromXml();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        return r100;
    L6:
        if (getCardViewFromXml().getVisibility() != 0) goto L9;
        CardViewContainer r101 = getCardViewFromXml();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        return r101;
    L9:
        if (getGalleryViewFromXml().getVisibility() != 0) goto L11;
        GalleryViewContainer r102 = getGalleryViewFromXml();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        return r102;
    L11:
        return null;
    }

    public final GridViewContainer getGridView() {
        return getGridViewFromXml();
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.c
    public String getDocumentTraceId() {
        return this.f213235f;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.c
    public Long getFirstRebuildTime() {
        return this.f213241l;
    }

    public MobileViewContainerType getMobileViewContainerType() {
        return this.f213240k;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.c
    public String getObjToken() {
        return this.f213242m;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.c
    public com.bytedance.ee.bear.bitable.infoarch.nativeview.a getViewDataProvider() {
        return this.f213236g;
    }

    public BitableNativeViewContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.c
    public final Pair<Boolean, Boolean> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewType");
        boolean r101 = this.f213238i.isEmpty();
        boolean r102 = !this.f213238i.contains(r100);
        this.f213238i.add(r100);
        return new Pair(Boolean.valueOf(r101), Boolean.valueOf(r102));
    }

    public final void b(View r100) {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.native_view_fix_update_not_ready") == false) goto L13;
        Function0<Boolean> r101 = this.f213237h;
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.invoke().booleanValue() != true) goto L9;
    L10:
        if (r102 == false) goto L14;
        setVisibility(0);
        r100.setVisibility(0);
        return;
    L14:
        return;
    L9:
        r102 = false;
        goto L10
    }

    public final void d(SceneModel r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (r100.isNativeCard() == false) goto L6;
        setVisibility(0);
        getCardViewFromXml().setVisibility(0);
        getGridViewFromXml().setVisibility(8);
        getGalleryViewFromXml().setVisibility(8);
        getCalendarViewFromXml().setVisibility(8);
        return;
    L6:
        if (r100.isNativeGallery() == false) goto L9;
        setVisibility(0);
        getCardViewFromXml().setVisibility(8);
        getGridViewFromXml().setVisibility(8);
        getGalleryViewFromXml().setVisibility(0);
        getCalendarViewFromXml().setVisibility(8);
        return;
    L9:
        if (r100.isNativeGrid() == false) goto L12;
        setVisibility(0);
        getCardViewFromXml().setVisibility(8);
        getGridViewFromXml().setVisibility(0);
        getGalleryViewFromXml().setVisibility(8);
        getCalendarViewFromXml().setVisibility(8);
        return;
    L12:
        if (r100.isNativeCalendar() == false) goto L14;
        setVisibility(0);
        getCardViewFromXml().setVisibility(8);
        getGridViewFromXml().setVisibility(8);
        getGalleryViewFromXml().setVisibility(8);
        getCalendarViewFromXml().setVisibility(0);
        return;
    L14:
        setVisibility(8);
        getGalleryViewFromXml().setVisibility(8);
        getCardViewFromXml().setVisibility(8);
        getGridViewFromXml().setVisibility(8);
        getCalendarViewFromXml().setVisibility(8);
    }

    public final void setBackgroundAllowed(boolean r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        getCardViewFromXml().getRecyclerView().setBackgroundResource(R.drawable.bitable_card_view_bg_shape);
        getGridViewFromXml().setBackgroundResource(R.color.bg_body);
        getGalleryViewFromXml().getRecyclerView().setBackgroundResource(R.drawable.bitable_card_view_bg_shape);
        getEmptyViewFromXml().setBackgroundColor(UDColorUtils.getColor(r101, R.color.ud_N00));
        return;
    L7:
        getCardViewFromXml().getRecyclerView().setBackground(null);
        getGridViewFromXml().setBackground(null);
        getGalleryViewFromXml().getRecyclerView().setBackground(null);
        getEmptyViewFromXml().setBackground(null);
    }

    public final void setCalendarViewFromXml(CalendarViewContainer r100) {
        this.f213233d = r100;
    }

    public final void setCardViewFromXml(CardViewContainer r100) {
        this.f213230a = r100;
    }

    public final void setDocumentTraceId(String r100) {
        tt5.a.h("NATIVE_VIEW_TAG", "setDocumentTraceId>>> documentId: " + r100);
        this.f213235f = r100;
    }

    public final void setEmptyViewFromXml(EmptyView r100) {
        this.f213234e = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.c
    public void setFirstRebuildTime(Long r100) {
        this.f213241l = r100;
    }

    public final void setGalleryViewFromXml(GalleryViewContainer r100) {
        this.f213231b = r100;
    }

    public final void setGridViewFromXml(GridViewContainer r100) {
        this.f213232c = r100;
    }

    public void setObjToken(String r100) {
        this.f213242m = r100;
    }

    public final void setVisibleNativeView(SubViewType r100) {
        Intrinsics.checkNotNullParameter(r100, "subViewType");
        int r101 = a.f213243a[r100.ordinal()];
        if (r101 != 1) goto L5;
        m.z(getGridViewFromXml(), true);
        m.z(getCardViewFromXml(), false);
        m.z(getGalleryViewFromXml(), false);
        m.z(getCalendarViewFromXml(), false);
        return;
    L5:
        if (r101 != 2) goto L7;
        m.z(getGridViewFromXml(), false);
        m.z(getCardViewFromXml(), true);
        m.z(getGalleryViewFromXml(), false);
        m.z(getCalendarViewFromXml(), false);
        return;
    L7:
        if (r101 != 3) goto L9;
        m.z(getGridViewFromXml(), false);
        m.z(getCardViewFromXml(), false);
        m.z(getGalleryViewFromXml(), true);
        m.z(getCalendarViewFromXml(), false);
        return;
    L9:
        if (r101 != 4) goto L19;
        m.z(getGridViewFromXml(), false);
        m.z(getCardViewFromXml(), false);
        m.z(getGalleryViewFromXml(), false);
        m.z(getCalendarViewFromXml(), true);
        return;
    }

    public BitableNativeViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213236g = new BitableViewDataProvider();
        this.f213238i = new HashSet();
        int r102 = 0;
        this.f213239j = new AtomicBoolean(false);
        this.f213240k = MobileViewContainerType.Main;
        LayoutInflater.from(r100).inflate(R.layout.bitable_native_view_container_layout, this, true);
        CardViewContainer r103 = getCardViewFromXml();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        GalleryViewContainer r104 = getGalleryViewFromXml();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        GridViewContainer r105 = getGridViewFromXml();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list.BaseListViewContainer<kotlin.Any>");
        BaseListViewContainer[] r106 = {r103, r104, r105};
    L3:
        if (r102 >= 3) goto L5;
        r106[r102].g(this);
        r102 = r102 + 1;
        goto L3
    }

    public final void c(ViewHolder r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, "isUpdateSceneNotReady");
        r100.f210215b.setTouchDownListener(new BitableNativeViewContainer$init$1(this));
        this.f213237h = r101;
    }

    public final void g(CardViewData r110, gv4.a r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "handler");
        if (m(r110.getEmpty(), r111, 0) == true) goto L6;
        CardViewContainer r100 = getCardViewFromXml();
        r100.getClass();
        boolean r112 = r100.n(r110.getTableId(), r110.getViewId());
        r100.m(r110.getViewId(), r110.getTableId(), r110.getGroupUniqueKey(), r110.isPartial(), r110.getUpdateStrategy(), r112, r111);
        CardViewContainer.c r101 = r100.getUpdateStrategy();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "data");
        r101.g(r110.getUpdateStrategy(), r110.getSetting(), r110, r112, r101.f213263c.getViewContext().e());
        b(getCardViewFromXml());
        return;
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewContainer$e] */
    public final void h(GalleryViewData r110, gv4.a r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "handler");
        if (m(r110.getEmpty(), r111, 0) == true) goto L13;
        GalleryViewContainer r100 = getGalleryViewFromXml();
        r100.getClass();
        boolean r112 = r100.n(r110.getTableId(), r110.getViewId());
        r100.m(r110.getViewId(), r110.getTableId(), r110.getGroupUniqueKey(), r110.isPartial(), r110.getUpdateStrategy(), r112, r111);
        GalleryViewContainer.d r101 = r100.getUpdateStrategy();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "data");
        r101.g(r110.getUpdateStrategy(), r110.getSetting(), r110, r112, r101.f213442c.getViewContext().e());
        GallerySetting r113 = r100.getViewContext().h().d();
        if (y0.d(r113.getBackground()) == false) goto L7;
        r100.setBackgroundResource(R.drawable.bitable_card_view_bg_shape);
    L9:
        if (r113.getHomepageBoost() == false) goto L11;
        r100.f213441o.setVerticalScrollBarEnabled(false);
    L11:
        b(getGalleryViewFromXml());
        return;
    L7:
        r100.setBackgroundColor(ColorUtils.h(r113.getBackground()));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewContainer$e] */
    public final void i(GridViewData r110, gv4.a r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "handler");
        EmptyData r100 = r110.getEmpty();
        int r101 = 0;
        if (r100 == null) goto L7;
        Icon r102 = r100.getIcon();
        if (r102 == null) goto L7;
        boolean r103 = Intrinsics.areEqual(r102.getLoading(), Boolean.TRUE);
    L8:
        if (r103 == true) goto L11;
        Math.ceil(getContext().getResources().getDimension(R.dimen.bitable_native_view_divider_size));
        r101 = ht4.a.f487119b;
    L11:
        m(r110.getEmpty(), r111, r101);
        GridViewContainer r104 = getGridViewFromXml();
        r104.getClass();
        boolean r105 = r104.n(r110.getTableId(), r110.getViewId());
        r104.m(r110.getViewId(), r110.getTableId(), r110.getGroupUniqueKey(), r110.isPartial(), r110.getUpdateStrategy(), r105, r111);
        GridSetting r112 = r110.getSetting();
        if (r112 == null) goto L14;
        r104.getRecyclerView().getRowScrollManager().c(r104.getViewContext().getRecyclerView().getMeasuredWidth(), r112, r104.getViewContext().h().getScrollX());
    L14:
        GridViewContainer.d r106 = r104.getUpdateStrategy();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r110, "data");
        r106.k().q1(r110.getFieldHeaderData());
        r106.g(r110.getUpdateStrategy(), r110.getSetting(), r110, r105, r106.f213545c.getViewContext().e());
        GridFieldHeaderData r113 = r110.getFieldHeaderData();
        if (r113 == null) goto L17;
        r104.f213541o.f210816b.g(r113, r104.getViewContext().e());
    L17:
        b(getGridViewFromXml());
        return;
    L7:
        r103 = false;
        goto L8
    }

    public final boolean m(EmptyData r100, gv4.a r101, int r102) {
        if (r100 == null) goto L11;
        getEmptyViewFromXml().setVisibility(0);
        getEmptyViewFromXml().a(r100, r101);
        m.u(getEmptyViewFromXml(), r102, false);
        b.c("showEmptyView>>" + r100.getText(), false);
        if (this.f213239j.compareAndSet(false, true) == false) goto L10;
        String r103 = this.f213235f;
        if (r103 == null) goto L9;
        tu4.b.g(r103, "BITABLE_NATIVE_FIRST_SCREEN_SUCCESS", System.currentTimeMillis());
        long r104 = System.currentTimeMillis();
        Lazy r105 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
        Intrinsics.checkNotNullParameter(r103, "traceId");
        tu4.b.l(r103, r104, null);
        goto L10
    L9:
        tt5.a.d("NATIVE_VIEW_TAG", "tryShowEmpty>>> error path. documentId is null");
    L10:
        return true;
    L11:
        getEmptyViewFromXml().setVisibility(8);
        return false;
    }

    public final void f(Activity r100, d r101, tb5.m r110, Map<String, ? extends i<String>> r111) {
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r100 == null) goto L27;
        Boolean r102 = getCalendarViewFromXml().f213252b;
        Boolean r103 = Boolean.FALSE;
        if (Intrinsics.areEqual(r102, r103) == true) goto L25;
        Boolean r104 = null;
        boolean r105 = false;
        m(null, null, 0);
        CalendarViewContainer r106 = getCalendarViewFromXml();
        Function1<String, Unit> r107 = new BitableNativeViewContainer$setData$1$1(this);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r106.f213251a == true) goto L18;
        r106.f213257g = r107;
        if (r111 == null) goto L11;
        r106.f213258h.putAll(r111);
    L11:
        fo4.a r112 = new fo4.a(r100, 2);
        zs4.b r108 = new zs4.b(r106);
        Intrinsics.checkNotNullParameter(r108, "lynxViewClient");
        r112.f478120e = r108;
        zs4.c r109 = new zs4.c(r106);
        Intrinsics.checkNotNullParameter(r109, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r112.f478119d = r109;
        BitableLynxViewHolder r113 = eo4.a.a(r112);
        View r114 = r113.c(true);
        if (r114 == null) goto L14;
        r106.addView(r114, new ViewGroup.LayoutParams(-1, -1));
        r113.h(new CalendarViewContainer.b(new WeakReference(r106)));
        r114.setBackgroundResource(R.color.bg_body);
    L17:
        r106.f213253c = r113;
        r106.f213251a = true;
        goto L18
    L14:
        r106.f213252b = r103;
        Function1<? super String, Unit> r115 = r106.f213257g;
        if (r115 == null) goto L17;
        r115.invoke("onLoadFailed: getView is null");
    L18:
        CalendarViewContainer r116 = getCalendarViewFromXml();
        r116.getClass();
        StringBuilder r117 = new StringBuilder("setData: data=");
        String r118 = r101.f573484a;
        if (r118 != null) goto L21;
    L24:
        r117.append(r104);
        tt5.a.h("CalendarViewContainer", r117.toString());
        r116.f213254d = r101;
        r116.f213255e = r110;
        r116.a();
        r116.b();
        b(getCalendarViewFromXml());
        return;
    L21:
        if (r118.length() <= 0) goto L23;
        r105 = true;
    L23:
        r104 = Boolean.valueOf(r105);
        goto L24
    L25:
        l();
        return;
    }

    public static /* synthetic */ void k(BitableNativeViewContainer r100, Activity r101, BitableNativeViewData r102, gv4.a r103, tb5.m r110) {
        r100.j(r101, r102, r103, r110, false);
    }

    public final void j(Activity r100, BitableNativeViewData r101, gv4.a r102, tb5.m r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "handler");
        MobileViewContainerType r105 = r101.getContainerType();
        if (r105 != null) goto L5;
        r105 = this.f213240k;
    L5:
        this.f213240k = r105;
        SubViewType r106 = r101.getSubViewType();
        if (r106 == null) goto L37;
        int r107 = a.f213243a[r106.ordinal()];
        GridViewData r108 = null;
        GalleryViewData r109 = null;
        CardViewData r110 = null;
        if (r107 != 1) goto L10;
        BaseViewData<?, ?> r111 = r101.getData();
        if ((r111 instanceof GridViewData) == false) goto L32;
        r108 = (GridViewData) r111;
    L32:
        if (r108 == null) goto L34;
        i(r108, r102);
    L34:
        if (r104 == false) goto L38;
        setVisibleNativeView(r106);
        return;
    L38:
        return;
    L10:
        if (r107 != 2) goto L12;
        BaseViewData<?, ?> r112 = r101.getData();
        if ((r112 instanceof CardViewData) == false) goto L27;
        r110 = (CardViewData) r112;
    L27:
        if (r110 == null) goto L34;
        g(r110, r102);
        goto L34
    L12:
        if (r107 != 3) goto L14;
        BaseViewData<?, ?> r113 = r101.getData();
        if ((r113 instanceof GalleryViewData) == false) goto L22;
        r109 = (GalleryViewData) r113;
    L22:
        if (r109 == null) goto L34;
        h(r109, r102);
        goto L34
    L14:
        if (r107 != 4) goto L34;
        String r114 = r101.getDataJson();
        if (r114 == null) goto L34;
        f(r100, new d(r114), r103, null);
        goto L34
    }
}
