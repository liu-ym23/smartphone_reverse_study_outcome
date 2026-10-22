package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.ee.bear.bitable.card.viewmodel.cell.BitableCardButtonLoadingStatus;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001#B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ButtonCell;", "Lcom/larksuite/component/universe_design/button/UDButton;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ButtonCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "iconSizeDp", "", "strokePaint", "cornerRadiusPx", "strokeWidthPx", "setData", "", "data", "extra", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "needFullWidth", "", "text", "", "remainWidth", "", "setStroke", "widthDp", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonCell extends UDButton {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f213808f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f213809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f213810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f213811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f213812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f213813e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213814a = null;

        static {
            int[] r100 = new int[BitableCardButtonLoadingStatus.values().length];
            r100[BitableCardButtonLoadingStatus.Default.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[BitableCardButtonLoadingStatus.Loading.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[BitableCardButtonLoadingStatus.Done.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[BitableCardButtonLoadingStatus.Disabled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f213814a = r100;
        }
    }

    static {
    }

    public ButtonCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = this.f213813e;
        if (r101 <= 0.0f) goto L6;
        float r102 = r101 / 2;
        RectF r103 = new RectF(r102, r102, getWidth() - r102, getHeight() - r102);
        float r104 = this.f213812d;
        r100.drawRoundRect(r103, r104, r104, this.f213811c);
        return;
    }

    public final void setStroke(float r100) {
        this.f213813e = r100;
        this.f213811c.setStrokeWidth(r100);
        invalidate();
    }

    public ButtonCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 4, null);
        Paint r102 = new Paint();
        r102.setTextSize(com.bytedance.ee.util.ui.n.d(14));
        this.f213809a = r102;
        this.f213810b = 14.0f;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(ContextCompat.getColor(r100, R.color.line_border_component));
        this.f213811c = r103;
        this.f213812d = com.bytedance.ee.util.ui.n.d(6);
        setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.ee.util.ui.n.d(28)));
        setMinWidth(com.bytedance.ee.util.ui.n.d(68));
        setPadding(com.bytedance.ee.util.ui.n.d(8), 0, com.bytedance.ee.util.ui.n.d(8), 0);
        setCornerRadius(com.bytedance.ee.util.ui.n.d(6));
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        setGravity(17);
        setTextSize(14.0f);
        setTextColor(ContextCompat.getColor(r100, R.color.static_white));
        setBackgroundColor(ContextCompat.getColor(r100, R.color.ud_button_blue_bg));
    }

    public final void a(ButtonCellValue r100, qt4.a r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        if (r100 == null) goto L54;
        String r101 = r100.getTitle();
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r102 = r100.getCurrentTextColor();
        if (r102 == null) goto L10;
        int r103 = ColorUtils.h(r102);
    L12:
        if (r110.f534785b == false) goto L18;
        int r104 = r110.f534784a;
        Intrinsics.checkNotNullParameter(r101, "text");
        if ((r104 - Math.max(((int) this.f213809a.measureText(r101)) + com.bytedance.ee.util.ui.n.d(32), com.bytedance.ee.util.ui.n.d(68))) >= 0) goto L16;
        boolean r105 = true;
    L17:
        com.bytedance.ee.bear.bitable.itemview.util.i.i(this, r105);
        goto L18
    L16:
        r105 = false;
    L18:
        setTextColor(r103);
        if (Intrinsics.areEqual(r100.getHasBorder(), Boolean.TRUE) == false) goto L21;
        setStroke(com.bytedance.ee.util.ui.n.d(1));
    L22:
        BitableCardButtonLoadingStatus r106 = r100.getStatus();
        if (r106 != null) goto L25;
        int r107 = -1;
    L26:
        if (r107 != (-1)) goto L28;
        return;
    L28:
        if (r107 == 1) goto L48;
        if (r107 != 2) goto L31;
        CircularProgressDrawable r111 = new CircularProgressDrawable(getContext());
        r111.setColorSchemeColors(new int[]{r103});
        r111.setStrokeWidth(com.bytedance.ee.util.ui.n.c(1.8f));
        int r108 = com.bytedance.ee.util.ui.n.c(this.f213810b);
        r111.setBounds(0, 0, r108, r108);
        com.larksuite.component.universe_design.button.a r109 = new com.larksuite.component.universe_design.button.a();
        r109.f284589c = 2;
        Unit r112 = Unit.INSTANCE;
        com.larksuite.component.universe_design.button.e.d(this, r111, r109);
        setClickable(false);
        String r113 = r100.getCurrentBgColor();
        if (r113 == null) goto L47;
        setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r113)));
        return;
    L47:
        return;
    L31:
        if (r107 != 3) goto L33;
        Drawable r114 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_msgcard_rectangle_outlined, r103, new UDDimension.Dp(this.f213810b));
        com.larksuite.component.universe_design.button.a r115 = new com.larksuite.component.universe_design.button.a();
        r115.f284589c = 2;
        Unit r116 = Unit.INSTANCE;
        com.larksuite.component.universe_design.button.e.d(this, r114, r115);
        setClickable(false);
        String r117 = r100.getCurrentBgColor();
        if (r117 == null) goto L43;
        setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r117)));
        return;
    L43:
        return;
    L33:
        if (r107 != 4) goto L39;
        setText(r101);
        setClickable(true);
        setOnClickListener(new c(r110));
        String r118 = r100.getCurrentBgColor();
        if (r118 == null) goto L37;
        setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r118)));
        return;
    L37:
        return;
    L39:
        throw new NoWhenBranchMatchedException();
    L48:
        com.larksuite.component.universe_design.button.e.b(this, r101);
        setClickable(true);
        setOnClickListener(new com.bytedance.ee.bear.bitable.itemview.cell.cellview.b(r110));
        int[][] r119 = {new int[]{android.R.attr.state_pressed}, new int[0]};
        String r120 = r100.getActiveBgColor();
        if (r120 == null) goto L59;
        int r121 = ColorUtils.h(r120);
        String r122 = r100.getCurrentBgColor();
        if (r122 == null) goto L60;
        setBackgroundTintList(new ColorStateList(r119, new int[]{r121, ColorUtils.h(r122)}));
        return;
    L60:
        return;
    L59:
        return;
    L25:
        r107 = b.f213814a[r106.ordinal()];
        goto L26
    L21:
        setStroke(0.0f);
        goto L22
    L10:
        r103 = -1;
        goto L12
    }
}
