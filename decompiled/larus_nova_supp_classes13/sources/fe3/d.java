package fe3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;

    public d() {
        this.a = "deep_feed_bff_video_pre_warm";
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<a> r0 = b.c.iterator();     // Catch: Throwable -> L9
    L4:
        if (r0.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r0.next().b, this.a) == false) goto L4;
        r0.remove();     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
