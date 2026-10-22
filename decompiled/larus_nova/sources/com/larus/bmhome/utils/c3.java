package com.larus.bmhome.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314983a = 0;

    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return StringsKt.contains$default(r100, "pc_guide_scene=", false, 2, null);
    }
}
