package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$Api17Impl {
    private AppCompatDelegateImpl$Api17Impl() {
    }

    public static Context createConfigurationContext(Context r0, Configuration r1) {
        Context r2 = r0.createConfigurationContext(r1);
        NewMiraResourcesManager.getInstance().install(r2);
        return r2;
    }

    public static void generateConfigDelta_densityDpi(Configuration r0, Configuration r1, Configuration r2) {
        int r3 = r0.densityDpi;
        int r4 = r1.densityDpi;
        if (r3 == r4) goto L6;
        r2.densityDpi = r4;
        return;
    }
}
