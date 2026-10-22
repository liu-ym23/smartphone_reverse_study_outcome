package com.larus.app.settings.impl;

import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f287037a = null;

    static {
        f287037a = LazyKt.lazy(new l());
    }

    public static Integer a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        String r101 = "portrait_auth_status_".concat(r100);
        Lazy r102 = f287037a;
        if (((SharedPreferences) r102.getValue()).contains(r101) == true) goto L8;
        return null;
    L8:
        return Integer.valueOf(((SharedPreferences) r102.getValue()).getInt(r101, 0));
    }
}
