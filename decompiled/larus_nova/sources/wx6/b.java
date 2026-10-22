package wx6;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561837a = 0;

    static {
    }

    public static String a(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "rawDatas");
        JsonObject r101 = new JsonObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        String r104 = r100[r103];
        if (TextUtils.isEmpty(r104) == true) goto L11;
        JsonObject r105 = new JsonParser().parse(r104).getAsJsonObject();     // Catch: Exception -> L14
        Iterator<T> r106 = r105.keySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r106.hasNext() == false) goto L11;
        String r107 = (String) r106.next();     // Catch: Exception -> L14
        r101.add(r107, r105.get(r107));     // Catch: Exception -> L14
    L11:
        r103 = r103 + 1;
        goto L3
    L13:
        return r101.toString();
    }
}
