package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u000bR*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/relax/relaxframework/DiffResult;", "", "insertions", "Ljava/util/ArrayList;", "", "Lcom/bytedance/rts/foundation/RTSArray;", "move_from", "move_to", "removals", "update_from", "update_to", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getInsertions", "()Ljava/util/ArrayList;", "setInsertions", "(Ljava/util/ArrayList;)V", "getMove_from", "setMove_from", "getMove_to", "setMove_to", "getRemovals", "setRemovals", "getUpdate_from", "setUpdate_from", "getUpdate_to", "setUpdate_to", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DiffResult {
    private ArrayList<Integer> insertions;
    private ArrayList<Integer> move_from;
    private ArrayList<Integer> move_to;
    private ArrayList<Integer> removals;
    private ArrayList<Integer> update_from;
    private ArrayList<Integer> update_to;

    public final ArrayList<Integer> getInsertions() {
        return this.insertions;
    }

    public final ArrayList<Integer> getMove_from() {
        return this.move_from;
    }

    public final ArrayList<Integer> getMove_to() {
        return this.move_to;
    }

    public final ArrayList<Integer> getRemovals() {
        return this.removals;
    }

    public final ArrayList<Integer> getUpdate_from() {
        return this.update_from;
    }

    public final ArrayList<Integer> getUpdate_to() {
        return this.update_to;
    }

    public final void setInsertions(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.insertions = r100;
    }

    public final void setMove_from(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.move_from = r100;
    }

    public final void setMove_to(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.move_to = r100;
    }

    public final void setRemovals(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.removals = r100;
    }

    public final void setUpdate_from(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.update_from = r100;
    }

    public final void setUpdate_to(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.update_to = r100;
    }

    public DiffResult(ArrayList<Integer> r100, ArrayList<Integer> r101, ArrayList<Integer> r102, ArrayList<Integer> r103, ArrayList<Integer> r104, ArrayList<Integer> r105) {
        Intrinsics.checkNotNullParameter(r100, "insertions");
        Intrinsics.checkNotNullParameter(r101, "move_from");
        Intrinsics.checkNotNullParameter(r102, "move_to");
        Intrinsics.checkNotNullParameter(r103, "removals");
        Intrinsics.checkNotNullParameter(r104, "update_from");
        Intrinsics.checkNotNullParameter(r105, "update_to");
        this.insertions = r100;
        this.move_from = r101;
        this.move_to = r102;
        this.removals = r103;
        this.update_from = r104;
        this.update_to = r105;
    }
}
