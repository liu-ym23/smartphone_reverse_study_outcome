package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001BO\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u000f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/AddOptionDataBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "fieldId", "viewId", "optionId", "optionName", "optionColor", "", "isChecked", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "cmd", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "getCmd", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "setCmd", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;)V", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "getFieldId", "setFieldId", "getViewId", "setViewId", "getOptionId", "setOptionId", "getOptionName", "setOptionName", "getOptionColor", "()Ljava/lang/Integer;", "setOptionColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "checked", "getChecked", "()Ljava/lang/Boolean;", "setChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddOptionDataBean implements NonProguard {
    private Boolean checked;
    private FieldCommandType cmd;
    private String fieldId;
    private Integer optionColor;
    private String optionId;
    private String optionName;
    private String tableId;
    private String viewId;

    public final Boolean getChecked() {
        return this.checked;
    }

    @JSONField(serialzeFeatures = {SerializerFeature.WriteEnumUsingToString})
    public final FieldCommandType getCmd() {
        return this.cmd;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final Integer getOptionColor() {
        return this.optionColor;
    }

    public final String getOptionId() {
        return this.optionId;
    }

    public final String getOptionName() {
        return this.optionName;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setChecked(Boolean r100) {
        this.checked = r100;
    }

    public final void setCmd(FieldCommandType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cmd = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setOptionColor(Integer r100) {
        this.optionColor = r100;
    }

    public final void setOptionId(String r100) {
        this.optionId = r100;
    }

    public final void setOptionName(String r100) {
        this.optionName = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public AddOptionDataBean(String r100, String r101, String r102, String r103, String r104, Integer r105, Boolean r106) {
        this.cmd = FieldCommandType.ADD_OPTION;
        this.tableId = r100;
        this.fieldId = r101;
        this.viewId = r102;
        this.optionId = r103;
        this.optionName = r104;
        this.optionColor = r105;
        this.checked = r106;
    }
}
