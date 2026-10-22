package fuc;

import bytedance.jvm.time.LocalTime;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes42.dex */
@Serializable(with = iuc.e.class)
public final class g implements Comparable<g> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalTime f478937a;

    public static final class a {
        public a() {
        }

        public final juc.d<g> serializer() {
            return iuc.e.f495912a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f478938a = 0;

        static {
        }
    }

    static {
        Companion = new a();
        new g(LocalTime.MIN);
        new g(LocalTime.MAX);
    }

    public final int hashCode() {
        return this.f478937a.hashCode();
    }

    public final String toString() {
        return this.f478937a.toString();
    }

    public g(LocalTime r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f478937a = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(g r100) {
        g r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return this.f478937a.compareTo2(r101.f478937a);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(this.f478937a, ((g) r100).f478937a) == false) goto L8;
        goto L8
    }
}
