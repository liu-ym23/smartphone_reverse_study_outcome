package ouc;

import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes.dex */
@Serializable(with = h0.class)
public abstract class g0 extends i {
    public static final a Companion = null;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a {
        public a() {
        }

        public final juc.d<g0> serializer() {
            return h0.f526855a;
        }
    }

    public abstract String a();

    public abstract boolean c();

    static {
        Companion = new a();
    }

    public String toString() {
        return a();
    }

    public g0() {
    }
}
