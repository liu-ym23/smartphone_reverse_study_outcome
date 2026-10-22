package pb2;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public class a extends lk6.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public jb2.b f528409m;

    public a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100);
    }

    public final void g(ImageStyle r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r102 = com.bytedance.live.richcontent.utils.b.f255804a;
        Intrinsics.checkNotNullParameter(this, "span");
        Intrinsics.checkNotNullParameter(r100, "style");
        Intrinsics.checkNotNullParameter(r100, "style");
        int r103 = r100.f255753b;
        int r104 = r100.f255754c;
        float r105 = r100.f255755d;
        int r106 = com.bytedance.live.richcontent.utils.a.f255803a[r100.f255752a.ordinal()];
        if (r106 != 1) goto L5;
        r104 = r101;
        r103 = r110;
    L26:
        if (r104 <= 0) goto L31;
        if (r103 <= 0) goto L31;
        r110 = r103;
        r101 = r104;
    L31:
        if (r101 <= 0) goto L33;
        if (r110 <= 0) goto L33;
    L34:
        if (r101 <= 0) goto L54;
        if (r110 <= 0) goto L54;
        int r107 = r100.f255756e;
        if (r107 <= 0) goto L39;
    L40:
        float r108 = 1.0f;
        if (r110 <= r107) goto L44;
        if (r107 <= 0) goto L44;
        float r109 = r107 / r110;
    L45:
        int r111 = r100.f255757f;
        if (r101 <= r111) goto L49;
        if (r111 <= 0) goto L49;
        r108 = r111 / r101;
    L49:
        float r112 = RangesKt.coerceAtMost(r109, r108);
        if (r112 <= 0) goto L54;
        if (r112 >= 1) goto L54;
        r101 = (int) (r101 * r112);
        r110 = (int) (r110 * r112);
    L44:
        r109 = 1.0f;
        goto L45
    L39:
        if (r100.f255757f > 0) goto L40;
    L54:
        Pair r113 = new Pair(Integer.valueOf(r101), Integer.valueOf(r110));
        setWidthAndHeight(((Number) r113.component1()).intValue(), ((Number) r113.component2()).intValue());
        int r114 = r100.f255765n;
        int r115 = r100.f255766o;
        this.f509586e = r114;
        this.f509587f = r115;
        this.f509584c = r100.f255763l.getValue();
        this.f509585d = r100.f255764m;
        f(r100.f255771t);
        c(r100.f255772u);
        d(r100.f255769r);
        e(r100.f255770s);
        this.f509588g = r100.f255768q;
        this.f509589h = r100.f255767p;
        return;
    L33:
        r101 = 0;
        r110 = 0;
        goto L34
    L5:
        if (r106 == 2) goto L26;
        if (r106 == 3) goto L23;
        float r116 = 0.0f;
        if (r106 != 4) goto L11;
        float r117 = r103;
        if (r110 == 0) goto L22;
        r116 = r101 / r110;
    L22:
        r104 = (int) (r117 * r116);
        goto L26
    L11:
        if (r106 != 5) goto L17;
        float r118 = r104;
        if (r101 != 0) goto L15;
        r105 = 0.0f;
    L24:
        r103 = (int) (r118 * r105);
        goto L26
    L15:
        r105 = r110 / r101;
        goto L24
    L17:
        throw new NoWhenBranchMatchedException();
    L23:
        r104 = (int) (r101 * r105);
        r118 = r110;
        goto L24
    }

    @Override // lk6.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        int r105 = super.getSize(r100, r101, r102, r103, r104);
        if (r104 == null) goto L5;
        int r106 = b(r100.getFontMetricsInt());
        r104.top = r106;
        r104.ascent = r106;
        int r107 = this.f509583b;
        r104.bottom = r107 + r106;
        r104.descent = r107 + r106;
    L5:
        return r105;
    }
}
