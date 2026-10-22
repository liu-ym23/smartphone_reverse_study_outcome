package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f203236a;

    public final void a() {
        Iterator<Map.Entry<String, String>> r100 = this.f203236a.f203238a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Map.Entry<String, String> r101 = r100.next();
        String r102 = r101.getKey();
        String r103 = r101.getValue();
        if (TextUtils.isEmpty(r102) == true) goto L4;
        NativeBridge.O(r102, r103);
        goto L4
    L8:
        this.f203236a.f203255r = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l0(m0 r100) {
        this.f203236a = r100;
    }
}
