package com.ss.android.lark.flow.notification.online.type.reaction;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements AbstractNotification.a {
    public b() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.a
    public final void a(Notice r100) {
        int r101 = ((int) (CastLongProtector.parseLong(r100.messageId) % 10001)) * 10001;
        iac.a.b(LarkContext.getApplication()).a(r101);
    }
}
