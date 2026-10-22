package oh2;

import android.os.Build;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(ECStrokedWaveDraweeView r1, float r2, float r3, int[] r4, float[] r5) {
        Intrinsics.checkNotNullParameter(r1, "$this$setGradientBorder");
        Intrinsics.checkNotNullParameter(r4, "borderColors");
        Intrinsics.checkNotNullParameter(r5, "borderPositions");
        f r0 = new f(r2, r3, r4, r5);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r1.setForeground(r0);
        return;
    }
}
