package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.utils.i;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010r\u001a\u00020q¢\u0006\u0004\bs\u0010tB\u001b\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u0012\b\u0010v\u001a\u0004\u0018\u00010u¢\u0006\u0004\bs\u0010wB#\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u0012\b\u0010v\u001a\u0004\u0018\u00010u\u0012\u0006\u0010x\u001a\u00020\u0002¢\u0006\u0004\bs\u0010yJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010<\u001a\u0004\bS\u0010>\"\u0004\bT\u0010@R\"\u0010\\\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\"\u0010d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010W\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R\"\u0010h\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010W\u001a\u0004\bf\u0010Y\"\u0004\bg\u0010[R\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010W\u001a\u0004\bj\u0010Y\"\u0004\bk\u0010[R\"\u0010p\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010W\u001a\u0004\bn\u0010Y\"\u0004\bo\u0010[¨\u0006z"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleBubbleLayout;", "Landroid/widget/LinearLayout;", "", "bubbleOrientation", "", "setBubbleOrientation", "", "getBubbleOffset", "getPADDING", "", "need", "setNeedAddColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getMPadding", "()F", "setMPadding", "(F)V", "mPadding", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mFillPaint", "Landroid/graphics/Path;", "c", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPath", "d", "getMBubbleArrowPath", "setMBubbleArrowPath", "mBubbleArrowPath", "f", "getMWidth", "setMWidth", "mWidth", ce.f26391f, "getMHeight", "setMHeight", "mHeight", "h", "getMBorderBubbleArrowPath", "setMBorderBubbleArrowPath", "mBorderBubbleArrowPath", "Landroid/graphics/RectF;", RXScreenCaptureService.KEY_INDEX, "Landroid/graphics/RectF;", "getMBorderRoundRect", "()Landroid/graphics/RectF;", "setMBorderRoundRect", "(Landroid/graphics/RectF;)V", "mBorderRoundRect", ce.f26395j, "I", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mBorderWidth", "Landroid/graphics/Matrix;", ce.f26396k, "Landroid/graphics/Matrix;", "getMBorderMatrix", "()Landroid/graphics/Matrix;", "setMBorderMatrix", "(Landroid/graphics/Matrix;)V", "mBorderMatrix", OfficeSDKRequestTag.KEY_NEW_USER, "getMBgColor", "setMBgColor", "mBgColor", "o", "getMBorderColor", "setMBorderColor", "mBorderColor", "p", "getMShadowColor", "setMShadowColor", "mShadowColor", "q", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "t", "getMNeedPath", "setMNeedPath", "mNeedPath", "u", "getMNeedPressFade", "setMNeedPressFade", "mNeedPressFade", BaseSwitches.V, "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "w", "getMNeedAddColor", "setMNeedAddColor", "mNeedAddColor", "x", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class StyleBubbleLayout extends LinearLayout {
    public static float A;
    public static float B;
    public static float C;
    public static int D;
    public static int E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f454895y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f454896z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f454897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f454898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f454899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f454900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f454901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f454902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f454903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f454904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f454905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f454906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Matrix f454907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f454908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Canvas f454909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f454910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f454911o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f454912p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f454913q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f454914r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f454915s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f454916t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f454917u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f454918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f454919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f454920x;

    public static final class a {
    }

    static {
    }

    public final float getBubbleOffset() {
        float r100 = RangesKt.coerceAtLeast(this.f454914r, C);
        int r101 = this.f454915s;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return RangesKt.coerceAtMost(r100, this.f454902f - C);
    L18:
        return RangesKt.coerceAtMost(r100, this.f454903g - C);
    L19:
        return RangesKt.coerceAtMost(r100, this.f454903g - C);
    L15:
        return RangesKt.coerceAtMost(r100, this.f454902f - C);
    }

    public final Path getMBorderBubbleArrowPath() {
        Path r100 = this.f454904h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L5:
        return r100;
    }

    public final Matrix getMBorderMatrix() {
        Matrix r100 = this.f454907k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L5:
        return r100;
    }

    public final RectF getMBorderRoundRect() {
        RectF r100 = this.f454905i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L5:
        return r100;
    }

    public final Path getMBubbleArrowPath() {
        Path r100 = this.f454900d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        return r100;
    }

    public final Paint getMFillPaint() {
        Paint r100 = this.f454898b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        return r100;
    }

    public final Path getMPath() {
        Path r100 = this.f454899c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r100;
    }

    public final int getPADDING() {
        return f454895y / 2;
    }

    public final int getMBgColor() {
        return this.f454910n;
    }

    public final int getMBorderColor() {
        return this.f454911o;
    }

    public final int getMBorderWidth() {
        return this.f454906j;
    }

    public final float getMHeight() {
        return this.f454903g;
    }

    public final boolean getMNeedAddColor() {
        return this.f454919w;
    }

    public final boolean getMNeedArrow() {
        return this.f454918v;
    }

    public final boolean getMNeedPath() {
        return this.f454916t;
    }

    public final boolean getMNeedPressFade() {
        return this.f454917u;
    }

    public final boolean getMNeedShadow() {
        return this.f454913q;
    }

    public final float getMPadding() {
        return this.f454897a;
    }

    public final int getMShadowColor() {
        return this.f454912p;
    }

    public final float getMWidth() {
        return this.f454902f;
    }

    public final boolean getUseDefaultView() {
        return this.f454920x;
    }

    public StyleBubbleLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Bitmap r100 = this.f454908l;
        if (r100 != null) goto L6;
        r100 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f454908l = r100;
        this.f454909m = new Canvas(r100);
    L6:
        float r101 = this.f454902f;
        float r102 = this.f454903g;
        float r103 = Math.max(this.f454914r, C);
        Matrix r104 = new Matrix();
        this.f454907k = new Matrix();
        int r105 = this.f454915s;
        if (r105 != 0) goto L9;
        float r106 = Math.min(r103, r101 - C);
        r104.postRotate(90.0f);
        Matrix r107 = this.f454907k;
        if (r107 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L34:
        r107.postRotate(90.0f);
        Matrix r108 = this.f454907k;
        if (r108 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L37:
        int r109 = this.f454906j;
        r108.postTranslate((((r109 * 3) / 2) + r106) - ((f454895y * 3) / 2), r109 + 0.0f);
        setPadding(0, f454895y, 0, 0);
        setGravity(17);
        this.f454901e = new RectF(0.0f, f454895y, this.f454902f, this.f454903g);
        float r111 = (this.f454906j * 3) / 2;
        r104.postTranslate((r106 + r111) - ((f454895y * 3) / 2), 0.0f + r111);
    L38:
        RectF r112 = this.f454901e;
        if (r112 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L41:
        r112.left += (this.f454906j * 3) / 2;
        RectF r113 = this.f454901e;
        if (r113 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L44:
        r113.top += (this.f454906j * 3) / 2;
        RectF r114 = this.f454901e;
        if (r114 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L47:
        r114.right += (this.f454906j * 3) / 2;
        RectF r115 = this.f454901e;
        if (r115 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L50:
        r115.bottom += (this.f454906j * 3) / 2;
        RectF r116 = new RectF();
        this.f454905i = r116;
        RectF r117 = this.f454901e;
        if (r117 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L53:
        r116.left = r117.left - (this.f454906j / 2);
        RectF r118 = this.f454905i;
        if (r118 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L56:
        RectF r119 = this.f454901e;
        if (r119 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L59:
        r118.top = r119.top - (this.f454906j / 2);
        RectF r120 = this.f454905i;
        if (r120 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L62:
        RectF r121 = this.f454901e;
        if (r121 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L65:
        r120.right = r121.right + (this.f454906j / 2);
        RectF r122 = this.f454905i;
        if (r122 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L68:
        RectF r123 = this.f454901e;
        if (r123 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L71:
        r122.bottom = r123.bottom + (this.f454906j / 2);
        if (this.f454913q == false) goto L78;
        Paint r124 = this.f454898b;
        if (r124 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L76:
        r124.setShadowLayer(2.0f, 2.0f, 5.0f, this.f454912p);
    L78:
        if (this.f454916t == false) goto L157;
        Paint r125 = this.f454898b;
        if (r125 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L82:
        r125.setColor(this.f454911o);
        Paint r126 = this.f454898b;
        if (r126 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L85:
        r126.setStyle(Paint.Style.STROKE);
        Paint r127 = this.f454898b;
        if (r127 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L88:
        r127.setStrokeWidth(this.f454906j);
        Path r128 = this.f454899c;
        if (r128 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L91:
        r128.reset();
        Path r129 = this.f454899c;
        if (r129 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L94:
        RectF r130 = this.f454905i;
        if (r130 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L97:
        float r131 = B;
        int r132 = this.f454906j;
        r129.addRoundRect(r130, (r132 / 2) + r131, r131 + (r132 / 2), Path.Direction.CW);
        if (this.f454918v == false) goto L109;
        Path r133 = this.f454899c;
        if (r133 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L102:
        Path r134 = this.f454904h;
        if (r134 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L105:
        Matrix r135 = this.f454907k;
        if (r135 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L108:
        r133.addPath(r134, r135);
    L109:
        Canvas r136 = this.f454909m;
        if (r136 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L112:
        Path r137 = this.f454899c;
        if (r137 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L115:
        Paint r138 = this.f454898b;
        if (r138 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L118:
        r136.drawPath(r137, r138);
        if (this.f454919w == false) goto L157;
        Paint r139 = this.f454898b;
        if (r139 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L123:
        r139.setColor(getResources().getColor(R.color.tools_const_tPrimary));
        Paint r140 = this.f454898b;
        if (r140 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L126:
        r140.setStyle(Paint.Style.STROKE);
        Path r141 = this.f454899c;
        if (r141 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L129:
        r141.reset();
        if (this.f454918v == false) goto L141;
        Path r142 = this.f454899c;
        if (r142 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L134:
        Path r143 = this.f454904h;
        if (r143 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L137:
        Matrix r144 = this.f454907k;
        if (r144 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L140:
        r142.addPath(r143, r144);
    L141:
        Path r145 = this.f454899c;
        if (r145 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L144:
        RectF r146 = this.f454905i;
        if (r146 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L147:
        float r147 = B;
        int r148 = this.f454906j;
        r145.addRoundRect(r146, (r148 / 2) + r147, r147 + (r148 / 2), Path.Direction.CW);
        Canvas r149 = this.f454909m;
        if (r149 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L150:
        Path r150 = this.f454899c;
        if (r150 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L153:
        Paint r151 = this.f454898b;
        if (r151 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L156:
        r149.drawPath(r150, r151);
    L157:
        Paint r152 = this.f454898b;
        if (r152 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L160:
        r152.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Paint r153 = this.f454898b;
        if (r153 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L163:
        r153.setColor(this.f454910n);
        Paint r154 = this.f454898b;
        if (r154 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L166:
        r154.setStyle(Paint.Style.FILL);
        Path r155 = this.f454899c;
        if (r155 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L169:
        r155.reset();
        Path r156 = this.f454899c;
        if (r156 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L172:
        RectF r157 = this.f454901e;
        if (r157 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L175:
        float r158 = B;
        r156.addRoundRect(r157, r158, r158, Path.Direction.CW);
        if (this.f454918v == false) goto L184;
        Path r159 = this.f454899c;
        if (r159 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L180:
        Path r160 = this.f454900d;
        if (r160 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L183:
        r159.addPath(r160, r104);
    L184:
        Canvas r161 = this.f454909m;
        if (r161 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L187:
        Path r162 = this.f454899c;
        if (r162 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L190:
        Paint r163 = this.f454898b;
        if (r163 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L193:
        r161.drawPath(r162, r163);
        Paint r164 = this.f454898b;
        if (r164 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L196:
        r164.setXfermode(null);
        r110.drawBitmap(r100, f454895y - i.a(getContext(), 1.4f), f454895y - i.a(getContext(), 1.3f), null);
        return;
    L9:
        if (r105 == 1) goto L27;
        if (r105 == 2) goto L20;
        if (r105 != 3) goto L38;
        float r165 = Math.min(r103, r101 - C);
        r104.postRotate(270.0f);
        Matrix r166 = this.f454907k;
        if (r166 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L16:
        r166.postRotate(270.0f);
        Matrix r167 = this.f454907k;
        if (r167 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L19:
        int r168 = this.f454906j;
        r167.postTranslate((((r168 * 3) / 2) + r165) - ((f454895y * 3) / 2), (r168 * 2) + r102);
        setPadding(0, 0, 0, f454895y);
        setGravity(17);
        this.f454901e = new RectF(0.0f, 0.0f, this.f454902f, this.f454903g - f454895y);
        float r169 = (this.f454906j * 3) / 2;
        r104.postTranslate((r165 + r169) - ((f454895y * 3) / 2), r102 + r169);
        goto L38
    L20:
        float r170 = Math.min(r103, r102 - C);
        r104.postRotate(180.0f);
        Matrix r171 = this.f454907k;
        if (r171 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L23:
        r171.postRotate(180.0f);
        Matrix r172 = this.f454907k;
        if (r172 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L26:
        float r173 = this.f454906j * 2;
        r172.postTranslate(r173 + r101, (r173 + r170) - ((f454895y * 3) / 2));
        setPadding(0, 0, f454895y, 0);
        setGravity(17);
        this.f454901e = new RectF(0.0f, 0.0f, this.f454902f - f454895y, this.f454903g);
        int r174 = this.f454906j;
        r104.postTranslate(r101 + ((r174 * 3) / 2), (r170 + (r174 * 2)) - ((f454895y * 3) / 2));
        goto L38
    L27:
        float r175 = Math.min(r103, r102 - C);
        setPadding(f454895y, 0, 0, 0);
        setGravity(17);
        Matrix r176 = this.f454907k;
        if (r176 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L30:
        int r177 = this.f454906j;
        r176.postTranslate(r177 + 0.0f, ((r177 * 2) + r175) - ((f454895y * 3) / 2));
        this.f454901e = new RectF(f454895y, 0.0f, this.f454902f, this.f454903g);
        int r178 = this.f454906j;
        r104.postTranslate(0.0f + ((r178 * 3) / 2), (r175 + (r178 * 2)) - ((f454895y * 3) / 2));
        goto L38
    }

    public final void setBubbleOrientation(int r100) {
        this.f454915s = r100;
    }

    public final void setMBgColor(int r100) {
        this.f454910n = r100;
    }

    public final void setMBorderBubbleArrowPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454904h = r100;
    }

    public final void setMBorderColor(int r100) {
        this.f454911o = r100;
    }

    public final void setMBorderMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454907k = r100;
    }

    public final void setMBorderRoundRect(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454905i = r100;
    }

    public final void setMBorderWidth(int r100) {
        this.f454906j = r100;
    }

    public final void setMBubbleArrowPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454900d = r100;
    }

    public final void setMFillPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454898b = r100;
    }

    public final void setMHeight(float r100) {
        this.f454903g = r100;
    }

    public final void setMNeedAddColor(boolean r100) {
        this.f454919w = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.f454918v = r100;
    }

    public final void setMNeedPath(boolean r100) {
        this.f454916t = r100;
    }

    public final void setMNeedPressFade(boolean r100) {
        this.f454917u = r100;
    }

    public final void setMNeedShadow(boolean r100) {
        this.f454913q = r100;
    }

    public final void setMPadding(float r100) {
        this.f454897a = r100;
    }

    public final void setMPath(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454899c = r100;
    }

    public final void setMShadowColor(int r100) {
        this.f454912p = r100;
    }

    public final void setMWidth(float r100) {
        this.f454902f = r100;
    }

    public final void setNeedAddColor(boolean r100) {
        this.f454919w = r100;
    }

    public final void setUseDefaultView(boolean r100) {
        this.f454920x = r100;
    }

    public StyleBubbleLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        f454896z = (int) i.a(getContext(), this.f454897a + 5.0f);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r100 = getChildAt(0);
        if (r100 == null) goto L8;
        TextView r101 = (TextView) r100;
    L10:
        int r102 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        int r103 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        int r104 = getMeasuredWidth();
        if (r101 != null) goto L13;
        char r105 = 0;
    L19:
        if (this.f454920x == false) goto L31;
        int r106 = D;
        if (r104 <= r106) goto L23;
        r106 = (f454896z * 2) + r104;
    L23:
        int r107 = this.f454915s;
        if (r107 == 2) goto L26;
        if (r107 == 1) goto L26;
    L27:
        int r108 = E;
        if (r105 == 1) goto L32;
        r108 = r108 + 19;
    L32:
        int r109 = this.f454906j;
        int r114 = r106 + (r109 * 3);
        int r115 = r108 + (r109 * 3);
        if (r102 != Integer.MIN_VALUE) goto L36;
        if (r103 != Integer.MIN_VALUE) goto L36;
        setMeasuredDimension(r114, r115);
    L40:
        this.f454902f = getMeasuredWidth() - (f454895y * 2);
        this.f454903g = getMeasuredHeight() - (f454895y * 2);
        return;
    L36:
        if (r102 != Integer.MIN_VALUE) goto L38;
        setMeasuredDimension(r114, r113);
        goto L40
    L38:
        if (r103 != Integer.MIN_VALUE) goto L40;
        setMeasuredDimension(r112, r115);
    L26:
        r106 = r106 + f454895y;
        goto L27
    L31:
        PopupWindow r116 = new PopupWindow(getChildAt(0), -2, -2, true);
        r116.getContentView().measure(0, 0);
        r106 = (r116.getContentView().getMeasuredWidth() + (f454895y * 3)) + f454896z;
        r108 = (r116.getContentView().getMeasuredHeight() + (f454895y * 3)) + f454896z;
        goto L32
    L13:
        if (((int) r101.getPaint().measureText(r101.getText().toString())) <= i.a(getContext(), 197.0f)) goto L15;
        i.a(getContext(), 197.0f);
        r105 = 2;
    L16:
        r101.getPaddingLeft();
        r101.getPaddingRight();
        goto L19
    L15:
        r101.getPaint().measureText(r101.getText().toString());
        r105 = 1;
        goto L16
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r101 = null;
        goto L10
    }

    public StyleBubbleLayout(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f454897a = 12.0f;
        this.f454912p = -16777216;
        this.f454914r = 0.75f;
        this.f454915s = 1;
        this.f454916t = true;
        this.f454918v = true;
        this.f454919w = true;
        this.f454920x = true;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f454906j = (int) i.a(r100, 0.7f);
        f454895y = (int) i.a(r100, 7.0f);
        A = 2.0f;
        B = i.a(r100, 8.0f);
        C = i.a(r100, 3.0f);
        D = (int) i.a(r100, 50.0f);
        E = (int) i.a(r100, 56.0f);
        this.f454898b = new Paint();
        this.f454899c = new Path();
        this.f454904h = new Path();
        this.f454900d = new Path();
        Paint r101 = this.f454898b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r101.setStyle(Paint.Style.FILL);
        Paint r102 = this.f454898b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r102.setStrokeCap(Paint.Cap.BUTT);
        Paint r103 = this.f454898b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r103.setAntiAlias(true);
        Paint r104 = this.f454898b;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r104.setStrokeWidth(A);
        Paint r105 = this.f454898b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L17:
        r105.setStrokeJoin(Paint.Join.MITER);
        this.f454910n = getResources().getColor(R.color.tools_std_sd_primary);
        this.f454911o = getResources().getColor(R.color.reverse_lPrimary2);
        Paint r106 = this.f454898b;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r106.setColor(this.f454910n);
        Paint r107 = this.f454898b;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L23:
        setLayerType(1, r107);
        if (this.f454913q == false) goto L29;
        Paint r108 = this.f454898b;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L28:
        r108.setShadowLayer(2.0f, 2.0f, 5.0f, this.f454912p);
    L29:
        Path r109 = this.f454900d;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L32:
        r109.moveTo(0.0f, 0.0f);
        Path r112 = this.f454900d;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L35:
        int r113 = f454895y;
        r112.lineTo(r113, -r113);
        Path r114 = this.f454900d;
        if (r114 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L38:
        float r115 = f454895y;
        r114.lineTo(r115, r115);
        Path r116 = this.f454900d;
        if (r116 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L41:
        r116.close();
        Path r117 = this.f454904h;
        if (r117 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L44:
        r117.moveTo(0.0f, 0.0f);
        Path r118 = this.f454904h;
        if (r118 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L47:
        r118.lineTo((float) (((double) f454895y) + (((double) this.f454906j) * Math.sqrt(2.0d))), (float) (((double) (-f454895y)) - (((double) this.f454906j) * Math.sqrt(2.0d))));
        Path r119 = this.f454904h;
        if (r119 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L50:
        r119.lineTo((float) (((double) f454895y) + (((double) this.f454906j) * Math.sqrt(2.0d))), (float) (((double) f454895y) + (((double) this.f454906j) * Math.sqrt(2.0d))));
        Path r120 = this.f454904h;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L53:
        r120.close();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
