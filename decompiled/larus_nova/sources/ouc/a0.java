package ouc;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes.dex */
@Serializable(with = b0.class)
public final class a0 extends g0 {
    public static final a0 INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f526802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Lazy<juc.d<Object>> f526803b = null;

    @Override // ouc.g0
    public final boolean c() {
        return false;
    }

    static {
        INSTANCE = new a0();
        f526802a = "null";
        f526803b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new z());
    }

    public final juc.d<a0> serializer() {
        return (juc.d) f526803b.getValue();
    }

    public a0() {
    }

    @Override // ouc.g0
    public final String a() {
        return f526802a;
    }
}
