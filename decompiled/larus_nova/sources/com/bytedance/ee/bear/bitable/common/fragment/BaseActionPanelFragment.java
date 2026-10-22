package com.bytedance.ee.bear.bitable.common.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.managerpanel.BitableManagerPanelFragment;
import com.bytedance.ee.bear.bitable.utils.g;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 £\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002£\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010L\u001a\u0004\u0018\u00010#2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u00020 H\u0002J\n\u0010U\u001a\u0004\u0018\u00010VH\u0014J\u0012\u0010W\u001a\u0004\u0018\u00010#2\u0006\u0010O\u001a\u00020PH&JA\u0010X\u001a\u0004\u0018\u00010Y2\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010R2\b\u0010_\u001a\u0004\u0018\u00010\u00182\u0006\u0010`\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010aJ\u001a\u0010b\u001a\u00020 2\u0006\u0010c\u001a\u00020d2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010e\u001a\u00020\u000fH\u0016J\b\u0010f\u001a\u00020 H\u0016J\b\u0010g\u001a\u00020 H\u0016J-\u0010h\u001a\u00020 2\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010i\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020 H\u0002J\u0012\u0010l\u001a\u00020 2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\u0010\u0010o\u001a\u00020 2\u0006\u0010p\u001a\u00020\u0018H\u0016JM\u0010q\u001a\u00020 2\u0006\u0010r\u001a\u00020\u00182\u001c\u0010s\u001a\u0018\u0012\f\u0012\n\u0018\u00010\u0018j\u0004\u0018\u0001`u\u0012\u0006\u0012\u0004\u0018\u00010n0t2\b\u0010v\u001a\u0004\u0018\u00010\u00182\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010xJ;\u0010q\u001a\u00020 2\u0006\u0010r\u001a\u00020\u00182\u001c\u0010s\u001a\u0018\u0012\f\u0012\n\u0018\u00010\u0018j\u0004\u0018\u0001`u\u0012\u0006\u0012\u0004\u0018\u00010n0t2\b\u0010v\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010yJ\u0016\u0010z\u001a\u00020 2\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJM\u0010{\u001a\u00020 2\u0006\u0010r\u001a\u00020\u00182\u001c\u0010s\u001a\u0018\u0012\f\u0012\n\u0018\u00010\u0018j\u0004\u0018\u0001`u\u0012\u0006\u0012\u0004\u0018\u00010n0t2\b\u0010v\u001a\u0004\u0018\u00010\u00182\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010xJ\b\u0010|\u001a\u00020 H\u0016J\b\u0010}\u001a\u00020 H\u0016J\u0010\u0010~\u001a\u00020 2\u0006\u0010p\u001a\u00020\u0018H\u0016J\u0011\u0010\u007f\u001a\u00020 2\u0007\u0010\u0080\u0001\u001a\u00020\u0018H\u0016J0\u0010\u0081\u0001\u001a\u00020 2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0003\u0010\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020\u000fH\u0004J\t\u0010\u0087\u0001\u001a\u00020\u0018H\u0016J'\u0010\u0088\u0001\u001a\u00020 2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001aH\u0004¢\u0006\u0003\u0010\u008a\u0001J\u0012\u0010\u008b\u0001\u001a\u00020 2\u0007\u0010\u0089\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020 2\u0007\u0010\u008d\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u008e\u0001\u001a\u00020 H\u0016J\t\u0010\u008f\u0001\u001a\u00020 H\u0016J\t\u0010\u0090\u0001\u001a\u00020 H\u0016J\t\u0010\u0091\u0001\u001a\u00020 H\u0002J\u0010\u0010\u0092\u0001\u001a\u00020 2\u0007\u0010\u008d\u0001\u001a\u00020\u000fJ\t\u0010\u0093\u0001\u001a\u00020\u0018H\u0016J\t\u0010\u0094\u0001\u001a\u00020 H\u0004J\u0010\u0010\u0095\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020 2\u0007\u0010\u0098\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010#J\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010#J\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010#J\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010#J\u0010\u0010\u009d\u0001\u001a\u00020 2\u0007\u0010\u008d\u0001\u001a\u00020\u000fJ\u0010\u0010\u009e\u0001\u001a\u00020 2\u0007\u0010\u008d\u0001\u001a\u00020\u000fJ\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010#J\t\u0010 \u0001\u001a\u0004\u0018\u00010#J\t\u0010¡\u0001\u001a\u0004\u0018\u00010/J\t\u0010¢\u0001\u001a\u0004\u0018\u00010)R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020#X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010%\"\u0004\b6\u0010'R\u001c\u00107\u001a\u0004\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001c\u0010C\u001a\u0004\u0018\u00010#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u001c\u0010F\u001a\u0004\u0018\u00010)X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010+\"\u0004\bH\u0010-R\u001c\u0010I\u001a\u0004\u0018\u00010/X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00101\"\u0004\bK\u00103¨\u0006¤\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/IActionPanelFragmentSetting;", "Lcom/bytedance/ee/bear/document/independentpanel/IndependentDialog;", "<init>", "()V", "mActionPanelLayout", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "getMActionPanelLayout", "()Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "setMActionPanelLayout", "(Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;)V", "rootContainer", "Landroid/widget/FrameLayout;", "isFgOn", "", "enableForsetiPanelHeightAdaptation", "getEnableForsetiPanelHeightAdaptation", "()Z", "setEnableForsetiPanelHeightAdaptation", "(Z)V", "isViewHeightMeasureAtMost", "setViewHeightMeasureAtMost", "mPanelHeightSpec", "", "mPanelHeightFixedPercent", "", "mPanelHeightMinPercent", "mPanelHeightMaxPercent", "mEnableDrag", "mLeftMenuClickListener", "Lkotlin/Function0;", "", "mRightMenuClickListener", "mBottomFixedView", "Landroid/view/View;", "getMBottomFixedView", "()Landroid/view/View;", "setMBottomFixedView", "(Landroid/view/View;)V", "mBottomFixedIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getMBottomFixedIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMBottomFixedIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "mBottomFixedText", "Landroid/widget/TextView;", "getMBottomFixedText", "()Landroid/widget/TextView;", "setMBottomFixedText", "(Landroid/widget/TextView;)V", "mBottomFixedButton", "getMBottomFixedButton", "setMBottomFixedButton", "mBottomDivider", "getMBottomDivider", "setMBottomDivider", "mHorizontalBottomBtnContainer", "Landroid/widget/LinearLayout;", "getMHorizontalBottomBtnContainer", "()Landroid/widget/LinearLayout;", "setMHorizontalBottomBtnContainer", "(Landroid/widget/LinearLayout;)V", "mHorizontalBottomBtn1", "getMHorizontalBottomBtn1", "setMHorizontalBottomBtn1", "mHorizontalBottomBtn2", "getMHorizontalBottomBtn2", "setMHorizontalBottomBtn2", "mHorizontalBottomFixedIconRight", "getMHorizontalBottomFixedIconRight", "setMHorizontalBottomFixedIconRight", "mHorizontalBottomFixedTextRight", "getMHorizontalBottomFixedTextRight", "setMHorizontalBottomFixedTextRight", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createActionPanelLayout", "initBottomView", "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "onCreateContentView", "addChildFragment", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "Ljava/lang/Class;", "tag", "", "args", "customEnterAnim", "writePluginHostToBundle", "(Ljava/lang/Class;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;Z)Landroidx/fragment/app/Fragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "openIndependentMode", "dismissDialog", "dismiss", "removeChildFragment", "customExitAnim", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Integer;)V", "createChildFragmentContainerIfNeeded", "setPanelTitle", "title", "", "setPanelTopBackgroupColor", "color", "setPanelLeftMenu", "menuType", "menuValue", "Lkotlin/Pair;", "Lcom/bytedance/ee/bear/bitable/common/fragment/DrawableResId;", "menuColorRes", "clickListener", "(ILkotlin/Pair;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "(ILkotlin/Pair;Ljava/lang/Integer;)V", "setPanelLeftMenuClickListener", "setPanelRightMenu", "hidePanelLeftMenu", "hidePanelRightMenu", "setPanelBackgroundColor", "setPanelHeightSpec", "panelHeightSpec", "setPanelHeightPercent", "fixedPercent", "minPercent", "maxPercent", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "isSelfAdaptive", "getPanelDragHeight", "setDraggableMode", "draggable", "(Ljava/lang/Boolean;Ljava/lang/Float;)V", "setPanelDraggable", "setDividerVisible", "visible", "collapsedPanel", "expandPanel", WidgetCostModule.TYPE_ON_START, "addBottomView", "setBottomViewVisible", "getBottomViewHeight", "updatePanelPeekHeight", "getBottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setPanelMeasuredHeight", "height", "getBottomFixedView", "getBottomFixedIcon", "getBottomFixedText", "getBottomFixedButton", "setBottomFixedVerticalButtonVisible", "setBottomFixedHorizontalButtonContainerVisible", "getBottomFixedHorizontalLeftButton", "getBottomFixedHorizontalRightButton", "getBottomFixedHorizontalRightButtonText", "getBottomFixedHorizontalRightButtonIcon", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseActionPanelFragment extends BaseBottomSheetDialogFragment implements IActionPanelFragmentSetting, v15.b {
    public View A;
    public LinearLayout B;
    public View C;
    public View D;
    public AppCompatImageView E;
    public TextView F;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommonActionPanelLayout f209810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f209811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f209812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f209813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f209814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f209815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f209816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f209817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f209818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f209819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function0<Unit> f209820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0<Unit> f209821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f209822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AppCompatImageView f209823x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f209824y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f209825z;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActionPanelFragment f209826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f209827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f209828c;

        public b(BaseActionPanelFragment r100, FragmentManager r101, String r102) {
            this.f209826a = r100;
            this.f209827b = r101;
            this.f209828c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseActionPanelFragment.ea0(this.f209826a, this.f209827b, this.f209828c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // v15.b
    public boolean D10() {
        return this instanceof BitableManagerPanelFragment;
    }

    @Override // v15.b
    public /* synthetic */ void Yf() {
    }

    public abstract View la0(CommonActionPanelLayout r100);

    public mr4.a o() {
        return null;
    }

    @Override // v15.b
    public /* synthetic */ long q30() {
        return 0;
    }

    public final View fa0() {
        if (this.f209822w != null) goto L7;
        return null;
    L7:
        return ka0();
    }

    public int ha0() {
        return n.d(80);
    }

    public final CommonActionPanelLayout ia0() {
        CommonActionPanelLayout r100 = this.f209810k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mActionPanelLayout");
        return null;
    }

    public final View ja0() {
        View r100 = this.f209825z;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedButton");
        return null;
    }

    public final View ka0() {
        View r100 = this.f209822w;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mBottomFixedView");
        return null;
    }

    public BaseActionPanelFragment() {
        this.f209815p = 1;
        this.f209816q = 0.8f;
        this.f209817r = 0.45f;
        this.f209818s = 0.8f;
    }

    public final BottomSheetBehavior<FrameLayout> ga0() {
        Dialog r100 = getDialog();
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r101 = (BottomSheetDialog) r100;
    L6:
        if (r101 == null) goto L10;
        AppCompatDelegate r102 = r101.getDelegate();
        if (r102 == null) goto L10;
        FrameLayout r103 = (FrameLayout) r102.findViewById(R.id.design_bottom_sheet);
    L11:
        if (r103 != null) goto L13;
        return null;
    L13:
        return BottomSheetBehavior.from(r103);
    L10:
        r103 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L5;
    L34:
        tt5.a.d("BaseActionPanelFragment", "Activity is not valid in onStart, skip dialog setup.");
        da0(this);
        return;
    L5:
        if (r100.isFinishing() == true) goto L34;
        if (r100.isDestroyed() == true) goto L34;
        if (ka0().getParent() == null) goto L12;
    L26:
        xa0();
        if (g.b() == false) goto L33;
        mr4.a r101 = o();
        if (r101 == null) goto L32;
        int r102 = WatermarkUtils.f209802a;
        if (WatermarkUtils.a(r101, getDialog()) == null) goto L32;
        return;
    L32:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
        Unit r103 = Unit.INSTANCE;
        return;
    L33:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
        Unit r104 = Unit.INSTANCE;
        return;
    L12:
        if (this.f209812m == false) goto L17;
        FrameLayout r105 = this.f209811l;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        r105 = null;
    L16:
        r105.addView(ka0());
    L25:
        na0(false);
        goto L26
    L17:
        Dialog r106 = getDialog();
        if (r106 == null) goto L22;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L22;
        FrameLayout r108 = (FrameLayout) r107.findViewById(R.id.container);
    L23:
        if (r108 == null) goto L25;
        r108.addView(ka0());
    L22:
        r108 = null;
        goto L23
    }

    public final void xa0() {
        if (isAdded() == true) goto L5;
    L60:
        tt5.a.k("BaseActionPanelFragment", "Fragment is not attached, ignore updatePanelPeekHeight.");
        return;
    L5:
        if (getContext() == null) goto L60;
        if (this.f209812m == false) goto L38;
        int r100 = n.z(getContext());
        if (this.f209814o == false) goto L12;
        int r101 = View.MeasureSpec.makeMeasureSpec(r100, Integer.MIN_VALUE);
    L13:
        FrameLayout r102 = this.f209811l;
        FrameLayout r103 = null;
        if (r102 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        r102 = null;
    L16:
        r102.measure(0, r101);
        FrameLayout r104 = this.f209811l;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L20:
        float r105 = r103.getMeasuredHeight();
        if (this.f209815p != 0) goto L25;
        float r106 = r100 * this.f209816q;
        tua.b r107 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r107 == null) goto L62;
        r107.b((int) r106);
        return;
    L62:
        return;
    L25:
        float r108 = r100;
        float r109 = this.f209817r * r108;
        float r110 = r108 * this.f209818s;
        if (r105 >= r109) goto L31;
        tua.b r111 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r111 == null) goto L64;
        r111.b((int) r109);
        return;
    L64:
        return;
    L31:
        if (r105 <= r110) goto L35;
        tua.b r112 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r112 == null) goto L66;
        r112.b((int) r110);
        return;
    L66:
        return;
    L35:
        tua.b r113 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        if (r113 == null) goto L68;
        r113.b((int) r105);
        return;
    L68:
        return;
    L19:
        r103 = r104;
        goto L20
    L12:
        r101 = 0;
        goto L13
    L38:
        BottomSheetBehavior<FrameLayout> r114 = ga0();
        if (r114 == null) goto L70;
        r114.setHideable(this.f209819t);
        ia0().measure(0, 0);
        float r115 = ia0().getMeasuredHeight();
        int r116 = n.z(getContext());
        if (this.f209815p != 0) goto L46;
        float r117 = r116;
        float r118 = this.f209816q * r117;
        r114.setPeekHeight((int) r118);
        if (this.f209819t == false) goto L45;
        ta0(r117 * this.f209818s);
        return;
    L45:
        ta0(r118);
        return;
    L46:
        float r119 = r116;
        float r120 = this.f209817r * r119;
        float r121 = r119 * this.f209818s;
        if (r115 >= r120) goto L50;
        ta0(r120);
        r114.setPeekHeight((int) r120);
        return;
    L50:
        if (r115 <= r121) goto L56;
        if (this.f209819t == true) goto L54;
        ta0(r121);
    L54:
        r114.setPeekHeight((int) r121);
        return;
    L56:
        if (this.f209819t == true) goto L58;
        ta0(r115);
    L58:
        r114.setPeekHeight((int) r115);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        da0(this);
    }

    @Override // v15.b
    public final void dismissDialog() {
        da0(this);
    }

    public static void da0(BaseActionPanelFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void ma0(boolean r100) {
        if (this.f209825z != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        int r101 = 0;
    L8:
        ja0().setVisibility(r101);
        return;
    L7:
        r101 = 8;
        goto L8
    }

    public final void na0(boolean r100) {
        if (r100 == false) goto L5;
        ka0().setVisibility(0);
        ia0().setPadding(0, 0, 0, ha0());
        return;
    L5:
        ka0().setVisibility(8);
        ia0().setPadding(0, 0, 0, 0);
    }

    public final void pa0(int r100) {
        ia0().setPanelBackgroundColor(r100);
    }

    public final void qa0(boolean r100) {
        this.f209819t = r100;
        ia0().setDragHandlerVisible(r100);
    }

    public final void ta0(float r100) {
        if (this.f209812m == false) goto L12;
        FrameLayout r101 = this.f209811l;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        r101 = null;
    L7:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L18;
        r102.height = (int) r100;
        View r103 = getView();
        if (r103 == null) goto L19;
        r103.setLayoutParams(r102);
        return;
    L19:
        return;
    L18:
        return;
    L12:
        ViewGroup.LayoutParams r104 = ia0().getLayoutParams();
        if (r104 == null) goto L21;
        r104.height = (int) r100;
        View r105 = getView();
        if (r105 == null) goto L22;
        r105.setLayoutParams(r104);
        return;
    L22:
        return;
    }

    public final void va0(CharSequence r100) {
        ia0().setTitle(r100);
    }

    public final void wa0(int r100) {
        ViewGroup r101 = ia0().getTopBar();
        if (r101 == null) goto L6;
        r101.setBackgroundTintList(r101.getResources().getColorStateList(r100));
        return;
    }

    public final void oa0(Boolean r100, Float r110) {
        float r101 = 0.2f;
        Float r102 = Float.valueOf(0.2f);
        if (r110 == null) goto L5;
        r101 = r110.floatValue();
    L5:
        if (r110 == null) goto L7;
        float r103 = r110.floatValue();
    L9:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L11;
        ia0().setLeftIconVisible(false);
        ia0().setLeftTextVisible(false);
        qa0(true);
        this.f209815p = 0;
        dn(Float.valueOf(r103), r102, Float.valueOf(0.8f));
        return;
    L11:
        Pair<Integer, ? extends CharSequence> r104 = new Pair(Integer.valueOf(R.drawable.ud_icon_close_small_outlined), null);
        Function0<Unit> r105 = new BaseActionPanelFragment$setDraggableMode$1(this);
        int r106 = com.bytedance.ee.bear.bitable.common.fragment.b.f209834a;
        sa0(0, r104, null, r105);
        qa0(false);
        if (r110 == null) goto L14;
        this.f209815p = 0;
    L15:
        dn(Float.valueOf(r101), r102, Float.valueOf(0.8f));
        return;
    L14:
        this.f209815p = 1;
        goto L15
    L7:
        r103 = 0.4f;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        v15.a.a(this, r100, new b(this, r100, r101));
    }

    public static final void ea0(BaseActionPanelFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        BaseActionPanelFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        super.show(r101, r102);
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.IActionPanelFragmentSetting
    public final void A40(Class<?> r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (isAdded() == true) goto L6;
        tt5.a.d("BaseActionPanelFragment", this + " has not been attached yet.");
        return;
    L6:
        FragmentManager r103 = getChildFragmentManager();
        if (r101 != null) goto L9;
        r101 = r100.getName();
    L9:
        Fragment r104 = r103.findFragmentByTag(r101);
        if (r104 != null) goto L12;
        tt5.a.d("BaseActionPanelFragment", "Fragment already removed: " + r100);
        return;
    L12:
        if (r102 == null) goto L15;
        int r105 = r102.intValue();
    L18:
        getChildFragmentManager().beginTransaction().setCustomAnimations(0, r105).remove(r104).commitAllowingStateLoss();
        return;
    L15:
        if (getChildFragmentManager().getFragments().size() <= 1) goto L17;
        r105 = R.anim.dialog_out_to_right;
        goto L18
    L17:
        r105 = 0;
        goto L18
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.IActionPanelFragmentSetting
    public final void dn(Float r100, Float r101, Float r102) {
        if (r100 == null) goto L4;
        this.f209816q = r100.floatValue();
    L4:
        if (r101 == null) goto L6;
        this.f209817r = r101.floatValue();
    L6:
        if (r102 == null) goto L9;
        this.f209818s = r102.floatValue();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f209813n == false) goto L11;
        int r103 = c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.base_action_panel_forseti_fix_enable") == false) goto L11;
        if (ForsetiHelper.s(this) == false) goto L11;
        if (U90() == false) goto L11;
        boolean r104 = true;
    L12:
        this.f209812m = r104;
        CommonActionPanelLayout r105 = new CommonActionPanelLayout(requireContext());
        r105.setLeftIconVisible(false);
        r105.setOnActionListener(new com.bytedance.ee.bear.bitable.common.fragment.a(this));
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f209810k = r105;
        View r106 = la0(ia0());
        if (r106 == null) goto L15;
        ia0().addView(r106, new ViewGroup.LayoutParams(-1, -1));
    L15:
        View r107 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_panel_bottom_fixed_layout, new FrameLayout(requireContext()), false);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f209822w = r107;
        View r108 = ka0().findViewById(R.id.panel_bottom_btn_1);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f209825z = r108;
        AppCompatImageView r109 = (AppCompatImageView) ja0().findViewById(R.id.bottom_fixed_btn_icon);
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        this.f209823x = r109;
        TextView r110 = (TextView) ja0().findViewById(R.id.bottom_fixed_btn_text);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f209824y = r110;
        if (this.f209822w == null) goto L36;
        this.A = ka0().findViewById(R.id.bottom_divider);
        LinearLayout r111 = (LinearLayout) ka0().findViewById(R.id.horizontal_btn_container);
        this.B = r111;
        if (r111 == null) goto L21;
        View r112 = r111.findViewById(R.id.panel_bottom_btn_v2_1);
    L22:
        this.C = r112;
        LinearLayout r113 = this.B;
        if (r113 == null) goto L25;
        View r114 = r113.findViewById(R.id.panel_bottom_btn_v2_2);
    L26:
        this.D = r114;
        if (r114 == null) goto L29;
        AppCompatImageView r115 = (AppCompatImageView) r114.findViewById(R.id.bottom_fixed_btn_icon);
    L30:
        this.E = r115;
        View r116 = this.D;
        if (r116 == null) goto L33;
        TextView r117 = (TextView) r116.findViewById(R.id.bottom_fixed_btn_text);
    L34:
        this.F = r117;
        goto L36
    L33:
        r117 = null;
        goto L34
    L29:
        r115 = null;
        goto L30
    L25:
        r114 = null;
        goto L26
    L21:
        r112 = null;
    L36:
        if (this.f209812m == false) goto L43;
        FrameLayout r118 = new FrameLayout(requireContext());
        r118.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f209811l = r118;
        r118.addView(ia0());
        FrameLayout r119 = this.f209811l;
        if (r119 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    L41:
        return r119;
    L43:
        return ia0();
    L11:
        r104 = false;
        goto L12
    }

    public final void ra0(int r100, Pair<Integer, ? extends CharSequence> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "menuValue");
        if (r100 != 0) goto L5;
        Integer r103 = r101.getFirst();
        if (r103 == null) goto L16;
        int r104 = r103.intValue();
        ia0().e(r104, r102);
        return;
    L16:
        return;
    L5:
        if (r100 != 1) goto L17;
        CharSequence r105 = r101.getSecond();
        if (r105 == null) goto L14;
        ia0().f(r105, r102);
        return;
    L14:
        return;
    }

    public final void ua0(Pair r100, Integer r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "menuValue");
        CharSequence r103 = (CharSequence) r100.getSecond();
        if (r103 == null) goto L5;
        ia0().h(r103, r101);
    L5:
        this.f209821v = r102;
    }

    public final void sa0(int r100, Pair<Integer, ? extends CharSequence> r101, Integer r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "menuValue");
        ra0(r100, r101, r102);
        this.f209820u = r103;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.IActionPanelFragmentSetting
    public final Fragment NG(Class<?> r100, String r101, Bundle r102, Integer r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (isAdded() == true) goto L6;
        tt5.a.d("BaseActionPanelFragment", this + " has not been attached yet.");
        return null;
    L6:
        if (r101 != null) goto L8;
        r101 = r100.getName();
    L8:
        Fragment r103 = getChildFragmentManager().findFragmentByTag(r101);
        if (r103 == null) goto L12;
        tt5.a.d("BaseActionPanelFragment", "Fragment already added: " + r103);
    L35:
        return r103;
    L12:
        if (ia0().findViewById(R.id.action_panel_child_fragment_container) != null) goto L14;
        FrameLayout r104 = new FrameLayout(requireContext());
        r104.setId(R.id.action_panel_child_fragment_container);
        ia0().addView(r104, new ViewGroup.LayoutParams(-1, -1));
    L14:
        r103 = getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), r100.getName());
        if (r102 != null) goto L18;
        r102 = new Bundle();
    L18:
        if (r111 == true) goto L36;
    L23:
        r103.setArguments(r102);
        if (r110 == null) goto L27;
        int r105 = r110.intValue();
    L30:
        FragmentTransaction r106 = getChildFragmentManager().beginTransaction().setCustomAnimations(r105, 0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, R.id.action_panel_child_fragment_container) == true) goto L34;
        r106 = r106.add(R.id.action_panel_child_fragment_container, r103, r101);
    L34:
        r106.commitAllowingStateLoss();
        goto L35
    L27:
        if ((!getChildFragmentManager().getFragments().isEmpty()) == false) goto L29;
        r105 = R.anim.dialog_in_from_right;
        goto L30
    L29:
        r105 = 0;
        goto L30
    L36:
        PluginHost.writePluginHostToBundle(this, r102);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        tt5.a.f("BaseActionPanelFragment", e, false);
        goto L23
    }
}
