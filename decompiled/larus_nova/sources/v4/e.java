package v4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends Drawable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f553000g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f553001h = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f553002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IAISDKDebugService.Gravity f553003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextPaint f553004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f553005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f553006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f553007f;

    public static final class a {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.OPAQUE", imports = {"android.graphics.PixelFormat"}))
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    static {
        f553000g = ColorProtector.parseColor("#a6f23131");
        f553001h = 10.0f;
    }

    public e() {
        this(null, IAISDKDebugService.Gravity.BOTTOM_CENTER);
    }

    public final int b() {
        return ((Number) this.f553005d.getValue()).intValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        String r101 = this.f553007f;
        if (r101 == null) goto L58;
        boolean r102 = true;
        int r103 = 0;
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        Integer r105 = null;
        if (r104 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L59;
        Integer r106 = Integer.valueOf(getBounds().width());
        if (r106.intValue() <= 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L21;
        r106 = null;
    L21:
        if (r106 == null) goto L24;
        int r108 = r106.intValue();
    L32:
        int r109 = RangesKt.coerceAtLeast(r108 - b(), 1);
        if (r109 > 0) goto L35;
        return;
    L35:
        SpannableString r110 = new SpannableString(r101);
        Integer r111 = this.f553002a;
        if (r111 == null) goto L38;
        int r112 = r111.intValue();
    L39:
        r110.setSpan(new BackgroundColorSpan(r112), 0, r101.length(), 33);
        if (this.f553003b != IAISDKDebugService.Gravity.BOTTOM_CENTER) goto L42;
        Layout.Alignment r113 = Layout.Alignment.ALIGN_CENTER;
    L43:
        StaticLayout r114 = a(r110, r109, r113);
        int r115 = r114.getHeight();
        Integer r116 = Integer.valueOf(getBounds().height());
        if (r116.intValue() > 0) goto L47;
        r102 = false;
    L47:
        if (r102 == false) goto L49;
        r105 = r116;
    L49:
        if (r105 == null) goto L52;
        r103 = r105.intValue();
    L56:
        int r117 = RangesKt.coerceAtLeast(r103, r115);
        r100.save();
        r100.translate(b(), r117 - r115);
        r114.draw(r100);
        r100.restore();
        return;
    L52:
        if (r100.getClipBounds(this.f553006e) == false) goto L56;
        if (this.f553006e.height() <= 0) goto L56;
        r103 = this.f553006e.height();
        goto L56
    L42:
        r113 = Layout.Alignment.ALIGN_NORMAL;
        goto L43
    L38:
        r112 = f553000g;
        goto L39
    L24:
        if (r100.getClipBounds(this.f553006e) == true) goto L26;
    L28:
        String r118 = this.f553007f;
        if (r118 == null) goto L31;
        r108 = RangesKt.coerceAtLeast((int) this.f553004c.measureText(r118), 1);
        goto L32
    L31:
        r108 = 0;
        goto L32
    L26:
        if (this.f553006e.width() <= 0) goto L28;
        r108 = this.f553006e.width();
        goto L32
    L17:
        r107 = false;
        goto L18
    L59:
        return;
    L7:
        r104 = false;
        goto L8
    }

    public e(Integer r100, IAISDKDebugService.Gravity r101) {
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f553002a = r100;
        this.f553003b = r101;
        TextPaint r102 = new TextPaint();
        r102.setTextSize(n2.a.a(Float.valueOf(13.0f)));
        r102.setColor(-1);
        r102.setTextAlign(Paint.Align.LEFT);
        this.f553004c = r102;
        this.f553005d = LazyKt.lazy(new d(this));
        this.f553006e = new Rect();
    }

    public final StaticLayout a(CharSequence r110, int r111, Layout.Alignment r112) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        StaticLayout r113 = StaticLayout.Builder.obtain(r110, 0, r110.length(), this.f553004c, r111).setAlignment(r112).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        Intrinsics.checkNotNull(r113);
        return r113;
    L6:
        return new StaticLayout(r110, this.f553004c, r111, r112, 1.0f, 0.0f, false);
    }
}
