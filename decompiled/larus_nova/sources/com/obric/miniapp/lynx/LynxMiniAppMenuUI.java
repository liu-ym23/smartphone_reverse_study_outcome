package com.obric.miniapp.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.facebook.keyframes.model.KFFeature;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.MaterialToken;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0007J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010$\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010%\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010&\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010'\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0014\u0010(\u001a\u00020\u001f2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH\u0002J\u0012\u00101\u001a\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u001fH\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\"\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u00108\u001a\u00020\tH\u0002J\u001f\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\tH\u0002J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00182\u0006\u00108\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\tH\u0002J&\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00182\b\b\u0002\u0010J\u001a\u00020?H\u0002J&\u0010K\u001a\b\u0012\u0004\u0012\u00020D0\u00182\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00182\b\b\u0002\u0010J\u001a\u00020?H\u0002J\u001c\u0010L\u001a\u00020D*\u00020I2\u0006\u0010J\u001a\u00020?2\u0006\u0010M\u001a\u00020\u000fH\u0002J\u0014\u0010N\u001a\u00020\u0019*\u00020I2\u0006\u0010J\u001a\u00020?H\u0002J\u0012\u0010O\u001a\u00020\u001f2\b\u0010P\u001a\u0004\u0018\u00010#H\u0002J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\n\u0010S\u001a\u0004\u0018\u00010TH\u0002J\u001c\u0010U\u001a\u0004\u0018\u00010:2\b\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u001dH\u0002J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020#H\u0002J\u000f\u0010X\u001a\u0004\u0018\u00010=*\u00020\u001dH\u0082\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppMenuUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/obric/miniapp/lynx/MiniAppMenuAnchorView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "anchorView", "contentHost", "Lcom/obric/miniapp/lynx/MiniAppMenuContentHostView;", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "optionsJson", "Lorg/json/JSONObject;", "visible", "", "pendingShow", "showInProgress", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "menuWidthDp", "", "Ljava/lang/Float;", "childLayoutSnapshots", "", "Lcom/obric/miniapp/lynx/MenuChildLayoutSnapshot;", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "setVisible", "", "value", "setOptions", "options", "", "setPlacement", "setPosition", "setGravity", "setMenuWidth", "insertView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/lynx/tasm/behavior/ui/LynxUI;", MapMonitorConst.EVENT_DESTROY, "scheduleShow", "showIfPossible", "dismissMenu", "emitCancel", "emitDismiss", "cleanupAfterDismiss", "emitEvents", "moveContentChildrenToHost", "restoreContentChildrenToAnchor", "refreshVisibleMenu", "createPopoverContentView", "Landroid/view/View;", "host", "backgroundAppearance", "Lcom/obric/miniapp/lynx/MiniAppMenuBackgroundAppearance;", "measurePopupContent", "activity", "Landroid/app/Activity;", "resolveMenuWidthPx", "", "maxWidth", "(Landroid/content/Context;I)Ljava/lang/Integer;", "relayoutChildren", "collectMeasuredViewSnapshots", "Lcom/obric/miniapp/lynx/MenuContentSnapshot;", "Landroid/view/ViewGroup;", "restoreChildLayouts", "snapshotUiLayoutSubtree", "nodes", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", ToygerFaceAlgorithmConfig.DEPTH, "snapshotUiSubtree", "toMenuContentSnapshot", "isLeaf", "toLayoutSnapshot", "updatePlacement", "rawValue", "resolveMenuTouchDispatcher", "Lcom/lynx/tasm/behavior/TouchEventDispatcher;", "resolveTouchBound", "Landroid/graphics/Rect;", "resolveMenuBackgroundAppearance", "sendSimpleEvent", "type", "findActivity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppMenuUI extends UIGroup<w5> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f397822m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w5 f397823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z5 f397824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.popover.v2.c f397825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f397826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f397827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f397828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f397829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f397830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f397831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Float f397832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<j4> f397833k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u0 f397834l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppMenuUI$createView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<com.lynx.tasm.behavior.b1> {
        public AnonymousClass1(Object r100) {
            super(0, r100, LynxMiniAppMenuUI.class, "resolveMenuTouchDispatcher", "resolveMenuTouchDispatcher()Lcom/lynx/tasm/behavior/TouchEventDispatcher;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.lynx.tasm.behavior.b1 invoke() {
            LynxMiniAppMenuUI r100 = (LynxMiniAppMenuUI) this.receiver;
            int r101 = LynxMiniAppMenuUI.f397822m;
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

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppMenuUI$createView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Rect> {
        public AnonymousClass3(Object r100) {
            super(0, r100, LynxMiniAppMenuUI.class, "resolveTouchBound", "resolveTouchBound()Landroid/graphics/Rect;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Rect invoke() {
            LynxMiniAppMenuUI r100 = (LynxMiniAppMenuUI) this.receiver;
            int r101 = LynxMiniAppMenuUI.f397822m;
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
        this.f397827e = false;
        this.f397828f = false;
        w5 r100 = this.f397823a;
        if (r100 == null) goto L5;
        r100.removeCallbacks(this.f397834l);
    L5:
        O(false);
        U();
        z5 r101 = this.f397824b;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        this.f397824b = null;
        this.f397833k = CollectionsKt.emptyList();
        this.f397823a = null;
        super.destroy();
    }

    public final void Q() {
        if (this.f397827e == true) goto L5;
        return;
    L5:
        w5 r100 = this.f397823a;
        if (r100 != null) goto L8;
        return;
    L8:
        r100.post(new s0(this));
    }

    public final void U() {
        w5 r100 = this.f397823a;
        if (r100 != null) goto L5;
        return;
    L5:
        z5 r101 = this.f397824b;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getChildCount() <= 0) goto L14;
        View r102 = r101.getChildAt(0);
        if (r102 == null) goto L17;
        r101.removeViewAt(0);
        y0.b(r102);
        r100.addView(r102);
        goto L9
    L17:
        return;
    }

    public final void V() {
        w5 r100 = this.f397823a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isAttachedToWindow() == false) goto L124;
        if (r100.isLaidOut() == false) goto L124;
        if (r100.getWidth() <= 0) goto L124;
        if (r100.getHeight() <= 0) goto L124;
        w5 r101 = this.f397823a;
        if (r101 == null) goto L141;
        z5 r102 = this.f397824b;
        if (r102 != null) goto L21;
        return;
    L21:
        if (this.f397827e == true) goto L23;
        return;
    L23:
        if (this.f397825c == null) goto L25;
        return;
    L25:
        if (this.f397829g == false) goto L28;
        return;
    L28:
        if (r101.isAttachedToWindow() == true) goto L30;
    L121:
        V();
        return;
    L30:
        if (r101.getWidth() <= 0) goto L121;
        if (r101.getHeight() <= 0) goto L121;
        Context r103 = r101.getContext();
    L36:
        if ((r103 instanceof Activity) == true) goto L37;
        if ((r103 instanceof ContextWrapper) == false) goto L43;
        r103 = ((ContextWrapper) r103).getBaseContext();
        if (r103 != null) goto L36;
    L43:
        Activity r104 = null;
    L45:
        if (r104 != null) goto L47;
    L120:
        FLogger.f375446a.w("LynxMiniAppMenuUI", "skip showing menu because activity is unavailable");
        return;
    L47:
        if (r104.isFinishing() == true) goto L120;
        if (r104.isDestroyed() == true) goto L120;
        if (r101.isAttachedToWindow() == true) goto L54;
    L61:
        boolean r105 = false;
    L62:
        if (r105 == true) goto L64;
        FLogger.f375446a.w("LynxMiniAppMenuUI", "skip showing menu because anchor is not visible");
        return;
    L64:
        w5 r106 = this.f397823a;
        if (r106 == null) goto L77;
        z5 r107 = this.f397824b;
        if (r107 == null) goto L77;
    L71:
        if (r106.getChildCount() <= 0) goto L77;
        View r108 = r106.getChildAt(0);
        if (r108 == null) goto L77;
        r106.removeViewAt(0);
        y0.b(r108);
        r107.addView(r108);
    L77:
        if (r102.getChildCount() != 0) goto L79;
        FLogger.f375446a.w("LynxMiniAppMenuUI", "skip showing menu because content host has no children");
        return;
    L79:
        this.f397829g = true;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L114
        y0.b(r102);     // Catch: Throwable -> L114
        r102.setVisibility(0);     // Catch: Throwable -> L114
        T(r102);     // Catch: Throwable -> L114
        R(r102);     // Catch: Throwable -> L114
        P(r104, r102);     // Catch: Throwable -> L114
        x5 r110 = S(this.f397826d, r104);     // Catch: Throwable -> L114
        if (r110 != null) goto L83;
        View r111 = r102;
    L104:
        int r112 = r102.getMeasuredWidth();     // Catch: Throwable -> L114
        int r113 = r102.getMeasuredHeight();     // Catch: Throwable -> L114
        com.obric.oui.popover.v2.c.a r114 = new com.obric.oui.popover.v2.c.a(r104);     // Catch: Throwable -> L114
        Intrinsics.checkNotNullParameter(r111, "view");     // Catch: Throwable -> L114
        r114.f402418f = r111;     // Catch: Throwable -> L114
        r114.f402414b = true;     // Catch: Throwable -> L114
        r114.f402421i = true;     // Catch: Throwable -> L114
        r114.f402422j = true;     // Catch: Throwable -> L114
        r114.f402424l = false;     // Catch: Throwable -> L114
        if (r110 != null) goto L107;
        boolean r115 = true;
    L108:
        r114.f402426n = r115;     // Catch: Throwable -> L114
        v0 r116 = new v0(this);     // Catch: Throwable -> L114
        Intrinsics.checkNotNullParameter(r116, "listener");     // Catch: Throwable -> L114
        r114.f402419g = r116;     // Catch: Throwable -> L114
        com.obric.oui.popover.v2.c r117 = r114.a();     // Catch: Throwable -> L114
        this.f397825c = r117;     // Catch: Throwable -> L114
        FLogger r118 = FLogger.f375446a;     // Catch: Throwable -> L114
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L114
        r119.append("show menu content=");     // Catch: Throwable -> L114
        r119.append(r112);     // Catch: Throwable -> L114
        r119.append(Permission.EXECUTE);     // Catch: Throwable -> L114
        r119.append(r113);     // Catch: Throwable -> L114
        r119.append(" placement=");     // Catch: Throwable -> L114
        r119.append(y0.g(this.f397826d));     // Catch: Throwable -> L114
        r119.append(" nativeBackground=");     // Catch: Throwable -> L114
        if (r110 == null) goto L111;
        boolean r120 = true;
    L112:
        r119.append(r120);     // Catch: Throwable -> L114
        r118.i("LynxMiniAppMenuUI", r119.toString());     // Catch: Throwable -> L114
        int r121 = com.obric.oui.popover.v2.i.f402432a;     // Catch: Throwable -> L114
        com.obric.oui.popover.v2.i.c(r117, r101, y0.g(this.f397826d), y0.c(r104, 8), false, 224);     // Catch: Throwable -> L114
        this.f397830h = true;     // Catch: Throwable -> L114
        this.f397831i = true;     // Catch: Throwable -> L114
        W("show");     // Catch: Throwable -> L114
        Object r122 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L116:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L119;
        FLogger.f375446a.e("LynxMiniAppMenuUI", "show menu failed", r123);
        this.f397825c = null;
        M(false);
    L119:
        this.f397829g = false;
        return;
    L111:
        r120 = false;
        goto L112
    L107:
        r115 = false;
        goto L108
    L83:
        y0.b(r102);     // Catch: Throwable -> L114
        y5 r124 = new y5(r104, r110);     // Catch: Throwable -> L114
        Integer r125 = Integer.valueOf(r102.getMeasuredWidth());     // Catch: Throwable -> L114
        if (r125.intValue() <= 0) goto L86;
        boolean r126 = true;
    L87:
        if (r126 == true) goto L90;
        r125 = null;
    L90:
        int r127 = -2;
        if (r125 == null) goto L93;
        int r128 = r125.intValue();     // Catch: Throwable -> L114
    L94:
        Integer r129 = Integer.valueOf(r102.getMeasuredHeight());     // Catch: Throwable -> L114
        if (r129.intValue() <= 0) goto L97;
        boolean r130 = true;
    L98:
        if (r130 == true) goto L101;
        r129 = null;
    L101:
        if (r129 == null) goto L103;
        r127 = r129.intValue();     // Catch: Throwable -> L114
    L103:
        r124.addView(r102, new FrameLayout.LayoutParams(r128, r127));     // Catch: Throwable -> L114
        r111 = r124;
        goto L104
    L97:
        r130 = false;
        goto L98
    L93:
        r128 = -2;
        goto L94
    L86:
        r126 = false;
    L114:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L116
    L54:
        if (r101.isShown() == false) goto L61;
        if (r101.getWidth() <= 0) goto L61;
        if (r101.getHeight() <= 0) goto L61;
        r105 = r101.getGlobalVisibleRect(new Rect());
        goto L62
    L37:
        r104 = (Activity) r103;
        goto L45
    L141:
        return;
    L124:
        if (this.f397828f == true) goto L144;
        this.f397828f = true;
        r100.post(this.f397834l);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.miniapp.lynx.u0] */
    public LynxMiniAppMenuUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f397830h = true;
        this.f397831i = true;
        this.f397833k = CollectionsKt.emptyList();
        this.f397834l = new u0(this);
    }

    public final void M(boolean r100) {
        z5 r101 = this.f397824b;
        if (r101 == null) goto L5;
        r101.f398349d = null;
        r101.f398350e = null;
        r101.f398351f = 0;
        r101.f398352g = 0;
        r101.setVisibility(8);
        y0.b(r101);
    L5:
        U();
        if (r100 == true) goto L8;
    L13:
        this.f397830h = true;
        this.f397831i = true;
        return;
    L8:
        if (this.f397830h == false) goto L11;
        W("cancel");
    L11:
        if (this.f397831i == false) goto L13;
        W("dismiss");
        goto L13
    }

    public final void O(boolean r100) {
        this.f397828f = false;
        w5 r101 = this.f397823a;
        if (r101 == null) goto L5;
        r101.removeCallbacks(this.f397834l);
    L5:
        com.obric.oui.popover.v2.c r102 = this.f397825c;
        if (r102 == null) goto L8;
        this.f397830h = false;
        this.f397831i = r100;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        PopupWindowLancet.handleDismissBeforeOrigin(r102);     // Catch: Throwable -> L14
        r102.dismiss();     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L23;
        FLogger.f375446a.e("LynxMiniAppMenuUI", "dismiss menu failed", r105);
        this.f397825c = null;
        M(true);
        return;
    L23:
        return;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L8:
        if (this.f397827e == true) goto L22;
        M(false);
        return;
    }

    public final void R(z5 r100) {
        Iterator<T> r101 = getChildren().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        LynxBaseUI r102 = (LynxBaseUI) r101.next();
        r102.measure();
        r102.layout();
        goto L4
    L6:
        y0.i(r100);
        r100.invalidate();
    }

    public final void T(z5 r210) {
        if (this.f397833k.isEmpty() == false) goto L5;
        this.f397833k = X(getChildren(), 0);
    L5:
        Iterator r100 = this.f397833k.iterator();
    L7:
        if (r100.hasNext() == false) goto L13;
        j4 r101 = (j4) r100.next();
        LynxBaseUI r102 = r101.f398157a;
        int r103 = r101.f398159c;
        int r104 = r101.f398160d;
        int r105 = r101.f398161e;
        int r106 = r101.f398162f;
        int r107 = r101.f398163g;
        int r108 = r101.f398164h;
        int r110 = r101.f398165i;
        int r111 = r101.f398166j;
        int r112 = r101.f398167k;
        int r113 = r101.f398168l;
        int r114 = r101.f398169m;
        int r115 = r101.f398170n;
        int r109 = r101.f398171o;
        Iterator r211 = r100;
        int r116 = r101.f398172p;
        int r117 = r101.f398173q;
        int r118 = r101.f398174r;
        Rect r119 = r101.f398175s;
        if (r119 == null) goto L11;
        Rect r120 = new Rect(r119);
    L12:
        r102.updateLayout(r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r109, r116, r117, r118, r120);
        r100 = r211;
        goto L7
    L11:
        int r121 = r101.f398159c;
        int r122 = r101.f398160d;
        r120 = new Rect(r121, r122, r101.f398161e + r121, r101.f398162f + r122);
        goto L12
    L13:
        R(r210);
    }

    public final void W(String r100) {
        LynxContext r101 = getLynxContext();
        if (r101 == null) goto L9;
        EventEmitter r102 = r101.getEventEmitter();
        if (r102 == null) goto L10;
        r102.sendCustomEvent(new m7a.a(getSign(), r100));
        return;
    L10:
        return;
    }

    public final void Z(String r100) {
        if (r100 == null) goto L4;
        String r101 = StringsKt.trim(r100).toString();
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        JSONObject r102 = this.f397826d;
        if (r102 == null) goto L12;
        String r103 = r102.toString();
        if (r103 == null) goto L12;
        JSONObject r104 = new JSONObject(r103);
    L14:
        if (StringsKt.isBlank(r101) == false) goto L16;
        r104.remove("placement");
        r104.remove("position");
        r104.remove(GXTemplateKey.GAIAX_LAYER_GRAVITY);
    L17:
        this.f397826d = r104;
        Q();
        return;
    L16:
        r104.put("placement", r101);
        r104.put("position", r101);
        r104.put(GXTemplateKey.GAIAX_LAYER_GRAVITY, r101);
    L12:
        r104 = new JSONObject();
        goto L14
    L4:
        r101 = null;
        goto L5
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.miniapp.lynx.r0] */
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        z5 r101 = new z5(r100, new AnonymousClass1(this), new r0(this), new AnonymousClass3(this));
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setVisibility(8);
        this.f397824b = r101;
        w5 r102 = new w5(r100);
        r102.setMinimumWidth(y0.c(r100, 2));
        r102.setMinimumHeight(y0.c(r100, 2));
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        this.f397823a = r102;
        return r102;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void insertView(LynxUI<?> r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.insertView(r100);
        if (this.f397827e == true) goto L5;
        return;
    L5:
        w5 r101 = this.f397823a;
        if (r101 == null) goto L9;
        r101.post(new t0(this));
        return;
    }

    @LynxProp(name = GXTemplateKey.GAIAX_LAYER_GRAVITY)
    public final void setGravity(String r100) {
        Z(r100);
    }

    @LynxProp(name = "menuWidth")
    public final void setMenuWidth(String r100) {
        this.f397832j = y0.f(r100);
        Q();
    }

    @LynxProp(name = "options")
    public final void setOptions(String r100) {
        JSONObject r101 = null;
        Object r102 = null;
        r101 = null;
        if (r100 != null) goto L5;
    L18:
        this.f397826d = r101;
        Q();
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L18;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L17;
        r102 = r104;
    L17:
        r101 = (JSONObject) r102;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @LynxProp(name = "placement")
    public final void setPlacement(String r100) {
        Z(r100);
    }

    @LynxProp(name = "position")
    public final void setPosition(String r100) {
        Z(r100);
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r100) {
        this.f397827e = r100;
        if (r100 == false) goto L5;
        V();
        return;
    L5:
        O(true);
    }

    public static x5 S(JSONObject r210, Context r211) {
        String r100 = y0.j(r210, new String[]{"material", "materialToken", "backgroundMaterial", "backgroundMaterialToken", "nativeBackgroundMaterial"});
        Object r101 = y0.k(r210, (String[]) Arrays.copyOf(new String[]{"nativeBlur", "blurEnabled", "backgroundBlur", "nativeBackground", "frosted", "glass"}, 6));
        Object r102 = null;
        if ((r101 instanceof Boolean) == false) goto L6;
        Boolean r103 = (Boolean) r101;
    L62:
        if (r103 == null) goto L64;
        boolean r104 = r103.booleanValue();
    L65:
        if (r104 == true) goto L68;
        if (r100 != null) goto L68;
        return null;
    L68:
        Integer r105 = y0.e(y0.k(r210, new String[]{"backgroundColor", "bgColor", "tintColor", "backgroundTint", "backgroundTintColor", "overlayColor"}), r211);
        if (r105 == null) goto L71;
        int r106 = r105.intValue();
    L72:
        Integer r107 = y0.e(y0.k(r210, new String[]{"borderColor", "strokeColor", "border_color", KFFeature.STROKE_COLOR_JSON_FIELD}), r211);
        if (r107 == null) goto L75;
        int r110 = r107.intValue();
    L76:
        Float r108 = y0.f(y0.k(r210, new String[]{"borderWidth", "strokeWidth", "border_width", KFFeature.STROKE_WIDTH_JSON_FIELD}));
        if (r108 == null) goto L79;
        float r109 = r108.floatValue();
    L80:
        Resources r111 = r211.getResources();
        int r112 = RangesKt.coerceAtLeast((int) (r109 * WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).density), 0);
        Float r113 = y0.f(y0.k(r210, new String[]{"cornerRadius", "radius", "borderRadius", "radiusDp", "corner_radius", "border_radius"}));
        if (r113 == null) goto L83;
        float r114 = r113.floatValue();
    L84:
        Resources r115 = r211.getResources();
        float r116 = (int) (r114 * WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density);
        Float r117 = y0.f(y0.k(r210, new String[]{"blurRadius", "backgroundBlurRadius", "nativeBlurRadius", "blur_radius", "background_blur_radius"}));
        if (r117 == null) goto L87;
        float r118 = r117.floatValue();
    L88:
        if (r100 != null) goto L112;
        r100 = "regular_2";
    L112:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L100
        if (o1.w(r211) == true) goto L93;
        boolean r120 = true;
    L94:
        com.obric.oui.material.c r121 = MaterialToken.parse(r100, r120);     // Catch: Throwable -> L100
        if (r121 == null) goto L97;
        com.obric.oui.material.c r122 = r121.a();     // Catch: Throwable -> L100
    L98:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L100
    L103:
        if (Result.m9455isFailureimpl(r123) == true) goto L106;
        r102 = r123;
    L106:
        com.obric.oui.material.c r124 = (com.obric.oui.material.c) r102;
        if (r124 != null) goto L109;
        com.obric.oui.material.c r125 = new com.obric.oui.material.c(null, null, null, null, null, null, null, null, 1023);
    L110:
        r125.f401452a = ColorStateList.valueOf(r106);
        r125.f401454c = new com.obric.oui.color.a[]{new com.obric.oui.color.a(r106, BlendMode.SRC_OVER)};
        r125.f401459h = Float.valueOf(r118);
        return new x5(r106, r110, r112, r116, r125);
    L109:
        r125 = r124;
        goto L110
    L97:
        r122 = null;
        goto L98
    L93:
        r120 = false;
    L100:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L103
    L87:
        r118 = 32.0f;
        goto L88
    L83:
        r114 = 28.0f;
        goto L84
    L79:
        r109 = 1.0f;
        goto L80
    L75:
        r110 = 1728053247;
        goto L76
    L71:
        r106 = -855638017;
        goto L72
    L64:
        r104 = false;
        goto L65
    L6:
        if ((r101 instanceof Number) == false) goto L13;
        if (((Number) r101).intValue() == 0) goto L10;
        boolean r127 = true;
    L11:
        r103 = Boolean.valueOf(r127);
        goto L62
    L10:
        r127 = false;
        goto L11
    L13:
        if ((r101 instanceof String) == false) goto L61;
        String r128 = StringsKt.trim((String) r101).toString().toLowerCase(Locale.ROOT);
        switch(r128.hashCode()) {
            case -1609594047: goto L58;
            case -1298848381: goto L55;
            case 48: goto L51;
            case 49: goto L48;
            case 110: goto L45;
            case 121: goto L42;
            case 3521: goto L39;
            case 3551: goto L36;
            case 109935: goto L33;
            case 119527: goto L30;
            case 3569038: goto L27;
            case 97196323: goto L24;
            case 270940796: goto L21;
            case 1671308008: goto L18;
            default: goto L115;
        };
    L115:
        r103 = null;
        goto L62
    L18:
        if (r128.equals("disable") == false) goto L116;
    L53:
        r103 = Boolean.FALSE;
        goto L62
    L116:
        r103 = null;
        goto L62
    L21:
        if (r128.equals("disabled") == true) goto L53;
        r103 = null;
        goto L62
    L24:
        if (r128.equals("false") == true) goto L53;
        r103 = null;
        goto L62
    L27:
        if (r128.equals("true") == false) goto L119;
    L60:
        r103 = Boolean.TRUE;
        goto L62
    L119:
        r103 = null;
        goto L62
    L30:
        if (r128.equals(BdpAppEventConstant.YES) == true) goto L60;
        r103 = null;
        goto L62
    L33:
        if (r128.equals("off") == true) goto L53;
        r103 = null;
        goto L62
    L36:
        if (r128.equals("on") == true) goto L60;
        r103 = null;
        goto L62
    L39:
        if (r128.equals(BdpAppEventConstant.NO) == true) goto L53;
        r103 = null;
        goto L62
    L42:
        if (r128.equals("y") == true) goto L60;
        r103 = null;
        goto L62
    L45:
        if (r128.equals(OfficeSDKRequestTag.KEY_NEW_USER) == true) goto L53;
        r103 = null;
        goto L62
    L48:
        if (r128.equals("1") == true) goto L60;
        r103 = null;
        goto L62
    L51:
        if (r128.equals("0") == true) goto L53;
        r103 = null;
        goto L62
    L55:
        if (r128.equals("enable") == true) goto L60;
        r103 = null;
        goto L62
    L58:
        if (r128.equals("enabled") == true) goto L60;
        r103 = null;
        goto L62
    L61:
        r103 = null;
        goto L62
    }

    public static List X(List r210, int r211) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = r210.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
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
        r100.add(new j4(r102, r211, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214));
        List<LynxBaseUI> r108 = r102.getChildren();
        Intrinsics.checkNotNull(r108);
        if ((!r108.isEmpty()) == false) goto L12;
        r100.addAll(X(r108, r211 + 1));
    L12:
        r101 = r215;
        goto L4
    L8:
        r214 = null;
        goto L9
    L13:
        return r100;
    }

    public final void P(Activity r110, z5 r210) {
        Window r100 = r110.getWindow();
        if (r100 == null) goto L9;
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L10:
        if (r101 == null) goto L12;
        int r103 = r101.getWidth();
    L13:
        int r104 = RangesKt.coerceAtLeast(r103 - y0.c(r110, 24), 1);
        if (r101 == null) goto L16;
        int r105 = r101.getHeight();
    L17:
        int r106 = RangesKt.coerceAtLeast(r105 - y0.c(r110, 24), 1);
        Float r107 = this.f397832j;
        if (r107 != null) goto L21;
        r107 = y0.f(y0.k(this.f397826d, new String[]{"menuWidth"}));
    L21:
        if (r107 != null) goto L23;
    L31:
        Integer r108 = null;
    L32:
        int r109 = View.MeasureSpec.makeMeasureSpec(r104, Integer.MIN_VALUE);
        int r111 = View.MeasureSpec.makeMeasureSpec(r106, Integer.MIN_VALUE);
        r210.f398349d = null;
        r210.f398350e = r108;
        y0.i(r210);
        r210.measure(r109, r111);
        r210.layout(0, 0, r210.getMeasuredWidth(), r210.getMeasuredHeight());
        List r112 = CollectionsKt.createListBuilder();
        int r113 = r210.getChildCount();
        int r114 = 0;
    L33:
        if (r114 >= r113) goto L39;
        View r115 = r210.getChildAt(r114);
        if (r115 == null) goto L38;
        N(r210, r112, r115, 0);
    L38:
        r114 = r114 + 1;
        goto L33
    L39:
        List r116 = CollectionsKt.build(r112);
        k4 r117 = MenuPopupLayoutUtilsKt.c(r116, r210.getMeasuredWidth(), r210.getMeasuredHeight());
        List<l4> r118 = Y(getChildren(), 0);
        k4 r119 = y0.a(y0.h(r118, r104, r106), MenuPopupLayoutUtilsKt.c(r118, r210.getMeasuredWidth(), r210.getMeasuredHeight()), r117, r104, r106);
        List<l4> r120 = MenuPopupLayoutUtilsKt.b(r116);
        k4 r121 = MenuPopupLayoutUtilsKt.c(r120, r210.getMeasuredWidth(), r210.getMeasuredHeight());
        List<l4> r122 = MenuPopupLayoutUtilsKt.b(r118);
        k4 r123 = MenuPopupLayoutUtilsKt.c(r122, r210.getMeasuredWidth(), r210.getMeasuredHeight());
        k4 r124 = y0.h(r122, r104, r106);
        k4 r125 = y0.a(r124, r123, r121, r104, r106);
        if (r108 == null) goto L42;
        int r126 = r108.intValue();
    L43:
        int r127 = RangesKt.coerceIn(r126, 1, r104);
        int r128 = RangesKt.coerceIn(r125.f398184d, 1, r106);
        r210.f398351f = r119.f398181a - r125.f398181a;
        r210.f398352g = r119.f398182b - r125.f398182b;
        int r129 = r125.f398181a;
        int r130 = r125.f398182b;
        r210.f398349d = new Rect(r129, r130, r129 + r127, r130 + r128);
        r210.measure(View.MeasureSpec.makeMeasureSpec(r127, 1073741824), View.MeasureSpec.makeMeasureSpec(r128, 1073741824));
        r210.layout(0, 0, r127, r128);
        FLogger.f375446a.i("LynxMiniAppMenuUI", "measurePopupContent host=" + r210.getMeasuredWidth() + Permission.EXECUTE + r210.getMeasuredHeight() + " forcedWidth=" + r108 + " rawChosen=" + r119 + " offset=" + r210.f398351f + ',' + r210.f398352g + " viewMetrics=" + r121 + " uiMetrics=" + r123 + " uiTopLevelMetrics=" + r124 + " chosen=" + r125 + " viewSnapshots=" + r120.size() + '/' + r116.size() + " uiSnapshots=" + r122.size() + '/' + ((ArrayList) r118).size());
        return;
    L42:
        r126 = r125.f398183c;
        goto L43
    L23:
        if (r107.floatValue() <= 0.0f) goto L25;
        boolean r131 = true;
    L26:
        if (r131 == true) goto L29;
        r107 = null;
    L29:
        if (r107 == null) goto L31;
        float r132 = r107.floatValue();
        Resources r133 = r110.getResources();
        r108 = Integer.valueOf(RangesKt.coerceIn((int) (r132 * WindowDisplayMetricsOverride.apply(r133, r133.getDisplayMetrics()).density), 1, r104));
        goto L32
    L25:
        r131 = false;
        goto L26
    L16:
        Resources r134 = r110.getResources();
        r105 = WindowDisplayMetricsOverride.apply(r134, r134.getDisplayMetrics()).heightPixels;
        goto L17
    L12:
        Resources r135 = r110.getResources();
        r103 = WindowDisplayMetricsOverride.apply(r135, r135.getDisplayMetrics()).widthPixels;
        goto L13
    L9:
        r101 = null;
        goto L10
    }

    public final List<l4> Y(List<? extends LynxBaseUI> r110, int r111) {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L26;
        LynxBaseUI r102 = (LynxBaseUI) r101.next();
        List<LynxBaseUI> r103 = r102.getChildren();
        boolean r112 = r103.isEmpty();
        int r104 = r102.getOriginLeft();
        int r105 = r102.getOriginTop();
        int r106 = r102.getWidth();
        int r107 = r102.getHeight();
        Rect r108 = r102.getBound();
        if (r108 == null) goto L8;
        Integer r113 = Integer.valueOf(r108.left);
    L9:
        Rect r109 = r102.getBound();
        if (r109 == null) goto L12;
        Integer r114 = Integer.valueOf(r109.top);
    L13:
        Rect r115 = r102.getBound();
        if (r115 == null) goto L16;
        Integer r116 = Integer.valueOf(r115.right);
    L17:
        Rect r117 = r102.getBound();
        if (r117 == null) goto L20;
        Integer r118 = Integer.valueOf(r117.bottom);
    L21:
        r100.add(new l4(r104, r105, r106, r107, r111, r112, r113, r114, r116, r118));
        Intrinsics.checkNotNull(r103);
        if ((!r103.isEmpty()) == false) goto L4;
        r100.addAll(Y(r103, r111 + 1));
        goto L4
    L20:
        r118 = null;
        goto L21
    L16:
        r116 = null;
        goto L17
    L12:
        r114 = null;
        goto L13
    L8:
        r113 = null;
        goto L9
    L26:
        return r100;
    }

    public static final boolean N(ViewGroup r210, List<l4> r211, View r212, int r213) {
        if (r212.getVisibility() != 8) goto L5;
    L26:
        return false;
    L5:
        if (r212.getMeasuredWidth() <= 0) goto L26;
        if (r212.getMeasuredHeight() <= 0) goto L26;
        if ((r212 instanceof ViewGroup) == false) goto L23;
        ViewGroup r100 = (ViewGroup) r212;
        int r101 = r100.getChildCount();
        int r102 = 0;
        boolean r103 = false;
    L12:
        if (r102 >= r101) goto L24;
        View r104 = r100.getChildAt(r102);
        if (r104 == null) goto L22;
        if (N(r210, r211, r104, r213 + 1) == true) goto L21;
        if (r103 == true) goto L21;
        r103 = false;
    L21:
        r103 = true;
    L22:
        r102 = r102 + 1;
    L24:
        Rect r105 = new Rect(0, 0, r212.getMeasuredWidth(), r212.getMeasuredHeight());
        r210.offsetDescendantRectToMyCoords(r212, r105);
        r211.add(new l4(r105.left, r105.top, r105.width(), r105.height(), r213, !r103, Integer.valueOf(r105.left), Integer.valueOf(r105.top), Integer.valueOf(r105.right), Integer.valueOf(r105.bottom)));
        return true;
    L23:
        r103 = false;
        goto L24
    }
}
