package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t8G¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/SetExTypeBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableExInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableExInfo;", "tableId", "", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableExInfo;Ljava/lang/String;)V", "cmd", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableCommonType;", "getCmd", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableCommonType;", "getTableExInfo", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableExInfo;", "setTableExInfo", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableExInfo;)V", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetExTypeBean implements NonProguard {
    private final TableCommonType cmd;
    private TableExInfo tableExInfo;
    private String tableId;

    @JSONField(serialzeFeatures = {SerializerFeature.WriteEnumUsingToString})
    public final TableCommonType getCmd() {
        return this.cmd;
    }

    public final TableExInfo getTableExInfo() {
        return this.tableExInfo;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final void setTableExInfo(TableExInfo r100) {
        this.tableExInfo = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public SetExTypeBean(TableExInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tableExInfo");
        this.cmd = TableCommonType.SET_EX_TYPE;
        this.tableExInfo = r100;
        this.tableId = r101;
    }
}
