package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.util.io.NonProguard;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003BU\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0002\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandDataBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "name", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "extendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;", "generateAIContent", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fieldUIType", "getFieldUIType", "setFieldUIType", "getProperty", "()Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "setProperty", "(Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;)V", "getAllowedEditModes", "()Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "setAllowedEditModes", "(Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;)V", "getExtendInfo", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;", "setExtendInfo", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;)V", "getGenerateAIContent", "()Ljava/lang/Boolean;", "setGenerateAIContent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldCommandDataBean implements NonProguard {
    private AllowedEditModes allowedEditModes;
    private FieldExtendBean extendInfo;
    private String fieldUIType;
    private Boolean generateAIContent;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207105id;
    private String name;
    private FieldProperty property;
    private Integer type;

    public FieldCommandDataBean() {
        this.generateAIContent = Boolean.FALSE;
    }

    public final AllowedEditModes getAllowedEditModes() {
        return this.allowedEditModes;
    }

    public final FieldExtendBean getExtendInfo() {
        return this.extendInfo;
    }

    public final String getFieldUIType() {
        return this.fieldUIType;
    }

    public final Boolean getGenerateAIContent() {
        return this.generateAIContent;
    }

    public final String getId() {
        return this.f207105id;
    }

    public final String getName() {
        return this.name;
    }

    public final FieldProperty getProperty() {
        return this.property;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setAllowedEditModes(AllowedEditModes r100) {
        this.allowedEditModes = r100;
    }

    public final void setExtendInfo(FieldExtendBean r100) {
        this.extendInfo = r100;
    }

    public final void setFieldUIType(String r100) {
        this.fieldUIType = r100;
    }

    public final void setGenerateAIContent(Boolean r100) {
        this.generateAIContent = r100;
    }

    public final void setId(String r100) {
        this.f207105id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setProperty(FieldProperty r100) {
        this.property = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public FieldCommandDataBean(String r100, String r101, FieldCompositeType r102, FieldProperty r103, AllowedEditModes r104, FieldExtendBean r105, Boolean r106) {
        this.generateAIContent = Boolean.FALSE;
        this.f207105id = r100;
        this.name = r101;
        String r107 = null;
        if (r102 == null) goto L7;
        EFieldType r108 = r102.getType();
        if (r108 == null) goto L7;
        Integer r109 = Integer.valueOf(r108.getValue());
    L8:
        this.type = r109;
        if (r102 == null) goto L13;
        EFieldUIType r110 = r102.getUiType();
        if (r110 == null) goto L13;
        r107 = r110.getValue();
    L13:
        this.fieldUIType = r107;
        this.property = r103;
        this.allowedEditModes = r104;
        this.extendInfo = r105;
        this.generateAIContent = r106;
        return;
    L7:
        r109 = null;
        goto L8
    }

    public /* synthetic */ FieldCommandDataBean(String r110, String r111, FieldCompositeType r112, FieldProperty r113, AllowedEditModes r114, FieldExtendBean r115, Boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 16) == 0) goto L5;
        AllowedEditModes r100 = null;
    L7:
        if ((r117 & 32) == 0) goto L9;
        FieldExtendBean r101 = null;
    L11:
        if ((r117 & 64) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
