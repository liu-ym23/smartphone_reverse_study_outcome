package wqa;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static void a(int r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        switch(r100) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L7;
            default: goto L17;
        };
    L7:
        Logger.e(r101, r102);
        return;
    L8:
        Logger.w(r101, r102);
        return;
    L9:
        Logger.i(r101, r102);
        return;
    L10:
        Logger.d(r101, r102);
        return;
    L11:
        Logger.v(r101, r102);
        return;
    }
}
