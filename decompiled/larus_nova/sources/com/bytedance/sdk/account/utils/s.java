package com.bytedance.sdk.account.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.common.account.platform.larkauth.AuthorizationFactory;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f269556a;

    public interface a {
        void handleMsg(Message r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        a r101 = this.f269556a.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public s(Looper r100, AuthorizationFactory r101) {
        super(r100);
        this.f269556a = new WeakReference(r101);
    }
}
