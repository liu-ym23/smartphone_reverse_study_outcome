package com.bytedance.iesgurd.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/settings/d;", "", "", "accessKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "channels", "Ljava/util/List;", "b", "()Ljava/util/List;", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("access_key")
    private final String accessKey;

    @SerializedName("channels")
    private final List<String> channels;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.accessKey, r101.accessKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channels, r101.channels) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.accessKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.channels;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateConfigItem(accessKey=" + this.accessKey + ", channels=" + this.channels + ")";
    }

    public d() {
        List<String> r100 = CollectionsKt.emptyList();
        this.accessKey = "";
        this.channels = r100;
    }

    public final String a() {
        return this.accessKey;
    }

    public final List<String> b() {
        return this.channels;
    }
}
