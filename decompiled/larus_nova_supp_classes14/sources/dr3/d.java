package dr3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.y;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends e<fr3.a.f, fr3.a.e, GenericDraweeView> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // dr3.e
    public final View b(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        SimpleDraweeView r0 = new SimpleDraweeView(r7);
        GenericDraweeHierarchy r8 = r0.getHierarchy();
        float[] r1 = ((fr3.a.e) this.b).d.a();
        ArrayList r2 = new ArrayList(8);
        int r4 = 0;
    L3:
        if (r4 >= 8) goto L5;
        r2.add(Float.valueOf(q.a(Float.valueOf(r1[r4]))));
        r4 = r4 + 1;
        goto L3
    L5:
        r8.setRoundingParams(RoundingParams.fromCornersRadii(CollectionsKt.toFloatArray(r2)));
        r0.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        y.a(r0, ((fr3.a.f) ((fr3.a.e) this.b).e).a);
        return r0;
    }

    public d(List<? extends er3.d> r2, fr3.a.e r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "imageConfig");
        super(r2, r3);
    }
}
