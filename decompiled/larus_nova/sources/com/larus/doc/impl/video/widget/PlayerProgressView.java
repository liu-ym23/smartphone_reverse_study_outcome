package com.larus.doc.impl.video.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.doc.biz.impl.databinding.LarusViewVideoPlayerProgressBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0003=>?B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001eH\u0017J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u001a\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u0017H\u0002J\u0018\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\u0018\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0017H\u0002J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\"J\u0006\u00105\u001a\u00020\"J&\u00106\u001a\u00020\"2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u00107\u001a\u00020\u00152\b\b\u0003\u0010\u0012\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\"2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0017J\u0016\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J\f\u0010;\u001a\u00020<*\u00020\u0007H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/doc/impl/video/widget/PlayerProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusViewVideoPlayerProgressBinding;", "getBinding", "()Lcom/larus/doc/biz/impl/databinding/LarusViewVideoPlayerProgressBinding;", "binding$delegate", "Lkotlin/Lazy;", "duration", "Lkotlin/Function0;", "displayMode", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "onProgressChangeListener", "Lcom/larus/doc/impl/video/widget/PlayerProgressView$IProgressChangedListener;", "inTouching", "", "downPoint", "Lcom/larus/doc/impl/video/widget/PlayerProgressView$TouchPoint;", "animator", "Landroid/animation/ValueAnimator;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "handleClick", "", "handleActionUpOrCancel", "handleActionMove", "handleActionDown", "changeSeekBarStyle", "enlarge", "loading", "startValueAnimator", "fromValue", "", "toValue", "initSeekBar", "refreshProgressBar", "percent", "smooth", "updateMaxProgress", "total", "asyncUpdateDuration", "startLoading", "stopLoading", "init", "progressChangedListener", "updateProgress", "updateTimeLine", "currentTime", "subToDisplay", "", "Companion", "IProgressChangedListener", "TouchPoint", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f331504h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f331505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f331506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f331507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f331508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f331509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f331510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f331511g;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/doc/impl/video/widget/PlayerProgressView$Companion$DisplayMode;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        public @interface DisplayMode {
            public static final a Companion = null;
            public static final int DEFAULT = 0;
            public static final int MUSIC = 1;
            public static final int VIDEO = 2;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f331512a = null;

                static {
                    f331512a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f331512a;
            }
        }
    }

    public interface a {
        void a(double r100);

        void b();

        void onProgressChanged(double r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f331513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f331514b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f331513a, r101.f331513a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f331514b, r101.f331514b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f331513a) * 31) + Float.floatToIntBits(this.f331514b);
        }

        public final String toString() {
            return "TouchPoint(x=" + this.f331513a + ", y=" + this.f331514b + ')';
        }

        public b(float r100, float r101) {
            this.f331513a = r100;
            this.f331514b = r101;
        }
    }

    static {
    }

    public PlayerProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlayerProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusViewVideoPlayerProgressBinding getBinding() {
        return (LarusViewVideoPlayerProgressBinding) this.f331505a.getValue();
    }

    public final String V5(int r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        if (r101.length() >= 2) goto L6;
        r101.insert(0, "0");
    L6:
        return r101.toString();
    }

    public final void Y5(int r100) {
        getBinding().f330975e.setMax(2000);
        this.f331507c = 2000;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = r110.getAction();
        if (r100 != 0) goto L5;
        this.f331510f = new b(r110.getX(), r110.getY());
        U5(true, false);
    L50:
        return true;
    L5:
        if (r100 == 1) goto L33;
        if (r100 != 2) goto L8;
        this.f331509e = true;
        float r101 = r110.getX() - this.f331510f.f331513a;
        if (Math.abs(r101) <= Math.abs(r110.getY() - this.f331510f.f331514b)) goto L28;
        requestDisallowInterceptTouchEvent(true);
        if (r101 <= 0.0f) goto L15;
        float r102 = Math.abs(r101);
    L16:
        float r103 = (getBinding().f330975e.getMax() / getBinding().f330975e.getWidth()) * r102;
        float r104 = RangesKt.coerceIn(getBinding().f330975e.getProgress() + r103, 0.0f, getBinding().f330975e.getMax());
        getBinding().f330975e.setProgress((int) r104);
        FLogger.f375446a.d("PlayerProgressView", "[handleActionMove] offsetX=" + r102 + ", progressOffset=" + r103 + ", newProgress=" + r104 + "   " + getBinding().f330975e.getProgress());
        a r105 = this.f331508d;
        if (r105 == null) goto L19;
        r105.onProgressChanged(((double) getBinding().f330975e.getProgress()) / ((double) getBinding().f330975e.getMax()));
    L19:
        a r106 = this.f331508d;
        if (r106 == null) goto L23;
        r106.a(((double) getBinding().f330975e.getProgress()) / ((double) getBinding().f330975e.getMax()));
    L23:
        if (this.f331506b == 2) goto L25;
    L31:
        this.f331510f = new b(r110.getX(), r110.getY());
        goto L50
    L25:
        if (getBinding().f330976f.getVisibility() == 0) goto L31;
        getBinding().f330976f.setVisibility(0);
        goto L31
    L15:
        r102 = -Math.abs(r101);
        goto L16
    L28:
        if (this.f331509e == false) goto L30;
        this.f331510f = new b(r110.getX(), r110.getY());
        goto L50
    L30:
        requestDisallowInterceptTouchEvent(false);
        goto L31
    L8:
        if (r100 != 3) goto L50;
    L33:
        if (this.f331509e == true) goto L41;
        int r107 = getBinding().f330975e.getProgressDrawable().getBounds().left + getPaddingStart();
        float r111 = RangesKt.coerceAtLeast(r110.getX() - r107, 0.0f);
        int r108 = getBinding().f330975e.getProgressDrawable().getBounds().width();
        float r109 = r111 / r108;
        int r112 = (int) (getBinding().f330975e.getMax() * r109);
        getBinding().f330975e.setProgress(r112);
        FLogger.f375446a.i("PlayerProgressView", "[handleClick] clickX=" + r111 + ", barLeftX=" + r107 + ", length=" + r108 + ", progressPercent=" + r109 + ", progress=" + r112);
        a r113 = this.f331508d;
        if (r113 == null) goto L37;
        r113.onProgressChanged(((double) getBinding().f330975e.getProgress()) / ((double) getBinding().f330975e.getMax()));
    L37:
        a r114 = this.f331508d;
        if (r114 == null) goto L41;
        r114.a(((double) getBinding().f330975e.getProgress()) / ((double) getBinding().f330975e.getMax()));
    L41:
        if (this.f331506b == 2) goto L43;
    L45:
        U5(false, false);
        a r115 = this.f331508d;
        if (r115 == null) goto L48;
        r115.b();
    L48:
        this.f331509e = false;
        goto L50
    L43:
        if (getBinding().f330976f.getVisibility() != 0) goto L45;
        getBinding().f330976f.setVisibility(4);
        goto L45
    }

    public static Unit R5(PlayerProgressView r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getBinding().f330975e.getLayoutParams();
        r102.height = (int) r101;
        r100.getBinding().f330975e.setLayoutParams(r102);
        return Unit.INSTANCE;
    }

    public static Unit S5(PlayerProgressView r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getBinding().f330975e.getLayoutParams();
        r102.height = (int) r101;
        r100.getBinding().f330975e.setLayoutParams(r102);
        return Unit.INSTANCE;
    }

    public final void J1(float r100, boolean r101) {
        if (this.f331509e == true) goto L7;
        int r102 = (int) ((this.f331507c * r100) / 100);
        int r103 = Build.VERSION.SDK_INT;
        getBinding().f330975e.setProgress(r102);
        return;
    }

    public final void U5(final boolean r100, final boolean r101) {
        if (r100 == false) goto L4;
        int r102 = 12;
    L5:
        final int r103 = c7.b(Integer.valueOf(r102));
        getBinding().f330975e.post(new f(this, r103, r100, r101));
        return;
    L4:
        r102 = 4;
        goto L5
    }

    public final void Z5(int r100, int r101) {
        int r102 = (int) Math.rint(((double) 0) / 1000.0d);
        int r103 = r102 % 60;
        int r104 = (int) Math.rint(((double) r100) / 1000.0d);
        int r105 = r104 % 60;
        getBinding().f330972b.setText(V5(r104 / 60));
        getBinding().f330973c.setText(V5(r105));
        getBinding().f330977g.setText(V5(r102 / 60));
        getBinding().f330978h.setText(V5(r103));
    }

    public PlayerProgressView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f331505a = LazyKt.lazy(new g(r100, this));
        this.f331507c = 100;
        this.f331510f = new b(0.0f, 0.0f);
        LarusViewVideoPlayerProgressBinding r103 = getBinding();
        U5(false, false);
        r103.f330975e.setThumb(null);
        r103.f330975e.setBackground(null);
        r103.f330975e.setOnSeekBarChangeListener(new j(this));
    }

    public /* synthetic */ PlayerProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void T5(final PlayerProgressView r100, int r110, boolean r111, boolean r112) {
        float r101 = r100.getBinding().f330975e.getLayoutParams().height;
        final float r102 = r110;
        ValueAnimator r113 = r100.f331511g;
        if (r113 == null) goto L7;
        boolean r103 = true;
        if (r113.isRunning() != true) goto L7;
    L8:
        if (r103 == false) goto L12;
        ValueAnimator r114 = r100.f331511g;
        if (r114 == null) goto L12;
        r114.cancel();
    L12:
        ValueAnimator r115 = tk9.b.b(r101, r102, 120, null, new h(r100), new i(r100, r102), 8);
        r100.f331511g = r115;
        r115.start();
        SeekBar r116 = r100.getBinding().f330975e;
        if (r111 == false) goto L15;
        Drawable r104 = ResourcesCompat.getDrawable(r100.getResources(), R.drawable.larus_seekbar_progress_drawable_enlarged, null);
    L18:
        r116.setProgressDrawable(r104);
        return;
    L15:
        if (r112 == false) goto L17;
        r104 = ResourcesCompat.getDrawable(r100.getResources(), R.drawable.larus_seekbar_progress_drawable_loading, null);
        goto L18
    L17:
        r104 = ResourcesCompat.getDrawable(r100.getResources(), R.drawable.larus_seekbar_progress_drawable, null);
    L7:
        r103 = false;
        goto L8
    }
}
