package com.bytedance.lark.policy.utils;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d {
    public static final boolean a(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getType() != ResponseType.DOWNGRADE) goto L5;
        return true;
    L5:
        return false;
    }
}
