package com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.promotion.ECLiveAtmosphere;
import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.playback.main.c;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002*+B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u001d¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/atmosphere/ECOtherAtmosphereView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", "c", "Lkotlin/Lazy;", "getElementView", "()Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", "elementView", "", "d", "getStrokeWidth", "()F", "strokeWidth", "Landroid/graphics/Path;", "e", "getPath", "()Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "f", "getSolidPaint", "()Landroid/graphics/Paint;", "solidPaint", "g", "getBorderPaint", "borderPaint", "", "h", "getDefaultBgColors", "()[I", "defaultBgColors", "i", "getDefaultBorderColors", "defaultBorderColors", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOtherAtmosphereView extends FrameLayout {
    public ECAtmosphereItem a;
    public b b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    static {
    }

    public ECOtherAtmosphereView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECOtherAtmosphereView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getBorderPaint() {
        return (Paint) this.g.getValue();
    }

    private final int[] getDefaultBgColors() {
        return (int[]) this.h.getValue();
    }

    private final int[] getDefaultBorderColors() {
        return (int[]) this.i.getValue();
    }

    private final ECCustomizedElementView getElementView() {
        return (ECCustomizedElementView) this.c.getValue();
    }

    private final Path getPath() {
        return (Path) this.e.getValue();
    }

    private final Paint getSolidPaint() {
        return (Paint) this.f.getValue();
    }

    private final float getStrokeWidth() {
        return ((Number) this.d.getValue()).floatValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b r0 = this.b;
        if (r0 == null) goto L9;
        ECAtmosphereItem r1 = this.a;
        if (r1 == null) goto L7;
        r1.getEventParam();
    L7:
        r0.a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r0 = this.b;
        if (r0 == null) goto L9;
        ECAtmosphereItem r1 = this.a;
        if (r1 == null) goto L7;
        r1.getEventParam();
    L7:
        r0.b();
        return;
    }

    public static final /* synthetic */ float a(ECOtherAtmosphereView r0) {
        return r0.getStrokeWidth();
    }

    public static int[] c(List r2) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L10;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Integer r1 = s.b((String) r3.next());
        if (r1 == null) goto L6;
        r0.add(Integer.valueOf(r1.intValue()));
    L10:
        int[] r4 = CollectionsKt.toIntArray(r0);
        if (r4.length != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L22;
        return null;
    L22:
        return r4;
    L13:
        r5 = false;
        goto L14
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        Intrinsics.checkNotNullParameter(r20, "canvas");
        super.onDraw(r20);
        dm.a.a("ECOtherAtmosphereView").a("width = " + getWidth() + " height = " + getHeight());
        float r0 = ((float) getHeight()) / 2.0f;
        getPath().reset();
        int r5 = 0;
        getPath().addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), new float[]{r0, r0, 0.0f, 0.0f, 0.0f, 0.0f, r0, r0}, Path.Direction.CW);
        Map<String, ECLiveAtmosphere> r1 = vh2.b.a;
        ECAtmosphereItem r2 = this.a;
        if (r2 == null) goto L5;
        r5 = r2.getDisplayType();
    L5:
        List r3 = null;
        if (vh2.b.a == null) goto L35;
    L17:
        Map<String, ECLiveAtmosphere> r4 = vh2.b.a;
        if (r4 == null) goto L20;
        ECLiveAtmosphere r6 = r4.get(String.valueOf(r5));
    L21:
        if (r6 == null) goto L23;
        List r7 = r6.getBorderColors();
    L24:
        int[] r8 = c(r7);
        if (r8 != null) goto L27;
        r8 = getDefaultBorderColors();
    L27:
        int[] r10 = r8;
        if (r6 == null) goto L30;
        r3 = r6.getBgColors();
    L30:
        int[] r9 = c(r3);
        if (r9 != null) goto L33;
        r9 = getDefaultBgColors();
    L33:
        getSolidPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, r9, null, Shader.TileMode.CLAMP));
        getBorderPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, r10, null, Shader.TileMode.CLAMP));
        r20.drawPath(getPath(), getSolidPaint());
        r20.drawPath(getPath(), getBorderPaint());
        return;
    L23:
        r7 = null;
        goto L24
    L20:
        r6 = null;
        goto L21
    L35:
        String r11 = ECLiveABUtils.INSTANCE.getEC_LIVE_ATMOSPHERE_UI_CONFIG();     // Catch: Exception -> L15
        if (c.a(r11) == true) goto L11;
        r11 = null;
    L11:
        if (r11 != null) goto L13;
        r11 = "{\"1\":{\"bg_colors\":[\"#CCF18827\",\"#99F18827\",\"#00F18827\"],\"border_colors\":[\"#FFFFB660\",\"#00FFB660\"]}}";
    L13:
        int r12 = m0.a;     // Catch: Exception -> L15
        vh2.b.a = (Map) m0.a.a.fromJson(r11, new vh2.a().getType());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L17
    }

    public final void b(ECAtmosphereItem r4, ECAtmosphereView.b r5) {
        Intrinsics.checkNotNullParameter(r4, "atmosphere");
        this.a = r4;
        this.b = r5;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        List<com.bytedance.android.ec.model.live.b> r1 = r4.getContent();     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        ECCustomizedElementView r2 = getElementView();     // Catch: Throwable -> L11
        int r3 = ECCustomizedElementView.k;     // Catch: Throwable -> L11
        r2.b(r1, false);     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r6) == null) goto L19;
        setVisibility(8);
        return;
    L19:
        return;
    L8:
        setVisibility(8);     // Catch: Throwable -> L11
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public ECOtherAtmosphereView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new ECOtherAtmosphereView$elementView$2(r2));
        this.d = LazyKt.lazy(new ECOtherAtmosphereView$strokeWidth$2(r2));
        this.e = LazyKt.lazy(ECOtherAtmosphereView$path$2.INSTANCE);
        this.f = LazyKt.lazy(ECOtherAtmosphereView$solidPaint$2.INSTANCE);
        this.g = LazyKt.lazy(new ECOtherAtmosphereView$borderPaint$2(this));
        this.h = LazyKt.lazy(new ECOtherAtmosphereView$defaultBgColors$2(r2));
        this.i = LazyKt.lazy(new ECOtherAtmosphereView$defaultBorderColors$2(r2));
        setWillNotDraw(false);
        addView(getElementView());
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if (r5 == null) goto L5;
        r5.width = -1;
        r5.height = -2;
    L6:
        setLayoutParams(r5);
        return;
    L5:
        r5 = new FrameLayout.LayoutParams(-1, -2);
        goto L6
    }

    public /* synthetic */ ECOtherAtmosphereView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
