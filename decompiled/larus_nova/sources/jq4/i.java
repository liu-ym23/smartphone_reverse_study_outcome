package jq4;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.bitable.card.view.record.CellListUtils$fixCellListViewCompatible$layoutManager$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f500041a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f500041a, ((i) r100).f500041a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f500041a.hashCode();
    }

    public final String toString() {
        return "CellListViewCompatiblePayload(layoutManager=" + this.f500041a + ')';
    }

    public i(CellListUtils$fixCellListViewCompatible$layoutManager$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        this.f500041a = r100;
    }
}
