package com.ss.android.ugc.tools.net;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/tools/net/WeakNetSortRule;", "", "", "component1", "component2", "component3", "", "component4", "sortCategory", "maxSortCount", "minNeededCount", "sortCover", "copy", "", "toString", "hashCode", "other", "equals", "I", "getSortCategory", "()I", "getMaxSortCount", "getMinNeededCount", "Z", "getSortCover", "()Z", "<init>", "(IIIZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class WeakNetSortRule {
    public static final int CATEGORY_MEET_NEED = 1;
    public static final int CATEGORY_NOT_SORT = 0;
    public static final int CATEGORY_SIMPLE_SORT = 2;
    public static final a Companion = null;
    private final int maxSortCount;
    private final int minNeededCount;
    private final int sortCategory;
    private final boolean sortCover;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public WeakNetSortRule() {
        this(0, 0, 0, false, 15, null);
    }

    public static /* synthetic */ WeakNetSortRule copy$default(WeakNetSortRule r100, int r101, int r102, int r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.sortCategory;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.maxSortCount;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.minNeededCount;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.sortCover;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.sortCategory;
    }

    public final int component2() {
        return this.maxSortCount;
    }

    public final int component3() {
        return this.minNeededCount;
    }

    public final boolean component4() {
        return this.sortCover;
    }

    public final WeakNetSortRule copy(int r100, int r101, int r102, boolean r103) {
        return new WeakNetSortRule(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WeakNetSortRule) == false) goto L14;
        WeakNetSortRule r101 = (WeakNetSortRule) r100;
        if (this.sortCategory == r101.sortCategory) goto L8;
        return false;
    L8:
        if (this.maxSortCount == r101.maxSortCount) goto L10;
        return false;
    L10:
        if (this.minNeededCount == r101.minNeededCount) goto L12;
        return false;
    L12:
        if (this.sortCover == r101.sortCover) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r100 = ((((this.sortCategory * 31) + this.maxSortCount) * 31) + this.minNeededCount) * 31;
        boolean r101 = this.sortCover;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public String toString() {
        return "WeakNetSortRule(sortCategory=" + this.sortCategory + ", maxSortCount=" + this.maxSortCount + ", minNeededCount=" + this.minNeededCount + ", sortCover=" + this.sortCover + ")";
    }

    public final int getMaxSortCount() {
        return this.maxSortCount;
    }

    public final int getMinNeededCount() {
        return this.minNeededCount;
    }

    public final int getSortCategory() {
        return this.sortCategory;
    }

    public final boolean getSortCover() {
        return this.sortCover;
    }

    public WeakNetSortRule(int r100, int r101, int r102, boolean r103) {
        this.sortCategory = r100;
        this.maxSortCount = r101;
        this.minNeededCount = r102;
        this.sortCover = r103;
    }

    public /* synthetic */ WeakNetSortRule(int r100, int r101, int r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
