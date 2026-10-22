package com.bytedance.ee.bear.bitable.card.model.jsmodel.check;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/check/ConfirmFieldTypeChangeExtra;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "checkTypeConvert", "", "getCheckTypeConvert", "()Ljava/lang/Boolean;", "setCheckTypeConvert", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "aiPromptTx", "", "getAiPromptTx", "()Ljava/lang/String;", "setAiPromptTx", "(Ljava/lang/String;)V", "supportAIConfig", "getSupportAIConfig", "setSupportAIConfig", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfirmFieldTypeChangeExtra implements NonProguard {
    private String aiPromptTx;
    private Boolean checkTypeConvert;
    private Boolean supportAIConfig;

    public ConfirmFieldTypeChangeExtra() {
        Boolean r100 = Boolean.FALSE;
        this.checkTypeConvert = r100;
        this.aiPromptTx = "";
        this.supportAIConfig = r100;
    }

    public final String getAiPromptTx() {
        return this.aiPromptTx;
    }

    public final Boolean getCheckTypeConvert() {
        return this.checkTypeConvert;
    }

    public final Boolean getSupportAIConfig() {
        return this.supportAIConfig;
    }

    public final void setAiPromptTx(String r100) {
        this.aiPromptTx = r100;
    }

    public final void setCheckTypeConvert(Boolean r100) {
        this.checkTypeConvert = r100;
    }

    public final void setSupportAIConfig(Boolean r100) {
        this.supportAIConfig = r100;
    }
}
