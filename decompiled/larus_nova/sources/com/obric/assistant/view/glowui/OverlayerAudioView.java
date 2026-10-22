package com.obric.assistant.view.glowui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.utils.b0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.ui.ObricListeningVisualView;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0001=\u0018\u0000 \u008b\u00012\u00020\u0001:\u0006\u008b\u0001\u008c\u0001\u008d\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0003H\u0002J\u001a\u0010T\u001a\u00020\u001b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)J\u001c\u0010V\u001a\u00020W2\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010)J\u0006\u0010X\u001a\u00020WJ\u001c\u0010Y\u001a\u00020\u001b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)H\u0002J\u0016\u0010Z\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020*J\u001e\u0010]\u001a\u00020W2\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020`0_j\b\u0012\u0004\u0012\u00020``aJ\b\u0010b\u001a\u00020WH\u0014J\b\u0010c\u001a\u00020WH\u0014J\u0016\u0010d\u001a\u00020W2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007J\u0006\u0010g\u001a\u00020WJ\u0006\u0010h\u001a\u00020WJ\u000e\u0010i\u001a\u00020W2\u0006\u0010j\u001a\u00020kJ\u0010\u0010l\u001a\u00020W2\u0006\u0010m\u001a\u00020\u0007H\u0016J\b\u0010n\u001a\u00020WH\u0002J\b\u0010o\u001a\u00020WH\u0002J\u0010\u0010p\u001a\u00020W2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020WH\u0002J\u0018\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u001b2\u0006\u0010v\u001a\u00020\u001bH\u0002J\u0010\u0010v\u001a\u00020\u001b2\u0006\u0010u\u001a\u00020\u001bH\u0002J\b\u0010w\u001a\u00020WH\u0002J\b\u0010x\u001a\u00020WH\u0002J\b\u0010y\u001a\u00020WH\u0002J\u0010\u0010z\u001a\u00020W2\b\b\u0002\u0010{\u001a\u00020\u001bJ\b\u0010|\u001a\u00020WH\u0002J\u001e\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020\u00072\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020W0,H\u0002J\u001f\u0010\u0080\u0001\u001a\u00020W2\u0006\u0010~\u001a\u00020\u00072\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020W0,H\u0002J\t\u0010\u0081\u0001\u001a\u00020WH\u0002J\t\u0010\u0082\u0001\u001a\u00020WH\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0002J\u0019\u0010\u0084\u0001\u001a\u00020W2\u0006\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020*H\u0002J&\u0010\u0085\u0001\u001a\u00020W2\u0007\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0087\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u001b2\u0007\u0010\u0088\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u008a\u0001\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001a\u0010\u001cR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001e\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u001b\u0010?\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u001e\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u001e\u001a\u0004\bD\u0010AR\u001b\u0010F\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001e\u001a\u0004\bG\u0010AR\u001b\u0010I\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u001e\u001a\u0004\bJ\u0010AR\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u001e\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u001e\u001a\u0004\bR\u0010O¨\u0006\u008e\u0001"}, d2 = {"Lcom/obric/assistant/view/glowui/OverlayerAudioView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "glowView", "Lcom/obric/assistant/view/glowui/GlowView;", "audioVisualizerView", "Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "getAudioVisualizerView", "()Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "tvTips", "Landroid/widget/TextView;", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "sharedListeningView", "Lcom/obric/assistant/activation/presentation/ui/ObricListeningVisualView;", "legacyVisualSnapshot", "Lcom/obric/assistant/view/glowui/OverlayerAudioView$LegacyVisualSnapshot;", "isWindow", "", "()Z", "isWindow$delegate", "Lkotlin/Lazy;", "isCameraActivity", "isCameraActivity$delegate", "isAiPress", "findActivity", "Landroid/app/Activity;", "gestureState", "Lcom/obric/assistant/view/glowui/OverlayerAudioView$GestureState;", "blurInsideRect", "Landroid/graphics/Rect;", "lastTouchPosition", "Lkotlin/Pair;", "", "isChatClickSpeakingCallback", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setChatClickSpeakingCallback", "(Lkotlin/jvm/functions/Function0;)V", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "uiScope$delegate", "glowUpdateJob", "Lkotlinx/coroutines/Job;", "audioAnimationRequestId", "navigationBarBottom", "imeBottom", "bottomMenuHeight", "basePaddingBottom", "insetsAnimationCallback", "com/obric/assistant/view/glowui/OverlayerAudioView$insetsAnimationCallback$1", "Lcom/obric/assistant/view/glowui/OverlayerAudioView$insetsAnimationCallback$1;", "cancelBaseColor", "getCancelBaseColor", "()I", "cancelBaseColor$delegate", "cancelCoverColor", "getCancelCoverColor", "cancelCoverColor$delegate", "cancelTintColor", "getCancelTintColor", "cancelTintColor$delegate", "tipsDefaultColor", "getTipsDefaultColor", "tipsDefaultColor$delegate", "gradientDefaultColors", "", "getGradientDefaultColors", "()[I", "gradientDefaultColors$delegate", "gradientCancelColors", "getGradientCancelColors", "gradientCancelColors$delegate", "shouldCancel", "xy", "updateTouchPosition", "", "notifyPositionChanged", "refreshGestureState", "updateGestureState", "x", "y", "setAudioData", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onAttachedToWindow", "onDetachedFromWindow", "updateBottomMenuHeight", "curHeight", "normalHeight", "onAiKeyLongPress", "onAiKeyShortClick", "renderListening", "state", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "observeWindowInsets", "syncCurrentWindowInsets", "updateWindowInsets", "insets", "Landroidx/core/view/WindowInsetsCompat;", "updateTranslationY", "updateWindowRootSafeBottomPadding", "isAttachedToWindowRoot", "isDecorViewPaddingHost", "allowGlowDrawIntoHostPadding", "startAudioAnimationWhenDisplayed", "cancelPendingAudioAnimation", "showAudioAnimation", "playWelcomeAnimation", "prepareAudioAnimation", "runAfterNextDraw", "requestId", "action", "runIfAudioAnimationValid", "stopAudioAnimation", "ensureGlowAnimationStarted", "applyGestureStyle", "showHighlightAtScreen", "updateTips", "toCancel", "visible", "isShortClick", "isClickTalk", "isIntercom", "Companion", "GestureState", "LegacyVisualSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverlayerAudioView extends FrameLayout {
    public static final float[] B = null;
    public final Lazy A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GlowView f394217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioContinueGradientView f394218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f394219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f394220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObricListeningVisualView f394221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f394222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f394223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f394224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f394225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GestureState f394226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f394227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Pair<Float, Float> f394228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Boolean> f394229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f394230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Job f394231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f394232p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f394233q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f394234r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f394235s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f394236t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OverlayerAudioView$insetsAnimationCallback$1 f394237u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f394238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f394239w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f394240x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f394241y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f394242z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/view/glowui/OverlayerAudioView$GestureState;", "", "<init>", "(Ljava/lang/String;I)V", "INSIDE", "OUTSIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GestureState extends Enum<GestureState> {
        public static final GestureState INSIDE = null;
        public static final GestureState OUTSIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GestureState[] f394243a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f394244b = null;

        public static EnumEntries<GestureState> getEntries() {
            return f394244b;
        }

        static {
            GestureState r100 = new GestureState("INSIDE", 0);
            INSIDE = r100;
            GestureState r101 = new GestureState("OUTSIDE", 1);
            OUTSIDE = r101;
            GestureState[] r102 = {r100, r101};
            f394243a = r102;
            f394244b = EnumEntriesKt.enumEntries(r102);
        }

        public static GestureState[] values() {
            return (GestureState[]) f394243a.clone();
        }

        public static GestureState valueOf(String r100) {
            return (GestureState) r27.a.a(GestureState.class, r100);
        }

        public GestureState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f394245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f394246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f394247c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f394245a == r101.f394245a) goto L12;
            return false;
        L12:
            if (this.f394246b == r101.f394246b) goto L15;
            return false;
        L15:
            if (this.f394247c == r101.f394247c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f394245a * 31) + this.f394246b) * 31) + this.f394247c;
        }

        public final String toString() {
            return "LegacyVisualSnapshot(glowVisibility=" + this.f394245a + ", audioVisualizerVisibility=" + this.f394246b + ", tipsVisibility=" + this.f394247c + ')';
        }

        public b(int r100, int r101, int r102) {
            this.f394245a = r100;
            this.f394246b = r101;
            this.f394247c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394248a = null;

        static {
            int[] r100 = new int[GestureState.values().length];
            r100[GestureState.INSIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GestureState.OUTSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f394248a = r100;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.glowui.OverlayerAudioView$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.glowui.OverlayerAudioView$setAudioData$1", f = "OverlayerAudioView.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Double> $sampleData;
        int label;
        final /* synthetic */ OverlayerAudioView this$0;

        public AnonymousClass1(OverlayerAudioView r100, ArrayList<Double> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$sampleData = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$sampleData, r101);
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            boolean r103 = true;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            OverlayerAudioView r104 = this.this$0;
            float[] r105 = OverlayerAudioView.B;
            r104.b();
            GlowView r106 = this.this$0.f394217a;
            ArrayList<Double> r107 = this.$sampleData;
            this.label = 1;
            if (r106.f394197d.f394253d != 0) goto L11;
            boolean r108 = true;
        L12:
            if (r108 == false) goto L14;
        L17:
            if (r103 == true) goto L19;
            Object r109 = Unit.INSTANCE;
        L23:
            if (r109 != r101) goto L26;
            return r101;
        L19:
            r109 = r106.f394196c.update(r107, this);
            if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
            r109 = Unit.INSTANCE;
            goto L23
        L14:
            if (r106.f394198e == true) goto L17;
            r103 = false;
            goto L17
        L11:
            r108 = false;
            goto L12
        }
    }

    public OverlayerAudioView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OverlayerAudioView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewCompat.setWindowInsetsAnimationCallback(this, null);
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        super.onDetachedFromWindow();
        this.f394232p++;
        Job r100 = this.f394231o;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f394231o = null;
    }

    static {
        B = new float[]{0.0f, 0.167f, 0.833f, 1.0f};
    }

    private final int getCancelBaseColor() {
        return ((Number) this.f394238v.getValue()).intValue();
    }

    private final int getCancelCoverColor() {
        return ((Number) this.f394239w.getValue()).intValue();
    }

    private final int getCancelTintColor() {
        return ((Number) this.f394240x.getValue()).intValue();
    }

    private final int[] getGradientCancelColors() {
        return (int[]) this.A.getValue();
    }

    private final int[] getGradientDefaultColors() {
        return (int[]) this.f394242z.getValue();
    }

    private final int getTipsDefaultColor() {
        return ((Number) this.f394241y.getValue()).intValue();
    }

    private final CoroutineScope getUiScope() {
        return (CoroutineScope) this.f394230n.getValue();
    }

    public final void a() {
        GestureState r100 = this.f394226j;
        int r101 = c.f394248a[r100.ordinal()];
        float[] r102 = B;
        if (r101 != 1) goto L5;
        this.f394217a.setEffectShow(true);
        this.f394217a.setBaseColor(ContextCompat.getColor(getContext(), R.color.primary_50));
        this.f394217a.setCoverColor(-6562561);
        this.f394218b.c(getGradientDefaultColors(), r102);
        return;
    L5:
        if (r101 != 2) goto L8;
        this.f394217a.setEffectShow(false);
        this.f394217a.setBaseColor(getCancelBaseColor());
        this.f394217a.setCoverColor(getCancelCoverColor());
        this.f394217a.a();
        this.f394218b.c(getGradientCancelColors(), r102);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void b() {
        final GlowView r100 = this.f394217a;
        boolean r101 = false;
        if (r100.f394197d.f394253d != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
    L9:
        r101 = true;
    L11:
        if (r101 == false) goto L13;
    L22:
        FLogger.f375446a.i("GlowView", "startWaveAnim already anim");
        r100.e();
        return;
    L13:
        if (r100.f394198e == true) goto L22;
        FLogger.f375446a.i("GlowView", "startWaveAnim start anim");
        if (r100.getWidth() != 0) goto L18;
    L21:
        r100.f394198e = true;
        return;
    L18:
        if (r100.getHeight() == 0) goto L21;
        r100.f394197d.a(new d(r100));
        r100.postInvalidateOnAnimation();
        return;
    L8:
        if (r100.f394198e == false) goto L11;
    L5:
        r102 = false;
        goto L6
    }

    public final boolean c() {
        return ((Boolean) this.f394223g.getValue()).booleanValue();
    }

    public final void d() {
        if (this.f394228l != null) goto L5;
        return;
    L5:
        if (isShown() == false) goto L10;
        post(new h(this));
        return;
    }

    public final void j() {
        float r100 = getTranslationY();
        boolean r101 = true;
        if (getParent() != getRootView()) goto L5;
        boolean r102 = true;
    L7:
        if (c() == true) goto L12;
        if (r102 == false) goto L12;
        if (getRootView().getPaddingBottom() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        setClipChildren(false);
        setClipToPadding(false);
        this.f394220d.setClipChildren(false);
        this.f394220d.setClipToPadding(false);
    L15:
        if (r103 == true) goto L17;
    L19:
        boolean r104 = false;
    L21:
        if (c() == true) goto L27;
        if (r102 == false) goto L27;
        if (((Boolean) this.f394224h.getValue()).booleanValue() == true) goto L27;
        if (r104 == true) goto L27;
        int r105 = this.f394233q;
    L28:
        int r106 = this.f394236t + r105;
        GlowView r107 = this.f394217a;
        float r108 = 0.0f;
        if (r103 == false) goto L31;
        float r109 = r105;
    L32:
        r107.setTranslationY(r109);
        if (getPaddingBottom() == r106) goto L37;
        setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), r106);
    L37:
        if (c() == false) goto L39;
    L41:
        float r110 = 0.0f;
    L43:
        if (c() == false) goto L60;
        int r111 = this.f394235s;
        if (r111 <= 0) goto L47;
        float r112 = (-r111) - this.f394233q;
    L52:
        if (r112 <= 0.0f) goto L54;
    L57:
        if (r101 == false) goto L59;
        r108 = -this.f394233q;
    L59:
        this.f394218b.setTranslationY(r108);
        this.f394219c.setTranslationY(r108);
        setTranslationY(r112);
    L79:
        FLogger.f375446a.i("OverlayerAudioView", "updateTranslationY: isWindowContext=" + c() + ", navigationBarBottom=" + this.f394233q + ", imeBottom=" + this.f394234r + ", bottomMenuHeight=" + this.f394235s + ", isAttachedToWindowRoot=" + r102 + ", isCameraActivity=" + ((Boolean) this.f394224h.getValue()).booleanValue() + ", isDecorViewPaddingHost=" + r103 + ", cameraOverlayOffset=" + r110 + ", paddingBottom=" + getPaddingBottom() + ", currentTranslationY=" + r100 + ", targetTranslationY=" + r112);
        if (b0.a(r100, r112 - r110) == true) goto L83;
        d();
        return;
    L83:
        return;
    L54:
        if (b0.a(r112, 0.0f) == true) goto L57;
        r101 = false;
        goto L57
    L47:
        int r113 = this.f394234r;
        if (r113 <= 0) goto L50;
        r112 = -r113;
        goto L52
    L50:
        r112 = 0.0f;
        goto L52
    L60:
        int r114 = this.f394235s;
        if (r114 <= 0) goto L63;
        r112 = -r114;
    L70:
        if (r112 <= 0.0f) goto L72;
    L75:
        if (r101 == false) goto L78;
        if (r103 == true) goto L78;
        r108 = -r112;
    L78:
        this.f394218b.setTranslationY(r108);
        this.f394219c.setTranslationY(r108);
        setTranslationY(r112 - r110);
        goto L79
    L72:
        if (b0.a(r112, 0.0f) == true) goto L75;
        r101 = false;
        goto L75
    L63:
        int r115 = this.f394234r;
        if (r115 <= 0) goto L68;
        if (r102 == false) goto L67;
        r112 = this.f394233q - r115;
        goto L70
    L67:
        r112 = 0.0f;
        goto L70
    L68:
        r112 = this.f394233q;
        goto L70
    L39:
        if (((Boolean) this.f394224h.getValue()).booleanValue() == false) goto L41;
        r110 = this.f394233q;
        goto L43
    L31:
        r109 = 0.0f;
    L27:
        r105 = 0;
        goto L28
    L17:
        if (this.f394234r <= this.f394233q) goto L19;
        r104 = true;
    L12:
        r103 = false;
        goto L13
    L5:
        r102 = false;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, new l(this));
        ViewCompat.setWindowInsetsAnimationCallback(this, this.f394237u);
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this);
        if (r100 == null) goto L5;
        k(r100);
    L5:
        j();
        ViewCompat.requestApplyInsets(this);
    }

    public final AudioContinueGradientView getAudioVisualizerView() {
        return this.f394218b;
    }

    public final ViewGroup getRoot() {
        return this.f394220d;
    }

    public final boolean e(Pair<Float, Float> r100) {
        r100.getFirst().floatValue();
        float r101 = r100.getSecond().floatValue();
        this.f394220d.getGlobalVisibleRect(this.f394227k);
        if (r101 < (this.f394227k.bottom - c7.a(R.dimen.glow_rect_height))) goto L5;
        GestureState r102 = GestureState.INSIDE;
    L7:
        if (r102 == this.f394226j) goto L10;
        this.f394226j = r102;
        a();
    L10:
        if (r102 != GestureState.OUTSIDE) goto L12;
        boolean r103 = true;
    L14:
        if (this.f394226j != GestureState.INSIDE) goto L17;
        float r104 = r100.getFirst().floatValue();
        float r105 = r100.getSecond().floatValue();
        int[] r106 = new int[2];
        this.f394217a.getLocationOnScreen(r106);
        this.f394217a.d(r104 - r106[0], r105 - r106[1]);
        this.f394217a.invalidate();
    L17:
        if (this.f394225i == true) goto L19;
        i(r103, false);
    L19:
        return r103;
    L12:
        r103 = false;
        goto L14
    L5:
        r102 = GestureState.OUTSIDE;
        goto L7
    }

    public final void f(ObricListeningViewState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.b() == true) goto L10;
        this.f394221e.e(ObricListeningViewState.f385269d);
        b r101 = this.f394222f;
        if (r101 != null) goto L7;
        return;
    L7:
        this.f394222f = null;
        this.f394217a.setVisibility(r101.f394245a);
        this.f394218b.setVisibility(r101.f394246b);
        this.f394219c.setVisibility(r101.f394247c);
        return;
    L10:
        if (this.f394222f != null) goto L12;
        this.f394222f = new b(this.f394217a.getVisibility(), this.f394218b.getVisibility(), this.f394219c.getVisibility());
    L12:
        this.f394221e.e(r100);
        this.f394217a.setVisibility(4);
        this.f394218b.setVisibility(4);
        this.f394219c.setVisibility(4);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.assistant.view.glowui.j] */
    public final void h(final boolean r100) {
        if (this.f394222f == null) goto L5;
        return;
    L5:
        final int r101 = this.f394232p + 1;
        this.f394232p = r101;
        b();
        final ?? r102 = new j(this, r100);
        if (isShown() == true) goto L8;
    L12:
        OneShotPreDrawListener.add(this, new u(this, this, r101, r102));
        return;
    L8:
        if (getWidth() <= 0) goto L12;
        if (getHeight() <= 0) goto L12;
        postOnAnimation(new k(this, r101, r102));
    }

    public final void k(WindowInsetsCompat r100) {
        this.f394233q = r100.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        this.f394234r = r100.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        j();
    }

    public final void setAudioData(ArrayList<Double> r110) {
        Intrinsics.checkNotNullParameter(r110, "sampleData");
        if (this.f394222f == null) goto L5;
        return;
    L5:
        this.f394218b.setAudioData(r110);
        Job r100 = this.f394231o;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        this.f394231o = BuildersKt.launch$default(getUiScope(), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r110, null), 2, null);
    }

    public final void setChatClickSpeakingCallback(Function0<Boolean> r100) {
        this.f394229m = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        int r101 = getVisibility();
        super.setVisibility(r100);
        if (r100 == 0) goto L5;
        this.f394228l = null;
        this.f394225i = false;
        int r102 = this.f394232p + 1;
        this.f394232p = r102;
        if (r101 != 0) goto L23;
        this.f394232p = r102 + 1;
        Job r103 = this.f394231o;
        if (r103 == null) goto L20;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L20:
        this.f394231o = null;
        this.f394217a.f();
        this.f394218b.a();
        return;
    L23:
        return;
    L5:
        if (this.f394222f == null) goto L8;
        this.f394217a.setVisibility(4);
        this.f394218b.setVisibility(4);
        this.f394219c.setVisibility(4);
        return;
    L8:
        this.f394226j = GestureState.INSIDE;
        a();
        if (r101 == 0) goto L14;
        WindowInsetsCompat r104 = ViewCompat.getRootWindowInsets(this);
        if (r104 == null) goto L13;
        k(r104);
    L13:
        j();
        ViewCompat.requestApplyInsets(this);
        this.f394232p++;
        this.f394218b.a();
        b();
    L14:
        i(false, false);
    }

    public final void g(int r100, Function0<Unit> r101) {
        if (r100 == this.f394232p) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        return;
    L7:
        if (getWidth() > 0) goto L9;
        return;
    L9:
        if (getHeight() <= 0) goto L15;
        b();
        r101.invoke();
        return;
    }

    public final void i(boolean r100, boolean r101) {
        if (this.f394222f == null) goto L6;
        this.f394219c.setVisibility(4);
        return;
    L6:
        boolean r102 = false;
        this.f394219c.setVisibility(0);
        TextView r103 = this.f394219c;
        ObricInteractDelegate r104 = ObricInteractDelegate.f392884b;
        Boolean r105 = r104.isAiKeyLongPress();
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == false) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L16;
        String r108 = getContext().getString(R.string.obric_hold_to_speak_note);
    L33:
        r103.setText(r108);
        TextView r109 = this.f394219c;
        if (r100 == true) goto L36;
    L39:
        int r110 = getTipsDefaultColor();
    L40:
        r109.setTextColor(r110);
        return;
    L36:
        if (Intrinsics.areEqual(r104.isAiKeyShortPress(), r106) == true) goto L39;
        r110 = getCancelTintColor();
        goto L40
    L16:
        if (Intrinsics.areEqual(r104.isAiKeyPressing(), r106) == true) goto L25;
        if (r101 == true) goto L25;
        Function0<Boolean> r111 = this.f394229m;
        if (r111 != null) goto L21;
    L23:
        boolean r112 = false;
    L24:
        if (r112 == true) goto L25;
    L26:
        if (r102 == false) goto L28;
        r108 = getContext().getString(R.string.obric_click_to_speak_note);
        goto L33
    L28:
        Context r113 = getContext();
        if (r100 == false) goto L31;
        int r114 = R.string.larus_release_to_cancel;
    L32:
        r108 = r113.getString(r114);
        goto L33
    L31:
        r114 = R.string.larus_hold_to_speak_note;
        goto L32
    L21:
        if (r111.invoke().booleanValue() != true) goto L23;
        r112 = true;
    L25:
        r102 = true;
        goto L26
    L9:
        if (this.f394225i == true) goto L12;
        r107 = false;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [com.obric.assistant.view.glowui.OverlayerAudioView$insetsAnimationCallback$1] */
    public OverlayerAudioView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f394223g = LazyKt.lazy(new m(r100));
        this.f394224h = LazyKt.lazy(new n(this, r100));
        this.f394226j = GestureState.INSIDE;
        this.f394227k = new Rect();
        this.f394230n = LazyKt.lazy(new o(this));
        this.f394236t = getPaddingBottom();
        this.f394237u = new OverlayerAudioView$insetsAnimationCallback$1(this);
        this.f394238v = LazyKt.lazy(new p(r100));
        this.f394239w = LazyKt.lazy(new q(r100));
        this.f394240x = LazyKt.lazy(new r(r100));
        this.f394241y = LazyKt.lazy(new s(r100));
        this.f394242z = LazyKt.lazy(new t(r100));
        this.A = LazyKt.lazy(new i(r100));
        FrameLayout.inflate(r100, R.layout.obric_overlayer_audio_view, this);
        this.f394217a = (GlowView) findViewById(R.id.glow_view);
        this.f394219c = (TextView) findViewById(R.id.tv_tips);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.over_layer_root);
        this.f394220d = r103;
        AudioContinueGradientView r104 = (AudioContinueGradientView) findViewById(R.id.audio_visualizer_view);
        this.f394218b = r104;
        FrameLayout r105 = r104.f394052a;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L7;
        r106.width = j19.c.c(210);
        r106.height = j19.c.c(24);
        r105.setLayoutParams(r106);
        r104.f394053b.setBarCount(36);
        r104.f394053b.setBarGapDp(3.6f);
        r104.f394053b.setBarWidthDp(2.4f);
        r104.f394053b.setMinBarHeightDp(7.0f);
        ObricListeningVisualView r107 = new ObricListeningVisualView(r100, false);
        this.f394221e = r107;
        r103.addView(r107, new FrameLayout.LayoutParams(-1, ObricListeningVisualView.a.a(r100), 81));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public /* synthetic */ OverlayerAudioView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
