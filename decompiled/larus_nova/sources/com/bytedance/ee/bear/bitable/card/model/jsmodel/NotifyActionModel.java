package com.bytedance.ee.bear.bitable.card.model.jsmodel;

import com.bytedance.ee.bear.bitable.card.model.enums.ECardsAction;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/NotifyActionModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "Lcom/bytedance/ee/bear/bitable/card/model/enums/ECardsAction;", "getAction", "()Lcom/bytedance/ee/bear/bitable/card/model/enums/ECardsAction;", "setAction", "(Lcom/bytedance/ee/bear/bitable/card/model/enums/ECardsAction;)V", "baseId", "", "getBaseId", "()Ljava/lang/String;", "setBaseId", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyActionModel implements NonProguard {
    private ECardsAction action;
    private String baseId;
    private String tableId;

    public NotifyActionModel() {
    }

    public String toString() {
        return "NotifyActionModel{action=" + this.action + '}';
    }

    public final ECardsAction getAction() {
        return this.action;
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final void setAction(ECardsAction r100) {
        this.action = r100;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }
}
