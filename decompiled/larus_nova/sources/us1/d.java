package us1;

import com.bytedance.android.livesdk.config.cj1;
import com.bytedance.android.livesdk.config.xi1;
import com.bytedance.android.livesdk.utils.z0;

/* JADX INFO: loaded from: classes8.dex */
public final class d {
    public static boolean a() {
        float r100 = z0.b(false);
        if (r100 > 0.0f) goto L5;
        return true;
    L5:
        if (r100 >= xi1.f121608a.getValue().floatValue()) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean b(boolean r100, boolean r101) {
        if (r100 == false) goto L4;
        return r101;
    L4:
        if (r101 == true) goto L6;
    L8:
        return false;
    L6:
        if (cj1.f119958a.getValue().intValue() != 2) goto L8;
        return true;
    }
}
