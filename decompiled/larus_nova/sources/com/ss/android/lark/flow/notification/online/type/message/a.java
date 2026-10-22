package com.ss.android.lark.flow.notification.online.type.message;

import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends AbstractNotification<Notice, qhb.a> {
    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public int getType() {
        return 2;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.b<Notice> a() {
        return new d();
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.a b() {
        return new b();
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.AbstractNotificationDisplayer<qhb.a> c() {
        return new e();
    }

    public a() {
    }
}
