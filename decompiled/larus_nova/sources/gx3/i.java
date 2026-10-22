package gx3;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends a {
    @Override // gx3.a
    public final boolean c(b r100) {
        int r101 = a();
        if (r101 >= 0) goto L6;
        return true;
    L6:
        if (r101 <= 0) goto L8;
        return false;
    L8:
        if (r100 != null) goto L10;
        return false;
    L10:
        String r102 = r100.d();
        if (TextUtils.isEmpty(r102) == false) goto L13;
        return false;
    L13:
        String r103 = r100.a();
        if (TextUtils.isEmpty(r103) == false) goto L16;
        return false;
    L16:
        String r104 = r100.b();
        if (TextUtils.isEmpty(r104) == false) goto L20;
        return false;
    L20:
        return !hx3.c.a(r102 + ":" + r104 + "_" + r103, this.f483091a);
    }

    public i(int r100, Set<String> r101, Map<String, List<Set<String>>> r102, Map<String, List<Map<String, Object>>> r103) {
        super(r100, r101, r102, r103);
    }
}
