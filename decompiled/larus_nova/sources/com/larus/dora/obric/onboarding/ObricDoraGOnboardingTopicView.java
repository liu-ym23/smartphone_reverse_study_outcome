package com.larus.dora.obric.onboarding;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0090\u00012\u00020\u0001:\u0004\u0090\u0001\u0091\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ>\u0010@\u001a\u00020526\u0010A\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u001e¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020504J)\u0010F\u001a\u0002052!\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020507J\u0006\u0010H\u001a\u00020\fJ\u0014\u0010I\u001a\u0002052\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010K\u001a\u000205J\u0006\u0010L\u001a\u000205J\u0006\u0010M\u001a\u000205J\u000e\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u001eJ\u0006\u0010P\u001a\u000205J\b\u0010Q\u001a\u000205H\u0002J\u0010\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\u0007H\u0002J\u0010\u0010T\u001a\u0002052\u0006\u0010S\u001a\u00020\u0007H\u0002J\u0010\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH\u0016J(\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0014J\u0010\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020_H\u0014J\u0010\u0010`\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010a\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010b\u001a\u0002052\u0006\u0010c\u001a\u00020\"H\u0002J \u0010d\u001a\u0002052\u0006\u0010c\u001a\u00020\"2\u0006\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u00020\u001eH\u0002J \u0010g\u001a\u0002052\u0006\u0010c\u001a\u00020\"2\u0006\u0010h\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u001eH\u0002J\u0018\u0010i\u001a\u0002052\u0006\u0010h\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u001eH\u0002J\b\u0010j\u001a\u000205H\u0002J\u0018\u0010k\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\"2\u0006\u0010l\u001a\u00020\"H\u0002J\b\u0010m\u001a\u000205H\u0002J\b\u0010n\u001a\u000205H\u0002J\u0010\u0010o\u001a\u0002052\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010p\u001a\u000205H\u0002J\b\u0010q\u001a\u00020\u0015H\u0002J\u0010\u0010r\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\fH\u0002J\u0018\u0010s\u001a\u00020+2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0002J \u0010v\u001a\u0002052\u0006\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\"H\u0002J\u0018\u0010z\u001a\u00020\"2\u0006\u0010G\u001a\u00020\f2\u0006\u0010{\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u0002052\u0006\u0010}\u001a\u00020\u0007H\u0002J\b\u0010~\u001a\u000205H\u0002J\b\u0010\u007f\u001a\u000205H\u0002J \u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00072\n\b\u0002\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\t\u0010\u0084\u0001\u001a\u000205H\u0002J\u001d\u0010\u0085\u0001\u001a\u0002052\b\b\u0002\u0010D\u001a\u00020\u00072\b\b\u0002\u0010x\u001a\u00020\u0007H\u0002J\r\u0010\u0086\u0001\u001a\u000205*\u00020\u0010H\u0002J\u0012\u0010\u0087\u0001\u001a\u0002052\u0007\u0010\u0088\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0089\u0001\u001a\u000205H\u0014J\t\u0010\u008a\u0001\u001a\u000205H\u0014J\u0016\u0010\u008e\u0001\u001a\u00020\u0007*\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0007H\u0002R\u0019\u0010\n\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020\"2\u0006\u0010,\u001a\u00020\"@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u000205\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u000205\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u008b\u0001\u001a\u00020\u0007*\u00020\u00078BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingTopicView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultTopicList", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "topicList", "primaryPrefix", "Landroid/widget/TextView;", "primaryTail", "primaryArrow", "Landroid/widget/ImageView;", "primaryQuery", "Landroid/widget/LinearLayout;", "secondaryText", "tertiaryText", "previewRows", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "loopJob", "Lkotlinx/coroutines/Job;", "autoScrollEnabled", "", "currentIndex", "isScrolling", "touchDownX", "", "touchDownY", "isUserDragging", "velocityTracker", "Landroid/view/VelocityTracker;", "settleAnimator", "Landroid/animation/ValueAnimator;", "autoScrollAnimator", "dragTransition", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingTopicView$TopicTransition;", "value", "offsetY", "setOffsetY", "(F)V", "lastTrackedEventTime", "", "lastTrackedAction", "onTopicChangedListener", "Lkotlin/Function2;", "", "onPrimaryQueryClickListener", "Lkotlin/Function1;", "touchSlop", "minimumFlingVelocity", "alphaMaskPaint", "Landroid/graphics/Paint;", "alphaMaskStops", "", "alphaMask", "Landroid/graphics/LinearGradient;", "setOnTopicChangedListener", "listener", "Lkotlin/ParameterName;", "name", "index", "animate", "setOnPrimaryQueryClickListener", "query", "getCurrentQueryText", "setTopicList", Constants.EXTRA_KEY_TOPICS, "refreshTopics", "startScroll", "stopScroll", "setAutoScrollEnabled", "enabled", "cancelAnimations", "scrollToNext", "scrollBy", "offset", "animateTopics", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "startUserDragIfNeeded", "updateDragPreview", "verticalDelta", "finishUserDrag", "releaseVelocity", "shouldCommitSelection", "settleUserDrag", "selectedOffset", "completeUserDrag", "resetDragPreview", "maxManualQueryOffset", "rowShift", "cancelAutoScrollAnimation", "cancelUserDragSettle", "trackVelocity", "recycleVelocityTracker", "createPrimaryQuery", "measurePrimaryQueryWidth", "prepareTopicTransition", "sourceIndex", "targetIndex", "renderTopicTransition", "transition", "direction", "progress", "calculatePrimaryTailCenterOffset", "targetQueryWidth", "setPrimaryQueryWidth", "width", "resetTopicTransition", "resetPrimaryQuerySize", "createTextView", GXTemplateKey.GAIAX_LAYER_GRAVITY, "typeface", "Landroid/graphics/Typeface;", "bindTopics", "bindPreviewTopics", "applyWakeWordGradient", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "onAttachedToWindow", "onDetachedFromWindow", "dp", "getDp", "(I)I", "floorMod", "modulus", "Companion", "TopicTransition", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraGOnboardingTopicView extends FrameLayout {
    public static final Typeface F = null;
    public static final Typeface G = null;
    public final int A;
    public final int B;
    public final Paint C;
    public final float[] D;
    public LinearGradient E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f340731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f340732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f340733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f340734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f340735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f340736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f340737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f340738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f340739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineScope f340740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f340741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f340742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f340743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f340744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f340745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f340746p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f340747q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public VelocityTracker f340748r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ValueAnimator f340749s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f340750t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f340751u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f340752v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f340753w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f340754x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f340755y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super String, Unit> f340756z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f340757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f340758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f340759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f340760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f340761e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f340757a == r101.f340757a) goto L12;
            return false;
        L12:
            if (this.f340758b == r101.f340758b) goto L15;
            return false;
        L15:
            if (this.f340759c == r101.f340759c) goto L18;
            return false;
        L18:
            if (this.f340760d == r101.f340760d) goto L21;
            return false;
        L21:
            if (Float.compare(this.f340761e, r101.f340761e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f340757a * 31) + this.f340758b) * 31) + this.f340759c) * 31) + this.f340760d) * 31) + Float.floatToIntBits(this.f340761e);
        }

        public final String toString() {
            return "TopicTransition(sourceIndex=" + this.f340757a + ", targetIndex=" + this.f340758b + ", initialQueryWidth=" + this.f340759c + ", targetQueryWidth=" + this.f340760d + ", incomingQueryTranslationX=" + this.f340761e + ')';
        }

        public b(int r100, int r101, int r102, int r103, float r104) {
            this.f340757a = r100;
            this.f340758b = r101;
            this.f340759c = r102;
            this.f340760d = r103;
            this.f340761e = r104;
        }
    }

    public ObricDoraGOnboardingTopicView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ObricDoraGOnboardingTopicView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void m() {
        this.f340742l = true;
        s();
        e();
        this.f340743m = 0;
        this.f340744n = false;
        d();
        Function2<? super Integer, ? super Boolean, Unit> r100 = this.f340755y;
        if (r100 == null) goto L6;
        r100.invoke(Integer.valueOf(this.f340743m), Boolean.FALSE);
    L6:
        if (getVisibility() != 0) goto L9;
        q();
        return;
    }

    public final void o() {
        this.f340751u = null;
        setOffsetY(0.0f);
        p();
        d();
    }

    static {
        F = Typeface.create("sans-serif-medium", 0);
        G = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0);
    }

    public final void d() {
        this.f340734d.setText((CharSequence) ListProtector.get(this.f340732b, this.f340743m));
        c(this.f340743m, 1);
    }

    public final void e() {
        ValueAnimator r100 = this.f340750t;
        if (r100 == null) goto L5;
        r100.cancel();
        p();
        d();
    L5:
        this.f340750t = null;
        ValueAnimator r101 = this.f340749s;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f340749s = null;
        this.f340744n = false;
        this.f340751u = null;
        this.f340734d.animate().cancel();
        this.f340739i.animate().cancel();
        p();
        this.f340739i.setAlpha(1.0f);
        setOffsetY(0.0f);
        this.f340744n = false;
    }

    public final String getCurrentQueryText() {
        return this.f340734d.getText().toString();
    }

    public final void l() {
        VelocityTracker r100 = this.f340748r;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f340748r = null;
        this.f340753w = Long.MIN_VALUE;
        this.f340754x = 3;
    }

    public final void p() {
        this.f340734d.setAlpha(1.0f);
        this.f340734d.setTranslationX(0.0f);
        this.f340734d.setTranslationY(0.0f);
        this.f340735e.setTranslationX(0.0f);
        this.f340737g.setTranslationX(0.0f);
        if (this.f340736f.getLayoutParams().width == (-2)) goto L6;
        LinearLayout r100 = this.f340736f;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.width = -2;
        r100.setLayoutParams(r101);
        return;
    }

    public final void q() {
        if (this.f340742l == true) goto L5;
        return;
    L5:
        Job r100 = this.f340741k;
        boolean r101 = false;
        if (r100 != null) goto L8;
    L10:
        if (r101 == false) goto L12;
        return;
    L12:
        this.f340741k = BuildersKt.launch$default(this.f340740j, null, null, new ObricDoraGOnboardingTopicView$startScroll$1(this, null), 3, null);
        return;
    L8:
        if (r100.isActive() != true) goto L10;
        r101 = true;
        goto L10
    }

    public final void s() {
        Job r100 = this.f340741k;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f340741k = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        q();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        e();
        l();
    }

    public static final /* synthetic */ void b(ObricDoraGOnboardingTopicView r100) {
        r100.setOffsetY(0.0f);
    }

    private final void setOffsetY(float r100) {
        this.f340752v = r100;
        this.f340739i.setTranslationY(r100);
    }

    private final void setPrimaryQueryWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (this.f340736f.getLayoutParams().width == r100) goto L9;
        LinearLayout r101 = this.f340736f;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.width = r100;
        r101.setLayoutParams(r102);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        LinearGradient r100 = this.E;
        if (r100 != null) goto L6;
        super.dispatchDraw(r110);
        return;
    L6:
        int r101 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r110);
        this.C.setShader(r100);
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.C);
        this.C.setShader(null);
        r110.restoreToCount(r101);
    }

    public final int i(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final int j(String r100) {
        CharSequence r101 = this.f340734d.getText();
        this.f340734d.setText(r100);
        this.f340736f.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i(48), 1073741824));
        int r102 = this.f340736f.getMeasuredWidth();
        this.f340734d.setText(r101);
        return r102;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        t(r100);
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        ValueAnimator r102 = this.f340749s;
        if (r102 == null) goto L22;
        if (r102 == null) goto L21;
        r102.cancel();
    L21:
        this.f340749s = null;
        this.f340744n = false;
        o();
    L22:
        this.f340745o = r100.getX();
        this.f340746p = r100.getY();
        this.f340747q = false;
    L24:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L15;
    L12:
        if (r(r100) == false) goto L24;
        return true;
    L15:
        if (this.f340747q == true) goto L24;
        l();
        goto L24
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        t(r100);
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L34;
        float r102 = 0.0f;
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L12;
    L40:
        return true;
    L12:
        if (this.f340747q == false) goto L14;
        h(r100.getY() - this.f340746p, 0.0f, false);
    L15:
        this.f340747q = false;
        l();
        ViewParent r103 = getParent();
        if (r103 == null) goto L40;
        r103.requestDisallowInterceptTouchEvent(false);
        goto L40
    L14:
        o();
        q();
        goto L15
    L19:
        if (r(r100) == false) goto L40;
        u(r100.getY() - this.f340746p);
        goto L40
    L22:
        if (this.f340747q == false) goto L30;
        VelocityTracker r104 = this.f340748r;
        if (r104 == null) goto L26;
        r104.computeCurrentVelocity(1000);
    L26:
        float r105 = r100.getY() - this.f340746p;
        VelocityTracker r106 = this.f340748r;
        if (r106 == null) goto L29;
        r102 = r106.getYVelocity();
    L29:
        h(r105, r102, true);
    L31:
        this.f340747q = false;
        l();
        ViewParent r107 = getParent();
        if (r107 == null) goto L40;
        r107.requestDisallowInterceptTouchEvent(false);
        goto L40
    L30:
        q();
        goto L31
    L34:
        ValueAnimator r108 = this.f340749s;
        if (r108 == null) goto L39;
        if (r108 == null) goto L38;
        r108.cancel();
    L38:
        this.f340749s = null;
        this.f340744n = false;
        o();
    L39:
        this.f340745o = r100.getX();
        this.f340746p = r100.getY();
        this.f340747q = false;
        goto L40
    }

    public final boolean r(MotionEvent r100) {
        float r101 = Math.abs(r100.getX() - this.f340745o);
        float r102 = Math.abs(r100.getY() - this.f340746p);
        if (this.f340747q == true) goto L12;
        if (r102 <= this.A) goto L12;
        if (r102 <= r101) goto L12;
        this.f340747q = true;
        s();
        e();
        ViewParent r103 = getParent();
        if (r103 == null) goto L12;
        r103.requestDisallowInterceptTouchEvent(true);
    L12:
        return this.f340747q;
    }

    public final void setAutoScrollEnabled(boolean r100) {
        this.f340742l = r100;
        if (r100 == true) goto L6;
        s();
        return;
    }

    public final void setOnPrimaryQueryClickListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f340756z = r100;
    }

    public final void setOnTopicChangedListener(Function2<? super Integer, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f340755y = r100;
        r100.invoke(Integer.valueOf(this.f340743m), Boolean.FALSE);
    }

    public final void setTopicList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.EXTRA_KEY_TOPICS);
        List<String> r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        String r103 = StringsKt.trim((String) r102.next()).toString();
        if (r103.length() <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L15:
        if (r101.isEmpty() == false) goto L17;
        r101 = this.f340731a;
    L17:
        this.f340732b = r101;
        m();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        q();
        return;
    L5:
        s();
    }

    public final void t(MotionEvent r100) {
        if (r100.getActionMasked() != 0) goto L6;
        l();
        this.f340748r = VelocityTracker.obtain();
    L6:
        if (r100.getEventTime() == this.f340753w) goto L8;
    L9:
        VelocityTracker r101 = this.f340748r;
        if (r101 == null) goto L12;
        r101.addMovement(r100);
    L12:
        this.f340753w = r100.getEventTime();
        this.f340754x = r100.getActionMasked();
        return;
    L8:
        if (r100.getActionMasked() != this.f340754x) goto L9;
    }

    public final void u(float r100) {
        if (this.f340732b.isEmpty() == false) goto L5;
        return;
    L5:
        float r101 = i(60);
        int r102 = 2;
        if (Math.abs(r100) < (2 * r101)) goto L8;
        r102 = 4;
    L8:
        float r103 = (-RangesKt.coerceIn(r100, (-r102) * r101, r102 * r101)) / r101;
        boolean r104 = true;
        if (r103 >= 0.0f) goto L11;
        int r105 = -1;
    L12:
        float r106 = Math.abs(r103);
        int r107 = (int) r106;
        float r108 = r106 - r107;
        int r109 = this.f340743m + (r107 * r105);
        int r110 = this.f340732b.size();
        int r111 = ((r109 % r110) + r110) % r110;
        int r112 = this.f340732b.size();
        int r113 = (((r111 + r105) % r112) + r112) % r112;
        b r114 = this.f340751u;
        if (r114 != null) goto L15;
    L24:
        r114 = k(r111, r113);
        this.f340751u = r114;
        c(r111, r105);
    L25:
        setOffsetY(((-r105) * r108) * r101);
        n(r114, r105, r108);
        return;
    L15:
        if (r114.f340757a == r111) goto L17;
    L19:
        r104 = false;
    L20:
        if (r104 == true) goto L23;
        r114 = null;
    L23:
        if (r114 != null) goto L25;
    L17:
        if (r114.f340758b != r113) goto L19;
    L11:
        r105 = 1;
        goto L12
    }

    public final void c(int r100, int r101) {
        TextView r102 = this.f340737g;
        List<String> r103 = this.f340732b;
        int r104 = r103.size();
        r102.setText((CharSequence) ListProtector.get(r103, (((r100 + r101) % r104) + r104) % r104));
        TextView r105 = this.f340738h;
        List<String> r106 = this.f340732b;
        int r107 = r100 + (r101 * 2);
        int r108 = r106.size();
        r105.setText((CharSequence) ListProtector.get(r106, ((r107 % r108) + r108) % r108));
    }

    public final void f(int r100, boolean r101) {
        this.f340749s = null;
        if (r101 == false) goto L8;
        if (r100 == 0) goto L8;
        int r102 = this.f340743m + r100;
        int r103 = this.f340732b.size();
        int r104 = ((r102 % r103) + r103) % r103;
        this.f340743m = r104;
        Function2<? super Integer, ? super Boolean, Unit> r105 = this.f340755y;
        if (r105 == null) goto L8;
        r105.invoke(Integer.valueOf(r104), Boolean.TRUE);
    L8:
        o();
        this.f340744n = false;
        q();
    }

    public final b k(int r110, int r111) {
        this.f340734d.setText((CharSequence) ListProtector.get(this.f340732b, r110));
        Integer r100 = Integer.valueOf(j((String) ListProtector.get(this.f340732b, r110)));
        boolean r101 = true;
        if (r100.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        Integer r103 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        int r104 = r100.intValue();
    L13:
        int r105 = r104;
        Integer r106 = Integer.valueOf(j((String) ListProtector.get(this.f340732b, r111)));
        if (r106.intValue() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L22;
        int r108 = r106.intValue();
    L23:
        String r109 = (String) ListProtector.get(this.f340732b, r111);
        Integer r112 = Integer.valueOf(this.f340733c.getWidth());
        if (r112.intValue() > 0) goto L27;
        r101 = false;
    L27:
        if (r101 == false) goto L29;
        r103 = r112;
    L29:
        if (r103 == null) goto L31;
        int r113 = r103.intValue();
    L33:
        return new b(r110, r111, r105, r108, (((i(16) + r113) + i(8)) + (this.f340734d.getPaint().measureText(r109) / 2.0f)) - (r108 / 2.0f));
    L31:
        r113 = MathKt.roundToInt(this.f340733c.getPaint().measureText(this.f340733c.getText().toString()));
        goto L33
    L22:
        r108 = r105;
        goto L23
    L16:
        r107 = false;
        goto L17
    L12:
        r104 = this.f340736f.getWidth();
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public ObricDoraGOnboardingTopicView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        List<String> r100 = CollectionsKt.listOf(new String[]{r110.getString(R.string.larus_dora_onboarding_glasses_query_text_meaning_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_flower_type_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_food_calories_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_cat_breed_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_building_style_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_plant_care_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_fridge_recipe_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_product_price_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_laundry_care_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_durian_pick_cn), r110.getString(R.string.larus_dora_onboarding_glasses_query_nearby_places_cn)});
        this.f340731a = r100;
        this.f340732b = r100;
        Typeface r101 = F;
        final TextView r102 = g(this, 0, r101, 1);
        r102.setText(r110.getString(R.string.onboarding_vision_wake_word));
        r102.post(new z(r102, this));
        this.f340733c = r102;
        TextView r103 = g(this, 0, r101, 1);
        this.f340734d = r103;
        ImageView r113 = new ImageView(r110);
        r113.setImageResource(R.drawable.obric_onboarding_query_arrow);
        this.f340735e = r113;
        LinearLayout r114 = new LinearLayout(getContext());
        r114.setBackground(ContextCompat.getDrawable(r114.getContext(), R.drawable.obric_onboarding_topic_primary_bg));
        r114.setGravity(16);
        r114.setOrientation(0);
        r114.setPadding(i(16), 0, i(16), 0);
        r114.setOnClickListener(new b0(this));
        r114.addView(r102, new LinearLayout.LayoutParams(-2, -1));
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -1);
        r104.setMarginStart(i(8));
        Unit r105 = Unit.INSTANCE;
        r114.addView(r103, r104);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(i(7), i(12));
        r106.setMarginStart(i(14));
        r106.gravity = 16;
        r114.addView(r113, r106);
        r114.setLayoutParams(new LinearLayout.LayoutParams(-2, i(48)));
        this.f340736f = r114;
        TextView r115 = g(this, 17, null, 2);
        this.f340737g = r115;
        TextView r107 = g(this, 17, null, 2);
        this.f340738h = r107;
        LinearLayout r108 = new LinearLayout(r110);
        r108.setGravity(1);
        r108.setOrientation(1);
        this.f340739i = r108;
        this.f340740j = CoroutineScopeKt.MainScope();
        this.f340742l = true;
        this.f340753w = Long.MIN_VALUE;
        this.f340754x = 3;
        this.A = ViewConfiguration.get(r110).getScaledTouchSlop();
        this.B = MathKt.roundToInt(ViewConfiguration.get(r110).getScaledMinimumFlingVelocity() * 1.5f);
        Paint r116 = new Paint(1);
        r116.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.C = r116;
        this.D = new float[]{getResources().getDimension(R.dimen.larus_dp_48), getResources().getDimension(R.dimen.larus_dp_93), getResources().getDimension(R.dimen.larus_dp_147)};
        setClipChildren(true);
        LinearLayout r109 = new LinearLayout(r110);
        r109.setGravity(1);
        r109.setOrientation(1);
        r109.addView(r114);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-1, -2);
        r117.topMargin = i(12);
        r109.addView(r108, r117);
        addView(r109, new FrameLayout.LayoutParams(-1, -2));
        r108.addView(r115, new LinearLayout.LayoutParams(-1, i(48)));
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(-1, i(48));
        r118.topMargin = i(12);
        r108.addView(r107, r118);
        d();
    }

    public final void h(float r100, float r101, boolean r110) {
        if (this.f340732b.isEmpty() == false) goto L6;
        q();
        return;
    L6:
        float r102 = i(60);
        if (Math.abs(r101) < this.B) goto L9;
        float r103 = RangesKt.coerceIn(r101 * 0.08f, -i(120), i(120));
    L11:
        if (r110 == true) goto L13;
        int r104 = 0;
    L18:
        s();
        this.f340744n = true;
        float r105 = (-r104) * i(60);
        float r106 = Math.abs(r105 - r100);
        if (r106 >= 0.5f) goto L21;
        f(r104, r110);
        return;
    L21:
        Ref.BooleanRef r107 = new Ref.BooleanRef();
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{r100, r105});
        r108.setDuration((long) ((RangesKt.coerceAtMost(r106 / i(60), 4.0f) * 55.0f) + 160.0f));
        r108.setInterpolator(new AccelerateDecelerateInterpolator());
        r108.addUpdateListener(new c0(this));
        r108.addListener(new e0(r107, this, r104, r110));
        r108.start();
        this.f340749s = r108;
        return;
    L13:
        if (Math.abs(r100) < (2 * r102)) goto L15;
        int r109 = 4;
    L16:
        r104 = RangesKt.coerceIn(MathKt.roundToInt((-(r103 + r100)) / r102), -r109, r109);
        goto L18
    L15:
        r109 = 2;
        goto L16
    L9:
        r103 = 0.0f;
        goto L11
    }

    public final void n(b r100, int r101, float r102) {
        int r103 = r100.f340760d;
        int r104 = r100.f340759c;
        float r105 = (r103 - r104) * r102;
        setPrimaryQueryWidth(r104 + MathKt.roundToInt(r105));
        this.f340735e.setTranslationX(r105);
        this.f340734d.setTranslationY(((-r101) * i(60)) * r102);
        this.f340734d.setAlpha(1.0f - r102);
        this.f340737g.setTranslationX(r100.f340761e * r102);
    }

    public /* synthetic */ ObricDoraGOnboardingTopicView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void a(ObricDoraGOnboardingTopicView r100, b r101, int r102, ValueAnimator r103) {
        Intrinsics.checkNotNullParameter(r103, "animator");
        Object r104 = r103.getAnimatedValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Float");
        r100.setOffsetY(((Float) r104).floatValue());
        r100.n(r101, r102, r103.getAnimatedFraction());
    }

    public static TextView g(ObricDoraGOnboardingTopicView r100, int r101, Typeface r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 16;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = G;
    L8:
        r100.getClass();
        TextView r104 = new TextView(r100.getContext());
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.setGravity(r101);
        r104.setIncludeFontPadding(false);
        r104.setLineSpacing(0.0f, 1.5f);
        r104.setMaxLines(1);
        r104.setTextSize(2, 16.0f);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), R.color.onboarding_query_tail_text));
        r104.setTypeface(r102);
        return r104;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        if (r100 <= 0) goto L6;
        if (r110 <= 0) goto L6;
        float r101 = r110;
        float[] r113 = this.D;
        LinearGradient r102 = new LinearGradient(0.0f, 0.0f, 0.0f, r101, new int[]{-16777216, -16777216, 1291845632, 520093696, 520093696}, new float[]{0.0f, r113[0] / r101, r113[1] / r101, r113[2] / r101, 1.0f}, Shader.TileMode.CLAMP);
    L7:
        this.E = r102;
        return;
    L6:
        r102 = null;
        goto L7
    }
}
