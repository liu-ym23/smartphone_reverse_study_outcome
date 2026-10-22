package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0002\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001d¨\u0006 "}, d2 = {"Lcom/relax/relaxframework/ListEventLayoutCompleteDetail;", "", "layoutId", "", "scrollInfo", "Lcom/relax/relaxframework/ListEventScrollDetail;", "diffResult", "Lcom/relax/relaxframework/DiffResult;", "visibleCellsAfterUpdate", "Ljava/util/ArrayList;", "Lcom/relax/relaxframework/ListItemInfo;", "Lcom/bytedance/rts/foundation/RTSArray;", "visibleCellsBeforeUpdate", "(ILcom/relax/relaxframework/ListEventScrollDetail;Lcom/relax/relaxframework/DiffResult;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getDiffResult", "()Lcom/relax/relaxframework/DiffResult;", "setDiffResult", "(Lcom/relax/relaxframework/DiffResult;)V", "getLayoutId", "()I", "setLayoutId", "(I)V", "getScrollInfo", "()Lcom/relax/relaxframework/ListEventScrollDetail;", "setScrollInfo", "(Lcom/relax/relaxframework/ListEventScrollDetail;)V", "getVisibleCellsAfterUpdate", "()Ljava/util/ArrayList;", "setVisibleCellsAfterUpdate", "(Ljava/util/ArrayList;)V", "getVisibleCellsBeforeUpdate", "setVisibleCellsBeforeUpdate", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListEventLayoutCompleteDetail {
    private DiffResult diffResult;
    private int layoutId;
    private ListEventScrollDetail scrollInfo;
    private ArrayList<ListItemInfo> visibleCellsAfterUpdate;
    private ArrayList<ListItemInfo> visibleCellsBeforeUpdate;

    public final DiffResult getDiffResult() {
        return this.diffResult;
    }

    public final int getLayoutId() {
        return this.layoutId;
    }

    public final ListEventScrollDetail getScrollInfo() {
        return this.scrollInfo;
    }

    public final ArrayList<ListItemInfo> getVisibleCellsAfterUpdate() {
        return this.visibleCellsAfterUpdate;
    }

    public final ArrayList<ListItemInfo> getVisibleCellsBeforeUpdate() {
        return this.visibleCellsBeforeUpdate;
    }

    public final void setDiffResult(DiffResult r100) {
        this.diffResult = r100;
    }

    public final void setLayoutId(int r100) {
        this.layoutId = r100;
    }

    public final void setScrollInfo(ListEventScrollDetail r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scrollInfo = r100;
    }

    public final void setVisibleCellsAfterUpdate(ArrayList<ListItemInfo> r100) {
        this.visibleCellsAfterUpdate = r100;
    }

    public final void setVisibleCellsBeforeUpdate(ArrayList<ListItemInfo> r100) {
        this.visibleCellsBeforeUpdate = r100;
    }

    public ListEventLayoutCompleteDetail(int r100, ListEventScrollDetail r101, DiffResult r102, ArrayList<ListItemInfo> r103, ArrayList<ListItemInfo> r104) {
        Intrinsics.checkNotNullParameter(r101, "scrollInfo");
        this.layoutId = r100;
        this.scrollInfo = r101;
        this.diffResult = r102;
        this.visibleCellsAfterUpdate = r103;
        this.visibleCellsBeforeUpdate = r104;
    }

    public /* synthetic */ ListEventLayoutCompleteDetail(int r100, ListEventScrollDetail r101, DiffResult r110, ArrayList r111, ArrayList r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        DiffResult r102 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        ArrayList r103 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        ArrayList r104 = null;
    L14:
        this(r100, r101, r102, r103, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
