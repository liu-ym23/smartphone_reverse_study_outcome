package com.bytedance.ies.xbridge.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249562a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Map<Class<? extends c>, c> r101 = k.f249565a;
        Intrinsics.checkNotNullParameter(d.class, "service");
        d r102 = (d) ((c) ((LinkedHashMap) k.f249565a).get(d.class));
        if (r102 == null) goto L6;
        r102.info();
        return;
    }
}
