package ib5;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d implements dw4.a.InterfaceC0214a {
    public /* synthetic */ d() {
    }

    public final Context a(Context r6) {
        i0 r0 = (i0) org.koin.java.a.a(i0.class);
        if (r0 == null) goto L5;
        Locale r1 = r0.c();
    L6:
        if (r1 == null) goto L12;
        int r2 = eu5.d.a;
        Configuration r3 = r6.getResources().getConfiguration();
        int r4 = Build.VERSION.SDK_INT;
        r3.setLocale(r1);
        Resources r5 = r6.getResources();
        Resources r7 = r6.getResources();
        r5.updateConfiguration(r3, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()));
        if (r4 < 24) goto L11;
        r6 = r6.createConfigurationContext(r3);
        NewMiraResourcesManager.getInstance().install(r6);
    L11:
        return new eu5.d(r6);
    L12:
        return r6;
    L5:
        r1 = null;
        goto L6
    }
}
