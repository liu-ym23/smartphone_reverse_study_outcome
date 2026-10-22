package com.ss.android.ugc.aweme.shortvideo.beauty;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautifyUsedInfo;", "", "", "Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautifyUesTabInfo;", "info", "Ljava/util/List;", "getInfo", "()Ljava/util/List;", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class BeautifyUsedInfo {

    @SerializedName("beautify_used_info")
    private final List<BeautifyUesTabInfo> info;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BeautifyUsedInfo) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.info, ((BeautifyUsedInfo) r100).info) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<BeautifyUesTabInfo> r100 = this.info;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "BeautifyUsedInfo(info=" + this.info + ")";
    }

    public BeautifyUsedInfo() {
        CopyOnWriteArrayList r100 = new CopyOnWriteArrayList();
        Intrinsics.checkNotNullParameter(r100, "info");
        this.info = r100;
    }
}
