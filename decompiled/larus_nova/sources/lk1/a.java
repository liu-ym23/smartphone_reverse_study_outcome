package lk1;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import java.util.Iterator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends mk1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<mk1.a> f509542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner f509543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityQueue<mk1.b> f509544c;

    @Override // mk1.b
    public final mk1.a a() {
        Iterator<mk1.b> r100 = this.f509544c.iterator();
        mk1.a r101 = null;
    L4:
        if (r100.hasNext() == false) goto L21;
        mk1.a r102 = r100.next().a();
        boolean r103 = true;
        int r104 = 0;
        if (r102.f514293a != 3) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
    L14:
        if (r103 == true) goto L15;
        int r106 = r102.f514293a;
        if (r101 == null) goto L19;
        r104 = r101.f514293a;
    L19:
        if (r106 < r104) goto L4;
        r101 = r102;
        goto L4
    L15:
        return r102;
    L11:
        if (r102.b() == true) goto L14;
        r103 = false;
        goto L14
    L8:
        r105 = false;
        goto L9
    L21:
        if (r101 == null) goto L23;
        return r101;
    L23:
        return mk1.a.f514292e;
    }

    public a() {
        PropertyOwner<mk1.a> r100 = new PropertyOwner(new mk1.a(0, 6));
        this.f509542a = r100;
        this.f509543b = r100;
        this.f509544c = new PriorityQueue();
    }
}
