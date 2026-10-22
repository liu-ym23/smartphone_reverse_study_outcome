package com.bytedance.ee.bear.document.security;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/security/TnsBlockData;", "Lcom/bytedance/ee/util/io/NonProguard;", "code", "", "url", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TnsBlockData implements NonProguard {
    private int code;
    private String url;

    public static /* synthetic */ TnsBlockData copy$default(TnsBlockData r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.url;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.url;
    }

    public final TnsBlockData copy(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        return new TnsBlockData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TnsBlockData) == true) goto L8;
        return false;
    L8:
        TnsBlockData r101 = (TnsBlockData) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.code * 31) + this.url.hashCode();
    }

    public String toString() {
        return "TnsBlockData(code=" + this.code + ", url=" + this.url + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public TnsBlockData(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        this.code = r100;
        this.url = r101;
    }
}
