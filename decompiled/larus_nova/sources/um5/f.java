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

/* JADX INFO: loaded from: classes18.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f550690a;

    public f(b r100) {
        this.f550690a = r100;
    }

    public final void a() {
    L28:
        b.a r100 = (b.a) ((ArrayBlockingQueue) this.f550690a.f550674j).take();     // Catch: Exception -> L25
        b r101 = this.f550690a;     // Catch: Exception -> L25
        String r102 = r100.f550680b;     // Catch: Exception -> L25
        r101.getClass();     // Catch: Exception -> L25
        byte[] r103 = Base64.decode(r102.substring(StringsKt.indexOf$default(r102, ",", 0, false, 6, null) + 1), 0);     // Catch: Exception -> L25
        int r104 = r103.length;     // Catch: Exception -> L25
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        byte r106 = r103[r105];     // Catch: Exception -> L25
        if (r106 >= 0) goto L7;
        r103[r105] = (byte) (r106 + 256);     // Catch: Exception -> L25
    L7:
        r105 = r105 + 1;     // Catch: Exception -> L25
        goto L3
    L8:
        Bitmap r107 = BitmapFactory.decodeByteArray(r103, 0, r103.length);     // Catch: Exception -> L25
        if (r107 == null) goto L10;
        int r108 = r100.f550681c;     // Catch: Exception -> L25
        int r109 = r100.f550682d;     // Catch: Exception -> L25
        b r110 = this.f550690a;     // Catch: Exception -> L25
        if (r110.f550669e != null) goto L14;
        r110.f550669e = Bitmap.createBitmap(r110.f550665a, r109, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L25
        b r111 = this.f550690a;     // Catch: Exception -> L25
        Bitmap r112 = this.f550690a.f550669e;     // Catch: Exception -> L25
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L25
        r111.f550670f = new Canvas(r112);     // Catch: Exception -> L25
    L14:
        int r113 = this.f550690a.f550671g;     // Catch: Exception -> L25
        Rect r114 = new Rect(r113, 0, r113 + r108, r109);     // Catch: Exception -> L25
        Rect r115 = new Rect(0, 0, r108, r109);     // Catch: Exception -> L25
        Canvas r116 = this.f550690a.f550670f;     // Catch: Exception -> L25
        if (r116 == null) goto L17;
        r116.drawBitmap(r107, r115, r114, null);     // Catch: Exception -> L25
    L17:
        this.f550690a.f550671g += r108;     // Catch: Exception -> L25
        if (r100.f550683e == false) goto L20;
        b.C7897b r117 = new b.C7897b();     // Catch: Exception -> L25
        b r118 = this.f550690a;     // Catch: Exception -> L25
        r117.f550685b = r118.f550669e;     // Catch: Exception -> L25
        r117.f550684a = r100.f550679a;     // Catch: Exception -> L25
        ((ArrayBlockingQueue) r118.f550673i).put(r117);     // Catch: Exception -> L25
        b r119 = this.f550690a;     // Catch: Exception -> L25
        r119.f550671g = 0;     // Catch: Exception -> L25
        r119.f550670f = null;     // Catch: Exception -> L25
        r119.f550669e = null;     // Catch: Exception -> L25
    L20:
        r107.recycle();     // Catch: Exception -> L25
        if (r100.f550679a == true) goto L36;
        b r120 = this.f550690a;     // Catch: Exception -> L25
        r120.getClass();     // Catch: Exception -> L25
        BearExecutors.f().execute(new d(r120));     // Catch: Exception -> L25
        goto L28
    L36:
        return;
    L10:
        tt5.a.d(this.f550690a.f550668d, "decodedBitmap block is null!");     // Catch: Exception -> L25
        b.a(this.f550690a, "cancatImage");     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        ((ArrayBlockingQueue) this.f550690a.f550674j).clear();
        tt5.a.k(this.f550690a.f550668d, "LineBitmap generate task is interrupted!" + e);
        b.a(this.f550690a, "Exception generate " + e);
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
