package com.lark.kmp.storage.module;

import com.lark.kmp.containerization.b;
import com.lark.kmp.storage.GlobalLarkStorage;
import com.lark.kmp.storage.UserLarkStorage;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes24.dex */
public final class StorageModule {
    static {
    }

    public static void a(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "globalContainer");
        Function0<GlobalLarkStorage> r101 = new StorageModule$bindGlobalStorage$1(r100);
        r100.c(Reflection.getOrCreateKotlinClass(GlobalLarkStorage.class), r101);
    }

    public static void b(final String r100, final b r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userContainer");
        Function0<UserLarkStorage> r102 = new StorageModule$bindUserStorage$1(r100, r101);
        r101.c(Reflection.getOrCreateKotlinClass(UserLarkStorage.class), r102);
    }
}
