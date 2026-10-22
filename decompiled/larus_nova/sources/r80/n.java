package r80;

import android.content.Context;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements com.bytedance.android.live.core.utils.screen.a {
    public n() {
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r100) {
        if (SystemPropertiesUtil.getInt("ro.miui.notch", 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }
}
