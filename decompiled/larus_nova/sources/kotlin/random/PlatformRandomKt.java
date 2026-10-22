package kotlin.random;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PlatformRandomKt {
    public static final double doubleFromParts(int r100, int r101) {
        return ((((long) r100) << 27) + ((long) r101)) / 9.007199254740992E15d;
    }

    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final java.util.Random asJavaRandom(Random r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AbstractPlatformRandom) == false) goto L5;
        AbstractPlatformRandom r101 = (AbstractPlatformRandom) r100;
    L6:
        if (r101 == null) goto L10;
        java.util.Random r102 = r101.getImpl();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return new KotlinRandom(r100);
    L5:
        r101 = null;
        goto L6
    }

    public static final Random asKotlinRandom(java.util.Random r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof KotlinRandom) == false) goto L5;
        KotlinRandom r101 = (KotlinRandom) r100;
    L6:
        if (r101 == null) goto L10;
        Random r102 = r101.getImpl();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return new PlatformRandom(r100);
    L5:
        r101 = null;
        goto L6
    }
}
