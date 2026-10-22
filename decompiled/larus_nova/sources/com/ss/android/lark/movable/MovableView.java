package com.ss.android.lark.movable;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableCallback;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.attatchment.MovableAttachmentApplier;
import com.ss.android.lark.movable.attatchment.p;
import com.ss.android.lark.movable.island.MovableIslandsOpsApplier;
import com.ss.android.lark.movable.island.ScrollIsland;
import com.ss.android.lark.movable.selection.HandleStyle;
import com.ss.android.lark.movable.selection.MovableLongPressBehavior;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b'\b\u0016\u0018\u0000 Â\u00012\u00020\u00012\u00020\u0002:\u0006Â\u0001Ã\u0001Ä\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010?\u001a\u00020@2\b\u00107\u001a\u0004\u0018\u00010%2\b\u0010A\u001a\u0004\u0018\u00010\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u001cJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00000EJ!\u0010Y\u001a\u00020@2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020@0[¢\u0006\u0002\b]H\u0016J\u0010\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\\H\u0004J\u0010\u0010`\u001a\u00020@2\u0006\u0010_\u001a\u00020\\H\u0014J\b\u0010a\u001a\u00020@H\u0002J\n\u0010b\u001a\u0004\u0018\u000106H\u0002J\u0010\u0010c\u001a\u00020@2\u0006\u0010d\u001a\u00020TH\u0002J\b\u0010e\u001a\u0004\u0018\u00010>J\u0006\u0010f\u001a\u00020gJ\b\u0010h\u001a\u0004\u0018\u00010iJ\u0006\u0010j\u001a\u00020@J\u0010\u0010k\u001a\u00020@2\u0006\u0010-\u001a\u00020\u001cH\u0007J\r\u0010l\u001a\u00020\nH\u0000¢\u0006\u0002\bmJ\b\u0010n\u001a\u0004\u0018\u00010oJ!\u0010p\u001a\u00020@2\u0006\u0010q\u001a\u00020\u00122\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0002\brJ\u000e\u0010s\u001a\u00020@2\u0006\u0010t\u001a\u00020\u001cJ\b\u0010u\u001a\u00020@H\u0014J\b\u0010v\u001a\u00020@H\u0014J\b\u0010w\u001a\u00020@H\u0002J\u0012\u0010x\u001a\u00020@2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010y\u001a\u00020@2\u0006\u0010q\u001a\u00020\u0012H\u0002J\b\u0010z\u001a\u00020@H\u0002J\b\u0010{\u001a\u00020@H\u0002J%\u0010|\u001a\u00020@2\u001b\u0010}\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~\u0018\u00010EH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020TH\u0014J\u001b\u0010\u0082\u0001\u001a\u00020@2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\nH\u0014J-\u0010\u0085\u0001\u001a\u00020@2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\nH\u0014J\r\u0010\u008a\u0001\u001a\u00020i*\u00020>H\u0002J\u0010\u0010\u008b\u0001\u001a\u00020@2\u0007\u0010\u008c\u0001\u001a\u00020>J\u0010\u0010\u008d\u0001\u001a\u00020@2\u0007\u0010\u008c\u0001\u001a\u00020>J\u001b\u0010\u008e\u0001\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020T2\u0007\u0010\u0090\u0001\u001a\u00020\nH\u0014J\u0015\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0007\u0010\u008c\u0001\u001a\u00020>H\u0002JW\u0010\u0093\u0001\u001a\u00020@2\b\u0010\u0094\u0001\u001a\u00030\u0092\u00012\u001b\u0010\u0095\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120~0E2\u0007\u0010\u0096\u0001\u001a\u00020\u001c2\u001c\u0010\u0097\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~\u0018\u00010EH\u0002J\t\u0010\u0098\u0001\u001a\u00020@H\u0016J\u0007\u0010\u0099\u0001\u001a\u00020@J\u0012\u0010\u009a\u0001\u001a\u00020@2\u0007\u0010\u009b\u0001\u001a\u00020\u001cH\u0002J@\u0010\u009c\u0001\u001a\u00020@2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020g2\u0007\u0010 \u0001\u001a\u00020g2\u0007\u0010¡\u0001\u001a\u00020g2\u0007\u0010¢\u0001\u001a\u00020gH\u0016¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u0012\u0010¥\u0001\u001a\u00020@2\u0007\u0010¦\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010§\u0001\u001a\u00020\u001c2\u0007\u0010¨\u0001\u001a\u00020UH\u0016J\t\u0010©\u0001\u001a\u00020@H\u0016J\t\u0010ª\u0001\u001a\u00020@H\u0002J,\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020g0E2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\b\u0010¬\u0001\u001a\u00030\u009e\u0001H\u0016¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J.\u0010¯\u0001\u001a\u00020@2\u0007\u0010°\u0001\u001a\u00020i2\u0007\u0010±\u0001\u001a\u00020i2\b\u0010²\u0001\u001a\u00030\u009e\u0001H\u0016¢\u0006\u0006\b³\u0001\u0010´\u0001J4\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020g0E2\b\u0010¶\u0001\u001a\u00030\u009e\u00012\u0007\u0010·\u0001\u001a\u00020g2\u0007\u0010¸\u0001\u001a\u00020iH\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J-\u0010»\u0001\u001a\u00020@2\u0007\u0010\t\u001a\u00030\u009e\u00012\u0007\u0010¼\u0001\u001a\u00020i2\u0007\u0010½\u0001\u001a\u00020iH\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u000f\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020i0EH\u0016J!\u0010Á\u0001\u001a\u00020@2\u0007\u0010¡\u0001\u001a\u00020g2\u0007\u0010¢\u0001\u001a\u00020g2\u0006\u0010t\u001a\u00020\u001cR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b0\u00101R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u00010%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020@\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020@\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0001"}, d2 = {"Lcom/ss/android/lark/movable/MovableView;", "Lcom/ss/android/lark/movable/OverflowClipContainer;", "Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "instanceId", "", "getInstanceId", "()I", "instanceId$delegate", "Lkotlin/Lazy;", "attachmentApplier", "Lcom/ss/android/lark/movable/attatchment/MovableAttachmentApplier;", "attachmentBlob", "", "textData", "islandsOps", "scope", "Lkotlinx/coroutines/CoroutineScope;", "renderJob", "Lkotlinx/coroutines/Job;", "currentRenderToken", "", "enableDrawGlyphs", "", "textCanvasView", "Lcom/ss/android/lark/movable/rcanvas/RCanvas;", "selectionEnabledByConfig", "selectionActive", "isSelectionEnabled", "()Z", "islands", "", "Lcom/ss/android/lark/movable/island/ScrollIsland;", "selectionManager", "Lcom/ss/android/lark/movable/selection/MovableSelectionManager;", "getSelectionManager$movable_release", "()Lcom/ss/android/lark/movable/selection/MovableSelectionManager;", "setSelectionManager$movable_release", "(Lcom/ss/android/lark/movable/selection/MovableSelectionManager;)V", "value", "isInStreaming", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "loadingView", "Lcom/ss/android/lark/movable/LoadingView;", "selectionManagerBuilder", "Lcom/ss/android/lark/movable/selection/MovableSelectionManager$Builder;", "parentIsland", "getParentIsland$movable_release", "()Lcom/ss/android/lark/movable/island/ScrollIsland;", "setParentIsland$movable_release", "(Lcom/ss/android/lark/movable/island/ScrollIsland;)V", "parentMovableView", "documentInfo", "Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "setParentInfo", "", "rootMovableView", "getRootMovableView", "isRootMovableView", "getInnerMovableViews", "", "eventClickListener", "Lcom/ss/android/lark/movable/IMovableEventClickListener;", "getEventClickListener$movable_release", "()Lcom/ss/android/lark/movable/IMovableEventClickListener;", "setEventClickListener$movable_release", "(Lcom/ss/android/lark/movable/IMovableEventClickListener;)V", "imageLoader", "Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;", "getImageLoader$movable_release", "()Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;", "setImageLoader$movable_release", "(Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;)V", "onNonClickableAreaClick", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "initialized", "shouldRegisterOnAttach", "onWidthChangedListener", LynxTemplateRender.RENDER_PHASE_SETUP, "block", "Lkotlin/Function1;", "Lcom/ss/android/lark/movable/MovableView$Config;", "Lkotlin/ExtensionFunctionType;", "setupWithConfig", "config", "applyConfig", "attachTextRCanvas", "resolveSelectionManagerBuilder", "ensureChildMeasuredAndLaidOut", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "getMovableDocumentInfo", "getMovableDocumentHeight", "", "getSelectedMarkdownText", "", "clearSelection", "updateIsInStreaming", "getMovableInstanceId", "getMovableInstanceId$movable_release", "getCopyStrategy", "Lcom/ss/android/lark/movable/selection/MovableCopyStrategy;", "updateTextRender", "data", "updateTextRender$movable_release", "updateLoadingState", "inStreaming", "onAttachedToWindow", "onDetachedFromWindow", "registerMovableViewIfAttached", "updateMovableDocumentInfo", "updateAttachmentRender", "removeAttachment", "removeScrollIsland", "updateIslandViews", "ops", "Lkotlin/Pair;", "Lcom/ss/android/lark/movable/island/MovableIslandsOpsApplier$Op;", "Lcom/ss/android/lark/movable/island/IslandInfo;", "shouldOverflow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "logInfo", ChameleonOpenTracker.Stage.RENDER, "originDocumentInfo", "renderSync", "onVisibilityChanged", "changedView", RemoteMessageConst.Notification.VISIBILITY, "prepareRender", "Lcom/ss/android/lark/movable/MovableView$RenderContext;", "applyRenderData", "renderContext", "islandResults", "needUpdateScrollIsland", "islandOpList", "onRecycled", "release", "releaseInternal", "resetLayout", "markHighlightUpdate", "canvasId", "Lkotlin/UInt;", "x", "y", "width", "height", "markHighlightUpdate-iyaXS9w", "(IFFFF)V", "updateEnableSelection", "active", "onTouchEvent", "event", "cancelLongPress", "cancelInternalLongPress", "getScrollIslandScrollOffset", "islandId", "getScrollIslandScrollOffset-feOb9K0", "(II)Ljava/util/List;", "registerFont", "name", "path", "ttcIndex", "registerFont-jXDDuk8", "(Ljava/lang/String;Ljava/lang/String;I)V", "measureAttachment", "typeId", "containerWidth", "propertyString", "measureAttachment-OzbTU-A", "(IFLjava/lang/String;)Ljava/util/List;", "eventClick", "schema", WsConstants.KEY_PAYLOAD, "eventClick-OzbTU-A", "(ILjava/lang/String;Ljava/lang/String;)V", "getFontPrefixPathCandidates", "updateSize", "Companion", "RenderContext", "Config", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MovableView extends OverflowClipContainer implements MovableCallback {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f432562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MovableAttachmentApplier f432563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f432564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f432565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f432566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f432567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f432568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f432569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ksb.b f432570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f432571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f432572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Integer, ScrollIsland> f432573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MovableSelectionManager f432574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f432575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.ss.android.lark.movable.c f432576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MovableSelectionManager.a f432577q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ScrollIsland f432578r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MovableView f432579s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public MovableDocumentInfo f432580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.ss.android.lark.movable.b f432581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p f432582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function2<? super View, ? super MotionEvent, Unit> f432583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f432584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f432585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f432586z;

    public static final class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f432587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.ss.android.lark.movable.b f432588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f432589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MovableSelectionManager.a f432590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function2<? super Integer, ? super Integer, Unit> f432591e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function2<? super View, ? super MotionEvent, Unit> f432592f;

        public b() {
            this.f432589c = true;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MovableDocumentInfo f432593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MovableDocumentInfo f432594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f432595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f432596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f432597e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f432593a, r101.f432593a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f432594b, r101.f432594b) == true) goto L15;
            return false;
        L15:
            if (this.f432595c == r101.f432595c) goto L18;
            return false;
        L18:
            if (this.f432596d == r101.f432596d) goto L21;
            return false;
        L21:
            if (this.f432597e == r101.f432597e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f432593a.hashCode() * 31) + this.f432594b.hashCode()) * 31) + UInt.m9556hashCodeimpl(this.f432595c)) * 31) + UInt.m9556hashCodeimpl(this.f432596d)) * 31;
            if (this.f432597e == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "RenderContext(originDocumentInfo=" + this.f432593a + ", documentInfo=" + this.f432594b + ", documentVersion=" + UInt.m9590toStringimpl(this.f432595c) + ", renderId=" + UInt.m9590toStringimpl(this.f432596d) + ", inStreaming=" + this.f432597e + ')';
        }

        public c(MovableDocumentInfo r100, MovableDocumentInfo r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "originDocumentInfo");
            Intrinsics.checkNotNullParameter(r101, "documentInfo");
            this.f432593a = r100;
            this.f432594b = r101;
            this.f432595c = r102;
            this.f432596d = r103;
            this.f432597e = false;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.MovableView$onDetachedFromWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.movable.MovableView$onDetachedFromWindow$1", f = "MovableView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MovableView this$0;

        public AnonymousClass1(MovableView r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            MovableSelectionManager r101 = this.this$0.getSelectionManager$movable_release();
            if (r101 == null) goto L8;
            r101.d();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.MovableView$onVisibilityChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.movable.MovableView$onVisibilityChanged$1", f = "MovableView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C119321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MovableView this$0;

        public C119321(MovableView r100, Continuation<? super C119321> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C119321(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C119321) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            MovableSelectionManager r101 = this.this$0.getSelectionManager$movable_release();
            if (r101 == null) goto L8;
            r101.d();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: registerFont-jXDDuk8 */
    public final void mo8418registerFontjXDDuk8(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "path");
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f432575o.getValue();
    }

    private final int getInstanceId() {
        return ((Number) this.f432562b.getValue()).intValue();
    }

    public void d() {
        Log.i("MovableView", "movable onRecycled() called, hashCode:" + hashCode());
        com.ss.android.lark.movable.c r100 = this.f432576p;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f432576p = null;
        removeAllViews();
        ksb.b r101 = this.f432570j;
        r101.getClass();
        Log.d("RCanvas", "canvasSh: " + r101.f505997e + ", reset called");
        r101.f505995c = new byte[0];
        r101.f505996d = null;
        ((LinkedHashMap) this.f432573m).clear();
        this.f432564d = null;
        this.f432565e = null;
        this.f432566f = null;
        this.f432580t = null;
        this.f432584x = false;
        this.f432585y = false;
        MovableGlobalManager.f432543d.a().e(getMovableInstanceId$movable_release());
        this.f432581u = null;
        this.f432582v = null;
        this.f432574n = null;
        this.f432577q = null;
        this.f432586z = null;
        this.f432578r = null;
        this.f432579s = null;
        this.f432572l = true;
        if (getLayoutParams() == null) goto L12;
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L11;
        r102.height = 0;
        setLayoutParams(r102);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void e() {
        if (this.f432585y == true) goto L5;
        return;
    L5:
        if (this.f432584x == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(getRootMovableView(), this) == true) goto L9;
        return;
    L9:
        if (isAttachedToWindow() == false) goto L15;
        MovableGlobalManager.f432543d.a().c(getMovableInstanceId$movable_release(), this);
        return;
    }

    public final List<MovableView> getInnerMovableViews() {
        Map<Integer, ScrollIsland> r100 = this.f432573m;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((ScrollIsland) ((Map.Entry) r102.next()).getValue()).getInnerMovableView());
        goto L4
    L6:
        return r101;
    }

    public final MovableView getRootMovableView() {
        MovableView r100 = this.f432579s;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this;
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        long r100 = SystemClock.uptimeMillis();
        MotionEvent r101 = MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0);
        getGestureDetector().onTouchEvent(r101);     // Catch: Throwable -> L8
        MovableSelectionManager r102 = this.f432574n;     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L8
        r102.l(r101);     // Catch: Throwable -> L8
    L6:
        r101.recycle();
        return;
    L8:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    public final MovableSelectionManager.a f() {
        if (getRootMovableView().f432571k == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(getRootMovableView(), this) == true) goto L11;
        MovableSelectionManager.a r100 = getRootMovableView().f();
        if (r100 == null) goto L15;
        MovableSelectionManager.a r101 = new MovableSelectionManager.a();
        HandleStyle r102 = r100.f432756f;
        Intrinsics.checkNotNullParameter(r102, "style");
        r101.f432756f = r102;
        r101.f432757g = r100.f432757g;
        return r101;
    L15:
        return null;
    L11:
        MovableSelectionManager.a r103 = this.f432577q;
        if (r103 == null) goto L14;
        return r103;
    L14:
        return new MovableSelectionManager.a();
    }

    public final com.ss.android.lark.movable.selection.h getCopyStrategy() {
        MovableSelectionManager r100 = getRootMovableView().f432574n;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f432727c;
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    public List<String> getFontPrefixPathCandidates() {
        return CollectionsKt.emptyList();
    }

    public final float getMovableDocumentHeight() {
        MovableDocumentInfo r100 = getMovableDocumentInfo();
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getHeight();
    }

    public final MovableDocumentInfo getMovableDocumentInfo() {
        return getRootMovableView().f432580t;
    }

    public final int getMovableInstanceId$movable_release() {
        return getRootMovableView().getInstanceId();
    }

    public final String getSelectedMarkdownText() {
        MovableDocumentInfo r100 = getMovableDocumentInfo();
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = Lark_markdown_renderKt.m8391ffiMovableGetMarkdownFromRangefeOb9K0(r100.m8423getDocumentIdpVg5ArA(), r100.m8424getDocumentVersionpVg5ArA());
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return null;
    L11:
        return r101;
    L8:
        r102 = false;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f432585y == false) goto L6;
        e();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (Intrinsics.areEqual(getRootMovableView(), this) == false) goto L5;
        MovableGlobalManager.f432543d.a().e(getMovableInstanceId$movable_release());
    L5:
        BuildersKt.launch$default(this.f432567g, null, null, new AnonymousClass1(this, null), 3, null);
        super.onDetachedFromWindow();
    }

    public final com.ss.android.lark.movable.b getEventClickListener$movable_release() {
        return this.f432581u;
    }

    public final p getImageLoader$movable_release() {
        return this.f432582v;
    }

    public final ScrollIsland getParentIsland$movable_release() {
        return this.f432578r;
    }

    public final MovableSelectionManager getSelectionManager$movable_release() {
        return this.f432574n;
    }

    @Override // com.ss.android.lark.movable.OverflowClipContainer
    public final boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r100 instanceof com.ss.android.lark.movable.selection.d) == false) goto L5;
        return true;
    L5:
        if (this.f432571k == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (this.f432572l == false) goto L9;
        r101 = true;
        goto L10
    }

    public void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f432582v = r100.f432587a;
        com.ss.android.lark.movable.b r101 = r100.f432588b;
        if (r101 != null) goto L5;
        r101 = new com.ss.android.lark.movable.a();
    L5:
        this.f432581u = r101;
        this.f432571k = r100.f432589c;
        this.f432577q = r100.f432590d;
        this.f432563c.f432617a = null;
        this.f432586z = r100.f432591e;
        this.f432583w = r100.f432592f;
        if (getWidth() <= 0) goto L10;
        Function2<? super Integer, ? super Integer, Unit> r102 = this.f432586z;
        if (r102 == null) goto L10;
        r102.invoke(Integer.valueOf(getWidth()), 0);
    L10:
        this.f432585y = true;
        e();
    }

    public final void g(byte[] r100) {
        if (Arrays.equals(this.f432564d, r100) == false) goto L6;
        Log.i("MovableView", "received empty attachment render data, ignore");
        return;
    L6:
        this.f432564d = r100;
        List r101 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this), MovableView$removeAttachment$1.INSTANCE));
        Log.i("MovableView", "remove all Attachment, size: " + r101.size());
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        removeView((View) r102.next());
        goto L8
    L10:
        this.f432563c.b(this, r100);
    }

    public final void h(boolean r110) {
        Integer r100 = null;
        if (r110 == true) goto L9;
        com.ss.android.lark.movable.c r111 = this.f432576p;
        if (r111 == null) goto L7;
        r111.a();
    L7:
        this.f432576p = null;
        return;
    L9:
        MovableDocumentInfo r112 = this.f432580t;
        if (r112 != null) goto L102;
        List r113 = null;
    L23:
        if (r113 != null) goto L25;
    L97:
        com.ss.android.lark.movable.c r114 = this.f432576p;
        if (r114 == null) goto L100;
        r114.a();
    L100:
        this.f432576p = null;
        return;
    L25:
        if (r113.size() < 4) goto L97;
        float r101 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r113, 0)).floatValue(), getContext());
        boolean r102 = true;
        float r103 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r113, 1)).floatValue(), getContext());
        float r104 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r113, 2)).floatValue(), getContext());
        float r115 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r113, 3)).floatValue(), getContext());
        if (this.f432576p != null) goto L37;
        com.ss.android.lark.movable.c r116 = new com.ss.android.lark.movable.c(getContext());
        this.f432576p = r116;
        Intrinsics.checkNotNullParameter(this, "parent");
        addView(r116);
        r116.setAlpha(1.0f);
        ObjectAnimator r117 = r116.f432657c;
        if (r117 != null) goto L31;
    L33:
        boolean r118 = false;
    L34:
        if (r118 == true) goto L37;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        r105.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r105.setRepeatCount(-1);
        r105.setInterpolator(new LinearInterpolator());
        r105.start();
        r116.f432657c = r105;
        goto L37
    L31:
        if (r117.isRunning() != true) goto L33;
        r118 = true;
    L37:
        float r106 = (r101 + r104) + com.ss.android.lark.movable.utils.b.e(4, getContext());
        float r107 = 2;
        float r108 = r103 + (r115 / r107);
        com.ss.android.lark.movable.c r119 = this.f432576p;
        if (r119 == null) goto L40;
        float r120 = r119.getRadius();
    L41:
        float r109 = r108 - r120;
        Log.d("MovableView", "loadingViewX: " + r106 + ", loadingViewCenterY: " + r109);
        com.ss.android.lark.movable.c r121 = this.f432576p;
        float r122 = (float) getWidth();
        float r123 = (float) getHeight();
        if (r121 == null) goto L52;
        Integer r124 = Integer.valueOf(r121.getMeasuredWidth());
        if (r124.intValue() <= 0) goto L46;
        boolean r125 = true;
    L47:
        if (r125 == true) goto L50;
        r124 = null;
    L50:
        if (r124 == null) goto L52;
        float r126 = r124.intValue();
    L56:
        if (r121 == null) goto L65;
        Integer r127 = Integer.valueOf(r121.getMeasuredHeight());
        if (r127.intValue() <= 0) goto L60;
        boolean r128 = true;
    L61:
        if (r128 == false) goto L63;
        r100 = r127;
    L63:
        if (r100 == null) goto L65;
        float r129 = r100.intValue();
    L70:
        if (r122 > 0.0f) goto L72;
    L87:
        if (r102 == false) goto L91;
        if (r121 == null) goto L104;
        r121.setVisibility(8);
        return;
    L104:
        return;
    L91:
        if (r121 == null) goto L93;
        r121.setVisibility(0);
    L93:
        if (r121 == null) goto L95;
        r121.setTranslationX(r106);
    L95:
        if (r121 == null) goto L105;
        r121.setTranslationY(r109);
        return;
    L105:
        return;
    L72:
        if (r123 <= 0.0f) goto L87;
        if (r126 <= 0.0f) goto L87;
        if (r129 <= 0.0f) goto L87;
        if (r106 < 0.0f) goto L87;
        if (r109 < 0.0f) goto L87;
        if ((r126 + r106) > r122) goto L87;
        if ((r129 + r109) > r123) goto L87;
        r102 = false;
        goto L87
    L60:
        r128 = false;
    L65:
        if (r121 == null) goto L67;
        float r130 = r121.getRadius();
    L68:
        r129 = r130 * r107;
        goto L70
    L67:
        r130 = 0.0f;
        goto L68
    L46:
        r125 = false;
    L52:
        if (r121 == null) goto L54;
        float r131 = r121.getRadius();
    L55:
        r126 = r131 * r107;
        goto L56
    L54:
        r131 = 0.0f;
        goto L55
    L40:
        r120 = 0.0f;
        goto L41
    L102:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L13
        Object r133 = Result.m9449constructorimpl(Lark_markdown_renderKt.m8383ffiGetTailElementfeOb9K0(r112.m8423getDocumentIdpVg5ArA(), r112.m8424getDocumentVersionpVg5ArA()));     // Catch: Throwable -> L13
    L15:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L19;
        Log.e("MovableView", "ffiGetTailElement failed: " + r134.getMessage());
    L19:
        if (Result.m9455isFailureimpl(r133) == false) goto L21;
        r133 = null;
    L21:
        r113 = (List) r133;
    L13:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = getGestureDetector().onTouchEvent(r100);
        if (this.f432571k == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L15;
        if (r101 == false) goto L11;
        return true;
    L11:
        if (super.onTouchEvent(r100) == true) goto L27;
        return false;
    L27:
        return true;
    L15:
        MovableSelectionManager r103 = this.f432574n;
        if (r103 == null) goto L18;
        r103.l(r100);
        boolean r104 = true;
    L19:
        if (r101 == true) goto L28;
        if (r104 == false) goto L22;
        return true;
    L22:
        if (super.onTouchEvent(r100) == true) goto L30;
        return false;
    L30:
        return true;
    L28:
        return true;
    L18:
        r104 = false;
        goto L19
    L5:
        if (this.f432572l == false) goto L7;
        r102 = true;
        goto L8
    }

    public final void setEventClickListener$movable_release(com.ss.android.lark.movable.b r100) {
        this.f432581u = r100;
    }

    public final void setImageLoader$movable_release(p r100) {
        this.f432582v = r100;
    }

    public final void setParentIsland$movable_release(ScrollIsland r100) {
        this.f432578r = r100;
    }

    public final void setSelectionManager$movable_release(MovableSelectionManager r100) {
        this.f432574n = r100;
    }

    public void setup(Function1<? super b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        b r101 = new b();
        r100.invoke(r101);
        setupWithConfig(r101);
    }

    public final void setupWithConfig(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (this.f432584x == false) goto L5;
        return;
    L5:
        b(r100);
        this.f432584x = true;
        MovableGlobalManager.f432543d.a().c(getMovableInstanceId$movable_release(), this);
    }

    public MovableView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f432562b = LazyKt.lazy(MovableView$instanceId$2.INSTANCE);
        this.f432563c = new MovableAttachmentApplier();
        this.f432567g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        if (Build.VERSION.SDK_INT < 31) goto L5;
        boolean r102 = true;
    L6:
        this.f432569i = r102;
        ksb.b r103 = new ksb.b(r100);
        r103.setEnableDrawGlyphs(r102);
        this.f432570j = r103;
        this.f432571k = true;
        this.f432572l = true;
        this.f432573m = new LinkedHashMap();
        this.f432575o = LazyKt.lazy(new MovableView$gestureDetector$2(r100, this));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: getScrollIslandScrollOffset-feOb9K0 */
    public final List<Float> mo8415getScrollIslandScrollOffsetfeOb9K0(int r100, int r101) {
        Log.d("native_get_scroll_island_scroll_offset", "getScrollIslandScrollOffset() called");
        Float[] r102 = new Float[2];
        ScrollIsland r103 = (ScrollIsland) ((LinkedHashMap) this.f432573m).get(Integer.valueOf(r101));
        if (r103 == null) goto L5;
        float r104 = com.ss.android.lark.movable.utils.b.g(r103.getScrollX(), getContext());
    L6:
        r102[0] = Float.valueOf(r104);
        r102[1] = Float.valueOf(0.0f);
        return CollectionsKt.listOf(r102);
    L5:
        r104 = 0.0f;
        goto L6
    }

    public final void i(byte[] r110, MovableDocumentInfo r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        boolean r100 = true;
        if (r110.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (Arrays.equals(this.f432565e, r110) == false) goto L11;
        return;
    L11:
        Log.d("MovableView", "updateTextRender called, data size: " + r110.length);
        this.f432565e = r110;
        if (indexOfChild(this.f432570j) == (-1)) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
    L38:
        this.f432570j.a(r110, r111);
        return;
    L17:
        if (indexOfChild(this.f432570j) != (-1)) goto L20;
        r100 = false;
    L20:
        if (r100 == true) goto L38;
        addView(this.f432570j, new FrameLayout.LayoutParams(-1, -1));
        ksb.b r103 = this.f432570j;
        if (getWidth() > 0) goto L25;
    L28:
        MovableSelectionManager.a r104 = f();
        if (r104 == null) goto L35;
        Intrinsics.checkNotNullParameter(this, "movableView");
        com.ss.android.lark.movable.selection.h r105 = r104.f432751a;
        com.ss.android.lark.movable.selection.g r106 = r104.f432752b;
        boolean r107 = r104.f432753c;
        boolean r108 = r104.f432754d;
        MovableLongPressBehavior r109 = r104.f432755e;
        HandleStyle r112 = r104.f432756f;
        Integer r113 = r104.f432757g;
        if (r113 == null) goto L33;
        int r114 = r113.intValue();
    L34:
        MovableSelectionManager r115 = new MovableSelectionManager(this, r105, r106, r107, r108, r109, r112, r114, r104.f432758h, r104.f432759i);
    L36:
        if (r115 == null) goto L38;
        this.f432574n = r115;
        goto L38
    L33:
        r114 = UIUtils.getColor(getContext(), R.color.primary_fill_default);
        goto L34
    L35:
        r115 = null;
        goto L36
    L25:
        if (getHeight() <= 0) goto L28;
        r103.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        r103.layout(0, 0, getWidth(), getHeight());
        goto L28
    L14:
        r102 = false;
        goto L15
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getLayoutParams().width;
        int r103 = getLayoutParams().height;
        if (r102 >= 0) goto L6;
        r102 = FrameLayout.resolveSize(0, r100);
    L6:
        if (r103 >= 0) goto L9;
        r103 = FrameLayout.resolveSize(0, r101);
    L9:
        setMeasuredDimension(r102, r103);
        int r104 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
        int r105 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        Iterator<View> r106 = ViewGroupKt.getChildren(this).iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        measureChild(r106.next(), r104, r105);
        goto L11
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (isShown() == true) goto L6;
        BuildersKt.launch$default(this.f432567g, null, null, new C119321(this, null), 3, null);
        return;
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: eventClick-OzbTU-A */
    public final void mo8414eventClickOzbTUA(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        com.ss.android.lark.movable.b r103 = this.f432581u;
        if (r103 == null) goto L6;
        r103.d(getContext(), r100, r101, r102);
        return;
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: measureAttachment-OzbTU-A */
    public final List<Float> mo8417measureAttachmentOzbTUA(int r100, float r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "propertyString");
        return CollectionsKt.emptyList();
    }

    public final void c(c r100, List<Pair<Integer, byte[]>> r101, boolean r110, List<? extends Pair<? extends MovableIslandsOpsApplier.Op, jsb.a>> r111) {
        if (r110 == false) goto L53;
        List r112 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this), MovableView$removeScrollIsland$1.INSTANCE));
        Log.d("MovableView", "remove all ScrollIsland, size: " + r112.size());
        Iterator r113 = r112.iterator();
    L4:
        Integer r102 = null;
        if (r113.hasNext() == false) goto L13;
        View r103 = (View) r113.next();
        removeView(r103);
        Map<Integer, ScrollIsland> r104 = this.f432573m;
        if ((r103 instanceof ScrollIsland) == false) goto L9;
        ScrollIsland r105 = (ScrollIsland) r103;
    L10:
        if (r105 == null) goto L12;
        r102 = Integer.valueOf(r105.getIslandID());
    L12:
        TypeIntrinsics.asMutableMap(r104).remove(r102);
        goto L4
    L9:
        r105 = null;
        goto L10
    L13:
        List<? extends Pair<? extends MovableIslandsOpsApplier.Op, jsb.a>> r114 = r111;
        if (r114 != null) goto L16;
    L19:
        boolean r115 = true;
    L20:
        if (r115 == true) goto L41;
        MovableIslandsOpsApplier r116 = new MovableIslandsOpsApplier(this, new g(this));
        Intrinsics.checkNotNullParameter(r111, "ops");
        Iterator<T> r117 = r111.iterator();
    L24:
        if (r117.hasNext() == false) goto L41;
        Pair r106 = (Pair) r117.next();
        MovableIslandsOpsApplier.Op r107 = (MovableIslandsOpsApplier.Op) r106.component1();
        jsb.a r108 = (jsb.a) r106.component2();
        int r109 = MovableIslandsOpsApplier.c.f432676a[r107.ordinal()];
        if (r109 != 1) goto L28;
        r116.a(r116.f432669a, r108);
        goto L24
    L28:
        if (r109 != 2) goto L30;
        MovableView r118 = r116.f432669a;
        int r119 = r108.f500270a;
        ScrollIsland r120 = (ScrollIsland) r118.findViewWithTag(Integer.valueOf(r119));
        if (r120 == null) goto L24;
        r118.removeView(r120);
        r116.f432670b.b(r119);
        Log.d("MovableIslandsOpsApplier", "remove island islandID=" + r119);
        goto L24
    L30:
        if (r109 != 3) goto L36;
        MovableView r121 = r116.f432669a;
        ScrollIsland r122 = (ScrollIsland) r121.findViewWithTag(Integer.valueOf(r108.f500270a));
        if (r122 != null) goto L33;
        r116.a(r121, r108);
        Log.d("MovableIslandsOpsApplier", "update island new, islandID=" + r108.f500270a);
        goto L24
    L33:
        r122.a(r108);
        Log.d("MovableIslandsOpsApplier", "update island islandID=" + r108.f500270a);
        goto L24
    L36:
        throw new NoWhenBranchMatchedException();
    L41:
        Iterator<Pair<Integer, byte[]>> r123 = r101.iterator();
    L43:
        if (r123.hasNext() == false) goto L82;
        Pair<Integer, byte[]> r124 = r123.next();
        int r125 = r124.component1().intValue();
        byte[] r126 = r124.component2();
        if (r126 == null) goto L43;
        ScrollIsland r127 = (ScrollIsland) ((LinkedHashMap) this.f432573m).get(Integer.valueOf(r125));
        if (r127 == null) goto L48;
        Log.i("MovableView", "islandData content render, islandID: " + r125 + ", docInfo: " + r100.f432594b.toString() + ", islandRenderDataSize: " + r126.length);     // Catch: Exception -> L51
        Intrinsics.checkNotNullParameter(r126, "renderData");     // Catch: Exception -> L51
        r127.f432678b.i(r126, null);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        Log.e("MovableView", "Failed to render island " + r125 + ": " + e.getMessage(), e);
        goto L43
    L48:
        Log.w("MovableView", "island " + r125 + " disappeared before apply");
        goto L43
    L82:
        return;
    L16:
        if (r114.isEmpty() == true) goto L19;
        r115 = false;
        goto L20
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Log.i("MovableView", "onSizeChanged, w:" + r100 + ", h:" + r101 + ", oldw:" + r102 + ", oldh:" + r103);
        if (r100 == r102) goto L7;
        Function2<? super Integer, ? super Integer, Unit> r104 = this.f432586z;
        if (r104 == null) goto L7;
        r104.invoke(Integer.valueOf(r100), Integer.valueOf(r102));
    L7:
        if (r102 <= 0) goto L23;
        if (r100 == r102) goto L24;
        MovableSelectionManager r105 = this.f432574n;     // Catch: Exception -> L18
        if (r105 == null) goto L13;
        r105.d();     // Catch: Exception -> L18
    L13:
        if (Intrinsics.areEqual(getRootMovableView(), this) == true) goto L25;
        MovableSelectionManager r106 = getRootMovableView().f432574n;     // Catch: Exception -> L18
        if (r106 == null) goto L26;
        r106.d();     // Catch: Exception -> L18
        return;
    L26:
        return;
    L25:
        return;
    L18:
        e = move-exception;
        Log.w("MovableView", "clearSelection on width changed failed: " + e.getMessage());
        return;
    L24:
        return;
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: markHighlightUpdate-iyaXS9w */
    public final void mo8416markHighlightUpdateiyaXS9w(int r110, float r111, float r112, float r113, float r114) {
        MovableSelectionManager r115 = this.f432574n;
        if (r115 == null) goto L83;
        ksb.b r116 = r115.f432739o;
        byte[] r117 = Lark_markdown_renderKt.m8382ffiGetHighlightStreamfeOb9K0(r115.g(), r115.h());
        LruCache<String, byte[]> r118 = ksb.b.f505992f;
        r116.a(r117, null);
        Iterator<T> r119 = r115.f432725a.getInnerMovableViews().iterator();
    L5:
        int r120 = 0;
        if (r119.hasNext() == false) goto L15;
        MovableView r121 = (MovableView) r119.next();
        MovableSelectionManager r100 = r121.getSelectionManager$movable_release();
        if (r100 == null) goto L5;
        ksb.b r101 = r100.f432739o;
        if (r101 == null) goto L5;
        ScrollIsland r122 = r121.getParentIsland$movable_release();
        if (r122 == null) goto L14;
        r120 = UInt.m9544constructorimpl(r122.getIslandID());
    L14:
        r101.a(Lark_markdown_renderKt.m8398ffiRequestIslandHighlightStreamzly0blg(r120, r115.g(), r115.h()), null);
        goto L5
    L15:
        List<FfiCaret> r123 = Lark_markdown_renderKt.m8394ffiMovableRequestCaretszly0blg(r115.i(), r115.g(), r115.h());
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator<T> r125 = r123.iterator();
    L17:
        if (r125.hasNext() == false) goto L19;
        FfiCaret r102 = (FfiCaret) r125.next();
        Context r103 = r115.f432738n;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        r124.add(FfiCaret.m8374copyrhtGY3M$default(r102, com.ss.android.lark.movable.utils.b.d(r102.getX(), r103), com.ss.android.lark.movable.utils.b.d(r102.getY(), r103), com.ss.android.lark.movable.utils.b.d(r102.getHeight(), r103), false, 0, 0, 56, null));
        goto L17
    L19:
        Iterator r126 = r124.iterator();
    L21:
        if (r126.hasNext() == false) goto L25;
        Object r104 = r126.next();
        if ((!((FfiCaret) r104).getDirection()) == false) goto L21;
    L26:
        FfiCaret r105 = (FfiCaret) r104;
        int r127 = r115.i();
        if (r105 == null) goto L29;
        UInt r106 = UInt.m9538boximpl(r105.m8378getCanvasIdpVg5ArA());
    L31:
        if (UInt.m9550equalsimpl(r127, r106) == false) goto L33;
        FfiCaret r128 = r105;
    L34:
        r115.o(true, r128);
        Iterator<T> r129 = r115.f432725a.getInnerMovableViews().iterator();
    L36:
        if (r129.hasNext() == false) goto L51;
        MovableView r107 = (MovableView) r129.next();
        MovableSelectionManager r108 = r107.getSelectionManager$movable_release();
        if (r108 == null) goto L36;
        ScrollIsland r109 = r107.getParentIsland$movable_release();
        if (r109 == null) goto L42;
        UInt r130 = UInt.m9538boximpl(UInt.m9544constructorimpl(r109.getIslandID()));
    L43:
        if (r105 == null) goto L45;
        UInt r131 = UInt.m9538boximpl(r105.m8378getCanvasIdpVg5ArA());
    L47:
        if (Intrinsics.areEqual(r130, r131) == false) goto L49;
        FfiCaret r132 = r105;
    L50:
        r108.o(true, r132);
        goto L36
    L49:
        r132 = null;
        goto L50
    L45:
        r131 = null;
        goto L47
    L42:
        r130 = null;
        goto L43
    L51:
        Iterator r133 = r124.iterator();
    L53:
        if (r133.hasNext() == false) goto L57;
        Object r134 = r133.next();
        if (((FfiCaret) r134).getDirection() == false) goto L53;
    L58:
        FfiCaret r135 = (FfiCaret) r134;
        int r136 = r115.i();
        if (r135 == null) goto L61;
        UInt r137 = UInt.m9538boximpl(r135.m8378getCanvasIdpVg5ArA());
    L63:
        if (UInt.m9550equalsimpl(r136, r137) == false) goto L65;
        FfiCaret r138 = r135;
    L66:
        r115.o(false, r138);
        Iterator<T> r139 = r115.f432725a.getInnerMovableViews().iterator();
    L68:
        if (r139.hasNext() == false) goto L108;
        MovableView r140 = (MovableView) r139.next();
        MovableSelectionManager r141 = r140.getSelectionManager$movable_release();
        if (r141 == null) goto L68;
        ScrollIsland r142 = r140.getParentIsland$movable_release();
        if (r142 == null) goto L74;
        UInt r143 = UInt.m9538boximpl(UInt.m9544constructorimpl(r142.getIslandID()));
    L75:
        if (r135 == null) goto L77;
        UInt r144 = UInt.m9538boximpl(r135.m8378getCanvasIdpVg5ArA());
    L79:
        if (Intrinsics.areEqual(r143, r144) == false) goto L81;
        FfiCaret r145 = r135;
    L82:
        r141.o(false, r145);
        goto L68
    L81:
        r145 = null;
        goto L82
    L77:
        r144 = null;
        goto L79
    L74:
        r143 = null;
        goto L75
    L108:
        return;
    L65:
        r138 = null;
        goto L66
    L61:
        r137 = null;
        goto L63
    L57:
        r134 = null;
        goto L58
    L33:
        r128 = null;
        goto L34
    L29:
        r106 = null;
        goto L31
    L25:
        r104 = null;
        goto L26
    }
}
