package ouc;

import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes.dex */
@Serializable(with = r.class)
public abstract class i {
    public static final a Companion = null;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a {
        public a() {
        }

        public final juc.d<i> serializer() {
            return r.f526859a;
        }
    }

    public i() {
    }

    static {
        Companion = new a();
    }
}
