package t0;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f544110j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f544111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f544112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f544113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f544114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f544115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f544116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<View> f544117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f544118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f544119i;

    static {
        f544110j = new a();
    }

    public final String a() {
        WeakReference<View> r100 = this.f544117g;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 == null) goto L11;
        Context r102 = r101.getContext();
        if (r102 == null) goto L11;
        return r102.getClass().getSimpleName();
    L11:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final void b() {
        if (this.f544119i >= 0) goto L6;
        this.f544119i = System.currentTimeMillis();
        return;
    }

    public a() {
        this.f544119i = -1;
    }
}
