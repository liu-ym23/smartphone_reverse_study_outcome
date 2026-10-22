package rg2;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import vl2.m;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, LottieComposition> f537690a;

    public g() {
        this.f537690a = new WeakHashMap();
    }

    public final void a(m r100, LottieAnimationView r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f555667b != null) goto L6;
        return;
    L6:
        if (r100.f555668c == null) goto L26;
        if (r101 == null) goto L27;
        UIUtils.setViewVisibility(r101, 0);
        r101.cancelAnimation();
        r101.setProgress(0.0f);
        HashMap<String, Bitmap> r103 = r100.f555669d;
        if (r103 == null) goto L13;
        r101.setImageAssetDelegate(new f(r103));
    L13:
        Map<String, LottieComposition> r104 = this.f537690a;
        WeakHashMap r105 = (WeakHashMap) r104;
        LottieComposition r106 = (LottieComposition) r105.get(r100.f555667b);
        if (r106 != null) goto L16;
        d r107 = (d) a.a(d.class);     // Catch: Exception -> L20
        r101.getContext();     // Catch: Exception -> L20
        r107.b();     // Catch: Exception -> L20
    L21:
        return;
    L16:
        r101.setComposition(r106);     // Catch: Exception -> L20
        if (r102 == false) goto L21;
        r101.playAnimation();     // Catch: Exception -> L20
    L28:
        return;
    L27:
        return;
    }
}
