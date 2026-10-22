package i88;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.larus.nova.R;
import com.larus.utils.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends BasePostprocessor {
    public d() {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void process(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Paint r101 = new Paint();
        int r102 = j0.f375426a;
        r101.setColorFilter(new LightingColorFilter(j0.a(R.color.larus_static_black), 1));
        new Canvas(r100).drawBitmap(r100, 0.0f, 0.0f, r101);
    }
}
