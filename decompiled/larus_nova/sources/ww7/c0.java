package ww7;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f561643e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f561644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f561645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f561646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k0 f561647d;

    static {
        f561643e = new c0();
    }

    public final Context a() {
        return this.f561644a.get();
    }

    public c0() {
        this.f561645b = false;
        this.f561646c = false;
    }
}
