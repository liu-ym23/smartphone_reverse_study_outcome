package n82;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends ScalingUtils.AbstractScaleType {
    public d() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
    public final void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
        if (r101 != null) goto L4;
        return;
    L4:
        float r108 = r101.left;
        float r109 = r101.top;
        if (r100 == null) goto L7;
        r100.setScale(r107, r107);
    L7:
        if (r100 == null) goto L10;
        r100.postTranslate((int) (r108 + 0.5f), (int) (r109 + 0.5f));
        return;
    }
}
