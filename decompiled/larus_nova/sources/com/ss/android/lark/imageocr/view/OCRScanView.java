package com.ss.android.lark.imageocr.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byted.cast.common.TeaEventTrack;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0014J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRScanView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scanLine", "Landroid/widget/ImageView;", "getScanLine", "()Landroid/widget/ImageView;", "scanLine$delegate", "Lkotlin/Lazy;", "animHandler", "Landroid/os/Handler;", "getAnimHandler", "()Landroid/os/Handler;", "animHandler$delegate", "animRunnable", "Lcom/ss/android/lark/imageocr/view/OCRScanView$AnimRunnable;", "getAnimRunnable", "()Lcom/ss/android/lark/imageocr/view/OCRScanView$AnimRunnable;", "animRunnable$delegate", "start", "", "cancel", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startScanAnim", "updateTranslationY", "Companion", "AnimRunnable", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OCRScanView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f426613d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f426614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f426615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f426616c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f426617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f426618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f426619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f426620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f426621e;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L3:
            if (ImageWidgetFG.a() == false) goto L5;
            float r100 = this.f426620d;     // Catch: Throwable -> L8
        L6:
            this.f426617a.setTranslationY(r100 * this.f426621e);     // Catch: Throwable -> L8
            this.f426618b.invoke();     // Catch: Throwable -> L8
            return;
        L5:
            r100 = this.f426619c;     // Catch: Throwable -> L8
            goto L6
        }

        public a(View r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "scanLine");
            Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
            this.f426617a = r100;
            this.f426618b = r101;
            this.f426619c = (UIUtils.getScreenHeight(LarkContext.getApplication()) - r100.getHeight()) / 100;
            this.f426621e = 1;
        }
    }

    public static final class b {
    }

    static {
    }

    private final Handler getAnimHandler() {
        return (Handler) this.f426615b.getValue();
    }

    private final a getAnimRunnable() {
        return (a) this.f426616c.getValue();
    }

    private final ImageView getScanLine() {
        return (ImageView) this.f426614a.getValue();
    }

    public final void b() {
        Log.i("OCRScanView", "cancel");
        setVisibility(8);
        getAnimHandler().removeCallbacksAndMessages(null);
        getScanLine().setTranslationY(0.0f);
    }

    public final void c() {
        getAnimHandler().removeCallbacksAndMessages(null);
        if (getAnimRunnable().f426621e >= 100) goto L5;
        getAnimRunnable().f426621e++;
    L6:
        getAnimHandler().postDelayed(getAnimRunnable(), 20);
        return;
    L5:
        getAnimRunnable().f426621e = 1;
        goto L6
    }

    public OCRScanView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ ImageView a(OCRScanView r100) {
        return r100.getScanLine();
    }

    public OCRScanView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        a r102 = getAnimRunnable();
        int r103 = getMeasuredHeight();
        r102.f426620d = (r103 - r102.f426617a.getHeight()) / 100;
        Log.i("OCRScanView", "setMaxHeight, maxHeight: " + r103 + ", stepYCompat: " + r102.f426620d);
    }

    public OCRScanView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f426614a = LazyKt.lazy(new OCRScanView$scanLine$2(this));
        this.f426615b = LazyKt.lazy(OCRScanView$animHandler$2.INSTANCE);
        this.f426616c = LazyKt.lazy(new OCRScanView$animRunnable$2(this));
        setVisibility(8);
        setClickable(true);
    }
}
