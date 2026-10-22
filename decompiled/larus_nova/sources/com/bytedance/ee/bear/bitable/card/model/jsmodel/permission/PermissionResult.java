package com.bytedance.ee.bear.bitable.card.model.jsmodel.permission;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/PermissionResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "result", "", "getResult", "()[Z", "setResult", "([Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionResult implements NonProguard {
    private boolean[] result;

    public PermissionResult() {
    }

    public final boolean[] getResult() {
        return this.result;
    }

    public final void setResult(boolean[] r100) {
        this.result = r100;
    }
}
