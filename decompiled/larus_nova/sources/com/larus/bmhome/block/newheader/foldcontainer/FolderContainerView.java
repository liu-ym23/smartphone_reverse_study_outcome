package com.larus.bmhome.block.newheader.foldcontainer;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.block.newheader.keywordreferencelist.QueryKeywordReferencesView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.layout.widget.ExpendAllThinkView;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.chat.common.databinding.LarusLayoutExpendAllThinkBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusWidgetTextSourceHeaderBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import defpackage.d0;
import defpackage.e0;
import defpackage.f0;
import ib8.c;
import ib8.g0;
import ib8.h0;
import ib8.i0;
import ib8.j0;
import ib8.k0;
import ib8.l0;
import ib8.m0;
import ib8.n;
import ib8.n0;
import ib8.o0;
import ib8.p0;
import ib8.q0;
import ib8.r0;
import ib8.s0;
import ib8.t0;
import ib8.u0;
import ib8.v0;
import ib8.w0;
import ic8.q;
import java.util.List;
import jb8.d;
import jb8.k;
import kb8.i;
import kc8.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import lb8.g;
import po8.p;
import po8.z;
import so8.f;
import so8.r;
import tk8.e;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 \u0087\u00012\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0087\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010E\u001a\u00020\rH\u0002J\u0018\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0004H\u0016J\u0018\u0010H\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010I\u001a\u00020<2\u0006\u0010G\u001a\u00020JH\u0002J\b\u0010K\u001a\u0004\u0018\u00010?J \u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020C2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0004H\u0002J,\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0O2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020AH\u0002J4\u0010R\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010Z\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J \u0010[\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\rH\u0002J$\u0010\\\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010S\u001a\u00020\r2\b\b\u0002\u0010T\u001a\u00020\rH\u0002J$\u0010]\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010S\u001a\u00020\r2\b\b\u0002\u0010T\u001a\u00020\rH\u0002J\u0010\u0010^\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010_\u001a\u00020<2\u0006\u0010`\u001a\u00020CH\u0002J\b\u0010a\u001a\u00020CH\u0002J\b\u0010b\u001a\u00020<H\u0002J\b\u0010c\u001a\u00020CH\u0002J\u0010\u0010d\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010e\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010f\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0018\u0010g\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010h\u001a\u00020CH\u0002J\b\u0010i\u001a\u00020<H\u0002J\u001a\u0010j\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010h\u001a\u00020CH\u0002J\u001e\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020\"2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\b\u0010n\u001a\u00020\"H\u0016J\b\u0010o\u001a\u00020pH\u0016J\b\u0010q\u001a\u00020<H\u0016J\n\u0010r\u001a\u0004\u0018\u00010AH\u0016J\u000f\u0010s\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020vH\u0016J\n\u0010w\u001a\u0004\u0018\u00010xH\u0016R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010*\u001a\u0004\b7\u00108R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020zX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001c\u0010\u007f\u001a\u00020zX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R'\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010;X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/bmhome/block/newheader/foldcontainer/FolderContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/block/newheader/foldcontainer/ContainerViewInput;", "Lcom/larus/bmhome/block/newheader/foldcontainer/FoldContainerViewOutput;", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "Lcom/larus/bmhome/chat/view/IFoldContainerInterface;", "Lcom/larus/bmhome/block/newheader/IRecyclableLifecycle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "outerHalfExpandHeight", "Ljava/lang/Integer;", "llReferenceTitleWrapper", "getLlReferenceTitleWrapper", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "subviewContainer", "Lcom/larus/bmhome/chat/layout/widget/MaxHeightRelativeLayout;", "getSubviewContainer", "()Lcom/larus/bmhome/chat/layout/widget/MaxHeightRelativeLayout;", "expandAllThinkView", "Lcom/larus/bmhome/chat/layout/widget/ExpendAllThinkView;", "getExpandAllThinkView", "()Lcom/larus/bmhome/chat/layout/widget/ExpendAllThinkView;", "llReferenceTitleBg", "Lcom/larus/bmhome/block/newheader/foldcontainer/ReferenceTitleBackgroundView;", "getLlReferenceTitleBg", "()Lcom/larus/bmhome/block/newheader/foldcontainer/ReferenceTitleBackgroundView;", "maskReferenceTitle", "Landroid/view/View;", "getMaskReferenceTitle", "()Landroid/view/View;", "foldExpandAnimationHelper", "LFoldExpandAnimationHelper;", "getFoldExpandAnimationHelper", "()LFoldExpandAnimationHelper;", "foldExpandAnimationHelper$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusWidgetTextSourceHeaderBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusWidgetTextSourceHeaderBinding;", "binding$delegate", "headerViewController", "Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/HeaderViewController;", "getHeaderViewController", "()Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/HeaderViewController;", "headerViewController$delegate", "subViewsController", "Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/SubViewsController;", "getSubViewsController", "()Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/SubViewsController;", "subViewsController$delegate", "scrollToAttachCellTopCallback", "Lkotlin/Function0;", "", BdpAppEventConstant.PARAMS_OUTPUT, "headerClickPosition", "", "currentFoldStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "headerStickyEnabled", "", "hideReferenceTitleBackground", "halfFoldExpandHeight", "bindData", "input", "bindFoldContainer", "bindHeaderSplitLine", "Lcom/larus/bmhome/block/newheader/foldcontainer/FoldContainerViewInput;", "currentHeaderTitle", "setupExpandAllView", "reachHalfFoldMaxHeight", "calculateAnimationStartAndEndHeight", "Lkotlin/Pair;", "originFoldStatus", "targetFoldStatus", "animateLayoutHeight", ShareData.START_HEIGHT, "endHeight", "animationDuration", "", "animationInterpolator", "Landroid/animation/TimeInterpolator;", "executeFoldOrExpandAnimation", "executeScrollIfRequired", "tryScrollAndExpandOrFoldAnimation", "animateHalfFoldTransition", "animateExpandTransition", "updateCommonHeaderUIForExpandedStates", "updateHeaderMaskVisibility", "visible", "shouldHideReferenceTitleBackground", "updateWindowStickyTitleBackground", "isWindowMessageBubbleEnabled", "tryShowExpandAll", "handleHalfFoldStatusUI", "handleCompleteExpandStatusUI", "handleCompleteFoldStatusUI", "animationEndTriggered", "resetAnimationLayoutParams", "refreshLayout", "adjustTopMargin", "itemView", "foldCallback", "getView", "getThinkingContainer", "Landroid/view/ViewGroup;", "onRecycle", "getDeepThinkFoldStatus", "scrollToAttachCellTop", "()Lkotlin/Unit;", "asTextView", "Landroid/widget/TextView;", "getContainer", "Landroid/widget/FrameLayout;", "clickY", "", "getClickY", "()F", "setClickY", "(F)V", "clickX", "getClickX", "setClickX", "downListener", "getDownListener", "()Lkotlin/jvm/functions/Function0;", "setDownListener", "(Lkotlin/jvm/functions/Function0;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderContainerView extends ConstraintLayout implements st8.a, p, hb8.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f296321o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f296322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f296323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f296324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f296325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f296326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f296327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larus.bmhome.block.newheader.foldcontainer.b f296328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f296329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DeepThinkFoldStatus f296330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f296331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f296332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f296333l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f296334m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Boolean> f296335n;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296336a = null;

        static {
            int[] r100 = new int[DeepThinkFoldStatus.values().length];
            r100[DeepThinkFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DeepThinkFoldStatus.HalfFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f296336a = r100;
        }
    }

    static {
    }

    public FolderContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FolderContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // po8.p
    public View getView() {
        return this;
    }

    @Override // st8.a
    public final View l5() {
        return null;
    }

    private final LarusWidgetTextSourceHeaderBinding getBinding() {
        return (LarusWidgetTextSourceHeaderBinding) this.f296324c.getValue();
    }

    private final e0 getFoldExpandAnimationHelper() {
        return (e0) this.f296323b.getValue();
    }

    private final d getHeaderViewController() {
        return (d) this.f296325d.getValue();
    }

    private final k getSubViewsController() {
        return (k) this.f296326e.getValue();
    }

    public final void V6() {
        if (this.f296332k == false) goto L6;
        e1.o(getMaskReferenceTitle());
        e1.o(getLlReferenceTitleBg());
        return;
    L6:
        ChatWindowServiceDelegate r100 = ChatWindowServiceDelegate.f392926b;
        if (r100.d(getContext()) == true) goto L10;
        return;
    L10:
        if (this.f296332k == false) goto L12;
    L20:
        boolean r101 = true;
    L21:
        if (r101 == true) goto L24;
        return;
    L24:
        if (getLlReferenceTitleWrapper().getTranslationY() <= 0.0f) goto L26;
        boolean r102 = true;
    L27:
        N6(r102);
        e1.y(getLlReferenceTitleBg(), r102);
        if (r102 == false) goto L31;
        ReferenceTitleBackgroundView r103 = getLlReferenceTitleBg();
        r103.f296347i = true;
        r103.f296346h = false;
        r103.f296348j = null;
        r103.f296349k = null;
        r103.f296350l = null;
        r103.a();
        r103.invalidate();
        return;
    L31:
        return;
    L26:
        r102 = false;
        goto L27
    L12:
        if (r100.d(getContext()) == true) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == true) goto L20;
        r101 = false;
        goto L21
    L14:
        if (z2.f365865a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L16;
        r104 = true;
        goto L17
    }

    public final int s6() {
        Integer r100 = this.f296322a;
        if (r100 != null) goto L7;
        Context r101 = getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        dh8.b.f468639a.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return dh8.b.e(dh8.b.b(r101));
    L7:
        return r100.intValue();
    }

    private final ExpendAllThinkView getExpandAllThinkView() {
        return getBinding().f358837d;
    }

    private final ReferenceTitleBackgroundView getLlReferenceTitleBg() {
        return getBinding().f358842i;
    }

    private final ConstraintLayout getLlReferenceTitleWrapper() {
        return getBinding().f358843j;
    }

    private final View getMaskReferenceTitle() {
        return getBinding().f358844k;
    }

    private final MaxHeightRelativeLayout getSubviewContainer() {
        return getBinding().f358846m;
    }

    public final void C6() {
        MaxHeightRelativeLayout r100 = getSubviewContainer();
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L10;
        r101.height = -2;
        ViewParent r102 = getParent();
        if (r102 == null) goto L7;
        r102.requestLayout();
    L7:
        r100.setLayoutParams(r101);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // hb8.a
    public final void f() {
        C6();
        getLlReferenceTitleWrapper().setTranslationY(0.0f);
        this.f296332k = false;
        getSubviewContainer().setMaxHeight(Integer.MAX_VALUE);
        e1.o(getSubviewContainer());
        ExpendAllThinkView r100 = getExpandAllThinkView();
        r100.getClass();
        e1.o(r100);
        r100.setDividerVisible(false);
        getSubViewsController().f();
    }

    public FrameLayout getContainer() {
        ViewParent r100 = getParent();
        if ((r100 instanceof FrameLayout) == true) goto L7;
        return null;
    L7:
        return (FrameLayout) r100;
    }

    @Override // po8.p
    public ViewGroup getThinkingContainer() {
        k r100 = getSubViewsController();
        if (r100.e().getParent() == null) goto L6;
        return r100.e();
    L6:
        if (r100.f498036h == false) goto L9;
        return r100.b();
    L9:
        return r100.d();
    }

    @Override // st8.a
    public float getClickX() {
        return this.f296334m;
    }

    @Override // st8.a
    public float getClickY() {
        return this.f296333l;
    }

    @Override // po8.p
    public DeepThinkFoldStatus getDeepThinkFoldStatus() {
        return this.f296330i;
    }

    public Function0<Boolean> getDownListener() {
        return this.f296335n;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [ib8.q0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [ib8.r0] */
    public static d T5(final FolderContainerView r100) {
        return new d(r100.getBinding(), new q0(r100), new r0(r100));
    }

    public static e0 c6(FolderContainerView r100) {
        return new e0(r100.getSubviewContainer());
    }

    public final void H6(ib8.a r100) {
        getExpandAllThinkView().setDividerVisible(r100.f488998a.f489082b);
        e1.x(getSubviewContainer());
        if (this.f296332k == false) goto L5;
    L13:
        boolean r101 = true;
    L14:
        if (r101 == false) goto L17;
        N6(false);
        e1.o(getLlReferenceTitleBg());
        ShimmerLinearLayout r102 = getBinding().f358841h;
        r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r102.getPaddingRight(), 0);
        return;
    L17:
        e1.x(getMaskReferenceTitle());
        e1.x(getLlReferenceTitleBg());
        o r103 = r100.f488998a.f489083c;
        if (r103 == null) goto L20;
        boolean r104 = r103.f502536a;
    L21:
        ReferenceTitleBackgroundView r105 = getLlReferenceTitleBg();
        if (r104 == true) goto L24;
    L26:
        boolean r106 = false;
    L27:
        r105.f296347i = true;
        r105.f296346h = r106;
        r105.f296348j = null;
        r105.f296349k = null;
        r105.f296350l = null;
        r105.a();
        r105.invalidate();
        ShimmerLinearLayout r107 = getBinding().f358841h;
        r107.setPadding(r107.getPaddingLeft(), r107.getPaddingTop(), r107.getPaddingRight(), 0);
        return;
    L24:
        if (r100.f488998a.f489095o == true) goto L26;
        r106 = true;
        goto L27
    L20:
        r104 = true;
        goto L21
    L5:
        if (ChatWindowServiceDelegate.f392926b.d(getContext()) == true) goto L7;
    L9:
        boolean r108 = false;
    L10:
        if (r108 == true) goto L13;
        r101 = false;
        goto L14
    L7:
        if (z2.f365865a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L9;
        r108 = true;
        goto L10
    }

    public final void N6(boolean r100) {
        View r101 = getMaskReferenceTitle();
        if (r100 == false) goto L6;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        return;
    L6:
        if (getBinding().f358838e.getVisibility() != 0) goto L8;
        r102 = 4;
        goto L9
    L8:
        r102 = 8;
        goto L9
    }

    public void setClickX(float r100) {
        this.f296334m = r100;
    }

    public void setClickY(float r100) {
        this.f296333l = r100;
    }

    public void setDownListener(Function0<Boolean> r100) {
        this.f296335n = r100;
    }

    public static void R5(ib8.a r100, FolderContainerView r101) {
        if (r100.f488998a.f489086f == true) goto L5;
    L7:
        e1.o(r101.getExpandAllThinkView());
        return;
    L5:
        if (r101.getSubviewContainer().getMeasuredHeight() < r101.s6()) goto L7;
        r101.getExpandAllThinkView().R5(!r100.f488998a.f489087g);
        r101.getExpandAllThinkView().setAlpha(1.0f);
    }

    public static void S5(FolderContainerView r100, n r101) {
        e1.y(r100.getBinding().f358836c, r101.f489096p);
    }

    public static Unit Y5(DeepThinkFoldStatus r100, FolderContainerView r101) {
        if (q.b(r100) == false) goto L6;
        e1.x(r101.getSubviewContainer());
    L6:
        return Unit.INSTANCE;
    }

    public static k Z5(Context r100, FolderContainerView r101) {
        return new k(r100, r101.getSubviewContainer());
    }

    public static Unit b6(FolderContainerView r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r100.f296330i == DeepThinkFoldStatus.CompleteFold) goto L10;
        com.larus.bmhome.block.newheader.foldcontainer.b r102 = r100.f296328g;
        if (r102 == null) goto L9;
        r102.h(r100, r100.getSubViewsController().c());
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final void o6(final ib8.a r210, final com.larus.bmhome.block.newheader.foldcontainer.b r211) {
        Intrinsics.checkNotNullParameter(r210, "input");
        Intrinsics.checkNotNullParameter(r211, BdpAppEventConstant.PARAMS_OUTPUT);
        FLogger.f375446a.d("FolderContainerView", "bindData=============" + r210.f488998a.f489090j);
        n r100 = r210.f488998a;
        this.f296322a = r100.f489100t;
        this.f296328g = r211;
        this.f296329h = r100.f489101u;
        this.f296330i = r100.f489090j.f489019d;
        this.f296332k = r100.C;
        boolean r101 = r100.f489103w;
        this.f296331j = r101;
        if (r101 == true) goto L5;
        getLlReferenceTitleWrapper().setTranslationY(0.0f);
        this.f296327f = null;
        V6();
    L5:
        final n r102 = r210.f488998a;
        if (r102.f489106z == true) goto L8;
        e1.o(getBinding().f358838e);
        e1.o(getBinding().f358839f);
    L15:
        ShimmerLinearLayout r103 = getBinding().f358841h;
        r103.setPaddingRelative(r102.f489104x, r102.f489105y, r103.getPaddingEnd(), r103.getPaddingBottom());
        MaxHeightRelativeLayout r104 = getSubviewContainer();
        boolean r110 = r102.f489081a;
        r104.getClass();
        if (r110 == false) goto L18;
        int r111 = 80;
    L19:
        r104.setGravity(r111);
        final d r105 = getHeaderViewController();
        w0 r112 = r102.f489084d;
        if (ChatWindowServiceDelegate.f392926b.d(getContext()) == true) goto L22;
    L24:
        boolean r113 = false;
    L25:
        if (r113 == false) goto L27;
        HeadTitleLoadingTarget r114 = HeadTitleLoadingTarget.TEXT;
    L28:
        w0 r115 = w0.a(r112, r114, 255);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r115, "input");
        r105.f498015a.f358848o.setText(r115.f489130c);
        we8.a.b(r105.f498015a.f358848o, i5.t(), false, null, null, 12);
        List<String> r116 = r115.f489131d;
        if (r116 != null) goto L31;
    L34:
        boolean r117 = true;
    L35:
        if (r117 == false) goto L37;
        e1.o(r105.f498015a.f358849p);
        e1.x(r105.f498015a.f358848o);
    L50:
        String r118 = r115.f489132e;
        if (r118 != null) goto L53;
    L56:
        boolean r119 = true;
    L57:
        if (r119 == false) goto L59;
        e1.o(r105.f498015a.f358845l);
    L61:
        if (r115.f489129b == false) goto L69;
        int r120 = d.a.f498020a[r115.f489136i.ordinal()];
        if (r120 == 1) goto L68;
        if (r120 != 2) goto L67;
        r105.f498015a.f358841h.a();
        r105.f498015a.f358848o.z(true);
    L70:
        ActivityIndicatorView r121 = r105.f498015a.f358835b;
        boolean r122 = r115.f489135h;
        r121.f328120d = r122;
        e1.y(r121, r122);
        if (r115.f489135h == false) goto L73;
        r105.f498015a.f358835b.b();
        ActivityIndicatorView r123 = r105.f498015a.f358835b;
        Handler r124 = r123.f328124h;
        Intrinsics.checkNotNull(r124);
        r124.post(r123.f328125i);
    L74:
        r105.f498015a.f358841h.setOnLongClickListener(new jb8.a(r105));
        float r125 = r115.f489133f;
        AppCompatImageView r126 = r105.f498015a.f358840g;
        if (r125 != 90.0f) goto L77;
        boolean r127 = true;
    L78:
        if (r127 == false) goto L80;
        int r128 = R.drawable.larus_ic_tool_header_arrow_down;
    L81:
        r126.setImageResource(r128);
        AppCompatImageView r129 = r105.f498015a.f358840g;
        if (r115.f489134g == true) goto L84;
    L86:
        boolean r130 = false;
    L87:
        e1.y(r129, r130);
        FrameLayout r106 = r105.f498015a.f358847n;
        ViewGroup.LayoutParams r131 = r106.getLayoutParams();
        if (r131 == null) goto L149;
        ViewGroup.MarginLayoutParams r132 = (ViewGroup.MarginLayoutParams) r131;
        if (r115.f489134g == false) goto L92;
    L95:
        int r133 = 0;
    L96:
        r132.setMarginEnd(r133);
        r106.setLayoutParams(r132);
        final d r107 = getHeaderViewController();
        if (r102.f489102v == false) goto L99;
        e1.d(r107.f498015a.f358841h, new jb8.b(r107));
    L100:
        d r108 = getHeaderViewController();
        e1.y(r108.f498015a.f358843j, r102.f489085e);
        getBinding().f358836c.post(new s0(this, r102));
        post(new t0(r102, this, r210, r211));
        n r109 = r210.f488998a;
        r r134 = r109.f489097q;
        if (r134 == null) goto L103;
        DeepThinkFoldStatus r135 = r109.f489090j.f489019d;
        FrameLayout r136 = getBinding().f358850q;
        so8.a r137 = new so8.a(r210.f488998a.f489090j.f489019d);
        MaxHeightRelativeLayout r138 = getBinding().f358846m;
        Intrinsics.checkNotNullParameter(r135, "foldStatus");
        Intrinsics.checkNotNullParameter(r136, "zoomInContainer");
        Intrinsics.checkNotNullParameter(r138, "thinkContainer");
        r134.f542778j = r135;
        r134.f542777i = r137;
        f r139 = (f) r134.f542776h.getValue();
        r139.getClass();
        Intrinsics.checkNotNullParameter(r136, "zoomInContainer");
        Intrinsics.checkNotNullParameter(r138, "thinkContainer");
        r139.f542749c = r136;
        r139.f542750d = r138;
    L103:
        if (r134 == null) goto L105;
        r134.b(getBinding().f358850q);
    L105:
        c r140 = r102.f489090j;
        if (r140.f489016a == false) goto L108;
    L110:
        final c r141 = r210.f488998a.f489090j;
        if (r141.f489017b == true) goto L113;
        u6(r210, false);
    L114:
        k r142 = getSubViewsController();
        r142.getClass();
        Intrinsics.checkNotNullParameter(r210, "input");
        Intrinsics.checkNotNullParameter(r211, BdpAppEventConstant.PARAMS_OUTPUT);
        if (r210.f488999b == null) goto L117;
        r142.f498036h = true;
    L117:
        com.larus.bmhome.chat.standarduikit.vlm.view.a r143 = r210.f489002e;
        if (r143 != null) goto L120;
        e1.o(r142.g());
    L121:
        i r144 = r210.f489000c;
        if (r144 != null) goto L124;
        e1.o((QueryKeywordReferencesView) r142.f498033e.getValue());
    L125:
        nb8.i r145 = r210.f489001d;
        if (r145 != null) goto L128;
        e1.o(r142.d());
    L129:
        g r146 = r210.f488999b;
        if (r146 != null) goto L132;
        e1.o(r142.b());
    L133:
        e r147 = r210.f489003f;
        if (r147 != null) goto L136;
        e1.o(r142.e());
    L141:
        if (r210.f488998a.f489085e == true) goto L147;
        RelativeLayout r148 = r142.f498030b;
        ViewGroup.LayoutParams r149 = r148.getLayoutParams();
        if (r149 == null) goto L146;
        ViewGroup.MarginLayoutParams r150 = (ViewGroup.MarginLayoutParams) r149;
        r150.topMargin = 0;
        r148.setLayoutParams(r150);
        return;
    L146:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L147:
        return;
    L136:
        tk8.f r151 = r211.f();
        if (r151 != null) goto L139;
        e1.o(r142.e());
        goto L141
    L139:
        r142.a(r142.e(), new RelativeLayout.LayoutParams(-1, -2), R.id.sub_elapsed_block_content, 3);
        e1.x(r142.e());
        r142.e().a(r147, r151);
        goto L141
    L132:
        r142.a(r142.b(), new RelativeLayout.LayoutParams(-1, 0), R.id.sub_deep_think_block_list, 3);
        e1.x(r142.b());
        r142.b().a(r146, r211.d());
        goto L133
    L128:
        r142.a(r142.d(), new RelativeLayout.LayoutParams(-1, -2), R.id.sub_deep_think_content, 4);
        e1.x(r142.d());
        r142.d().a(r145, r211.g());
        goto L129
    L124:
        r142.a((QueryKeywordReferencesView) r142.f498033e.getValue(), new RelativeLayout.LayoutParams(-1, -2), R.id.sub_keyword_reference, 2);
        e1.x((QueryKeywordReferencesView) r142.f498033e.getValue());
        ((QueryKeywordReferencesView) r142.f498033e.getValue()).a(r144, r211.e());
        goto L125
    L120:
        r142.a(r142.g(), new RelativeLayout.LayoutParams(-1, -2), R.id.sub_vlm_mixed_media_widget, 1);
        e1.x(r142.g());
        r142.g().v(r143, r211.i());
        r142.g().B(r143, 0);
        goto L121
    L113:
        post(new u0(this, r210, r141));
        goto L114
    L108:
        if (r140.f489017b == true) goto L110;
    L99:
        r107.f498015a.f358841h.setOnClickListener(null);
        r107.f498015a.f358841h.setClickable(false);
        goto L100
    L92:
        if (r115.f489135h == true) goto L95;
        r133 = i5.q();
        goto L96
    L149:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L84:
        if (r115.f489135h == true) goto L86;
        r130 = true;
        goto L87
    L80:
        r128 = R.drawable.larus_ic_tool_header_arrow_right;
        goto L81
    L77:
        r127 = false;
        goto L78
    L73:
        r105.f498015a.f358835b.b();
        goto L74
    L67:
        throw new NoWhenBranchMatchedException();
    L68:
        r105.f498015a.f358848o.x();
        r105.f498015a.f358841h.b();
        goto L70
    L69:
        r105.f498015a.f358841h.a();
        r105.f498015a.f358848o.x();
        goto L70
    L59:
        e1.x(r105.f498015a.f358845l);
        ImageLoaderKt.u(r105.f498015a.f358845l, r115.f489132e, "deep_think_title_icon");
        goto L61
    L53:
        if (r118.length() == 0) goto L56;
        r119 = false;
        goto L57
    L37:
        e1.x(r105.f498015a.f358849p);
        e1.o(r105.f498015a.f358848o);
        List<String> r152 = r115.f489131d;
        List<String> r153 = r105.f498019e;
        if (r153 == null) goto L40;
        int r154 = r153.hashCode();
    L42:
        if (r154 == r152.hashCode()) goto L50;
        r105.f498019e = r152;
        final Context r155 = r105.f498015a.f358834a.getContext();
        z r156 = r105.f498018d;
        if (r156 == null) goto L47;
        r156.b();
    L47:
        r105.f498015a.f358849p.removeAllViews();
        r105.f498015a.f358849p.setFactory(new jb8.c(r155));
        z r157 = new z(r105.f498015a.f358849p, r152);
        r105.f498018d = r157;
        Intrinsics.checkNotNull(r155);
        r157.a(r155);
        z r158 = r105.f498018d;
        if (r158 == null) goto L50;
        r158.c();
        goto L50
    L40:
        r154 = 0;
        goto L42
    L31:
        if (r116.isEmpty() == true) goto L34;
        r117 = false;
        goto L35
    L27:
        r114 = HeadTitleLoadingTarget.CONTAINER;
        goto L28
    L22:
        if (z2.f365865a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L24;
        r113 = true;
        goto L25
    L18:
        r111 = 48;
        goto L19
    L8:
        View r159 = getBinding().f358838e;
        ViewGroup.LayoutParams r160 = r159.getLayoutParams();
        if (r160 == null) goto L155;
        ConstraintLayout.LayoutParams r161 = (ConstraintLayout.LayoutParams) r160;
        ((ViewGroup.MarginLayoutParams) r161).topMargin = r102.A;
        r159.setLayoutParams(r161);
        e1.x(getBinding().f358838e);
        Space r162 = getBinding().f358839f;
        ViewGroup.LayoutParams r163 = r162.getLayoutParams();
        if (r163 == null) goto L153;
        ConstraintLayout.LayoutParams r164 = (ConstraintLayout.LayoutParams) r163;
        ((ViewGroup.MarginLayoutParams) r164).height = r102.B;
        r162.setLayoutParams(r164);
        e1.x(getBinding().f358839f);
        MaxHeightRelativeLayout r165 = getSubviewContainer();
        ViewGroup.LayoutParams r166 = r165.getLayoutParams();
        if (r166 == null) goto L151;
        ConstraintLayout.LayoutParams r167 = (ConstraintLayout.LayoutParams) r166;
        r167.topToTop = -1;
        r167.topToBottom = R.id.header_split_line_bottom_space;
        ((ViewGroup.MarginLayoutParams) r167).topMargin = 0;
        r165.setLayoutParams(r167);
        goto L15
    L151:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L153:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L155:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @Override // po8.p
    public final void u1(View r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "foldCallback");
        if (q.a(this.f296330i) == false) goto L5;
        return;
    L5:
        if (this.f296331j == false) goto L18;
        d r102 = getHeaderViewController();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "itemView");
        int r103 = r100.getTop() + e1.n(r102.f498015a.f358843j, r100).y;
        if (r102.f498015a.f358838e.getVisibility() != 0) goto L10;
        int r104 = r102.f498015a.f358846m.getBottom();
        int r105 = r102.f498015a.f358843j.getBottom();
    L11:
        int r106 = r104 - r105;
        if (r103 < 0) goto L14;
        int r107 = 0;
    L15:
        r102.f498015a.f358843j.setTranslationY(r107);
        r102.f498015a.f358842i.invalidate();
        V6();
        this.f296327f = r101;
        return;
    L14:
        r107 = Math.min(-r103, r106);
        goto L15
    L10:
        r104 = r102.f498015a.f358846m.getHeight();
        r105 = r102.f498015a.f358844k.getHeight();
        goto L11
    }

    public final void u6(final ib8.a r100, boolean r101) {
        DeepThinkFoldStatus r102 = r100.f488998a.f489090j.f489019d;
        C6();
        int r103 = b.f296336a[r102.ordinal()];
        int r104 = 0;
        if (r103 != 1) goto L5;
        getSubviewContainer().setMaxHeight(Integer.MAX_VALUE);
        ReferenceTitleBackgroundView r105 = getLlReferenceTitleBg();
        r105.f296347i = false;
        r105.invalidate();
        ExpendAllThinkView r106 = getExpandAllThinkView();
        r106.getClass();
        e1.o(r106);
        r106.setDividerVisible(false);
        N6(false);
        e1.o(getSubviewContainer());
        if (getLlReferenceTitleWrapper().getTranslationY() <= 0.0f) goto L19;
        getLlReferenceTitleWrapper().setTranslationY(0.0f);
        if (r101 == false) goto L19;
        Function0<Unit> r107 = this.f296327f;
        if (r107 == null) goto L19;
        r107.invoke();
        Unit r108 = Unit.INSTANCE;
    L19:
        Resources r109 = AppHost.f326268a.getApplication().getResources();
        if (r100.f488998a.f489093m == false) goto L22;
        r104 = r109.getDimensionPixelSize(R.dimen.dp_12);
    L22:
        ShimmerLinearLayout r110 = getBinding().f358841h;
        r110.setPadding(r110.getPaddingLeft(), r110.getPaddingTop(), r110.getPaddingRight(), r104);
    L23:
        com.larus.bmhome.block.newheader.foldcontainer.b r111 = this.f296328g;
        if (r111 == null) goto L27;
        r111.c();
        return;
    L27:
        return;
    L5:
        if (r103 != 2) goto L7;
        e1.x(getMaskReferenceTitle());
        post(new i0(r100, this));
        getSubviewContainer().setMaxHeight(s6());
        H6(r100);
        goto L23
    L7:
        if (r103 != 3) goto L10;
        getSubviewContainer().setMaxHeight(Integer.MAX_VALUE);
        ExpendAllThinkView r112 = getExpandAllThinkView();
        r112.getClass();
        e1.o(r112);
        r112.setDividerVisible(false);
        View r113 = getMaskReferenceTitle();
        Intrinsics.checkNotNullParameter(r113, "<this>");
        r113.setVisibility(0);
        r113.setAlpha(1.0f);
        ReferenceTitleBackgroundView r114 = getLlReferenceTitleBg();
        Intrinsics.checkNotNullParameter(r114, "<this>");
        r114.setVisibility(0);
        r114.setAlpha(1.0f);
        H6(r100);
        goto L23
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public FolderContainerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f296323b = LazyKt.lazy(new g0(this));
        this.f296324c = LazyKt.lazy(new n0(r100, this));
        this.f296325d = LazyKt.lazy(new o0(this));
        this.f296326e = LazyKt.lazy(new p0(r100, this));
        this.f296329h = "thinking_title";
        this.f296331j = true;
    }

    public static void U5(com.larus.bmhome.block.newheader.foldcontainer.b r100, ExpendAllThinkView r101, FolderContainerView r102) {
        r100.h(r101, r102.getSubViewsController().c());
    }

    public static void i6(final FolderContainerView r110, final ib8.a r111, c r112) {
        DeepThinkFoldStatus r100 = r112.f489018c;
        DeepThinkFoldStatus r113 = r112.f489019d;
        k r101 = r110.getSubViewsController();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, "input");
        boolean r102 = false;
        if (r111.f488999b == null) goto L5;
        int r103 = r101.b().getMeasuredHeight();
    L7:
        if (r111.f489000c == null) goto L9;
        int r104 = ((QueryKeywordReferencesView) r101.f498033e.getValue()).getAnimationMeasureHeight();
    L11:
        if (r111.f489001d == null) goto L13;
        int r105 = r101.d().getMeasuredHeight();
    L15:
        if (r111.f489002e == null) goto L17;
        int r106 = r101.g().A(r111.f489002e);
    L19:
        if (r111.f489003f == null) goto L21;
        int r107 = r101.e().getMeasuredHeight();
    L22:
        final int r108 = (((r103 + r104) + r105) + r106) + r107;
        final int r109 = Math.min(r110.getSubviewContainer().getMeasuredHeight(), r110.s6());
        final int r114 = RangesKt.coerceAtLeast((int) r110.getLlReferenceTitleWrapper().getTranslationY(), 0);
        Function1 r115 = new j0(r114, r109, r108);
        int r116 = ((Number) r115.invoke(r100)).intValue();
        int r117 = ((Number) r115.invoke(r113)).intValue();
        Pair r118 = TuplesKt.to(Integer.valueOf(r116), Integer.valueOf(r117));
        int r119 = ((Number) r118.component1()).intValue();
        int r120 = ((Number) r118.component2()).intValue();
        if (r119 != r120) goto L25;
        r110.post(new k0(r111, r110));
        r110.u6(r111, false);
        return;
    L25:
        ExpendAllThinkView r121 = r110.getExpandAllThinkView();
        r121.getClass();
        e1.o(r121);
        r121.setDividerVisible(false);
        DeepThinkFoldStatus r122 = r111.f488998a.f489090j.f489019d;
        int r123 = b.f296336a[r122.ordinal()];
        if (r123 != 1) goto L28;
        n6(r110, r111, r119, r120);
        return;
    L28:
        if (r123 == 2) goto L42;
        if (r123 != 3) goto L40;
        int r124 = r111.f488998a.f489094n.invoke().intValue();
        if (r124 > 0) goto L34;
    L38:
        r110.k6(r111, r119, r120, 240, new DecelerateInterpolator());
        return;
    L34:
        if (r111.f488998a.f489088h == false) goto L38;
        com.larus.bmhome.block.newheader.foldcontainer.b r125 = r110.f296328g;
        if (r125 == null) goto L38;
        com.larus.bmhome.block.newheader.foldcontainer.b.a.a(r125, r124, 240);
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        if (((int) r110.getLlReferenceTitleWrapper().getTranslationY()) <= 0) goto L44;
        r102 = true;
    L44:
        if (r102 == false) goto L49;
        float r126 = -r110.getLlReferenceTitleWrapper().getTranslationY();
        com.larus.bmhome.block.newheader.foldcontainer.b r127 = r110.f296328g;
        if (r127 == null) goto L48;
        r127.a((int) r126, 160, new DecelerateInterpolator());
    L48:
        r110.k6(r111, r119, r120, 160, new LinearInterpolator());
        return;
    L49:
        n6(r110, r111, r119, r120);
        return;
    L21:
        r107 = 0;
        goto L22
    L17:
        r106 = 0;
        goto L19
    L13:
        r105 = 0;
        goto L15
    L9:
        r104 = 0;
        goto L11
    L5:
        r103 = 0;
        goto L7
    }

    public /* synthetic */ FolderContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void V5(n r100, final FolderContainerView r101, ib8.a r102, final com.larus.bmhome.block.newheader.foldcontainer.b r103) {
        if (r100.f489086f == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r101.getClass();
        Integer r105 = r102.f488998a.f489099s;
        if (r105 == null) goto L11;
        r101.getExpandAllThinkView().setupExpandAllMaskRes(r105.intValue());
    L11:
        Integer r106 = r102.f488998a.f489098r;
        if (r106 == null) goto L14;
        r101.getExpandAllThinkView().setupDividerColor(r106.intValue());
    L14:
        r101.getExpandAllThinkView().setDividerVisible(r102.f488998a.f489082b);
        if (r104 == false) goto L26;
        final ExpendAllThinkView r107 = r101.getExpandAllThinkView();
        e1.d(r107, new v0(r103));
        r107.setOnLongClickListener(new h0(r103, r107, r101));
        r107.R5(!r102.f488998a.f489087g);
        FLogger.f375446a.d("FolderContainerView", "hideExpandAllThinkTitle:" + r102.f488998a.f489087g);
        if (r102.f488998a.f489087g == false) goto L24;
        LarusLayoutExpendAllThinkBinding r108 = r107.f304811a;
        if (r108 == null) goto L24;
        TextView r109 = r108.f323992b;
        if (r109 == null) goto L24;
        r109.setText("");
    L24:
        r107.setAlpha(1.0f);
        return;
    L26:
        return;
    L5:
        if (r101.getSubviewContainer().getMeasuredHeight() < r101.getSubviewContainer().getMaxHeight()) goto L7;
        r104 = true;
        goto L8
    }

    public static /* synthetic */ void n6(FolderContainerView r100, ib8.a r101, int r102, int r110) {
        r100.k6(r101, r102, r110, 240, new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [ib8.m0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [ib8.l0, java.lang.Object] */
    public final void k6(final ib8.a r100, int r101, int r102, long r103, TimeInterpolator r110) {
        final DeepThinkFoldStatus r104 = r100.f488998a.f489090j.f489019d;
        final e0 r105 = getFoldExpandAnimationHelper();
        ?? r106 = new l0(r104, this);
        ?? r107 = new m0(this, r100);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "interpolator");
        Intrinsics.checkNotNullParameter(r106, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r107, "onEnd");
        FLogger.f375446a.d("FoldExpandAnimationHelper", "startHeight==" + r101 + ",endHeight==" + r102);
        r105.f470632a.setMaxHeight(-1);
        MaxHeightRelativeLayout r108 = r105.f470632a;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L7;
        r109.height = r101;
        r105.f470632a.requestLayout();
        r108.setLayoutParams(r109);
        ValueAnimator r111 = ValueAnimator.ofInt(new int[]{r101, r102});
        r111.setDuration(r103);
        r111.setInterpolator(r110);
        r111.addUpdateListener(new d0(r105));
        r111.addListener(new f0(r106, r107));
        r111.start();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
