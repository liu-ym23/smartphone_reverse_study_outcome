package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Dialog;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004~\u007f\u0080\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00162\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010;\u001a\u0002072\u0006\u00108\u001a\u00020\bH\u0007J\u0015\u0010<\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0000¢\u0006\u0002\b=J\u001b\u0010>\u001a\u0002072\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0000¢\u0006\u0002\b@J\u0015\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u0005H\u0000¢\u0006\u0002\bCJ\u0012\u0010D\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010F\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010G\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00162\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010J\u001a\u0002072\u0006\u0010I\u001a\u00020\u000bH\u0007J\u001e\u0010K\u001a\u0002072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010L\u001a\u00020\u0011H\u0007J5\u0010K\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010L\u001a\u00020\u00112\u0014\u0010M\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00110\u001dH\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020\u0016H\u0007J\u001e\u0010P\u001a\u0002072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010L\u001a\u00020\u0011H\u0007J\u0010\u0010Q\u001a\u0002072\u0006\u00109\u001a\u00020\u0016H\u0007J\u0010\u0010R\u001a\u0002072\u0006\u0010:\u001a\u00020\u0013H\u0007J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\u0016\u0010V\u001a\u0002072\f\u0010W\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\b\u0010X\u001a\u00020\u0016H\u0002J\u0012\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u00109\u001a\u00020\u0016H\u0002J\u001a\u0010Z\u001a\u00020\u00112\u0006\u0010[\u001a\u00020\t2\b\u0010\\\u001a\u0004\u0018\u00010\u0013H\u0002J!\u0010]\u001a\u0004\u0018\u00010\u00172\u0006\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b^J9\u0010_\u001a\u0004\u0018\u00010\u00172\u0006\u00109\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\beJ\u0017\u0010f\u001a\u0004\u0018\u00010\u00172\u0006\u00108\u001a\u00020\bH\u0000¢\u0006\u0002\bgJ\u0017\u0010h\u001a\u0004\u0018\u00010\u00172\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\biJ,\u0010j\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00112\b\u0010k\u001a\u0004\u0018\u00010\u00172\b\u0010l\u001a\u0004\u0018\u00010\u0017H\u0002J*\u0010m\u001a\u00020\u00172\u0006\u0010l\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00162\b\u0010d\u001a\u0004\u0018\u00010\u00172\u0006\u0010k\u001a\u00020\u0017H\u0002J$\u0010n\u001a\u0002072\u0006\u00109\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010p\u001a\u00020qH\u0002J\u001c\u0010r\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010s\u001a\u0002072\u0006\u00108\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0005H\u0002J\b\u0010t\u001a\u000207H\u0002J\f\u0010u\u001a\u00020\u0005*\u00020\u0013H\u0002J\u0017\u0010v\u001a\u0004\u0018\u00010\u00172\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0002\bxJ\u0017\u0010y\u001a\u0004\u0018\u00010\u00172\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0002\bzJ\u0017\u0010{\u001a\u0004\u0018\u00010-2\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0002\b|J\u000e\u0010}\u001a\u0004\u0018\u00010\u0017*\u00020&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R(\u0010%\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R(\u0010,\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010-0\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\"\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001701X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006\u0081\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker;", "", "<init>", "()V", "TAG", "", "dialogSources", "Ljava/util/WeakHashMap;", "Landroid/app/Dialog;", "Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$TrackedOverlay;", "popupSources", "Landroid/widget/PopupWindow;", "dialogFragmentsByDialog", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/DialogFragment;", "retainedWindowDialogs", "windowVisible", "", "activityVisibleStates", "Landroidx/fragment/app/FragmentActivity;", "inputControlRectResolver", "Lkotlin/Function2;", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "Landroid/graphics/Rect;", "getInputControlRectResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function2;", "setInputControlRectResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function2;)V", "dialogVisibleRectResolver", "Lkotlin/Function1;", "getDialogVisibleRectResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setDialogVisibleRectResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "popupVisibleRectResolver", "getPopupVisibleRectResolver$impl_mainlandRelease", "setPopupVisibleRectResolver$impl_mainlandRelease", "viewVisibleRectResolver", "Landroid/view/View;", "getViewVisibleRectResolver$impl_mainlandRelease", "setViewVisibleRectResolver$impl_mainlandRelease", "popupViewLocalVisibleRectResolver", "getPopupViewLocalVisibleRectResolver$impl_mainlandRelease", "setPopupViewLocalVisibleRectResolver$impl_mainlandRelease", "viewLocationOnScreenResolver", "", "getViewLocationOnScreenResolver$impl_mainlandRelease", "setViewLocationOnScreenResolver$impl_mainlandRelease", "windowVisibleBoundsResolver", "Lkotlin/Function0;", "getWindowVisibleBoundsResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setWindowVisibleBoundsResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "onDialogShow", "", "dialog", "source", "activity", "onDialogDismiss", "retainActiveWindowDialog", "retainActiveWindowDialog$impl_mainlandRelease", "releaseWindowDialog", "dialogRef", "releaseWindowDialog$impl_mainlandRelease", "dismissRetainedWindowDialogs", "reason", "dismissRetainedWindowDialogs$impl_mainlandRelease", "bindDialogFragment", WidgetService.PARAM_FRAGMENT, "onDialogShowBlocked", "onDialogFragmentDismissed", "onPopupShow", "popupWindow", "onPopupDismiss", "dismissAllTrackedDialogs", "dismissOverlappedOnly", "shouldDismissFragment", "dismissAllTrackedDialogs$impl_mainlandRelease", "clearTrackedDialogs", "dismissAllTrackedPopupWindows", "clearTrackedPopupWindows", "clearTrackedOverlays", "computeVisibilityEventsLocked", "", "Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$VisibilityEvent;", "dispatchEvents", "events", "defaultDismissSource", "dismissActivityIfNeeded", "matchesDismissTargetActivity", "trackedOverlay", "dismissActivity", "resolveInputControlRect", "resolveInputControlRect$impl_mainlandRelease", "buildInputDismissRect", "inputVisibleRect", "inputViewHeight", "", "orientation", "windowBounds", "buildInputDismissRect$impl_mainlandRelease", "resolveDialogVisibleRect", "resolveDialogVisibleRect$impl_mainlandRelease", "resolvePopupVisibleRect", "resolvePopupVisibleRect$impl_mainlandRelease", "shouldDismissOverlay", "inputControlRect", "rawOverlayVisibleRect", "normalizeWindowOverlayRect", "dispatchVisibleChanged", "visible", "currentCounts", "Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$Counts;", "createTrackedOverlay", "clearDialogFragmentBinding", "pruneStaleActivityOverlaysLocked", "activityIdentity", "resolveViewVisibleRect", "view", "resolveViewVisibleRect$impl_mainlandRelease", "resolveViewLocalVisibleRect", "resolveViewLocalVisibleRect$impl_mainlandRelease", "resolveViewLocationOnScreen", "resolveViewLocationOnScreen$impl_mainlandRelease", "visibleRectOrNull", "TrackedOverlay", "VisibilityEvent", "Counts", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupOrDialogVisibilityTracker {
    public static final PopupOrDialogVisibilityTracker INSTANCE = null;
    private static final String TAG = "PopupOrDialogTracker";
    private static final WeakHashMap<FragmentActivity, Boolean> activityVisibleStates = null;
    private static final WeakHashMap<Dialog, WeakReference<DialogFragment>> dialogFragmentsByDialog = null;
    private static final WeakHashMap<Dialog, TrackedOverlay> dialogSources = null;
    private static Function1<? super Dialog, Rect> dialogVisibleRectResolver;
    private static Function2<? super OverlaySource, ? super FragmentActivity, Rect> inputControlRectResolver;
    private static final WeakHashMap<PopupWindow, TrackedOverlay> popupSources = null;
    private static Function1<? super View, Rect> popupViewLocalVisibleRectResolver;
    private static Function1<? super PopupWindow, Rect> popupVisibleRectResolver;
    private static final WeakHashMap<Dialog, WeakReference<Dialog>> retainedWindowDialogs = null;
    private static Function1<? super View, int[]> viewLocationOnScreenResolver;
    private static Function1<? super View, Rect> viewVisibleRectResolver;
    private static boolean windowVisible;
    private static Function0<Rect> windowVisibleBoundsResolver;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$Counts;", "", "windowCount", "", "activityOverlayCount", "activityVisibleSize", "dialogSize", "popupSize", "<init>", "(IIIII)V", "getWindowCount", "()I", "getActivityOverlayCount", "getActivityVisibleSize", "getDialogSize", "getPopupSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Counts {
        private final int activityOverlayCount;
        private final int activityVisibleSize;
        private final int dialogSize;
        private final int popupSize;
        private final int windowCount;

        public static /* synthetic */ Counts copy$default(Counts r100, int r101, int r102, int r103, int r104, int r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.windowCount;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.activityOverlayCount;
        L8:
            int r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.activityVisibleSize;
        L11:
            int r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.dialogSize;
        L14:
            int r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.popupSize;
        L17:
            int r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final int component1() {
            return this.windowCount;
        }

        public final int component2() {
            return this.activityOverlayCount;
        }

        public final int component3() {
            return this.activityVisibleSize;
        }

        public final int component4() {
            return this.dialogSize;
        }

        public final int component5() {
            return this.popupSize;
        }

        public final Counts copy(int r100, int r101, int r110, int r111, int r112) {
            return new Counts(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Counts) == true) goto L8;
            return false;
        L8:
            Counts r101 = (Counts) r100;
            if (this.windowCount == r101.windowCount) goto L12;
            return false;
        L12:
            if (this.activityOverlayCount == r101.activityOverlayCount) goto L15;
            return false;
        L15:
            if (this.activityVisibleSize == r101.activityVisibleSize) goto L18;
            return false;
        L18:
            if (this.dialogSize == r101.dialogSize) goto L21;
            return false;
        L21:
            if (this.popupSize == r101.popupSize) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.windowCount * 31) + this.activityOverlayCount) * 31) + this.activityVisibleSize) * 31) + this.dialogSize) * 31) + this.popupSize;
        }

        public String toString() {
            return "Counts(windowCount=" + this.windowCount + ", activityOverlayCount=" + this.activityOverlayCount + ", activityVisibleSize=" + this.activityVisibleSize + ", dialogSize=" + this.dialogSize + ", popupSize=" + this.popupSize + ')';
        }

        public final int getActivityOverlayCount() {
            return this.activityOverlayCount;
        }

        public final int getActivityVisibleSize() {
            return this.activityVisibleSize;
        }

        public final int getDialogSize() {
            return this.dialogSize;
        }

        public final int getPopupSize() {
            return this.popupSize;
        }

        public final int getWindowCount() {
            return this.windowCount;
        }

        public Counts(int r100, int r101, int r102, int r103, int r104) {
            this.windowCount = r100;
            this.activityOverlayCount = r101;
            this.activityVisibleSize = r102;
            this.dialogSize = r103;
            this.popupSize = r104;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÂ\u0003J%\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$TrackedOverlay;", "", "source", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;Ljava/lang/ref/WeakReference;)V", "getSource", "()Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "activity", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TrackedOverlay {
        private final WeakReference<FragmentActivity> activityRef;
        private final OverlaySource source;

        private final WeakReference<FragmentActivity> component2() {
            return this.activityRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TrackedOverlay copy$default(TrackedOverlay r100, OverlaySource r101, WeakReference r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.source;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.activityRef;
        L9:
            return r100.copy(r101, r102);
        }

        public final OverlaySource component1() {
            return this.source;
        }

        public final TrackedOverlay copy(OverlaySource r100, WeakReference<FragmentActivity> r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new TrackedOverlay(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TrackedOverlay) == true) goto L8;
            return false;
        L8:
            TrackedOverlay r101 = (TrackedOverlay) r100;
            if (this.source == r101.source) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.activityRef, r101.activityRef) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.source.hashCode() * 31;
            WeakReference<FragmentActivity> r101 = this.activityRef;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "TrackedOverlay(source=" + this.source + ", activityRef=" + this.activityRef + ')';
        }

        public final FragmentActivity getActivity() {
            WeakReference<FragmentActivity> r100 = this.activityRef;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get();
        }

        public final OverlaySource getSource() {
            return this.source;
        }

        public TrackedOverlay(OverlaySource r100, WeakReference<FragmentActivity> r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.source = r100;
            this.activityRef = r101;
        }

        public /* synthetic */ TrackedOverlay(OverlaySource r100, WeakReference r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$VisibilityEvent;", "", "source", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "visible", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;ZLandroidx/fragment/app/FragmentActivity;)V", "getSource", "()Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "getVisible", "()Z", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VisibilityEvent {
        private final FragmentActivity activity;
        private final OverlaySource source;
        private final boolean visible;

        public static /* synthetic */ VisibilityEvent copy$default(VisibilityEvent r100, OverlaySource r101, boolean r102, FragmentActivity r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.source;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.visible;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.activity;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final OverlaySource component1() {
            return this.source;
        }

        public final boolean component2() {
            return this.visible;
        }

        public final FragmentActivity component3() {
            return this.activity;
        }

        public final VisibilityEvent copy(OverlaySource r100, boolean r101, FragmentActivity r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new VisibilityEvent(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof VisibilityEvent) == true) goto L8;
            return false;
        L8:
            VisibilityEvent r101 = (VisibilityEvent) r100;
            if (this.source == r101.source) goto L12;
            return false;
        L12:
            if (this.visible == r101.visible) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.activity, r101.activity) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.source.hashCode() * 31;
            if (this.visible == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            FragmentActivity r103 = this.activity;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "VisibilityEvent(source=" + this.source + ", visible=" + this.visible + ", activity=" + this.activity + ')';
        }

        public final FragmentActivity getActivity() {
            return this.activity;
        }

        public final OverlaySource getSource() {
            return this.source;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public VisibilityEvent(OverlaySource r100, boolean r101, FragmentActivity r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.source = r100;
            this.visible = r101;
            this.activity = r102;
        }

        public /* synthetic */ VisibilityEvent(OverlaySource r100, boolean r101, FragmentActivity r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[OverlaySource.values().length];
            r100[OverlaySource.WINDOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OverlaySource.ACTIVITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private PopupOrDialogVisibilityTracker() {
    }

    public static /* synthetic */ boolean a(OverlaySource r100, Map.Entry r101) {
        return clearTrackedPopupWindows$lambda$40$lambda$39(r100, r101);
    }

    public static /* synthetic */ boolean b(Map.Entry r100) {
        return pruneStaleActivityOverlaysLocked$lambda$59(r100);
    }

    public static /* synthetic */ boolean c(FragmentActivity r100, Map.Entry r101) {
        return clearTrackedOverlays$lambda$43$lambda$42(r100, r101);
    }

    private final Counts currentCounts() {
        monitor-enter(this);
        INSTANCE.pruneStaleActivityOverlaysLocked();     // Catch: Throwable -> L14
        Ref.IntRef r100 = new Ref.IntRef();     // Catch: Throwable -> L14
        Ref.IntRef r101 = new Ref.IntRef();     // Catch: Throwable -> L14
        LinkedHashSet r102 = new LinkedHashSet();     // Catch: Throwable -> L14
        Iterator<T> r103 = dialogSources.values().iterator();     // Catch: Throwable -> L14
    L5:
        if (r103.hasNext() == false) goto L7;
        currentCounts$lambda$55$recordOverlay$52(r100, r101, r102, (TrackedOverlay) r103.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<T> r104 = popupSources.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r104.hasNext() == false) goto L11;
        currentCounts$lambda$55$recordOverlay$52(r100, r101, r102, (TrackedOverlay) r104.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        Counts r105 = new Counts(r100.element, r101.element, r102.size(), dialogSources.size(), popupSources.size());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r105;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void d(DialogFragment r100, Dialog r101) {
        onDialogShowBlocked$lambda$18(r100, r101);
    }

    private static final boolean dismissAllTrackedDialogs$lambda$24(DialogFragment r100) {
        return true;
    }

    public static /* synthetic */ boolean e(DialogFragment r100, Map.Entry r101) {
        return bindDialogFragment$lambda$16$lambda$15(r100, r101);
    }

    public static /* synthetic */ boolean f(DialogFragment r100) {
        return dismissAllTrackedDialogs$lambda$24(r100);
    }

    public static /* synthetic */ boolean g(DialogFragment r100, Map.Entry r101) {
        return onDialogFragmentDismissed$lambda$20$lambda$19(r100, r101);
    }

    public static /* synthetic */ boolean h(FragmentActivity r100, Map.Entry r101) {
        return clearTrackedOverlays$lambda$43$lambda$41(r100, r101);
    }

    public static /* synthetic */ boolean i(OverlaySource r100, Map.Entry r101) {
        return clearTrackedDialogs$lambda$32$lambda$31(r100, r101);
    }

    public static /* synthetic */ boolean j(Map.Entry r100) {
        return pruneStaleActivityOverlaysLocked$lambda$58(r100);
    }

    public static /* synthetic */ Rect k() {
        return windowVisibleBoundsResolver$lambda$0();
    }

    public final WeakReference<Dialog> retainActiveWindowDialog$impl_mainlandRelease() {
        monitor-enter(this);
        WeakHashMap<Dialog, TrackedOverlay> r100 = dialogSources;     // Catch: Throwable -> L41
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L41
        Iterator<Map.Entry<Dialog, TrackedOverlay>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L41
    L4:
        String r103 = null;
        Dialog r104 = null;
        if (r102.hasNext() == false) goto L28;
        Map.Entry<Dialog, TrackedOverlay> r105 = r102.next();     // Catch: Throwable -> L41
        Dialog r106 = r105.getKey();     // Catch: Throwable -> L41
        TrackedOverlay r107 = r105.getValue();     // Catch: Throwable -> L41
        WeakReference<DialogFragment> r108 = dialogFragmentsByDialog.get(r106);     // Catch: Throwable -> L41
        if (r108 == null) goto L9;
        DialogFragment r109 = r108.get();     // Catch: Throwable -> L41
    L10:
        boolean r110 = false;
        if (r107.getSource() == OverlaySource.WINDOW) goto L13;
    L24:
        if (r110 == false) goto L26;
        r104 = r106;
    L26:
        if (r104 == null) goto L4;
        r101.add(r104);     // Catch: Throwable -> L41
        goto L4
    L13:
        if (r106.isShowing() == false) goto L24;
        if (r109 != null) goto L17;
    L19:
        boolean r111 = false;
    L20:
        if (r111 == false) goto L24;
        if (r109.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L24;
        r110 = true;
        goto L24
    L17:
        if (r109.isAdded() != true) goto L19;
        r111 = true;
        goto L20
    L9:
        r109 = null;
        goto L10
    L28:
        int r112 = r101.size();     // Catch: Throwable -> L41
        Dialog r113 = (Dialog) CollectionsKt.singleOrNull(r101);     // Catch: Throwable -> L41
        if (r113 != null) goto L31;
        Pair r114 = null;
    L32:
        monitor-exit(this);
        if (r114 != null) goto L36;
        FLogger.f375446a.i(TAG, "retainWindowDialog skipped candidateCount=" + r112);
        return null;
    L36:
        dispatchEvents((List) r114.getSecond());
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("retainWindowDialog dialog=");
        Dialog r117 = (Dialog) ((WeakReference) r114.getFirst()).get();
        if (r117 == null) goto L39;
        r103 = r117.getClass().getName();
    L39:
        r116.append(r103);
        r115.i(TAG, r116.toString());
        return (WeakReference) r114.getFirst();
    L31:
        WeakReference<Dialog> r118 = new WeakReference(r113);     // Catch: Throwable -> L41
        retainedWindowDialogs.put(r113, r118);     // Catch: Throwable -> L41
        dialogSources.remove(r113);     // Catch: Throwable -> L41
        r114 = TuplesKt.to(r118, INSTANCE.computeVisibilityEventsLocked());     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    static {
        PopupOrDialogVisibilityTracker r100 = new PopupOrDialogVisibilityTracker();
        INSTANCE = r100;
        dialogSources = new WeakHashMap();
        popupSources = new WeakHashMap();
        dialogFragmentsByDialog = new WeakHashMap();
        retainedWindowDialogs = new WeakHashMap();
        activityVisibleStates = new WeakHashMap();
        inputControlRectResolver = new PopupOrDialogVisibilityTracker$inputControlRectResolver$1(r100);
        dialogVisibleRectResolver = new PopupOrDialogVisibilityTracker$dialogVisibleRectResolver$1(r100);
        popupVisibleRectResolver = new PopupOrDialogVisibilityTracker$popupVisibleRectResolver$1(r100);
        viewVisibleRectResolver = new PopupOrDialogVisibilityTracker$viewVisibleRectResolver$1(r100);
        popupViewLocalVisibleRectResolver = new PopupOrDialogVisibilityTracker$popupViewLocalVisibleRectResolver$1(r100);
        viewLocationOnScreenResolver = new PopupOrDialogVisibilityTracker$viewLocationOnScreenResolver$1(r100);
        windowVisibleBoundsResolver = new f();
    }

    private final OverlaySource defaultDismissSource() {
        if (WindowHost.INSTANCE.isShowing() == false) goto L6;
        return OverlaySource.WINDOW;
    L6:
        return OverlaySource.ACTIVITY;
    }

    private final void pruneStaleActivityOverlaysLocked() {
        CollectionsKt.removeAll(dialogSources.entrySet(), new h());
        CollectionsKt.removeAll(popupSources.entrySet(), new i());
    }

    private static final Rect windowVisibleBoundsResolver$lambda$0() {
        return WindowHost.INSTANCE.getWindowVisibleBounds$impl_mainlandRelease();
    }

    private final List<VisibilityEvent> computeVisibilityEventsLocked() {
        pruneStaleActivityOverlaysLocked();
        Ref.IntRef r100 = new Ref.IntRef();
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = dialogSources.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        computeVisibilityEventsLocked$recordOverlay(r100, r101, (TrackedOverlay) r102.next());
        goto L4
    L6:
        Iterator<T> r103 = popupSources.values().iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        computeVisibilityEventsLocked$recordOverlay(r100, r101, (TrackedOverlay) r103.next());
        goto L8
    L11:
        if (r100.element <= 0) goto L13;
        boolean r104 = true;
    L14:
        int r105 = r101.size();
        WeakHashMap<FragmentActivity, Boolean> r110 = activityVisibleStates;
        ArrayList r106 = new ArrayList((r105 + r110.size()) + 1);
        if (r104 == windowVisible) goto L17;
        windowVisible = r104;
        r106.add(new VisibilityEvent(OverlaySource.WINDOW, r104, null, 4, null));
    L17:
        Iterator r107 = CollectionsKt.toList(r110.keySet()).iterator();
    L19:
        if (r107.hasNext() == false) goto L23;
        FragmentActivity r108 = (FragmentActivity) r107.next();
        if (r101.containsKey(r108) == true) goto L19;
        activityVisibleStates.remove(r108);
        r106.add(new VisibilityEvent(OverlaySource.ACTIVITY, false, r108));
        goto L19
    L23:
        Iterator r109 = r101.keySet().iterator();
    L25:
        if (r109.hasNext() == false) goto L30;
        FragmentActivity r111 = (FragmentActivity) r109.next();
        WeakHashMap<FragmentActivity, Boolean> r112 = activityVisibleStates;
        Boolean r113 = r112.get(r111);
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r113, r114) == true) goto L29;
        r106.add(new VisibilityEvent(OverlaySource.ACTIVITY, true, r111));
    L29:
        r112.put(r111, r114);
        goto L25
    L30:
        return r106;
    L13:
        r104 = false;
        goto L14
    }

    public final Function1<Dialog, Rect> getDialogVisibleRectResolver$impl_mainlandRelease() {
        return dialogVisibleRectResolver;
    }

    public final Function2<OverlaySource, FragmentActivity, Rect> getInputControlRectResolver$impl_mainlandRelease() {
        return inputControlRectResolver;
    }

    public final Function1<View, Rect> getPopupViewLocalVisibleRectResolver$impl_mainlandRelease() {
        return popupViewLocalVisibleRectResolver;
    }

    public final Function1<PopupWindow, Rect> getPopupVisibleRectResolver$impl_mainlandRelease() {
        return popupVisibleRectResolver;
    }

    public final Function1<View, int[]> getViewLocationOnScreenResolver$impl_mainlandRelease() {
        return viewLocationOnScreenResolver;
    }

    public final Function1<View, Rect> getViewVisibleRectResolver$impl_mainlandRelease() {
        return viewVisibleRectResolver;
    }

    public final Function0<Rect> getWindowVisibleBoundsResolver$impl_mainlandRelease() {
        return windowVisibleBoundsResolver;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    }

    private final String activityIdentity(FragmentActivity r100) {
        return r100.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(r100));
    }

    @JvmStatic
    public static final void bindDialogFragment(final DialogFragment r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Dialog r101 = r100.getDialog();
        if (r101 != null) goto L7;
        return;
    L7:
        PopupOrDialogVisibilityTracker r102 = INSTANCE;
        monitor-enter(r102);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r103 = dialogFragmentsByDialog;     // Catch: Throwable -> L13
        CollectionsKt.removeAll(r103.entrySet(), new e(r100));     // Catch: Throwable -> L13
        r103.put(r101, new WeakReference(r100));     // Catch: Throwable -> L13
        int r104 = r103.size();     // Catch: Throwable -> L13
        monitor-exit(r102);
        FLogger.f375446a.i(TAG, "bindDialogFragment dialog=" + r101.getClass().getName() + " fragment=" + r100.getClass().getName() + " bindingSize=" + r104);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clearTrackedDialogs(final OverlaySource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        CollectionsKt.removeAll(dialogSources.entrySet(), new j(r100));     // Catch: Throwable -> L8
        List<VisibilityEvent> r102 = r101.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r101);
        FLogger.f375446a.i(TAG, "clearTrackedDialogs source=" + r100);
        r101.dispatchEvents(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clearTrackedOverlays(final FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        CollectionsKt.removeAll(dialogSources.entrySet(), new n(r100));     // Catch: Throwable -> L8
        CollectionsKt.removeAll(popupSources.entrySet(), new o(r100));     // Catch: Throwable -> L8
        activityVisibleStates.remove(r100);     // Catch: Throwable -> L8
        List<VisibilityEvent> r102 = r101.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r101);
        FLogger.f375446a.i(TAG, "clearTrackedOverlays activity=" + r101.activityIdentity(r100));
        r101.dispatchEvents(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clearTrackedPopupWindows(final OverlaySource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        CollectionsKt.removeAll(popupSources.entrySet(), new l(r100));     // Catch: Throwable -> L8
        List<VisibilityEvent> r102 = r101.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r101);
        FLogger.f375446a.i(TAG, "clearTrackedPopupWindows source=" + r100);
        r101.dispatchEvents(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final FragmentActivity dismissActivityIfNeeded(OverlaySource r100) {
        if (r100 == OverlaySource.ACTIVITY) goto L5;
        return null;
    L5:
        FragmentActivity r101 = WindowUtils.INSTANCE.getCurrentActivityExceptWindow();
        if (r101 == null) goto L10;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L10;
        Lifecycle.State r103 = r102.getCurrentState();
    L12:
        if (r103 == Lifecycle.State.RESUMED) goto L25;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("dismissActivityIfNeeded skip activity=");
        if (r101 == null) goto L16;
        String r106 = activityIdentity(r101);
    L17:
        r105.append(r106);
        r105.append(" state=");
        if (r101 == null) goto L22;
        Lifecycle r107 = r101.getLifecycle();
        if (r107 == null) goto L22;
        Lifecycle.State r108 = r107.getCurrentState();
    L23:
        r105.append(r108);
        r104.i(TAG, r105.toString());
        return null;
    L22:
        r108 = null;
        goto L23
    L16:
        r106 = null;
        goto L17
    L25:
        return r101;
    L10:
        r103 = null;
        goto L12
    }

    private final void dispatchEvents(List<VisibilityEvent> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        VisibilityEvent r102 = (VisibilityEvent) r101.next();
        INSTANCE.dispatchVisibleChanged(r102.getSource(), r102.getVisible(), r102.getActivity());
        goto L4
    }

    @JvmStatic
    public static final void onDialogDismiss(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        dialogSources.remove(r100);     // Catch: Throwable -> L8
        retainedWindowDialogs.remove(r100);     // Catch: Throwable -> L8
        List<VisibilityEvent> r102 = r101.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r101);
        r101.dispatchEvents(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onDialogFragmentDismissed(final DialogFragment r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r102 = dialogFragmentsByDialog;     // Catch: Throwable -> L10
        int r103 = r102.size();     // Catch: Throwable -> L10
        CollectionsKt.removeAll(r102.entrySet(), new g(r100));     // Catch: Throwable -> L10
        int r104 = r102.size();     // Catch: Throwable -> L10
        Pair r105 = TuplesKt.to(Integer.valueOf(r103 - r104), Integer.valueOf(r104));     // Catch: Throwable -> L10
        monitor-exit(r101);
        int r106 = ((Number) r105.component1()).intValue();
        int r107 = ((Number) r105.component2()).intValue();
        FLogger.f375446a.i(TAG, "onDialogFragmentDismissed fragment=" + r100.getClass().getName() + " removedCount=" + r106 + " bindingSize=" + r107);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onDialogShowBlocked(final Dialog r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r102 = dialogFragmentsByDialog;     // Catch: Throwable -> L20
        WeakReference<DialogFragment> r103 = r102.get(r100);     // Catch: Throwable -> L20
        if (r103 == null) goto L9;
        DialogFragment r104 = r103.get();     // Catch: Throwable -> L20
    L10:
        if (r104 != null) goto L12;
        r102.remove(r100);     // Catch: Throwable -> L20
    L12:
        Pair r105 = TuplesKt.to(r104, Integer.valueOf(r102.size()));     // Catch: Throwable -> L20
        monitor-exit(r101);
        final DialogFragment r106 = (DialogFragment) r105.component1();
        int r107 = ((Number) r105.component2()).intValue();
        if (r106 != null) goto L18;
        FLogger.f375446a.w(TAG, "onDialogShowBlocked skipped, owner fragment not found and binding removed dialog=" + r100.getClass().getName() + " bindingSize=" + r107);
        return;
    L18:
        FLogger.f375446a.i(TAG, "onDialogShowBlocked dialog=" + r100.getClass().getName() + " fragment=" + r106.getClass().getName() + " bindingSize=" + r107);
        t0.c(new k(r106, r100));
        return;
    L9:
        r104 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onPopupDismiss(PopupWindow r100) {
        Intrinsics.checkNotNullParameter(r100, "popupWindow");
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        monitor-enter(r101);
        popupSources.remove(r100);     // Catch: Throwable -> L8
        List<VisibilityEvent> r102 = r101.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r101);
        r101.dispatchEvents(r102);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static final boolean pruneStaleActivityOverlaysLocked$lambda$58(Map.Entry r100) {
        Intrinsics.checkNotNullParameter(r100, "<destruct>");
        TrackedOverlay r101 = (TrackedOverlay) r100.getValue();
        if (r101.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r101.getActivity() != null) goto L7;
        return true;
    }

    private static final boolean pruneStaleActivityOverlaysLocked$lambda$59(Map.Entry r100) {
        Intrinsics.checkNotNullParameter(r100, "<destruct>");
        TrackedOverlay r101 = (TrackedOverlay) r100.getValue();
        if (r101.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r101.getActivity() != null) goto L7;
        return true;
    }

    private final Rect visibleRectOrNull(View r100) {
        Rect r101 = new Rect();
        if (r100.getGlobalVisibleRect(r101) == true) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == true) goto L10;
        return r101;
    L10:
        return null;
    }

    public final void dismissRetainedWindowDialogs$impl_mainlandRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        monitor-enter(this);
        WeakHashMap<Dialog, WeakReference<Dialog>> r101 = retainedWindowDialogs;     // Catch: Throwable -> L21
        List r102 = CollectionsKt.toList(r101.keySet());     // Catch: Throwable -> L21
        r101.clear();     // Catch: Throwable -> L21
        monitor-exit(this);
        if (r102.isEmpty() == false) goto L9;
        return;
    L9:
        FLogger.f375446a.i(TAG, "dismissRetainedWindowDialogs reason=" + r100 + " size=" + r102.size());
        Iterator r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L20;
        Dialog r104 = (Dialog) r103.next();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r104);     // Catch: Throwable -> L15
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L11;
        FLogger.f375446a.e(TAG, "dismissRetainedWindowDialogs failed reason=" + r100 + " dialog=" + r104.getClass().getName(), r107);
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final void releaseWindowDialog$impl_mainlandRelease(WeakReference<Dialog> r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogRef");
        Dialog r101 = r100.get();
        if (r101 != null) goto L6;
        FLogger.f375446a.i(TAG, "releaseWindowDialog skipped dialogCollected=true");
        return;
    L6:
        monitor-enter(this);
        WeakHashMap<Dialog, WeakReference<Dialog>> r102 = retainedWindowDialogs;     // Catch: Throwable -> L26
        List<VisibilityEvent> r103 = null;
        boolean r104 = false;
        if (r102.get(r101) != r100) goto L20;
        r102.remove(r101);     // Catch: Throwable -> L26
        WeakHashMap<Dialog, TrackedOverlay> r105 = dialogSources;     // Catch: Throwable -> L26
        if (r105.containsKey(r101) == false) goto L13;
    L19:
        r103 = INSTANCE.computeVisibilityEventsLocked();     // Catch: Throwable -> L26
        goto L20
    L13:
        if (r101.isShowing() == false) goto L19;
        if (WindowHost.INSTANCE.isShowing() == false) goto L19;
        TrackedOverlay r106 = INSTANCE.createTrackedOverlay(OverlaySource.WINDOW, null);     // Catch: Throwable -> L26
        if (r106 == null) goto L19;
        r105.put(r101, r106);     // Catch: Throwable -> L26
        r104 = true;
    L20:
        monitor-exit(this);
        if (r103 != null) goto L24;
        FLogger.f375446a.i(TAG, "releaseWindowDialog skipped lifecycleCleared=true");
        return;
    L24:
        FLogger.f375446a.i(TAG, "releaseWindowDialog dialog=" + r101.getClass().getName() + " retracked=" + r104);
        dispatchEvents(r103);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final Rect resolveDialogVisibleRect$impl_mainlandRelease(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        View r101 = r100.findViewById(R.id.design_bottom_sheet);
        if (r101 == null) goto L7;
        Rect r102 = viewVisibleRectResolver.invoke(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        Window r103 = r100.getWindow();
        if (r103 == null) goto L12;
        View r104 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
        if (r104 == null) goto L12;
        return viewVisibleRectResolver.invoke(r104);
    L12:
        return null;
    }

    public final Rect resolvePopupVisibleRect$impl_mainlandRelease(PopupWindow r100) {
        Intrinsics.checkNotNullParameter(r100, "popupWindow");
        if (r100.isShowing() == true) goto L5;
        return null;
    L5:
        View r101 = r100.getContentView();
        if (r101 != null) goto L8;
        return null;
    L8:
        Rect r102 = popupViewLocalVisibleRectResolver.invoke(r101);
        int[] r103 = viewLocationOnScreenResolver.invoke(r101);
        if (r102 == null) goto L14;
        if (r103 == null) goto L14;
        int r104 = r103[0];
        int r105 = r102.left + r104;
        int r106 = r103[1];
        return new Rect(r105, r102.top + r106, r104 + r102.right, r106 + r102.bottom);
    L14:
        return viewVisibleRectResolver.invoke(r101);
    }

    public final Rect resolveViewLocalVisibleRect$impl_mainlandRelease(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Rect r101 = new Rect();
        if (r100.getLocalVisibleRect(r101) == true) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == true) goto L10;
        return r101;
    L10:
        return null;
    }

    public final int[] resolveViewLocationOnScreen$impl_mainlandRelease(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.isAttachedToWindow() == true) goto L6;
        return null;
    L6:
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        return r101;
    }

    public final Rect resolveViewVisibleRect$impl_mainlandRelease(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return visibleRectOrNull(r100);
    }

    public final void setDialogVisibleRectResolver$impl_mainlandRelease(Function1<? super Dialog, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        dialogVisibleRectResolver = r100;
    }

    public final void setInputControlRectResolver$impl_mainlandRelease(Function2<? super OverlaySource, ? super FragmentActivity, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        inputControlRectResolver = r100;
    }

    public final void setPopupViewLocalVisibleRectResolver$impl_mainlandRelease(Function1<? super View, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        popupViewLocalVisibleRectResolver = r100;
    }

    public final void setPopupVisibleRectResolver$impl_mainlandRelease(Function1<? super PopupWindow, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        popupVisibleRectResolver = r100;
    }

    public final void setViewLocationOnScreenResolver$impl_mainlandRelease(Function1<? super View, int[]> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        viewLocationOnScreenResolver = r100;
    }

    public final void setViewVisibleRectResolver$impl_mainlandRelease(Function1<? super View, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        viewVisibleRectResolver = r100;
    }

    public final void setWindowVisibleBoundsResolver$impl_mainlandRelease(Function0<Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        windowVisibleBoundsResolver = r100;
    }

    private static final boolean bindDialogFragment$lambda$16$lambda$15(DialogFragment r100, Map.Entry r101) {
        Intrinsics.checkNotNullParameter(r101, "<destruct>");
        DialogFragment r102 = (DialogFragment) ((WeakReference) r101.getValue()).get();
        if (r102 == null) goto L7;
        if (r102 == r100) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean clearTrackedDialogs$lambda$32$lambda$31(OverlaySource r100, Map.Entry r101) {
        Intrinsics.checkNotNullParameter(r101, "<destruct>");
        if (((TrackedOverlay) r101.getValue()).getSource() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean clearTrackedOverlays$lambda$43$lambda$41(FragmentActivity r100, Map.Entry r101) {
        Intrinsics.checkNotNullParameter(r101, "<destruct>");
        TrackedOverlay r102 = (TrackedOverlay) r101.getValue();
        if (r102.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r102.getActivity() != r100) goto L7;
        return true;
    }

    private static final boolean clearTrackedOverlays$lambda$43$lambda$42(FragmentActivity r100, Map.Entry r101) {
        Intrinsics.checkNotNullParameter(r101, "<destruct>");
        TrackedOverlay r102 = (TrackedOverlay) r101.getValue();
        if (r102.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r102.getActivity() != r100) goto L7;
        return true;
    }

    private static final boolean clearTrackedPopupWindows$lambda$40$lambda$39(OverlaySource r100, Map.Entry r101) {
        Intrinsics.checkNotNullParameter(r101, "<destruct>");
        if (((TrackedOverlay) r101.getValue()).getSource() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    private final TrackedOverlay createTrackedOverlay(OverlaySource r100, FragmentActivity r101) {
        WeakReference r102 = null;
        if (r100 != OverlaySource.ACTIVITY) goto L7;
        if (r101 != null) goto L7;
        FLogger.f375446a.w(TAG, "skip tracking activity overlay because activity is null");
        return null;
    L7:
        if (r101 == null) goto L10;
        r102 = new WeakReference(r101);
    L10:
        return new TrackedOverlay(r100, r102);
    }

    @JvmStatic
    public static final void dismissAllTrackedDialogs(OverlaySource r100, boolean r101) {
        INSTANCE.dismissAllTrackedDialogs$impl_mainlandRelease(r100, r101, new m());
    }

    @JvmStatic
    public static final void dismissAllTrackedPopupWindows(OverlaySource r100, boolean r110) {
        if (r100 != null) goto L4;
        r100 = INSTANCE.defaultDismissSource();
    L4:
        PopupOrDialogVisibilityTracker r101 = INSTANCE;
        FragmentActivity r102 = r101.dismissActivityIfNeeded(r100);
        String r103 = null;
        if (r110 == false) goto L7;
        Rect r104 = inputControlRectResolver.invoke(r100, r102);
    L8:
        monitor-enter(r101);
        WeakHashMap<PopupWindow, TrackedOverlay> r105 = popupSources;     // Catch: Throwable -> L43
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L43
        Iterator<Map.Entry<PopupWindow, TrackedOverlay>> r107 = r105.entrySet().iterator();     // Catch: Throwable -> L43
    L11:
        if (r107.hasNext() == false) goto L20;
        Map.Entry<PopupWindow, TrackedOverlay> r108 = r107.next();     // Catch: Throwable -> L43
        TrackedOverlay r109 = r108.getValue();     // Catch: Throwable -> L43
        if (r109.getSource() != r100) goto L17;
        PopupOrDialogVisibilityTracker r111 = INSTANCE;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L43
        if (r111.matchesDismissTargetActivity(r109, r102) == false) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L11;
        r106.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L43
    L17:
        r112 = false;
        goto L18
    L20:
        List r113 = CollectionsKt.toList(r106.keySet());     // Catch: Throwable -> L43
        monitor-exit(r101);
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L24:
        if (r115.hasNext() == false) goto L28;
        Object r116 = r115.next();
        PopupWindow r117 = (PopupWindow) r116;
        PopupOrDialogVisibilityTracker r118 = INSTANCE;
        Function1<? super PopupWindow, Rect> r119 = popupVisibleRectResolver;
        Intrinsics.checkNotNull(r117);
        if (r118.shouldDismissOverlay(r100, r110, r104, r119.invoke(r117)) == false) goto L24;
        r114.add(r116);
        goto L24
    L28:
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("dismissAllTrackedPopupWindows size=");
        r121.append(r114.size());
        r121.append(" dismissSource=");
        r121.append(r100);
        r121.append(" dismissActivity=");
        if (r102 == null) goto L31;
        r103 = INSTANCE.activityIdentity(r102);
    L31:
        r121.append(r103);
        r121.append(" windowShowing=");
        r121.append(WindowHost.INSTANCE.isShowing());
        r121.append(" dismissOverlappedOnly=");
        r121.append(r110);
        r121.append(" inputControlRect=");
        r121.append(r104);
        r120.i(TAG, r121.toString());
        Iterator r122 = r114.iterator();
    L33:
        if (r122.hasNext() == false) goto L42;
        PopupWindow r123 = (PopupWindow) r122.next();
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L37
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(r123);     // Catch: Throwable -> L37
        Object r125 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L33;
        FLogger.f375446a.e(TAG, "dismissAllTrackedPopupWindows failed popupWindow=" + r123 + " source=" + r100, r126);
    L37:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L42:
        return;
    L43:
        th = move-exception;
        throw th;
    L7:
        r104 = null;
        goto L8
    }

    private final boolean matchesDismissTargetActivity(TrackedOverlay r100, FragmentActivity r101) {
        if (r100.getSource() != OverlaySource.ACTIVITY) goto L10;
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.getActivity() != r101) goto L8;
        return true;
    L10:
        return true;
    }

    private static final boolean onDialogFragmentDismissed$lambda$20$lambda$19(DialogFragment r100, Map.Entry r101) {
        Intrinsics.checkNotNullParameter(r101, "<destruct>");
        DialogFragment r102 = (DialogFragment) ((WeakReference) r101.getValue()).get();
        if (r102 == null) goto L7;
        if (r102 == r100) goto L7;
        return false;
    L7:
        return true;
    }

    private static final void onDialogShowBlocked$lambda$18(DialogFragment r100, Dialog r101) {
        if (r100.getDialog() == r101) goto L21;
        FLogger.f375446a.w(TAG, "onDialogShowBlocked skipped, dialog binding changed fragment=".concat(r100.getClass().getName()));
        INSTANCE.clearDialogFragmentBinding(r101, r100, "binding_changed");
        return;
    L21:
    L11:
        th = move-exception;
        FLogger.f375446a.e(TAG, "dismiss blocked dialog fragment failed fragment=".concat(r100.getClass().getName()), th);     // Catch: Throwable -> L15
    L13:
        INSTANCE.clearDialogFragmentBinding(r101, r100, "show_blocked_handled");
        return;
    L15:
        th = move-exception;
        INSTANCE.clearDialogFragmentBinding(r101, r100, "show_blocked_handled");
        throw th;
    L7:
        if (r100.isAdded() == false) goto L9;
        FLogger.f375446a.i(TAG, "onDialogShowBlocked dismiss fragment=".concat(r100.getClass().getName()));     // Catch: Throwable -> L11
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r100);     // Catch: Throwable -> L11
    L20:
        goto L13
    L9:
        FLogger.f375446a.w(TAG, "onDialogShowBlocked skipped, fragment not added fragment=".concat(r100.getClass().getName()));     // Catch: Throwable -> L11
        goto L20
    }

    public final Rect resolveInputControlRect$impl_mainlandRelease(OverlaySource r110, FragmentActivity r111) {
        Intrinsics.checkNotNullParameter(r110, "source");
        int r100 = WhenMappings.$EnumSwitchMapping$0[r110.ordinal()];
        Rect r101 = null;
        if (r100 != 1) goto L5;
        IAssistantChatWindow r112 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r112 == null) goto L22;
        t1a.b r113 = r112.provideWindowVContext();
        if (r113 == null) goto L22;
    L26:
        if (r113 == null) goto L42;
        va8.m r114 = (va8.m) r113.getAbility(va8.m.class);
        if (r114 == null) goto L42;
        va8.l r115 = r114.iX();
        if (r115 == null) goto L42;
        FrameLayout r116 = r115.getInput();
        if (r116 == null) goto L42;
        Rect r102 = visibleRectOrNull(r116);
        if (r102 != null) goto L37;
        return null;
    L37:
        int r103 = r116.getResources().getConfiguration().orientation;
        int r104 = r116.getHeight();
        if (r110 != OverlaySource.WINDOW) goto L41;
        r101 = windowVisibleBoundsResolver.invoke();
    L41:
        return buildInputDismissRect$impl_mainlandRelease(r110, r102, r104, r103, r101);
    L42:
        return null;
    L22:
        IAssistantChatWindow r117 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r117 == null) goto L25;
        r113 = r117.getCurrentVContext();
    L25:
        r113 = null;
        goto L26
    L5:
        if (r100 != 2) goto L17;
        if (r111 != null) goto L8;
    L10:
        if (r111 == null) goto L13;
        r113 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r111);
        if (r113 != null) goto L26;
    L13:
        IAssistantChatWindow r118 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r118 == null) goto L25;
        r113 = r118.getCurrentVContext();
        goto L26
    L8:
        if (ObricChatContextServiceDelegate.f386558b.c(r111) == false) goto L10;
        r113 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r111);
        goto L26
    L17:
        throw new NoWhenBranchMatchedException();
    }

    private final void clearDialogFragmentBinding(Dialog r100, DialogFragment r101, String r102) {
        monitor-enter(this);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r103 = dialogFragmentsByDialog;     // Catch: Throwable -> L16
        WeakReference<DialogFragment> r104 = r103.get(r100);     // Catch: Throwable -> L16
        if (r104 == null) goto L6;
        DialogFragment r105 = r104.get();     // Catch: Throwable -> L16
    L7:
        if (r105 != r101) goto L9;
        r103.remove(r100);     // Catch: Throwable -> L16
        boolean r106 = true;
    L10:
        Pair r107 = TuplesKt.to(Boolean.valueOf(r106), Integer.valueOf(r103.size()));     // Catch: Throwable -> L16
        monitor-exit(this);
        boolean r108 = ((Boolean) r107.component1()).booleanValue();
        int r109 = ((Number) r107.component2()).intValue();
        if (r108 == false) goto L21;
        FLogger.f375446a.i(TAG, "clearDialogFragmentBinding reason=" + r102 + " dialog=" + r100.getClass().getName() + " fragment=" + r101.getClass().getName() + " bindingSize=" + r109);
        return;
    L21:
        return;
    L9:
        r106 = false;
        goto L10
    L6:
        r105 = null;
    L16:
        th = move-exception;
        throw th;
    }

    private static final void computeVisibilityEventsLocked$recordOverlay(Ref.IntRef r100, LinkedHashMap<FragmentActivity, Integer> r101, TrackedOverlay r102) {
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.getSource().ordinal()];
        if (r103 != 1) goto L5;
        r100.element++;
        return;
    L5:
        if (r103 != 2) goto L14;
        FragmentActivity r104 = r102.getActivity();
        if (r104 == null) goto L17;
        Integer r105 = r101.get(r104);
        if (r105 == null) goto L11;
        int r106 = r105.intValue();
    L12:
        r101.put(r104, Integer.valueOf(r106 + 1));
        return;
    L11:
        r106 = 0;
        goto L12
    L17:
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private final void dispatchVisibleChanged(OverlaySource r100, boolean r101, FragmentActivity r102) {
        Counts r103 = currentCounts();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("visibleChanged source=");
        r105.append(r100);
        r105.append(" visible=");
        r105.append(r101);
        r105.append(" activity=");
        t1a.b r106 = null;
        if (r102 == null) goto L5;
        String r107 = activityIdentity(r102);
    L6:
        r105.append(r107);
        r105.append(" windowCount=");
        r105.append(r103.getWindowCount());
        r105.append(" activityOverlayCount=");
        r105.append(r103.getActivityOverlayCount());
        r105.append(" activityVisibleSize=");
        r105.append(r103.getActivityVisibleSize());
        r105.append(" dialogSize=");
        r105.append(r103.getDialogSize());
        r105.append(" popupSize=");
        r105.append(r103.getPopupSize());
        r104.i(TAG, r105.toString());
        int r108 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r108 != 1) goto L9;
        IAssistantChatWindow r109 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r109 == null) goto L20;
        t1a.b r110 = r109.provideWindowVContext();
        if (r110 == null) goto L20;
        r106 = r110;
    L24:
        if (r100 != OverlaySource.ACTIVITY) goto L27;
        if (r102 != null) goto L27;
        r104.w(TAG, "dispatchVisibleChanged missing activity for ACTIVITY event");
    L27:
        if (r106 == null) goto L32;
        laa.d r111 = (laa.d) r106.getAbility(laa.d.class);
        if (r111 == null) goto L33;
        r111.Ks(r101);
        return;
    L33:
        return;
    L32:
        return;
    L20:
        IAssistantChatWindow r112 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r112 == null) goto L24;
        r106 = r112.getCurrentVContext();
        goto L24
    L9:
        if (r108 != 2) goto L13;
        if (r102 == null) goto L24;
        r106 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r102);
        goto L24
    L13:
        throw new NoWhenBranchMatchedException();
    L5:
        r107 = null;
        goto L6
    }

    @JvmStatic
    public static final void onDialogShow(Dialog r100, OverlaySource r101, FragmentActivity r102) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "source");
        PopupOrDialogVisibilityTracker r103 = INSTANCE;
        monitor-enter(r103);
        PopupOrDialogVisibilityTracker r104 = INSTANCE;     // Catch: Throwable -> L11
        TrackedOverlay r105 = r104.createTrackedOverlay(r101, r102);     // Catch: Throwable -> L11
        if (r105 == null) goto L7;
        dialogSources.put(r100, r105);     // Catch: Throwable -> L11
    L7:
        List<VisibilityEvent> r106 = r104.computeVisibilityEventsLocked();     // Catch: Throwable -> L11
        monitor-exit(r103);
        r104.dispatchEvents(r106);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onPopupShow(PopupWindow r100, OverlaySource r101, FragmentActivity r102) {
        Intrinsics.checkNotNullParameter(r100, "popupWindow");
        Intrinsics.checkNotNullParameter(r101, "source");
        PopupOrDialogVisibilityTracker r103 = INSTANCE;
        monitor-enter(r103);
        PopupOrDialogVisibilityTracker r104 = INSTANCE;     // Catch: Throwable -> L11
        TrackedOverlay r105 = r104.createTrackedOverlay(r101, r102);     // Catch: Throwable -> L11
        if (r105 == null) goto L7;
        popupSources.put(r100, r105);     // Catch: Throwable -> L11
    L7:
        List<VisibilityEvent> r106 = r104.computeVisibilityEventsLocked();     // Catch: Throwable -> L11
        monitor-exit(r103);
        r104.dispatchEvents(r106);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void dismissAllTrackedDialogs$impl_mainlandRelease(OverlaySource r110, boolean r111, Function1<? super DialogFragment, Boolean> r112) {
        Intrinsics.checkNotNullParameter(r112, "shouldDismissFragment");
        if (r110 != null) goto L5;
        r110 = defaultDismissSource();
    L5:
        FragmentActivity r100 = dismissActivityIfNeeded(r110);
        String r101 = null;
        if (r111 == false) goto L8;
        Rect r102 = inputControlRectResolver.invoke(r110, r100);
    L9:
        monitor-enter(this);
        WeakHashMap<Dialog, TrackedOverlay> r103 = dialogSources;     // Catch: Throwable -> L50
        LinkedHashMap r104 = new LinkedHashMap();     // Catch: Throwable -> L50
        Iterator<Map.Entry<Dialog, TrackedOverlay>> r105 = r103.entrySet().iterator();     // Catch: Throwable -> L50
    L12:
        if (r105.hasNext() == false) goto L27;
        Map.Entry<Dialog, TrackedOverlay> r106 = r105.next();     // Catch: Throwable -> L50
        Dialog r107 = r106.getKey();     // Catch: Throwable -> L50
        TrackedOverlay r108 = r106.getValue();     // Catch: Throwable -> L50
        if (r108.getSource() != r110) goto L24;
        PopupOrDialogVisibilityTracker r109 = INSTANCE;     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L50
        if (r109.matchesDismissTargetActivity(r108, r100) == false) goto L24;
        WeakReference<DialogFragment> r113 = dialogFragmentsByDialog.get(r107);     // Catch: Throwable -> L50
        if (r113 == null) goto L20;
        DialogFragment r114 = r113.get();     // Catch: Throwable -> L50
    L22:
        if (r112.invoke(r114).booleanValue() == false) goto L24;
        boolean r115 = true;
    L25:
        if (r115 == false) goto L12;
        r104.put(r106.getKey(), r106.getValue());     // Catch: Throwable -> L50
        goto L12
    L20:
        r114 = null;
    L24:
        r115 = false;
        goto L25
    L27:
        List r116 = CollectionsKt.toList(r104.keySet());     // Catch: Throwable -> L50
        monitor-exit(this);
        ArrayList r117 = new ArrayList();
        Iterator r118 = r116.iterator();
    L31:
        if (r118.hasNext() == false) goto L35;
        Object r119 = r118.next();
        Dialog r120 = (Dialog) r119;
        PopupOrDialogVisibilityTracker r121 = INSTANCE;
        Function1<? super Dialog, Rect> r122 = dialogVisibleRectResolver;
        Intrinsics.checkNotNull(r120);
        if (r121.shouldDismissOverlay(r110, r111, r102, r122.invoke(r120)) == false) goto L31;
        r117.add(r119);
        goto L31
    L35:
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("dismissAllTrackedDialogs size=");
        r124.append(r117.size());
        r124.append(" dismissSource=");
        r124.append(r110);
        r124.append(" dismissActivity=");
        if (r100 == null) goto L38;
        r101 = activityIdentity(r100);
    L38:
        r124.append(r101);
        r124.append(" windowShowing=");
        r124.append(WindowHost.INSTANCE.isShowing());
        r124.append(" dismissOverlappedOnly=");
        r124.append(r111);
        r124.append(" inputControlRect=");
        r124.append(r102);
        r123.i(TAG, r124.toString());
        Iterator r125 = r117.iterator();
    L40:
        if (r125.hasNext() == false) goto L49;
        Dialog r126 = (Dialog) r125.next();
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L44
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r126);     // Catch: Throwable -> L44
        Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L40;
        FLogger.f375446a.e(TAG, "dismissAllTrackedDialogs failed dialog=" + r126 + " source=" + r110, r129);
    L44:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L49:
        return;
    L50:
        th = move-exception;
        throw th;
    L8:
        r102 = null;
        goto L9
    }

    private static final void currentCounts$lambda$55$recordOverlay$52(Ref.IntRef r100, Ref.IntRef r101, LinkedHashSet<FragmentActivity> r102, TrackedOverlay r103) {
        int r104 = WhenMappings.$EnumSwitchMapping$0[r103.getSource().ordinal()];
        if (r104 != 1) goto L5;
        r100.element++;
        return;
    L5:
        if (r104 != 2) goto L10;
        FragmentActivity r105 = r103.getActivity();
        if (r105 == null) goto L13;
        r101.element++;
        r102.add(r105);
        return;
    L13:
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void dismissAllTrackedDialogs$default(OverlaySource r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        dismissAllTrackedDialogs(r100, r101);
    }

    public static /* synthetic */ void dismissAllTrackedPopupWindows$default(OverlaySource r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        dismissAllTrackedPopupWindows(r100, r101);
    }

    private final Rect normalizeWindowOverlayRect(Rect r100, OverlaySource r101, Rect r102, Rect r103) {
        Rect r104 = new Rect(r100);
        if (r101 != OverlaySource.WINDOW) goto L14;
        if (r102 == null) goto L14;
        if (r102.isEmpty() == true) goto L14;
        if (Rect.intersects(r104, r103) == false) goto L11;
        return r104;
    L11:
        Rect r105 = new Rect(r104);
        r105.offset(r102.left, r102.top);
        if (Rect.intersects(r105, r103) == false) goto L14;
        return r105;
    L14:
        return r104;
    }

    private final boolean shouldDismissOverlay(OverlaySource r100, boolean r101, Rect r102, Rect r103) {
        if (r101 == true) goto L5;
        return true;
    L5:
        if (r102 == null) goto L15;
        if (r103 == null) goto L15;
        if (r100 != OverlaySource.WINDOW) goto L11;
        Rect r104 = windowVisibleBoundsResolver.invoke();
    L13:
        return Rect.intersects(r102, normalizeWindowOverlayRect(r103, r100, r104, r102));
    L11:
        r104 = null;
    L15:
        if (r100 == OverlaySource.WINDOW) goto L19;
        return false;
    L19:
        return true;
    }

    public static /* synthetic */ void onDialogShow$default(Dialog r100, OverlaySource r101, FragmentActivity r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        onDialogShow(r100, r101, r102);
    }

    public static /* synthetic */ void onPopupShow$default(PopupWindow r100, OverlaySource r101, FragmentActivity r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        onPopupShow(r100, r101, r102);
    }

    public final Rect buildInputDismissRect$impl_mainlandRelease(OverlaySource r100, Rect r101, int r102, int r103, Rect r104) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "inputVisibleRect");
        if (r103 == 2) goto L6;
        r102 = r102 / 3;
    L6:
        Rect r105 = new Rect(r101.left, r101.top - r102, r101.right, r101.bottom);
        if (r100 != OverlaySource.WINDOW) goto L20;
        if (r103 != 2) goto L20;
        if (r104 == null) goto L20;
        if (r104.isEmpty() == false) goto L14;
        return r105;
    L14:
        int r106 = RangesKt.coerceAtLeast(r105.top, r104.top);
        int r107 = RangesKt.coerceAtMost(r105.bottom, r104.bottom);
        if (r106 < r107) goto L19;
        return null;
    L19:
        return new Rect(r104.left, r106, r104.right, r107);
    L20:
        return r105;
    }

    public static /* synthetic */ void dispatchVisibleChanged$default(PopupOrDialogVisibilityTracker r100, OverlaySource r101, boolean r102, FragmentActivity r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.dispatchVisibleChanged(r101, r102, r103);
    }
}
