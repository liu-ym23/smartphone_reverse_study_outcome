package com.bytedance.ee.bear.rn;

import com.ss.android.lark.chameleon.ChameleonResourceLoadCallback;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements ChameleonResourceLoadCallback {
    public final /* synthetic */ b a;
    public final /* synthetic */ boolean b;

    public c(b r1) {
        this.a = r1;
        this.b = false;
    }

    public final void onLoadFail(int r3, Throwable r4) {
        tt5.a.d("DefaultRnManager", "initWithResource, loadResource failed, code: " + r3 + ", error: " + r4);
    }

    public final void onLoadSuccess(VFSPath r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "path");
        tt5.a.h("DefaultRnManager", "initWithResource, loadResource success, path: " + r3 + ", version: " + r4);
        this.a.getClass();
        RnSyncManager.e = r3;
        this.a.init(this.b);
    }
}
