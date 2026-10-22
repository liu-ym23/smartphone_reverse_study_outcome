package com.ss.android.lark.insets;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class h extends c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f427764q = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f427765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final WindowInsetsControllerCompat f427766p;

    public static final class a {
        public static h a(Window r100) {
            Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
            int r101 = i.f427767a;
            Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
            View r102 = r100.findViewById(R.id.content);
            if (r102 != null) goto L10;
            View r103 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r104 = ThreadMethodProxy.currentThread();
            if (r104 == com.larus.home.impl.utils.c.f346341a) goto L9;
            com.larus.home.impl.utils.c.a(r104, "getDecorView");
        L9:
            r102 = r103.findViewById(R.id.content);
        L10:
            Object r105 = r102.getTag(com.larus.nova.R.id.activity_fit_system_window_handler);
            if ((r105 instanceof h) == false) goto L13;
            h r106 = (h) r105;
        L14:
            if (r106 != null) goto L19;
            r106 = new h(r100, r102);
            if (Build.VERSION.SDK_INT >= 35) goto L18;
            WindowCompat.setDecorFitsSystemWindows(r100, false);
        L18:
            WindowInsetsUtils.h(r100, r106);
            r102.setTag(com.larus.nova.R.id.activity_fit_system_window_handler, r106);
        L19:
            return r106;
        L13:
            r106 = null;
            goto L14
        }
    }

    static {
    }

    @Override // com.ss.android.lark.insets.c
    public final WindowInsetsControllerCompat u() {
        return this.f427766p;
    }

    public h(Window r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r101, "contentRootView");
        this.f427765o = r101;
        Intrinsics.checkNotNullParameter(r101, "targetView");
        BaseWindowInsetsHandler$createCoordinator$coordinator$1 r102 = new BaseWindowInsetsHandler$createCoordinator$coordinator$1(r101, this);
        this.f427766p = WindowCompat.getInsetsController(r100, r101);
        Iterator<k> r103 = l.f427779a.iterator();
        OnApplyWindowInsetsListener r104 = r102;
    L4:
        if (r103.hasNext() == false) goto L6;
        r104 = r103.next().intercept();
        goto L4
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this.f427765o, r104);
        this.f427765o.requestApplyInsets();
        this.f427733a = r102;
        WindowInsetsControllerCompat r105 = this.f427766p;
        boolean r106 = false;
        if (r105 != null) goto L9;
    L11:
        boolean r107 = false;
    L12:
        p(r107);
        WindowInsetsControllerCompat r108 = this.f427766p;
        if (r108 != null) goto L15;
    L17:
        v(r106);
        return;
    L15:
        if (r108.isAppearanceLightStatusBars() != true) goto L17;
        r106 = true;
        goto L17
    L9:
        if (r105.isAppearanceLightNavigationBars() != true) goto L11;
        r107 = true;
        goto L12
    }
}
