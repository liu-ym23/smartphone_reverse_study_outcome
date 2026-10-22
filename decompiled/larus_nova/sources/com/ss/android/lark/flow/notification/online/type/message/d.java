package com.ss.android.lark.flow.notification.online.type.message;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements AbstractNotification.b<Notice> {
    public d() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final Notice a(Notice r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.extra == null) goto L9;
        return r100;
    L9:
        return null;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final int b(Notice r100) {
        Notice.Extra r101 = r100.extra;
        if (r101 != null) goto L6;
    L33:
        return 0;
    L6:
        if (r101.f433066j != null) goto L9;
        return 0;
    L9:
        if (r100.shouldNotify == true) goto L33;
        int r102 = r100.state;
        if (r102 == 3) goto L13;
        if (r102 != 2) goto L33;
    L13:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!TextUtils.isEmpty(r100.extra.f433061e)) == false) goto L30;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.extra.f433060d != Notice.Extra.ChatMode.THREAD_V2) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L30;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.extra.f433067k < 0) goto L30;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r104 = r100.state;
        if (r104 == 2) goto L27;
        if (r104 == 3) goto L27;
        boolean r105 = false;
    L28:
        if (r105 == false) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == true) goto L33;
        return 1;
    L27:
        r105 = true;
        goto L28
    L18:
        r103 = false;
    L30:
        r106 = false;
        goto L31
    }
}
