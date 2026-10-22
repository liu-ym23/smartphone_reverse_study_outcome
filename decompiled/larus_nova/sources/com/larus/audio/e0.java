package com.larus.audio;

import android.os.Build;
import com.huawei.hms.android.SystemUtils;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f289663a = 0;

    static {
    }

    public static boolean a() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r100.toUpperCase(Locale.getDefault()), SystemUtils.PRODUCT_HONOR, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
