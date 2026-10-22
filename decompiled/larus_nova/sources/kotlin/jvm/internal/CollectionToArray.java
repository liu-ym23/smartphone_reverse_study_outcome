package kotlin.jvm.internal;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;

    static {
        EMPTY = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "collection");
        int r101 = r100.size();
        if (r101 == 0) goto L32;
        Iterator<?> r102 = r100.iterator();
        if (r102.hasNext() == false) goto L32;
        Object[] r103 = new Object[r101];
        int r104 = 0;
    L9:
        int r105 = r104 + 1;
        r103[r104] = r102.next();
        if (r105 < r103.length) goto L23;
        if (r102.hasNext() == false) goto L33;
        int r106 = ((r105 * 3) + 1) >>> 1;
        if (r106 > r105) goto L21;
        r106 = MAX_SIZE;
        if (r105 < MAX_SIZE) goto L21;
        throw new OutOfMemoryError();
    L21:
        r103 = Arrays.copyOf(r103, r106);
    L26:
        r104 = r105;
        goto L9
    L33:
        return r103;
    L23:
        if (r102.hasNext() == true) goto L26;
        return Arrays.copyOf(r103, r105);
    L32:
        return EMPTY;
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "collection");
        if (r101 == null) goto L38;
        int r102 = r100.size();
        int r103 = 0;
        if (r102 == 0) goto L7;
        Iterator<?> r104 = r100.iterator();
        if (r104.hasNext() == true) goto L15;
        if (r101.length <= 0) goto L47;
        r101[0] = null;
        return r101;
    L47:
        return r101;
    L15:
        if (r102 > r101.length) goto L17;
        Object[] r105 = r101;
    L18:
        int r106 = r103 + 1;
        r105[r103] = r104.next();
        if (r106 < r105.length) goto L32;
        if (r104.hasNext() == false) goto L49;
        int r107 = ((r106 * 3) + 1) >>> 1;
        if (r107 > r106) goto L30;
        r107 = MAX_SIZE;
        if (r106 < MAX_SIZE) goto L30;
        throw new OutOfMemoryError();
    L30:
        r105 = Arrays.copyOf(r105, r107);
    L37:
        r103 = r106;
        goto L18
    L49:
        return r105;
    L32:
        if (r104.hasNext() == true) goto L37;
        if (r105 != r101) goto L36;
        r101[r106] = null;
        return r101;
    L36:
        return Arrays.copyOf(r105, r106);
    L17:
        Object r108 = Array.newInstance(r101.getClass().getComponentType(), r102);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r105 = (Object[]) r108;
        goto L18
    L7:
        if (r101.length <= 0) goto L45;
        r101[0] = null;
        return r101;
    L45:
        return r101;
    L38:
        throw null;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] toArrayImpl(Collection<?> r100, Function0<Object[]> r101, Function1<? super Integer, Object[]> r102, Function2<? super Object[], ? super Integer, Object[]> r103) {
        int r104 = r100.size();
        if (r104 == 0) goto L5;
        Iterator<?> r105 = r100.iterator();
        if (r105.hasNext() == false) goto L9;
        Object[] r106 = r102.invoke(Integer.valueOf(r104));
        int r107 = 0;
        ?? r108 = r106;
    L11:
        int r109 = r107 + 1;
        r108[r107] = r105.next();
        if (r109 < r108.length) goto L25;
        if (r105.hasNext() == false) goto L15;
        int r110 = ((r109 * 3) + 1) >>> 1;
        if (r110 > r109) goto L23;
        r110 = MAX_SIZE;
        if (r109 < MAX_SIZE) goto L23;
        throw new OutOfMemoryError();
    L23:
        r108 = Arrays.copyOf(r108, r110);
    L28:
        r107 = r109;
        r108 = r108;
        goto L11
    L15:
        return r108;
    L25:
        if (r105.hasNext() == true) goto L28;
        return r103.invoke(r108, Integer.valueOf(r109));
    L9:
        return r101.invoke();
    L5:
        return r101.invoke();
    }
}
