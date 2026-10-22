package un;

import android.view.View;
import com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx;

/* JADX INFO: loaded from: classes44.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExposeLinearLayoutManagerEx f550755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f550756b;

    public abstract int b(View r100);

    public abstract int c(View r100);

    public abstract int d(View r100);

    public abstract int e(View r100);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract void k(int r100);

    public e(ExposeLinearLayoutManagerEx r100) {
        this.f550756b = Integer.MIN_VALUE;
        this.f550755a = r100;
    }

    public static e a(ExposeLinearLayoutManagerEx r100, int r101) {
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L8;
        return new d(r100);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return new c(r100);
    }
}
