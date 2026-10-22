package com.bytedance.ee.bear.bitable.uikit;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static final boolean b(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getAction();
        Action.Companion.getClass();
        return StringsKt.equals$default(r101, Action.access$getTYEP_NATIVE_PROXY_ACTION$cp(), false, 2, null);
    }

    public static final ActionPayload a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stackIdentify");
        Intrinsics.checkNotNullParameter(r101, "action");
        ActionPayload r102 = new ActionPayload();
        r102.setStackIdentify(r100);
        r102.setAction(r101);
        return r102;
    }
}
