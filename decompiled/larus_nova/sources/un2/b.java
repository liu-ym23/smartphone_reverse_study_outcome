package un2;

import android.os.Build;
import android.os.Debug;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public static long a(String r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return 0;
    L8:
        return CastLongProtector.parseLong(Debug.getRuntimeStat(r100));
    L5:
        r101 = false;
        goto L6
    }
}
