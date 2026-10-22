package rg2;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import vl2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public final Map<String, LottieComposition> a;

    public g() {
        this.a = new WeakHashMap();
    }

    public final void a(m r3, LottieAnimationView r4, boolean r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.b != null) goto L6;
        return;
    L6:
        if (r3.c == null) goto L26;
        if (r4 == null) goto L27;
        UIUtils.setViewVisibility(r4, 0);
        r4.cancelAnimation();
        r4.setProgress(0.0f);
        HashMap<String, Bitmap> r0 = r3.d;
        if (r0 == null) goto L13;
        r4.setImageAssetDelegate(new f(r0));
    L13:
        Map<String, LottieComposition> r1 = this.a;
        WeakHashMap r2 = (WeakHashMap) r1;
        LottieComposition r6 = (LottieComposition) r2.get(r3.b);
        if (r6 != null) goto L16;
        d r7 = (d) a.a(d.class);     // Catch: Exception -> L20
        r4.getContext();     // Catch: Exception -> L20
        r7.b();     // Catch: Exception -> L20
    L21:
        return;
    L16:
        r4.setComposition(r6);     // Catch: Exception -> L20
        if (r5 == false) goto L21;
        r4.playAnimation();     // Catch: Exception -> L20
    L28:
        return;
    L27:
        return;
    }
}
