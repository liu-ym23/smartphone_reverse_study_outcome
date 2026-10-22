package com.bytedance.ee.bear.bitable.msgcenter.view;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/OldMentionModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "openOldMention", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getOpenOldMention", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setOpenOldMention", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "lastLegacyMessageTimestamp", "", "getLastLegacyMessageTimestamp", "()Ljava/lang/Long;", "setLastLegacyMessageTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OldMentionModel implements NonProguard {
    private Long lastLegacyMessageTimestamp;
    private ActionPayload openOldMention;

    public OldMentionModel() {
    }

    public final Long getLastLegacyMessageTimestamp() {
        return this.lastLegacyMessageTimestamp;
    }

    public final ActionPayload getOpenOldMention() {
        return this.openOldMention;
    }

    public final void setLastLegacyMessageTimestamp(Long r100) {
        this.lastLegacyMessageTimestamp = r100;
    }

    public final void setOpenOldMention(ActionPayload r100) {
        this.openOldMention = r100;
    }
}
