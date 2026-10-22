package com.bytedance.revenue.platform.api.core;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267505a = 0;

    static {
    }

    public static byte[] a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return Base64.decode(r100, 0);
    }
}
