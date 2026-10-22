package com.larus.dora.impl.util;

import com.bytedance.dora.annotation.ProductNameType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f338157a = 0;

    static {
    }

    public static String a(Integer r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        int r102 = ProductNameType.DORA_G.f204375id;
        if (r100 != null) goto L6;
    L7:
        return r101;
    L6:
        if (r100.intValue() != r102) goto L7;
        if (s.a() == true) goto L13;
        return "";
    L13:
        return r101;
    }
}
