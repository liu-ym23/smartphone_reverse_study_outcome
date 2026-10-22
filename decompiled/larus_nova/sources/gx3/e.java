package gx3;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends a {
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
    L17:
        return false;
    L10:
        if (TextUtils.isEmpty(r100.c()) == true) goto L17;
        CRC32 r102 = new CRC32();
        r102.update(r100.c().getBytes());
        if ((r102.getValue() % 10000) >= this.f483091a) goto L18;
        return false;
    L18:
        return true;
    }

    public e(int r100, Set<String> r101, Map<String, List<Set<String>>> r102, Map<String, List<Map<String, Object>>> r103) {
        super(r100, r101, r102, r103);
    }
}
