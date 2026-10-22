package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.r;
import com.bytedance.android.shopping.utils.PdpPerfUtils;
import com.bytedance.android.shopping.utils.d0;
import com.bytedance.android.shopping.utils.y;
import com.facebook.common.references.CloseableReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BgDecorLayer {
    public static final Rect k = null;
    public static final Rect l = null;
    public static final Lazy m = null;
    public HeaderContentModel a;
    public Integer b;
    public Bitmap c;
    public Bitmap d;
    public float e;
    public CloseableReference<Bitmap> f;
    public final s g;
    public final View h;
    public final boolean i;
    public final boolean j;

    public static final class a {
    }

    static {
        k = new Rect();
        l = new Rect();
        m = LazyKt.lazy(BgDecorLayer$Companion$headerDefaultPaint$2.INSTANCE);
    }

    public final boolean e() {
        HeaderContentModel r0 = this.a;
        r r1 = null;
        if (r0 == null) goto L7;
        HeaderMediaModel r2 = r0.getMedia();
        if (r2 == null) goto L7;
        VideoModel r3 = r2.getVideo();
    L9:
        if (r3 == null) goto L11;
        return true;
    L11:
        if (this.g.W4() != 1) goto L17;
        Integer r4 = this.b;
        if (r4 == null) goto L17;
        if (r4.intValue() != 0) goto L17;
        return true;
    L17:
        HeaderContentModel r5 = this.a;
        if (r5 == null) goto L20;
        r1 = r5.getMultiPreview();
    L20:
        if (r1 == null) goto L22;
        return true;
    L22:
        if (this.i == true) goto L29;
        return false;
    L29:
        return true;
    L7:
        r3 = null;
        goto L9
    }

    public final Bitmap c(Bitmap r10) {
        int r0 = k83.b.a;
        int r4 = k83.b.b(this.g);
        int r3 = this.h.getWidth();
        int r1 = (int) ((r10.getWidth() * r4) / r3);
        Bitmap r8 = Bitmap.createBitmap(r3, r4, Bitmap.Config.RGB_565);
        Canvas r2 = new Canvas(r8);
        r2.scale(1.0f, -1.0f);
        r2.translate(0.0f, -r4);
        Rect r5 = k;
        r5.set(0, r10.getHeight() - r1, r10.getWidth(), r10.getHeight());
        Rect r6 = l;
        r6.set(0, 0, r3, r4);
        r2.drawBitmap(r10, r5, r6, null);
        Bitmap r11 = b(this, r8, r3, r4, 0.0f, null, 56);
        if (r11 != null) goto L6;
        return r8;
    L6:
        return r11;
    }

    public final Bitmap d(Bitmap r10) {
        int r0 = k83.b.a;
        int r1 = (int) (k83.b.b(this.g) / 4.0f);
        int r2 = (int) (this.h.getWidth() / 4.0f);
        int r3 = (int) ((r10.getWidth() * r1) / r2);
        Bitmap r4 = Bitmap.createBitmap(r2, r1, Bitmap.Config.RGB_565);
        Canvas r5 = new Canvas(r4);
        r5.scale(1.0f, -1.0f);
        r5.translate(0.0f, -r1);
        Rect r6 = k;
        r6.set(0, r10.getHeight() - r3, r10.getWidth(), r10.getHeight());
        Rect r7 = l;
        r7.set(0, 0, r2, r1);
        r5.drawBitmap(r10, r6, r7, null);
        return r4;
    }

    public final void f(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        if (this.h.getWidth() > 0) goto L5;
        return;
    L5:
        HeaderContentModel r0 = this.a;
        boolean r1 = true;
        if (r0 == null) goto L12;
        HeaderMediaModel r2 = r0.getMedia();
        if (r2 == null) goto L12;
        if (r2.getDisableNavDecor() != true) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return;
    L15:
        CloseableReference<Bitmap> r4 = this.f;
        ViewGroup.LayoutParams r5 = null;
        if (r4 == null) goto L18;
        Bitmap r6 = (Bitmap) r4.get();
    L19:
        if (r6 != null) goto L21;
    L50:
        CloseableReference<Bitmap> r7 = this.f;
        if (r7 == null) goto L53;
        r7.close();
    L53:
        this.f = null;
        if (this.j == false) goto L57;
    L69:
        r1 = false;
    L70:
        if (r1 == true) goto L80;
        Rect r8 = l;
        int r9 = -d0.a();
        ViewGroup.LayoutParams r10 = this.h.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L75;
        r5 = r10;
    L75:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r5;
        if (r11 == null) goto L78;
        int r12 = r11.topMargin;
    L79:
        int r14 = r9 - r12;
        int r15 = this.h.getWidth();
        int r16 = this.h.getHeight();
        int r17 = k83.b.a;
        r8.set(0, r14, r15, r16 + k83.b.b(this.g));
        r13.drawRect(r8, (Paint) m.getValue());
        return;
    L78:
        r12 = 0;
        goto L79
    L80:
        Bitmap r18 = this.d;
        if (r18 == null) goto L84;
        Rect r19 = k;
        r19.set(0, 0, r18.getWidth(), r18.getHeight());
        Rect r20 = l;
        int r21 = this.h.getHeight();
        int r22 = this.h.getWidth();
        int r23 = this.h.getHeight();
        int r24 = k83.b.a;
        r20.set(0, r21, r22, r23 + k83.b.b(this.g));
        r13.drawBitmap(r18, r19, r20, null);
    L84:
        r13.save();
        r13.translate(0.0f, this.e);
        if (e() == false) goto L96;
        Bitmap r25 = this.c;
        if (r25 == null) goto L99;
        Rect r26 = k;
        r26.set(0, 0, r25.getWidth(), r25.getHeight());
        Rect r27 = l;
        int r28 = -d0.a();
        ViewGroup.LayoutParams r29 = this.h.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == true) goto L91;
        r29 = null;
    L91:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
        if (r30 == null) goto L94;
        int r31 = r30.topMargin;
    L95:
        int r32 = r28 - r31;
        int r33 = this.h.getWidth();
        int r34 = this.h.getHeight();
        int r35 = k83.b.a;
        r27.set(0, r32, r33, r34 + k83.b.b(this.g));
        r13.drawBitmap(r25, r26, r27, null);
        goto L99
    L94:
        r31 = 0;
    L99:
        r13.restore();
        return;
    L96:
        Bitmap r36 = this.c;
        if (r36 == null) goto L99;
        Rect r37 = k;
        r37.set(0, 0, r36.getWidth(), r36.getHeight());
        Rect r38 = l;
        r38.set(0, -d0.a(), this.h.getWidth(), 0);
        r13.drawBitmap(r36, r37, r38, null);
        goto L99
    L57:
        if (this.i == true) goto L70;
        HeaderContentModel r39 = this.a;
        if (r39 == null) goto L61;
        r r40 = r39.getMultiPreview();
    L62:
        if (r40 != null) goto L70;
        HeaderContentModel r41 = this.a;
        if (r41 == null) goto L66;
        HeaderMediaModel r42 = r41.getMedia();
    L67:
        if (r42 == null) goto L69;
    L66:
        r42 = null;
        goto L67
    L61:
        r40 = null;
        goto L62
    L21:
        if ((!r6.isRecycled()) == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L50;
        if (e() == false) goto L35;
        int r43 = this.h.getWidth();
        int r44 = this.h.getHeight() + d0.a();
        int r45 = k83.b.a;
        int r46 = r44 + k83.b.b(this.g);
        ViewGroup.LayoutParams r47 = this.h.getLayoutParams();
        if ((r47 instanceof ViewGroup.MarginLayoutParams) == true) goto L30;
        r47 = null;
    L30:
        ViewGroup.MarginLayoutParams r48 = (ViewGroup.MarginLayoutParams) r47;
        if (r48 == null) goto L33;
        int r49 = r48.topMargin;
    L34:
        this.c = b(this, r6, r43, r46 + r49, 1.0f, 1728053247, 32);
    L36:
        AnchorV4HeadV2VO r50 = this.g.K10();
        if (r50 == null) goto L45;
        if (r50.getEnableBottomFillBlur() != true) goto L45;
        this.d = c(r6);     // Catch: Exception -> L42
    L42:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L45:
        if (e() == true) goto L50;
        this.d = d(r6);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L50
    L33:
        r49 = 0;
        goto L34
    L35:
        this.c = a(r6, k1.m(this.g.getContext()), d0.a(), 1.0f, 1728053247, new com.bytedance.android.shopping.anchorv4.voavhs.blur.d(0, 0, 0, r6.getHeight() - d0.a()));
        goto L36
    L18:
        r6 = null;
    L12:
        r3 = false;
        goto L13
    }

    public BgDecorLayer(s r3, View r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        Intrinsics.checkNotNullParameter(r4, "hostView");
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        r3.eh().x(new b(this));
    }

    public static Bitmap g(Bitmap r7, int r8, int r9, float r10, com.bytedance.android.shopping.anchorv4.voavhs.blur.d r11, Integer r12) {
        int r13 = RangesKt.coerceAtLeast(1, (int) (r8 / 8.0f));
        int r14 = RangesKt.coerceAtLeast(1, (int) (r9 / 8.0f));
        int r0 = y.a;
        Intrinsics.checkNotNullParameter(r7, "bitmap");
        Bitmap r1 = Bitmap.createBitmap(r13, r14, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        Rect r3 = new Rect(0, 0, r7.getWidth(), r7.getHeight());
        float r4 = 1;
        if (r10 < r4) goto L5;
    L7:
        if (r11 == null) goto L9;
        r3.left += r11.a;
        r3.top += r11.b;
        r3.right -= r11.c;
        r3.bottom -= r11.d;
    L9:
        Unit r15 = Unit.INSTANCE;
        r2.drawBitmap(r7, r3, new Rect(0, 0, r13, r14), null);
        if (r12 == null) goto L12;
        r2.drawColor(r12.intValue());
    L12:
        PdpPerfUtils.INSTANCE.stackBlurBitmap(r1, 8);
        return r1;
    L5:
        if (r10 <= 0) goto L7;
        float r5 = r4 - r10;
        float r16 = 2;
        r3.inset((int) ((r7.getWidth() * r5) / r16), (int) ((r7.getHeight() * r5) / r16));
        goto L9
    }

    public final Bitmap a(Bitmap r9, int r10, int r11, float r12, Integer r13, com.bytedance.android.shopping.anchorv4.voavhs.blur.d r14) {
        if (PdpPerfOpt.b().m(2) == true) goto L10;
        return this.g.eL().a(r9, r10, r11, r12, r13, r14);
    L10:
        return g(r9, r10, r11, r12, r14, r13);
    L9:
        return this.g.eL().a(r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Bitmap b(BgDecorLayer r7, Bitmap r8, int r9, int r10, float r11, Integer r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        float r4 = 1.0f;
    L7:
        if ((r13 & 16) == 0) goto L10;
        r12 = null;
    L10:
        return r7.a(r8, r9, r10, r4, r12, null);
    L5:
        r4 = r11;
        goto L7
    }
}
