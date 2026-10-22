package com.zhpan.bannerview.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.zhpan.indicator.base.BaseIndicatorView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/zhpan/bannerview/indicator/DrawableIndicator;", "Lcom/zhpan/indicator/base/BaseIndicatorView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bannerview_release"}, k = 1, mv = {1, 4, 0})
public final class DrawableIndicator extends BaseIndicatorView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f464554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f464555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f464556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f464557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f464558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f464559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f464560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f464561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f464562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f464563n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f464564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f464565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f464566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f464567d;

        public a(int r100, int r101, int r102, int r103) {
            this.f464564a = r100;
            this.f464565b = r101;
            this.f464566c = r102;
            this.f464567d = r103;
        }
    }

    public DrawableIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DrawableIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.zhpan.indicator.base.BaseIndicatorView
    public final void a(Canvas r100) {
    }

    public final void c() {
        Bitmap r100 = this.f464554e;
        if (r100 != null) goto L5;
    L48:
        Bitmap r101 = this.f464555f;
        if (r101 != null) goto L51;
        return;
    L51:
        if (this.f464561l == null) goto L93;
        if (r101 != null) goto L55;
        Intrinsics.throwNpe();
    L55:
        if (r101.isMutable() == true) goto L57;
    L71:
        Bitmap r102 = this.f464555f;
        if (r102 != null) goto L74;
        Intrinsics.throwNpe();
    L74:
        int r103 = r102.getWidth();
        Bitmap r104 = this.f464555f;
        if (r104 != null) goto L77;
        Intrinsics.throwNpe();
    L77:
        int r105 = r104.getHeight();
        a r106 = this.f464561l;
        if (r106 != null) goto L80;
        Intrinsics.throwNpe();
    L80:
        float r107 = r106.f464564a;
        Bitmap r108 = this.f464555f;
        if (r108 != null) goto L83;
        Intrinsics.throwNpe();
    L83:
        float r109 = r107 / r108.getWidth();
        a r110 = this.f464561l;
        if (r110 != null) goto L86;
        Intrinsics.throwNpe();
    L86:
        float r111 = r110.f464565b;
        Bitmap r112 = this.f464555f;
        if (r112 != null) goto L89;
        Intrinsics.throwNpe();
    L89:
        float r113 = r111 / r112.getHeight();
        Matrix r114 = new Matrix();
        r114.postScale(r109, r113);
        Bitmap r115 = this.f464555f;
        if (r115 != null) goto L92;
        Intrinsics.throwNpe();
    L92:
        this.f464555f = Bitmap.createBitmap(r115, 0, 0, r103, r105, r114, true);
        goto L93
    L57:
        if (this.f464562m == false) goto L71;
        Bitmap r116 = this.f464555f;
        if (r116 != null) goto L61;
        Intrinsics.throwNpe();
    L61:
        a r117 = this.f464561l;
        if (r117 != null) goto L64;
        Intrinsics.throwNpe();
    L64:
        r116.setWidth(r117.f464564a);
        Bitmap r118 = this.f464555f;
        if (r118 != null) goto L67;
        Intrinsics.throwNpe();
    L67:
        a r119 = this.f464561l;
        if (r119 != null) goto L70;
        Intrinsics.throwNpe();
    L70:
        r118.setHeight(r119.f464565b);
    L93:
        Bitmap r120 = this.f464555f;
        if (r120 != null) goto L96;
        Intrinsics.throwNpe();
    L96:
        this.f464559j = r120.getWidth();
        Bitmap r121 = this.f464555f;
        if (r121 != null) goto L99;
        Intrinsics.throwNpe();
    L99:
        this.f464560k = r121.getHeight();
        return;
    L5:
        if (this.f464561l == null) goto L41;
        if (r100 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        if (r100.isMutable() == true) goto L11;
    L25:
        Bitmap r122 = this.f464554e;
        if (r122 != null) goto L28;
        Intrinsics.throwNpe();
    L28:
        int r123 = r122.getWidth();
        Bitmap r124 = this.f464554e;
        if (r124 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        int r125 = r124.getHeight();
        a r126 = this.f464561l;
        if (r126 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        float r127 = r126.f464566c / r123;
        a r128 = this.f464561l;
        if (r128 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        float r129 = r128.f464567d / r125;
        Matrix r130 = new Matrix();
        r130.postScale(r127, r129);
        Bitmap r131 = this.f464554e;
        if (r131 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        this.f464554e = Bitmap.createBitmap(r131, 0, 0, r123, r125, r130, true);
        goto L41
    L11:
        if (this.f464563n == false) goto L25;
        Bitmap r132 = this.f464554e;
        if (r132 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        a r133 = this.f464561l;
        if (r133 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        r132.setWidth(r133.f464566c);
        Bitmap r134 = this.f464554e;
        if (r134 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        a r135 = this.f464561l;
        if (r135 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        r134.setHeight(r135.f464567d);
    L41:
        Bitmap r136 = this.f464554e;
        if (r136 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        this.f464557h = r136.getWidth();
        Bitmap r137 = this.f464554e;
        if (r137 != null) goto L47;
        Intrinsics.throwNpe();
    L47:
        this.f464558i = r137.getHeight();
        goto L48
    }

    @Override // com.zhpan.indicator.base.BaseIndicatorView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = 1;
        if (getPageSize() > 1) goto L5;
        return;
    L5:
        if (this.f464554e != null) goto L7;
        return;
    L7:
        if (this.f464555f == null) goto L27;
        int r102 = getPageSize() + 1;
    L9:
        if (r101 >= r102) goto L28;
        Bitmap r103 = this.f464555f;
        int r104 = r101 - 1;
        if (r104 >= getCurrentPosition()) goto L15;
        int r105 = r104 * (this.f464559j + this.f464556g);
        int r106 = getMeasuredHeight() / 2;
        int r107 = this.f464560k / 2;
    L13:
        int r108 = r106 - r107;
    L18:
        if (r103 == null) goto L21;
        r100.drawBitmap(r103, r105, r108, null);
    L21:
        r101 = r101 + 1;
        goto L9
    L15:
        if (r104 != getCurrentPosition()) goto L17;
        r105 = r104 * (this.f464559j + this.f464556g);
        r108 = (getMeasuredHeight() / 2) - (this.f464558i / 2);
        r103 = this.f464554e;
        goto L18
    L17:
        r105 = ((r104 * this.f464556g) + ((r101 - 2) * this.f464559j)) + this.f464557h;
        r106 = getMeasuredHeight() / 2;
        r107 = this.f464560k / 2;
        goto L13
    L28:
        return;
    }

    public static Bitmap b(Context r100, int r101) {
        Drawable r102 = ContextCompat.getDrawable(r100, r101);
        if (r102 == null) goto L6;
        Bitmap r103 = Bitmap.createBitmap(r102.getIntrinsicWidth(), r102.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        r102.setBounds(0, 0, r104.getWidth(), r104.getHeight());
        r102.draw(r104);
        return r103;
    L6:
        return null;
    }

    public final void d(int r100, int r101) {
        this.f464555f = BitmapFactory.decodeResource(getResources(), r100);
        this.f464554e = BitmapFactory.decodeResource(getResources(), r101);
        if (this.f464555f != null) goto L6;
        this.f464555f = b(getContext(), r100);
        this.f464562m = false;
    L6:
        if (this.f464554e != null) goto L8;
        this.f464554e = b(getContext(), r101);
        this.f464563n = false;
    L8:
        c();
        postInvalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(this.f464557h + ((this.f464559j + this.f464556g) * (getPageSize() - 1)), RangesKt.coerceAtLeast(this.f464558i, this.f464560k));
    }

    public DrawableIndicator(Context r100, AttributeSet r101, int r102) {
        if (r100 != null) goto L4;
        Intrinsics.throwNpe();
    L4:
        super(r100, r101, r102);
        this.f464562m = true;
        this.f464563n = true;
    }

    public /* synthetic */ DrawableIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
