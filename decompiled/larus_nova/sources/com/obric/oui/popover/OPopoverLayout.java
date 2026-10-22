package com.obric.oui.popover;

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
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.oui.common.style.r;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001dVB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PB\u001b\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bO\u0010SB#\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010T\u001a\u00020\u0002¢\u0006\u0004\bO\u0010UJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001bR\"\u0010#\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00109\u001a\u00020\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\"\u0010@\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010D\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010;\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\"\u0010H\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010;\u001a\u0004\bF\u0010=\"\u0004\bG\u0010?R\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010%\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)¨\u0006W"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout;", "Landroid/widget/LinearLayout;", "", "cornerRadiusDp", "", "setCornerRadiusDp", "", "cornerRadius", "setCornerRadius", "getCornerRadius", "", "str", "setSubText", "color", "setBorderColor", "width", "setBorderWidth", "", ECPromotion.TRANSPARENT_BOTTON_ICON, "setTransparentBg", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "getPadding", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "Lcom/obric/oui/popover/OPopoverLayout$b;", "getShadowConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getMSubTitle", "()Ljava/lang/String;", "setMSubTitle", "(Ljava/lang/String;)V", "mSubTitle", "c", "I", "getMPadding", "()I", "setMPadding", "(I)V", "mPadding", RXScreenCaptureService.KEY_INDEX, FaceService.girlLabel, "getMWidth", "()F", "setMWidth", "(F)V", "mWidth", ce.f26395j, "getMHeight", "setMHeight", "mHeight", "o", "getMBgColor", "setMBgColor", "mBgColor", "p", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "q", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "r", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "s", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPopoverLayout extends LinearLayout {
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f402230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f402231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f402232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f402233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f402234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f402235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f402236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f402237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f402238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f402239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f402240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f402241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f402242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Canvas f402243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f402244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f402245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f402246q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f402247r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f402248s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f402249t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f402250u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f402251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Paint f402252w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f402253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Path f402254y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f402255z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f402256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f402257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f402258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f402259d;

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
            if (Intrinsics.areEqual(Float.valueOf(this.f402256a), Float.valueOf(r101.f402256a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f402257b), Float.valueOf(r101.f402257b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f402258c), Float.valueOf(r101.f402258c)) == true) goto L18;
            return false;
        L18:
            if (this.f402259d == r101.f402259d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f402256a) * 31) + Float.floatToIntBits(this.f402257b)) * 31) + Float.floatToIntBits(this.f402258c)) * 31) + this.f402259d;
        }

        public final String toString() {
            return "ShadowConfig(radius=" + this.f402256a + ", dx=" + this.f402257b + ", dy=" + this.f402258c + ", color=" + this.f402259d + ')';
        }

        public b(int r100) {
            this.f402256a = 2.0f;
            this.f402257b = 2.0f;
            this.f402258c = 5.0f;
            this.f402259d = -16777216;
        }
    }

    static {
    }

    public final float getBubbleOffset() {
        float r100 = Math.max(this.f402240k, this.A);
        int r101 = this.f402241l;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, (this.f402238i - this.f402255z) - this.A);
    L18:
        return Math.min(r100, (this.f402239j - this.f402255z) - this.A);
    L19:
        return Math.min(r100, (this.f402239j - this.f402255z) - this.A);
    L15:
        return Math.min(r100, (this.f402238i - this.f402255z) - this.A);
    }

    public final Path getFullPath() {
        Path r100 = this.f402234e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r100;
    }

    public final int getPadding() {
        return this.f402255z / 2;
    }

    public final int getArrowHeight() {
        return this.f402255z;
    }

    public final float getCornerRadius() {
        return this.f402249t;
    }

    public final int getMAdjustHeight() {
        return this.f402248s;
    }

    public final int getMBgColor() {
        return this.f402244o;
    }

    public final float getMHeight() {
        return this.f402239j;
    }

    public final boolean getMNeedArrow() {
        return this.f402246q;
    }

    public final boolean getMNeedShadow() {
        return this.f402245p;
    }

    public final int getMPadding() {
        return this.f402232c;
    }

    public final String getMSubTitle() {
        return this.f402230a;
    }

    public final float getMWidth() {
        return this.f402238i;
    }

    public final b getShadowConfig() {
        return this.f402231b;
    }

    public final boolean getUseDefaultView() {
        return this.f402247r;
    }

    public OPopoverLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static int a(TextView r100) {
        String r101 = r100.getText().toString();
        TextPaint r102 = r100.getPaint();
        if (r102 == null) goto L16;
        int r103 = 0;
        if (StringsKt.contains$default(r101, "\n", false, 2, null) == false) goto L7;
        Iterator r104 = StringsKt.split$default(r101, new String[]{"\n"}, false, 0, 6, null).iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        int r105 = (int) r102.measureText((String) r104.next());
        if (r105 <= r103) goto L10;
        r103 = r105;
        goto L10
    L14:
        return r103;
    L7:
        return (int) r102.measureText(r101);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.text.TextPaint");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f402242m != null) goto L5;
        Resources r100 = getContext().getResources();
        this.f402242m = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r101 = this.f402242m;
        Intrinsics.checkNotNull(r101);
        this.f402243n = new Canvas(r101);
    L5:
        Paint r102 = this.f402233d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r102 = null;
    L8:
        r102.setColor(getMBgColor());
        float r103 = this.f402238i;
        float r104 = this.f402239j;
        float r105 = Math.max(this.f402240k, this.A + this.f402255z);
        Matrix r106 = new Matrix();
        int r107 = this.f402250u;
        int r108 = r107 / 2;
        int r109 = this.f402241l;
        if (r109 != 0) goto L11;
        float r111 = Math.min(r105, (r103 - this.f402255z) - this.A);
        float r112 = this.f402250u;
        r106.postRotate(90.0f);
        setPadding(0, r108, 0, 0);
    L21:
        setGravity(17);
        float r113 = this.f402255z;
        int r114 = this.f402250u;
        float r115 = (r114 / 2) + r113;
        float r116 = r114;
        this.f402236g = new RectF(r115, r115, (this.f402238i - r113) - r116, (this.f402239j - r113) - r116);
        r106.postTranslate(r111, r112);
        Path r117 = this.f402234e;
        if (r117 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r117 = null;
    L24:
        r117.reset();
        this.f402253x.reset();
        SmoothCornerHelper r118 = r.f399599a;
        Path r119 = this.f402253x;
        RectF r120 = this.f402236g;
        if (r120 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r120 = null;
    L27:
        float r121 = this.f402249t;
        Intrinsics.checkNotNullParameter(r119, "path");
        Intrinsics.checkNotNullParameter(r120, SVGRenderEngine.RECT);
        r119.addPath(r.a(r120, r121));
        if (this.f402246q == false) goto L33;
        this.f402254y.reset();
        Path r122 = this.f402254y;
        Path r123 = this.f402235f;
        if (r123 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r123 = null;
    L32:
        r122.addPath(r123, r106);
        this.f402253x.op(this.f402254y, Path.Op.UNION);
    L33:
        Path r124 = this.f402234e;
        if (r124 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r124 = null;
    L36:
        r124.addPath(this.f402253x);
        if (this.f402245p == false) goto L42;
        Paint r125 = this.f402233d;
        if (r125 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r125 = null;
    L41:
        b r126 = this.f402231b;
        r125.setShadowLayer(r126.f402256a, r126.f402257b, r126.f402258c, r126.f402259d);
    L42:
        Canvas r127 = this.f402243n;
        if (r127 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r127 = null;
    L45:
        Path r128 = this.f402234e;
        if (r128 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r128 = null;
    L48:
        Paint r129 = this.f402233d;
        if (r129 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r129 = null;
    L51:
        r127.drawPath(r128, r129);
        if (this.f402252w == null) goto L63;
        if (this.f402250u <= 0) goto L63;
        Canvas r130 = this.f402243n;
        if (r130 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r130 = null;
    L58:
        Path r131 = this.f402234e;
        if (r131 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r131 = null;
    L61:
        Paint r132 = this.f402252w;
        Intrinsics.checkNotNull(r132);
        r130.drawPath(r131, r132);
    L63:
        if (this.f402237h == null) goto L68;
        Canvas r133 = this.f402243n;
        if (r133 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r133 = null;
    L67:
        Path r134 = this.f402254y;
        Paint r135 = this.f402237h;
        Intrinsics.checkNotNull(r135);
        r133.drawPath(r134, r135);
    L68:
        Bitmap r136 = this.f402242m;
        Intrinsics.checkNotNull(r136);
        r110.drawBitmap(r136, 0.0f, 0.0f, null);
        return;
    L11:
        if (r109 != 1) goto L13;
        r111 = r107;
        r112 = Math.min(r105, (r104 - this.f402255z) - this.A);
        setPadding(r108, 0, 0, 0);
        goto L21
    L13:
        if (r109 != 2) goto L15;
        r111 = r103 - r107;
        r112 = Math.min(r105, (r104 - this.f402255z) - this.A);
        r106.postRotate(180.0f);
        setPadding(0, 0, r108, 0);
        goto L21
    L15:
        if (r109 == 3) goto L17;
        r111 = 0.0f;
        r112 = 0.0f;
        goto L21
    L17:
        r111 = Math.min(r105, (r103 - this.f402255z) - this.A);
        r112 = r104 - this.f402250u;
        r106.postRotate(270.0f);
        setPadding(0, 0, 0, r108);
        goto L21
    }

    public final void setBorderColor(int r100) {
        this.f402251v = r100;
    }

    public final void setBorderWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f402250u = r100;
        if (this.f402252w != null) goto L7;
        this.f402252w = new Paint();
    L7:
        Paint r101 = this.f402252w;
        if (r101 == null) goto L11;
        r101.setStyle(Paint.Style.STROKE);
    L11:
        Paint r102 = this.f402252w;
        if (r102 == null) goto L15;
        r102.setStrokeWidth(this.f402250u);
    L15:
        Paint r103 = this.f402252w;
        if (r103 == null) goto L19;
        r103.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r104 = this.f402252w;
        if (r104 == null) goto L23;
        r104.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r105 = this.f402252w;
        if (r105 == null) goto L27;
        r105.setAntiAlias(true);
    L27:
        Paint r106 = this.f402252w;
        if (r106 == null) goto L31;
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r107 = this.f402252w;
        if (r107 == null) goto L35;
        r107.setColor(this.f402251v);
    L35:
        Paint r108 = this.f402233d;
        Paint r109 = null;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r108 = null;
    L38:
        r108.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r110 = this.f402233d;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r109.setStrokeWidth(this.f402250u);
        return;
    L41:
        r109 = r110;
        goto L42
    }

    public final void setBubbleOrientation(int r100) {
        this.f402241l = r100;
    }

    public final void setCornerRadius(float r100) {
        this.f402249t = r100;
    }

    public final void setCornerRadiusDp(int r100) {
        this.f402249t = d.q(this, r100);
    }

    public final void setMAdjustHeight(int r100) {
        this.f402248s = r100;
    }

    public final void setMBgColor(int r100) {
        this.f402244o = r100;
    }

    public final void setMHeight(float r100) {
        this.f402239j = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.f402246q = r100;
    }

    public final void setMNeedShadow(boolean r100) {
        this.f402245p = r100;
    }

    public final void setMPadding(int r100) {
        this.f402232c = r100;
    }

    public final void setMSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402230a = r100;
    }

    public final void setMWidth(float r100) {
        this.f402238i = r100;
    }

    public final void setSubText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f402230a = r100;
    }

    public final void setTransparentBg(boolean r100) {
        if (r100 == false) goto L5;
        this.f402244o = 0;
        return;
    }

    public final void setUseDefaultView(boolean r100) {
        this.f402247r = r100;
    }

    public OPopoverLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = 0;
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r103 = getChildAt(0);
        if (r103 == null) goto L8;
        TextView r104 = (TextView) r103;
    L10:
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.getSize(r100);
        int r107 = View.MeasureSpec.getMode(r101);
        int r108 = View.MeasureSpec.getSize(r101);
        if (r104 == null) goto L17;
        int r109 = a(r104);
        int r110 = this.E;
        if (r109 > r110) goto L16;
        r110 = a(r104);
    L16:
        int r111 = (r110 + r104.getPaddingLeft()) + r104.getPaddingRight();
    L19:
        if (this.f402247r == false) goto L28;
        int r112 = this.B;
        if (r111 <= r112) goto L23;
        r112 = (this.f402232c * 2) + r111;
    L23:
        int r113 = this.f402255z * 2;
        int r114 = this.f402250u * 2;
        int r115 = (r112 + r113) + r114;
        int r116 = (this.C + r113) + r114;
        if (Intrinsics.areEqual(this.f402230a, "") == true) goto L27;
        r102 = this.D;
    L27:
        int r117 = r116 + r102;
    L30:
        if (r105 != Integer.MIN_VALUE) goto L33;
        if (r107 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r115, r117);
    L38:
        this.f402238i = getMeasuredWidth();
        this.f402239j = getMeasuredHeight();
        return;
    L33:
        if (r105 != Integer.MIN_VALUE) goto L35;
        setMeasuredDimension(r115, r108);
        goto L38
    L35:
        if (r107 != Integer.MIN_VALUE) goto L37;
        setMeasuredDimension(r106, r117);
        goto L38
    L37:
        setMeasuredDimension(r106, r108);
        goto L38
    L28:
        PopupWindow r118 = new PopupWindow(getChildAt(0), -2, -2, true);
        r118.getContentView().measure(0, 0);
        r115 = (this.f402255z * 2) + r118.getContentView().getMeasuredWidth();
        r117 = r118.getContentView().getMeasuredHeight() + (this.f402255z * 2);
        goto L30
    L17:
        r111 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r104 = null;
        goto L10
    }

    public OPopoverLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f402230a = "";
        this.f402231b = new b(0);
        this.f402240k = 0.75f;
        this.f402241l = 1;
        this.f402246q = true;
        this.f402247r = true;
        this.f402253x = new Path();
        this.f402254y = new Path();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f402255z = d.n(this, 7);
        this.A = d.q(this, 18);
        this.B = d.n(this, 40);
        this.C = d.n(this, 36);
        this.D = d.n(this, 20);
        this.f402232c = d.n(this, 12);
        this.E = d.n(this, MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE);
        this.f402233d = new Paint();
        this.f402234e = new Path();
        this.f402235f = new Path();
        Paint r100 = this.f402233d;
        Path r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r100 = null;
    L5:
        r100.setStyle(Paint.Style.FILL);
        Paint r102 = this.f402233d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r102 = null;
    L8:
        r102.setStrokeCap(Paint.Cap.BUTT);
        Paint r103 = this.f402233d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r103 = null;
    L11:
        r103.setAntiAlias(true);
        Paint r113 = this.f402233d;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r113 = null;
    L14:
        r113.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f402244o = ContextCompat.getColor(r110, R.color.SDPrimary);
    L17:
        Paint r114 = this.f402233d;
        if (r114 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r114 = null;
    L20:
        r114.setColor(getMBgColor());
        Path r115 = this.f402235f;
        if (r115 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r115 = null;
    L23:
        r115.moveTo(0.0f, 0.0f);
        float r116 = this.f402255z / 7.0f;
        Path r104 = this.f402235f;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r105 = null;
    L27:
        float r117 = r116 * 0.0f;
        float r106 = r116 * 7.0f;
        r105.cubicTo(r117, r116 * (-2.5f), r106, r116 * (-4.0f), r106, r116 * (-10.0f));
        Path r107 = this.f402235f;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r107 = null;
    L30:
        r107.lineTo(r106, 10.0f * r116);
        Path r108 = this.f402235f;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r109 = null;
    L34:
        r109.cubicTo(r106, r116 * 4.0f, r117, r116 * 2.5f, r117, r117);
        Path r118 = this.f402235f;
        if (r118 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L38:
        r101.close();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L37:
        r101 = r118;
        goto L38
    L33:
        r109 = r108;
        goto L34
    L26:
        r105 = r104;
        goto L27
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L17;
        if (r101 <= 0) goto L18;
        Bitmap r104 = this.f402242m;
        if (r104 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r104.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Resources r105 = getContext().getResources();
        Bitmap r106 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f402243n = new Canvas(r106);
        this.f402242m = r106;
        wma.b.h("OPopoverLayout", "onSizeChanged, init new bg, w: " + r100 + ", h: " + r101 + ", oldw: " + r102 + ", oldh: " + r103);
        return;
    L14:
        if (r104.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }
}
