package o7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522251a = 0;

    static {
    }

    public static void b(Context r100) {
        new Handler(Looper.getMainLooper()).post(new j(r100));
    }

    public static Map a(String r100, String r101) {
        if (r100 == null) goto L7;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).getHeaderMap(r100));
        Iterator r103 = ((CopyOnWriteArrayList) p9.a.f528282c).iterator();
    L5:
        if (r103.hasNext() == false) goto L8;
        r102.putAll(((p9.d) r103.next()).a(r100));
    L8:
        if (r101 != null) goto L10;
    L24:
        return r102;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return r102;
    L12:
        JSONObject r104 = new JSONObject(r101);
        Iterator<String> r105 = r104.keys();
    L13:
        if (r105 == null) goto L24;
        if (r105.hasNext() == false) goto L24;
        String r106 = r105.next();     // Catch: Exception -> L23
        String r107 = r104.optString(r106);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r106) == true) goto L13;
        if (TextUtils.isEmpty(r107) == true) goto L13;
        r102.put(r106, r107);     // Catch: Exception -> L23
        goto L13
    L7:
        r102 = new LinkedHashMap();
        goto L8
    }
}
