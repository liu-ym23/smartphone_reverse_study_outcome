package com.bytedance.ee.bear.search;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/search/SelectTitleConfig;", "Ljava/io/Serializable;", "useTitle", "", "titleName", "", "<init>", "(ZLjava/lang/String;)V", "getUseTitle", "()Z", "getTitleName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "contentmanager-search-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectTitleConfig implements Serializable {
    private final String titleName;
    private final boolean useTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectTitleConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SelectTitleConfig copy$default(SelectTitleConfig r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.useTitle;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.titleName;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.useTitle;
    }

    public final String component2() {
        return this.titleName;
    }

    public final SelectTitleConfig copy(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "titleName");
        return new SelectTitleConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectTitleConfig) == true) goto L8;
        return false;
    L8:
        SelectTitleConfig r101 = (SelectTitleConfig) r100;
        if (this.useTitle == r101.useTitle) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleName, r101.titleName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.useTitle == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.titleName.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "SelectTitleConfig(useTitle=" + this.useTitle + ", titleName=" + this.titleName + ')';
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final boolean getUseTitle() {
        return this.useTitle;
    }

    public SelectTitleConfig(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "titleName");
        this.useTitle = r100;
        this.titleName = r101;
    }

    public /* synthetic */ SelectTitleConfig(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
