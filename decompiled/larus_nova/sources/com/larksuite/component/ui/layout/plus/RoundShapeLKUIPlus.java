package com.larksuite.component.ui.layout.plus;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.ui.layout.ILKUILayout;
import com.larus.nova.R;
import j08.c;
import j08.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010 \u001a\u00020!H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020$H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020$H\u0002J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020$2\b\b\u0001\u00106\u001a\u00020\u000eJ\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\tJ\u000e\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u000eJ&\u00107\u001a\u00020$2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tJ&\u00109\u001a\u00020$2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020\tJ\u0006\u0010D\u001a\u00020\tJ\u0006\u0010E\u001a\u00020\tJ\u0006\u0010F\u001a\u00020\tJ\u0006\u0010G\u001a\u00020\tJ(\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u000eH\u0016J(\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0002JH\u0010R\u001a\u00020S2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0002J,\u0010T\u001a\u00020$*\u00020\u001e2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u000eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larksuite/component/ui/layout/plus/RoundShapeLKUIPlus;", "Lcom/larksuite/component/ui/layout/plus/BaseInnerPlus;", "layout", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "<init>", "(Lcom/larksuite/component/ui/layout/ILKUILayout;)V", "getPlusType", "Lcom/larksuite/component/ui/layout/plus/InnerPlusType;", "radiusLeftTop", "", "radiusRightTop", "radiusLeftBottom", "radiusRightBottom", "originPaddingLeft", "", "originPaddingTop", "originPaddingRight", "originPaddingBottom", "borderWidth", "boarderColor", "boardPaint", "Landroid/graphics/Paint;", "getBoardPaint", "()Landroid/graphics/Paint;", "boardPaint$delegate", "Lkotlin/Lazy;", "clearPaint", "getClearPaint", "clearPaint$delegate", "clearPath", "Landroid/graphics/Path;", "borderMode", "isVeryLargeThanScreen", "", "hasBorder", "onDelegateDispatchDrawEnd", "", "canvas", "Landroid/graphics/Canvas;", "getClearCanvasPath", "setClipOutline", "setPadding", GXTemplateKey.FLEXBOX_PADDING, "onDelegateSetPaddingStart", "paddingData", "Landroid/graphics/Rect;", "amendPadding", "setBorderMode", "mode", "setBorderWidth", "widthInDp", "setBorderWidthInPx", "widthInPx", "setBorderColor", "color", "setRadius", "radiusInDp", "setRadiusInPx", "radiusInPx", "leftTopRadiusInDp", "leftBottomRadiusInDp", "rightTopRadiusInDp", "rightBottomRadiusInDp", "leftTopRadius", "leftBottomRadius", "rightTopRadius", "rightBottomRadius", "getRadius", "getLeftTopRadius", "getLeftBottomRadius", "getRightTopRadius", "getRightBottomRadius", "onDelegateSizeChanged", "w", "h", "oldw", "oldh", "getBorderPath", "left", "top", "right", "bottom", "createPathKey", "", "arcTo", "x", "y", "radius", "rotations", "Companion", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundShapeLKUIPlus extends BaseInnerPlus {
    public static final a Companion = null;
    public static final int MODE_INSET = 1;
    public static final int MODE_OVERLAY = 0;
    private static final RoundShapeLKUIPlus$Companion$sPathCache$1 sPathCache = null;
    private final Lazy boardPaint$delegate;
    private int boarderColor;
    private int borderMode;
    private float borderWidth;
    private final Lazy clearPaint$delegate;
    private Path clearPath;
    private boolean isVeryLargeThanScreen;
    private int originPaddingBottom;
    private int originPaddingLeft;
    private int originPaddingRight;
    private int originPaddingTop;
    private float radiusLeftBottom;
    private float radiusLeftTop;
    private float radiusRightBottom;
    private float radiusRightTop;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundShapeLKUIPlus f284236a;

        public b(RoundShapeLKUIPlus r100) {
            this.f284236a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r101 == null) goto L5;
            r101.setRoundRect(0, 0, this.f284236a.getLayout().getWidth(), this.f284236a.getLayout().getHeight(), RoundShapeLKUIPlus.access$getRadiusLeftTop$p(this.f284236a));
            return;
        }
    }

    static {
        Companion = new a();
        sPathCache = new RoundShapeLKUIPlus$Companion$sPathCache$1();
    }

    private final void amendPadding() {
        if (this.borderMode != 1) goto L5;
        int r100 = (int) this.borderWidth;
    L6:
        getLayout().setPadding(this.originPaddingLeft + r100, this.originPaddingTop + r100, this.originPaddingRight + r100, this.originPaddingBottom + r100);
        return;
    L5:
        r100 = 0;
        goto L6
    }

    private final Paint getBoardPaint() {
        return (Paint) this.boardPaint$delegate.getValue();
    }

    private final Path getClearCanvasPath() {
        this.clearPath.reset();
        this.clearPath.set(getBorderPath(0.0f, 0.0f, getLayout().getWidth(), getLayout().getHeight()));
        this.clearPath.toggleInverseFillType();
        return this.clearPath;
    }

    private final Paint getClearPaint() {
        return (Paint) this.clearPaint$delegate.getValue();
    }

    private final boolean hasBorder() {
        if (this.borderWidth > 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (this.boarderColor == 0) goto L7;
        return true;
    }

    private final void setClipOutline() {
        float r100 = this.radiusLeftTop;
        if (r100 != this.radiusRightTop) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L18:
        getLayout().setClipToOutline(false);
        getLayout().setOutlineProvider(null);
    L19:
        getLayout().invalidate();
        return;
    L8:
        if (r100 != this.radiusLeftBottom) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L18;
        if (r100 != this.radiusRightBottom) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        getLayout().setOutlineProvider(new b(this));
        getLayout().setClipToOutline(true);
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

    private final boolean isVeryLargeThanScreen() {
        c r100 = d.c(getContext());
        if (getLayout().getWidth() <= (r100.f496834a * 2)) goto L5;
    L8:
        return true;
    L5:
        if (getLayout().getHeight() > (r100.f496835b * 2)) goto L8;
        return false;
    }

    public final float getLeftBottomRadius() {
        return this.radiusLeftBottom;
    }

    public final float getLeftTopRadius() {
        return this.radiusLeftTop;
    }

    @Override // com.larksuite.component.ui.layout.plus.BaseInnerPlus
    public InnerPlusType getPlusType() {
        return InnerPlusType.ROUND_SHAPE;
    }

    public final float getRadius() {
        return this.radiusLeftTop;
    }

    public final float getRightBottomRadius() {
        return this.radiusRightBottom;
    }

    public final float getRightTopRadius() {
        return this.radiusRightTop;
    }

    public RoundShapeLKUIPlus(ILKUILayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        super(r100);
        this.boardPaint$delegate = LazyKt.lazy(RoundShapeLKUIPlus$boardPaint$2.INSTANCE);
        this.clearPaint$delegate = LazyKt.lazy(RoundShapeLKUIPlus$clearPaint$2.INSTANCE);
        this.clearPath = new Path();
        TypedArray r101 = getContext().obtainStyledAttributes(getAttrs(), new int[]{R.attr.rl_border_color, R.attr.rl_border_mode, R.attr.rl_border_width, R.attr.rl_radius, R.attr.rl_radius_left_bottom, R.attr.rl_radius_left_top, R.attr.rl_radius_right_bottom, R.attr.rl_radius_right_top}, 0, 0);
        float r102 = r101.getDimension(3, 0.0f);
        this.radiusLeftTop = r101.getDimension(5, r102);
        this.radiusLeftBottom = r101.getDimension(4, r102);
        this.radiusRightTop = r101.getDimension(7, r102);
        this.radiusRightBottom = r101.getDimension(6, r102);
        this.borderWidth = r101.getDimension(2, 0.0f);
        this.boarderColor = r101.getColor(0, ContextCompat.getColor(getContext(), R.color.lkui_N200));
        this.borderMode = r101.getInt(1, 0);
        r101.recycle();
        this.originPaddingLeft = getLayout().getPaddingLeft();
        this.originPaddingTop = getLayout().getPaddingTop();
        this.originPaddingRight = getLayout().getPaddingRight();
        this.originPaddingBottom = getLayout().getPaddingBottom();
        if (this.borderWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.borderMode != 1) goto L9;
        amendPadding();
        return;
    }

    public static final /* synthetic */ float access$getRadiusLeftTop$p(RoundShapeLKUIPlus r100) {
        return r100.radiusLeftTop;
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateDispatchDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getLayout().getClipToOutline() == false) goto L5;
    L7:
        boolean r101 = false;
    L18:
        e = move-exception;
        String r102 = e.getMessage();
        if (r102 != null) goto L22;
    L24:
        if (r101 == false) goto L28;
        throw e;
    L28:
        return;
    L22:
        if (StringsKt.contains$default(r102, "recycled bitmap", false, 2, null) == true) goto L24;
        r101 = true;
        goto L24
    L9:
        if (hasBorder() == false) goto L12;
        getBoardPaint().setColor(this.boarderColor);     // Catch: RuntimeException -> L18
        getBoardPaint().setStrokeWidth(this.borderWidth * 2);     // Catch: RuntimeException -> L18
        r100.drawPath(getBorderPath(0.0f, 0.0f, getLayout().getWidth(), getLayout().getHeight()), getBoardPaint());     // Catch: RuntimeException -> L18
    L12:
        if (getLayout().getClipToOutline() == false) goto L14;
    L16:
        getLayout().setLayerType(0, null);     // Catch: RuntimeException -> L18
        return;
    L14:
        if (this.isVeryLargeThanScreen == true) goto L16;
        getLayout().setLayerType(2, null);     // Catch: RuntimeException -> L18
        r100.drawPath(getClearCanvasPath(), getClearPaint());     // Catch: RuntimeException -> L18
        return;
    L5:
        if (this.isVeryLargeThanScreen == false) goto L7;
        r100.clipPath(getBorderPath(0.0f, 0.0f, getLayout().getWidth(), getLayout().getHeight()));
        goto L7
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateSetPaddingStart(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        int r101 = r100.left;
        this.originPaddingLeft = r101;
        int r102 = r100.top;
        this.originPaddingTop = r102;
        int r103 = r100.right;
        this.originPaddingRight = r103;
        int r104 = r100.bottom;
        this.originPaddingBottom = r104;
        if (this.borderMode != 1) goto L5;
        int r105 = (int) this.borderWidth;
    L6:
        r100.left = r101 + r105;
        r100.top = r102 + r105;
        r100.right = r103 + r105;
        r100.bottom = r104 + r105;
        super.onDelegateSetPaddingStart(r100);
        return;
    L5:
        r105 = 0;
        goto L6
    }

    public final void setBorderColor(int r100) {
        this.boarderColor = r100;
        getLayout().invalidate();
    }

    public final void setBorderMode(int r100) {
        if (this.borderMode == r100) goto L5;
        boolean r101 = true;
    L6:
        this.borderMode = r100;
        amendPadding();
        if (r101 == false) goto L10;
        setClipOutline();
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
        if (this.borderWidth != r100) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = !r101;
        this.borderWidth = r100;
        amendPadding();
        if (r102 == false) goto L10;
        setClipOutline();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setPadding(int r100) {
        getLayout().setPadding(r100, r100, r100, r100);
    }

    public final void setRadius(float r100) {
        setRadiusInPx((int) j08.b.a(getContext(), r100));
    }

    public final void setRadiusInPx(int r100) {
        float r101 = r100;
        this.radiusLeftTop = r101;
        this.radiusLeftBottom = r101;
        this.radiusRightTop = r101;
        this.radiusRightBottom = r101;
        setClipOutline();
    }

    private final Path getBorderPath(float r110, float r111, float r112, float r210) {
        RoundShapeLKUIPlus$Companion$sPathCache$1 r113 = sPathCache;
        Path r100 = (Path) r113.get(createPathKey(r110, r111, r112, r210, this.radiusLeftTop, this.radiusLeftBottom, this.radiusRightTop, this.radiusRightBottom));
        if (r100 == null) goto L5;
        return r100;
    L5:
        Path r114 = new Path();
        r114.reset();
        r114.moveTo(this.radiusLeftTop + r110, r111);
        r114.lineTo(r112 - this.radiusRightTop, r111);
        float r101 = this.radiusRightTop;
        arcTo(r114, r112 - r101, r111 + r101, r101, -1);
        r114.lineTo(r112, r210 - this.radiusRightBottom);
        float r102 = this.radiusRightBottom;
        arcTo(r114, r112 - r102, r210 - r102, r102, 0);
        r114.lineTo(this.radiusLeftBottom + r110, r210);
        float r103 = this.radiusLeftBottom;
        arcTo(r114, r110 + r103, r210 - r103, r103, 1);
        r114.lineTo(r110, this.radiusLeftTop + r111);
        float r104 = this.radiusLeftTop;
        arcTo(r114, r110 + r104, r111 + r104, r104, 2);
        r114.lineTo(this.radiusLeftTop + r110, r111);
        r114.close();
        r113.put(createPathKey(r110, r111, r112, r210, this.radiusLeftTop, this.radiusLeftBottom, this.radiusRightTop, this.radiusRightBottom), r114);
        return r114;
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateSizeChanged(int r100, int r101, int r102, int r103) {
        super.onDelegateSizeChanged(r100, r101, r102, r103);
        this.isVeryLargeThanScreen = isVeryLargeThanScreen();
        setClipOutline();
    }

    public final void setRadius(float r100, float r101, float r102, float r103) {
        setRadiusInPx(j08.b.a(getContext(), r100), j08.b.a(getContext(), r101), j08.b.a(getContext(), r102), j08.b.a(getContext(), r103));
    }

    public final void setRadiusInPx(float r100, float r101, float r102, float r103) {
        this.radiusLeftTop = r100;
        this.radiusLeftBottom = r101;
        this.radiusRightTop = r102;
        this.radiusRightBottom = r103;
        setClipOutline();
    }

    private final void arcTo(Path r100, float r110, float r111, float r112, int r113) {
        r100.arcTo(r110 - r112, r111 - r112, r110 + r112, r111 + r112, r113 * 90.0f, 90.0f, false);
    }

    private final String createPathKey(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r110) {
        return "l:" + ((int) r100) + " ,t:" + ((int) r101) + " ,r:" + ((int) r102) + " ,b:" + ((int) r103) + " ,lt:" + ((int) r104) + ", lb = " + ((int) r105) + ", rt = " + ((int) r106) + " , rb = " + ((int) r110);
    }
}
