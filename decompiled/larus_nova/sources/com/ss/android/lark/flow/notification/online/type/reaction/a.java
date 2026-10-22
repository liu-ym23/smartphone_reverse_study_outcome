package com.ss.android.lark.flow.notification.online.type.reaction;

import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.passportc.dwarf.UserScope;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class a extends AbstractNotification<FlowReactionNotice, rhb.a> {
    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public int getType() {
        return 4;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.b<FlowReactionNotice> a() {
        return new d();
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.a b() {
        return new b();
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.AbstractNotificationDisplayer<rhb.a> c() {
        return new e();
    }

    public a() {
    }
}
