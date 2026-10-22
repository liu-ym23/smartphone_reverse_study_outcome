package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/ThumbnailInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "url", "", "encryptKey", "encryptType", "", "encryptNonce", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getEncryptKey", "getEncryptType", "()I", "getEncryptNonce", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailInfo implements NonProguard {
    private final String encryptKey;
    private final String encryptNonce;
    private final int encryptType;
    private final String url;

    public static /* synthetic */ ThumbnailInfo copy$default(ThumbnailInfo r100, String r101, String r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.encryptKey;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.encryptType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.encryptNonce;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.encryptKey;
    }

    public final int component3() {
        return this.encryptType;
    }

    public final String component4() {
        return this.encryptNonce;
    }

    public final ThumbnailInfo copy(String r100, String r101, int r102, String r103) {
        return new ThumbnailInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThumbnailInfo) == true) goto L8;
        return false;
    L8:
        ThumbnailInfo r101 = (ThumbnailInfo) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.encryptKey, r101.encryptKey) == true) goto L15;
        return false;
    L15:
        if (this.encryptType == r101.encryptType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.encryptNonce, r101.encryptNonce) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.encryptKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.encryptType) * 31;
        String r107 = this.encryptNonce;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ThumbnailInfo(url=" + this.url + ", encryptKey=" + this.encryptKey + ", encryptType=" + this.encryptType + ", encryptNonce=" + this.encryptNonce + ')';
    }

    public final String getEncryptKey() {
        return this.encryptKey;
    }

    public final String getEncryptNonce() {
        return this.encryptNonce;
    }

    public final int getEncryptType() {
        return this.encryptType;
    }

    public final String getUrl() {
        return this.url;
    }

    public ThumbnailInfo(String r100, String r101, int r102, String r103) {
        this.url = r100;
        this.encryptKey = r101;
        this.encryptType = r102;
        this.encryptNonce = r103;
    }
}
