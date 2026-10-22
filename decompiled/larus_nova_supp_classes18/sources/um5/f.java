package um5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Base64;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Runnable {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    public final void a() {
    L28:
        b.a r0 = (b.a) ((ArrayBlockingQueue) this.a.j).take();     // Catch: Exception -> L25
        b r1 = this.a;     // Catch: Exception -> L25
        String r8 = r0.b;     // Catch: Exception -> L25
        r1.getClass();     // Catch: Exception -> L25
        byte[] r2 = Base64.decode(r8.substring(StringsKt.indexOf$default(r8, ",", 0, false, 6, null) + 1), 0);     // Catch: Exception -> L25
        int r3 = r2.length;     // Catch: Exception -> L25
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        byte r5 = r2[r4];     // Catch: Exception -> L25
        if (r5 >= 0) goto L7;
        r2[r4] = (byte) (r5 + 256);     // Catch: Exception -> L25
    L7:
        r4 = r4 + 1;     // Catch: Exception -> L25
        goto L3
    L8:
        Bitmap r6 = BitmapFactory.decodeByteArray(r2, 0, r2.length);     // Catch: Exception -> L25
        if (r6 == null) goto L10;
        int r7 = r0.c;     // Catch: Exception -> L25
        int r9 = r0.d;     // Catch: Exception -> L25
        b r10 = this.a;     // Catch: Exception -> L25
        if (r10.e != null) goto L14;
        r10.e = Bitmap.createBitmap(r10.a, r9, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L25
        b r11 = this.a;     // Catch: Exception -> L25
        Bitmap r12 = this.a.e;     // Catch: Exception -> L25
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L25
        r11.f = new Canvas(r12);     // Catch: Exception -> L25
    L14:
        int r13 = this.a.g;     // Catch: Exception -> L25
        Rect r14 = new Rect(r13, 0, r13 + r7, r9);     // Catch: Exception -> L25
        Rect r15 = new Rect(0, 0, r7, r9);     // Catch: Exception -> L25
        Canvas r16 = this.a.f;     // Catch: Exception -> L25
        if (r16 == null) goto L17;
        r16.drawBitmap(r6, r15, r14, null);     // Catch: Exception -> L25
    L17:
        this.a.g += r7;     // Catch: Exception -> L25
        if (r0.e == false) goto L20;
        b.C0317b r17 = new b.C0317b();     // Catch: Exception -> L25
        b r18 = this.a;     // Catch: Exception -> L25
        r17.b = r18.e;     // Catch: Exception -> L25
        r17.a = r0.a;     // Catch: Exception -> L25
        ((ArrayBlockingQueue) r18.i).put(r17);     // Catch: Exception -> L25
        b r19 = this.a;     // Catch: Exception -> L25
        r19.g = 0;     // Catch: Exception -> L25
        r19.f = null;     // Catch: Exception -> L25
        r19.e = null;     // Catch: Exception -> L25
    L20:
        r6.recycle();     // Catch: Exception -> L25
        if (r0.a == true) goto L36;
        b r20 = this.a;     // Catch: Exception -> L25
        r20.getClass();     // Catch: Exception -> L25
        BearExecutors.f().execute(new d(r20));     // Catch: Exception -> L25
        goto L28
    L36:
        return;
    L10:
        tt5.a.d(this.a.d, "decodedBitmap block is null!");     // Catch: Exception -> L25
        b.a(this.a, "cancatImage");     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        ((ArrayBlockingQueue) this.a.j).clear();
        tt5.a.k(this.a.d, "LineBitmap generate task is interrupted!" + e);
        b.a(this.a, "Exception generate " + e);
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
