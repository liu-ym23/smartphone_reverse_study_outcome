package com.bytedance.ee.bear.bitable.uikit;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final boolean b(Action r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = r4.getAction();
        Action.Companion.getClass();
        return StringsKt.equals$default(r5, Action.access$getTYEP_NATIVE_PROXY_ACTION$cp(), false, 2, null);
    }

    public static final ActionPayload a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "stackIdentify");
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        ActionPayload r0 = new ActionPayload();
        r0.setStackIdentify(r1);
        r0.setAction(r2);
        return r0;
    }
}
