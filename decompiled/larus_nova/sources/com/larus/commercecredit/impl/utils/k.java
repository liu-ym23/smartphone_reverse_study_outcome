package com.larus.commercecredit.impl.utils;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325826a = 0;

    static {
    }

    public k() {
    }

    public static String a(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        if (r100 == null) goto L9;
        String r102 = r100.getString(r101, "");
        if (r102 != null) goto L8;
        return "";
    L8:
        return r102;
    L9:
        return "";
    }
}
