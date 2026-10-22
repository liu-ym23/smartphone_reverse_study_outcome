package com.bytedance.ee.bear.share.notification;

import android.os.IBinder;
import com.ss.android.lark.doc.IReminder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements IBinder.DeathRecipient {
    public final /* synthetic */ ShareNotifySetView a;

    public b(ShareNotifySetView r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IReminder r0 = this.a.c;
        if (r0 == null) goto L7;
        IBinder r1 = r0.asBinder();
        if (r1 == null) goto L7;
        b r2 = this.a.d;
        Intrinsics.checkNotNull(r2);
        r1.unlinkToDeath(r2, 0);
    L7:
        ShareNotifySetView r3 = this.a;
        r3.c = null;
        r3.f = null;
        r3.e = null;
        r3.g = null;
    }
}
