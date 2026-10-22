package fe3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f476571a;

    public d() {
        this.f476571a = "deep_feed_bff_video_pre_warm";
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<a> r100 = b.f476568c.iterator();     // Catch: Throwable -> L9
    L4:
        if (r100.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r100.next().f476565b, this.f476571a) == false) goto L4;
        r100.remove();     // Catch: Throwable -> L9
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
