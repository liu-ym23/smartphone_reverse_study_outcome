package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "", "height", "", "bgColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBgColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "equals", "", "other", "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThematicBreakConfig {
    private final Integer bgColor;
    private final Integer height;

    /* JADX WARN: Multi-variable type inference failed */
    public ThematicBreakConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ThematicBreakConfig copy$default(ThematicBreakConfig r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.height;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bgColor;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.height;
    }

    public final Integer component2() {
        return this.bgColor;
    }

    public final ThematicBreakConfig copy(Integer r100, Integer r101) {
        return new ThematicBreakConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThematicBreakConfig) == true) goto L8;
        return false;
    L8:
        ThematicBreakConfig r101 = (ThematicBreakConfig) r100;
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.height;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bgColor;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ThematicBreakConfig(height=" + this.height + ", bgColor=" + this.bgColor + ')';
    }

    public final Integer getBgColor() {
        return this.bgColor;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public ThematicBreakConfig(Integer r100, Integer r101) {
        this.height = r100;
        this.bgColor = r101;
    }

    public /* synthetic */ ThematicBreakConfig(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
