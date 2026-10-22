package com.bytedance.ee.bear.bitable.uikit;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/PullAction;", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PullAction extends ActionPayload {
    public PullAction(ArrayList<RenderItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        setList(r100);
        setAction("PullCardData");
    }
}
