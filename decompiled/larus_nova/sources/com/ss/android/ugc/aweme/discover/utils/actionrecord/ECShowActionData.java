package com.ss.android.ugc.aweme.discover.utils.actionrecord;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/utils/actionrecord/ECShowActionData;", "", "", "searchId", "Ljava/lang/String;", "getSearchId", "()Ljava/lang/String;", "docId", "getDocId", "", "docType", "Ljava/lang/Integer;", "getDocType", "()Ljava/lang/Integer;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShowActionData {

    @SerializedName("doc_id")
    private final String docId;

    @SerializedName("doc_type")
    private final Integer docType;

    @SerializedName("search_id")
    private final String searchId;

    public final String toString() {
        return "ECShowActionData(searchId=" + this.searchId + ", docId=" + this.docId + ", docType=" + this.docType + ")";
    }

    public final int hashCode() {
        String r100 = this.searchId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.docId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public ECShowActionData() {
        this.searchId = null;
        this.docId = null;
        this.docType = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(ECShowActionData.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        ECShowActionData r102 = (ECShowActionData) r100;
        if ((!Intrinsics.areEqual(this.searchId, r102.searchId)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.docId, r102.docId)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.discover.utils.actionrecord.ECShowActionData");
    L8:
        r101 = null;
        goto L10
    }
}
