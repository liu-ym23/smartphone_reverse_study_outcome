package com.bytedance.gamecenter.base;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class v {
    public static final String a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJson");
        return GsonProtectorUtils.toJson(new Gson(), r100);
    }
}
