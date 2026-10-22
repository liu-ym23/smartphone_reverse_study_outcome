package com.bytedance.dux.popover;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002KLB\u0011\b\u0016\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EB\u001b\b\u0016\u0012\u0006\u0010C\u001a\u00020B\u0012\b\u0010G\u001a\u0004\u0018\u00010F¢\u0006\u0004\bD\u0010HB#\b\u0016\u0012\u0006\u0010C\u001a\u00020B\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\u0006\u0010I\u001a\u00020\t¢\u0006\u0004\bD\u0010JJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\"\u0010.\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\"\u0010A\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010)\u001a\u0004\b?\u0010+\"\u0004\b@\u0010-¨\u0006M"}, d2 = {"Lcom/bytedance/dux/popover/DuxPopoverLayout;", "Landroid/widget/LinearLayout;", "", "enabled", "", "setClearBitmapCacheEnabled", "", "cornerRadius", "setCornerRadius", "", "color", "setBorderColor", "width", "setBorderWidth", ECPromotion.TRANSPARENT_BOTTON_ICON, "setTransparentBg", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "getPadding", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "Lcom/bytedance/dux/popover/DuxPopoverLayout$b;", "getShadowConfig", "d", FaceService.girlLabel, "getMPadding", "()F", "setMPadding", "(F)V", "mPadding", ce.f26395j, "getMWidth", "setMWidth", "mWidth", ce.f26396k, "getMHeight", "setMHeight", "mHeight", "p", "I", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBgColor", "q", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "r", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "s", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "t", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxPopoverLayout extends LinearLayout {
    public static final float A = 0.0f;
    public static final float B = 0.0f;
    public static int C;
    public static int D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f205431z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f205432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f205434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f205435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f205436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f205437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f205438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f205439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f205440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f205441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f205442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f205443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f205444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f205445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Canvas f205446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f205447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f205448q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f205449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f205450s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f205451t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f205452u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f205453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Paint f205454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f205455x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Path f205456y;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f205457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f205458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f205459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f205460d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f205457a, r101.f205457a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f205458b, r101.f205458b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f205459c, r101.f205459c) == 0) goto L18;
            return false;
        L18:
            if (this.f205460d == r101.f205460d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f205457a) * 31) + Float.floatToIntBits(this.f205458b)) * 31) + Float.floatToIntBits(this.f205459c)) * 31) + this.f205460d;
        }

        public final String toString() {
            return "ShadowConfig(radius=" + this.f205457a + ", dx=" + this.f205458b + ", dy=" + this.f205459c + ", color=" + this.f205460d + ')';
        }

        public b(int r100) {
            this.f205457a = 2.0f;
            this.f205458b = 2.0f;
            this.f205459c = 5.0f;
            this.f205460d = -16777216;
        }
    }

    static {
        f205431z = MathKt.roundToInt(TypedValue.applyDimension(1, 7, a(Resources.getSystem())));
        A = TypedValue.applyDimension(1, 8, a(Resources.getSystem()));
        B = TypedValue.applyDimension(1, 18, a(Resources.getSystem()));
        C = MathKt.roundToInt(TypedValue.applyDimension(1, 40, a(Resources.getSystem())));
        D = MathKt.roundToInt(TypedValue.applyDimension(1, 42, a(Resources.getSystem())));
    }

    public final float getBubbleOffset() {
        float r100 = this.f205443l;
        float r101 = B;
        float r102 = Math.max(r100, r101);
        int r103 = this.f205444m;
        if (r103 == 0) goto L15;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r102, (this.f205441j - f205431z) - r101);
    L18:
        return Math.min(r102, (this.f205442k - f205431z) - r101);
    L19:
        return Math.min(r102, (this.f205442k - f205431z) - r101);
    L15:
        return Math.min(r102, (this.f205441j - f205431z) - r101);
    }

    public final Path getFullPath() {
        Path r100 = this.f205437f;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r100;
    }

    public final int getPadding() {
        return f205431z / 2;
    }

    public final int getArrowHeight() {
        return f205431z;
    }

    public final int getMAdjustHeight() {
        return this.f205451t;
    }

    public final int getMBgColor() {
        return this.f205447p;
    }

    public final float getMHeight() {
        return this.f205442k;
    }

    public final boolean getMNeedArrow() {
        return this.f205449r;
    }

    public final boolean getMNeedShadow() {
        return this.f205448q;
    }

    public final float getMPadding() {
        return this.f205435d;
    }

    public final float getMWidth() {
        return this.f205441j;
    }

    public final b getShadowConfig() {
        return this.f205434c;
    }

    public final boolean getUseDefaultView() {
        return this.f205450s;
    }

    public DuxPopoverLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f205445n != null) goto L6;
        this.f205445n = Bitmap.createBitmap(a(getContext().getResources()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r101 = this.f205445n;
        Intrinsics.checkNotNull(r101);
        this.f205446o = new Canvas(r101);
    L6:
        if (this.f205433b == false) goto L11;
        Canvas r102 = this.f205446o;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r102 = null;
    L10:
        r102.drawColor(0, PorterDuff.Mode.CLEAR);
    L11:
        Paint r103 = this.f205436e;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r103 = null;
    L14:
        r103.setColor(getMBgColor());
        b(this.f205441j, this.f205442k);
        if (this.f205448q == false) goto L20;
        Paint r104 = this.f205436e;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r104 = null;
    L19:
        b r105 = this.f205434c;
        r104.setShadowLayer(r105.f205457a, r105.f205458b, r105.f205459c, r105.f205460d);
    L20:
        Canvas r106 = this.f205446o;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r106 = null;
    L23:
        Path r107 = this.f205437f;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r107 = null;
    L26:
        Paint r108 = this.f205436e;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r108 = null;
    L29:
        r106.drawPath(r107, r108);
        if (this.f205454w == null) goto L41;
        if (this.f205452u <= 0) goto L41;
        Canvas r109 = this.f205446o;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r109 = null;
    L36:
        Path r110 = this.f205437f;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r110 = null;
    L39:
        Paint r111 = this.f205454w;
        Intrinsics.checkNotNull(r111);
        r109.drawPath(r110, r111);
    L41:
        if (this.f205440i == null) goto L46;
        Canvas r112 = this.f205446o;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r112 = null;
    L45:
        Path r113 = this.f205456y;
        Paint r114 = this.f205440i;
        Intrinsics.checkNotNull(r114);
        r112.drawPath(r113, r114);
    L46:
        Bitmap r115 = this.f205445n;
        Intrinsics.checkNotNull(r115);
        r100.drawBitmap(r115, 0.0f, 0.0f, null);
    }

    public final void setBorderColor(int r100) {
        this.f205453v = r100;
    }

    public final void setBorderWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f205452u = r100;
        if (this.f205454w != null) goto L7;
        this.f205454w = new Paint();
    L7:
        Paint r101 = this.f205454w;
        if (r101 == null) goto L11;
        r101.setStyle(Paint.Style.STROKE);
    L11:
        Paint r102 = this.f205454w;
        if (r102 == null) goto L15;
        r102.setStrokeWidth(this.f205452u);
    L15:
        Paint r103 = this.f205454w;
        if (r103 == null) goto L19;
        r103.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r104 = this.f205454w;
        if (r104 == null) goto L23;
        r104.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r105 = this.f205454w;
        if (r105 == null) goto L27;
        r105.setAntiAlias(true);
    L27:
        Paint r106 = this.f205454w;
        if (r106 == null) goto L31;
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r107 = this.f205454w;
        if (r107 == null) goto L35;
        r107.setColor(this.f205453v);
    L35:
        Paint r108 = this.f205436e;
        Paint r109 = null;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r108 = null;
    L38:
        r108.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r110 = this.f205436e;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r109.setStrokeWidth(this.f205452u);
        return;
    L41:
        r109 = r110;
        goto L42
    }

    public final void setBubbleOrientation(int r100) {
        this.f205444m = r100;
    }

    public final void setClearBitmapCacheEnabled(boolean r100) {
        this.f205433b = r100;
    }

    public final void setCornerRadius(float r100) {
        this.f205432a = r100;
    }

    public final void setMAdjustHeight(int r100) {
        this.f205451t = r100;
    }

    public final void setMBgColor(int r100) {
        this.f205447p = r100;
    }

    public final void setMHeight(float r100) {
        this.f205442k = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.f205449r = r100;
    }

    public final void setMNeedShadow(boolean r100) {
        this.f205448q = r100;
    }

    public final void setMPadding(float r100) {
        this.f205435d = r100;
    }

    public final void setMWidth(float r100) {
        this.f205441j = r100;
    }

    public final void setTransparentBg(boolean r100) {
        if (r100 == false) goto L5;
        this.f205447p = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r100) {
        this.f205450s = r100;
    }

    public DuxPopoverLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final void b(float r110, float r111) {
        float r100 = this.f205443l;
        float r101 = B;
        float r102 = f205431z;
        float r103 = Math.max(r100, r102 + r101);
        Matrix r104 = new Matrix();
        int r105 = this.f205452u;
        int r106 = r105 / 2;
        int r107 = this.f205444m;
        if (r107 != 0) goto L5;
        float r112 = Math.min(r103, (r110 - r102) - r101);
        float r113 = this.f205452u;
        r104.postRotate(90.0f);
        setPadding(0, r106, 0, 0);
    L15:
        setGravity(17);
        int r108 = this.f205452u;
        float r109 = (r108 / 2) + r102;
        float r114 = r108;
        this.f205439h = new RectF(r109, r109, (this.f205441j - r102) - r114, (this.f205442k - r102) - r114);
        r104.postTranslate(r112, r113);
        Path r115 = this.f205437f;
        Path r116 = null;
        if (r115 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r115 = null;
    L18:
        r115.reset();
        this.f205455x.reset();
        Path r117 = this.f205455x;
        RectF r118 = this.f205439h;
        if (r118 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r118 = null;
    L21:
        float r119 = this.f205432a;
        r117.addRoundRect(r118, r119, r119, Path.Direction.CW);
        if (this.f205449r == false) goto L27;
        this.f205456y.reset();
        Path r120 = this.f205456y;
        Path r121 = this.f205438g;
        if (r121 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r121 = null;
    L26:
        r120.addPath(r121, r104);
        this.f205455x.op(this.f205456y, Path.Op.UNION);
    L27:
        Path r122 = this.f205437f;
        if (r122 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L31:
        r116.addPath(this.f205455x);
        return;
    L30:
        r116 = r122;
        goto L31
    L5:
        if (r107 != 1) goto L7;
        r112 = r105;
        r113 = Math.min(r103, (r111 - r102) - r101);
        setPadding(r106, 0, 0, 0);
        goto L15
    L7:
        if (r107 != 2) goto L9;
        r112 = r110 - r105;
        r113 = Math.min(r103, (r111 - r102) - r101);
        r104.postRotate(180.0f);
        setPadding(0, 0, r106, 0);
        goto L15
    L9:
        if (r107 == 3) goto L11;
        r112 = 0.0f;
        r113 = 0.0f;
        goto L15
    L11:
        r112 = Math.min(r103, (r110 - r102) - r101);
        r113 = r111 - this.f205452u;
        r104.postRotate(270.0f);
        setPadding(0, 0, 0, r106);
        goto L15
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        Integer r100 = null;
        if ((getChildAt(0) instanceof TextView) == false) goto L5;
        View r101 = getChildAt(0);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.TextView");
        TextView r102 = (TextView) r101;
    L6:
        int r103 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        int r104 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        if (r102 == null) goto L13;
        int r105 = (int) r102.getPaint().measureText(r102.getText().toString());
        float r106 = MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE;
        if (r105 <= MathKt.roundToInt(TypedValue.applyDimension(1, r106, a(Resources.getSystem())))) goto L11;
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, r106, a(Resources.getSystem())));
    L12:
        int r108 = (r107 + r102.getPaddingLeft()) + r102.getPaddingRight();
    L15:
        if (this.f205450s == false) goto L28;
        if (r102 == null) goto L18;
        r102.measure(0, 0);
    L18:
        if (r102 == null) goto L20;
        r100 = Integer.valueOf(r102.getMeasuredHeight() + (MathKt.roundToInt(TypedValue.applyDimension(1, this.f205435d, a(Resources.getSystem()))) * 2));
    L20:
        int r109 = C;
        if (r108 <= r109) goto L23;
        r109 = (MathKt.roundToInt(TypedValue.applyDimension(1, this.f205435d, a(Resources.getSystem()))) * 2) + r108;
    L23:
        int r114 = f205431z;
        int r115 = (r109 + (r114 * 2)) + (this.f205452u * 2);
        if (r100 == null) goto L26;
        int r116 = r100.intValue();
    L27:
        int r117 = r116 + (r114 * 2);
        int r118 = this.f205452u;
    L29:
        int r119 = r117 + (r118 * 2);
        if (r103 != Integer.MIN_VALUE) goto L33;
        if (r104 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r115, r119);
    L37:
        this.f205441j = getMeasuredWidth();
        this.f205442k = getMeasuredHeight();
        return;
    L33:
        if (r103 != Integer.MIN_VALUE) goto L35;
        setMeasuredDimension(r115, r113);
        goto L37
    L35:
        if (r104 != Integer.MIN_VALUE) goto L37;
        setMeasuredDimension(r112, r119);
        goto L37
    L26:
        r116 = D;
        goto L27
    L28:
        PopupWindow r120 = new PopupWindow(getChildAt(0), -2, -2, true);
        r120.getContentView().measure(0, 0);
        int r121 = r120.getContentView().getMeasuredWidth();
        r118 = f205431z;
        r115 = r121 + (r118 * 2);
        r117 = r120.getContentView().getMeasuredHeight();
        goto L29
    L11:
        r107 = (int) r102.getPaint().measureText(r102.getText().toString());
        goto L12
    L13:
        r108 = getMeasuredWidth();
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public DuxPopoverLayout(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        this.f205432a = A;
        this.f205434c = new b(0);
        this.f205435d = 10.0f;
        this.f205443l = 0.75f;
        this.f205444m = 1;
        this.f205449r = true;
        this.f205450s = true;
        this.f205455x = new Path();
        this.f205456y = new Path();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f205436e = new Paint();
        this.f205437f = new Path();
        this.f205438g = new Path();
        Paint r100 = this.f205436e;
        Path r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r100 = null;
    L5:
        r100.setStyle(Paint.Style.FILL);
        Paint r102 = this.f205436e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r102 = null;
    L8:
        r102.setStrokeCap(Paint.Cap.BUTT);
        Paint r103 = this.f205436e;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r103 = null;
    L11:
        r103.setAntiAlias(true);
        Paint r104 = this.f205436e;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r104 = null;
    L14:
        r104.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f205447p = ContextCompat.getColor(r110, R.color.SDPrimary);
    L17:
        Paint r105 = this.f205436e;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r105 = null;
    L20:
        r105.setColor(getMBgColor());
        setLayerType(1, null);
        Path r106 = this.f205438g;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r106 = null;
    L23:
        r106.moveTo(0.0f, 0.0f);
        float r107 = f205431z / 7.0f;
        Path r108 = this.f205438g;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r109 = null;
    L27:
        float r112 = r107 * 0.0f;
        float r113 = r107 * 7.0f;
        r109.cubicTo(r112, r107 * (-2.5f), r113, r107 * (-4.0f), r113, r107 * (-10.0f));
        Path r114 = this.f205438g;
        if (r114 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r114 = null;
    L30:
        r114.lineTo(r113, 10.0f * r107);
        Path r115 = this.f205438g;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r116 = null;
    L34:
        r116.cubicTo(r113, r107 * 4.0f, r112, r107 * 2.5f, r112, r112);
        Path r117 = this.f205438g;
        if (r117 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L38:
        r101.close();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L37:
        r101 = r117;
        goto L38
    L33:
        r116 = r115;
        goto L34
    L26:
        r109 = r108;
        goto L27
    }
}
