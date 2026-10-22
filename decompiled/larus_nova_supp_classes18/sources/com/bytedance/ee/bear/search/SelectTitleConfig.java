package com.bytedance.ee.bear.search;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/search/SelectTitleConfig;", "Ljava/io/Serializable;", "useTitle", "", "titleName", "", "<init>", "(ZLjava/lang/String;)V", "getUseTitle", "()Z", "getTitleName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "contentmanager-search-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectTitleConfig implements Serializable {
    private final String titleName;
    private final boolean useTitle;

    public SelectTitleConfig() {
        String r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ SelectTitleConfig copy$default(SelectTitleConfig r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.useTitle;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.titleName;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.useTitle;
    }

    public final String component2() {
        return this.titleName;
    }

    public final SelectTitleConfig copy(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "titleName");
        return new SelectTitleConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectTitleConfig) == true) goto L8;
        return false;
    L8:
        SelectTitleConfig r6 = (SelectTitleConfig) r5;
        if (this.useTitle == r6.useTitle) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleName, r6.titleName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.useTitle == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.titleName.hashCode();
    L5:
        r0 = 1237;
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

    public SelectTitleConfig(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "titleName");
        this.useTitle = r2;
        this.titleName = r3;
    }

    public /* synthetic */ SelectTitleConfig(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "";
    L8:
        this(r1, r2);
    }
}
