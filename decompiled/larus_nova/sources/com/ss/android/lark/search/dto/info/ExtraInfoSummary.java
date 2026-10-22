package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.ExtraInfoBlock;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/search/dto/info/ExtraInfoSummary;", "Ljava/io/Serializable;", "extraInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/search/v2/ExtraInfoBlock;", "Lkotlin/collections/ArrayList;", "extraInfoSeparator", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getExtraInfoList", "()Ljava/util/ArrayList;", "getExtraInfoSeparator", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraInfoSummary implements Serializable {
    private final ArrayList<ExtraInfoBlock> extraInfoList;
    private final String extraInfoSeparator;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraInfoSummary copy$default(ExtraInfoSummary r100, ArrayList r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.extraInfoList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extraInfoSeparator;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<ExtraInfoBlock> component1() {
        return this.extraInfoList;
    }

    public final String component2() {
        return this.extraInfoSeparator;
    }

    public final ExtraInfoSummary copy(ArrayList<ExtraInfoBlock> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "extraInfoList");
        Intrinsics.checkNotNullParameter(r101, "extraInfoSeparator");
        return new ExtraInfoSummary(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExtraInfoSummary) == true) goto L8;
        return false;
    L8:
        ExtraInfoSummary r101 = (ExtraInfoSummary) r100;
        if (Intrinsics.areEqual(this.extraInfoList, r101.extraInfoList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfoSeparator, r101.extraInfoSeparator) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.extraInfoList.hashCode() * 31) + this.extraInfoSeparator.hashCode();
    }

    public String toString() {
        return "ExtraInfoSummary(extraInfoList=" + this.extraInfoList + ", extraInfoSeparator=" + this.extraInfoSeparator + ')';
    }

    public final ArrayList<ExtraInfoBlock> getExtraInfoList() {
        return this.extraInfoList;
    }

    public final String getExtraInfoSeparator() {
        return this.extraInfoSeparator;
    }

    public ExtraInfoSummary(ArrayList<ExtraInfoBlock> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "extraInfoList");
        Intrinsics.checkNotNullParameter(r101, "extraInfoSeparator");
        this.extraInfoList = r100;
        this.extraInfoSeparator = r101;
    }

    public /* synthetic */ ExtraInfoSummary(ArrayList r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101);
    }
}
