package com.bytedance.ee.bear.bitable.dao.resourcedata;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;", "Lcom/bytedance/ee/util/io/NonProguard;", "dataJSON", "", "token", "pageID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDataJSON", "()Ljava/lang/String;", "getToken", "getPageID", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAppData implements NonProguard {
    private final String dataJSON;
    private final String pageID;
    private final String token;

    public static /* synthetic */ BitableAppData copy$default(BitableAppData r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.dataJSON;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.token;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pageID;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.dataJSON;
    }

    public final String component2() {
        return this.token;
    }

    public final String component3() {
        return this.pageID;
    }

    public final BitableAppData copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "dataJSON");
        Intrinsics.checkNotNullParameter(r101, "token");
        return new BitableAppData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableAppData) == true) goto L8;
        return false;
    L8:
        BitableAppData r101 = (BitableAppData) r100;
        if (Intrinsics.areEqual(this.dataJSON, r101.dataJSON) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pageID, r101.pageID) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.dataJSON.hashCode() * 31) + this.token.hashCode()) * 31;
        String r101 = this.pageID;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "BitableAppData(dataJSON=" + this.dataJSON + ", token=" + this.token + ", pageID=" + this.pageID + ')';
    }

    public final String getDataJSON() {
        return this.dataJSON;
    }

    public final String getPageID() {
        return this.pageID;
    }

    public final String getToken() {
        return this.token;
    }

    public BitableAppData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "dataJSON");
        Intrinsics.checkNotNullParameter(r101, "token");
        this.dataJSON = r100;
        this.token = r101;
        this.pageID = r102;
    }
}
