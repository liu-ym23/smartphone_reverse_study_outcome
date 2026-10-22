package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedWakeupBinding;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import com.larus.dora.impl.settings.SimplifiedTopic;
import com.larus.dora.impl.view.DoraSimplifiedGradientTextView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u0097\u00012\u00020\u0001:\b\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\u0018\u00105\u001a\u00020.2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\u0010\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u0018\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000207H\u0002J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u001aH\u0002J\b\u0010A\u001a\u00020.H\u0002J\n\u0010B\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010C\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010\u00132\u0006\u0010E\u001a\u00020\u0016H\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010\u00132\u0006\u0010G\u001a\u00020\u0016H\u0002J\b\u0010H\u001a\u00020.H\u0002J\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0012\u0010K\u001a\u0002072\b\u0010L\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010M\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u000207H\u0002J\u0018\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u000207H\u0002J8\u0010S\u001a\u00020.2\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u0002072\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020.H\u0002J\b\u0010\\\u001a\u00020.H\u0002J\u0010\u0010]\u001a\u00020.2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020.2\u0006\u0010^\u001a\u00020_H\u0002J\u0012\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020\u0016H\u0002J\u0010\u0010e\u001a\u00020.2\u0006\u0010d\u001a\u00020\u0016H\u0002J\u0012\u0010f\u001a\u0004\u0018\u00010b2\u0006\u0010^\u001a\u00020_H\u0002J\u0018\u0010g\u001a\u00020.2\u0006\u0010d\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u001aH\u0002J\b\u0010i\u001a\u00020\u0016H\u0002J\u0010\u0010j\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0016H\u0002J\u0010\u0010k\u001a\u00020U2\u0006\u0010l\u001a\u00020&H\u0002J\u001a\u0010m\u001a\u0004\u0018\u00010X2\u0006\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u000207H\u0002J\u0018\u0010n\u001a\u00020.2\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0002J \u0010q\u001a\u00020.2\u0006\u0010T\u001a\u00020U2\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0002J\u0018\u0010r\u001a\u00020.2\u0006\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020UH\u0002J \u0010u\u001a\u00020.2\u0006\u0010T\u001a\u00020U2\u0006\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020UH\u0002J0\u0010v\u001a\u00020\u00162\u0006\u0010w\u001a\u00020&2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010{\u001a\u00020\u0016H\u0002J(\u0010|\u001a\u00020U2\u0006\u0010)\u001a\u00020&2\u0006\u0010w\u001a\u00020&2\u0006\u0010}\u001a\u00020\u00162\u0006\u0010z\u001a\u00020&H\u0002J\b\u0010~\u001a\u00020.H\u0002J\b\u0010\u007f\u001a\u00020.H\u0002J!\u0010\u0080\u0001\u001a\u00020\u00162\u0006\u0010)\u001a\u00020&2\u0006\u0010w\u001a\u00020&2\u0006\u0010z\u001a\u00020&H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020.2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020.2\u0007\u0010\u0084\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0085\u0001\u001a\u00020.H\u0002J#\u0010\u0086\u0001\u001a\u00020.2\u0007\u0010\u0087\u0001\u001a\u00020\u00162\u0007\u0010\u0088\u0001\u001a\u00020\u00162\u0006\u0010T\u001a\u00020UH\u0002J\u001a\u0010\u0089\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020y2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u001a\u0010\u008a\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020y2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020.2\u0007\u0010\u008c\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u008d\u0001\u001a\u00020.H\u0002J\t\u0010\u008e\u0001\u001a\u00020.H\u0016J\t\u0010\u008f\u0001\u001a\u00020.H\u0016J\t\u0010\u0090\u0001\u001a\u00020.H\u0016J\t\u0010\u0091\u0001\u001a\u00020.H\u0016J\t\u0010\u0092\u0001\u001a\u000207H\u0016J\t\u0010\u0093\u0001\u001a\u000207H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "simplifiedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getSimplifiedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "simplifiedModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter;", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupBinding;", "sourceTopics", "", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "stableTopics", "currentSelectedIndex", "", "currentSelectedAdapterPosition", "currentAnchorAdapterPosition", "isAnimatingSelection", "", "isUserDraggingList", "isProgrammaticSnap", "pendingManualSelectedAdapterPosition", "Ljava/lang/Integer;", "listAnimator", "Landroid/animation/ValueAnimator;", "capsuleWidthAnimator", "arrowTranslationAnimator", "hasConsumedInitialConnectedState", "keepVoiceCallbackOnNextPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTopContainer", "setupRecyclerView", "setupRecyclerViewScrollListener", "setupObservers", "setupListeners", "reportWakeupTopicClick", ReportConstant.COMMON_ACTION_TYPE, "", "topicKey", "navigateToInterruptPage", "useSharedElement", "addInterruptFragmentOverlay", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "fragmentTag", "renderTopics", "resetAnimatedState", "advanceSelection", "getCurrentTopic", "getNextTopic", "getTopicAtOffset", "offset", "getTopicAtAdapterPosition", "position", "ensureStableTopicWindow", "buildStableTopicWindow", Constants.EXTRA_KEY_TOPICS, "getTopicText", "topic", "getTopicTextByKey", "resetSelectedSuffixText", "topicText", "startTopicTransitionAnimation", "currentText", "nextText", "renderTopicTransitionProgress", "progress", "", "listShift", "metrics", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$TopicTransitionMetrics;", "direction", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$ScrollDirection;", "finishTopicTransition", "onManualScrollStart", "onManualScrollIdle", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "syncCapsuleWithManualScroll", "buildDraggingVisualScrollState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$ManualScrollState;", "finishManualScroll", "selectedAdapterPosition", "commitManualSelection", "buildManualScrollState", "finishSelectionAtAdapterPosition", "resetRecyclerPosition", "resolveRecyclerAnchorOffset", "resolveTopicIndexForAdapterPosition", "calculateListShift", "firstItemView", "buildTransitionMetrics", "startSelectedContainerWidthAnimation", "startWidth", "endWidth", "updateSelectedContainerForProgress", "startArrowTranslationAnimation", "startArrowLeft", "endArrowLeft", "updateArrowForProgress", "calculateSelectedContainerTargetWidth", "prefixTextView", "suffixTextView", "Landroid/widget/TextView;", "arrowView", "suffixMaxWidth", "calculateArrowLeft", "suffixWidth", "updateSelectedContainerWidth", "updateSelectedSuffixTextMaxWidth", "resolveSelectedSuffixMaxWidth", "applySelectedSuffixTextMaxWidth", "maxWidth", "updateSelectedSuffixContainerFixedHeight", "targetHeight", "restoreSelectedSuffixContainerWrapContentHeight", "updateSelectedSuffixContainerAnimatedHeight", ShareData.START_HEIGHT, "endHeight", "measureTextViewWidthWithinMaxWidth", "measureTextViewHeightWithinMaxWidth", "cancelAllAnimators", "resetVisualState", "resetClickDebounceState", "onDestroyView", "onSkipButtonClicked", "onResume", "onPause", "getCurrentPageName", "getCurrentCardName", "ManualScrollState", "ScrollDirection", "TopicTransitionMetrics", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedWakeupFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int F = 0;
    public ValueAnimator A;
    public ValueAnimator B;
    public ValueAnimator C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f337219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DoraHStreamlinedWakeupAdapter f337220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LarusDoraHSimplifiedWakeupBinding f337221q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<SimplifiedTopic> f337222r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<SimplifiedTopic> f337223s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f337224t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f337225u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f337226v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f337227w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f337228x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f337229y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f337230z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupFragment$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "FORWARD", "BACKWARD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f337231a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f337232b = null;

        public static EnumEntries<ScrollDirection> getEntries() {
            return f337232b;
        }

        static {
            ScrollDirection r100 = new ScrollDirection("FORWARD", 0);
            FORWARD = r100;
            ScrollDirection r101 = new ScrollDirection("BACKWARD", 1);
            BACKWARD = r101;
            ScrollDirection[] r102 = {r100, r101};
            f337231a = r102;
            f337232b = EnumEntriesKt.enumEntries(r102);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f337231a.clone();
        }

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r100);
        }

        public ScrollDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f337234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f337235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f337236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f337237e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f337238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ScrollDirection f337239g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f337233a == r101.f337233a) goto L12;
            return false;
        L12:
            if (this.f337234b == r101.f337234b) goto L15;
            return false;
        L15:
            if (Float.compare(this.f337235c, r101.f337235c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f337236d, r101.f337236d) == 0) goto L21;
            return false;
        L21:
            if (this.f337237e == r101.f337237e) goto L24;
            return false;
        L24:
            if (this.f337238f == r101.f337238f) goto L27;
            return false;
        L27:
            if (this.f337239g == r101.f337239g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.f337233a * 31) + this.f337234b) * 31) + Float.floatToIntBits(this.f337235c)) * 31) + Float.floatToIntBits(this.f337236d)) * 31) + this.f337237e) * 31) + this.f337238f) * 31) + this.f337239g.hashCode();
        }

        public final String toString() {
            return "ManualScrollState(firstVisiblePosition=" + this.f337233a + ", firstViewTop=" + this.f337234b + ", listShift=" + this.f337235c + ", progress=" + this.f337236d + ", fromSelectedAdapterPosition=" + this.f337237e + ", toSelectedAdapterPosition=" + this.f337238f + ", direction=" + this.f337239g + ')';
        }

        public b(int r100, int r101, float r102, float r103, int r104, int r105, ScrollDirection r106) {
            Intrinsics.checkNotNullParameter(r106, "direction");
            this.f337233a = r100;
            this.f337234b = r101;
            this.f337235c = r102;
            this.f337236d = r103;
            this.f337237e = r104;
            this.f337238f = r105;
            this.f337239g = r106;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f337241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f337242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f337243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f337244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f337245f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f337240a == r101.f337240a) goto L12;
            return false;
        L12:
            if (this.f337241b == r101.f337241b) goto L15;
            return false;
        L15:
            if (this.f337242c == r101.f337242c) goto L18;
            return false;
        L18:
            if (this.f337243d == r101.f337243d) goto L21;
            return false;
        L21:
            if (Float.compare(this.f337244e, r101.f337244e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f337245f, r101.f337245f) == 0) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f337240a * 31) + this.f337241b) * 31) + this.f337242c) * 31) + this.f337243d) * 31) + Float.floatToIntBits(this.f337244e)) * 31) + Float.floatToIntBits(this.f337245f);
        }

        public final String toString() {
            return "TopicTransitionMetrics(currentTextHeight=" + this.f337240a + ", nextTextHeight=" + this.f337241b + ", startWidth=" + this.f337242c + ", endWidth=" + this.f337243d + ", startArrowLeft=" + this.f337244e + ", endArrowLeft=" + this.f337245f + ')';
        }

        public c(int r100, int r101, int r102, int r103, float r104, float r105) {
            this.f337240a = r100;
            this.f337241b = r101;
            this.f337242c = r102;
            this.f337243d = r103;
            this.f337244e = r104;
            this.f337245f = r105;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f337246a = null;

        static {
            int[] r100 = new int[ScrollDirection.values().length];
            r100[ScrollDirection.FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ScrollDirection.BACKWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f337246a = r100;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        return "new_voice_wakeup_card";
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_h_streamlined_wakeup";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ka0(false);
        this.D = false;
        super.onDestroyView();
        this.f337221q = null;
    }

    public final DoraHStreamlinedOnboardingViewModel ma0() {
        return (DoraHStreamlinedOnboardingViewModel) this.f337219o.getValue();
    }

    public final void sa0() {
        LarusDoraHSimplifiedWakeupBinding r100 = this.f337221q;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        if (this.f337222r.isEmpty() == false) goto L10;
        this.f337223s = CollectionsKt.emptyList();
        this.f337225u = 0;
        this.f337226v = 0;
        DoraSimplifiedGradientTextView r102 = r100.f332697h;
        int r103 = com.larus.utils.j0.f375426a;
        r102.setText(com.larus.utils.j0.d(R.string.larus_dora_onboarding_wakeup_keyword_prefix_cn));
        r100.f332699j.setText("");
        r100.f332700k.setVisibility(4);
        this.f337220p.y2(CollectionsKt.emptyList());
        return;
    L10:
        if ((!this.f337223s.isEmpty()) == true) goto L28;
        List<SimplifiedTopic> r104 = this.f337222r;
        if (r104.isEmpty() == false) goto L15;
        List<SimplifiedTopic> r105 = CollectionsKt.emptyList();
    L19:
        this.f337223s = r105;
        if (this.f337222r.isEmpty() == true) goto L23;
        r101 = this.f337224t + (this.f337222r.size() * 20);
    L23:
        this.f337225u = r101;
        if (this.f337222r.size() <= 1) goto L26;
        int r106 = this.f337225u + 1;
    L27:
        this.f337226v = r106;
        goto L28
    L26:
        r106 = this.f337225u;
        goto L27
    L15:
        List r107 = CollectionsKt.createListBuilder(r104.size() * 40);
        int r108 = 0;
    L16:
        if (r108 >= 40) goto L18;
        r107.addAll(r104);
        r108 = r108 + 1;
        goto L16
    L18:
        r105 = CollectionsKt.build(r107);
    L28:
        SimplifiedTopic r109 = na0(this.f337225u);
        if (r109 != null) goto L31;
        return;
    L31:
        DoraSimplifiedGradientTextView r110 = r100.f332697h;
        int r111 = com.larus.utils.j0.f375426a;
        r110.setText(com.larus.utils.j0.d(R.string.larus_dora_onboarding_wakeup_keyword_prefix_cn));
        this.f337220p.y2(this.f337223s);
        r100.f332694e.setTranslationY(0.0f);
        if (this.f337228x == false) goto L34;
    L41:
        ta0(oa0(r109));
        return;
    L34:
        if (this.f337229y == true) goto L41;
        RecyclerView.LayoutManager r112 = r100.f332694e.getLayoutManager();
        if ((r112 instanceof LinearLayoutManager) == false) goto L38;
        LinearLayoutManager r113 = (LinearLayoutManager) r112;
    L39:
        if (r113 == null) goto L41;
        r113.scrollToPositionWithOffset(this.f337226v, -c7.b(12));
        goto L41
    L38:
        r113 = null;
        goto L39
    }

    public DoraHStreamlinedWakeupFragment() {
        this.f337219o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedWakeupFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedWakeupFragment$special$$inlined$activityViewModels$default$2(this));
        this.f337220p = new DoraHStreamlinedWakeupAdapter();
        this.f337222r = CollectionsKt.emptyList();
        this.f337223s = CollectionsKt.emptyList();
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        ma0().skipToInterrupt(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.E == false) goto L5;
        this.E = false;
    L6:
        ma0().stopTicker();
        this.f337228x = false;
        this.f337229y = false;
        this.f337230z = null;
        ka0(false);
        return;
    L5:
        ma0().unregisterVoiceCallback();
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        sa0();
        LarusDoraHSimplifiedWakeupBinding r100 = this.f337221q;
        if (r100 == null) goto L7;
        LinearLayout r101 = r100.f332696g;
        if (r101 == null) goto L7;
        r101.setTag(123400002, 0L);
    L7:
        TextView r102 = this.f336547h;
        if (r102 == null) goto L10;
        r102.setTag(123400002, 0L);
    L10:
        ma0().registerVoiceCallback();
        ma0().startTicker();
    }

    public static float ia0(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof RecyclerView.LayoutParams) == false) goto L5;
        RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r101;
    L6:
        int r103 = 0;
        if (r102 == null) goto L9;
        int r104 = ((ViewGroup.MarginLayoutParams) r102).topMargin;
    L10:
        if (r102 == null) goto L13;
        r103 = ((ViewGroup.MarginLayoutParams) r102).bottomMargin;
    L13:
        return (r100.getHeight() + r104) + r103;
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static String oa0(SimplifiedTopic r100) {
        int r101 = com.larus.utils.j0.f375426a;
        if (r100 == null) goto L6;
        String r102 = r100.getTitleKey();
        if (r102 == null) goto L6;
    L8:
        return com.larus.utils.j0.e(r102);
    L6:
        r102 = "";
        goto L8
    }

    public final b fa0(RecyclerView r110) {
        boolean r100 = true;
        if (this.f337223s.size() > 1) goto L5;
        return null;
    L5:
        RecyclerView.LayoutManager r101 = r110.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
    L9:
        if (r102 != null) goto L11;
        return null;
    L11:
        int r103 = r102.findFirstVisibleItemPosition();
        if (r103 != (-1)) goto L14;
        return null;
    L14:
        View r104 = r102.findViewByPosition(r103);
        if (r104 != null) goto L17;
        return null;
    L17:
        float r105 = ia0(r104);
        if (r105 > 0.0f) goto L20;
        return null;
    L20:
        float r111 = r110.getPaddingTop();
        if (r103 < this.f337226v) goto L25;
        r100 = false;
    L25:
        if (r100 == false) goto L27;
        float r112 = RangesKt.coerceIn(((r104.getTop() - r111) / r105) + 1.0f, 0.0f, 1.0f);
    L28:
        float r106 = r112;
        if (r100 == false) goto L31;
        int r107 = r103;
    L32:
        if (r100 == false) goto L34;
        int r113 = r107 - 1;
    L35:
        int r108 = r113;
        int r109 = r104.getTop();
        if (r100 == false) goto L38;
        ScrollDirection r114 = ScrollDirection.BACKWARD;
    L40:
        return new b(r103, r109, r105, r106, r107, r108, r114);
    L38:
        r114 = ScrollDirection.FORWARD;
        goto L40
    L34:
        r113 = r107 + 1;
        goto L35
    L31:
        r107 = r103 - 1;
        goto L32
    L27:
        r112 = RangesKt.coerceIn((r111 - r104.getTop()) / r105, 0.0f, 1.0f);
        goto L28
    L8:
        r102 = null;
        goto L9
    }

    public final void ka0(boolean r100) {
        ValueAnimator r101 = this.A;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.A = null;
        ValueAnimator r102 = this.B;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        this.B = null;
        ValueAnimator r103 = this.C;
        if (r103 == null) goto L11;
        r103.cancel();
    L11:
        this.C = null;
        this.f337227w = false;
        LarusDoraHSimplifiedWakeupBinding r104 = this.f337221q;
        if (r104 == null) goto L16;
        RecyclerView r105 = r104.f332694e;
        if (r105 == null) goto L16;
        r105.setTranslationY(0.0f);
    L16:
        if (r100 == false) goto L21;
        SimplifiedTopic r106 = na0(this.f337225u);
        if (r106 == null) goto L22;
        ta0(oa0(r106));
        return;
    L22:
        return;
    }

    public final SimplifiedTopic na0(int r100) {
        return (SimplifiedTopic) CollectionsKt.getOrNull(this.f337223s, r100);
    }

    public final void ta0(String r100) {
        LarusDoraHSimplifiedWakeupBinding r101 = this.f337221q;
        if (r101 != null) goto L5;
        return;
    L5:
        DoraTextView r102 = r101.f332699j;
        DoraTextView r103 = r101.f332700k;
        ImageView r104 = r101.f332695f;
        r102.setText(r100);
        r102.setTranslationY(0.0f);
        r102.setAlpha(1.0f);
        r103.setText("");
        r103.setTranslationY(0.0f);
        r103.setAlpha(0.0f);
        r103.setVisibility(4);
        ValueAnimator r105 = this.C;
        if (r105 == null) goto L8;
        r105.cancel();
    L8:
        r104.setTranslationX(0.0f);
        int r106 = ua0(r101.f332696g, r101.f332697h, r104);
        if (r106 <= 0) goto L21;
        LarusDoraHSimplifiedWakeupBinding r107 = this.f337221q;
        if (r107 == null) goto L16;
        DoraTextView r108 = r107.f332699j;
        if (r108 == null) goto L16;
        r108.setMaxWidth(r106);
    L16:
        LarusDoraHSimplifiedWakeupBinding r109 = this.f337221q;
        if (r109 == null) goto L21;
        DoraTextView r110 = r109.f332700k;
        if (r110 == null) goto L21;
        r110.setMaxWidth(r106);
    L21:
        int r111 = Math.max(pa0(r102, r106), r101.f332698i.getMinimumHeight());
        LarusDoraHSimplifiedWakeupBinding r112 = this.f337221q;
        if (r112 == null) goto L27;
        FrameLayout r113 = r112.f332698i;
        if (r113 == null) goto L27;
        int r114 = Math.max(r111, r113.getMinimumHeight());
        ViewGroup.LayoutParams r115 = r113.getLayoutParams();
        r115.height = r114;
        r113.setLayoutParams(r115);
    L27:
        LarusDoraHSimplifiedWakeupBinding r116 = this.f337221q;
        if (r116 == null) goto L34;
        LinearLayout r117 = r116.f332696g;
        if (r117 == null) goto L35;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        r118.width = -2;
        r117.setLayoutParams(r118);
        return;
    L35:
        return;
    }

    public static int pa0(DoraTextView r100, int r101) {
        if (r101 <= 0) goto L5;
        int r102 = View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE);
    L6:
        r100.measure(r102, View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredHeight();
    L5:
        r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L6
    }

    public static int qa0(DoraTextView r100, int r101) {
        if (r101 <= 0) goto L5;
        int r102 = View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE);
    L6:
        r100.measure(r102, View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredWidth();
    L5:
        r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L6
    }

    public final c ga0(String r110, String r111) {
        LarusDoraHSimplifiedWakeupBinding r100 = this.f337221q;
        if (r100 != null) goto L6;
        return null;
    L6:
        LinearLayout r101 = r100.f332696g;
        DoraSimplifiedGradientTextView r102 = r100.f332697h;
        DoraTextView r103 = r100.f332699j;
        DoraTextView r104 = r100.f332700k;
        ImageView r105 = r100.f332695f;
        int r106 = ua0(r101, r102, r105);
        if (r106 <= 0) goto L19;
        LarusDoraHSimplifiedWakeupBinding r107 = this.f337221q;
        if (r107 == null) goto L14;
        DoraTextView r108 = r107.f332699j;
        if (r108 == null) goto L14;
        r108.setMaxWidth(r106);
    L14:
        LarusDoraHSimplifiedWakeupBinding r109 = this.f337221q;
        if (r109 == null) goto L19;
        DoraTextView r112 = r109.f332700k;
        if (r112 == null) goto L19;
        r112.setMaxWidth(r106);
    L19:
        r103.setText(r110);
        r104.setText(r111);
        int r113 = Math.max(pa0(r103, r106), r100.f332698i.getMinimumHeight());
        int r114 = Math.max(pa0(r104, r106), r100.f332698i.getMinimumHeight());
        int r115 = qa0(r103, r106);
        int r116 = qa0(r104, r106);
        int r117 = ja0(r102, r103, r105, r101, r106);
        int r118 = ja0(r102, r104, r105, r101, r106);
        float r119 = ha0(r101, r102, r115, r105);
        float r120 = ha0(r101, r102, r116, r105);
        LarusDoraHSimplifiedWakeupBinding r121 = this.f337221q;
        if (r121 == null) goto L26;
        FrameLayout r122 = r121.f332698i;
        if (r122 == null) goto L26;
        int r123 = Math.max(r113, r122.getMinimumHeight());
        ViewGroup.LayoutParams r124 = r122.getLayoutParams();
        r124.height = r123;
        r122.setLayoutParams(r124);
    L26:
        return new c(r113, r114, r117, r118, r119, r120);
    }

    public final void la0(int r100, boolean r101) {
        LarusDoraHSimplifiedWakeupBinding r102 = this.f337221q;
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = 0;
        int r104 = RangesKt.coerceIn(r100, 0, CollectionsKt.getLastIndex(this.f337223s));
        this.f337225u = r104;
        if (this.f337222r.isEmpty() == true) goto L9;
        int r105 = this.f337222r.size();
        int r106 = r104 % r105;
        r103 = r106 + (r105 & (((r106 ^ r105) & ((-r106) | r106)) >> 31));
    L9:
        this.f337224t = r103;
        if (this.f337222r.size() <= 1) goto L12;
        int r107 = RangesKt.coerceAtMost(r104 + 1, CollectionsKt.getLastIndex(this.f337223s));
    L13:
        this.f337226v = r107;
        r102.f332694e.setTranslationY(0.0f);
        if (r101 == false) goto L21;
        this.f337220p.y2(this.f337223s);
        RecyclerView.LayoutManager r108 = r102.f332694e.getLayoutManager();
        if ((r108 instanceof LinearLayoutManager) == false) goto L18;
        LinearLayoutManager r109 = (LinearLayoutManager) r108;
    L19:
        if (r109 == null) goto L21;
        r109.scrollToPositionWithOffset(this.f337226v, -c7.b(12));
        goto L21
    L18:
        r109 = null;
    L21:
        ta0(oa0(na0(r104)));
        return;
    L12:
        r107 = r104;
        goto L13
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        LarusDoraHSimplifiedWakeupBinding r100 = this.f337221q;
        if (r100 == null) goto L7;
        LinearLayout r101 = r100.f332696g;
        if (r101 == null) goto L7;
        ViewCompat.setTransitionName(r101, "dora_h_simplified_interrupt_card");
    L7:
        LarusDoraHSimplifiedWakeupBinding r102 = this.f337221q;
        if (r102 == null) goto L12;
        RecyclerView r103 = r102.f332694e;
        if (r103 == null) goto L12;
        r103.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
    L12:
        LarusDoraHSimplifiedWakeupBinding r104 = this.f337221q;
        if (r104 == null) goto L17;
        RecyclerView r105 = r104.f332694e;
        if (r105 == null) goto L17;
        r105.setAdapter(this.f337220p);
    L17:
        LarusDoraHSimplifiedWakeupBinding r106 = this.f337221q;
        if (r106 == null) goto L22;
        RecyclerView r107 = r106.f332694e;
        if (r107 == null) goto L22;
        r107.setItemAnimator(null);
    L22:
        LarusDoraHSimplifiedWakeupBinding r108 = this.f337221q;
        if (r108 == null) goto L27;
        RecyclerView r109 = r108.f332694e;
        if (r109 == null) goto L27;
        r109.addOnScrollListener(new DoraHStreamlinedWakeupFragment$setupRecyclerViewScrollListener$1(this));
    L27:
        Lifecycle.State r110 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedWakeupFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r110, null, this), 3, null);
        LarusDoraHSimplifiedWakeupBinding r111 = this.f337221q;
        if (r111 == null) goto L32;
        LinearLayout r112 = r111.f332696g;
        if (r112 == null) goto L32;
        e1.d(r112, new a0(this));
    L32:
        TextView r113 = this.f336547h;
        if (r113 == null) goto L35;
        e1.x(r113);
        int r114 = com.larus.utils.j0.f375426a;
        r113.setText(com.larus.utils.j0.d(R.string.larus_dora_btn_continue_cn));
        e1.d(r113, new b0(this));
    L35:
        ma0().fetchAvatarUrl();
        DoraExternalOnboardingViewModel.enterOnboardingMode$default(ca0(), false, 1, null);
        DoraExternalOnboardingViewModel.enterVoiceOnlyMode$default(ca0(), false, 1, null);
        ma0().stopTTS("InitWakeFragment");
        DoraHStreamlinedOnboardingViewModel r115 = ma0();
        int r116 = com.larus.utils.j0.f375426a;
        r115.playTTS(com.larus.utils.j0.d(R.string.larus_dora_onboarding_wake_tts_cn));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_dora_h_simplified_wakeup, r111, false);
        int r101 = R.id.dora_onboarding_avatar;
        CircleSimpleDraweeView r102 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_avatar);
        if (r102 == null) goto L41;
        ConstraintLayout r103 = (ConstraintLayout) r100;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_recycler_container);
        if (r104 == null) goto L38;
        View r105 = ViewBindings.findChildViewById(r100, R.id.dora_onboarding_recycler_mask);
        if (r105 == null) goto L37;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_recycler_view);
        if (r106 == null) goto L36;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_selected_arrow);
        if (r107 == null) goto L35;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_selected_container);
        if (r113 == null) goto L34;
        DoraSimplifiedGradientTextView r114 = (DoraSimplifiedGradientTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_selected_prefix);
        if (r114 == null) goto L33;
        FrameLayout r115 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_selected_suffix_container);
        if (r115 == null) goto L32;
        DoraTextView r116 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_selected_suffix_current);
        if (r116 == null) goto L31;
        DoraTextView r117 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_selected_suffix_next);
        if (r117 == null) goto L30;
        FrameLayout r118 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_top_container);
        if (r118 != null) goto L25;
        r101 = R.id.dora_onboarding_top_container;
        goto L41
    L25:
        if (((DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_wakeup_title)) == null) goto L28;
        this.f337221q = new LarusDoraHSimplifiedWakeupBinding(r103, r102, r104, r105, r106, r107, r113, r114, r115, r116, r117, r118);
        return r103;
    L28:
        r101 = R.id.dora_onboarding_wakeup_title;
        goto L41
    L30:
        r101 = R.id.dora_onboarding_selected_suffix_next;
        goto L41
    L31:
        r101 = R.id.dora_onboarding_selected_suffix_current;
        goto L41
    L32:
        r101 = R.id.dora_onboarding_selected_suffix_container;
        goto L41
    L33:
        r101 = R.id.dora_onboarding_selected_prefix;
        goto L41
    L34:
        r101 = R.id.dora_onboarding_selected_container;
        goto L41
    L35:
        r101 = R.id.dora_onboarding_selected_arrow;
        goto L41
    L36:
        r101 = R.id.dora_onboarding_recycler_view;
        goto L41
    L37:
        r101 = R.id.dora_onboarding_recycler_mask;
        goto L41
    L38:
        r101 = R.id.dora_onboarding_recycler_container;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final int ua0(View r100, DoraSimplifiedGradientTextView r101, View r110) {
        Object r102 = r100.getParent();
        ViewGroup.MarginLayoutParams r103 = null;
        if ((r102 instanceof View) == false) goto L5;
        View r104 = (View) r102;
    L7:
        if (r104 == null) goto L9;
        int r105 = r104.getWidth();
    L15:
        if (r105 > 0) goto L17;
        return 0;
    L17:
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L21:
        Integer r108 = Integer.valueOf(r101.getMeasuredWidth());
        boolean r109 = true;
        if (r108.intValue() <= 0) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L30;
        int r112 = r108.intValue();
    L31:
        Integer r113 = Integer.valueOf(r110.getMeasuredWidth());
        if (r113.intValue() > 0) goto L35;
        r109 = false;
    L35:
        if (r109 == true) goto L38;
        r113 = null;
    L38:
        if (r113 == null) goto L40;
        int r114 = r113.intValue();
    L41:
        ViewGroup.LayoutParams r115 = r110.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        r103 = (ViewGroup.MarginLayoutParams) r115;
    L44:
        if (r103 == null) goto L46;
        int r116 = r103.getMarginStart();
    L47:
        if (r107 == null) goto L49;
        int r117 = r107.getMarginStart();
    L50:
        if (r107 == null) goto L52;
        int r118 = r107.getMarginEnd();
    L54:
        return RangesKt.coerceAtLeast(r105 - ((((((r117 + r118) + r100.getPaddingStart()) + r100.getPaddingEnd()) + r112) + r114) + r116), 0);
    L52:
        r118 = 0;
        goto L54
    L49:
        r117 = 0;
        goto L50
    L46:
        r116 = 0;
        goto L47
    L40:
        r114 = r110.getWidth();
        goto L41
    L30:
        r112 = r101.getWidth();
        goto L31
    L24:
        r111 = false;
        goto L25
    L20:
        r107 = null;
        goto L21
    L9:
        LarusDoraHSimplifiedWakeupBinding r119 = this.f337221q;
        if (r119 == null) goto L14;
        ConstraintLayout r120 = r119.f332690a;
        if (r120 == null) goto L14;
        r105 = r120.getWidth();
    L14:
        r105 = 0;
        goto L15
    L5:
        r104 = null;
        goto L7
    }

    public static float ha0(View r100, DoraSimplifiedGradientTextView r101, int r102, View r103) {
        Integer r104 = Integer.valueOf(r101.getMeasuredWidth());
        int r105 = 0;
        if (r104.intValue() <= 0) goto L5;
        boolean r106 = true;
    L6:
        ViewGroup.MarginLayoutParams r107 = null;
        if (r106 == true) goto L10;
        r104 = null;
    L10:
        if (r104 == null) goto L12;
        int r108 = r104.intValue();
    L13:
        ViewGroup.LayoutParams r109 = r103.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r107 = (ViewGroup.MarginLayoutParams) r109;
    L16:
        if (r107 == null) goto L19;
        r105 = r107.getMarginStart();
    L19:
        return ((r100.getPaddingStart() + r108) + r102) + r105;
    L12:
        r108 = r101.getWidth();
        goto L13
    L5:
        r106 = false;
        goto L6
    }

    public static int ja0(DoraSimplifiedGradientTextView r100, DoraTextView r101, View r102, View r103, int r104) {
        Integer r105 = Integer.valueOf(r100.getMeasuredWidth());
        boolean r106 = true;
        int r107 = 0;
        if (r105.intValue() <= 0) goto L5;
        boolean r108 = true;
    L6:
        ViewGroup.MarginLayoutParams r109 = null;
        if (r108 == true) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L12;
        int r110 = r105.intValue();
    L13:
        int r111 = qa0(r101, r104);
        Integer r112 = Integer.valueOf(r102.getMeasuredWidth());
        if (r112.intValue() > 0) goto L17;
        r106 = false;
    L17:
        if (r106 == true) goto L20;
        r112 = null;
    L20:
        if (r112 == null) goto L22;
        int r113 = r112.intValue();
    L23:
        ViewGroup.LayoutParams r114 = r102.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r109 = (ViewGroup.MarginLayoutParams) r114;
    L26:
        if (r109 == null) goto L29;
        r107 = r109.getMarginStart();
    L29:
        return (((r110 + r111) + r113) + r107) + (r103.getPaddingStart() + r103.getPaddingEnd());
    L22:
        r113 = r102.getWidth();
        goto L23
    L12:
        r110 = r100.getWidth();
        goto L13
    L5:
        r108 = false;
        goto L6
    }

    public final void ra0(String r100, String r101, float r102, float r103, c r104, ScrollDirection r105) {
        LarusDoraHSimplifiedWakeupBinding r106 = this.f337221q;
        if (r106 == null) goto L41;
        DoraTextView r107 = r106.f332699j;
        if (r107 == null) goto L44;
        if (r106 == null) goto L42;
        DoraTextView r108 = r106.f332700k;
        if (r108 == null) goto L45;
        r107.setText(r100);
        r108.setText(r101);
        r108.setVisibility(0);
        int r109 = d.f337246a[r105.ordinal()];
        if (r109 != 1) goto L14;
        r107.setTranslationY((-r103) * r102);
        r108.setTranslationY(r103 * (1.0f - r102));
    L19:
        r107.setAlpha(1.0f - r102);
        r108.setAlpha(r102);
        int r110 = r104.f337240a;
        int r111 = r104.f337241b;
        LarusDoraHSimplifiedWakeupBinding r112 = this.f337221q;
        if (r112 == null) goto L25;
        FrameLayout r113 = r112.f332698i;
        if (r113 == null) goto L25;
        int r114 = (int) (r110 + ((r111 - r110) * r102));
        ViewGroup.LayoutParams r115 = r113.getLayoutParams();
        r115.height = RangesKt.coerceAtLeast(r114, r113.getMinimumHeight());
        r113.setLayoutParams(r115);
    L25:
        int r116 = r104.f337242c;
        int r117 = r104.f337243d;
        LarusDoraHSimplifiedWakeupBinding r118 = this.f337221q;
        if (r118 == null) goto L34;
        LinearLayout r119 = r118.f332696g;
        if (r119 == null) goto L34;
        if (r116 <= 0) goto L34;
        if (r117 <= 0) goto L34;
        int r120 = (int) (r116 + ((r117 - r116) * r102));
        ViewGroup.LayoutParams r121 = r119.getLayoutParams();
        r121.width = r120;
        r119.setLayoutParams(r121);
    L34:
        float r122 = r104.f337244e;
        float r123 = r104.f337245f;
        LarusDoraHSimplifiedWakeupBinding r124 = this.f337221q;
        if (r124 == null) goto L43;
        ImageView r125 = r124.f332695f;
        if (r125 == null) goto L46;
        r125.setTranslationX((r122 + ((r123 - r122) * r102)) - r125.getLeft());
        return;
    L46:
        return;
    L43:
        return;
    L14:
        if (r109 != 2) goto L17;
        r107.setTranslationY(r103 * r102);
        r108.setTranslationY((-r103) * (1.0f - r102));
        goto L19
    L17:
        throw new NoWhenBranchMatchedException();
    L45:
        return;
    L42:
        return;
    L44:
        return;
    }
}
