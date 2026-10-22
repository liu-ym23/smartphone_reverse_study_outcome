package com.larus.audio.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/audio/bean/ConversationCellIconConfig;", "Ljava/io/Serializable;", "cellIconList", "", "Lcom/larus/audio/bean/ConversationCellIcon;", "<init>", "(Ljava/util/List;)V", "getCellIconList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationCellIconConfig implements Serializable {

    @SerializedName("cell_bar_icon_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<ConversationCellIcon> cellIconList;

    /* JADX WARN: Multi-variable type inference failed */
    public ConversationCellIconConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationCellIconConfig copy$default(ConversationCellIconConfig r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.cellIconList;
    L6:
        return r100.copy(r101);
    }

    public final List<ConversationCellIcon> component1() {
        return this.cellIconList;
    }

    public final ConversationCellIconConfig copy(List<ConversationCellIcon> r100) {
        return new ConversationCellIconConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationCellIconConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.cellIconList, ((ConversationCellIconConfig) r100).cellIconList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ConversationCellIcon> r100 = this.cellIconList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ConversationCellIconConfig(cellIconList=" + this.cellIconList + ')';
    }

    public final List<ConversationCellIcon> getCellIconList() {
        return this.cellIconList;
    }

    public ConversationCellIconConfig(List<ConversationCellIcon> r100) {
        this.cellIconList = r100;
    }

    public /* synthetic */ ConversationCellIconConfig(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
