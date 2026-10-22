package com.ss.android.lark.ug.banner;

import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "colorString");
        return Color.parseColor("#" + r100.substring(6) + r100.substring(0, 6));
    L5:
        return 0;
    }
}
