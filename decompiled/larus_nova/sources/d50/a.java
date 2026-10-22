package d50;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f466888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, c50.d> f466889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f50.a f466890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<Integer> f466891d;

    public abstract void b();

    public abstract boolean c(c50.c r100);

    public abstract boolean d(c50.c r100);

    public abstract void e(int r100);

    public abstract void f();

    public final Message a(c50.c r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.f22450d;
        if (r101 != (-1)) goto L8;
        return null;
    L8:
        Message r102 = Message.obtain(this.f466888a, r100);
        r102.what = r101;
        return r102;
    }

    public a(c50.a r100, HashMap r101, f50.a r102) {
        this.f466891d = new HashSet();
        this.f466888a = r100;
        this.f466889b = r101;
        this.f466890c = r102;
    }
}
