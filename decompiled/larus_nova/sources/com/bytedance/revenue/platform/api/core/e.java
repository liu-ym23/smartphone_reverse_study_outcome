package com.bytedance.revenue.platform.api.core;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267507a = 0;

    static {
    }

    public static Uri a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemeString");
        return UriProtector.parse(r100);
    }
}
