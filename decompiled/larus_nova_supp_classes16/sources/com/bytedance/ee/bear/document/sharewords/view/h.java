package com.bytedance.ee.bear.document.sharewords.view;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.ThreadTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public static final String a(ForwardTarget r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringBuilder r0 = new StringBuilder("{id: ");
        r0.append(r5.a);
        r0.append(", type: ");
        r0.append(r5.b());
        r0.append(", threadTarget: ");
        if (r5.b() != 2) goto L12;
        StringBuilder r1 = new StringBuilder("{chatId: ");
        ThreadTarget r2 = r5.c();
        Boolean r4 = null;
        if (r2 == null) goto L7;
        String r3 = r2.getChatId();
    L8:
        r1.append(r3);
        r1.append(", isReplyInThread: ");
        ThreadTarget r6 = r5.c();
        if (r6 == null) goto L11;
        r4 = Boolean.valueOf(r6.isReplyInThread());
    L11:
        r1.append(r4);
        r1.append('}');
        String r7 = r1.toString();
    L13:
        r0.append(r7);
        r0.append('}');
        return r0.toString();
    L7:
        r3 = null;
        goto L8
    L12:
        r7 = "null";
        goto L13
    }
}
