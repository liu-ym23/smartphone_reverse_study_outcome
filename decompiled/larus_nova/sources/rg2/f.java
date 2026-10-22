package rg2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.airbnb.lottie.h;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements com.airbnb.lottie.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f537689a;

    public f(HashMap r100) {
        this.f537689a = r100;
    }

    @Override // com.airbnb.lottie.d
    public final Bitmap q(h r100) {
        String r101 = r100.f24781d;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (this.f537689a.containsKey(r101) == false) goto L16;
        Bitmap r102 = (Bitmap) this.f537689a.get(r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.isRecycled() == true) goto L17;
        return r102;
    L17:
        return null;
    L16:
        return null;
    }
}
