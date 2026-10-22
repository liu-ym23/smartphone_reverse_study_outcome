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

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f550665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f550666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VFSPath f550667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f550668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f550669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Canvas f550670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f550671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f550672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BlockingQueue<C7897b> f550673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BlockingQueue<a> f550674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Future<?> f550675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Future<?> f550676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public um5.a f550677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CCMWatermarkManager f550678n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f550679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f550680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f550681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f550682d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f550683e;

        public a() {
            this.f550680b = "";
        }
    }

    /* JADX INFO: renamed from: um5.b$b, reason: collision with other inner class name */
    public static final class C7897b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f550684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f550685b;

        public C7897b() {
        }
    }

    public final void b() {
        Bitmap r100 = this.f550669e;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        Future<?> r101 = this.f550675k;
        if (r101 == null) goto L8;
        r101.cancel(true);
    L8:
        Future<?> r102 = this.f550676l;
        if (r102 == null) goto L12;
        r102.cancel(true);
        return;
    }

    public static final void a(b r100, String r101) {
        r100.getClass();
        BearExecutors.f().execute(new c(r100, r101));
    }

    public b(int r100, int r101, VFSPath r102) {
        Intrinsics.checkNotNullParameter(r102, "filePath");
        this.f550665a = r100;
        this.f550666b = r101;
        this.f550667c = r102;
        this.f550668d = "ImageDataProcessor";
        this.f550672h = 15;
        this.f550673i = new ArrayBlockingQueue(5);
        this.f550674j = new ArrayBlockingQueue(15);
        this.f550678n = new CCMWatermarkManager();
    }
}
