package com.ss.android.lark.time.format.common;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441321a = 0;

    static {
    }

    public static Context a(Context r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L15;
        boolean r102 = false;
        if (Build.VERSION.SDK_INT < 24) goto L10;
        if (Intrinsics.areEqual(r100.getResources().getConfiguration().getLocales().get(0), r101) == false) goto L11;
    L12:
        if (r102 == false) goto L16;
        Configuration r103 = new Configuration(r100.getResources().getConfiguration());
        r103.setLocale(r101);
        Context r104 = r100.createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r104);
        Intrinsics.checkNotNull(r104);
        return r104;
    L16:
        return r100;
    L11:
        r102 = true;
        goto L12
    L10:
        if (Intrinsics.areEqual(r100.getResources().getConfiguration().locale, r101) == true) goto L12;
    L15:
        return r100;
    }
}
