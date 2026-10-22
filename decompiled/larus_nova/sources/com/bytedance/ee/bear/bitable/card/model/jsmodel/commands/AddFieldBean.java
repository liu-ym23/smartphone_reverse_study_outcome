package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001BC\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u00108G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/AddFieldBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "viewId", "index", "", "data", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;", "extendFieldOptions", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;", "generateAIContent", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;Ljava/lang/Boolean;)V", "cmd", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "getCmd", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "getViewId", "setViewId", "getIndex", "()I", "setIndex", "(I)V", "getData", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;", "setData", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;)V", "getExtendFieldOptions", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;", "setExtendFieldOptions", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;)V", "getGenerateAIContent", "()Ljava/lang/Boolean;", "setGenerateAIContent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddFieldBean implements NonProguard {
    private final FieldCommandType cmd;
    private FieldCommandDataBean data;
    private ExtendFieldOptions extendFieldOptions;
    private Boolean generateAIContent;
    private int index;
    private String tableId;
    private String viewId;

    @JSONField(serialzeFeatures = {SerializerFeature.WriteEnumUsingToString})
    public final FieldCommandType getCmd() {
        return this.cmd;
    }

    public final FieldCommandDataBean getData() {
        return this.data;
    }

    public final ExtendFieldOptions getExtendFieldOptions() {
        return this.extendFieldOptions;
    }

    public final Boolean getGenerateAIContent() {
        return this.generateAIContent;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setData(FieldCommandDataBean r100) {
        this.data = r100;
    }

    public final void setExtendFieldOptions(ExtendFieldOptions r100) {
        this.extendFieldOptions = r100;
    }

    public final void setGenerateAIContent(Boolean r100) {
        this.generateAIContent = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public AddFieldBean(String r100, String r101, int r102, FieldCommandDataBean r103, ExtendFieldOptions r104, Boolean r105) {
        this.cmd = FieldCommandType.ADD_FIELD;
        this.tableId = r100;
        this.viewId = r101;
        this.index = r102;
        this.data = r103;
        this.extendFieldOptions = r104;
        this.generateAIContent = r105;
    }
}
