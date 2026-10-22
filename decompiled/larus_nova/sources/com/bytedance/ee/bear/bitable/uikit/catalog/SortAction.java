package com.bytedance.ee.bear.bitable.uikit.catalog;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/SortAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "id", "", "action", "fromIndex", "", "toIndex", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getFromIndex", "()I", "getToIndex", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SortAction extends Action {
    private final int fromIndex;
    private final int toIndex;

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String toString() {
        return "SortAction(action=" + getAction() + ", from=" + this.fromIndex + ", to=" + this.toIndex + ") " + super.toString();
    }

    public final int getFromIndex() {
        return this.fromIndex;
    }

    public final int getToIndex() {
        return this.toIndex;
    }

    public SortAction(String r100, String r101, int r102, int r103) {
        super(r100, r101);
        this.fromIndex = r102;
        this.toIndex = r103;
    }
}
