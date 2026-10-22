package cy7;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {
    public a() {
    }

    @Override // cy7.b
    public final void intercept(String r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.length() <= 0) goto L6;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        JSONObject r103 = r101;
    L11:
        if (r103 == null) goto L29;
        ArrayList r104 = new ArrayList();
        Iterator<String> r105 = r101.keys();
    L14:
        if (r105.hasNext() == false) goto L18;
        String r106 = r105.next();
        if (StringsKt.startsWith$default(r106, "__track__", false, 2, null) == false) goto L14;
        r104.add(r106);
        goto L14
    L18:
        Iterator r107 = r104.iterator();
    L20:
        if (r107.hasNext() == false) goto L30;
        r101.remove((String) r107.next());
        goto L20
    L30:
        return;
    L29:
        return;
    L10:
        r103 = null;
        goto L11
    L6:
        r102 = false;
        goto L8
    }
}
