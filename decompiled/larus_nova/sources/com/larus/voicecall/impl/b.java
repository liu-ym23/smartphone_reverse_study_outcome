package com.larus.voicecall.impl;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f377180a = null;

    static {
        f377180a = LazyKt.lazy(new a());
    }

    public static boolean a() {
        return ((Keva) f377180a.getValue()).getBoolean("is_full_screen_call", false);
    }
}
