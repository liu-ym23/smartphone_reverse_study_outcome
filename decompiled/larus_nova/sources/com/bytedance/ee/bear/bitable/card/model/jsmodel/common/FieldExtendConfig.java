package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "extendType", "", "getExtendType", "()Ljava/lang/String;", "setExtendType", "(Ljava/lang/String;)V", "fromInfo", "getFromInfo", "setFromInfo", "editInfo", "getEditInfo", "setEditInfo", "editable", "", "getEditable", "()Ljava/lang/Boolean;", "setEditable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "extendState", "getExtendState", "setExtendState", "extendItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfigItem;", "Lkotlin/collections/ArrayList;", "getExtendItems", "()Ljava/util/ArrayList;", "setExtendItems", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldExtendConfig implements NonProguard {
    private String editInfo;
    private Boolean editable;
    private ArrayList<FieldExtendConfigItem> extendItems;
    private Boolean extendState;
    private String extendType;
    private String fromInfo;

    public FieldExtendConfig() {
    }

    public final String getEditInfo() {
        return this.editInfo;
    }

    public final Boolean getEditable() {
        return this.editable;
    }

    public final ArrayList<FieldExtendConfigItem> getExtendItems() {
        return this.extendItems;
    }

    public final Boolean getExtendState() {
        return this.extendState;
    }

    public final String getExtendType() {
        return this.extendType;
    }

    public final String getFromInfo() {
        return this.fromInfo;
    }

    public final void setEditInfo(String r100) {
        this.editInfo = r100;
    }

    public final void setEditable(Boolean r100) {
        this.editable = r100;
    }

    public final void setExtendItems(ArrayList<FieldExtendConfigItem> r100) {
        this.extendItems = r100;
    }

    public final void setExtendState(Boolean r100) {
        this.extendState = r100;
    }

    public final void setExtendType(String r100) {
        this.extendType = r100;
    }

    public final void setFromInfo(String r100) {
        this.fromInfo = r100;
    }
}
