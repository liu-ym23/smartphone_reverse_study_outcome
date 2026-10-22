package com.bytedance.ee.bear;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.secret.SecretLevel;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/VisibleSecretResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "helpDocLink", "", "getHelpDocLink", "()Ljava/lang/String;", "setHelpDocLink", "(Ljava/lang/String;)V", "mustNeedDowngradeReason", "", "getMustNeedDowngradeReason", "()Z", "setMustNeedDowngradeReason", "(Z)V", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibleSecretResult extends Result<ArrayList<SecretLevel>> {
    private String helpDocLink;
    private boolean mustNeedDowngradeReason;

    public VisibleSecretResult() {
    }

    public final String getHelpDocLink() {
        return this.helpDocLink;
    }

    public final boolean getMustNeedDowngradeReason() {
        return this.mustNeedDowngradeReason;
    }

    public final void setHelpDocLink(String r100) {
        this.helpDocLink = r100;
    }

    public final void setMustNeedDowngradeReason(boolean r100) {
        this.mustNeedDowngradeReason = r100;
    }
}
