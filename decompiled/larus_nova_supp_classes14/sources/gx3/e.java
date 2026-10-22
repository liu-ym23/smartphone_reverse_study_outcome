package gx3;

import android.text.TextUtils;
import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends a {
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
    L17:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.c()) == true) goto L17;
        CRC32 r1 = new CRC32();
        r1.update(r8.c().getBytes());
        if ((r1.getValue() % DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS) >= this.a) goto L18;
        return false;
    L18:
        return true;
    }

    public e(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }
}
