package com.bytedance.sdk.xbridge.cn.protocol;

import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270058a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        StringBuilder r102 = new StringBuilder("com.bytedance.xbridge.cn.gen.");
        String r103 = StringsKt.replace$default(r100, ".", "_", false, 4, null);
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r102.append(String.format("%s_Creator_%s", Arrays.copyOf(new Object[]{r101, r103}, 2)));
        return r102.toString();
    }
}
