package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/api/image/a0;", "", "", "connectScene", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/shopping/api/image/z;", "supportImageDomainUrl", "Ljava/util/List;", "b", "()Ljava/util/List;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("connect_scene")
    private final Integer connectScene;

    @SerializedName("support_image_domain_url")
    private final List<z> supportImageDomainUrl;

    public a0() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a0) == false) goto L10;
        a0 r4 = (a0) r3;
        if (Intrinsics.areEqual(this.connectScene, r4.connectScene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supportImageDomainUrl, r4.supportImageDomainUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.connectScene;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<z> r4 = this.supportImageDomainUrl;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageDomainPreConnectModel(connectScene=" + this.connectScene + ", supportImageDomainUrl=" + this.supportImageDomainUrl + ")";
    }

    public final Integer a() {
        return this.connectScene;
    }

    public final List<z> b() {
        return this.supportImageDomainUrl;
    }

    public a0(Object r1) {
        this.connectScene = null;
        this.supportImageDomainUrl = null;
    }
}
