package zl4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends BitmapDrawable {
    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Resources r100 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(2, 58, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Resources r100 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(2, 36, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    public a(Resources r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        super(r100, r101);
    }
}
