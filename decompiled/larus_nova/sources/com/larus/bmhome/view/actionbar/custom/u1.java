package com.larus.bmhome.view.actionbar.custom;

import android.graphics.Color;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u1 {
    public static final Integer a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Integer.valueOf(Color.parseColor(r100));
    L5:
        FLogger.f375446a.e("CustomActionBarNormalHolder", " to color fail:" + r100);
        return null;
    }
}
