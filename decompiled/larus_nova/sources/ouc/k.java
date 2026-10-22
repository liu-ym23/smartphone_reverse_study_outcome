package ouc;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.m0;
import kotlinx.serialization.json.internal.o0;
import nuc.r0;
import nuc.t0;
import nuc.v2;

/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f526858a = null;

    static {
        kuc.a.f(StringCompanionObject.INSTANCE);
        f526858a = t0.a("kotlinx.serialization.json.JsonUnquotedLiteral", v2.f520790a);
    }

    public static final g0 a(Boolean r100) {
        if (r100 != null) goto L6;
        return a0.INSTANCE;
    L6:
        return new x(r100, false, null);
    }

    public static final g0 b(Number r100) {
        if (r100 != null) goto L6;
        return a0.INSTANCE;
    L6:
        return new x(r100, false, null);
    }

    public static final g0 c(String r100) {
        if (r100 != null) goto L6;
        return a0.INSTANCE;
    L6:
        return new x(r100, true, null);
    }

    public static final boolean e(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Boolean r101 = o0.b(r100.a());
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        throw new IllegalStateException(r100 + " does not represent a Boolean");
    }

    public static final Boolean f(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return o0.b(r100.a());
    }

    public static final String g(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof a0) == false) goto L6;
        return null;
    L6:
        return r100.a();
    }

    public static final double h(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastDoubleProtector.parseDouble(r100.a());
    }

    public static final Double i(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.toDoubleOrNull(r100.a());
    }

    public static final Float j(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.toFloatOrNull(r100.a());
    }

    public static final int k(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r101 = new m0(r100.a()).h();     // Catch: JsonDecodingException -> L14
        boolean r102 = false;
        if (SieveCacheKt.NodeMetaAndPreviousMask <= r101) goto L7;
    L9:
        if (r102 == false) goto L13;
        return (int) r101;
    L13:
        throw new NumberFormatException(r100.a() + " is not an Int");
    L7:
        if (r101 > SieveCacheKt.NodeLinkMask) goto L9;
        r102 = true;
    L14:
        e = move-exception;
        throw new NumberFormatException(e.getMessage());
    }

    public static final Integer l(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = Long.valueOf(new m0(r100.a()).h());     // Catch: JsonDecodingException -> L5
    L6:
        if (r101 == null) goto L16;
        long r102 = r101.longValue();
        boolean r103 = false;
        if (SieveCacheKt.NodeMetaAndPreviousMask <= r102) goto L10;
    L12:
        if (r103 == true) goto L15;
        return null;
    L15:
        return Integer.valueOf((int) r102);
    L10:
        if (r102 > SieveCacheKt.NodeLinkMask) goto L12;
        r103 = true;
        goto L12
    L16:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public static final b m(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof b) == false) goto L5;
        b r101 = (b) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        d(r100, "JsonArray");
        throw null;
    L5:
        r101 = null;
        goto L6
    }

    public static final d0 n(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof d0) == false) goto L5;
        d0 r101 = (d0) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        d(r100, "JsonObject");
        throw null;
    L5:
        r101 = null;
        goto L6
    }

    public static final g0 o(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof g0) == false) goto L5;
        g0 r101 = (g0) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        d(r100, "JsonPrimitive");
        throw null;
    L5:
        r101 = null;
        goto L6
    }

    public static final long p(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new m0(r100.a()).h();
    L5:
        e = move-exception;
        throw new NumberFormatException(e.getMessage());
    }

    public static final Long q(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Long.valueOf(new m0(r100.a()).h());
    L5:
        return null;
    }

    public static final void d(i r100, String r101) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(r100.getClass()) + " is not a " + r101);
    }
}
