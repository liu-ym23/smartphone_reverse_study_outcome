package i84;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static boolean a(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static List<Pair<String, String>> b(Map<String, List<String>> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L17:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, List<String>>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, List<String>> r103 = r102.next();
        int r104 = 0;
    L11:
        if (r104 >= r103.getValue().size()) goto L8;
        if (TextUtils.isEmpty(r103.getKey()) == true) goto L15;
        r101.add(new Pair(r103.getKey(), ListProtector.get(r103.getValue(), r104)));
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        com.bytedance.bdinstall.t.a("NetUtils#parseHeaders" + r101);
        goto L17
    }
}
