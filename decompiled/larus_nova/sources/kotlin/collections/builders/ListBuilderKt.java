package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001eH\u0002¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"arrayOfUninitializedElements", "", ExifInterface.LONGITUDE_EAST, "size", "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", ExifInterface.GPS_DIRECTION_TRUE, "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", "offset", "length", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ListBuilderKt {
    public static final <E> E[] arrayOfUninitializedElements(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L9;
        return (E[]) new Object[r100];
    L9:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L4:
        r101 = false;
        goto L5
    }

    public static final <T> T[] copyOfUninitializedElements(T[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (T[]) Arrays.copyOf(r100, r101);
    }

    public static final <E> void resetAt(E[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100[r101] = null;
    }

    public static final /* synthetic */ int access$subarrayContentHashCode(Object[] r100, int r101, int r102) {
        return subarrayContentHashCode(r100, r101, r102);
    }

    public static final <E> void resetRange(E[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L3:
        if (r101 >= r102) goto L5;
        resetAt(r100, r101);
        r101 = r101 + 1;
        goto L3
    }

    private static final <T> int subarrayContentHashCode(T[] r100, int r101, int r102) {
        int r103 = 1;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L9;
        T r105 = r100[r101 + r104];
        int r106 = r103 * 31;
        if (r105 == null) goto L7;
        int r107 = r105.hashCode();
    L8:
        r103 = r106 + r107;
        r104 = r104 + 1;
        goto L3
    L7:
        r107 = 0;
        goto L8
    L9:
        return r103;
    }

    public static final /* synthetic */ boolean access$subarrayContentEquals(Object[] r100, int r101, int r102, List r103) {
        return subarrayContentEquals(r100, r101, r102, r103);
    }

    public static final /* synthetic */ String access$subarrayContentToString(Object[] r100, int r101, int r102, Collection r103) {
        return subarrayContentToString(r100, r101, r102, r103);
    }

    private static final <T> boolean subarrayContentEquals(T[] r100, int r101, int r102, List<?> r103) {
        if (r102 == r103.size()) goto L5;
        return false;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L11;
        if (Intrinsics.areEqual(r100[r101 + r104], ListProtector.get(r103, r104)) == false) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static final <T> String subarrayContentToString(T[] r100, int r101, int r102, Collection<? extends T> r103) {
        StringBuilder r104 = new StringBuilder((r102 * 3) + 2);
        r104.append("[");
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L11;
        if (r105 <= 0) goto L6;
        r104.append(", ");
    L6:
        T r106 = r100[r101 + r105];
        if (r106 != r103) goto L9;
        r104.append("(this Collection)");
    L10:
        r105 = r105 + 1;
        goto L3
    L9:
        r104.append(r106);
        goto L10
    L11:
        r104.append("]");
        return r104.toString();
    }
}
