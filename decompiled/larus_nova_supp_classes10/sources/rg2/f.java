package rg2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.airbnb.lottie.h;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements com.airbnb.lottie.d {
    public final /* synthetic */ HashMap a;

    public f(HashMap r1) {
        this.a = r1;
    }

    public final Bitmap q(h r2) {
        String r3 = r2.d;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (this.a.containsKey(r3) == false) goto L16;
        Bitmap r4 = (Bitmap) this.a.get(r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        if (r4.isRecycled() == true) goto L17;
        return r4;
    L17:
        return null;
    L16:
        return null;
    }
}
