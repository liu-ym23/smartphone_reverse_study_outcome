package gx3;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends a {
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
    L18:
        return false;
    L10:
        if (TextUtils.isEmpty(r100.c()) == true) goto L18;
        if ((CastLongProtector.parseLong(r100.c()) % 10000) >= this.f483091a) goto L22;
        return false;
    L22:
        return true;
    }

    public f(int r100, Set<String> r101, Map<String, List<Set<String>>> r102, Map<String, List<Map<String, Object>>> r103) {
        super(r100, r101, r102, r103);
    }
}
