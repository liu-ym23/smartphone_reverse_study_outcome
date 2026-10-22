package fuc;

import bytedance.jvm.time.ZoneOffset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes42.dex */
@Serializable(with = iuc.g.class)
public final class j {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZoneOffset f478941a;

    public static final class a {
        public a() {
        }

        public final juc.d<j> serializer() {
            return iuc.g.f495916a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f478942a = 0;

        static {
        }
    }

    static {
        Companion = new a();
        new j(ZoneOffset.UTC);
    }

    public final int hashCode() {
        return this.f478941a.hashCode();
    }

    public final String toString() {
        return this.f478941a.toString();
    }

    public j(ZoneOffset r100) {
        Intrinsics.checkNotNullParameter(r100, "zoneOffset");
        this.f478941a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof j) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f478941a, ((j) r100).f478941a) == false) goto L7;
        return true;
    }
}
