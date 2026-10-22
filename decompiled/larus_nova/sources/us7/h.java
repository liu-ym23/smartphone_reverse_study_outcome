package us7;

import android.app.Activity;
import android.os.Handler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f551544b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Activity> f551545a;

    static {
        f551544b = new h();
    }

    public final void a() {
        if (((CopyOnWriteArrayList) this.f551545a).size() <= 0) goto L8;
        Iterator r100 = ((CopyOnWriteArrayList) this.f551545a).iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        ((Activity) r100.next()).finish();
        goto L6
    L10:
        return;
    }

    public final Activity b() {
        List<Activity> r100 = this.f551545a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (((CopyOnWriteArrayList) r100).size() == 0) goto L11;
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) this.f551545a;
        return (Activity) ListProtector.get(r101, r101.size() - 1);
    L11:
        return null;
    }

    public h() {
        this.f551545a = new CopyOnWriteArrayList();
    }

    public final void c(Activity r100) {
        if (((CopyOnWriteArrayList) this.f551545a).contains(r100) == false) goto L6;
        ((CopyOnWriteArrayList) this.f551545a).remove(r100);
    L6:
        if (((CopyOnWriteArrayList) this.f551545a).size() <= 0) goto L8;
        boolean r101 = true;
    L9:
        ts7.c.f547419e = r101;
        if (r101 == false) goto L12;
        ts7.c.e();
        return;
    L12:
        Handler r102 = ts7.c.b();
        if (r102 == null) goto L17;
        ts7.c.a r103 = ts7.c.f547420f;
        r102.removeCallbacks(r103);
        r102.postDelayed(r103, 300000);
        return;
    L17:
        return;
    L8:
        r101 = false;
        goto L9
    }
}
