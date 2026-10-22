package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final KotlinVersion CURRENT = null;
    public static final Companion Companion = null;
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CURRENT = KotlinVersionCurrentValue.get();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.major);
        r100.append('.');
        r100.append(this.minor);
        r100.append('.');
        r100.append(this.patch);
        return r100.toString();
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return this.version;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(KotlinVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return this.version - r100.version;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KotlinVersion) == false) goto L8;
        KotlinVersion r101 = (KotlinVersion) r100;
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (this.version == r101.version) goto L17;
        return false;
    L17:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(KotlinVersion r100) {
        return compareTo2(r100);
    }

    public KotlinVersion(int r100, int r101) {
        this(r100, r101, 0);
    }

    public final boolean isAtLeast(int r100, int r101) {
        int r102 = this.major;
        if (r102 > r100) goto L9;
        if (r102 == r100) goto L6;
    L8:
        return false;
    L6:
        if (this.minor < r101) goto L8;
    L9:
        return true;
    }

    public KotlinVersion(int r100, int r101, int r102) {
        this.major = r100;
        this.minor = r101;
        this.patch = r102;
        this.version = versionOf(r100, r101, r102);
    }

    private final int versionOf(int r100, int r101, int r102) {
        boolean r103 = true;
        if (r100 < 0) goto L6;
        if (r100 >= 256) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L19;
        if (r101 < 0) goto L11;
        if (r101 >= 256) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L19;
        if (r102 < 0) goto L16;
        if (r102 >= 256) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
    L20:
        if (r103 == false) goto L24;
        return ((r100 << 16) + (r101 << 8)) + r102;
    L24:
        throw new IllegalArgumentException(("Version components are out of range: " + r100 + '.' + r101 + '.' + r102).toString());
    L16:
        r106 = false;
    L11:
        r105 = false;
    L19:
        r103 = false;
    L6:
        r104 = false;
        goto L7
    }

    public final boolean isAtLeast(int r100, int r101, int r102) {
        int r103 = this.major;
        if (r103 > r100) goto L12;
        if (r103 != r100) goto L11;
        int r104 = this.minor;
        if (r104 > r101) goto L12;
        if (r104 != r101) goto L11;
        if (this.patch >= r102) goto L12;
    L11:
        return false;
    L12:
        return true;
    }
}
