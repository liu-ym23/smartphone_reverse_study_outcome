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

/* JADX INFO: loaded from: classes18.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f550691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f550692b;

    public g(b r100, boolean r101) {
        this.f550691a = r100;
        this.f550692b = r101;
    }

    public final void a() {
        String r100 = null;
        FastPngEncoder r101 = null;
    L43:
        b.C7897b r102 = (b.C7897b) ((ArrayBlockingQueue) this.f550691a.f550673i).take();     // Catch: InterruptedException -> L25 Exception -> L32
        Bitmap r103 = r102.f550685b;     // Catch: InterruptedException -> L25 Exception -> L32
        Intrinsics.checkNotNull(r103);     // Catch: InterruptedException -> L25 Exception -> L32
        r103.getHeight();     // Catch: InterruptedException -> L25 Exception -> L32
        if (r101 != null) goto L7;
        tt5.a.h(this.f550691a.f550668d, "init pngEncoder!");     // Catch: InterruptedException -> L25 Exception -> L32
        b r104 = this.f550691a;     // Catch: InterruptedException -> L25 Exception -> L32
        r101 = new FastPngEncoder(r104.f550667c, r104.f550665a, r104.f550666b);     // Catch: InterruptedException -> L25 Exception -> L32
    L7:
        if (this.f550692b == false) goto L28;
        boolean r105 = wo5.c.a("admin.security.watermark.file.switch");     // Catch: InterruptedException -> L25 Exception -> L32
        CCMWatermarkManager r106 = this.f550691a.f550678n;     // Catch: InterruptedException -> L25 Exception -> L32
        WatermarkType r107 = WatermarkType.EXPORT;     // Catch: InterruptedException -> L25 Exception -> L32
        r106.getClass();     // Catch: InterruptedException -> L25 Exception -> L32
        p r108 = CCMWatermarkManager.b(r105, r103, r107);     // Catch: InterruptedException -> L25 Exception -> L32
        Object r109 = r108.f236229a;     // Catch: InterruptedException -> L25 Exception -> L32
        if ((r109 instanceof p.b) == true) goto L10;
        if ((r109 instanceof p.b) == false) goto L22;
        r109 = null;
    L22:
        Bitmap r110 = (Bitmap) r109;     // Catch: InterruptedException -> L25 Exception -> L32
        if (r110 == null) goto L28;
        tt5.a.h(this.f550691a.f550668d, "watermark success");     // Catch: InterruptedException -> L25 Exception -> L32
        r103 = r110;
        goto L28
    L10:
        b r111 = this.f550691a;     // Catch: InterruptedException -> L25 Exception -> L32
        StringBuilder r112 = new StringBuilder();     // Catch: InterruptedException -> L25 Exception -> L32
        r112.append("watermark fail, message is ");     // Catch: InterruptedException -> L25 Exception -> L32
        Object r113 = r108.f236229a;     // Catch: InterruptedException -> L25 Exception -> L32
        if ((r113 instanceof p.b) == false) goto L13;
        p.b r114 = (p.b) r113;     // Catch: InterruptedException -> L25 Exception -> L32
    L14:
        if (r114 == null) goto L18;
        Throwable r115 = r114.f236230a;     // Catch: InterruptedException -> L25 Exception -> L32
        if (r115 == null) goto L18;
        r100 = r115.getMessage();     // Catch: InterruptedException -> L25 Exception -> L32
    L18:
        r112.append(r100);     // Catch: InterruptedException -> L25 Exception -> L32
        b.a(r111, r112.toString());     // Catch: InterruptedException -> L25 Exception -> L32
    L40:
        if (r101 == null) goto L51;
        r101.a();
        return;
    L51:
        return;
    L13:
        r114 = null;
    L28:
        if (r102.f550684a == true) goto L29;
        r101.c(r103);     // Catch: InterruptedException -> L25 Exception -> L32
        r103.recycle();     // Catch: InterruptedException -> L25 Exception -> L32
        goto L43
    L29:
        r101.d(r103, 0, r103.getHeight());     // Catch: InterruptedException -> L25 Exception -> L32
        tt5.a.h(this.f550691a.f550668d, "Last bitmap has successfully finished!");     // Catch: InterruptedException -> L25 Exception -> L32
        r103.recycle();     // Catch: InterruptedException -> L25 Exception -> L32
        b r116 = this.f550691a;     // Catch: InterruptedException -> L25 Exception -> L32
        r116.getClass();     // Catch: InterruptedException -> L25 Exception -> L32
        BearExecutors.f().execute(new e(r116));     // Catch: InterruptedException -> L25 Exception -> L32
    L25:
        e = move-exception;
    L35:
        if (this.f550691a.f550673i.isEmpty() == true) goto L39;
        Bitmap r117 = ((b.C7897b) ((ArrayBlockingQueue) this.f550691a.f550673i).take()).f550685b;
        if (r117 == null) goto L35;
        r117.recycle();
        goto L35
    L39:
        tt5.a.l(this.f550691a.f550668d, "Png encode task is interrupted!", e);
        b.a(this.f550691a, "InterruptedException encode " + e);
    L32:
        e = move-exception;
        tt5.a.l(this.f550691a.f550668d, "Png encode  task is error!", e);
        b.a(this.f550691a, "Exception encode " + e);
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
