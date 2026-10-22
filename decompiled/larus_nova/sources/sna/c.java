package sna;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f542673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f542674b;

    public static final class a {
    }

    static {
    }

    public final Keva a() {
        return (Keva) this.f542673a.getValue();
    }

    public c() {
        this.f542673a = LazyKt.lazy(new sna.a());
        this.f542674b = LazyKt.lazy(new b());
    }
}
