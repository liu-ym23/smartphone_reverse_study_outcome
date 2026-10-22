package com.ss.android.lark.utils;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.ss.android.lark.chameleon.util.MagicWindowUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444722a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b() {
        return StringsKt.contains$default(Build.BRAND.toLowerCase(), DimLocationCheckUtil.XIAOMI, false, 2, null);
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = StringsKt.contains$default(r100.getResources().getConfiguration().toString(), "magic-windows", false, 2, null);
        hac.b.f484427a.a(MagicWindowUtil.TAG, "configuration: " + r100.getResources().getConfiguration());
        return r101;
    }
}
