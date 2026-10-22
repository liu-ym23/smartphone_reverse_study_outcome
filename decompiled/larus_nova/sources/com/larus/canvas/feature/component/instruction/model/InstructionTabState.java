package com.larus.canvas.feature.component.instruction.model;

import com.larus.canvas.service.bean.InstructionTab;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/InstructionTabState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "tabUiState", "Lcom/larus/canvas/feature/component/instruction/model/TabUIState;", "dataSource", "Lcom/larus/canvas/feature/component/instruction/model/TabDataSource;", "instructionTabList", "", "Lcom/larus/canvas/service/bean/InstructionTab;", "<init>", "(Lcom/larus/canvas/feature/component/instruction/model/TabUIState;Lcom/larus/canvas/feature/component/instruction/model/TabDataSource;Ljava/util/List;)V", "getTabUiState", "()Lcom/larus/canvas/feature/component/instruction/model/TabUIState;", "getDataSource", "()Lcom/larus/canvas/feature/component/instruction/model/TabDataSource;", "getInstructionTabList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionTabState implements w1a.b {
    private final TabDataSource dataSource;
    private final List<InstructionTab> instructionTabList;
    private final TabUIState tabUiState;

    public InstructionTabState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstructionTabState copy$default(InstructionTabState r100, TabUIState r101, TabDataSource r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tabUiState;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.dataSource;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.instructionTabList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final TabUIState component1() {
        return this.tabUiState;
    }

    public final TabDataSource component2() {
        return this.dataSource;
    }

    public final List<InstructionTab> component3() {
        return this.instructionTabList;
    }

    public final InstructionTabState copy(TabUIState r100, TabDataSource r101, List<InstructionTab> r102) {
        Intrinsics.checkNotNullParameter(r100, "tabUiState");
        Intrinsics.checkNotNullParameter(r102, "instructionTabList");
        return new InstructionTabState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InstructionTabState) == true) goto L8;
        return false;
    L8:
        InstructionTabState r101 = (InstructionTabState) r100;
        if (this.tabUiState == r101.tabUiState) goto L12;
        return false;
    L12:
        if (this.dataSource == r101.dataSource) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instructionTabList, r101.instructionTabList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.tabUiState.hashCode() * 31;
        TabDataSource r101 = this.dataSource;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.instructionTabList.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "InstructionTabState(tabUiState=" + this.tabUiState + ", dataSource=" + this.dataSource + ", instructionTabList=" + this.instructionTabList + ')';
    }

    public final TabDataSource getDataSource() {
        return this.dataSource;
    }

    public final List<InstructionTab> getInstructionTabList() {
        return this.instructionTabList;
    }

    public final TabUIState getTabUiState() {
        return this.tabUiState;
    }

    public InstructionTabState(TabUIState r100, TabDataSource r101, List<InstructionTab> r102) {
        Intrinsics.checkNotNullParameter(r100, "tabUiState");
        Intrinsics.checkNotNullParameter(r102, "instructionTabList");
        this.tabUiState = r100;
        this.dataSource = r101;
        this.instructionTabList = r102;
    }

    public /* synthetic */ InstructionTabState(TabUIState r100, TabDataSource r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = TabUIState.STATE_LOADING;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        this(r100, r101, r102);
    }
}
