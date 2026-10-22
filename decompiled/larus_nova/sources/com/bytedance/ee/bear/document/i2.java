package com.bytedance.ee.bear.document;

import com.bytedance.ee.larkwebview.bridge.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes16.dex */
public final class i2 extends at5.e {
    public i2() {
    }

    public static Message c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsMessage");
        Message r101 = new Message();
        int r102 = StringsKt.indexOf$default(r100, "callbackID\":\"", 0, false, 6, null);
        if (r102 < 0) goto L5;
        int r103 = r102 + 13;
        r101.setCallbackID(r100.substring(r103, StringsKt.indexOf$default(r100, Typography.quote, r103, false, 4, null)));
    L5:
        int r104 = StringsKt.indexOf$default(r100, "\"apiName\":\"", 0, false, 6, null);
        if (r104 < 0) goto L10;
        int r105 = r104 + 11;
        int r106 = StringsKt.indexOf$default(r100, Typography.quote, r105, false, 4, null);
        r101.setApiName(r100.substring(r105, r106));
        int r107 = r106 + 9;
        int r108 = r100.length() - 1;
        if (r107 >= r108) goto L10;
        r101.setData(r100.substring(r107, r108));
    L10:
        return r101;
    }

    @Override // at5.e
    public final Message b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Message r101 = c(r100);     // Catch: Throwable -> L15
        String r102 = r101.getApiName();
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        iu5.d.a("DocsBridgeExtension", new RuntimeException("message.apiName.isNullOrEmpty()"));
        return super.b(r100);
    L14:
        return r101;
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
    L15:
        th = move-exception;
        iu5.d.a("DocsBridgeExtension", th);
        return super.b(r100);
    }
}
