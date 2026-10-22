package com.bytedance.ee.bear.list.dto;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/list/dto/SaveTemplateResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "url", "", "token", "tokenList", "parentToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getToken", "setToken", "getTokenList", "setTokenList", "getParentToken", "setParentToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveTemplateResult extends Result<Serializable> {
    private String parentToken;
    private String token;
    private String tokenList;
    private String url;

    public SaveTemplateResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SaveTemplateResult copy$default(SaveTemplateResult r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.token;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.tokenList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.parentToken;
    L15:
        return r100.copy(r101, r102, r103, r104);
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

    public final SaveTemplateResult copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "tokenList");
        Intrinsics.checkNotNullParameter(r103, "parentToken");
        return new SaveTemplateResult(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SaveTemplateResult) == true) goto L8;
        return false;
    L8:
        SaveTemplateResult r101 = (SaveTemplateResult) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tokenList, r101.tokenList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentToken, r101.parentToken) == true) goto L20;
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

    public final void setParentToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.parentToken = r100;
    }

    public final void setToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.token = r100;
    }

    public final void setTokenList(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tokenList = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public SaveTemplateResult(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "tokenList");
        Intrinsics.checkNotNullParameter(r103, "parentToken");
        this.url = r100;
        this.token = r101;
        this.tokenList = r102;
        this.parentToken = r103;
    }

    public /* synthetic */ SaveTemplateResult(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
