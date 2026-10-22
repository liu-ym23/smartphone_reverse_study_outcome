package com.ss.android.lark.flow.notification.online.type.reaction;

import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements AbstractNotification.b<FlowReactionNotice> {
    public d() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final Notice a(Notice r100) {
        if (r100 != null) goto L4;
    L7:
        return null;
    L4:
        if (r100.extra == null) goto L7;
        return new FlowReactionNotice(r100);
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final int b(Notice r100) {
        if (r100.shouldNotify == true) goto L13;
        int r101 = r100.state;
        if (r101 != 2) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return 1;
    L7:
        if (r101 == 3) goto L10;
        r102 = false;
    L13:
        return 0;
    }
}
