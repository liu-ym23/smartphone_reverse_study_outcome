package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.suite.lark.platform.component.dyres.DyResUtils;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    static {
    }

    public static String a() {
        yob.e.a().getClass();     // Catch: Exception -> L10
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;     // Catch: Exception -> L10
        apb.b r101 = com.ss.android.lark.language.service.impl.a.b.f431098a;     // Catch: Exception -> L10
        Locale r102 = r101.getLanguageSetting();     // Catch: Exception -> L10
        if (r102 == null) goto L6;
        String r103 = r101.d(r102);     // Catch: Exception -> L10
    L7:
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L10
        return r103;
    L6:
        r103 = DyResUtils.ResI18n.en_US;
    L13:
        return DyResUtils.ResI18n.en_US;
    }
}
