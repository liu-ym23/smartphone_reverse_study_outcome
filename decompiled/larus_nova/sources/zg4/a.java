package zg4;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f572043b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f572044a;

    public static String a() {
        if (f572043b != null) goto L5;
        f572043b = new a();
    L5:
        Object r100 = ((HashMap) f572043b.f572044a).get("release_build");
        if (r100 == null) goto L10;
        String r101 = String.valueOf(r100);
        if (r101.length() < 16) goto L12;
        return r101;
    L12:
        return "invalid";
    L10:
        return "invalid";
    }

    public a() {
        this.f572044a = new HashMap();
        Context r100 = com.bytedance.crash.i.getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        Properties r101 = new Properties();
        r101.load(r100.getAssets().open("slardar.properties"));     // Catch: Exception -> L12
        Iterator r102 = r101.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r102.hasNext() == false) goto L17;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Exception -> L12
        this.f572044a.put(String.valueOf(r103.getKey()), r103.getValue());     // Catch: Exception -> L12
    L17:
        return;
    }
}
