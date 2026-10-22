package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/api/image/i;", "", "", "Lcom/bytedance/android/shopping/api/image/j;", "match", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "replaceDomain", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("match")
    private final List<j> match;

    @SerializedName("replace_domain")
    private final String replaceDomain;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L10;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.match, r4.match) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.replaceDomain, r4.replaceDomain) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<j> r0 = this.match;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.replaceDomain;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HostReplaceMatchConfig(match=" + this.match + ", replaceDomain=" + this.replaceDomain + ")";
    }

    public i() {
        this.match = null;
        this.replaceDomain = null;
    }

    public final List<j> a() {
        return this.match;
    }

    public final String b() {
        return this.replaceDomain;
    }
}
