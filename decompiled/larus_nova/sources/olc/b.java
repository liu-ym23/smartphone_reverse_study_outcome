package olc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements olc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet<Bitmap> f524195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f524196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f524197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f524198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f524199e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ReentrantLock r100 = this.f524196b;
        r100.lock();
        this.f524197c.removeMessages(1);     // Catch: Throwable -> L10
        if (this.f524195a.isEmpty() == false) goto L7;
        r100.unlock();
        return;
    L7:
        this.f524197c.sendEmptyMessageDelayed(1, this.f524199e);     // Catch: Throwable -> L10
        r100.unlock();
        return;
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public b() {
        this.f524198d = 5;
        this.f524199e = 3000;
        this.f524195a = new TreeSet(d.f524201a);
        this.f524196b = new ReentrantLock();
        this.f524197c = new Handler(Looper.getMainLooper(), new c(this));
    }

    @Override // olc.a
    public final void a(Bitmap r100) {
        ReentrantLock r101 = this.f524196b;
        r101.lock();
        this.f524195a.add(r100);     // Catch: Throwable -> L9
        if (this.f524195a.size() <= this.f524198d) goto L6;
        Iterator<Bitmap> r102 = this.f524195a.iterator();     // Catch: Throwable -> L9
        r102.next().recycle();     // Catch: Throwable -> L9
        r102.remove();     // Catch: Throwable -> L9
    L6:
        b();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r101.unlock();
        return;
    L9:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // olc.a
    public final Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        ReentrantLock r103 = this.f524196b;
        r103.lock();
        Iterator<Bitmap> r104 = this.f524195a.iterator();     // Catch: Throwable -> L22
    L5:
        if (r104.hasNext() == false) goto L16;
        Bitmap r105 = r104.next();     // Catch: Throwable -> L22
        if (r105.getWidth() >= r100) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == false) goto L5;
        if (r105.getConfig() != r102) goto L5;
        r104.remove();     // Catch: Throwable -> L22
        r105.eraseColor(0);     // Catch: Throwable -> L22
    L17:
        if (r105 != null) goto L20;
        r105 = e.f524202b.obtain(r100, r101, r102);     // Catch: Throwable -> L22
    L20:
        r103.unlock();
        return r105;
    L9:
        if (r105.getHeight() < r101) goto L11;
        r106 = true;
        goto L12
    L16:
        r105 = null;
    L22:
        th = move-exception;
        r103.unlock();
        throw th;
    }
}
