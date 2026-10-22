package r80;

import android.content.Context;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements com.bytedance.android.live.core.utils.screen.a {
    public g() {
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r100) {
        return r100.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
