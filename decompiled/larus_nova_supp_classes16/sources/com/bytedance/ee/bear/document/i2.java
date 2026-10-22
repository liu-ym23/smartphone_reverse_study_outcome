package com.bytedance.ee.bear.document;

import com.bytedance.ee.larkwebview.bridge.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i2 extends at5.e {
    public i2() {
    }

    public static Message c(String r8) {
        Intrinsics.checkNotNullParameter(r8, "jsMessage");
        Message r0 = new Message();
        int r1 = StringsKt.indexOf$default(r8, "callbackID\":\"", 0, false, 6, null);
        if (r1 < 0) goto L5;
        int r2 = r1 + 13;
        r0.setCallbackID(r8.substring(r2, StringsKt.indexOf$default(r8, '\"', r2, false, 4, null)));
    L5:
        int r3 = StringsKt.indexOf$default(r8, "\"apiName\":\"", 0, false, 6, null);
        if (r3 < 0) goto L10;
        int r4 = r3 + 11;
        int r5 = StringsKt.indexOf$default(r8, '\"', r4, false, 4, null);
        r0.setApiName(r8.substring(r4, r5));
        int r6 = r5 + 9;
        int r7 = r8.length() - 1;
        if (r6 >= r7) goto L10;
        r0.setData(r8.substring(r6, r7));
    L10:
        return r0;
    }

    public final Message b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Message r1 = c(r4);     // Catch: Throwable -> L15
        String r2 = r1.getApiName();
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        iu5.d.a("DocsBridgeExtension", new RuntimeException("message.apiName.isNullOrEmpty()"));
        return super.b(r4);
    L14:
        return r1;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
    L15:
        th = move-exception;
        iu5.d.a("DocsBridgeExtension", th);
        return super.b(r4);
    }
}
