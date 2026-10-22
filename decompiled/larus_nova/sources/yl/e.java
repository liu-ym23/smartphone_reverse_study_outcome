package yl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lyl/e;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "equals", "getEquals", "contains", "getContains", "startsWith", "getStartsWith", "endsWith", "getEndsWith", "", "isNull", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isExclude", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("contains")
    private final String contains;

    @SerializedName("ends_with")
    private final String endsWith;

    @SerializedName("equals")
    private final String equals;

    @SerializedName("is_exclude")
    private final Boolean isExclude;

    @SerializedName("is_null")
    private final Boolean isNull;

    @SerializedName("key")
    private final String key;

    @SerializedName("starts_with")
    private final String startsWith;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.equals, r101.equals) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.contains, r101.contains) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startsWith, r101.startsWith) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.endsWith, r101.endsWith) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isNull, r101.isNull) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isExclude, r101.isExclude) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.equals;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.contains;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.startsWith;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.endsWith;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isNull;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isExclude;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NetImagePreloadMatch(key=" + this.key + ", equals=" + this.equals + ", contains=" + this.contains + ", startsWith=" + this.startsWith + ", endsWith=" + this.endsWith + ", isNull=" + this.isNull + ", isExclude=" + this.isExclude + ")";
    }

    public e() {
        Boolean r100 = Boolean.FALSE;
        this.key = null;
        this.equals = null;
        this.contains = null;
        this.startsWith = null;
        this.endsWith = null;
        this.isNull = null;
        this.isExclude = r100;
    }
}
