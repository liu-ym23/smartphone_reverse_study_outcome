package gx3;

import android.text.TextUtils;
import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends a {
    @Override // gx3.a
    public final boolean c(b r8) {
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r8 != null) goto L10;
    L18:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.c()) == true) goto L18;
        if ((CastLongProtector.parseLong(r8.c()) % DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS) >= this.a) goto L22;
        return false;
    L22:
        return true;
    }

    public f(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }
}
