package ouc;

import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Serializable(with = h0.class)
public abstract class g0 extends i {
    public static final a Companion = null;

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
