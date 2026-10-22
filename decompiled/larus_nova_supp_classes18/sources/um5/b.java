package um5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.ss.android.lark.vfs.VFSPath;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final int a;
    public final int b;
    public final VFSPath c;
    public final String d;
    public Bitmap e;
    public Canvas f;
    public int g;
    public final int h;
    public final BlockingQueue<C0317b> i;
    public final BlockingQueue<a> j;
    public Future<?> k;
    public Future<?> l;
    public um5.a m;
    public final CCMWatermarkManager n;

    public static final class a {
        public boolean a;
        public String b;
        public int c;
        public int d;
        public boolean e;

        public a() {
            this.b = "";
        }
    }

    /* JADX INFO: renamed from: um5.b$b, reason: collision with other inner class name */
    public static final class C0317b {
        public boolean a;
        public Bitmap b;

        public C0317b() {
        }
    }

    public final void b() {
        Bitmap r0 = this.e;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        Future<?> r1 = this.k;
        if (r1 == null) goto L8;
        r1.cancel(true);
    L8:
        Future<?> r2 = this.l;
        if (r2 == null) goto L12;
        r2.cancel(true);
        return;
    }

    public static final void a(b r2, String r3) {
        r2.getClass();
        BearExecutors.f().execute(new c(r2, r3));
    }

    public b(int r2, int r3, VFSPath r4) {
        Intrinsics.checkNotNullParameter(r4, "filePath");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "ImageDataProcessor";
        this.h = 15;
        this.i = new ArrayBlockingQueue(5);
        this.j = new ArrayBlockingQueue(15);
        this.n = new CCMWatermarkManager();
    }
}
