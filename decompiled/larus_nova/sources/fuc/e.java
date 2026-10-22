package fuc;

import bytedance.jvm.time.LocalDate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.l0;
import kotlinx.datetime.format.v;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes42.dex */
@Serializable(with = iuc.c.class)
public final class e implements Comparable<e> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalDate f478933a;

    public static final class a {
        public a() {
        }

        public final juc.d<e> serializer() {
            return iuc.c.f495908a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v<e> f478934a = null;

        static {
            f478934a = (v) l0.f505226b.getValue();
        }
    }

    static {
        Companion = new a();
        new e(LocalDate.MIN);
        new e(LocalDate.MAX);
    }

    public final int hashCode() {
        return this.f478933a.hashCode();
    }

    public final String toString() {
        return this.f478933a.toString();
    }

    public e(LocalDate r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f478933a = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(e r100) {
        e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return this.f478933a.compareTo(r101.f478933a);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(this.f478933a, ((e) r100).f478933a) == false) goto L8;
        goto L8
    }
}
