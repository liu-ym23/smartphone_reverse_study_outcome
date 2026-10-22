package ppc;

import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class h {
    public static final ImageView c(g r100) {
        ImageView r101 = new ImageView(r100.getActivity());
        r101.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r101.setAdjustViewBounds(true);
        r101.setContentDescription(null);
        GradientDrawable r102 = new GradientDrawable();
        r102.setColor(0);
        r102.setCornerRadius(y9c.d.a(12));
        r101.setBackground(r102);
        r101.setClipToOutline(true);
        return r101;
    }

    public static final void a(TextView r100, String r101) {
        r100.setText(r101);
        if (StringsKt.isBlank(r101) == false) goto L5;
        int r102 = 8;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static final Size b(int r100, int r101) {
        int r102 = y9c.d.a(120);
        if (r100 <= 0) goto L13;
        if (r101 <= 0) goto L13;
        int r103 = y9c.d.a(220);
        int r104 = y9c.d.a(180);
        float r105 = r100 / r101;
        if (r105 < 1.0f) goto L9;
        Pair r106 = TuplesKt.to(Integer.valueOf(r103), Integer.valueOf((int) (r103 / r105)));
    L11:
        return new Size(RangesKt.coerceIn(((Number) r106.component1()).intValue(), y9c.d.a(80), r103), RangesKt.coerceIn(((Number) r106.component2()).intValue(), y9c.d.a(80), r104));
    L9:
        r106 = TuplesKt.to(Integer.valueOf((int) (r104 * r105)), Integer.valueOf(r104));
    L13:
        return new Size(r102, r102);
    }
}
