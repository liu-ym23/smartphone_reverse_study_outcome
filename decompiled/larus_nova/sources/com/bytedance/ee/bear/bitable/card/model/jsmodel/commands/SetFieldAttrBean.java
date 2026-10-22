package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B[\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/SetFieldAttrBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "viewId", "fieldId", "data", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;", "checkConfirmValue", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;", "extendFieldOptions", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;", "generateAIContent", "", "isPartialLoadSchemaVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "cmd", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "getCmd", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "setCmd", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;)V", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "getViewId", "setViewId", "getFieldId", "setFieldId", "getData", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;", "setData", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;)V", "getCheckConfirmValue", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;", "setCheckConfirmValue", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;)V", "getExtendFieldOptions", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;", "setExtendFieldOptions", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;)V", "getGenerateAIContent", "()Ljava/lang/Boolean;", "setGenerateAIContent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetFieldAttrBean implements NonProguard {
    private CheckConfirmValue checkConfirmValue;
    private FieldCommandType cmd;
    private FieldCommandDataBean data;
    private ExtendFieldOptions extendFieldOptions;
    private String fieldId;
    private Boolean generateAIContent;
    private String tableId;
    private String viewId;

    public final CheckConfirmValue getCheckConfirmValue() {
        return this.checkConfirmValue;
    }

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

    public final String getFieldId() {
        return this.fieldId;
    }

    public final Boolean getGenerateAIContent() {
        return this.generateAIContent;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setCheckConfirmValue(CheckConfirmValue r100) {
        this.checkConfirmValue = r100;
    }

    public final void setCmd(FieldCommandType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cmd = r100;
    }

    public final void setData(FieldCommandDataBean r100) {
        this.data = r100;
    }

    public final void setExtendFieldOptions(ExtendFieldOptions r100) {
        this.extendFieldOptions = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setGenerateAIContent(Boolean r100) {
        this.generateAIContent = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public SetFieldAttrBean(String r100, String r101, String r102, FieldCommandDataBean r103, CheckConfirmValue r104, ExtendFieldOptions r105, Boolean r106, Boolean r107) {
        this.cmd = FieldCommandType.SET_FIELD_ATTR;
        this.tableId = r100;
        this.viewId = r101;
        this.fieldId = r102;
        this.data = r103;
        this.checkConfirmValue = r104;
        this.extendFieldOptions = r105;
        this.generateAIContent = r106;
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L6;
        this.cmd = FieldCommandType.CONVERT_FIELD;
        return;
    }

    public /* synthetic */ SetFieldAttrBean(String r110, String r111, String r112, FieldCommandDataBean r113, CheckConfirmValue r114, ExtendFieldOptions r115, Boolean r116, Boolean r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 128) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L6:
        this(r110, r111, r112, r113, r114, r115, r116, r100);
        return;
    L5:
        r100 = r117;
        goto L6
    }
}
