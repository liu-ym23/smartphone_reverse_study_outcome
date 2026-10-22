package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010)\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0014J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020+H\u0002J\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\bJ(\u00101\u001a\u00020+2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020+H\u0002J\u000e\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\fJ\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\fJ\u0010\u0010>\u001a\u00020+2\b\b\u0001\u0010?\u001a\u00020\bJ\u0010\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\bH\u0016J(\u0010@\u001a\u00020+2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fH\u0016J(\u0010B\u001a\u00020+2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0016J\b\u0010L\u001a\u00020\fH\u0016J\b\u0010M\u001a\u00020\fH\u0016J\b\u0010N\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J(\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\bH\u0014J(\u0010V\u001a\u00020 2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0002JH\u0010W\u001a\u00020X2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fH\u0002J,\u0010Y\u001a\u00020+*\u00020 2\u0006\u0010Z\u001a\u00020\f2\u0006\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006_"}, d2 = {"Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "Landroid/widget/FrameLayout;", "Lcom/larksuite/component/ui/layout/LKUIRadiusSupportLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radiusLeftTop", "", "radiusRightTop", "radiusLeftBottom", "radiusRightBottom", "originPaddingLeft", "originPaddingTop", "originPaddingRight", "originPaddingBottom", "borderWidth", "boarderColor", "boardPaint", "Landroid/graphics/Paint;", "getBoardPaint", "()Landroid/graphics/Paint;", "boardPaint$delegate", "Lkotlin/Lazy;", "clearPaint", "getClearPaint", "clearPaint$delegate", "clearPath", "Landroid/graphics/Path;", "borderMode", "isVeryLargeThanScreen", "", "softwareRoundClipEnabled", "getSoftwareRoundClipEnabled", "()Z", "setSoftwareRoundClipEnabled", "(Z)V", "hasBorder", "draw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "getClearCanvasPath", "setClipOutline", "setPadding", GXTemplateKey.FLEXBOX_PADDING, "left", "top", "right", "bottom", "amendPadding", "setBorderMode", "mode", "setBorderWidth", "widthInDp", "setBorderWidthInPx", "widthInPx", "setBorderColor", "color", "setRadius", "radiusInDp", "setRadiusInPx", "radiusInPx", "leftTopRadiusInDp", "leftBottomRadiusInDp", "rightTopRadiusInDp", "rightBottomRadiusInDp", "leftTopRadius", "leftBottomRadius", "rightTopRadius", "rightBottomRadius", "getRadius", "getLeftTopRadius", "getLeftBottomRadius", "getRightTopRadius", "getRightBottomRadius", "onSizeChanged", "w", "h", "oldw", "oldh", "getBorderPath", "createPathKey", "", "arcTo", "x", "y", "radius", "rotations", "Companion", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LKUIRoundableLayout extends FrameLayout implements com.larksuite.component.ui.layout.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final LKUIRoundableLayout$Companion$sPathCache$1 f284209q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f284210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f284211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f284212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f284213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f284215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f284216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f284217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f284218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f284219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f284220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f284221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Path f284222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f284223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f284224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f284225p;

    public static final class a {
    }

    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUIRoundableLayout f284226a;

        public b(LKUIRoundableLayout r100) {
            this.f284226a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r101 == null) goto L5;
            r101.setRoundRect(0, 0, this.f284226a.getWidth(), this.f284226a.getHeight(), this.f284226a.f284210a);
            return;
        }
    }

    public LKUIRoundableLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LKUIRoundableLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f284209q = new LKUIRoundableLayout$Companion$sPathCache$1();
    }

    private final Paint getBoardPaint() {
        return (Paint) this.f284220k.getValue();
    }

    private final Path getClearCanvasPath() {
        this.f284222m.reset();
        this.f284222m.set(d(getWidth(), getHeight()));
        this.f284222m.toggleInverseFillType();
        return this.f284222m;
    }

    private final Paint getClearPaint() {
        return (Paint) this.f284221l.getValue();
    }

    public final void a() {
        if (this.f284223n != 1) goto L5;
        int r100 = (int) this.f284218i;
    L6:
        super.setPadding(this.f284214e + r100, this.f284215f + r100, this.f284216g + r100, this.f284217h + r100);
        return;
    L5:
        r100 = 0;
        goto L6
    }

    public final void e() {
        float r100 = this.f284210a;
        if (r100 != this.f284211b) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L18:
        setClipToOutline(false);
        setOutlineProvider(null);
    L19:
        invalidate();
        return;
    L8:
        if (r100 != this.f284212c) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L18;
        if (r100 != this.f284213d) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        setOutlineProvider(new b(this));
        setClipToOutline(true);
        goto L19
    L15:
        r103 = false;
        goto L16
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public float getLeftBottomRadius() {
        return this.f284212c;
    }

    public float getLeftTopRadius() {
        return this.f284210a;
    }

    public float getRadius() {
        return this.f284210a;
    }

    public float getRightBottomRadius() {
        return this.f284213d;
    }

    public float getRightTopRadius() {
        return this.f284211b;
    }

    public final boolean getSoftwareRoundClipEnabled() {
        return this.f284225p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f284225p == false) goto L5;
    L9:
        boolean r101 = true;
        super.dispatchDraw(r100);     // Catch: RuntimeException -> L29
        if (this.f284218i > 0.0f) goto L13;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L19;
        getBoardPaint().setColor(this.f284219j);     // Catch: RuntimeException -> L29
        getBoardPaint().setStrokeWidth(this.f284218i * 2);     // Catch: RuntimeException -> L29
        r100.drawPath(d(getWidth(), getHeight()), getBoardPaint());     // Catch: RuntimeException -> L29
    L19:
        if (this.f284225p == true) goto L26;
        if (getClipToOutline() == true) goto L26;
        if (this.f284224o == true) goto L26;
        setLayerType(2, null);     // Catch: RuntimeException -> L29
        r100.drawPath(getClearCanvasPath(), getClearPaint());     // Catch: RuntimeException -> L29
        return;
    L26:
        if (this.f284225p == true) goto L40;
        setLayerType(0, null);     // Catch: RuntimeException -> L29
        return;
    L40:
        return;
    L13:
        if (this.f284219j == 0) goto L15;
        r102 = true;
    L29:
        e = move-exception;
        String r103 = e.getMessage();
        if (r103 != null) goto L33;
    L35:
        r101 = false;
    L36:
        if (r101 == false) goto L41;
        throw e;
    L41:
        return;
    L33:
        if (StringsKt.contains$default(r103, "recycled bitmap", false, 2, null) == true) goto L35;
    L5:
        if (getClipToOutline() == true) goto L9;
        if (this.f284224o == false) goto L9;
        r100.clipPath(d(getWidth(), getHeight()));
        goto L9
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f284225p == false) goto L5;
        int r101 = r100.save();
        r100.clipPath(d(getWidth(), getHeight()));
        super.draw(r100);
        r100.restoreToCount(r101);
        return;
    L5:
        super.draw(r100);
    }

    public final void setBorderColor(int r100) {
        this.f284219j = r100;
        invalidate();
    }

    public final void setBorderMode(int r100) {
        if (this.f284223n == r100) goto L5;
        boolean r101 = true;
    L6:
        this.f284223n = r100;
        a();
        if (r101 == false) goto L10;
        e();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setBorderWidth(float r100) {
        setBorderWidthInPx(j08.b.a(getContext(), r100));
    }

    public final void setBorderWidthInPx(float r100) {
        if (this.f284218i != r100) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = !r101;
        this.f284218i = r100;
        a();
        if (r102 == false) goto L10;
        e();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setPadding(int r100) {
        setPadding(r100, r100, r100, r100);
    }

    public void setRadius(float r100) {
        setRadiusInPx((int) j08.b.a(getContext(), r100));
    }

    public void setRadiusInPx(int r100) {
        float r101 = r100;
        this.f284210a = r101;
        this.f284212c = r101;
        this.f284211b = r101;
        this.f284213d = r101;
        e();
    }

    public final void setSoftwareRoundClipEnabled(boolean r100) {
        this.f284225p = r100;
    }

    public final Path d(float r110, float r111) {
        LKUIRoundableLayout$Companion$sPathCache$1 r100 = f284209q;
        Path r101 = (Path) r100.get(c(r110, r111, this.f284210a, this.f284212c, this.f284211b, this.f284213d));
        if (r101 == null) goto L5;
        return r101;
    L5:
        Path r102 = new Path();
        r102.reset();
        r102.moveTo(this.f284210a + 0.0f, 0.0f);
        r102.lineTo(r110 - this.f284211b, 0.0f);
        float r103 = this.f284211b;
        b(r102, r110 - r103, 0.0f + r103, r103, -1);
        r102.lineTo(r110, r111 - this.f284213d);
        float r104 = this.f284213d;
        b(r102, r110 - r104, r111 - r104, r104, 0);
        r102.lineTo(this.f284212c + 0.0f, r111);
        float r105 = this.f284212c;
        b(r102, 0.0f + r105, r111 - r105, r105, 1);
        r102.lineTo(0.0f, this.f284210a + 0.0f);
        float r106 = this.f284210a;
        float r107 = 0.0f + r106;
        b(r102, r107, r107, r106, 2);
        r102.lineTo(this.f284210a + 0.0f, 0.0f);
        r102.close();
        r100.put(c(r110, r111, this.f284210a, this.f284212c, this.f284211b, this.f284213d), r102);
        return r102;
    }

    public LKUIRoundableLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f284220k = LazyKt.lazy(LKUIRoundableLayout$boardPaint$2.INSTANCE);
        this.f284221l = LazyKt.lazy(LKUIRoundableLayout$clearPaint$2.INSTANCE);
        this.f284222m = new Path();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.rl_border_color, R.attr.rl_border_mode, R.attr.rl_border_width, R.attr.rl_radius, R.attr.rl_radius_left_bottom, R.attr.rl_radius_left_top, R.attr.rl_radius_right_bottom, R.attr.rl_radius_right_top}, 0, 0);
        float r104 = r103.getDimension(3, 0.0f);
        this.f284210a = r103.getDimension(5, r104);
        this.f284212c = r103.getDimension(4, r104);
        this.f284211b = r103.getDimension(7, r104);
        this.f284213d = r103.getDimension(6, r104);
        this.f284218i = r103.getDimension(2, 0.0f);
        this.f284219j = r103.getColor(0, ContextCompat.getColor(r100, R.color.ud_N200));
        this.f284223n = r103.getInt(1, 0);
        r103.recycle();
        this.f284214e = getPaddingLeft();
        this.f284215f = getPaddingTop();
        this.f284216g = getPaddingRight();
        this.f284217h = getPaddingBottom();
        if (this.f284218i > 0.0f) goto L5;
        return;
    L5:
        if (this.f284223n != 1) goto L9;
        a();
        return;
    }

    public /* synthetic */ LKUIRoundableLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        j08.c r104 = j08.d.c(getContext());
        if (getWidth() <= (r104.f496834a * 2)) goto L5;
    L8:
        boolean r105 = true;
    L9:
        this.f284224o = r105;
        e();
        return;
    L5:
        if (getHeight() > (r104.f496835b * 2)) goto L8;
        r105 = false;
        goto L9
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        this.f284214e = r100;
        this.f284215f = r101;
        this.f284216g = r102;
        this.f284217h = r103;
        a();
    }

    @Override // com.larksuite.component.ui.layout.b
    public final void setRadius(float r100, float r101, float r102, float r103) {
        float r104 = j08.b.a(getContext(), r100);
        float r105 = j08.b.a(getContext(), r101);
        float r106 = j08.b.a(getContext(), r102);
        float r107 = j08.b.a(getContext(), r103);
        this.f284210a = r104;
        this.f284212c = r105;
        this.f284211b = r106;
        this.f284213d = r107;
        e();
    }

    public final void b(Path r100, float r110, float r111, float r112, int r113) {
        r100.arcTo(r110 - r112, r111 - r112, r110 + r112, r111 + r112, r113 * 90.0f, 90.0f, false);
    }

    public final String c(float r100, float r101, float r102, float r103, float r104, float r105) {
        return "l:0 ,t:0 ,r:" + ((int) r100) + " ,b:" + ((int) r101) + " ,lt:" + ((int) r102) + ", lb = " + ((int) r103) + ", rt = " + ((int) r104) + " , rb = " + ((int) r105);
    }
}
