package com.bytedance.ee.bear.document.folder.creation;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/folder/creation/CreationPanelModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "parentWikiToken", "", "getParentWikiToken", "()Ljava/lang/String;", "setParentWikiToken", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPanelModel implements NonProguard {
    private String parentWikiToken;
    private String spaceId;

    public CreationPanelModel() {
    }

    public final String getParentWikiToken() {
        return this.parentWikiToken;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final void setParentWikiToken(String r1) {
        this.parentWikiToken = r1;
    }

    public final void setSpaceId(String r1) {
        this.spaceId = r1;
    }
}
