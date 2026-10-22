package ul;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e {
    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$mergeJSONObject");
        Iterator<String> r102 = r101.keys();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.hasNext() == false) goto L21;
        String r103 = r102.next();
        String r104 = r101.optString(r103);
        if (r104.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L5;
        r100.put(r103, r104);
        goto L5
    L9:
        r105 = false;
        goto L10
    }
}
