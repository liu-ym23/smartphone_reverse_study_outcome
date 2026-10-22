package ib5;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class d implements dw4.a.InterfaceC5715a {
    public /* synthetic */ d() {
    }

    public final Context a(Context r100) {
        i0 r101 = (i0) org.koin.java.a.a(i0.class);
        if (r101 == null) goto L5;
        Locale r102 = r101.c();
    L6:
        if (r102 == null) goto L12;
        int r103 = eu5.d.f474076a;
        Configuration r104 = r100.getResources().getConfiguration();
        int r105 = Build.VERSION.SDK_INT;
        r104.setLocale(r102);
        Resources r106 = r100.getResources();
        Resources r107 = r100.getResources();
        r106.updateConfiguration(r104, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()));
        if (r105 < 24) goto L11;
        r100 = r100.createConfigurationContext(r104);
        NewMiraResourcesManager.getInstance().install(r100);
    L11:
        return new eu5.d(r100);
    L12:
        return r100;
    L5:
        r102 = null;
        goto L6
    }
}
