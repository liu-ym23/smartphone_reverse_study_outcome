package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.bytedance.ee.util.io.NonProguard;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "originFieldId", "", "getOriginFieldId", "()Ljava/lang/String;", "setOriginFieldId", "(Ljava/lang/String;)V", "originFieldUIType", "getOriginFieldUIType", "setOriginFieldUIType", "originFieldCustomType", "getOriginFieldCustomType", "setOriginFieldCustomType", "extendFieldType", "getExtendFieldType", "setExtendFieldType", CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, "getLang", "setLang", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldExtendBean implements NonProguard {
    private String extendFieldType;
    private String lang;
    private String originFieldCustomType;
    private String originFieldId;
    private String originFieldUIType;

    public FieldExtendBean() {
    }

    public final String getExtendFieldType() {
        return this.extendFieldType;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getOriginFieldCustomType() {
        return this.originFieldCustomType;
    }

    public final String getOriginFieldId() {
        return this.originFieldId;
    }

    public final String getOriginFieldUIType() {
        return this.originFieldUIType;
    }

    public final void setExtendFieldType(String r100) {
        this.extendFieldType = r100;
    }

    public final void setLang(String r100) {
        this.lang = r100;
    }

    public final void setOriginFieldCustomType(String r100) {
        this.originFieldCustomType = r100;
    }

    public final void setOriginFieldId(String r100) {
        this.originFieldId = r100;
    }

    public final void setOriginFieldUIType(String r100) {
        this.originFieldUIType = r100;
    }
}
