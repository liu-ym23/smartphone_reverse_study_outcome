package com.ss.android.lark.flow.notification.online.type.message;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements AbstractNotification.a {
    public b() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.a
    public final void a(Notice r100) {
        String r101 = r100.messageId;
        if (TextUtils.isEmpty(r101) == true) goto L13;
        Notice.Extra r102 = r100.extra;
        if (r102 == null) goto L13;
        String r103 = r102.f433057a;
        if (TextUtils.isEmpty(r103) == false) goto L11;
        thb.a.a("FlowMessageNotificationCanceler", "getChatId extra is null");
        return;
    L11:
        int r104 = dtb.c.b(r100, r101);
        iac.a.b(LarkContext.getApplication()).a(r104);
        int r105 = dtb.c.b(r100, r103);
        iac.a.b(LarkContext.getApplication()).a(r105);
        iac.a.b(LarkContext.getApplication()).a(dtb.c.b(r100, r100.key));
        return;
    L13:
        thb.a.a("FlowMessageNotificationCanceler", "messageId or notice extra is null");
    }
}
