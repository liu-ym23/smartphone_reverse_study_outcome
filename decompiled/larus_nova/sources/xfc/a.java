package xfc;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static int a(Intent r100, String r101) {
        Bundle r102 = r100.getExtras();
        if (r102 != null) goto L5;
        return 0;
    L5:
        Object r103 = r102.get(r101);
        if (r103 != null) goto L9;
        return 0;
    L9:
        if ((r103 instanceof String) == true) goto L18;
        return ((Integer) r103).intValue();
    L15:
        return 0;
    L18:
        return CastIntegerProtector.parseInt((String) r103);
    L12:
        return 0;
    }
}
