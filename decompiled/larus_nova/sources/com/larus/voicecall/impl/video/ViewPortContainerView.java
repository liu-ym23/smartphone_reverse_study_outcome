package com.larus.voicecall.impl.video;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014J \u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0082@¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\u0016\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020%J\u0016\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020!J\u0010\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u00020\u0013J\u0006\u00105\u001a\u00020\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/voicecall/impl/video/ViewPortContainerView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgView", "Landroid/view/View;", "contentContainer", "Landroid/view/ViewGroup;", "maskView", "dragDelegate", "Lcom/larus/voicecall/impl/video/DragFloatingEffect;", "updateLimitCallBack", "Lkotlin/Function0;", "", "getUpdateLimitCallBack", "()Lkotlin/jvm/functions/Function0;", "setUpdateLimitCallBack", "(Lkotlin/jvm/functions/Function0;)V", "onScreenChangeTask", "Ljava/lang/Runnable;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "getContentBitmap", "Landroid/graphics/Bitmap;", "bitmapWidth", "", "bitmapHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "addContentView", "view", "params", "Landroid/widget/FrameLayout$LayoutParams;", "enableDrag", "enable", "setDragLimit", "topLimit", "bottomLimit", "setDragListener", "listener", "Lcom/larus/voicecall/impl/video/DragFloatingListener;", "showBg", "hideBg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPortContainerView extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f379572g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f379573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f379574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f379575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f379576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f379577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f379578f;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r110, Outline r111) {
            Intrinsics.checkNotNullParameter(r110, "view");
            Intrinsics.checkNotNullParameter(r111, "outline");
            FLogger.f375446a.d("ViewPortContainerView", "width: " + r110.getWidth() + ", height: " + r110.getHeight());
            r111.setRoundRect(0, 0, r110.getWidth(), r110.getHeight(), ((float) i5.r0()) / r110.getScaleX());
        }
    }

    public static final class b {
    }

    static {
    }

    public ViewPortContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ViewPortContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f379578f);
    }

    public final Function0<Unit> getUpdateLimitCallBack() {
        return this.f379577e;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L14;
        if (r100 != null) goto L11;
    L13:
        if (r101 == true) goto L14;
        return;
    L11:
        if (r100.orientation != 1) goto L13;
        r101 = true;
    L14:
        postDelayed(this.f379578f, 100);
        return;
    L5:
        if (r100.orientation != 2) goto L7;
        r102 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voicecall.impl.video.d, java.lang.Runnable] */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        final e r100 = this.f379576d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r100.f379601j == false) goto L8;
        float r101 = r110.getRawX();
        float r102 = r110.getRawY();
        int r103 = r110.getAction();
        if (r103 != 0) goto L15;
        r100.f379595d = r101;
        r100.f379596e = r102;
        r100.f379603l = r101;
        r100.f379604m = r102;
        ?? r104 = new d(r100);
        r100.f379599h = r104;
        r100.f379592a.postDelayed(r104, 500);
    L66:
        return true;
    L15:
        if (r103 != 1) goto L17;
        r100.f379592a.removeCallbacks(r100.f379599h);
        if (r100.f379600i == false) goto L59;
        r100.b(true);
        boolean r105 = false;
    L64:
        r100.f379600i = r105;
        r100.f379599h = null;
        goto L66
    L59:
        if (r100.f379602k == false) goto L61;
        r105 = false;
        r100.b(false);
        goto L64
    L61:
        r105 = false;
        f r106 = r100.f379597f;
        if (r106 == null) goto L64;
        r106.onClick();
        goto L64
    L17:
        if (r103 == 2) goto L26;
        if (r103 != 3) goto L66;
        if (r100.f379600i == false) goto L24;
        r100.b(true);
    L24:
        r100.f379600i = false;
        r100.f379599h = null;
        goto L66
    L26:
        if (r100.f379600i == false) goto L48;
        float r107 = r101 - r100.f379595d;
        float r108 = r102 - r100.f379596e;
        float r109 = r100.f379592a.getX();
        float r111 = r100.f379592a.getY();
        float r112 = r109 + r107;
        float r113 = r111 + r108;
        float r114 = Math.max(r100.f379606o, Math.min(r113, r100.f379607p - (r100.f379592a.getHeight() * r100.f379592a.getScaleY())));
        r100.f379592a.setX(r112);
        r100.f379592a.setY(r114);
        FLogger.f375446a.d("DragFloatingEffect", "updateViewLocation() called with: dx = " + r107 + ", dy = " + r108 + ", oldX = " + r109 + ", oldY = " + r111 + ", newX = " + r112 + ", newY = " + r113 + ", width: " + r100.f379592a.getWidth() + ", height = " + r100.f379592a.getHeight() + ", scaleX: " + r100.f379592a.getScaleX() + ", scaleY: " + r100.f379592a.getScaleY() + ", transX: " + r100.f379592a.getTranslationX() + ", transY: " + r100.f379592a.getTranslationY() + ", limitY = " + r114);
        float r115 = r100.f379592a.getX() + ((((float) r100.f379592a.getWidth()) * r100.f379592a.getScaleX()) / ((float) 2));
        if (r115 > 0.0f) goto L30;
    L33:
        boolean r116 = true;
    L34:
        if (r116 == false) goto L42;
        if (r100.f379602k == true) goto L47;
        r100.f379602k = true;
        g r117 = r100.f379598g;
        if (r117 == null) goto L47;
        r117.a();
    L47:
        r100.f379595d = r101;
        r100.f379596e = r102;
        goto L66
    L42:
        if (r100.f379602k == false) goto L47;
        r100.f379602k = false;
        g r118 = r100.f379598g;
        if (r118 == null) goto L47;
        r118.b();
        goto L47
    L30:
        if (r115 >= r100.a()) goto L33;
        r116 = false;
        goto L34
    L48:
        float r119 = r100.f379603l;
        float r120 = r100.f379604m;
        if (Math.abs(r101 - r119) <= r100.f379605n) goto L51;
    L52:
        r100.f379592a.removeCallbacks(r100.f379599h);
        d r121 = r100.f379599h;
        if (r121 == null) goto L66;
        r121.run();
        goto L66
    L51:
        if (Math.abs(r102 - r120) <= r100.f379605n) goto L66;
    L8:
        if (r110.getAction() != 1) goto L66;
        f r122 = r100.f379597f;
        if (r122 == null) goto L66;
        r122.onClick();
        goto L66
    }

    public final void setDragListener(f r100) {
        this.f379576d.f379597f = r100;
    }

    public final void setUpdateLimitCallBack(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f379577e = r100;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.voicecall.impl.video.u] */
    public ViewPortContainerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        e r103 = new e(this);
        this.f379576d = r103;
        this.f379577e = new t();
        this.f379578f = new u(this);
        View r104 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_rtc_view_port, this);
        this.f379573a = r104.findViewById(R.id.viewPortBg);
        this.f379574b = (ViewGroup) r104.findViewById(R.id.viewPortContentContainer);
        this.f379575c = r104.findViewById(R.id.viewPortControlLayer);
        setBackgroundColor(ContextCompat.getColor(r100, android.R.color.transparent));
        setClipToOutline(true);
        setOutlineProvider(new a());
        r103.f379598g = new AnonymousClass3(this, r100);
    }

    public /* synthetic */ ViewPortContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final Object a(ViewPortContainerView r100, float r101, float r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof ViewPortContainerView$getContentBitmap$1) == false) goto L7;
        ViewPortContainerView$getContentBitmap$1 r104 = (ViewPortContainerView$getContentBitmap$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L36:
        return (Bitmap) r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        if (r100.f379574b.getChildCount() <= 0) goto L17;
        View r109 = r100.f379574b.getChildAt(0);
    L19:
        if ((r109 instanceof TextureView) == false) goto L22;
        return ((TextureView) r109).getBitmap((int) r101, (int) r102);
    L22:
        if ((r109 instanceof SurfaceView) == false) goto L31;
        SurfaceHolder r110 = ((SurfaceView) r109).getHolder();
        final Bitmap r111 = Bitmap.createBitmap((int) r101, (int) r102, Bitmap.Config.ARGB_8888);
        Surface r112 = r110.getSurface();
        final CompletableDeferred r113 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (Build.VERSION.SDK_INT < 24) goto L26;
        PixelCopy.request(r112, r111, new s(r113, r111), new Handler(Looper.getMainLooper()));
    L27:
        r104.label = 1;
        r106 = r113.await(r104);
        if (r106 != r107) goto L36;
        return r107;
    L26:
        Boxing.boxBoolean(r113.complete(null));
        goto L27
    L31:
        if (r109 == null) goto L34;
        Bitmap r114 = ViewKt.drawToBitmap$default(r109, null, 1, null);
        Bitmap r115 = Bitmap.createScaledBitmap(r114, (int) r101, (int) r102, true);
        r114.recycle();
        return r115;
    L34:
        return null;
    L17:
        r109 = null;
    L7:
        r104 = new ViewPortContainerView$getContentBitmap$1(r100, r103);
        goto L8
    }
}
