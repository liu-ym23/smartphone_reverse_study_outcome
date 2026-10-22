package com.ss.android.lark.insets;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends h {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<Integer, WeakReference<j>> f427749r = null;

    public static final class a {
        public static void a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            r101.setSystemUiVisibility(1280);
            r100.addFlags(Integer.MIN_VALUE);
            r100.setStatusBarColor(0);
            r100.addFlags(-2147483392);
            WindowManager.LayoutParams r103 = r100.getAttributes();
            if (r103 == null) goto L18;
            int r104 = Build.VERSION.SDK_INT;
            if (r104 < 28) goto L15;
            WindowManager.LayoutParams r105 = r100.getAttributes();
            if (r105 == null) goto L15;
            r105.layoutInDisplayCutoutMode = 1;
        L15:
            if (r104 < 30) goto L19;
            r103.setFitInsetsTypes(r103.getFitInsetsTypes() & (~WindowInsetsCompat.Type.systemBars()));
            return;
        L19:
            return;
        }
    }

    static {
        f427749r = new LinkedHashMap();
    }
}
