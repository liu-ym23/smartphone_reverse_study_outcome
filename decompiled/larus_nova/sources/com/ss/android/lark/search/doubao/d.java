package com.ss.android.lark.search.doubao;

import java.util.UUID;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f440101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f440102b;

    static {
        StringBuilder r100 = new StringBuilder();
        r100.append(System.currentTimeMillis());
        r100.append('_');
        r100.append(UUID.randomUUID());
        f440101a = r100.toString();
    }
}
