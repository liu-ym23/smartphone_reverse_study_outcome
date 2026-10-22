package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BinaryVersion {
    public static final Companion Companion = null;
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public int hashCode() {
        int r100 = this.major;
        int r101 = r100 + ((r100 * 31) + this.minor);
        int r102 = r101 + ((r101 * 31) + this.patch);
        return r102 + ((r102 * 31) + this.rest.hashCode());
    }

    public String toString() {
        int[] r100 = toArray();
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        int r104 = r100[r103];
        if (r104 == (-1)) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L12;
        r101.add(Integer.valueOf(r104));
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = false;
    L12:
        if (r101.isEmpty() == false) goto L15;
        return "unknown";
    L15:
        return CollectionsKt.joinToString$default(r101, ".", null, null, 0, null, null, 62, null);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public BinaryVersion(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "numbers");
        this.numbers = r100;
        Integer r101 = ArraysKt.getOrNull(r100, 0);
        int r102 = -1;
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        this.major = r103;
        Integer r104 = ArraysKt.getOrNull(r100, 1);
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        this.minor = r105;
        Integer r106 = ArraysKt.getOrNull(r100, 2);
        if (r106 == null) goto L13;
        r102 = r106.intValue();
    L13:
        this.patch = r102;
        if (r100.length > 3) goto L16;
        List<Integer> r107 = CollectionsKt.emptyList();
    L21:
        this.rest = r107;
        return;
    L16:
        if (r100.length > 1024) goto L19;
        r107 = CollectionsKt.toList(ArraysKt.asList(r100).subList(3, r100.length));
        goto L21
    L19:
        throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + r100.length + '.');
    L9:
        r105 = -1;
        goto L10
    L5:
        r103 = -1;
        goto L6
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L4;
    L14:
        return false;
    L4:
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == false) goto L14;
        BinaryVersion r101 = (BinaryVersion) r100;
        if (this.major != r101.major) goto L14;
        if (this.minor != r101.minor) goto L14;
        if (this.patch != r101.patch) goto L14;
        if (Intrinsics.areEqual(this.rest, r101.rest) == false) goto L14;
        return true;
    }

    public final boolean isAtLeast(BinaryVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        return isAtLeast(r100.major, r100.minor, r100.patch);
    }

    public final boolean isCompatibleTo(BinaryVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "ourVersion");
        int r101 = this.major;
        if (r101 != 0) goto L10;
        if (r100.major == 0) goto L7;
    L14:
        return false;
    L7:
        if (this.minor != r100.minor) goto L14;
        return true;
    L10:
        if (r101 != r100.major) goto L14;
        if (this.minor > r100.minor) goto L14;
        return true;
    }

    public final boolean isAtLeast(int r100, int r101, int r102) {
        int r103 = this.major;
        if (r103 <= r100) goto L6;
        return true;
    L6:
        if (r103 >= r100) goto L8;
        return false;
    L8:
        int r104 = this.minor;
        if (r104 <= r101) goto L11;
        return true;
    L11:
        if (r104 >= r101) goto L14;
        return false;
    L14:
        if (this.patch >= r102) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean isAtMost(int r100, int r101, int r102) {
        int r103 = this.major;
        if (r103 >= r100) goto L6;
        return true;
    L6:
        if (r103 <= r100) goto L8;
        return false;
    L8:
        int r104 = this.minor;
        if (r104 >= r101) goto L11;
        return true;
    L11:
        if (r104 <= r101) goto L14;
        return false;
    L14:
        if (this.patch <= r102) goto L18;
        return false;
    L18:
        return true;
    }
}
