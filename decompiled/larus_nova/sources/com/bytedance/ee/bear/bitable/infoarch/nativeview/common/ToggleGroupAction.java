package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ToggleGroupAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "id", "", "<init>", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToggleGroupAction extends Action {
    public ToggleGroupAction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        super(r100, "toggleGroup");
    }
}
