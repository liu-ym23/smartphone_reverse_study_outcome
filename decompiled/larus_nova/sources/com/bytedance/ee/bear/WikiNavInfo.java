package com.bytedance.ee.bear;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/WikiNavInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "isWiki", "", WikiFolderPushPlugin.WIKI_TOKEN, "", "<init>", "(ZLjava/lang/String;)V", "()Z", "setWiki", "(Z)V", "getWikiToken", "()Ljava/lang/String;", "setWikiToken", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "contentmanager-space-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiNavInfo extends Result<Serializable> {
    private boolean isWiki;
    private String wikiToken;

    /* JADX WARN: Multi-variable type inference failed */
    public WikiNavInfo() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WikiNavInfo copy$default(WikiNavInfo r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isWiki;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.wikiToken;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isWiki;
    }

    public final String component2() {
        return this.wikiToken;
    }

    public final WikiNavInfo copy(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        return new WikiNavInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WikiNavInfo) == true) goto L8;
        return false;
    L8:
        WikiNavInfo r101 = (WikiNavInfo) r100;
        if (this.isWiki == r101.isWiki) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wikiToken, r101.wikiToken) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isWiki == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.wikiToken.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "WikiNavInfo(isWiki=" + this.isWiki + ", wikiToken=" + this.wikiToken + ')';
    }

    public final String getWikiToken() {
        return this.wikiToken;
    }

    public final boolean isWiki() {
        return this.isWiki;
    }

    public final void setWiki(boolean r100) {
        this.isWiki = r100;
    }

    public final void setWikiToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.wikiToken = r100;
    }

    public WikiNavInfo(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        this.isWiki = r100;
        this.wikiToken = r101;
    }

    public /* synthetic */ WikiNavInfo(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
