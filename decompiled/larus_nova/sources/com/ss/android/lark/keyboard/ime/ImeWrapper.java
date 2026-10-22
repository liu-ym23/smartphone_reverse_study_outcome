package com.ss.android.lark.keyboard.ime;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.util.Pools;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ³\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b°\u0001±\u0001²\u0001³\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010E\u001a\u00020AH\u0014J\b\u0010F\u001a\u00020AH\u0014J\b\u0010G\u001a\u00020)H\u0002J\u0010\u0010H\u001a\u00020A2\u0006\u0010/\u001a\u00020\tH\u0016J\u0018\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020AH\u0002J\b\u0010N\u001a\u00020\u0017H\u0016J\b\u0010O\u001a\u00020\u0017H\u0016J\b\u0010P\u001a\u00020\u0017H\u0016J\u0006\u0010Q\u001a\u00020-J\b\u0010R\u001a\u00020\u0017H\u0016J\b\u0010S\u001a\u00020\u0017H\u0016J\u0018\u0010T\u001a\u00020A2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0012H\u0016J\b\u0010U\u001a\u00020\u0017H\u0016J\b\u0010V\u001a\u00020\u0017H\u0016J\b\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020:H\u0016J\b\u0010\\\u001a\u00020\tH\u0016J\b\u0010]\u001a\u00020AH\u0002J\b\u0010^\u001a\u00020AH\u0002J\u0010\u0010_\u001a\u00020A2\u0006\u0010`\u001a\u00020\u0017H\u0016J\b\u0010a\u001a\u00020\u0017H\u0016J\u0010\u0010b\u001a\u00020A2\u0006\u0010`\u001a\u00020\u0017H\u0016J\b\u0010c\u001a\u00020\u0017H\u0016J\u0012\u0010d\u001a\u00020A2\b\b\u0002\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020AH\u0002J/\u0010g\u001a\u00020A*\u00020h2!\u0010i\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020A0jH\u0002J\u001c\u0010n\u001a\u00020A2\b\b\u0002\u0010o\u001a\u00020\t2\b\b\u0002\u0010p\u001a\u00020\u0017H\u0002J\f\u0010q\u001a\u00020A*\u00020?H\u0002J=\u0010r\u001a\u00020h2\u0006\u0010e\u001a\u00020\t2\u0006\u0010o\u001a\u00020\t2\b\b\u0002\u0010s\u001a\u00020\t2\u0019\b\u0002\u0010t\u001a\u0013\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020A0j¢\u0006\u0002\buH\u0002J\b\u0010v\u001a\u00020\tH\u0002J\u0010\u0010w\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\b\u0010x\u001a\u00020&H\u0002J\u0006\u0010y\u001a\u00020zJ\u0006\u0010{\u001a\u00020|J\u0018\u0010}\u001a\u00020A2\u0006\u0010~\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020\tH\u0014J6\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020\u00172\u0007\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0014J\u0012\u0010\u0086\u0001\u001a\u00020A2\u0007\u0010\u0087\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020A2\u0007\u0010\u0087\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020A2\u0007\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u008b\u0001\u001a\u00020A2\u0007\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0016J\u001a\u0010\u008d\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u0017H\u0016J\u0011\u0010\u008f\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\u0012\u0010\u0090\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020 H\u0002J&\u0010\u0092\u0001\u001a\u00020A2\u0007\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0095\u0001\u001a\u00020|H\u0002J\u0011\u0010\u0096\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\t\u0010\u0097\u0001\u001a\u00020AH\u0002J\t\u0010\u0098\u0001\u001a\u00020AH\u0002J\t\u0010\u0099\u0001\u001a\u00020AH\u0002J\t\u0010\u009a\u0001\u001a\u00020AH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020A2\u0006\u0010\\\u001a\u00020\tH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020A2\u0007\u0010\u009d\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u009e\u0001\u001a\u00020 2\u0007\u0010\u009f\u0001\u001a\u00020LH\u0002J\t\u0010 \u0001\u001a\u00020\u0017H\u0002J\u0012\u0010¡\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020 H\u0002J\t\u0010¢\u0001\u001a\u00020AH\u0002J\u001b\u0010£\u0001\u001a\u00020A2\u0007\u0010¤\u0001\u001a\u00020 2\u0007\u0010¥\u0001\u001a\u00020\u0017H\u0002J\u001b\u0010¦\u0001\u001a\u00020A2\u0007\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\tH\u0002J\u0015\u0010§\u0001\u001a\u00020A2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0014J\n\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\u0015\u0010¬\u0001\u001a\u00020A*\n\u0012\u0005\u0012\u00030®\u00010\u00ad\u0001H\u0002J\u0015\u0010¯\u0001\u001a\u00020A*\n\u0012\u0005\u0012\u00030®\u00010\u00ad\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020 0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b1\u00102R\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:0$X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006´\u0001"}, d2 = {"Lcom/ss/android/lark/keyboard/ime/ImeWrapper;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/keyboard/ime/ImeController;", "Lcom/ss/android/lark/keyboard/ime/ImeCoordinator$InsetsDispatchListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "bottomSpacing", "lastImeHeight", "minPanelHeight", "maxPanelHeightProvider", "Lkotlin/Function0;", "", "storeImeHeight", "panelHeight", "enableWindowInsetsAnim", "", "imeHeightObserver", "", "Lcom/ss/android/lark/keyboard/ime/ImeHeightObserver;", "imeInsetsInterceptor", "Lcom/ss/android/lark/keyboard/ime/ImeInsetsInterceptor;", "panelHeightFollowIme", "deferredInsets", "lastWindowInsets", "Lcom/ss/android/lark/keyboard/ime/ImeInsetsHolder;", "innerActionHandle", "Lcom/ss/android/lark/keyboard/ime/ImeEventHandleImpl;", "actionHandles", "", "imeAnimController", "Lcom/ss/android/lark/keyboard/ime/ImeWrapper$ImeAnimController;", "imeEnable", "innerContainer", "Lcom/ss/android/lark/keyboard/ime/ImePanelContainer;", "insetsPool", "Landroidx/core/util/Pools$SimplePool;", "focusDelegateProvider", "Landroid/view/View;", "hasPendingPanelAnim", "value", "inAnimationCount", "setInAnimationCount", "(I)V", "imeState", "Lcom/ss/android/lark/keyboard/ime/ImeStateFlow;", "getImeState", "()Lcom/ss/android/lark/keyboard/ime/ImeStateFlow;", "panelState", "getPanelState", "extraMap", "", "getExtraMap$keyboard_base_release", "()Ljava/util/Map;", "runningAnimators", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/animation/Animator;", "setPanelState", "", "state", "Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;", "setImeState", "onAttachedToWindow", "onDetachedFromWindow", "prepareInnerContainer", "setBottomSpacing", "onGlobalDispatchInsets", "decorFitSystemWindow", "dispatchWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "adjustPanelHeightBeforeShow", "showPanel", "hidePanel", "showIme", "requestFocusForShowIme", "hideIme", "hideImeUseCompat", "setFocusDelegate", "isImeShow", "isPanelShow", "getPanel", "Landroid/view/ViewGroup;", "getHandle", "Lcom/ss/android/lark/keyboard/ime/ImeEventHandle;", "key", "height", "attachImpl", "detachImpl", "setAnimationEnable", "enable", "isAnimationEnable", "setImeEnable", "isInAnimation", "playEnterAnim", "fromHeight", "cancelRunningAnimations", "doOnEndIgnoreCancel", "Landroid/animation/ValueAnimator;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "playExitAnim", "toHeight", "notifyExit", "startOnNextFrame", "preparePanelAnimator", "type", "initFunction", "Lkotlin/ExtensionFunctionType;", "getInitialImeHeight", "setImeHeightToStore", "createImeAnimController", "getAnimDuration", "", "getAnimInterpolator", "Landroid/view/animation/Interpolator;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "addImeHeightObserver", "listener", "removeImeHeightObserver", "addInsetsInterceptor", "interceptor", "removeInsetsInterceptor", "setPanelHeight", "setPanelHeightImmediately", "followIme", "setHeightInner", "notifyHeightChangeForAnimationOfIme", "imeInsetsHolder", "notifyHeightChangeForAnimation", "from", RemoteMessageConst.TO, "interpolator", "notifyHeightChange", "notifyPanelShow", "notifyPanelHide", "notifyImeShow", "notifyImeHide", "updateHeightWhenInsetsChange", "recordImeHeight", "imeHeight", "obtainImeInsetsHolder", "insets", "isOfficeSdkRuntime", "consumeImeInsets", "notifyImeWrapperHeightUpdate", "handleWindowInsets", "insetsHolder", "systemDispatch", "startCompatInsetsAnimation", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "buildLayoutSnapshot", "", "consume", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/keyboard/ime/ImeEventHandleImpl$ActionWrapper;", "pollExecuteOnce", "ImeAnimControllerImpl", "ImeAnimController", "InterpolatorFilter", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImeWrapper extends FrameLayout implements com.ss.android.lark.keyboard.ime.a, ImeCoordinator.b {
    public static final a B = null;
    public final CopyOnWriteArrayList<Animator> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f429340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f429341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f429342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f429343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f429344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Float> f429345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f429346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f429347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f429348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<e> f429349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<g> f429350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f429351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f429352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f429353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f429354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<Integer, d> f429355p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImeAnimControllerImpl f429356q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f429357r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f429358s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Pools.SimplePool<f> f429359t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function0<? extends View> f429360u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f429361v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f429362w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j f429363x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f429364y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<Integer, Object> f429365z;

    public final class ImeAnimControllerImpl extends WindowInsetsAnimationCompat.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Interpolator f429366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f429367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImeWrapper f429368c;

        public ImeAnimControllerImpl(ImeWrapper r100) {
            this.f429368c = r100;
            super(1);
            this.f429366a = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
            this.f429367b = 285;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public final void onPrepare(final WindowInsetsAnimationCompat r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onPrepare(r100);
            Interpolator r101 = r100.getInterpolator();
            if (r100.getTypeMask() != WindowInsetsCompat.Type.ime()) goto L6;
            if (r101 == null) goto L6;
            this.f429366a = r101;
            this.f429367b = r100.getDurationMillis();
        L6:
            com.ss.android.lark.keyboard.ime.b r102 = com.ss.android.lark.keyboard.ime.b.f429377a;
            final ImeWrapper r103 = this.f429368c;
            Function0<String> r104 = new ImeWrapper$ImeAnimControllerImpl$onPrepare$1(r100, r103);
            r102.getClass();
            com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r104);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public final WindowInsetsCompat onProgress(final WindowInsetsCompat r100, final List<WindowInsetsAnimationCompat> r101) {
            Intrinsics.checkNotNullParameter(r100, "insets");
            Intrinsics.checkNotNullParameter(r101, "runningAnimations");
            com.ss.android.lark.keyboard.ime.b r102 = com.ss.android.lark.keyboard.ime.b.f429377a;
            final ImeWrapper r103 = this.f429368c;
            Function0<String> r104 = new ImeWrapper$ImeAnimControllerImpl$onProgress$1(r100, r101, r103);
            r102.getClass();
            com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r104);
            return r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Interpolator f429369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f429370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f429371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f429372d;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = this.f429369a.getInterpolation(r100);
            if (this.f429371c >= 0) goto L5;
            float r102 = Math.max(0.0f, r101 - this.f429370b);
            float r103 = this.f429372d;
        L7:
            return r102 * r103;
        L5:
            r102 = Math.min(this.f429370b, r101);
            r103 = this.f429372d;
            goto L7
        }

        public b(Interpolator r100, float r101, int r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f429369a = r100;
            this.f429370b = r101;
            this.f429371c = r102;
            this.f429372d = r103;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f429373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImeWrapper f429374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Animator f429375c;

        public c(View r100, ImeWrapper r101, Animator r102) {
            this.f429373a = r100;
            this.f429374b = r101;
            this.f429375c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("ImeWrapper", "startOnNextFrame: invoked");     // Catch: Throwable -> L4
            this.f429374b.f429361v = false;     // Catch: Throwable -> L4
            this.f429375c.start();     // Catch: Throwable -> L4
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
        B = new a();
    }

    public ImeWrapper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImeWrapper(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getInitialImeHeight() {
        int r100 = this.f429341b.getInt("lark:im:keyboard:imeHeight", 0);
        Log.i("ImeWrapper", "getInitialImeHeight: heightInSp is " + r100);
        if (r100 > this.f429344e) goto L6;
        int r101 = s.f429413a;
        Context r102 = this.f429340a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIUtils.dp2px(r102, 260.0f);
    L6:
        return r100;
    }

    public final boolean T() {
        if (this.f429362w <= 0) goto L5;
    L10:
        return true;
    L5:
        if (this.f429352m == true) goto L10;
        if (this.f429361v == true) goto L10;
        return false;
    }

    public final void X() {
        Iterator<T> r100 = this.f429349j.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).J();
        goto L4
    }

    public final void Y() {
        Log.d("ImeWrapper", "state change: panel hide");
        R(this.f429354o.f429381d);
        Iterator r100 = ((LinkedHashMap) this.f429355p).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        R(((d) r100.next()).f429381d);
        goto L4
    }

    public final void Z() {
        Log.d("ImeWrapper", "state change: panel show");
        R(this.f429354o.f429380c);
        Iterator r100 = ((LinkedHashMap) this.f429355p).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        R(((d) r100.next()).f429380c);
        goto L4
    }

    public final long getAnimDuration() {
        return this.f429356q.f429367b;
    }

    public final Interpolator getAnimInterpolator() {
        return this.f429356q.f429366a;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean B() {
        if (getPanelState().b() == ImeStateDetail.Hide) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean a() {
        if (getPanelState().b().isHideOrExit() == false) goto L6;
        return false;
    L6:
        if (this.f429348i == false) goto L9;
        setPanelState(ImeStateDetail.Exit);
        a0(this, 0, true, 1);
        return true;
    L9:
        setPanelState(ImeStateDetail.Hide);
        this.f429358s.setVisibility(4);
        setHeightInner(0);
        Y();
        U(0);
        return true;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean e() {
        if (getPanelState().b().isEnterOrShow() == false) goto L6;
        return false;
    L6:
        if (this.f429362w <= 0) goto L9;
        Log.i("ImeWrapper", "showPanel: inAnimationCount > 0");
        return false;
    L9:
        int r100 = MathKt.roundToInt(this.f429345f.invoke().floatValue());
        if (this.f429347h <= r100) goto L12;
        Log.i("ImeWrapper", "adjustPanelHeightBeforeShow: panelHeight > maxPanelHeight, adjust panelHeight from " + this.f429347h + " to " + r100);
        int r101 = RangesKt.coerceAtMost(this.f429347h, r100);
        this.f429347h = r101;
        this.f429358s.setExpectHeight(r101);
    L12:
        ImeStateDetail r102 = getImeState().b();
        ImeStateDetail r103 = ImeStateDetail.Enter;
        if (r102 == r103) goto L19;
        if (getImeState().b() == ImeStateDetail.Show) goto L19;
        final int r104 = 0;
        boolean r105 = false;
    L22:
        Function0<Unit> r106 = new ImeWrapper$showPanel$showPanelActionNoAnim$1(this);
        if (this.f429348i == false) goto L29;
        setHeightInner(this.f429347h);
        this.f429358s.setVisibility(0);
        setPanelState(r103);
        Log.i("ImeWrapper", "panelEnter: prepare. form: " + r104 + ", to: " + this.f429347h + " , panelTransform: " + getPanelState() + " -> " + r103);
        Iterator<Animator> r107 = this.A.iterator();
    L26:
        if (r107.hasNext() == false) goto L28;
        r107.next().cancel();
        goto L26
    L28:
        V(r104, this.f429347h, getAnimInterpolator());
        Z();
        X();
        c0(b0(this, r104, this.f429347h, new ImeWrapper$playEnterAnim$1(this, r104)));
    L32:
        return true;
    L29:
        if (r105 == false) goto L31;
        this.f429354o.g(r106);
        goto L32
    L31:
        r106.invoke();
    L19:
        if (g() == true) goto L21;
        return false;
    L21:
        r104 = this.f429343d;
        r105 = true;
        goto L22
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean g() {
        if (getImeState().b().isEnterOrShow() == true) goto L6;
        return false;
    L6:
        Function0<? extends View> r100 = this.f429360u;
        if (r100 == null) goto L10;
        View r101 = r100.invoke();
        if (r101 == null) goto L10;
    L11:
        int r102 = s.f429413a;
        Context r103 = this.f429340a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "currentFocusView");
        KeyboardUtils.hideKeyboard(r103, r101);
        return true;
    L10:
        r101 = this;
        goto L11
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final int height() {
        return getLayoutParams().height;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f429358s.setVisibility(4);
        setPanelState(ImeStateDetail.Hide);
        int r100 = ImeCoordinator.f429333e;
        Intrinsics.checkNotNullParameter(this, "imeWrapper");
        if (isAttachedToWindow() == true) goto L5;
        Log.e("GlobalTraversalObserver", "imeWrapper is not attach to window , method return.");
        return;
    L5:
        View r101 = getRootView();
        int r102 = ImeCoordinator.f429333e;
        ImeCoordinator r103 = (ImeCoordinator) r101.findViewById(r102);
        if (r103 != null) goto L8;
        r103 = new ImeCoordinator(getContext());
        r103.setId(r102);
        ((ViewGroup) r101.findViewById(R.id.content)).addView(r103, 0);
    L8:
        ((ArrayList) r103.f429337d).add(this);
        r103.requestApplyInsets();
        r103.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = ImeCoordinator.f429333e;
        Intrinsics.checkNotNullParameter(this, "imeWrapper");
        if (isAttachedToWindow() == true) goto L5;
        Log.e("GlobalTraversalObserver", "imeWrapper is not attach to window , method return.");
    L5:
        ImeCoordinator r101 = (ImeCoordinator) getRootView().findViewById(ImeCoordinator.f429333e);
        if (r101 == null) goto L9;
        ((ArrayList) r101.f429337d).remove(this);
    L9:
        boolean r102 = B();
        setPanelState(ImeStateDetail.Hide);
        if (r102 == false) goto L12;
        Y();
    L12:
        setHeightInner(0);
        this.f429343d = 0;
        f r103 = this.f429353n;
        r103.f429384a = 0;
        r103.f429385b = 0;
        r103.f429386c = 0;
        r103.f429387d = false;
        r103.f429388e = false;
        r103.f429389f = false;
        U(0);
        this.f429358s.setVisibility(4);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean y() {
        if (getImeState().b() == ImeStateDetail.Hide) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final boolean z() {
        if (getImeState().b().isEnterOrShow() == false) goto L6;
        return false;
    L6:
        if (getImeState().b() != ImeStateDetail.Exit) goto L9;
        this.f429354o.g(new ImeWrapper$showIme$1(this));
    L9:
        if (this.f429357r == true) goto L12;
        Log.w("ImeWrapper", "business require disable show ime");
        return false;
    L12:
        Function0<? extends View> r100 = this.f429360u;
        if (r100 == null) goto L16;
        View r101 = r100.invoke();
        if (r101 == null) goto L16;
    L17:
        int r102 = s.f429413a;
        Intrinsics.checkNotNullParameter(r101, ButtonColorBean.StateFocus);
        if (CarUtils.a() == false) goto L20;
        KeyboardUtils.showKeyboardIgnoreExternalKeyboardCheck(r101);
        return true;
    L20:
        KeyboardUtils.showKeyboard(r101);
        return true;
    L16:
        r101 = this;
        goto L17
    }

    public final Map<Integer, Object> getExtraMap$keyboard_base_release() {
        return this.f429365z;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public j getImeState() {
        return this.f429363x;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public ViewGroup getPanel() {
        return this.f429358s;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public j getPanelState() {
        return this.f429364y;
    }

    public static final String J(ImeWrapper r100) {
        View r101 = r100.getRootView().findViewById(R.id.content);
        StringBuilder r102 = new StringBuilder("layout[rootH=");
        r102.append(r100.getRootView().getHeight());
        r102.append(", rootBottom=");
        r102.append(r100.getRootView().getBottom());
        r102.append(", contentH=");
        Integer r103 = null;
        if (r101 == null) goto L5;
        Integer r104 = Integer.valueOf(r101.getHeight());
    L6:
        r102.append(r104);
        r102.append(", contentBottom=");
        if (r101 == null) goto L9;
        r103 = Integer.valueOf(r101.getBottom());
    L9:
        r102.append(r103);
        r102.append(", wrapperH=");
        r102.append(r100.getHeight());
        r102.append(", wrapperTop=");
        r102.append(r100.getTop());
        r102.append(", wrapperBottom=");
        r102.append(r100.getBottom());
        r102.append(", innerH=");
        r102.append(r100.f429358s.getHeight());
        r102.append(", innerTop=");
        r102.append(r100.f429358s.getTop());
        r102.append(", innerBottom=");
        r102.append(r100.f429358s.getBottom());
        r102.append(']');
        return r102.toString();
    L5:
        r104 = null;
        goto L6
    }

    public static void R(LinkedList r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d.a) r101.next()).f429383b.invoke();
        goto L4
    L6:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if ((!((d.a) r104).f429382a) == false) goto L8;
        r102.add(r104);
        goto L8
    L12:
        r100.clear();
        r100.addAll(r102);
    }

    private final void setHeightInner(int r100) {
        Log.d("ImeWrapper", "setHeightInner: update height is " + r100);
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L7;
        r101.height = r100;
        setLayoutParams(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void setImeHeightToStore(int r100) {
        this.f429346g = r100;
        this.f429341b.putInt("lark:im:keyboard:imeHeight", r100);
    }

    private final void setImeState(ImeStateDetail r100) {
        j r101 = getImeState();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f429395a.setValue(r100);
    }

    private final void setInAnimationCount(int r100) {
        if (r100 > 2) goto L8;
        if (r100 < 0) goto L9;
        this.f429362w = r100;
        Log.d("ImeWrapper", "inAnimationCount: update value is " + r100);
        return;
    L9:
        return;
    }

    private final void setPanelState(ImeStateDetail r100) {
        j r101 = getPanelState();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f429395a.setValue(r100);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void H(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f429349j).remove(r100);
    }

    public final void U(int r100) {
        Iterator<T> r101 = this.f429349j.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e) r101.next()).a(r100);
        goto L4
    }

    public final void W(f r100) {
        Interpolator r101 = getAnimInterpolator();
        if (r100.f429387d == false) goto L12;
        int r102 = r100.f429386c + this.f429342c;
        int r103 = Math.max(r100.f429384a, r100.f429385b);
        if (r100.f429384a <= r100.f429385b) goto L7;
        int r104 = 1;
    L8:
        if (r104 <= 0) goto L10;
        int r105 = r103;
    L11:
        float r106 = r102 + r103;
        r101 = new b(r101, r105 / r106, r104, r106 / r103);
        goto L12
    L10:
        r105 = r102;
        goto L11
    L7:
        r104 = -1;
    L12:
        V(r100.f429384a, r100.f429385b, r101);
    }

    public final void c0(Animator r100) {
        this.f429361v = true;
        OneShotPreDrawListener.add(this, new c(this, this, r100));
        invalidate();
    }

    public final void d0(int r100) {
        if (B() == true) goto L8;
        int r101 = Math.max(r100, 0);
        setHeightInner(r101);
        if (this.f429352m == true) goto L9;
        U(r101);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void l(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f429349j).add(r100);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void n(g r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f429350k).add(r100);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        int r101 = MathKt.roundToInt(this.f429345f.invoke().floatValue());
        if (B() == true) goto L5;
        return;
    L5:
        if (this.f429347h <= r101) goto L9;
        this.f429347h = r101;
        this.f429358s.setExpectHeight(r101);
        setHeightInner(this.f429347h);
        U(this.f429347h);
        return;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public void setAnimationEnable(boolean r100) {
        if (this.f429348i != r100) goto L5;
        return;
    L5:
        this.f429348i = r100;
        if (r100 == false) goto L11;
        ImeAnimControllerImpl r101 = this.f429356q;
        if (Build.VERSION.SDK_INT < 30) goto L10;
        ViewCompat.setWindowInsetsAnimationCallback(r101.f429368c, r101);
        return;
    L10:
        r101.getClass();
        return;
    L11:
        ImeAnimControllerImpl r102 = this.f429356q;
        if (Build.VERSION.SDK_INT < 30) goto L14;
        ViewCompat.setWindowInsetsAnimationCallback(r102.f429368c, null);
        return;
    L14:
        r102.getClass();
    }

    public void setBottomSpacing(int r100) {
        Log.i("ImeWrapper", "imeWrapper: setBottomSpacing " + r100);
        this.f429342c = r100;
    }

    public void setFocusDelegate(Function0<? extends View> r100) {
        this.f429360u = r100;
        if (r100 != null) goto L5;
        setFocusable(true);
        setFocusableInTouchMode(true);
        return;
    L5:
        clearFocus();
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public void setImeEnable(boolean r100) {
        this.f429357r = r100;
    }

    public void setPanelHeight(int r100) {
        int r101 = this.f429347h;
        if (r100 != (-2)) goto L9;
        this.f429351l = true;
        int r102 = this.f429343d;
        if (r102 > 0) goto L8;
        int r103 = s.f429413a;
        Context r104 = this.f429340a;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102 = UIUtils.dp2px(r104, 260.0f);
    L8:
        this.f429347h = r102;
    L9:
        if (r100 <= 0) goto L11;
        this.f429347h = r100;
        this.f429351l = false;
    L11:
        this.f429358s.setExpectHeight(this.f429347h);
        if (B() == false) goto L20;
        int r105 = this.f429347h;
        if (r101 != r105) goto L16;
        return;
    L16:
        if (this.f429348i == true) goto L18;
        setHeightInner(r105);
        return;
    L18:
        setHeightInner(Math.max(r101, r105));
        Log.i("ImeWrapper", "onPanelHeight update: form " + r101 + ", to " + this.f429347h);
        c0(b0(this, r101, this.f429347h, new AnonymousClass1(this)));
        V(r101, this.f429347h, getAnimInterpolator());
        X();
        return;
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final com.ss.android.lark.keyboard.ime.c v(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<Integer, d> r101 = this.f429355p;
        Integer r102 = Integer.valueOf(r100.hashCode());
        LinkedHashMap r103 = (LinkedHashMap) r101;
        Object r104 = r103.get(r102);
        if (r104 != null) goto L6;
        r104 = new d();
        r103.put(r102, r104);
    L6:
        return (com.ss.android.lark.keyboard.ime.c) r104;
    }

    public static final /* synthetic */ void L(ImeWrapper r100, int r101) {
        r100.setHeightInner(r101);
    }

    public static final /* synthetic */ void P(ImeWrapper r100, int r101) {
        r100.setInAnimationCount(r101);
    }

    public static final /* synthetic */ void Q(ImeWrapper r100, ImeStateDetail r101) {
        r100.setPanelState(r101);
    }

    public final void S(final f r210, final boolean r211) {
        if (r211 == true) goto L5;
    L9:
        Log.d("ImeWrapper", "handleWindowInsets: insets holder is " + r210 + ", last ime height is " + this.f429343d + " , is systemDispatch is " + r211);
        final boolean r100 = hasWindowFocus() ^ true;
        com.ss.android.lark.keyboard.ime.b r101 = com.ss.android.lark.keyboard.ime.b.f429377a;
        Function0<String> r102 = new ImeWrapper$handleWindowInsets$1(r211, r100, this, r210);
        r101.getClass();
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r102);
        if (this.f429348i == true) goto L12;
    L18:
        final boolean r110 = r210.f429388e;
        final boolean r103 = r210.f429387d;
        final boolean r104 = r210.f429389f;
        boolean r105 = this.f429348i & this.f429352m;
        final boolean r106 = (r105 & r103) & (!r104);
        final boolean r107 = r105 & (!r103);
        if (r104 == true) goto L21;
        int r108 = r210.f429384a;
    L22:
        if (r104 == true) goto L24;
        int r109 = r210.f429385b;
    L25:
        final Ref.BooleanRef r111 = new Ref.BooleanRef();
        final ImeStateDetail r112 = getImeState().b();
        final int r113 = r109;
        final int r114 = r108;
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", new ImeWrapper$consumeImeInsets$1(r210, r104, this, r103, r106, r107, r114, r113, r112));
        if (r103 == false) goto L45;
        final boolean r115 = B();
        StringBuilder r116 = new StringBuilder("panel is show ");
        r116.append(r115);
        r116.append(" , currentImeState.isHideOrExit is ");
        final ImeStateDetail r117 = r112;
        r116.append(r117);
        r116.append(".isHideOrExit() , insetsImeShow is ");
        r116.append(r110);
        Log.d("ImeWrapper", r116.toString());
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", new ImeWrapper$consumeImeInsets$2(r115, r117, r110));
        if (r115 == true) goto L34;
        d0(r113);
        if (r106 == false) goto L32;
        Log.d("ImeWrapper", "notifyHeightChangeForAnimationOfIme 1");
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$3.INSTANCE);
        W(r210);
    L32:
        boolean r118 = r107;
        boolean r119 = true;
    L57:
        if (r210.f429388e == false) goto L70;
        int r120 = r210.f429385b;
        if (r120 <= 0) goto L64;
        if (this.f429346g == r120) goto L64;
        setImeHeightToStore(r120);
    L64:
        if (this.f429351l == false) goto L70;
        if (r120 <= this.f429344e) goto L70;
        if (this.f429347h == r120) goto L70;
        this.f429347h = r120;
        this.f429358s.setExpectHeight(r120);
    L70:
        if (r106 == true) goto L75;
        if (r110 == false) goto L73;
        ImeStateDetail r121 = ImeStateDetail.Show;
    L83:
        ImeStateDetail r122 = ImeStateDetail.Hide;
        if (r117 == r122) goto L86;
        boolean r123 = true;
    L87:
        if (r121 != r122) goto L90;
        r119 = false;
    L90:
        if (r123 == false) goto L96;
        if (r119 == true) goto L96;
        Log.d("ImeWrapper", "state change: ime hide");
        R(this.f429354o.f429379b);
        Iterator r124 = ((LinkedHashMap) this.f429355p).values().iterator();
    L94:
        if (r124.hasNext() == false) goto L96;
        R(((d) r124.next()).f429379b);
    L96:
        setImeState(r121);
        if (r123 == true) goto L104;
        if (r119 == false) goto L104;
        Log.d("ImeWrapper", "state change: ime show");
        R(this.f429354o.f429378a);
        Iterator r125 = ((LinkedHashMap) this.f429355p).values().iterator();
    L101:
        if (r125.hasNext() == false) goto L104;
        R(((d) r125.next()).f429378a);
    L104:
        if (r11.element == false) goto L106;
        setPanelState(ImeStateDetail.Exit);
    L106:
        this.f429343d = r210.f429385b;
        this.f429353n.a(r210);
        if (r117 == getImeState().b()) goto L109;
        Log.i("ImeWrapper", "consume window insets end: " + r210 + ", needAnimation: " + r106 + ", updateAnimation: " + r118 + ", deferred insets " + this.f429352m + ", imeTransform: " + r117 + " -> " + getImeState().b());
    L109:
        com.ss.android.lark.keyboard.ime.b r126 = com.ss.android.lark.keyboard.ime.b.f429377a;
        Function0<String> r127 = new ImeWrapper$consumeImeInsets$7(this, r117, r111);
        r126.getClass();
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r127);
        X();
        return;
    L86:
        r123 = false;
        goto L87
    L73:
        r121 = ImeStateDetail.Hide;
        goto L83
    L75:
        if (r117.isHideOrExit() == false) goto L79;
        if (r110 == false) goto L79;
        r121 = ImeStateDetail.Enter;
    L79:
        if (r117.isEnterOrShow() == false) goto L82;
        if (r110 == true) goto L82;
        r121 = ImeStateDetail.Exit;
    L82:
        r121 = r117;
        goto L83
    L34:
        if (r117.isHideOrExit() == false) goto L39;
        if (r110 == false) goto L39;
        if (r106 == false) goto L38;
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$4.INSTANCE);
        r111.element = true;
        a0(this, r113, false, 2);
    L44:
        r119 = true;
    L51:
        r118 = r107;
        goto L57
    L38:
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$5.INSTANCE);
        this.f429358s.setVisibility(4);
        Y();
        setPanelState(ImeStateDetail.Hide);
        d0(r113);
    L39:
        if (r110 == true) goto L44;
        if (getPanelState().b() != ImeStateDetail.Exit) goto L44;
        if (r106 == false) goto L44;
        r119 = true;
        r111.element = true;
        a0(this, r113, false, 2);
        goto L51
    L45:
        r117 = r112;
        r119 = true;
        if (r114 != r113) goto L52;
        if (r104 == true) goto L51;
        if (this.f429352m == true) goto L51;
    L52:
        d0(r113);
        r118 = r107;
        if (r118 == false) goto L57;
        Log.d("ImeWrapper", "notifyHeightChangeForAnimationOfIme 2");
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", ImeWrapper$consumeImeInsets$6.INSTANCE);
        W(r210);
        goto L57
    L24:
        r109 = 0;
        goto L25
    L21:
        r108 = 0;
        goto L22
    L12:
        if (r210.f429387d == false) goto L18;
        if (r211 == false) goto L18;
        if (this.f429352m == true) goto L18;
        if (r100 == true) goto L18;
        Log.d("ImeWrapper", "handleWindowInsets: has window insets animation, start compat insets anim");
        this.f429352m = true;
        int r128 = r210.f429384a;
        int r129 = r210.f429385b;
        ValueAnimator r130 = ObjectAnimator.ofFloat(new float[]{1000.0f});
        r130.setDuration(getAnimDuration());
        r130.setInterpolator(getAnimInterpolator());
        Intrinsics.checkNotNull(r130);
        r130.addListener(new r(this, r128, r129));
        r130.addUpdateListener(new p(r128, r129, this));
        r130.addListener(new q(this));
        c0(r130);
        goto L18
    L5:
        if (r210.f429387d == true) goto L9;
        if (r210.f429385b != this.f429343d) goto L9;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Log.d("ImeWrapper", "ImeWrapper: onMeasure: height is " + getMeasuredHeight());
    }

    @Override // com.ss.android.lark.keyboard.ime.ImeCoordinator.b
    public final void r(boolean r110, final WindowInsetsCompat r111) {
        Intrinsics.checkNotNullParameter(r111, "dispatchWindowInsets");
        Log.d("ImeWrapper", "onGlobalDispatchMeasure: called");
        int r100 = WindowInsetsCompat.Type.ime();
        int r101 = WindowInsetsCompat.Type.systemBars();
        boolean r102 = r111.isVisible(r100);
        boolean r103 = false;
        if (this.f429353n.f429388e == r102) goto L5;
        boolean r104 = true;
    L6:
        Log.d("ImeWrapper", "unwrapIme: lastWindowInsets " + this.f429353n.f429388e + ", insetsImeVisible " + r102);
        int r105 = r111.getInsets(r101).bottom;
        if (CarUtils.b() == false) goto L9;
        r105 = 0;
    L9:
        int r106 = Math.max((r111.getInsets(r100).bottom - r105) - this.f429342c, 0);
        if (r104 == true) goto L12;
        int r107 = this.f429343d;
    L15:
        final f r108 = this.f429359t.acquire();
        if (r108 != null) goto L18;
        r108 = new f();
    L18:
        r108.f429384a = r107;
        r108.f429385b = r106;
        r108.f429387d = r104;
        r108.f429388e = r102;
        r108.f429386c = r105;
        r108.f429389f = r110;
        com.ss.android.lark.keyboard.ime.b r112 = com.ss.android.lark.keyboard.ime.b.f429377a;
        Function0<String> r109 = new ImeWrapper$onGlobalDispatchInsets$1(r108, r111, this);
        r112.getClass();
        com.ss.android.lark.keyboard.ime.b.a("ImeWrapper", r109);
        List<g> r113 = this.f429350k;
        if ((r113 instanceof Collection) == true) goto L21;
    L23:
        Iterator r114 = ((ArrayList) r113).iterator();
    L25:
        if (r114.hasNext() == false) goto L29;
        if ((!((g) r114.next()).r(r108)) == true) goto L25;
    L30:
        if (r103 == false) goto L32;
        S(r108, true);
    L32:
        this.f429359t.release(r108);
        return;
    L29:
        r103 = true;
        goto L30
    L21:
        if (((ArrayList) r113).isEmpty() == false) goto L23;
    L12:
        if (r102 == false) goto L14;
        r107 = 0;
        goto L15
    L14:
        r107 = this.f429343d;
        r106 = 0;
        goto L15
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.ime.a
    public final void u(int r100, boolean r101) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f429347h = r100;
        this.f429351l = r101;
        this.f429358s.setExpectHeight(r100);
        if (B() == false) goto L8;
        setHeightInner(this.f429347h);
        U(this.f429347h);
        return;
    }

    public ImeWrapper(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f429340a = r100;
        this.f429341b = LarkKVStorage.h(new com.ss.android.lark.storage.a("lark:im:keyboard"), true);
        int r103 = s.f429413a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f429344e = UIUtils.dp2px(r100, 200.0f);
        this.f429345f = new ImeWrapper$maxPanelHeightProvider$1(this);
        int r104 = getInitialImeHeight();
        this.f429346g = r104;
        this.f429347h = r104;
        this.f429349j = new ArrayList();
        this.f429350k = new ArrayList();
        this.f429351l = true;
        this.f429353n = new f();
        d r105 = new d();
        this.f429354o = r105;
        LinkedHashMap r106 = new LinkedHashMap();
        this.f429355p = r106;
        this.f429356q = new ImeAnimControllerImpl(this);
        this.f429357r = true;
        h r107 = new h(r100, this);
        r107.setVisibility(4);
        r107.setExpectHeight(this.f429347h);
        this.f429358s = r107;
        this.f429359t = new Pools.SimplePool(3);
        ImeStateDetail r108 = ImeStateDetail.Hide;
        this.f429363x = new j(r108);
        this.f429364y = new j(r108);
        this.f429365z = new LinkedHashMap();
        this.A = new CopyOnWriteArrayList();
        setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        setWillNotDraw(false);
        addView(r107, getLayoutParams());
        r106.put(Integer.valueOf(hashCode()), r105);
    }

    public static final void K(ImeWrapper r100, ValueAnimator r101, Function1 r102) {
        r100.getClass();
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = true;
        r101.addListener(new k(r103));
        r101.addListener(new l(r103, r102, r101));
    }

    public final void V(int r110, int r111, Interpolator r112) {
        Log.d("ImeWrapper", "notifyHeightChangeForAnimation: invoke");
        long r100 = getAnimDuration();
        Iterator<T> r101 = this.f429349j.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e) r101.next()).n(r110, r111, r100, r112);
        goto L4
    }

    public /* synthetic */ ImeWrapper(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a0(final ImeWrapper r100, final int r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = true;
    L8:
        r100.getClass();
        Log.i("ImeWrapper", "panelExit: prepare. form: " + r100.f429347h + ", to: " + r101 + " , panelTransform: " + r100.getPanelState() + " -> " + ImeStateDetail.Exit);
        Iterator<Animator> r104 = r100.A.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r104.next().cancel();
        goto L10
    L12:
        if (r102 == false) goto L14;
        r100.V(r100.f429347h, r101, r100.getAnimInterpolator());
        r100.X();
    L14:
        r100.c0(b0(r100, r100.f429347h, r101, new ImeWrapper$playExitAnim$1(r100, r101)));
    }

    public static ValueAnimator b0(final ImeWrapper r100, final int r101, final int r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(B, "<this>");
        final int r102 = 2;
        r100.getClass();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r103.setDuration(r100.getAnimDuration());
        r103.setInterpolator(r100.getAnimInterpolator());
        final int r104 = Math.max(r101, r110);
        Function1<Float, Unit> r105 = new ImeWrapper$preparePanelAnimator$2$onAnimationUpdate$1(r110, r101, r100, r104, r102);
        Intrinsics.checkNotNull(r103);
        r103.addListener(new o(r100, r105));
        r103.addUpdateListener(new m(r105));
        r103.addListener(new n(r100, r105, r103));
        r100.A.add(r103);
        r111.invoke(r103);
        return r103;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Log.d("ImeWrapper", "ImeWrapper: onLayout: height is " + getHeight());
    }
}
