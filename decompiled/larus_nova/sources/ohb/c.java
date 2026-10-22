package ohb;

import com.ss.android.lark.notification.export.entity.CurrentProcess;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements ctb.a {
    public c() {
    }

    @Override // ctb.a
    public final void a(Notice r100) {
        Intrinsics.checkNotNullParameter(r100, "notice");
        StringBuilder r101 = new StringBuilder("onPushNotice id=");
        r101.append(r100.key);
        r101.append(", messageId=");
        r101.append(r100.messageId);
        r101.append("  type=");
        r101.append(r100.type);
        r101.append(" from=");
        r101.append(r100.extra.f433059c);
        r101.append(", uid=");
        Notice.Extra r102 = r100.extra;
        if (r102 == null) goto L5;
        String r103 = r102.f433072p;
    L6:
        r101.append(r103);
        thb.a.b("InitFlowNotificationTask", r101.toString());
        int r104 = a.f523340a;
        ((zsb.c) k.a(LarkContext.getApplication(), zsb.c.class)).R2(r100, CurrentProcess.MAIN);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
