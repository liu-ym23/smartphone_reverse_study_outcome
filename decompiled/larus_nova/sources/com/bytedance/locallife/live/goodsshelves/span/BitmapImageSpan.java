package com.bytedance.locallife.live.goodsshelves.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.bytedance.locallife.live.util.j0;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class BitmapImageSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorPoint f259871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rv6.b f259872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f259873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f259874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f259875e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/span/BitmapImageSpan$AnchorPoint;", "", "CENTER", "LINE_BOTTOM", "TOP", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum AnchorPoint extends Enum<AnchorPoint> {
        public static final AnchorPoint CENTER = null;
        public static final AnchorPoint LINE_BOTTOM = null;
        public static final AnchorPoint TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorPoint[] f259876a = null;

        public static AnchorPoint valueOf(String r100) {
            return (AnchorPoint) r27.a.a(AnchorPoint.class, r100);
        }

        public static AnchorPoint[] values() {
            return (AnchorPoint[]) f259876a.clone();
        }

        static {
            AnchorPoint r100 = new AnchorPoint("CENTER", 0);
            CENTER = r100;
            AnchorPoint r101 = new AnchorPoint("LINE_BOTTOM", 1);
            LINE_BOTTOM = r101;
            AnchorPoint r102 = new AnchorPoint("TOP", 2);
            TOP = r102;
            f259876a = new AnchorPoint[]{r100, r101, r102};
        }

        public AnchorPoint(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static AnchorPoint a(String r100) {
            if (r100 == null) goto L23;
            int r101 = r100.hashCode();
            if (r101 == (-1383228885)) goto L19;
            if (r101 == (-1364013995)) goto L15;
            if (r101 != 115029) goto L23;
            if (r100.equals("top") == false) goto L23;
            return AnchorPoint.TOP;
        L15:
            if (r100.equals("center") == false) goto L23;
            return AnchorPoint.CENTER;
        L19:
            if (r100.equals("bottom") == false) goto L23;
            return AnchorPoint.LINE_BOTTOM;
        L23:
            return AnchorPoint.CENTER;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f259877a = null;

        static {
            int[] r100 = new int[AnchorPoint.values().length];
            r100[AnchorPoint.LINE_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnchorPoint.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnchorPoint.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f259877a = r100;
        }
    }

    static {
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        return (this.f259872b.getBounds().right + this.f259874d) + this.f259875e;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        int r109 = r100.save();
        int r110 = b.f259877a[this.f259871a.ordinal()];
        if (r110 != 1) goto L5;
    L12:
        r100.translate(r104 + this.f259875e, ((r107 - this.f259872b.getBounds().bottom) + this.f259873c) * 1.0f);
        this.f259872b.draw(r100);
        r100.restoreToCount(r109);
        return;
    L5:
        if (r110 != 2) goto L7;
        r107 = ((r107 - r105) + this.f259872b.getBounds().bottom) / 2;
        goto L12
    L7:
        if (r110 != 3) goto L10;
        r107 = this.f259872b.getBounds().bottom;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public BitmapImageSpan(Context r100, Bitmap r101, int r102, int r103, Float r104, Float r105, Float r106, Float r107, boolean r110, AnchorPoint r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r111, "anchorPoint");
        this.f259871a = r111;
        if (r104 == null) goto L5;
        int r108 = (int) j0.b(r104.floatValue());
    L6:
        this.f259873c = r108;
        if (r106 == null) goto L9;
        int r109 = (int) j0.b(r106.floatValue());
    L10:
        this.f259874d = r109;
        if (r105 == null) goto L13;
        int r112 = (int) j0.b(r105.floatValue());
    L14:
        this.f259875e = r112;
        if (r107 == null) goto L17;
        float r113 = j0.b(r107.floatValue());
    L18:
        int r114 = rv6.c.f539503a;
        Resources r115 = r100.getResources();
        Intrinsics.checkNotNullParameter(r115, "res");
        rv6.b r116 = new rv6.b(r115, r101);
        boolean r117 = true;
        if (r116.f539497g != r113) goto L21;
        boolean r118 = true;
    L22:
        if (r118 == true) goto L32;
        int r119 = rv6.a.f539490m;
        if (r113 <= 0.05f) goto L27;
        boolean r120 = true;
    L28:
        if (r120 == false) goto L30;
        r116.f539494d.setShader(r116.f539495e);
    L31:
        r116.f539497g = r113;
        r116.invalidateSelf();
        goto L32
    L30:
        r116.f539494d.setShader(null);
        goto L31
    L27:
        r120 = false;
    L32:
        this.f259872b = r116;
        if (r102 > 0) goto L35;
        r102 = r101.getWidth();
    L35:
        if (r103 > 0) goto L37;
        r103 = r101.getHeight();
    L37:
        if (r110 == false) goto L62;
        int r121 = r101.getWidth();
        int r122 = r101.getHeight();
        float r123 = 1.0f;
        if (r102 <= 0) goto L41;
        float r124 = r121 / r102;
    L42:
        if (r103 <= 0) goto L44;
        r123 = r122 / r103;
    L44:
        float r125 = Math.max(r124, r123);
        if (r121 > 0) goto L47;
    L52:
        int r126 = 0;
    L53:
        if (r122 > 0) goto L55;
    L60:
        int r127 = 0;
    L61:
        r116.setBounds(0, 0, r126, r127);
        return;
    L55:
        if (r125 == 0.0f) goto L58;
        r117 = false;
    L58:
        if (r117 == true) goto L60;
        r127 = (int) (r122 / r125);
        goto L61
    L47:
        if (r125 != 0.0f) goto L49;
        boolean r128 = true;
    L50:
        if (r128 == true) goto L52;
        r126 = (int) (r121 / r125);
        goto L53
    L49:
        r128 = false;
        goto L50
    L41:
        r124 = 1.0f;
        goto L42
    L62:
        r116.setBounds(0, 0, r102, r103);
        return;
    L21:
        r118 = false;
        goto L22
    L17:
        r113 = 0.0f;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r108 = 0;
        goto L6
    }
}
