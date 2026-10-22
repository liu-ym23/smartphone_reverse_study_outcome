package gx3;

import android.text.TextUtils;
import hx3.c;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends a {
    @Override // gx3.a
    public final boolean c(b r6) {
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r6 != null) goto L10;
        return false;
    L10:
        String r1 = r6.d();
        if (TextUtils.isEmpty(r1) == false) goto L13;
        return false;
    L13:
        String r3 = r6.a();
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return false;
    L16:
        String r7 = r6.b();
        if (TextUtils.isEmpty(r7) == false) goto L20;
        return false;
    L20:
        return !c.a(r1 + ":" + r7 + "_" + r3, this.a);
    }

    public i(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }
}
