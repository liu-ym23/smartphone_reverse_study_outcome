package com.larus.extension.aggregate_search_ui.api.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.larus.list.arch.IFlowListCell;
import ei9.f;
import ei9.g;
import hi9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u0006\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u0006HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nHÆ\u0003JK\u0010\u0016\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u00062\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/kmp/KmpCellPack;", "", "cellType", "Ljava/lang/Class;", "Lcom/larus/list/arch/IFlowListCell;", "transformer", "Lcom/larus/list/arch/IFlowListCellStateTransformer;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "Lcom/larus/list/arch/IFlowListCellState;", "matcher", "Lcom/larus/list/arch/multi/IMultipleType;", "<init>", "(Ljava/lang/Class;Lcom/larus/list/arch/IFlowListCellStateTransformer;Lcom/larus/list/arch/multi/IMultipleType;)V", "getCellType", "()Ljava/lang/Class;", "getTransformer", "()Lcom/larus/list/arch/IFlowListCellStateTransformer;", "getMatcher", "()Lcom/larus/list/arch/multi/IMultipleType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCellPack {
    private final Class<? extends IFlowListCell<?>> cellType;
    private final a<? extends f> matcher;
    private final g<ISearchDataPayload, ? extends f> transformer;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmpCellPack copy$default(KmpCellPack r100, Class r101, g r102, a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.cellType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.transformer;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.matcher;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Class<? extends IFlowListCell<?>> component1() {
        return this.cellType;
    }

    public final g<ISearchDataPayload, ? extends f> component2() {
        return this.transformer;
    }

    public final a<? extends f> component3() {
        return this.matcher;
    }

    public final KmpCellPack copy(Class<? extends IFlowListCell<?>> r100, g<ISearchDataPayload, ? extends f> r101, a<? extends f> r102) {
        Intrinsics.checkNotNullParameter(r100, "cellType");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        return new KmpCellPack(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KmpCellPack) == true) goto L8;
        return false;
    L8:
        KmpCellPack r101 = (KmpCellPack) r100;
        if (Intrinsics.areEqual(this.cellType, r101.cellType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transformer, r101.transformer) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.matcher, r101.matcher) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.cellType.hashCode() * 31) + this.transformer.hashCode()) * 31;
        a<? extends f> r101 = this.matcher;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "KmpCellPack(cellType=" + this.cellType + ", transformer=" + this.transformer + ", matcher=" + this.matcher + ')';
    }

    public final Class<? extends IFlowListCell<?>> getCellType() {
        return this.cellType;
    }

    public final a<? extends f> getMatcher() {
        return this.matcher;
    }

    public final g<ISearchDataPayload, ? extends f> getTransformer() {
        return this.transformer;
    }

    public KmpCellPack(Class<? extends IFlowListCell<?>> r100, g<ISearchDataPayload, ? extends f> r101, a<? extends f> r102) {
        Intrinsics.checkNotNullParameter(r100, "cellType");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        this.cellType = r100;
        this.transformer = r101;
        this.matcher = r102;
    }

    public /* synthetic */ KmpCellPack(Class r100, g r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
