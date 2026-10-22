package r80;

import android.content.Context;
import com.bytedance.common.utility.reflect.Reflect;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements com.bytedance.android.live.core.utils.screen.a {
    public m() {
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r100) {
        return ((Boolean) Reflect.on("android.util.FtFeature").call("isFeatureSupport", new Class[]{Integer.class}, new Object[]{32}).get()).booleanValue();
    L8:
        return false;
    }
}
