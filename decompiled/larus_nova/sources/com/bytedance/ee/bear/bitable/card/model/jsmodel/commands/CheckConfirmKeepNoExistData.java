package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmKeepNoExistData;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;", "shouldSyncToLinkedTable", "", "<init>", "(Z)V", "getShouldSyncToLinkedTable", "()Ljava/lang/Boolean;", "setShouldSyncToLinkedTable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckConfirmKeepNoExistData implements CheckConfirmValue {
    private Boolean shouldSyncToLinkedTable;

    public final Boolean getShouldSyncToLinkedTable() {
        return this.shouldSyncToLinkedTable;
    }

    public CheckConfirmKeepNoExistData(boolean r100) {
        this.shouldSyncToLinkedTable = Boolean.valueOf(r100);
    }

    public final void setShouldSyncToLinkedTable(Boolean r100) {
        this.shouldSyncToLinkedTable = r100;
    }
}
