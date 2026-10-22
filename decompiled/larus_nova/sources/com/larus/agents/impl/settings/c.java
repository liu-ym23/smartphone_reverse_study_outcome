package com.larus.agents.impl.settings;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286714a = 0;

    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "instruction");
        if (r100.length() > 10000) goto L5;
        return true;
    L5:
        return false;
    }
}
