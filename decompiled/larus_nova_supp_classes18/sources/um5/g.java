package um5;

import android.graphics.Bitmap;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.p;
import com.bytedance.ee.bear.screenshot.FastPngEncoder;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.watermark.core.WatermarkType;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ boolean b;

    public g(b r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = null;
        FastPngEncoder r1 = null;
    L43:
        b.C0317b r2 = (b.C0317b) ((ArrayBlockingQueue) this.a.i).take();     // Catch: InterruptedException -> L25 Exception -> L32
        Bitmap r3 = r2.b;     // Catch: InterruptedException -> L25 Exception -> L32
        Intrinsics.checkNotNull(r3);     // Catch: InterruptedException -> L25 Exception -> L32
        r3.getHeight();     // Catch: InterruptedException -> L25 Exception -> L32
        if (r1 != null) goto L7;
        tt5.a.h(this.a.d, "init pngEncoder!");     // Catch: InterruptedException -> L25 Exception -> L32
        b r5 = this.a;     // Catch: InterruptedException -> L25 Exception -> L32
        r1 = new FastPngEncoder(r5.c, r5.a, r5.b);     // Catch: InterruptedException -> L25 Exception -> L32
    L7:
        if (this.b == false) goto L28;
        boolean r4 = wo5.c.a("admin.security.watermark.file.switch");     // Catch: InterruptedException -> L25 Exception -> L32
        CCMWatermarkManager r6 = this.a.n;     // Catch: InterruptedException -> L25 Exception -> L32
        WatermarkType r7 = WatermarkType.EXPORT;     // Catch: InterruptedException -> L25 Exception -> L32
        r6.getClass();     // Catch: InterruptedException -> L25 Exception -> L32
        p r8 = CCMWatermarkManager.b(r4, r3, r7);     // Catch: InterruptedException -> L25 Exception -> L32
        Object r9 = r8.a;     // Catch: InterruptedException -> L25 Exception -> L32
        if ((r9 instanceof p.b) == true) goto L10;
        if ((r9 instanceof p.b) == false) goto L22;
        r9 = null;
    L22:
        Bitmap r10 = (Bitmap) r9;     // Catch: InterruptedException -> L25 Exception -> L32
        if (r10 == null) goto L28;
        tt5.a.h(this.a.d, "watermark success");     // Catch: InterruptedException -> L25 Exception -> L32
        r3 = r10;
        goto L28
    L10:
        b r11 = this.a;     // Catch: InterruptedException -> L25 Exception -> L32
        StringBuilder r12 = new StringBuilder();     // Catch: InterruptedException -> L25 Exception -> L32
        r12.append("watermark fail, message is ");     // Catch: InterruptedException -> L25 Exception -> L32
        Object r13 = r8.a;     // Catch: InterruptedException -> L25 Exception -> L32
        if ((r13 instanceof p.b) == false) goto L13;
        p.b r14 = (p.b) r13;     // Catch: InterruptedException -> L25 Exception -> L32
    L14:
        if (r14 == null) goto L18;
        Throwable r15 = r14.a;     // Catch: InterruptedException -> L25 Exception -> L32
        if (r15 == null) goto L18;
        r0 = r15.getMessage();     // Catch: InterruptedException -> L25 Exception -> L32
    L18:
        r12.append(r0);     // Catch: InterruptedException -> L25 Exception -> L32
        b.a(r11, r12.toString());     // Catch: InterruptedException -> L25 Exception -> L32
    L40:
        if (r1 == null) goto L51;
        r1.a();
        return;
    L51:
        return;
    L13:
        r14 = null;
    L28:
        if (r2.a == true) goto L29;
        r1.c(r3);     // Catch: InterruptedException -> L25 Exception -> L32
        r3.recycle();     // Catch: InterruptedException -> L25 Exception -> L32
        goto L43
    L29:
        r1.d(r3, 0, r3.getHeight());     // Catch: InterruptedException -> L25 Exception -> L32
        tt5.a.h(this.a.d, "Last bitmap has successfully finished!");     // Catch: InterruptedException -> L25 Exception -> L32
        r3.recycle();     // Catch: InterruptedException -> L25 Exception -> L32
        b r16 = this.a;     // Catch: InterruptedException -> L25 Exception -> L32
        r16.getClass();     // Catch: InterruptedException -> L25 Exception -> L32
        BearExecutors.f().execute(new e(r16));     // Catch: InterruptedException -> L25 Exception -> L32
    L25:
        e = move-exception;
    L35:
        if (this.a.i.isEmpty() == true) goto L39;
        Bitmap r17 = ((b.C0317b) ((ArrayBlockingQueue) this.a.i).take()).b;
        if (r17 == null) goto L35;
        r17.recycle();
        goto L35
    L39:
        tt5.a.l(this.a.d, "Png encode task is interrupted!", e);
        b.a(this.a, "InterruptedException encode " + e);
    L32:
        e = move-exception;
        tt5.a.l(this.a.d, "Png encode  task is error!", e);
        b.a(this.a, "Exception encode " + e);
        goto L40
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
}
