package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableExInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "coverId", "", "<init>", "(Ljava/lang/String;)V", "cardCoverId", "getCardCoverId", "()Ljava/lang/String;", "setCardCoverId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableExInfo implements NonProguard {
    private String cardCoverId;

    public final String getCardCoverId() {
        return this.cardCoverId;
    }

    public TableExInfo(String r100) {
        this.cardCoverId = r100;
    }

    public final void setCardCoverId(String r100) {
        this.cardCoverId = r100;
    }
}
