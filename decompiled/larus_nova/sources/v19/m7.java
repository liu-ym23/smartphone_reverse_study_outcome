package v19;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m7 {
    public static final void a(Window r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        WindowCompat.setDecorFitsSystemWindows(r100, false);
        r100.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r100.addFlags(Integer.MIN_VALUE);
        r100.setNavigationBarColor(0);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 28) goto L11;
        r100.setNavigationBarDividerColor(0);
    L11:
        if (r103 < 29) goto L13;
        r100.setNavigationBarContrastEnforced(false);
    L13:
        r101.setSystemUiVisibility((r101.getSystemUiVisibility() | 512) | 256);
        View r104 = r101.findViewById(R.id.container);
        if (r104 != null) goto L16;
        return;
    L16:
        ViewCompat.setOnApplyWindowInsetsListener(r104, new l7());
        ViewCompat.requestApplyInsets(r104);
    }
}
