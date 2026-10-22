package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u<T> implements ObservableOnSubscribe {
    public final /* synthetic */ v.a a;
    public final /* synthetic */ String b;

    public u(v.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        File[] r6 = new PolarisFileWrapper(this.b).listFiles();     // Catch: Exception -> L16
        if (r6 == null) goto L15;
        if (r6.length != 0) goto L8;
        boolean r1 = true;
    L10:
        if ((!r1) == false) goto L15;
        if (r6[0].isFile() == false) goto L15;
        this.a.b.onNext(r6[0]);     // Catch: Exception -> L16
        return;
    L8:
        r1 = false;
    L15:
        throw new IllegalStateException("folder has no image , path：" + this.b);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        this.a.b.tryOnError(e);
    }
}
