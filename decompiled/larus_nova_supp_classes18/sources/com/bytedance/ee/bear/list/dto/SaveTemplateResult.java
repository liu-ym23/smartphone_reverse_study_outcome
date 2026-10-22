package com.bytedance.ee.bear.list.dto;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/list/dto/SaveTemplateResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", ResourceData.KEY_URL, "", ResourceData.KEY_TOKEN, "tokenList", "parentToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getToken", "setToken", "getTokenList", "setTokenList", "getParentToken", "setParentToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveTemplateResult extends Result<Serializable> {
    private String parentToken;
    private String token;
    private String tokenList;
    private String url;

    public SaveTemplateResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SaveTemplateResult copy$default(SaveTemplateResult r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.url;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.token;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.tokenList;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.parentToken;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.token;
    }

    public final String component3() {
        return this.tokenList;
    }

    public final String component4() {
        return this.parentToken;
    }

    public final SaveTemplateResult copy(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "tokenList");
        Intrinsics.checkNotNullParameter(r5, "parentToken");
        return new SaveTemplateResult(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SaveTemplateResult) == true) goto L8;
        return false;
    L8:
        SaveTemplateResult r6 = (SaveTemplateResult) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tokenList, r6.tokenList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentToken, r6.parentToken) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.token.hashCode()) * 31) + this.tokenList.hashCode()) * 31) + this.parentToken.hashCode();
    }

    public String toString() {
        return "SaveTemplateResult(url=" + this.url + ", token=" + this.token + ", tokenList=" + this.tokenList + ", parentToken=" + this.parentToken + ')';
    }

    public final String getParentToken() {
        return this.parentToken;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getTokenList() {
        return this.tokenList;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setParentToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.parentToken = r2;
    }

    public final void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    public final void setTokenList(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tokenList = r2;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    public SaveTemplateResult(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "tokenList");
        Intrinsics.checkNotNullParameter(r5, "parentToken");
        this.url = r2;
        this.token = r3;
        this.tokenList = r4;
        this.parentToken = r5;
    }

    public /* synthetic */ SaveTemplateResult(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
