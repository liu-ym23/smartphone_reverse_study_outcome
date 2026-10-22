package com.obric.oui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
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
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002HIB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bA\u0010EB#\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\u0006\u0010F\u001a\u00020\u0006¢\u0006\u0004\bA\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010+\u001a\u00020\u00068F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010:\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010-\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\"\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010&\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*¨\u0006J"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "Landroid/widget/LinearLayout;", "", "cornerRadius", "", "setCornerRadius", "", "color", "setBorderColor", "width", "setBorderWidth", "", ECPromotion.TRANSPARENT_BOTTON_ICON, "setTransparentBg", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "getPadding", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$b;", "getShadowConfig", "f", FaceService.girlLabel, "()F", "setPadding", "(F)V", GXTemplateKey.FLEXBOX_PADDING, ce.f26395j, "getMWidth", "setMWidth", "mWidth", ce.f26396k, "getMHeight", "setMHeight", "mHeight", "q", "I", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBgColor", "r", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "s", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "t", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "u", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OMiddleArrowPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f402200y = 0.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f402201z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f402202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f402203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f402204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f402205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f402206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f402207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f402208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f402209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Path f402210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f402211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f402212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f402213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f402214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f402215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Canvas f402216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f402217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f402218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f402219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f402220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f402221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f402222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f402223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f402224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f402225x;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f402226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f402227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f402228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f402229d;

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
            if (Intrinsics.areEqual(Float.valueOf(this.f402226a), Float.valueOf(r101.f402226a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f402227b), Float.valueOf(r101.f402227b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f402228c), Float.valueOf(r101.f402228c)) == true) goto L18;
            return false;
        L18:
            if (this.f402229d == r101.f402229d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f402226a) * 31) + Float.floatToIntBits(this.f402227b)) * 31) + Float.floatToIntBits(this.f402228c)) * 31) + this.f402229d;
        }

        public final String toString() {
            return "ShadowConfig(radius=" + this.f402226a + ", dx=" + this.f402227b + ", dy=" + this.f402228c + ", color=" + this.f402229d + ')';
        }

        public b(int r100) {
            this.f402226a = 2.0f;
            this.f402227b = 2.0f;
            this.f402228c = 5.0f;
            this.f402229d = -16777216;
        }
    }

    public final void setCornerRadius(float r100) {
    }

    static {
        f402200y = Math.min(42, 42) / 2.0f;
        f402201z = 12;
    }

    public final float getBubbleOffset() {
        float r100 = Math.max(this.f402213l, this.f402203b);
        int r101 = this.f402214m;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r100, (this.f402211j - this.f402202a) - this.f402203b);
    L18:
        return Math.min(r100, (this.f402212k - this.f402202a) - this.f402203b);
    L19:
        return Math.min(r100, (this.f402212k - this.f402202a) - this.f402203b);
    L15:
        return Math.min(r100, (this.f402211j - this.f402202a) - this.f402203b);
    }

    public final Path getFullPath() {
        Path r100 = this.f402209h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r100;
    }

    /* JADX INFO: renamed from: getPadding, reason: collision with other method in class */
    public final int m8590getPadding() {
        return this.f402202a / 2;
    }

    public final int getArrowHeight() {
        return this.f402202a;
    }

    public final int getMAdjustHeight() {
        return this.f402222u;
    }

    public final int getMBgColor() {
        return this.f402218q;
    }

    public final float getMHeight() {
        return this.f402212k;
    }

    public final boolean getMNeedArrow() {
        return this.f402220s;
    }

    public final boolean getMNeedShadow() {
        return this.f402219r;
    }

    public final float getMWidth() {
        return this.f402211j;
    }

    public final b getShadowConfig() {
        return this.f402206e;
    }

    public final boolean getUseDefaultView() {
        return this.f402221t;
    }

    public final float getPadding() {
        return this.f402207f;
    }

    public OMiddleArrowPopoverLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f402202a = d.c(getContext(), 9);
        this.f402203b = d.d(getContext(), 18.0f);
        this.f402204c = d.c(getContext(), 42);
        this.f402205d = d.c(getContext(), 42);
        d.d(getContext(), f402200y);
        this.f402207f = d.e(getContext(), f402201z);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f402215n != null) goto L5;
        Resources r100 = getContext().getResources();
        this.f402215n = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r101 = this.f402215n;
        Intrinsics.checkNotNull(r101);
        this.f402216o = new Canvas(r101);
    L5:
        Paint r102 = this.f402208g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r102 = null;
    L8:
        r102.setColor(getMBgColor());
        Drawable r103 = this.f402217p;
        if (r103 == null) goto L34;
        int r104 = this.f402214m;
        if (r104 != 0) goto L14;
        float r105 = 270.0f;
    L21:
        int r106 = this.f402202a + ((int) getPadding());
        int r107 = this.f402202a;
        int r108 = (getHeight() - ((int) ((((getWidth() - r106) - r107) * r103.getIntrinsicHeight()) / r103.getIntrinsicWidth()))) / 2;
        r103.setBounds(r106, r108, getWidth() - r107, getHeight() - r108);
        Canvas r109 = this.f402216o;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r109 = null;
    L24:
        r109.save();
        Canvas r111 = this.f402216o;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r111 = null;
    L27:
        r111.rotate(r105, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r112 = this.f402216o;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r112 = null;
    L30:
        r103.draw(r112);
        Canvas r113 = this.f402216o;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r113 = null;
    L33:
        r113.restore();
        goto L34
    L14:
        if (r104 != 1) goto L16;
        r105 = 180.0f;
        goto L21
    L16:
        if (r104 == 3) goto L18;
        r105 = 0.0f;
        goto L21
    L18:
        r105 = 90.0f;
    L34:
        Bitmap r114 = this.f402215n;
        Intrinsics.checkNotNull(r114);
        r110.drawBitmap(r114, 0.0f, 0.0f, null);
    }

    public final void setBorderColor(int r100) {
        this.f402224w = r100;
    }

    public final void setBorderWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f402223v = r100;
        if (this.f402225x != null) goto L7;
        this.f402225x = new Paint();
    L7:
        Paint r101 = this.f402225x;
        if (r101 == null) goto L11;
        r101.setStyle(Paint.Style.STROKE);
    L11:
        Paint r102 = this.f402225x;
        if (r102 == null) goto L15;
        r102.setStrokeWidth(this.f402223v);
    L15:
        Paint r103 = this.f402225x;
        if (r103 == null) goto L19;
        r103.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r104 = this.f402225x;
        if (r104 == null) goto L23;
        r104.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r105 = this.f402225x;
        if (r105 == null) goto L27;
        r105.setAntiAlias(true);
    L27:
        Paint r106 = this.f402225x;
        if (r106 == null) goto L31;
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r107 = this.f402225x;
        if (r107 == null) goto L35;
        r107.setColor(this.f402224w);
    L35:
        Paint r108 = this.f402208g;
        Paint r109 = null;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r108 = null;
    L38:
        r108.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r110 = this.f402208g;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r109.setStrokeWidth(this.f402223v);
        return;
    L41:
        r109 = r110;
        goto L42
    }

    public final void setBubbleOrientation(int r100) {
        this.f402214m = r100;
    }

    public final void setMAdjustHeight(int r100) {
        this.f402222u = r100;
    }

    public final void setMBgColor(int r100) {
        this.f402218q = r100;
    }

    public final void setMHeight(float r100) {
        this.f402212k = r100;
    }

    public final void setMNeedArrow(boolean r100) {
        this.f402220s = r100;
    }

    public final void setMNeedShadow(boolean r100) {
        this.f402219r = r100;
    }

    public final void setMWidth(float r100) {
        this.f402211j = r100;
    }

    public final void setPadding(float r100) {
        this.f402207f = r100;
    }

    public final void setTransparentBg(boolean r100) {
        if (r100 == false) goto L5;
        this.f402218q = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r100) {
        this.f402221t = r100;
    }

    public OMiddleArrowPopoverLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        Path r101 = null;
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r102 = getChildAt(0);
        if (r102 == null) goto L8;
        TextView r103 = (TextView) r102;
    L10:
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getSize(r100);
        int r106 = View.MeasureSpec.getMode(r110);
        int r111 = View.MeasureSpec.getSize(r110);
        if (r103 == null) goto L17;
        int r107 = d.c(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE);
        if (((int) r103.getPaint().measureText(r103.getText().toString())) > r107) goto L16;
        r107 = (int) r103.getPaint().measureText(r103.getText().toString());
    L16:
        int r108 = (r107 + r103.getPaddingLeft()) + r103.getPaddingRight();
    L19:
        if (this.f402221t == false) goto L24;
        int r109 = this.f402204c;
        if (r108 <= r109) goto L23;
        r109 = (((int) this.f402207f) * 2) + r108;
    L23:
        int r112 = this.f402202a;
        int r113 = this.f402223v;
        int r114 = (r109 + (r112 * 2)) + (r113 * 2);
        int r115 = (this.f402205d + (r112 * 2)) + (r113 * 2);
    L26:
        if (r104 != Integer.MIN_VALUE) goto L29;
        if (r106 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r114, r115);
    L33:
        this.f402211j = getMeasuredWidth();
        float r116 = getMeasuredHeight();
        this.f402212k = r116;
        float r117 = r116 / 2.0f;
        float r118 = (this.f402202a + r117) - (r117 / 1.63f);
        float r119 = r117 / 1.56f;
        Path r120 = this.f402210i;
        if (r120 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r120 = null;
    L36:
        r120.reset();
        Path r121 = this.f402210i;
        if (r121 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r121 = null;
    L39:
        r121.moveTo(0.0f, 0.0f);
        Path r122 = this.f402210i;
        if (r122 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r122 = null;
    L42:
        r122.lineTo(r118, -r119);
        Path r123 = this.f402210i;
        if (r123 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r123 = null;
    L45:
        r123.lineTo(r118, r119);
        Path r124 = this.f402210i;
        if (r124 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r124 = null;
    L48:
        r124.lineTo(0.0f, 0.0f);
        Path r125 = this.f402210i;
        if (r125 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L52:
        r101.close();
        return;
    L51:
        r101 = r125;
    L29:
        if (r104 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r114, r111);
        goto L33
    L31:
        if (r106 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r105, r115);
        goto L33
    L24:
        PopupWindow r126 = new PopupWindow(getChildAt(0), -2, -2, true);
        r126.getContentView().measure(0, 0);
        r114 = r126.getContentView().getMeasuredWidth() + 18;
        r115 = r126.getContentView().getMeasuredHeight() + 18;
        goto L26
    L17:
        r108 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r103 = null;
        goto L10
    }

    public OMiddleArrowPopoverLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402206e = new b(0);
        this.f402213l = 0.75f;
        this.f402214m = 1;
        this.f402220s = true;
        this.f402221t = true;
        new Path();
        new Path();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f402202a = d.c(r100, 9);
        this.f402203b = d.d(r100, 18.0f);
        this.f402204c = d.c(r100, 42);
        this.f402205d = d.c(r100, 42);
        d.d(r100, f402200y);
        this.f402207f = d.e(r100, f402201z);
        this.f402208g = new Paint();
        this.f402209h = new Path();
        this.f402210i = new Path();
        Paint r103 = this.f402208g;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r103 = null;
    L5:
        r103.setStyle(Paint.Style.FILL);
        Paint r104 = this.f402208g;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r104 = null;
    L8:
        r104.setStrokeCap(Paint.Cap.BUTT);
        Paint r105 = this.f402208g;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r105 = null;
    L11:
        r105.setAntiAlias(true);
        Paint r106 = this.f402208g;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r106 = null;
    L14:
        r106.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f402218q = ContextCompat.getColor(r100, R.color.SDPrimary);
    L17:
        Paint r107 = this.f402208g;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r107 = null;
    L20:
        r107.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f402217p = r100.getDrawable(R.drawable.o_bg_middle_arrow_popover);
    }
}
