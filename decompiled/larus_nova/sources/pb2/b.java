package pb2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends pb2.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Paint f528410u = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f528411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f528412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f528413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f528414q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f528415r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f528416s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f528417t;

    public static final class a {
    }

    static {
        f528410u = new Paint();
    }

    @Override // lk6.c
    public final void a(Canvas r100, CharSequence r101, int r102, int r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r104, "paint");
        super.a(r100, r101, r102, r103, r104);
        Paint r105 = f528410u;
        float r106 = r103;
        r105.setTextSize(this.f528413p * r106);
        r105.setColor(this.f528412o);
        int r107 = (int) r105.measureText(this.f528411n);
        if (this.f528416s == false) goto L5;
        r102 = r102 - r103;
    L5:
        int r108 = RangesKt.coerceAtMost(r107, r102);
        float r109 = ((r103 / 2) + ((r105.getFontMetrics().descent - r105.getFontMetrics().ascent) * this.f528415r)) - r105.getFontMetrics().descent;
        if (this.f528416s == false) goto L10;
        float r110 = ((r102 - r108) * this.f528414q) + r106;
        float r111 = r110 - r106;
        int r112 = this.f528417t;
        if (r111 < r112) goto L11;
        r110 = r110 - r112;
    L11:
        r100.drawText(this.f528411n, r110, r109, r105);
        return;
    L10:
        r110 = (r102 - r108) * this.f528414q;
        goto L11
    }

    public b(Drawable r100, String r101, int r102, float r103, float r104, float r105, boolean r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r101, RXScreenCaptureService.KEY_CONTENT_TEXT);
        super(r100);
        this.f528411n = r101;
        this.f528412o = r102;
        this.f528413p = r103;
        this.f528414q = r104;
        this.f528415r = r105;
        this.f528416s = r106;
        this.f528417t = r107;
        Paint r108 = f528410u;
        r108.setStyle(Paint.Style.FILL_AND_STROKE);
        r108.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    }
}
