package com.bytedance.ee.bear.bitable.card.model.jsmodel.check;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/check/ConfirmAIGenerateExtra;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "canGenerateAI", "", "getCanGenerateAI", "()Ljava/lang/Boolean;", "setCanGenerateAI", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "notGenerateAIReason", "", "getNotGenerateAIReason", "()Ljava/lang/String;", "setNotGenerateAIReason", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfirmAIGenerateExtra implements NonProguard {
    private Boolean canGenerateAI;
    private String notGenerateAIReason;

    public ConfirmAIGenerateExtra() {
        this.canGenerateAI = Boolean.FALSE;
    }

    public final Boolean getCanGenerateAI() {
        return this.canGenerateAI;
    }

    public final String getNotGenerateAIReason() {
        return this.notGenerateAIReason;
    }

    public final void setCanGenerateAI(Boolean r100) {
        this.canGenerateAI = r100;
    }

    public final void setNotGenerateAIReason(String r100) {
        this.notGenerateAIReason = r100;
    }
}
