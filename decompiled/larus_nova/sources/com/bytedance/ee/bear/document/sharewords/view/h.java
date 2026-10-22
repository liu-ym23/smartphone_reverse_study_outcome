package com.bytedance.ee.bear.document.sharewords.view;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.ThreadTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {
    public static final String a(ForwardTarget r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder("{id: ");
        r101.append(r100.f424780a);
        r101.append(", type: ");
        r101.append(r100.b());
        r101.append(", threadTarget: ");
        if (r100.b() != 2) goto L12;
        StringBuilder r102 = new StringBuilder("{chatId: ");
        ThreadTarget r103 = r100.c();
        Boolean r104 = null;
        if (r103 == null) goto L7;
        String r105 = r103.getChatId();
    L8:
        r102.append(r105);
        r102.append(", isReplyInThread: ");
        ThreadTarget r106 = r100.c();
        if (r106 == null) goto L11;
        r104 = Boolean.valueOf(r106.isReplyInThread());
    L11:
        r102.append(r104);
        r102.append('}');
        String r107 = r102.toString();
    L13:
        r101.append(r107);
        r101.append('}');
        return r101.toString();
    L7:
        r105 = null;
        goto L8
    L12:
        r107 = "null";
        goto L13
    }
}
