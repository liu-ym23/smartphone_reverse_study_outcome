package com.larus.common_ui.video.progress;

import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusViewMusicPlayerProgressBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0003GHIB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017J\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020'H\u0017J\u0010\u0010*\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010)\u001a\u00020'H\u0002J\u001a\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u00020\u0017H\u0002J\u0018\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020#H\u0002J\u0018\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0017H\u0002J\u000e\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020#J\u0006\u0010<\u001a\u00020#J&\u0010=\u001a\u00020#2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010>\u001a\u00020\u00152\b\b\u0003\u0010\u0012\u001a\u00020\u0007J\u0016\u0010?\u001a\u00020#2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020#J\u0016\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\u0017J\f\u0010E\u001a\u00020F*\u00020\u0007H\u0002R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/common_ui/video/progress/PlayerProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewMusicPlayerProgressBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusViewMusicPlayerProgressBinding;", "binding$delegate", "Lkotlin/Lazy;", "duration", "Lkotlin/Function0;", "displayMode", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "onProgressChangeListener", "Lcom/larus/common_ui/video/progress/PlayerProgressView$IProgressChangedListener;", "inTouching", "", "downPoint", "Lcom/larus/common_ui/video/progress/PlayerProgressView$TouchPoint;", "dragStartProgress", "animator", "Landroid/animation/ValueAnimator;", "seekbarHeight", "", "seekbarRounded", "seekbarEnlargeHeight", "supportTouch", "setSupportTouch", "", "value", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "handleClick", "handleActionUpOrCancel", "handleActionMove", "handleActionDown", "changeSeekBarStyle", "enlarge", "loading", "startValueAnimator", "fromValue", "toValue", "initSeekBar", "refreshProgressBar", "percent", "smooth", "updateMaxProgress", "total", "asyncUpdateDuration", "startLoading", "stopLoading", "init", "progressChangedListener", "updateProgress", "setUIToDark", "updateTimeLine", "currentTime", "setSeekBarAlignToBottom", "alignToBottom", "subToDisplay", "", "Companion", "IProgressChangedListener", "TouchPoint", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f328070n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f328071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Integer> f328072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f328073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f328074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f328075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f328076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f328077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f328078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f328079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f328080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f328081k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f328082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f328083m;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/video/progress/PlayerProgressView$Companion$DisplayMode;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        public @interface DisplayMode {
            public static final a Companion = null;
            public static final int DEFAULT = 0;
            public static final int MUSIC = 1;
            public static final int VIDEO = 2;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f328084a = null;

                static {
                    f328084a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f328084a;
            }
        }
    }

    public interface a {
        void a(double r100);

        void b();

        void c();

        void onProgressChanged(double r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f328085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f328086b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f328085a, r101.f328085a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f328086b, r101.f328086b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f328085a) * 31) + Float.floatToIntBits(this.f328086b);
        }

        public final String toString() {
            return "TouchPoint(x=" + this.f328085a + ", y=" + this.f328086b + ')';
        }

        public b(float r100, float r101) {
            this.f328085a = r100;
            this.f328086b = r101;
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

    private final LarusViewMusicPlayerProgressBinding getBinding() {
        return (LarusViewMusicPlayerProgressBinding) this.f328071a.getValue();
    }

    public final void Z5() {
        AppHost.Companion r100 = AppHost.f326268a;
        Application r101 = r100.getApplication();
        Configuration r102 = new Configuration(r100.getApplication().getResources().getConfiguration());
        r102.uiMode = 32;
        Context r103 = r101.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r103);
        getBinding().f326820f.setProgressDrawable(ResourcesCompat.getDrawable(r103.getResources(), R.drawable.larus_seekbar_progress_drawable, null));
    }

    public final void b6() {
        LarusViewMusicPlayerProgressBinding r100 = getBinding();
        float r101 = (r100.f326820f.getProgress() / r100.f326820f.getMax()) * r100.f326820f.getWidth();
        V5(false, true);
        r100.f326819e.setLoadingLength((int) r101);
        FLogger.f375446a.d("PlayerProgressView", "[startLoading] loadingLength=" + r101);
        HorizontalProgressLayer r102 = r100.f326819e;
        r102.getClass();
        e1.x(r102);
        r102.f328069f = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new HorizontalProgressLayer$startLoadingAnimation$1(r102, null), 3, null);
    }

    public final void c6() {
        final LarusViewMusicPlayerProgressBinding r100 = getBinding();
        t0.e(new f(r100));
    }

    public final void U5() {
        getBinding();
    }

    public final String i6(int r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        if (r101.length() >= 2) goto L6;
        r101.insert(0, "0");
    L6:
        return r101.toString();
    }

    public final void k6(int r100) {
        getBinding().f326820f.setMax(r100);
        this.f328074d = r100;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f328083m == false) goto L7;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f328083m == false) goto L62;
        int r100 = r110.getAction();
        if (r100 != 0) goto L7;
        this.f328077g = new b(r110.getX(), r110.getY());
        this.f328078h = getBinding().f326820f.getProgress();
        V5(true, false);
    L60:
        return true;
    L7:
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L43;
    L13:
        if (this.f328076f == true) goto L17;
        a r101 = this.f328075e;
        if (r101 == null) goto L17;
        r101.c();
    L17:
        this.f328076f = true;
        float r102 = r110.getX() - this.f328077g.f328085a;
        if (Math.abs(r102) <= Math.abs(r110.getY() - this.f328077g.f328086b)) goto L39;
        requestDisallowInterceptTouchEvent(true);
        Integer r111 = Integer.valueOf(getBinding().f326820f.getWidth());
        if (r111.intValue() <= 0) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == true) goto L26;
        r111 = null;
    L26:
        if (r111 == null) goto L60;
        float r104 = (getBinding().f326820f.getMax() / r111.intValue()) * r102;
        float r112 = RangesKt.coerceIn(this.f328078h + r104, 0.0f, getBinding().f326820f.getMax());
        getBinding().f326820f.setProgress((int) r112);
        FLogger.f375446a.d("PlayerProgressView", "[handleActionMove] offsetX=" + r102 + ", progressOffset=" + r104 + ", newProgress=" + r112 + "   " + getBinding().f326820f.getProgress());
        a r113 = this.f328075e;
        if (r113 == null) goto L30;
        r113.onProgressChanged(((double) getBinding().f326820f.getProgress()) / ((double) getBinding().f326820f.getMax()));
    L30:
        a r114 = this.f328075e;
        if (r114 == null) goto L34;
        r114.a(((double) getBinding().f326820f.getProgress()) / ((double) getBinding().f326820f.getMax()));
    L34:
        if (this.f328073c != 2) goto L60;
        if (getBinding().f326821g.getVisibility() == 0) goto L60;
        getBinding().f326821g.setVisibility(0);
        goto L60
    L22:
        r103 = false;
        goto L23
    L39:
        if (this.f328076f == false) goto L41;
        this.f328077g = new b(r110.getX(), r110.getY());
        this.f328078h = getBinding().f326820f.getProgress();
        goto L60
    L41:
        requestDisallowInterceptTouchEvent(false);
    L43:
        if (this.f328076f == true) goto L51;
        int r105 = getBinding().f326820f.getProgressDrawable().getBounds().left + getPaddingStart();
        float r115 = RangesKt.coerceAtLeast(r110.getX() - r105, 0.0f);
        int r106 = getBinding().f326820f.getProgressDrawable().getBounds().width();
        float r107 = r115 / r106;
        int r108 = (int) (getBinding().f326820f.getMax() * r107);
        getBinding().f326820f.setProgress(r108);
        FLogger.f375446a.d("PlayerProgressView", "[handleClick] clickX=" + r115 + ", barLeftX=" + r105 + ", length=" + r106 + ", progressPercent=" + r107 + ", progress=" + r108);
        a r116 = this.f328075e;
        if (r116 == null) goto L47;
        r116.onProgressChanged(((double) getBinding().f326820f.getProgress()) / ((double) getBinding().f326820f.getMax()));
    L47:
        a r117 = this.f328075e;
        if (r117 == null) goto L51;
        r117.a(((double) getBinding().f326820f.getProgress()) / ((double) getBinding().f326820f.getMax()));
    L51:
        if (this.f328073c == 2) goto L53;
    L55:
        V5(false, false);
        a r118 = this.f328075e;
        if (r118 == null) goto L58;
        r118.b();
    L58:
        this.f328076f = false;
        goto L60
    L53:
        if (getBinding().f326821g.getVisibility() != 0) goto L55;
        getBinding().f326821g.setVisibility(4);
        goto L55
    L62:
        return super.onTouchEvent(r110);
    }

    public final void setSeekBarAlignToBottom(boolean r100) {
        ViewGroup.LayoutParams r101 = getBinding().f326820f.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        if (r100 == false) goto L5;
        r102.bottomToBottom = 0;
        r102.topToTop = -1;
        r102.topToBottom = -1;
    L6:
        getBinding().f326820f.setLayoutParams(r102);
        return;
    L5:
        r102.bottomToBottom = R.id.divider;
        r102.topToTop = R.id.divider;
        goto L6
    }

    public final void setSupportTouch(boolean r100) {
        this.f328083m = r100;
    }

    public static Unit R5(PlayerProgressView r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getBinding().f326820f.getLayoutParams();
        r102.height = (int) r101;
        r100.getBinding().f326820f.setLayoutParams(r102);
        return Unit.INSTANCE;
    }

    public static Unit T5(PlayerProgressView r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getBinding().f326820f.getLayoutParams();
        r102.height = (int) r101;
        r100.getBinding().f326820f.setLayoutParams(r102);
        return Unit.INSTANCE;
    }

    public final void J1(float r100, boolean r101) {
        if (this.f328076f == true) goto L19;
        int r102 = (int) ((this.f328074d * r100) / 100);
        if (Build.VERSION.SDK_INT < 24) goto L14;
        if (r101 == false) goto L14;
        if (r102 <= getBinding().f326820f.getProgress()) goto L12;
        getBinding().f326820f.setProgress(r102);
        return;
    L12:
        if ((((double) getBinding().f326820f.getProgress()) - (((double) this.f328074d) * 0.05d)) <= r100) goto L17;
        getBinding().f326820f.setProgress(r102);
        return;
    L17:
        return;
    L14:
        getBinding().f326820f.setProgress(r102);
        return;
    }

    public final void V5(final boolean r100, final boolean r101) {
        if (r100 == false) goto L4;
        final float r102 = this.f328082l;
    L5:
        getBinding().f326820f.post(new g(this, r102, r100, r101));
        return;
    L4:
        r102 = this.f328080j;
        goto L5
    }

    public final void n6(int r100, int r101) {
        int r102 = (int) Math.rint(((double) r101) / 1000.0d);
        int r103 = r102 % 60;
        int r104 = (int) Math.rint(((double) r100) / 1000.0d);
        int r105 = r104 % 60;
        getBinding().f326816b.setText(i6(r104 / 60));
        getBinding().f326817c.setText(i6(r105));
        getBinding().f326822h.setText(i6(r102 / 60));
        getBinding().f326823i.setText(i6(r103));
    }

    public PlayerProgressView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328071a = LazyKt.lazy(new h(r100, this));
        this.f328074d = 100;
        this.f328077g = new b(0.0f, 0.0f);
        float r103 = c7.c(4);
        this.f328080j = r103;
        this.f328081k = true;
        float r104 = c7.c(12);
        this.f328082l = r104;
        this.f328083m = true;
        TypedArray r105 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.larus_seekbar_enlarge_height, R.attr.larus_seekbar_height, R.attr.larus_seekbar_rounded}, 0, 0);
        float r106 = r105.getDimension(1, r103);     // Catch: Throwable -> L6
        this.f328080j = r106;     // Catch: Throwable -> L6
        this.f328081k = r105.getBoolean(2, true);     // Catch: Throwable -> L6
        this.f328082l = r105.getDimension(0, r104);     // Catch: Throwable -> L6
        r105.recycle();
        LarusViewMusicPlayerProgressBinding r107 = getBinding();
        V5(false, false);
        SeekBar r108 = r107.f326820f;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        r109.height = (int) r106;
        r108.setLayoutParams(r109);
        r107.f326820f.setThumb(null);
        r107.f326820f.setBackground(null);
        r107.f326820f.setOnSeekBarChangeListener(new k(this));
        return;
    L6:
        th = move-exception;
        r105.recycle();
        throw th;
    }

    public final void Y5(Function0<Integer> r100, a r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "duration");
        Intrinsics.checkNotNullParameter(r101, "progressChangedListener");
        this.f328072b = r100;
        this.f328073c = r102;
        this.f328075e = r101;
    }

    public /* synthetic */ PlayerProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void S5(final PlayerProgressView r100, final float r110, boolean r111, boolean r112) {
        float r101 = r100.getBinding().f326820f.getLayoutParams().height;
        ValueAnimator r102 = r100.f328079i;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isRunning() != true) goto L7;
    L8:
        if (r103 == false) goto L12;
        ValueAnimator r104 = r100.f328079i;
        if (r104 == null) goto L12;
        r104.cancel();
    L12:
        ValueAnimator r113 = tk9.b.b(r101, r110, 120, null, new i(r100), new j(r100, r110), 8);
        r100.f328079i = r113;
        r113.start();
        SeekBar r114 = r100.getBinding().f326820f;
        if (r111 == false) goto L19;
        Resources r115 = r100.getResources();
        if (r100.f328081k == false) goto L17;
        int r105 = R.drawable.larus_seekbar_progress_drawable_enlarged;
    L18:
        Drawable r106 = ResourcesCompat.getDrawable(r115, r105, null);
    L30:
        r114.setProgressDrawable(r106);
        return;
    L17:
        r105 = R.drawable.larus_seekbar_progress_drawable_enlarged_square;
        goto L18
    L19:
        if (r112 == false) goto L25;
        Resources r116 = r100.getResources();
        if (r100.f328081k == false) goto L23;
        int r107 = R.drawable.larus_seekbar_progress_drawable_loading;
    L24:
        r106 = ResourcesCompat.getDrawable(r116, r107, null);
        goto L30
    L23:
        r107 = R.drawable.larus_seekbar_progress_drawable_loading_square;
        goto L24
    L25:
        Resources r117 = r100.getResources();
        if (r100.f328081k == false) goto L28;
        int r108 = R.drawable.larus_seekbar_progress_drawable;
    L29:
        r106 = ResourcesCompat.getDrawable(r117, r108, null);
        goto L30
    L28:
        r108 = R.drawable.larus_seekbar_progress_drawable_square;
    L7:
        r103 = false;
        goto L8
    }
}
