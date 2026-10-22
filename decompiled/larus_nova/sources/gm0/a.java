package gm0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements g71.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<u71.b> f481648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g71.a f481649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f481650c;

    public final void c() {
        Iterator<T> r100 = b().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        u71.b r101 = (u71.b) r100.next();
        r101.c(this);
        r101.a();
        goto L4
    }

    @Override // g71.b
    public final void reset() {
        Iterator<T> r100 = b().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((u71.b) r100.next()).reset();
        goto L4
    }

    public a(DataCenter r100) {
        this.f481650c = r100;
        this.f481648a = new ArrayList();
    }

    @Override // g71.b
    public final void a(Integer r100) {
        g71.a r101 = this.f481649b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
