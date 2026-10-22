package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends Handler {
    public final WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.c> a;

    public q(com.bytedance.awemeopen.apps.framework.comment.write.c r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        super(Looper.getMainLooper());
        this.a = new WeakReference(r2);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.c> r3 = this.a;
        if (r3 == null) goto L5;
        com.bytedance.awemeopen.apps.framework.comment.write.c r4 = r3.get();
    L6:
        if (r4 == null) goto L9;
        r4.e(null);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
