package com.bytedance.ee.bear.bitable.card.model.jsmodel;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/FieldGroupNode;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "type", "getType", "setType", "description", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$DescriptionBean;", "getDescription", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$DescriptionBean;", "setDescription", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$DescriptionBean;)V", "children", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/FieldSummary;", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldGroupNode implements NonProguard {
    private List<FieldSummary> children;
    private TableMetaModel.DescriptionBean description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207097id;
    private String name;
    private String type;

    public FieldGroupNode() {
    }

    public final List<FieldSummary> getChildren() {
        return this.children;
    }

    public final TableMetaModel.DescriptionBean getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f207097id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final void setChildren(List<FieldSummary> r100) {
        this.children = r100;
    }

    public final void setDescription(TableMetaModel.DescriptionBean r100) {
        this.description = r100;
    }

    public final void setId(String r100) {
        this.f207097id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
