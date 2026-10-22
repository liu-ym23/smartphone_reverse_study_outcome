package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/ErrorPosition;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "<init>", "()V", "isError", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ErrorPosition extends GroupPosition {
    public static final ErrorPosition INSTANCE = null;

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition
    public boolean isError() {
        return true;
    }

    static {
        ErrorPosition r100 = new ErrorPosition();
        INSTANCE = r100;
        r100.setOffset(-2);
    }

    private ErrorPosition() {
    }
}
