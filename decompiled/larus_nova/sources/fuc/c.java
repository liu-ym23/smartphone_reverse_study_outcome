package fuc;

import bytedance.jvm.time.ZoneId;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes42.dex */
@Serializable(with = iuc.a.class)
public final class c extends h {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }

        public final juc.d<c> serializer() {
            return iuc.a.f495904a;
        }
    }

    static {
        Companion = new a();
    }

    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        this(r100, r100.f478941a);
    }

    public c(j r100, ZoneId r101) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        Intrinsics.checkNotNullParameter(r101, "zoneId");
        super(r101);
    }
}
