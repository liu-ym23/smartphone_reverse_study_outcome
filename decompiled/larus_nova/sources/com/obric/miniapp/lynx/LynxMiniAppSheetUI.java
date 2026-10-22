package com.obric.miniapp.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0007J\u0012\u0010$\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010%\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0007J\u0010\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0007J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0007J\u0014\u0010*\u001a\u00020\"2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,H\u0016J\b\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\"H\u0002J\u0018\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000bH\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\n\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0002H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u000bH\u0002J\u001e\u0010>\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00022\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0016\u0010@\u001a\u00020\u000b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0018\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0002H\u0002J\u0010\u0010C\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0002H\u0002J\u0010\u0010D\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0002H\u0002J \u0010E\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0019H\u0002J\u0010\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020IH\u0002J\u000f\u0010J\u001a\u0004\u0018\u00010K*\u00020 H\u0082\u0010J&\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u001c2\b\b\u0002\u0010O\u001a\u00020\u0015H\u0002J\u0014\u0010P\u001a\u00020\u001d*\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppSheetUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/obric/miniapp/lynx/MiniAppSheetContentHostView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "contentHost", DocumentType.SHEET_NAME, "Lcom/obric/oui/sheet/v2/OSheet;", "title", "", "closeOnMask", "", "closeOnBack", "visible", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "originalParent", "Landroid/view/ViewGroup;", "originalIndex", "", "originalLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "sheetBodyContainer", "Lcom/obric/miniapp/lynx/SheetBodyContainerView;", "dialogMaxBodyHeightPx", "childLayoutSnapshots", "", "Lcom/obric/miniapp/lynx/SheetChildLayoutSnapshot;", "emitShowOnAnimEnd", "createView", "Landroid/content/Context;", "setVisible", "", "value", com.alipay.sdk.m.x.d.f25925o, "setWidth", "setCloseOnMask", "setCloseOnBack", "setOptions", "options", "insertView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/lynx/tasm/behavior/ui/LynxUI;", MapMonitorConst.EVENT_DESTROY, "showIfPossible", "dismissSheet", "emitCancel", "emitDismiss", "sendSimpleEvent", "type", "resolveSheetTouchDispatcher", "Lcom/lynx/tasm/behavior/TouchEventDispatcher;", "resolveTouchBound", "Landroid/graphics/Rect;", "detachHostFromOriginalParent", "host", "restoreHostToOriginalParent", "clearOriginalParentSnapshot", "refreshSheetContentLayout", "stage", "resolveUiContentHeight", "snapshots", "buildSnapshotSummary", "adaptChildLayoutsToSheetWidth", "targetWidth", "restoreChildLayouts", "relayoutChildren", "logHostLayoutState", "bodyContainer", "resolveMaxBodyHeight", "dialog", "Landroid/app/Dialog;", "findActivity", "Landroid/app/Activity;", "snapshotUiSubtree", "nodes", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", ToygerFaceAlgorithmConfig.DEPTH, "toSnapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppSheetUI extends UIGroup<a6> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f397835p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a6 f397836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.miniapp.utils.b1 f397837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f397838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f397839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f397840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f397841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f397842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f397843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f397844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f397845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup.LayoutParams f397846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f6 f397847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f397848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<g6> f397849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f397850o;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            g6 r102 = (g6) r101;
            int r103 = r102.f398117d + r102.f398119f;
            Rect r104 = r102.f398132s;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r104.bottom;
        L6:
            Integer r107 = Integer.valueOf(Math.max(r103, r106));
            g6 r108 = (g6) r100;
            int r109 = r108.f398117d + r108.f398119f;
            Rect r110 = r108.f398132s;
            if (r110 == null) goto L10;
            r105 = r110.bottom;
        L10:
            return ComparisonsKt.compareValues(r107, Integer.valueOf(Math.max(r109, r105)));
        L5:
            r106 = 0;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppSheetUI$createView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<com.lynx.tasm.behavior.b1> {
        public AnonymousClass1(Object r100) {
            super(0, r100, LynxMiniAppSheetUI.class, "resolveSheetTouchDispatcher", "resolveSheetTouchDispatcher()Lcom/lynx/tasm/behavior/TouchEventDispatcher;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.lynx.tasm.behavior.b1 invoke() {
            LynxMiniAppSheetUI r100 = (LynxMiniAppSheetUI) this.receiver;
            int r101 = LynxMiniAppSheetUI.f397835p;
            LynxContext r102 = r100.getLynxContext();
            if (r102 != null) goto L5;
            return null;
        L5:
            r102.EnsureEventDispatcher();
            return r102.getTouchEventDispatcher();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ com.lynx.tasm.behavior.b1 invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppSheetUI$createView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Rect> {
        public AnonymousClass3(Object r100) {
            super(0, r100, LynxMiniAppSheetUI.class, "resolveTouchBound", "resolveTouchBound()Landroid/graphics/Rect;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Rect invoke() {
            LynxMiniAppSheetUI r100 = (LynxMiniAppSheetUI) this.receiver;
            int r101 = LynxMiniAppSheetUI.f397835p;
            LynxBaseUI r102 = (LynxBaseUI) CollectionsKt.firstOrNull(r100.getChildren());
            if (r102 == null) goto L7;
            Rect r103 = r102.getBound();
            if (r103 == null) goto L7;
            return r103;
        L7:
            return r100.getBound();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Rect invoke() {
            return invoke();
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        O(false);
        a6 r100 = this.f397836a;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        this.f397836a = null;
        super.destroy();
    }

    public LynxMiniAppSheetUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f397839d = true;
        this.f397840e = true;
        this.f397842g = true;
        this.f397843h = true;
        this.f397845j = -1;
        this.f397849n = CollectionsKt.emptyList();
    }

    public static void M(com.obric.miniapp.utils.b1 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final String N(List<g6> r110) {
        return CollectionsKt.joinToString$default(CollectionsKt.take(CollectionsKt.sortedWith(r110, new b()), 6), " | ", null, null, 0, null, new d1(), 30, null);
    }

    public final void O(boolean r100) {
        com.obric.miniapp.utils.b1 r101 = this.f397837b;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f397842g = false;
        this.f397843h = r100;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        M(r101);     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        FLogger.f375446a.e("LynxMiniAppSheetUI", "dismiss sheet failed", r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void P(String r110) {
        a6 r100 = this.f397836a;
        if (r100 != null) goto L5;
        return;
    L5:
        f6 r101 = this.f397847l;
        if (r101 != null) goto L8;
        return;
    L8:
        Iterator<T> r102 = getChildren().iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        LynxBaseUI r103 = (LynxBaseUI) r102.next();
        r103.measure();
        r103.layout();
        goto L10
    L12:
        i1.a(r100);
        r100.invalidate();
        int r104 = 0;
        List<g6> r105 = R(getChildren(), 0);
        Iterator r106 = ((ArrayList) r105).iterator();
        if (r106.hasNext() == true) goto L15;
        Integer r107 = null;
    L30:
        if (r107 == null) goto L32;
        r104 = RangesKt.coerceAtLeast((r107.intValue() + r100.getPaddingTop()) + r100.getPaddingBottom(), 0);
    L32:
        r100.setContentHeightOverridePx(r104);
        if (r104 <= 0) goto L39;
        int r108 = this.f397848m;
        if (r108 <= 0) goto L37;
        int r109 = RangesKt.coerceAtMost(r104, r108);
    L38:
        r100.setBodyMaxHeightPx(r109);
        goto L39
    L37:
        r109 = r104;
    L39:
        int r111 = this.f397848m;
        if (r101.f398086a == r111) goto L43;
        r101.f398086a = r111;
        r101.requestLayout();
    L43:
        i1.a(r100);
        r101.requestLayout();
        r100.requestLayout();
        FLogger.f375446a.i("LynxMiniAppSheetUI", r110 + " refreshSheetContentLayout contentHeight=" + r104 + ", dialogMaxBodyHeightPx=" + this.f397848m + ", hostChildren=" + r100.getChildCount() + ", uiChildren=" + getChildren().size() + ", snapshotSummary=" + N(r105));
        r100.getChildCount();
        getChildren().size();
        N(r105);
        return;
    L15:
        g6 r112 = (g6) r106.next();
        int r113 = r112.f398117d + r112.f398119f;
        Rect r114 = r112.f398132s;
        if (r114 == null) goto L18;
        int r115 = r114.bottom;
    L19:
        Integer r116 = Integer.valueOf(Math.max(r113, r115));
    L21:
        if (r106.hasNext() == false) goto L29;
        g6 r117 = (g6) r106.next();
        int r118 = r117.f398117d + r117.f398119f;
        Rect r119 = r117.f398132s;
        if (r119 == null) goto L25;
        int r120 = r119.bottom;
    L26:
        Integer r121 = Integer.valueOf(Math.max(r118, r120));
        if (r116.compareTo(r121) >= 0) goto L21;
        r116 = r121;
        goto L21
    L25:
        r120 = 0;
        goto L26
    L29:
        r107 = r116;
        goto L30
    L18:
        r115 = 0;
        goto L19
    }

    public final void Q(String r100) {
        LynxContext r101 = getLynxContext();
        if (r101 == null) goto L9;
        EventEmitter r102 = r101.getEventEmitter();
        if (r102 == null) goto L10;
        r102.sendCustomEvent(new m7a.a(getSign(), r100));
        return;
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.miniapp.lynx.c1] */
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        a6 r101 = new a6(r100, new AnonymousClass1(this), new c1(this), new AnonymousClass3(this));
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setClickable(false);
        r101.setFocusable(false);
        r101.setFocusableInTouchMode(false);
        r101.setImportantForAccessibility(2);
        r101.setMinimumWidth(0);
        r101.setMinimumHeight(0);
        r101.setVisibility(8);
        this.f397836a = r101;
        return r101;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void insertView(LynxUI<?> r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.insertView(r100);
        a6 r101 = this.f397836a;
        if (r101 != null) goto L5;
        return;
    L5:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("insertView child=");
        r103.append(r100.getClass().getSimpleName());
        r103.append(", hostChildren=");
        r103.append(r101.getChildCount());
        r103.append(", hostLp=");
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        Integer r105 = null;
        if (r104 == null) goto L8;
        Integer r106 = Integer.valueOf(r104.width);
    L9:
        r103.append(r106);
        r103.append(Permission.EXECUTE);
        ViewGroup.LayoutParams r107 = r101.getLayoutParams();
        if (r107 == null) goto L12;
        r105 = Integer.valueOf(r107.height);
    L12:
        r103.append(r105);
        r102.i("LynxMiniAppSheetUI", r103.toString());
        r101.getChildCount();
        r101.getLayoutParams();
        r101.getLayoutParams();
        if (this.f397841f == true) goto L15;
        return;
    L15:
        if (this.f397837b == null) goto L19;
        r101.post(new z0(this));
        return;
    L19:
        return;
    L8:
        r106 = null;
        goto L9
    }

    @LynxProp(name = "closeOnBack")
    public final void setCloseOnBack(boolean r100) {
        this.f397840e = r100;
    }

    @LynxProp(name = "closeOnMask")
    public final void setCloseOnMask(boolean r100) {
        this.f397839d = r100;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r100) {
        if (r100 == null) goto L39;
        boolean r101 = true;
        String r102 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L40;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = null;
    L15:
        JSONObject r105 = (JSONObject) r104;
        if (r105 != null) goto L19;
        return;
    L19:
        if (r105.has("title") == false) goto L28;
        String r106 = StringsKt.trim(r105.optString("title")).toString();
        if (r106.length() > 0) goto L24;
        r101 = false;
    L24:
        if (r101 == false) goto L26;
        r102 = r106;
    L26:
        this.f397838c = r102;
    L28:
        if (r105.has("width") == false) goto L31;
        setWidth(r105.optString("width"));
    L31:
        if (r105.has("closeOnMask") == false) goto L34;
        this.f397839d = r105.optBoolean("closeOnMask", this.f397839d);
    L34:
        if (r105.has("closeOnBack") == false) goto L41;
        this.f397840e = r105.optBoolean("closeOnBack", this.f397840e);
        return;
    L41:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L40:
        return;
    }

    @LynxProp(name = "title")
    public final void setTitle(String r100) {
        String r101 = null;
        if (r100 == null) goto L12;
        String r102 = StringsKt.trim(r100).toString();
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r101 = r102;
        goto L12
    L9:
        r103 = false;
    L12:
        this.f397838c = r101;
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r110) {
        this.f397841f = r110;
        if (r110 == true) goto L5;
        O(true);
        return;
    L5:
        if (this.f397837b != null) goto L98;
        a6 r100 = this.f397836a;
        if (r100 == null) goto L94;
        Context r101 = r100.getContext();
        if (r101 == null) goto L99;
        final a6 r102 = this.f397836a;
        if (r102 == null) goto L100;
        Context r103 = r101;
    L17:
        if ((r103 instanceof Activity) == true) goto L18;
        if ((r103 instanceof ContextWrapper) == false) goto L24;
        r103 = ((ContextWrapper) r103).getBaseContext();
        if (r103 != null) goto L17;
    L24:
        Activity r104 = null;
    L26:
        if (r104 != null) goto L28;
    L82:
        FLogger.f375446a.w("LynxMiniAppSheetUI", "skip showing sheet because activity is unavailable");
        return;
    L28:
        if (r104.isFinishing() == true) goto L82;
        if (r104.isDestroyed() == true) goto L82;
        ViewParent r105 = r102.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L35;
        ViewGroup r106 = (ViewGroup) r105;
    L36:
        if (r106 == null) goto L39;
        this.f397844i = r106;
        this.f397845j = r106.indexOfChild(r102);
        this.f397846k = r102.getLayoutParams();
        r106.removeView(r102);
    L39:
        i1.a(r102);
        r102.setBodyMaxHeightPx(0);
        r102.setContentHeightOverridePx(0);
        r102.setVisibility(0);
        f6 r107 = new f6(r101);
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullParameter(r102, "host");
        if (r102.getParent() == r107) goto L48;
        ViewParent r108 = r102.getParent();
        if ((r108 instanceof ViewGroup) == false) goto L44;
        ViewGroup r109 = (ViewGroup) r108;
    L45:
        if (r109 == null) goto L47;
        r109.removeView(r102);
    L47:
        r107.addView(r102, new FrameLayout.LayoutParams(-1, -2));
        goto L48
    L44:
        r109 = null;
    L48:
        i1.a(r102);
        this.f397847l = r107;
        Window r111 = r104.getWindow();
        if (r111 == null) goto L57;
        View r112 = r111.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L55;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r113 = ThreadMethodProxy.currentThread();
        if (r113 == com.larus.home.impl.utils.c.f346341a) goto L55;
        com.larus.home.impl.utils.c.a(r113, "getDecorView");
    L55:
        if (r112 == null) goto L57;
        int r114 = r112.getHeight();
    L58:
        com.obric.miniapp.utils.b1 r115 = com.obric.miniapp.utils.c1.a(r101, r114);
        OSheetBase.DefaultImpls.q(r115, OSheet.HeightMode.WRAP_HEIGHT);
        String r116 = this.f397838c;
        if (r116 != null) goto L61;
    L64:
        boolean r117 = true;
    L66:
        if ((!r117) == false) goto L68;
        OSheetBase.DefaultImpls.o(r115, OSheet.Header.ONLY_TITLE, null, this.f397838c, null, true, null, null, 16134);
    L68:
        OSheetBase.DefaultImpls.j(r115, r107);
        r115.setCancelable(this.f397840e);
        r115.setCanceledOnTouchOutside(this.f397839d);
        r115.f402893t = new h1(this, r107, r102);
        r115.setOnCancelListener(new a1(this));
        r115.setOnDismissListener(new b1(this, r102));
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L77
        this.f397850o = true;     // Catch: Throwable -> L77
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L88;
        DialogLancet.handleBlockedDialogShow(r115);     // Catch: Throwable -> L77
    L75:
        this.f397837b = r115;     // Catch: Throwable -> L77
        this.f397842g = true;     // Catch: Throwable -> L77
        this.f397843h = true;     // Catch: Throwable -> L77
        Object r119 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L77
    L79:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L95;
        FLogger.f375446a.e("LynxMiniAppSheetUI", "show sheet failed", r120);
        this.f397850o = false;
        this.f397837b = null;
        return;
    L95:
        return;
    L88:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L85 Throwable -> L77
    L74:
        DialogLancet.beforeDialogShow(r115);     // Catch: Throwable -> L77
        r115.show();     // Catch: Throwable -> L77
        DialogLancet.afterDialogShow(r115);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L79
    L61:
        if (StringsKt.isBlank(r116) == true) goto L64;
        r117 = false;
    L57:
        r114 = 0;
        goto L58
    L35:
        r106 = null;
        goto L36
    L18:
        r104 = (Activity) r103;
        goto L26
    L100:
        return;
    L99:
        return;
    L94:
        return;
    }

    @LynxProp(name = "width")
    public final void setWidth(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        if (StringsKt.equals(r100, "board", true) == true) goto L15;
        FLogger.f375446a.i("LynxMiniAppSheetUI", "OSheet ignores width=" + r100 + " and always uses drawer layout");
        return;
    L15:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final List<g6> R(List<? extends LynxBaseUI> r210, int r211) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = r210.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        LynxBaseUI r102 = (LynxBaseUI) r101.next();
        int r103 = r102.getOriginLeft();
        int r104 = r102.getOriginTop();
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        int r110 = r102.getPaddingLeft();
        int r111 = r102.getPaddingTop();
        int r112 = r102.getPaddingRight();
        int r113 = r102.getPaddingBottom();
        int r114 = r102.getMarginLeft();
        int r115 = r102.getMarginTop();
        int r116 = r102.getMarginRight();
        int r117 = r102.getMarginBottom();
        int r118 = r102.getBorderLeftWidth();
        int r119 = r102.getBorderTopWidth();
        int r212 = r102.getBorderRightWidth();
        int r213 = r102.getBorderBottomWidth();
        Rect r107 = r102.getBound();
        if (r107 == null) goto L8;
        Rect r214 = new Rect(r107);
    L9:
        Iterator r215 = r101;
        r100.add(new g6(r102, r211, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214));
        List<LynxBaseUI> r108 = r102.getChildren();
        Intrinsics.checkNotNull(r108);
        if ((!r108.isEmpty()) == false) goto L13;
        r100.addAll(R(r108, r211 + 1));
    L13:
        r101 = r215;
        goto L4
    L8:
        r214 = null;
        goto L9
    L15:
        return r100;
    }
}
