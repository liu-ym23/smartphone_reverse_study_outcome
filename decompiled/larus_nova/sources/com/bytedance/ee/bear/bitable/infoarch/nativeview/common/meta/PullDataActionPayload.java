package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/PullDataActionPayload;", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "visiblePullAction", "", "pullActions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/PullDataAction;", "Lkotlin/collections/ArrayList;", "<init>", "(ZLjava/util/ArrayList;)V", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PullDataActionPayload extends ActionPayload {
    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String toString() {
        return "PullDataActionPayload(): action:" + getAction() + ", pullDataActions:" + getPullDataActions() + '}';
    }

    public PullDataActionPayload(boolean r100, ArrayList<PullDataAction> r101) {
        if (r100 == false) goto L5;
        String r102 = "VisiblePullAction";
    L6:
        setAction(r102);
        setPullDataActions(r101);
        return;
    L5:
        r102 = "PullData";
        goto L6
    }
}
