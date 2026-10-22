package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.c> f194564a;

    public q(com.bytedance.awemeopen.apps.framework.comment.write.c r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        super(Looper.getMainLooper());
        this.f194564a = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.c> r101 = this.f194564a;
        if (r101 == null) goto L5;
        com.bytedance.awemeopen.apps.framework.comment.write.c r102 = r101.get();
    L6:
        if (r102 == null) goto L9;
        r102.e(null);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
