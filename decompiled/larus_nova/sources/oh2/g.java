package oh2;

import android.os.Build;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g {
    public static final void a(ECStrokedWaveDraweeView r100, float r101, float r102, int[] r103, float[] r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$setGradientBorder");
        Intrinsics.checkNotNullParameter(r103, "borderColors");
        Intrinsics.checkNotNullParameter(r104, "borderPositions");
        f r105 = new f(r101, r102, r103, r104);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r100.setForeground(r105);
        return;
    }
}
