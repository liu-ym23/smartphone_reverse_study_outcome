package kuc;

import juc.d;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import nuc.a1;
import nuc.f;
import nuc.o2;
import nuc.r1;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static final f b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "elementSerializer");
        return new f(r100);
    }

    public static final <T> d<T> d(d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getDescriptor().a() == false) goto L6;
        return r100;
    L6:
        return new r1(r100);
    }

    public static final void e(IntCompanionObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        w0 r101 = w0.f520792a;
    }

    public static final void f(StringCompanionObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        v2 r101 = v2.f520790a;
    }

    @ExperimentalSerializationApi
    public static final o2 a(KClass r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "elementSerializer");
        return new o2(r100, r101);
    }

    public static final a1 c(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "keySerializer");
        Intrinsics.checkNotNullParameter(r101, "valueSerializer");
        return new a1(r100, r101);
    }
}
