package com.ss.android.lark.keyboard.edittext2.utils;

import com.ss.android.lark.KeyboardBaseModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f429254a = 0;

    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return KeyboardBaseModule.a().isFeatureGatingEnable(r100);
    }
}
