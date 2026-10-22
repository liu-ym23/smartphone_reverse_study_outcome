package gx3;

import android.text.TextUtils;
import hx3.c;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends a {
    @Override // gx3.a
    public final boolean c(b r5) {
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r5 != null) goto L10;
    L16:
        return false;
    L10:
        if (TextUtils.isEmpty(r5.d()) == true) goto L16;
        if (TextUtils.isEmpty(r5.c()) == true) goto L16;
        return !c.a(r5.d() + ":" + r5.c(), this.a);
    }

    public h(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }
}
