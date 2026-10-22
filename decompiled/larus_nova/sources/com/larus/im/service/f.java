package com.larus.im.service;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f350834a = 0;

    static {
    }

    public static List b() {
        return CollectionsKt.listOf(new String[]{"AVSDK", "AIXUE_TUTOR", "LARK_MINUTES", "RealtimeSessionDemo", "BrowserTakeover"});
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        return b().contains(r100);
    }
}
