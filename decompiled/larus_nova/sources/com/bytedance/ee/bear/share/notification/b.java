package com.bytedance.ee.bear.share.notification;

import android.os.IBinder;
import com.ss.android.lark.doc.IReminder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareNotifySetView f237264a;

    public b(ShareNotifySetView r100) {
        this.f237264a = r100;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IReminder r100 = this.f237264a.f237248c;
        if (r100 == null) goto L7;
        IBinder r101 = r100.asBinder();
        if (r101 == null) goto L7;
        b r102 = this.f237264a.f237249d;
        Intrinsics.checkNotNull(r102);
        r101.unlinkToDeath(r102, 0);
    L7:
        ShareNotifySetView r103 = this.f237264a;
        r103.f237248c = null;
        r103.f237251f = null;
        r103.f237250e = null;
        r103.f237252g = null;
    }
}
