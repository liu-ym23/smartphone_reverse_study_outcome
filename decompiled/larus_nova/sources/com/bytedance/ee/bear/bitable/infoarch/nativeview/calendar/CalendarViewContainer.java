package com.bytedance.ee.bear.bitable.infoarch.nativeview.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import com.bytedance.ee.bear.bitable.statistic.c;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import zs4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u000267B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010&\u001a\u00020\fJY\u0010'\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020(2'\b\u0002\u0010\u0017\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00182\u001e\b\u0002\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190 \u0018\u00010)H\u0007J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020\u001dH\u0014J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0014J\u001a\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u00122\b\u00102\u001a\u0004\u0018\u00010\u0014J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u001dH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0017\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarViewContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isInit", "", "isLoadSuccess", "Ljava/lang/Boolean;", "lynxView", "Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;", "viewData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarViewData;", "actionHandler", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "contextMenuHandler", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/calendar/CalendarContextMenuHandler;", "onLoadFail", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msg", "", "interceptors", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "fpsTrace", "Lcom/bytedance/ee/bear/bitable/statistic/IBitableFpsTrace;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLoadFailed", "init", "Landroid/app/Activity;", "", "initView", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "setData", "data", "callback", "notifySetDataChanged", "startFps", "stopFps", "SetCalendarViewDataCallback", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f213251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f213252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BitableLynxViewHolder f213253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f213254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f213255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zs4.a f213256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super String, Unit> f213257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, i<String>> f213258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f213259i;

    public static final class a {
    }

    public static final class b extends XCoreBridgeMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<CalendarViewContainer> f213260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f213261b;

        @Override // com.bytedance.ies.xbridge.XBridgeMethod
        public final String getName() {
            return this.f213261b;
        }

        public b(WeakReference<CalendarViewContainer> r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f213260a = r100;
            this.f213261b = "biz.bitable.setCalendarViewData.callback";
        }

        @Override // com.bytedance.ies.xbridge.XBridgeMethod
        public final void handle(XReadableMap r100, XBridgeMethod.Callback r110, XBridgePlatformType r111) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r110, "callback");
            Intrinsics.checkNotNullParameter(r111, "type");
            CalendarViewContainer r101 = this.f213260a.get();
            if (r101 != null) goto L6;
            return;
        L6:
            if (((Context) provideContext(Context.class)) != null) goto L8;
            return;
        L8:
            String r102 = r100.getString("action");
            String r103 = r100.getString("data");
            tt5.a.h("CalendarViewContainer", "setCalendarViewDataCallback: data= " + r103);
            boolean r104 = true;
            if (r102.length() <= 0) goto L11;
            boolean r105 = true;
        L12:
            if (r105 == true) goto L14;
        L26:
            XCoreBridgeMethod.onFailure$default(this, r110, -3, "data is empty", null, 8, null);
            return;
        L14:
            if (r103.length() > 0) goto L17;
            r104 = false;
        L17:
            if (r104 == false) goto L26;
            i<String> r106 = r101.f213258h.get(r102);
            if (r106 == null) goto L21;
            r106.handle(r103, r101.f213255e);
        L24:
            XCoreBridgeMethod.onSuccess$default(this, r110, new LinkedHashMap(), null, 4, null);
            return;
        L21:
            m r107 = r101.f213255e;
            if (r107 == null) goto L24;
            r107.onCallBack(r103);
            goto L24
        L11:
            r105 = false;
            goto L12
        }
    }

    static {
    }

    public CalendarViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public CalendarViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void a() {
        BitableLynxViewHolder r100 = this.f213253c;
        d r101 = this.f213254d;
        if (r101 == null) goto L5;
        String r102 = r101.f573484a;
    L6:
        if (r100 != null) goto L8;
    L19:
        tt5.a.k("CalendarViewContainer", "notifySetDataChanged failed!");
        return;
    L8:
        if (Intrinsics.areEqual(this.f213252b, Boolean.TRUE) == false) goto L19;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L19;
        r100.k("biz.bitable.setCalendarViewData", CollectionsKt.listOf(r102));
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public final void b() {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.native_calendar_fps_enable") == true) goto L6;
        return;
    L6:
        if (this.f213254d != null) goto L9;
        return;
    L9:
        if (this.f213259i != null) goto L12;
        tt5.a.h("CalendarViewContainer", "startFps");
        c r100 = ((com.bytedance.ee.bear.bitable.statistic.m) org.koin.java.a.c(com.bytedance.ee.bear.bitable.statistic.m.class, null, null, 6)).createFpsTrace(null);
        r100.d(new com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.c(SubViewType.LynxCalendar.getValue()));
        r100.a(30000);
        this.f213259i = r100;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r100 = this.f213259i;
        if (r100 == null) goto L5;
        tt5.a.h("CalendarViewContainer", "stopFps");
        r100.g();
    L5:
        this.f213259i = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L13;
        zs4.a r102 = this.f213256f;
        ActionMode r103 = r102.f573477b;
        if (r103 == null) goto L11;
        r103.finish();
    L11:
        r102.f573477b = null;
    L13:
        return super.onInterceptTouchEvent(r100);
    L4:
        if (r100.getAction() != 0) goto L6;
        r101 = true;
        goto L7
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        b();
        return;
    L5:
        c r102 = this.f213259i;
        if (r102 == null) goto L8;
        tt5.a.h("CalendarViewContainer", "stopFps");
        r102.g();
    L8:
        this.f213259i = null;
    }

    public CalendarViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        zs4.a r104 = new zs4.a(this);
        this.f213256f = r104;
        this.f213258h = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("LongPressSchedule", r104)});
    }
}
