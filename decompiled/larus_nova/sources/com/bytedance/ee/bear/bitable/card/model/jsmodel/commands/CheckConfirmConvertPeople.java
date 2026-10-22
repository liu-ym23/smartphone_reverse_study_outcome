package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmConvertPeople;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;", "shouldCreateNewPeopleField", "", "<init>", "(Z)V", "getShouldCreateNewPeopleField", "()Ljava/lang/Boolean;", "setShouldCreateNewPeopleField", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckConfirmConvertPeople implements CheckConfirmValue {
    private Boolean shouldCreateNewPeopleField;

    public final Boolean getShouldCreateNewPeopleField() {
        return this.shouldCreateNewPeopleField;
    }

    public CheckConfirmConvertPeople(boolean r100) {
        this.shouldCreateNewPeopleField = Boolean.valueOf(r100);
    }

    public final void setShouldCreateNewPeopleField(Boolean r100) {
        this.shouldCreateNewPeopleField = r100;
    }
}
