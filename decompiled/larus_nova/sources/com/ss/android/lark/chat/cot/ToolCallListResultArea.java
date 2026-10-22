package com.ss.android.lark.chat.cot;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/cot/ToolCallListResultArea;", "Lcom/ss/android/lark/chat/cot/ToolCallResultArea;", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/cot/ToolCallResultAreaListItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolCallListResultArea implements ToolCallResultArea {
    private final ArrayList<ToolCallResultAreaListItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolCallListResultArea copy$default(ToolCallListResultArea r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<ToolCallResultAreaListItem> component1() {
        return this.items;
    }

    public final ToolCallListResultArea copy(ArrayList<ToolCallResultAreaListItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        return new ToolCallListResultArea(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ToolCallListResultArea) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.items, ((ToolCallListResultArea) r100).items) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "ToolCallListResultArea(items=" + this.items + ')';
    }

    public final ArrayList<ToolCallResultAreaListItem> getItems() {
        return this.items;
    }

    public ToolCallListResultArea(ArrayList<ToolCallResultAreaListItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.items = r100;
    }
}
