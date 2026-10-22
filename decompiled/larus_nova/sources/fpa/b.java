package fpa;

import com.bytedance.common.utility.CommonHttpException;
import com.privacy.azerothprivacy.exception.AzerothException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static Map<String, String> a(Throwable r100) {
        Map<String, String> r101 = null;
        boolean r102 = false;
    L3:
        if (r100 == null) goto L17;
        if ((r100 instanceof AzerothException) == false) goto L16;
        if (r101 != null) goto L8;
        r101 = ((AzerothException) r100).getDebugData();
        goto L16
    L8:
        if (r102 == true) goto L10;
        r101 = new HashMap(r101);
        r102 = true;
    L10:
        Iterator<Map.Entry<String, String>> r103 = ((AzerothException) r100).getDebugData().entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, String> r104 = r103.next();
        if (r101.get(r104.getKey()) != null) goto L12;
        r101.put(r104.getKey(), r104.getValue());
    L16:
        r100 = r100.getCause();
        goto L3
    L17:
        return r101;
    }

    public static boolean b(Throwable r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof CommonHttpException) == false) goto L10;
        return true;
    L10:
        return b(r100.getCause());
    }
}
