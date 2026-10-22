package com.obric.miniapp.request;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static final boolean a(AIBridgeMethod.Error r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getCode() != (-2)) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.getMessage(), "Function not found") == true) goto L8;
        return false;
    }
}
