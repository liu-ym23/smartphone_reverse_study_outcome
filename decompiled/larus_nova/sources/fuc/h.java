package fuc;

import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes42.dex */
@Serializable(with = iuc.f.class)
public class h {
    public static final a Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f478939b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZoneId f478940a;

    public static final class a {
        public a() {
        }

        public final juc.d<h> serializer() {
            return iuc.f.f495914a;
        }

        public static h a(ZoneId r100) {
            Intrinsics.checkNotNullParameter(r100, "zoneId");
            if ((r100 instanceof ZoneOffset) == true) goto L14;
            boolean r101 = r100.getRules().isFixedOffset();     // Catch: ArrayIndexOutOfBoundsException -> L7
        L8:
            if (r101 == false) goto L11;
            ZoneId r102 = r100.normalized();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type bytedance.jvm.time.ZoneOffset");
            return new c(new j((ZoneOffset) r102), r100);
        L11:
            return new h(r100);
        L7:
            r101 = false;
            goto L8
        L14:
            return new c(new j((ZoneOffset) r100));
        }
    }

    static {
        Companion = new a();
        j r100 = new j(ZoneOffset.UTC);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        f478939b = new c(r100);
    }

    public final int hashCode() {
        return this.f478940a.hashCode();
    }

    public final String toString() {
        return this.f478940a.toString();
    }

    public h(ZoneId r100) {
        Intrinsics.checkNotNullParameter(r100, "zoneId");
        this.f478940a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(this.f478940a, ((h) r100).f478940a) == false) goto L8;
        goto L8
    }
}
