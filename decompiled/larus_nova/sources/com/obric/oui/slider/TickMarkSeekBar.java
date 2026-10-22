package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.oui.common.style.q;
import com.obric.oui.common.style.r;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import fja.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import vma.h;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002FGB'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0005¢\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\t2\b\b\u0001\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\t2\b\b\u0001\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\t2\b\b\u0001\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\t2\b\b\u0001\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\t2\b\b\u0001\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u001e\u001a\u00020\u0005J\u0010\u0010!\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$R*\u0010.\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00028B@BX\u0082\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u00103\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R*\u0010:\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010)\u001a\u0004\b<\u0010+\"\u0004\b=\u0010-¨\u0006H"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "getTrackStartX", "getTrackEndX", "", "getCompatMinValue", "", "enabled", "", "setDebugLogEnabled", "tickMarkCount", "setDefaultTickMarkCount", "backgroundHeight", "setBackgroundHeight", "backgroundColor", "setProcessBackgroundColorInt", "progressColor", "setProcessProgressColorInt", "backgroundColorResId", "setProcessBackgroundColor", "progressColorResId", "setProcessProgressColor", "color", "setTickColorInt", "setTickColor", "minVisibleProgress", "setMinVisibleProgress", "maxVisibleProgress", "setMaxVisibleProgress", "thumbColor", "setThumbColorInt", "thumbColorResId", "setThumbColor", "progress", "setProgress", "Lcom/obric/oui/slider/TickMarkSeekBar$b;", "l", "setOnSeekBarChangeListenerExt", "value", ce.f26395j, FaceService.girlLabel, "getCurrentProgress", "()F", "setCurrentProgress", "(F)V", "currentProgress", "I", "Lkotlin/Lazy;", "getTouchSlop", "()I", "touchSlop", ExifInterface.GPS_DIRECTION_TRUE, "Z", "getEnableMoveThumbOnDownOutside", "()Z", "setEnableMoveThumbOnDownOutside", "(Z)V", "enableMoveThumbOnDownOutside", "U", "getMTouchProgressOffset", "setMTouchProgressOffset", "mTouchProgressOffset", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class TickMarkSeekBar extends AppCompatSeekBar {
    public static final /* synthetic */ int W = 0;
    public final q A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final float H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f403003J;
    public float K;
    public boolean L;
    public boolean M;
    public int N;
    public float O;
    public MotionEvent P;
    public final com.obric.oui.slider.c Q;
    public final boolean R;
    public boolean S;
    public boolean T;
    public float U;
    public b V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f403004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f403005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f403006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f403007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f403008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f403009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f403010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f403011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f403012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f403013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f403014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f403015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f403016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f403017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f403018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f403019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f403020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f403021r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f403022s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f403023t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Path f403024u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f403025v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f403026w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f403027x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f403028y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.obric.oui.slider.a f403029z;

    public static final class a {
        public a() {
        }

        public static final String a(int r100) {
            int r101 = TickMarkSeekBar.W;
            if (r100 != 0) goto L5;
            return "DOWN";
        L5:
            if (r100 != 1) goto L7;
            return "UP";
        L7:
            if (r100 != 2) goto L9;
            return "MOVE";
        L9:
            if (r100 != 3) goto L11;
            return "CANCEL";
        L11:
            if (r100 != 5) goto L13;
            return "POINTER_DOWN";
        L13:
            if (r100 != 6) goto L22;
            return "POINTER_UP";
        L22:
            return String.valueOf(r100);
        }
    }

    public interface b {
        void a(SeekBar r100, float r101, boolean r102);

        void b(SeekBar r100);

        void c(SeekBar r100, float r101);

        void d(TickMarkSeekBar r100);

        void e(int r100);

        void onStartTrackingTouch(SeekBar r100);
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TickMarkSeekBar f403030a;

        public c(TickMarkSeekBar r100) {
            this.f403030a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            TickMarkSeekBar r101 = this.f403030a;
            int r102 = TickMarkSeekBar.W;
            r101.getClass();
            b r103 = this.f403030a.V;
            if (r103 == null) goto L7;
            r103.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            TickMarkSeekBar r101 = this.f403030a;
            b r102 = r101.V;
            if (r102 == null) goto L7;
            r102.d(r101);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r110, int r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r110, "seekBar");
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L48:
            TickMarkSeekBar r100 = this.f403030a;
            if (r100.m() == false) goto L52;
            StringBuilder r101 = new StringBuilder("[listener-progress][");
            r101.append(Integer.toHexString(System.identityHashCode(r100)));
            r101.append("] ");
            r101.append("progress=" + r111 + ", fromUser=" + r112 + ", currentProgress=" + TickMarkSeekBar.b(r100) + ", currentTargetProgress=" + r100.f403014k + ", tickMarkCount=" + r100.f403004a);
            wma.b.a("TickSeekBar", r101.toString());
        L52:
            TickMarkSeekBar r102 = this.f403030a;
            b r103 = r102.V;
            if (r103 == null) goto L59;
            r103.a(r110, r102.r(r111), r112);
            return;
        L59:
            return;
        L5:
            if (this.f403030a.isHapticFeedbackEnabled() == false) goto L48;
            TickMarkSeekBar r104 = this.f403030a;
            com.obric.oui.slider.a r105 = r104.f403029z;
            Context r106 = r104.getContext();
            TickMarkSeekBar r107 = this.f403030a;
            int r108 = r107.f403004a;
            boolean r109 = r107.f403028y;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "seekBar");
            if (r112 == true) goto L9;
            r105.f403031a = Integer.valueOf(r111);
            r105.f403032b = Integer.MAX_VALUE;
            goto L48
        L9:
            r105.f403032b = 0;
            int r113 = r110.getMin();
            int r114 = r110.getMax();
            if (r111 != r113) goto L12;
            r105.a(r106, 5, "hit minProgress", true, null);
            goto L48
        L12:
            if (r111 != r114) goto L14;
            r105.a(r106, 4, "hit maxProgress", true, null);
            goto L48
        L14:
            int r115 = r108 - 1;
            if (r109 == false) goto L48;
            if (r115 <= 1) goto L48;
            if (r105.f403031a == null) goto L47;
            float r116 = (r114 - r113) / r115;
            if (1 > r115) goto L47;
            int r117 = 1;
        L23:
            int r118 = r117 + 1;
            int r119 = MathKt.roundToInt((r117 * r116) - (r116 / 2)) + r113;
            Integer r120 = r105.f403031a;
            Intrinsics.checkNotNull(r120);
            if (r120.intValue() >= r119) goto L27;
            if (r111 < r119) goto L27;
            boolean r121 = true;
        L28:
            Integer r122 = r105.f403031a;
            Intrinsics.checkNotNull(r122);
            if (r122.intValue() <= r119) goto L32;
            if (r111 > r119) goto L32;
            boolean r123 = true;
        L33:
            if (r117 == 1) goto L42;
            if (r117 != r115) goto L37;
            r121 = r123;
            goto L42
        L37:
            if (r121 == true) goto L41;
            if (r123 == true) goto L41;
            r121 = false;
        L41:
            r121 = true;
        L42:
            if (r121 == true) goto L43;
            if (r117 == r115) goto L47;
            r117 = r118;
            goto L23
        L43:
            r105.a(r106, 26, "passed boundary: " + r117 + '/' + r115 + ", progress: " + r111, false, r110);
        L32:
            r123 = false;
        L27:
            r121 = false;
        L47:
            r105.f403031a = Integer.valueOf(r111);
            goto L48
        }
    }

    static {
        new a();
    }

    public TickMarkSeekBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TickMarkSeekBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getCompatMinValue() {
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return 0;
    L7:
        return getMin();
    }

    private final int getTouchSlop() {
        return ((Number) this.I.getValue()).intValue();
    }

    private final float getTrackStartX() {
        return this.H + (this.f403009f / 2.0f);
    }

    public final void d() {
        if (this.f403028y == false) goto L35;
        final int r100 = 0;
        IntRange r101 = RangesKt.until(0, this.f403004a);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Integer> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(Integer.valueOf(p(((IntIterator) r103).nextInt())));
        goto L6
    L8:
        Iterator<Integer> r104 = CollectionsKt.getIndices(r102).iterator();
        if (r104.hasNext() == true) goto L11;
        Integer r105 = null;
    L21:
        Integer r106 = r105;
        if (r106 == null) goto L25;
        r100 = r106.intValue();
    L25:
        int r107 = ((Number) ListProtector.get(r102, r100)).intValue();
        Runnable r108 = new com.obric.oui.slider.b(this, r100);
        boolean r109 = s(r107, r108);
        if (m() == false) goto L29;
        StringBuilder r110 = new StringBuilder("[anchor-point][");
        r110.append(Integer.toHexString(System.identityHashCode(this)));
        r110.append("] ");
        r110.append("closestTickIndex=" + r100 + ", closestProgress=" + r107 + ", currentProgress=" + getCurrentProgress() + ", result=" + r109);
        wma.b.a("TickSeekBar", r110.toString());
    L29:
        if (r109 == true) goto L36;
        r108.run();
        return;
    L36:
        return;
    L11:
        Integer r111 = r104.next();
        if (r104.hasNext() == true) goto L14;
    L13:
        r105 = r111;
        goto L21
    L14:
        int r112 = Math.abs(((Number) ListProtector.get(r102, r111.intValue())).intValue() - getProgress());
    L15:
        Integer r113 = r104.next();
        int r114 = Math.abs(((Number) ListProtector.get(r102, r113.intValue())).intValue() - getProgress());
        if (r112 <= r114) goto L19;
        r111 = r113;
        r112 = r114;
    L19:
        if (r104.hasNext() == true) goto L15;
    }

    public final void f() {
        MotionEvent r100 = this.P;
        if (r100 == null) goto L6;
        r100.recycle();
    L6:
        this.P = null;
        removeCallbacks(this.Q);
    }

    public final boolean m() {
        if (this.S == true) goto L5;
        return false;
    L5:
        return true;
    }

    private final float getTrackEndX() {
        return (getWidth() - this.H) - (this.f403009f / 2.0f);
    }

    public final float h() {
        float r100 = getWidth();
        float r101 = this.H;
        float r102 = this.f403009f;
        return (r101 + (r102 / 2.0f)) + ((getCurrentProgress() / getMax()) * (((r100 - r101) - r101) - r102));
    }

    public final void o() {
        if (m() == false) goto L6;
        StringBuilder r100 = new StringBuilder("[reset-touch-state][");
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append("] ");
        r100.append("isThumbOnTouchDown=" + this.D + ", isThumbOnTouchEvent=" + this.E + ", hasDirectionLocked=" + this.L + ", isDraggingHorizontally=" + this.M);
        wma.b.a("TickSeekBar", r100.toString());
    L6:
        this.D = false;
        this.E = false;
        this.L = false;
        this.M = false;
        f();
        t(false);
        getParent().requestDisallowInterceptTouchEvent(false);
    }

    private final float getCurrentProgress() {
        return this.f403013j;
    }

    public final boolean getEnableMoveThumbOnDownOutside() {
        return this.T;
    }

    public final float getMTouchProgressOffset() {
        return this.U;
    }

    public static void a(TickMarkSeekBar r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r100.B == false) goto L22;
        if (r100.F == true) goto L22;
        if (r100.L == true) goto L22;
        if (r100.M == true) goto L22;
        if (r100.D == true) goto L22;
        MotionEvent r101 = r100.P;
        r100.P = null;
        r100.removeCallbacks(r100.Q);
        if (r101 != null) goto L17;
        return;
    L17:
        if (r100.m() == false) goto L20;
        StringBuilder r102 = new StringBuilder("[delayed-track-run][");
        r102.append(Integer.toHexString(System.identityHashCode(r100)));
        r102.append("] ");
        r102.append("action=" + a.a(r101.getAction()) + ", x=" + r101.getX() + ", progress=" + r100.getProgress() + ", currentProgress=" + r100.getCurrentProgress());
        wma.b.a("TickSeekBar", r102.toString());
    L20:
        r100.u(r101);
        r101.recycle();
        return;
    L22:
        if (r100.m() == false) goto L25;
        StringBuilder r103 = new StringBuilder("[delayed-track-skip][");
        r103.append(Integer.toHexString(System.identityHashCode(r100)));
        r103.append("] ");
        r103.append("isPress=" + r100.B + ", isInternalUpdating=" + r100.F + ", hasDirectionLocked=" + r100.L + ", isDraggingHorizontally=" + r100.M + ", isThumbOnTouchDown=" + r100.D);
        wma.b.a("TickSeekBar", r103.toString());
    L25:
        r100.f();
    }

    public static final /* synthetic */ float b(TickMarkSeekBar r100) {
        return r100.getCurrentProgress();
    }

    private final void setCurrentProgress(float r100) {
        this.f403013j = r100;
    }

    public final float e(float r100) {
        float r101 = getTrackStartX();
        float r102 = getTrackEndX() - r101;
        if (r102 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn((q(r100) - r101) / r102, 0.0f, 1.0f);
    }

    public final void g(MotionEvent r100) {
        if (m() == false) goto L10;
        StringBuilder r101 = new StringBuilder("[internal-update-cancel][");
        r101.append(Integer.toHexString(System.identityHashCode(this)));
        r101.append("] ");
        StringBuilder r102 = new StringBuilder("action=");
        if (r100 != null) goto L8;
        int r103 = -1;
    L9:
        r102.append(a.a(r103));
        r102.append(", progress=");
        r102.append(getProgress());
        r102.append(", currentProgress=");
        r102.append(getCurrentProgress());
        r102.append(", touchOffset=");
        r102.append(getMTouchProgressOffset());
        r101.append(r102.toString());
        wma.b.a("TickSeekBar", r101.toString());
        goto L10
    L8:
        r103 = r100.getActionMasked();
    L10:
        this.B = false;
        o();
        if (r100 == null) goto L14;
        MotionEvent r104 = MotionEvent.obtain(r100);
        r104.setAction(3);
        super.onTouchEvent(r104);
        r104.recycle();
    L14:
        this.F = false;
    }

    public final void i(Canvas r100) {
        r100.save();
        float r101 = this.f403005b / 2;
        this.f403025v.set(this.H, this.f403006c - r101, getWidth() - this.H, this.f403006c + r101);
        this.f403024u.reset();
        this.f403024u.addRoundRect(this.f403025v, r101, r101, Path.Direction.CW);
        this.f403023t.setColor(this.f403018o);
        r100.drawPath(this.f403024u, this.f403023t);
        r100.restore();
        if (this.f403028y == false) goto L6;
        l(r100);
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "dr");
        super.invalidateDrawable(r100);
    }

    public final void j(Canvas r110) {
        int r100 = r110.save();
        if (getProgressDrawable() == null) goto L5;
        Drawable r101 = getProgressDrawable();
        r110.translate(0.0f, getPaddingTop());
        r101.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r101.getIntrinsicHeight() / 2), getMeasuredWidth(), (getMeasuredHeight() / 2) + (r101.getIntrinsicHeight() / 2)));
        r101.draw(r110);
    L9:
        r110.restoreToCount(r100);
        return;
    L5:
        float r102 = this.f403005b / 2;
        float r103 = h();
        float r104 = (this.f403009f * this.f403010g) / 2.0f;
        RectF r105 = this.f403025v;
        float r106 = this.H;
        float r107 = this.f403006c;
        r105.set(r106, r107 - r102, r103, r107 + r102);
        this.f403027x.reset();
        this.f403027x.addRoundRect(this.f403025v, new float[]{r102, r102, 0.0f, 0.0f, 0.0f, 0.0f, r102, r102}, Path.Direction.CW);
        this.f403023t.setColor(this.f403019p);
        if (Build.VERSION.SDK_INT < 26) goto L8;
        this.f403024u.reset();
        this.f403024u.addCircle(r103, this.f403006c, r104, Path.Direction.CW);
        r110.clipOutPath(this.f403024u);
    L8:
        r110.drawPath(this.f403027x, this.f403023t);
        goto L9
    }

    public final void k(Canvas r110) {
        if (this.f403020q != 0) goto L5;
        return;
    L5:
        r110.save();
        float r100 = this.f403009f * this.f403010g;
        float r101 = h();
        this.f403023t.setColor(this.f403020q);
        float r102 = r100 / 2.0f;
        float r103 = this.f403006c;
        this.f403025v.set(r101 - r102, r103 - r102, r101 + r102, r103 + r102);
        r110.drawRoundRect(this.f403025v, r102, r102, this.f403023t);
        r110.restore();
        r110.save();
        int r104 = h.f556353a;
        q r105 = this.A;
        RectF r106 = this.f403025v;
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r105, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        Intrinsics.checkNotNullParameter(r106, SVGRenderEngine.RECT);
        float r107 = r105.f399598g;
        if (r107 > 0.0f) goto L9;
        r107 = r102;
    L9:
        Path r108 = new Path();
        SmoothCornerHelper r109 = r.f399599a;
        Intrinsics.checkNotNullParameter(r108, "path");
        Intrinsics.checkNotNullParameter(r106, SVGRenderEngine.RECT);
        r108.addPath(r.a(r106, r107));
        int r111 = r110.save();
        RectF r112 = new RectF(r106);
        r112.offset(r105.f399594c, r105.f399595d);
        float r113 = -r105.f399596e;
        r112.inset(r113, r113);
        r110.clipOutPath(r108);
        r105.f399597f.setColor(r105.f399592a);
        if (r105.f399593b <= 0.0f) goto L12;
        r105.f399597f.setMaskFilter(new BlurMaskFilter(r105.f399593b, BlurMaskFilter.Blur.NORMAL));
    L12:
        r.e(r110, r112, r107, r105.f399597f);
        r110.restoreToCount(r111);
        r110.restore();
        float r114 = this.O / 2.0f;
        this.f403026w.set(this.f403025v);
        float r115 = -r114;
        this.f403026w.inset(r115, r115);
        Paint.Style r116 = this.f403023t.getStyle();
        float r117 = this.f403023t.getStrokeWidth();
        this.f403023t.setStyle(Paint.Style.STROKE);
        this.f403023t.setStrokeWidth(this.O);
        this.f403023t.setColor(this.f403021r);
        float r118 = r102 + r114;
        r110.drawRoundRect(this.f403026w, r118, r118, this.f403023t);
        this.f403023t.setStrokeWidth(r117);
        this.f403023t.setStyle(r116);
    }

    public final void l(Canvas r100) {
        if (this.f403004a > 0) goto L5;
        return;
    L5:
        if (this.f403028y == false) goto L11;
        float r101 = getWidth();
        float r102 = this.H;
        float r103 = ((r101 - r102) - r102) - this.f403009f;
        int r104 = this.f403004a;
        float r105 = r103 / (r104 - 1);
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L12;
        int r107 = r106 + 1;
        float r108 = this.H;
        float r109 = this.f403009f;
        float r110 = (r108 + (r109 / 2.0f)) + (r106 * r105);
        float r111 = (this.f403006c + (r109 / 2.0f)) - this.f403017n;
        this.f403023t.setColor(this.f403022s);
        r100.drawCircle(r110, r111, this.f403017n, this.f403023t);
        r106 = r107;
        goto L7
    L12:
        return;
    }

    public final boolean n(float r100) {
        float r101 = q(r100);
        boolean r102 = true;
        if (r101 > getTrackStartX()) goto L5;
        boolean r103 = true;
    L7:
        if (r101 < getTrackEndX()) goto L9;
        boolean r104 = true;
    L10:
        if (r103 == true) goto L14;
        if (r104 == true) goto L14;
        r102 = false;
    L14:
        if (r102 == true) goto L16;
    L19:
        return r102;
    L16:
        if (m() == false) goto L19;
        StringBuilder r105 = new StringBuilder("[track-edge-hit][");
        r105.append(Integer.toHexString(System.identityHashCode(this)));
        r105.append("] ");
        r105.append("rawX=" + r100 + ", logicalX=" + r101 + ", hitStart=" + r103 + ", hitEnd=" + r104 + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX());
        wma.b.a("TickSeekBar", r105.toString());
        goto L19
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.N = pla.d.n(this, 32);
        this.O = pla.d.o(this, 0.5d);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "canvas");     // Catch: Throwable -> L9
        if (this.G == false) goto L6;
        this.G = false;     // Catch: Throwable -> L9
        setCurrentProgress(getProgress());     // Catch: Throwable -> L9
    L6:
        i(r100);     // Catch: Throwable -> L9
        l(r100);     // Catch: Throwable -> L9
        j(r100);     // Catch: Throwable -> L9
        k(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r210) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        String r100 = "action=";
        if (m() == false) goto L22;
        StringBuilder r101 = new StringBuilder("[touch-enter][");
        r101.append(Integer.toHexString(System.identityHashCode(this)));
        r101.append("] ");
        StringBuilder r110 = new StringBuilder("action=");
        if (r210 != null) goto L11;
        int r111 = -1;
    L12:
        r110.append(a.a(r111));
        r110.append(", x=");
        if (r210 != null) goto L15;
        Float r112 = null;
    L16:
        r110.append(r112);
        r110.append(", y=");
        if (r210 != null) goto L19;
        Float r113 = null;
    L20:
        r110.append(r113);
        r110.append(", progress=");
        r110.append(getProgress());
        r110.append(", currentProgress=");
        r110.append(getCurrentProgress());
        r110.append(", isPress=");
        r110.append(this.B);
        r110.append(", isInternalUpdating=");
        r110.append(this.F);
        r110.append(", touchOffset=");
        r110.append(getMTouchProgressOffset());
        r101.append(r110.toString());
        wma.b.a("TickSeekBar", r101.toString());
        goto L22
    L19:
        r113 = Float.valueOf(r210.getY());
        goto L20
    L15:
        r112 = Float.valueOf(r210.getX());
        goto L16
    L11:
        r111 = r210.getActionMasked();
    L22:
        if (this.F == true) goto L24;
        int r102 = (int) (((int) this.H) + (this.f403009f / 2));
        setPadding(r102, 0, r102, 0);
        if (r210 != null) goto L36;
        Integer r103 = null;
    L37:
        if (r210 != null) goto L39;
        Integer r104 = null;
    L41:
        if (r104 != null) goto L44;
    L49:
        String r105 = ", offset=";
        if (r103 != null) goto L53;
    L54:
        if (r103 != null) goto L57;
    L59:
        this.B = false;
        this.D = false;
        this.E = false;
        f();
        invalidate();
        r210 = r210;
        r104 = r104;
        r100 = "action=";
        String r106 = ", progress=";
        boolean r114 = false;
    L161:
        if (r210 != null) goto L164;
    L186:
        String r115 = ", touchOffset=";
    L200:
        MotionEvent r107 = null;
    L206:
        if (r107 != null) goto L208;
        MotionEvent r108 = r210;
    L209:
        boolean r109 = super.onTouchEvent(r108);
        if (m() == true) goto L212;
        String r116 = r100;
    L225:
        if (r107 == null) goto L229;
        r107.recycle();
        Unit r117 = Unit.INSTANCE;
    L229:
        if (this.F == false) goto L231;
        g(r210);
        boolean r118 = true;
    L232:
        if (r210 == null) goto L269;
        int r119 = r210.getAction();
        if (this.F == true) goto L268;
        if (r119 == 0) goto L246;
        if (r119 != 2) goto L249;
        if (this.D == false) goto L243;
    L244:
        u(r210);
        goto L249
    L243:
        if (this.M == true) goto L244;
    L249:
        if (r119 == 1) goto L254;
        if (r119 != 3) goto L268;
    L254:
        if (m() == false) goto L258;
        StringBuilder r120 = new StringBuilder("[touch-finish][");
        r120.append(Integer.toHexString(System.identityHashCode(this)));
        r120.append("] ");
        r120.append(r116 + a.a(r119) + r106 + getProgress() + ", currentProgress=" + getCurrentProgress() + ", isStyleSegmented=" + this.f403028y + r115 + getMTouchProgressOffset());
        wma.b.a("TickSeekBar", r120.toString());
    L258:
        if (r119 == 1) goto L260;
    L267:
        o();
        goto L268
    L260:
        if (this.f403028y == false) goto L262;
        d();
    L263:
        b r121 = this.V;
        if (r121 == null) goto L267;
        r121.c(this, r(getProgress()));
        Unit r122 = Unit.INSTANCE;
        goto L267
    L262:
        s(getProgress(), null);
        goto L263
    L246:
        if (this.D == false) goto L249;
        u(r210);
    L268:
        Unit r123 = Unit.INSTANCE;
    L269:
        this.F = false;
        setPadding(0, 0, 0, 0);
        if (m() == false) goto L277;
        StringBuilder r124 = new StringBuilder("[touch-exit][");
        r124.append(Integer.toHexString(System.identityHashCode(this)));
        r124.append("] ");
        StringBuilder r125 = new StringBuilder(r116);
        if (r104 != null) goto L275;
        int r126 = -1;
    L276:
        r125.append(a.a(r126));
        r125.append(r106);
        r125.append(getProgress());
        r125.append(", currentProgress=");
        r125.append(getCurrentProgress());
        r125.append(", forceBreakTouch=");
        r125.append(r118);
        r124.append(r125.toString());
        wma.b.a("TickSeekBar", r124.toString());
        goto L277
    L275:
        r126 = r104.intValue();
    L277:
        if (r118 == false) goto L280;
        return false;
    L280:
        return r109;
    L231:
        r118 = r114;
        goto L232
    L212:
        StringBuilder r127 = new StringBuilder("[touch-super-result][");
        r127.append(Integer.toHexString(System.identityHashCode(this)));
        r127.append("] ");
        if (r107 != null) goto L215;
        MotionEvent r128 = r210;
    L216:
        r116 = r100;
        StringBuilder r129 = new StringBuilder(r116);
        if (r128 != null) goto L219;
        int r130 = -1;
    L220:
        r129.append(a.a(r130));
        r129.append(", usedCorrectedEvent=");
        if (r107 == null) goto L223;
        boolean r131 = true;
    L224:
        r129.append(r131);
        r129.append(r106);
        r129.append(getProgress());
        r129.append(", currentProgress=");
        r129.append(getCurrentProgress());
        r129.append(", result=");
        r129.append(r109);
        r127.append(r129.toString());
        wma.b.a("TickSeekBar", r127.toString());
        goto L225
    L223:
        r131 = false;
        goto L224
    L219:
        r130 = r128.getActionMasked();
        goto L220
    L215:
        r128 = r107;
        goto L216
    L208:
        r108 = r107;
        goto L209
    L164:
        if (r210.getAction() == 0) goto L169;
        if (r210.getAction() != 2) goto L186;
    L169:
        if (this.D == true) goto L173;
        if (this.E == false) goto L186;
    L173:
        if (this.U != 0.0f) goto L175;
        boolean r132 = true;
    L176:
        if (r132 == true) goto L186;
        if (n(r210.getX()) == true) goto L181;
        int r133 = getMax() - getCompatMinValue();
        if (r133 <= 0) goto L186;
        float r134 = e(r210.getX());
        float r135 = RangesKt.coerceIn((this.U / r133) + r134, 0.0f, 1.0f);
        float r136 = this.H + (this.f403009f / 2.0f);
        float r137 = (getWidth() - this.H) - (this.f403009f / 2.0f);
        r115 = ", touchOffset=";
        float r138 = ((r137 - r136) * RangesKt.coerceIn(r135, 0.0f, 1.0f)) + r136;
        if (getLayoutDirection() != 1) goto L190;
        boolean r139 = true;
    L191:
        if (r139 == false) goto L196;
        if (this.R == false) goto L196;
        r138 = (r136 + r137) - r138;
    L196:
        if (r138 != r210.getX()) goto L198;
        boolean r140 = true;
    L199:
        if (r140 == true) goto L200;
        if (m() == false) goto L205;
        StringBuilder r141 = new StringBuilder("[native-event-correct][");
        r141.append(Integer.toHexString(System.identityHashCode(this)));
        r141.append("] ");
        r141.append("rawX=" + r210.getX() + ", scale=" + r134 + ", nativeScale=" + r135 + ", nativeX=" + r138 + r105 + getMTouchProgressOffset() + ", range=" + r133);
        wma.b.a("TickSeekBar", r141.toString());
    L205:
        r107 = MotionEvent.obtain(r210);
        r107.offsetLocation(r138 - r210.getX(), 0.0f);
        goto L206
    L198:
        r140 = false;
        goto L199
    L190:
        r139 = false;
        goto L191
    L181:
        if (m() == false) goto L186;
        StringBuilder r142 = new StringBuilder("[native-event-skip-edge][");
        r142.append(Integer.toHexString(System.identityHashCode(this)));
        r142.append("] ");
        r142.append("x=" + r210.getX() + ", logicalX=" + q(r210.getX()) + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX() + r105 + getMTouchProgressOffset());
        wma.b.a("TickSeekBar", r142.toString());
        goto L186
    L175:
        r132 = false;
        goto L176
    L57:
        if (r103.intValue() != 2) goto L59;
    L61:
        this.B = true;
        float r143 = h();
        float r144 = this.f403009f / 2.0f;
        float r145 = (r143 - r144) - 30.0f;
        float r146 = (r143 + r144) + 30.0f;
        if (getEnableMoveThumbOnDownOutside() == false) goto L78;
        float r147 = r210.getX();
        if (r145 <= r147) goto L66;
    L68:
        boolean r148 = false;
    L69:
        if (r148 == false) goto L78;
        this.E = true;
        if (m() == false) goto L78;
        StringBuilder r149 = new StringBuilder("[thumb-hit-area][");
        r149.append(Integer.toHexString(System.identityHashCode(this)));
        r149.append("] ");
        StringBuilder r150 = new StringBuilder("action=");
        if (r104 != null) goto L76;
        int r211 = -1;
    L77:
        r150.append(a.a(r211));
        r150.append(", x=");
        r150.append(r210.getX());
        r150.append(", thumbLeft=");
        r150.append(r145);
        r150.append(", thumbRight=");
        r150.append(r146);
        r149.append(r150.toString());
        wma.b.a("TickSeekBar", r149.toString());
    L79:
        if (r103 != null) goto L82;
    L127:
        r210 = r210;
        r105 = r105;
        r106 = ", progress=";
        r114 = false;
    L128:
        if (r104 != null) goto L131;
    L152:
        r114 = r114;
        r104 = r104;
    L154:
        if (this.D == false) goto L156;
    L159:
        boolean r151 = true;
    L160:
        t(r151);
        invalidate();
        goto L161
    L156:
        if (this.E == true) goto L159;
        r151 = false;
        goto L160
    L131:
        if (r104.intValue() != 2) goto L152;
        if (this.L == true) goto L152;
        float r152 = Math.abs(r210.getX() - this.f403003J);
        float r153 = Math.abs(r210.getY() - this.K);
        if (r152 <= getTouchSlop()) goto L137;
    L138:
        this.L = true;
        if (r152 <= r153) goto L141;
        boolean r154 = true;
    L142:
        this.M = r154;
        f();
        if (m() == false) goto L147;
        StringBuilder r155 = new StringBuilder("[direction-lock][");
        r155.append(Integer.toHexString(System.identityHashCode(this)));
        r155.append("] ");
        r155.append("dx=" + r152 + ", dy=" + r153 + ", touchSlop=" + getTouchSlop() + ", isDraggingHorizontally=" + this.M + ", isThumbOnTouchDown=" + this.D);
        wma.b.a("TickSeekBar", r155.toString());
    L147:
        if (this.M == false) goto L150;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L154
    L150:
        if (this.D == true) goto L154;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L154
    L141:
        r154 = false;
        goto L142
    L137:
        if (r153 <= getTouchSlop()) goto L152;
    L82:
        if (r103.intValue() != 0) goto L127;
        float r156 = r210.getX();
        if (r145 <= r156) goto L86;
    L88:
        boolean r157 = false;
    L89:
        if (r157 == false) goto L105;
        this.D = true;
        float r158 = r210.getX();
        int r159 = getCompatMinValue();
        int r160 = getMax() - r159;
        if (r160 > 0) goto L93;
        this.U = 0.0f;
    L97:
        getParent().requestDisallowInterceptTouchEvent(true);
        b r161 = this.V;
        if (r161 == null) goto L102;
        r161.b(this);
        Unit r162 = Unit.INSTANCE;
    L102:
        if (m() == true) goto L104;
        r105 = ", offset=";
        r106 = ", progress=";
    L113:
        r114 = false;
    L114:
        if (r114 == true) goto L128;
        if (getEnableMoveThumbOnDownOutside() == false) goto L128;
        if (this.D == true) goto L128;
        this.U = 0.0f;
        b r163 = this.V;
        if (r163 == null) goto L123;
        r163.b(this);
        Unit r164 = Unit.INSTANCE;
    L123:
        this.P = MotionEvent.obtain(r210);
        postDelayed(this.Q, 150);
        if (m() == false) goto L128;
        StringBuilder r165 = new StringBuilder("[delayed-track-schedule][");
        r165.append(Integer.toHexString(System.identityHashCode(this)));
        r165.append("] ");
        r165.append("x=" + r210.getX() + ", y=" + r210.getY() + ", delayMs=150");
        wma.b.a("TickSeekBar", r165.toString());
        goto L128
    L104:
        StringBuilder r166 = new StringBuilder("[touch-down-thumb][");
        r166.append(Integer.toHexString(System.identityHashCode(this)));
        r166.append("] ");
        StringBuilder r167 = new StringBuilder("x=");
        r167.append(r210.getX());
        r105 = r105;
        r167.append(r105);
        r167.append(getMTouchProgressOffset());
        r106 = ", progress=";
        r167.append(r106);
        r167.append(getProgress());
        r167.append(", currentProgress=");
        r167.append(getCurrentProgress());
        r166.append(r167.toString());
        wma.b.a("TickSeekBar", r166.toString());
        goto L113
    L93:
        float r168 = e(r158);
        this.U = getCurrentProgress() - ((r160 * r168) + r159);
        if (m() == false) goto L97;
        StringBuilder r169 = new StringBuilder("[touch-offset-update][");
        r169.append(Integer.toHexString(System.identityHashCode(this)));
        r169.append("] ");
        r169.append("downX=" + r158 + ", scale=" + r168 + ", minValue=" + r159 + ", range=" + r160 + ", currentProgress=" + getCurrentProgress() + ", touchOffset=" + getMTouchProgressOffset());
        wma.b.a("TickSeekBar", r169.toString());
        goto L97
    L105:
        r105 = r105;
        r106 = ", progress=";
        if (getEnableMoveThumbOnDownOutside() == true) goto L113;
        this.B = false;
        this.D = false;
        this.E = false;
        r210 = r210;
        r210.setAction(1);
        if (m() == false) goto L111;
        StringBuilder r170 = new StringBuilder("[touch-down-outside-break][");
        r170.append(Integer.toHexString(System.identityHashCode(this)));
        r170.append("] ");
        r170.append("x=" + r210.getX() + ", enableMoveThumbOnDownOutside=" + getEnableMoveThumbOnDownOutside());
        wma.b.a("TickSeekBar", r170.toString());
    L111:
        r114 = true;
        goto L114
    L86:
        if (r156 > r146) goto L88;
        r157 = true;
        goto L89
    L76:
        r211 = r104.intValue();
        goto L77
    L66:
        if (r147 > r146) goto L68;
        r148 = true;
    L78:
        r100 = "action=";
        goto L79
    L53:
        if (r103.intValue() == 0) goto L61;
    L44:
        if (r104.intValue() != 0) goto L49;
        f();
        this.U = 0.0f;
        this.f403003J = r210.getX();
        this.K = r210.getY();
        this.L = false;
        this.M = false;
        if (m() == false) goto L49;
        StringBuilder r171 = new StringBuilder("[touch-down-init][");
        r171.append(Integer.toHexString(System.identityHashCode(this)));
        r171.append("] ");
        r171.append("x=" + r210.getX() + ", y=" + r210.getY() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", thumbCenter=" + h());
        wma.b.a("TickSeekBar", r171.toString());
        goto L49
    L39:
        r104 = Integer.valueOf(r210.getActionMasked());
        goto L41
    L36:
        r103 = Integer.valueOf(r210.getAction());
        goto L37
    L24:
        if (m() == false) goto L31;
        StringBuilder r172 = new StringBuilder("[touch-break-internal-update][");
        r172.append(Integer.toHexString(System.identityHashCode(this)));
        r172.append("] ");
        StringBuilder r173 = new StringBuilder("action=");
        if (r210 != null) goto L29;
        int r174 = -1;
    L30:
        r173.append(a.a(r174));
        r173.append(", progress=");
        r173.append(getProgress());
        r173.append(", currentProgress=");
        r173.append(getCurrentProgress());
        r172.append(r173.toString());
        wma.b.a("TickSeekBar", r172.toString());
        goto L31
    L29:
        r174 = r210.getActionMasked();
    L31:
        g(r210);
        return false;
    }

    public final int p(int r100) {
        int r101 = this.f403004a;
        if (r101 > 1) goto L6;
        return 0;
    L6:
        if (r100 > 0) goto L10;
        return getCompatMinValue();
    L10:
        if (r100 >= (r101 - 1)) goto L12;
        int r102 = getCompatMinValue();
        return MathKt.roundToInt(r102 + ((getMax() - r102) * (r100 / (this.f403004a - 1))));
    L12:
        return getMax();
    }

    public final float q(float r100) {
        float r101 = getTrackStartX();
        float r102 = getTrackEndX();
        boolean r103 = true;
        if (getLayoutDirection() == 1) goto L6;
        r103 = false;
    L6:
        if (r103 == true) goto L8;
        return r100;
    L8:
        if (this.R == true) goto L10;
        return r100;
    L10:
        return (r101 + r102) - r100;
    }

    public final float r(int r100) {
        return CastFloatProtector.parseFloat(String.format(Locale.CHINA, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 100)}, 1)));
    }

    public final void setBackgroundHeight(float r100) {
        this.f403005b = r100;
        invalidate();
    }

    public final void setDebugLogEnabled(boolean r100) {
        this.S = r100;
        if (m() == false) goto L7;
        StringBuilder r101 = new StringBuilder("[config][");
        r101.append(Integer.toHexString(System.identityHashCode(this)));
        r101.append("] ");
        r101.append("instanceDebug=" + r100 + ", globalDebug=false");
        wma.b.a("TickSeekBar", r101.toString());
        return;
    }

    public void setDefaultTickMarkCount(int r100) {
        this.f403004a = r100;
        invalidate();
    }

    public final void setEnableMoveThumbOnDownOutside(boolean r100) {
        this.T = r100;
    }

    public final void setMTouchProgressOffset(float r100) {
        this.U = r100;
    }

    public final void setMaxVisibleProgress(int r100) {
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setMinVisibleProgress(int r100) {
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(b r100) {
        this.V = r100;
        super.setOnSeekBarChangeListener(new c(this));
    }

    public final void setProcessBackgroundColor(int r100) {
        this.f403018o = ContextCompat.getColor(getContext(), r100);
        invalidate();
    }

    public final void setProcessBackgroundColorInt(int r100) {
        this.f403018o = r100;
        invalidate();
    }

    public final void setProcessProgressColor(int r100) {
        this.f403019p = ContextCompat.getColor(getContext(), r100);
        invalidate();
    }

    public final void setProcessProgressColorInt(int r100) {
        this.f403019p = r100;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100) {
        super.setProgress(r100);
        if (m() == false) goto L6;
        StringBuilder r101 = new StringBuilder("[setProgress][");
        r101.append(Integer.toHexString(System.identityHashCode(this)));
        r101.append("] ");
        r101.append("progress=" + r100 + ", isPress=" + this.B + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.f403014k);
        wma.b.a("TickSeekBar", r101.toString());
    L6:
        this.D = true;
        if (this.B == false) goto L9;
        this.F = true;
    L9:
        s(r100, null);
        this.D = false;
    }

    public final void setThumbColor(int r100) {
        this.f403020q = ContextCompat.getColor(getContext(), r100);
        invalidate();
    }

    public final void setThumbColorInt(int r100) {
        this.f403020q = r100;
        invalidate();
    }

    public final void setTickColor(int r100) {
        this.f403022s = ContextCompat.getColor(getContext(), r100);
        invalidate();
    }

    public final void setTickColorInt(int r100) {
        this.f403022s = r100;
        invalidate();
    }

    public final void t(boolean r100) {
        if (this.C != r100) goto L5;
        return;
    L5:
        this.C = r100;
        d r101 = this.f403012i;
        if (r101 == null) goto L9;
        int r102 = d.f477533d;
        r101.a(false);
    L9:
        com.obric.common.oea.foundation.animation.builder.d.a r103 = new com.obric.common.oea.foundation.animation.builder.d.a();
        float r104 = this.f403010g;
        if (r100 == false) goto L12;
        float r105 = this.f403008e;
    L13:
        r103.b(r104, r105, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4), Float.valueOf(this.f403011h));
        Function3<String, Object, Object, Unit> r106 = new TickMarkSeekBar$toggleThumbScaleAnim$1(this);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r103.f396382d = r106;
        this.f403012i = r103.a().a();
        return;
    L12:
        r105 = this.f403007d;
        goto L13
    }

    public final void u(MotionEvent r100) {
        int r101 = getCompatMinValue();
        int r102 = getMax() - r101;
        if (r102 > 0) goto L6;
        return;
    L6:
        if (n(r100.getX()) == false) goto L11;
        if (q(r100.getX()) > getTrackStartX()) goto L11;
        float r103 = r101;
    L17:
        if (m() == false) goto L20;
        StringBuilder r104 = new StringBuilder("[track-touch][");
        r104.append(Integer.toHexString(System.identityHashCode(this)));
        r104.append("] ");
        r104.append("x=" + r100.getX() + ", logicalX=" + q(r100.getX()) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", newProgress=" + r103 + ", minValue=" + r101 + ", max=" + getMax() + ", touchOffset=" + getMTouchProgressOffset());
        wma.b.a("TickSeekBar", r104.toString());
    L20:
        s(r103, null);
        return;
    L11:
        if (n(r100.getX()) == true) goto L13;
    L15:
        float r105 = this.U + (e(r100.getX()) * r102);
        float r106 = r101;
        r103 = RangesKt.coerceIn(r105 + r106, r106, getMax());
        goto L17
    L13:
        if (q(r100.getX()) < getTrackEndX()) goto L15;
        r103 = getMax();
        goto L17
    }

    public static final /* synthetic */ void c(TickMarkSeekBar r100, float r101) {
        r100.setCurrentProgress(r101);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.N, 1073741824));
    }

    public final boolean s(float r100, final Runnable r101) {
        if (getCurrentProgress() != r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return false;
    L9:
        if (this.D == false) goto L11;
    L28:
        d r103 = this.f403016m;
        if (r103 == null) goto L32;
        int r104 = d.f477533d;
        r103.a(false);
    L32:
        setCurrentProgress(r100);
        this.f403014k = getCurrentProgress();
        invalidate();
        if (r101 == null) goto L36;
        r101.run();
    L36:
        return true;
    L11:
        if (this.E == true) goto L28;
        if (this.f403014k != r100) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == true) goto L23;
        d r106 = this.f403016m;
        if (r106 == null) goto L22;
        int r107 = d.f477533d;
        r106.a(false);
    L22:
        this.f403014k = r100;
        com.obric.common.oea.foundation.animation.builder.d.a r108 = new com.obric.common.oea.foundation.animation.builder.d.a();
        float r109 = getCurrentProgress();
        float r110 = this.f403014k;
        com.obric.common.oea.foundation.animation.spec.spring.b r111 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4);
        r111.f396390b = 0.1f;
        Unit r112 = Unit.INSTANCE;
        r108.b(r109, r110, r111, Float.valueOf(this.f403015l));
        Function3<String, Object, Object, Unit> r113 = new TickMarkSeekBar$toggleProgressChangedAnim$2(this);
        Intrinsics.checkNotNullParameter(r113, "callback");
        r108.f396382d = r113;
        Function2<Boolean, Throwable, Unit> r114 = new TickMarkSeekBar$toggleProgressChangedAnim$3(r101);
        Intrinsics.checkNotNullParameter(r114, "callback");
        r108.f396383e = r114;
        this.f403016m = r108.a().a();
        invalidate();
    L27:
        return true;
    L23:
        setCurrentProgress(r100);
        this.f403014k = r100;
        invalidate();
        if (r101 == null) goto L27;
        r101.run();
        goto L27
    L16:
        r105 = false;
        goto L17
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r100, boolean r101) {
        super.setProgress(r100, r101);
        if (m() == false) goto L7;
        StringBuilder r102 = new StringBuilder("[setProgressWithAnimate][");
        r102.append(Integer.toHexString(System.identityHashCode(this)));
        r102.append("] ");
        r102.append("progress=" + r100 + ", animate=" + r101 + ", isPress=" + this.B + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.f403014k);
        wma.b.a("TickSeekBar", r102.toString());
    L7:
        if (r101 == true) goto L10;
        this.D = true;
    L10:
        if (this.B == false) goto L12;
        this.F = true;
    L12:
        s(r100, null);
        this.D = false;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [com.obric.oui.slider.c] */
    public TickMarkSeekBar(final Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f403004a = -1;
        this.f403005b = pla.d.n(this, 6);
        this.f403006c = pla.d.n(this, 16);
        this.f403007d = 1.0f;
        this.f403008e = 1.22f;
        this.f403009f = pla.d.n(this, 18);
        this.f403010g = 1.0f;
        this.f403017n = pla.d.n(this, 2);
        Paint r100 = new Paint();
        this.f403023t = r100;
        this.f403024u = new Path();
        this.f403025v = new RectF();
        this.f403026w = new RectF();
        this.f403027x = new Path();
        this.f403029z = new com.obric.oui.slider.a();
        q r101 = new q(ColorProtector.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.A = r101;
        this.G = true;
        this.H = pla.d.n(this, 12);
        this.I = LazyKt.lazy(new TickMarkSeekBar$touchSlop$2(r110));
        this.Q = new com.obric.oui.slider.c(this);
        this.T = true;
        this.N = pla.d.n(this, 32);
        this.O = pla.d.o(this, 0.5d);
        TypedArray r113 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.seekbarBackgroundColor, R.attr.seekbarEnableMoveThumbOnDownOutside, R.attr.seekbarHeight, R.attr.seekbarMirrorForRtl, R.attr.seekbarProgressColor, R.attr.seekbarThumbColor, R.attr.seekbarThumbStrokeColor, R.attr.seekbarTickColor}, r112, 0);
        this.f403005b = r113.getDimensionPixelSize(2, pla.d.n(this, 6));
        this.f403018o = r113.getColor(0, ContextCompat.getColor(r110, R.color.oui_basic_line_2));
        this.f403019p = r113.getColor(4, ContextCompat.getColor(r110, R.color.oui_functional_blue_6));
        this.f403020q = r113.getColor(5, ContextCompat.getColor(r110, R.color.oui_on_accent_default));
        this.f403021r = r113.getColor(6, ContextCompat.getColor(r110, R.color.oui_basic_line_1));
        this.f403022s = r113.getColor(7, ContextCompat.getColor(r110, R.color.oui_basic_line_2));
        setEnableMoveThumbOnDownOutside(r113.getBoolean(1, true));
        this.R = r113.getBoolean(3, false);
        r113.recycle();
        setOnSeekBarChangeListenerExt(null);
        r100.setStyle(Paint.Style.FILL);
        int r114 = h.f556353a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "baseShadow");
        TypedArray r115 = r110.obtainStyledAttributes(R.style.OUIShadow_1, new int[]{android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, R.attr.oui_bottomDividerColor, R.attr.oui_bottomDividerHeight, R.attr.oui_bottomDividerInsetLeft, R.attr.oui_bottomDividerInsetRight, R.attr.oui_bottomLeft_radius, R.attr.oui_bottomRight_radius, R.attr.oui_firstOffsetX, R.attr.oui_firstOffsetY, R.attr.oui_firstShadowBlur, R.attr.oui_firstShadowColor, R.attr.oui_firstShadowSpread, R.attr.oui_layout_borderColor, R.attr.oui_layout_borderWidth, R.attr.oui_leftDividerColor, R.attr.oui_leftDividerInsetBottom, R.attr.oui_leftDividerInsetTop, R.attr.oui_leftDividerWidth, R.attr.oui_outerNormalColor, R.attr.oui_outlineExcludePadding, R.attr.oui_outlineInsetBottom, R.attr.oui_outlineInsetLeft, R.attr.oui_outlineInsetRight, R.attr.oui_outlineInsetTop, R.attr.oui_radius, R.attr.oui_rightDividerColor, R.attr.oui_rightDividerInsetBottom, R.attr.oui_rightDividerInsetTop, R.attr.oui_rightDividerWidth, R.attr.oui_secondOffsetX, R.attr.oui_secondOffsetY, R.attr.oui_secondShadowBlur, R.attr.oui_secondShadowColor, R.attr.oui_secondShadowSpread, R.attr.oui_shadow, R.attr.oui_shadowAlpha, R.attr.oui_shadowCornerRadius, R.attr.oui_shadowElevation, R.attr.oui_shadow_style, R.attr.oui_showBorderOnlyBeforeL, R.attr.oui_support_image_mirroring, R.attr.oui_topDividerColor, R.attr.oui_topDividerHeight, R.attr.oui_topDividerInsetLeft, R.attr.oui_topDividerInsetRight, R.attr.oui_topLeft_radius, R.attr.oui_topRight_radius, R.attr.oui_useThemeGeneralShadowElevation});
        r101.f399592a = r115.getColor(13, ColorProtector.parseColor("#00000000"));
        r101.f399593b = r115.getDimension(12, 0.0f);
        r101.f399594c = r115.getDimension(10, 0.0f);
        r101.f399595d = r115.getDimension(11, 0.0f);
        r101.f399596e = r115.getDimension(14, 0.0f);
        r115.recycle();
        setCurrentProgress(getProgress());
    }

    public /* synthetic */ TickMarkSeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
