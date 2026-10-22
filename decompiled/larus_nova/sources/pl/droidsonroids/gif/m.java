package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class m implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f529745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f529746b;

    public static final class a extends WeakReference<Drawable.Callback> {
        public final int hashCode() {
            Drawable.Callback r100 = get();
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public a(Drawable.Callback r100) {
            super(r100);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L15;
            if (get() == ((a) r100).get()) goto L16;
            return false;
        L16:
            return true;
        }
    }

    public m() {
        this(false);
    }

    public m(boolean r100) {
        this.f529745a = new CopyOnWriteArrayList();
        this.f529746b = r100;
    }

    public final void a(Drawable.Callback r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f529745a.size()) goto L9;
        a r102 = this.f529745a.get(r101);
        if (r102.get() != null) goto L8;
        this.f529745a.remove(r102);
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        this.f529745a.addIfAbsent(new a(r100));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f529745a.size()) goto L15;
        a r102 = this.f529745a.get(r101);
        Drawable.Callback r103 = r102.get();
        if (r103 != null) goto L8;
        this.f529745a.remove(r102);
    L14:
        r101 = r101 + 1;
        goto L4
    L8:
        if (this.f529746b == true) goto L10;
    L12:
        r103.invalidateDrawable(r100);
        goto L14
    L10:
        if ((r103 instanceof View) == false) goto L12;
        ((View) r103).invalidate();
        goto L14
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.f529745a.size()) goto L10;
        a r103 = this.f529745a.get(r102);
        Drawable.Callback r104 = r103.get();
        if (r104 == null) goto L8;
        r104.unscheduleDrawable(r100, r101);
    L9:
        r102 = r102 + 1;
        goto L4
    L8:
        this.f529745a.remove(r103);
        goto L9
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        int r103 = 0;
    L4:
        if (r103 >= this.f529745a.size()) goto L10;
        a r104 = this.f529745a.get(r103);
        Drawable.Callback r105 = r104.get();
        if (r105 == null) goto L8;
        r105.scheduleDrawable(r100, r101, r102);
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        this.f529745a.remove(r104);
        goto L9
    }
}
