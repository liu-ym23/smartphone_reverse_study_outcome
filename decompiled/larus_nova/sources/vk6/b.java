package vk6;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements vk6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet<Bitmap> f555512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f555513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f555514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f555515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f555516e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ReentrantLock r100 = this.f555513b;
        r100.lock();
        this.f555514c.removeMessages(1);     // Catch: Throwable -> L10
        if (this.f555512a.isEmpty() == false) goto L7;
        r100.unlock();
        return;
    L7:
        this.f555514c.sendEmptyMessageDelayed(1, this.f555516e);     // Catch: Throwable -> L10
        r100.unlock();
        return;
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public b() {
        this.f555515d = 5;
        this.f555516e = 3000;
        this.f555512a = new TreeSet(d.f555518a);
        this.f555513b = new ReentrantLock();
        this.f555514c = new Handler(Looper.getMainLooper(), new c(this));
    }

    @Override // vk6.a
    public final void a(Bitmap r100) {
        ReentrantLock r101 = this.f555513b;
        r101.lock();
        this.f555512a.add(r100);     // Catch: Throwable -> L9
        if (this.f555512a.size() <= this.f555515d) goto L6;
        Iterator<Bitmap> r102 = this.f555512a.iterator();     // Catch: Throwable -> L9
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

    @Override // vk6.a
    public final Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        ReentrantLock r103 = this.f555513b;
        r103.lock();
        Iterator<Bitmap> r104 = this.f555512a.iterator();     // Catch: Throwable -> L22
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
        r105 = i.f555531b.obtain(r100, r101, r102);     // Catch: Throwable -> L22
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
