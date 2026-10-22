package com.bytedance.ee.bear.templates.data;

import ao5.a;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/templates/data/CategoryTab;", "Lcom/bytedance/ee/util/io/NonProguard;", "categoryTabName", "", "categoryList", "", "Lcom/bytedance/ee/bear/templates/data/Category;", "categoryId", "", "pageNumber", "", "source", "<init>", "(Ljava/lang/CharSequence;Ljava/util/List;JII)V", "getCategoryTabName", "()Ljava/lang/CharSequence;", "getCategoryList", "()Ljava/util/List;", "getCategoryId", "()J", "setCategoryId", "(J)V", "getPageNumber", "()I", "setPageNumber", "(I)V", "getSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryTab implements NonProguard {
    private long categoryId;
    private final List<a> categoryList;
    private final CharSequence categoryTabName;
    private int pageNumber;
    private final int source;

    public CategoryTab() {
        this(null, null, 0, 0, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryTab copy$default(CategoryTab r100, CharSequence r101, List r102, long r103, int r104, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.categoryTabName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.categoryList;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.categoryId;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.pageNumber;
    L14:
        int r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.source;
    L17:
        CharSequence r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final CharSequence component1() {
        return this.categoryTabName;
    }

    public final List<a> component2() {
        return this.categoryList;
    }

    public final long component3() {
        return this.categoryId;
    }

    public final int component4() {
        return this.pageNumber;
    }

    public final int component5() {
        return this.source;
    }

    public final CategoryTab copy(CharSequence r100, List<a> r110, long r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "categoryTabName");
        Intrinsics.checkNotNullParameter(r110, "categoryList");
        return new CategoryTab(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CategoryTab) == true) goto L8;
        return false;
    L8:
        CategoryTab r101 = (CategoryTab) r100;
        if (Intrinsics.areEqual(this.categoryTabName, r101.categoryTabName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryList, r101.categoryList) == true) goto L15;
        return false;
    L15:
        if (this.categoryId == r101.categoryId) goto L18;
        return false;
    L18:
        if (this.pageNumber == r101.pageNumber) goto L21;
        return false;
    L21:
        if (this.source == r101.source) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.categoryTabName.hashCode() * 31) + this.categoryList.hashCode()) * 31;
        long r101 = this.categoryId;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.pageNumber) * 31) + this.source;
    }

    public String toString() {
        return "CategoryTab(categoryTabName=" + this.categoryTabName + ", categoryList=" + this.categoryList + ", categoryId=" + this.categoryId + ", pageNumber=" + this.pageNumber + ", source=" + this.source + ')';
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final List<a> getCategoryList() {
        return this.categoryList;
    }

    public final CharSequence getCategoryTabName() {
        return this.categoryTabName;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getSource() {
        return this.source;
    }

    public final void setCategoryId(long r100) {
        this.categoryId = r100;
    }

    public final void setPageNumber(int r100) {
        this.pageNumber = r100;
    }

    public CategoryTab(CharSequence r100, List<a> r101, long r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "categoryTabName");
        Intrinsics.checkNotNullParameter(r101, "categoryList");
        this.categoryTabName = r100;
        this.categoryList = r101;
        this.categoryId = r102;
        this.pageNumber = r103;
        this.source = r104;
    }

    public /* synthetic */ CategoryTab(CharSequence r100, List r101, long r102, int r103, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        List r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = -1;
    L11:
        long r104 = r102;
        if ((r111 & 8) == 0) goto L14;
        int r105 = 0;
    L16:
        if ((r111 & 16) == 0) goto L18;
        int r106 = 0;
    L19:
        this(r100, r113, r104, r105, r106);
        return;
    L18:
        r106 = r110;
        goto L19
    L14:
        r105 = r103;
        goto L16
    }
}
