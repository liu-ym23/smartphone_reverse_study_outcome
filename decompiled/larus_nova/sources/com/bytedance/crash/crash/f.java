package com.bytedance.crash.crash;

import android.content.Context;
import com.bytedance.crash.a0;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.t;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f203139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f203140c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f203141a;

    public f(Context r100, a r101) {
        this.f203141a = r101;
        t.a();     // Catch: Throwable -> L5
    L5:
        ConfigManager r102 = a0.f203096a;     // Catch: Throwable -> L8
        com.bytedance.librarian.a.e("npth", true, i.getContext());     // Catch: Throwable -> L8
    L6:
        NativeBridge.Z(r100, r101.f203098a);
    }
}
