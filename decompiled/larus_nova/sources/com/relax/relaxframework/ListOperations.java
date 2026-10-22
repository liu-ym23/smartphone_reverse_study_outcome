package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005¢\u0006\u0002\u0010\nR*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/relax/relaxframework/ListOperations;", "", "insertAction", "Ljava/util/ArrayList;", "Lcom/relax/relaxframework/ListInsertAction;", "Lcom/bytedance/rts/foundation/RTSArray;", "removeAction", "", "updateAction", "Lcom/relax/relaxframework/ListUpdateAction;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getInsertAction", "()Ljava/util/ArrayList;", "setInsertAction", "(Ljava/util/ArrayList;)V", "getRemoveAction", "setRemoveAction", "getUpdateAction", "setUpdateAction", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListOperations {
    private ArrayList<ListInsertAction> insertAction;
    private ArrayList<Integer> removeAction;
    private ArrayList<ListUpdateAction> updateAction;

    public final ArrayList<ListInsertAction> getInsertAction() {
        return this.insertAction;
    }

    public final ArrayList<Integer> getRemoveAction() {
        return this.removeAction;
    }

    public final ArrayList<ListUpdateAction> getUpdateAction() {
        return this.updateAction;
    }

    public final void setInsertAction(ArrayList<ListInsertAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.insertAction = r100;
    }

    public final void setRemoveAction(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.removeAction = r100;
    }

    public final void setUpdateAction(ArrayList<ListUpdateAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.updateAction = r100;
    }

    public ListOperations(ArrayList<ListInsertAction> r100, ArrayList<Integer> r101, ArrayList<ListUpdateAction> r102) {
        Intrinsics.checkNotNullParameter(r100, "insertAction");
        Intrinsics.checkNotNullParameter(r101, "removeAction");
        Intrinsics.checkNotNullParameter(r102, "updateAction");
        this.insertAction = r100;
        this.removeAction = r101;
        this.updateAction = r102;
    }
}
