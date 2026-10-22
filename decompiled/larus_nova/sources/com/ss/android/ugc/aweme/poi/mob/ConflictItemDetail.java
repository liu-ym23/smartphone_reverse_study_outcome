package com.ss.android.ugc.aweme.poi.mob;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/ConflictItemDetail;", "", "", "key", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "Lcom/ss/android/ugc/aweme/poi/mob/WriteActionRecord;", "writeHistories", "Ljava/util/List;", "getWriteHistories", "()Ljava/util/List;", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class ConflictItemDetail {

    @SerializedName("key")
    private final String key;

    @SerializedName("writeHistories")
    private final List<WriteActionRecord> writeHistories;

    public ConflictItemDetail() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConflictItemDetail) == true) goto L8;
        return false;
    L8:
        ConflictItemDetail r101 = (ConflictItemDetail) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.writeHistories, r101.writeHistories) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<WriteActionRecord> r104 = this.writeHistories;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConflictItemDetail(key=" + this.key + ", writeHistories=" + this.writeHistories + ')';
    }

    public final String a() {
        return this.key;
    }

    public ConflictItemDetail(String r100, List<WriteActionRecord> r101) {
        this.key = r100;
        this.writeHistories = r101;
    }
}
