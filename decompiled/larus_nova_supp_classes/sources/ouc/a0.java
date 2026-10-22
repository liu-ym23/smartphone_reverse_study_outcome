package ouc;

import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Serializable(with = b0.class)
public final class a0 extends g0 {
    public static final a0 INSTANCE = null;
    public static final String a = null;
    public static final /* synthetic */ Lazy<d<Object>> b = null;

    @Override // ouc.g0
    public final boolean c() {
        return false;
    }

    static {
        INSTANCE = new a0();
        a = "null";
        b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new z());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d<a0> serializer() {
        return b.getValue();
    }

    public a0() {
    }

    @Override // ouc.g0
    public final String a() {
        return a;
    }
}
